package org.webrtc;

public abstract class WrappedNativeVideoDecoder
  implements VideoDecoder
{
  public abstract long createNativeVideoDecoder();
  
  public final VideoCodecStatus decode(EncodedImage paramEncodedImage, VideoDecoder.DecodeInfo paramDecodeInfo)
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public final String getImplementationName()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public final boolean getPrefersLateDecoding()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public final VideoCodecStatus initDecode(VideoDecoder.Settings paramSettings, VideoDecoder.Callback paramCallback)
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public final VideoCodecStatus release()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.WrappedNativeVideoDecoder
 * JD-Core Version:    0.7.0.1
 */