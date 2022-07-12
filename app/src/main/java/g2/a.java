package g2;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  implements ExecutorService
{
  private static final long b = TimeUnit.SECONDS.toMillis(10L);
  private static volatile int c;
  private final ExecutorService a;
  
  a(ExecutorService paramExecutorService)
  {
    this.a = paramExecutorService;
  }
  
  public static int a()
  {
    if (c == 0) {
      c = Math.min(4, b.a());
    }
    return c;
  }
  
  public static b b()
  {
    int i;
    if (a() >= 4) {
      i = 2;
    } else {
      i = 1;
    }
    return new b(true).c(i).b("animation");
  }
  
  public static a c()
  {
    return b().a();
  }
  
  public static b d()
  {
    return new b(true).c(1).b("disk-cache");
  }
  
  public static a e()
  {
    return d().a();
  }
  
  public static b f()
  {
    return new b(false).c(a()).b("source");
  }
  
  public static a g()
  {
    return f().a();
  }
  
  public static a h()
  {
    return new a(new ThreadPoolExecutor(0, 2147483647, b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new d(new c(null), "source-unlimited", e.d, false)));
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.a.execute(paramRunnable);
  }
  
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection)
  {
    return this.a.invokeAll(paramCollection);
  }
  
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.invokeAll(paramCollection, paramLong, paramTimeUnit);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection)
  {
    return this.a.invokeAny(paramCollection);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.invokeAny(paramCollection, paramLong, paramTimeUnit);
  }
  
  public boolean isShutdown()
  {
    return this.a.isShutdown();
  }
  
  public boolean isTerminated()
  {
    return this.a.isTerminated();
  }
  
  public void shutdown()
  {
    this.a.shutdown();
  }
  
  public List<Runnable> shutdownNow()
  {
    return this.a.shutdownNow();
  }
  
  public Future<?> submit(Runnable paramRunnable)
  {
    return this.a.submit(paramRunnable);
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    return this.a.submit(paramRunnable, paramT);
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable)
  {
    return this.a.submit(paramCallable);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public static final class b
  {
    private final boolean a;
    private int b;
    private int c;
    private final ThreadFactory d = new a.c(null);
    private a.e e = a.e.d;
    private String f;
    private long g;
    
    b(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public a a()
    {
      if (!TextUtils.isEmpty(this.f))
      {
        localObject = new ThreadPoolExecutor(this.b, this.c, this.g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a.d(this.d, this.f, this.e, this.a));
        if (this.g != 0L) {
          ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
        }
        return new a((ExecutorService)localObject);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Name must be non-null and non-empty, but given: ");
      ((StringBuilder)localObject).append(this.f);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public b b(String paramString)
    {
      this.f = paramString;
      return this;
    }
    
    public b c(int paramInt)
    {
      this.b = paramInt;
      this.c = paramInt;
      return this;
    }
  }
  
  private static final class c
    implements ThreadFactory
  {
    public Thread newThread(Runnable paramRunnable)
    {
      return new a(paramRunnable);
    }
    
    class a
      extends Thread
    {
      a(Runnable paramRunnable)
      {
        super();
      }
      
      public void run()
      {
        Process.setThreadPriority(9);
        super.run();
      }
    }
  }
  
  private static final class d
    implements ThreadFactory
  {
    private final ThreadFactory a;
    private final String b;
    final a.e c;
    final boolean d;
    private final AtomicInteger e = new AtomicInteger();
    
    d(ThreadFactory paramThreadFactory, String paramString, a.e parame, boolean paramBoolean)
    {
      this.a = paramThreadFactory;
      this.b = paramString;
      this.c = parame;
      this.d = paramBoolean;
    }
    
    public Thread newThread(final Runnable paramRunnable)
    {
      paramRunnable = this.a.newThread(new a(paramRunnable));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("glide-");
      localStringBuilder.append(this.b);
      localStringBuilder.append("-thread-");
      localStringBuilder.append(this.e.getAndIncrement());
      paramRunnable.setName(localStringBuilder.toString());
      return paramRunnable;
    }
    
    class a
      implements Runnable
    {
      a(Runnable paramRunnable) {}
      
      public void run()
      {
        if (a.d.this.d) {
          StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
        }
        try
        {
          paramRunnable.run();
          return;
        }
        finally
        {
          a.d.this.c.a(localThrowable);
        }
      }
    }
  }
  
  public static abstract interface e
  {
    public static final e a = new a();
    public static final e b;
    public static final e c;
    public static final e d;
    
    static
    {
      b localb = new b();
      b = localb;
      c = new c();
      d = localb;
    }
    
    public abstract void a(Throwable paramThrowable);
    
    class a
      implements a.e
    {
      public void a(Throwable paramThrowable) {}
    }
    
    class b
      implements a.e
    {
      public void a(Throwable paramThrowable)
      {
        if ((paramThrowable != null) && (Log.isLoggable("GlideExecutor", 6))) {
          Log.e("GlideExecutor", "Request threw uncaught throwable", paramThrowable);
        }
      }
    }
    
    class c
      implements a.e
    {
      public void a(Throwable paramThrowable)
      {
        if (paramThrowable == null) {
          return;
        }
        throw new RuntimeException("Request threw uncaught throwable", paramThrowable);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g2.a
 * JD-Core Version:    0.7.0.1
 */