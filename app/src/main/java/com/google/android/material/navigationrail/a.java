package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.google.android.material.R.dimen;
import com.google.android.material.R.layout;

final class a
  extends com.google.android.material.navigation.a
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  protected int getItemDefaultMarginResId()
  {
    return R.dimen.mtrl_navigation_rail_icon_margin;
  }
  
  protected int getItemLayoutResId()
  {
    return R.layout.mtrl_navigation_rail_item;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt2) == 0)
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      paramInt1 = Math.max(getMeasuredHeight(), paramInt1);
      setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(paramInt1, paramInt2, 0));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.navigationrail.a
 * JD-Core Version:    0.7.0.1
 */