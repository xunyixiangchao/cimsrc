package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class ListFooterView
  extends RelativeLayout
{
  private View a;
  private View b;
  
  public ListFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.b.setVisibility(4);
  }
  
  public void b()
  {
    this.a.setVisibility(4);
  }
  
  public void c()
  {
    setVisibility(0);
    this.b.setVisibility(0);
  }
  
  public void d()
  {
    setVisibility(0);
    this.a.setVisibility(0);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = findViewById(2131231017);
    this.b = findViewById(2131231016);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.ListFooterView
 * JD-Core Version:    0.7.0.1
 */