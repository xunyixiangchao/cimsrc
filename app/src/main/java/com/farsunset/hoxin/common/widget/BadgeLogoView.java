package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;
import o3.b;
import u3.b0;
import u3.o;

public class BadgeLogoView
  extends GridLayout
{
  private WebImageView a;
  
  public BadgeLogoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    o.c(this);
  }
  
  public void b(b paramb, long paramLong)
  {
    if (this.a == null) {
      this.a = ((WebImageView)getChildAt(0));
    }
    this.a.p(b0.f(paramb.a(), String.valueOf(paramLong)), 2131165495);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.BadgeLogoView
 * JD-Core Version:    0.7.0.1
 */