package com.farsunset.hoxin.message.function.handler;

import android.app.Application;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.webrtc.service.CallIncomingService;
import i4.a;
import u3.r;
import u3.s;
import u6.b;

public class Action900MessageHandler
  implements MessageHandler
{
  protected byte getCallType()
  {
    return 0;
  }
  
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    int i = i3.e.l();
    paramMessage = paramMessage.sender;
    if (i == 1)
    {
      b.c(paramMessage.longValue());
      return;
    }
    paramMessage = a.l(paramMessage.longValue());
    paramBundle = new Intent(HoxinApplication.h(), CallIncomingService.class);
    paramBundle.putExtra("ATTR_TYPE", getCallType());
    paramBundle.putExtra(MessageSource.NAME, paramMessage);
    paramBundle.putExtra("ATTR_LOGO", s.a().n(paramMessage.getWebIcon()));
    if (Build.VERSION.SDK_INT >= 29) {
      HoxinApplication.h().startForegroundService(paramBundle);
    } else {
      HoxinApplication.h().startService(paramBundle);
    }
    i3.e.x(1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action900MessageHandler
 * JD-Core Version:    0.7.0.1
 */