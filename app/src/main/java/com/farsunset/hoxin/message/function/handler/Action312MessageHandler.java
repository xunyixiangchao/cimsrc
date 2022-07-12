package com.farsunset.hoxin.message.function.handler;

import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import m5.e;
import p4.b;
import u3.l;

public class Action312MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    long l = paramMessage.sender.longValue();
    l.w0(l);
    paramMessage = paramMessage.content.split(",");
    int j = paramMessage.length;
    int i = 0;
    while (i < j)
    {
      b.p(Long.valueOf(l), Long.valueOf(Long.parseLong(paramMessage[i])));
      i += 1;
    }
    paramMessage = new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_SOURCE");
    paramMessage.putExtra("ATTR_CHAT_SESSION", ChatSession.of(l, 2));
    HoxinApplication.t(paramMessage);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action312MessageHandler
 * JD-Core Version:    0.7.0.1
 */