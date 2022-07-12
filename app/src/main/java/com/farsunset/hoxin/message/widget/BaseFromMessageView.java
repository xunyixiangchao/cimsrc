package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.group.entity.GroupMember;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.MessageForwardActivity;
import java.util.List;
import r5.e;
import s3.h;
import u3.b0;
import u3.j0;

public abstract class BaseFromMessageView<T extends View>
  extends RelativeLayout
  implements h<Message>, View.OnLongClickListener, View.OnClickListener, View.OnTouchListener
{
  private WebImageView a;
  private l5.a<Message> b;
  private ViewStub c;
  private TextView d;
  protected T e;
  protected Message f;
  protected ChatSession g;
  private e h;
  
  public BaseFromMessageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    if (this.b == null)
    {
      l5.a locala = new l5.a(getContext());
      this.b = locala;
      locala.d(this);
    }
  }
  
  private TextView getFromNameTextView()
  {
    if (this.d == null) {
      this.d = ((TextView)this.c.inflate());
    }
    return this.d;
  }
  
  protected abstract void b();
  
  public final void d(Message paramMessage, ChatSession paramChatSession)
  {
    this.a.setTag(2131231522, paramChatSession);
    this.f = paramMessage;
    this.g = paramChatSession;
    if (paramMessage.action.equals("3"))
    {
      paramChatSession = p4.b.m(paramMessage.sender.longValue(), Long.valueOf(Long.parseLong(paramMessage.extra)));
      this.a.setTag(2131231522, paramChatSession);
      this.a.p(b0.l(paramChatSession.uid), 2131165495);
      this.a.setOnLongClickListener(this);
      getFromNameTextView().setVisibility(0);
      getFromNameTextView().setText(paramChatSession.name);
    }
    else
    {
      this.a.o(b0.l(paramChatSession.sourceId));
    }
    setTag(paramMessage);
    this.e.setOnClickListener(null);
    this.e.setOnTouchListener(this);
    this.e.setOnLongClickListener(this);
    b();
    e();
  }
  
  protected void e()
  {
    if (10 == this.f.state.byteValue())
    {
      f5.a.d(this.f);
      this.f.state = Byte.valueOf((byte)11);
      j5.b.u(this.f.id);
    }
  }
  
  public void f(int paramInt, Message paramMessage)
  {
    if (paramInt == 2131231200) {
      this.h.m(paramMessage);
    }
    if (paramInt == 2131231209)
    {
      Intent localIntent = new Intent(getContext(), MessageForwardActivity.class);
      localIntent.putExtra(Message.NAME, paramMessage);
      getContext().startActivity(localIntent);
    }
    if (paramInt == 2131231252) {
      this.h.o(paramMessage);
    }
    if (paramInt == 2131231234) {
      this.h.l(paramMessage);
    }
  }
  
  public Object getTag()
  {
    return this.a.getTag(2131230724);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231150)
    {
      if (this.f.action.equals("3"))
      {
        j0.a(paramView.getContext(), Long.parseLong(this.f.extra));
        return;
      }
      ChatSession localChatSession = (ChatSession)this.a.getTag(2131231522);
      j0.a(paramView.getContext(), localChatSession.sourceId);
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((ViewStub)findViewById(2131231021));
    this.a = ((WebImageView)findViewById(2131231150));
    this.e = findViewById(2131230905);
    this.a.setOnClickListener(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == this.a)
    {
      paramView = new Intent("com.farsunset.hoxin.ACTION_ICON_LONG_CLICKED");
      GroupMember localGroupMember = (GroupMember)this.a.getTag(2131231522);
      paramView.putExtra(GroupMember.class.getName(), localGroupMember);
      HoxinApplication.t(paramView);
      return true;
    }
    byte b1 = this.f.format;
    boolean bool1;
    if (b1 == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = i5.b.c.contains(Byte.valueOf(b1));
    boolean bool3 = i5.b.d.contains(Byte.valueOf(this.f.format));
    a();
    this.b.a(bool1, bool2, false, bool1, bool3);
    this.b.e(this.f, paramView);
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(Resources.getSystem().getDisplayMetrics().widthPixels, 1073741824), paramInt2);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.setTag(2131231638, Float.valueOf(paramMotionEvent.getX()));
    paramView.setTag(2131231641, Float.valueOf(paramMotionEvent.getY()));
    return false;
  }
  
  public void setOnMessageOperationListener(e parame)
  {
    this.h = parame;
  }
  
  public void setTag(Object paramObject)
  {
    this.a.setTag(2131230724, paramObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.BaseFromMessageView
 * JD-Core Version:    0.7.0.1
 */