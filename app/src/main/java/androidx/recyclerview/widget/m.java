package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public abstract class m
{
  protected final RecyclerView.p a;
  private int b = -2147483648;
  final Rect c = new Rect();
  
  private m(RecyclerView.p paramp)
  {
    this.a = paramp;
  }
  
  public static m a(RecyclerView.p paramp)
  {
    return new a();
  }
  
  public static m b(RecyclerView.p paramp, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return c(paramp);
      }
      throw new IllegalArgumentException("invalid orientation");
    }
    return a(paramp);
  }
  
  public static m c(RecyclerView.p paramp)
  {
    return new b();
  }
  
  public abstract int d(View paramView);
  
  public abstract int e(View paramView);
  
  public abstract int f(View paramView);
  
  public abstract int g(View paramView);
  
  public abstract int h();
  
  public abstract int i();
  
  public abstract int j();
  
  public abstract int k();
  
  public abstract int l();
  
  public abstract int m();
  
  public abstract int n();
  
  public int o()
  {
    if (-2147483648 == this.b) {
      return 0;
    }
    return n() - this.b;
  }
  
  public abstract int p(View paramView);
  
  public abstract int q(View paramView);
  
  public abstract void r(int paramInt);
  
  public void s()
  {
    this.b = n();
  }
  
  class a
    extends m
  {
    a()
    {
      super(null);
    }
    
    public int d(View paramView)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return this.a.T(paramView) + localLayoutParams.rightMargin;
    }
    
    public int e(View paramView)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return this.a.S(paramView) + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
    }
    
    public int f(View paramView)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return this.a.R(paramView) + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    }
    
    public int g(View paramView)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return this.a.Q(paramView) - localLayoutParams.leftMargin;
    }
    
    public int h()
    {
      return this.a.o0();
    }
    
    public int i()
    {
      return this.a.o0() - this.a.f0();
    }
    
    public int j()
    {
      return this.a.f0();
    }
    
    public int k()
    {
      return this.a.p0();
    }
    
    public int l()
    {
      return this.a.X();
    }
    
    public int m()
    {
      return this.a.e0();
    }
    
    public int n()
    {
      return this.a.o0() - this.a.e0() - this.a.f0();
    }
    
    public int p(View paramView)
    {
      this.a.n0(paramView, true, this.c);
      return this.c.right;
    }
    
    public int q(View paramView)
    {
      this.a.n0(paramView, true, this.c);
      return this.c.left;
    }
    
    public void r(int paramInt)
    {
      this.a.C0(paramInt);
    }
  }
  
  class b
    extends m
  {
    b()
    {
      super(null);
    }
    
    public int d(View paramView)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return this.a.O(paramView) + localLayoutParams.bottomMargin;
    }
    
    public int e(View paramView)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return this.a.R(paramView) + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    }
    
    public int f(View paramView)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return this.a.S(paramView) + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
    }
    
    public int g(View paramView)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return this.a.U(paramView) - localLayoutParams.topMargin;
    }
    
    public int h()
    {
      return this.a.W();
    }
    
    public int i()
    {
      return this.a.W() - this.a.d0();
    }
    
    public int j()
    {
      return this.a.d0();
    }
    
    public int k()
    {
      return this.a.X();
    }
    
    public int l()
    {
      return this.a.p0();
    }
    
    public int m()
    {
      return this.a.g0();
    }
    
    public int n()
    {
      return this.a.W() - this.a.g0() - this.a.d0();
    }
    
    public int p(View paramView)
    {
      this.a.n0(paramView, true, this.c);
      return this.c.bottom;
    }
    
    public int q(View paramView)
    {
      this.a.n0(paramView, true, this.c);
      return this.c.top;
    }
    
    public void r(int paramInt)
    {
      this.a.D0(paramInt);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.m
 * JD-Core Version:    0.7.0.1
 */