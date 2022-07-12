package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.message.entity.Message;
import u3.l;

public class FromMessageVideoView
  extends BaseFromMessageView<ChatVideoView>
{
  public FromMessageVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    Object localObject = (CloudVideo)l.s0(this.f.content, CloudVideo.class);
    ((ChatVideoView)this.e).h((CloudVideo)localObject, this.f);
    localObject = this.e;
    ((ChatVideoView)localObject).setOnClickListener((View.OnClickListener)localObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.FromMessageVideoView
 * JD-Core Version:    0.7.0.1
 */