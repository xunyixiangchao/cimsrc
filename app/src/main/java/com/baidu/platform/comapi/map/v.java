package com.baidu.platform.comapi.map;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;

class v
  extends SurfaceView
  implements SurfaceHolder.Callback2
{
  protected t a;
  
  public v(Context paramContext)
  {
    super(paramContext);
    a(paramContext, u.a.a, true);
  }
  
  public v(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, u.a.a, true);
  }
  
  public v(Context paramContext, u.a parama)
  {
    super(paramContext);
    a(paramContext, parama, true);
  }
  
  public v(Context paramContext, u.a parama, boolean paramBoolean)
  {
    super(paramContext);
    a(paramContext, parama, paramBoolean);
  }
  
  public v(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    a(paramContext, u.a.a, paramBoolean);
  }
  
  protected t a(u.a parama, boolean paramBoolean, Context paramContext)
  {
    return u.a(this, parama, paramBoolean, paramContext);
  }
  
  protected void a(Context paramContext, u.a parama, boolean paramBoolean)
  {
    if (this.a != null) {
      return;
    }
    this.a = a(parama, paramBoolean, paramContext);
    getHolder().addCallback(this);
  }
  
  public Bitmap captureImageFromSurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject, Bitmap.Config paramConfig)
  {
    return this.a.captureImageFromSurface(paramInt1, paramInt2, paramInt3, paramInt4, paramObject, paramConfig);
  }
  
  public int getDebugFlags()
  {
    return this.a.getDebugFlags();
  }
  
  public t getRenderControl()
  {
    return this.a;
  }
  
  public int getRenderMode()
  {
    return this.a.getRenderMode();
  }
  
  public u.a getViewType()
  {
    t localt = this.a;
    if (localt != null) {
      return localt.getViewType();
    }
    return u.a.c;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a.onAttachedToWindow();
  }
  
  public void onDetachedFromWindow()
  {
    this.a.onDetachedFromWindow();
    super.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    this.a.onPause();
  }
  
  public void onResume()
  {
    this.a.onResume();
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    this.a.queueEvent(paramRunnable);
  }
  
  public void requestRender()
  {
    this.a.requestRender();
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.a.setDebugFlags(paramInt);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.a.setRenderMode(paramInt);
  }
  
  public void setRenderer(b0 paramb0)
  {
    this.a.setRenderer(paramb0);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.a.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.a.surfaceDestroyed(paramSurfaceHolder);
  }
  
  @Deprecated
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
  
  @TargetApi(26)
  public void surfaceRedrawNeededAsync(SurfaceHolder paramSurfaceHolder, Runnable paramRunnable)
  {
    this.a.surfaceRedrawNeededAsync(paramSurfaceHolder, paramRunnable);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.v
 * JD-Core Version:    0.7.0.1
 */