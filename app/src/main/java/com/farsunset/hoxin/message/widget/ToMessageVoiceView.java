package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatVoice;
import o3.b;
import u3.c0;
import u3.l;

public class ToMessageVoiceView
  extends BaseToMessageView<ChatVoiceView>
{
  public ToMessageVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void f()
  {
    ((ChatVoiceView)this.f).d(this.e, true);
    View localView = this.f;
    ((ChatVoiceView)localView).setOnClickListener((View.OnClickListener)localView);
  }
  
  protected void j()
  {
    ChatVoice localChatVoice = (ChatVoice)l.s0(this.e.content, ChatVoice.class);
    c0.e(b.f, localChatVoice.file);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ToMessageVoiceView
 * JD-Core Version:    0.7.0.1
 */