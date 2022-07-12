package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.moment.entity.Moment;
import i4.a;
import m5.e;

public class Action500MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    long l = paramMessage.sender.longValue();
    if (!a.o(Long.parseLong(paramMessage.content))) {
      return;
    }
    Moment localMoment = d6.b.e(l);
    if (localMoment == null) {
      return;
    }
    g6.b.a(localMoment);
    j5.b.C(paramMessage.id, Byte.valueOf((byte)11));
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action500MessageHandler
 * JD-Core Version:    0.7.0.1
 */