package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.core.content.b;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import o7.c;
import r7.h;
import s7.a;

public class MaterialDivider
  extends View
{
  private static final int f = R.style.Widget_MaterialComponents_MaterialDivider;
  private final h a;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public MaterialDivider(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.materialDividerStyle);
  }
  
  public MaterialDivider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(a.c(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.a = new h();
    paramAttributeSet = p.h(paramContext, paramAttributeSet, R.styleable.MaterialDivider, paramInt, i, new int[0]);
    this.b = paramAttributeSet.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
    this.d = paramAttributeSet.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
    this.e = paramAttributeSet.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
    setDividerColor(c.a(paramContext, paramAttributeSet, R.styleable.MaterialDivider_dividerColor).getDefaultColor());
    paramAttributeSet.recycle();
  }
  
  public int getDividerColor()
  {
    return this.c;
  }
  
  public int getDividerInsetEnd()
  {
    return this.e;
  }
  
  public int getDividerInsetStart()
  {
    return this.d;
  }
  
  public int getDividerThickness()
  {
    return this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = x.B(this);
    int j = 1;
    if (i != 1) {
      j = 0;
    }
    if (j != 0) {
      i = this.e;
    } else {
      i = this.d;
    }
    int k;
    if (j != 0)
    {
      j = getWidth();
      k = this.d;
    }
    else
    {
      j = getWidth();
      k = this.e;
    }
    this.a.setBounds(i, 0, j - k, getBottom() - getTop());
    this.a.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = getMeasuredHeight();
    if ((paramInt1 == -2147483648) || (paramInt1 == 0))
    {
      int i = this.b;
      paramInt1 = paramInt2;
      if (i > 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 != i) {
          paramInt1 = i;
        }
      }
      setMeasuredDimension(getMeasuredWidth(), paramInt1);
    }
  }
  
  public void setDividerColor(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      this.a.b0(ColorStateList.valueOf(paramInt));
      invalidate();
    }
  }
  
  public void setDividerColorResource(int paramInt)
  {
    setDividerColor(b.b(getContext(), paramInt));
  }
  
  public void setDividerInsetEnd(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setDividerInsetEndResource(int paramInt)
  {
    setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setDividerInsetStart(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setDividerInsetStartResource(int paramInt)
  {
    setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setDividerThickness(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      requestLayout();
    }
  }
  
  public void setDividerThicknessResource(int paramInt)
  {
    setDividerThickness(getContext().getResources().getDimensionPixelSize(paramInt));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.divider.MaterialDivider
 * JD-Core Version:    0.7.0.1
 */