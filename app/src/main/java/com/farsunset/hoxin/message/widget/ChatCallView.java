package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatCall;
import u3.l;

public class ChatCallView
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView a;
  private TextView b;
  private ChatCall c;
  private ChatSession d;
  
  public ChatCallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a(Message paramMessage, ChatSession paramChatSession)
  {
    paramMessage = (ChatCall)l.s0(paramMessage.content, ChatCall.class);
    this.c = paramMessage;
    this.d = paramChatSession;
    if (paramMessage.type == 1) {
      this.a.setImageResource(2131165440);
    }
    if (this.c.type == 0) {
      this.a.setImageResource(2131165438);
    }
    if (this.c.state == 1) {
      this.b.setText(2131690022);
    }
    if (this.c.state == 2) {
      this.b.setText(2131689582);
    }
    if (this.c.state == 0) {
      this.b.setText(getContext().getString(2131689585, new Object[] { l.s(this.c.duration) }));
    }
  }
  
  public void b(Message paramMessage, ChatSession paramChatSession)
  {
    paramMessage = (ChatCall)l.s0(paramMessage.content, ChatCall.class);
    this.c = paramMessage;
    this.d = paramChatSession;
    if (paramMessage.type == 1) {
      this.a.setImageResource(2131165441);
    }
    if (this.c.type == 0) {
      this.a.setImageResource(2131165439);
    }
    if (this.c.state == 1) {
      this.b.setText(2131690016);
    }
    if (this.c.state == 2) {
      this.b.setText(2131690023);
    }
    if (this.c.state == 4) {
      this.b.setText(2131689583);
    }
    if (this.c.state == 0) {
      this.b.setText(getContext().getString(2131689585, new Object[] { l.s(this.c.duration) }));
    }
    if (this.c.state == 3) {
      this.b.setText(2131690021);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.c.type == 1) {
      HoxinApplication.h().v(this.d);
    }
    if (this.c.type == 0) {
      HoxinApplication.h().u(this.d);
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(2131230860));
    this.b = ((TextView)findViewById(2131230861));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ChatCallView
 * JD-Core Version:    0.7.0.1
 */