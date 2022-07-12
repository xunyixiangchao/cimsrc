package com.farsunset.hoxin.message.function.parser;

import android.app.Application;
import android.content.Intent;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.FriendChatActivity;
import i3.e;
import i4.a;
import java.util.Objects;

public class UserMessageParser
  extends MessageParser
{
  public String getDescription(Message paramMessage)
  {
    if (paramMessage.state.byteValue() == 6) {
      paramMessage = HoxinApplication.h();
    }
    for (int i = 2131690088;; i = 2131690083)
    {
      return paramMessage.getString(i);
      if (paramMessage.state.byteValue() != 13) {
        break;
      }
      paramMessage = HoxinApplication.h();
    }
    return super.getDescription(paramMessage);
  }
  
  public Intent getNotificationIntent()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(HoxinApplication.h(), FriendChatActivity.class);
    return localIntent;
  }
  
  public MessageSource getSource(Message paramMessage)
  {
    if (Objects.equals(paramMessage.sender, e.o())) {}
    for (paramMessage = paramMessage.receiver;; paramMessage = paramMessage.sender) {
      return a.l(paramMessage.longValue());
    }
  }
  
  public String getTitle(MessageSource paramMessageSource, Message paramMessage)
  {
    return paramMessageSource.getName();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.parser.UserMessageParser
 * JD-Core Version:    0.7.0.1
 */