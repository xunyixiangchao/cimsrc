package t;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import u.f;

final class c
  extends AbstractExecutorService
  implements ScheduledExecutorService
{
  private static ThreadLocal<ScheduledExecutorService> b = new a();
  private final Handler a;
  
  c(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  private RejectedExecutionException a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(" is shutting down");
    return new RejectedExecutionException(localStringBuilder.toString());
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append(c.class.getSimpleName());
    paramTimeUnit.append(" cannot be shut down. Use Looper.quitSafely().");
    throw new UnsupportedOperationException(paramTimeUnit.toString());
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (this.a.post(paramRunnable)) {
      return;
    }
    throw a();
  }
  
  public boolean isShutdown()
  {
    return false;
  }
  
  public boolean isTerminated()
  {
    return false;
  }
  
  public ScheduledFuture<?> schedule(final Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return schedule(new b(paramRunnable), paramLong, paramTimeUnit);
  }
  
  public <V> ScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = SystemClock.uptimeMillis() + TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit);
    paramCallable = new c(this.a, paramLong, paramCallable);
    if (this.a.postAtTime(paramCallable, paramLong)) {
      return paramCallable;
    }
    return f.g(a());
  }
  
  public ScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    paramRunnable = new StringBuilder();
    paramRunnable.append(c.class.getSimpleName());
    paramRunnable.append(" does not yet support fixed-rate scheduling.");
    throw new UnsupportedOperationException(paramRunnable.toString());
  }
  
  public ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    paramRunnable = new StringBuilder();
    paramRunnable.append(c.class.getSimpleName());
    paramRunnable.append(" does not yet support fixed-delay scheduling.");
    throw new UnsupportedOperationException(paramRunnable.toString());
  }
  
  public void shutdown()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.class.getSimpleName());
    localStringBuilder.append(" cannot be shut down. Use Looper.quitSafely().");
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public List<Runnable> shutdownNow()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.class.getSimpleName());
    localStringBuilder.append(" cannot be shut down. Use Looper.quitSafely().");
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  class a
    extends ThreadLocal<ScheduledExecutorService>
  {
    public ScheduledExecutorService a()
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        return a.d();
      }
      if (Looper.myLooper() != null) {
        return new c(new Handler(Looper.myLooper()));
      }
      return null;
    }
  }
  
  class b
    implements Callable<Void>
  {
    b(Runnable paramRunnable) {}
    
    public Void a()
    {
      paramRunnable.run();
      return null;
    }
  }
  
  private static class c<V>
    implements RunnableScheduledFuture<V>
  {
    final AtomicReference<androidx.concurrent.futures.c.a<V>> a = new AtomicReference(null);
    private final long b;
    private final Callable<V> c;
    private final u7.a<V> d;
    
    c(final Handler paramHandler, long paramLong, final Callable<V> paramCallable)
    {
      this.b = paramLong;
      this.c = paramCallable;
      this.d = androidx.concurrent.futures.c.a(new a(paramHandler, paramCallable));
    }
    
    public int a(Delayed paramDelayed)
    {
      TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
      return Long.compare(getDelay(localTimeUnit), paramDelayed.getDelay(localTimeUnit));
    }
    
    public boolean cancel(boolean paramBoolean)
    {
      return this.d.cancel(paramBoolean);
    }
    
    public V get()
    {
      return this.d.get();
    }
    
    public V get(long paramLong, TimeUnit paramTimeUnit)
    {
      return this.d.get(paramLong, paramTimeUnit);
    }
    
    public long getDelay(TimeUnit paramTimeUnit)
    {
      return paramTimeUnit.convert(this.b - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
    
    public boolean isCancelled()
    {
      return this.d.isCancelled();
    }
    
    public boolean isDone()
    {
      return this.d.isDone();
    }
    
    public boolean isPeriodic()
    {
      return false;
    }
    
    public void run()
    {
      androidx.concurrent.futures.c.a locala = (androidx.concurrent.futures.c.a)this.a.getAndSet(null);
      if (locala != null) {
        try
        {
          locala.c(this.c.call());
          return;
        }
        catch (Exception localException)
        {
          locala.f(localException);
        }
      }
    }
    
    class a
      implements androidx.concurrent.futures.c.c<V>
    {
      a(Handler paramHandler, Callable paramCallable) {}
      
      public Object a(androidx.concurrent.futures.c.a<V> parama)
      {
        parama.a(new a(), a.a());
        c.c.this.a.set(parama);
        parama = new StringBuilder();
        parama.append("HandlerScheduledFuture-");
        parama.append(paramCallable.toString());
        return parama.toString();
      }
      
      class a
        implements Runnable
      {
        a() {}
        
        public void run()
        {
          if (c.c.this.a.getAndSet(null) != null)
          {
            c.c.a locala = c.c.a.this;
            locala.a.removeCallbacks(locala.c);
          }
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t.c
 * JD-Core Version:    0.7.0.1
 */