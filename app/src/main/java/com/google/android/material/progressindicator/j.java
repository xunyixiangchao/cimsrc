package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import g7.a;

final class j
  extends g<LinearProgressIndicatorSpec>
{
  private float c = 300.0F;
  private float d;
  private float e;
  
  public j(LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    super(paramLinearProgressIndicatorSpec);
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    Rect localRect = paramCanvas.getClipBounds();
    this.c = localRect.width();
    float f1 = ((LinearProgressIndicatorSpec)this.a).a;
    paramCanvas.translate(localRect.left + localRect.width() / 2.0F, localRect.top + localRect.height() / 2.0F + Math.max(0.0F, (localRect.height() - ((LinearProgressIndicatorSpec)this.a).a) / 2.0F));
    if (((LinearProgressIndicatorSpec)this.a).i) {
      paramCanvas.scale(-1.0F, 1.0F);
    }
    if (((this.b.j()) && (((LinearProgressIndicatorSpec)this.a).e == 1)) || ((this.b.i()) && (((LinearProgressIndicatorSpec)this.a).f == 2))) {
      paramCanvas.scale(1.0F, -1.0F);
    }
    if ((this.b.j()) || (this.b.i())) {
      paramCanvas.translate(0.0F, ((LinearProgressIndicatorSpec)this.a).a * (paramFloat - 1.0F) / 2.0F);
    }
    float f2 = this.c;
    paramCanvas.clipRect(-f2 / 2.0F, -f1 / 2.0F, f2 / 2.0F, f1 / 2.0F);
    paramCanvas = this.a;
    this.d = (((LinearProgressIndicatorSpec)paramCanvas).a * paramFloat);
    this.e = (((LinearProgressIndicatorSpec)paramCanvas).b * paramFloat);
  }
  
  public void b(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramFloat1 == paramFloat2) {
      return;
    }
    float f1 = this.c;
    float f2 = -f1 / 2.0F;
    float f3 = this.e;
    float f4 = -f1 / 2.0F;
    paramPaint.setStyle(Paint.Style.FILL);
    paramPaint.setAntiAlias(true);
    paramPaint.setColor(paramInt);
    float f5 = this.d;
    RectF localRectF = new RectF(f2 + paramFloat1 * (f1 - f3 * 2.0F), -f5 / 2.0F, f4 + paramFloat2 * (f1 - f3 * 2.0F) + f3 * 2.0F, f5 / 2.0F);
    paramFloat1 = this.e;
    paramCanvas.drawRoundRect(localRectF, paramFloat1, paramFloat1, paramPaint);
  }
  
  void c(Canvas paramCanvas, Paint paramPaint)
  {
    int i = a.a(((LinearProgressIndicatorSpec)this.a).d, this.b.getAlpha());
    paramPaint.setStyle(Paint.Style.FILL);
    paramPaint.setAntiAlias(true);
    paramPaint.setColor(i);
    float f1 = this.c;
    float f2 = -f1 / 2.0F;
    float f3 = this.d;
    RectF localRectF = new RectF(f2, -f3 / 2.0F, f1 / 2.0F, f3 / 2.0F);
    f1 = this.e;
    paramCanvas.drawRoundRect(localRectF, f1, f1, paramPaint);
  }
  
  public int d()
  {
    return ((LinearProgressIndicatorSpec)this.a).a;
  }
  
  public int e()
  {
    return -1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.j
 * JD-Core Version:    0.7.0.1
 */