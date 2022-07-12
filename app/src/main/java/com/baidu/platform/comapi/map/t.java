package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.SurfaceHolder.Callback2;

abstract interface t
  extends SurfaceHolder.Callback2
{
  public abstract Bitmap captureImageFromSurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject, Bitmap.Config paramConfig);
  
  public abstract int getDebugFlags();
  
  public abstract int getFPS();
  
  public abstract int getRenderMode();
  
  public abstract u.a getViewType();
  
  public abstract void onAttachedToWindow();
  
  public abstract void onDetachedFromWindow();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void queueEvent(Runnable paramRunnable);
  
  public abstract void requestRender();
  
  public abstract void setDebugFlags(int paramInt);
  
  public abstract void setFPS(int paramInt);
  
  public abstract void setRenderMode(int paramInt);
  
  public abstract void setRenderer(b0 paramb0);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.t
 * JD-Core Version:    0.7.0.1
 */