package com.baidu.platform.comjni.base.networkdetect;

import com.baidu.platform.comjni.NativeComponent;

public class NANetworkDetect
  extends NativeComponent
{
  public NANetworkDetect()
  {
    create();
  }
  
  private native long nativeCreate();
  
  private native boolean nativeNetworkDetect(long paramLong, String paramString);
  
  private native int nativeRelease(long paramLong);
  
  public long create()
  {
    this.mNativePointer = nativeCreate();
    return this.mNativePointer;
  }
  
  public int dispose()
  {
    return nativeRelease(this.mNativePointer);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.base.networkdetect.NANetworkDetect
 * JD-Core Version:    0.7.0.1
 */