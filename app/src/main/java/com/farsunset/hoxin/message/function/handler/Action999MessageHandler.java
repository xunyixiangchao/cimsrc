package com.farsunset.hoxin.message.function.handler;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.home.ui.ForceOfflineAlertActivity;
import com.farsunset.hoxin.message.entity.Message;
import j5.b;
import u3.l;

public class Action999MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    b.d(paramMessage.id);
    i3.e.t();
    paramBundle = paramMessage.content;
    paramMessage = l.x(paramMessage.createTime.longValue());
    parame = new Intent(HoxinApplication.h(), ForceOfflineAlertActivity.class);
    parame.addFlags(268435456);
    parame.putExtra("TITLE", HoxinApplication.h().getString(2131690159));
    parame.putExtra("MESSAGE", HoxinApplication.h().getString(2131690050, new Object[] { paramMessage, paramBundle }));
    HoxinApplication.h().startActivity(parame);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action999MessageHandler
 * JD-Core Version:    0.7.0.1
 */