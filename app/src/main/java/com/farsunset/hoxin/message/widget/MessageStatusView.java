package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;

public class MessageStatusView
  extends FrameLayout
{
  private View a;
  private View b;
  private ProgressBar c;
  private View d;
  
  public MessageStatusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.b.setVisibility(8);
  }
  
  public void b()
  {
    this.a.setVisibility(8);
  }
  
  public void c()
  {
    this.c.setVisibility(8);
  }
  
  public boolean d()
  {
    return (this.b.getVisibility() == 8) && (this.c.getVisibility() == 8) && (this.a.getVisibility() == 8);
  }
  
  public void e()
  {
    this.b.setVisibility(0);
    this.c.setVisibility(8);
    this.a.setVisibility(8);
  }
  
  public void f(View.OnClickListener paramOnClickListener)
  {
    this.a.setVisibility(0);
    this.a.setOnClickListener(paramOnClickListener);
    this.c.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void g()
  {
    this.c.setVisibility(0);
    this.b.setVisibility(8);
    this.a.setVisibility(8);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = findViewById(2131231064);
    this.a = findViewById(2131231065);
    this.c = ((ProgressBar)findViewById(2131231433));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.d.getMeasuredHeight() != 0) && (getMeasuredHeight() != 0))
    {
      if (d()) {
        return;
      }
      paramInt1 = (this.d.getMeasuredHeight() - getMeasuredHeight()) / 2;
      ((RelativeLayout.LayoutParams)getLayoutParams()).topMargin = paramInt1;
    }
  }
  
  public void setContainerView(View paramView)
  {
    this.d = paramView;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.MessageStatusView
 * JD-Core Version:    0.7.0.1
 */