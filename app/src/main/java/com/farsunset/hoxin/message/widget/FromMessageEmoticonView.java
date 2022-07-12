package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class FromMessageEmoticonView
  extends BaseFromMessageView<ChatEmoticonView>
{
  public FromMessageEmoticonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    ((ChatEmoticonView)this.e).a(this.f);
    View localView = this.e;
    ((ChatEmoticonView)localView).setOnClickListener((View.OnClickListener)localView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.FromMessageEmoticonView
 * JD-Core Version:    0.7.0.1
 */