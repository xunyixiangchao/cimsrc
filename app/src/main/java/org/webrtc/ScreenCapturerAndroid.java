package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjection.Callback;
import android.media.projection.MediaProjectionManager;
import android.view.Surface;

@TargetApi(21)
public class ScreenCapturerAndroid
  implements VideoCapturer, VideoSink
{
  private static final int DISPLAY_FLAGS = 3;
  private static final int VIRTUAL_DISPLAY_DPI = 400;
  private CapturerObserver capturerObserver;
  private int height;
  private boolean isDisposed;
  private MediaProjection mediaProjection;
  private final MediaProjection.Callback mediaProjectionCallback;
  private MediaProjectionManager mediaProjectionManager;
  private final Intent mediaProjectionPermissionResultData;
  private long numCapturedFrames;
  private SurfaceTextureHelper surfaceTextureHelper;
  private VirtualDisplay virtualDisplay;
  private int width;
  
  public ScreenCapturerAndroid(Intent paramIntent, MediaProjection.Callback paramCallback)
  {
    this.mediaProjectionPermissionResultData = paramIntent;
    this.mediaProjectionCallback = paramCallback;
  }
  
  private void checkNotDisposed()
  {
    if (!this.isDisposed) {
      return;
    }
    throw new RuntimeException("capturer is disposed.");
  }
  
  private void createVirtualDisplay()
  {
    this.surfaceTextureHelper.setTextureSize(this.width, this.height);
    this.virtualDisplay = this.mediaProjection.createVirtualDisplay("WebRTC_ScreenCapture", this.width, this.height, 400, 3, new Surface(this.surfaceTextureHelper.getSurfaceTexture()), null, null);
  }
  
  public void changeCaptureFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      checkNotDisposed();
      this.width = paramInt1;
      this.height = paramInt2;
      VirtualDisplay localVirtualDisplay = this.virtualDisplay;
      if (localVirtualDisplay == null) {
        return;
      }
      ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new Runnable()
      {
        public void run()
        {
          ScreenCapturerAndroid.this.virtualDisplay.release();
          ScreenCapturerAndroid.this.createVirtualDisplay();
        }
      });
      return;
    }
    finally {}
  }
  
  public void dispose()
  {
    try
    {
      this.isDisposed = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public MediaProjection getMediaProjection()
  {
    return this.mediaProjection;
  }
  
  public long getNumCapturedFrames()
  {
    return this.numCapturedFrames;
  }
  
  public void initialize(SurfaceTextureHelper paramSurfaceTextureHelper, Context paramContext, CapturerObserver paramCapturerObserver)
  {
    try
    {
      checkNotDisposed();
      if (paramCapturerObserver != null)
      {
        this.capturerObserver = paramCapturerObserver;
        if (paramSurfaceTextureHelper != null)
        {
          this.surfaceTextureHelper = paramSurfaceTextureHelper;
          this.mediaProjectionManager = ((MediaProjectionManager)paramContext.getSystemService("media_projection"));
          return;
        }
        throw new RuntimeException("surfaceTextureHelper not set.");
      }
      throw new RuntimeException("capturerObserver not set.");
    }
    finally {}
  }
  
  public boolean isScreencast()
  {
    return true;
  }
  
  public void onFrame(VideoFrame paramVideoFrame)
  {
    this.numCapturedFrames += 1L;
    this.capturerObserver.onFrameCaptured(paramVideoFrame);
  }
  
  public void startCapture(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      checkNotDisposed();
      this.width = paramInt1;
      this.height = paramInt2;
      MediaProjection localMediaProjection = this.mediaProjectionManager.getMediaProjection(-1, this.mediaProjectionPermissionResultData);
      this.mediaProjection = localMediaProjection;
      localMediaProjection.registerCallback(this.mediaProjectionCallback, this.surfaceTextureHelper.getHandler());
      createVirtualDisplay();
      this.capturerObserver.onCapturerStarted(true);
      this.surfaceTextureHelper.startListening(this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void stopCapture()
  {
    try
    {
      checkNotDisposed();
      ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new Runnable()
      {
        public void run()
        {
          ScreenCapturerAndroid.this.surfaceTextureHelper.stopListening();
          ScreenCapturerAndroid.this.capturerObserver.onCapturerStopped();
          if (ScreenCapturerAndroid.this.virtualDisplay != null)
          {
            ScreenCapturerAndroid.this.virtualDisplay.release();
            ScreenCapturerAndroid.access$202(ScreenCapturerAndroid.this, null);
          }
          if (ScreenCapturerAndroid.this.mediaProjection != null)
          {
            ScreenCapturerAndroid.this.mediaProjection.unregisterCallback(ScreenCapturerAndroid.this.mediaProjectionCallback);
            ScreenCapturerAndroid.this.mediaProjection.stop();
            ScreenCapturerAndroid.access$302(ScreenCapturerAndroid.this, null);
          }
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.ScreenCapturerAndroid
 * JD-Core Version:    0.7.0.1
 */