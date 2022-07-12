package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;
import o7.c;

final class b
{
  final a a;
  final a b;
  final a c;
  final a d;
  final a e;
  final a f;
  final a g;
  final Paint h;
  
  b(Context paramContext)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(o7.b.d(paramContext, R.attr.materialCalendarStyle, f.class.getCanonicalName()), R.styleable.MaterialCalendar);
    this.a = a.a(paramContext, localTypedArray.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
    this.g = a.a(paramContext, localTypedArray.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
    this.b = a.a(paramContext, localTypedArray.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
    this.c = a.a(paramContext, localTypedArray.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
    ColorStateList localColorStateList = c.a(paramContext, localTypedArray, R.styleable.MaterialCalendar_rangeFillColor);
    this.d = a.a(paramContext, localTypedArray.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
    this.e = a.a(paramContext, localTypedArray.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
    this.f = a.a(paramContext, localTypedArray.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
    paramContext = new Paint();
    this.h = paramContext;
    paramContext.setColor(localColorStateList.getDefaultColor());
    localTypedArray.recycle();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.b
 * JD-Core Version:    0.7.0.1
 */