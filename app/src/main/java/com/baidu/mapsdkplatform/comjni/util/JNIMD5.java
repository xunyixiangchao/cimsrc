package com.baidu.mapsdkplatform.comjni.util;

public class JNIMD5
{
  public static native String encodeUrlParamsValue(String paramString);
  
  public static native String getSignMD5String(String paramString);
  
  public static native String getUrlNeedInfo();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comjni.util.JNIMD5
 * JD-Core Version:    0.7.0.1
 */