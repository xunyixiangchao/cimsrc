package androidx.lifecycle;

import android.annotation.SuppressLint;
import j.b;
import j.b.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class m
  extends h
{
  private j.a<k, a> b = new j.a();
  private h.c c;
  private final WeakReference<l> d;
  private int e = 0;
  private boolean f = false;
  private boolean g = false;
  private ArrayList<h.c> h = new ArrayList();
  private final boolean i;
  
  public m(l paraml)
  {
    this(paraml, true);
  }
  
  private m(l paraml, boolean paramBoolean)
  {
    this.d = new WeakReference(paraml);
    this.c = h.c.b;
    this.i = paramBoolean;
  }
  
  private void d(l paraml)
  {
    Iterator localIterator = this.b.a();
    while ((localIterator.hasNext()) && (!this.g))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a locala = (a)localEntry.getValue();
      while ((locala.a.compareTo(this.c) > 0) && (!this.g) && (this.b.contains((k)localEntry.getKey())))
      {
        h.b localb = h.b.a(locala.a);
        if (localb == null) {
          break label124;
        }
        n(localb.b());
        locala.a(paraml, localb);
        m();
      }
      continue;
      label124:
      paraml = new StringBuilder();
      paraml.append("no event down from ");
      paraml.append(locala.a);
      throw new IllegalStateException(paraml.toString());
    }
  }
  
  private h.c e(k paramk)
  {
    paramk = this.b.i(paramk);
    Object localObject = null;
    if (paramk != null) {
      paramk = ((a)paramk.getValue()).a;
    } else {
      paramk = null;
    }
    if (!this.h.isEmpty())
    {
      localObject = this.h;
      localObject = (h.c)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    }
    return k(k(this.c, paramk), (h.c)localObject);
  }
  
  @SuppressLint({"RestrictedApi"})
  private void f(String paramString)
  {
    if (this.i)
    {
      if (i.a.e().b()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Method ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" must be called on the main thread");
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  private void g(l paraml)
  {
    b.d locald = this.b.d();
    while ((locald.hasNext()) && (!this.g))
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      a locala = (a)localEntry.getValue();
      while ((locala.a.compareTo(this.c) < 0) && (!this.g) && (this.b.contains((k)localEntry.getKey())))
      {
        n(locala.a);
        h.b localb = h.b.c(locala.a);
        if (localb == null) {
          break label123;
        }
        locala.a(paraml, localb);
        m();
      }
      continue;
      label123:
      paraml = new StringBuilder();
      paraml.append("no event up from ");
      paraml.append(locala.a);
      throw new IllegalStateException(paraml.toString());
    }
  }
  
  private boolean i()
  {
    if (this.b.size() == 0) {
      return true;
    }
    h.c localc1 = ((a)this.b.b().getValue()).a;
    h.c localc2 = ((a)this.b.e().getValue()).a;
    return (localc1 == localc2) && (this.c == localc2);
  }
  
  static h.c k(h.c paramc1, h.c paramc2)
  {
    h.c localc = paramc1;
    if (paramc2 != null)
    {
      localc = paramc1;
      if (paramc2.compareTo(paramc1) < 0) {
        localc = paramc2;
      }
    }
    return localc;
  }
  
  private void l(h.c paramc)
  {
    if (this.c == paramc) {
      return;
    }
    this.c = paramc;
    if ((!this.f) && (this.e == 0))
    {
      this.f = true;
      p();
      this.f = false;
      return;
    }
    this.g = true;
  }
  
  private void m()
  {
    ArrayList localArrayList = this.h;
    localArrayList.remove(localArrayList.size() - 1);
  }
  
  private void n(h.c paramc)
  {
    this.h.add(paramc);
  }
  
  private void p()
  {
    l locall = (l)this.d.get();
    if (locall != null)
    {
      for (;;)
      {
        boolean bool = i();
        this.g = false;
        if (bool) {
          break;
        }
        if (this.c.compareTo(((a)this.b.b().getValue()).a) < 0) {
          d(locall);
        }
        Map.Entry localEntry = this.b.e();
        if ((!this.g) && (localEntry != null) && (this.c.compareTo(((a)localEntry.getValue()).a) > 0)) {
          g(locall);
        }
      }
      return;
    }
    throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
  }
  
  public void a(k paramk)
  {
    f("addObserver");
    Object localObject2 = this.c;
    Object localObject1 = h.c.a;
    if (localObject2 != localObject1) {
      localObject1 = h.c.b;
    }
    localObject2 = new a(paramk, (h.c)localObject1);
    if ((a)this.b.g(paramk, localObject2) != null) {
      return;
    }
    l locall = (l)this.d.get();
    if (locall == null) {
      return;
    }
    int j;
    if ((this.e == 0) && (!this.f)) {
      j = 0;
    } else {
      j = 1;
    }
    localObject1 = e(paramk);
    this.e += 1;
    while ((((a)localObject2).a.compareTo((Enum)localObject1) < 0) && (this.b.contains(paramk)))
    {
      n(((a)localObject2).a);
      localObject1 = h.b.c(((a)localObject2).a);
      if (localObject1 != null)
      {
        ((a)localObject2).a(locall, (h.b)localObject1);
        m();
        localObject1 = e(paramk);
      }
      else
      {
        paramk = new StringBuilder();
        paramk.append("no event up from ");
        paramk.append(((a)localObject2).a);
        throw new IllegalStateException(paramk.toString());
      }
    }
    if (j == 0) {
      p();
    }
    this.e -= 1;
  }
  
  public h.c b()
  {
    return this.c;
  }
  
  public void c(k paramk)
  {
    f("removeObserver");
    this.b.h(paramk);
  }
  
  public void h(h.b paramb)
  {
    f("handleLifecycleEvent");
    l(paramb.b());
  }
  
  @Deprecated
  public void j(h.c paramc)
  {
    f("markState");
    o(paramc);
  }
  
  public void o(h.c paramc)
  {
    f("setCurrentState");
    l(paramc);
  }
  
  static class a
  {
    h.c a;
    j b;
    
    a(k paramk, h.c paramc)
    {
      this.b = o.f(paramk);
      this.a = paramc;
    }
    
    void a(l paraml, h.b paramb)
    {
      h.c localc = paramb.b();
      this.a = m.k(this.a, localc);
      this.b.d(paraml, paramb);
      this.a = localc;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.m
 * JD-Core Version:    0.7.0.1
 */