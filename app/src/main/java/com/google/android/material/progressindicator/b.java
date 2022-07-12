package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import g7.a;
import o7.c;

public abstract class b
{
  public int a;
  public int b;
  public int[] c = new int[0];
  public int d;
  public int e;
  public int f;
  
  protected b(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    int i = paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
    paramAttributeSet = p.h(paramContext, paramAttributeSet, R.styleable.BaseProgressIndicator, paramInt1, paramInt2, new int[0]);
    this.a = c.d(paramContext, paramAttributeSet, R.styleable.BaseProgressIndicator_trackThickness, i);
    this.b = Math.min(c.d(paramContext, paramAttributeSet, R.styleable.BaseProgressIndicator_trackCornerRadius, 0), this.a / 2);
    this.e = paramAttributeSet.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
    this.f = paramAttributeSet.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
    c(paramContext, paramAttributeSet);
    d(paramContext, paramAttributeSet);
    paramAttributeSet.recycle();
  }
  
  private void c(Context paramContext, TypedArray paramTypedArray)
  {
    int i = R.styleable.BaseProgressIndicator_indicatorColor;
    if (!paramTypedArray.hasValue(i))
    {
      this.c = new int[] { a.b(paramContext, R.attr.colorPrimary, -1) };
      return;
    }
    if (paramTypedArray.peekValue(i).type != 1)
    {
      this.c = new int[] { paramTypedArray.getColor(i, -1) };
      return;
    }
    paramContext = paramContext.getResources().getIntArray(paramTypedArray.getResourceId(i, -1));
    this.c = paramContext;
    if (paramContext.length != 0) {
      return;
    }
    throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
  }
  
  private void d(Context paramContext, TypedArray paramTypedArray)
  {
    int i = R.styleable.BaseProgressIndicator_trackColor;
    if (paramTypedArray.hasValue(i)) {}
    for (i = paramTypedArray.getColor(i, -1);; i = a.a(this.d, i))
    {
      this.d = i;
      return;
      this.d = this.c[0];
      paramContext = paramContext.getTheme().obtainStyledAttributes(new int[] { 16842803 });
      float f1 = paramContext.getFloat(0, 0.2F);
      paramContext.recycle();
      i = (int)(f1 * 255.0F);
    }
  }
  
  public boolean a()
  {
    return this.f != 0;
  }
  
  public boolean b()
  {
    return this.e != 0;
  }
  
  abstract void e();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.b
 * JD-Core Version:    0.7.0.1
 */