package org.webrtc;

public class CallSessionFileRotatingLogSink
{
  private long nativeSink;
  
  public CallSessionFileRotatingLogSink(String paramString, int paramInt, Logging.Severity paramSeverity)
  {
    if (paramString != null)
    {
      this.nativeSink = nativeAddSink(paramString, paramInt, paramSeverity.ordinal());
      return;
    }
    throw new IllegalArgumentException("dirPath may not be null.");
  }
  
  public static byte[] getLogData(String paramString)
  {
    if (paramString != null) {
      return nativeGetLogData(paramString);
    }
    throw new IllegalArgumentException("dirPath may not be null.");
  }
  
  private static native long nativeAddSink(String paramString, int paramInt1, int paramInt2);
  
  private static native void nativeDeleteSink(long paramLong);
  
  private static native byte[] nativeGetLogData(String paramString);
  
  public void dispose()
  {
    long l = this.nativeSink;
    if (l != 0L)
    {
      nativeDeleteSink(l);
      this.nativeSink = 0L;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.CallSessionFileRotatingLogSink
 * JD-Core Version:    0.7.0.1
 */