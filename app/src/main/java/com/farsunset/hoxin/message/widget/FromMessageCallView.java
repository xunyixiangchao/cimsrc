package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class FromMessageCallView
  extends BaseFromMessageView<ChatCallView>
{
  public FromMessageCallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    ((ChatCallView)this.e).a(this.f, this.g);
    View localView = this.e;
    ((ChatCallView)localView).setOnClickListener((View.OnClickListener)localView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.FromMessageCallView
 * JD-Core Version:    0.7.0.1
 */