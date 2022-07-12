package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.api.response.StringResult;
import com.farsunset.hoxin.message.entity.Message;
import f5.b;
import p3.a;
import s3.e;

public class MessageTranslateView
  extends RelativeLayout
  implements e<StringResult>
{
  private TextView a;
  private TextView b;
  private ProgressBar c;
  
  public MessageTranslateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    setVisibility(8);
  }
  
  public void b()
  {
    this.c.setVisibility(8);
  }
  
  public void c(StringResult paramStringResult)
  {
    e(paramStringResult.data);
    Long localLong = (Long)getTag(2131231589);
    if (localLong != null) {
      a.c(localLong.longValue(), paramStringResult.data);
    }
  }
  
  public void d()
  {
    this.c.setVisibility(0);
  }
  
  public void e(String paramString)
  {
    setVisibility(0);
    this.b.setVisibility(0);
    this.a.setVisibility(0);
    this.a.setText(paramString);
    b();
  }
  
  public void f(Message paramMessage)
  {
    setVisibility(0);
    setTag(2131231589, Long.valueOf(paramMessage.id));
    this.b.setVisibility(8);
    this.a.setVisibility(8);
    d();
    b.b(paramMessage.content, this);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((TextView)findViewById(2131231588));
    this.b = ((TextView)findViewById(2131231586));
    this.c = ((ProgressBar)findViewById(2131231587));
  }
  
  public void onHttpException(Exception paramException)
  {
    a();
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.a.setMaxWidth(paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.MessageTranslateView
 * JD-Core Version:    0.7.0.1
 */