package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;

public final class LinearProgressIndicatorSpec
  extends b
{
  public int g;
  public int h;
  boolean i;
  
  public LinearProgressIndicatorSpec(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.linearProgressIndicatorStyle);
  }
  
  public LinearProgressIndicatorSpec(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, LinearProgressIndicator.p);
  }
  
  public LinearProgressIndicatorSpec(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    int[] arrayOfInt = R.styleable.LinearProgressIndicator;
    paramInt1 = R.attr.linearProgressIndicatorStyle;
    paramInt2 = LinearProgressIndicator.p;
    boolean bool = false;
    paramContext = p.h(paramContext, paramAttributeSet, arrayOfInt, paramInt1, paramInt2, new int[0]);
    this.g = paramContext.getInt(R.styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
    this.h = paramContext.getInt(R.styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
    paramContext.recycle();
    e();
    if (this.h == 1) {
      bool = true;
    }
    this.i = bool;
  }
  
  void e()
  {
    if (this.g == 0)
    {
      if (this.b <= 0)
      {
        if (this.c.length >= 3) {
          return;
        }
        throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
      }
      throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.LinearProgressIndicatorSpec
 * JD-Core Version:    0.7.0.1
 */