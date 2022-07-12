package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;

public class AutoGridLayoutView
  extends GridLayout
{
  private int a;
  private int b;
  
  public AutoGridLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.a = ((getMeasuredWidth() - (getColumnCount() - 1) * this.b) / getColumnCount());
    int i = 0;
    while (i < getChildCount())
    {
      b(getChildAt(i), i);
      i += 1;
    }
  }
  
  private void b(View paramView, int paramInt)
  {
    int i = this.a;
    GridLayout.LayoutParams localLayoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(i, i));
    i = getColumnCount();
    int k = 1;
    int j = 0;
    if (paramInt % i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = 0;
    } else {
      i = this.b;
    }
    localLayoutParams.leftMargin = i;
    if (paramInt < getColumnCount()) {
      paramInt = k;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      paramInt = j;
    } else {
      paramInt = this.b;
    }
    localLayoutParams.topMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = getPaddingLeft();
    setPadding(0, 0, 0, 0);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredWidth() > 0) {
      a();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.AutoGridLayoutView
 * JD-Core Version:    0.7.0.1
 */