package p9;

import a9.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class c
{
  private final d a;
  private final String b;
  private boolean c;
  private a d;
  private final List<a> e;
  private boolean f;
  
  public c(d paramd, String paramString)
  {
    this.a = paramd;
    this.b = paramString;
    this.e = new ArrayList();
  }
  
  public final void a()
  {
    if ((m9.o.e) && (Thread.holdsLock(this)))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Thread ");
      ((StringBuilder)???).append(Thread.currentThread().getName());
      ((StringBuilder)???).append(" MUST NOT hold lock on ");
      ((StringBuilder)???).append(this);
      throw new AssertionError(((StringBuilder)???).toString());
    }
    synchronized (this.a)
    {
      if (b()) {
        j().h(this);
      }
      o8.o localo = o8.o.a;
      return;
    }
  }
  
  public final boolean b()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      f.c(localObject);
      if (((a)localObject).a()) {
        this.f = true;
      }
    }
    boolean bool = false;
    int i = this.e.size() - 1;
    if (i >= 0) {
      for (;;)
      {
        int j = i - 1;
        if (((a)this.e.get(i)).a())
        {
          localObject = this.a.g();
          a locala = (a)this.e.get(i);
          if (((Logger)localObject).isLoggable(Level.FINE)) {
            b.a((Logger)localObject, locala, this, "canceled");
          }
          this.e.remove(i);
          bool = true;
        }
        if (j < 0) {
          return bool;
        }
        i = j;
      }
    }
    return false;
  }
  
  public final void c(String paramString, long paramLong, final boolean paramBoolean, final z8.a<o8.o> parama)
  {
    f.f(paramString, "name");
    f.f(parama, "block");
    l(new a(paramString, paramBoolean, parama), paramLong);
  }
  
  public final a e()
  {
    return this.d;
  }
  
  public final boolean f()
  {
    return this.f;
  }
  
  public final List<a> g()
  {
    return this.e;
  }
  
  public final String h()
  {
    return this.b;
  }
  
  public final boolean i()
  {
    return this.c;
  }
  
  public final d j()
  {
    return this.a;
  }
  
  public final void k(String paramString, long paramLong, final z8.a<Long> parama)
  {
    f.f(paramString, "name");
    f.f(parama, "block");
    l(new b(paramString, parama), paramLong);
  }
  
  public final void l(a parama, long paramLong)
  {
    f.f(parama, "task");
    synchronized (this.a)
    {
      if (i())
      {
        if (parama.a())
        {
          localLogger = j().g();
          if (localLogger.isLoggable(Level.FINE)) {
            b.a(localLogger, parama, this, "schedule canceled (queue is shutdown)");
          }
          return;
        }
        Logger localLogger = j().g();
        if (localLogger.isLoggable(Level.FINE)) {
          b.a(localLogger, parama, this, "schedule failed (queue is shutdown)");
        }
        throw new RejectedExecutionException();
      }
      if (n(parama, paramLong, false)) {
        j().h(this);
      }
      parama = o8.o.a;
      return;
    }
  }
  
  public final boolean n(a parama, long paramLong, boolean paramBoolean)
  {
    f.f(parama, "task");
    parama.e(this);
    long l1 = this.a.f().e();
    long l2 = l1 + paramLong;
    int i = this.e.indexOf(parama);
    boolean bool = false;
    if (i != -1)
    {
      if (parama.c() <= l2)
      {
        localObject = this.a.g();
        if (((Logger)localObject).isLoggable(Level.FINE)) {
          b.a((Logger)localObject, parama, this, "already scheduled");
        }
        return false;
      }
      this.e.remove(i);
    }
    parama.g(l2);
    Logger localLogger = this.a.g();
    if (localLogger.isLoggable(Level.FINE))
    {
      l2 -= l1;
      String str;
      if (paramBoolean)
      {
        str = b.b(l2);
        localObject = "run again after ";
      }
      else
      {
        str = b.b(l2);
        localObject = "scheduled after ";
      }
      b.a(localLogger, parama, this, f.m((String)localObject, str));
    }
    Object localObject = this.e.iterator();
    i = 0;
    while (((Iterator)localObject).hasNext())
    {
      if (((a)((Iterator)localObject).next()).c() - l1 > paramLong) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        break label256;
      }
      i += 1;
    }
    i = -1;
    label256:
    int j = i;
    if (i == -1) {
      j = this.e.size();
    }
    this.e.add(j, parama);
    paramBoolean = bool;
    if (j == 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public final void o(a parama)
  {
    this.d = parama;
  }
  
  public final void p(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final void q(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void r()
  {
    if ((m9.o.e) && (Thread.holdsLock(this)))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Thread ");
      ((StringBuilder)???).append(Thread.currentThread().getName());
      ((StringBuilder)???).append(" MUST NOT hold lock on ");
      ((StringBuilder)???).append(this);
      throw new AssertionError(((StringBuilder)???).toString());
    }
    synchronized (this.a)
    {
      q(true);
      if (b()) {
        j().h(this);
      }
      o8.o localo = o8.o.a;
      return;
    }
  }
  
  public String toString()
  {
    return this.b;
  }
  
  public static final class a
    extends a
  {
    a(String paramString, boolean paramBoolean, z8.a<o8.o> parama)
    {
      super(paramBoolean);
    }
    
    public long f()
    {
      parama.b();
      return -1L;
    }
  }
  
  public static final class b
    extends a
  {
    b(String paramString, z8.a<Long> parama)
    {
      super(false, 2, null);
    }
    
    public long f()
    {
      return ((Number)parama.b()).longValue();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p9.c
 * JD-Core Version:    0.7.0.1
 */