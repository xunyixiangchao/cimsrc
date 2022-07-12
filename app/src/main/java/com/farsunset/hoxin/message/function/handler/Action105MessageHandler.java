package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import i4.a;
import l3.h;
import m5.e;

public class Action105MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    long l = paramMessage.sender.longValue();
    paramMessage.state = Byte.valueOf((byte)10);
    j5.b.e(Long.valueOf(l), "105");
    if (!a.e(l)) {
      a.a(h.e(l), (byte)3);
    }
    n5.b.a(paramMessage, true);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action105MessageHandler
 * JD-Core Version:    0.7.0.1
 */