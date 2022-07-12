package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.widget.CircleProgressView;
import com.farsunset.hoxin.message.entity.Message;
import o3.b;
import u3.c0;
import u3.l;

public class ToMessageVideoView
  extends BaseToMessageView<ChatVideoView>
{
  private CircleProgressView h;
  
  public ToMessageVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void f()
  {
    this.h.setVisibility(8);
    CloudVideo localCloudVideo = (CloudVideo)l.s0(this.e.content, CloudVideo.class);
    ((ChatVideoView)this.f).h(localCloudVideo, this.e);
    View localView = this.f;
    ((ChatVideoView)localView).setOnClickListener((View.OnClickListener)localView);
    ((ChatVideoView)this.f).setTag(localCloudVideo.video);
    ((ChatVideoView)this.f).setSendProgressView(this.h);
  }
  
  protected void j()
  {
    CloudVideo localCloudVideo = (CloudVideo)l.s0(this.e.content, CloudVideo.class);
    b localb = b.f;
    c0.e(localb, localCloudVideo.image);
    c0.e(localb, localCloudVideo.video);
  }
  
  public void l()
  {
    this.h.setVisibility(8);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.h = ((CircleProgressView)findViewById(2131230885));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ToMessageVideoView
 * JD-Core Version:    0.7.0.1
 */