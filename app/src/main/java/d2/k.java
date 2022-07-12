package d2;

import android.util.Log;
import b2.f;
import f2.a.a;
import f2.b;
import f2.i;
import f2.i.a;
import java.util.Map;
import java.util.concurrent.Executor;
import x2.g;
import y2.a.d;

public class k
  implements m, i.a, p.a
{
  private static final boolean i = Log.isLoggable("Engine", 2);
  private final s a;
  private final o b;
  private final i c;
  private final b d;
  private final y e;
  private final c f;
  private final a g;
  private final a h;
  
  k(i parami, a.a parama, g2.a parama1, g2.a parama2, g2.a parama3, g2.a parama4, s params, o paramo, a parama5, b paramb, a parama6, y paramy, boolean paramBoolean)
  {
    this.c = parami;
    parama = new c(parama);
    this.f = parama;
    if (parama5 == null) {
      parama5 = new a(paramBoolean);
    }
    this.h = parama5;
    parama5.f(this);
    if (paramo == null) {
      paramo = new o();
    }
    this.b = paramo;
    if (params == null) {
      params = new s();
    }
    this.a = params;
    if (paramb == null) {
      paramb = new b(parama1, parama2, parama3, parama4, this, this);
    }
    this.d = paramb;
    if (parama6 == null) {
      parama6 = new a(parama);
    }
    this.g = parama6;
    if (paramy == null) {
      paramy = new y();
    }
    this.e = paramy;
    parami.c(this);
  }
  
  public k(i parami, a.a parama, g2.a parama1, g2.a parama2, g2.a parama3, g2.a parama4, boolean paramBoolean)
  {
    this(parami, parama, parama1, parama2, parama3, parama4, null, null, null, null, null, null, paramBoolean);
  }
  
  private p<?> e(f paramf)
  {
    v localv = this.c.e(paramf);
    if (localv == null) {
      return null;
    }
    if ((localv instanceof p)) {
      return (p)localv;
    }
    return new p(localv, true, true, paramf, this);
  }
  
  private p<?> g(f paramf)
  {
    paramf = this.h.e(paramf);
    if (paramf != null) {
      paramf.b();
    }
    return paramf;
  }
  
  private p<?> h(f paramf)
  {
    p localp = e(paramf);
    if (localp != null)
    {
      localp.b();
      this.h.a(paramf, localp);
    }
    return localp;
  }
  
  private p<?> i(n paramn, boolean paramBoolean, long paramLong)
  {
    if (!paramBoolean) {
      return null;
    }
    p localp = g(paramn);
    if (localp != null)
    {
      if (i) {
        j("Loaded resource from active resources", paramLong, paramn);
      }
      return localp;
    }
    localp = h(paramn);
    if (localp != null)
    {
      if (i) {
        j("Loaded resource from cache", paramLong, paramn);
      }
      return localp;
    }
    return null;
  }
  
  private static void j(String paramString, long paramLong, f paramf)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" in ");
    localStringBuilder.append(g.a(paramLong));
    localStringBuilder.append("ms, key: ");
    localStringBuilder.append(paramf);
    Log.v("Engine", localStringBuilder.toString());
  }
  
  private <R> d l(com.bumptech.glide.e parame, Object paramObject, f paramf, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, com.bumptech.glide.h paramh, j paramj, Map<Class<?>, b2.l<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, b2.h paramh1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, t2.j paramj1, Executor paramExecutor, n paramn, long paramLong)
  {
    l locall = this.a.a(paramn, paramBoolean6);
    if (locall != null)
    {
      locall.b(paramj1, paramExecutor);
      if (i) {
        j("Added to existing load", paramLong, paramn);
      }
      return new d(paramj1, locall);
    }
    locall = this.d.a(paramn, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6);
    parame = this.g.a(parame, paramObject, paramn, paramf, paramInt1, paramInt2, paramClass, paramClass1, paramh, paramj, paramMap, paramBoolean1, paramBoolean2, paramBoolean6, paramh1, locall);
    this.a.c(paramn, locall);
    locall.b(paramj1, paramExecutor);
    locall.s(parame);
    if (i) {
      j("Started new load", paramLong, paramn);
    }
    return new d(paramj1, locall);
  }
  
  public void a(l<?> paraml, f paramf, p<?> paramp)
  {
    if (paramp != null) {}
    try
    {
      if (paramp.f()) {
        this.h.a(paramf, paramp);
      }
      this.a.d(paramf, paraml);
      return;
    }
    finally {}
  }
  
  public void b(v<?> paramv)
  {
    this.e.a(paramv, true);
  }
  
  public void c(l<?> paraml, f paramf)
  {
    try
    {
      this.a.d(paramf, paraml);
      return;
    }
    finally
    {
      paraml = finally;
      throw paraml;
    }
  }
  
  public void d(f paramf, p<?> paramp)
  {
    this.h.d(paramf);
    if (paramp.f())
    {
      this.c.d(paramf, paramp);
      return;
    }
    this.e.a(paramp, false);
  }
  
  public <R> d f(com.bumptech.glide.e parame, Object paramObject, f paramf, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, com.bumptech.glide.h paramh, j paramj, Map<Class<?>, b2.l<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, b2.h paramh1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, t2.j paramj1, Executor paramExecutor)
  {
    long l;
    if (i) {
      l = g.b();
    } else {
      l = 0L;
    }
    n localn = this.b.a(paramObject, paramf, paramInt1, paramInt2, paramMap, paramClass, paramClass1, paramh1);
    try
    {
      p localp = i(localn, paramBoolean3, l);
      if (localp == null)
      {
        parame = l(parame, paramObject, paramf, paramInt1, paramInt2, paramClass, paramClass1, paramh, paramj, paramMap, paramBoolean1, paramBoolean2, paramh1, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramj1, paramExecutor, localn, l);
        return parame;
      }
      paramj1.a(localp, b2.a.e, false);
      return null;
    }
    finally {}
  }
  
  public void k(v<?> paramv)
  {
    if ((paramv instanceof p))
    {
      ((p)paramv).g();
      return;
    }
    throw new IllegalArgumentException("Cannot release anything but an EngineResource");
  }
  
  static class a
  {
    final h.e a;
    final x0.e<h<?>> b = y2.a.d(150, new a());
    private int c;
    
    a(h.e parame)
    {
      this.a = parame;
    }
    
    <R> h<R> a(com.bumptech.glide.e parame, Object paramObject, n paramn, f paramf, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, com.bumptech.glide.h paramh, j paramj, Map<Class<?>, b2.l<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b2.h paramh1, h.b<R> paramb)
    {
      h localh = (h)x2.k.d((h)this.b.b());
      int i = this.c;
      this.c = (i + 1);
      return localh.n(parame, paramObject, paramn, paramf, paramInt1, paramInt2, paramClass, paramClass1, paramh, paramj, paramMap, paramBoolean1, paramBoolean2, paramBoolean3, paramh1, paramb, i);
    }
    
    class a
      implements a.d<h<?>>
    {
      a() {}
      
      public h<?> b()
      {
        k.a locala = k.a.this;
        return new h(locala.a, locala.b);
      }
    }
  }
  
  static class b
  {
    final g2.a a;
    final g2.a b;
    final g2.a c;
    final g2.a d;
    final m e;
    final p.a f;
    final x0.e<l<?>> g = y2.a.d(150, new a());
    
    b(g2.a parama1, g2.a parama2, g2.a parama3, g2.a parama4, m paramm, p.a parama)
    {
      this.a = parama1;
      this.b = parama2;
      this.c = parama3;
      this.d = parama4;
      this.e = paramm;
      this.f = parama;
    }
    
    <R> l<R> a(f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      return ((l)x2.k.d((l)this.g.b())).l(paramf, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
    }
    
    class a
      implements a.d<l<?>>
    {
      a() {}
      
      public l<?> b()
      {
        k.b localb = k.b.this;
        return new l(localb.a, localb.b, localb.c, localb.d, localb.e, localb.f, localb.g);
      }
    }
  }
  
  private static class c
    implements h.e
  {
    private final a.a a;
    private volatile f2.a b;
    
    c(a.a parama)
    {
      this.a = parama;
    }
    
    public f2.a a()
    {
      if (this.b == null) {
        try
        {
          if (this.b == null) {
            this.b = this.a.build();
          }
          if (this.b == null) {
            this.b = new b();
          }
        }
        finally {}
      }
      return this.b;
    }
  }
  
  public class d
  {
    private final l<?> a;
    private final t2.j b;
    
    d(l<?> paraml)
    {
      this.b = paraml;
      Object localObject;
      this.a = localObject;
    }
    
    public void a()
    {
      synchronized (k.this)
      {
        this.a.r(this.b);
        return;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.k
 * JD-Core Version:    0.7.0.1
 */