package com.farsunset.hoxin.message.function.handler;

import android.app.Application;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.farsunset.cim.sdk.android.h;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.webrtc.model.AvRoom;
import com.farsunset.hoxin.webrtc.service.CallIncomingService;
import java.util.Map;
import u3.l;
import u3.r;
import u3.s;

public class Action910MessageHandler
  implements MessageHandler
{
  protected byte getCallType()
  {
    return 10;
  }
  
  public void handle(Message paramMessage, Bundle paramBundle, m5.e parame)
  {
    paramBundle = new AvRoom();
    paramBundle.setUid(paramMessage.sender.longValue());
    paramBundle.setTag(paramMessage.extra);
    paramBundle.setType(getCallType());
    paramBundle.setTimestamp(paramMessage.createTime.longValue());
    paramBundle.setMember((Map)l.t0(paramMessage.content, new com.google.gson.reflect.a() {}.getType()));
    if (i3.e.l() == 1)
    {
      u6.a.d(paramBundle.getTag());
      return;
    }
    parame = new Friend();
    long l = paramMessage.sender.longValue();
    parame.id = l;
    parame.name = paramBundle.getName(l);
    paramMessage = new Intent(HoxinApplication.h(), CallIncomingService.class);
    paramMessage.putExtra("ATTR_TYPE", getCallType());
    paramMessage.putExtra("ATTR_LOGO", s.a().n(parame.getWebIcon()));
    paramMessage.putExtra(MessageSource.NAME, parame);
    paramMessage.putExtra(AvRoom.class.getName(), paramBundle);
    if (Build.VERSION.SDK_INT >= 29) {
      HoxinApplication.h().startForegroundService(paramMessage);
    } else {
      HoxinApplication.h().startService(paramMessage);
    }
    h.t(HoxinApplication.h(), paramBundle.getTag());
    i3.e.x(1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action910MessageHandler
 * JD-Core Version:    0.7.0.1
 */