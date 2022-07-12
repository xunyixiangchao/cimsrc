package com.farsunset.hoxin.moment.widget;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.moment.entity.Moment;
import com.farsunset.hoxin.moment.ui.MomentDetailedActivity;
import u3.l;

public class PersonalMomentView
  extends LinearLayout
  implements View.OnClickListener
{
  public TextView a;
  public TextView b;
  public TextView c;
  
  public PersonalMomentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Moment paramMoment)
  {
    TextView localTextView = this.a;
    int i;
    if (l.c0(paramMoment.text)) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
    this.a.setText(l.W(paramMoment.text));
    this.c.setText(HoxinApplication.h().getString(2131689891, new Object[] { l.E(paramMoment.createTime.longValue()) }));
    this.b.setText(l.y(paramMoment.createTime.longValue()));
    setOnClickListener(this);
    setTag(paramMoment);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(paramView.getContext(), MomentDetailedActivity.class);
    localIntent.putExtra(Moment.class.getName(), (Moment)paramView.getTag());
    paramView.getContext().startActivity(localIntent);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((TextView)findViewById(2131230928));
    this.c = ((TextView)findViewById(2131231265));
    this.a = ((TextView)findViewById(2131231528));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.PersonalMomentView
 * JD-Core Version:    0.7.0.1
 */