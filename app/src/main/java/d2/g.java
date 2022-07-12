package d2;

import b2.d;
import b2.f;
import b2.k;
import b2.l;
import com.bumptech.glide.i;
import e2.b;
import f2.a;
import h2.n;
import h2.n.a;
import j2.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class g<Transcode>
{
  private final List<n.a<?>> a = new ArrayList();
  private final List<f> b = new ArrayList();
  private com.bumptech.glide.e c;
  private Object d;
  private int e;
  private int f;
  private Class<?> g;
  private h.e h;
  private b2.h i;
  private Map<Class<?>, l<?>> j;
  private Class<Transcode> k;
  private boolean l;
  private boolean m;
  private f n;
  private com.bumptech.glide.h o;
  private j p;
  private boolean q;
  private boolean r;
  
  void a()
  {
    this.c = null;
    this.d = null;
    this.n = null;
    this.g = null;
    this.k = null;
    this.i = null;
    this.o = null;
    this.j = null;
    this.p = null;
    this.a.clear();
    this.l = false;
    this.b.clear();
    this.m = false;
  }
  
  b b()
  {
    return this.c.b();
  }
  
  List<f> c()
  {
    if (!this.m)
    {
      this.m = true;
      this.b.clear();
      List localList = g();
      int i3 = localList.size();
      int i1 = 0;
      while (i1 < i3)
      {
        n.a locala = (n.a)localList.get(i1);
        if (!this.b.contains(locala.a)) {
          this.b.add(locala.a);
        }
        int i2 = 0;
        while (i2 < locala.b.size())
        {
          if (!this.b.contains(locala.b.get(i2))) {
            this.b.add(locala.b.get(i2));
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
    return this.b;
  }
  
  a d()
  {
    return this.h.a();
  }
  
  j e()
  {
    return this.p;
  }
  
  int f()
  {
    return this.f;
  }
  
  List<n.a<?>> g()
  {
    if (!this.l)
    {
      this.l = true;
      this.a.clear();
      List localList = this.c.i().i(this.d);
      int i1 = 0;
      int i2 = localList.size();
      while (i1 < i2)
      {
        n.a locala = ((n)localList.get(i1)).b(this.d, this.e, this.f, this.i);
        if (locala != null) {
          this.a.add(locala);
        }
        i1 += 1;
      }
    }
    return this.a;
  }
  
  <Data> t<Data, ?, Transcode> h(Class<Data> paramClass)
  {
    return this.c.i().h(paramClass, this.g, this.k);
  }
  
  Class<?> i()
  {
    return this.d.getClass();
  }
  
  List<n<File, ?>> j(File paramFile)
  {
    return this.c.i().i(paramFile);
  }
  
  b2.h k()
  {
    return this.i;
  }
  
  com.bumptech.glide.h l()
  {
    return this.o;
  }
  
  List<Class<?>> m()
  {
    return this.c.i().j(this.d.getClass(), this.g, this.k);
  }
  
  <Z> k<Z> n(v<Z> paramv)
  {
    return this.c.i().k(paramv);
  }
  
  <T> com.bumptech.glide.load.data.e<T> o(T paramT)
  {
    return this.c.i().l(paramT);
  }
  
  f p()
  {
    return this.n;
  }
  
  <X> d<X> q(X paramX)
  {
    return this.c.i().m(paramX);
  }
  
  Class<?> r()
  {
    return this.k;
  }
  
  <Z> l<Z> s(Class<Z> paramClass)
  {
    l locall = (l)this.j.get(paramClass);
    Object localObject = locall;
    if (locall == null)
    {
      Iterator localIterator = this.j.entrySet().iterator();
      do
      {
        localObject = locall;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
      } while (!((Class)((Map.Entry)localObject).getKey()).isAssignableFrom(paramClass));
      localObject = (l)((Map.Entry)localObject).getValue();
    }
    if (localObject == null)
    {
      if ((this.j.isEmpty()) && (this.q))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Missing transformation for ");
        ((StringBuilder)localObject).append(paramClass);
        ((StringBuilder)localObject).append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      return c.c();
    }
    return localObject;
  }
  
  int t()
  {
    return this.e;
  }
  
  boolean u(Class<?> paramClass)
  {
    return h(paramClass) != null;
  }
  
  <R> void v(com.bumptech.glide.e parame, Object paramObject, f paramf, int paramInt1, int paramInt2, j paramj, Class<?> paramClass, Class<R> paramClass1, com.bumptech.glide.h paramh, b2.h paramh1, Map<Class<?>, l<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, h.e parame1)
  {
    this.c = parame;
    this.d = paramObject;
    this.n = paramf;
    this.e = paramInt1;
    this.f = paramInt2;
    this.p = paramj;
    this.g = paramClass;
    this.h = parame1;
    this.k = paramClass1;
    this.o = paramh;
    this.i = paramh1;
    this.j = paramMap;
    this.q = paramBoolean1;
    this.r = paramBoolean2;
  }
  
  boolean w(v<?> paramv)
  {
    return this.c.i().n(paramv);
  }
  
  boolean x()
  {
    return this.r;
  }
  
  boolean y(f paramf)
  {
    List localList = g();
    int i2 = localList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((n.a)localList.get(i1)).a.equals(paramf)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.g
 * JD-Core Version:    0.7.0.1
 */