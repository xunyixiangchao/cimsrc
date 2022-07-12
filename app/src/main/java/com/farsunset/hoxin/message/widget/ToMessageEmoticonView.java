package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ToMessageEmoticonView
  extends BaseToMessageView<ChatEmoticonView>
{
  public ToMessageEmoticonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void f()
  {
    ((ChatEmoticonView)this.f).a(this.e);
    View localView = this.f;
    ((ChatEmoticonView)localView).setOnClickListener((View.OnClickListener)localView);
  }
  
  protected void j() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ToMessageEmoticonView
 * JD-Core Version:    0.7.0.1
 */