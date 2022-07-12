package org.webrtc;

public class LibvpxVp9Encoder
  extends WrappedNativeVideoEncoder
{
  static native long nativeCreateEncoder();
  
  static native boolean nativeIsSupported();
  
  public long createNativeVideoEncoder()
  {
    return nativeCreateEncoder();
  }
  
  public boolean isHardwareEncoder()
  {
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.LibvpxVp9Encoder
 * JD-Core Version:    0.7.0.1
 */