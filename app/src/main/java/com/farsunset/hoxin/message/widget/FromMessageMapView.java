package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

public class FromMessageMapView
  extends BaseFromMessageView<ChatMapView>
{
  public FromMessageMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    ((ChatMapView)this.e).i(this.f);
    View localView = this.e;
    ((ChatMapView)localView).setOnClickListener((View.OnClickListener)localView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.FromMessageMapView
 * JD-Core Version:    0.7.0.1
 */