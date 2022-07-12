package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.ui.WebViewActivity;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatLink;
import u3.l;

public class ChatLinkView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView a;
  private TextView b;
  private ChatLink c;
  
  public ChatLinkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a(Message paramMessage)
  {
    paramMessage = (ChatLink)l.s0(paramMessage.content, ChatLink.class);
    this.c = paramMessage;
    this.a.setText(paramMessage.title);
    this.b.setText(l.B(this.c.url));
    setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(getContext(), WebViewActivity.class);
    paramView.setData(Uri.parse(this.c.url));
    getContext().startActivity(paramView);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((TextView)findViewById(2131231557));
    this.b = ((TextView)findViewById(2131230954));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ChatLinkView
 * JD-Core Version:    0.7.0.1
 */