package org.webrtc;

public class AudioSource
  extends MediaSource
{
  public AudioSource(long paramLong)
  {
    super(paramLong);
  }
  
  long getNativeAudioSource()
  {
    return getNativeMediaSource();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.AudioSource
 * JD-Core Version:    0.7.0.1
 */