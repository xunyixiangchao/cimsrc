package org.webrtc;

public class MediaSource
{
  private long nativeSource;
  private final RefCountDelegate refCountDelegate;
  
  public MediaSource(long paramLong)
  {
    this.refCountDelegate = new RefCountDelegate(new t(paramLong));
    this.nativeSource = paramLong;
  }
  
  private void checkMediaSourceExists()
  {
    if (this.nativeSource != 0L) {
      return;
    }
    throw new IllegalStateException("MediaSource has been disposed.");
  }
  
  private static native State nativeGetState(long paramLong);
  
  public void dispose()
  {
    checkMediaSourceExists();
    this.refCountDelegate.release();
    this.nativeSource = 0L;
  }
  
  protected long getNativeMediaSource()
  {
    checkMediaSourceExists();
    return this.nativeSource;
  }
  
  void runWithReference(Runnable paramRunnable)
  {
    if (this.refCountDelegate.safeRetain()) {
      try
      {
        paramRunnable.run();
        return;
      }
      finally
      {
        this.refCountDelegate.release();
      }
    }
  }
  
  public State state()
  {
    checkMediaSourceExists();
    return nativeGetState(this.nativeSource);
  }
  
  public static enum State
  {
    static
    {
      State localState1 = new State("INITIALIZING", 0);
      INITIALIZING = localState1;
      State localState2 = new State("LIVE", 1);
      LIVE = localState2;
      State localState3 = new State("ENDED", 2);
      ENDED = localState3;
      State localState4 = new State("MUTED", 3);
      MUTED = localState4;
      $VALUES = new State[] { localState1, localState2, localState3, localState4 };
    }
    
    private State() {}
    
    @CalledByNative("State")
    static State fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.MediaSource
 * JD-Core Version:    0.7.0.1
 */