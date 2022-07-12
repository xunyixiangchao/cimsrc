package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import e1.d;

public final class e<S extends b>
  extends f
{
  private static final e1.c<e> u = new a("indicatorLevel");
  private g<S> p;
  private final e1.e q;
  private final d r;
  private float s;
  private boolean t = false;
  
  e(Context paramContext, b paramb, g<S> paramg)
  {
    super(paramContext, paramb);
    y(paramg);
    paramContext = new e1.e();
    this.q = paramContext;
    paramContext.d(1.0F);
    paramContext.f(50.0F);
    paramb = new d(this, u);
    this.r = paramb;
    paramb.p(paramContext);
    m(1.0F);
  }
  
  public static e<CircularProgressIndicatorSpec> u(Context paramContext, CircularProgressIndicatorSpec paramCircularProgressIndicatorSpec)
  {
    return new e(paramContext, paramCircularProgressIndicatorSpec, new c(paramCircularProgressIndicatorSpec));
  }
  
  public static e<LinearProgressIndicatorSpec> v(Context paramContext, LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    return new e(paramContext, paramLinearProgressIndicatorSpec, new j(paramLinearProgressIndicatorSpec));
  }
  
  private float x()
  {
    return this.s;
  }
  
  private void z(float paramFloat)
  {
    this.s = paramFloat;
    invalidateSelf();
  }
  
  void A(float paramFloat)
  {
    setLevel((int)(paramFloat * 10000.0F));
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = new Rect();
    if ((!getBounds().isEmpty()) && (isVisible()))
    {
      if (!paramCanvas.getClipBounds(localRect)) {
        return;
      }
      paramCanvas.save();
      this.p.g(paramCanvas, g());
      this.p.c(paramCanvas, this.m);
      int i = g7.a.a(this.b.c[0], getAlpha());
      this.p.b(paramCanvas, this.m, 0.0F, x(), i);
      paramCanvas.restore();
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.p.d();
  }
  
  public int getIntrinsicWidth()
  {
    return this.p.e();
  }
  
  public void jumpToCurrentState()
  {
    this.r.q();
    z(getLevel() / 10000.0F);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.t)
    {
      this.r.q();
      z(paramInt / 10000.0F);
    }
    else
    {
      this.r.h(x() * 10000.0F);
      this.r.l(paramInt);
    }
    return true;
  }
  
  boolean q(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramBoolean1 = super.q(paramBoolean1, paramBoolean2, paramBoolean3);
    float f = this.c.a(this.a.getContentResolver());
    if (f == 0.0F)
    {
      this.t = true;
      return paramBoolean1;
    }
    this.t = false;
    this.q.f(50.0F / f);
    return paramBoolean1;
  }
  
  g<S> w()
  {
    return this.p;
  }
  
  void y(g<S> paramg)
  {
    this.p = paramg;
    paramg.f(this);
  }
  
  class a
    extends e1.c<e>
  {
    a()
    {
      super();
    }
    
    public float c(e parame)
    {
      return e.s(parame) * 10000.0F;
    }
    
    public void d(e parame, float paramFloat)
    {
      e.t(parame, paramFloat / 10000.0F);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.e
 * JD-Core Version:    0.7.0.1
 */