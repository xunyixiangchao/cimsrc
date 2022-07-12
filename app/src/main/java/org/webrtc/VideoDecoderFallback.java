package org.webrtc;

public class VideoDecoderFallback
  extends WrappedNativeVideoDecoder
{
  private final VideoDecoder fallback;
  private final VideoDecoder primary;
  
  public VideoDecoderFallback(VideoDecoder paramVideoDecoder1, VideoDecoder paramVideoDecoder2)
  {
    this.fallback = paramVideoDecoder1;
    this.primary = paramVideoDecoder2;
  }
  
  private static native long nativeCreateDecoder(VideoDecoder paramVideoDecoder1, VideoDecoder paramVideoDecoder2);
  
  public long createNativeVideoDecoder()
  {
    return nativeCreateDecoder(this.fallback, this.primary);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoDecoderFallback
 * JD-Core Version:    0.7.0.1
 */