package com.baidu.mapapi.common;

import android.util.Log;

public class Logger
{
  public static boolean debugEnable()
  {
    return false;
  }
  
  public static void logD(String paramString1, String paramString2) {}
  
  public static void logE(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public static void logI(String paramString1, String paramString2) {}
  
  public static void logV(String paramString1, String paramString2) {}
  
  public static void logW(String paramString1, String paramString2) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.common.Logger
 * JD-Core Version:    0.7.0.1
 */