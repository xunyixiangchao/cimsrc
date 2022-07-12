package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class r
  extends RecyclerView.r
{
  RecyclerView a;
  private Scroller b;
  private final RecyclerView.t c = new a();
  
  private void e()
  {
    this.a.b1(this.c);
    this.a.setOnFlingListener(null);
  }
  
  private void h()
  {
    if (this.a.getOnFlingListener() == null)
    {
      this.a.l(this.c);
      this.a.setOnFlingListener(this);
      return;
    }
    throw new IllegalStateException("An instance of OnFlingListener already set.");
  }
  
  private boolean i(RecyclerView.p paramp, int paramInt1, int paramInt2)
  {
    if (!(paramp instanceof RecyclerView.y.b)) {
      return false;
    }
    RecyclerView.y localy = d(paramp);
    if (localy == null) {
      return false;
    }
    paramInt1 = g(paramp, paramInt1, paramInt2);
    if (paramInt1 == -1) {
      return false;
    }
    localy.p(paramInt1);
    paramp.J1(localy);
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    RecyclerView.p localp = this.a.getLayoutManager();
    boolean bool2 = false;
    if (localp == null) {
      return false;
    }
    if (this.a.getAdapter() == null) {
      return false;
    }
    int i = this.a.getMinFlingVelocity();
    boolean bool1;
    if (Math.abs(paramInt2) <= i)
    {
      bool1 = bool2;
      if (Math.abs(paramInt1) <= i) {}
    }
    else
    {
      bool1 = bool2;
      if (i(localp, paramInt1, paramInt2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b(RecyclerView paramRecyclerView)
  {
    RecyclerView localRecyclerView = this.a;
    if (localRecyclerView == paramRecyclerView) {
      return;
    }
    if (localRecyclerView != null) {
      e();
    }
    this.a = paramRecyclerView;
    if (paramRecyclerView != null)
    {
      h();
      this.b = new Scroller(this.a.getContext(), new DecelerateInterpolator());
      j();
    }
  }
  
  public abstract int[] c(RecyclerView.p paramp, View paramView);
  
  protected abstract RecyclerView.y d(RecyclerView.p paramp);
  
  public abstract View f(RecyclerView.p paramp);
  
  public abstract int g(RecyclerView.p paramp, int paramInt1, int paramInt2);
  
  void j()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((RecyclerView)localObject).getLayoutManager();
    if (localObject == null) {
      return;
    }
    View localView = f((RecyclerView.p)localObject);
    if (localView == null) {
      return;
    }
    localObject = c((RecyclerView.p)localObject, localView);
    if ((localObject[0] != 0) || (localObject[1] != 0)) {
      this.a.o1(localObject[0], localObject[1]);
    }
  }
  
  class a
    extends RecyclerView.t
  {
    boolean a = false;
    
    a() {}
    
    public void a(RecyclerView paramRecyclerView, int paramInt)
    {
      super.a(paramRecyclerView, paramInt);
      if ((paramInt == 0) && (this.a))
      {
        this.a = false;
        r.this.j();
      }
    }
    
    public void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        this.a = true;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.r
 * JD-Core Version:    0.7.0.1
 */