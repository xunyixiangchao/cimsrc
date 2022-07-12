package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import n7.a;

public final class i<S extends b>
  extends f
{
  private g<S> p;
  private h<ObjectAnimator> q;
  
  i(Context paramContext, b paramb, g<S> paramg, h<ObjectAnimator> paramh)
  {
    super(paramContext, paramb);
    x(paramg);
    w(paramh);
  }
  
  public static i<CircularProgressIndicatorSpec> s(Context paramContext, CircularProgressIndicatorSpec paramCircularProgressIndicatorSpec)
  {
    return new i(paramContext, paramCircularProgressIndicatorSpec, new c(paramCircularProgressIndicatorSpec), new d(paramCircularProgressIndicatorSpec));
  }
  
  public static i<LinearProgressIndicatorSpec> t(Context paramContext, LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    j localj = new j(paramLinearProgressIndicatorSpec);
    Object localObject;
    if (paramLinearProgressIndicatorSpec.g == 0) {
      localObject = new k(paramLinearProgressIndicatorSpec);
    } else {
      localObject = new l(paramContext, paramLinearProgressIndicatorSpec);
    }
    return new i(paramContext, paramLinearProgressIndicatorSpec, localj, (h)localObject);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject1 = new Rect();
    if ((!getBounds().isEmpty()) && (isVisible()))
    {
      if (!paramCanvas.getClipBounds((Rect)localObject1)) {
        return;
      }
      paramCanvas.save();
      this.p.g(paramCanvas, g());
      this.p.c(paramCanvas, this.m);
      int i = 0;
      for (;;)
      {
        Object localObject2 = this.q;
        localObject1 = ((h)localObject2).c;
        if (i >= localObject1.length) {
          break;
        }
        g localg = this.p;
        Paint localPaint = this.m;
        localObject2 = ((h)localObject2).b;
        int j = i * 2;
        localg.b(paramCanvas, localPaint, localObject2[j], localObject2[(j + 1)], localObject1[i]);
        i += 1;
      }
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
  
  boolean q(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramBoolean2 = super.q(paramBoolean1, paramBoolean2, paramBoolean3);
    if (!isRunning()) {
      this.q.a();
    }
    this.c.a(this.a.getContentResolver());
    if (paramBoolean1)
    {
      if (!paramBoolean3) {
        return paramBoolean2;
      }
      this.q.g();
    }
    return paramBoolean2;
  }
  
  h<ObjectAnimator> u()
  {
    return this.q;
  }
  
  g<S> v()
  {
    return this.p;
  }
  
  void w(h<ObjectAnimator> paramh)
  {
    this.q = paramh;
    paramh.e(this);
  }
  
  void x(g<S> paramg)
  {
    this.p = paramg;
    paramg.f(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.i
 * JD-Core Version:    0.7.0.1
 */