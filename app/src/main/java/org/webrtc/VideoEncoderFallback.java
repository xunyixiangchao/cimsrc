package org.webrtc;

public class VideoEncoderFallback
  extends WrappedNativeVideoEncoder
{
  private final VideoEncoder fallback;
  private final VideoEncoder primary;
  
  public VideoEncoderFallback(VideoEncoder paramVideoEncoder1, VideoEncoder paramVideoEncoder2)
  {
    this.fallback = paramVideoEncoder1;
    this.primary = paramVideoEncoder2;
  }
  
  private static native long nativeCreateEncoder(VideoEncoder paramVideoEncoder1, VideoEncoder paramVideoEncoder2);
  
  public long createNativeVideoEncoder()
  {
    return nativeCreateEncoder(this.fallback, this.primary);
  }
  
  public boolean isHardwareEncoder()
  {
    return this.primary.isHardwareEncoder();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoEncoderFallback
 * JD-Core Version:    0.7.0.1
 */