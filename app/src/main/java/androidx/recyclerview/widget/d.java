package androidx.recyclerview.widget;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import x0.h;

class d
  implements k.b
{
  private final c a;
  private final v b;
  private List<WeakReference<RecyclerView>> c = new ArrayList();
  private final IdentityHashMap<RecyclerView.c0, k> d = new IdentityHashMap();
  private List<k> e = new ArrayList();
  private a f = new a();
  private final c.a.a g;
  private final s h;
  
  d(c paramc, c.a parama)
  {
    this.a = paramc;
    if (parama.a) {
      paramc = new v.a();
    } else {
      paramc = new v.b();
    }
    this.b = paramc;
    paramc = parama.b;
    this.g = paramc;
    if (paramc == c.a.a.a) {
      paramc = new s.b();
    }
    for (;;)
    {
      this.h = paramc;
      return;
      if (paramc == c.a.a.b)
      {
        paramc = new s.a();
      }
      else
      {
        if (paramc != c.a.a.c) {
          break;
        }
        paramc = new s.c();
      }
    }
    throw new IllegalArgumentException("unknown stable id mode");
  }
  
  private void C(a parama)
  {
    parama.c = false;
    parama.a = null;
    parama.b = -1;
    this.f = parama;
  }
  
  private void i()
  {
    RecyclerView.h.a locala = j();
    if (locala != this.a.g()) {
      this.a.J(locala);
    }
  }
  
  private RecyclerView.h.a j()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      RecyclerView.h.a locala1 = localk.c.g();
      RecyclerView.h.a locala2 = RecyclerView.h.a.c;
      if (locala1 == locala2) {
        return locala2;
      }
      if ((locala1 == RecyclerView.h.a.b) && (localk.a() == 0)) {
        return locala2;
      }
    }
    return RecyclerView.h.a.a;
  }
  
  private int k(k paramk)
  {
    Iterator localIterator = this.e.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk == paramk) {
        break;
      }
      i += localk.a();
    }
    return i;
  }
  
  private a l(int paramInt)
  {
    Object localObject = this.f;
    if (((a)localObject).c) {
      localObject = new a();
    } else {
      ((a)localObject).c = true;
    }
    Iterator localIterator = this.e.iterator();
    int i = paramInt;
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.a() > i)
      {
        ((a)localObject).a = localk;
        ((a)localObject).b = i;
        break;
      }
      i -= localk.a();
    }
    if (((a)localObject).a != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find wrapper for ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private k m(RecyclerView.h<RecyclerView.c0> paramh)
  {
    int i = s(paramh);
    if (i == -1) {
      return null;
    }
    return (k)this.e.get(i);
  }
  
  private k q(RecyclerView.c0 paramc0)
  {
    Object localObject = (k)this.d.get(paramc0);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find wrapper for ");
    ((StringBuilder)localObject).append(paramc0);
    ((StringBuilder)localObject).append(", seems like it is not bound by this adapter: ");
    ((StringBuilder)localObject).append(this);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  private int s(RecyclerView.h<RecyclerView.c0> paramh)
  {
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      if (((k)this.e.get(i)).c == paramh) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private boolean t(RecyclerView paramRecyclerView)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramRecyclerView) {
        return true;
      }
    }
    return false;
  }
  
  public void A(RecyclerView.c0 paramc0)
  {
    q(paramc0).c.C(paramc0);
  }
  
  public void B(RecyclerView.c0 paramc0)
  {
    Object localObject = (k)this.d.get(paramc0);
    if (localObject != null)
    {
      ((k)localObject).c.D(paramc0);
      this.d.remove(paramc0);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find wrapper for ");
    ((StringBuilder)localObject).append(paramc0);
    ((StringBuilder)localObject).append(", seems like it is not bound by this adapter: ");
    ((StringBuilder)localObject).append(this);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void a(k paramk)
  {
    i();
  }
  
  public void b(k paramk, int paramInt1, int paramInt2)
  {
    int i = k(paramk);
    this.a.s(paramInt1 + i, paramInt2);
  }
  
  public void c(k paramk, int paramInt1, int paramInt2)
  {
    int i = k(paramk);
    this.a.q(paramInt1 + i, paramInt2 + i);
  }
  
  public void d(k paramk, int paramInt1, int paramInt2, Object paramObject)
  {
    int i = k(paramk);
    this.a.r(paramInt1 + i, paramInt2, paramObject);
  }
  
  public void e(k paramk)
  {
    this.a.j();
    i();
  }
  
  public void f(k paramk, int paramInt1, int paramInt2)
  {
    int i = k(paramk);
    this.a.t(paramInt1 + i, paramInt2);
  }
  
  boolean g(int paramInt, RecyclerView.h<RecyclerView.c0> paramh)
  {
    if ((paramInt >= 0) && (paramInt <= this.e.size()))
    {
      if (r()) {
        h.b(paramh.i(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
      } else if (paramh.i()) {
        Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
      }
      if (m(paramh) != null) {
        return false;
      }
      k localk = new k(paramh, this, this.b, this.h.a());
      this.e.add(paramInt, localk);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        RecyclerView localRecyclerView = (RecyclerView)((WeakReference)localIterator.next()).get();
        if (localRecyclerView != null) {
          paramh.v(localRecyclerView);
        }
      }
      if (localk.a() > 0) {
        this.a.s(k(localk), localk.a());
      }
      i();
      return true;
    }
    paramh = new StringBuilder();
    paramh.append("Index must be between 0 and ");
    paramh.append(this.e.size());
    paramh.append(". Given:");
    paramh.append(paramInt);
    throw new IndexOutOfBoundsException(paramh.toString());
  }
  
  boolean h(RecyclerView.h<RecyclerView.c0> paramh)
  {
    return g(this.e.size(), paramh);
  }
  
  public long n(int paramInt)
  {
    a locala = l(paramInt);
    long l = locala.a.b(locala.b);
    C(locala);
    return l;
  }
  
  public int o(int paramInt)
  {
    a locala = l(paramInt);
    paramInt = locala.a.c(locala.b);
    C(locala);
    return paramInt;
  }
  
  public int p()
  {
    Iterator localIterator = this.e.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((k)localIterator.next()).a();
    }
    return i;
  }
  
  public boolean r()
  {
    return this.g != c.a.a.a;
  }
  
  public void u(RecyclerView paramRecyclerView)
  {
    if (t(paramRecyclerView)) {
      return;
    }
    this.c.add(new WeakReference(paramRecyclerView));
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).c.v(paramRecyclerView);
    }
  }
  
  public void v(RecyclerView.c0 paramc0, int paramInt)
  {
    a locala = l(paramInt);
    this.d.put(paramc0, locala.a);
    locala.a.d(paramc0, locala.b);
    C(locala);
  }
  
  public RecyclerView.c0 w(ViewGroup paramViewGroup, int paramInt)
  {
    return this.b.b(paramInt).e(paramViewGroup, paramInt);
  }
  
  public void x(RecyclerView paramRecyclerView)
  {
    int i = this.c.size() - 1;
    while (i >= 0)
    {
      localObject = (WeakReference)this.c.get(i);
      if (((WeakReference)localObject).get() == null)
      {
        this.c.remove(i);
      }
      else if (((WeakReference)localObject).get() == paramRecyclerView)
      {
        this.c.remove(i);
        break;
      }
      i -= 1;
    }
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((k)((Iterator)localObject).next()).c.z(paramRecyclerView);
    }
  }
  
  public boolean y(RecyclerView.c0 paramc0)
  {
    Object localObject = (k)this.d.get(paramc0);
    if (localObject != null)
    {
      boolean bool = ((k)localObject).c.A(paramc0);
      this.d.remove(paramc0);
      return bool;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find wrapper for ");
    ((StringBuilder)localObject).append(paramc0);
    ((StringBuilder)localObject).append(", seems like it is not bound by this adapter: ");
    ((StringBuilder)localObject).append(this);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void z(RecyclerView.c0 paramc0)
  {
    q(paramc0).c.B(paramc0);
  }
  
  static class a
  {
    k a;
    int b;
    boolean c;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.d
 * JD-Core Version:    0.7.0.1
 */