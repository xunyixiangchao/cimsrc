package org.webrtc;

public abstract interface VideoSink
{
  @CalledByNative
  public abstract void onFrame(VideoFrame paramVideoFrame);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoSink
 * JD-Core Version:    0.7.0.1
 */