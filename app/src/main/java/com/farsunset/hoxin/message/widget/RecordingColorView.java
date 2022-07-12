package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class RecordingColorView
  extends View
{
  private final Paint a;
  private final Path b;
  private final int[] c = { -15028967, -518418408 };
  private final int[] d = { -46045, -505276812 };
  private boolean e = false;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  
  public RecordingColorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int k = Resources.getSystem().getDisplayMetrics().widthPixels;
    this.f = k;
    int m = k * 9 / 20;
    this.g = m;
    this.h = (m - (int)(Resources.getSystem().getDisplayMetrics().density * 10.0F));
    this.i = (k / 2);
    this.j = ((int)(-k / 2.2D));
    this.b = new Path();
    paramContext = new Paint();
    this.a = paramContext;
    paramContext.setAntiAlias(true);
    paramContext.setStyle(Paint.Style.FILL);
  }
  
  public int getRealHeight()
  {
    return this.g;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f2;
    float f3;
    float f4;
    Object localObject2;
    if (!this.e)
    {
      localObject1 = this.a;
      f1 = this.i;
      f2 = this.j;
      f3 = this.f;
      f4 = this.g;
      localObject2 = this.c;
      localObject2 = new LinearGradient(f1, f2, f3, f4, localObject2[0], localObject2[1], Shader.TileMode.MIRROR);
    }
    else
    {
      localObject1 = this.a;
      f1 = this.i;
      f2 = this.j;
      f3 = this.f;
      f4 = this.g;
      localObject2 = this.d;
      localObject2 = new LinearGradient(f1, f2, f3, f4, localObject2[0], localObject2[1], Shader.TileMode.MIRROR);
    }
    ((Paint)localObject1).setShader((Shader)localObject2);
    paramCanvas.drawRect(0.0F, 0.0F, this.f, this.h, this.a);
    this.b.reset();
    this.b.moveTo(0.0F, this.h);
    Object localObject1 = this.b;
    int k = this.f;
    float f1 = k;
    int m = this.h;
    ((Path)localObject1).quadTo(f1 * 0.5F, (this.g - m) * 2 + m, k, m);
    localObject1 = this.a;
    ((Paint)localObject1).setShadowLayer(15.0F, 0.0F, 0.0F, ((Paint)localObject1).getColor());
    paramCanvas.drawPath(this.b, this.a);
  }
  
  public void setTouchOutSide(boolean paramBoolean)
  {
    this.e = paramBoolean;
    invalidate();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.RecordingColorView
 * JD-Core Version:    0.7.0.1
 */