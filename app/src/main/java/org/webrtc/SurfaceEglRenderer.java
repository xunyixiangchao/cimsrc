package org.webrtc;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import java.util.concurrent.CountDownLatch;

public class SurfaceEglRenderer
  extends EglRenderer
  implements SurfaceHolder.Callback
{
  private static final String TAG = "SurfaceEglRenderer";
  private int frameRotation;
  private boolean isFirstFrameRendered;
  private boolean isRenderingPaused;
  private final Object layoutLock = new Object();
  private RendererCommon.RendererEvents rendererEvents;
  private int rotatedFrameHeight;
  private int rotatedFrameWidth;
  
  public SurfaceEglRenderer(String paramString)
  {
    super(paramString);
  }
  
  private void logD(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramString);
    Logging.d("SurfaceEglRenderer", localStringBuilder.toString());
  }
  
  private void updateFrameDimensionsAndReportEvents(VideoFrame paramVideoFrame)
  {
    synchronized (this.layoutLock)
    {
      if (this.isRenderingPaused) {
        return;
      }
      Object localObject2;
      if (!this.isFirstFrameRendered)
      {
        this.isFirstFrameRendered = true;
        logD("Reporting first rendered frame.");
        localObject2 = this.rendererEvents;
        if (localObject2 != null) {
          ((RendererCommon.RendererEvents)localObject2).onFirstFrameRendered();
        }
      }
      if ((this.rotatedFrameWidth != paramVideoFrame.getRotatedWidth()) || (this.rotatedFrameHeight != paramVideoFrame.getRotatedHeight()) || (this.frameRotation != paramVideoFrame.getRotation()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Reporting frame resolution changed to ");
        ((StringBuilder)localObject2).append(paramVideoFrame.getBuffer().getWidth());
        ((StringBuilder)localObject2).append("x");
        ((StringBuilder)localObject2).append(paramVideoFrame.getBuffer().getHeight());
        ((StringBuilder)localObject2).append(" with rotation ");
        ((StringBuilder)localObject2).append(paramVideoFrame.getRotation());
        logD(((StringBuilder)localObject2).toString());
        localObject2 = this.rendererEvents;
        if (localObject2 != null) {
          ((RendererCommon.RendererEvents)localObject2).onFrameResolutionChanged(paramVideoFrame.getBuffer().getWidth(), paramVideoFrame.getBuffer().getHeight(), paramVideoFrame.getRotation());
        }
        this.rotatedFrameWidth = paramVideoFrame.getRotatedWidth();
        this.rotatedFrameHeight = paramVideoFrame.getRotatedHeight();
        this.frameRotation = paramVideoFrame.getRotation();
      }
      return;
    }
  }
  
  public void disableFpsReduction()
  {
    synchronized (this.layoutLock)
    {
      this.isRenderingPaused = false;
      super.disableFpsReduction();
      return;
    }
  }
  
  public void init(EglBase.Context paramContext, RendererCommon.RendererEvents arg2, int[] paramArrayOfInt, RendererCommon.GlDrawer paramGlDrawer)
  {
    ThreadUtils.checkIsOnMainThread();
    this.rendererEvents = ???;
    synchronized (this.layoutLock)
    {
      this.isFirstFrameRendered = false;
      this.rotatedFrameWidth = 0;
      this.rotatedFrameHeight = 0;
      this.frameRotation = 0;
      super.init(paramContext, paramArrayOfInt, paramGlDrawer);
      return;
    }
  }
  
  public void init(EglBase.Context paramContext, int[] paramArrayOfInt, RendererCommon.GlDrawer paramGlDrawer)
  {
    init(paramContext, null, paramArrayOfInt, paramGlDrawer);
  }
  
  public void onFrame(VideoFrame paramVideoFrame)
  {
    updateFrameDimensionsAndReportEvents(paramVideoFrame);
    super.onFrame(paramVideoFrame);
  }
  
  public void pauseVideo()
  {
    synchronized (this.layoutLock)
    {
      this.isRenderingPaused = true;
      super.pauseVideo();
      return;
    }
  }
  
  public void setFpsReduction(float paramFloat)
  {
    Object localObject1 = this.layoutLock;
    boolean bool;
    if (paramFloat == 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    try
    {
      this.isRenderingPaused = bool;
      super.setFpsReduction(paramFloat);
      return;
    }
    finally {}
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    ThreadUtils.checkIsOnMainThread();
    paramSurfaceHolder = new StringBuilder();
    paramSurfaceHolder.append("surfaceChanged: format: ");
    paramSurfaceHolder.append(paramInt1);
    paramSurfaceHolder.append(" size: ");
    paramSurfaceHolder.append(paramInt2);
    paramSurfaceHolder.append("x");
    paramSurfaceHolder.append(paramInt3);
    logD(paramSurfaceHolder.toString());
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    ThreadUtils.checkIsOnMainThread();
    createEglSurface(paramSurfaceHolder.getSurface());
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    ThreadUtils.checkIsOnMainThread();
    paramSurfaceHolder = new CountDownLatch(1);
    releaseEglSurface(new w(paramSurfaceHolder));
    ThreadUtils.awaitUninterruptibly(paramSurfaceHolder);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.SurfaceEglRenderer
 * JD-Core Version:    0.7.0.1
 */