package com.farsunset.hoxin.message.function.handler;

import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import m5.e;
import u3.b0;

public class Action306MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    j5.b.d(paramMessage.id);
    long l = paramMessage.sender.longValue();
    p3.b.a(b0.g(l));
    paramMessage = new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_SOURCE");
    paramMessage.putExtra("ATTR_CHAT_SESSION", ChatSession.of(l, 2));
    HoxinApplication.t(paramMessage);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action306MessageHandler
 * JD-Core Version:    0.7.0.1
 */