package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import s3.r;
import v3.b;

public class CustomSwipeRefreshLayout
  extends SwipeRefreshLayout
  implements SwipeRefreshLayout.j
{
  private final Handler R = new Handler();
  private r S;
  private long T;
  private boolean U = false;
  
  public CustomSwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setColorSchemeResources(new int[] { 2131034167, 17170450, 17170454, 17170456 });
    super.setOnRefreshListener(this);
  }
  
  private void w()
  {
    super.setRefreshing(false);
  }
  
  public void R()
  {
    r localr = this.S;
    if (localr != null)
    {
      if (!this.U)
      {
        localr.s0();
        return;
      }
      if (System.currentTimeMillis() - this.T >= 300000L)
      {
        this.S.s0();
        return;
      }
      this.R.postDelayed(new b(this), 1000L);
    }
  }
  
  public void setLimited(boolean paramBoolean)
  {
    this.U = paramBoolean;
  }
  
  public void setOnRefreshListener(r paramr)
  {
    this.S = paramr;
  }
  
  public void x()
  {
    super.setRefreshing(false);
    this.T = System.currentTimeMillis();
  }
  
  public void y()
  {
    m(false, 0, (int)(Resources.getSystem().getDisplayMetrics().density * 30.0F));
    super.setRefreshing(true);
    this.S.s0();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.CustomSwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */