package com.farsunset.hoxin.message.function.parser;

import android.app.Application;
import android.content.Intent;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.friend.ui.NewFriendActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import i4.a;

public class Action105MessageParser
  extends MessageParser
{
  public String getDescription(Message paramMessage)
  {
    paramMessage = a.k(paramMessage.sender.longValue());
    return HoxinApplication.h().getString(2131689500, new Object[] { paramMessage });
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
    localIntent.setClass(HoxinApplication.h(), NewFriendActivity.class);
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
    return HoxinApplication.h().getString(2131689501);
  }
  
  public boolean isBadgeAddable()
  {
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.parser.Action105MessageParser
 * JD-Core Version:    0.7.0.1
 */