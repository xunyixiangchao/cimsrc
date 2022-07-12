package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.moment.entity.Moment;
import java.util.Iterator;
import java.util.List;
import o3.b;
import u3.l;

public class MomentImageView
  extends WebImageView
  implements View.OnClickListener
{
  private CloudImage t;
  
  public MomentImageView(Context paramContext)
  {
    super(paramContext);
    setOnClickListener(this);
  }
  
  public MomentImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnClickListener(this);
  }
  
  private List<CloudImage> v(Moment paramMoment)
  {
    paramMoment = l.u0(paramMoment.content, CloudImage.class);
    Iterator localIterator = paramMoment.iterator();
    while (localIterator.hasNext()) {
      ((CloudImage)localIterator.next()).bucket = b.g.a();
    }
    return paramMoment;
  }
  
  public void onClick(View paramView)
  {
    paramView = (Moment)paramView.getTag(2131231522);
    this.t.bucket = b.g.a();
    if (paramView.type == 4)
    {
      List localList = v(paramView);
      int i = localList.indexOf(this.t);
      View localView = ((ViewGroup)getParent()).getChildAt(i);
      HoxinApplication.h().x(getContext(), localList, i, localView);
    }
    if (paramView.type == 0) {
      HoxinApplication.h().z(getContext(), this.t, this);
    }
  }
  
  public void t(Moment paramMoment, CloudImage paramCloudImage)
  {
    setTag(2131231522, paramMoment);
    this.t = paramCloudImage;
    paramCloudImage.bucket = b.g.a();
    setTag(l.w(paramCloudImage));
    p(l.w(paramCloudImage), 2131034649);
  }
  
  public void u(Moment paramMoment, CloudImage paramCloudImage)
  {
    setTag(2131231522, paramMoment);
    this.t = paramCloudImage;
    paramCloudImage.bucket = b.g.a();
    int i = paramCloudImage.ow;
    int j = paramCloudImage.oh;
    int k = getContext().getResources().getDimensionPixelOffset(2131099745);
    if ((i < k) && (j < k))
    {
      getLayoutParams().width = i;
      getLayoutParams().height = j;
    }
    else
    {
      paramMoment = getLayoutParams();
      if (i >= j)
      {
        paramMoment.width = k;
        getLayoutParams().height = (k * j / i);
      }
      else
      {
        paramMoment.height = k;
        getLayoutParams().width = (k * i / j);
      }
    }
    p(l.v(paramCloudImage), 2131034649);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.MomentImageView
 * JD-Core Version:    0.7.0.1
 */