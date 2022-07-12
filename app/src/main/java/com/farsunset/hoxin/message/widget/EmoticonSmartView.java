package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import u3.b0;
import u3.r;
import u3.s;

public class EmoticonSmartView
  extends LinearLayout
{
  private ImageView a;
  private TextView b;
  
  public EmoticonSmartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(EmoticonItem paramEmoticonItem)
  {
    this.b.setText(paramEmoticonItem.name);
    if (paramEmoticonItem.isStatic())
    {
      s.a().l(this.a, b0.d(paramEmoticonItem.id.longValue()));
      return;
    }
    s.a().f(this.a, b0.d(paramEmoticonItem.id.longValue()));
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)getChildAt(0));
    this.b = ((TextView)getChildAt(1));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.EmoticonSmartView
 * JD-Core Version:    0.7.0.1
 */