package org.webrtc;

public class LibvpxVp9Decoder
  extends WrappedNativeVideoDecoder
{
  static native long nativeCreateDecoder();
  
  static native boolean nativeIsSupported();
  
  public long createNativeVideoDecoder()
  {
    return nativeCreateDecoder();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.LibvpxVp9Decoder
 * JD-Core Version:    0.7.0.1
 */