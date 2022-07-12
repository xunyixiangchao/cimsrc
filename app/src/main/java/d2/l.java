package d2;

import b2.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import t2.j;
import x2.k;
import y2.a.f;
import y2.c;

class l<R>
  implements h.b<R>, a.f
{
  private static final c z = new c();
  final e a = new e();
  private final c b = c.a();
  private final p.a c;
  private final x0.e<l<?>> d;
  private final c e;
  private final m f;
  private final g2.a g;
  private final g2.a h;
  private final g2.a i;
  private final g2.a j;
  private final AtomicInteger k = new AtomicInteger();
  private f l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private v<?> q;
  b2.a r;
  private boolean s;
  q t;
  private boolean u;
  p<?> v;
  private h<R> w;
  private volatile boolean x;
  private boolean y;
  
  l(g2.a parama1, g2.a parama2, g2.a parama3, g2.a parama4, m paramm, p.a parama, x0.e<l<?>> parame)
  {
    this(parama1, parama2, parama3, parama4, paramm, parama, parame, z);
  }
  
  l(g2.a parama1, g2.a parama2, g2.a parama3, g2.a parama4, m paramm, p.a parama, x0.e<l<?>> parame, c paramc)
  {
    this.g = parama1;
    this.h = parama2;
    this.i = parama3;
    this.j = parama4;
    this.f = paramm;
    this.c = parama;
    this.d = parame;
    this.e = paramc;
  }
  
  private g2.a j()
  {
    if (this.n) {
      return this.i;
    }
    if (this.o) {
      return this.j;
    }
    return this.h;
  }
  
  private boolean m()
  {
    return (this.u) || (this.s) || (this.x);
  }
  
  private void q()
  {
    try
    {
      if (this.l != null)
      {
        this.a.clear();
        this.l = null;
        this.v = null;
        this.q = null;
        this.u = false;
        this.x = false;
        this.s = false;
        this.y = false;
        this.w.w(false);
        this.w = null;
        this.t = null;
        this.r = null;
        this.d.a(this);
        return;
      }
      throw new IllegalArgumentException();
    }
    finally {}
  }
  
  public void a(v<R> paramv, b2.a parama, boolean paramBoolean)
  {
    try
    {
      this.q = paramv;
      this.r = parama;
      this.y = paramBoolean;
      o();
      return;
    }
    finally {}
  }
  
  void b(j paramj, Executor paramExecutor)
  {
    for (;;)
    {
      try
      {
        this.b.c();
        this.a.a(paramj, paramExecutor);
        boolean bool2 = this.s;
        bool1 = true;
        if (bool2)
        {
          k(1);
          paramj = new b(paramj);
          paramExecutor.execute(paramj);
        }
        else
        {
          if (this.u)
          {
            k(1);
            paramj = new a(paramj);
            continue;
          }
          if (this.x) {
            break label105;
          }
          k.a(bool1, "Cannot add callbacks to a cancelled EngineJob");
        }
        return;
      }
      finally {}
      label105:
      boolean bool1 = false;
    }
  }
  
  public void c(q paramq)
  {
    try
    {
      this.t = paramq;
      n();
      return;
    }
    finally {}
  }
  
  public void d(h<?> paramh)
  {
    j().execute(paramh);
  }
  
  public c e()
  {
    return this.b;
  }
  
  void f(j paramj)
  {
    try
    {
      paramj.c(this.t);
      return;
    }
    finally {}
  }
  
  void g(j paramj)
  {
    try
    {
      paramj.a(this.v, this.r, this.y);
      return;
    }
    finally {}
  }
  
  void h()
  {
    if (m()) {
      return;
    }
    this.x = true;
    this.w.d();
    this.f.c(this, this.l);
  }
  
  void i()
  {
    for (;;)
    {
      try
      {
        this.b.c();
        k.a(m(), "Not yet complete!");
        int i1 = this.k.decrementAndGet();
        if (i1 >= 0)
        {
          bool = true;
          k.a(bool, "Can't decrement below 0");
          if (i1 != 0) {
            break label78;
          }
          p localp = this.v;
          q();
          if (localp != null) {
            localp.g();
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label78:
      Object localObject2 = null;
    }
  }
  
  void k(int paramInt)
  {
    try
    {
      k.a(m(), "Not yet complete!");
      if (this.k.getAndAdd(paramInt) == 0)
      {
        p localp = this.v;
        if (localp != null) {
          localp.b();
        }
      }
      return;
    }
    finally {}
  }
  
  l<R> l(f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    try
    {
      this.l = paramf;
      this.m = paramBoolean1;
      this.n = paramBoolean2;
      this.o = paramBoolean3;
      this.p = paramBoolean4;
      return this;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  void n()
  {
    try
    {
      this.b.c();
      if (this.x)
      {
        q();
        return;
      }
      if (!this.a.isEmpty())
      {
        if (!this.u)
        {
          this.u = true;
          Object localObject1 = this.l;
          Object localObject3 = this.a.c();
          k(((e)localObject3).size() + 1);
          this.f.a(this, (f)localObject1, null);
          localObject1 = ((e)localObject3).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (d)((Iterator)localObject1).next();
            ((d)localObject3).b.execute(new a(((d)localObject3).a));
          }
          i();
          return;
        }
        throw new IllegalStateException("Already failed once");
      }
      throw new IllegalStateException("Received an exception without any callbacks to notify");
    }
    finally {}
  }
  
  void o()
  {
    try
    {
      this.b.c();
      if (this.x)
      {
        this.q.a();
        q();
        return;
      }
      if (!this.a.isEmpty())
      {
        if (!this.s)
        {
          this.v = this.e.a(this.q, this.m, this.l, this.c);
          this.s = true;
          Object localObject1 = this.a.c();
          k(((e)localObject1).size() + 1);
          Object localObject3 = this.l;
          p localp = this.v;
          this.f.a(this, (f)localObject3, localp);
          localObject1 = ((e)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (d)((Iterator)localObject1).next();
            ((d)localObject3).b.execute(new b(((d)localObject3).a));
          }
          i();
          return;
        }
        throw new IllegalStateException("Already have resource");
      }
      throw new IllegalStateException("Received a resource without any callbacks to notify");
    }
    finally {}
  }
  
  boolean p()
  {
    return this.p;
  }
  
  void r(j paramj)
  {
    for (;;)
    {
      try
      {
        this.b.c();
        this.a.e(paramj);
        if (this.a.isEmpty())
        {
          h();
          if (this.s) {
            break label79;
          }
          if (!this.u) {
            break label74;
          }
          break label79;
          if ((i1 != 0) && (this.k.get() == 0)) {
            q();
          }
        }
        return;
      }
      finally {}
      label74:
      int i1 = 0;
      continue;
      label79:
      i1 = 1;
    }
  }
  
  public void s(h<R> paramh)
  {
    try
    {
      this.w = paramh;
      g2.a locala;
      if (paramh.C()) {
        locala = this.g;
      } else {
        locala = j();
      }
      locala.execute(paramh);
      return;
    }
    finally {}
  }
  
  private class a
    implements Runnable
  {
    private final j a;
    
    a(j paramj)
    {
      this.a = paramj;
    }
    
    public void run()
    {
      synchronized (this.a.d())
      {
        synchronized (l.this)
        {
          if (l.this.a.b(this.a)) {
            l.this.f(this.a);
          }
          l.this.i();
          return;
        }
      }
    }
  }
  
  private class b
    implements Runnable
  {
    private final j a;
    
    b(j paramj)
    {
      this.a = paramj;
    }
    
    public void run()
    {
      synchronized (this.a.d())
      {
        synchronized (l.this)
        {
          if (l.this.a.b(this.a))
          {
            l.this.v.b();
            l.this.g(this.a);
            l.this.r(this.a);
          }
          l.this.i();
          return;
        }
      }
    }
  }
  
  static class c
  {
    public <R> p<R> a(v<R> paramv, boolean paramBoolean, f paramf, p.a parama)
    {
      return new p(paramv, paramBoolean, true, paramf, parama);
    }
  }
  
  static final class d
  {
    final j a;
    final Executor b;
    
    d(j paramj, Executor paramExecutor)
    {
      this.a = paramj;
      this.b = paramExecutor;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        return this.a.equals(paramObject.a);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
  }
  
  static final class e
    implements Iterable<l.d>
  {
    private final List<l.d> a;
    
    e()
    {
      this(new ArrayList(2));
    }
    
    e(List<l.d> paramList)
    {
      this.a = paramList;
    }
    
    private static l.d d(j paramj)
    {
      return new l.d(paramj, x2.e.a());
    }
    
    void a(j paramj, Executor paramExecutor)
    {
      this.a.add(new l.d(paramj, paramExecutor));
    }
    
    boolean b(j paramj)
    {
      return this.a.contains(d(paramj));
    }
    
    e c()
    {
      return new e(new ArrayList(this.a));
    }
    
    void clear()
    {
      this.a.clear();
    }
    
    void e(j paramj)
    {
      this.a.remove(d(paramj));
    }
    
    boolean isEmpty()
    {
      return this.a.isEmpty();
    }
    
    public Iterator<l.d> iterator()
    {
      return this.a.iterator();
    }
    
    int size()
    {
      return this.a.size();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.l
 * JD-Core Version:    0.7.0.1
 */