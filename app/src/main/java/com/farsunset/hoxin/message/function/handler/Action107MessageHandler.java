package com.farsunset.hoxin.message.function.handler;

import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import m5.e;

public class Action107MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    long l = paramMessage.sender.longValue();
    paramBundle = i4.a.l(l);
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.type == 2)
    {
      i4.a.c(Long.valueOf(l), (byte)0);
      paramMessage = new Intent("com.farsunset.hoxin.ACTION_RELOAD_CONTACTS");
    }
    for (;;)
    {
      HoxinApplication.t(paramMessage);
      return;
      i4.a.c(Long.valueOf(l), (byte)3);
      g6.b.e(l);
      j5.b.d(paramMessage.id);
      l = j5.a.f(paramBundle);
      j5.a.c(l);
      j5.b.h(l);
      HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RELOAD_CONTACTS"));
      paramMessage = new Intent("com.farsunset.hoxin.ACTION_RECENT_DELETE_CHAT");
      paramMessage.putExtra("ATTR_CHAT_SESSION", ChatSession.of(paramBundle));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action107MessageHandler
 * JD-Core Version:    0.7.0.1
 */