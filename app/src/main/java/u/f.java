package u;

import androidx.concurrent.futures.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

public final class f
{
  private static final k.a<?, ?> a = new b();
  
  public static <V> void b(u7.a<V> parama, c<? super V> paramc, Executor paramExecutor)
  {
    x0.h.g(paramc);
    parama.h(new e(parama, paramc), paramExecutor);
  }
  
  public static <V> u7.a<List<V>> c(Collection<? extends u7.a<? extends V>> paramCollection)
  {
    return new h(new ArrayList(paramCollection), true, t.a.a());
  }
  
  public static <V> V d(Future<V> paramFuture)
  {
    boolean bool = paramFuture.isDone();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Future was expected to be done, ");
    localStringBuilder.append(paramFuture);
    x0.h.j(bool, localStringBuilder.toString());
    return e(paramFuture);
  }
  
  /* Error */
  public static <V> V e(Future<V> paramFuture)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokeinterface 104 1 0
    //   8: astore_2
    //   9: iload_1
    //   10: ifeq +9 -> 19
    //   13: invokestatic 110	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 113	java/lang/Thread:interrupt	()V
    //   19: aload_2
    //   20: areturn
    //   21: astore_0
    //   22: iload_1
    //   23: ifeq +9 -> 32
    //   26: invokestatic 110	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   29: invokevirtual 113	java/lang/Thread:interrupt	()V
    //   32: aload_0
    //   33: athrow
    //   34: iconst_1
    //   35: istore_1
    //   36: goto -34 -> 2
    //   39: astore_2
    //   40: goto -6 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	paramFuture	Future<V>
    //   1	35	1	i	int
    //   8	12	2	localObject	Object
    //   39	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	9	21	finally
    //   2	9	39	java/lang/InterruptedException
  }
  
  public static <V> u7.a<V> f(Throwable paramThrowable)
  {
    return new g.a(paramThrowable);
  }
  
  public static <V> ScheduledFuture<V> g(Throwable paramThrowable)
  {
    return new g.b(paramThrowable);
  }
  
  public static <V> u7.a<V> h(V paramV)
  {
    if (paramV == null) {
      return g.a();
    }
    return new g.c(paramV);
  }
  
  public static <V> u7.a<V> j(u7.a<V> parama)
  {
    x0.h.g(parama);
    if (parama.isDone()) {
      return parama;
    }
    return androidx.concurrent.futures.c.a(new e(parama));
  }
  
  public static <V> void k(u7.a<V> parama, c.a<V> parama1)
  {
    l(parama, a, parama1, t.a.a());
  }
  
  public static <I, O> void l(u7.a<I> parama, k.a<? super I, ? extends O> parama1, c.a<O> parama2, Executor paramExecutor)
  {
    m(true, parama, parama1, parama2, paramExecutor);
  }
  
  private static <I, O> void m(boolean paramBoolean, u7.a<I> parama, final k.a<? super I, ? extends O> parama1, c.a<O> parama2, Executor paramExecutor)
  {
    x0.h.g(parama);
    x0.h.g(parama1);
    x0.h.g(parama2);
    x0.h.g(paramExecutor);
    b(parama, new c(parama2, parama1), paramExecutor);
    if (paramBoolean) {
      parama2.a(new d(parama), t.a.a());
    }
  }
  
  public static <V> u7.a<List<V>> n(Collection<? extends u7.a<? extends V>> paramCollection)
  {
    return new h(new ArrayList(paramCollection), false, t.a.a());
  }
  
  public static <I, O> u7.a<O> o(u7.a<I> parama, k.a<? super I, ? extends O> parama1, Executor paramExecutor)
  {
    x0.h.g(parama1);
    return p(parama, new a(parama1), paramExecutor);
  }
  
  public static <I, O> u7.a<O> p(u7.a<I> parama, a<? super I, ? extends O> parama1, Executor paramExecutor)
  {
    parama1 = new b(parama1, parama);
    parama.h(parama1, paramExecutor);
    return parama1;
  }
  
  class a
    implements a<I, O>
  {
    a() {}
    
    public u7.a<O> a(I paramI)
    {
      return f.h(f.this.a(paramI));
    }
  }
  
  class b
    implements k.a<Object, Object>
  {
    public Object a(Object paramObject)
    {
      return paramObject;
    }
  }
  
  class c
    implements c<I>
  {
    c(k.a parama) {}
    
    public void a(Throwable paramThrowable)
    {
      f.this.f(paramThrowable);
    }
    
    public void b(I paramI)
    {
      try {}finally
      {
        f.this.f(paramI);
      }
    }
  }
  
  class d
    implements Runnable
  {
    d() {}
    
    public void run()
    {
      f.this.cancel(true);
    }
  }
  
  private static final class e<V>
    implements Runnable
  {
    final Future<V> a;
    final c<? super V> b;
    
    e(Future<V> paramFuture, c<? super V> paramc)
    {
      this.a = paramFuture;
      this.b = paramc;
    }
    
    public void run()
    {
      try
      {
        try
        {
          Object localObject = f.d(this.a);
          this.b.b(localObject);
          return;
        }
        catch (Error localError) {}catch (RuntimeException localRuntimeException) {}
        this.b.a(localRuntimeException);
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        this.b.a(localExecutionException.getCause());
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(e.class.getSimpleName());
      localStringBuilder.append(",");
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u.f
 * JD-Core Version:    0.7.0.1
 */