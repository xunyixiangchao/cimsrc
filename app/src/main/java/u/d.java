package u;

import androidx.concurrent.futures.c;
import androidx.concurrent.futures.c.a;
import androidx.concurrent.futures.c.c;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import x0.h;

public class d<V>
  implements u7.a<V>
{
  private final u7.a<V> a;
  c.a<V> b;
  
  d()
  {
    this.a = c.a(new a());
  }
  
  d(u7.a<V> parama)
  {
    this.a = ((u7.a)h.g(parama));
  }
  
  public static <V> d<V> a(u7.a<V> parama)
  {
    if ((parama instanceof d)) {
      return (d)parama;
    }
    return new d(parama);
  }
  
  boolean b(V paramV)
  {
    c.a locala = this.b;
    if (locala != null) {
      return locala.c(paramV);
    }
    return false;
  }
  
  boolean c(Throwable paramThrowable)
  {
    c.a locala = this.b;
    if (locala != null) {
      return locala.f(paramThrowable);
    }
    return false;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return this.a.cancel(paramBoolean);
  }
  
  public final <T> d<T> d(k.a<? super V, T> parama, Executor paramExecutor)
  {
    return (d)f.o(this, parama, paramExecutor);
  }
  
  public final <T> d<T> e(a<? super V, T> parama, Executor paramExecutor)
  {
    return (d)f.p(this, parama, paramExecutor);
  }
  
  public V get()
  {
    return this.a.get();
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.get(paramLong, paramTimeUnit);
  }
  
  public void h(Runnable paramRunnable, Executor paramExecutor)
  {
    this.a.h(paramRunnable, paramExecutor);
  }
  
  public boolean isCancelled()
  {
    return this.a.isCancelled();
  }
  
  public boolean isDone()
  {
    return this.a.isDone();
  }
  
  class a
    implements c.c<V>
  {
    a() {}
    
    public Object a(c.a<V> parama)
    {
      boolean bool;
      if (d.this.b == null) {
        bool = true;
      } else {
        bool = false;
      }
      h.j(bool, "The result can only set once!");
      d.this.b = parama;
      parama = new StringBuilder();
      parama.append("FutureChain[");
      parama.append(d.this);
      parama.append("]");
      return parama.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u.d
 * JD-Core Version:    0.7.0.1
 */