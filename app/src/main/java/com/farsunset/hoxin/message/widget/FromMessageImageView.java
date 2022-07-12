package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.message.entity.Message;
import u3.l;

public class FromMessageImageView
  extends BaseFromMessageView<ChatImageView>
{
  public FromMessageImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    Object localObject = (CloudImage)l.s0(this.f.content, CloudImage.class);
    ((ChatImageView)this.e).i((CloudImage)localObject, this.f);
    localObject = this.e;
    ((ChatImageView)localObject).setOnClickListener((View.OnClickListener)localObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.FromMessageImageView
 * JD-Core Version:    0.7.0.1
 */