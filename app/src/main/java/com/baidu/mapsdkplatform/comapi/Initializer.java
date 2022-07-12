package com.baidu.mapsdkplatform.comapi;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.platform.comapi.util.SysOSUtil;
import java.io.File;
import java.io.IOException;

public class Initializer
{
  private static boolean a = false;
  private static boolean b = false;
  
  private static boolean a(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("/check.0");
        paramString = new File(localStringBuilder.toString());
        if (paramString.exists()) {
          paramString.delete();
        }
        paramString.createNewFile();
        if (paramString.exists()) {
          paramString.delete();
        }
        return true;
      }
      catch (IOException paramString)
      {
        Log.e("SDKInitializer", "SDCard cache path invalid", paramString);
        throw new IllegalArgumentException("BDMapSDKException: Provided sdcard cache path invalid can not used.");
      }
    }
    return false;
  }
  
  public static void initialize(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (a) {
      return;
    }
    if (paramContext != null)
    {
      if ((paramContext instanceof Application))
      {
        NativeLoader.setContext(paramContext);
        NativeLoader.a(paramBoolean, paramString1);
        JNIInitializer.setContext((Application)paramContext);
        SysOSUtil.getInstance().init(new com.baidu.platform.comapi.util.a.b(), new com.baidu.platform.comapi.util.a.a());
        a.e().a(paramContext);
        a.e().g();
        if (a(paramString2)) {
          EnvironmentUtilities.setSDCardPath(paramString2);
        }
        EnvironmentUtilities.initAppDirectory(paramContext);
        if (OpenLogUtil.isNativeLogAnalysisEnable()) {
          com.baidu.mapsdkplatform.comapi.c.a.b.c().a(paramContext);
        }
        a = true;
        return;
      }
      throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
    }
    throw new IllegalArgumentException("BDMapSDKException: context can not be null");
  }
  
  public static boolean isAgreePrivacyMode()
  {
    return b;
  }
  
  public static boolean isInitialized()
  {
    return a;
  }
  
  public static void setPrivacyMode(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if ((paramContext instanceof Application))
      {
        b = paramBoolean;
        PermissionCheck.setPrivacyMode(paramBoolean);
        LBSAuthManager.getInstance(paramContext).setPrivacyMode(paramBoolean);
        return;
      }
      throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
    }
    throw new IllegalArgumentException("BDMapSDKException: context can not be null");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.Initializer
 * JD-Core Version:    0.7.0.1
 */