package com.farsunset.hoxin.message.function.handler;

import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.organization.entity.Organization;
import java.util.List;
import p6.c;
import u3.l;
import u3.l0;

public class Action403MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    long l = paramMessage.sender.longValue();
    Organization localOrganization = c.d(l);
    if (localOrganization == null) {
      return;
    }
    c.b();
    p6.a.c(l);
    p6.b.c(l);
    Object localObject = j5.a.g(i4.a.m((byte)1), 1);
    j5.a.d((List)localObject);
    j5.b.i((List)localObject);
    i4.a.d();
    j5.b.d(paramMessage.id);
    g6.b.d();
    g6.a.d();
    localObject = l0.a(paramMessage);
    ((Message)localObject).sender = Long.valueOf(0L);
    ((Message)localObject).receiver = i3.e.o();
    ((Message)localObject).action = "2";
    ((Message)localObject).format = 0;
    ((Message)localObject).content = l.J(2131690075, new Object[] { localOrganization.name });
    n5.b.a((Message)localObject, true);
    HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RECENT_REFRESH_LIST"));
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action403MessageHandler
 * JD-Core Version:    0.7.0.1
 */