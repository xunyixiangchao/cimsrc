package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.moment.entity.Moment;
import java.io.File;
import u3.a0;
import u3.b0;
import u3.l;

public class PersonalMomentVideoView
  extends PersonalMomentView
{
  public WebImageView d;
  
  public PersonalMomentVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Moment paramMoment)
  {
    super.a(paramMoment);
    paramMoment = (CloudVideo)l.s0(paramMoment.content, CloudVideo.class);
    File localFile = a0.g(paramMoment.image);
    if (localFile.exists())
    {
      this.d.m(localFile, 2131034649);
      return;
    }
    paramMoment = b0.h(paramMoment.image);
    this.d.p(paramMoment, 2131034649);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((WebImageView)findViewById(2131231552));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.PersonalMomentVideoView
 * JD-Core Version:    0.7.0.1
 */