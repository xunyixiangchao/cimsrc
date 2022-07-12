package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.widget.AutoGridLayoutView;
import com.farsunset.hoxin.moment.entity.Moment;
import java.util.List;
import u3.l;

public class PersonalMomentMultiplePhotoView
  extends PersonalMomentView
{
  public AutoGridLayoutView d;
  public TextView e;
  
  public PersonalMomentMultiplePhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private MomentImageView b(int paramInt)
  {
    if (this.d.getChildCount() >= paramInt + 1) {
      return (MomentImageView)this.d.getChildAt(paramInt);
    }
    MomentImageView localMomentImageView = new MomentImageView(getContext());
    localMomentImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.d.addView(localMomentImageView);
    return localMomentImageView;
  }
  
  public void a(Moment paramMoment)
  {
    super.a(paramMoment);
    List localList = l.u0(paramMoment.content, CloudImage.class);
    this.e.setText(l.J(2131689728, new Object[] { Integer.valueOf(localList.size()) }));
    int j = Math.min(localList.size(), this.d.getColumnCount() * this.d.getRowCount());
    int i = 0;
    while (i < j)
    {
      MomentImageView localMomentImageView = b(i);
      localMomentImageView.setVisibility(0);
      localMomentImageView.t(paramMoment, (CloudImage)localList.get(i));
      i += 1;
    }
    i = localList.size();
    while (i < this.d.getChildCount())
    {
      this.d.getChildAt(i).setVisibility(8);
      i += 1;
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((AutoGridLayoutView)findViewById(2131231031));
    this.e = ((TextView)findViewById(2131230917));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.PersonalMomentMultiplePhotoView
 * JD-Core Version:    0.7.0.1
 */