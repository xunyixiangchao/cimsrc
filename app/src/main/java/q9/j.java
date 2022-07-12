package q9;

import a9.f;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import l9.h0;
import p9.c;
import p9.d;
import u9.h.a;

public final class j
{
  public static final a f = new a(null);
  private final int a;
  private final long b;
  private final c c;
  private final b d;
  private final ConcurrentLinkedQueue<i> e;
  
  public j(d paramd, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.a = paramInt;
    this.b = paramTimeUnit.toNanos(paramLong);
    this.c = paramd.i();
    this.d = new b(this, f.m(m9.o.f, " ConnectionPool"));
    this.e = new ConcurrentLinkedQueue();
    if (paramLong > 0L) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      return;
    }
    throw new IllegalArgumentException(f.m("keepAliveDuration <= 0: ", Long.valueOf(paramLong)).toString());
  }
  
  private final int d(i parami, long paramLong)
  {
    if ((m9.o.e) && (!Thread.holdsLock(parami)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Thread ");
      ((StringBuilder)localObject1).append(Thread.currentThread().getName());
      ((StringBuilder)localObject1).append(" MUST hold lock on ");
      ((StringBuilder)localObject1).append(parami);
      throw new AssertionError(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = parami.i();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      Object localObject2 = (Reference)((List)localObject1).get(i);
      if (((Reference)localObject2).get() != null)
      {
        i += 1;
      }
      else
      {
        localObject2 = (h.b)localObject2;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("A connection to ");
        ((StringBuilder)localObject3).append(parami.t().a().l());
        ((StringBuilder)localObject3).append(" was leaked. Did you forget to close a response body?");
        localObject3 = ((StringBuilder)localObject3).toString();
        u9.h.a.g().l((String)localObject3, ((h.b)localObject2).a());
        ((List)localObject1).remove(i);
        parami.w(true);
        if (((List)localObject1).isEmpty())
        {
          parami.v(paramLong - this.b);
          return 0;
        }
      }
    }
    return ((List)localObject1).size();
  }
  
  public final i a(boolean paramBoolean1, l9.a parama, h paramh, List<h0> paramList, boolean paramBoolean2)
  {
    f.f(parama, "address");
    f.f(paramh, "call");
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      f.e(locali, "connection");
      int i = 0;
      if (paramBoolean2) {}
      try
      {
        if ((locali.q()) && (locali.o(parama, paramList)))
        {
          paramh.c(locali);
          i = 1;
        }
        if (i != 0) {
          if (locali.p(paramBoolean1)) {
            return locali;
          }
        }
      }
      finally
      {
        try
        {
          locali.w(true);
          Socket localSocket = paramh.y();
          if (localSocket == null) {
            continue;
          }
          m9.o.g(localSocket);
        }
        finally {}
      }
    }
    return null;
  }
  
  public final long b(long paramLong)
  {
    Iterator localIterator = this.e.iterator();
    int i = 0;
    long l1 = -9223372036854775808L;
    Object localObject1 = null;
    int j = 0;
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      f.e(locali, "connection");
      try
      {
        if (d(locali, paramLong) > 0)
        {
          j += 1;
        }
        else
        {
          i += 1;
          long l3 = paramLong - locali.j();
          l2 = l1;
          if (l3 > l1)
          {
            localObject1 = locali;
            l2 = l3;
          }
          o8.o localo = o8.o.a;
          l1 = l2;
        }
      }
      finally {}
    }
    long l2 = this.b;
    if ((l1 < l2) && (i <= this.a))
    {
      if (i > 0) {
        return l2 - l1;
      }
      if (j > 0) {
        return l2;
      }
      return -1L;
    }
    f.c(localObject2);
    try
    {
      boolean bool = localObject2.i().isEmpty();
      if ((bool ^ true)) {
        return 0L;
      }
      l2 = localObject2.j();
      if (l2 + l1 != paramLong) {
        return 0L;
      }
      localObject2.w(true);
      this.e.remove(localObject2);
      m9.o.g(localObject2.x());
      if (this.e.isEmpty()) {
        this.c.a();
      }
      return 0L;
    }
    finally {}
  }
  
  public final boolean c(i parami)
  {
    f.f(parami, "connection");
    if ((m9.o.e) && (!Thread.holdsLock(parami)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Thread ");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(" MUST hold lock on ");
      localStringBuilder.append(parami);
      throw new AssertionError(localStringBuilder.toString());
    }
    if ((!parami.k()) && (this.a != 0))
    {
      c.m(this.c, this.d, 0L, 2, null);
      return false;
    }
    parami.w(true);
    this.e.remove(parami);
    if (this.e.isEmpty()) {
      this.c.a();
    }
    return true;
  }
  
  public final void e(i parami)
  {
    f.f(parami, "connection");
    if ((m9.o.e) && (!Thread.holdsLock(parami)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Thread ");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(" MUST hold lock on ");
      localStringBuilder.append(parami);
      throw new AssertionError(localStringBuilder.toString());
    }
    this.e.add(parami);
    c.m(this.c, this.d, 0L, 2, null);
  }
  
  public static final class a {}
  
  public static final class b
    extends p9.a
  {
    b(j paramj, String paramString)
    {
      super(false, 2, null);
    }
    
    public long f()
    {
      return this.e.b(System.nanoTime());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.j
 * JD-Core Version:    0.7.0.1
 */