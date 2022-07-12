package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class ToMessageCallView
  extends BaseToMessageView<ChatCallView>
{
  public ToMessageCallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void f()
  {
    ((ChatCallView)this.f).b(this.e, this.b);
    View localView = this.f;
    ((ChatCallView)localView).setOnClickListener((View.OnClickListener)localView);
  }
  
  protected void h() {}
  
  protected void j() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ToMessageCallView
 * JD-Core Version:    0.7.0.1
 */