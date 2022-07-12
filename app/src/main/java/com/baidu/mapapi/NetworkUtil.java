package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;

public class NetworkUtil
{
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String getCurrentNetMode(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = getActiveNetworkInfo(paramContext);
    int i = 4;
    if (localObject != null)
    {
      if (((NetworkInfo)localObject).getType() == 1)
      {
        i = 1;
        break label321;
      }
      if (Build.VERSION.SDK_INT > 29)
      {
        localObject = "mobile";
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext == null) {
          return "mobile";
        }
        NetworkCapabilities localNetworkCapabilities = paramContext.getNetworkCapabilities(paramContext.getActiveNetwork());
        paramContext = (Context)localObject;
        if (localNetworkCapabilities != null)
        {
          boolean bool1 = localNetworkCapabilities.hasTransport(1);
          boolean bool2 = localNetworkCapabilities.hasTransport(0);
          boolean bool3 = localNetworkCapabilities.hasTransport(3);
          boolean bool4 = localNetworkCapabilities.hasTransport(6);
          boolean bool5 = localNetworkCapabilities.hasTransport(4);
          boolean bool6 = localNetworkCapabilities.hasTransport(5);
          if (bool1) {
            return "WIFI";
          }
          if (bool2) {
            return "CELLULAR";
          }
          if (bool3) {
            return "ETHERNET";
          }
          if (bool4) {
            return "LoWPAN";
          }
          if (bool5) {
            return "VPN";
          }
          paramContext = (Context)localObject;
          if (bool6) {
            paramContext = "WifiAware";
          }
        }
        return paramContext;
      }
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        return Integer.toString(0);
      }
    }
    switch (paramContext.getNetworkType())
    {
    default: 
      break;
    case 14: 
      i = 10;
      break;
    case 11: 
      i = 2;
      break;
    case 8: 
      i = 8;
      break;
    case 5: 
    case 6: 
    case 7: 
    case 12: 
      i = 7;
      break;
    case 4: 
      i = 5;
      break;
    case 3: 
    case 9: 
    case 10: 
    case 15: 
      i = 9;
      break;
    case 1: 
    case 2: 
      i = 6;
      break label321;
      i = 0;
    }
    label321:
    return Integer.toString(i);
  }
  
  public static boolean initConnectState()
  {
    return true;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      if (isWifiConnected(paramContext)) {
        return true;
      }
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        boolean bool3 = paramContext.isConnectedOrConnecting();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool1 = bool2;
    if (paramContext != null) {}
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (1 == paramContext.getType())
        {
          boolean bool3 = paramContext.isConnected();
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isWifiConnected(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo != null) {
      try
      {
        if (1 == paramNetworkInfo.getType())
        {
          boolean bool = paramNetworkInfo.isConnected();
          if (bool) {
            return true;
          }
        }
      }
      catch (Exception paramNetworkInfo)
      {
        paramNetworkInfo.printStackTrace();
      }
    }
    return false;
  }
  
  public static void updateNetworkProxy(Context paramContext)
  {
    SysUpdateObservable.getInstance().updateNetworkProxy(paramContext);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */