package org.webrtc;

public abstract interface VideoDecoderFactory
{
  @Deprecated
  public abstract VideoDecoder createDecoder(String paramString);
  
  @CalledByNative
  public abstract VideoDecoder createDecoder(VideoCodecInfo paramVideoCodecInfo);
  
  @CalledByNative
  public abstract VideoCodecInfo[] getSupportedCodecs();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoDecoderFactory
 * JD-Core Version:    0.7.0.1
 */