package h0;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

public class d
{
  public static boolean r = false;
  public static boolean s = true;
  public static boolean t = true;
  public static boolean u = true;
  public static boolean v = false;
  private static int w = 1000;
  public static long x;
  public static long y;
  public boolean a = false;
  int b = 0;
  private HashMap<String, i> c = null;
  private a d;
  private int e = 32;
  private int f = 32;
  b[] g = null;
  public boolean h = false;
  public boolean i = false;
  private boolean[] j = new boolean[32];
  int k = 1;
  int l = 0;
  private int m = 32;
  final c n;
  private i[] o = new i[w];
  private int p = 0;
  private a q;
  
  public d()
  {
    C();
    Object localObject = new c();
    this.n = ((c)localObject);
    this.d = new h((c)localObject);
    if (v) {
      localObject = new b((c)localObject);
    } else {
      localObject = new b((c)localObject);
    }
    this.q = ((a)localObject);
  }
  
  private final int B(a parama, boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.k)
    {
      this.j[i1] = false;
      i1 += 1;
    }
    int i2 = 0;
    i1 = i2;
    while (i2 == 0)
    {
      int i5 = i1 + 1;
      if (i5 >= this.k * 2) {
        return i5;
      }
      if (parama.getKey() != null) {
        this.j[parama.getKey().c] = true;
      }
      i locali = parama.a(this, this.j);
      Object localObject;
      if (locali != null)
      {
        localObject = this.j;
        i1 = locali.c;
        if (localObject[i1] != 0) {
          return i5;
        }
        localObject[i1] = 1;
      }
      if (locali != null)
      {
        float f1 = 3.4028235E+38F;
        i1 = 0;
        int i4;
        for (int i3 = -1; i1 < this.l; i3 = i4)
        {
          localObject = this.g[i1];
          float f2;
          if (((b)localObject).a.j == i.a.a)
          {
            f2 = f1;
            i4 = i3;
          }
          else if (((b)localObject).f)
          {
            f2 = f1;
            i4 = i3;
          }
          else
          {
            f2 = f1;
            i4 = i3;
            if (((b)localObject).t(locali))
            {
              float f3 = ((b)localObject).e.b(locali);
              f2 = f1;
              i4 = i3;
              if (f3 < 0.0F)
              {
                f3 = -((b)localObject).b / f3;
                f2 = f1;
                i4 = i3;
                if (f3 < f1)
                {
                  i4 = i1;
                  f2 = f3;
                }
              }
            }
          }
          i1 += 1;
          f1 = f2;
        }
        i1 = i5;
        if (i3 > -1)
        {
          localObject = this.g[i3];
          ((b)localObject).a.d = -1;
          ((b)localObject).x(locali);
          locali = ((b)localObject).a;
          locali.d = i3;
          locali.h(this, (b)localObject);
          i1 = i5;
        }
      }
      else
      {
        i2 = 1;
        i1 = i5;
      }
    }
    return i1;
  }
  
  private void C()
  {
    boolean bool = v;
    int i1 = 0;
    int i2 = 0;
    b localb;
    if (bool)
    {
      i1 = i2;
      while (i1 < this.l)
      {
        localb = this.g[i1];
        if (localb != null) {
          this.n.a.a(localb);
        }
        this.g[i1] = null;
        i1 += 1;
      }
    }
    while (i1 < this.l)
    {
      localb = this.g[i1];
      if (localb != null) {
        this.n.b.a(localb);
      }
      this.g[i1] = null;
      i1 += 1;
    }
  }
  
  private i a(i.a parama, String paramString)
  {
    i locali = (i)this.n.c.b();
    if (locali == null) {
      locali = new i(parama, paramString);
    } else {
      locali.e();
    }
    locali.g(parama, paramString);
    int i1 = this.p;
    int i2 = w;
    if (i1 >= i2)
    {
      i1 = i2 * 2;
      w = i1;
      this.o = ((i[])Arrays.copyOf(this.o, i1));
    }
    parama = this.o;
    i1 = this.p;
    this.p = (i1 + 1);
    parama[i1] = locali;
    return locali;
  }
  
  private final void l(b paramb)
  {
    Object localObject;
    int i1;
    if ((t) && (paramb.f))
    {
      paramb.a.f(this, paramb.b);
    }
    else
    {
      localObject = this.g;
      i1 = this.l;
      localObject[i1] = paramb;
      localObject = paramb.a;
      ((i)localObject).d = i1;
      this.l = (i1 + 1);
      ((i)localObject).h(this, paramb);
    }
    if ((t) && (this.a))
    {
      int i2;
      for (i1 = 0; i1 < this.l; i1 = i2 + 1)
      {
        if (this.g[i1] == null) {
          System.out.println("WTF");
        }
        paramb = this.g;
        i2 = i1;
        if (paramb[i1] != null)
        {
          i2 = i1;
          if (paramb[i1].f)
          {
            localObject = paramb[i1];
            ((b)localObject).a.f(this, ((b)localObject).b);
            if (v) {
              paramb = this.n.a;
            } else {
              paramb = this.n.b;
            }
            paramb.a(localObject);
            this.g[i1] = null;
            i2 = i1 + 1;
            int i3 = i2;
            int i4;
            for (;;)
            {
              i4 = this.l;
              if (i2 >= i4) {
                break;
              }
              paramb = this.g;
              i3 = i2 - 1;
              paramb[i3] = paramb[i2];
              if (paramb[i3].a.d == i2) {
                paramb[i3].a.d = i3;
              }
              i3 = i2;
              i2 += 1;
            }
            if (i3 < i4) {
              this.g[i3] = null;
            }
            this.l = (i4 - 1);
            i2 = i1 - 1;
          }
        }
      }
      this.a = false;
    }
  }
  
  private void n()
  {
    int i1 = 0;
    while (i1 < this.l)
    {
      b localb = this.g[i1];
      localb.a.f = localb.b;
      i1 += 1;
    }
  }
  
  public static b s(d paramd, i parami1, i parami2, float paramFloat)
  {
    return paramd.r().j(parami1, parami2, paramFloat);
  }
  
  private int u(a parama)
  {
    int i1 = 0;
    while (i1 < this.l)
    {
      parama = this.g;
      if ((parama[i1].a.j != i.a.a) && (parama[i1].b < 0.0F))
      {
        i1 = 1;
        break label66;
      }
      i1 += 1;
    }
    i1 = 0;
    label66:
    if (i1 != 0)
    {
      int i5 = 0;
      i1 = 0;
      while (i5 == 0)
      {
        int i11 = i1 + 1;
        float f1 = 3.4028235E+38F;
        i1 = 0;
        int i2 = -1;
        int i3 = -1;
        int i9;
        i locali;
        for (int i4 = 0; i1 < this.l; i4 = i9)
        {
          parama = this.g[i1];
          float f2;
          int i7;
          int i8;
          if (parama.a.j == i.a.a)
          {
            f2 = f1;
            i7 = i2;
            i8 = i3;
            i9 = i4;
          }
          else if (parama.f)
          {
            f2 = f1;
            i7 = i2;
            i8 = i3;
            i9 = i4;
          }
          else
          {
            f2 = f1;
            i7 = i2;
            i8 = i3;
            i9 = i4;
            if (parama.b < 0.0F)
            {
              int i10;
              float f3;
              if (u)
              {
                int i12 = parama.e.e();
                i10 = 0;
                for (;;)
                {
                  f2 = f1;
                  i7 = i2;
                  i8 = i3;
                  i9 = i4;
                  if (i10 >= i12) {
                    break;
                  }
                  locali = parama.e.i(i10);
                  f3 = parama.e.b(locali);
                  if (f3 <= 0.0F)
                  {
                    f2 = f1;
                    i7 = i2;
                    i8 = i3;
                    i9 = i4;
                  }
                  else
                  {
                    i7 = 0;
                    i6 = i2;
                    i2 = i7;
                    for (;;)
                    {
                      f2 = f1;
                      i7 = i6;
                      i8 = i3;
                      i9 = i4;
                      if (i2 >= 9) {
                        break;
                      }
                      f2 = locali.h[i2] / f3;
                      if ((f2 >= f1) || (i2 != i4))
                      {
                        i7 = i4;
                        if (i2 <= i4) {}
                      }
                      else
                      {
                        i3 = locali.c;
                        i7 = i2;
                        i6 = i1;
                        f1 = f2;
                      }
                      i2 += 1;
                      i4 = i7;
                    }
                  }
                  i10 += 1;
                  f1 = f2;
                  i2 = i7;
                  i3 = i8;
                  i4 = i9;
                }
              }
              int i6 = 1;
              for (;;)
              {
                f2 = f1;
                i7 = i2;
                i8 = i3;
                i9 = i4;
                if (i6 >= this.k) {
                  break;
                }
                locali = this.n.d[i6];
                f3 = parama.e.b(locali);
                if (f3 <= 0.0F)
                {
                  f2 = f1;
                  i8 = i2;
                  i9 = i3;
                  i10 = i4;
                }
                else
                {
                  i7 = 0;
                  for (;;)
                  {
                    f2 = f1;
                    i8 = i2;
                    i9 = i3;
                    i10 = i4;
                    if (i7 >= 9) {
                      break;
                    }
                    f2 = locali.h[i7] / f3;
                    if ((f2 >= f1) || (i7 != i4))
                    {
                      i8 = i4;
                      if (i7 <= i4) {}
                    }
                    else
                    {
                      i3 = i6;
                      i2 = i1;
                      i8 = i7;
                      f1 = f2;
                    }
                    i7 += 1;
                    i4 = i8;
                  }
                }
                i6 += 1;
                f1 = f2;
                i2 = i8;
                i3 = i9;
                i4 = i10;
              }
            }
          }
          i1 += 1;
          f1 = f2;
          i2 = i7;
          i3 = i8;
        }
        if (i2 != -1)
        {
          parama = this.g[i2];
          parama.a.d = -1;
          parama.x(this.n.d[i3]);
          locali = parama.a;
          locali.d = i2;
          locali.h(this, parama);
        }
        else
        {
          i5 = 1;
        }
        i1 = i11;
        if (i11 > this.k / 2)
        {
          i5 = 1;
          i1 = i11;
        }
      }
      return i1;
    }
    return 0;
  }
  
  public static e w()
  {
    return null;
  }
  
  private void y()
  {
    int i1 = this.e * 2;
    this.e = i1;
    this.g = ((b[])Arrays.copyOf(this.g, i1));
    c localc = this.n;
    localc.d = ((i[])Arrays.copyOf(localc.d, this.e));
    i1 = this.e;
    this.j = new boolean[i1];
    this.f = i1;
    this.m = i1;
  }
  
  void A(a parama)
  {
    u(parama);
    B(parama, false);
    n();
  }
  
  public void D()
  {
    int i1 = 0;
    for (;;)
    {
      localObject = this.n;
      i[] arrayOfi = ((c)localObject).d;
      if (i1 >= arrayOfi.length) {
        break;
      }
      localObject = arrayOfi[i1];
      if (localObject != null) {
        ((i)localObject).e();
      }
      i1 += 1;
    }
    ((c)localObject).c.c(this.o, this.p);
    this.p = 0;
    Arrays.fill(this.n.d, null);
    Object localObject = this.c;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    this.b = 0;
    this.d.clear();
    this.k = 1;
    i1 = 0;
    while (i1 < this.l)
    {
      localObject = this.g;
      if (localObject[i1] != null) {
        localObject[i1].c = false;
      }
      i1 += 1;
    }
    C();
    this.l = 0;
    if (v) {
      localObject = new b(this.n);
    } else {
      localObject = new b(this.n);
    }
    this.q = ((a)localObject);
  }
  
  public void b(k0.e parame1, k0.e parame2, float paramFloat, int paramInt)
  {
    Object localObject1 = k0.d.b.b;
    i locali1 = q(parame1.q((k0.d.b)localObject1));
    Object localObject4 = k0.d.b.c;
    i locali3 = q(parame1.q((k0.d.b)localObject4));
    Object localObject3 = k0.d.b.d;
    i locali2 = q(parame1.q((k0.d.b)localObject3));
    Object localObject2 = k0.d.b.e;
    parame1 = q(parame1.q((k0.d.b)localObject2));
    localObject1 = q(parame2.q((k0.d.b)localObject1));
    localObject4 = q(parame2.q((k0.d.b)localObject4));
    localObject3 = q(parame2.q((k0.d.b)localObject3));
    parame2 = q(parame2.q((k0.d.b)localObject2));
    localObject2 = r();
    double d1 = paramFloat;
    double d2 = Math.sin(d1);
    double d3 = paramInt;
    ((b)localObject2).q(locali3, parame1, (i)localObject4, parame2, (float)(d2 * d3));
    d((b)localObject2);
    parame1 = r();
    parame1.q(locali1, locali2, (i)localObject1, (i)localObject3, (float)(Math.cos(d1) * d3));
    d(parame1);
  }
  
  public void c(i parami1, i parami2, int paramInt1, float paramFloat, i parami3, i parami4, int paramInt2, int paramInt3)
  {
    b localb = r();
    localb.h(parami1, parami2, paramInt1, paramFloat, parami3, parami4, paramInt2);
    if (paramInt3 != 8) {
      localb.d(this, paramInt3);
    }
    d(localb);
  }
  
  public void d(b paramb)
  {
    if (paramb == null) {
      return;
    }
    int i1 = this.l;
    int i2 = 1;
    if ((i1 + 1 >= this.m) || (this.k + 1 >= this.f)) {
      y();
    }
    i1 = 0;
    if (!paramb.f)
    {
      paramb.D(this);
      if (paramb.isEmpty()) {
        return;
      }
      paramb.r();
      if (paramb.f(this))
      {
        Object localObject = p();
        paramb.a = ((i)localObject);
        i1 = this.l;
        l(paramb);
        if (this.l == i1 + 1)
        {
          this.q.c(paramb);
          B(this.q, true);
          i1 = i2;
          if (((i)localObject).d != -1) {
            break label233;
          }
          if (paramb.a == localObject)
          {
            localObject = paramb.v((i)localObject);
            if (localObject != null) {
              paramb.x((i)localObject);
            }
          }
          if (!paramb.f) {
            paramb.a.h(this, paramb);
          }
          if (v) {
            localObject = this.n.a;
          } else {
            localObject = this.n.b;
          }
          ((f)localObject).a(paramb);
          this.l -= 1;
          i1 = i2;
          break label233;
        }
      }
      i1 = 0;
      label233:
      if (!paramb.s()) {
        return;
      }
    }
    if (i1 == 0) {
      l(paramb);
    }
  }
  
  public b e(i parami1, i parami2, int paramInt1, int paramInt2)
  {
    if ((s) && (paramInt2 == 8) && (parami2.g) && (parami1.d == -1))
    {
      parami1.f(this, parami2.f + paramInt1);
      return null;
    }
    b localb = r();
    localb.n(parami1, parami2, paramInt1);
    if (paramInt2 != 8) {
      localb.d(this, paramInt2);
    }
    d(localb);
    return localb;
  }
  
  public void f(i parami, int paramInt)
  {
    Object localObject;
    if ((s) && (parami.d == -1))
    {
      float f1 = paramInt;
      parami.f(this, f1);
      paramInt = 0;
      while (paramInt < this.b + 1)
      {
        localObject = this.n.d[paramInt];
        if ((localObject != null) && (((i)localObject).n) && (((i)localObject).o == parami.c)) {
          ((i)localObject).f(this, ((i)localObject).p + f1);
        }
        paramInt += 1;
      }
      return;
    }
    int i1 = parami.d;
    if (i1 != -1)
    {
      localObject = this.g[i1];
      if (((b)localObject).f) {}
      for (;;)
      {
        ((b)localObject).b = paramInt;
        return;
        if (((b)localObject).e.e() != 0) {
          break;
        }
        ((b)localObject).f = true;
      }
      localObject = r();
      ((b)localObject).m(parami, paramInt);
      parami = (i)localObject;
    }
    else
    {
      localObject = r();
      ((b)localObject).i(parami, paramInt);
      parami = (i)localObject;
    }
    d(parami);
  }
  
  public void g(i parami1, i parami2, int paramInt, boolean paramBoolean)
  {
    b localb = r();
    i locali = t();
    locali.e = 0;
    localb.o(parami1, parami2, locali, paramInt);
    d(localb);
  }
  
  public void h(i parami1, i parami2, int paramInt1, int paramInt2)
  {
    b localb = r();
    i locali = t();
    locali.e = 0;
    localb.o(parami1, parami2, locali, paramInt1);
    if (paramInt2 != 8) {
      m(localb, (int)(localb.e.b(locali) * -1.0F), paramInt2);
    }
    d(localb);
  }
  
  public void i(i parami1, i parami2, int paramInt, boolean paramBoolean)
  {
    b localb = r();
    i locali = t();
    locali.e = 0;
    localb.p(parami1, parami2, locali, paramInt);
    d(localb);
  }
  
  public void j(i parami1, i parami2, int paramInt1, int paramInt2)
  {
    b localb = r();
    i locali = t();
    locali.e = 0;
    localb.p(parami1, parami2, locali, paramInt1);
    if (paramInt2 != 8) {
      m(localb, (int)(localb.e.b(locali) * -1.0F), paramInt2);
    }
    d(localb);
  }
  
  public void k(i parami1, i parami2, i parami3, i parami4, float paramFloat, int paramInt)
  {
    b localb = r();
    localb.k(parami1, parami2, parami3, parami4, paramFloat);
    if (paramInt != 8) {
      localb.d(this, paramInt);
    }
    d(localb);
  }
  
  void m(b paramb, int paramInt1, int paramInt2)
  {
    paramb.e(o(paramInt2, null), paramInt1);
  }
  
  public i o(int paramInt, String paramString)
  {
    if (this.k + 1 >= this.f) {
      y();
    }
    paramString = a(i.a.d, paramString);
    int i1 = this.b + 1;
    this.b = i1;
    this.k += 1;
    paramString.c = i1;
    paramString.e = paramInt;
    this.n.d[i1] = paramString;
    this.d.b(paramString);
    return paramString;
  }
  
  public i p()
  {
    if (this.k + 1 >= this.f) {
      y();
    }
    i locali = a(i.a.c, null);
    int i1 = this.b + 1;
    this.b = i1;
    this.k += 1;
    locali.c = i1;
    this.n.d[i1] = locali;
    return locali;
  }
  
  public i q(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      return null;
    }
    if (this.k + 1 >= this.f) {
      y();
    }
    if ((paramObject instanceof k0.d))
    {
      k0.d locald = (k0.d)paramObject;
      localObject = locald.i();
      paramObject = localObject;
      if (localObject == null)
      {
        locald.s(this.n);
        paramObject = locald.i();
      }
      int i1 = paramObject.c;
      if ((i1 != -1) && (i1 <= this.b))
      {
        localObject = paramObject;
        if (this.n.d[i1] != null) {}
      }
      else
      {
        if (i1 != -1) {
          paramObject.e();
        }
        i1 = this.b + 1;
        this.b = i1;
        this.k += 1;
        paramObject.c = i1;
        paramObject.j = i.a.a;
        this.n.d[i1] = paramObject;
        localObject = paramObject;
      }
    }
    return localObject;
  }
  
  public b r()
  {
    b localb;
    Object localObject;
    if (v)
    {
      localb = (b)this.n.a.b();
      localObject = localb;
      if (localb == null)
      {
        localObject = new b(this.n);
        y += 1L;
        break label101;
      }
    }
    else
    {
      localb = (b)this.n.b.b();
      localObject = localb;
      if (localb == null)
      {
        localObject = new b(this.n);
        x += 1L;
        break label101;
      }
    }
    ((b)localObject).y();
    label101:
    i.c();
    return localObject;
  }
  
  public i t()
  {
    if (this.k + 1 >= this.f) {
      y();
    }
    i locali = a(i.a.c, null);
    int i1 = this.b + 1;
    this.b = i1;
    this.k += 1;
    locali.c = i1;
    this.n.d[i1] = locali;
    return locali;
  }
  
  public c v()
  {
    return this.n;
  }
  
  public int x(Object paramObject)
  {
    paramObject = ((k0.d)paramObject).i();
    if (paramObject != null) {
      return (int)(paramObject.f + 0.5F);
    }
    return 0;
  }
  
  public void z()
  {
    if (this.d.isEmpty())
    {
      n();
      return;
    }
    if ((!this.h) && (!this.i)) {}
    int i1;
    label81:
    do
    {
      A(this.d);
      return;
      int i2 = 0;
      i1 = 0;
      while (i1 < this.l)
      {
        if (!this.g[i1].f)
        {
          i1 = i2;
          break label81;
        }
        i1 += 1;
      }
      i1 = 1;
    } while (i1 == 0);
    n();
  }
  
  static abstract interface a
  {
    public abstract i a(d paramd, boolean[] paramArrayOfBoolean);
    
    public abstract void b(i parami);
    
    public abstract void c(a parama);
    
    public abstract void clear();
    
    public abstract i getKey();
    
    public abstract boolean isEmpty();
  }
  
  class b
    extends b
  {
    public b(c paramc)
    {
      this.e = new j(this, paramc);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h0.d
 * JD-Core Version:    0.7.0.1
 */