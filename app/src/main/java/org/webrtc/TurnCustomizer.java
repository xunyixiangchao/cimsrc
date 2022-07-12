package org.webrtc;

public class TurnCustomizer
{
  private long nativeTurnCustomizer;
  
  public TurnCustomizer(long paramLong)
  {
    this.nativeTurnCustomizer = paramLong;
  }
  
  private void checkTurnCustomizerExists()
  {
    if (this.nativeTurnCustomizer != 0L) {
      return;
    }
    throw new IllegalStateException("TurnCustomizer has been disposed.");
  }
  
  private static native void nativeFreeTurnCustomizer(long paramLong);
  
  public void dispose()
  {
    checkTurnCustomizerExists();
    nativeFreeTurnCustomizer(this.nativeTurnCustomizer);
    this.nativeTurnCustomizer = 0L;
  }
  
  @CalledByNative
  long getNativeTurnCustomizer()
  {
    checkTurnCustomizerExists();
    return this.nativeTurnCustomizer;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.TurnCustomizer
 * JD-Core Version:    0.7.0.1
 */