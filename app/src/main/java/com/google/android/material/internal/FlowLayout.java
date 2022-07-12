package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.view.h;
import androidx.core.view.x;
import com.google.android.material.R.id;
import com.google.android.material.R.styleable;

public class FlowLayout
  extends ViewGroup
{
  private int a;
  private int b;
  private boolean c = false;
  private int d;
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d(paramContext, paramAttributeSet);
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != -2147483648)
    {
      if (paramInt2 != 1073741824) {
        return paramInt3;
      }
      return paramInt1;
    }
    return Math.min(paramInt3, paramInt1);
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout, 0, 0);
    this.a = paramContext.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
    this.b = paramContext.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
    paramContext.recycle();
  }
  
  public int b(View paramView)
  {
    paramView = paramView.getTag(R.id.row_index_key);
    if (!(paramView instanceof Integer)) {
      return -1;
    }
    return ((Integer)paramView).intValue();
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  protected int getItemSpacing()
  {
    return this.b;
  }
  
  protected int getLineSpacing()
  {
    return this.a;
  }
  
  protected int getRowCount()
  {
    return this.d;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() == 0)
    {
      this.d = 0;
      return;
    }
    this.d = 1;
    int i;
    if (x.B(this) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramInt2 = getPaddingRight();
    } else {
      paramInt2 = getPaddingLeft();
    }
    if (i != 0) {
      paramInt4 = getPaddingLeft();
    } else {
      paramInt4 = getPaddingRight();
    }
    int n = getPaddingTop();
    int i3 = paramInt3 - paramInt1 - paramInt4;
    int j = 0;
    paramInt4 = paramInt2;
    for (paramInt3 = n; j < getChildCount(); paramInt3 = paramInt1)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8)
      {
        localView.setTag(R.id.row_index_key, Integer.valueOf(-1));
        paramInt1 = paramInt3;
      }
      else
      {
        Object localObject = localView.getLayoutParams();
        int m;
        int k;
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          m = h.b((ViewGroup.MarginLayoutParams)localObject);
          k = h.a((ViewGroup.MarginLayoutParams)localObject);
        }
        else
        {
          k = 0;
          m = k;
        }
        int i2 = localView.getMeasuredWidth();
        int i1 = paramInt4;
        paramInt1 = paramInt3;
        if (!this.c)
        {
          i1 = paramInt4;
          paramInt1 = paramInt3;
          if (paramInt4 + m + i2 > i3)
          {
            paramInt1 = this.a + n;
            this.d += 1;
            i1 = paramInt2;
          }
        }
        localView.setTag(R.id.row_index_key, Integer.valueOf(this.d - 1));
        paramInt4 = i1 + m;
        i2 = localView.getMeasuredWidth() + paramInt4;
        n = localView.getMeasuredHeight() + paramInt1;
        paramInt3 = i2;
        if (i != 0)
        {
          paramInt4 = i3 - i2;
          paramInt3 = i3 - i1 - m;
        }
        localView.layout(paramInt4, paramInt1, paramInt3, n);
        paramInt4 = i1 + (m + k + localView.getMeasuredWidth() + this.b);
      }
      j += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i7 = View.MeasureSpec.getSize(paramInt2);
    int i8 = View.MeasureSpec.getMode(paramInt2);
    int m;
    if ((i6 != -2147483648) && (i6 != 1073741824)) {
      m = 2147483647;
    } else {
      m = i4;
    }
    int k = getPaddingLeft();
    int i1 = getPaddingTop();
    int i9 = getPaddingRight();
    int j = i1;
    int n = 0;
    int i = 0;
    while (n < getChildCount())
    {
      View localView = getChildAt(n);
      if (localView.getVisibility() != 8)
      {
        measureChild(localView, paramInt1, paramInt2);
        Object localObject = localView.getLayoutParams();
        int i2;
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          i3 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin + 0;
          i2 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin + 0;
        }
        else
        {
          i3 = 0;
          i2 = i3;
        }
        if ((k + i3 + localView.getMeasuredWidth() > m - i9) && (!c()))
        {
          j = getPaddingLeft();
          k = this.a + i1;
          i1 = j;
          j = k;
        }
        else
        {
          i1 = k;
        }
        int i5 = i1 + i3 + localView.getMeasuredWidth();
        int i10 = localView.getMeasuredHeight();
        k = i;
        if (i5 > i) {
          k = i5;
        }
        int i3 = i1 + (i3 + i2 + localView.getMeasuredWidth() + this.b);
        i = k;
        if (n == getChildCount() - 1) {
          i = k + i2;
        }
        i1 = j + i10;
        k = i3;
      }
      n += 1;
    }
    paramInt1 = getPaddingRight();
    paramInt2 = getPaddingBottom();
    setMeasuredDimension(a(i4, i6, i + paramInt1), a(i7, i8, i1 + paramInt2));
  }
  
  protected void setItemSpacing(int paramInt)
  {
    this.b = paramInt;
  }
  
  protected void setLineSpacing(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.FlowLayout
 * JD-Core Version:    0.7.0.1
 */