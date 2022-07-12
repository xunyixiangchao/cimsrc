package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import g6.a;
import m5.e;

public class Action501MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    long l = paramMessage.sender.longValue();
    if (!g6.b.j(l)) {
      return;
    }
    g6.b.c(l);
    a.e(l);
    j5.b.d(paramMessage.id);
    j5.b.e(Long.valueOf(l), "500");
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action501MessageHandler
 * JD-Core Version:    0.7.0.1
 */