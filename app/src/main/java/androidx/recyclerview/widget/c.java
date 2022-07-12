package androidx.recyclerview.widget;

import android.view.ViewGroup;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class c
  extends RecyclerView.h<RecyclerView.c0>
{
  private final d d;
  
  public c(a parama, List<? extends RecyclerView.h<? extends RecyclerView.c0>> paramList)
  {
    this.d = new d(this, parama);
    parama = paramList.iterator();
    while (parama.hasNext()) {
      I((RecyclerView.h)parama.next());
    }
    super.F(this.d.r());
  }
  
  @SafeVarargs
  public c(a parama, RecyclerView.h<? extends RecyclerView.c0>... paramVarArgs)
  {
    this(parama, Arrays.asList(paramVarArgs));
  }
  
  @SafeVarargs
  public c(RecyclerView.h<? extends RecyclerView.c0>... paramVarArgs)
  {
    this(a.c, paramVarArgs);
  }
  
  public boolean A(RecyclerView.c0 paramc0)
  {
    return this.d.y(paramc0);
  }
  
  public void B(RecyclerView.c0 paramc0)
  {
    this.d.z(paramc0);
  }
  
  public void C(RecyclerView.c0 paramc0)
  {
    this.d.A(paramc0);
  }
  
  public void D(RecyclerView.c0 paramc0)
  {
    this.d.B(paramc0);
  }
  
  public boolean I(RecyclerView.h<? extends RecyclerView.c0> paramh)
  {
    return this.d.h(paramh);
  }
  
  void J(RecyclerView.h.a parama)
  {
    super.G(parama);
  }
  
  public int d()
  {
    return this.d.p();
  }
  
  public long e(int paramInt)
  {
    return this.d.n(paramInt);
  }
  
  public int f(int paramInt)
  {
    return this.d.o(paramInt);
  }
  
  public void v(RecyclerView paramRecyclerView)
  {
    this.d.u(paramRecyclerView);
  }
  
  public void w(RecyclerView.c0 paramc0, int paramInt)
  {
    this.d.v(paramc0, paramInt);
  }
  
  public RecyclerView.c0 y(ViewGroup paramViewGroup, int paramInt)
  {
    return this.d.w(paramViewGroup, paramInt);
  }
  
  public void z(RecyclerView paramRecyclerView)
  {
    this.d.x(paramRecyclerView);
  }
  
  public static final class a
  {
    public static final a c = new a(true, a.a);
    public final boolean a;
    public final a b;
    
    a(boolean paramBoolean, a parama)
    {
      this.a = paramBoolean;
      this.b = parama;
    }
    
    public static enum a
    {
      static
      {
        a locala1 = new a("NO_STABLE_IDS", 0);
        a = locala1;
        a locala2 = new a("ISOLATED_STABLE_IDS", 1);
        b = locala2;
        a locala3 = new a("SHARED_STABLE_IDS", 2);
        c = locala3;
        d = new a[] { locala1, locala2, locala3 };
      }
      
      private a() {}
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.c
 * JD-Core Version:    0.7.0.1
 */