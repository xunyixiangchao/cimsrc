package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comjni.tools.a;

public class OpenLogUtil
{
  private static ModuleName a;
  private static boolean b = true;
  private static boolean c = false;
  private static String d;
  
  public static String getMapLogFilePath()
  {
    return d;
  }
  
  public static boolean isMapLogEnable()
  {
    return c;
  }
  
  public static boolean isNativeLogAnalysisEnable()
  {
    return b;
  }
  
  public static void setMapLogEnable(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public static void setMapLogFilePath(String paramString)
  {
    d = paramString;
  }
  
  public static void setModuleLogEnable(ModuleName paramModuleName, boolean paramBoolean)
  {
    a = paramModuleName;
    a.a(paramBoolean, paramModuleName.ordinal());
  }
  
  public static void setNativeLogAnalysisEnable(boolean paramBoolean)
  {
    b = paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.OpenLogUtil
 * JD-Core Version:    0.7.0.1
 */