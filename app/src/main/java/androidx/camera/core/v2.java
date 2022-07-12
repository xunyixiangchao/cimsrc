package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import s.b0;
import s.e0;
import s.e2;
import s.g0;
import s.g2;
import s.h1;
import s.j1;
import s.s0;
import s.s0.a;
import s.t2;
import s.t2.a;
import s.u1;
import s.u2;
import s.v0;
import s.y1;
import v.i;
import v.m;
import x0.h;

public abstract class v2
{
  private final Set<d> a = new HashSet();
  private final Object b = new Object();
  private c c = c.b;
  private t2<?> d;
  private t2<?> e;
  private t2<?> f;
  private Size g;
  private t2<?> h;
  private Rect i;
  private g0 j;
  private g2 k = g2.a();
  
  protected v2(t2<?> paramt2)
  {
    this.e = paramt2;
    this.f = paramt2;
  }
  
  private void F(d paramd)
  {
    this.a.remove(paramd);
  }
  
  private void a(d paramd)
  {
    this.a.add(paramd);
  }
  
  public void A() {}
  
  protected t2<?> B(e0 parame0, t2.a<?, ?, ?> parama)
  {
    return parama.b();
  }
  
  public void C()
  {
    y();
  }
  
  public void D() {}
  
  protected abstract Size E(Size paramSize);
  
  public void G(Matrix paramMatrix) {}
  
  public void H(Rect paramRect)
  {
    this.i = paramRect;
  }
  
  protected void I(g2 paramg2)
  {
    this.k = paramg2;
    paramg2 = paramg2.k().iterator();
    while (paramg2.hasNext())
    {
      v0 localv0 = (v0)paramg2.next();
      if (localv0.e() == null) {
        localv0.o(getClass());
      }
    }
  }
  
  public void J(Size paramSize)
  {
    this.g = E(paramSize);
  }
  
  protected int b()
  {
    return ((j1)this.f).A(-1);
  }
  
  public Size c()
  {
    return this.g;
  }
  
  public g0 d()
  {
    synchronized (this.b)
    {
      g0 localg0 = this.j;
      return localg0;
    }
  }
  
  protected b0 e()
  {
    synchronized (this.b)
    {
      Object localObject2 = this.j;
      if (localObject2 == null)
      {
        localObject2 = b0.a;
        return localObject2;
      }
      localObject2 = ((g0)localObject2).m();
      return localObject2;
    }
  }
  
  protected String f()
  {
    g0 localg0 = d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("No camera attached to use case: ");
    localStringBuilder.append(this);
    return ((g0)h.h(localg0, localStringBuilder.toString())).i().c();
  }
  
  public t2<?> g()
  {
    return this.f;
  }
  
  public abstract t2<?> h(boolean paramBoolean, u2 paramu2);
  
  public int i()
  {
    return this.f.q();
  }
  
  public String j()
  {
    t2 localt2 = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<UnknownUseCase-");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(">");
    return localt2.B(localStringBuilder.toString());
  }
  
  protected int k(g0 paramg0)
  {
    return paramg0.i().e(m());
  }
  
  public g2 l()
  {
    return this.k;
  }
  
  @SuppressLint({"WrongConstant"})
  protected int m()
  {
    return ((j1)this.f).D(0);
  }
  
  public abstract t2.a<?, ?, ?> n(s0 params0);
  
  public Rect o()
  {
    return this.i;
  }
  
  protected boolean p(String paramString)
  {
    if (d() == null) {
      return false;
    }
    return Objects.equals(paramString, f());
  }
  
  public t2<?> q(e0 parame0, t2<?> paramt21, t2<?> paramt22)
  {
    if (paramt22 != null)
    {
      paramt22 = u1.N(paramt22);
      paramt22.O(i.w);
    }
    else
    {
      paramt22 = u1.M();
    }
    Iterator localIterator = this.e.c().iterator();
    s0.a locala;
    while (localIterator.hasNext())
    {
      locala = (s0.a)localIterator.next();
      paramt22.t(locala, this.e.d(locala), this.e.a(locala));
    }
    if (paramt21 != null)
    {
      localIterator = paramt21.c().iterator();
      while (localIterator.hasNext())
      {
        locala = (s0.a)localIterator.next();
        if (!locala.c().equals(i.w.c())) {
          paramt22.t(locala, paramt21.d(locala), paramt21.a(locala));
        }
      }
    }
    if (paramt22.b(j1.j))
    {
      paramt21 = j1.g;
      if (paramt22.b(paramt21)) {
        paramt22.O(paramt21);
      }
    }
    return B(parame0, n(paramt22));
  }
  
  protected final void r()
  {
    this.c = c.a;
    u();
  }
  
  protected final void s()
  {
    this.c = c.b;
    u();
  }
  
  protected final void t()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).d(this);
    }
  }
  
  public final void u()
  {
    int m = a.a[this.c.ordinal()];
    if (m != 1)
    {
      if (m != 2) {
        return;
      }
      localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).b(this);
      }
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).j(this);
    }
  }
  
  protected final void v()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).k(this);
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public void w(g0 paramg0, t2<?> paramt21, t2<?> paramt22)
  {
    synchronized (this.b)
    {
      this.j = paramg0;
      a(paramg0);
      this.d = paramt21;
      this.h = paramt22;
      paramt21 = q(paramg0.i(), this.d, this.h);
      this.f = paramt21;
      paramt21 = paramt21.C(null);
      if (paramt21 != null) {
        paramt21.b(paramg0.i());
      }
      x();
      return;
    }
  }
  
  public void x() {}
  
  protected void y() {}
  
  public void z(g0 paramg0)
  {
    A();
    ??? = this.f.C(null);
    if (??? != null) {
      ((b)???).a();
    }
    for (;;)
    {
      synchronized (this.b)
      {
        if (paramg0 == this.j)
        {
          bool = true;
          h.a(bool);
          F(this.j);
          this.j = null;
          this.g = null;
          this.i = null;
          this.f = this.e;
          this.d = null;
          this.h = null;
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void b(r paramr);
  }
  
  static enum c
  {
    static
    {
      c localc1 = new c("ACTIVE", 0);
      a = localc1;
      c localc2 = new c("INACTIVE", 1);
      b = localc2;
      c = new c[] { localc1, localc2 };
    }
    
    private c() {}
  }
  
  public static abstract interface d
  {
    public abstract void b(v2 paramv2);
    
    public abstract void d(v2 paramv2);
    
    public abstract void j(v2 paramv2);
    
    public abstract void k(v2 paramv2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.v2
 * JD-Core Version:    0.7.0.1
 */