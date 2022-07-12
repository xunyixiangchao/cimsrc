package org.webrtc;

public abstract interface VideoEncoderFactory
{
  @CalledByNative
  public abstract VideoEncoder createEncoder(VideoCodecInfo paramVideoCodecInfo);
  
  @CalledByNative
  public abstract VideoEncoderSelector getEncoderSelector();
  
  @CalledByNative
  public abstract VideoCodecInfo[] getImplementations();
  
  @CalledByNative
  public abstract VideoCodecInfo[] getSupportedCodecs();
  
  public static abstract interface VideoEncoderSelector
  {
    @CalledByNative("VideoEncoderSelector")
    public abstract VideoCodecInfo onAvailableBitrate(int paramInt);
    
    @CalledByNative("VideoEncoderSelector")
    public abstract void onCurrentEncoder(VideoCodecInfo paramVideoCodecInfo);
    
    @CalledByNative("VideoEncoderSelector")
    public abstract VideoCodecInfo onEncoderBroken();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoEncoderFactory
 * JD-Core Version:    0.7.0.1
 */