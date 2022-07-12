package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

public class FromMessageFileView
  extends BaseFromMessageView<ChatFileView>
{
  public FromMessageFileView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    ((ChatFileView)this.e).b(this.f);
    View localView = this.e;
    ((ChatFileView)localView).setOnClickListener((View.OnClickListener)localView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.FromMessageFileView
 * JD-Core Version:    0.7.0.1
 */