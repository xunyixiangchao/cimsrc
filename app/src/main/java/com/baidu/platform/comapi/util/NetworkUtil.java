package com.baidu.platform.comapi.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public class NetworkUtil
{
  public static final int NETYPE_2G = 2;
  public static final int NETYPE_3G = 3;
  public static final int NETYPE_4G = 4;
  public static final int NETYPE_4G_UNKNOWN = 10;
  public static final int NETYPE_MOBILE_3G = 8;
  public static final int NETYPE_MOBILE_UNICOM_2G = 6;
  public static final int NETYPE_NOCON = -1;
  public static final int NETYPE_TELECOM_2G = 5;
  public static final int NETYPE_TELECOM_3G = 7;
  public static final int NETYPE_UNICOM_3G = 9;
  public static final int NETYPE_UNKNOWN = 0;
  public static final int NETYPE_WIFI = 1;
  public static String mProxyHost = "";
  public static int mProxyPort = 0;
  public static boolean mUseProxy = false;
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null) {}
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
    return null;
  }
  
  public static NetworkInfo[] getAllNetworkInfo(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    try
    {
      paramContext = paramContext.getAllNetworkInfo();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String getCurrentNetMode(Context paramContext)
  {
    Object localObject = getActiveNetworkInfo(paramContext);
    int i = 0;
    if (localObject != null)
    {
      int j = ((NetworkInfo)localObject).getType();
      if (j == 1)
      {
        i = 1;
        break label349;
      }
      if ((j == 0) || (j == 3) || (j == 4) || (j == 5))
      {
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
        if (paramContext != null) {
          switch (paramContext.getNetworkType())
          {
          default: 
            break;
          case 14: 
            i = 3;
            break;
          case 13: 
          case 18: 
            i = 4;
            break;
          case 8: 
          case 17: 
            i = 8;
            break;
          case 7: 
          case 11: 
          case 16: 
            i = 2;
            break;
          case 5: 
          case 6: 
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
            break;
          }
        }
      }
    }
    i = -1;
    label349:
    return Integer.toString(i);
  }
  
  public static String getNetworkOperatorInfo(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null)
    {
      paramContext = paramContext.getNetworkOperator();
      if (TextUtils.isEmpty(paramContext)) {}
    }
    try
    {
      paramContext = new StringBuilder(paramContext);
      paramContext.insert(3, ":");
      paramContext = paramContext.toString();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
    return "";
  }
  
  public static int getNetworkOperatorType(Context paramContext)
  {
    paramContext = getNetworkOperatorInfo(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      if ((!paramContext.startsWith("460:00")) && (!paramContext.startsWith("460:02")))
      {
        if (paramContext.startsWith("460:01")) {
          return 1;
        }
        if (paramContext.startsWith("460:03")) {
          return 2;
        }
      }
      else
      {
        return 0;
      }
    }
    return -1;
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
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      boolean bool1 = bool2;
      if (paramContext != null)
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
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean isWifiState(Context paramContext)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    WifiManager localWifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    try
    {
      if (paramContext.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
        i = localWifiManager.getWifiState();
      }
    }
    catch (Exception paramContext)
    {
      int i;
      label38:
      break label38;
    }
    i = 1;
    if (i == 3) {
      bool = true;
    }
    return bool;
  }
  
  public static void updateNetworkProxy(Context paramContext) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */