package com.farsunset.hoxin.message.function.handler;

import android.app.Application;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.Message;
import p4.a;

public class Action307MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    long l1 = paramMessage.sender.longValue();
    long l2 = Long.parseLong(paramMessage.content);
    a.n(l1, l2);
    String str = p4.b.l(Long.valueOf(l1), Long.valueOf(l2));
    paramMessage.state = Byte.valueOf((byte)11);
    paramMessage.action = "3";
    paramMessage.format = 11;
    paramMessage.receiver = i3.e.o();
    paramMessage.content = HoxinApplication.h().getString(2131690064, new Object[] { str });
    n5.b.a(paramMessage, true);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action307MessageHandler
 * JD-Core Version:    0.7.0.1
 */