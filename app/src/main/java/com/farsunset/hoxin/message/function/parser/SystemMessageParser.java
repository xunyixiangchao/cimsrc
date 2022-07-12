package com.farsunset.hoxin.message.function.parser;

import android.app.Application;
import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.model.SystemMessage;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.SystemMessageActivity;
import d5.i;

public class SystemMessageParser
  extends MessageParser
{
  public void displayWindowView(i parami, Message paramMessage)
  {
    parami.x.setText(paramMessage.content.trim());
    parami.x.setVisibility(0);
    parami.w.setImageResource(2131165652);
  }
  
  public String getDescription(Message paramMessage)
  {
    return paramMessage.content;
  }
  
  public Intent getNotificationIntent()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(HoxinApplication.h(), SystemMessageActivity.class);
    return localIntent;
  }
  
  public MessageSource getSource(Message paramMessage)
  {
    return new SystemMessage();
  }
  
  public String getTitle(MessageSource paramMessageSource, Message paramMessage)
  {
    return HoxinApplication.h().getString(2131689557);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.parser.SystemMessageParser
 * JD-Core Version:    0.7.0.1
 */