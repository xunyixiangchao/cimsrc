package t;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class d
  implements Executor
{
  private static volatile Executor b;
  private final ExecutorService a = Executors.newSingleThreadExecutor(new a());
  
  static Executor a()
  {
    if (b != null) {
      return b;
    }
    try
    {
      if (b == null) {
        b = new d();
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
    a() {}
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      paramRunnable.setPriority(10);
      paramRunnable.setName("CameraX-camerax_high_priority");
      return paramRunnable;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t.d
 * JD-Core Version:    0.7.0.1
 */