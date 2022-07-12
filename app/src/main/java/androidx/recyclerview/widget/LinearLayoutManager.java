package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.p
  implements RecyclerView.y.b
{
  int A = -1;
  int B = -2147483648;
  private boolean C;
  SavedState D = null;
  final a E = new a();
  private final b F = new b();
  private int G = 2;
  private int[] H = new int[2];
  int s = 1;
  private c t;
  m u;
  private boolean v;
  private boolean w = false;
  boolean x = false;
  private boolean y = false;
  private boolean z = true;
  
  public LinearLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    A2(paramInt);
    B2(paramBoolean);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = RecyclerView.p.i0(paramContext, paramAttributeSet, paramInt1, paramInt2);
    A2(paramContext.a);
    B2(paramContext.c);
    C2(paramContext.d);
  }
  
  private boolean D2(RecyclerView.v paramv, RecyclerView.z paramz, a parama)
  {
    int i = J();
    int m = 0;
    if (i == 0) {
      return false;
    }
    View localView = V();
    if ((localView != null) && (parama.d(localView, paramz)))
    {
      parama.c(localView, h0(localView));
      return true;
    }
    boolean bool1 = this.v;
    boolean bool2 = this.y;
    if (bool1 != bool2) {
      return false;
    }
    paramv = f2(paramv, paramz, parama.d, bool2);
    if (paramv != null)
    {
      parama.b(paramv, h0(paramv));
      if ((!paramz.e()) && (L1()))
      {
        int i1 = this.u.g(paramv);
        int i2 = this.u.d(paramv);
        int n = this.u.m();
        int k = this.u.i();
        if ((i2 <= n) && (i1 < n)) {
          i = 1;
        } else {
          i = 0;
        }
        int j = m;
        if (i1 >= k)
        {
          j = m;
          if (i2 > k) {
            j = 1;
          }
        }
        if ((i != 0) || (j != 0))
        {
          i = n;
          if (parama.d) {
            i = k;
          }
          parama.c = i;
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean E2(RecyclerView.z paramz, a parama)
  {
    boolean bool1 = paramz.e();
    boolean bool2 = false;
    if (!bool1)
    {
      int i = this.A;
      if (i == -1) {
        return false;
      }
      if ((i >= 0) && (i < paramz.b()))
      {
        parama.b = this.A;
        paramz = this.D;
        if ((paramz != null) && (paramz.g()))
        {
          bool1 = this.D.c;
          parama.d = bool1;
          if (bool1) {
            i = this.u.i() - this.D.b;
          } else {
            i = this.u.m() + this.D.b;
          }
          parama.c = i;
          return true;
        }
        if (this.B == -2147483648)
        {
          paramz = C(this.A);
          if (paramz != null)
          {
            if (this.u.e(paramz) > this.u.n())
            {
              parama.a();
              return true;
            }
            if (this.u.g(paramz) - this.u.m() < 0)
            {
              parama.c = this.u.m();
              parama.d = false;
              return true;
            }
            if (this.u.i() - this.u.d(paramz) < 0)
            {
              parama.c = this.u.i();
              parama.d = true;
              return true;
            }
            if (parama.d) {
              i = this.u.d(paramz) + this.u.o();
            } else {
              i = this.u.g(paramz);
            }
            parama.c = i;
            return true;
          }
          if (J() > 0)
          {
            i = h0(I(0));
            if (this.A < i) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if (bool1 == this.x) {
              bool2 = true;
            }
            parama.d = bool2;
          }
          parama.a();
          return true;
        }
        bool1 = this.x;
        parama.d = bool1;
        if (bool1) {
          i = this.u.i() - this.B;
        } else {
          i = this.u.m() + this.B;
        }
        parama.c = i;
        return true;
      }
      this.A = -1;
      this.B = -2147483648;
    }
    return false;
  }
  
  private void F2(RecyclerView.v paramv, RecyclerView.z paramz, a parama)
  {
    if (E2(paramz, parama)) {
      return;
    }
    if (D2(paramv, paramz, parama)) {
      return;
    }
    parama.a();
    int i;
    if (this.y) {
      i = paramz.b() - 1;
    } else {
      i = 0;
    }
    parama.b = i;
  }
  
  private void G2(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.z paramz)
  {
    this.t.m = w2();
    this.t.f = paramInt1;
    Object localObject = this.H;
    int k = 0;
    localObject[0] = 0;
    int n = 1;
    int m = 1;
    localObject[1] = 0;
    M1(paramz, (int[])localObject);
    int i = Math.max(0, this.H[0]);
    int j = Math.max(0, this.H[1]);
    if (paramInt1 == 1) {
      k = 1;
    }
    paramz = this.t;
    if (k != 0) {
      paramInt1 = j;
    } else {
      paramInt1 = i;
    }
    paramz.h = paramInt1;
    if (k == 0) {
      i = j;
    }
    paramz.i = i;
    c localc;
    if (k != 0)
    {
      paramz.h = (paramInt1 + this.u.j());
      paramz = i2();
      localObject = this.t;
      paramInt1 = m;
      if (this.x) {
        paramInt1 = -1;
      }
      ((c)localObject).e = paramInt1;
      paramInt1 = h0(paramz);
      localc = this.t;
      ((c)localObject).d = (paramInt1 + localc.e);
      localc.b = this.u.d(paramz);
      paramInt1 = this.u.d(paramz) - this.u.i();
    }
    else
    {
      paramz = j2();
      localObject = this.t;
      ((c)localObject).h += this.u.m();
      localObject = this.t;
      if (this.x) {
        paramInt1 = n;
      } else {
        paramInt1 = -1;
      }
      ((c)localObject).e = paramInt1;
      paramInt1 = h0(paramz);
      localc = this.t;
      ((c)localObject).d = (paramInt1 + localc.e);
      localc.b = this.u.g(paramz);
      paramInt1 = -this.u.g(paramz) + this.u.m();
    }
    paramz = this.t;
    paramz.c = paramInt2;
    if (paramBoolean) {
      paramz.c = (paramInt2 - paramInt1);
    }
    paramz.g = paramInt1;
  }
  
  private void H2(int paramInt1, int paramInt2)
  {
    this.t.c = (this.u.i() - paramInt2);
    c localc = this.t;
    int i;
    if (this.x) {
      i = -1;
    } else {
      i = 1;
    }
    localc.e = i;
    localc.d = paramInt1;
    localc.f = 1;
    localc.b = paramInt2;
    localc.g = -2147483648;
  }
  
  private void I2(a parama)
  {
    H2(parama.b, parama.c);
  }
  
  private void J2(int paramInt1, int paramInt2)
  {
    this.t.c = (paramInt2 - this.u.m());
    c localc = this.t;
    localc.d = paramInt1;
    if (this.x) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    }
    localc.e = paramInt1;
    localc.f = -1;
    localc.b = paramInt2;
    localc.g = -2147483648;
  }
  
  private void K2(a parama)
  {
    J2(parama.b, parama.c);
  }
  
  private int O1(RecyclerView.z paramz)
  {
    if (J() == 0) {
      return 0;
    }
    T1();
    return p.a(paramz, this.u, X1(this.z ^ true, true), W1(this.z ^ true, true), this, this.z);
  }
  
  private int P1(RecyclerView.z paramz)
  {
    if (J() == 0) {
      return 0;
    }
    T1();
    return p.b(paramz, this.u, X1(this.z ^ true, true), W1(this.z ^ true, true), this, this.z, this.x);
  }
  
  private int Q1(RecyclerView.z paramz)
  {
    if (J() == 0) {
      return 0;
    }
    T1();
    return p.c(paramz, this.u, X1(this.z ^ true, true), W1(this.z ^ true, true), this, this.z);
  }
  
  private View V1()
  {
    return b2(0, J());
  }
  
  private View Z1()
  {
    return b2(J() - 1, -1);
  }
  
  private View d2()
  {
    if (this.x) {
      return V1();
    }
    return Z1();
  }
  
  private View e2()
  {
    if (this.x) {
      return Z1();
    }
    return V1();
  }
  
  private int g2(int paramInt, RecyclerView.v paramv, RecyclerView.z paramz, boolean paramBoolean)
  {
    int i = this.u.i() - paramInt;
    if (i > 0)
    {
      i = -y2(-i, paramv, paramz);
      if (paramBoolean)
      {
        paramInt = this.u.i() - (paramInt + i);
        if (paramInt > 0)
        {
          this.u.r(paramInt);
          return paramInt + i;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int h2(int paramInt, RecyclerView.v paramv, RecyclerView.z paramz, boolean paramBoolean)
  {
    int i = paramInt - this.u.m();
    if (i > 0)
    {
      int j = -y2(i, paramv, paramz);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.u.m();
        i = j;
        if (paramInt > 0)
        {
          this.u.r(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private View i2()
  {
    int i;
    if (this.x) {
      i = 0;
    } else {
      i = J() - 1;
    }
    return I(i);
  }
  
  private View j2()
  {
    int i;
    if (this.x) {
      i = J() - 1;
    } else {
      i = 0;
    }
    return I(i);
  }
  
  private void q2(RecyclerView.v paramv, RecyclerView.z paramz, int paramInt1, int paramInt2)
  {
    if ((paramz.g()) && (J() != 0) && (!paramz.e()))
    {
      if (!L1()) {
        return;
      }
      Object localObject = paramv.k();
      int n = ((List)localObject).size();
      int i1 = h0(I(0));
      int m = 0;
      int i = m;
      int j = i;
      int k = i;
      i = m;
      while (i < n)
      {
        RecyclerView.c0 localc0 = (RecyclerView.c0)((List)localObject).get(i);
        if (!localc0.v())
        {
          int i2 = localc0.m();
          m = 1;
          int i3;
          if (i2 < i1) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          if (i3 != this.x) {
            m = -1;
          }
          i2 = this.u.e(localc0.a);
          if (m == -1) {
            k += i2;
          } else {
            j += i2;
          }
        }
        i += 1;
      }
      this.t.l = ((List)localObject);
      if (k > 0)
      {
        J2(h0(j2()), paramInt1);
        localObject = this.t;
        ((c)localObject).h = k;
        ((c)localObject).c = 0;
        ((c)localObject).a();
        U1(paramv, this.t, paramz, false);
      }
      if (j > 0)
      {
        H2(h0(i2()), paramInt2);
        localObject = this.t;
        ((c)localObject).h = j;
        ((c)localObject).c = 0;
        ((c)localObject).a();
        U1(paramv, this.t, paramz, false);
      }
      this.t.l = null;
    }
  }
  
  private void s2(RecyclerView.v paramv, c paramc)
  {
    if (paramc.a)
    {
      if (paramc.m) {
        return;
      }
      int i = paramc.g;
      int j = paramc.i;
      if (paramc.f == -1)
      {
        u2(paramv, i, j);
        return;
      }
      v2(paramv, i, j);
    }
  }
  
  private void t2(RecyclerView.v paramv, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    int i = paramInt1;
    if (paramInt2 > paramInt1)
    {
      paramInt2 -= 1;
      while (paramInt2 >= paramInt1)
      {
        n1(paramInt2, paramv);
        paramInt2 -= 1;
      }
    }
    while (i > paramInt2)
    {
      n1(i, paramv);
      i -= 1;
    }
  }
  
  private void u2(RecyclerView.v paramv, int paramInt1, int paramInt2)
  {
    int j = J();
    if (paramInt1 < 0) {
      return;
    }
    int i = this.u.h() - paramInt1 + paramInt2;
    View localView;
    if (this.x)
    {
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= j) {
          return;
        }
        localView = I(paramInt1);
        if ((this.u.g(localView) < i) || (this.u.q(localView) < i)) {
          break;
        }
        paramInt1 += 1;
      }
      t2(paramv, 0, paramInt1);
      return;
    }
    paramInt2 = j - 1;
    paramInt1 = paramInt2;
    while (paramInt1 >= 0)
    {
      localView = I(paramInt1);
      if ((this.u.g(localView) >= i) && (this.u.q(localView) >= i)) {
        paramInt1 -= 1;
      } else {
        t2(paramv, paramInt2, paramInt1);
      }
    }
  }
  
  private void v2(RecyclerView.v paramv, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return;
    }
    int i = paramInt1 - paramInt2;
    paramInt2 = J();
    View localView;
    if (this.x)
    {
      paramInt2 -= 1;
      paramInt1 = paramInt2;
      for (;;)
      {
        if (paramInt1 < 0) {
          return;
        }
        localView = I(paramInt1);
        if ((this.u.d(localView) > i) || (this.u.p(localView) > i)) {
          break;
        }
        paramInt1 -= 1;
      }
      t2(paramv, paramInt2, paramInt1);
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localView = I(paramInt1);
      if ((this.u.d(localView) <= i) && (this.u.p(localView) <= i)) {
        paramInt1 += 1;
      } else {
        t2(paramv, 0, paramInt1);
      }
    }
  }
  
  private void x2()
  {
    boolean bool;
    if ((this.s != 1) && (n2())) {
      bool = this.w ^ true;
    } else {
      bool = this.w;
    }
    this.x = bool;
  }
  
  public void A2(int paramInt)
  {
    Object localObject;
    if ((paramInt != 0) && (paramInt != 1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid orientation:");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    g(null);
    if ((paramInt != this.s) || (this.u == null))
    {
      localObject = m.b(this, paramInt);
      this.u = ((m)localObject);
      this.E.a = ((m)localObject);
      this.s = paramInt;
      t1();
    }
  }
  
  public void B2(boolean paramBoolean)
  {
    g(null);
    if (paramBoolean == this.w) {
      return;
    }
    this.w = paramBoolean;
    t1();
  }
  
  public View C(int paramInt)
  {
    int i = J();
    if (i == 0) {
      return null;
    }
    int j = paramInt - h0(I(0));
    if ((j >= 0) && (j < i))
    {
      View localView = I(j);
      if (h0(localView) == paramInt) {
        return localView;
      }
    }
    return super.C(paramInt);
  }
  
  public void C2(boolean paramBoolean)
  {
    g(null);
    if (this.y == paramBoolean) {
      return;
    }
    this.y = paramBoolean;
    t1();
  }
  
  public RecyclerView.LayoutParams D()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  boolean G1()
  {
    return (X() != 1073741824) && (p0() != 1073741824) && (q0());
  }
  
  public void I0(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    super.I0(paramRecyclerView, paramv);
    if (this.C)
    {
      k1(paramv);
      paramv.c();
    }
  }
  
  public void I1(RecyclerView paramRecyclerView, RecyclerView.z paramz, int paramInt)
  {
    paramRecyclerView = new j(paramRecyclerView.getContext());
    paramRecyclerView.p(paramInt);
    J1(paramRecyclerView);
  }
  
  public View J0(View paramView, int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
  {
    x2();
    if (J() == 0) {
      return null;
    }
    paramInt = R1(paramInt);
    if (paramInt == -2147483648) {
      return null;
    }
    T1();
    G2(paramInt, (int)(this.u.n() * 0.3333333F), false, paramz);
    paramView = this.t;
    paramView.g = -2147483648;
    paramView.a = false;
    U1(paramv, paramView, paramz, true);
    if (paramInt == -1) {
      paramView = e2();
    } else {
      paramView = d2();
    }
    if (paramInt == -1) {
      paramv = j2();
    } else {
      paramv = i2();
    }
    if (paramv.hasFocusable())
    {
      if (paramView == null) {
        return null;
      }
      return paramv;
    }
    return paramView;
  }
  
  public void K0(AccessibilityEvent paramAccessibilityEvent)
  {
    super.K0(paramAccessibilityEvent);
    if (J() > 0)
    {
      paramAccessibilityEvent.setFromIndex(Y1());
      paramAccessibilityEvent.setToIndex(a2());
    }
  }
  
  public boolean L1()
  {
    return (this.D == null) && (this.v == this.y);
  }
  
  protected void M1(RecyclerView.z paramz, int[] paramArrayOfInt)
  {
    int i = k2(paramz);
    int j;
    int k;
    if (this.t.f == -1)
    {
      j = 0;
      k = i;
    }
    else
    {
      k = 0;
      j = i;
    }
    paramArrayOfInt[0] = k;
    paramArrayOfInt[1] = j;
  }
  
  void N1(RecyclerView.z paramz, c paramc, RecyclerView.p.c paramc1)
  {
    int i = paramc.d;
    if ((i >= 0) && (i < paramz.b())) {
      paramc1.a(i, Math.max(0, paramc.g));
    }
  }
  
  int R1(int paramInt)
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
              if (this.s == 1) {
                return 1;
              }
              return -2147483648;
            }
            if (this.s == 0) {
              return 1;
            }
            return -2147483648;
          }
          if (this.s == 1) {
            return -1;
          }
          return -2147483648;
        }
        if (this.s == 0) {
          return -1;
        }
        return -2147483648;
      }
      if (this.s == 1) {
        return 1;
      }
      if (n2()) {
        return -1;
      }
      return 1;
    }
    if (this.s == 1) {
      return -1;
    }
    if (n2()) {
      return 1;
    }
    return -1;
  }
  
  c S1()
  {
    return new c();
  }
  
  void T1()
  {
    if (this.t == null) {
      this.t = S1();
    }
  }
  
  int U1(RecyclerView.v paramv, c paramc, RecyclerView.z paramz, boolean paramBoolean)
  {
    int k = paramc.c;
    int i = paramc.g;
    if (i != -2147483648)
    {
      if (k < 0) {
        paramc.g = (i + k);
      }
      s2(paramv, paramc);
    }
    int j = paramc.c + paramc.h;
    b localb = this.F;
    do
    {
      do
      {
        if (((!paramc.m) && (j <= 0)) || (!paramc.c(paramz))) {
          break;
        }
        localb.a();
        p2(paramv, paramz, paramc, localb);
        if (localb.b) {
          break;
        }
        paramc.b += localb.a * paramc.f;
        int m;
        if ((localb.c) && (paramc.l == null))
        {
          i = j;
          if (paramz.e()) {}
        }
        else
        {
          i = paramc.c;
          m = localb.a;
          paramc.c = (i - m);
          i = j - m;
        }
        j = paramc.g;
        if (j != -2147483648)
        {
          j += localb.a;
          paramc.g = j;
          m = paramc.c;
          if (m < 0) {
            paramc.g = (j + m);
          }
          s2(paramv, paramc);
        }
        j = i;
      } while (!paramBoolean);
      j = i;
    } while (!localb.d);
    return k - paramc.c;
  }
  
  View W1(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (this.x) {
      i = 0;
    }
    for (int j = J();; j = -1)
    {
      return c2(i, j, paramBoolean1, paramBoolean2);
      i = J() - 1;
    }
  }
  
  public void X0(RecyclerView.v paramv, RecyclerView.z paramz)
  {
    Object localObject = this.D;
    int k = -1;
    if (((localObject != null) || (this.A != -1)) && (paramz.b() == 0))
    {
      k1(paramv);
      return;
    }
    localObject = this.D;
    if ((localObject != null) && (((SavedState)localObject).g())) {
      this.A = this.D.a;
    }
    T1();
    this.t.a = false;
    x2();
    localObject = V();
    a locala = this.E;
    if ((locala.e) && (this.A == -1) && (this.D == null))
    {
      if ((localObject != null) && ((this.u.g((View)localObject) >= this.u.i()) || (this.u.d((View)localObject) <= this.u.m()))) {
        this.E.c((View)localObject, h0((View)localObject));
      }
    }
    else
    {
      locala.e();
      localObject = this.E;
      ((a)localObject).d = (this.x ^ this.y);
      F2(paramv, paramz, (a)localObject);
      this.E.e = true;
    }
    localObject = this.t;
    if (((c)localObject).k >= 0) {
      i = 1;
    } else {
      i = -1;
    }
    ((c)localObject).f = i;
    localObject = this.H;
    localObject[0] = 0;
    localObject[1] = 0;
    M1(paramz, (int[])localObject);
    int m = Math.max(0, this.H[0]) + this.u.m();
    int n = Math.max(0, this.H[1]) + this.u.j();
    int i = m;
    int j = n;
    int i1;
    if (paramz.e())
    {
      i1 = this.A;
      i = m;
      j = n;
      if (i1 != -1)
      {
        i = m;
        j = n;
        if (this.B != -2147483648)
        {
          localObject = C(i1);
          i = m;
          j = n;
          if (localObject != null)
          {
            if (this.x)
            {
              j = this.u.i() - this.u.d((View)localObject);
              i = this.B;
            }
            else
            {
              i = this.u.g((View)localObject) - this.u.m();
              j = this.B;
            }
            i = j - i;
            if (i > 0)
            {
              i = m + i;
              j = n;
            }
            else
            {
              j = n - i;
              i = m;
            }
          }
        }
      }
    }
    localObject = this.E;
    if (((a)localObject).d)
    {
      if (!this.x) {}
    }
    else {
      while (!this.x)
      {
        k = 1;
        break;
      }
    }
    r2(paramv, paramz, (a)localObject, k);
    w(paramv);
    this.t.m = w2();
    this.t.j = paramz.e();
    this.t.i = 0;
    localObject = this.E;
    if (((a)localObject).d)
    {
      K2((a)localObject);
      localObject = this.t;
      ((c)localObject).h = i;
      U1(paramv, (c)localObject, paramz, false);
      localObject = this.t;
      k = ((c)localObject).b;
      n = ((c)localObject).d;
      m = ((c)localObject).c;
      i = j;
      if (m > 0) {
        i = j + m;
      }
      I2(this.E);
      localObject = this.t;
      ((c)localObject).h = i;
      ((c)localObject).d += ((c)localObject).e;
      U1(paramv, (c)localObject, paramz, false);
      localObject = this.t;
      m = ((c)localObject).b;
      i1 = ((c)localObject).c;
      j = k;
      i = m;
      if (i1 > 0)
      {
        J2(n, k);
        localObject = this.t;
        ((c)localObject).h = i1;
        U1(paramv, (c)localObject, paramz, false);
        j = this.t.b;
        i = m;
      }
    }
    else
    {
      I2((a)localObject);
      localObject = this.t;
      ((c)localObject).h = j;
      U1(paramv, (c)localObject, paramz, false);
      localObject = this.t;
      k = ((c)localObject).b;
      n = ((c)localObject).d;
      m = ((c)localObject).c;
      j = i;
      if (m > 0) {
        j = i + m;
      }
      K2(this.E);
      localObject = this.t;
      ((c)localObject).h = j;
      ((c)localObject).d += ((c)localObject).e;
      U1(paramv, (c)localObject, paramz, false);
      localObject = this.t;
      m = ((c)localObject).b;
      i1 = ((c)localObject).c;
      j = m;
      i = k;
      if (i1 > 0)
      {
        H2(n, k);
        localObject = this.t;
        ((c)localObject).h = i1;
        U1(paramv, (c)localObject, paramz, false);
        i = this.t.b;
        j = m;
      }
    }
    m = j;
    k = i;
    if (J() > 0)
    {
      if ((this.x ^ this.y))
      {
        m = g2(i, paramv, paramz, true);
        k = j + m;
        j = i + m;
        i = h2(k, paramv, paramz, false);
      }
      else
      {
        m = h2(j, paramv, paramz, true);
        k = j + m;
        j = i + m;
        i = g2(j, paramv, paramz, false);
      }
      m = k + i;
      k = j + i;
    }
    q2(paramv, paramz, m, k);
    if (!paramz.e()) {
      this.u.s();
    } else {
      this.E.e();
    }
    this.v = this.y;
  }
  
  View X1(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (this.x) {
      i = J() - 1;
    }
    for (int j = -1;; j = J())
    {
      return c2(i, j, paramBoolean1, paramBoolean2);
      i = 0;
    }
  }
  
  public void Y0(RecyclerView.z paramz)
  {
    super.Y0(paramz);
    this.D = null;
    this.A = -1;
    this.B = -2147483648;
    this.E.e();
  }
  
  public int Y1()
  {
    View localView = c2(0, J(), false, true);
    if (localView == null) {
      return -1;
    }
    return h0(localView);
  }
  
  public PointF a(int paramInt)
  {
    if (J() == 0) {
      return null;
    }
    int k = 0;
    int j = h0(I(0));
    int i = 1;
    if (paramInt < j) {
      k = 1;
    }
    paramInt = i;
    if (k != this.x) {
      paramInt = -1;
    }
    if (this.s == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  public int a2()
  {
    View localView = c2(J() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return h0(localView);
  }
  
  View b2(int paramInt1, int paramInt2)
  {
    T1();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else if (paramInt2 < paramInt1) {
      i = -1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return I(paramInt1);
    }
    int j;
    if (this.u.g(I(paramInt1)) < this.u.m())
    {
      i = 16644;
      j = 16388;
    }
    else
    {
      i = 4161;
      j = 4097;
    }
    t localt;
    if (this.s == 0) {
      localt = this.e;
    } else {
      localt = this.f;
    }
    return localt.a(paramInt1, paramInt2, i, j);
  }
  
  public void c1(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      paramParcelable = (SavedState)paramParcelable;
      this.D = paramParcelable;
      if (this.A != -1) {
        paramParcelable.h();
      }
      t1();
    }
  }
  
  View c2(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    T1();
    int j = 320;
    int i;
    if (paramBoolean1) {
      i = 24579;
    } else {
      i = 320;
    }
    if (!paramBoolean2) {
      j = 0;
    }
    t localt;
    if (this.s == 0) {
      localt = this.e;
    } else {
      localt = this.f;
    }
    return localt.a(paramInt1, paramInt2, i, j);
  }
  
  public Parcelable d1()
  {
    if (this.D != null) {
      return new SavedState(this.D);
    }
    SavedState localSavedState = new SavedState();
    if (J() > 0)
    {
      T1();
      boolean bool = this.v ^ this.x;
      localSavedState.c = bool;
      if (bool)
      {
        localView = i2();
        localSavedState.b = (this.u.i() - this.u.d(localView));
        localSavedState.a = h0(localView);
        return localSavedState;
      }
      View localView = j2();
      localSavedState.a = h0(localView);
      localSavedState.b = (this.u.g(localView) - this.u.m());
      return localSavedState;
    }
    localSavedState.h();
    return localSavedState;
  }
  
  View f2(RecyclerView.v paramv, RecyclerView.z paramz, boolean paramBoolean1, boolean paramBoolean2)
  {
    T1();
    int i = J();
    int j = -1;
    int k;
    if (paramBoolean2)
    {
      i = J() - 1;
      k = -1;
    }
    else
    {
      j = i;
      i = 0;
      k = 1;
    }
    int i1 = paramz.b();
    int i2 = this.u.m();
    int i3 = this.u.i();
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject5;
    for (paramz = localObject1; i != j; paramz = (RecyclerView.z)localObject5)
    {
      paramv = I(i);
      int m = h0(paramv);
      int n = this.u.g(paramv);
      int i4 = this.u.d(paramv);
      Object localObject3 = localObject2;
      Object localObject4 = localObject1;
      localObject5 = paramz;
      if (m >= 0)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        localObject5 = paramz;
        if (m < i1) {
          if (((RecyclerView.LayoutParams)paramv.getLayoutParams()).c())
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            localObject5 = paramz;
            if (paramz == null)
            {
              localObject3 = localObject2;
              localObject4 = localObject1;
              localObject5 = paramv;
            }
          }
          else
          {
            if ((i4 <= i2) && (n < i2)) {
              m = 1;
            } else {
              m = 0;
            }
            if ((n >= i3) && (i4 > i3)) {
              n = 1;
            } else {
              n = 0;
            }
            if ((m == 0) && (n == 0)) {
              return paramv;
            }
            if (paramBoolean1)
            {
              if (n == 0)
              {
                localObject3 = localObject2;
                localObject4 = localObject1;
                localObject5 = paramz;
                if (localObject2 != null) {
                  break label328;
                }
                break label318;
              }
            }
            else {
              if (m == 0) {
                break label302;
              }
            }
            localObject3 = localObject2;
            localObject4 = paramv;
            localObject5 = paramz;
            break label328;
            label302:
            localObject3 = localObject2;
            localObject4 = localObject1;
            localObject5 = paramz;
            if (localObject2 == null)
            {
              label318:
              localObject5 = paramz;
              localObject4 = localObject1;
              localObject3 = paramv;
            }
          }
        }
      }
      label328:
      i += k;
      localObject2 = localObject3;
      localObject1 = localObject4;
    }
    if (localObject2 != null) {
      return localObject2;
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return paramz;
  }
  
  public void g(String paramString)
  {
    if (this.D == null) {
      super.g(paramString);
    }
  }
  
  public boolean k()
  {
    return this.s == 0;
  }
  
  @Deprecated
  protected int k2(RecyclerView.z paramz)
  {
    if (paramz.d()) {
      return this.u.n();
    }
    return 0;
  }
  
  public boolean l()
  {
    return this.s == 1;
  }
  
  public int l2()
  {
    return this.s;
  }
  
  public boolean m2()
  {
    return this.y;
  }
  
  protected boolean n2()
  {
    return Z() == 1;
  }
  
  public void o(int paramInt1, int paramInt2, RecyclerView.z paramz, RecyclerView.p.c paramc)
  {
    if (this.s != 0) {
      paramInt1 = paramInt2;
    }
    if (J() != 0)
    {
      if (paramInt1 == 0) {
        return;
      }
      T1();
      if (paramInt1 > 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = -1;
      }
      G2(paramInt2, Math.abs(paramInt1), true, paramz);
      N1(paramz, this.t, paramc);
    }
  }
  
  public boolean o2()
  {
    return this.z;
  }
  
  public void p(int paramInt, RecyclerView.p.c paramc)
  {
    SavedState localSavedState = this.D;
    int j = -1;
    boolean bool1;
    int i;
    if ((localSavedState != null) && (localSavedState.g()))
    {
      localSavedState = this.D;
      bool1 = localSavedState.c;
      i = localSavedState.a;
    }
    else
    {
      x2();
      boolean bool2 = this.x;
      k = this.A;
      i = k;
      bool1 = bool2;
      if (k == -1) {
        if (bool2)
        {
          i = paramInt - 1;
          bool1 = bool2;
        }
        else
        {
          i = 0;
          bool1 = bool2;
        }
      }
    }
    if (!bool1) {
      j = 1;
    }
    int k = 0;
    while ((k < this.G) && (i >= 0) && (i < paramInt))
    {
      paramc.a(i, 0);
      i += j;
      k += 1;
    }
  }
  
  void p2(RecyclerView.v paramv, RecyclerView.z paramz, c paramc, b paramb)
  {
    paramv = paramc.d(paramv);
    if (paramv == null)
    {
      paramb.b = true;
      return;
    }
    paramz = (RecyclerView.LayoutParams)paramv.getLayoutParams();
    boolean bool2;
    boolean bool1;
    if (paramc.l == null)
    {
      bool2 = this.x;
      if (paramc.f == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool2 == bool1) {
        d(paramv);
      } else {
        e(paramv, 0);
      }
    }
    else
    {
      bool2 = this.x;
      if (paramc.f == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool2 == bool1) {
        b(paramv);
      } else {
        c(paramv, 0);
      }
    }
    A0(paramv, 0, 0);
    paramb.a = this.u.e(paramv);
    int i;
    int j;
    int m;
    int k;
    int n;
    int i1;
    if (this.s == 1)
    {
      if (n2())
      {
        i = o0() - f0();
        j = i - this.u.f(paramv);
      }
      else
      {
        j = e0();
        i = this.u.f(paramv) + j;
      }
      m = paramc.f;
      k = paramc.b;
      if (m == -1)
      {
        m = paramb.a;
        n = k;
        i1 = i;
        i = k - m;
        m = j;
        j = i1;
        k = n;
      }
      else
      {
        m = paramb.a;
        n = k;
        i1 = i;
        k = m + k;
        m = j;
        i = n;
        j = i1;
      }
    }
    else
    {
      m = g0();
      j = this.u.f(paramv) + m;
      k = paramc.f;
      i = paramc.b;
      if (k == -1)
      {
        int i2 = paramb.a;
        k = i;
        i1 = m;
        n = j;
        m = i - i2;
        i = i1;
        j = k;
        k = n;
      }
      else
      {
        k = paramb.a;
        i1 = k + i;
        n = i;
        k = j;
        j = i1;
        i = m;
        m = n;
      }
    }
    z0(paramv, m, i, j, k);
    if ((paramz.c()) || (paramz.b())) {
      paramb.c = true;
    }
    paramb.d = paramv.hasFocusable();
  }
  
  public int q(RecyclerView.z paramz)
  {
    return O1(paramz);
  }
  
  public int r(RecyclerView.z paramz)
  {
    return P1(paramz);
  }
  
  void r2(RecyclerView.v paramv, RecyclerView.z paramz, a parama, int paramInt) {}
  
  public int s(RecyclerView.z paramz)
  {
    return Q1(paramz);
  }
  
  public boolean s0()
  {
    return true;
  }
  
  public int t(RecyclerView.z paramz)
  {
    return O1(paramz);
  }
  
  public int u(RecyclerView.z paramz)
  {
    return P1(paramz);
  }
  
  public int v(RecyclerView.z paramz)
  {
    return Q1(paramz);
  }
  
  public int w1(int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
  {
    if (this.s == 1) {
      return 0;
    }
    return y2(paramInt, paramv, paramz);
  }
  
  boolean w2()
  {
    return (this.u.k() == 0) && (this.u.h() == 0);
  }
  
  public void x1(int paramInt)
  {
    this.A = paramInt;
    this.B = -2147483648;
    SavedState localSavedState = this.D;
    if (localSavedState != null) {
      localSavedState.h();
    }
    t1();
  }
  
  public int y1(int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
  {
    if (this.s == 0) {
      return 0;
    }
    return y2(paramInt, paramv, paramz);
  }
  
  int y2(int paramInt, RecyclerView.v paramv, RecyclerView.z paramz)
  {
    if (J() != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      T1();
      this.t.a = true;
      int i;
      if (paramInt > 0) {
        i = 1;
      } else {
        i = -1;
      }
      int j = Math.abs(paramInt);
      G2(i, j, true, paramz);
      c localc = this.t;
      int k = localc.g + U1(paramv, localc, paramz, false);
      if (k < 0) {
        return 0;
      }
      if (j > k) {
        paramInt = i * k;
      }
      this.u.r(-paramInt);
      this.t.k = paramInt;
      return paramInt;
    }
    return 0;
  }
  
  public void z2(int paramInt1, int paramInt2)
  {
    this.A = paramInt1;
    this.B = paramInt2;
    SavedState localSavedState = this.D;
    if (localSavedState != null) {
      localSavedState.h();
    }
    t1();
  }
  
  @SuppressLint({"BanParcelableUsage"})
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    int a;
    int b;
    boolean c;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.c = bool;
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.a = paramSavedState.a;
      this.b = paramSavedState.b;
      this.c = paramSavedState.c;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    boolean g()
    {
      return this.a >= 0;
    }
    
    void h()
    {
      this.a = -1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    class a
      implements Parcelable.Creator<LinearLayoutManager.SavedState>
    {
      public LinearLayoutManager.SavedState a(Parcel paramParcel)
      {
        return new LinearLayoutManager.SavedState(paramParcel);
      }
      
      public LinearLayoutManager.SavedState[] b(int paramInt)
      {
        return new LinearLayoutManager.SavedState[paramInt];
      }
    }
  }
  
  static class a
  {
    m a;
    int b;
    int c;
    boolean d;
    boolean e;
    
    a()
    {
      e();
    }
    
    void a()
    {
      int i;
      if (this.d) {
        i = this.a.i();
      } else {
        i = this.a.m();
      }
      this.c = i;
    }
    
    public void b(View paramView, int paramInt)
    {
      int i;
      if (this.d) {
        i = this.a.d(paramView) + this.a.o();
      } else {
        i = this.a.g(paramView);
      }
      this.c = i;
      this.b = paramInt;
    }
    
    public void c(View paramView, int paramInt)
    {
      int i = this.a.o();
      if (i >= 0)
      {
        b(paramView, paramInt);
        return;
      }
      this.b = paramInt;
      int j;
      int k;
      if (this.d)
      {
        paramInt = this.a.i() - i - this.a.d(paramView);
        this.c = (this.a.i() - paramInt);
        if (paramInt > 0)
        {
          i = this.a.e(paramView);
          j = this.c;
          k = this.a.m();
          i = j - i - (k + Math.min(this.a.g(paramView) - k, 0));
          if (i < 0) {
            this.c += Math.min(paramInt, -i);
          }
        }
      }
      else
      {
        j = this.a.g(paramView);
        paramInt = j - this.a.m();
        this.c = j;
        if (paramInt > 0)
        {
          k = this.a.e(paramView);
          int m = this.a.i();
          int n = this.a.d(paramView);
          i = this.a.i() - Math.min(0, m - i - n) - (j + k);
          if (i < 0) {
            this.c -= Math.min(paramInt, -i);
          }
        }
      }
    }
    
    boolean d(View paramView, RecyclerView.z paramz)
    {
      paramView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return (!paramView.c()) && (paramView.a() >= 0) && (paramView.a() < paramz.b());
    }
    
    void e()
    {
      this.b = -1;
      this.c = -2147483648;
      this.d = false;
      this.e = false;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AnchorInfo{mPosition=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", mCoordinate=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", mLayoutFromEnd=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", mValid=");
      localStringBuilder.append(this.e);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  protected static class b
  {
    public int a;
    public boolean b;
    public boolean c;
    public boolean d;
    
    void a()
    {
      this.a = 0;
      this.b = false;
      this.c = false;
      this.d = false;
    }
  }
  
  static class c
  {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h = 0;
    int i = 0;
    boolean j = false;
    int k;
    List<RecyclerView.c0> l = null;
    boolean m;
    
    private View e()
    {
      int i1 = this.l.size();
      int n = 0;
      while (n < i1)
      {
        View localView = ((RecyclerView.c0)this.l.get(n)).a;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((!localLayoutParams.c()) && (this.d == localLayoutParams.a()))
        {
          b(localView);
          return localView;
        }
        n += 1;
      }
      return null;
    }
    
    public void a()
    {
      b(null);
    }
    
    public void b(View paramView)
    {
      paramView = f(paramView);
      int n;
      if (paramView == null) {
        n = -1;
      } else {
        n = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).a();
      }
      this.d = n;
    }
    
    boolean c(RecyclerView.z paramz)
    {
      int n = this.d;
      return (n >= 0) && (n < paramz.b());
    }
    
    View d(RecyclerView.v paramv)
    {
      if (this.l != null) {
        return e();
      }
      paramv = paramv.o(this.d);
      this.d += this.e;
      return paramv;
    }
    
    public View f(View paramView)
    {
      int i4 = this.l.size();
      Object localObject1 = null;
      int i1 = 2147483647;
      int n = 0;
      while (n < i4)
      {
        View localView = ((RecyclerView.c0)this.l.get(n)).a;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        Object localObject2 = localObject1;
        int i2 = i1;
        if (localView != paramView) {
          if (localLayoutParams.c())
          {
            localObject2 = localObject1;
            i2 = i1;
          }
          else
          {
            int i3 = (localLayoutParams.a() - this.d) * this.e;
            if (i3 < 0)
            {
              localObject2 = localObject1;
              i2 = i1;
            }
            else
            {
              localObject2 = localObject1;
              i2 = i1;
              if (i3 < i1)
              {
                localObject2 = localView;
                if (i3 == 0) {
                  return localObject2;
                }
                i2 = i3;
              }
            }
          }
        }
        n += 1;
        localObject1 = localObject2;
        i1 = i2;
      }
      return localObject1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */