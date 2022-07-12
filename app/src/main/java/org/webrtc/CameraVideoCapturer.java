package org.webrtc;

import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;

public abstract interface CameraVideoCapturer
  extends VideoCapturer
{
  @Deprecated
  public abstract void addMediaRecorderToCamera(MediaRecorder paramMediaRecorder, MediaRecorderHandler paramMediaRecorderHandler);
  
  @Deprecated
  public abstract void removeMediaRecorderFromCamera(MediaRecorderHandler paramMediaRecorderHandler);
  
  public abstract void switchCamera(CameraSwitchHandler paramCameraSwitchHandler);
  
  public abstract void switchCamera(CameraSwitchHandler paramCameraSwitchHandler, String paramString);
  
  public static abstract interface CameraEventsHandler
  {
    public abstract void onCameraClosed();
    
    public abstract void onCameraDisconnected();
    
    public abstract void onCameraError(String paramString);
    
    public abstract void onCameraFreezed(String paramString);
    
    public abstract void onCameraOpening(String paramString);
    
    public abstract void onFirstFrameAvailable();
  }
  
  public static class CameraStatistics
  {
    private static final int CAMERA_FREEZE_REPORT_TIMOUT_MS = 4000;
    private static final int CAMERA_OBSERVER_PERIOD_MS = 2000;
    private static final String TAG = "CameraStatistics";
    private final Runnable cameraObserver;
    private final CameraVideoCapturer.CameraEventsHandler eventsHandler;
    private int frameCount;
    private int freezePeriodCount;
    private final SurfaceTextureHelper surfaceTextureHelper;
    
    public CameraStatistics(SurfaceTextureHelper paramSurfaceTextureHelper, CameraVideoCapturer.CameraEventsHandler paramCameraEventsHandler)
    {
      Runnable local1 = new Runnable()
      {
        public void run()
        {
          int i = Math.round(CameraVideoCapturer.CameraStatistics.this.frameCount * 1000.0F / 2000.0F);
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Camera fps: ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(".");
          Logging.d("CameraStatistics", ((StringBuilder)localObject).toString());
          if (CameraVideoCapturer.CameraStatistics.this.frameCount == 0)
          {
            CameraVideoCapturer.CameraStatistics.access$104(CameraVideoCapturer.CameraStatistics.this);
            if ((CameraVideoCapturer.CameraStatistics.this.freezePeriodCount * 2000 >= 4000) && (CameraVideoCapturer.CameraStatistics.this.eventsHandler != null))
            {
              Logging.e("CameraStatistics", "Camera freezed.");
              String str;
              if (CameraVideoCapturer.CameraStatistics.this.surfaceTextureHelper.isTextureInUse())
              {
                localObject = CameraVideoCapturer.CameraStatistics.this.eventsHandler;
                str = "Camera failure. Client must return video buffers.";
              }
              else
              {
                localObject = CameraVideoCapturer.CameraStatistics.this.eventsHandler;
                str = "Camera failure.";
              }
              ((CameraVideoCapturer.CameraEventsHandler)localObject).onCameraFreezed(str);
            }
          }
          else
          {
            CameraVideoCapturer.CameraStatistics.access$102(CameraVideoCapturer.CameraStatistics.this, 0);
          }
          CameraVideoCapturer.CameraStatistics.access$002(CameraVideoCapturer.CameraStatistics.this, 0);
          CameraVideoCapturer.CameraStatistics.this.surfaceTextureHelper.getHandler().postDelayed(this, 2000L);
        }
      };
      this.cameraObserver = local1;
      if (paramSurfaceTextureHelper != null)
      {
        this.surfaceTextureHelper = paramSurfaceTextureHelper;
        this.eventsHandler = paramCameraEventsHandler;
        this.frameCount = 0;
        this.freezePeriodCount = 0;
        paramSurfaceTextureHelper.getHandler().postDelayed(local1, 2000L);
        return;
      }
      throw new IllegalArgumentException("SurfaceTextureHelper is null");
    }
    
    private void checkThread()
    {
      if (Thread.currentThread() == this.surfaceTextureHelper.getHandler().getLooper().getThread()) {
        return;
      }
      throw new IllegalStateException("Wrong thread");
    }
    
    public void addFrame()
    {
      checkThread();
      this.frameCount += 1;
    }
    
    public void release()
    {
      this.surfaceTextureHelper.getHandler().removeCallbacks(this.cameraObserver);
    }
  }
  
  public static abstract interface CameraSwitchHandler
  {
    public abstract void onCameraSwitchDone(boolean paramBoolean);
    
    public abstract void onCameraSwitchError(String paramString);
  }
  
  @Deprecated
  public static abstract interface MediaRecorderHandler
  {
    public abstract void onMediaRecorderError(String paramString);
    
    public abstract void onMediaRecorderSuccess();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.CameraVideoCapturer
 * JD-Core Version:    0.7.0.1
 */