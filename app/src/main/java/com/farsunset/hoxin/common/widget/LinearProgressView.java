package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.content.b;

public class LinearProgressView
  extends View
{
  private Paint a;
  private Paint b;
  private boolean c = false;
  private int d;
  private int e;
  private int f;
  private int g;
  private final Handler h = new a();
  
  public LinearProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void f()
  {
    this.c = false;
    this.h.removeCallbacksAndMessages(null);
    this.f = 0;
    invalidate();
  }
  
  public void g()
  {
    this.c = true;
    this.h.removeCallbacksAndMessages(null);
    this.h.sendEmptyMessage(0);
  }
  
  public int getDurationSecond()
  {
    return this.f / 1000;
  }
  
  public void h()
  {
    this.c = false;
    this.h.removeCallbacksAndMessages(null);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.g = Resources.getSystem().getDisplayMetrics().widthPixels;
    this.a = new Paint();
    this.b = new Paint();
    int i = Color.parseColor("#ED445C");
    int j = Color.parseColor("#F6D45C");
    int k = Color.parseColor("#54ABEF");
    int m = Color.parseColor("#45C01A");
    float f1 = this.g;
    Object localObject = Shader.TileMode.MIRROR;
    localObject = new LinearGradient(0.0F, 0.0F, f1, 0.0F, new int[] { i, j, k, m }, new float[] { 0.1F, 0.3F, 0.6F, 1.0F }, (Shader.TileMode)localObject);
    this.a.setShader((Shader)localObject);
    this.a.setStyle(Paint.Style.FILL);
    this.b.setColor(b.b(getContext(), 17170454));
    this.b.setStyle(Paint.Style.FILL);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.c = false;
    this.h.removeCallbacksAndMessages(null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.g * this.e / this.d;
    paramCanvas.drawRect(i, 0.0F, i + getMeasuredHeight(), getMeasuredHeight(), this.b);
    paramCanvas.drawRect(0.0F, 0.0F, this.g * this.f / this.d, getMeasuredHeight(), this.a);
  }
  
  public void setMaxDuration(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setMinDuration(int paramInt)
  {
    this.e = paramInt;
  }
  
  class a
    extends Handler
  {
    a() {}
    
    public void dispatchMessage(Message paramMessage)
    {
      if (LinearProgressView.a(LinearProgressView.this))
      {
        if (LinearProgressView.b(LinearProgressView.this) == LinearProgressView.d(LinearProgressView.this))
        {
          LinearProgressView.this.h();
          return;
        }
        LinearProgressView.c(LinearProgressView.this, 20);
        LinearProgressView.this.invalidate();
        LinearProgressView.e(LinearProgressView.this).sendEmptyMessageDelayed(0, 20L);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.LinearProgressView
 * JD-Core Version:    0.7.0.1
 */