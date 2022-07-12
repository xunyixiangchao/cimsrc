package androidx.camera.core;

import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import s.d0;
import x0.h;

class o
  implements Executor
{
  private static final ThreadFactory c = new a();
  private final Object a = new Object();
  private ThreadPoolExecutor b = b();
  
  private static ThreadPoolExecutor b()
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), c);
    localThreadPoolExecutor.setRejectedExecutionHandler(n.a);
    return localThreadPoolExecutor;
  }
  
  void c(d0 paramd0)
  {
    h.g(paramd0);
    synchronized (this.a)
    {
      if (this.b.isShutdown()) {
        this.b = b();
      }
      ThreadPoolExecutor localThreadPoolExecutor = this.b;
      int i = Math.max(1, paramd0.c().size());
      localThreadPoolExecutor.setMaximumPoolSize(i);
      localThreadPoolExecutor.setCorePoolSize(i);
      return;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    h.g(paramRunnable);
    synchronized (this.a)
    {
      this.b.execute(paramRunnable);
      return;
    }
  }
  
  class a
    implements ThreadFactory
  {
    private final AtomicInteger a = new AtomicInteger(0);
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      paramRunnable.setName(String.format(Locale.US, "CameraX-core_camera_%d", new Object[] { Integer.valueOf(this.a.getAndIncrement()) }));
      return paramRunnable;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.o
 * JD-Core Version:    0.7.0.1
 */