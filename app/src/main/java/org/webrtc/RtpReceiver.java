package org.webrtc;

public class RtpReceiver
{
  private MediaStreamTrack cachedTrack;
  private long nativeObserver;
  private long nativeRtpReceiver;
  
  @CalledByNative
  public RtpReceiver(long paramLong)
  {
    this.nativeRtpReceiver = paramLong;
    this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(paramLong));
  }
  
  private void checkRtpReceiverExists()
  {
    if (this.nativeRtpReceiver != 0L) {
      return;
    }
    throw new IllegalStateException("RtpReceiver has been disposed.");
  }
  
  private static native String nativeGetId(long paramLong);
  
  private static native RtpParameters nativeGetParameters(long paramLong);
  
  private static native long nativeGetTrack(long paramLong);
  
  private static native void nativeSetFrameDecryptor(long paramLong1, long paramLong2);
  
  private static native long nativeSetObserver(long paramLong, Observer paramObserver);
  
  private static native void nativeUnsetObserver(long paramLong1, long paramLong2);
  
  public void SetObserver(Observer paramObserver)
  {
    checkRtpReceiverExists();
    long l = this.nativeObserver;
    if (l != 0L) {
      nativeUnsetObserver(this.nativeRtpReceiver, l);
    }
    this.nativeObserver = nativeSetObserver(this.nativeRtpReceiver, paramObserver);
  }
  
  @CalledByNative
  public void dispose()
  {
    checkRtpReceiverExists();
    this.cachedTrack.dispose();
    long l = this.nativeObserver;
    if (l != 0L)
    {
      nativeUnsetObserver(this.nativeRtpReceiver, l);
      this.nativeObserver = 0L;
    }
    JniCommon.nativeReleaseRef(this.nativeRtpReceiver);
    this.nativeRtpReceiver = 0L;
  }
  
  public RtpParameters getParameters()
  {
    checkRtpReceiverExists();
    return nativeGetParameters(this.nativeRtpReceiver);
  }
  
  public String id()
  {
    checkRtpReceiverExists();
    return nativeGetId(this.nativeRtpReceiver);
  }
  
  public void setFrameDecryptor(FrameDecryptor paramFrameDecryptor)
  {
    checkRtpReceiverExists();
    nativeSetFrameDecryptor(this.nativeRtpReceiver, paramFrameDecryptor.getNativeFrameDecryptor());
  }
  
  public MediaStreamTrack track()
  {
    return this.cachedTrack;
  }
  
  public static abstract interface Observer
  {
    @CalledByNative("Observer")
    public abstract void onFirstPacketReceived(MediaStreamTrack.MediaType paramMediaType);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.RtpReceiver
 * JD-Core Version:    0.7.0.1
 */