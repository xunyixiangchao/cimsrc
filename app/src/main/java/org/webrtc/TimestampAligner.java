package org.webrtc;

public class TimestampAligner
{
  private volatile long nativeTimestampAligner = nativeCreateTimestampAligner();
  
  private void checkNativeAlignerExists()
  {
    if (this.nativeTimestampAligner != 0L) {
      return;
    }
    throw new IllegalStateException("TimestampAligner has been disposed.");
  }
  
  public static long getRtcTimeNanos()
  {
    return nativeRtcTimeNanos();
  }
  
  private static native long nativeCreateTimestampAligner();
  
  private static native void nativeReleaseTimestampAligner(long paramLong);
  
  private static native long nativeRtcTimeNanos();
  
  private static native long nativeTranslateTimestamp(long paramLong1, long paramLong2);
  
  public void dispose()
  {
    checkNativeAlignerExists();
    nativeReleaseTimestampAligner(this.nativeTimestampAligner);
    this.nativeTimestampAligner = 0L;
  }
  
  public long translateTimestamp(long paramLong)
  {
    checkNativeAlignerExists();
    return nativeTranslateTimestamp(this.nativeTimestampAligner, paramLong);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.TimestampAligner
 * JD-Core Version:    0.7.0.1
 */