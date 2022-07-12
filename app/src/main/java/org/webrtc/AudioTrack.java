package org.webrtc;

public class AudioTrack
  extends MediaStreamTrack
{
  public AudioTrack(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void nativeSetVolume(long paramLong, double paramDouble);
  
  long getNativeAudioTrack()
  {
    return getNativeMediaStreamTrack();
  }
  
  public void setVolume(double paramDouble)
  {
    nativeSetVolume(getNativeAudioTrack(), paramDouble);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.AudioTrack
 * JD-Core Version:    0.7.0.1
 */