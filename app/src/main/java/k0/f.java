package k0;

import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import l0.b.a;
import l0.b.b;

public class f
  extends n
{
  l0.b W0 = new l0.b(this);
  public l0.e X0 = new l0.e(this);
  private int Y0;
  protected b.b Z0 = null;
  private boolean a1 = false;
  protected h0.d b1 = new h0.d();
  int c1;
  int d1;
  int e1;
  int f1;
  public int g1 = 0;
  public int h1 = 0;
  c[] i1 = new c[4];
  c[] j1 = new c[4];
  public boolean k1 = false;
  public boolean l1 = false;
  public boolean m1 = false;
  public int n1 = 0;
  public int o1 = 0;
  private int p1 = 257;
  public boolean q1 = false;
  private boolean r1 = false;
  private boolean s1 = false;
  int t1 = 0;
  private WeakReference<d> u1 = null;
  private WeakReference<d> v1 = null;
  private WeakReference<d> w1 = null;
  private WeakReference<d> x1 = null;
  HashSet<e> y1 = new HashSet();
  public b.a z1 = new b.a();
  
  private void B1(e parame)
  {
    int i = this.g1;
    c[] arrayOfc = this.j1;
    if (i + 1 >= arrayOfc.length) {
      this.j1 = ((c[])Arrays.copyOf(arrayOfc, arrayOfc.length * 2));
    }
    this.j1[this.g1] = new c(parame, 0, T1());
    this.g1 += 1;
  }
  
  private void E1(d paramd, h0.i parami)
  {
    paramd = this.b1.q(paramd);
    this.b1.h(parami, paramd, 0, 5);
  }
  
  private void F1(d paramd, h0.i parami)
  {
    paramd = this.b1.q(paramd);
    this.b1.h(paramd, parami, 0, 5);
  }
  
  private void G1(e parame)
  {
    int i = this.h1;
    c[] arrayOfc = this.i1;
    if (i + 1 >= arrayOfc.length) {
      this.i1 = ((c[])Arrays.copyOf(arrayOfc, arrayOfc.length * 2));
    }
    this.i1[this.h1] = new c(parame, 1, T1());
    this.h1 += 1;
  }
  
  public static boolean W1(int paramInt1, e parame, b.b paramb, b.a parama, int paramInt2)
  {
    if (paramb == null) {
      return false;
    }
    if ((parame.X() != 8) && (!(parame instanceof h)) && (!(parame instanceof a)))
    {
      parama.a = parame.C();
      parama.b = parame.V();
      parama.c = parame.Y();
      parama.d = parame.z();
      parama.i = false;
      parama.j = paramInt2;
      e.b localb1 = parama.a;
      e.b localb2 = e.b.c;
      if (localb1 == localb2) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (parama.b == localb2) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      int k;
      if ((paramInt1 != 0) && (parame.f0 > 0.0F)) {
        k = 1;
      } else {
        k = 0;
      }
      int j;
      if ((paramInt2 != 0) && (parame.f0 > 0.0F)) {
        j = 1;
      } else {
        j = 0;
      }
      int i = paramInt1;
      if (paramInt1 != 0)
      {
        i = paramInt1;
        if (parame.c0(0))
        {
          i = paramInt1;
          if (parame.w == 0)
          {
            i = paramInt1;
            if (k == 0)
            {
              parama.a = e.b.b;
              if ((paramInt2 != 0) && (parame.x == 0)) {
                parama.a = e.b.a;
              }
              i = 0;
            }
          }
        }
      }
      paramInt1 = paramInt2;
      if (paramInt2 != 0)
      {
        paramInt1 = paramInt2;
        if (parame.c0(1))
        {
          paramInt1 = paramInt2;
          if (parame.x == 0)
          {
            paramInt1 = paramInt2;
            if (j == 0)
            {
              parama.b = e.b.b;
              if ((i != 0) && (parame.w == 0)) {
                parama.b = e.b.a;
              }
              paramInt1 = 0;
            }
          }
        }
      }
      if (parame.p0())
      {
        parama.a = e.b.a;
        i = 0;
      }
      if (parame.q0())
      {
        parama.b = e.b.a;
        paramInt1 = 0;
      }
      if (k != 0) {
        if (parame.y[0] == 4)
        {
          parama.a = e.b.a;
        }
        else if (paramInt1 == 0)
        {
          localb1 = parama.b;
          localb2 = e.b.a;
          if (localb1 == localb2)
          {
            paramInt1 = parama.d;
          }
          else
          {
            parama.a = e.b.b;
            paramb.b(parame, parama);
            paramInt1 = parama.f;
          }
          parama.a = localb2;
          parama.c = ((int)(parame.x() * paramInt1));
        }
      }
      if (j != 0) {
        if (parame.y[1] == 4)
        {
          parama.b = e.b.a;
        }
        else if (i == 0)
        {
          localb1 = parama.a;
          localb2 = e.b.a;
          if (localb1 == localb2)
          {
            paramInt1 = parama.c;
          }
          else
          {
            parama.b = e.b.b;
            paramb.b(parame, parama);
            paramInt1 = parama.e;
          }
          parama.b = localb2;
          if (parame.y() == -1) {
            paramInt1 = (int)(paramInt1 / parame.x());
          } else {
            paramInt1 = (int)(parame.x() * paramInt1);
          }
          parama.d = paramInt1;
        }
      }
      paramb.b(parame, parama);
      parame.o1(parama.e);
      parame.P0(parama.f);
      parame.O0(parama.h);
      parame.E0(parama.g);
      parama.j = b.a.k;
      return parama.i;
    }
    parama.e = 0;
    parama.f = 0;
    return false;
  }
  
  private void Y1()
  {
    this.g1 = 0;
    this.h1 = 0;
  }
  
  public boolean A1(h0.d paramd)
  {
    boolean bool = X1(64);
    g(paramd, bool);
    int k = this.V0.size();
    int i = 0;
    int j = i;
    Object localObject1;
    while (i < k)
    {
      localObject1 = (e)this.V0.get(i);
      ((e)localObject1).W0(0, false);
      ((e)localObject1).W0(1, false);
      if ((localObject1 instanceof a)) {
        j = 1;
      }
      i += 1;
    }
    if (j != 0)
    {
      i = 0;
      while (i < k)
      {
        localObject1 = (e)this.V0.get(i);
        if ((localObject1 instanceof a)) {
          ((a)localObject1).C1();
        }
        i += 1;
      }
    }
    this.y1.clear();
    i = 0;
    while (i < k)
    {
      localObject1 = (e)this.V0.get(i);
      if (((e)localObject1).f()) {
        if ((localObject1 instanceof m)) {
          this.y1.add(localObject1);
        } else {
          ((e)localObject1).g(paramd, bool);
        }
      }
      i += 1;
    }
    Object localObject2;
    while (this.y1.size() > 0)
    {
      i = this.y1.size();
      localObject1 = this.y1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (m)((Iterator)localObject1).next();
        if (((m)localObject2).z1(this.y1))
        {
          ((e)localObject2).g(paramd, bool);
          this.y1.remove(localObject2);
        }
      }
      if (i == this.y1.size())
      {
        localObject1 = this.y1.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((e)((Iterator)localObject1).next()).g(paramd, bool);
        }
        this.y1.clear();
      }
    }
    if (h0.d.r)
    {
      localObject1 = new HashSet();
      i = 0;
      while (i < k)
      {
        localObject2 = (e)this.V0.get(i);
        if (!((e)localObject2).f()) {
          ((HashSet)localObject1).add(localObject2);
        }
        i += 1;
      }
      if (C() == e.b.b) {
        i = 0;
      } else {
        i = 1;
      }
      e(this, paramd, (HashSet)localObject1, i, false);
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        k.a(this, paramd, (e)localObject2);
        ((e)localObject2).g(paramd, bool);
      }
    }
    i = 0;
    while (i < k)
    {
      localObject1 = (e)this.V0.get(i);
      if ((localObject1 instanceof f))
      {
        Object localObject3 = ((e)localObject1).b0;
        localObject2 = localObject3[0];
        localObject3 = localObject3[1];
        e.b localb = e.b.b;
        if (localObject2 == localb) {
          ((e)localObject1).T0(e.b.a);
        }
        if (localObject3 == localb) {
          ((e)localObject1).k1(e.b.a);
        }
        ((e)localObject1).g(paramd, bool);
        if (localObject2 == localb) {
          ((e)localObject1).T0((e.b)localObject2);
        }
        if (localObject3 == localb) {
          ((e)localObject1).k1((e.b)localObject3);
        }
      }
      else
      {
        k.a(this, paramd, (e)localObject1);
        if (!((e)localObject1).f()) {
          ((e)localObject1).g(paramd, bool);
        }
      }
      i += 1;
    }
    if (this.g1 > 0) {
      b.b(this, paramd, null, 0);
    }
    if (this.h1 > 0) {
      b.b(this, paramd, null, 1);
    }
    return true;
  }
  
  public void C1(d paramd)
  {
    WeakReference localWeakReference = this.x1;
    if ((localWeakReference == null) || (localWeakReference.get() == null) || (paramd.e() > ((d)this.x1.get()).e())) {
      this.x1 = new WeakReference(paramd);
    }
  }
  
  public void D1(d paramd)
  {
    WeakReference localWeakReference = this.v1;
    if ((localWeakReference == null) || (localWeakReference.get() == null) || (paramd.e() > ((d)this.v1.get()).e())) {
      this.v1 = new WeakReference(paramd);
    }
  }
  
  void H1(d paramd)
  {
    WeakReference localWeakReference = this.w1;
    if ((localWeakReference == null) || (localWeakReference.get() == null) || (paramd.e() > ((d)this.w1.get()).e())) {
      this.w1 = new WeakReference(paramd);
    }
  }
  
  void I1(d paramd)
  {
    WeakReference localWeakReference = this.u1;
    if ((localWeakReference == null) || (localWeakReference.get() == null) || (paramd.e() > ((d)this.u1.get()).e())) {
      this.u1 = new WeakReference(paramd);
    }
  }
  
  public boolean J1(boolean paramBoolean)
  {
    return this.X0.f(paramBoolean);
  }
  
  public boolean K1(boolean paramBoolean)
  {
    return this.X0.g(paramBoolean);
  }
  
  public boolean L1(boolean paramBoolean, int paramInt)
  {
    return this.X0.h(paramBoolean, paramInt);
  }
  
  public b.b M1()
  {
    return this.Z0;
  }
  
  public int N1()
  {
    return this.p1;
  }
  
  public h0.d O1()
  {
    return this.b1;
  }
  
  public boolean P1()
  {
    return false;
  }
  
  public void Q(StringBuilder paramStringBuilder)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.o);
    ((StringBuilder)localObject).append(":{\n");
    paramStringBuilder.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("  actualWidth:");
    ((StringBuilder)localObject).append(this.d0);
    paramStringBuilder.append(((StringBuilder)localObject).toString());
    paramStringBuilder.append("\n");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("  actualHeight:");
    ((StringBuilder)localObject).append(this.e0);
    paramStringBuilder.append(((StringBuilder)localObject).toString());
    paramStringBuilder.append("\n");
    localObject = v1().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ((e)((Iterator)localObject).next()).Q(paramStringBuilder);
      paramStringBuilder.append(",\n");
    }
    paramStringBuilder.append("}");
  }
  
  public void Q1()
  {
    this.X0.j();
  }
  
  public void R1()
  {
    this.X0.k();
  }
  
  public boolean S1()
  {
    return this.s1;
  }
  
  public boolean T1()
  {
    return this.a1;
  }
  
  public boolean U1()
  {
    return this.r1;
  }
  
  public long V1(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.c1 = paramInt8;
    this.d1 = paramInt9;
    return this.W0.d(this, paramInt1, paramInt8, paramInt9, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public boolean X1(int paramInt)
  {
    return (this.p1 & paramInt) == paramInt;
  }
  
  public void Z1(b.b paramb)
  {
    this.Z0 = paramb;
    this.X0.n(paramb);
  }
  
  public void a2(int paramInt)
  {
    this.p1 = paramInt;
    h0.d.r = X1(512);
  }
  
  public void b2(int paramInt)
  {
    this.Y0 = paramInt;
  }
  
  public void c2(boolean paramBoolean)
  {
    this.a1 = paramBoolean;
  }
  
  public boolean d2(h0.d paramd, boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    paramArrayOfBoolean[2] = false;
    boolean bool2 = X1(64);
    u1(paramd, bool2);
    int j = this.V0.size();
    boolean bool1 = false;
    while (i < j)
    {
      paramArrayOfBoolean = (e)this.V0.get(i);
      paramArrayOfBoolean.u1(paramd, bool2);
      if (paramArrayOfBoolean.e0()) {
        bool1 = true;
      }
      i += 1;
    }
    return bool1;
  }
  
  public void e2()
  {
    this.W0.e(this);
  }
  
  public void t1(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.t1(paramBoolean1, paramBoolean2);
    int j = this.V0.size();
    int i = 0;
    while (i < j)
    {
      ((e)this.V0.get(i)).t1(paramBoolean1, paramBoolean2);
      i += 1;
    }
  }
  
  public void v0()
  {
    this.b1.D();
    this.c1 = 0;
    this.e1 = 0;
    this.d1 = 0;
    this.f1 = 0;
    this.q1 = false;
    super.v0();
  }
  
  public void w1()
  {
    this.h0 = 0;
    this.i0 = 0;
    this.r1 = false;
    this.s1 = false;
    int i4 = this.V0.size();
    int j = Math.max(0, Y());
    int k = Math.max(0, z());
    Object localObject2 = this.b0;
    Object localObject1 = localObject2[1];
    localObject2 = localObject2[0];
    Object localObject7;
    if ((this.Y0 == 0) && (k.b(this.p1, 1)))
    {
      l0.h.h(this, M1());
      i = 0;
      while (i < i4)
      {
        localObject3 = (e)this.V0.get(i);
        if ((((e)localObject3).o0()) && (!(localObject3 instanceof h)) && (!(localObject3 instanceof a)) && (!(localObject3 instanceof m)) && (!((e)localObject3).n0()))
        {
          localObject4 = ((e)localObject3).w(0);
          localObject6 = ((e)localObject3).w(1);
          localObject7 = e.b.c;
          if ((localObject4 == localObject7) && (((e)localObject3).w != 1) && (localObject6 == localObject7) && (((e)localObject3).x != 1)) {
            m = 1;
          } else {
            m = 0;
          }
          if (m == 0)
          {
            localObject4 = new b.a();
            W1(0, (e)localObject3, this.Z0, (b.a)localObject4, b.a.k);
          }
        }
        i += 1;
      }
    }
    if (i4 > 2)
    {
      localObject3 = e.b.b;
      if (((localObject2 == localObject3) || (localObject1 == localObject3)) && (k.b(this.p1, 1024)) && (l0.i.c(this, M1())))
      {
        i = j;
        if (localObject2 == localObject3) {
          if ((j < Y()) && (j > 0))
          {
            o1(j);
            this.r1 = true;
            i = j;
          }
          else
          {
            i = Y();
          }
        }
        j = k;
        if (localObject1 == localObject3) {
          if ((k < z()) && (k > 0))
          {
            P0(k);
            this.s1 = true;
            j = k;
          }
          else
          {
            j = z();
          }
        }
        bool1 = true;
        break label395;
      }
    }
    int i = j;
    boolean bool1 = false;
    j = k;
    label395:
    if ((!X1(64)) && (!X1(128))) {
      k = 0;
    } else {
      k = 1;
    }
    Object localObject3 = this.b1;
    ((h0.d)localObject3).h = false;
    ((h0.d)localObject3).i = false;
    if ((this.p1 != 0) && (k != 0)) {
      ((h0.d)localObject3).i = true;
    }
    localObject3 = this.V0;
    Object localObject4 = C();
    Object localObject6 = e.b.b;
    if ((localObject4 != localObject6) && (V() != localObject6)) {
      k = 0;
    } else {
      k = 1;
    }
    Y1();
    int m = 0;
    while (m < i4)
    {
      localObject4 = (e)this.V0.get(m);
      if ((localObject4 instanceof n)) {
        ((n)localObject4).w1();
      }
      m += 1;
    }
    boolean bool7 = X1(64);
    m = 0;
    boolean bool2 = true;
    while (bool2)
    {
      int i3 = m + 1;
      boolean bool3 = bool2;
      try
      {
        this.b1.D();
        bool3 = bool2;
        Y1();
        bool3 = bool2;
        o(this.b1);
        m = 0;
        while (m < i4)
        {
          bool3 = bool2;
          ((e)this.V0.get(m)).o(this.b1);
          m += 1;
        }
        bool3 = bool2;
        bool2 = A1(this.b1);
        bool3 = bool2;
        localObject4 = this.u1;
        if (localObject4 != null)
        {
          bool3 = bool2;
          if (((WeakReference)localObject4).get() != null)
          {
            bool3 = bool2;
            F1((d)this.u1.get(), this.b1.q(this.R));
            bool3 = bool2;
            this.u1 = null;
          }
        }
        bool3 = bool2;
        localObject4 = this.w1;
        if (localObject4 != null)
        {
          bool3 = bool2;
          if (((WeakReference)localObject4).get() != null)
          {
            bool3 = bool2;
            E1((d)this.w1.get(), this.b1.q(this.T));
            bool3 = bool2;
            this.w1 = null;
          }
        }
        bool3 = bool2;
        localObject4 = this.v1;
        if (localObject4 != null)
        {
          bool3 = bool2;
          if (((WeakReference)localObject4).get() != null)
          {
            bool3 = bool2;
            F1((d)this.v1.get(), this.b1.q(this.Q));
            bool3 = bool2;
            this.v1 = null;
          }
        }
        bool3 = bool2;
        localObject4 = this.x1;
        if (localObject4 != null)
        {
          bool3 = bool2;
          if (((WeakReference)localObject4).get() != null)
          {
            bool3 = bool2;
            E1((d)this.x1.get(), this.b1.q(this.S));
            bool3 = bool2;
            this.x1 = null;
          }
        }
        bool3 = bool2;
        if (bool2)
        {
          bool3 = bool2;
          this.b1.z();
          bool3 = bool2;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject6 = System.out;
        localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append("EXCEPTION : ");
        ((StringBuilder)localObject7).append(localException);
        ((PrintStream)localObject6).println(((StringBuilder)localObject7).toString());
      }
      Object localObject5 = this.b1;
      if (bool3)
      {
        bool2 = d2((h0.d)localObject5, k.a);
      }
      else
      {
        u1((h0.d)localObject5, bool7);
        m = 0;
        while (m < i4)
        {
          ((e)this.V0.get(m)).u1(this.b1, bool7);
          m += 1;
        }
        bool2 = false;
      }
      if ((k != 0) && (i3 < 8) && (k.a[2] != 0))
      {
        int n = 0;
        m = 0;
        int i2 = 0;
        while (n < i4)
        {
          localObject5 = (e)this.V0.get(n);
          i2 = Math.max(i2, ((e)localObject5).h0 + ((e)localObject5).Y());
          m = Math.max(m, ((e)localObject5).i0 + ((e)localObject5).z());
          n += 1;
        }
        n = Math.max(this.o0, i2);
        m = Math.max(this.p0, m);
        localObject5 = e.b.b;
        bool4 = bool1;
        bool3 = bool2;
        if (localObject2 == localObject5)
        {
          bool4 = bool1;
          bool3 = bool2;
          if (Y() < n)
          {
            o1(n);
            this.b0[0] = localObject5;
            bool4 = true;
            bool3 = true;
          }
        }
        bool1 = bool4;
        bool2 = bool3;
        if (localObject1 == localObject5)
        {
          bool1 = bool4;
          bool2 = bool3;
          if (z() < m)
          {
            P0(m);
            this.b0[1] = localObject5;
            bool1 = true;
            bool2 = true;
          }
        }
      }
      m = Math.max(this.o0, Y());
      if (m > Y())
      {
        o1(m);
        this.b0[0] = e.b.a;
        bool1 = true;
        bool2 = true;
      }
      m = Math.max(this.p0, z());
      if (m > z())
      {
        P0(m);
        this.b0[1] = e.b.a;
        bool1 = true;
        bool2 = bool1;
      }
      boolean bool6 = bool1;
      boolean bool4 = bool2;
      if (!bool1)
      {
        localObject5 = this.b0[0];
        localObject6 = e.b.b;
        boolean bool5 = bool1;
        bool3 = bool2;
        if (localObject5 == localObject6)
        {
          bool5 = bool1;
          bool3 = bool2;
          if (i > 0)
          {
            bool5 = bool1;
            bool3 = bool2;
            if (Y() > i)
            {
              this.r1 = true;
              this.b0[0] = e.b.a;
              o1(i);
              bool5 = true;
              bool3 = bool5;
            }
          }
        }
        bool6 = bool5;
        bool4 = bool3;
        if (this.b0[1] == localObject6)
        {
          bool6 = bool5;
          bool4 = bool3;
          if (j > 0)
          {
            bool6 = bool5;
            bool4 = bool3;
            if (z() > j)
            {
              this.s1 = true;
              this.b0[1] = e.b.a;
              P0(j);
              bool2 = true;
              bool1 = true;
              break label1574;
            }
          }
        }
      }
      bool1 = bool6;
      bool2 = bool4;
      label1574:
      if (i3 > 8) {
        bool2 = false;
      }
      m = i3;
    }
    this.V0 = ((ArrayList)localObject3);
    if (bool1)
    {
      localObject3 = this.b0;
      localObject3[0] = localObject2;
      localObject3[1] = localObject1;
    }
    z0(this.b1.v());
  }
  
  void z1(e parame, int paramInt)
  {
    if (paramInt == 0)
    {
      B1(parame);
      return;
    }
    if (paramInt == 1) {
      G1(parame);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.f
 * JD-Core Version:    0.7.0.1
 */