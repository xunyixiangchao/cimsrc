package com.baidu.mapapi.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

public class OpenClientUtil
{
  public static int getBaiduMapVersion(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 0).versionName;
      if (paramContext != null)
      {
        if (paramContext.length() <= 0) {
          return 0;
        }
        int i = Integer.valueOf(paramContext.trim().replace(".", "").trim()).intValue();
        return i;
      }
      return 0;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static void getLatestBaiduMapApp(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    String str = a.a(paramContext);
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://map.baidu.com/zt/client/index/?fr=sdk_[");
    localStringBuilder.append(str);
    localStringBuilder.append("]");
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    paramContext.startActivity(localIntent);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.utils.OpenClientUtil
 * JD-Core Version:    0.7.0.1
 */