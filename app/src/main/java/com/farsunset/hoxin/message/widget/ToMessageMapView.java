package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatMap;
import o3.b;
import u3.c0;
import u3.l;

public class ToMessageMapView
  extends BaseToMessageView<ChatMapView>
{
  public ToMessageMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void f()
  {
    ((ChatMapView)this.f).i(this.e);
    View localView = this.f;
    ((ChatMapView)localView).setOnClickListener((View.OnClickListener)localView);
  }
  
  protected void j()
  {
    ChatMap localChatMap = (ChatMap)l.s0(this.e.content, ChatMap.class);
    c0.e(b.f, localChatMap.image);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ToMessageMapView
 * JD-Core Version:    0.7.0.1
 */