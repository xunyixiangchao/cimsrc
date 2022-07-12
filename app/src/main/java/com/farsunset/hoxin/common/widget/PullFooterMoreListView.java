package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import s3.r;

public class PullFooterMoreListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private boolean a = true;
  private View b;
  private int c;
  private r d;
  
  public PullFooterMoreListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnScrollListener(this);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131427561, null);
    this.b = paramContext;
    addFooterView(paramContext, null, false);
    this.b.setVisibility(8);
    paramContext = this.b;
    paramContext.setPadding(0, 0, 0, paramContext.getMeasuredHeight() * -1);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      int i = paramAbsListView.getLastVisiblePosition();
      int j = paramAbsListView.getCount();
      paramInt = 1;
      if (i != j - 1) {
        paramInt = 0;
      }
      if (paramInt != 0)
      {
        this.b.setVisibility(0);
        if (this.a)
        {
          this.b.findViewById(2131231017).setVisibility(0);
          this.b.findViewById(2131231016).setVisibility(8);
          if (this.c != 5)
          {
            this.d.e();
            this.c = 5;
          }
        }
      }
      else
      {
        this.b.findViewById(2131231017).setVisibility(8);
        this.b.findViewById(2131231016).setVisibility(0);
      }
    }
  }
  
  public void setOnRefreshListener(r paramr)
  {
    this.d = paramr;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.PullFooterMoreListView
 * JD-Core Version:    0.7.0.1
 */