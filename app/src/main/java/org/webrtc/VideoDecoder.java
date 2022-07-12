package org.webrtc;

public abstract interface VideoDecoder
{
  @CalledByNative
  public abstract long createNativeVideoDecoder();
  
  @CalledByNative
  public abstract VideoCodecStatus decode(EncodedImage paramEncodedImage, DecodeInfo paramDecodeInfo);
  
  @CalledByNative
  public abstract String getImplementationName();
  
  @CalledByNative
  public abstract boolean getPrefersLateDecoding();
  
  @CalledByNative
  public abstract VideoCodecStatus initDecode(Settings paramSettings, Callback paramCallback);
  
  @CalledByNative
  public abstract VideoCodecStatus release();
  
  public static abstract interface Callback
  {
    public abstract void onDecodedFrame(VideoFrame paramVideoFrame, Integer paramInteger1, Integer paramInteger2);
  }
  
  public static class DecodeInfo
  {
    public final boolean isMissingFrames;
    public final long renderTimeMs;
    
    public DecodeInfo(boolean paramBoolean, long paramLong)
    {
      this.isMissingFrames = paramBoolean;
      this.renderTimeMs = paramLong;
    }
  }
  
  public static class Settings
  {
    public final int height;
    public final int numberOfCores;
    public final int width;
    
    @CalledByNative("Settings")
    public Settings(int paramInt1, int paramInt2, int paramInt3)
    {
      this.numberOfCores = paramInt1;
      this.width = paramInt2;
      this.height = paramInt3;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */