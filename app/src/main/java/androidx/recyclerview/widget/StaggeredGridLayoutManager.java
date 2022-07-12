package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager
  extends RecyclerView.p
  implements RecyclerView.y.b
{
  boolean A = false;
  private BitSet B;
  int C = -1;
  int D = -2147483648;
  LazySpanLookup E = new LazySpanLookup();
  private int F = 2;
  private boolean G;
  private boolean H;
  private SavedState I;
  private int J;
  private final Rect K = new Rect();
  private final b L = new b();
  private boolean M = false;
  private boolean N = true;
  private int[] O;
  private final Runnable P = new a();
  private int s = -1;
  c[] t;
  m u;
  m v;
  private int w;
  private int x;
  private final i y;
  boolean z = false;
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = RecyclerView.p.i0(paramContext, paramAttributeSet, paramInt1, paramInt2);
    H2(paramContext.a);
    J2(paramContext.b);
    I2(paramContext.c);
    this.y = new i();
    a2();
  }
  
  private void A2(RecyclerView.v paramv, i parami)
  {
    if (parami.a)
    {
      if (parami.i) {
        return;
      }
      if (parami.b == 0) {
        if (parami.e == -1)
        {
          i = parami.g;
          label35:
          B2(paramv, i);
          return;
        }
      }
      label42:
      int j;
      for (int i = parami.f;; i = Math.min(i, parami.b) + j)
      {
        C2(paramv, i);
        return;
        if (parami.e == -1)
        {
          i = parami.f;
          i -= m2(i);
          if (i < 0) {
            break;
          }
          i = parami.g - Math.min(i, parami.b);
          break label35;
        }
        i = n2(parami.g) - parami.g;
        if (i < 0) {
          break label42;
        }
        j = parami.f;
      }
    }
  }
  
  private void B2(RecyclerView.v paramv, int paramInt)
  {
    int i = J() - 1;
    while (i >= 0)
    {
      View localView = I(i);
      if ((this.u.g(localView) < paramInt) || (this.u.q(localView) < paramInt)) {
        break;
      }
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.f)
      {
        int m = 0;
        int j = 0;
        int k;
        for (;;)
        {
          k = m;
          if (j >= this.s) {
            break;
          }
          if (this.t[j].a.size() == 1) {
            return;
          }
          j += 1;
        }
        while (k < this.s)
        {
          this.t[k].s();
          k += 1;
        }
      }
      if (localLayoutParams.e.a.size() == 1) {
        return;
      }
      localLayoutParams.e.s();
      m1(localView, paramv);
      i -= 1;
    }
  }
  
  private void C2(RecyclerView.v paramv, int paramInt)
  {
    while (J() > 0)
    {
      int k = 0;
      View localView = I(0);
      if ((this.u.d(localView) > paramInt) || (this.u.p(localView) > paramInt)) {
        break;
      }
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.f)
      {
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= this.s) {
            break;
          }
          if (this.t[i].a.size() == 1) {
            return;
          }
          i += 1;
        }
        while (j < this.s)
        {
          this.t[j].t();
          j += 1;
        }
      }
      if (localLayoutParams.e.a.size() == 1) {
        return;
      }
      localLayoutParams.e.t();
      m1(localView, paramv);
    }
  }
  
  private void D2()
  {
    if (this.v.k() == 1073741824) {
      return;
    }
    float f1 = 0.0F;
    int m = J();
    int j = 0;
    int i = 0;
    View localView;
    while (i < m)
    {
      localView = I(i);
      float f3 = this.v.e(localView);
      if (f3 >= f1)
      {
        float f2 = f3;
        if (((LayoutParams)localView.getLayoutParams()).e()) {
          f2 = f3 * 1.0F / this.s;
        }
        f1 = Math.max(f1, f2);
      }
      i += 1;
    }
    int n = this.x;
    int k = Math.round(f1 * this.s);
    i = k;
    if (this.v.k() == -2147483648) {
      i = Math.min(k, this.v.n());
    }
    P2(i);
    i = j;
    if (this.x == n) {
      return;
    }
    while (i < m)
    {
      localView = I(i);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.f) {
        if ((t2()) && (this.w == 1))
        {
          j = this.s;
          k = localLayoutParams.e.e;
          localView.offsetLeftAndRight(-(j - 1 - k) * this.x - -(j - 1 - k) * n);
        }
        else
        {
          k = localLayoutParams.e.e;
          int i1 = this.x;
          j = this.w;
          k = i1 * k - k * n;
          if (j == 1) {
            localView.offsetLeftAndRight(k);
          } else {
            localView.offsetTopAndBottom(k);
          }
        }
      }
      i += 1;
    }
  }
  
  private void E2()
  {
    boolean bool;
    if ((this.w != 1) && (t2())) {
      bool = this.z ^ true;
    } else {
      bool = this.z;
    }
    this.A = bool;
  }
  
  private void G2(int paramInt)
  {
    i locali = this.y;
    locali.e = paramInt;
    boolean bool2 = this.A;
    int i = 1;
    boolean bool1;
    if (paramInt == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool2 == bool1) {
      paramInt = i;
    } else {
      paramInt = -1;
    }
    locali.d = paramInt;
  }
  
  private void K2(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.s)
    {
      if (!this.t[i].a.isEmpty()) {
        Q2(this.t[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private boolean L2(RecyclerView.z paramz, b paramb)
  {
    boolean bool = this.G;
    int i = paramz.b();
    if (bool) {
      i = g2(i);
    } else {
      i = c2(i);
    }
    paramb.a = i;
    paramb.b = -2147483648;
    return true;
  }
  
  private void M1(View paramView)
  {
    int i = this.s - 1;
    while (i >= 0)
    {
      this.t[i].a(paramView);
      i -= 1;
    }
  }
  
  private void N1(b paramb)
  {
    SavedState localSavedState = this.I;
    int i = localSavedState.c;
    if (i > 0)
    {
      if (i == this.s)
      {
        i = 0;
        while (i < this.s)
        {
          this.t[i].e();
          localSavedState = this.I;
          int k = localSavedState.d[i];
          int j = k;
          if (k != -2147483648)
          {
            if (localSavedState.i) {
              j = this.u.i();
            } else {
              j = this.u.m();
            }
            j = k + j;
          }
          this.t[i].v(j);
          i += 1;
        }
      }
      localSavedState.h();
      localSavedState = this.I;
      localSavedState.a = localSavedState.b;
    }
    localSavedState = this.I;
    this.H = localSavedState.j;
    I2(localSavedState.h);
    E2();
    localSavedState = this.I;
    i = localSavedState.a;
    boolean bool;
    if (i != -1)
    {
      this.C = i;
      bool = localSavedState.i;
    }
    else
    {
      bool = this.A;
    }
    paramb.c = bool;
    if (localSavedState.e > 1)
    {
      paramb = this.E;
      paramb.a = localSavedState.f;
      paramb.b = localSavedState.g;
    }
  }
  
  private void O2(int paramInt, RecyclerView.z paramz)
  {
    i locali = this.y;
    boolean bool2 = false;
    locali.b = 0;
    locali.c = paramInt;
    if (x0())
    {
      i = paramz.c();
      if (i != -1)
      {
        boolean bool3 = this.A;
        if (i < paramInt) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (bool3 == bool1)
        {
          paramInt = this.u.n();
          i = 0;
          break label95;
        }
        i = this.u.n();
        paramInt = 0;
        break label95;
      }
    }
    paramInt = 0;
    int i = paramInt;
    label95:
    if (M())
    {
      this.y.f = (this.u.m() - i);
      this.y.g = (this.u.i() + paramInt);
    }
    else
    {
      this.y.g = (this.u.h() + paramInt);
      this.y.f = (-i);
    }
    paramz = this.y;
    paramz.h = false;
    paramz.a = true;
    boolean bool1 = bool2;
    if (this.u.k() == 0)
    {
      bool1 = bool2;
      if (this.u.h() == 0) {
        bool1 = true;
      }
    }
    paramz.i = bool1;
  }
  
  private void Q1(View paramView, LayoutParams paramLayoutParams, i parami)
  {
    if (parami.e == 1)
    {
      if (paramLayoutParams.f)
      {
        M1(paramView);
        return;
      }
      paramLayoutParams.e.a(paramView);
      return;
    }
    if (paramLayoutParams.f)
    {
      z2(paramView);
      return;
    }
    paramLayoutParams.e.u(paramView);
  }
  
  private void Q2(c paramc, int paramInt1, int paramInt2)
  {
    int i = paramc.j();
    if (paramInt1 == -1 ? paramc.o() + i <= paramInt2 : paramc.k() - i >= paramInt2) {
      this.B.set(paramc.e, false);
    }
  }
  
  private int R1(int paramInt)
  {
    int j = J();
    int i = -1;
    if (j == 0)
    {
      paramInt = i;
      if (this.A) {
        paramInt = 1;
      }
      return paramInt;
    }
    int k;
    if (paramInt < j2()) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != this.A) {
      return -1;
    }
    return 1;
  }
  
  private int R2(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      return paramInt1;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    if ((i != -2147483648) && (i != 1073741824)) {
      return paramInt1;
    }
    return View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i);
  }
  
  private boolean T1(c paramc)
  {
    if (this.A)
    {
      if (paramc.k() < this.u.i())
      {
        ArrayList localArrayList = paramc.a;
        return paramc.n((View)localArrayList.get(localArrayList.size() - 1)).f ^ true;
      }
    }
    else if (paramc.o() > this.u.m()) {
      return paramc.n((View)paramc.a.get(0)).f ^ true;
    }
    return false;
  }
  
  private int U1(RecyclerView.z paramz)
  {
    if (J() == 0) {
      return 0;
    }
    return p.a(paramz, this.u, e2(this.N ^ true), d2(this.N ^ true), this, this.N);
  }
  
  private int V1(RecyclerView.z paramz)
  {
    if (J() == 0) {
      return 0;
    }
    return p.b(paramz, this.u, e2(this.N ^ true), d2(this.N ^ true), this, this.N, this.A);
  }
  
  private int W1(RecyclerView.z paramz)
  {
    if (J() == 0) {
      return 0;
    }
    return p.c(paramz, this.u, e2(this.N ^ true), d2(this.N ^ true), this, this.N);
  }
  
  private int X1(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 17)
        {
          if (paramInt != 33)
          {
            if (paramInt != 66)
            {
              if (paramInt != 130) {
                return -2147483648;
              }
              if (this.w == 1) {
                return 1;
              }
              return -2147483648;
            }
            if (this.w == 0) {
              return 1;
            }
            return -2147483648;
          }
          if (this.w == 1) {
            return -1;
          }
          return -2147483648;
        }
        if (this.w == 0) {
          return -1;
        }
        return -2147483648;
      }
      if (this.w == 1) {
        return 1;
      }
      if (t2()) {
        return -1;
      }
      return 1;
    }
    if (this.w == 1) {
      return -1;
    }
    if (t2()) {
      return 1;
    }
    return -1;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem Y1(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.c = new int[this.s];
    int i = 0;
    while (i < this.s)
    {
      localFullSpanItem.c[i] = (paramInt - this.t[i].l(paramInt));
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem Z1(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.c = new int[this.s];
    int i = 0;
    while (i < this.s)
    {
      localFullSpanItem.c[i] = (this.t[i].p(paramInt) - paramInt);
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private void a2()
  {
    this.u = m.b(this, this.w);
    this.v = m.b(this, 1 - this.w);
  }
  
  private int b2(RecyclerView.v paramv, i parami, RecyclerView.z paramz)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private int c2(int paramInt)
  {
    int j = J();
    int i = 0;
    while (i < j)
    {
      int k = h0(I(i));
      if ((k >= 0) && (k < paramInt)) {
        return k;
      }
      i += 1;
    }
    return 0;
  }
  
  private int g2(int paramInt)
  {
    int i = J() - 1;
    while (i >= 0)
    {
      int j = h0(I(i));
      if ((j >= 0) && (j < paramInt)) {
        return j;
      }
      i -= 1;
    }
    return 0;
  }
  
  private void h2(RecyclerView.v paramv, RecyclerView.z paramz, boolean paramBoolean)
  {
    int i = l2(-2147483648);
    if (i == -2147483648) {
      return;
    }
    i = this.u.i() - i;
    if (i > 0)
    {
      i -= -F2(-i, paramv, paramz);
      if ((paramBoolean) && (i > 0)) {
        this.u.r(i);
      }
    }
  }
  
  private void i2(RecyclerView.v paramv, RecyclerView.z paramz, boolean paramBoolean)
  {
    int i = o2(2147483647);
    if (i == 2147483647) {
      return;
    }
    i -= this.u.m();
    if (i > 0)
    {
      i -= F2(i, paramv, paramz);
      if ((paramBoolean) && (i > 0)) {
        this.u.r(-i);
      }
    }
  }
  
  private int l2(int paramInt)
  {
    int j = this.t[0].l(paramInt);
    int i = 1;
    while (i < this.s)
    {
      int m = this.t[i].l(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int m2(int paramInt)
  {
    int j = this.t[0].p(paramInt);
    int i = 1;
    while (i < this.s)
    {
      int m = this.t[i].p(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int n2(int paramInt)
  {
    int j = this.t[0].l(paramInt);
    int i = 1;
    while (i < this.s)
    {
      int m = this.t[i].l(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int o2(int paramInt)
  {
    int j = this.t[0].p(paramInt);
    int i = 1;
    while (i < this.s)
    {
      int m = this.t[i].p(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private c p2(i parami)
  {
    boolean bool = x2(parami.e);
    int j = -1;
    int i;
    int k;
    if (bool)
    {
      i = this.s - 1;
      k = -1;
    }
    else
    {
      i = 0;
      j = this.s;
      k = 1;
    }
    int m = parami.e;
    c localc = null;
    parami = null;
    int i1;
    int n;
    if (m == 1)
    {
      m = 2147483647;
      i2 = this.u.m();
      while (i != j)
      {
        localc = this.t[i];
        i1 = localc.l(i2);
        n = m;
        if (i1 < m)
        {
          parami = localc;
          n = i1;
        }
        i += k;
        m = n;
      }
      return parami;
    }
    m = -2147483648;
    int i2 = this.u.i();
    parami = localc;
    while (i != j)
    {
      localc = this.t[i];
      i1 = localc.p(i2);
      n = m;
      if (i1 > m)
      {
        parami = localc;
        n = i1;
      }
      i += k;
      m = n;
    }
    return parami;
  }
  
  private void q2(int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    if (this.A) {
      j = k2();
    } else {
      j = j2();
    }
    int i;
    if (paramInt3 == 8)
    {
      if (paramInt1 < paramInt2)
      {
        i = paramInt2 + 1;
      }
      else
      {
        i = paramInt1 + 1;
        k = paramInt2;
        break label60;
      }
    }
    else {
      i = paramInt1 + paramInt2;
    }
    int k = paramInt1;
    label60:
    this.E.h(k);
    if (paramInt3 != 1)
    {
      if (paramInt3 != 2)
      {
        if (paramInt3 == 8)
        {
          this.E.k(paramInt1, 1);
          this.E.j(paramInt2, 1);
        }
      }
      else {
        this.E.k(paramInt1, paramInt2);
      }
    }
    else {
      this.E.j(paramInt1, paramInt2);
    }
    if (i <= j) {
      return;
    }
    if (this.A) {
      paramInt1 = j2();
    } else {
      paramInt1 = k2();
    }
    if (k <= paramInt1) {
      t1();
    }
  }
  
  private void u2(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    j(paramView, this.K);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.leftMargin;
    Rect localRect = this.K;
    paramInt1 = R2(paramInt1, i + localRect.left, localLayoutParams.rightMargin + localRect.right);
    i = localLayoutParams.topMargin;
    localRect = this.K;
    paramInt2 = R2(paramInt2, i + localRect.top, localLayoutParams.bottomMargin + localRect.bottom);
    if (paramBoolean) {
      paramBoolean = H1(paramView, paramInt1, paramInt2, localLayoutParams);
    } else {
      paramBoolean = F1(paramView, paramInt1, paramInt2, localLayoutParams);
    }
    if (paramBoolean) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private void v2(View paramView, LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramLayoutParams.f)
    {
      if (this.w == 1) {
        i = this.J;
      } else {
        u2(paramView, RecyclerView.p.K(o0(), p0(), e0() + f0(), paramLayoutParams.width, true), this.J, paramBoolean);
      }
    }
    else
    {
      if (this.w != 1) {
        break label117;
      }
      i = RecyclerView.p.K(this.x, p0(), 0, paramLayoutParams.width, false);
    }
    int j = RecyclerView.p.K(W(), X(), g0() + d0(), paramLayoutParams.height, true);
    break label163;
    label117:
    int i = RecyclerView.p.K(o0(), p0(), e0() + f0(), paramLayoutParams.width, true);
    j = RecyclerView.p.K(this.x, X(), 0, paramLayoutParams.height, false);
    label163:
    u2(paramView, i, j, paramBoolean);
  }
  
  private void w2(RecyclerView.v paramv, RecyclerView.z paramz, boolean paramBoolean)
  {
    b localb = this.L;
    if (((this.I != null) || (this.C != -1)) && (paramz.b() == 0))
    {
      k1(paramv);
      localb.c();
      return;
    }
    boolean bool = localb.e;
    int j = 1;
    if ((bool) && (this.C == -1) && (this.I == null)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      localb.c();
      if (this.I != null)
      {
        N1(localb);
      }
      else
      {
        E2();
        localb.c = this.A;
      }
      N2(paramz, localb);
      localb.e = true;
    }
    if ((this.I == null) && (this.C == -1) && ((localb.c != this.G) || (t2() != this.H)))
    {
      this.E.b();
      localb.d = true;
    }
    if (J() > 0)
    {
      localObject = this.I;
      if ((localObject == null) || (((SavedState)localObject).c < 1))
      {
        if (localb.d)
        {
          i = 0;
          while (i < this.s)
          {
            this.t[i].e();
            int k = localb.b;
            if (k != -2147483648) {
              this.t[i].v(k);
            }
            i += 1;
          }
        }
        if ((i == 0) && (this.L.f != null)) {
          i = 0;
        }
        while (i < this.s)
        {
          localObject = this.t[i];
          ((c)localObject).e();
          ((c)localObject).v(this.L.f[i]);
          i += 1;
          continue;
          i = 0;
          while (i < this.s)
          {
            this.t[i].b(this.A, localb.b);
            i += 1;
          }
          this.L.d(this.t);
        }
      }
    }
    w(paramv);
    this.y.a = false;
    this.M = false;
    P2(this.v.n());
    O2(localb.a, paramz);
    if (localb.c)
    {
      G2(-1);
      b2(paramv, this.y, paramz);
      G2(1);
    }
    else
    {
      G2(1);
      b2(paramv, this.y, paramz);
      G2(-1);
    }
    Object localObject = this.y;
    ((i)localObject).c = (localb.a + ((i)localObject).d);
    b2(paramv, (i)localObject, paramz);
    D2();
    if (J() > 0) {
      if (this.A)
      {
        h2(paramv, paramz, true);
        i2(paramv, paramz, false);
      }
      else
      {
        i2(paramv, paramz, true);
        h2(paramv, paramz, false);
      }
    }
    if ((paramBoolean) && (!paramz.e()))
    {
      if ((this.F != 0) && (J() > 0) && ((this.M) || (r2() != null))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        o1(this.P);
        if (S1())
        {
          i = j;
          break label646;
        }
      }
    }
    int i = 0;
    label646:
    if (paramz.e()) {
      this.L.c();
    }
    this.G = localb.c;
    this.H = t2();
    if (i != 0)
    {
      this.L.c();
      w2(paramv, paramz, false);
    }
  }
  
  private boolean x2(int paramInt)
  {
    int i;
    if (this.w == 0)
    {
      if (paramInt == -1) {
        i = 1;
      } else {
        i = 0;
      }
      return i != this.A;
    }
    if (paramInt == -1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == this.A) {
      i = 1;
    } else {
      i = 0;
    }
    return i == t2();
  }
  
  private void z2(View paramView)
  {
    int i = this.s - 1;
    while (i >= 0)
    {
      this.t[i].u(paramView);
      i -= 1;
    }
  }
  
  public void C0(int paramInt)
  {
    super.C0(paramInt);
    int i = 0;
    while (i < this.s)
    {
      this.t[i].r(paramInt);
      i += 1;
    }
  }
  
  public void C1(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = e0() + f0();
    int j = g0() + d0();
    if (this.w == 1)
    {
      paramInt2 = RecyclerView.p.n(paramInt2, paramRect.height() + j, b0());
      i = RecyclerView.p.n(paramInt1, this.x * this.s + i, c0());
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
    else
    {
      paramInt1 = RecyclerView.p.n(paramInt1, paramRect.width() + i, c0());
      i = RecyclerView.p.n(paramInt2, this.x * this.s + j, b0());
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    B1(paramInt2, paramInt1);
  }
  
  public RecyclerView.LayoutParams D()
  {
    if (this.w == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public void D0(int paramInt)
  {
    super.D0(paramInt);
    int i = 0;
    while (i < this.s)
    {
      this.t[i].r(paramInt);
      i += 1;
    }
  }
  
  public RecyclerView.LayoutParams E(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public void E0(RecyclerView.h paramh1, RecyclerView.h paramh2)
  {
    this.E.b();
    int i = 0;
    while (i < this.s)
    {
      this.t[i].e();
      i += 1;
    }
  }
  
  public RecyclerView.LayoutParams F(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  int F2(int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
  {
    if (J() != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      y2(paramInt, paramz);
      int i = b2(paramv, this.y, paramz);
      if (this.y.b >= i) {
        if (paramInt < 0) {
          paramInt = -i;
        } else {
          paramInt = i;
        }
      }
      this.u.r(-paramInt);
      this.G = this.A;
      paramz = this.y;
      paramz.b = 0;
      A2(paramv, paramz);
      return paramInt;
    }
    return 0;
  }
  
  public void H2(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    g(null);
    if (paramInt == this.w) {
      return;
    }
    this.w = paramInt;
    m localm = this.u;
    this.u = this.v;
    this.v = localm;
    t1();
  }
  
  public void I0(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    super.I0(paramRecyclerView, paramv);
    o1(this.P);
    int i = 0;
    while (i < this.s)
    {
      this.t[i].e();
      i += 1;
    }
    paramRecyclerView.requestLayout();
  }
  
  public void I1(RecyclerView paramRecyclerView, RecyclerView.z paramz, int paramInt)
  {
    paramRecyclerView = new j(paramRecyclerView.getContext());
    paramRecyclerView.p(paramInt);
    J1(paramRecyclerView);
  }
  
  public void I2(boolean paramBoolean)
  {
    g(null);
    SavedState localSavedState = this.I;
    if ((localSavedState != null) && (localSavedState.h != paramBoolean)) {
      localSavedState.h = paramBoolean;
    }
    this.z = paramBoolean;
    t1();
  }
  
  public View J0(View paramView, int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
  {
    if (J() == 0) {
      return null;
    }
    paramView = B(paramView);
    if (paramView == null) {
      return null;
    }
    E2();
    int k = X1(paramInt);
    if (k == -2147483648) {
      return null;
    }
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    boolean bool1 = ((LayoutParams)localObject).f;
    localObject = ((LayoutParams)localObject).e;
    if (k == 1) {
      paramInt = k2();
    } else {
      paramInt = j2();
    }
    O2(paramInt, paramz);
    G2(k);
    i locali = this.y;
    locali.c = (locali.d + paramInt);
    locali.b = ((int)(this.u.n() * 0.3333333F));
    locali = this.y;
    locali.h = true;
    int j = 0;
    locali.a = false;
    b2(paramv, locali, paramz);
    this.G = this.A;
    if (!bool1)
    {
      paramv = ((c)localObject).m(paramInt, k);
      if ((paramv != null) && (paramv != paramView)) {
        return paramv;
      }
    }
    if (x2(k))
    {
      i = this.s - 1;
      while (i >= 0)
      {
        paramv = this.t[i].m(paramInt, k);
        if ((paramv != null) && (paramv != paramView)) {
          return paramv;
        }
        i -= 1;
      }
    }
    int i = 0;
    while (i < this.s)
    {
      paramv = this.t[i].m(paramInt, k);
      if ((paramv != null) && (paramv != paramView)) {
        return paramv;
      }
      i += 1;
    }
    boolean bool2 = this.z;
    if (k == -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((bool2 ^ true) == paramInt) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (!bool1)
    {
      if (paramInt != 0) {
        i = ((c)localObject).f();
      } else {
        i = ((c)localObject).g();
      }
      paramv = C(i);
      if ((paramv != null) && (paramv != paramView)) {
        return paramv;
      }
    }
    i = j;
    if (x2(k))
    {
      i = this.s - 1;
      while (i >= 0)
      {
        if (i != ((c)localObject).e)
        {
          paramv = this.t;
          if (paramInt != 0) {
            j = paramv[i].f();
          } else {
            j = paramv[i].g();
          }
          paramv = C(j);
          if ((paramv != null) && (paramv != paramView)) {
            return paramv;
          }
        }
        i -= 1;
      }
    }
    while (i < this.s)
    {
      paramv = this.t;
      if (paramInt != 0) {
        j = paramv[i].f();
      } else {
        j = paramv[i].g();
      }
      paramv = C(j);
      if ((paramv != null) && (paramv != paramView)) {
        return paramv;
      }
      i += 1;
    }
    return null;
  }
  
  public void J2(int paramInt)
  {
    g(null);
    if (paramInt != this.s)
    {
      s2();
      this.s = paramInt;
      this.B = new BitSet(this.s);
      this.t = new c[this.s];
      paramInt = 0;
      while (paramInt < this.s)
      {
        this.t[paramInt] = new c(paramInt);
        paramInt += 1;
      }
      t1();
    }
  }
  
  public void K0(AccessibilityEvent paramAccessibilityEvent)
  {
    super.K0(paramAccessibilityEvent);
    if (J() > 0)
    {
      View localView1 = e2(false);
      View localView2 = d2(false);
      if (localView1 != null)
      {
        if (localView2 == null) {
          return;
        }
        int i = h0(localView1);
        int j = h0(localView2);
        if (i < j)
        {
          paramAccessibilityEvent.setFromIndex(i);
          paramAccessibilityEvent.setToIndex(j);
          return;
        }
        paramAccessibilityEvent.setFromIndex(j);
        paramAccessibilityEvent.setToIndex(i);
      }
    }
  }
  
  public boolean L1()
  {
    return this.I == null;
  }
  
  boolean M2(RecyclerView.z paramz, b paramb)
  {
    boolean bool2 = paramz.e();
    boolean bool1 = false;
    if (!bool2)
    {
      int i = this.C;
      if (i == -1) {
        return false;
      }
      if ((i >= 0) && (i < paramz.b()))
      {
        paramz = this.I;
        if ((paramz != null) && (paramz.a != -1) && (paramz.c >= 1))
        {
          paramb.b = -2147483648;
          paramb.a = this.C;
          return true;
        }
        paramz = C(this.C);
        if (paramz != null)
        {
          if (this.A) {
            i = k2();
          } else {
            i = j2();
          }
          paramb.a = i;
          if (this.D != -2147483648)
          {
            if (paramb.c)
            {
              i = this.u.i() - this.D;
              j = this.u.d(paramz);
            }
            else
            {
              i = this.u.m() + this.D;
              j = this.u.g(paramz);
            }
            paramb.b = (i - j);
            return true;
          }
          if (this.u.e(paramz) > this.u.n())
          {
            if (paramb.c) {
              i = this.u.i();
            } else {
              i = this.u.m();
            }
            paramb.b = i;
            return true;
          }
          i = this.u.g(paramz) - this.u.m();
          if (i < 0)
          {
            paramb.b = (-i);
            return true;
          }
          i = this.u.i() - this.u.d(paramz);
          if (i < 0)
          {
            paramb.b = i;
            return true;
          }
          paramb.b = -2147483648;
          return true;
        }
        i = this.C;
        paramb.a = i;
        int j = this.D;
        if (j == -2147483648)
        {
          if (R1(i) == 1) {
            bool1 = true;
          }
          paramb.c = bool1;
          paramb.a();
        }
        else
        {
          paramb.b(j);
        }
        paramb.d = true;
        return true;
      }
      this.C = -1;
      this.D = -2147483648;
    }
    return false;
  }
  
  void N2(RecyclerView.z paramz, b paramb)
  {
    if (M2(paramz, paramb)) {
      return;
    }
    if (L2(paramz, paramb)) {
      return;
    }
    paramb.a();
    paramb.a = 0;
  }
  
  boolean O1()
  {
    int j = this.t[0].l(-2147483648);
    int i = 1;
    while (i < this.s)
    {
      if (this.t[i].l(-2147483648) != j) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  boolean P1()
  {
    int j = this.t[0].p(-2147483648);
    int i = 1;
    while (i < this.s)
    {
      if (this.t[i].p(-2147483648) != j) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  void P2(int paramInt)
  {
    this.x = (paramInt / this.s);
    this.J = View.MeasureSpec.makeMeasureSpec(paramInt, this.v.k());
  }
  
  public void R0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    q2(paramInt1, paramInt2, 1);
  }
  
  public void S0(RecyclerView paramRecyclerView)
  {
    this.E.b();
    t1();
  }
  
  boolean S1()
  {
    if ((J() != 0) && (this.F != 0))
    {
      if (!r0()) {
        return false;
      }
      int i;
      int j;
      if (this.A)
      {
        i = k2();
        j = j2();
      }
      else
      {
        i = j2();
        j = k2();
      }
      if ((i == 0) && (r2() != null)) {
        this.E.b();
      }
      for (;;)
      {
        u1();
        t1();
        return true;
        if (!this.M) {
          return false;
        }
        int k;
        if (this.A) {
          k = -1;
        } else {
          k = 1;
        }
        Object localObject = this.E;
        j += 1;
        localObject = ((LazySpanLookup)localObject).e(i, j, k, true);
        if (localObject == null)
        {
          this.M = false;
          this.E.d(j);
          return false;
        }
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = this.E.e(i, ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).a, k * -1, true);
        if (localFullSpanItem == null) {
          this.E.d(((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).a);
        } else {
          this.E.d(localFullSpanItem.a + 1);
        }
      }
    }
    return false;
  }
  
  public void T0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    q2(paramInt1, paramInt2, 8);
  }
  
  public void U0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    q2(paramInt1, paramInt2, 2);
  }
  
  public void W0(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    q2(paramInt1, paramInt2, 4);
  }
  
  public void X0(RecyclerView.v paramv, RecyclerView.z paramz)
  {
    w2(paramv, paramz, true);
  }
  
  public void Y0(RecyclerView.z paramz)
  {
    super.Y0(paramz);
    this.C = -1;
    this.D = -2147483648;
    this.I = null;
    this.L.c();
  }
  
  public PointF a(int paramInt)
  {
    paramInt = R1(paramInt);
    PointF localPointF = new PointF();
    if (paramInt == 0) {
      return null;
    }
    if (this.w == 0)
    {
      localPointF.x = paramInt;
      localPointF.y = 0.0F;
      return localPointF;
    }
    localPointF.x = 0.0F;
    localPointF.y = paramInt;
    return localPointF;
  }
  
  public void c1(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      paramParcelable = (SavedState)paramParcelable;
      this.I = paramParcelable;
      if (this.C != -1)
      {
        paramParcelable.g();
        this.I.h();
      }
      t1();
    }
  }
  
  public Parcelable d1()
  {
    if (this.I != null) {
      return new SavedState(this.I);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.h = this.z;
    localSavedState.i = this.G;
    localSavedState.j = this.H;
    LazySpanLookup localLazySpanLookup = this.E;
    int j = 0;
    if (localLazySpanLookup != null)
    {
      int[] arrayOfInt = localLazySpanLookup.a;
      if (arrayOfInt != null)
      {
        localSavedState.f = arrayOfInt;
        localSavedState.e = arrayOfInt.length;
        localSavedState.g = localLazySpanLookup.b;
        break label114;
      }
    }
    localSavedState.e = 0;
    label114:
    if (J() > 0)
    {
      if (this.G) {
        i = k2();
      } else {
        i = j2();
      }
      localSavedState.a = i;
      localSavedState.b = f2();
      int i = this.s;
      localSavedState.c = i;
      localSavedState.d = new int[i];
      while (j < this.s)
      {
        int k;
        if (this.G)
        {
          k = this.t[j].l(-2147483648);
          i = k;
          if (k == -2147483648) {
            break label253;
          }
          i = this.u.i();
        }
        else
        {
          k = this.t[j].p(-2147483648);
          i = k;
          if (k == -2147483648) {
            break label253;
          }
          i = this.u.m();
        }
        i = k - i;
        label253:
        localSavedState.d[j] = i;
        j += 1;
      }
    }
    localSavedState.a = -1;
    localSavedState.b = -1;
    localSavedState.c = 0;
    return localSavedState;
  }
  
  View d2(boolean paramBoolean)
  {
    int j = this.u.m();
    int k = this.u.i();
    int i = J() - 1;
    Object localObject2;
    for (Object localObject1 = null; i >= 0; localObject1 = localObject2)
    {
      View localView = I(i);
      int m = this.u.g(localView);
      int n = this.u.d(localView);
      localObject2 = localObject1;
      if (n > j) {
        if (m >= k)
        {
          localObject2 = localObject1;
        }
        else if (n > k)
        {
          if (!paramBoolean) {
            return localView;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
        else
        {
          return localView;
        }
      }
      i -= 1;
    }
    return localObject1;
  }
  
  public void e1(int paramInt)
  {
    if (paramInt == 0) {
      S1();
    }
  }
  
  View e2(boolean paramBoolean)
  {
    int j = this.u.m();
    int k = this.u.i();
    int m = J();
    Object localObject1 = null;
    int i = 0;
    while (i < m)
    {
      View localView = I(i);
      int n = this.u.g(localView);
      Object localObject2 = localObject1;
      if (this.u.d(localView) > j) {
        if (n >= k)
        {
          localObject2 = localObject1;
        }
        else if (n < j)
        {
          if (!paramBoolean) {
            return localView;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
        else
        {
          return localView;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  int f2()
  {
    View localView;
    if (this.A) {
      localView = d2(true);
    } else {
      localView = e2(true);
    }
    if (localView == null) {
      return -1;
    }
    return h0(localView);
  }
  
  public void g(String paramString)
  {
    if (this.I == null) {
      super.g(paramString);
    }
  }
  
  int j2()
  {
    if (J() == 0) {
      return 0;
    }
    return h0(I(0));
  }
  
  public boolean k()
  {
    return this.w == 0;
  }
  
  int k2()
  {
    int i = J();
    if (i == 0) {
      return 0;
    }
    return h0(I(i - 1));
  }
  
  public boolean l()
  {
    return this.w == 1;
  }
  
  public boolean m(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void o(int paramInt1, int paramInt2, RecyclerView.z paramz, RecyclerView.p.c paramc)
  {
    if (this.w != 0) {
      paramInt1 = paramInt2;
    }
    if (J() != 0)
    {
      if (paramInt1 == 0) {
        return;
      }
      y2(paramInt1, paramz);
      Object localObject = this.O;
      if ((localObject == null) || (localObject.length < this.s)) {
        this.O = new int[this.s];
      }
      int k = 0;
      paramInt2 = 0;
      int i;
      for (paramInt1 = paramInt2; paramInt2 < this.s; paramInt1 = i)
      {
        localObject = this.y;
        if (((i)localObject).d == -1)
        {
          i = ((i)localObject).f;
          j = this.t[paramInt2].p(i);
        }
        else
        {
          i = this.t[paramInt2].l(((i)localObject).g);
          j = this.y.g;
        }
        int j = i - j;
        i = paramInt1;
        if (j >= 0)
        {
          this.O[paramInt1] = j;
          i = paramInt1 + 1;
        }
        paramInt2 += 1;
      }
      Arrays.sort(this.O, 0, paramInt1);
      paramInt2 = k;
      while ((paramInt2 < paramInt1) && (this.y.a(paramz)))
      {
        paramc.a(this.y.c, this.O[paramInt2]);
        localObject = this.y;
        ((i)localObject).c += ((i)localObject).d;
        paramInt2 += 1;
      }
    }
  }
  
  public int q(RecyclerView.z paramz)
  {
    return U1(paramz);
  }
  
  public int r(RecyclerView.z paramz)
  {
    return V1(paramz);
  }
  
  View r2()
  {
    int i = J() - 1;
    BitSet localBitSet = new BitSet(this.s);
    localBitSet.set(0, this.s, true);
    int j = this.w;
    int n = -1;
    if ((j == 1) && (t2())) {
      j = 1;
    } else {
      j = -1;
    }
    int k;
    if (this.A)
    {
      k = -1;
    }
    else
    {
      k = i + 1;
      i = 0;
    }
    int m = i;
    if (i < k)
    {
      n = 1;
      m = i;
    }
    while (m != k)
    {
      View localView = I(m);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localBitSet.get(localLayoutParams.e.e))
      {
        if (T1(localLayoutParams.e)) {
          return localView;
        }
        localBitSet.clear(localLayoutParams.e.e);
      }
      if (!localLayoutParams.f)
      {
        i = m + n;
        if (i != k)
        {
          Object localObject = I(i);
          int i1;
          if (this.A)
          {
            i = this.u.d(localView);
            i1 = this.u.d((View)localObject);
            if (i < i1) {
              return localView;
            }
            if (i != i1) {
              break label274;
            }
          }
          else
          {
            i = this.u.g(localView);
            i1 = this.u.g((View)localObject);
            if (i > i1) {
              return localView;
            }
            if (i != i1) {
              break label274;
            }
          }
          i = 1;
          break label276;
          label274:
          i = 0;
          label276:
          if (i != 0)
          {
            localObject = (LayoutParams)((View)localObject).getLayoutParams();
            if (localLayoutParams.e.e - ((LayoutParams)localObject).e.e < 0) {
              i = 1;
            } else {
              i = 0;
            }
            if (j < 0) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if (i != i1) {
              return localView;
            }
          }
        }
      }
      m += n;
    }
    return null;
  }
  
  public int s(RecyclerView.z paramz)
  {
    return W1(paramz);
  }
  
  public boolean s0()
  {
    return this.F != 0;
  }
  
  public void s2()
  {
    this.E.b();
    t1();
  }
  
  public int t(RecyclerView.z paramz)
  {
    return U1(paramz);
  }
  
  boolean t2()
  {
    return Z() == 1;
  }
  
  public int u(RecyclerView.z paramz)
  {
    return V1(paramz);
  }
  
  public int v(RecyclerView.z paramz)
  {
    return W1(paramz);
  }
  
  public int w1(int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
  {
    return F2(paramInt, paramv, paramz);
  }
  
  public void x1(int paramInt)
  {
    SavedState localSavedState = this.I;
    if ((localSavedState != null) && (localSavedState.a != paramInt)) {
      localSavedState.g();
    }
    this.C = paramInt;
    this.D = -2147483648;
    t1();
  }
  
  public int y1(int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
  {
    return F2(paramInt, paramv, paramz);
  }
  
  void y2(int paramInt, RecyclerView.z paramz)
  {
    int i;
    int j;
    if (paramInt > 0)
    {
      i = k2();
      j = 1;
    }
    else
    {
      i = j2();
      j = -1;
    }
    this.y.a = true;
    O2(i, paramz);
    G2(j);
    paramz = this.y;
    paramz.c = (i + paramz.d);
    paramz.b = Math.abs(paramInt);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    StaggeredGridLayoutManager.c e;
    boolean f;
    
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
    
    public boolean e()
    {
      return this.f;
    }
  }
  
  static class LazySpanLookup
  {
    int[] a;
    List<FullSpanItem> b;
    
    private int i(int paramInt)
    {
      if (this.b == null) {
        return -1;
      }
      FullSpanItem localFullSpanItem = f(paramInt);
      if (localFullSpanItem != null) {
        this.b.remove(localFullSpanItem);
      }
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        if (((FullSpanItem)this.b.get(i)).a >= paramInt) {
          break label82;
        }
        i += 1;
      }
      i = -1;
      label82:
      if (i != -1)
      {
        localFullSpanItem = (FullSpanItem)this.b.get(i);
        this.b.remove(i);
        return localFullSpanItem.a;
      }
      return -1;
    }
    
    private void l(int paramInt1, int paramInt2)
    {
      Object localObject = this.b;
      if (localObject == null) {
        return;
      }
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        localObject = (FullSpanItem)this.b.get(i);
        int j = ((FullSpanItem)localObject).a;
        if (j >= paramInt1) {
          ((FullSpanItem)localObject).a = (j + paramInt2);
        }
        i -= 1;
      }
    }
    
    private void m(int paramInt1, int paramInt2)
    {
      Object localObject = this.b;
      if (localObject == null) {
        return;
      }
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        localObject = (FullSpanItem)this.b.get(i);
        int j = ((FullSpanItem)localObject).a;
        if (j >= paramInt1) {
          if (j < paramInt1 + paramInt2) {
            this.b.remove(i);
          } else {
            ((FullSpanItem)localObject).a = (j - paramInt2);
          }
        }
        i -= 1;
      }
    }
    
    public void a(FullSpanItem paramFullSpanItem)
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.b.get(i);
        if (localFullSpanItem.a == paramFullSpanItem.a) {
          this.b.remove(i);
        }
        if (localFullSpanItem.a >= paramFullSpanItem.a)
        {
          this.b.add(i, paramFullSpanItem);
          return;
        }
        i += 1;
      }
      this.b.add(paramFullSpanItem);
    }
    
    void b()
    {
      int[] arrayOfInt = this.a;
      if (arrayOfInt != null) {
        Arrays.fill(arrayOfInt, -1);
      }
      this.b = null;
    }
    
    void c(int paramInt)
    {
      int[] arrayOfInt1 = this.a;
      if (arrayOfInt1 == null)
      {
        arrayOfInt1 = new int[Math.max(paramInt, 10) + 1];
        this.a = arrayOfInt1;
        Arrays.fill(arrayOfInt1, -1);
        return;
      }
      if (paramInt >= arrayOfInt1.length)
      {
        int[] arrayOfInt2 = new int[o(paramInt)];
        this.a = arrayOfInt2;
        System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
        arrayOfInt2 = this.a;
        Arrays.fill(arrayOfInt2, arrayOfInt1.length, arrayOfInt2.length, -1);
      }
    }
    
    int d(int paramInt)
    {
      List localList = this.b;
      if (localList != null)
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          if (((FullSpanItem)this.b.get(i)).a >= paramInt) {
            this.b.remove(i);
          }
          i -= 1;
        }
      }
      return h(paramInt);
    }
    
    public FullSpanItem e(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      Object localObject = this.b;
      if (localObject == null) {
        return null;
      }
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        localObject = (FullSpanItem)this.b.get(i);
        int k = ((FullSpanItem)localObject).a;
        if (k >= paramInt2) {
          return null;
        }
        if ((k >= paramInt1) && ((paramInt3 == 0) || (((FullSpanItem)localObject).b == paramInt3) || ((paramBoolean) && (((FullSpanItem)localObject).d)))) {
          return localObject;
        }
        i += 1;
      }
      return null;
    }
    
    public FullSpanItem f(int paramInt)
    {
      Object localObject = this.b;
      if (localObject == null) {
        return null;
      }
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        localObject = (FullSpanItem)this.b.get(i);
        if (((FullSpanItem)localObject).a == paramInt) {
          return localObject;
        }
        i -= 1;
      }
      return null;
    }
    
    int g(int paramInt)
    {
      int[] arrayOfInt = this.a;
      if ((arrayOfInt != null) && (paramInt < arrayOfInt.length)) {
        return arrayOfInt[paramInt];
      }
      return -1;
    }
    
    int h(int paramInt)
    {
      int[] arrayOfInt = this.a;
      if (arrayOfInt == null) {
        return -1;
      }
      if (paramInt >= arrayOfInt.length) {
        return -1;
      }
      int i = i(paramInt);
      if (i == -1)
      {
        arrayOfInt = this.a;
        Arrays.fill(arrayOfInt, paramInt, arrayOfInt.length, -1);
        return this.a.length;
      }
      i = Math.min(i + 1, this.a.length);
      Arrays.fill(this.a, paramInt, i, -1);
      return i;
    }
    
    void j(int paramInt1, int paramInt2)
    {
      int[] arrayOfInt = this.a;
      if (arrayOfInt != null)
      {
        if (paramInt1 >= arrayOfInt.length) {
          return;
        }
        int i = paramInt1 + paramInt2;
        c(i);
        arrayOfInt = this.a;
        System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, i, arrayOfInt.length - paramInt1 - paramInt2);
        Arrays.fill(this.a, paramInt1, i, -1);
        l(paramInt1, paramInt2);
      }
    }
    
    void k(int paramInt1, int paramInt2)
    {
      int[] arrayOfInt = this.a;
      if (arrayOfInt != null)
      {
        if (paramInt1 >= arrayOfInt.length) {
          return;
        }
        int i = paramInt1 + paramInt2;
        c(i);
        arrayOfInt = this.a;
        System.arraycopy(arrayOfInt, i, arrayOfInt, paramInt1, arrayOfInt.length - paramInt1 - paramInt2);
        arrayOfInt = this.a;
        Arrays.fill(arrayOfInt, arrayOfInt.length - paramInt2, arrayOfInt.length, -1);
        m(paramInt1, paramInt2);
      }
    }
    
    void n(int paramInt, StaggeredGridLayoutManager.c paramc)
    {
      c(paramInt);
      this.a[paramInt] = paramc.e;
    }
    
    int o(int paramInt)
    {
      int i = this.a.length;
      while (i <= paramInt) {
        i *= 2;
      }
      return i;
    }
    
    @SuppressLint({"BanParcelableUsage"})
    static class FullSpanItem
      implements Parcelable
    {
      public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();
      int a;
      int b;
      int[] c;
      boolean d;
      
      FullSpanItem() {}
      
      FullSpanItem(Parcel paramParcel)
      {
        this.a = paramParcel.readInt();
        this.b = paramParcel.readInt();
        int i = paramParcel.readInt();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        this.d = bool;
        i = paramParcel.readInt();
        if (i > 0)
        {
          int[] arrayOfInt = new int[i];
          this.c = arrayOfInt;
          paramParcel.readIntArray(arrayOfInt);
        }
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      int g(int paramInt)
      {
        int[] arrayOfInt = this.c;
        if (arrayOfInt == null) {
          return 0;
        }
        return arrayOfInt[paramInt];
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FullSpanItem{mPosition=");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", mGapDir=");
        localStringBuilder.append(this.b);
        localStringBuilder.append(", mHasUnwantedGapAfter=");
        localStringBuilder.append(this.d);
        localStringBuilder.append(", mGapPerSpan=");
        localStringBuilder.append(Arrays.toString(this.c));
        localStringBuilder.append('}');
        return localStringBuilder.toString();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      class a
        implements Parcelable.Creator<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem>
      {
        public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem a(Parcel paramParcel)
        {
          return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(paramParcel);
        }
        
        public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] b(int paramInt)
        {
          return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[paramInt];
        }
      }
    }
  }
  
  @SuppressLint({"BanParcelableUsage"})
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    int a;
    int b;
    int c;
    int[] d;
    int e;
    int[] f;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> g;
    boolean h;
    boolean i;
    boolean j;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
      int k = paramParcel.readInt();
      this.c = k;
      int[] arrayOfInt;
      if (k > 0)
      {
        arrayOfInt = new int[k];
        this.d = arrayOfInt;
        paramParcel.readIntArray(arrayOfInt);
      }
      k = paramParcel.readInt();
      this.e = k;
      if (k > 0)
      {
        arrayOfInt = new int[k];
        this.f = arrayOfInt;
        paramParcel.readIntArray(arrayOfInt);
      }
      k = paramParcel.readInt();
      boolean bool2 = false;
      if (k == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.h = bool1;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.i = bool1;
      boolean bool1 = bool2;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      }
      this.j = bool1;
      this.g = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.c = paramSavedState.c;
      this.a = paramSavedState.a;
      this.b = paramSavedState.b;
      this.d = paramSavedState.d;
      this.e = paramSavedState.e;
      this.f = paramSavedState.f;
      this.h = paramSavedState.h;
      this.i = paramSavedState.i;
      this.j = paramSavedState.j;
      this.g = paramSavedState.g;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    void g()
    {
      this.d = null;
      this.c = 0;
      this.a = -1;
      this.b = -1;
    }
    
    void h()
    {
      this.d = null;
      this.c = 0;
      this.e = 0;
      this.f = null;
      this.g = null;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    class a
      implements Parcelable.Creator<StaggeredGridLayoutManager.SavedState>
    {
      public StaggeredGridLayoutManager.SavedState a(Parcel paramParcel)
      {
        return new StaggeredGridLayoutManager.SavedState(paramParcel);
      }
      
      public StaggeredGridLayoutManager.SavedState[] b(int paramInt)
      {
        return new StaggeredGridLayoutManager.SavedState[paramInt];
      }
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      StaggeredGridLayoutManager.this.S1();
    }
  }
  
  class b
  {
    int a;
    int b;
    boolean c;
    boolean d;
    boolean e;
    int[] f;
    
    b()
    {
      c();
    }
    
    void a()
    {
      int i;
      if (this.c) {
        i = StaggeredGridLayoutManager.this.u.i();
      } else {
        i = StaggeredGridLayoutManager.this.u.m();
      }
      this.b = i;
    }
    
    void b(int paramInt)
    {
      if (this.c) {
        paramInt = StaggeredGridLayoutManager.this.u.i() - paramInt;
      } else {
        paramInt = StaggeredGridLayoutManager.this.u.m() + paramInt;
      }
      this.b = paramInt;
    }
    
    void c()
    {
      this.a = -1;
      this.b = -2147483648;
      this.c = false;
      this.d = false;
      this.e = false;
      int[] arrayOfInt = this.f;
      if (arrayOfInt != null) {
        Arrays.fill(arrayOfInt, -1);
      }
    }
    
    void d(StaggeredGridLayoutManager.c[] paramArrayOfc)
    {
      int j = paramArrayOfc.length;
      int[] arrayOfInt = this.f;
      if ((arrayOfInt == null) || (arrayOfInt.length < j)) {
        this.f = new int[StaggeredGridLayoutManager.this.t.length];
      }
      int i = 0;
      while (i < j)
      {
        this.f[i] = paramArrayOfc[i].p(-2147483648);
        i += 1;
      }
    }
  }
  
  class c
  {
    ArrayList<View> a = new ArrayList();
    int b = -2147483648;
    int c = -2147483648;
    int d = 0;
    final int e;
    
    c(int paramInt)
    {
      this.e = paramInt;
    }
    
    void a(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = n(paramView);
      localLayoutParams.e = this;
      this.a.add(paramView);
      this.c = -2147483648;
      if (this.a.size() == 1) {
        this.b = -2147483648;
      }
      if ((localLayoutParams.c()) || (localLayoutParams.b())) {
        this.d += StaggeredGridLayoutManager.this.u.e(paramView);
      }
    }
    
    void b(boolean paramBoolean, int paramInt)
    {
      int i;
      if (paramBoolean) {
        i = l(-2147483648);
      } else {
        i = p(-2147483648);
      }
      e();
      if (i == -2147483648) {
        return;
      }
      if (((paramBoolean) && (i < StaggeredGridLayoutManager.this.u.i())) || ((!paramBoolean) && (i > StaggeredGridLayoutManager.this.u.m()))) {
        return;
      }
      int j = i;
      if (paramInt != -2147483648) {
        j = i + paramInt;
      }
      this.c = j;
      this.b = j;
    }
    
    void c()
    {
      Object localObject = this.a;
      localObject = (View)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = n((View)localObject);
      this.c = StaggeredGridLayoutManager.this.u.d((View)localObject);
      if (localLayoutParams.f)
      {
        localObject = StaggeredGridLayoutManager.this.E.f(localLayoutParams.a());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).b == 1)) {
          this.c += ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).g(this.e);
        }
      }
    }
    
    void d()
    {
      Object localObject = (View)this.a.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = n((View)localObject);
      this.b = StaggeredGridLayoutManager.this.u.g((View)localObject);
      if (localLayoutParams.f)
      {
        localObject = StaggeredGridLayoutManager.this.E.f(localLayoutParams.a());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).b == -1)) {
          this.b -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).g(this.e);
        }
      }
    }
    
    void e()
    {
      this.a.clear();
      q();
      this.d = 0;
    }
    
    public int f()
    {
      int i;
      int j;
      if (StaggeredGridLayoutManager.this.z)
      {
        i = this.a.size() - 1;
        j = -1;
      }
      else
      {
        i = 0;
        j = this.a.size();
      }
      return i(i, j, true);
    }
    
    public int g()
    {
      int i;
      int j;
      if (StaggeredGridLayoutManager.this.z)
      {
        i = 0;
        j = this.a.size();
      }
      else
      {
        i = this.a.size() - 1;
        j = -1;
      }
      return i(i, j, true);
    }
    
    int h(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      int m = StaggeredGridLayoutManager.this.u.m();
      int n = StaggeredGridLayoutManager.this.u.i();
      int i;
      if (paramInt2 > paramInt1) {
        i = 1;
      } else {
        i = -1;
      }
      while (paramInt1 != paramInt2)
      {
        View localView = (View)this.a.get(paramInt1);
        int i1 = StaggeredGridLayoutManager.this.u.g(localView);
        int i2 = StaggeredGridLayoutManager.this.u.d(localView);
        int k = 0;
        int j;
        if (paramBoolean3 ? i1 <= n : i1 < n) {
          j = 1;
        } else {
          j = 0;
        }
        if (paramBoolean3 ? i2 >= m : i2 > m) {
          k = 1;
        }
        if ((j != 0) && (k != 0)) {
          if ((paramBoolean1) && (paramBoolean2))
          {
            if ((i1 < m) || (i2 > n)) {}
          }
          else {
            while ((paramBoolean2) || (i1 < m) || (i2 > n)) {
              return StaggeredGridLayoutManager.this.h0(localView);
            }
          }
        }
        paramInt1 += i;
      }
      return -1;
    }
    
    int i(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return h(paramInt1, paramInt2, false, false, paramBoolean);
    }
    
    public int j()
    {
      return this.d;
    }
    
    int k()
    {
      int i = this.c;
      if (i != -2147483648) {
        return i;
      }
      c();
      return this.c;
    }
    
    int l(int paramInt)
    {
      int i = this.c;
      if (i != -2147483648) {
        return i;
      }
      if (this.a.size() == 0) {
        return paramInt;
      }
      c();
      return this.c;
    }
    
    public View m(int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      View localView;
      StaggeredGridLayoutManager localStaggeredGridLayoutManager;
      if (paramInt2 == -1)
      {
        int i = this.a.size();
        paramInt2 = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (paramInt2 >= i) {
            break;
          }
          localView = (View)this.a.get(paramInt2);
          localStaggeredGridLayoutManager = StaggeredGridLayoutManager.this;
          if (localStaggeredGridLayoutManager.z)
          {
            localObject2 = localObject1;
            if (localStaggeredGridLayoutManager.h0(localView) <= paramInt1) {
              break;
            }
          }
          localObject2 = StaggeredGridLayoutManager.this;
          if ((!((StaggeredGridLayoutManager)localObject2).z) && (((RecyclerView.p)localObject2).h0(localView) >= paramInt1)) {
            return localObject1;
          }
          localObject2 = localObject1;
          if (!localView.hasFocusable()) {
            break;
          }
          paramInt2 += 1;
          localObject1 = localView;
        }
      }
      paramInt2 = this.a.size() - 1;
      for (localObject1 = localObject2;; localObject1 = localView)
      {
        localObject2 = localObject1;
        if (paramInt2 < 0) {
          break;
        }
        localView = (View)this.a.get(paramInt2);
        localStaggeredGridLayoutManager = StaggeredGridLayoutManager.this;
        if (localStaggeredGridLayoutManager.z)
        {
          localObject2 = localObject1;
          if (localStaggeredGridLayoutManager.h0(localView) >= paramInt1) {
            break;
          }
        }
        localObject2 = StaggeredGridLayoutManager.this;
        if ((!((StaggeredGridLayoutManager)localObject2).z) && (((RecyclerView.p)localObject2).h0(localView) <= paramInt1)) {
          return localObject1;
        }
        localObject2 = localObject1;
        if (!localView.hasFocusable()) {
          break;
        }
        paramInt2 -= 1;
      }
      return localObject2;
    }
    
    StaggeredGridLayoutManager.LayoutParams n(View paramView)
    {
      return (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    }
    
    int o()
    {
      int i = this.b;
      if (i != -2147483648) {
        return i;
      }
      d();
      return this.b;
    }
    
    int p(int paramInt)
    {
      int i = this.b;
      if (i != -2147483648) {
        return i;
      }
      if (this.a.size() == 0) {
        return paramInt;
      }
      d();
      return this.b;
    }
    
    void q()
    {
      this.b = -2147483648;
      this.c = -2147483648;
    }
    
    void r(int paramInt)
    {
      int i = this.b;
      if (i != -2147483648) {
        this.b = (i + paramInt);
      }
      i = this.c;
      if (i != -2147483648) {
        this.c = (i + paramInt);
      }
    }
    
    void s()
    {
      int i = this.a.size();
      View localView = (View)this.a.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = n(localView);
      localLayoutParams.e = null;
      if ((localLayoutParams.c()) || (localLayoutParams.b())) {
        this.d -= StaggeredGridLayoutManager.this.u.e(localView);
      }
      if (i == 1) {
        this.b = -2147483648;
      }
      this.c = -2147483648;
    }
    
    void t()
    {
      View localView = (View)this.a.remove(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = n(localView);
      localLayoutParams.e = null;
      if (this.a.size() == 0) {
        this.c = -2147483648;
      }
      if ((localLayoutParams.c()) || (localLayoutParams.b())) {
        this.d -= StaggeredGridLayoutManager.this.u.e(localView);
      }
      this.b = -2147483648;
    }
    
    void u(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = n(paramView);
      localLayoutParams.e = this;
      this.a.add(0, paramView);
      this.b = -2147483648;
      if (this.a.size() == 1) {
        this.c = -2147483648;
      }
      if ((localLayoutParams.c()) || (localLayoutParams.b())) {
        this.d += StaggeredGridLayoutManager.this.u.e(paramView);
      }
    }
    
    void v(int paramInt)
    {
      this.b = paramInt;
      this.c = paramInt;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */