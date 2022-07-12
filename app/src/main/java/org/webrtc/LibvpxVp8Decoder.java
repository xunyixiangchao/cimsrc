package org.webrtc;

public class LibvpxVp8Decoder
  extends WrappedNativeVideoDecoder
{
  static native long nativeCreateDecoder();
  
  public long createNativeVideoDecoder()
  {
    return nativeCreateDecoder();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.LibvpxVp8Decoder
 * JD-Core Version:    0.7.0.1
 */