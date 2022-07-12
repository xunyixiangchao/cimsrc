package org.webrtc;

public abstract class WrappedNativeVideoEncoder
  implements VideoEncoder
{
  public abstract long createNativeVideoEncoder();
  
  public final VideoCodecStatus encode(VideoFrame paramVideoFrame, VideoEncoder.EncodeInfo paramEncodeInfo)
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public final String getImplementationName()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public final VideoEncoder.ScalingSettings getScalingSettings()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public final VideoCodecStatus initEncode(VideoEncoder.Settings paramSettings, VideoEncoder.Callback paramCallback)
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public abstract boolean isHardwareEncoder();
  
  public final VideoCodecStatus release()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public final VideoCodecStatus setRateAllocation(VideoEncoder.BitrateAllocation paramBitrateAllocation, int paramInt)
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.WrappedNativeVideoEncoder
 * JD-Core Version:    0.7.0.1
 */