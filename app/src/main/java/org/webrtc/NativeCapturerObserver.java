package org.webrtc;

class NativeCapturerObserver
  implements CapturerObserver
{
  private final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource;
  
  @CalledByNative
  public NativeCapturerObserver(long paramLong)
  {
    this.nativeAndroidVideoTrackSource = new NativeAndroidVideoTrackSource(paramLong);
  }
  
  public void onCapturerStarted(boolean paramBoolean)
  {
    this.nativeAndroidVideoTrackSource.setState(paramBoolean);
  }
  
  public void onCapturerStopped()
  {
    this.nativeAndroidVideoTrackSource.setState(false);
  }
  
  public void onFrameCaptured(VideoFrame paramVideoFrame)
  {
    VideoProcessor.FrameAdaptationParameters localFrameAdaptationParameters = this.nativeAndroidVideoTrackSource.adaptFrame(paramVideoFrame);
    if (localFrameAdaptationParameters == null) {
      return;
    }
    VideoFrame.Buffer localBuffer = paramVideoFrame.getBuffer().cropAndScale(localFrameAdaptationParameters.cropX, localFrameAdaptationParameters.cropY, localFrameAdaptationParameters.cropWidth, localFrameAdaptationParameters.cropHeight, localFrameAdaptationParameters.scaleWidth, localFrameAdaptationParameters.scaleHeight);
    this.nativeAndroidVideoTrackSource.onFrameCaptured(new VideoFrame(localBuffer, paramVideoFrame.getRotation(), localFrameAdaptationParameters.timestampNs));
    localBuffer.release();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.NativeCapturerObserver
 * JD-Core Version:    0.7.0.1
 */