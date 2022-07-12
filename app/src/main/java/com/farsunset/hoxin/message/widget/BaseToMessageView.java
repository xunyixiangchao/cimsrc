package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.MessageForwardActivity;
import i5.c;
import java.util.List;
import r5.e;
import r5.f;
import s3.h;
import s3.h0;
import u3.b0;
import u3.l;
import u3.l0;

public abstract class BaseToMessageView<T extends View>
  extends RelativeLayout
  implements f, View.OnLongClickListener, h<Message>, View.OnClickListener, View.OnTouchListener
{
  private WebImageView a;
  protected ChatSession b;
  private e c;
  private l5.a<Message> d;
  protected Message e;
  protected T f;
  private MessageStatusView g;
  
  public BaseToMessageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void e()
  {
    if (this.d == null)
    {
      l5.a locala = new l5.a(getContext());
      this.d = locala;
      locala.d(this);
    }
  }
  
  private void m()
  {
    ((BaseActivity)getContext()).T0(2131690087);
    f5.a.f(this.e, new a());
  }
  
  private void n()
  {
    Message localMessage = (Message)getTag();
    q();
    localMessage.state = Byte.valueOf((byte)1);
    n5.b.d(localMessage);
    Object localObject = this.b;
    ((ChatSession)localObject).state = 1;
    j5.a.w(((ChatSession)localObject).id, 1);
    localObject = new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_CHAT");
    ((Intent)localObject).putExtra("ATTR_CHAT_SESSION", this.b);
    HoxinApplication.t((Intent)localObject);
    f5.a.g(localMessage);
  }
  
  private void q()
  {
    i(4);
    if ((this.e.isTextFormat()) || (this.e.isProfileFormat())) {
      i(1);
    }
  }
  
  public void a(Message paramMessage, int paramInt)
  {
    i(3);
    i(2);
    if ((paramInt == 403) && (this.e.isSingleChatMessage()))
    {
      l.z0(getContext(), 2131690127);
      i4.a.c(Long.valueOf(this.b.sourceId), (byte)0);
    }
    if ((paramInt == 423) && (this.e.isGroupChatMessage())) {
      l.z0(getContext(), 2131690125);
    }
    if ((paramInt == 403) && (this.e.isGroupChatMessage())) {
      l.z0(getContext(), 2131690126);
    }
    l();
  }
  
  public void b(Message paramMessage)
  {
    i(4);
    i(2);
  }
  
  protected abstract void f();
  
  public final void g(Message paramMessage, long paramLong, ChatSession paramChatSession)
  {
    this.e = paramMessage;
    this.b = paramChatSession;
    setTag(paramMessage);
    this.a.p(b0.l(paramLong), 2131165495);
    this.f.setOnTouchListener(this);
    this.f.setOnLongClickListener(this);
    this.f.setOnClickListener(null);
    f();
    h();
  }
  
  protected void h()
  {
    if (1 == this.e.state.byteValue()) {
      q();
    } else {
      i(2);
    }
    int i;
    if (2 == this.e.state.byteValue()) {
      i = 3;
    } else {
      i = 4;
    }
    i(i);
    if (this.e.state.byteValue() == 0) {
      n();
    }
    if ((5 == this.e.state.byteValue()) && (this.e.isSingleChatMessage()) && (this.e.isNeedShowReadStatus()))
    {
      i(5);
      return;
    }
    i(6);
  }
  
  protected void i(int paramInt)
  {
    MessageStatusView localMessageStatusView;
    if (paramInt == 6)
    {
      localMessageStatusView = this.g;
      if (localMessageStatusView != null)
      {
        localMessageStatusView.a();
        return;
      }
    }
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
      localMessageStatusView.setContainerView(this.f);
    }
    if (paramInt == 5) {
      this.g.e();
    }
    if (paramInt == 1) {
      this.g.g();
    }
    if (paramInt == 3) {
      this.g.f(this);
    }
  }
  
  protected abstract void j();
  
  public void k(int paramInt, Message paramMessage)
  {
    if (paramInt == 2131231200)
    {
      this.c.m(paramMessage);
      j();
    }
    if (paramInt == 2131231237) {
      m();
    }
    if (paramInt == 2131231209)
    {
      Intent localIntent = new Intent(getContext(), MessageForwardActivity.class);
      localIntent.putExtra(Message.NAME, l0.a(paramMessage));
      getContext().startActivity(localIntent);
    }
    if (paramInt == 2131231252) {
      this.c.o(paramMessage);
    }
    if (paramInt == 2131231234) {
      this.c.l(paramMessage);
    }
  }
  
  void l() {}
  
  public void o()
  {
    this.e.state = Byte.valueOf((byte)5);
    i(5);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231065) {
      n();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((WebImageView)findViewById(2131231150));
    this.f = findViewById(2131230905);
  }
  
  public boolean onLongClick(View paramView)
  {
    Message localMessage = (Message)getTag();
    boolean bool4 = localMessage.isTextFormat();
    List localList = c.c;
    boolean bool1;
    if ((localList.contains(localMessage.state)) && (i5.b.c.contains(Byte.valueOf(localMessage.format)))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((localList.contains(localMessage.state)) && (i5.b.d.contains(Byte.valueOf(localMessage.format)))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if ((System.currentTimeMillis() - localMessage.createTime.longValue() <= 120000L) && (c.b.contains(localMessage.state))) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    e();
    this.d.a(bool4, bool1, bool3, bool4, bool2);
    this.d.e(localMessage, paramView);
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.setTag(2131231638, Float.valueOf(paramMotionEvent.getX()));
    paramView.setTag(2131231641, Float.valueOf(paramMotionEvent.getY()));
    return false;
  }
  
  public void setOnMessageOperationListener(e parame)
  {
    this.c = parame;
  }
  
  class a
    extends h0<BaseResult>
  {
    a() {}
    
    public void onHttpException(Exception paramException)
    {
      ((BaseActivity)BaseToMessageView.this.getContext()).J0();
    }
    
    public void onHttpResponse(BaseResult paramBaseResult)
    {
      ((BaseActivity)BaseToMessageView.this.getContext()).J0();
      BaseToMessageView.this.e.state = Byte.valueOf((byte)6);
      n5.b.d(BaseToMessageView.this.e);
      BaseToMessageView.d(BaseToMessageView.this).n((Message)BaseToMessageView.this.getTag());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.BaseToMessageView
 * JD-Core Version:    0.7.0.1
 */