package com.baidu.platform.comapi.verify;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build.VERSION;

public class SignUtils
{
  private static int a = 621133959;
  
  private static int a(Context paramContext)
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 28)
      {
        if (paramContext.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 134217728).signingInfo.hasMultipleSigners()) {
          paramContext = paramContext.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 134217728).signingInfo.getApkContentsSigners();
        } else {
          paramContext = paramContext.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 134217728).signingInfo.getSigningCertificateHistory();
        }
      }
      else {
        paramContext = paramContext.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 64).signatures;
      }
      i = paramContext[0].hashCode();
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  private static boolean b(Context paramContext)
  {
    return a(paramContext) == a;
  }
  
  public static boolean verifySign(Context paramContext)
  {
    return b(paramContext);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.verify.SignUtils
 * JD-Core Version:    0.7.0.1
 */