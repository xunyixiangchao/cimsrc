package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import i4.a;
import j5.b;
import m5.e;

public class Action104MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    b.d(paramMessage.id);
    a.s(Long.valueOf(paramMessage.sender.longValue()), paramMessage.content);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action104MessageHandler
 * JD-Core Version:    0.7.0.1
 */