package com.farsunset.hoxin.message.function.handler;

import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import m5.e;
import u3.b0;
import x5.a;

public class Action204MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    j5.b.d(paramMessage.id);
    long l = paramMessage.sender.longValue();
    p3.b.a(b0.j(l));
    paramMessage = a.f(l);
    paramBundle = new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_SOURCE");
    paramBundle.putExtra("ATTR_CHAT_SESSION", ChatSession.of(paramMessage));
    HoxinApplication.t(paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action204MessageHandler
 * JD-Core Version:    0.7.0.1
 */