package t;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class a
{
  public static Executor a()
  {
    return b.a();
  }
  
  public static Executor b()
  {
    return d.a();
  }
  
  public static Executor c()
  {
    return e.a();
  }
  
  public static ScheduledExecutorService d()
  {
    return f.a();
  }
  
  public static ScheduledExecutorService e(Handler paramHandler)
  {
    return new c(paramHandler);
  }
  
  public static Executor f(Executor paramExecutor)
  {
    return new g(paramExecutor);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t.a
 * JD-Core Version:    0.7.0.1
 */