package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.common.model.Link;
import com.farsunset.hoxin.message.entity.Message;
import j5.b;
import m5.e;
import u3.l;

public class Action200MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    try
    {
      if (6 == paramMessage.format) {
        l.s0(paramMessage.content, Link.class);
      }
      if (7 == paramMessage.format) {
        l.u0(paramMessage.content, Link.class);
      }
      parame.c(paramMessage, paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      label45:
      break label45;
    }
    b.d(paramMessage.id);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action200MessageHandler
 * JD-Core Version:    0.7.0.1
 */