package com.farsunset.hoxin.message.function.parser;

import android.content.Intent;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.Link;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.micro.ui.MicroServerWindowActivity;
import java.util.List;
import java.util.Objects;
import u3.l;
import x5.a;

public class MicroServerMessageParser
  extends MessageParser
{
  public String getDescription(Message paramMessage)
  {
    int i = paramMessage.format;
    if (6 == i) {}
    for (paramMessage = l.s0(paramMessage.content, Link.class);; paramMessage = l.u0(paramMessage, Link.class).get(0))
    {
      return ((Link)paramMessage).title;
      paramMessage = paramMessage.content;
      if (7 != i) {
        break;
      }
    }
    return paramMessage;
  }
  
  public Intent getNotificationIntent()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(HoxinApplication.h(), MicroServerWindowActivity.class);
    return localIntent;
  }
  
  public MessageSource getSource(Message paramMessage)
  {
    if (Objects.equals(Byte.valueOf(paramMessage.direction), Byte.valueOf((byte)1))) {}
    for (paramMessage = paramMessage.receiver;; paramMessage = paramMessage.sender) {
      return a.f(paramMessage.longValue());
    }
  }
  
  public String getTitle(MessageSource paramMessageSource, Message paramMessage)
  {
    return paramMessageSource.getName();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.parser.MicroServerMessageParser
 * JD-Core Version:    0.7.0.1
 */