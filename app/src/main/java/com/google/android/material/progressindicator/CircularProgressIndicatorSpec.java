package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import o7.c;

public final class CircularProgressIndicatorSpec
  extends b
{
  public int g;
  public int h;
  public int i;
  
  public CircularProgressIndicatorSpec(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.circularProgressIndicatorStyle);
  }
  
  public CircularProgressIndicatorSpec(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, CircularProgressIndicator.p);
  }
  
  public CircularProgressIndicatorSpec(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    int j = paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
    int k = paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
    paramAttributeSet = p.h(paramContext, paramAttributeSet, R.styleable.CircularProgressIndicator, paramInt1, paramInt2, new int[0]);
    this.g = Math.max(c.d(paramContext, paramAttributeSet, R.styleable.CircularProgressIndicator_indicatorSize, j), this.a * 2);
    this.h = c.d(paramContext, paramAttributeSet, R.styleable.CircularProgressIndicator_indicatorInset, k);
    this.i = paramAttributeSet.getInt(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
    paramAttributeSet.recycle();
    e();
  }
  
  void e() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.CircularProgressIndicatorSpec
 * JD-Core Version:    0.7.0.1
 */