package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.t;
import java.util.Locale;

final class e
  extends RecyclerView.t
{
  private ViewPager2.i a;
  private final ViewPager2 b;
  private final RecyclerView c;
  private final LinearLayoutManager d;
  private int e;
  private int f;
  private a g;
  private int h;
  private int i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  
  e(ViewPager2 paramViewPager2)
  {
    this.b = paramViewPager2;
    paramViewPager2 = paramViewPager2.j;
    this.c = paramViewPager2;
    this.d = ((LinearLayoutManager)paramViewPager2.getLayoutManager());
    this.g = new a();
    n();
  }
  
  private void c(int paramInt1, float paramFloat, int paramInt2)
  {
    ViewPager2.i locali = this.a;
    if (locali != null) {
      locali.b(paramInt1, paramFloat, paramInt2);
    }
  }
  
  private void d(int paramInt)
  {
    ViewPager2.i locali = this.a;
    if (locali != null) {
      locali.c(paramInt);
    }
  }
  
  private void e(int paramInt)
  {
    if ((this.e == 3) && (this.f == 0)) {
      return;
    }
    if (this.f == paramInt) {
      return;
    }
    this.f = paramInt;
    ViewPager2.i locali = this.a;
    if (locali != null) {
      locali.a(paramInt);
    }
  }
  
  private int f()
  {
    return this.d.Y1();
  }
  
  private boolean k()
  {
    int n = this.e;
    boolean bool = true;
    if (n != 1)
    {
      if (n == 4) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void n()
  {
    this.e = 0;
    this.f = 0;
    this.g.a();
    this.h = -1;
    this.i = -1;
    this.j = false;
    this.k = false;
    this.m = false;
    this.l = false;
  }
  
  private void p(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (paramBoolean) {
      n = 4;
    } else {
      n = 1;
    }
    this.e = n;
    int n = this.i;
    if (n != -1)
    {
      this.h = n;
      this.i = -1;
    }
    else if (this.h == -1)
    {
      this.h = f();
    }
    e(1);
  }
  
  private void q()
  {
    a locala = this.g;
    int n = this.d.Y1();
    locala.a = n;
    if (n == -1)
    {
      locala.a();
      return;
    }
    View localView = this.d.C(n);
    if (localView == null)
    {
      locala.a();
      return;
    }
    int i7 = this.d.a0(localView);
    int i6 = this.d.j0(localView);
    int i5 = this.d.m0(localView);
    int i4 = this.d.H(localView);
    Object localObject = localView.getLayoutParams();
    int i2 = i7;
    int i1 = i6;
    n = i5;
    int i3 = i4;
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      i2 = i7 + ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      i1 = i6 + ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
      n = i5 + ((ViewGroup.MarginLayoutParams)localObject).topMargin;
      i3 = i4 + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    }
    i4 = localView.getHeight() + n + i3;
    i5 = localView.getWidth();
    if (this.d.l2() == 0) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    if (i3 != 0)
    {
      i3 = localView.getLeft() - i2 - this.c.getPaddingLeft();
      n = i3;
      if (this.b.d()) {
        n = -i3;
      }
      i2 = i5 + i2 + i1;
      i1 = n;
      n = i2;
    }
    else
    {
      i1 = localView.getTop() - n - this.c.getPaddingTop();
      n = i4;
    }
    i1 = -i1;
    locala.c = i1;
    if (i1 < 0)
    {
      if (new a(this.d).d()) {
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
      }
      throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[] { Integer.valueOf(locala.c) }));
    }
    float f1;
    if (n == 0) {
      f1 = 0.0F;
    } else {
      f1 = i1 / n;
    }
    locala.b = f1;
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt)
  {
    int n = this.e;
    int i1 = 1;
    if (((n != 1) || (this.f != 1)) && (paramInt == 1))
    {
      p(false);
      return;
    }
    if ((k()) && (paramInt == 2))
    {
      if (this.k)
      {
        e(2);
        this.j = true;
      }
      return;
    }
    if ((k()) && (paramInt == 0))
    {
      q();
      int i2;
      if (!this.k)
      {
        i2 = this.g.a;
        n = i1;
        if (i2 != -1)
        {
          c(i2, 0.0F, 0);
          n = i1;
        }
      }
      else
      {
        paramRecyclerView = this.g;
        if (paramRecyclerView.c == 0)
        {
          i2 = this.h;
          int i3 = paramRecyclerView.a;
          n = i1;
          if (i2 != i3)
          {
            d(i3);
            n = i1;
          }
        }
        else
        {
          n = 0;
        }
      }
      if (n != 0)
      {
        e(0);
        n();
      }
    }
    if ((this.e == 2) && (paramInt == 0) && (this.l))
    {
      q();
      paramRecyclerView = this.g;
      if (paramRecyclerView.c == 0)
      {
        paramInt = this.i;
        n = paramRecyclerView.a;
        if (paramInt != n)
        {
          paramInt = n;
          if (n == -1) {
            paramInt = 0;
          }
          d(paramInt);
        }
        e(0);
        n();
      }
    }
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.k = true;
    q();
    if (this.j)
    {
      this.j = false;
      if (paramInt2 <= 0) {
        if (paramInt2 == 0)
        {
          int n;
          if (paramInt1 < 0) {
            n = 1;
          } else {
            n = 0;
          }
          if (n == this.b.d()) {}
        }
        else
        {
          paramInt1 = 0;
          break label64;
        }
      }
      paramInt1 = 1;
      label64:
      if (paramInt1 != 0)
      {
        paramRecyclerView = this.g;
        if (paramRecyclerView.c != 0)
        {
          paramInt1 = paramRecyclerView.a + 1;
          break label98;
        }
      }
      paramInt1 = this.g.a;
      label98:
      this.i = paramInt1;
      if (this.h == paramInt1) {
        break label143;
      }
    }
    else
    {
      if (this.e != 0) {
        break label143;
      }
      paramInt2 = this.g.a;
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = 0;
      }
    }
    d(paramInt1);
    label143:
    paramRecyclerView = this.g;
    paramInt2 = paramRecyclerView.a;
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = 0;
    }
    c(paramInt1, paramRecyclerView.b, paramRecyclerView.c);
    paramRecyclerView = this.g;
    paramInt1 = paramRecyclerView.a;
    paramInt2 = this.i;
    if (((paramInt1 == paramInt2) || (paramInt2 == -1)) && (paramRecyclerView.c == 0) && (this.f != 1))
    {
      e(0);
      n();
    }
  }
  
  double g()
  {
    q();
    a locala = this.g;
    return locala.a + locala.b;
  }
  
  int h()
  {
    return this.f;
  }
  
  boolean i()
  {
    return this.m;
  }
  
  boolean j()
  {
    return this.f == 0;
  }
  
  void l()
  {
    this.l = true;
  }
  
  void m(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      n = 2;
    } else {
      n = 3;
    }
    this.e = n;
    int n = 0;
    this.m = false;
    if (this.i != paramInt) {
      n = 1;
    }
    this.i = paramInt;
    e(2);
    if (n != 0) {
      d(paramInt);
    }
  }
  
  void o(ViewPager2.i parami)
  {
    this.a = parami;
  }
  
  private static final class a
  {
    int a;
    float b;
    int c;
    
    void a()
    {
      this.a = -1;
      this.b = 0.0F;
      this.c = 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.viewpager2.widget.e
 * JD-Core Version:    0.7.0.1
 */