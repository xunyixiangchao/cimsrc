package com.baidu.mapapi.common;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.util.f;

public class SysOSUtil
{
  public static float getDensity()
  {
    return f.t;
  }
  
  public static int getDensityDpi()
  {
    return f.c();
  }
  
  public static String getDeviceID()
  {
    String str = f.b();
    if (TextUtils.isEmpty(str)) {
      return str;
    }
    return str.substring(0, str.indexOf("|"));
  }
  
  public static String getModuleFileName()
  {
    return f.d();
  }
  
  public static String getPhoneType()
  {
    return f.j();
  }
  
  public static int getScreenSizeX()
  {
    return f.k();
  }
  
  public static int getScreenSizeY()
  {
    return f.l();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.common.SysOSUtil
 * JD-Core Version:    0.7.0.1
 */