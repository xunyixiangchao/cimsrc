package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver;
import com.baidu.platform.comapi.util.d;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;

public class SysUpdateUtil
  implements SysUpdateObserver
{
  private static NACommonMemCache a;
  
  public SysUpdateUtil()
  {
    a = d.b();
  }
  
  public void init(String paramString)
  {
    if (a != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = SyncSysInfo.getPhoneInfoCache();
      }
      a.a(str);
    }
  }
  
  public void updateNetworkInfo(Context paramContext)
  {
    NetworkUtil.updateNetworkProxy(paramContext);
  }
  
  public void updateNetworkProxy(Context paramContext)
  {
    paramContext = NetworkUtil.getActiveNetworkInfo(paramContext);
    if ((paramContext != null) && (paramContext.isAvailable()))
    {
      String str = paramContext.getTypeName().toLowerCase();
      if ((str.equals("wifi")) && (paramContext.isConnected())) {
        return;
      }
      if ((str.equals("mobile")) || ((str.equals("wifi")) && (!NetworkUtil.isWifiConnected(paramContext))))
      {
        paramContext = paramContext.getExtraInfo();
        if (paramContext != null)
        {
          paramContext = paramContext.toLowerCase();
          if ((!paramContext.startsWith("cmwap")) && (!paramContext.startsWith("uniwap")))
          {
            if (paramContext.startsWith("3gwap")) {
              return;
            }
            if (paramContext.startsWith("ctwap")) {
              return;
            }
            if ((!paramContext.startsWith("cmnet")) && (!paramContext.startsWith("uninet")) && (!paramContext.startsWith("ctnet"))) {
              paramContext.startsWith("3gnet");
            }
          }
        }
        else
        {
          paramContext = Proxy.getDefaultHost();
          Proxy.getDefaultPort();
          if ((paramContext != null) && (paramContext.length() > 0))
          {
            if ("10.0.0.172".equals(paramContext.trim())) {
              return;
            }
            "10.0.0.200".equals(paramContext.trim());
          }
        }
      }
    }
  }
  
  public void updatePhoneInfo(String paramString)
  {
    NACommonMemCache localNACommonMemCache = a;
    if (localNACommonMemCache != null) {
      localNACommonMemCache.a(paramString);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil
 * JD-Core Version:    0.7.0.1
 */