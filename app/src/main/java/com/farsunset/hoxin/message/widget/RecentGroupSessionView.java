package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.widget.BadgeLogoView;
import com.farsunset.hoxin.message.entity.ChatSession;
import o3.b;
import u3.d;
import u3.l;

public class RecentGroupSessionView
  extends RecentSessionView
{
  public ImageView f;
  
  public RecentGroupSessionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(ChatSession paramChatSession)
  {
    super.a(paramChatSession);
    b(paramChatSession.state);
    this.a.b(b.d, paramChatSession.sourceId);
    if (d.s(Long.valueOf(paramChatSession.sourceId)))
    {
      this.f.setVisibility(0);
      int i = d.l(paramChatSession.sourceId);
      if (i > 0)
      {
        this.a.a();
        this.d.setText(l.J(2131689824, new Object[] { Integer.valueOf(i), paramChatSession.message }));
      }
    }
    else
    {
      this.f.setVisibility(8);
    }
    if (d.o(paramChatSession.sourceId))
    {
      paramChatSession = l.J(2131689823, new Object[] { l.X(paramChatSession.message) });
      this.d.setText(Html.fromHtml(paramChatSession));
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = ((ImageView)findViewById(2131231062));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.RecentGroupSessionView
 * JD-Core Version:    0.7.0.1
 */