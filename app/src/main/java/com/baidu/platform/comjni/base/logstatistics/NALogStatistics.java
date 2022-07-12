package com.baidu.platform.comjni.base.logstatistics;

import com.baidu.platform.comjni.NativeComponent;

public class NALogStatistics
  extends NativeComponent
{
  public NALogStatistics()
  {
    create();
  }
  
  public static native boolean nativeAddLog(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3);
  
  public static native long nativeCreate();
  
  public static native int nativeRelease(long paramLong);
  
  public static native boolean nativeSave(long paramLong);
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    return false;
  }
  
  public long create()
  {
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
 * Qualified Name:     com.baidu.platform.comjni.base.logstatistics.NALogStatistics
 * JD-Core Version:    0.7.0.1
 */