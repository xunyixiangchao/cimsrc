package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.widget.AutoGridLayoutView;
import com.farsunset.hoxin.moment.entity.Moment;
import java.util.List;
import u3.l;

public class DetailedMomentPhotosView
  extends DetailedMomentView
{
  private AutoGridLayoutView l;
  
  public DetailedMomentPhotosView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void e(Moment paramMoment)
  {
    super.e(paramMoment);
    List localList = l.u0(paramMoment.content, CloudImage.class);
    int i = 0;
    while (i < localList.size())
    {
      MomentImageView localMomentImageView = new MomentImageView(getContext());
      localMomentImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.l.addView(localMomentImageView);
      localMomentImageView.t(paramMoment, (CloudImage)localList.get(i));
      i += 1;
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.l = ((AutoGridLayoutView)findViewById(2131231031));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.DetailedMomentPhotosView
 * JD-Core Version:    0.7.0.1
 */