package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.farsunset.hoxin.common.widget.CircleProgressView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatFile;
import o3.b;
import u3.c0;
import u3.l;

public class ToMessageFileView
  extends BaseToMessageView<ChatFileView>
{
  private CircleProgressView h;
  
  public ToMessageFileView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void f()
  {
    this.h.setVisibility(8);
    ((ChatFileView)this.f).setSendProgressView(this.h);
    ((ChatFileView)this.f).b(this.e);
    View localView = this.f;
    ((ChatFileView)localView).setOnClickListener((View.OnClickListener)localView);
    i(2);
  }
  
  protected void j()
  {
    ChatFile localChatFile = (ChatFile)l.s0(this.e.content, ChatFile.class);
    c0.e(b.f, localChatFile.file);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.h = ((CircleProgressView)findViewById(2131230885));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ToMessageFileView
 * JD-Core Version:    0.7.0.1
 */