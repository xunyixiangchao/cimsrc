package com.baidu.platform.comapi.util;

import com.baidu.platform.comjni.JNIBaseApi;

public final class EncryptUtil
  extends JNIBaseApi
{
  private static native String nativeDecrypt(String paramString1, String paramString2);
  
  private static native String nativeEncrypt(String paramString1, String paramString2);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.EncryptUtil
 * JD-Core Version:    0.7.0.1
 */