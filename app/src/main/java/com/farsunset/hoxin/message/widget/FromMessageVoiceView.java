package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.farsunset.hoxin.message.entity.Message;
import n5.b;

public class FromMessageVoiceView
  extends BaseFromMessageView<ChatVoiceView>
{
  private View i;
  
  public FromMessageVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    ((ChatVoiceView)this.e).d(this.f, false);
    if (12 != this.f.state.byteValue())
    {
      this.i.setVisibility(0);
      return;
    }
    this.i.setVisibility(4);
  }
  
  protected void e()
  {
    if (10 == this.f.state.byteValue())
    {
      this.f.state = Byte.valueOf((byte)11);
      b.c(this.f);
    }
  }
  
  public void g()
  {
    this.i.setVisibility(4);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.i = findViewById(2131231621);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.FromMessageVoiceView
 * JD-Core Version:    0.7.0.1
 */