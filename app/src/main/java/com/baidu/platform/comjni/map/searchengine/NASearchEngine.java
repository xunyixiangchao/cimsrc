package com.baidu.platform.comjni.map.searchengine;

import com.baidu.platform.comjni.NativeComponent;

public class NASearchEngine
  extends NativeComponent
{
  public NASearchEngine()
  {
    create();
  }
  
  private static native boolean nativeCancelRequest(long paramLong, int paramInt);
  
  private static native long nativeCreate();
  
  private static native String nativeGetJsonResult(long paramLong, int paramInt);
  
  private static native byte[] nativeGetProtobufResult(long paramLong, int paramInt);
  
  private static native boolean nativeInit(long paramLong, int paramInt);
  
  private static native boolean nativeInitWithBundle(long paramLong, String paramString);
  
  private static native int nativeRelease(long paramLong);
  
  private static native int nativeRequest(long paramLong, String paramString);
  
  private static native boolean nativeRequestData(long paramLong, byte[] paramArrayOfByte);
  
  private static native void nativeUpdateOfflineSearchPath(long paramLong, String paramString);
  
  public long create()
  {
    this.mNativePointer = nativeCreate();
    return this.mNativePointer;
  }
  
  public int dispose()
  {
    if (this.mNativePointer != 0L) {
      return nativeRelease(this.mNativePointer);
    }
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.map.searchengine.NASearchEngine
 * JD-Core Version:    0.7.0.1
 */