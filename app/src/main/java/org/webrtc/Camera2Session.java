package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.os.Handler;
import android.os.Looper;
import android.util.Range;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
class Camera2Session
  implements CameraSession
{
  private static final String TAG = "Camera2Session";
  private static final Histogram camera2ResolutionHistogram = Histogram.createEnumeration("WebRTC.Android.Camera2.Resolution", CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());
  private static final Histogram camera2StartTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera2.StartTimeMs", 1, 10000, 50);
  private static final Histogram camera2StopTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera2.StopTimeMs", 1, 10000, 50);
  private final Context applicationContext;
  private final CameraSession.CreateSessionCallback callback;
  private CameraCharacteristics cameraCharacteristics;
  private CameraDevice cameraDevice;
  private final String cameraId;
  private final CameraManager cameraManager;
  private int cameraOrientation;
  private final Handler cameraThreadHandler;
  private CameraEnumerationAndroid.CaptureFormat captureFormat;
  private CameraCaptureSession captureSession;
  private final long constructionTimeNs;
  private final CameraSession.Events events;
  private boolean firstFrameReported;
  private int fpsUnitFactor;
  private final int framerate;
  private final int height;
  private boolean isCameraFrontFacing;
  private SessionState state = SessionState.RUNNING;
  private Surface surface;
  private final SurfaceTextureHelper surfaceTextureHelper;
  private final int width;
  
  private Camera2Session(CameraSession.CreateSessionCallback paramCreateSessionCallback, CameraSession.Events paramEvents, Context paramContext, CameraManager paramCameraManager, SurfaceTextureHelper paramSurfaceTextureHelper, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Create new camera2 session on camera ");
    localStringBuilder.append(paramString);
    Logging.d("Camera2Session", localStringBuilder.toString());
    this.constructionTimeNs = System.nanoTime();
    this.cameraThreadHandler = new Handler();
    this.callback = paramCreateSessionCallback;
    this.events = paramEvents;
    this.applicationContext = paramContext;
    this.cameraManager = paramCameraManager;
    this.surfaceTextureHelper = paramSurfaceTextureHelper;
    this.cameraId = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.framerate = paramInt3;
    start();
  }
  
  private void checkIsOnCameraThread()
  {
    if (Thread.currentThread() == this.cameraThreadHandler.getLooper().getThread()) {
      return;
    }
    throw new IllegalStateException("Wrong thread");
  }
  
  public static void create(CameraSession.CreateSessionCallback paramCreateSessionCallback, CameraSession.Events paramEvents, Context paramContext, CameraManager paramCameraManager, SurfaceTextureHelper paramSurfaceTextureHelper, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    new Camera2Session(paramCreateSessionCallback, paramEvents, paramContext, paramCameraManager, paramSurfaceTextureHelper, paramString, paramInt1, paramInt2, paramInt3);
  }
  
  private void findCaptureFormat()
  {
    checkIsOnCameraThread();
    Object localObject1 = (Range[])this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
    int i = Camera2Enumerator.getFpsUnitFactor((Range[])localObject1);
    this.fpsUnitFactor = i;
    Object localObject2 = Camera2Enumerator.convertFramerates((Range[])localObject1, i);
    localObject1 = Camera2Enumerator.getSupportedSizes(this.cameraCharacteristics);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Available preview sizes: ");
    localStringBuilder.append(localObject1);
    Logging.d("Camera2Session", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Available fps ranges: ");
    localStringBuilder.append(localObject2);
    Logging.d("Camera2Session", localStringBuilder.toString());
    if ((!((List)localObject2).isEmpty()) && (!((List)localObject1).isEmpty()))
    {
      localObject2 = CameraEnumerationAndroid.getClosestSupportedFramerateRange((List)localObject2, this.framerate);
      localObject1 = CameraEnumerationAndroid.getClosestSupportedSize((List)localObject1, this.width, this.height);
      CameraEnumerationAndroid.reportCameraResolution(camera2ResolutionHistogram, (Size)localObject1);
      this.captureFormat = new CameraEnumerationAndroid.CaptureFormat(((Size)localObject1).width, ((Size)localObject1).height, (CameraEnumerationAndroid.CaptureFormat.FramerateRange)localObject2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Using capture format: ");
      ((StringBuilder)localObject1).append(this.captureFormat);
      Logging.d("Camera2Session", ((StringBuilder)localObject1).toString());
      return;
    }
    reportError("No supported capture formats.");
  }
  
  private int getFrameOrientation()
  {
    int j = e.b(this.applicationContext);
    int i = j;
    if (!this.isCameraFrontFacing) {
      i = 360 - j;
    }
    return (this.cameraOrientation + i) % 360;
  }
  
  private void openCamera()
  {
    checkIsOnCameraThread();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Opening camera ");
    localStringBuilder1.append(this.cameraId);
    Logging.d("Camera2Session", localStringBuilder1.toString());
    this.events.onCameraOpening();
    try
    {
      this.cameraManager.openCamera(this.cameraId, new CameraStateCallback(null), this.cameraThreadHandler);
      return;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Failed to open camera: ");
      localStringBuilder2.append(localCameraAccessException);
      reportError(localStringBuilder2.toString());
    }
  }
  
  private void reportError(String paramString)
  {
    checkIsOnCameraThread();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Error: ");
    localStringBuilder.append(paramString);
    Logging.e("Camera2Session", localStringBuilder.toString());
    int i;
    if ((this.captureSession == null) && (this.state != SessionState.STOPPED)) {
      i = 1;
    } else {
      i = 0;
    }
    this.state = SessionState.STOPPED;
    stopInternal();
    if (i != 0)
    {
      this.callback.onFailure(CameraSession.FailureType.ERROR, paramString);
      return;
    }
    this.events.onCameraError(this, paramString);
  }
  
  private void start()
  {
    checkIsOnCameraThread();
    Logging.d("Camera2Session", "start");
    try
    {
      CameraCharacteristics localCameraCharacteristics = this.cameraManager.getCameraCharacteristics(this.cameraId);
      this.cameraCharacteristics = localCameraCharacteristics;
      this.cameraOrientation = ((Integer)localCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
      boolean bool;
      if (((Integer)this.cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.isCameraFrontFacing = bool;
      findCaptureFormat();
      openCamera();
      return;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCameraCharacteristics(): ");
      localStringBuilder.append(localCameraAccessException.getMessage());
      reportError(localStringBuilder.toString());
    }
  }
  
  private void stopInternal()
  {
    Logging.d("Camera2Session", "Stop internal");
    checkIsOnCameraThread();
    this.surfaceTextureHelper.stopListening();
    Object localObject = this.captureSession;
    if (localObject != null)
    {
      ((CameraCaptureSession)localObject).close();
      this.captureSession = null;
    }
    localObject = this.surface;
    if (localObject != null)
    {
      ((Surface)localObject).release();
      this.surface = null;
    }
    localObject = this.cameraDevice;
    if (localObject != null)
    {
      ((CameraDevice)localObject).close();
      this.cameraDevice = null;
    }
    Logging.d("Camera2Session", "Stop done");
  }
  
  public void stop()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Stop camera2 session on camera ");
    ((StringBuilder)localObject).append(this.cameraId);
    Logging.d("Camera2Session", ((StringBuilder)localObject).toString());
    checkIsOnCameraThread();
    localObject = this.state;
    SessionState localSessionState = SessionState.STOPPED;
    if (localObject != localSessionState)
    {
      long l = System.nanoTime();
      this.state = localSessionState;
      stopInternal();
      int i = (int)TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l);
      camera2StopTimeMsHistogram.addSample(i);
    }
  }
  
  private static class CameraCaptureCallback
    extends CameraCaptureSession.CaptureCallback
  {
    public void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure)
    {
      paramCameraCaptureSession = new StringBuilder();
      paramCameraCaptureSession.append("Capture failed: ");
      paramCameraCaptureSession.append(paramCaptureFailure);
      Logging.d("Camera2Session", paramCameraCaptureSession.toString());
    }
  }
  
  private class CameraStateCallback
    extends CameraDevice.StateCallback
  {
    private CameraStateCallback() {}
    
    private String getErrorDescription(int paramInt)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("Unknown camera error: ");
                localStringBuilder.append(paramInt);
                return localStringBuilder.toString();
              }
              return "Camera service has encountered a fatal error.";
            }
            return "Camera device has encountered a fatal error.";
          }
          return "Camera device could not be opened due to a device policy.";
        }
        return "Camera device could not be opened because there are too many other open camera devices.";
      }
      return "Camera device is in use already.";
    }
    
    public void onClosed(CameraDevice paramCameraDevice)
    {
      Camera2Session.this.checkIsOnCameraThread();
      Logging.d("Camera2Session", "Camera device closed.");
      Camera2Session.this.events.onCameraClosed(Camera2Session.this);
    }
    
    public void onDisconnected(CameraDevice paramCameraDevice)
    {
      Camera2Session.this.checkIsOnCameraThread();
      int i;
      if ((Camera2Session.this.captureSession == null) && (Camera2Session.this.state != Camera2Session.SessionState.STOPPED)) {
        i = 1;
      } else {
        i = 0;
      }
      Camera2Session.access$202(Camera2Session.this, Camera2Session.SessionState.STOPPED);
      Camera2Session.this.stopInternal();
      if (i != 0)
      {
        Camera2Session.this.callback.onFailure(CameraSession.FailureType.DISCONNECTED, "Camera disconnected / evicted.");
        return;
      }
      Camera2Session.this.events.onCameraDisconnected(Camera2Session.this);
    }
    
    public void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      Camera2Session.this.checkIsOnCameraThread();
      Camera2Session.this.reportError(getErrorDescription(paramInt));
    }
    
    public void onOpened(CameraDevice paramCameraDevice)
    {
      Camera2Session.this.checkIsOnCameraThread();
      Logging.d("Camera2Session", "Camera opened.");
      Camera2Session.access$702(Camera2Session.this, paramCameraDevice);
      Camera2Session.this.surfaceTextureHelper.setTextureSize(Camera2Session.this.captureFormat.width, Camera2Session.this.captureFormat.height);
      Camera2Session.access$1002(Camera2Session.this, new Surface(Camera2Session.this.surfaceTextureHelper.getSurfaceTexture()));
      try
      {
        paramCameraDevice.createCaptureSession(Arrays.asList(new Surface[] { Camera2Session.this.surface }), new Camera2Session.CaptureSessionCallback(Camera2Session.this, null), Camera2Session.this.cameraThreadHandler);
        return;
      }
      catch (CameraAccessException paramCameraDevice)
      {
        Camera2Session localCamera2Session = Camera2Session.this;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to create capture session. ");
        localStringBuilder.append(paramCameraDevice);
        localCamera2Session.reportError(localStringBuilder.toString());
      }
    }
  }
  
  private class CaptureSessionCallback
    extends CameraCaptureSession.StateCallback
  {
    private CaptureSessionCallback() {}
    
    private void chooseFocusMode(CaptureRequest.Builder paramBuilder)
    {
      int[] arrayOfInt = (int[])Camera2Session.this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
      int j = arrayOfInt.length;
      int i = 0;
      if (i < j) {
        if (arrayOfInt[i] == 3) {
          paramBuilder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(3));
        }
      }
      for (paramBuilder = "Using continuous video auto-focus.";; paramBuilder = "Auto-focus is not available.")
      {
        Logging.d("Camera2Session", paramBuilder);
        return;
        i += 1;
        break;
      }
    }
    
    private void chooseStabilizationMode(CaptureRequest.Builder paramBuilder)
    {
      int[] arrayOfInt = (int[])Camera2Session.this.cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
      int j = 0;
      Integer localInteger1 = Integer.valueOf(0);
      Integer localInteger2 = Integer.valueOf(1);
      int k;
      int i;
      if (arrayOfInt != null)
      {
        k = arrayOfInt.length;
        i = 0;
        if (i < k) {
          if (arrayOfInt[i] == 1)
          {
            paramBuilder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, localInteger2);
            paramBuilder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, localInteger1);
            paramBuilder = "Using optical stabilization.";
          }
        }
      }
      for (;;)
      {
        Logging.d("Camera2Session", paramBuilder);
        return;
        i += 1;
        break;
        arrayOfInt = (int[])Camera2Session.this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        k = arrayOfInt.length;
        i = j;
        for (;;)
        {
          if (i >= k) {
            break label163;
          }
          if (arrayOfInt[i] == 1)
          {
            paramBuilder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, localInteger2);
            paramBuilder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, localInteger1);
            paramBuilder = "Using video stabilization.";
            break;
          }
          i += 1;
        }
        label163:
        paramBuilder = "Stabilization not available.";
      }
    }
    
    public void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
    {
      Camera2Session.this.checkIsOnCameraThread();
      paramCameraCaptureSession.close();
      Camera2Session.this.reportError("Failed to configure capture session.");
    }
    
    public void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      Camera2Session.this.checkIsOnCameraThread();
      Logging.d("Camera2Session", "Camera capture session configured.");
      Camera2Session.access$102(Camera2Session.this, paramCameraCaptureSession);
      try
      {
        localObject = Camera2Session.this.cameraDevice.createCaptureRequest(3);
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range(Integer.valueOf(Camera2Session.this.captureFormat.framerate.min / Camera2Session.this.fpsUnitFactor), Integer.valueOf(Camera2Session.this.captureFormat.framerate.max / Camera2Session.this.fpsUnitFactor)));
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
        chooseStabilizationMode((CaptureRequest.Builder)localObject);
        chooseFocusMode((CaptureRequest.Builder)localObject);
        ((CaptureRequest.Builder)localObject).addTarget(Camera2Session.this.surface);
        paramCameraCaptureSession.setRepeatingRequest(((CaptureRequest.Builder)localObject).build(), new Camera2Session.CameraCaptureCallback(null), Camera2Session.this.cameraThreadHandler);
        Camera2Session.this.surfaceTextureHelper.startListening(new d(this));
        Logging.d("Camera2Session", "Camera device successfully started.");
        Camera2Session.this.callback.onDone(Camera2Session.this);
        return;
      }
      catch (CameraAccessException paramCameraCaptureSession)
      {
        Object localObject = Camera2Session.this;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to start capture request. ");
        localStringBuilder.append(paramCameraCaptureSession);
        ((Camera2Session)localObject).reportError(localStringBuilder.toString());
      }
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
 * Qualified Name:     org.webrtc.Camera2Session
 * JD-Core Version:    0.7.0.1
 */