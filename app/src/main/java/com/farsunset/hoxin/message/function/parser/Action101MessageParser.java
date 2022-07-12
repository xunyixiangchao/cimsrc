package com.farsunset.hoxin.message.function.parser;

import android.app.Application;
import android.content.Intent;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.FriendChatActivity;
import i4.a;

public class Action101MessageParser
  extends MessageParser
{
  public String getDescription(Message paramMessage)
  {
    return HoxinApplication.h().getString(2131690083);
  }
  
  public Intent getNotificationIntent()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(HoxinApplication.h(), FriendChatActivity.class);
    return localIntent;
  }
  
  public MessageSource getSource(Message paramMessage)
  {
    return a.l(paramMessage.sender.longValue());
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
 * Qualified Name:     com.farsunset.hoxin.message.function.parser.Action101MessageParser
 * JD-Core Version:    0.7.0.1
 */