package org.webrtc;

public final class CandidatePairChangeEvent
{
  public final int estimatedDisconnectedTimeMs;
  public final int lastDataReceivedMs;
  public final IceCandidate local;
  public final String reason;
  public final IceCandidate remote;
  
  @CalledByNative
  CandidatePairChangeEvent(IceCandidate paramIceCandidate1, IceCandidate paramIceCandidate2, int paramInt1, String paramString, int paramInt2)
  {
    this.local = paramIceCandidate1;
    this.remote = paramIceCandidate2;
    this.lastDataReceivedMs = paramInt1;
    this.reason = paramString;
    this.estimatedDisconnectedTimeMs = paramInt2;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.CandidatePairChangeEvent
 * JD-Core Version:    0.7.0.1
 */