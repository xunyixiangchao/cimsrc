package j1;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class d<Params, Progress, Result>
{
  private static final ThreadFactory f;
  private static final BlockingQueue<Runnable> g;
  public static final Executor h;
  private static f i;
  private static volatile Executor j;
  private final h<Params, Result> a;
  private final FutureTask<Result> b;
  private volatile g c = g.a;
  final AtomicBoolean d = new AtomicBoolean();
  final AtomicBoolean e = new AtomicBoolean();
  
  static
  {
    Object localObject = new a();
    f = (ThreadFactory)localObject;
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue(10);
    g = localLinkedBlockingQueue;
    localObject = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, localLinkedBlockingQueue, (ThreadFactory)localObject);
    h = (Executor)localObject;
    j = (Executor)localObject;
  }
  
  d()
  {
    b localb = new b();
    this.a = localb;
    this.b = new c(localb);
  }
  
  private static Handler e()
  {
    try
    {
      if (i == null) {
        i = new f();
      }
      f localf = i;
      return localf;
    }
    finally {}
  }
  
  public final boolean a(boolean paramBoolean)
  {
    this.d.set(true);
    return this.b.cancel(paramBoolean);
  }
  
  protected abstract Result b(Params... paramVarArgs);
  
  public final d<Params, Progress, Result> c(Executor paramExecutor, Params... paramVarArgs)
  {
    if (this.c != g.a)
    {
      int k = d.a[this.c.ordinal()];
      if (k != 1)
      {
        if (k != 2) {
          throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
      }
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    this.c = g.b;
    j();
    this.a.a = paramVarArgs;
    paramExecutor.execute(this.b);
    return this;
  }
  
  void d(Result paramResult)
  {
    if (f()) {
      h(paramResult);
    } else {
      i(paramResult);
    }
    this.c = g.c;
  }
  
  public final boolean f()
  {
    return this.d.get();
  }
  
  protected void g() {}
  
  protected void h(Result paramResult)
  {
    g();
  }
  
  protected void i(Result paramResult) {}
  
  protected void j() {}
  
  protected void k(Progress... paramVarArgs) {}
  
  Result l(Result paramResult)
  {
    e().obtainMessage(1, new e(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  void m(Result paramResult)
  {
    if (!this.e.get()) {
      l(paramResult);
    }
  }
  
  static final class a
    implements ThreadFactory
  {
    private final AtomicInteger a = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ModernAsyncTask #");
      localStringBuilder.append(this.a.getAndIncrement());
      return new Thread(paramRunnable, localStringBuilder.toString());
    }
  }
  
  class b
    extends d.h<Params, Result>
  {
    b() {}
    
    public Result call()
    {
      d.this.e.set(true);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      try
      {
        Process.setThreadPriority(10);
        localObject1 = localObject2;
        localObject2 = d.this.b(this.a);
        localObject1 = localObject2;
        Binder.flushPendingCommands();
        d.this.l(localObject2);
        return localObject2;
      }
      finally
      {
        try
        {
          d.this.d.set(true);
          throw localObject3;
        }
        finally
        {
          d.this.l(localObject1);
        }
      }
    }
  }
  
  class c
    extends FutureTask<Result>
  {
    c(Callable paramCallable)
    {
      super();
    }
    
    /* Error */
    protected void done()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 30	java/util/concurrent/FutureTask:get	()Ljava/lang/Object;
      //   4: astore_1
      //   5: aload_0
      //   6: getfield 15	j1/d$c:a	Lj1/d;
      //   9: aload_1
      //   10: invokevirtual 34	j1/d:m	(Ljava/lang/Object;)V
      //   13: return
      //   14: astore_1
      //   15: new 36	java/lang/RuntimeException
      //   18: dup
      //   19: ldc 38
      //   21: aload_1
      //   22: invokespecial 41	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   25: athrow
      //   26: aload_0
      //   27: getfield 15	j1/d$c:a	Lj1/d;
      //   30: aconst_null
      //   31: invokevirtual 34	j1/d:m	(Ljava/lang/Object;)V
      //   34: return
      //   35: astore_1
      //   36: new 36	java/lang/RuntimeException
      //   39: dup
      //   40: ldc 38
      //   42: aload_1
      //   43: invokevirtual 45	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
      //   46: invokespecial 41	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   49: athrow
      //   50: astore_1
      //   51: ldc 47
      //   53: aload_1
      //   54: invokestatic 53	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
      //   57: pop
      //   58: return
      //   59: astore_1
      //   60: goto -34 -> 26
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	c
      //   4	6	1	localObject	Object
      //   14	8	1	localThrowable	java.lang.Throwable
      //   35	8	1	localExecutionException	java.util.concurrent.ExecutionException
      //   50	4	1	localInterruptedException	java.lang.InterruptedException
      //   59	1	1	localCancellationException	java.util.concurrent.CancellationException
      // Exception table:
      //   from	to	target	type
      //   0	13	14	finally
      //   0	13	35	java/util/concurrent/ExecutionException
      //   0	13	50	java/lang/InterruptedException
      //   0	13	59	java/util/concurrent/CancellationException
    }
  }
  
  private static class e<Data>
  {
    final d a;
    final Data[] b;
    
    e(d paramd, Data... paramVarArgs)
    {
      this.a = paramd;
      this.b = paramVarArgs;
    }
  }
  
  private static class f
    extends Handler
  {
    f()
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      d.e locale = (d.e)paramMessage.obj;
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        locale.a.k(locale.b);
        return;
      }
      locale.a.d(locale.b[0]);
    }
  }
  
  public static enum g
  {
    static
    {
      g localg1 = new g("PENDING", 0);
      a = localg1;
      g localg2 = new g("RUNNING", 1);
      b = localg2;
      g localg3 = new g("FINISHED", 2);
      c = localg3;
      d = new g[] { localg1, localg2, localg3 };
    }
    
    private g() {}
  }
  
  private static abstract class h<Params, Result>
    implements Callable<Result>
  {
    Params[] a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j1.d
 * JD-Core Version:    0.7.0.1
 */