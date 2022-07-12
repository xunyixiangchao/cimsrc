package com.farsunset.hoxin.micro.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.MessageForwardActivity;
import com.farsunset.hoxin.message.widget.EmoticonTextView;
import com.farsunset.hoxin.message.widget.MessageStatusView;
import com.farsunset.hoxin.micro.entity.MicroServer;
import com.google.android.material.snackbar.Snackbar;
import r5.f;
import s3.h;
import u3.b0;

public class MicroServerToTextView
  extends RelativeLayout
  implements f, View.OnLongClickListener, h<Message>, View.OnClickListener, View.OnTouchListener
{
  private r5.e a;
  private l5.a<Message> b;
  private WebImageView c;
  private EmoticonTextView d;
  private Message e;
  private ChatSession f;
  private MessageStatusView g;
  
  public MicroServerToTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void d()
  {
    if (this.b == null)
    {
      l5.a locala = new l5.a(getContext());
      this.b = locala;
      locala.d(this);
    }
  }
  
  private void h()
  {
    n5.b.a(this.e, false);
    MicroServer localMicroServer = x5.a.f(this.f.sourceId);
    f(4);
    if (TextUtils.isEmpty(localMicroServer.url))
    {
      f(2);
      return;
    }
    this.e.state = Byte.valueOf((byte)1);
    n5.b.d(this.e);
    Object localObject = this.f;
    ((ChatSession)localObject).state = 1;
    j5.a.w(((ChatSession)localObject).id, 1);
    localObject = new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_CHAT");
    ((Intent)localObject).putExtra("ATTR_CHAT_SESSION", this.f);
    HoxinApplication.t((Intent)localObject);
    v5.b.d(localMicroServer, this.e);
  }
  
  private void i()
  {
    f(2);
    f(4);
    if (1 == this.e.state.byteValue()) {
      f(1);
    }
    if (2 == this.e.state.byteValue()) {
      f(3);
    }
    if (this.e.state.byteValue() == 0)
    {
      f(1);
      h();
    }
  }
  
  public void a(Message paramMessage, int paramInt)
  {
    f(2);
    f(3);
    this.e.state = paramMessage.state;
  }
  
  public void b(Message paramMessage)
  {
    f(2);
    f(4);
    this.e.state = paramMessage.state;
  }
  
  public final void e(Message paramMessage, ChatSession paramChatSession)
  {
    this.e = paramMessage;
    this.f = paramChatSession;
    setTag(paramMessage);
    this.c.p(b0.l(i3.e.o().longValue()), 2131165495);
    this.d.setFaceSize(24);
    this.d.setText(paramMessage.content);
    this.d.setOnLongClickListener(this);
    this.d.setOnTouchListener(this);
    i();
  }
  
  protected void f(int paramInt)
  {
    MessageStatusView localMessageStatusView;
    if (paramInt == 2)
    {
      localMessageStatusView = this.g;
      if (localMessageStatusView != null)
      {
        localMessageStatusView.c();
        return;
      }
    }
    if (paramInt == 4)
    {
      localMessageStatusView = this.g;
      if (localMessageStatusView != null)
      {
        localMessageStatusView.b();
        return;
      }
    }
    if (this.g == null)
    {
      localMessageStatusView = (MessageStatusView)((ViewStub)findViewById(2131231479)).inflate();
      this.g = localMessageStatusView;
      localMessageStatusView.setContainerView(this.d);
    }
    if (paramInt == 1) {
      this.g.g();
    }
    if (paramInt == 3) {
      this.g.f(this);
    }
  }
  
  public void g(int paramInt, Message paramMessage)
  {
    if (paramInt == 2131231197)
    {
      ((ClipboardManager)androidx.core.content.b.h(getContext(), ClipboardManager.class)).setPrimaryClip(ClipData.newPlainText(null, paramMessage.content));
      Snackbar.b0(this, 2131690029, -1).P();
    }
    if (paramInt == 2131231200) {
      this.a.m(paramMessage);
    }
    if (paramInt == 2131231209)
    {
      Intent localIntent = new Intent(getContext(), MessageForwardActivity.class);
      localIntent.putExtra(Message.NAME, paramMessage);
      getContext().startActivity(localIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231065)
    {
      j5.b.d(this.e.id);
      h();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((WebImageView)findViewById(2131231150));
    this.d = ((EmoticonTextView)findViewById(2131230905));
  }
  
  public boolean onLongClick(View paramView)
  {
    Message localMessage = (Message)getTag();
    boolean bool;
    if (localMessage.format == 0) {
      bool = true;
    } else {
      bool = false;
    }
    d();
    this.b.a(bool, true, false, false, false);
    this.b.e(localMessage, paramView);
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.setTag(2131231638, Float.valueOf(paramMotionEvent.getX()));
    paramView.setTag(2131231641, Float.valueOf(paramMotionEvent.getY()));
    return false;
  }
  
  public void setOnMessageOperationListener(r5.e parame)
  {
    this.a = parame;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.micro.widget.MicroServerToTextView
 * JD-Core Version:    0.7.0.1
 */