package com.farsunset.hoxin.message.function.handler;

import android.app.Application;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.Message;
import n5.b;
import p4.a;

public class Action309MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    a.o(paramMessage.sender);
    paramMessage.action = "3";
    paramMessage.format = 13;
    paramMessage.receiver = i3.e.o();
    paramMessage.state = Byte.valueOf((byte)11);
    paramMessage.content = HoxinApplication.h().getString(2131690057);
    b.a(paramMessage, true);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action309MessageHandler
 * JD-Core Version:    0.7.0.1
 */