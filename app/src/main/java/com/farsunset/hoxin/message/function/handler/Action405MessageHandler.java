package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.organization.entity.Department;
import m5.e;
import p6.a;
import u3.l;

public class Action405MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, e parame)
  {
    a.a((Department)l.s0(paramMessage.content, Department.class));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action405MessageHandler
 * JD-Core Version:    0.7.0.1
 */