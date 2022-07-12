package com.farsunset.hoxin.message.function.parser;

import android.app.Application;
import android.content.Intent;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.GroupChatActivity;
import i3.e;
import i5.c;
import java.util.List;
import java.util.Set;
import u3.d;
import u3.l;

public class GroupMessageParser
  extends MessageParser
{
  private boolean isAtMeMessage(Message paramMessage)
  {
    paramMessage = q5.a.c(paramMessage.title);
    if (paramMessage.f()) {
      return paramMessage.d().contains(e.o());
    }
    return false;
  }
  
  public String getDescription(Message paramMessage)
  {
    Object localObject = c.a;
    if ((((List)localObject).contains(paramMessage.state)) && (paramMessage.direction == 1)) {
      return HoxinApplication.h().getString(2131690088);
    }
    if ((((List)localObject).contains(paramMessage.state)) && (paramMessage.direction == 0))
    {
      paramMessage = p4.b.l(paramMessage.sender, Long.valueOf(Long.parseLong(paramMessage.extra)));
      return HoxinApplication.h().getString(2131690084, new Object[] { paramMessage });
    }
    if (i5.b.a.contains(Byte.valueOf(paramMessage.format))) {
      return paramMessage.content;
    }
    if (1 == paramMessage.direction) {
      return super.getDescription(paramMessage);
    }
    localObject = p4.b.l(paramMessage.sender, Long.valueOf(Long.parseLong(paramMessage.extra)));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(":");
    localStringBuilder.append(super.getDescription(paramMessage));
    return localStringBuilder.toString();
  }
  
  public String getNotificationChannelId(Message paramMessage)
  {
    if (isAtMeMessage(paramMessage)) {
      return "IMPORTANCE_HIGH_NOTIFICATION";
    }
    return "NEW_MESSAGE_NOTIFICATION";
  }
  
  public String getNotificationContent(ChatSession paramChatSession, Message paramMessage)
  {
    int i;
    if (d.s(Long.valueOf(paramChatSession.sourceId))) {
      i = d.l(paramChatSession.sourceId);
    } else {
      i = j5.a.p(paramChatSession.id);
    }
    return l.J(2131689566, new Object[] { Long.valueOf(i), getDescription(paramMessage) });
  }
  
  public Intent getNotificationIntent()
  {
    return new Intent(HoxinApplication.h(), GroupChatActivity.class);
  }
  
  public int getNotificationPriority(Message paramMessage)
  {
    if (isAtMeMessage(paramMessage)) {
      return 2;
    }
    return 0;
  }
  
  public MessageSource getSource(Message paramMessage)
  {
    if (1 == paramMessage.direction) {}
    for (paramMessage = paramMessage.receiver;; paramMessage = paramMessage.sender) {
      return p4.a.h(paramMessage);
    }
  }
  
  public String getTitle(MessageSource paramMessageSource, Message paramMessage)
  {
    return paramMessageSource.getName();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.parser.GroupMessageParser
 * JD-Core Version:    0.7.0.1
 */