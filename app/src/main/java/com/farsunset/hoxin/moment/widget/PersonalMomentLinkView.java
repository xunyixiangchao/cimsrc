package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.model.Link;
import com.farsunset.hoxin.moment.entity.Moment;
import k6.a;
import u3.l;

public class PersonalMomentLinkView
  extends PersonalMomentView
{
  public View d;
  public TextView e;
  
  public PersonalMomentLinkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Moment paramMoment)
  {
    super.a(paramMoment);
    paramMoment = (Link)l.s0(paramMoment.content, Link.class);
    this.d.setOnClickListener(new a(paramMoment));
    this.e.setText(paramMoment.title);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.e = ((TextView)findViewById(2131231139));
    this.d = findViewById(2131231138);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.PersonalMomentLinkView
 * JD-Core Version:    0.7.0.1
 */