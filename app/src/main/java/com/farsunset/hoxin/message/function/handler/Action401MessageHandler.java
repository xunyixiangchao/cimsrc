package com.farsunset.hoxin.message.function.handler;

import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import m5.e;

public class Action401MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    long l = Long.parseLong(paramMessage.content);
    paramBundle = i4.a.l(l);
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.type == 2)
    {
      i4.a.c(Long.valueOf(l), (byte)1);
      HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RELOAD_CONTACTS"));
      return;
    }
    i4.a.c(Long.valueOf(l), (byte)3);
    g6.b.e(l);
    j5.b.d(paramMessage.id);
    j5.b.h(j5.a.f(paramBundle));
    HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RELOAD_CONTACTS"));
    paramMessage = new Intent("com.farsunset.hoxin.ACTION_RECENT_DELETE_CHAT");
    paramMessage.putExtra("ATTR_CHAT_SESSION", ChatSession.of(l, 1));
    HoxinApplication.t(paramMessage);
    i4.a.c(Long.valueOf(l), (byte)1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action401MessageHandler
 * JD-Core Version:    0.7.0.1
 */