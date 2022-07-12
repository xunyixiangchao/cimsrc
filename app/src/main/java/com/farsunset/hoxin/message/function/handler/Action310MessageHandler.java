package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import j5.b;
import m5.e;

public class Action310MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    long l = Long.parseLong(paramMessage.content);
    if (!b.j(l)) {
      return;
    }
    b.C(l, Byte.valueOf((byte)13));
    b.d(paramMessage.id);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action310MessageHandler
 * JD-Core Version:    0.7.0.1
 */