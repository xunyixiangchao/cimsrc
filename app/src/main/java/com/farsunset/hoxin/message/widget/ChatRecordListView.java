package com.farsunset.hoxin.message.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.e;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.Message;
import java.util.Objects;
import r5.a;
import r5.g;
import r5.h;
import s3.b0;
import s3.d0;

public class ChatRecordListView
  extends RecyclerView
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private b0 M0;
  private MessageSendReceiver N0;
  private LinearLayoutManager O0;
  private g P0;
  private a Q0;
  private h R0;
  private r5.b S0;
  
  public ChatRecordListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void F1(int paramInt)
  {
    if (paramInt >= 0) {
      postDelayed(new b(this, paramInt), 24L);
    }
  }
  
  public void H1()
  {
    LinearLayoutManager localLinearLayoutManager = this.O0;
    localLinearLayoutManager.z2(localLinearLayoutManager.Y() - 1, -2147483648);
  }
  
  public void I1()
  {
    if (!canScrollVertically(1)) {
      H1();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MessageSendReceiver localMessageSendReceiver = new MessageSendReceiver();
    this.N0 = localMessageSendReceiver;
    HoxinApplication.p(localMessageSendReceiver, localMessageSendReceiver.a());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    HoxinApplication.D(this.N0);
    getViewTreeObserver().removeOnGlobalLayoutListener(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOverScrollMode(2);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext());
    this.O0 = localLinearLayoutManager;
    setLayoutManager(localLinearLayoutManager);
    setItemAnimator(new e());
    h(new v3.f((int)Resources.getSystem().getDisplayMetrics().density * 18));
    getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  public void onGlobalLayout()
  {
    int i;
    if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!this.O0.m2()))
    {
      this.O0.C2(true);
      return;
    }
    if ((i == 0) && (this.O0.m2())) {
      this.O0.C2(false);
    }
    setVisibility(0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      b0 localb0 = this.M0;
      if (localb0 != null) {
        localb0.V();
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnAddMessageListener(a parama)
  {
    this.Q0 = parama;
  }
  
  public void setOnClickMessageListener(r5.b paramb)
  {
    this.S0 = paramb;
  }
  
  public void setOnQuoteMessageListener(g paramg)
  {
    this.P0 = paramg;
  }
  
  public void setOnRedoMessageListener(h paramh)
  {
    this.R0 = paramh;
  }
  
  public void setOnTouchDownListener(b0 paramb0)
  {
    this.M0 = paramb0;
  }
  
  public class MessageSendReceiver
    extends BroadcastReceiver
  {
    public MessageSendReceiver() {}
    
    IntentFilter a()
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.farsunset.hoxin.ACTION_WINDOW_REFRESH_MESSAGE");
      localIntentFilter.addAction("com.farsunset.hoxin.ACTION_UPLOAD_PROGRESS");
      localIntentFilter.addAction("com.farsunset.hoxin.ACTION_QUOTE_MESSAGE");
      localIntentFilter.addAction("com.farsunset.hoxin.ACTION_WINDOW_ADD_MESSAGE");
      localIntentFilter.addAction("com.farsunset.hoxin.ACTION_REDO_MESSAGE");
      localIntentFilter.addAction("com.farsunset.hoxin.ACTION_OPEN_GALLERY");
      return localIntentFilter;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (Objects.equals(paramIntent.getAction(), "com.farsunset.hoxin.ACTION_WINDOW_REFRESH_MESSAGE"))
      {
        paramContext = (Message)paramIntent.getSerializableExtra(Message.NAME);
        View localView = ChatRecordListView.this.findViewWithTag(paramContext);
        if ((4 == paramContext.state.byteValue()) && ((localView instanceof r5.f))) {
          ((r5.f)localView).b(paramContext);
        }
        if ((2 == paramContext.state.byteValue()) && ((localView instanceof r5.f)))
        {
          int i = paramIntent.getIntExtra("ATTR_CODE", -1);
          ((r5.f)localView).a(paramContext, i);
        }
        return;
      }
      if (Objects.equals(paramIntent.getAction(), "com.farsunset.hoxin.ACTION_UPLOAD_PROGRESS"))
      {
        paramContext = paramIntent.getStringExtra("ATTR_TAG");
        paramContext = ChatRecordListView.this.findViewWithTag(paramContext);
        float f = paramIntent.getFloatExtra("ATTR_PROGRESS", 0.0F);
        if ((paramContext instanceof d0)) {
          ((d0)paramContext).a(f);
        }
      }
      if (Objects.equals(paramIntent.getAction(), "com.farsunset.hoxin.ACTION_QUOTE_MESSAGE"))
      {
        paramContext = (Message)paramIntent.getSerializableExtra(Message.NAME);
        ChatRecordListView.B1(ChatRecordListView.this).l(paramContext);
      }
      if (Objects.equals(paramIntent.getAction(), "com.farsunset.hoxin.ACTION_WINDOW_ADD_MESSAGE"))
      {
        paramContext = (Message)paramIntent.getSerializableExtra(Message.NAME);
        ChatRecordListView.C1(ChatRecordListView.this).E(paramContext);
      }
      if (Objects.equals(paramIntent.getAction(), "com.farsunset.hoxin.ACTION_REDO_MESSAGE"))
      {
        paramContext = (Message)paramIntent.getSerializableExtra(Message.NAME);
        ChatRecordListView.D1(ChatRecordListView.this).d0(paramContext);
      }
      if (Objects.equals(paramIntent.getAction(), "com.farsunset.hoxin.ACTION_OPEN_GALLERY")) {
        ChatRecordListView.E1(ChatRecordListView.this).L((Message)paramIntent.getSerializableExtra(Message.NAME));
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ChatRecordListView
 * JD-Core Version:    0.7.0.1
 */