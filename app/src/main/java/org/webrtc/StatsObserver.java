package org.webrtc;

public abstract interface StatsObserver
{
  @CalledByNative
  public abstract void onComplete(StatsReport[] paramArrayOfStatsReport);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.StatsObserver
 * JD-Core Version:    0.7.0.1
 */