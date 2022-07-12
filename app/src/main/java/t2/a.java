package t2;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import b2.g;
import java.util.Map;
import k2.m;
import k2.o;
import k2.q;
import o2.c;
import x2.k;

public abstract class a<T extends a<T>>
  implements Cloneable
{
  private int a;
  private float b = 1.0F;
  private d2.j c = d2.j.e;
  private com.bumptech.glide.h d = com.bumptech.glide.h.c;
  private Drawable e;
  private int f;
  private Drawable g;
  private int h;
  private boolean i = true;
  private int j = -1;
  private int k = -1;
  private b2.f l = w2.a.c();
  private boolean m;
  private boolean n = true;
  private Drawable o;
  private int p;
  private b2.h q = new b2.h();
  private Map<Class<?>, b2.l<?>> r = new x2.b();
  private Class<?> s = Object.class;
  private boolean t;
  private Resources.Theme u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y = true;
  private boolean z;
  
  private boolean L(int paramInt)
  {
    return M(this.a, paramInt);
  }
  
  private static boolean M(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  private T V(k2.l paraml, b2.l<Bitmap> paraml1)
  {
    return b0(paraml, paraml1, false);
  }
  
  private T b0(k2.l paraml, b2.l<Bitmap> paraml1, boolean paramBoolean)
  {
    if (paramBoolean) {
      paraml = m0(paraml, paraml1);
    } else {
      paraml = W(paraml, paraml1);
    }
    paraml.y = true;
    return paraml;
  }
  
  private T c0()
  {
    return this;
  }
  
  public final b2.f A()
  {
    return this.l;
  }
  
  public final float C()
  {
    return this.b;
  }
  
  public final Resources.Theme D()
  {
    return this.u;
  }
  
  public final Map<Class<?>, b2.l<?>> E()
  {
    return this.r;
  }
  
  public final boolean F()
  {
    return this.z;
  }
  
  public final boolean G()
  {
    return this.w;
  }
  
  protected final boolean H()
  {
    return this.v;
  }
  
  public final boolean I()
  {
    return this.i;
  }
  
  public final boolean J()
  {
    return L(8);
  }
  
  boolean K()
  {
    return this.y;
  }
  
  public final boolean N()
  {
    return this.n;
  }
  
  public final boolean O()
  {
    return this.m;
  }
  
  public final boolean P()
  {
    return L(2048);
  }
  
  public final boolean Q()
  {
    return x2.l.t(this.k, this.j);
  }
  
  public T R()
  {
    this.t = true;
    return c0();
  }
  
  public T S()
  {
    return W(k2.l.e, new k2.i());
  }
  
  public T T()
  {
    return V(k2.l.d, new k2.j());
  }
  
  public T U()
  {
    return V(k2.l.c, new q());
  }
  
  final T W(k2.l paraml, b2.l<Bitmap> paraml1)
  {
    if (this.v) {
      return c().W(paraml, paraml1);
    }
    j(paraml);
    return k0(paraml1, false);
  }
  
  public T X(int paramInt1, int paramInt2)
  {
    if (this.v) {
      return c().X(paramInt1, paramInt2);
    }
    this.k = paramInt1;
    this.j = paramInt2;
    this.a |= 0x200;
    return e0();
  }
  
  public T Y(int paramInt)
  {
    if (this.v) {
      return c().Y(paramInt);
    }
    this.h = paramInt;
    paramInt = this.a;
    this.g = null;
    this.a = ((paramInt | 0x80) & 0xFFFFFFBF);
    return e0();
  }
  
  public T Z(Drawable paramDrawable)
  {
    if (this.v) {
      return c().Z(paramDrawable);
    }
    this.g = paramDrawable;
    int i1 = this.a;
    this.h = 0;
    this.a = ((i1 | 0x40) & 0xFFFFFF7F);
    return e0();
  }
  
  public T a(a<?> parama)
  {
    if (this.v) {
      return c().a(parama);
    }
    if (M(parama.a, 2)) {
      this.b = parama.b;
    }
    if (M(parama.a, 262144)) {
      this.w = parama.w;
    }
    if (M(parama.a, 1048576)) {
      this.z = parama.z;
    }
    if (M(parama.a, 4)) {
      this.c = parama.c;
    }
    if (M(parama.a, 8)) {
      this.d = parama.d;
    }
    if (M(parama.a, 16))
    {
      this.e = parama.e;
      this.f = 0;
      this.a &= 0xFFFFFFDF;
    }
    if (M(parama.a, 32))
    {
      this.f = parama.f;
      this.e = null;
      this.a &= 0xFFFFFFEF;
    }
    if (M(parama.a, 64))
    {
      this.g = parama.g;
      this.h = 0;
      this.a &= 0xFFFFFF7F;
    }
    if (M(parama.a, 128))
    {
      this.h = parama.h;
      this.g = null;
      this.a &= 0xFFFFFFBF;
    }
    if (M(parama.a, 256)) {
      this.i = parama.i;
    }
    if (M(parama.a, 512))
    {
      this.k = parama.k;
      this.j = parama.j;
    }
    if (M(parama.a, 1024)) {
      this.l = parama.l;
    }
    if (M(parama.a, 4096)) {
      this.s = parama.s;
    }
    if (M(parama.a, 8192))
    {
      this.o = parama.o;
      this.p = 0;
      this.a &= 0xFFFFBFFF;
    }
    if (M(parama.a, 16384))
    {
      this.p = parama.p;
      this.o = null;
      this.a &= 0xFFFFDFFF;
    }
    if (M(parama.a, 32768)) {
      this.u = parama.u;
    }
    if (M(parama.a, 65536)) {
      this.n = parama.n;
    }
    if (M(parama.a, 131072)) {
      this.m = parama.m;
    }
    if (M(parama.a, 2048))
    {
      this.r.putAll(parama.r);
      this.y = parama.y;
    }
    if (M(parama.a, 524288)) {
      this.x = parama.x;
    }
    if (!this.n)
    {
      this.r.clear();
      int i1 = this.a;
      this.m = false;
      this.a = (i1 & 0xFFFFF7FF & 0xFFFDFFFF);
      this.y = true;
    }
    this.a |= parama.a;
    this.q.d(parama.q);
    return e0();
  }
  
  public T a0(com.bumptech.glide.h paramh)
  {
    if (this.v) {
      return c().a0(paramh);
    }
    this.d = ((com.bumptech.glide.h)k.d(paramh));
    this.a |= 0x8;
    return e0();
  }
  
  public T b()
  {
    if ((this.t) && (!this.v)) {
      throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }
    this.v = true;
    return R();
  }
  
  public T c()
  {
    try
    {
      a locala = (a)super.clone();
      Object localObject = new b2.h();
      locala.q = ((b2.h)localObject);
      ((b2.h)localObject).d(this.q);
      localObject = new x2.b();
      locala.r = ((Map)localObject);
      ((Map)localObject).putAll(this.r);
      locala.t = false;
      locala.v = false;
      return locala;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  public T d(Class<?> paramClass)
  {
    if (this.v) {
      return c().d(paramClass);
    }
    this.s = ((Class)k.d(paramClass));
    this.a |= 0x1000;
    return e0();
  }
  
  public T e(d2.j paramj)
  {
    if (this.v) {
      return c().e(paramj);
    }
    this.c = ((d2.j)k.d(paramj));
    this.a |= 0x4;
    return e0();
  }
  
  protected final T e0()
  {
    if (!this.t) {
      return c0();
    }
    throw new IllegalStateException("You cannot modify locked T, consider clone()");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (Float.compare(paramObject.b, this.b) == 0)
      {
        bool1 = bool2;
        if (this.f == paramObject.f)
        {
          bool1 = bool2;
          if (x2.l.d(this.e, paramObject.e))
          {
            bool1 = bool2;
            if (this.h == paramObject.h)
            {
              bool1 = bool2;
              if (x2.l.d(this.g, paramObject.g))
              {
                bool1 = bool2;
                if (this.p == paramObject.p)
                {
                  bool1 = bool2;
                  if (x2.l.d(this.o, paramObject.o))
                  {
                    bool1 = bool2;
                    if (this.i == paramObject.i)
                    {
                      bool1 = bool2;
                      if (this.j == paramObject.j)
                      {
                        bool1 = bool2;
                        if (this.k == paramObject.k)
                        {
                          bool1 = bool2;
                          if (this.m == paramObject.m)
                          {
                            bool1 = bool2;
                            if (this.n == paramObject.n)
                            {
                              bool1 = bool2;
                              if (this.w == paramObject.w)
                              {
                                bool1 = bool2;
                                if (this.x == paramObject.x)
                                {
                                  bool1 = bool2;
                                  if (this.c.equals(paramObject.c))
                                  {
                                    bool1 = bool2;
                                    if (this.d == paramObject.d)
                                    {
                                      bool1 = bool2;
                                      if (this.q.equals(paramObject.q))
                                      {
                                        bool1 = bool2;
                                        if (this.r.equals(paramObject.r))
                                        {
                                          bool1 = bool2;
                                          if (this.s.equals(paramObject.s))
                                          {
                                            bool1 = bool2;
                                            if (x2.l.d(this.l, paramObject.l))
                                            {
                                              bool1 = bool2;
                                              if (x2.l.d(this.u, paramObject.u)) {
                                                bool1 = true;
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public T f()
  {
    return f0(o2.i.b, Boolean.TRUE);
  }
  
  public <Y> T f0(g<Y> paramg, Y paramY)
  {
    if (this.v) {
      return c().f0(paramg, paramY);
    }
    k.d(paramg);
    k.d(paramY);
    this.q.e(paramg, paramY);
    return e0();
  }
  
  public T g0(b2.f paramf)
  {
    if (this.v) {
      return c().g0(paramf);
    }
    this.l = ((b2.f)k.d(paramf));
    this.a |= 0x400;
    return e0();
  }
  
  public T h0(float paramFloat)
  {
    if (this.v) {
      return c().h0(paramFloat);
    }
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      this.b = paramFloat;
      this.a |= 0x2;
      return e0();
    }
    throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
  }
  
  public int hashCode()
  {
    int i1 = x2.l.l(this.b);
    i1 = x2.l.n(this.f, i1);
    i1 = x2.l.o(this.e, i1);
    i1 = x2.l.n(this.h, i1);
    i1 = x2.l.o(this.g, i1);
    i1 = x2.l.n(this.p, i1);
    i1 = x2.l.o(this.o, i1);
    i1 = x2.l.p(this.i, i1);
    i1 = x2.l.n(this.j, i1);
    i1 = x2.l.n(this.k, i1);
    i1 = x2.l.p(this.m, i1);
    i1 = x2.l.p(this.n, i1);
    i1 = x2.l.p(this.w, i1);
    i1 = x2.l.p(this.x, i1);
    i1 = x2.l.o(this.c, i1);
    i1 = x2.l.o(this.d, i1);
    i1 = x2.l.o(this.q, i1);
    i1 = x2.l.o(this.r, i1);
    i1 = x2.l.o(this.s, i1);
    i1 = x2.l.o(this.l, i1);
    return x2.l.o(this.u, i1);
  }
  
  public T i0(boolean paramBoolean)
  {
    if (this.v) {
      return c().i0(true);
    }
    this.i = (paramBoolean ^ true);
    this.a |= 0x100;
    return e0();
  }
  
  public T j(k2.l paraml)
  {
    return f0(k2.l.h, k.d(paraml));
  }
  
  public T j0(b2.l<Bitmap> paraml)
  {
    return k0(paraml, true);
  }
  
  public T k(int paramInt)
  {
    if (this.v) {
      return c().k(paramInt);
    }
    this.f = paramInt;
    paramInt = this.a;
    this.e = null;
    this.a = ((paramInt | 0x20) & 0xFFFFFFEF);
    return e0();
  }
  
  T k0(b2.l<Bitmap> paraml, boolean paramBoolean)
  {
    if (this.v) {
      return c().k0(paraml, paramBoolean);
    }
    o localo = new o(paraml, paramBoolean);
    l0(Bitmap.class, paraml, paramBoolean);
    l0(Drawable.class, localo, paramBoolean);
    l0(BitmapDrawable.class, localo.c(), paramBoolean);
    l0(c.class, new o2.f(paraml), paramBoolean);
    return e0();
  }
  
  public T l(Drawable paramDrawable)
  {
    if (this.v) {
      return c().l(paramDrawable);
    }
    this.e = paramDrawable;
    int i1 = this.a;
    this.f = 0;
    this.a = ((i1 | 0x10) & 0xFFFFFFDF);
    return e0();
  }
  
  <Y> T l0(Class<Y> paramClass, b2.l<Y> paraml, boolean paramBoolean)
  {
    if (this.v) {
      return c().l0(paramClass, paraml, paramBoolean);
    }
    k.d(paramClass);
    k.d(paraml);
    this.r.put(paramClass, paraml);
    int i1 = this.a;
    this.n = true;
    i1 = i1 | 0x800 | 0x10000;
    this.a = i1;
    this.y = false;
    if (paramBoolean)
    {
      this.a = (i1 | 0x20000);
      this.m = true;
    }
    return e0();
  }
  
  public T m(b2.b paramb)
  {
    k.d(paramb);
    return f0(m.f, paramb).f0(o2.i.a, paramb);
  }
  
  final T m0(k2.l paraml, b2.l<Bitmap> paraml1)
  {
    if (this.v) {
      return c().m0(paraml, paraml1);
    }
    j(paraml);
    return j0(paraml1);
  }
  
  public final d2.j n()
  {
    return this.c;
  }
  
  public T n0(boolean paramBoolean)
  {
    if (this.v) {
      return c().n0(paramBoolean);
    }
    this.z = paramBoolean;
    this.a |= 0x100000;
    return e0();
  }
  
  public final int o()
  {
    return this.f;
  }
  
  public final Drawable p()
  {
    return this.e;
  }
  
  public final Drawable q()
  {
    return this.o;
  }
  
  public final int r()
  {
    return this.p;
  }
  
  public final boolean s()
  {
    return this.x;
  }
  
  public final b2.h t()
  {
    return this.q;
  }
  
  public final int u()
  {
    return this.j;
  }
  
  public final int v()
  {
    return this.k;
  }
  
  public final Drawable w()
  {
    return this.g;
  }
  
  public final int x()
  {
    return this.h;
  }
  
  public final com.bumptech.glide.h y()
  {
    return this.d;
  }
  
  public final Class<?> z()
  {
    return this.s;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t2.a
 * JD-Core Version:    0.7.0.1
 */