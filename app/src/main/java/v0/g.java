package v0;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import x0.a;

class g
{
  static ThreadPoolExecutor a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new a(paramString, paramInt1);
    paramString = new ThreadPoolExecutor(0, 1, paramInt2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), paramString);
    paramString.allowCoreThreadTimeOut(true);
    return paramString;
  }
  
  static <T> void b(Executor paramExecutor, Callable<T> paramCallable, a<T> parama)
  {
    paramExecutor.execute(new b(b.a(), paramCallable, parama));
  }
  
  static <T> T c(ExecutorService paramExecutorService, Callable<T> paramCallable, int paramInt)
  {
    paramExecutorService = paramExecutorService.submit(paramCallable);
    long l = paramInt;
    try
    {
      paramExecutorService = paramExecutorService.get(l, TimeUnit.MILLISECONDS);
      return paramExecutorService;
    }
    catch (InterruptedException paramExecutorService)
    {
      throw paramExecutorService;
    }
    catch (ExecutionException paramExecutorService)
    {
      throw new RuntimeException(paramExecutorService);
    }
    catch (TimeoutException paramExecutorService)
    {
      label24:
      break label24;
    }
    throw new InterruptedException("timeout");
  }
  
  private static class a
    implements ThreadFactory
  {
    private String a;
    private int b;
    
    a(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      return new a(paramRunnable, this.a, this.b);
    }
    
    private static class a
      extends Thread
    {
      private final int a;
      
      a(Runnable paramRunnable, String paramString, int paramInt)
      {
        super(paramString);
        this.a = paramInt;
      }
      
      public void run()
      {
        Process.setThreadPriority(this.a);
        super.run();
      }
    }
  }
  
  private static class b<T>
    implements Runnable
  {
    private Callable<T> a;
    private a<T> b;
    private Handler c;
    
    b(Handler paramHandler, Callable<T> paramCallable, a<T> parama)
    {
      this.a = paramCallable;
      this.b = parama;
      this.c = paramHandler;
    }
    
    public void run()
    {
      try
      {
        localObject = this.a.call();
      }
      catch (Exception localException)
      {
        final Object localObject;
        label13:
        final a locala;
        break label13;
      }
      localObject = null;
      locala = this.b;
      this.c.post(new a(locala, localObject));
    }
    
    class a
      implements Runnable
    {
      a(a parama, Object paramObject) {}
      
      public void run()
      {
        locala.a(localObject);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v0.g
 * JD-Core Version:    0.7.0.1
 */