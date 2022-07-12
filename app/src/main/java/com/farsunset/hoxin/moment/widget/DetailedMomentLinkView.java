package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.model.Link;
import com.farsunset.hoxin.common.ui.WebViewActivity;
import com.farsunset.hoxin.moment.entity.Moment;
import u3.l;

public class DetailedMomentLinkView
  extends DetailedMomentView
{
  private TextView l;
  private String m;
  
  public DetailedMomentLinkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void e(Moment paramMoment)
  {
    super.e(paramMoment);
    paramMoment = (Link)l.s0(paramMoment.content, Link.class);
    this.m = paramMoment.link;
    this.l.setText(paramMoment.title);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView == this.l.getParent())
    {
      paramView = new Intent(getContext(), WebViewActivity.class);
      paramView.setData(Uri.parse(this.m));
      getContext().startActivity(paramView);
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    TextView localTextView = (TextView)findViewById(2131231139);
    this.l = localTextView;
    ((View)localTextView.getParent()).setOnClickListener(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.DetailedMomentLinkView
 * JD-Core Version:    0.7.0.1
 */