package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.view.menu.e;
import com.google.android.material.navigation.c;
import java.util.ArrayList;

public class b
  extends c
{
  private int F = -1;
  private final FrameLayout.LayoutParams G;
  
  public b(Context paramContext)
  {
    super(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    this.G = paramContext;
    paramContext.gravity = 49;
    setLayoutParams(paramContext);
    setItemActiveIndicatorResizeable(true);
  }
  
  private int s(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = paramInt2 / Math.max(1, paramInt3);
    paramInt2 = this.F;
    if (paramInt2 != -1) {
      paramInt1 = paramInt2;
    } else {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
    }
    return View.MeasureSpec.makeMeasureSpec(Math.min(paramInt1, paramInt3), 0);
  }
  
  private int t(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView.getVisibility() != 8)
    {
      paramView.measure(paramInt1, paramInt2);
      return paramView.getMeasuredHeight();
    }
    return 0;
  }
  
  private int u(int paramInt1, int paramInt2, int paramInt3, View paramView)
  {
    s(paramInt1, paramInt2, paramInt3);
    int j = 0;
    if (paramView == null) {
      paramInt2 = s(paramInt1, paramInt2, paramInt3);
    } else {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(paramView.getMeasuredHeight(), 0);
    }
    int k = getChildCount();
    int i = 0;
    paramInt3 = j;
    while (paramInt3 < k)
    {
      View localView = getChildAt(paramInt3);
      j = i;
      if (localView != paramView) {
        j = i + t(localView, paramInt1, paramInt2);
      }
      paramInt3 += 1;
      i = j;
    }
    return i;
  }
  
  private int v(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = getChildAt(getSelectedItemPosition());
    int i;
    int j;
    if (localView != null)
    {
      i = t(localView, paramInt1, s(paramInt1, paramInt2, paramInt3));
      j = paramInt2 - i;
      int k = paramInt3 - 1;
      paramInt2 = i;
      paramInt3 = j;
      i = k;
    }
    else
    {
      j = 0;
      i = paramInt3;
      paramInt3 = paramInt2;
      paramInt2 = j;
    }
    return paramInt2 + u(paramInt1, paramInt3, i, localView);
  }
  
  protected com.google.android.material.navigation.a g(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public int getItemMinimumHeight()
  {
    return this.F;
  }
  
  int getMenuGravity()
  {
    return this.G.gravity;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    paramInt2 = 0;
    int i;
    for (paramInt4 = paramInt2; paramInt2 < j; paramInt4 = i)
    {
      View localView = getChildAt(paramInt2);
      i = paramInt4;
      if (localView.getVisibility() != 8)
      {
        i = localView.getMeasuredHeight() + paramInt4;
        localView.layout(0, paramInt4, paramInt3 - paramInt1, i);
      }
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    int j = getMenu().G().size();
    if ((j > 1) && (j(getLabelVisibilityMode(), j))) {
      i = v(paramInt1, i, j);
    } else {
      i = u(paramInt1, i, j, null);
    }
    setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(paramInt1), paramInt1, 0), View.resolveSizeAndState(i, paramInt2, 0));
  }
  
  boolean r()
  {
    return (this.G.gravity & 0x70) == 48;
  }
  
  public void setItemMinimumHeight(int paramInt)
  {
    if (this.F != paramInt)
    {
      this.F = paramInt;
      requestLayout();
    }
  }
  
  void setMenuGravity(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = this.G;
    if (localLayoutParams.gravity != paramInt)
    {
      localLayoutParams.gravity = paramInt;
      setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.navigationrail.b
 * JD-Core Version:    0.7.0.1
 */