package com.farsunset.hoxin.message.function.handler;

import android.app.Application;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.group.entity.Group;
import com.farsunset.hoxin.message.entity.Message;
import u3.d;

public class Action300MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    d.e(paramMessage.sender.longValue());
    Object localObject = n4.b.e(paramMessage.sender.longValue());
    if (localObject == null)
    {
      j5.b.d(paramMessage.id);
      return;
    }
    p4.a.a((Group)localObject);
    localObject = i4.a.k(Long.parseLong(paramMessage.extra));
    paramMessage.action = "3";
    paramMessage.format = 8;
    paramMessage.receiver = i3.e.o();
    paramMessage.content = HoxinApplication.h().getString(2131690058, new Object[] { localObject });
    paramMessage.state = Byte.valueOf((byte)10);
    n5.b.a(paramMessage, true);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action300MessageHandler
 * JD-Core Version:    0.7.0.1
 */