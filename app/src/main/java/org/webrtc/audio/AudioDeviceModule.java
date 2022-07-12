package org.webrtc.audio;

public abstract interface AudioDeviceModule
{
  public abstract long getNativeAudioDeviceModulePointer();
  
  public abstract void release();
  
  public abstract void setMicrophoneMute(boolean paramBoolean);
  
  public abstract void setSpeakerMute(boolean paramBoolean);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.audio.AudioDeviceModule
 * JD-Core Version:    0.7.0.1
 */