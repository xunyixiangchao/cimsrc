package org.webrtc;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Camera1Session
  implements CameraSession
{
  private static final int NUMBER_OF_CAPTURE_BUFFERS = 3;
  private static final String TAG = "Camera1Session";
  private static final Histogram camera1ResolutionHistogram = Histogram.createEnumeration("WebRTC.Android.Camera1.Resolution", CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());
  private static final Histogram camera1StartTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera1.StartTimeMs", 1, 10000, 50);
  private static final Histogram camera1StopTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera1.StopTimeMs", 1, 10000, 50);
  private final Context applicationContext;
  private final Camera camera;
  private final int cameraId;
  private final Handler cameraThreadHandler;
  private final CameraEnumerationAndroid.CaptureFormat captureFormat;
  private final boolean captureToTexture;
  private final long constructionTimeNs;
  private final CameraSession.Events events;
  private boolean firstFrameReported;
  private final Camera.CameraInfo info;
  private SessionState state;
  private final SurfaceTextureHelper surfaceTextureHelper;
  
  private Camera1Session(CameraSession.Events paramEvents, boolean paramBoolean, Context paramContext, SurfaceTextureHelper paramSurfaceTextureHelper, int paramInt, Camera paramCamera, Camera.CameraInfo paramCameraInfo, CameraEnumerationAndroid.CaptureFormat paramCaptureFormat, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Create new camera1 session on camera ");
    localStringBuilder.append(paramInt);
    Logging.d("Camera1Session", localStringBuilder.toString());
    this.cameraThreadHandler = new Handler();
    this.events = paramEvents;
    this.captureToTexture = paramBoolean;
    this.applicationContext = paramContext;
    this.surfaceTextureHelper = paramSurfaceTextureHelper;
    this.cameraId = paramInt;
    this.camera = paramCamera;
    this.info = paramCameraInfo;
    this.captureFormat = paramCaptureFormat;
    this.constructionTimeNs = paramLong;
    paramSurfaceTextureHelper.setTextureSize(paramCaptureFormat.width, paramCaptureFormat.height);
    startCapturing();
  }
  
  private void checkIsOnCameraThread()
  {
    if (Thread.currentThread() == this.cameraThreadHandler.getLooper().getThread()) {
      return;
    }
    throw new IllegalStateException("Wrong thread");
  }
  
  public static void create(CameraSession.CreateSessionCallback paramCreateSessionCallback, CameraSession.Events paramEvents, boolean paramBoolean, Context paramContext, SurfaceTextureHelper paramSurfaceTextureHelper, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l = System.nanoTime();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Open camera ");
    ((StringBuilder)localObject).append(paramInt1);
    Logging.d("Camera1Session", ((StringBuilder)localObject).toString());
    paramEvents.onCameraOpening();
    try
    {
      localObject = Camera.open(paramInt1);
      if (localObject == null)
      {
        paramEvents = CameraSession.FailureType.ERROR;
        paramContext = new StringBuilder();
        paramContext.append("android.hardware.Camera.open returned null for camera id = ");
        paramContext.append(paramInt1);
        paramCreateSessionCallback.onFailure(paramEvents, paramContext.toString());
        return;
      }
      try
      {
        ((Camera)localObject).setPreviewTexture(paramSurfaceTextureHelper.getSurfaceTexture());
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(paramInt1, localCameraInfo);
        try
        {
          Camera.Parameters localParameters = ((Camera)localObject).getParameters();
          CameraEnumerationAndroid.CaptureFormat localCaptureFormat = findClosestCaptureFormat(localParameters, paramInt2, paramInt3, paramInt4);
          updateCameraParameters((Camera)localObject, localParameters, localCaptureFormat, findClosestPictureSize(localParameters, paramInt2, paramInt3), paramBoolean);
          if (!paramBoolean)
          {
            paramInt3 = localCaptureFormat.frameSize();
            paramInt2 = 0;
            while (paramInt2 < 3)
            {
              ((Camera)localObject).addCallbackBuffer(ByteBuffer.allocateDirect(paramInt3).array());
              paramInt2 += 1;
            }
          }
          ((Camera)localObject).setDisplayOrientation(0);
          paramCreateSessionCallback.onDone(new Camera1Session(paramEvents, paramBoolean, paramContext, paramSurfaceTextureHelper, paramInt1, (Camera)localObject, localCameraInfo, localCaptureFormat, l));
          return;
        }
        catch (RuntimeException paramEvents)
        {
          ((Camera)localObject).release();
          paramCreateSessionCallback.onFailure(CameraSession.FailureType.ERROR, paramEvents.getMessage());
          return;
        }
        ((Camera)localObject).release();
      }
      catch (RuntimeException paramEvents) {}catch (IOException paramEvents) {}
      paramCreateSessionCallback.onFailure(CameraSession.FailureType.ERROR, paramEvents.getMessage());
      return;
    }
    catch (RuntimeException paramEvents)
    {
      paramCreateSessionCallback.onFailure(CameraSession.FailureType.ERROR, paramEvents.getMessage());
    }
  }
  
  private static CameraEnumerationAndroid.CaptureFormat findClosestCaptureFormat(Camera.Parameters paramParameters, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = Camera1Enumerator.convertFramerates(paramParameters.getSupportedPreviewFpsRange());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Available fps ranges: ");
    localStringBuilder.append(localObject);
    Logging.d("Camera1Session", localStringBuilder.toString());
    localObject = CameraEnumerationAndroid.getClosestSupportedFramerateRange((List)localObject, paramInt3);
    paramParameters = CameraEnumerationAndroid.getClosestSupportedSize(Camera1Enumerator.convertSizes(paramParameters.getSupportedPreviewSizes()), paramInt1, paramInt2);
    CameraEnumerationAndroid.reportCameraResolution(camera1ResolutionHistogram, paramParameters);
    return new CameraEnumerationAndroid.CaptureFormat(paramParameters.width, paramParameters.height, (CameraEnumerationAndroid.CaptureFormat.FramerateRange)localObject);
  }
  
  private static Size findClosestPictureSize(Camera.Parameters paramParameters, int paramInt1, int paramInt2)
  {
    return CameraEnumerationAndroid.getClosestSupportedSize(Camera1Enumerator.convertSizes(paramParameters.getSupportedPictureSizes()), paramInt1, paramInt2);
  }
  
  private int getFrameOrientation()
  {
    int j = e.b(this.applicationContext);
    Camera.CameraInfo localCameraInfo = this.info;
    int i = j;
    if (localCameraInfo.facing == 0) {
      i = 360 - j;
    }
    return (localCameraInfo.orientation + i) % 360;
  }
  
  private void listenForBytebufferFrames()
  {
    this.camera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback()
    {
      public void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        Camera1Session.this.checkIsOnCameraThread();
        if (paramAnonymousCamera != Camera1Session.this.camera)
        {
          Logging.e("Camera1Session", "Callback from a different camera. This should never happen.");
          return;
        }
        if (Camera1Session.this.state != Camera1Session.SessionState.RUNNING)
        {
          Logging.d("Camera1Session", "Bytebuffer frame captured but camera is no longer running.");
          return;
        }
        long l = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
        if (!Camera1Session.this.firstFrameReported)
        {
          int i = (int)TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - Camera1Session.this.constructionTimeNs);
          Camera1Session.camera1StartTimeMsHistogram.addSample(i);
          Camera1Session.access$502(Camera1Session.this, true);
        }
        paramAnonymousArrayOfByte = new VideoFrame(new NV21Buffer(paramAnonymousArrayOfByte, Camera1Session.this.captureFormat.width, Camera1Session.this.captureFormat.height, new c(this, paramAnonymousArrayOfByte)), Camera1Session.this.getFrameOrientation(), l);
        Camera1Session.this.events.onFrameCaptured(Camera1Session.this, paramAnonymousArrayOfByte);
        paramAnonymousArrayOfByte.release();
      }
    });
  }
  
  private void listenForTextureFrames()
  {
    this.surfaceTextureHelper.startListening(new a(this));
  }
  
  private void startCapturing()
  {
    Logging.d("Camera1Session", "Start capturing");
    checkIsOnCameraThread();
    this.state = SessionState.RUNNING;
    this.camera.setErrorCallback(new Camera.ErrorCallback()
    {
      public void onError(int paramAnonymousInt, Camera paramAnonymousCamera)
      {
        if (paramAnonymousInt == 100)
        {
          paramAnonymousCamera = "Camera server died!";
        }
        else
        {
          paramAnonymousCamera = new StringBuilder();
          paramAnonymousCamera.append("Camera error: ");
          paramAnonymousCamera.append(paramAnonymousInt);
          paramAnonymousCamera = paramAnonymousCamera.toString();
        }
        Logging.e("Camera1Session", paramAnonymousCamera);
        Camera1Session.this.stopInternal();
        if (paramAnonymousInt == 2)
        {
          Camera1Session.this.events.onCameraDisconnected(Camera1Session.this);
          return;
        }
        Camera1Session.this.events.onCameraError(Camera1Session.this, paramAnonymousCamera);
      }
    });
    if (this.captureToTexture) {
      listenForTextureFrames();
    } else {
      listenForBytebufferFrames();
    }
    try
    {
      this.camera.startPreview();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      stopInternal();
      this.events.onCameraError(this, localRuntimeException.getMessage());
    }
  }
  
  private void stopInternal()
  {
    Logging.d("Camera1Session", "Stop internal");
    checkIsOnCameraThread();
    Object localObject = this.state;
    SessionState localSessionState = SessionState.STOPPED;
    if (localObject == localSessionState) {}
    for (localObject = "Camera is already stopped";; localObject = "Stop done")
    {
      Logging.d("Camera1Session", (String)localObject);
      return;
      this.state = localSessionState;
      this.surfaceTextureHelper.stopListening();
      this.camera.stopPreview();
      this.camera.release();
      this.events.onCameraClosed(this);
    }
  }
  
  private static void updateCameraParameters(Camera paramCamera, Camera.Parameters paramParameters, CameraEnumerationAndroid.CaptureFormat paramCaptureFormat, Size paramSize, boolean paramBoolean)
  {
    List localList = paramParameters.getSupportedFocusModes();
    CameraEnumerationAndroid.CaptureFormat.FramerateRange localFramerateRange = paramCaptureFormat.framerate;
    paramParameters.setPreviewFpsRange(localFramerateRange.min, localFramerateRange.max);
    paramParameters.setPreviewSize(paramCaptureFormat.width, paramCaptureFormat.height);
    paramParameters.setPictureSize(paramSize.width, paramSize.height);
    if (!paramBoolean) {
      paramParameters.setPreviewFormat(17);
    }
    if (paramParameters.isVideoStabilizationSupported()) {
      paramParameters.setVideoStabilization(true);
    }
    if (localList.contains("continuous-video")) {
      paramParameters.setFocusMode("continuous-video");
    }
    paramCamera.setParameters(paramParameters);
  }
  
  public void stop()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Stop camera1 session on camera ");
    localStringBuilder.append(this.cameraId);
    Logging.d("Camera1Session", localStringBuilder.toString());
    checkIsOnCameraThread();
    if (this.state != SessionState.STOPPED)
    {
      long l = System.nanoTime();
      stopInternal();
      int i = (int)TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l);
      camera1StopTimeMsHistogram.addSample(i);
    }
  }
  
  private static enum SessionState
  {
    static
    {
      SessionState localSessionState1 = new SessionState("RUNNING", 0);
      RUNNING = localSessionState1;
      SessionState localSessionState2 = new SessionState("STOPPED", 1);
      STOPPED = localSessionState2;
      $VALUES = new SessionState[] { localSessionState1, localSessionState2 };
    }
    
    private SessionState() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.Camera1Session
 * JD-Core Version:    0.7.0.1
 */