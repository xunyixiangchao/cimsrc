package com.farsunset.hoxin.message.function.handler;

import android.app.Application;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.Message;
import n5.b;
import p4.a;

public class Action303MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    a.d(paramMessage.sender);
    paramMessage.action = "3";
    paramMessage.format = 10;
    paramMessage.receiver = i3.e.o();
    paramMessage.content = HoxinApplication.h().getString(2131690055);
    paramMessage.state = Byte.valueOf((byte)11);
    b.a(paramMessage, true);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action303MessageHandler
 * JD-Core Version:    0.7.0.1
 */