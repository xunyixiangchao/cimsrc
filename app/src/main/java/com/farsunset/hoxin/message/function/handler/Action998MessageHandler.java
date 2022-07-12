package com.farsunset.hoxin.message.function.handler;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.farsunset.cim.sdk.android.h;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.home.ui.ForceOfflineAlertActivity;
import com.farsunset.hoxin.message.entity.Message;
import j5.b;

public class Action998MessageHandler
  implements MessageHandler
{
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    b.d(paramMessage.id);
    h.w(HoxinApplication.h());
    i3.e.t();
    paramMessage = new Intent(HoxinApplication.h(), ForceOfflineAlertActivity.class);
    paramMessage.addFlags(268435456);
    paramMessage.putExtra("TITLE", HoxinApplication.h().getString(2131689557));
    paramMessage.putExtra("MESSAGE", HoxinApplication.h().getString(2131690133));
    HoxinApplication.h().startActivity(paramMessage);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action998MessageHandler
 * JD-Core Version:    0.7.0.1
 */