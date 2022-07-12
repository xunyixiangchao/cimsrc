package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.view.menu.e;
import androidx.core.view.x;
import com.google.android.material.R.dimen;
import com.google.android.material.navigation.c;
import java.util.ArrayList;

public class b
  extends c
{
  private final int F;
  private final int G;
  private final int H;
  private final int I;
  private boolean J;
  private int[] K;
  
  public b(Context paramContext)
  {
    super(paramContext);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    paramContext.gravity = 17;
    setLayoutParams(paramContext);
    paramContext = getResources();
    this.F = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
    this.G = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
    this.H = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
    this.I = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    this.K = new int[5];
  }
  
  protected com.google.android.material.navigation.a g(Context paramContext)
  {
    return new a(paramContext);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = paramInt4 - paramInt2;
    paramInt2 = 0;
    paramInt4 = paramInt2;
    while (paramInt2 < i)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        if (x.B(this) == 1)
        {
          int k = paramInt3 - paramInt1 - paramInt4;
          localView.layout(k - localView.getMeasuredWidth(), 0, k, j);
        }
        else
        {
          localView.layout(paramInt4, 0, localView.getMeasuredWidth() + paramInt4, j);
        }
        paramInt4 += localView.getMeasuredWidth();
      }
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = getMenu();
    int m = View.MeasureSpec.getSize(paramInt1);
    int j = ((e)localObject).G().size();
    int n = getChildCount();
    int i1 = View.MeasureSpec.getSize(paramInt2);
    int i2 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
    int k;
    if ((j(getLabelVisibilityMode(), j)) && (r()))
    {
      localObject = getChildAt(getSelectedItemPosition());
      i = this.I;
      paramInt1 = i;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.H, -2147483648), i2);
        paramInt1 = Math.max(i, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8) {
        i = 1;
      } else {
        i = 0;
      }
      i = j - i;
      k = Math.min(m - this.G * i, Math.min(paramInt1, this.H));
      j = m - k;
      if (i == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = i;
      }
      m = Math.min(j / paramInt1, this.F);
      i = j - i * m;
      paramInt1 = 0;
    }
    while (paramInt1 < n)
    {
      if (getChildAt(paramInt1).getVisibility() != 8)
      {
        localObject = this.K;
        if (paramInt1 == getSelectedItemPosition()) {
          j = k;
        } else {
          j = m;
        }
        localObject[paramInt1] = j;
        j = i;
        if (i > 0)
        {
          localObject = this.K;
          localObject[paramInt1] += 1;
          j = i - 1;
        }
      }
      else
      {
        this.K[paramInt1] = 0;
        j = i;
      }
      paramInt1 += 1;
      i = j;
      continue;
      if (j == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = j;
      }
      k = Math.min(m / paramInt1, this.H);
      i = m - j * k;
      paramInt1 = 0;
      while (paramInt1 < n)
      {
        if (getChildAt(paramInt1).getVisibility() != 8)
        {
          localObject = this.K;
          localObject[paramInt1] = k;
          j = i;
          if (i > 0)
          {
            localObject[paramInt1] += 1;
            j = i - 1;
          }
        }
        else
        {
          this.K[paramInt1] = 0;
          j = i;
        }
        paramInt1 += 1;
        i = j;
      }
    }
    paramInt1 = 0;
    int i = paramInt1;
    while (paramInt1 < n)
    {
      localObject = getChildAt(paramInt1);
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.K[paramInt1], 1073741824), i2);
        ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
        i += ((View)localObject).getMeasuredWidth();
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(i, View.MeasureSpec.makeMeasureSpec(i, 1073741824), 0), View.resolveSizeAndState(i1, paramInt2, 0));
  }
  
  public boolean r()
  {
    return this.J;
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.bottomnavigation.b
 * JD-Core Version:    0.7.0.1
 */