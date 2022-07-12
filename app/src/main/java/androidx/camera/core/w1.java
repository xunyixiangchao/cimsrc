package androidx.camera.core;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.impl.utils.l;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import s.a2;
import s.e0;
import s.f1;
import s.g0;
import s.g2.b;
import s.h1;
import s.j1;
import s.k;
import s.p0;
import s.q0;
import s.q0.a;
import s.r0;
import s.s0;
import s.t;
import s.t2;
import s.t2.a;
import s.u2.b;
import s.v0;
import s.y1;
import v.b;
import v.i;
import v.m;

public final class w1
  extends v2
{
  public static final c r = new c();
  private static final Executor s = t.a.d();
  private d l;
  private Executor m = s;
  private v0 n;
  u2 o;
  private boolean p = false;
  private Size q;
  
  w1(a2 parama2)
  {
    super(parama2);
  }
  
  private Rect N(Size paramSize)
  {
    if (o() != null) {
      return o();
    }
    if (paramSize != null) {
      return new Rect(0, 0, paramSize.getWidth(), paramSize.getHeight());
    }
    return null;
  }
  
  private boolean Q()
  {
    u2 localu2 = this.o;
    d locald = this.l;
    if ((locald != null) && (localu2 != null))
    {
      this.m.execute(new u1(locald, localu2));
      return true;
    }
    return false;
  }
  
  private void R()
  {
    g0 localg0 = d();
    d locald = this.l;
    Rect localRect = N(this.q);
    u2 localu2 = this.o;
    if ((localg0 != null) && (locald != null) && (localRect != null)) {
      localu2.x(u2.g.d(localRect, k(localg0), b()));
    }
  }
  
  private void U(String paramString, a2 parama2, Size paramSize)
  {
    I(M(paramString, parama2, paramSize).n());
  }
  
  public void A()
  {
    v0 localv0 = this.n;
    if (localv0 != null) {
      localv0.c();
    }
    this.o = null;
  }
  
  protected t2<?> B(e0 parame0, t2.a<?, ?, ?> parama)
  {
    s.t1 localt1;
    int i;
    if (parama.a().e(a2.C, null) != null)
    {
      localt1 = parama.a();
      parame0 = h1.f;
      i = 35;
    }
    else
    {
      localt1 = parama.a();
      parame0 = h1.f;
      i = 34;
    }
    localt1.G(parame0, Integer.valueOf(i));
    return parama.b();
  }
  
  protected Size E(Size paramSize)
  {
    this.q = paramSize;
    U(f(), (a2)g(), this.q);
    return paramSize;
  }
  
  public void H(Rect paramRect)
  {
    super.H(paramRect);
    R();
  }
  
  g2.b M(String paramString, a2 parama2, Size paramSize)
  {
    l.a();
    g2.b localb = g2.b.p(parama2);
    Object localObject1 = parama2.I(null);
    Object localObject2 = this.n;
    if (localObject2 != null) {
      ((v0)localObject2).c();
    }
    boolean bool = parama2.K(false);
    localObject2 = new u2(paramSize, d(), bool);
    this.o = ((u2)localObject2);
    if (Q()) {
      R();
    } else {
      this.p = true;
    }
    if (localObject1 != null)
    {
      q0.a locala = new q0.a();
      HandlerThread localHandlerThread = new HandlerThread("CameraX-preview_processing");
      localHandlerThread.start();
      String str = Integer.toString(locala.hashCode());
      localObject1 = new f2(paramSize.getWidth(), paramSize.getHeight(), parama2.q(), new Handler(localHandlerThread.getLooper()), locala, (p0)localObject1, ((u2)localObject2).k(), str);
      localb.d(((f2)localObject1).r());
      ((v0)localObject1).i().h(new t1(localHandlerThread), t.a.a());
      this.n = ((v0)localObject1);
      localb.m(str, Integer.valueOf(locala.getId()));
    }
    else
    {
      localObject1 = parama2.J(null);
      if (localObject1 != null) {
        localb.d(new a((f1)localObject1));
      }
      this.n = ((u2)localObject2).k();
    }
    localb.l(this.n);
    localb.f(new v1(this, paramString, parama2, paramSize));
    return localb;
  }
  
  public void S(d paramd)
  {
    T(s, paramd);
  }
  
  public void T(Executor paramExecutor, d paramd)
  {
    
    if (paramd == null)
    {
      this.l = null;
      s();
      return;
    }
    this.l = paramd;
    this.m = paramExecutor;
    r();
    if (this.p)
    {
      if (Q())
      {
        R();
        this.p = false;
      }
    }
    else if (c() != null)
    {
      U(f(), (a2)g(), c());
      t();
    }
  }
  
  public t2<?> h(boolean paramBoolean, s.u2 paramu2)
  {
    s0 locals0 = paramu2.a(u2.b.b, 1);
    paramu2 = locals0;
    if (paramBoolean) {
      paramu2 = r0.b(locals0, r.a());
    }
    if (paramu2 == null) {
      return null;
    }
    return n(paramu2).b();
  }
  
  public t2.a<?, ?, ?> n(s0 params0)
  {
    return b.d(params0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Preview:");
    localStringBuilder.append(j());
    return localStringBuilder.toString();
  }
  
  class a
    extends k
  {
    a(f1 paramf1) {}
    
    public void b(t paramt)
    {
      super.b(paramt);
      if (this.a.a(new b(paramt))) {
        w1.this.v();
      }
    }
  }
  
  public static final class b
    implements t2.a<w1, a2, b>
  {
    private final s.u1 a;
    
    public b()
    {
      this(s.u1.M());
    }
    
    private b(s.u1 paramu1)
    {
      this.a = paramu1;
      paramu1 = (Class)paramu1.e(i.x, null);
      if ((paramu1 != null) && (!paramu1.equals(w1.class)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid target class configuration for ");
        localStringBuilder.append(this);
        localStringBuilder.append(": ");
        localStringBuilder.append(paramu1);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      l(w1.class);
    }
    
    static b d(s0 params0)
    {
      return new b(s.u1.N(params0));
    }
    
    public s.t1 a()
    {
      return this.a;
    }
    
    public w1 c()
    {
      if ((a().e(j1.g, null) != null) && (a().e(j1.j, null) != null)) {
        throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
      }
      return new w1(e());
    }
    
    public a2 e()
    {
      return new a2(y1.K(this.a));
    }
    
    public b f(p0 paramp0)
    {
      a().G(a2.C, paramp0);
      return this;
    }
    
    public b g(f1 paramf1)
    {
      a().G(a2.B, paramf1);
      return this;
    }
    
    public b h(boolean paramBoolean)
    {
      a().G(a2.D, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public b i(List<Pair<Integer, Size[]>> paramList)
    {
      a().G(j1.m, paramList);
      return this;
    }
    
    public b j(int paramInt)
    {
      a().G(t2.r, Integer.valueOf(paramInt));
      return this;
    }
    
    public b k(int paramInt)
    {
      a().G(j1.g, Integer.valueOf(paramInt));
      return this;
    }
    
    public b l(Class<w1> paramClass)
    {
      a().G(i.x, paramClass);
      if (a().e(i.w, null) == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramClass.getCanonicalName());
        localStringBuilder.append("-");
        localStringBuilder.append(UUID.randomUUID());
        m(localStringBuilder.toString());
      }
      return this;
    }
    
    public b m(String paramString)
    {
      a().G(i.w, paramString);
      return this;
    }
    
    public b n(int paramInt)
    {
      a().G(j1.h, Integer.valueOf(paramInt));
      a().G(j1.i, Integer.valueOf(paramInt));
      return this;
    }
    
    public b o(v2.b paramb)
    {
      a().G(m.z, paramb);
      return this;
    }
  }
  
  public static final class c
  {
    private static final a2 a = new w1.b().j(2).k(0).e();
    
    public a2 a()
    {
      return a;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(u2 paramu2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.w1
 * JD-Core Version:    0.7.0.1
 */