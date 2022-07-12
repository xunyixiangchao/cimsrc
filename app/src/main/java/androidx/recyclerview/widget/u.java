package androidx.recyclerview.widget;

import g0.d;
import g0.g;
import x0.e;
import x0.f;

class u
{
  final g<RecyclerView.c0, a> a = new g();
  final d<RecyclerView.c0> b = new d();
  
  private RecyclerView.m.c l(RecyclerView.c0 paramc0, int paramInt)
  {
    int i = this.a.f(paramc0);
    if (i < 0) {
      return null;
    }
    a locala = (a)this.a.m(i);
    if (locala != null)
    {
      int j = locala.a;
      if ((j & paramInt) != 0)
      {
        j = paramInt & j;
        locala.a = j;
        if (paramInt == 4)
        {
          paramc0 = locala.b;
        }
        else
        {
          if (paramInt != 8) {
            break label110;
          }
          paramc0 = locala.c;
        }
        if ((j & 0xC) == 0)
        {
          this.a.k(i);
          a.c(locala);
        }
        return paramc0;
        label110:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
      }
    }
    return null;
  }
  
  void a(RecyclerView.c0 paramc0, RecyclerView.m.c paramc)
  {
    a locala2 = (a)this.a.get(paramc0);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.b();
      this.a.put(paramc0, locala1);
    }
    locala1.a |= 0x2;
    locala1.b = paramc;
  }
  
  void b(RecyclerView.c0 paramc0)
  {
    a locala2 = (a)this.a.get(paramc0);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.b();
      this.a.put(paramc0, locala1);
    }
    locala1.a |= 0x1;
  }
  
  void c(long paramLong, RecyclerView.c0 paramc0)
  {
    this.b.l(paramLong, paramc0);
  }
  
  void d(RecyclerView.c0 paramc0, RecyclerView.m.c paramc)
  {
    a locala2 = (a)this.a.get(paramc0);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.b();
      this.a.put(paramc0, locala1);
    }
    locala1.c = paramc;
    locala1.a |= 0x8;
  }
  
  void e(RecyclerView.c0 paramc0, RecyclerView.m.c paramc)
  {
    a locala2 = (a)this.a.get(paramc0);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.b();
      this.a.put(paramc0, locala1);
    }
    locala1.b = paramc;
    locala1.a |= 0x4;
  }
  
  void f()
  {
    this.a.clear();
    this.b.b();
  }
  
  RecyclerView.c0 g(long paramLong)
  {
    return (RecyclerView.c0)this.b.e(paramLong);
  }
  
  boolean h(RecyclerView.c0 paramc0)
  {
    paramc0 = (a)this.a.get(paramc0);
    return (paramc0 != null) && ((paramc0.a & 0x1) != 0);
  }
  
  boolean i(RecyclerView.c0 paramc0)
  {
    paramc0 = (a)this.a.get(paramc0);
    return (paramc0 != null) && ((paramc0.a & 0x4) != 0);
  }
  
  void j() {}
  
  public void k(RecyclerView.c0 paramc0)
  {
    p(paramc0);
  }
  
  RecyclerView.m.c m(RecyclerView.c0 paramc0)
  {
    return l(paramc0, 8);
  }
  
  RecyclerView.m.c n(RecyclerView.c0 paramc0)
  {
    return l(paramc0, 4);
  }
  
  void o(b paramb)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      RecyclerView.c0 localc0 = (RecyclerView.c0)this.a.i(i);
      a locala = (a)this.a.k(i);
      int j = locala.a;
      if ((j & 0x3) == 3) {}
      RecyclerView.m.c localc1;
      do
      {
        paramb.a(localc0);
        break label196;
        if ((j & 0x1) == 0) {
          break;
        }
        localc1 = locala.b;
      } while (localc1 == null);
      RecyclerView.m.c localc2 = locala.c;
      paramb.c(localc0, localc1, localc2);
      break label196;
      if ((j & 0xE) == 14) {}
      do
      {
        paramb.b(localc0, locala.b, locala.c);
        break label196;
        if ((j & 0xC) == 12)
        {
          paramb.d(localc0, locala.b, locala.c);
          break label196;
        }
        if ((j & 0x4) != 0)
        {
          localc1 = locala.b;
          localc2 = null;
          break;
        }
      } while ((j & 0x8) != 0);
      label196:
      a.c(locala);
      i -= 1;
    }
  }
  
  void p(RecyclerView.c0 paramc0)
  {
    paramc0 = (a)this.a.get(paramc0);
    if (paramc0 == null) {
      return;
    }
    paramc0.a &= 0xFFFFFFFE;
  }
  
  void q(RecyclerView.c0 paramc0)
  {
    int i = this.b.o() - 1;
    while (i >= 0)
    {
      if (paramc0 == this.b.p(i))
      {
        this.b.n(i);
        break;
      }
      i -= 1;
    }
    paramc0 = (a)this.a.remove(paramc0);
    if (paramc0 != null) {
      a.c(paramc0);
    }
  }
  
  static class a
  {
    static e<a> d = new f(20);
    int a;
    RecyclerView.m.c b;
    RecyclerView.m.c c;
    
    static void a()
    {
      while (d.b() != null) {}
    }
    
    static a b()
    {
      a locala2 = (a)d.b();
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a();
      }
      return locala1;
    }
    
    static void c(a parama)
    {
      parama.a = 0;
      parama.b = null;
      parama.c = null;
      d.a(parama);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(RecyclerView.c0 paramc0);
    
    public abstract void b(RecyclerView.c0 paramc0, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2);
    
    public abstract void c(RecyclerView.c0 paramc0, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2);
    
    public abstract void d(RecyclerView.c0 paramc0, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.u
 * JD-Core Version:    0.7.0.1
 */