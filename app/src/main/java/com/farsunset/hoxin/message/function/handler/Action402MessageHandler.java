package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.organization.entity.Organization;
import j5.b;
import m5.e;
import p6.c;

public class Action402MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    b.d(paramMessage.id);
    Organization localOrganization = new Organization();
    localOrganization.id = paramMessage.sender;
    localOrganization.name = paramMessage.content;
    c.a(localOrganization);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action402MessageHandler
 * JD-Core Version:    0.7.0.1
 */