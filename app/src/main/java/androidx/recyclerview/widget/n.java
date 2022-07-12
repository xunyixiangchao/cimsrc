package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

public class n
  extends r
{
  private m d;
  private m e;
  
  private int k(View paramView, m paramm)
  {
    return paramm.g(paramView) + paramm.e(paramView) / 2 - (paramm.m() + paramm.n() / 2);
  }
  
  private View l(RecyclerView.p paramp, m paramm)
  {
    int n = paramp.J();
    Object localObject = null;
    if (n == 0) {
      return null;
    }
    int i1 = paramm.m();
    int i2 = paramm.n() / 2;
    int j = 2147483647;
    int i = 0;
    while (i < n)
    {
      View localView = paramp.I(i);
      int m = Math.abs(paramm.g(localView) + paramm.e(localView) / 2 - (i1 + i2));
      int k = j;
      if (m < j)
      {
        localObject = localView;
        k = m;
      }
      i += 1;
      j = k;
    }
    return localObject;
  }
  
  private m m(RecyclerView.p paramp)
  {
    m localm = this.e;
    if ((localm == null) || (localm.a != paramp)) {
      this.e = m.a(paramp);
    }
    return this.e;
  }
  
  private m n(RecyclerView.p paramp)
  {
    if (paramp.l()) {
      return o(paramp);
    }
    if (paramp.k()) {
      return m(paramp);
    }
    return null;
  }
  
  private m o(RecyclerView.p paramp)
  {
    m localm = this.d;
    if ((localm == null) || (localm.a != paramp)) {
      this.d = m.c(paramp);
    }
    return this.d;
  }
  
  private boolean p(RecyclerView.p paramp, int paramInt1, int paramInt2)
  {
    if (paramp.k()) {
      return paramInt1 > 0;
    }
    return paramInt2 > 0;
  }
  
  private boolean q(RecyclerView.p paramp)
  {
    int i = paramp.Y();
    boolean bool3 = paramp instanceof RecyclerView.y.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramp = ((RecyclerView.y.b)paramp).a(i - 1);
      bool1 = bool2;
      if (paramp != null) {
        if (paramp.x >= 0.0F)
        {
          bool1 = bool2;
          if (paramp.y >= 0.0F) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int[] c(RecyclerView.p paramp, View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramp.k()) {
      arrayOfInt[0] = k(paramView, m(paramp));
    } else {
      arrayOfInt[0] = 0;
    }
    if (paramp.l())
    {
      arrayOfInt[1] = k(paramView, o(paramp));
      return arrayOfInt;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  protected RecyclerView.y d(RecyclerView.p paramp)
  {
    if (!(paramp instanceof RecyclerView.y.b)) {
      return null;
    }
    return new a(this.a.getContext());
  }
  
  public View f(RecyclerView.p paramp)
  {
    if (paramp.l()) {}
    for (m localm = o(paramp);; localm = m(paramp))
    {
      return l(paramp, localm);
      if (!paramp.k()) {
        break;
      }
    }
    return null;
  }
  
  public int g(RecyclerView.p paramp, int paramInt1, int paramInt2)
  {
    int i2 = paramp.Y();
    if (i2 == 0) {
      return -1;
    }
    m localm = n(paramp);
    if (localm == null) {
      return -1;
    }
    int j = -2147483648;
    int m = 2147483647;
    int i3 = paramp.J();
    int k = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    while (k < i3)
    {
      View localView = paramp.I(k);
      int i1;
      Object localObject4;
      if (localView == null)
      {
        i1 = m;
        localObject4 = localObject2;
      }
      else
      {
        int n = k(localView, localm);
        int i = j;
        Object localObject3 = localObject1;
        if (n <= 0)
        {
          i = j;
          localObject3 = localObject1;
          if (n > j)
          {
            localObject3 = localView;
            i = n;
          }
        }
        j = i;
        i1 = m;
        localObject4 = localObject2;
        localObject1 = localObject3;
        if (n >= 0)
        {
          j = i;
          i1 = m;
          localObject4 = localObject2;
          localObject1 = localObject3;
          if (n < m)
          {
            localObject1 = localObject3;
            localObject4 = localView;
            i1 = n;
            j = i;
          }
        }
      }
      k += 1;
      m = i1;
      localObject2 = localObject4;
    }
    boolean bool = p(paramp, paramInt1, paramInt2);
    if ((bool) && (localObject2 != null)) {
      return paramp.h0(localObject2);
    }
    if ((!bool) && (localObject1 != null)) {
      return paramp.h0(localObject1);
    }
    if (bool) {
      localObject2 = localObject1;
    }
    if (localObject2 == null) {
      return -1;
    }
    paramInt2 = paramp.h0(localObject2);
    if (q(paramp) == bool) {
      paramInt1 = -1;
    } else {
      paramInt1 = 1;
    }
    paramInt1 = paramInt2 + paramInt1;
    if (paramInt1 >= 0)
    {
      if (paramInt1 >= i2) {
        return -1;
      }
      return paramInt1;
    }
    return -1;
  }
  
  class a
    extends j
  {
    a(Context paramContext)
    {
      super();
    }
    
    protected void o(View paramView, RecyclerView.z paramz, RecyclerView.y.a parama)
    {
      paramz = n.this;
      paramView = paramz.c(paramz.a.getLayoutManager(), paramView);
      int i = paramView[0];
      int j = paramView[1];
      int k = w(Math.max(Math.abs(i), Math.abs(j)));
      if (k > 0) {
        parama.d(i, j, k, this.j);
      }
    }
    
    protected float v(DisplayMetrics paramDisplayMetrics)
    {
      return 100.0F / paramDisplayMetrics.densityDpi;
    }
    
    protected int x(int paramInt)
    {
      return Math.min(100, super.x(paramInt));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.n
 * JD-Core Version:    0.7.0.1
 */