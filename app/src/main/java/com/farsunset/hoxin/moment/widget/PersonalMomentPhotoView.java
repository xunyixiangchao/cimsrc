package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.moment.entity.Moment;
import u3.l;

public class PersonalMomentPhotoView
  extends PersonalMomentView
{
  public MomentImageView d;
  
  public PersonalMomentPhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Moment paramMoment)
  {
    super.a(paramMoment);
    CloudImage localCloudImage = (CloudImage)l.s0(paramMoment.content, CloudImage.class);
    this.d.t(paramMoment, localCloudImage);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((MomentImageView)findViewById(2131231072));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.PersonalMomentPhotoView
 * JD-Core Version:    0.7.0.1
 */