package com.baidu.platform.comjni.util;

import com.baidu.platform.comjni.JNIBaseApi;

@Deprecated
public class JNIMD5
  extends JNIBaseApi
{
  public static native String EncodeUrlParamsValue(String paramString);
  
  public static native String GetSignMD5String(String paramString);
  
  public static native String GetWebSignMD5String(String paramString);
  
  public static native String SignOpra(String paramString);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.util.JNIMD5
 * JD-Core Version:    0.7.0.1
 */