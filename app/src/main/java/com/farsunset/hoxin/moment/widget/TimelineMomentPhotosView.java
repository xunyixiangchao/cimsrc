package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.widget.AutoGridLayoutView;
import com.farsunset.hoxin.moment.entity.Moment;
import j6.a;
import java.util.List;
import u3.l;

public class TimelineMomentPhotosView
  extends TimelineMomentView
{
  private AutoGridLayoutView n;
  
  public TimelineMomentPhotosView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private MomentImageView j(int paramInt)
  {
    if (this.n.getChildCount() >= paramInt + 1) {
      return (MomentImageView)this.n.getChildAt(paramInt);
    }
    MomentImageView localMomentImageView = new MomentImageView(getContext());
    localMomentImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.n.addView(localMomentImageView);
    return localMomentImageView;
  }
  
  public void g(Moment paramMoment, User paramUser, a parama)
  {
    super.g(paramMoment, paramUser, parama);
    paramUser = l.u0(paramMoment.content, CloudImage.class);
    int i = 0;
    while (i < paramUser.size())
    {
      parama = j(i);
      parama.setVisibility(0);
      parama.t(paramMoment, (CloudImage)paramUser.get(i));
      i += 1;
    }
    i = paramUser.size();
    while (i < this.n.getChildCount())
    {
      this.n.getChildAt(i).setVisibility(8);
      i += 1;
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.n = ((AutoGridLayoutView)findViewById(2131231031));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.TimelineMomentPhotosView
 * JD-Core Version:    0.7.0.1
 */