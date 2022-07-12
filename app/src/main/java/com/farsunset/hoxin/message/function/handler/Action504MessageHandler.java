package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import m5.e;
import u3.b0;

public class Action504MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    j5.b.d(paramMessage.id);
    p3.b.a(b0.i(paramMessage.sender.longValue()));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action504MessageHandler
 * JD-Core Version:    0.7.0.1
 */