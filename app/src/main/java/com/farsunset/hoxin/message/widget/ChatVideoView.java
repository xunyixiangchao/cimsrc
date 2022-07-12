package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.widget.CircleProgressView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.Message;
import java.io.File;
import s3.d0;
import u3.a0;
import u3.b0;
import u3.l;

public class ChatVideoView
  extends CardView
  implements View.OnClickListener, d0
{
  private TextView j;
  private WebImageView k;
  private Message l;
  private CircleProgressView m;
  
  public ChatVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a(float paramFloat)
  {
    this.m.setProgress((int)paramFloat);
    if (paramFloat >= 100.0F)
    {
      this.m.setVisibility(8);
      return;
    }
    if (paramFloat > 0.0F) {
      this.m.setVisibility(0);
    }
  }
  
  public void h(CloudVideo paramCloudVideo, Message paramMessage)
  {
    this.l = paramMessage;
    int i;
    if (paramCloudVideo.mode == 0)
    {
      this.k.getLayoutParams().width = getContext().getResources().getDimensionPixelOffset(2131099738);
      paramMessage = this.k.getLayoutParams();
      i = getContext().getResources().getDimensionPixelOffset(2131099739);
    }
    else
    {
      this.k.getLayoutParams().width = getContext().getResources().getDimensionPixelOffset(2131099739);
      paramMessage = this.k.getLayoutParams();
      i = getContext().getResources().getDimensionPixelOffset(2131099738);
    }
    paramMessage.height = i;
    this.k.requestLayout();
    paramMessage = a0.g(paramCloudVideo.image);
    if (paramMessage.exists())
    {
      this.k.l(paramMessage);
    }
    else
    {
      paramMessage = b0.f(paramCloudVideo.bucket, paramCloudVideo.image);
      this.k.p(paramMessage, 2131165336);
    }
    this.j.setText(getContext().getString(2131689896, new Object[] { Integer.valueOf((int)paramCloudVideo.duration) }));
  }
  
  public void onClick(View paramView)
  {
    paramView = (CloudVideo)l.s0(this.l.content, CloudVideo.class);
    HoxinApplication.h().C(getContext(), paramView, this);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.k = ((WebImageView)findViewById(2131231072));
    this.j = ((TextView)findViewById(2131230993));
  }
  
  public void setSendProgressView(CircleProgressView paramCircleProgressView)
  {
    this.m = paramCircleProgressView;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ChatVideoView
 * JD-Core Version:    0.7.0.1
 */