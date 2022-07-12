package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.moment.entity.Moment;
import j6.a;
import u3.l;

public class TimelineMomentPhotoView
  extends TimelineMomentView
{
  private MomentImageView n;
  
  public TimelineMomentPhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void g(Moment paramMoment, User paramUser, a parama)
  {
    super.g(paramMoment, paramUser, parama);
    paramUser = (CloudImage)l.s0(paramMoment.content, CloudImage.class);
    this.n.u(paramMoment, paramUser);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.n = ((MomentImageView)findViewById(2131231444));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.TimelineMomentPhotoView
 * JD-Core Version:    0.7.0.1
 */