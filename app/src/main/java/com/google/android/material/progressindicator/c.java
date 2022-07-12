package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import g7.a;

final class c
  extends g<CircularProgressIndicatorSpec>
{
  private int c = 1;
  private float d;
  private float e;
  private float f;
  
  public c(CircularProgressIndicatorSpec paramCircularProgressIndicatorSpec)
  {
    super(paramCircularProgressIndicatorSpec);
  }
  
  private void h(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramCanvas.save();
    paramCanvas.rotate(paramFloat3);
    paramFloat3 = this.f;
    paramFloat1 /= 2.0F;
    paramCanvas.drawRoundRect(new RectF(paramFloat3 - paramFloat1, paramFloat2, paramFloat3 + paramFloat1, -paramFloat2), paramFloat2, paramFloat2, paramPaint);
    paramCanvas.restore();
  }
  
  private int i()
  {
    b localb = this.a;
    return ((CircularProgressIndicatorSpec)localb).g + ((CircularProgressIndicatorSpec)localb).h * 2;
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    b localb = this.a;
    float f1 = ((CircularProgressIndicatorSpec)localb).g / 2.0F + ((CircularProgressIndicatorSpec)localb).h;
    paramCanvas.translate(f1, f1);
    paramCanvas.rotate(-90.0F);
    float f2 = -f1;
    paramCanvas.clipRect(f2, f2, f1, f1);
    paramCanvas = this.a;
    int i;
    if (((CircularProgressIndicatorSpec)paramCanvas).i == 0) {
      i = 1;
    } else {
      i = -1;
    }
    this.c = i;
    this.d = (((CircularProgressIndicatorSpec)paramCanvas).a * paramFloat);
    this.e = (((CircularProgressIndicatorSpec)paramCanvas).b * paramFloat);
    this.f = ((((CircularProgressIndicatorSpec)paramCanvas).g - ((CircularProgressIndicatorSpec)paramCanvas).a) / 2.0F);
    if (((this.b.j()) && (((CircularProgressIndicatorSpec)this.a).e == 2)) || ((this.b.i()) && (((CircularProgressIndicatorSpec)this.a).f == 1))) {}
    for (paramFloat = this.f + (1.0F - paramFloat) * ((CircularProgressIndicatorSpec)this.a).a / 2.0F;; paramFloat = this.f - (1.0F - paramFloat) * ((CircularProgressIndicatorSpec)this.a).a / 2.0F)
    {
      this.f = paramFloat;
      return;
      if (((!this.b.j()) || (((CircularProgressIndicatorSpec)this.a).e != 1)) && ((!this.b.i()) || (((CircularProgressIndicatorSpec)this.a).f != 2))) {
        break;
      }
    }
  }
  
  void b(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramFloat1 == paramFloat2) {
      return;
    }
    paramPaint.setStyle(Paint.Style.STROKE);
    paramPaint.setStrokeCap(Paint.Cap.BUTT);
    paramPaint.setAntiAlias(true);
    paramPaint.setColor(paramInt);
    paramPaint.setStrokeWidth(this.d);
    paramInt = this.c;
    float f1 = paramFloat1 * 360.0F * paramInt;
    if (paramFloat2 >= paramFloat1) {
      paramFloat1 = paramFloat2 - paramFloat1;
    } else {
      paramFloat1 = 1.0F + paramFloat2 - paramFloat1;
    }
    paramFloat1 = paramFloat1 * 360.0F * paramInt;
    paramFloat2 = this.f;
    paramCanvas.drawArc(new RectF(-paramFloat2, -paramFloat2, paramFloat2, paramFloat2), f1, paramFloat1, false, paramPaint);
    if ((this.e > 0.0F) && (Math.abs(paramFloat1) < 360.0F))
    {
      paramPaint.setStyle(Paint.Style.FILL);
      h(paramCanvas, paramPaint, this.d, this.e, f1);
      h(paramCanvas, paramPaint, this.d, this.e, f1 + paramFloat1);
    }
  }
  
  void c(Canvas paramCanvas, Paint paramPaint)
  {
    int i = a.a(((CircularProgressIndicatorSpec)this.a).d, this.b.getAlpha());
    paramPaint.setStyle(Paint.Style.STROKE);
    paramPaint.setStrokeCap(Paint.Cap.BUTT);
    paramPaint.setAntiAlias(true);
    paramPaint.setColor(i);
    paramPaint.setStrokeWidth(this.d);
    float f1 = this.f;
    paramCanvas.drawArc(new RectF(-f1, -f1, f1, f1), 0.0F, 360.0F, false, paramPaint);
  }
  
  public int d()
  {
    return i();
  }
  
  public int e()
  {
    return i();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.c
 * JD-Core Version:    0.7.0.1
 */