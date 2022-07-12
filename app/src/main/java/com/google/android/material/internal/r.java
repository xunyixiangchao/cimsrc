package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class r
  implements s
{
  private final ViewOverlay a;
  
  r(View paramView)
  {
    this.a = paramView.getOverlay();
  }
  
  public void a(Drawable paramDrawable)
  {
    this.a.add(paramDrawable);
  }
  
  public void b(Drawable paramDrawable)
  {
    this.a.remove(paramDrawable);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.r
 * JD-Core Version:    0.7.0.1
 */