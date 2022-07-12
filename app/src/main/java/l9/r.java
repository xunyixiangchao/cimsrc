package l9;

import a9.f;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p8.l;
import q9.h;
import q9.h.a;

public final class r
{
  private int a = 64;
  private int b = 5;
  private Runnable c;
  private ExecutorService d;
  private final ArrayDeque<h.a> e = new ArrayDeque();
  private final ArrayDeque<h.a> f = new ArrayDeque();
  private final ArrayDeque<h> g = new ArrayDeque();
  
  private final h.a e(String paramString)
  {
    Iterator localIterator = this.f.iterator();
    h.a locala;
    while (localIterator.hasNext())
    {
      locala = (h.a)localIterator.next();
      if (f.a(locala.d(), paramString)) {
        return locala;
      }
    }
    localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      locala = (h.a)localIterator.next();
      if (f.a(locala.d(), paramString)) {
        return locala;
      }
    }
    return null;
  }
  
  private final <T> void f(Deque<T> paramDeque, T paramT)
  {
    try
    {
      if (paramDeque.remove(paramT))
      {
        paramDeque = i();
        paramT = o8.o.a;
        if ((!l()) && (paramDeque != null)) {
          paramDeque.run();
        }
        return;
      }
      throw new AssertionError("Call wasn't in-flight!");
    }
    finally {}
  }
  
  private final boolean l()
  {
    if ((m9.o.e) && (Thread.holdsLock(this)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Thread ");
      ((StringBuilder)localObject1).append(Thread.currentThread().getName());
      ((StringBuilder)localObject1).append(" MUST NOT hold lock on ");
      ((StringBuilder)localObject1).append(this);
      throw new AssertionError(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    for (;;)
    {
      try
      {
        Object localObject3 = this.e.iterator();
        f.e(localObject3, "readyAsyncCalls.iterator()");
        if (((Iterator)localObject3).hasNext())
        {
          h.a locala = (h.a)((Iterator)localObject3).next();
          if (this.f.size() < j())
          {
            if (locala.c().get() >= k()) {
              continue;
            }
            ((Iterator)localObject3).remove();
            locala.c().incrementAndGet();
            f.e(locala, "asyncCall");
            ((List)localObject1).add(locala);
            this.f.add(locala);
            continue;
          }
        }
        int j = o();
        int i = 0;
        if (j > 0)
        {
          bool = true;
          localObject3 = o8.o.a;
          j = ((List)localObject1).size();
          if (i < j)
          {
            ((h.a)((List)localObject1).get(i)).a(d());
            i += 1;
            continue;
          }
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public final void a()
  {
    try
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext()) {
        ((h.a)localIterator.next()).b().cancel();
      }
      localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((h.a)localIterator.next()).b().cancel();
      }
      localIterator = this.g.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).cancel();
      }
      return;
    }
    finally {}
  }
  
  public final void b(h.a parama)
  {
    f.f(parama, "call");
    try
    {
      this.e.add(parama);
      if (!parama.b().p())
      {
        h.a locala = e(parama.d());
        if (locala != null) {
          parama.e(locala);
        }
      }
      parama = o8.o.a;
      l();
      return;
    }
    finally {}
  }
  
  public final void c(h paramh)
  {
    try
    {
      f.f(paramh, "call");
      this.g.add(paramh);
      return;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
  
  public final ExecutorService d()
  {
    try
    {
      if (this.d == null) {
        this.d = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), m9.o.o(f.m(m9.o.f, " Dispatcher"), false));
      }
      ExecutorService localExecutorService = this.d;
      f.c(localExecutorService);
      return localExecutorService;
    }
    finally {}
  }
  
  public final void g(h.a parama)
  {
    f.f(parama, "call");
    parama.c().decrementAndGet();
    f(this.f, parama);
  }
  
  public final void h(h paramh)
  {
    f.f(paramh, "call");
    f(this.g, paramh);
  }
  
  public final Runnable i()
  {
    try
    {
      Runnable localRunnable = this.c;
      return localRunnable;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int j()
  {
    try
    {
      int i = this.a;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int k()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final List<e> m()
  {
    try
    {
      Object localObject3 = this.e;
      Object localObject1 = new ArrayList(l.q((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject1).add(((h.a)((Iterator)localObject3).next()).b());
      }
      localObject1 = Collections.unmodifiableList((List)localObject1);
      f.e(localObject1, "unmodifiableList(readyAsyncCalls.map { it.call })");
      return localObject1;
    }
    finally {}
  }
  
  public final List<e> n()
  {
    try
    {
      Object localObject1 = this.g;
      Object localObject3 = this.f;
      ArrayList localArrayList = new ArrayList(l.q((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add(((h.a)((Iterator)localObject3).next()).b());
      }
      localObject1 = Collections.unmodifiableList(l.D((Collection)localObject1, localArrayList));
      f.e(localObject1, "unmodifiableList(running…yncCalls.map { it.call })");
      return localObject1;
    }
    finally {}
  }
  
  public final int o()
  {
    try
    {
      int i = this.f.size();
      int j = this.g.size();
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.r
 * JD-Core Version:    0.7.0.1
 */