package com.farsunset.hoxin.message.function.parser;

import android.app.Application;
import android.content.Intent;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.FriendChatActivity;
import i4.a;

public class Action106MessageParser
  extends MessageParser
{
  public String getDescription(Message paramMessage)
  {
    return HoxinApplication.h().getString(2131689502);
  }
  
  public String getNotificationChannelId(Message paramMessage)
  {
    return "IMPORTANCE_HIGH_NOTIFICATION";
  }
  
  public String getNotificationContent(ChatSession paramChatSession, Message paramMessage)
  {
    return getDescription(paramMessage);
  }
  
  public Intent getNotificationIntent()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(HoxinApplication.h(), FriendChatActivity.class);
    return localIntent;
  }
  
  public int getNotificationPriority(Message paramMessage)
  {
    return 2;
  }
  
  public MessageSource getSource(Message paramMessage)
  {
    return a.l(paramMessage.sender.longValue());
  }
  
  public String getTitle(MessageSource paramMessageSource, Message paramMessage)
  {
    return paramMessageSource.getName();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.parser.Action106MessageParser
 * JD-Core Version:    0.7.0.1
 */