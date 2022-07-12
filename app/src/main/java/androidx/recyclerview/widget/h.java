package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import u0.f;

final class h
  implements Runnable
{
  static final ThreadLocal<h> e = new ThreadLocal();
  static Comparator<c> f = new a();
  ArrayList<RecyclerView> a = new ArrayList();
  long b;
  long c;
  private ArrayList<c> d = new ArrayList();
  
  private void b()
  {
    int n = this.a.size();
    int i = 0;
    Object localObject;
    int k;
    for (int j = i; i < n; j = k)
    {
      localObject = (RecyclerView)this.a.get(i);
      k = j;
      if (((ViewGroup)localObject).getWindowVisibility() == 0)
      {
        ((RecyclerView)localObject).i0.c((RecyclerView)localObject, false);
        k = j + ((RecyclerView)localObject).i0.d;
      }
      i += 1;
    }
    this.d.ensureCapacity(j);
    j = 0;
    int m;
    for (i = j; j < n; i = m)
    {
      RecyclerView localRecyclerView = (RecyclerView)this.a.get(j);
      if (localRecyclerView.getWindowVisibility() != 0)
      {
        m = i;
      }
      else
      {
        b localb = localRecyclerView.i0;
        int i1 = Math.abs(localb.a) + Math.abs(localb.b);
        k = 0;
        for (;;)
        {
          m = i;
          if (k >= localb.d * 2) {
            break;
          }
          if (i >= this.d.size())
          {
            localObject = new c();
            this.d.add(localObject);
          }
          else
          {
            localObject = (c)this.d.get(i);
          }
          int[] arrayOfInt = localb.c;
          m = arrayOfInt[(k + 1)];
          boolean bool;
          if (m <= i1) {
            bool = true;
          } else {
            bool = false;
          }
          ((c)localObject).a = bool;
          ((c)localObject).b = i1;
          ((c)localObject).c = m;
          ((c)localObject).d = localRecyclerView;
          ((c)localObject).e = arrayOfInt[k];
          i += 1;
          k += 2;
        }
      }
      j += 1;
    }
    Collections.sort(this.d, f);
  }
  
  private void c(c paramc, long paramLong)
  {
    long l;
    if (paramc.a) {
      l = 9223372036854775807L;
    } else {
      l = paramLong;
    }
    paramc = i(paramc.d, paramc.e, l);
    if ((paramc != null) && (paramc.b != null) && (paramc.s()) && (!paramc.t())) {
      h((RecyclerView)paramc.b.get(), paramLong);
    }
  }
  
  private void d(long paramLong)
  {
    int i = 0;
    while (i < this.d.size())
    {
      c localc = (c)this.d.get(i);
      if (localc.d == null) {
        return;
      }
      c(localc, paramLong);
      localc.a();
      i += 1;
    }
  }
  
  static boolean e(RecyclerView paramRecyclerView, int paramInt)
  {
    int j = paramRecyclerView.e.j();
    int i = 0;
    while (i < j)
    {
      RecyclerView.c0 localc0 = RecyclerView.h0(paramRecyclerView.e.i(i));
      if ((localc0.c == paramInt) && (!localc0.t())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void h(RecyclerView paramRecyclerView, long paramLong)
  {
    if (paramRecyclerView == null) {
      return;
    }
    if ((paramRecyclerView.F) && (paramRecyclerView.e.j() != 0)) {
      paramRecyclerView.X0();
    }
    b localb = paramRecyclerView.i0;
    localb.c(paramRecyclerView, true);
    if (localb.d != 0) {
      try
      {
        f.a("RV Nested Prefetch");
        paramRecyclerView.j0.f(paramRecyclerView.l);
        int i = 0;
        while (i < localb.d * 2)
        {
          i(paramRecyclerView, localb.c[i], paramLong);
          i += 2;
        }
        return;
      }
      finally
      {
        f.b();
      }
    }
  }
  
  private RecyclerView.c0 i(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    if (e(paramRecyclerView, paramInt)) {
      return null;
    }
    RecyclerView.v localv = paramRecyclerView.b;
    try
    {
      paramRecyclerView.J0();
      RecyclerView.c0 localc0 = localv.I(paramInt, false, paramLong);
      if (localc0 != null) {
        if ((localc0.s()) && (!localc0.t())) {
          localv.B(localc0.a);
        } else {
          localv.a(localc0, false);
        }
      }
      return localc0;
    }
    finally
    {
      paramRecyclerView.L0(false);
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.a.add(paramRecyclerView);
  }
  
  void f(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.isAttachedToWindow()) && (this.b == 0L))
    {
      this.b = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView.i0.e(paramInt1, paramInt2);
  }
  
  void g(long paramLong)
  {
    b();
    d(paramLong);
  }
  
  public void j(RecyclerView paramRecyclerView)
  {
    this.a.remove(paramRecyclerView);
  }
  
  public void run()
  {
    for (;;)
    {
      int i;
      long l2;
      try
      {
        f.a("RV Prefetch");
        boolean bool = this.a.isEmpty();
        if (bool) {
          return;
        }
        int j = this.a.size();
        i = 0;
        l1 = 0L;
        if (i >= j) {
          break label134;
        }
        RecyclerView localRecyclerView = (RecyclerView)this.a.get(i);
        l2 = l1;
        if (localRecyclerView.getWindowVisibility() != 0) {
          break label123;
        }
        l2 = Math.max(localRecyclerView.getDrawingTime(), l1);
      }
      finally
      {
        this.b = 0L;
        f.b();
      }
      g(TimeUnit.MILLISECONDS.toNanos(l1) + this.c);
      this.b = 0L;
      f.b();
      return;
      label123:
      i += 1;
      long l1 = l2;
      continue;
      label134:
      if (l1 != 0L) {}
    }
  }
  
  class a
    implements Comparator<h.c>
  {
    public int a(h.c paramc1, h.c paramc2)
    {
      RecyclerView localRecyclerView = paramc1.d;
      int k = 1;
      if (localRecyclerView == null) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (paramc2.d == null) {
        j = 1;
      } else {
        j = 0;
      }
      if (i != j)
      {
        if (localRecyclerView == null) {
          return 1;
        }
        return -1;
      }
      boolean bool = paramc1.a;
      if (bool != paramc2.a)
      {
        i = k;
        if (bool) {
          i = -1;
        }
        return i;
      }
      int i = paramc2.b - paramc1.b;
      if (i != 0) {
        return i;
      }
      i = paramc1.c - paramc2.c;
      if (i != 0) {
        return i;
      }
      return 0;
    }
  }
  
  @SuppressLint({"VisibleForTests"})
  static class b
    implements RecyclerView.p.c
  {
    int a;
    int b;
    int[] c;
    int d;
    
    public void a(int paramInt1, int paramInt2)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= 0)
        {
          int i = this.d * 2;
          int[] arrayOfInt1 = this.c;
          if (arrayOfInt1 == null)
          {
            arrayOfInt1 = new int[4];
            this.c = arrayOfInt1;
            Arrays.fill(arrayOfInt1, -1);
          }
          else if (i >= arrayOfInt1.length)
          {
            int[] arrayOfInt2 = new int[i * 2];
            this.c = arrayOfInt2;
            System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
          }
          arrayOfInt1 = this.c;
          arrayOfInt1[i] = paramInt1;
          arrayOfInt1[(i + 1)] = paramInt2;
          this.d += 1;
          return;
        }
        throw new IllegalArgumentException("Pixel distance must be non-negative");
      }
      throw new IllegalArgumentException("Layout positions must be non-negative");
    }
    
    void b()
    {
      int[] arrayOfInt = this.c;
      if (arrayOfInt != null) {
        Arrays.fill(arrayOfInt, -1);
      }
      this.d = 0;
    }
    
    void c(RecyclerView paramRecyclerView, boolean paramBoolean)
    {
      this.d = 0;
      Object localObject = this.c;
      if (localObject != null) {
        Arrays.fill((int[])localObject, -1);
      }
      localObject = paramRecyclerView.m;
      if ((paramRecyclerView.l != null) && (localObject != null) && (((RecyclerView.p)localObject).u0()))
      {
        if (paramBoolean)
        {
          if (!paramRecyclerView.d.p()) {
            ((RecyclerView.p)localObject).p(paramRecyclerView.l.d(), this);
          }
        }
        else if (!paramRecyclerView.o0()) {
          ((RecyclerView.p)localObject).o(this.a, this.b, paramRecyclerView.j0, this);
        }
        int i = this.d;
        if (i > ((RecyclerView.p)localObject).m)
        {
          ((RecyclerView.p)localObject).m = i;
          ((RecyclerView.p)localObject).n = paramBoolean;
          paramRecyclerView.b.K();
        }
      }
    }
    
    boolean d(int paramInt)
    {
      if (this.c != null)
      {
        int j = this.d;
        int i = 0;
        while (i < j * 2)
        {
          if (this.c[i] == paramInt) {
            return true;
          }
          i += 2;
        }
      }
      return false;
    }
    
    void e(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
  
  static class c
  {
    public boolean a;
    public int b;
    public int c;
    public RecyclerView d;
    public int e;
    
    public void a()
    {
      this.a = false;
      this.b = 0;
      this.c = 0;
      this.d = null;
      this.e = 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.h
 * JD-Core Version:    0.7.0.1
 */