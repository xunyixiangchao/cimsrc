package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;
import com.google.android.material.circularreveal.c.e;

public class CircularRevealCoordinatorLayout
  extends CoordinatorLayout
  implements c
{
  private final b z = new b(this);
  
  public CircularRevealCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    this.z.b();
  }
  
  public void d(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    b localb = this.z;
    if (localb != null)
    {
      localb.c(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void e()
  {
    this.z.a();
  }
  
  public boolean f()
  {
    return super.isOpaque();
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.z.e();
  }
  
  public int getCircularRevealScrimColor()
  {
    return this.z.f();
  }
  
  public c.e getRevealInfo()
  {
    return this.z.h();
  }
  
  public boolean isOpaque()
  {
    b localb = this.z;
    if (localb != null) {
      return localb.j();
    }
    return super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    this.z.k(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    this.z.l(paramInt);
  }
  
  public void setRevealInfo(c.e parame)
  {
    this.z.m(parame);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */