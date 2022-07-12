package com.farsunset.hoxin.message.function.parser;

import android.app.Application;
import android.content.Intent;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MapAddress;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.home.ui.HomeActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatCall;
import com.farsunset.hoxin.message.model.ChatEmoticon;
import com.farsunset.hoxin.message.model.ChatFile;
import com.farsunset.hoxin.message.model.ChatLink;
import com.farsunset.hoxin.message.model.ChatMap;
import com.farsunset.hoxin.message.model.ChatProfile;
import d5.i;
import i3.e;
import j5.a;
import u3.l;

public abstract class MessageParser
{
  public void displayWindowView(i parami, Message paramMessage) {}
  
  public String getDescription(Message paramMessage)
  {
    int i = paramMessage.format;
    if (1 == i) {
      return HoxinApplication.h().getString(2131689762);
    }
    if (6 == i)
    {
      paramMessage = (ChatLink)l.s0(paramMessage.content, ChatLink.class);
      return HoxinApplication.h().getString(2131689763, new Object[] { paramMessage.title });
    }
    if (4 == i)
    {
      paramMessage = (ChatFile)l.s0(paramMessage.content, ChatFile.class);
      return HoxinApplication.h().getString(2131689761, new Object[] { paramMessage.name });
    }
    if (2 == i) {
      return HoxinApplication.h().getString(2131689771);
    }
    if (5 == i)
    {
      paramMessage = (ChatMap)l.s0(paramMessage.content, ChatMap.class);
      return HoxinApplication.h().getString(2131689764, new Object[] { paramMessage.name });
    }
    if (3 == i) {
      return HoxinApplication.h().getString(2131689770);
    }
    if (14 == i)
    {
      paramMessage = (ChatProfile)l.s0(paramMessage.content, ChatProfile.class);
      return HoxinApplication.h().getString(2131689767, new Object[] { paramMessage.name });
    }
    if (18 == i)
    {
      paramMessage = (ChatProfile)l.s0(paramMessage.content, ChatProfile.class);
      return HoxinApplication.h().getString(2131689765, new Object[] { paramMessage.name });
    }
    if (15 == i)
    {
      paramMessage = (ChatEmoticon)l.s0(paramMessage.content, ChatEmoticon.class);
      return HoxinApplication.h().getString(2131689760, new Object[] { paramMessage.name });
    }
    if (16 == i)
    {
      i = ((ChatCall)l.s0(paramMessage.content, ChatCall.class)).state;
      if (i == 2) {
        return HoxinApplication.h().getString(2131689753);
      }
      if (i == 1) {
        return HoxinApplication.h().getString(2131689751);
      }
      if (i == 4) {
        return HoxinApplication.h().getString(2131689754);
      }
      return HoxinApplication.h().getString(2131689752);
    }
    if (17 == i)
    {
      i = ((ChatCall)l.s0(paramMessage.content, ChatCall.class)).state;
      if (i == 2) {
        return HoxinApplication.h().getString(2131689758);
      }
      if (i == 1) {
        return HoxinApplication.h().getString(2131689756);
      }
      if (i == 4) {
        return HoxinApplication.h().getString(2131689759);
      }
      return HoxinApplication.h().getString(2131689757);
    }
    if (e.o().longValue() == paramMessage.sender.longValue()) {
      return HoxinApplication.h().getString(2131689766, new Object[] { paramMessage.content });
    }
    return paramMessage.content;
  }
  
  public String getNotificationChannelId(Message paramMessage)
  {
    return "NEW_MESSAGE_NOTIFICATION";
  }
  
  public String getNotificationContent(ChatSession paramChatSession, Message paramMessage)
  {
    return l.J(2131689566, new Object[] { Long.valueOf(a.p(paramChatSession.id)), getDescription(paramMessage) });
  }
  
  public Intent getNotificationIntent()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(HoxinApplication.h(), HomeActivity.class);
    return localIntent;
  }
  
  public int getNotificationPriority(Message paramMessage)
  {
    return 0;
  }
  
  public abstract MessageSource getSource(Message paramMessage);
  
  public abstract String getTitle(MessageSource paramMessageSource, Message paramMessage);
  
  public boolean isBadgeAddable()
  {
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.parser.MessageParser
 * JD-Core Version:    0.7.0.1
 */