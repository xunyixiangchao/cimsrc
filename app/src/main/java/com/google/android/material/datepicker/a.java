package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.core.view.x;
import com.google.android.material.R.styleable;
import o7.c;
import r7.m;
import r7.m.b;

final class a
{
  private final Rect a;
  private final ColorStateList b;
  private final ColorStateList c;
  private final ColorStateList d;
  private final int e;
  private final m f;
  
  private a(ColorStateList paramColorStateList1, ColorStateList paramColorStateList2, ColorStateList paramColorStateList3, int paramInt, m paramm, Rect paramRect)
  {
    x0.h.d(paramRect.left);
    x0.h.d(paramRect.top);
    x0.h.d(paramRect.right);
    x0.h.d(paramRect.bottom);
    this.a = paramRect;
    this.b = paramColorStateList2;
    this.c = paramColorStateList1;
    this.d = paramColorStateList3;
    this.e = paramInt;
    this.f = paramm;
  }
  
  static a a(Context paramContext, int paramInt)
  {
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    x0.h.b(bool, "Cannot create a CalendarItemStyle with a styleResId of 0");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.MaterialCalendarItem);
    Rect localRect = new Rect(localTypedArray.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), localTypedArray.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), localTypedArray.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), localTypedArray.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
    ColorStateList localColorStateList1 = c.a(paramContext, localTypedArray, R.styleable.MaterialCalendarItem_itemFillColor);
    ColorStateList localColorStateList2 = c.a(paramContext, localTypedArray, R.styleable.MaterialCalendarItem_itemTextColor);
    ColorStateList localColorStateList3 = c.a(paramContext, localTypedArray, R.styleable.MaterialCalendarItem_itemStrokeColor);
    paramInt = localTypedArray.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
    paramContext = m.b(paramContext, localTypedArray.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), localTypedArray.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
    localTypedArray.recycle();
    return new a(localColorStateList1, localColorStateList2, localColorStateList3, paramInt, paramContext, localRect);
  }
  
  int b()
  {
    return this.a.bottom;
  }
  
  int c()
  {
    return this.a.top;
  }
  
  void d(TextView paramTextView)
  {
    Object localObject1 = new r7.h();
    Object localObject2 = new r7.h();
    ((r7.h)localObject1).setShapeAppearanceModel(this.f);
    ((r7.h)localObject2).setShapeAppearanceModel(this.f);
    ((r7.h)localObject1).b0(this.c);
    ((r7.h)localObject1).k0(this.e, this.d);
    paramTextView.setTextColor(this.b);
    localObject1 = new RippleDrawable(this.b.withAlpha(30), (Drawable)localObject1, (Drawable)localObject2);
    localObject2 = this.a;
    x.u0(paramTextView, new InsetDrawable((Drawable)localObject1, ((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.a
 * JD-Core Version:    0.7.0.1
 */