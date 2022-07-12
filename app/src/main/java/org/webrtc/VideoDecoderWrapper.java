package org.webrtc;

class VideoDecoderWrapper
{
  @CalledByNative
  static VideoDecoder.Callback createDecoderCallback(long paramLong)
  {
    return new j0(paramLong);
  }
  
  private static native void nativeOnDecodedFrame(long paramLong, VideoFrame paramVideoFrame, Integer paramInteger1, Integer paramInteger2);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoDecoderWrapper
 * JD-Core Version:    0.7.0.1
 */