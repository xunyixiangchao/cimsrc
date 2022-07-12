package u;

import androidx.camera.core.n1;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import u7.a;
import x0.h;

abstract class g<V>
  implements a<V>
{
  public static <V> a<V> a()
  {
    return c.b;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public abstract V get();
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
  {
    h.g(paramTimeUnit);
    return get();
  }
  
  public void h(Runnable paramRunnable, Executor paramExecutor)
  {
    h.g(paramRunnable);
    h.g(paramExecutor);
    try
    {
      paramExecutor.execute(paramRunnable);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Experienced RuntimeException while attempting to notify ");
      localStringBuilder.append(paramRunnable);
      localStringBuilder.append(" on Executor ");
      localStringBuilder.append(paramExecutor);
      n1.d("ImmediateFuture", localStringBuilder.toString(), localRuntimeException);
    }
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return true;
  }
  
  static class a<V>
    extends g<V>
  {
    private final Throwable a;
    
    a(Throwable paramThrowable)
    {
      this.a = paramThrowable;
    }
    
    public V get()
    {
      throw new ExecutionException(this.a);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append("[status=FAILURE, cause=[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]]");
      return localStringBuilder.toString();
    }
  }
  
  static final class b<V>
    extends g.a<V>
    implements ScheduledFuture<V>
  {
    b(Throwable paramThrowable)
    {
      super();
    }
    
    public int b(Delayed paramDelayed)
    {
      return -1;
    }
    
    public long getDelay(TimeUnit paramTimeUnit)
    {
      return 0L;
    }
  }
  
  static final class c<V>
    extends g<V>
  {
    static final g<Object> b = new c(null);
    private final V a;
    
    c(V paramV)
    {
      this.a = paramV;
    }
    
    public V get()
    {
      return this.a;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append("[status=SUCCESS, result=[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u.g
 * JD-Core Version:    0.7.0.1
 */