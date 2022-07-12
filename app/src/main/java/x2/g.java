package x2;

import android.annotation.TargetApi;
import android.os.SystemClock;

public final class g
{
  private static final double a = 1.0D / Math.pow(10.0D, 6.0D);
  
  public static double a(long paramLong)
  {
    return (b() - paramLong) * a;
  }
  
  @TargetApi(17)
  public static long b()
  {
    return SystemClock.elapsedRealtimeNanos();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x2.g
 * JD-Core Version:    0.7.0.1
 */