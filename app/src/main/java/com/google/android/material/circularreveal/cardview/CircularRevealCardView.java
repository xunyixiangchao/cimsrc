package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;
import com.google.android.material.circularreveal.c.e;

public class CircularRevealCardView
  extends MaterialCardView
  implements c
{
  private final b s = new b(this);
  
  public CircularRevealCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    this.s.b();
  }
  
  public void d(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    b localb = this.s;
    if (localb != null)
    {
      localb.c(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void e()
  {
    this.s.a();
  }
  
  public boolean f()
  {
    return super.isOpaque();
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.s.e();
  }
  
  public int getCircularRevealScrimColor()
  {
    return this.s.f();
  }
  
  public c.e getRevealInfo()
  {
    return this.s.h();
  }
  
  public boolean isOpaque()
  {
    b localb = this.s;
    if (localb != null) {
      return localb.j();
    }
    return super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    this.s.k(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    this.s.l(paramInt);
  }
  
  public void setRevealInfo(c.e parame)
  {
    this.s.m(parame);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.circularreveal.cardview.CircularRevealCardView
 * JD-Core Version:    0.7.0.1
 */