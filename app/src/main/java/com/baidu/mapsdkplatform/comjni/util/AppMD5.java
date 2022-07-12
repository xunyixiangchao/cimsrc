package com.baidu.mapsdkplatform.comjni.util;

public class AppMD5
{
  public static String encodeUrlParamsValue(String paramString)
  {
    return JNIMD5.encodeUrlParamsValue(paramString);
  }
  
  public static String getSignMD5String(String paramString)
  {
    return JNIMD5.getSignMD5String(paramString);
  }
  
  public static String getUrlNeedInfo()
  {
    return JNIMD5.getUrlNeedInfo();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comjni.util.AppMD5
 * JD-Core Version:    0.7.0.1
 */