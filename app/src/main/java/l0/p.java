package l0;

import java.util.List;
import k0.e;
import k0.e.b;

public abstract class p
  implements d
{
  public int a;
  e b;
  m c;
  protected e.b d;
  g e = new g(this);
  public int f = 0;
  boolean g = false;
  public f h = new f(this);
  public f i = new f(this);
  protected b j = b.a;
  
  public p(e parame)
  {
    this.b = parame;
  }
  
  private void l(int paramInt1, int paramInt2)
  {
    int m = this.a;
    int k = paramInt2;
    if (m != 0) {
      if (m != 1)
      {
        float f1;
        if (m != 2)
        {
          if (m != 3) {
            return;
          }
          locale = this.b;
          localObject1 = locale.e;
          Object localObject2 = ((p)localObject1).d;
          e.b localb = e.b.c;
          if ((localObject2 == localb) && (((p)localObject1).a == 3))
          {
            localObject2 = locale.f;
            if ((((p)localObject2).d == localb) && (((p)localObject2).a == 3)) {
              return;
            }
          }
          if (paramInt1 == 0) {
            localObject1 = locale.f;
          }
          if (!((p)localObject1).e.j) {
            return;
          }
          f1 = locale.x();
          if (paramInt1 == 1) {
            paramInt1 = (int)(((p)localObject1).e.g / f1 + 0.5F);
          } else {
            paramInt1 = (int)(f1 * ((p)localObject1).e.g + 0.5F);
          }
          this.e.d(paramInt1);
          return;
        }
        localObject1 = this.b.M();
        if (localObject1 == null) {
          return;
        }
        if (paramInt1 == 0) {
          localObject1 = ((e)localObject1).e;
        } else {
          localObject1 = ((e)localObject1).f;
        }
        localObject1 = ((p)localObject1).e;
        if (!((f)localObject1).j) {
          return;
        }
        e locale = this.b;
        if (paramInt1 == 0) {
          f1 = locale.B;
        } else {
          f1 = locale.E;
        }
        k = (int)(((f)localObject1).g * f1 + 0.5F);
      }
      else
      {
        paramInt1 = g(this.e.m, paramInt1);
        localObject1 = this.e;
        paramInt1 = Math.min(paramInt1, paramInt2);
        break label312;
      }
    }
    Object localObject1 = this.e;
    paramInt1 = g(k, paramInt1);
    label312:
    ((g)localObject1).d(paramInt1);
  }
  
  public void a(d paramd) {}
  
  protected final void b(f paramf1, f paramf2, int paramInt)
  {
    paramf1.l.add(paramf2);
    paramf1.f = paramInt;
    paramf2.k.add(paramf1);
  }
  
  protected final void c(f paramf1, f paramf2, int paramInt, g paramg)
  {
    paramf1.l.add(paramf2);
    paramf1.l.add(this.e);
    paramf1.h = paramInt;
    paramf1.i = paramg;
    paramf2.k.add(paramf1);
    paramg.k.add(paramf1);
  }
  
  abstract void d();
  
  abstract void e();
  
  abstract void f();
  
  protected final int g(int paramInt1, int paramInt2)
  {
    e locale;
    if (paramInt2 == 0)
    {
      locale = this.b;
      k = locale.A;
      paramInt2 = Math.max(locale.z, paramInt1);
      if (k > 0) {
        paramInt2 = Math.min(k, paramInt1);
      }
      k = paramInt1;
      if (paramInt2 == paramInt1) {
        return k;
      }
    }
    else
    {
      locale = this.b;
      k = locale.D;
      paramInt2 = Math.max(locale.C, paramInt1);
      if (k > 0) {
        paramInt2 = Math.min(k, paramInt1);
      }
      k = paramInt1;
      if (paramInt2 == paramInt1) {
        return k;
      }
    }
    int k = paramInt2;
    return k;
  }
  
  protected final f h(k0.d paramd)
  {
    Object localObject = paramd.f;
    if (localObject == null) {
      return null;
    }
    paramd = ((k0.d)localObject).d;
    localObject = ((k0.d)localObject).e;
    int k = a.a[localObject.ordinal()];
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4)
          {
            if (k != 5) {
              return null;
            }
            paramd = paramd.f;
          }
          else
          {
            return paramd.f.k;
          }
        }
        else
        {
          paramd = paramd.f;
          break label96;
        }
      }
      else {
        paramd = paramd.e;
      }
      return paramd.i;
    }
    else
    {
      paramd = paramd.e;
    }
    label96:
    return paramd.h;
  }
  
  protected final f i(k0.d paramd, int paramInt)
  {
    Object localObject = paramd.f;
    if (localObject == null) {
      return null;
    }
    paramd = ((k0.d)localObject).d;
    if (paramInt == 0) {
      paramd = paramd.e;
    } else {
      paramd = paramd.f;
    }
    localObject = ((k0.d)localObject).e;
    paramInt = a.a[localObject.ordinal()];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          break label74;
        }
        if (paramInt != 5) {
          return null;
        }
      }
      return paramd.i;
    }
    label74:
    return paramd.h;
  }
  
  public long j()
  {
    g localg = this.e;
    if (localg.j) {
      return localg.g;
    }
    return 0L;
  }
  
  public boolean k()
  {
    return this.g;
  }
  
  abstract boolean m();
  
  protected void n(d paramd, k0.d paramd1, k0.d paramd2, int paramInt)
  {
    paramd = h(paramd1);
    f localf = h(paramd2);
    if (paramd.j)
    {
      if (!localf.j) {
        return;
      }
      int m = paramd.g + paramd1.f();
      int k = localf.g - paramd2.f();
      int n = k - m;
      if ((!this.e.j) && (this.d == e.b.c)) {
        l(paramInt, n);
      }
      paramd1 = this.e;
      if (!paramd1.j) {
        return;
      }
      if (paramd1.g == n)
      {
        this.h.d(m);
        paramd = this.i;
      }
      for (;;)
      {
        paramd.d(k);
        return;
        paramd1 = this.b;
        float f1;
        if (paramInt == 0) {
          f1 = paramd1.A();
        } else {
          f1 = paramd1.T();
        }
        paramInt = m;
        if (paramd == localf)
        {
          paramInt = paramd.g;
          k = localf.g;
          f1 = 0.5F;
        }
        m = this.e.g;
        this.h.d((int)(paramInt + 0.5F + (k - paramInt - m) * f1));
        paramd = this.i;
        k = this.h.g + this.e.g;
      }
    }
  }
  
  protected void o(d paramd) {}
  
  protected void p(d paramd) {}
  
  static enum b
  {
    static
    {
      b localb1 = new b("NONE", 0);
      a = localb1;
      b localb2 = new b("START", 1);
      b = localb2;
      b localb3 = new b("END", 2);
      c = localb3;
      b localb4 = new b("CENTER", 3);
      d = localb4;
      e = new b[] { localb1, localb2, localb3, localb4 };
    }
    
    private b() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.p
 * JD-Core Version:    0.7.0.1
 */