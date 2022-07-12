package t;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class e
  implements Executor
{
  private static volatile Executor b;
  private final ExecutorService a = Executors.newFixedThreadPool(2, new a());
  
  static Executor a()
  {
    if (b != null) {
      return b;
    }
    try
    {
      if (b == null) {
        b = new e();
      }
      return b;
    }
    finally {}
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.a.execute(paramRunnable);
  }
  
  class a
    implements ThreadFactory
  {
    private final AtomicInteger a = new AtomicInteger(0);
    
    a() {}
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      paramRunnable.setName(String.format(Locale.US, "CameraX-camerax_io_%d", new Object[] { Integer.valueOf(this.a.getAndIncrement()) }));
      return paramRunnable;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t.e
 * JD-Core Version:    0.7.0.1
 */