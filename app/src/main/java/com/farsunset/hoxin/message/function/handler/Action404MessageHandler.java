package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.organization.entity.DepartmentMember;
import i4.a;
import l3.h;
import m5.e;
import p6.b;
import u3.l;

public class Action404MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    DepartmentMember localDepartmentMember = (DepartmentMember)l.s0(paramMessage.content, DepartmentMember.class);
    b.a(localDepartmentMember);
    a.a(h.e(localDepartmentMember.uid.longValue()), (byte)1);
    parame.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action404MessageHandler
 * JD-Core Version:    0.7.0.1
 */