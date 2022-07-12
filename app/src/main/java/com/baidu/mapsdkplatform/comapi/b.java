package com.baidu.mapsdkplatform.comapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.f;

public class b
  extends BroadcastReceiver
{
  public void a(Context paramContext)
  {
    paramContext = NetworkUtil.getCurrentNetMode(paramContext);
    String str = f.e();
    if ((str != null) && (!str.equals(paramContext))) {
      f.a(paramContext);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    a(paramContext);
    NetworkUtil.updateNetworkProxy(paramContext);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.b
 * JD-Core Version:    0.7.0.1
 */