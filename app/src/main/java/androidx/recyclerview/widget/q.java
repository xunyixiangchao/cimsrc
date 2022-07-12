package androidx.recyclerview.widget;

import android.view.View;

public abstract class q
  extends RecyclerView.m
{
  boolean g = true;
  
  public final void A(RecyclerView.c0 paramc0)
  {
    I(paramc0);
    h(paramc0);
  }
  
  public final void B(RecyclerView.c0 paramc0)
  {
    J(paramc0);
  }
  
  public final void C(RecyclerView.c0 paramc0, boolean paramBoolean)
  {
    K(paramc0, paramBoolean);
    h(paramc0);
  }
  
  public final void D(RecyclerView.c0 paramc0, boolean paramBoolean)
  {
    L(paramc0, paramBoolean);
  }
  
  public final void E(RecyclerView.c0 paramc0)
  {
    M(paramc0);
    h(paramc0);
  }
  
  public final void F(RecyclerView.c0 paramc0)
  {
    N(paramc0);
  }
  
  public final void G(RecyclerView.c0 paramc0)
  {
    O(paramc0);
    h(paramc0);
  }
  
  public final void H(RecyclerView.c0 paramc0)
  {
    P(paramc0);
  }
  
  public void I(RecyclerView.c0 paramc0) {}
  
  public void J(RecyclerView.c0 paramc0) {}
  
  public void K(RecyclerView.c0 paramc0, boolean paramBoolean) {}
  
  public void L(RecyclerView.c0 paramc0, boolean paramBoolean) {}
  
  public void M(RecyclerView.c0 paramc0) {}
  
  public void N(RecyclerView.c0 paramc0) {}
  
  public void O(RecyclerView.c0 paramc0) {}
  
  public void P(RecyclerView.c0 paramc0) {}
  
  public boolean a(RecyclerView.c0 paramc0, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2)
  {
    if (paramc1 != null)
    {
      int i = paramc1.a;
      int j = paramc2.a;
      if ((i != j) || (paramc1.b != paramc2.b)) {
        return y(paramc0, i, paramc1.b, j, paramc2.b);
      }
    }
    return w(paramc0);
  }
  
  public boolean b(RecyclerView.c0 paramc01, RecyclerView.c0 paramc02, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2)
  {
    int k = paramc1.a;
    int m = paramc1.b;
    int i;
    int j;
    if (paramc02.J())
    {
      i = paramc1.a;
      j = paramc1.b;
    }
    else
    {
      i = paramc2.a;
      j = paramc2.b;
    }
    return x(paramc01, paramc02, k, m, i, j);
  }
  
  public boolean c(RecyclerView.c0 paramc0, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2)
  {
    int k = paramc1.a;
    int m = paramc1.b;
    paramc1 = paramc0.a;
    int i;
    if (paramc2 == null) {
      i = paramc1.getLeft();
    } else {
      i = paramc2.a;
    }
    int j;
    if (paramc2 == null) {
      j = paramc1.getTop();
    } else {
      j = paramc2.b;
    }
    if ((!paramc0.v()) && ((k != i) || (m != j)))
    {
      paramc1.layout(i, j, paramc1.getWidth() + i, paramc1.getHeight() + j);
      return y(paramc0, k, m, i, j);
    }
    return z(paramc0);
  }
  
  public boolean d(RecyclerView.c0 paramc0, RecyclerView.m.c paramc1, RecyclerView.m.c paramc2)
  {
    int i = paramc1.a;
    int j = paramc2.a;
    if ((i == j) && (paramc1.b == paramc2.b))
    {
      E(paramc0);
      return false;
    }
    return y(paramc0, i, paramc1.b, j, paramc2.b);
  }
  
  public boolean f(RecyclerView.c0 paramc0)
  {
    return (!this.g) || (paramc0.t());
  }
  
  public abstract boolean w(RecyclerView.c0 paramc0);
  
  public abstract boolean x(RecyclerView.c0 paramc01, RecyclerView.c0 paramc02, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean y(RecyclerView.c0 paramc0, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean z(RecyclerView.c0 paramc0);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.q
 * JD-Core Version:    0.7.0.1
 */