package com.farsunset.hoxin.micro.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import j5.b;
import l5.a;
import r5.e;
import s3.h;

public abstract class BaseMicroServerFromView
  extends LinearLayout
  implements h<Message>, View.OnLongClickListener, View.OnTouchListener
{
  ChatSession a;
  Message b;
  private e c;
  private a<Message> d;
  
  public BaseMicroServerFromView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    if (this.d == null)
    {
      a locala = new a(getContext());
      this.d = locala;
      locala.d(this);
    }
  }
  
  protected abstract void b();
  
  public final void d(Message paramMessage, ChatSession paramChatSession)
  {
    this.b = paramMessage;
    this.a = paramChatSession;
    setTag(paramMessage);
    if (10 == paramMessage.state.byteValue())
    {
      paramMessage.state = Byte.valueOf((byte)11);
      b.E(paramMessage);
    }
    b();
  }
  
  public void e(int paramInt, Message paramMessage)
  {
    if (paramInt == 2131231200) {
      this.c.m(paramMessage);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool1;
    if (this.b.format == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a();
    int i = this.b.format;
    boolean bool2;
    if ((i != 0) && (6 != i)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    this.d.a(bool1, bool2, false, false, false);
    this.d.e(this.b, paramView);
    return false;
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
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.micro.widget.BaseMicroServerFromView
 * JD-Core Version:    0.7.0.1
 */