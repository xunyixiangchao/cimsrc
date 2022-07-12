package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import g6.a;
import m5.e;

public class Action503MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    long l = paramMessage.sender.longValue();
    j5.b.d(paramMessage.id);
    if (!g6.b.j(l)) {
      return;
    }
    a.c(Long.valueOf(Long.parseLong(paramMessage.content)));
    j5.b.f(Long.valueOf(l), "502", paramMessage.content);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action503MessageHandler
 * JD-Core Version:    0.7.0.1
 */