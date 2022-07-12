package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.model.Link;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.ui.WebViewActivity;
import com.farsunset.hoxin.moment.entity.Moment;
import j6.a;
import u3.l;

public class TimelineMomentLinkView
  extends TimelineMomentView
{
  private TextView n;
  private String o;
  
  public TimelineMomentLinkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void g(Moment paramMoment, User paramUser, a parama)
  {
    super.g(paramMoment, paramUser, parama);
    paramMoment = (Link)l.s0(paramMoment.content, Link.class);
    this.o = paramMoment.link;
    this.n.setText(paramMoment.title);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView == this.n.getParent())
    {
      paramView = new Intent(getContext(), WebViewActivity.class);
      paramView.setData(Uri.parse(this.o));
      getContext().startActivity(paramView);
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    TextView localTextView = (TextView)findViewById(2131231139);
    this.n = localTextView;
    ((View)localTextView.getParent()).setOnClickListener(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.TimelineMomentLinkView
 * JD-Core Version:    0.7.0.1
 */