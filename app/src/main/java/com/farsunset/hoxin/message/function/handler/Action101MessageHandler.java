package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import j5.b;
import m5.e;
import o3.c;

public class Action101MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    long l = Long.parseLong(paramMessage.content);
    if (!b.j(l)) {
      return;
    }
    paramBundle.putSerializable("ATTR_CHAT_SESSION", j5.a.n(i4.a.l(paramMessage.sender.longValue()), c.b));
    b.C(l, Byte.valueOf((byte)13));
    b.d(paramMessage.id);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action101MessageHandler
 * JD-Core Version:    0.7.0.1
 */