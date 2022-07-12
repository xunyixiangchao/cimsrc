package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import q0.a;
import r7.m;
import r7.n;

class c
  extends Drawable
{
  private final n a = n.k();
  private final Paint b;
  private final Path c = new Path();
  private final Rect d = new Rect();
  private final RectF e = new RectF();
  private final RectF f = new RectF();
  private final b g = new b(null);
  float h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private boolean n = true;
  private m o;
  private ColorStateList p;
  
  c(m paramm)
  {
    this.o = paramm;
    paramm = new Paint(1);
    this.b = paramm;
    paramm.setStyle(Paint.Style.STROKE);
  }
  
  private Shader a()
  {
    Object localObject = this.d;
    copyBounds((Rect)localObject);
    float f1 = this.h / ((Rect)localObject).height();
    int i1 = a.j(this.i, this.m);
    int i2 = a.j(this.j, this.m);
    int i3 = a.j(a.o(this.j, 0), this.m);
    int i4 = a.j(a.o(this.l, 0), this.m);
    int i5 = a.j(this.l, this.m);
    int i6 = a.j(this.k, this.m);
    float f2 = ((Rect)localObject).top;
    float f3 = ((Rect)localObject).bottom;
    localObject = Shader.TileMode.CLAMP;
    return new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i1, i2, i3, i4, i5, i6 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject);
  }
  
  protected RectF b()
  {
    this.f.set(getBounds());
    return this.f;
  }
  
  void c(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      this.m = paramColorStateList.getColorForState(getState(), this.m);
    }
    this.p = paramColorStateList;
    this.n = true;
    invalidateSelf();
  }
  
  public void d(float paramFloat)
  {
    if (this.h != paramFloat)
    {
      this.h = paramFloat;
      this.b.setStrokeWidth(paramFloat * 1.3333F);
      this.n = true;
      invalidateSelf();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.n)
    {
      this.b.setShader(a());
      this.n = false;
    }
    float f1 = this.b.getStrokeWidth() / 2.0F;
    copyBounds(this.d);
    this.e.set(this.d);
    float f2 = Math.min(this.o.r().a(b()), this.e.width() / 2.0F);
    if (this.o.u(b()))
    {
      this.e.inset(f1, f1);
      paramCanvas.drawRoundRect(this.e, f2, f2, this.b);
    }
  }
  
  void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramInt3;
    this.l = paramInt4;
  }
  
  public void f(m paramm)
  {
    this.o = paramm;
    invalidateSelf();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.g;
  }
  
  public int getOpacity()
  {
    if (this.h > 0.0F) {
      return -3;
    }
    return -2;
  }
  
  @TargetApi(21)
  public void getOutline(Outline paramOutline)
  {
    if (this.o.u(b()))
    {
      float f1 = this.o.r().a(b());
      paramOutline.setRoundRect(getBounds(), f1);
      return;
    }
    copyBounds(this.d);
    this.e.set(this.d);
    this.a.d(this.o, 1.0F, this.e, this.c);
    if (this.c.isConvex()) {
      paramOutline.setConvexPath(this.c);
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    if (this.o.u(b()))
    {
      int i1 = Math.round(this.h);
      paramRect.set(i1, i1, i1, i1);
    }
    return true;
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = this.p;
    return ((localColorStateList != null) && (localColorStateList.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.n = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    ColorStateList localColorStateList = this.p;
    if (localColorStateList != null)
    {
      int i1 = localColorStateList.getColorForState(paramArrayOfInt, this.m);
      if (i1 != this.m)
      {
        this.n = true;
        this.m = i1;
      }
    }
    if (this.n) {
      invalidateSelf();
    }
    return this.n;
  }
  
  public void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  private class b
    extends Drawable.ConstantState
  {
    private b() {}
    
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    public Drawable newDrawable()
    {
      return c.this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.floatingactionbutton.c
 * JD-Core Version:    0.7.0.1
 */