package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;
import y0.d;
import y0.d.c;

public class GridLayoutManager
  extends LinearLayoutManager
{
  boolean I = false;
  int J = -1;
  int[] K;
  View[] L;
  final SparseIntArray M = new SparseIntArray();
  final SparseIntArray N = new SparseIntArray();
  b O = new a();
  final Rect P = new Rect();
  private boolean Q;
  
  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt2, paramBoolean);
    c3(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c3(RecyclerView.p.i0(paramContext, paramAttributeSet, paramInt1, paramInt2).b);
  }
  
  private void L2(RecyclerView.v paramv, RecyclerView.z paramz, int paramInt, boolean paramBoolean)
  {
    int k = 0;
    int i = -1;
    int j;
    int m;
    if (paramBoolean)
    {
      j = 1;
      m = 0;
      i = paramInt;
      paramInt = m;
    }
    else
    {
      paramInt -= 1;
      j = -1;
    }
    while (paramInt != i)
    {
      View localView = this.L[paramInt];
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      m = Y2(paramv, paramz, h0(localView));
      localLayoutParams.f = m;
      localLayoutParams.e = k;
      k += m;
      paramInt += j;
    }
  }
  
  private void M2()
  {
    int j = J();
    int i = 0;
    while (i < j)
    {
      LayoutParams localLayoutParams = (LayoutParams)I(i).getLayoutParams();
      int k = localLayoutParams.a();
      this.M.put(k, localLayoutParams.f());
      this.N.put(k, localLayoutParams.e());
      i += 1;
    }
  }
  
  private void N2(int paramInt)
  {
    this.K = O2(this.K, this.J, paramInt);
  }
  
  static int[] O2(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int j = 1;
    int[] arrayOfInt;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length == paramInt1 + 1))
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt[(paramArrayOfInt.length - 1)] == paramInt2) {}
    }
    else
    {
      arrayOfInt = new int[paramInt1 + 1];
    }
    int k = 0;
    arrayOfInt[0] = 0;
    int m = paramInt2 / paramInt1;
    int n = paramInt2 % paramInt1;
    int i = 0;
    paramInt2 = k;
    while (j <= paramInt1)
    {
      paramInt2 += n;
      if ((paramInt2 > 0) && (paramInt1 - paramInt2 < n))
      {
        k = m + 1;
        paramInt2 -= paramInt1;
      }
      else
      {
        k = m;
      }
      i += k;
      arrayOfInt[j] = i;
      j += 1;
    }
    return arrayOfInt;
  }
  
  private void P2()
  {
    this.M.clear();
    this.N.clear();
  }
  
  private int Q2(RecyclerView.z paramz)
  {
    if (J() != 0)
    {
      if (paramz.b() == 0) {
        return 0;
      }
      T1();
      boolean bool = o2();
      View localView1 = X1(bool ^ true, true);
      View localView2 = W1(bool ^ true, true);
      if (localView1 != null)
      {
        if (localView2 == null) {
          return 0;
        }
        int j = this.O.b(h0(localView1), this.J);
        int k = this.O.b(h0(localView2), this.J);
        int i = Math.min(j, k);
        j = Math.max(j, k);
        k = this.O.b(paramz.b() - 1, this.J);
        if (this.x) {
          i = Math.max(0, k + 1 - j - 1);
        } else {
          i = Math.max(0, i);
        }
        if (!bool) {
          return i;
        }
        j = Math.abs(this.u.d(localView2) - this.u.g(localView1));
        k = this.O.b(h0(localView1), this.J);
        int m = this.O.b(h0(localView2), this.J);
        float f = j / (m - k + 1);
        return Math.round(i * f + (this.u.m() - this.u.g(localView1)));
      }
    }
    return 0;
  }
  
  private int R2(RecyclerView.z paramz)
  {
    if (J() != 0)
    {
      if (paramz.b() == 0) {
        return 0;
      }
      T1();
      View localView1 = X1(o2() ^ true, true);
      View localView2 = W1(o2() ^ true, true);
      if (localView1 != null)
      {
        if (localView2 == null) {
          return 0;
        }
        if (!o2()) {
          return this.O.b(paramz.b() - 1, this.J) + 1;
        }
        int i = this.u.d(localView2);
        int j = this.u.g(localView1);
        int k = this.O.b(h0(localView1), this.J);
        int m = this.O.b(h0(localView2), this.J);
        int n = this.O.b(paramz.b() - 1, this.J);
        return (int)((i - j) / (m - k + 1) * (n + 1));
      }
    }
    return 0;
  }
  
  private void S2(RecyclerView.v paramv, RecyclerView.z paramz, LinearLayoutManager.a parama, int paramInt)
  {
    if (paramInt == 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i = X2(paramv, paramz, parama.b);
    if (paramInt != 0) {
      while (i > 0)
      {
        paramInt = parama.b;
        if (paramInt <= 0) {
          break;
        }
        paramInt -= 1;
        parama.b = paramInt;
        i = X2(paramv, paramz, paramInt);
      }
    }
    int m = paramz.b();
    paramInt = parama.b;
    while (paramInt < m - 1)
    {
      int k = paramInt + 1;
      int j = X2(paramv, paramz, k);
      if (j <= i) {
        break;
      }
      paramInt = k;
      i = j;
    }
    parama.b = paramInt;
  }
  
  private void T2()
  {
    View[] arrayOfView = this.L;
    if ((arrayOfView == null) || (arrayOfView.length != this.J)) {
      this.L = new View[this.J];
    }
  }
  
  private int W2(RecyclerView.v paramv, RecyclerView.z paramz, int paramInt)
  {
    if (!paramz.e()) {
      return this.O.b(paramInt, this.J);
    }
    int i = paramv.f(paramInt);
    if (i == -1)
    {
      paramv = new StringBuilder();
      paramv.append("Cannot find span size for pre layout position. ");
      paramv.append(paramInt);
      Log.w("GridLayoutManager", paramv.toString());
      return 0;
    }
    return this.O.b(i, this.J);
  }
  
  private int X2(RecyclerView.v paramv, RecyclerView.z paramz, int paramInt)
  {
    if (!paramz.e()) {
      return this.O.c(paramInt, this.J);
    }
    int i = this.N.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = paramv.f(paramInt);
    if (i == -1)
    {
      paramv = new StringBuilder();
      paramv.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      paramv.append(paramInt);
      Log.w("GridLayoutManager", paramv.toString());
      return 0;
    }
    return this.O.c(i, this.J);
  }
  
  private int Y2(RecyclerView.v paramv, RecyclerView.z paramz, int paramInt)
  {
    if (!paramz.e()) {
      return this.O.f(paramInt);
    }
    int i = this.M.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = paramv.f(paramInt);
    if (i == -1)
    {
      paramv = new StringBuilder();
      paramv.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      paramv.append(paramInt);
      Log.w("GridLayoutManager", paramv.toString());
      return 1;
    }
    return this.O.f(i);
  }
  
  private void Z2(float paramFloat, int paramInt)
  {
    N2(Math.max(Math.round(paramFloat * this.J), paramInt));
  }
  
  private void a3(View paramView, int paramInt, boolean paramBoolean)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.b;
    int j = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int i = localRect.left + localRect.right + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
    int k = U2(localLayoutParams.e, localLayoutParams.f);
    if (this.s == 1)
    {
      i = RecyclerView.p.K(k, paramInt, i, localLayoutParams.width, false);
      paramInt = RecyclerView.p.K(this.u.n(), X(), j, localLayoutParams.height, true);
    }
    else
    {
      paramInt = RecyclerView.p.K(k, paramInt, j, localLayoutParams.height, false);
      i = RecyclerView.p.K(this.u.n(), p0(), i, localLayoutParams.width, true);
    }
    b3(paramView, i, paramInt, paramBoolean);
  }
  
  private void b3(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {
      paramBoolean = H1(paramView, paramInt1, paramInt2, localLayoutParams);
    } else {
      paramBoolean = F1(paramView, paramInt1, paramInt2, localLayoutParams);
    }
    if (paramBoolean) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private void d3()
  {
    int i;
    int j;
    if (l2() == 1)
    {
      i = o0() - f0();
      j = e0();
    }
    else
    {
      i = W() - d0();
      j = g0();
    }
    N2(i - j);
  }
  
  public void C1(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.K == null) {
      super.C1(paramRect, paramInt1, paramInt2);
    }
    int i = e0() + f0();
    int j = g0() + d0();
    if (this.s == 1)
    {
      paramInt2 = RecyclerView.p.n(paramInt2, paramRect.height() + j, b0());
      paramRect = this.K;
      i = RecyclerView.p.n(paramInt1, paramRect[(paramRect.length - 1)] + i, c0());
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
    else
    {
      paramInt1 = RecyclerView.p.n(paramInt1, paramRect.width() + i, c0());
      paramRect = this.K;
      i = RecyclerView.p.n(paramInt2, paramRect[(paramRect.length - 1)] + j, b0());
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    B1(paramInt2, paramInt1);
  }
  
  public void C2(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      super.C2(false);
      return;
    }
    throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
  }
  
  public RecyclerView.LayoutParams D()
  {
    if (this.s == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams E(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams F(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public View J0(View paramView, int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
  {
    View localView = B(paramView);
    Object localObject1 = null;
    if (localView == null) {
      return null;
    }
    Object localObject2 = (LayoutParams)localView.getLayoutParams();
    int i6 = ((LayoutParams)localObject2).e;
    int i7 = ((LayoutParams)localObject2).f + i6;
    if (super.J0(paramView, paramInt, paramv, paramz) == null) {
      return null;
    }
    int i12;
    if (R1(paramInt) == 1) {
      i12 = 1;
    } else {
      i12 = 0;
    }
    if (i12 != this.x) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int m;
    if (paramInt != 0)
    {
      paramInt = J() - 1;
      i = -1;
      m = i;
    }
    else
    {
      i = J();
      m = 1;
      paramInt = 0;
    }
    int n;
    if ((this.s == 1) && (n2())) {
      n = 1;
    } else {
      n = 0;
    }
    int i8 = W2(paramv, paramz, paramInt);
    int i3 = -1;
    int j = i3;
    int k = 0;
    int i1 = 0;
    int i2 = paramInt;
    paramView = null;
    paramInt = i1;
    i1 = i;
    int i = k;
    while (i2 != i1)
    {
      k = W2(paramv, paramz, i2);
      localObject2 = I(i2);
      if (localObject2 == localView) {
        break;
      }
      if ((((View)localObject2).hasFocusable()) && (k != i8))
      {
        if (localObject1 != null) {
          break;
        }
      }
      else
      {
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
        int i9 = localLayoutParams.e;
        int i10 = localLayoutParams.f + i9;
        if ((((View)localObject2).hasFocusable()) && (i9 == i6) && (i10 == i7)) {
          return localObject2;
        }
        if (((((View)localObject2).hasFocusable()) && (localObject1 == null)) || ((!((View)localObject2).hasFocusable()) && (paramView == null))) {}
        for (;;)
        {
          k = 1;
          break label479;
          k = Math.max(i9, i6);
          int i11 = Math.min(i10, i7) - k;
          if (((View)localObject2).hasFocusable())
          {
            if (i11 <= i) {
              while (i11 == i)
              {
                if (i9 > i3) {
                  k = 1;
                } else {
                  k = 0;
                }
                if (n != k) {
                  break;
                }
              }
            }
          }
          else
          {
            if (localObject1 != null) {
              break;
            }
            int i5 = 1;
            k = 1;
            if (!y0((View)localObject2, false, true)) {
              break;
            }
            int i4 = paramInt;
            if (i11 > i4)
            {
              k = i5;
              break label479;
            }
            if (i11 != i4) {
              break;
            }
            if (i9 <= j) {
              k = 0;
            }
            if (n != k) {
              break;
            }
          }
        }
        k = 0;
        label479:
        if (k != 0) {
          if (((View)localObject2).hasFocusable())
          {
            i3 = localLayoutParams.e;
            i = Math.min(i10, i7);
            k = Math.max(i9, i6);
            localObject1 = localObject2;
            i -= k;
          }
          else
          {
            j = localLayoutParams.e;
            paramInt = Math.min(i10, i7) - Math.max(i9, i6);
            paramView = (View)localObject2;
          }
        }
      }
      i2 += m;
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return paramView;
  }
  
  public boolean L1()
  {
    return (this.D == null) && (!this.I);
  }
  
  public int N(RecyclerView.v paramv, RecyclerView.z paramz)
  {
    if (this.s == 1) {
      return this.J;
    }
    if (paramz.b() < 1) {
      return 0;
    }
    return W2(paramv, paramz, paramz.b() - 1) + 1;
  }
  
  void N1(RecyclerView.z paramz, LinearLayoutManager.c paramc, RecyclerView.p.c paramc1)
  {
    int j = this.J;
    int i = 0;
    while ((i < this.J) && (paramc.c(paramz)) && (j > 0))
    {
      int k = paramc.d;
      paramc1.a(k, Math.max(0, paramc.g));
      j -= this.O.f(k);
      paramc.d += paramc.e;
      i += 1;
    }
  }
  
  public void P0(RecyclerView.v paramv, RecyclerView.z paramz, View paramView, d paramd)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.O0(paramView, paramd);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = W2(paramv, paramz, paramView.a());
    int j;
    int m;
    int k;
    if (this.s == 0)
    {
      int n = paramView.e();
      j = paramView.f();
      m = 1;
      k = i;
      i = n;
    }
    else
    {
      j = 1;
      k = paramView.e();
      m = paramView.f();
    }
    paramd.f0(d.c.a(i, j, k, m, false, false));
  }
  
  public void R0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.O.h();
    this.O.g();
  }
  
  public void S0(RecyclerView paramRecyclerView)
  {
    this.O.h();
    this.O.g();
  }
  
  public void T0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.O.h();
    this.O.g();
  }
  
  public void U0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.O.h();
    this.O.g();
  }
  
  int U2(int paramInt1, int paramInt2)
  {
    if ((this.s == 1) && (n2()))
    {
      arrayOfInt = this.K;
      int i = this.J;
      return arrayOfInt[(i - paramInt1)] - arrayOfInt[(i - paramInt1 - paramInt2)];
    }
    int[] arrayOfInt = this.K;
    return arrayOfInt[(paramInt2 + paramInt1)] - arrayOfInt[paramInt1];
  }
  
  public int V2()
  {
    return this.J;
  }
  
  public void W0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    this.O.h();
    this.O.g();
  }
  
  public void X0(RecyclerView.v paramv, RecyclerView.z paramz)
  {
    if (paramz.e()) {
      M2();
    }
    super.X0(paramv, paramz);
    P2();
  }
  
  public void Y0(RecyclerView.z paramz)
  {
    super.Y0(paramz);
    this.I = false;
  }
  
  public void c3(int paramInt)
  {
    if (paramInt == this.J) {
      return;
    }
    this.I = true;
    if (paramInt >= 1)
    {
      this.J = paramInt;
      this.O.h();
      t1();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Span count should be at least 1. Provided ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  View f2(RecyclerView.v paramv, RecyclerView.z paramz, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = J();
    int j = -1;
    int k = 1;
    if (paramBoolean2)
    {
      i = J() - 1;
      k = -1;
    }
    else
    {
      j = i;
      i = 0;
    }
    int m = paramz.b();
    T1();
    int n = this.u.m();
    int i1 = this.u.i();
    Object localObject2 = null;
    Object localObject4;
    for (Object localObject1 = null; i != j; localObject1 = localObject4)
    {
      View localView = I(i);
      int i2 = h0(localView);
      Object localObject3 = localObject2;
      localObject4 = localObject1;
      if (i2 >= 0)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (i2 < m) {
          if (X2(paramv, paramz, i2) != 0)
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
          }
          else if (((RecyclerView.LayoutParams)localView.getLayoutParams()).c())
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject1 == null)
            {
              localObject4 = localView;
              localObject3 = localObject2;
            }
          }
          else
          {
            if ((this.u.g(localView) < i1) && (this.u.d(localView) >= n)) {
              return localView;
            }
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject2 == null)
            {
              localObject3 = localView;
              localObject4 = localObject1;
            }
          }
        }
      }
      i += k;
      localObject2 = localObject3;
    }
    if (localObject2 != null) {
      return localObject2;
    }
    return localObject1;
  }
  
  public int k0(RecyclerView.v paramv, RecyclerView.z paramz)
  {
    if (this.s == 0) {
      return this.J;
    }
    if (paramz.b() < 1) {
      return 0;
    }
    return W2(paramv, paramz, paramz.b() - 1) + 1;
  }
  
  public boolean m(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  void p2(RecyclerView.v paramv, RecyclerView.z paramz, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb)
  {
    int i3 = this.u.l();
    int k;
    if (i3 != 1073741824) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (J() > 0) {
      m = this.K[this.J];
    } else {
      m = 0;
    }
    if (k != 0) {
      d3();
    }
    boolean bool;
    if (paramc.e == 1) {
      bool = true;
    } else {
      bool = false;
    }
    int i = this.J;
    if (!bool) {
      i = X2(paramv, paramz, paramc.d) + Y2(paramv, paramz, paramc.d);
    }
    int i1 = 0;
    int n;
    Object localObject;
    while ((i1 < this.J) && (paramc.c(paramz)) && (i > 0))
    {
      j = paramc.d;
      n = Y2(paramv, paramz, j);
      if (n <= this.J)
      {
        i -= n;
        if (i >= 0)
        {
          localObject = paramc.d(paramv);
          if (localObject != null)
          {
            this.L[i1] = localObject;
            i1 += 1;
          }
        }
      }
      else
      {
        paramv = new StringBuilder();
        paramv.append("Item at position ");
        paramv.append(j);
        paramv.append(" requires ");
        paramv.append(n);
        paramv.append(" spans but GridLayoutManager has only ");
        paramv.append(this.J);
        paramv.append(" spans.");
        throw new IllegalArgumentException(paramv.toString());
      }
    }
    if (i1 == 0)
    {
      paramb.b = true;
      return;
    }
    float f1 = 0.0F;
    L2(paramv, paramz, i1, bool);
    int j = 0;
    i = j;
    while (j < i1)
    {
      paramv = this.L[j];
      if (paramc.l == null)
      {
        if (bool) {
          d(paramv);
        } else {
          e(paramv, 0);
        }
      }
      else if (bool) {
        b(paramv);
      } else {
        c(paramv, 0);
      }
      j(paramv, this.P);
      a3(paramv, i3, false);
      i2 = this.u.e(paramv);
      n = i;
      if (i2 > i) {
        n = i2;
      }
      paramz = (LayoutParams)paramv.getLayoutParams();
      float f3 = this.u.f(paramv) * 1.0F / paramz.f;
      float f2 = f1;
      if (f3 > f1) {
        f2 = f3;
      }
      j += 1;
      i = n;
      f1 = f2;
    }
    j = i;
    if (k != 0)
    {
      Z2(f1, m);
      k = 0;
      for (i = 0;; i = j)
      {
        j = i;
        if (k >= i1) {
          break;
        }
        paramv = this.L[k];
        a3(paramv, 1073741824, true);
        m = this.u.e(paramv);
        j = i;
        if (m > i) {
          j = m;
        }
        k += 1;
      }
    }
    i = 0;
    while (i < i1)
    {
      paramv = this.L[i];
      if (this.u.e(paramv) != j)
      {
        paramz = (LayoutParams)paramv.getLayoutParams();
        localObject = paramz.b;
        m = ((Rect)localObject).top + ((Rect)localObject).bottom + paramz.topMargin + paramz.bottomMargin;
        k = ((Rect)localObject).left + ((Rect)localObject).right + paramz.leftMargin + paramz.rightMargin;
        n = U2(paramz.e, paramz.f);
        if (this.s == 1)
        {
          k = RecyclerView.p.K(n, 1073741824, k, paramz.width, false);
          m = View.MeasureSpec.makeMeasureSpec(j - m, 1073741824);
        }
        else
        {
          k = View.MeasureSpec.makeMeasureSpec(j - k, 1073741824);
          m = RecyclerView.p.K(n, 1073741824, m, paramz.height, false);
        }
        b3(paramv, k, m, true);
      }
      i += 1;
    }
    int i2 = 0;
    paramb.a = j;
    if (this.s == 1)
    {
      if (paramc.f == -1)
      {
        i = paramc.b;
        j = i - j;
      }
      else
      {
        k = paramc.b;
        i = k;
        k = j + k;
        j = i;
        i = k;
      }
      k = 0;
      m = k;
    }
    else if (paramc.f == -1)
    {
      k = paramc.b;
      m = k - j;
      j = 0;
      i = j;
    }
    else
    {
      m = paramc.b;
      k = j + m;
      i = 0;
      j = i;
    }
    while (i2 < i1)
    {
      paramv = this.L[i2];
      paramz = (LayoutParams)paramv.getLayoutParams();
      if (this.s == 1)
      {
        if (n2())
        {
          k = e0() + this.K[(this.J - paramz.e)];
          n = this.u.f(paramv);
          m = k;
          k -= n;
        }
        else
        {
          m = e0() + this.K[paramz.e];
          n = this.u.f(paramv);
          k = m;
          m = n + m;
        }
        n = i;
        i = j;
        j = k;
      }
      else
      {
        n = g0() + this.K[paramz.e];
        i3 = this.u.f(paramv);
        i = n;
        j = m;
        n = i3 + n;
        m = k;
      }
      z0(paramv, j, i, m, n);
      if ((paramz.c()) || (paramz.b())) {
        paramb.c = true;
      }
      paramb.d |= paramv.hasFocusable();
      i3 = i2 + 1;
      k = m;
      i2 = i;
      i = n;
      m = j;
      j = i2;
      i2 = i3;
    }
    Arrays.fill(this.L, null);
  }
  
  public int r(RecyclerView.z paramz)
  {
    if (this.Q) {
      return Q2(paramz);
    }
    return super.r(paramz);
  }
  
  void r2(RecyclerView.v paramv, RecyclerView.z paramz, LinearLayoutManager.a parama, int paramInt)
  {
    super.r2(paramv, paramz, parama, paramInt);
    d3();
    if ((paramz.b() > 0) && (!paramz.e())) {
      S2(paramv, paramz, parama, paramInt);
    }
    T2();
  }
  
  public int s(RecyclerView.z paramz)
  {
    if (this.Q) {
      return R2(paramz);
    }
    return super.s(paramz);
  }
  
  public int u(RecyclerView.z paramz)
  {
    if (this.Q) {
      return Q2(paramz);
    }
    return super.u(paramz);
  }
  
  public int v(RecyclerView.z paramz)
  {
    if (this.Q) {
      return R2(paramz);
    }
    return super.v(paramz);
  }
  
  public int w1(int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
  {
    d3();
    T2();
    return super.w1(paramInt, paramv, paramz);
  }
  
  public int y1(int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
  {
    d3();
    T2();
    return super.y1(paramInt, paramv, paramz);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    int e = -1;
    int f = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public int e()
    {
      return this.e;
    }
    
    public int f()
    {
      return this.f;
    }
  }
  
  public static final class a
    extends GridLayoutManager.b
  {
    public int e(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }
    
    public int f(int paramInt)
    {
      return 1;
    }
  }
  
  public static abstract class b
  {
    final SparseIntArray a = new SparseIntArray();
    final SparseIntArray b = new SparseIntArray();
    private boolean c = false;
    private boolean d = false;
    
    static int a(SparseIntArray paramSparseIntArray, int paramInt)
    {
      int j = paramSparseIntArray.size() - 1;
      int i = 0;
      while (i <= j)
      {
        int k = i + j >>> 1;
        if (paramSparseIntArray.keyAt(k) < paramInt) {
          i = k + 1;
        } else {
          j = k - 1;
        }
      }
      paramInt = i - 1;
      if ((paramInt >= 0) && (paramInt < paramSparseIntArray.size())) {
        return paramSparseIntArray.keyAt(paramInt);
      }
      return -1;
    }
    
    int b(int paramInt1, int paramInt2)
    {
      if (!this.d) {
        return d(paramInt1, paramInt2);
      }
      int i = this.b.get(paramInt1, -1);
      if (i != -1) {
        return i;
      }
      paramInt2 = d(paramInt1, paramInt2);
      this.b.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    int c(int paramInt1, int paramInt2)
    {
      if (!this.c) {
        return e(paramInt1, paramInt2);
      }
      int i = this.a.get(paramInt1, -1);
      if (i != -1) {
        return i;
      }
      paramInt2 = e(paramInt1, paramInt2);
      this.a.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public int d(int paramInt1, int paramInt2)
    {
      int i1;
      if (this.d)
      {
        i = a(this.b, paramInt1);
        if (i != -1)
        {
          n = this.b.get(i);
          m = i + 1;
          i1 = c(i, paramInt2) + f(i);
          i = n;
          k = m;
          j = i1;
          if (i1 != paramInt2) {
            break label91;
          }
          i = n + 1;
          j = 0;
          k = m;
          break label91;
        }
      }
      int i = 0;
      int k = i;
      int j = k;
      label91:
      int i2 = f(paramInt1);
      int n = j;
      int m = k;
      j = i;
      while (m < paramInt1)
      {
        i1 = f(m);
        n += i1;
        if (n == paramInt2)
        {
          k = j + 1;
          i = 0;
        }
        else
        {
          k = j;
          i = n;
          if (n > paramInt2)
          {
            k = j + 1;
            i = i1;
          }
        }
        m += 1;
        j = k;
        n = i;
      }
      paramInt1 = j;
      if (n + i2 > paramInt2) {
        paramInt1 = j + 1;
      }
      return paramInt1;
    }
    
    public abstract int e(int paramInt1, int paramInt2);
    
    public abstract int f(int paramInt);
    
    public void g()
    {
      this.b.clear();
    }
    
    public void h()
    {
      this.a.clear();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */