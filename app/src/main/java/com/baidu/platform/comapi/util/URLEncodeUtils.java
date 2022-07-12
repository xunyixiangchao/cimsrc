package com.baidu.platform.comapi.util;

import com.baidu.platform.comjni.JNIBaseApi;

public final class URLEncodeUtils
  extends JNIBaseApi
{
  public static String generateSign(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      return nativeMD5Sign(paramString);
    }
    if (paramInt == 2) {
      return nativeWebSign(paramString);
    }
    if (paramInt == 3) {
      return nativeOperSign(paramString);
    }
    return "";
  }
  
  public static String getMD5String(String paramString)
  {
    return MD5.getMD5String(paramString);
  }
  
  private static native String nativeMD5Sign(String paramString);
  
  private static native String nativeOperSign(String paramString);
  
  private static native String nativeUrlEncode(String paramString);
  
  private static native String nativeWebSign(String paramString);
  
  public static String urlEncode(String paramString)
  {
    return nativeUrlEncode(paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.URLEncodeUtils
 * JD-Core Version:    0.7.0.1
 */