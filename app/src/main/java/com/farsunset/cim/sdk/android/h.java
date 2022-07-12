package com.farsunset.cim.sdk.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.TextUtils;
import com.farsunset.cim.sdk.android.model.SentBody;
import java.util.Locale;
import java.util.UUID;

public class h
{
  protected static boolean a(Context paramContext)
  {
    String str = a.d(paramContext, "KEY_UID");
    if ((str != null) && (!l(paramContext)))
    {
      q(paramContext, str);
      return true;
    }
    return false;
  }
  
  public static void b(Context paramContext, long paramLong)
  {
    c(paramContext, String.valueOf(paramLong));
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (l(paramContext)) {
      return;
    }
    q(paramContext, paramString);
  }
  
  public static void d(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, CIMPushService.class);
    localIntent.setAction("ACTION_HIDE_PERSIST_NOTIFICATION");
    v(paramContext, localIntent);
  }
  
  public static void e(Context paramContext, String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt != 0))
    {
      a.g(paramContext, "KEY_CIM_SERVER_HOST", paramString);
      a.f(paramContext, "KEY_CIM_SERVER_PORT", paramInt);
      a.e(paramContext, "KEY_CIM_DESTROYED", false);
      a.e(paramContext, "KEY_MANUAL_STOP", false);
      a.h(paramContext, "KEY_UID");
      paramString = new Intent(paramContext, CIMPushService.class);
      paramString.setAction("ACTION_CREATE_CIM_CONNECTION");
      v(paramContext, paramString);
      return;
    }
    b3.a.d().f(paramString, paramInt);
  }
  
  public static void f(Context paramContext)
  {
    a.e(paramContext, "KEY_CIM_DESTROYED", true);
    a.h(paramContext, "KEY_UID");
    Intent localIntent = new Intent(paramContext, CIMPushService.class);
    localIntent.setAction("ACTION_DESTROY_CIM_SERVICE");
    v(paramContext, localIntent);
  }
  
  private static String g(Context paramContext)
  {
    String str = a.d(paramContext, "KEY_DEVICE_ID");
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = UUID.randomUUID().toString().replace("-", "").toUpperCase();
    a.g(paramContext, "KEY_DEVICE_ID", str);
    return str;
  }
  
  private static String h()
  {
    Locale localLocale;
    if (Build.VERSION.SDK_INT >= 24) {
      localLocale = LocaleList.getDefault().get(0);
    } else {
      localLocale = Locale.getDefault();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localLocale.getLanguage());
    localStringBuilder.append("-");
    localStringBuilder.append(localLocale.getCountry());
    return localStringBuilder.toString();
  }
  
  public static NetworkInfo i(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  private static String j(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label18:
      break label18;
    }
    return null;
  }
  
  public static boolean k(Context paramContext)
  {
    return a.b(paramContext, "KEY_CIM_CONNECTION_STATE");
  }
  
  public static boolean l(Context paramContext)
  {
    return a.b(paramContext, "KEY_CIM_DESTROYED");
  }
  
  public static boolean m(Context paramContext)
  {
    paramContext = i(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean n(Context paramContext)
  {
    return a.b(paramContext, "KEY_MANUAL_STOP");
  }
  
  public static void o(Context paramContext)
  {
    if (!l(paramContext))
    {
      if (n(paramContext)) {
        return;
      }
      Intent localIntent = new Intent(paramContext, CIMPushService.class);
      localIntent.setAction("ACTION_CIM_CONNECTION_PONG");
      v(paramContext, localIntent);
    }
  }
  
  public static void p(Context paramContext)
  {
    SentBody localSentBody = new SentBody();
    localSentBody.setKey("client_remove_tag");
    r(paramContext, localSentBody);
  }
  
  private static void q(Context paramContext, String paramString)
  {
    a.e(paramContext, "KEY_MANUAL_STOP", false);
    a.g(paramContext, "KEY_UID", paramString);
    SentBody localSentBody = new SentBody();
    localSentBody.setKey("client_bind");
    localSentBody.put("uid", String.valueOf(paramString));
    localSentBody.put("channel", "android");
    localSentBody.put("deviceId", g(paramContext));
    localSentBody.put("deviceName", Build.MODEL);
    localSentBody.put("appVersion", j(paramContext));
    localSentBody.put("osVersion", Build.VERSION.RELEASE);
    localSentBody.put("packageName", paramContext.getPackageName());
    localSentBody.put("language", h());
    localSentBody.setTimestamp(System.currentTimeMillis());
    r(paramContext, localSentBody);
  }
  
  public static void r(Context paramContext, SentBody paramSentBody)
  {
    if (!l(paramContext))
    {
      if (n(paramContext)) {
        return;
      }
      Intent localIntent = new Intent(paramContext, CIMPushService.class);
      localIntent.putExtra("KEY_SEND_BODY", paramSentBody);
      localIntent.setAction("ACTION_SEND_REQUEST_BODY");
      v(paramContext, localIntent);
    }
  }
  
  public static void s(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, CIMPushService.class);
    localIntent.putExtra("KEY_LOGGER_ENABLE", paramBoolean);
    localIntent.setAction("ACTION_SET_LOGGER_EATABLE");
    v(paramContext, localIntent);
  }
  
  public static void t(Context paramContext, String paramString)
  {
    SentBody localSentBody = new SentBody();
    localSentBody.setKey("client_set_tag");
    localSentBody.put("tag", paramString);
    r(paramContext, localSentBody);
  }
  
  public static void u(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, CIMPushService.class);
    localIntent.putExtra("KEY_NOTIFICATION_MESSAGE", paramString2);
    localIntent.putExtra("KEY_NOTIFICATION_CHANNEL", paramString1);
    localIntent.putExtra("KEY_NOTIFICATION_ICON", paramInt);
    localIntent.setAction("ACTION_SHOW_PERSIST_NOTIFICATION");
    v(paramContext, localIntent);
  }
  
  public static void v(Context paramContext, Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramContext.startForegroundService(paramIntent);
      return;
    }
    paramContext.startService(paramIntent);
  }
  
  public static void w(Context paramContext)
  {
    if (l(paramContext)) {
      return;
    }
    a.e(paramContext, "KEY_MANUAL_STOP", true);
    Intent localIntent = new Intent(paramContext, CIMPushService.class);
    localIntent.setAction("ACTION_CLOSE_CIM_CONNECTION");
    v(paramContext, localIntent);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.cim.sdk.android.h
 * JD-Core Version:    0.7.0.1
 */