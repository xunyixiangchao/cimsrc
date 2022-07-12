package com.baidu.platform.comapi.map;

import android.view.Surface;

class VulkanDetect
{
  public static native long getNativeWindow(Surface paramSurface);
  
  public static native boolean isSupportedVulkan();
  
  public static native void releaseNativeWindow(long paramLong);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.VulkanDetect
 * JD-Core Version:    0.7.0.1
 */