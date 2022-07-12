package org.webrtc;

class WebRtcClassLoader
{
  @CalledByNative
  static Object getClassLoader()
  {
    ClassLoader localClassLoader = WebRtcClassLoader.class.getClassLoader();
    if (localClassLoader != null) {
      return localClassLoader;
    }
    throw new RuntimeException("Failed to get WebRTC class loader.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.WebRtcClassLoader
 * JD-Core Version:    0.7.0.1
 */