package com.baidu.platform.comjni.map.dataengine;

import android.os.Bundle;
import com.baidu.platform.comjni.NativeComponent;

public class NADataEngine
  extends NativeComponent
{
  private native void nativeCancelThumbImageRequest(long paramLong);
  
  private native long nativeCreate();
  
  private native String nativeGetCurrentStreetId(long paramLong);
  
  private native String nativeGetCurrentStreetInfo(long paramLong, Bundle paramBundle);
  
  private native boolean nativeGetHotMapCityInfo(long paramLong, Bundle paramBundle);
  
  private native boolean nativeGetStreetCityInfo(long paramLong, Bundle paramBundle);
  
  private native boolean nativeQueryThumbImage(long paramLong, String paramString);
  
  private native int nativeRelease(long paramLong);
  
  private native void nativeSetStreetPOIUID(long paramLong, String paramString);
  
  private native boolean nativeStreetSwitchByUID(long paramLong, String paramString1, String paramString2);
  
  private native boolean nativeStreetSwitchToID(long paramLong, String paramString, int paramInt);
  
  private native boolean nativeStreetSwitchToIDFromReGeo(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3);
  
  private native boolean nativeStreetSwitchToIID(long paramLong, String paramString1, String paramString2, boolean paramBoolean);
  
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
 * Qualified Name:     com.baidu.platform.comjni.map.dataengine.NADataEngine
 * JD-Core Version:    0.7.0.1
 */