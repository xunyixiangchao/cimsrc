package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import m5.e;
import u3.l;

public class Action302MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    j5.b.d(paramMessage.id);
    long l = paramMessage.sender.longValue();
    p4.b.p(Long.valueOf(l), Long.valueOf(Long.parseLong(paramMessage.content)));
    l.w0(l);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action302MessageHandler
 * JD-Core Version:    0.7.0.1
 */