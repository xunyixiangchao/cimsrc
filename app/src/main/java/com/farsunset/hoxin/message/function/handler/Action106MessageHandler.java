package com.farsunset.hoxin.message.function.handler;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.Message;
import i4.a;
import l3.h;
import m5.e;
import u3.l0;

public class Action106MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    j5.b.d(paramMessage.id);
    a.a(h.e(paramMessage.sender.longValue()), (byte)0);
    HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RELOAD_CONTACTS"));
    parame.c(paramMessage, paramBundle);
    paramMessage = l0.a(paramMessage);
    paramMessage.action = "0";
    paramMessage.format = 0;
    paramMessage.state = Byte.valueOf((byte)0);
    paramMessage.content = HoxinApplication.h().getString(2131690112);
    n5.b.a(paramMessage, true);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action106MessageHandler
 * JD-Core Version:    0.7.0.1
 */