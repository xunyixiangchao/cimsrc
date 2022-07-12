package com.farsunset.hoxin.message.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatProfile;
import com.farsunset.hoxin.micro.api.response.MicroServerResult;
import com.farsunset.hoxin.micro.ui.MicroServerDetailedActivity;
import r3.c;
import s3.e;
import u3.b0;
import u3.l;
import v5.b;

public class ChatProfileView
  extends FrameLayout
  implements View.OnClickListener, e<MicroServerResult>
{
  private TextView a;
  private WebImageView b;
  private TextView c;
  private ChatProfile d;
  private c e;
  
  public ChatProfileView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void b()
  {
    this.c.setText(2131689817);
    this.b.o(b0.l(this.d.id.longValue()));
    setOnClickListener(new a(this));
  }
  
  private void c()
  {
    this.c.setText(2131689781);
    this.b.o(b0.j(this.d.id.longValue()));
    setOnClickListener(this);
  }
  
  public void d(Message paramMessage)
  {
    ChatProfile localChatProfile = (ChatProfile)l.s0(paramMessage.content, ChatProfile.class);
    this.d = localChatProfile;
    this.a.setText(localChatProfile.name);
    if (paramMessage.isProfileFormat())
    {
      b();
      return;
    }
    c();
  }
  
  public void f(MicroServerResult paramMicroServerResult)
  {
    this.e.hide();
    Intent localIntent = new Intent(getContext(), MicroServerDetailedActivity.class);
    localIntent.putExtra(MessageSource.NAME, paramMicroServerResult.data);
    getContext().startActivity(localIntent);
  }
  
  public void onClick(View paramView)
  {
    paramView = x5.a.f(this.d.id.longValue());
    if (paramView != null)
    {
      Intent localIntent = new Intent(getContext(), MicroServerDetailedActivity.class);
      localIntent.putExtra(MessageSource.NAME, paramView);
      getContext().startActivity(localIntent);
      return;
    }
    if (this.e == null)
    {
      paramView = new c(getContext());
      this.e = paramView;
      paramView.setCancelable(false);
      this.e.setCanceledOnTouchOutside(false);
      this.e.e(2131690073);
    }
    this.e.show();
    b.c(this.d.id.longValue(), this);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((TextView)findViewById(2131231301));
    this.c = ((TextView)findViewById(2131231364));
    this.b = ((WebImageView)findViewById(2131231363));
  }
  
  public void onHttpException(Exception paramException)
  {
    this.e.hide();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ChatProfileView
 * JD-Core Version:    0.7.0.1
 */