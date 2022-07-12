package com.farsunset.hoxin.message.function.parser;

import android.app.Application;
import android.content.Intent;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.GroupChatActivity;
import p4.a;
import p4.b;

public class Action310MessageParser
  extends MessageParser
{
  public String getDescription(Message paramMessage)
  {
    paramMessage = b.l(paramMessage.sender, Long.valueOf(Long.parseLong(paramMessage.extra)));
    return HoxinApplication.h().getString(2131690084, new Object[] { paramMessage });
  }
  
  public Intent getNotificationIntent()
  {
    return new Intent(HoxinApplication.h(), GroupChatActivity.class);
  }
  
  public int getNotificationPriority(Message paramMessage)
  {
    return -1;
  }
  
  public MessageSource getSource(Message paramMessage)
  {
    return a.h(paramMessage.sender);
  }
  
  public String getTitle(MessageSource paramMessageSource, Message paramMessage)
  {
    return null;
  }
  
  public boolean isBadgeAddable()
  {
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.parser.Action310MessageParser
 * JD-Core Version:    0.7.0.1
 */