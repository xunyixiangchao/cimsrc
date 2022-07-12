package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class d
  extends Drawable
{
  private float a;
  private final Paint b;
  private final RectF c;
  private final Rect d;
  private float e;
  private boolean f = false;
  private boolean g = true;
  private ColorStateList h;
  private PorterDuffColorFilter i;
  private ColorStateList j;
  private PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;
  
  d(ColorStateList paramColorStateList, float paramFloat)
  {
    this.a = paramFloat;
    this.b = new Paint(5);
    e(paramColorStateList);
    this.c = new RectF();
    this.d = new Rect();
  }
  
  private PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    }
    return null;
  }
  
  private void e(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.h = localColorStateList;
    this.b.setColor(localColorStateList.getColorForState(getState(), this.h.getDefaultColor()));
  }
  
  private void i(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.c.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.d.set(localRect);
    if (this.f)
    {
      float f1 = e.b(this.e, this.a, this.g);
      float f2 = e.a(this.e, this.a, this.g);
      this.d.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      this.c.set(this.d);
    }
  }
  
  public ColorStateList b()
  {
    return this.h;
  }
  
  float c()
  {
    return this.e;
  }
  
  public float d()
  {
    return this.a;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = this.b;
    int m;
    if ((this.i != null) && (localPaint.getColorFilter() == null))
    {
      localPaint.setColorFilter(this.i);
      m = 1;
    }
    else
    {
      m = 0;
    }
    RectF localRectF = this.c;
    float f1 = this.a;
    paramCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
    if (m != 0) {
      localPaint.setColorFilter(null);
    }
  }
  
  public void f(ColorStateList paramColorStateList)
  {
    e(paramColorStateList);
    invalidateSelf();
  }
  
  void g(float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramFloat == this.e) && (this.f == paramBoolean1) && (this.g == paramBoolean2)) {
      return;
    }
    this.e = paramFloat;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    i(null);
    invalidateSelf();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void getOutline(Outline paramOutline)
  {
    paramOutline.setRoundRect(this.d, this.a);
  }
  
  void h(float paramFloat)
  {
    if (paramFloat == this.a) {
      return;
    }
    this.a = paramFloat;
    i(null);
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = this.j;
    if ((localColorStateList == null) || (!localColorStateList.isStateful())) {
      localColorStateList = this.h;
    }
    return ((localColorStateList != null) && (localColorStateList.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    i(paramRect);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    Object localObject = this.h;
    int m = ((ColorStateList)localObject).getColorForState(paramArrayOfInt, ((ColorStateList)localObject).getDefaultColor());
    boolean bool;
    if (m != this.b.getColor()) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      this.b.setColor(m);
    }
    paramArrayOfInt = this.j;
    if (paramArrayOfInt != null)
    {
      localObject = this.k;
      if (localObject != null)
      {
        this.i = a(paramArrayOfInt, (PorterDuff.Mode)localObject);
        return true;
      }
    }
    return bool;
  }
  
  public void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.j = paramColorStateList;
    this.i = a(paramColorStateList, this.k);
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.k = paramMode;
    this.i = a(this.j, paramMode);
    invalidateSelf();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.cardview.widget.d
 * JD-Core Version:    0.7.0.1
 */