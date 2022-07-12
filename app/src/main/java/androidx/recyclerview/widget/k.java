package androidx.recyclerview.widget;

import android.view.ViewGroup;
import x0.h;

class k
{
  private final v.c a;
  private final s.d b;
  public final RecyclerView.h<RecyclerView.c0> c;
  final b d;
  int e;
  private RecyclerView.j f = new a();
  
  k(RecyclerView.h<RecyclerView.c0> paramh, b paramb, v paramv, s.d paramd)
  {
    this.c = paramh;
    this.d = paramb;
    this.a = paramv.a(this);
    this.b = paramd;
    this.e = paramh.d();
    paramh.E(this.f);
  }
  
  int a()
  {
    return this.e;
  }
  
  public long b(int paramInt)
  {
    long l = this.c.e(paramInt);
    return this.b.a(l);
  }
  
  int c(int paramInt)
  {
    return this.a.b(this.c.f(paramInt));
  }
  
  void d(RecyclerView.c0 paramc0, int paramInt)
  {
    this.c.a(paramc0, paramInt);
  }
  
  RecyclerView.c0 e(ViewGroup paramViewGroup, int paramInt)
  {
    paramInt = this.a.a(paramInt);
    return this.c.y(paramViewGroup, paramInt);
  }
  
  class a
    extends RecyclerView.j
  {
    a() {}
    
    public void a()
    {
      k localk = k.this;
      localk.e = localk.c.d();
      localk = k.this;
      localk.d.e(localk);
    }
    
    public void b(int paramInt1, int paramInt2)
    {
      k localk = k.this;
      localk.d.d(localk, paramInt1, paramInt2, null);
    }
    
    public void c(int paramInt1, int paramInt2, Object paramObject)
    {
      k localk = k.this;
      localk.d.d(localk, paramInt1, paramInt2, paramObject);
    }
    
    public void d(int paramInt1, int paramInt2)
    {
      k localk = k.this;
      localk.e += paramInt2;
      localk.d.b(localk, paramInt1, paramInt2);
      localk = k.this;
      if ((localk.e > 0) && (localk.c.g() == RecyclerView.h.a.b))
      {
        localk = k.this;
        localk.d.a(localk);
      }
    }
    
    public void e(int paramInt1, int paramInt2, int paramInt3)
    {
      boolean bool = true;
      if (paramInt3 != 1) {
        bool = false;
      }
      h.b(bool, "moving more than 1 item is not supported in RecyclerView");
      k localk = k.this;
      localk.d.c(localk, paramInt1, paramInt2);
    }
    
    public void f(int paramInt1, int paramInt2)
    {
      k localk = k.this;
      localk.e -= paramInt2;
      localk.d.f(localk, paramInt1, paramInt2);
      localk = k.this;
      if ((localk.e < 1) && (localk.c.g() == RecyclerView.h.a.b))
      {
        localk = k.this;
        localk.d.a(localk);
      }
    }
    
    public void g()
    {
      k localk = k.this;
      localk.d.a(localk);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(k paramk);
    
    public abstract void b(k paramk, int paramInt1, int paramInt2);
    
    public abstract void c(k paramk, int paramInt1, int paramInt2);
    
    public abstract void d(k paramk, int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void e(k paramk);
    
    public abstract void f(k paramk, int paramInt1, int paramInt2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.k
 * JD-Core Version:    0.7.0.1
 */