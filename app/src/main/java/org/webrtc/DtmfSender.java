package org.webrtc;

public class DtmfSender
{
  private long nativeDtmfSender;
  
  public DtmfSender(long paramLong)
  {
    this.nativeDtmfSender = paramLong;
  }
  
  private void checkDtmfSenderExists()
  {
    if (this.nativeDtmfSender != 0L) {
      return;
    }
    throw new IllegalStateException("DtmfSender has been disposed.");
  }
  
  private static native boolean nativeCanInsertDtmf(long paramLong);
  
  private static native int nativeDuration(long paramLong);
  
  private static native boolean nativeInsertDtmf(long paramLong, String paramString, int paramInt1, int paramInt2);
  
  private static native int nativeInterToneGap(long paramLong);
  
  private static native String nativeTones(long paramLong);
  
  public boolean canInsertDtmf()
  {
    checkDtmfSenderExists();
    return nativeCanInsertDtmf(this.nativeDtmfSender);
  }
  
  public void dispose()
  {
    checkDtmfSenderExists();
    JniCommon.nativeReleaseRef(this.nativeDtmfSender);
    this.nativeDtmfSender = 0L;
  }
  
  public int duration()
  {
    checkDtmfSenderExists();
    return nativeDuration(this.nativeDtmfSender);
  }
  
  public boolean insertDtmf(String paramString, int paramInt1, int paramInt2)
  {
    checkDtmfSenderExists();
    return nativeInsertDtmf(this.nativeDtmfSender, paramString, paramInt1, paramInt2);
  }
  
  public int interToneGap()
  {
    checkDtmfSenderExists();
    return nativeInterToneGap(this.nativeDtmfSender);
  }
  
  public String tones()
  {
    checkDtmfSenderExists();
    return nativeTones(this.nativeDtmfSender);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.DtmfSender
 * JD-Core Version:    0.7.0.1
 */