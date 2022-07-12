package com.baidu.mapapi;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;

public class SDKInitializer
{
  public static final String SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR = "network error";
  public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR = "permission check error";
  public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK = "permission check ok";
  public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE = "error_code";
  public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE = "error_message";
  private static CoordType a = CoordType.BD09LL;
  
  public static CoordType getCoordType()
  {
    return a;
  }
  
  public static void initialize(Context paramContext)
  {
    Initializer.initialize(paramContext, false, null, null, null);
  }
  
  public static void initialize(Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    Initializer.initialize(paramContext, paramBoolean, paramString1, paramString2, null);
  }
  
  public static void initialize(String paramString, Context paramContext)
  {
    Initializer.initialize(paramContext, false, null, paramString, null);
  }
  
  public static boolean isHttpsEnable()
  {
    return HttpClient.isHttpsEnable;
  }
  
  public static void setAgreePrivacy(Context paramContext, boolean paramBoolean)
  {
    Initializer.setPrivacyMode(paramContext, paramBoolean);
  }
  
  public static void setApiKey(String paramString)
  {
    PermissionCheck.setApiKey(paramString);
  }
  
  public static void setCoordType(CoordType paramCoordType)
  {
    a = paramCoordType;
  }
  
  public static void setHttpsEnable(boolean paramBoolean)
  {
    HttpClient.isHttpsEnable = paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.SDKInitializer
 * JD-Core Version:    0.7.0.1
 */