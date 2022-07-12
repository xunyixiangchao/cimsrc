package com.farsunset.hoxin.micro.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.model.Link;
import com.farsunset.hoxin.common.ui.WebViewActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.MessageForwardActivity;
import u3.l;
import u3.l0;

public class MicroServerFromLinkView
  extends BaseMicroServerFromView
  implements View.OnClickListener
{
  private Link e;
  private TextView f;
  private TextView g;
  private WebImageView h;
  
  public MicroServerFromLinkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    setOnLongClickListener(this);
    setOnTouchListener(this);
    Link localLink = (Link)l.s0(this.b.content, Link.class);
    this.e = localLink;
    this.f.setText(localLink.title);
    this.g.setText(this.e.content);
    this.h.p(this.e.image, 2131034649);
    setOnClickListener(this);
  }
  
  public void e(int paramInt, Message paramMessage)
  {
    super.e(paramInt, paramMessage);
    if (paramInt == 2131231209)
    {
      paramMessage = l0.a(paramMessage);
      paramMessage.content = this.e.toString();
      paramMessage.format = 0;
      Intent localIntent = new Intent(getContext(), MessageForwardActivity.class);
      localIntent.putExtra(Message.NAME, paramMessage);
      getContext().startActivity(localIntent);
    }
  }
  
  public Object getTag()
  {
    return this.f.getTag(2131231150);
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(getContext(), WebViewActivity.class);
    paramView.setData(Uri.parse(this.e.link));
    getContext().startActivity(paramView);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = ((TextView)findViewById(2131231557));
    this.g = ((TextView)findViewById(2131230938));
    this.h = ((WebImageView)findViewById(2131230825));
  }
  
  public void setTag(Object paramObject)
  {
    this.f.setTag(2131231150, paramObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.micro.widget.MicroServerFromLinkView
 * JD-Core Version:    0.7.0.1
 */