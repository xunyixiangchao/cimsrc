package com.farsunset.hoxin.message.function.handler;

import android.app.Application;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.Message;
import n5.b;
import p4.a;

public class Action308MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    a.c(paramMessage.sender);
    paramMessage.action = "3";
    paramMessage.format = 12;
    paramMessage.receiver = i3.e.o();
    paramMessage.content = HoxinApplication.h().getString(2131690056);
    paramMessage.state = Byte.valueOf((byte)11);
    b.a(paramMessage, true);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action308MessageHandler
 * JD-Core Version:    0.7.0.1
 */