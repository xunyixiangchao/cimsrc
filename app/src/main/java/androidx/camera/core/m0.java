package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.utils.l;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;
import java.util.concurrent.Executor;
import s.c2;
import s.d1;
import s.e0;
import s.g0;
import s.g2.b;
import s.j1;
import s.m1;
import s.r0;
import s.s0;
import s.t1;
import s.t2;
import s.t2.a;
import s.u1;
import s.u2;
import s.u2.b;
import s.v0;
import s.y1;
import v.i;
import x.d;
import x0.h;

public final class m0
  extends v2
{
  public static final c m = new c();
  private static final Boolean n = null;
  private v0 l;
  
  private boolean S(g0 paramg0)
  {
    boolean bool3 = T();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (k(paramg0) % 180 != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void W()
  {
    g0 localg0 = d();
    if (localg0 == null) {
      return;
    }
    k(localg0);
    throw null;
  }
  
  public void A()
  {
    M();
    throw null;
  }
  
  protected t2<?> B(e0 parame0, t2.a<?, ?, ?> parama)
  {
    parama = Q();
    parame0.f().a(d.class);
    if (parama != null) {
      parama.booleanValue();
    }
    throw null;
  }
  
  protected Size E(Size paramSize)
  {
    d1 locald1 = (d1)g();
    I(N(f(), locald1, paramSize).n());
    return paramSize;
  }
  
  public void G(Matrix paramMatrix)
  {
    throw null;
  }
  
  public void H(Rect paramRect)
  {
    super.H(paramRect);
    throw null;
  }
  
  void M()
  {
    l.a();
    v0 localv0 = this.l;
    if (localv0 != null)
    {
      localv0.c();
      this.l = null;
    }
  }
  
  g2.b N(String paramString, d1 paramd1, Size paramSize)
  {
    l.a();
    Object localObject1 = (Executor)h.g(paramd1.I(t.a.b()));
    int i = O();
    int i3 = 1;
    if (i == 1) {
      i = P();
    } else {
      i = 4;
    }
    i2 locali21;
    if (paramd1.L() != null) {
      locali21 = new i2(paramd1.L().a(paramSize.getWidth(), paramSize.getHeight(), i(), i, 0L));
    } else {
      locali21 = new i2(g1.a(paramSize.getWidth(), paramSize.getHeight(), i(), i));
    }
    boolean bool;
    if (d() != null) {
      bool = S(d());
    } else {
      bool = false;
    }
    if (bool) {
      i = paramSize.getHeight();
    } else {
      i = paramSize.getWidth();
    }
    int j;
    if (bool) {
      j = paramSize.getWidth();
    } else {
      j = paramSize.getHeight();
    }
    int k;
    if (R() == 2) {
      k = 1;
    } else {
      k = 35;
    }
    int i1;
    if ((i() == 35) && (R() == 2)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i() == 35)
    {
      if (d() != null)
      {
        i2 = i3;
        if (k(d()) != 0) {
          break label275;
        }
      }
      if (Boolean.TRUE.equals(Q()))
      {
        i2 = i3;
        break label275;
      }
    }
    int i2 = 0;
    label275:
    i2 locali22;
    if ((i1 == 0) && (i2 == 0)) {
      locali22 = null;
    } else {
      locali22 = new i2(g1.a(i, j, k, locali21.f()));
    }
    if (locali22 == null)
    {
      W();
      locali21.e(null, (Executor)localObject1);
      localObject1 = g2.b.p(paramd1);
      Object localObject2 = this.l;
      if (localObject2 != null) {
        ((v0)localObject2).c();
      }
      localObject2 = new m1(locali21.getSurface(), paramSize, i());
      this.l = ((v0)localObject2);
      ((v0)localObject2).i().h(new k0(locali21, locali22), t.a.d());
      ((g2.b)localObject1).l(this.l);
      ((g2.b)localObject1).f(new l0(this, paramString, paramd1, paramSize));
      return localObject1;
    }
    throw null;
  }
  
  public int O()
  {
    return ((d1)g()).J(0);
  }
  
  public int P()
  {
    return ((d1)g()).K(6);
  }
  
  public Boolean Q()
  {
    return ((d1)g()).M(n);
  }
  
  public int R()
  {
    return ((d1)g()).N(1);
  }
  
  public boolean T()
  {
    return ((d1)g()).O(Boolean.FALSE).booleanValue();
  }
  
  public t2<?> h(boolean paramBoolean, u2 paramu2)
  {
    s0 locals0 = paramu2.a(u2.b.c, 1);
    paramu2 = locals0;
    if (paramBoolean) {
      paramu2 = r0.b(locals0, m.a());
    }
    if (paramu2 == null) {
      return null;
    }
    return n(paramu2).b();
  }
  
  public t2.a<?, ?, ?> n(s0 params0)
  {
    return b.c(params0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageAnalysis:");
    localStringBuilder.append(j());
    return localStringBuilder.toString();
  }
  
  public void x()
  {
    throw null;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface a {}
  
  public static final class b
    implements t2.a<m0, d1, b>
  {
    private final u1 a;
    
    public b()
    {
      this(u1.M());
    }
    
    private b(u1 paramu1)
    {
      this.a = paramu1;
      paramu1 = (Class)paramu1.e(i.x, null);
      if ((paramu1 != null) && (!paramu1.equals(m0.class)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid target class configuration for ");
        localStringBuilder.append(this);
        localStringBuilder.append(": ");
        localStringBuilder.append(paramu1);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      h(m0.class);
    }
    
    static b c(s0 params0)
    {
      return new b(u1.N(params0));
    }
    
    public t1 a()
    {
      return this.a;
    }
    
    public d1 d()
    {
      return new d1(y1.K(this.a));
    }
    
    public b e(Size paramSize)
    {
      a().G(j1.k, paramSize);
      return this;
    }
    
    public b f(int paramInt)
    {
      a().G(t2.r, Integer.valueOf(paramInt));
      return this;
    }
    
    public b g(int paramInt)
    {
      a().G(j1.g, Integer.valueOf(paramInt));
      return this;
    }
    
    public b h(Class<m0> paramClass)
    {
      a().G(i.x, paramClass);
      if (a().e(i.w, null) == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramClass.getCanonicalName());
        localStringBuilder.append("-");
        localStringBuilder.append(UUID.randomUUID());
        i(localStringBuilder.toString());
      }
      return this;
    }
    
    public b i(String paramString)
    {
      a().G(i.w, paramString);
      return this;
    }
  }
  
  public static final class c
  {
    private static final Size a;
    private static final d1 b;
    
    static
    {
      Size localSize = new Size(640, 480);
      a = localSize;
      b = new m0.b().e(localSize).f(1).g(0).d();
    }
    
    public d1 a()
    {
      return b;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface d {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.m0
 * JD-Core Version:    0.7.0.1
 */