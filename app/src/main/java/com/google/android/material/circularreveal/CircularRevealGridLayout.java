package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;

public class CircularRevealGridLayout
  extends GridLayout
  implements c
{
  private final b a = new b(this);
  
  public CircularRevealGridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    this.a.b();
  }
  
  public void d(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    b localb = this.a;
    if (localb != null)
    {
      localb.c(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void e()
  {
    this.a.a();
  }
  
  public boolean f()
  {
    return super.isOpaque();
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.a.e();
  }
  
  public int getCircularRevealScrimColor()
  {
    return this.a.f();
  }
  
  public c.e getRevealInfo()
  {
    return this.a.h();
  }
  
  public boolean isOpaque()
  {
    b localb = this.a;
    if (localb != null) {
      return localb.j();
    }
    return super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    this.a.k(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    this.a.l(paramInt);
  }
  
  public void setRevealInfo(c.e parame)
  {
    this.a.m(parame);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealGridLayout
 * JD-Core Version:    0.7.0.1
 */