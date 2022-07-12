package com.baidu.platform.comjni.map.msgcenter;

import com.baidu.platform.comjni.JNIBaseApi;

public class NAMsgCenter
  extends JNIBaseApi
{
  private native boolean nativeCancelRequest(long paramLong);
  
  private native long nativeCreate();
  
  private native boolean nativeFetchAccessToken(long paramLong);
  
  private native String nativeGetCenterParam(long paramLong, String paramString);
  
  private native boolean nativeMSGCStartup(long paramLong);
  
  private native boolean nativeRegMsgCenter(long paramLong, String paramString);
  
  private native int nativeRelease(long paramLong);
  
  private native boolean nativeSetCenterParam(long paramLong, String paramString);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.map.msgcenter.NAMsgCenter
 * JD-Core Version:    0.7.0.1
 */