package u3;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class m0
{
  private static final HandlerThread a;
  private static final Handler b;
  private static final Handler c;
  
  static
  {
    HandlerThread localHandlerThread = new HandlerThread(m0.class.getName(), 10);
    a = localHandlerThread;
    c = new Handler(Looper.getMainLooper());
    localHandlerThread.start();
    b = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    d(b, paramRunnable, paramLong);
  }
  
  public static void b(Runnable paramRunnable)
  {
    d(c, paramRunnable, 0L);
  }
  
  public static void c(Runnable paramRunnable, long paramLong)
  {
    d(c, paramRunnable, paramLong);
  }
  
  private static void d(Handler paramHandler, Runnable paramRunnable, long paramLong)
  {
    paramHandler.removeCallbacks(paramRunnable);
    if (paramLong > 0L)
    {
      paramHandler.postDelayed(paramRunnable, paramLong);
      return;
    }
    paramHandler.post(paramRunnable);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.m0
 * JD-Core Version:    0.7.0.1
 */