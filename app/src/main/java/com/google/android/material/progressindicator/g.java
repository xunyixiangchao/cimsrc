package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;

abstract class g<S extends b>
{
  S a;
  protected f b;
  
  public g(S paramS)
  {
    this.a = paramS;
  }
  
  abstract void a(Canvas paramCanvas, float paramFloat);
  
  abstract void b(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, int paramInt);
  
  abstract void c(Canvas paramCanvas, Paint paramPaint);
  
  abstract int d();
  
  abstract int e();
  
  protected void f(f paramf)
  {
    this.b = paramf;
  }
  
  void g(Canvas paramCanvas, float paramFloat)
  {
    this.a.e();
    a(paramCanvas, paramFloat);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.g
 * JD-Core Version:    0.7.0.1
 */