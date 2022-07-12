package org.webrtc;

import java.util.List;

public class RtpSender
{
  private MediaStreamTrack cachedTrack;
  private final DtmfSender dtmfSender;
  private long nativeRtpSender;
  private boolean ownsTrack = true;
  
  @CalledByNative
  public RtpSender(long paramLong)
  {
    this.nativeRtpSender = paramLong;
    this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(paramLong));
    paramLong = nativeGetDtmfSender(paramLong);
    DtmfSender localDtmfSender;
    if (paramLong != 0L) {
      localDtmfSender = new DtmfSender(paramLong);
    } else {
      localDtmfSender = null;
    }
    this.dtmfSender = localDtmfSender;
  }
  
  private void checkRtpSenderExists()
  {
    if (this.nativeRtpSender != 0L) {
      return;
    }
    throw new IllegalStateException("RtpSender has been disposed.");
  }
  
  private static native long nativeGetDtmfSender(long paramLong);
  
  private static native String nativeGetId(long paramLong);
  
  private static native RtpParameters nativeGetParameters(long paramLong);
  
  private static native List<String> nativeGetStreams(long paramLong);
  
  private static native long nativeGetTrack(long paramLong);
  
  private static native void nativeSetFrameEncryptor(long paramLong1, long paramLong2);
  
  private static native boolean nativeSetParameters(long paramLong, RtpParameters paramRtpParameters);
  
  private static native void nativeSetStreams(long paramLong, List<String> paramList);
  
  private static native boolean nativeSetTrack(long paramLong1, long paramLong2);
  
  public void dispose()
  {
    checkRtpSenderExists();
    Object localObject = this.dtmfSender;
    if (localObject != null) {
      ((DtmfSender)localObject).dispose();
    }
    localObject = this.cachedTrack;
    if ((localObject != null) && (this.ownsTrack)) {
      ((MediaStreamTrack)localObject).dispose();
    }
    JniCommon.nativeReleaseRef(this.nativeRtpSender);
    this.nativeRtpSender = 0L;
  }
  
  public DtmfSender dtmf()
  {
    return this.dtmfSender;
  }
  
  long getNativeRtpSender()
  {
    checkRtpSenderExists();
    return this.nativeRtpSender;
  }
  
  public RtpParameters getParameters()
  {
    checkRtpSenderExists();
    return nativeGetParameters(this.nativeRtpSender);
  }
  
  public List<String> getStreams()
  {
    checkRtpSenderExists();
    return nativeGetStreams(this.nativeRtpSender);
  }
  
  public String id()
  {
    checkRtpSenderExists();
    return nativeGetId(this.nativeRtpSender);
  }
  
  public void setFrameEncryptor(FrameEncryptor paramFrameEncryptor)
  {
    checkRtpSenderExists();
    nativeSetFrameEncryptor(this.nativeRtpSender, paramFrameEncryptor.getNativeFrameEncryptor());
  }
  
  public boolean setParameters(RtpParameters paramRtpParameters)
  {
    checkRtpSenderExists();
    return nativeSetParameters(this.nativeRtpSender, paramRtpParameters);
  }
  
  public void setStreams(List<String> paramList)
  {
    checkRtpSenderExists();
    nativeSetStreams(this.nativeRtpSender, paramList);
  }
  
  public boolean setTrack(MediaStreamTrack paramMediaStreamTrack, boolean paramBoolean)
  {
    checkRtpSenderExists();
    long l2 = this.nativeRtpSender;
    long l1;
    if (paramMediaStreamTrack == null) {
      l1 = 0L;
    } else {
      l1 = paramMediaStreamTrack.getNativeMediaStreamTrack();
    }
    if (!nativeSetTrack(l2, l1)) {
      return false;
    }
    MediaStreamTrack localMediaStreamTrack = this.cachedTrack;
    if ((localMediaStreamTrack != null) && (this.ownsTrack)) {
      localMediaStreamTrack.dispose();
    }
    this.cachedTrack = paramMediaStreamTrack;
    this.ownsTrack = paramBoolean;
    return true;
  }
  
  public MediaStreamTrack track()
  {
    return this.cachedTrack;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.RtpSender
 * JD-Core Version:    0.7.0.1
 */