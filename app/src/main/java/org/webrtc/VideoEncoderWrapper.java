package org.webrtc;

class VideoEncoderWrapper
{
  @CalledByNative
  static VideoEncoder.Callback createEncoderCallback(long paramLong)
  {
    return new m0(paramLong);
  }
  
  @CalledByNative
  static Integer getScalingSettingsHigh(VideoEncoder.ScalingSettings paramScalingSettings)
  {
    return paramScalingSettings.high;
  }
  
  @CalledByNative
  static Integer getScalingSettingsLow(VideoEncoder.ScalingSettings paramScalingSettings)
  {
    return paramScalingSettings.low;
  }
  
  @CalledByNative
  static boolean getScalingSettingsOn(VideoEncoder.ScalingSettings paramScalingSettings)
  {
    return paramScalingSettings.on;
  }
  
  private static native void nativeOnEncodedFrame(long paramLong, EncodedImage paramEncodedImage);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoEncoderWrapper
 * JD-Core Version:    0.7.0.1
 */