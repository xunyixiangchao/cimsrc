package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import r7.h;
import r7.m;

class c
  extends h
{
  private final RectF A;
  private final Paint z = new Paint(1);
  
  c()
  {
    this(null);
  }
  
  c(m paramm)
  {
    super(paramm);
    u0();
    this.A = new RectF();
  }
  
  private void u0()
  {
    this.z.setStyle(Paint.Style.FILL_AND_STROKE);
    this.z.setColor(-1);
    this.z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
  
  boolean q0()
  {
    return this.A.isEmpty() ^ true;
  }
  
  protected void r(Canvas paramCanvas)
  {
    if (this.A.isEmpty())
    {
      super.r(paramCanvas);
      return;
    }
    paramCanvas.save();
    if (Build.VERSION.SDK_INT >= 26) {
      paramCanvas.clipOutRect(this.A);
    } else {
      paramCanvas.clipRect(this.A, Region.Op.DIFFERENCE);
    }
    super.r(paramCanvas);
    paramCanvas.restore();
  }
  
  void r0()
  {
    s0(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  void s0(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    RectF localRectF = this.A;
    if ((paramFloat1 != localRectF.left) || (paramFloat2 != localRectF.top) || (paramFloat3 != localRectF.right) || (paramFloat4 != localRectF.bottom))
    {
      localRectF.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    }
  }
  
  void t0(RectF paramRectF)
  {
    s0(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.textfield.c
 * JD-Core Version:    0.7.0.1
 */