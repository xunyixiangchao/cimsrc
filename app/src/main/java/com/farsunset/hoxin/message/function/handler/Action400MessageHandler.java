package com.farsunset.hoxin.message.function.handler;

import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.organization.entity.Organization;
import l3.h;
import p6.c;
import u3.l;
import u3.l0;

public class Action400MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    j5.b.d(paramMessage.id);
    Object localObject = n6.a.b(paramMessage.sender.longValue());
    c.a((Organization)localObject);
    i4.a.b(h.b(((Organization)localObject).getUidList()), (byte)1);
    Message localMessage = l0.a(paramMessage);
    localMessage.sender = Long.valueOf(0L);
    localMessage.receiver = i3.e.o();
    localMessage.action = "2";
    localMessage.format = 0;
    localMessage.content = l.J(2131690072, new Object[] { ((Organization)localObject).name });
    n5.b.a(localMessage, true);
    localObject = new Intent("com.farsunset.hoxin.ACTION_RECENT_APPEND_CHAT");
    ((Intent)localObject).putExtra("ATTR_CHAT_SESSION", j5.a.l(0L, 3));
    HoxinApplication.t((Intent)localObject);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action400MessageHandler
 * JD-Core Version:    0.7.0.1
 */