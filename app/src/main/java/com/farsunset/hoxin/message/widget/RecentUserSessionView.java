package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.farsunset.hoxin.common.widget.BadgeLogoView;
import com.farsunset.hoxin.message.entity.ChatSession;
import o3.b;

public class RecentUserSessionView
  extends RecentSessionView
{
  public RecentUserSessionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(ChatSession paramChatSession)
  {
    super.a(paramChatSession);
    b(paramChatSession.state);
    this.a.b(b.b, paramChatSession.sourceId);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.RecentUserSessionView
 * JD-Core Version:    0.7.0.1
 */