package com.farsunset.hoxin.message.function.handler;

import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import j5.b;
import m5.e;

public class Action304MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    b.d(paramMessage.id);
    long l = paramMessage.sender.longValue();
    paramMessage = paramMessage.content;
    p4.a.p(Long.valueOf(l), paramMessage);
    j5.a.v(l, 2, paramMessage);
    paramMessage = p4.a.h(Long.valueOf(l));
    paramBundle = new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_SOURCE");
    paramBundle.putExtra("ATTR_CHAT_SESSION", ChatSession.of(paramMessage));
    HoxinApplication.t(paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action304MessageHandler
 * JD-Core Version:    0.7.0.1
 */