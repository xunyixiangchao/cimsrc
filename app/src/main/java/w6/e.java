package w6;

import org.webrtc.AudioTrack;
import org.webrtc.IceCandidate;
import org.webrtc.MediaStream;
import org.webrtc.SessionDescription;
import org.webrtc.VideoTrack;

public abstract interface e
{
  public abstract void F0(long paramLong, MediaStream paramMediaStream);
  
  public abstract void T(long paramLong, MediaStream paramMediaStream);
  
  public abstract void Y(long paramLong, IceCandidate paramIceCandidate);
  
  public abstract void c0(long paramLong, AudioTrack paramAudioTrack);
  
  public abstract void e0(long paramLong, SessionDescription paramSessionDescription);
  
  public abstract void p0(long paramLong, VideoTrack paramVideoTrack);
  
  public abstract void x0(long paramLong, SessionDescription paramSessionDescription);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w6.e
 * JD-Core Version:    0.7.0.1
 */