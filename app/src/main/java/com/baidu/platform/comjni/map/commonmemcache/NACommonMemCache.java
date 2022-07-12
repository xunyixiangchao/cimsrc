package com.baidu.platform.comjni.map.commonmemcache;

import com.baidu.platform.comjni.NativeComponent;

public class NACommonMemCache
  extends NativeComponent
{
  public NACommonMemCache()
  {
    create();
  }
  
  private static native long nativeCreate();
  
  private static native String nativeDecodeUsync(long paramLong, String paramString);
  
  private static native String nativeEnCrypt(long paramLong, String paramString);
  
  private static native String nativeEnCryptWithType(long paramLong, String paramString1, String paramString2);
  
  private static native String nativeEnCryptWithUsync(long paramLong, String paramString);
  
  private static native String nativeGetKeyString(long paramLong, String paramString);
  
  private static native String nativeGetPhoneInfoBundle(long paramLong, boolean paramBoolean);
  
  private static native String nativeGetPhoneInfoUrl(long paramLong);
  
  private static native String nativeGetSataInfo(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2);
  
  private static native void nativeInit(long paramLong, String paramString);
  
  private static native int nativeRelease(long paramLong);
  
  private static native void nativeSetKeyBundle(long paramLong, String paramString1, String paramString2);
  
  private static native void nativeSetKeyDouble(long paramLong, String paramString, double paramDouble);
  
  private static native void nativeSetKeyFloat(long paramLong, String paramString, float paramFloat);
  
  private static native void nativeSetKeyInt(long paramLong, String paramString, int paramInt);
  
  private static native void nativeSetKeyString(long paramLong, String paramString1, String paramString2);
  
  public void a(String paramString)
  {
    nativeInit(this.mNativePointer, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    nativeSetKeyBundle(this.mNativePointer, paramString1, paramString2);
  }
  
  public long create()
  {
    this.mNativePointer = nativeCreate();
    return this.mNativePointer;
  }
  
  public int dispose()
  {
    if (this.mNativePointer != 0L)
    {
      int i = nativeRelease(this.mNativePointer);
      this.mNativePointer = 0L;
      return i;
    }
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache
 * JD-Core Version:    0.7.0.1
 */