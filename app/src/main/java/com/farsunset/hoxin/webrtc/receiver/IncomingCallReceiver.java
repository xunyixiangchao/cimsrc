package com.farsunset.hoxin.webrtc.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import i3.e;

public class IncomingCallReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.PHONE_STATE".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("state");
      if (TelephonyManager.EXTRA_STATE_IDLE.equals(paramContext)) {}
      for (int i = 0;; i = 1)
      {
        e.x(i);
        return;
        if (!TelephonyManager.EXTRA_STATE_RINGING.equals(paramContext)) {
          break;
        }
      }
      if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(paramContext)) {
        e.x(2);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.webrtc.receiver.IncomingCallReceiver
 * JD-Core Version:    0.7.0.1
 */