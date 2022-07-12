package org.webrtc;

class NativeAndroidVideoTrackSource
{
  private final long nativeAndroidVideoTrackSource;
  
  public NativeAndroidVideoTrackSource(long paramLong)
  {
    this.nativeAndroidVideoTrackSource = paramLong;
  }
  
  @CalledByNative
  static VideoProcessor.FrameAdaptationParameters createFrameAdaptationParameters(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, boolean paramBoolean)
  {
    return new VideoProcessor.FrameAdaptationParameters(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramBoolean);
  }
  
  private static native VideoProcessor.FrameAdaptationParameters nativeAdaptFrame(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private static native void nativeAdaptOutputFormat(long paramLong, int paramInt1, int paramInt2, Integer paramInteger1, int paramInt3, int paramInt4, Integer paramInteger2, Integer paramInteger3);
  
  private static native void nativeOnFrameCaptured(long paramLong1, int paramInt, long paramLong2, VideoFrame.Buffer paramBuffer);
  
  private static native void nativeSetIsScreencast(long paramLong, boolean paramBoolean);
  
  private static native void nativeSetState(long paramLong, boolean paramBoolean);
  
  public VideoProcessor.FrameAdaptationParameters adaptFrame(VideoFrame paramVideoFrame)
  {
    return nativeAdaptFrame(this.nativeAndroidVideoTrackSource, paramVideoFrame.getBuffer().getWidth(), paramVideoFrame.getBuffer().getHeight(), paramVideoFrame.getRotation(), paramVideoFrame.getTimestampNs());
  }
  
  public void adaptOutputFormat(VideoSource.AspectRatio paramAspectRatio1, Integer paramInteger1, VideoSource.AspectRatio paramAspectRatio2, Integer paramInteger2, Integer paramInteger3)
  {
    nativeAdaptOutputFormat(this.nativeAndroidVideoTrackSource, paramAspectRatio1.width, paramAspectRatio1.height, paramInteger1, paramAspectRatio2.width, paramAspectRatio2.height, paramInteger2, paramInteger3);
  }
  
  public void onFrameCaptured(VideoFrame paramVideoFrame)
  {
    nativeOnFrameCaptured(this.nativeAndroidVideoTrackSource, paramVideoFrame.getRotation(), paramVideoFrame.getTimestampNs(), paramVideoFrame.getBuffer());
  }
  
  public void setIsScreencast(boolean paramBoolean)
  {
    nativeSetIsScreencast(this.nativeAndroidVideoTrackSource, paramBoolean);
  }
  
  public void setState(boolean paramBoolean)
  {
    nativeSetState(this.nativeAndroidVideoTrackSource, paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.NativeAndroidVideoTrackSource
 * JD-Core Version:    0.7.0.1
 */