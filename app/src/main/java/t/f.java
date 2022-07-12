package t;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ScheduledExecutorService;

final class f
{
  private static volatile ScheduledExecutorService a;
  
  static ScheduledExecutorService a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      if (a == null) {
        a = new c(new Handler(Looper.getMainLooper()));
      }
      return a;
    }
    finally {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t.f
 * JD-Core Version:    0.7.0.1
 */