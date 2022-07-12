package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.widget.BadgeLogoView;
import com.farsunset.hoxin.message.entity.ChatSession;
import u3.l;
import u3.o;

public abstract class RecentSessionView
  extends RelativeLayout
{
  protected BadgeLogoView a;
  protected TextView b;
  protected TextView c;
  protected EmoticonTextView d;
  protected ImageView e;
  
  public RecentSessionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(ChatSession paramChatSession)
  {
    setTag(paramChatSession);
    this.c.setText(paramChatSession.name);
    this.b.setText(l.V(paramChatSession.timestamp));
    this.a.setTag(Integer.valueOf(2131230721));
    o.d(this.a, paramChatSession.badge);
    this.d.setText(l.t(paramChatSession.message));
  }
  
  public void b(int paramInt)
  {
    int i = 0;
    ImageView localImageView;
    if (1 == paramInt)
    {
      localImageView = this.e;
      paramInt = 2131165601;
      localImageView.setImageResource(paramInt);
      localImageView = this.e;
    }
    for (paramInt = i;; paramInt = 8)
    {
      localImageView.setVisibility(paramInt);
      return;
      if (2 == paramInt)
      {
        localImageView = this.e;
        paramInt = 2131165600;
        break;
      }
      localImageView = this.e;
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.e = ((ImageView)findViewById(2131231067));
    this.c = ((TextView)findViewById(2131231301));
    this.d = ((EmoticonTextView)findViewById(2131231362));
    this.b = ((TextView)findViewById(2131231553));
    this.a = ((BadgeLogoView)findViewById(2131231151));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.RecentSessionView
 * JD-Core Version:    0.7.0.1
 */