package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class b
{
  final b a;
  final a b;
  final List<View> c;
  
  b(b paramb)
  {
    this.a = paramb;
    this.b = new a();
    this.c = new ArrayList();
  }
  
  private int h(int paramInt)
  {
    if (paramInt < 0) {
      return -1;
    }
    int j = this.a.g();
    int i = paramInt;
    while (i < j)
    {
      int k = paramInt - (i - this.b.b(i));
      if (k == 0)
      {
        while (this.b.d(i)) {
          i += 1;
        }
        return i;
      }
      i += k;
    }
    return -1;
  }
  
  private void l(View paramView)
  {
    this.c.add(paramView);
    this.a.b(paramView);
  }
  
  private boolean t(View paramView)
  {
    if (this.c.remove(paramView))
    {
      this.a.e(paramView);
      return true;
    }
    return false;
  }
  
  void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {
      paramInt = this.a.g();
    } else {
      paramInt = h(paramInt);
    }
    this.b.e(paramInt, paramBoolean);
    if (paramBoolean) {
      l(paramView);
    }
    this.a.f(paramView, paramInt);
  }
  
  void b(View paramView, boolean paramBoolean)
  {
    a(paramView, -1, paramBoolean);
  }
  
  void c(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {
      paramInt = this.a.g();
    } else {
      paramInt = h(paramInt);
    }
    this.b.e(paramInt, paramBoolean);
    if (paramBoolean) {
      l(paramView);
    }
    this.a.j(paramView, paramInt, paramLayoutParams);
  }
  
  void d(int paramInt)
  {
    paramInt = h(paramInt);
    this.b.f(paramInt);
    this.a.d(paramInt);
  }
  
  View e(int paramInt)
  {
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.c.get(i);
      RecyclerView.c0 localc0 = this.a.c(localView);
      if ((localc0.m() == paramInt) && (!localc0.t()) && (!localc0.v())) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  View f(int paramInt)
  {
    paramInt = h(paramInt);
    return this.a.a(paramInt);
  }
  
  int g()
  {
    return this.a.g() - this.c.size();
  }
  
  View i(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  int j()
  {
    return this.a.g();
  }
  
  void k(View paramView)
  {
    int i = this.a.k(paramView);
    if (i >= 0)
    {
      this.b.h(i);
      l(paramView);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("view is not a child, cannot hide ");
    localStringBuilder.append(paramView);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  int m(View paramView)
  {
    int i = this.a.k(paramView);
    if (i == -1) {
      return -1;
    }
    if (this.b.d(i)) {
      return -1;
    }
    return i - this.b.b(i);
  }
  
  boolean n(View paramView)
  {
    return this.c.contains(paramView);
  }
  
  void o()
  {
    this.b.g();
    int i = this.c.size() - 1;
    while (i >= 0)
    {
      this.a.e((View)this.c.get(i));
      this.c.remove(i);
      i -= 1;
    }
    this.a.i();
  }
  
  void p(View paramView)
  {
    int i = this.a.k(paramView);
    if (i < 0) {
      return;
    }
    if (this.b.f(i)) {
      t(paramView);
    }
    this.a.h(i);
  }
  
  void q(int paramInt)
  {
    paramInt = h(paramInt);
    View localView = this.a.a(paramInt);
    if (localView == null) {
      return;
    }
    if (this.b.f(paramInt)) {
      t(localView);
    }
    this.a.h(paramInt);
  }
  
  boolean r(View paramView)
  {
    int i = this.a.k(paramView);
    if (i == -1)
    {
      t(paramView);
      return true;
    }
    if (this.b.d(i))
    {
      this.b.f(i);
      t(paramView);
      this.a.h(i);
      return true;
    }
    return false;
  }
  
  void s(View paramView)
  {
    int i = this.a.k(paramView);
    if (i >= 0)
    {
      if (this.b.d(i))
      {
        this.b.a(i);
        t(paramView);
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("trying to unhide a view that was not hidden");
      localStringBuilder.append(paramView);
      throw new RuntimeException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("view is not a child, cannot hide ");
    localStringBuilder.append(paramView);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.toString());
    localStringBuilder.append(", hidden list:");
    localStringBuilder.append(this.c.size());
    return localStringBuilder.toString();
  }
  
  static class a
  {
    long a = 0L;
    a b;
    
    private void c()
    {
      if (this.b == null) {
        this.b = new a();
      }
    }
    
    void a(int paramInt)
    {
      if (paramInt >= 64)
      {
        a locala = this.b;
        if (locala != null) {
          locala.a(paramInt - 64);
        }
      }
      else
      {
        this.a &= 1L << paramInt;
      }
    }
    
    int b(int paramInt)
    {
      a locala = this.b;
      if (locala == null)
      {
        if (paramInt >= 64) {
          return Long.bitCount(this.a);
        }
        return Long.bitCount(this.a & (1L << paramInt) - 1L);
      }
      if (paramInt < 64) {
        return Long.bitCount(this.a & (1L << paramInt) - 1L);
      }
      return locala.b(paramInt - 64) + Long.bitCount(this.a);
    }
    
    boolean d(int paramInt)
    {
      if (paramInt >= 64)
      {
        c();
        return this.b.d(paramInt - 64);
      }
      return (this.a & 1L << paramInt) != 0L;
    }
    
    void e(int paramInt, boolean paramBoolean)
    {
      if (paramInt >= 64)
      {
        c();
        this.b.e(paramInt - 64, paramBoolean);
        return;
      }
      long l1 = this.a;
      boolean bool;
      if ((0x0 & l1) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      long l2 = (1L << paramInt) - 1L;
      this.a = ((l1 & l2) << 1 | l1 & l2);
      if (paramBoolean) {
        h(paramInt);
      } else {
        a(paramInt);
      }
      if ((bool) || (this.b != null))
      {
        c();
        this.b.e(0, bool);
      }
    }
    
    boolean f(int paramInt)
    {
      if (paramInt >= 64)
      {
        c();
        return this.b.f(paramInt - 64);
      }
      long l1 = 1L << paramInt;
      long l2 = this.a;
      boolean bool;
      if ((l2 & l1) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      l2 &= l1;
      this.a = l2;
      l1 -= 1L;
      this.a = (l2 & l1 | Long.rotateRight(l1 & l2, 1));
      a locala = this.b;
      if (locala != null)
      {
        if (locala.d(0)) {
          h(63);
        }
        this.b.f(0);
      }
      return bool;
    }
    
    void g()
    {
      this.a = 0L;
      a locala = this.b;
      if (locala != null) {
        locala.g();
      }
    }
    
    void h(int paramInt)
    {
      if (paramInt >= 64)
      {
        c();
        this.b.h(paramInt - 64);
        return;
      }
      this.a |= 1L << paramInt;
    }
    
    public String toString()
    {
      if (this.b == null) {
        return Long.toBinaryString(this.a);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.toString());
      localStringBuilder.append("xx");
      localStringBuilder.append(Long.toBinaryString(this.a));
      return localStringBuilder.toString();
    }
  }
  
  static abstract interface b
  {
    public abstract View a(int paramInt);
    
    public abstract void b(View paramView);
    
    public abstract RecyclerView.c0 c(View paramView);
    
    public abstract void d(int paramInt);
    
    public abstract void e(View paramView);
    
    public abstract void f(View paramView, int paramInt);
    
    public abstract int g();
    
    public abstract void h(int paramInt);
    
    public abstract void i();
    
    public abstract void j(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);
    
    public abstract int k(View paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.b
 * JD-Core Version:    0.7.0.1
 */