package org.webrtc;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Point;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class SurfaceViewRenderer
  extends SurfaceView
  implements SurfaceHolder.Callback, VideoSink, RendererCommon.RendererEvents
{
  private static final String TAG = "SurfaceViewRenderer";
  private final SurfaceEglRenderer eglRenderer;
  private boolean enableFixedSize;
  private RendererCommon.RendererEvents rendererEvents;
  private final String resourceName;
  private int rotatedFrameHeight;
  private int rotatedFrameWidth;
  private int surfaceHeight;
  private int surfaceWidth;
  private final RendererCommon.VideoLayoutMeasure videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
  
  public SurfaceViewRenderer(Context paramContext)
  {
    super(paramContext);
    paramContext = getResourceName();
    this.resourceName = paramContext;
    paramContext = new SurfaceEglRenderer(paramContext);
    this.eglRenderer = paramContext;
    getHolder().addCallback(this);
    getHolder().addCallback(paramContext);
  }
  
  public SurfaceViewRenderer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResourceName();
    this.resourceName = paramContext;
    paramContext = new SurfaceEglRenderer(paramContext);
    this.eglRenderer = paramContext;
    getHolder().addCallback(this);
    getHolder().addCallback(paramContext);
  }
  
  private String getResourceName()
  {
    try
    {
      String str = getResources().getResourceEntryName(getId());
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label14:
      break label14;
    }
    return "";
  }
  
  private void logD(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.resourceName);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramString);
    Logging.d("SurfaceViewRenderer", localStringBuilder.toString());
  }
  
  private void postOrRun(Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }
  
  private void updateSurfaceSize()
  {
    
    if ((this.enableFixedSize) && (this.rotatedFrameWidth != 0) && (this.rotatedFrameHeight != 0) && (getWidth() != 0) && (getHeight() != 0))
    {
      float f1 = getWidth() / getHeight();
      int j = this.rotatedFrameWidth;
      float f2 = j;
      int i = this.rotatedFrameHeight;
      if (f2 / i > f1) {
        j = (int)(i * f1);
      } else {
        i = (int)(j / f1);
      }
      j = Math.min(getWidth(), j);
      i = Math.min(getHeight(), i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSurfaceSize. Layout size: ");
      localStringBuilder.append(getWidth());
      localStringBuilder.append("x");
      localStringBuilder.append(getHeight());
      localStringBuilder.append(", frame size: ");
      localStringBuilder.append(this.rotatedFrameWidth);
      localStringBuilder.append("x");
      localStringBuilder.append(this.rotatedFrameHeight);
      localStringBuilder.append(", requested surface size: ");
      localStringBuilder.append(j);
      localStringBuilder.append("x");
      localStringBuilder.append(i);
      localStringBuilder.append(", old surface size: ");
      localStringBuilder.append(this.surfaceWidth);
      localStringBuilder.append("x");
      localStringBuilder.append(this.surfaceHeight);
      logD(localStringBuilder.toString());
      if ((j != this.surfaceWidth) || (i != this.surfaceHeight))
      {
        this.surfaceWidth = j;
        this.surfaceHeight = i;
        getHolder().setFixedSize(j, i);
      }
    }
    else
    {
      this.surfaceHeight = 0;
      this.surfaceWidth = 0;
      getHolder().setSizeFromLayout();
    }
  }
  
  public void addFrameListener(EglRenderer.FrameListener paramFrameListener, float paramFloat)
  {
    this.eglRenderer.addFrameListener(paramFrameListener, paramFloat);
  }
  
  public void addFrameListener(EglRenderer.FrameListener paramFrameListener, float paramFloat, RendererCommon.GlDrawer paramGlDrawer)
  {
    this.eglRenderer.addFrameListener(paramFrameListener, paramFloat, paramGlDrawer);
  }
  
  public void clearImage()
  {
    this.eglRenderer.clearImage();
  }
  
  public void disableFpsReduction()
  {
    this.eglRenderer.disableFpsReduction();
  }
  
  public void init(EglBase.Context paramContext, RendererCommon.RendererEvents paramRendererEvents)
  {
    init(paramContext, paramRendererEvents, EglBase.CONFIG_PLAIN, new GlRectDrawer());
  }
  
  public void init(EglBase.Context paramContext, RendererCommon.RendererEvents paramRendererEvents, int[] paramArrayOfInt, RendererCommon.GlDrawer paramGlDrawer)
  {
    ThreadUtils.checkIsOnMainThread();
    this.rendererEvents = paramRendererEvents;
    this.rotatedFrameWidth = 0;
    this.rotatedFrameHeight = 0;
    this.eglRenderer.init(paramContext, this, paramArrayOfInt, paramGlDrawer);
  }
  
  public void onFirstFrameRendered()
  {
    RendererCommon.RendererEvents localRendererEvents = this.rendererEvents;
    if (localRendererEvents != null) {
      localRendererEvents.onFirstFrameRendered();
    }
  }
  
  public void onFrame(VideoFrame paramVideoFrame)
  {
    this.eglRenderer.onFrame(paramVideoFrame);
  }
  
  public void onFrameResolutionChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    RendererCommon.RendererEvents localRendererEvents = this.rendererEvents;
    if (localRendererEvents != null) {
      localRendererEvents.onFrameResolutionChanged(paramInt1, paramInt2, paramInt3);
    }
    int i;
    if ((paramInt3 != 0) && (paramInt3 != 180)) {
      i = paramInt2;
    } else {
      i = paramInt1;
    }
    if ((paramInt3 == 0) || (paramInt3 == 180)) {
      paramInt1 = paramInt2;
    }
    postOrRun(new e0(this, i, paramInt1));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ThreadUtils.checkIsOnMainThread();
    this.eglRenderer.setLayoutAspectRatio((paramInt3 - paramInt1) / (paramInt4 - paramInt2));
    updateSurfaceSize();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ThreadUtils.checkIsOnMainThread();
    Point localPoint = this.videoLayoutMeasure.measure(paramInt1, paramInt2, this.rotatedFrameWidth, this.rotatedFrameHeight);
    setMeasuredDimension(localPoint.x, localPoint.y);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMeasure(). New size: ");
    localStringBuilder.append(localPoint.x);
    localStringBuilder.append("x");
    localStringBuilder.append(localPoint.y);
    logD(localStringBuilder.toString());
  }
  
  public void pauseVideo()
  {
    this.eglRenderer.pauseVideo();
  }
  
  public void release()
  {
    this.eglRenderer.release();
  }
  
  public void removeFrameListener(EglRenderer.FrameListener paramFrameListener)
  {
    this.eglRenderer.removeFrameListener(paramFrameListener);
  }
  
  public void setEnableHardwareScaler(boolean paramBoolean)
  {
    ThreadUtils.checkIsOnMainThread();
    this.enableFixedSize = paramBoolean;
    updateSurfaceSize();
  }
  
  public void setFpsReduction(float paramFloat)
  {
    this.eglRenderer.setFpsReduction(paramFloat);
  }
  
  public void setMirror(boolean paramBoolean)
  {
    this.eglRenderer.setMirror(paramBoolean);
  }
  
  public void setScalingType(RendererCommon.ScalingType paramScalingType)
  {
    ThreadUtils.checkIsOnMainThread();
    this.videoLayoutMeasure.setScalingType(paramScalingType);
    requestLayout();
  }
  
  public void setScalingType(RendererCommon.ScalingType paramScalingType1, RendererCommon.ScalingType paramScalingType2)
  {
    ThreadUtils.checkIsOnMainThread();
    this.videoLayoutMeasure.setScalingType(paramScalingType1, paramScalingType2);
    requestLayout();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    ThreadUtils.checkIsOnMainThread();
    this.surfaceHeight = 0;
    this.surfaceWidth = 0;
    updateSurfaceSize();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.SurfaceViewRenderer
 * JD-Core Version:    0.7.0.1
 */