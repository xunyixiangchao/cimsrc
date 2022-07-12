package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CircleProgressView
  extends View
{
  private final Paint a;
  private final Paint b;
  private int c;
  private final RectF d = new RectF();
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new Paint();
    this.b = paramContext;
    paramContext.setColor(2147483647);
    paramContext.setAntiAlias(true);
    paramContext = new Paint();
    this.a = paramContext;
    paramContext.setStrokeWidth(getResources().getDisplayMetrics().density * 2.0F);
    paramContext.setColor(-1);
    paramContext.setAntiAlias(true);
    paramContext.setStyle(Paint.Style.STROKE);
  }
  
  public void a()
  {
    invalidate();
    this.b.setColor(2146255964);
    this.a.setColor(-1227684);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i = (int)(getWidth() / 2 * 0.9D);
    int j = getWidth() / 2;
    int k = getHeight() / 2;
    RectF localRectF = this.d;
    localRectF.left = (j - i);
    localRectF.top = (k - i);
    localRectF.right = (j + i);
    localRectF.bottom = (k + i);
    paramCanvas.drawArc(localRectF, -90.0F, this.c * 360 / 100, true, this.b);
    paramCanvas.drawArc(this.d, 0.0F, 360.0F, false, this.a);
  }
  
  public void setProgress(int paramInt)
  {
    this.c = paramInt;
    this.b.setColor(2147483647);
    this.a.setColor(-1);
    invalidate();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.CircleProgressView
 * JD-Core Version:    0.7.0.1
 */