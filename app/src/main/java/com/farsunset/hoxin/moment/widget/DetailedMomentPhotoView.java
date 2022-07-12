package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.moment.entity.Moment;
import u3.l;

public class DetailedMomentPhotoView
  extends DetailedMomentView
{
  private MomentImageView l;
  
  public DetailedMomentPhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void e(Moment paramMoment)
  {
    super.e(paramMoment);
    CloudImage localCloudImage = (CloudImage)l.s0(paramMoment.content, CloudImage.class);
    this.l.u(paramMoment, localCloudImage);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.l = ((MomentImageView)findViewById(2131231444));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.DetailedMomentPhotoView
 * JD-Core Version:    0.7.0.1
 */