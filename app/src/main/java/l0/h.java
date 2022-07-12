package l0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import k0.a;
import k0.d;
import k0.d.b;
import k0.e;
import k0.e.b;
import k0.f;
import k0.n;

public class h
{
  private static b.a a = new b.a();
  private static int b = 0;
  private static int c = 0;
  
  private static boolean a(int paramInt, e parame)
  {
    e.b localb2 = parame.C();
    e.b localb1 = parame.V();
    if (parame.M() != null) {
      localObject = (f)parame.M();
    } else {
      localObject = null;
    }
    e.b localb3;
    if (localObject != null)
    {
      ((e)localObject).C();
      localb3 = e.b.a;
    }
    if (localObject != null)
    {
      ((e)localObject).V();
      localObject = e.b.a;
    }
    Object localObject = e.b.a;
    boolean bool2 = false;
    if ((localb2 != localObject) && (!parame.p0()) && (localb2 != e.b.b))
    {
      localb3 = e.b.c;
      if (((localb2 != localb3) || (parame.w != 0) || (parame.f0 != 0.0F) || (!parame.c0(0))) && ((localb2 != localb3) || (parame.w != 1) || (!parame.f0(0, parame.Y()))))
      {
        paramInt = 0;
        break label169;
      }
    }
    paramInt = 1;
    label169:
    if ((localb1 != localObject) && (!parame.q0()) && (localb1 != e.b.b))
    {
      localObject = e.b.c;
      if (((localb1 != localObject) || (parame.x != 0) || (parame.f0 != 0.0F) || (!parame.c0(1))) && ((localb1 != localObject) || (parame.x != 1) || (!parame.f0(1, parame.z()))))
      {
        i = 0;
        break label264;
      }
    }
    int i = 1;
    label264:
    if ((parame.f0 > 0.0F) && ((paramInt != 0) || (i != 0))) {
      return true;
    }
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static void b(int paramInt, e parame, b.b paramb, boolean paramBoolean)
  {
    if (parame.i0()) {
      return;
    }
    b += 1;
    int i;
    if ((!(parame instanceof f)) && (parame.o0()))
    {
      i = paramInt + 1;
      if (a(i, parame)) {
        f.W1(i, parame, paramb, new b.a(), b.a.k);
      }
    }
    Object localObject2 = parame.q(d.b.b);
    Object localObject1 = parame.q(d.b.d);
    int k = ((d)localObject2).e();
    int j = ((d)localObject1).e();
    Object localObject3;
    Object localObject4;
    boolean bool;
    Object localObject5;
    if ((((d)localObject2).d() != null) && (((d)localObject2).n()))
    {
      localObject2 = ((d)localObject2).d().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d)((Iterator)localObject2).next();
        localObject4 = ((d)localObject3).d;
        int m = paramInt + 1;
        bool = a(m, (e)localObject4);
        if ((((e)localObject4).o0()) && (bool)) {
          f.W1(m, (e)localObject4, paramb, new b.a(), b.a.k);
        }
        if (localObject3 == ((e)localObject4).Q)
        {
          localObject5 = ((e)localObject4).S.f;
          if ((localObject5 != null) && (((d)localObject5).n())) {}
        }
        else
        {
          if (localObject3 != ((e)localObject4).S) {
            break label267;
          }
          localObject5 = ((e)localObject4).Q.f;
          if ((localObject5 == null) || (!((d)localObject5).n())) {
            break label267;
          }
        }
        i = 1;
        break label270;
        label267:
        i = 0;
        label270:
        localObject5 = ((e)localObject4).C();
        Object localObject6 = e.b.c;
        if ((localObject5 == localObject6) && (!bool))
        {
          if ((((e)localObject4).C() == localObject6) && (((e)localObject4).A >= 0) && (((e)localObject4).z >= 0) && ((((e)localObject4).X() == 8) || ((((e)localObject4).w == 0) && (((e)localObject4).x() == 0.0F))) && (!((e)localObject4).k0()) && (!((e)localObject4).n0()) && (i != 0) && (!((e)localObject4).k0())) {
            e(m, parame, paramb, (e)localObject4, paramBoolean);
          }
        }
        else {
          if (((e)localObject4).o0()) {
            continue;
          }
        }
        for (;;)
        {
          localObject5 = ((e)localObject4).Q;
          if ((localObject3 == localObject5) && (((e)localObject4).S.f == null))
          {
            i = ((d)localObject5).f() + k;
            ((e)localObject4).J0(i, ((e)localObject4).Y() + i);
          }
          for (;;)
          {
            b(m, (e)localObject4, paramb, paramBoolean);
            break;
            localObject6 = ((e)localObject4).S;
            if ((localObject3 != localObject6) || (((d)localObject5).f != null)) {
              break label516;
            }
            i = k - ((d)localObject6).f();
            ((e)localObject4).J0(i - ((e)localObject4).Y(), i);
          }
          label516:
          if ((i != 0) && (!((e)localObject4).k0())) {
            d(m, paramb, (e)localObject4, paramBoolean);
          }
        }
      }
    }
    if ((parame instanceof k0.h)) {
      return;
    }
    if ((((d)localObject1).d() != null) && (((d)localObject1).n()))
    {
      localObject1 = ((d)localObject1).d().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        localObject3 = ((d)localObject2).d;
        k = paramInt + 1;
        bool = a(k, (e)localObject3);
        if ((((e)localObject3).o0()) && (bool)) {
          f.W1(k, (e)localObject3, paramb, new b.a(), b.a.k);
        }
        if (localObject2 == ((e)localObject3).Q)
        {
          localObject4 = ((e)localObject3).S.f;
          if ((localObject4 != null) && (((d)localObject4).n())) {}
        }
        else
        {
          if (localObject2 != ((e)localObject3).S) {
            break label722;
          }
          localObject4 = ((e)localObject3).Q.f;
          if ((localObject4 == null) || (!((d)localObject4).n())) {
            break label722;
          }
        }
        i = 1;
        break label725;
        label722:
        i = 0;
        label725:
        localObject4 = ((e)localObject3).C();
        localObject5 = e.b.c;
        if ((localObject4 == localObject5) && (!bool))
        {
          if ((((e)localObject3).C() == localObject5) && (((e)localObject3).A >= 0) && (((e)localObject3).z >= 0) && ((((e)localObject3).X() == 8) || ((((e)localObject3).w == 0) && (((e)localObject3).x() == 0.0F))) && (!((e)localObject3).k0()) && (!((e)localObject3).n0()) && (i != 0) && (!((e)localObject3).k0())) {
            e(k, parame, paramb, (e)localObject3, paramBoolean);
          }
        }
        else if (!((e)localObject3).o0())
        {
          localObject4 = ((e)localObject3).Q;
          if ((localObject2 == localObject4) && (((e)localObject3).S.f == null))
          {
            i = ((d)localObject4).f() + j;
            ((e)localObject3).J0(i, ((e)localObject3).Y() + i);
          }
          for (;;)
          {
            b(k, (e)localObject3, paramb, paramBoolean);
            break;
            localObject5 = ((e)localObject3).S;
            if ((localObject2 != localObject5) || (((d)localObject4).f != null)) {
              break label971;
            }
            i = j - ((d)localObject5).f();
            ((e)localObject3).J0(i - ((e)localObject3).Y(), i);
          }
          label971:
          if ((i != 0) && (!((e)localObject3).k0())) {
            d(k, paramb, (e)localObject3, paramBoolean);
          }
        }
      }
    }
    parame.s0();
  }
  
  private static void c(int paramInt1, a parama, b.b paramb, int paramInt2, boolean paramBoolean)
  {
    if (parama.x1())
    {
      paramInt1 += 1;
      if (paramInt2 == 0)
      {
        b(paramInt1, parama, paramb, paramBoolean);
        return;
      }
      i(paramInt1, parama, paramb);
    }
  }
  
  private static void d(int paramInt, b.b paramb, e parame, boolean paramBoolean)
  {
    float f = parame.A();
    int i = parame.Q.f.e();
    int j = parame.S.f.e();
    int m = parame.Q.f();
    int k = parame.S.f();
    if (i == j)
    {
      f = 0.5F;
    }
    else
    {
      i = m + i;
      j -= k;
    }
    m = parame.Y();
    k = j - i - m;
    if (i > j) {
      k = i - j - m;
    }
    if (k > 0) {
      f = f * k + 0.5F;
    } else {
      f *= k;
    }
    int n = (int)f + i;
    k = n + m;
    if (i > j) {
      k = n - m;
    }
    parame.J0(n, k);
    b(paramInt + 1, parame, paramb, paramBoolean);
  }
  
  private static void e(int paramInt, e parame1, b.b paramb, e parame2, boolean paramBoolean)
  {
    float f = parame2.A();
    int k = parame2.Q.f.e() + parame2.Q.f();
    int m = parame2.S.f.e() - parame2.S.f();
    if (m >= k)
    {
      int j = parame2.Y();
      int i = j;
      if (parame2.X() != 8)
      {
        int n = parame2.w;
        if (n == 2)
        {
          if (!(parame1 instanceof f)) {
            parame1 = parame1.M();
          }
          i = parame1.Y();
          i = (int)(parame2.A() * 0.5F * i);
        }
        else
        {
          i = j;
          if (n == 0) {
            i = m - k;
          }
        }
        j = Math.max(parame2.z, i);
        n = parame2.A;
        i = j;
        if (n > 0) {
          i = Math.min(n, j);
        }
      }
      j = k + (int)(f * (m - k - i) + 0.5F);
      parame2.J0(j, i + j);
      b(paramInt + 1, parame2, paramb, paramBoolean);
    }
  }
  
  private static void f(int paramInt, b.b paramb, e parame)
  {
    float f = parame.T();
    int i = parame.R.f.e();
    int j = parame.T.f.e();
    int m = parame.R.f();
    int k = parame.T.f();
    if (i == j)
    {
      f = 0.5F;
    }
    else
    {
      i = m + i;
      j -= k;
    }
    int n = parame.z();
    k = j - i - n;
    if (i > j) {
      k = i - j - n;
    }
    if (k > 0) {
      f = f * k + 0.5F;
    } else {
      f *= k;
    }
    int i1 = (int)f;
    k = i + i1;
    m = k + n;
    if (i > j)
    {
      k = i - i1;
      m = k - n;
    }
    parame.M0(k, m);
    i(paramInt + 1, parame, paramb);
  }
  
  private static void g(int paramInt, e parame1, b.b paramb, e parame2)
  {
    float f = parame2.T();
    int k = parame2.R.f.e() + parame2.R.f();
    int m = parame2.T.f.e() - parame2.T.f();
    if (m >= k)
    {
      int j = parame2.z();
      int i = j;
      if (parame2.X() != 8)
      {
        int n = parame2.x;
        if (n == 2)
        {
          if (!(parame1 instanceof f)) {
            parame1 = parame1.M();
          }
          i = (int)(f * 0.5F * parame1.z());
        }
        else
        {
          i = j;
          if (n == 0) {
            i = m - k;
          }
        }
        j = Math.max(parame2.C, i);
        n = parame2.D;
        i = j;
        if (n > 0) {
          i = Math.min(n, j);
        }
      }
      j = k + (int)(f * (m - k - i) + 0.5F);
      parame2.M0(j, i + j);
      i(paramInt + 1, parame2, paramb);
    }
  }
  
  public static void h(f paramf, b.b paramb)
  {
    Object localObject2 = paramf.C();
    Object localObject1 = paramf.V();
    b = 0;
    c = 0;
    paramf.y0();
    ArrayList localArrayList = paramf.v1();
    int i1 = localArrayList.size();
    int i = 0;
    while (i < i1)
    {
      ((e)localArrayList.get(i)).y0();
      i += 1;
    }
    boolean bool = paramf.T1();
    if (localObject2 == e.b.a) {
      paramf.J0(0, paramf.Y());
    } else {
      paramf.K0(0);
    }
    int k = 0;
    i = k;
    int m;
    int n;
    for (int j = i; k < i1; j = n)
    {
      localObject2 = (e)localArrayList.get(k);
      if ((localObject2 instanceof k0.h))
      {
        localObject2 = (k0.h)localObject2;
        m = i;
        n = j;
        if (((k0.h)localObject2).w1() == 1)
        {
          if (((k0.h)localObject2).x1() != -1) {
            i = ((k0.h)localObject2).x1();
          }
          for (;;)
          {
            ((k0.h)localObject2).A1(i);
            break;
            if ((((k0.h)localObject2).y1() != -1) && (paramf.p0()))
            {
              i = paramf.Y() - ((k0.h)localObject2).y1();
            }
            else
            {
              if (!paramf.p0()) {
                break;
              }
              i = (int)(((k0.h)localObject2).z1() * paramf.Y() + 0.5F);
            }
          }
          m = 1;
          n = j;
        }
      }
      else
      {
        m = i;
        n = j;
        if ((localObject2 instanceof a))
        {
          m = i;
          n = j;
          if (((a)localObject2).B1() == 0)
          {
            n = 1;
            m = i;
          }
        }
      }
      k += 1;
      i = m;
    }
    if (i != 0)
    {
      i = 0;
      while (i < i1)
      {
        localObject2 = (e)localArrayList.get(i);
        if ((localObject2 instanceof k0.h))
        {
          localObject2 = (k0.h)localObject2;
          if (((k0.h)localObject2).w1() == 1) {
            b(0, (e)localObject2, paramb, bool);
          }
        }
        i += 1;
      }
    }
    b(0, paramf, paramb, bool);
    if (j != 0)
    {
      i = 0;
      while (i < i1)
      {
        localObject2 = (e)localArrayList.get(i);
        if ((localObject2 instanceof a))
        {
          localObject2 = (a)localObject2;
          if (((a)localObject2).B1() == 0) {
            c(0, (a)localObject2, paramb, 0, bool);
          }
        }
        i += 1;
      }
    }
    if (localObject1 == e.b.a) {
      paramf.M0(0, paramf.z());
    } else {
      paramf.L0(0);
    }
    k = 0;
    i = k;
    for (j = i; k < i1; j = n)
    {
      localObject1 = (e)localArrayList.get(k);
      if ((localObject1 instanceof k0.h))
      {
        localObject1 = (k0.h)localObject1;
        m = i;
        n = j;
        if (((k0.h)localObject1).w1() == 0)
        {
          if (((k0.h)localObject1).x1() != -1) {
            i = ((k0.h)localObject1).x1();
          }
          for (;;)
          {
            ((k0.h)localObject1).A1(i);
            break;
            if ((((k0.h)localObject1).y1() != -1) && (paramf.q0()))
            {
              i = paramf.z() - ((k0.h)localObject1).y1();
            }
            else
            {
              if (!paramf.q0()) {
                break;
              }
              i = (int)(((k0.h)localObject1).z1() * paramf.z() + 0.5F);
            }
          }
          m = 1;
          n = j;
        }
      }
      else
      {
        m = i;
        n = j;
        if ((localObject1 instanceof a))
        {
          m = i;
          n = j;
          if (((a)localObject1).B1() == 1)
          {
            n = 1;
            m = i;
          }
        }
      }
      k += 1;
      i = m;
    }
    if (i != 0)
    {
      i = 0;
      while (i < i1)
      {
        localObject1 = (e)localArrayList.get(i);
        if ((localObject1 instanceof k0.h))
        {
          localObject1 = (k0.h)localObject1;
          if (((k0.h)localObject1).w1() == 0) {
            i(1, (e)localObject1, paramb);
          }
        }
        i += 1;
      }
    }
    i(0, paramf, paramb);
    if (j != 0)
    {
      i = 0;
      while (i < i1)
      {
        paramf = (e)localArrayList.get(i);
        if ((paramf instanceof a))
        {
          paramf = (a)paramf;
          if (paramf.B1() == 1) {
            c(0, paramf, paramb, 1, bool);
          }
        }
        i += 1;
      }
    }
    i = 0;
    while (i < i1)
    {
      paramf = (e)localArrayList.get(i);
      if ((paramf.o0()) && (a(0, paramf)))
      {
        f.W1(0, paramf, paramb, a, b.a.k);
        if ((paramf instanceof k0.h))
        {
          if (((k0.h)paramf).w1() != 0)
          {
            b(0, paramf, paramb, bool);
            break label865;
          }
        }
        else {
          b(0, paramf, paramb, bool);
        }
        i(0, paramf, paramb);
      }
      label865:
      i += 1;
    }
  }
  
  private static void i(int paramInt, e parame, b.b paramb)
  {
    if (parame.r0()) {
      return;
    }
    c += 1;
    int i;
    if ((!(parame instanceof f)) && (parame.o0()))
    {
      i = paramInt + 1;
      if (a(i, parame)) {
        f.W1(i, parame, paramb, new b.a(), b.a.k);
      }
    }
    Object localObject2 = parame.q(d.b.c);
    Object localObject1 = parame.q(d.b.e);
    int k = ((d)localObject2).e();
    int j = ((d)localObject1).e();
    Object localObject3;
    Object localObject4;
    boolean bool;
    Object localObject5;
    if ((((d)localObject2).d() != null) && (((d)localObject2).n()))
    {
      localObject2 = ((d)localObject2).d().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d)((Iterator)localObject2).next();
        localObject4 = ((d)localObject3).d;
        int m = paramInt + 1;
        bool = a(m, (e)localObject4);
        if ((((e)localObject4).o0()) && (bool)) {
          f.W1(m, (e)localObject4, paramb, new b.a(), b.a.k);
        }
        if (localObject3 == ((e)localObject4).R)
        {
          localObject5 = ((e)localObject4).T.f;
          if ((localObject5 != null) && (((d)localObject5).n())) {}
        }
        else
        {
          if (localObject3 != ((e)localObject4).T) {
            break label263;
          }
          localObject5 = ((e)localObject4).R.f;
          if ((localObject5 == null) || (!((d)localObject5).n())) {
            break label263;
          }
        }
        i = 1;
        break label265;
        label263:
        i = 0;
        label265:
        localObject5 = ((e)localObject4).V();
        Object localObject6 = e.b.c;
        if ((localObject5 == localObject6) && (!bool))
        {
          if ((((e)localObject4).V() == localObject6) && (((e)localObject4).D >= 0) && (((e)localObject4).C >= 0) && ((((e)localObject4).X() == 8) || ((((e)localObject4).x == 0) && (((e)localObject4).x() == 0.0F))) && (!((e)localObject4).m0()) && (!((e)localObject4).n0()) && (i != 0) && (!((e)localObject4).m0())) {
            g(m, parame, paramb, (e)localObject4);
          }
        }
        else if (!((e)localObject4).o0())
        {
          localObject5 = ((e)localObject4).R;
          if ((localObject3 == localObject5) && (((e)localObject4).T.f == null))
          {
            i = ((d)localObject5).f() + k;
            ((e)localObject4).M0(i, ((e)localObject4).z() + i);
          }
          for (;;)
          {
            i(m, (e)localObject4, paramb);
            break;
            localObject6 = ((e)localObject4).T;
            if ((localObject3 != localObject6) || (((d)localObject5).f != null)) {
              break label502;
            }
            i = k - ((d)localObject6).f();
            ((e)localObject4).M0(i - ((e)localObject4).z(), i);
          }
          label502:
          if ((i != 0) && (!((e)localObject4).m0())) {
            f(m, paramb, (e)localObject4);
          }
        }
      }
    }
    if ((parame instanceof k0.h)) {
      return;
    }
    if ((((d)localObject1).d() != null) && (((d)localObject1).n()))
    {
      localObject1 = ((d)localObject1).d().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        localObject3 = ((d)localObject2).d;
        k = paramInt + 1;
        bool = a(k, (e)localObject3);
        if ((((e)localObject3).o0()) && (bool)) {
          f.W1(k, (e)localObject3, paramb, new b.a(), b.a.k);
        }
        if (localObject2 == ((e)localObject3).R)
        {
          localObject4 = ((e)localObject3).T.f;
          if ((localObject4 != null) && (((d)localObject4).n())) {}
        }
        else
        {
          if (localObject2 != ((e)localObject3).T) {
            break label705;
          }
          localObject4 = ((e)localObject3).R.f;
          if ((localObject4 == null) || (!((d)localObject4).n())) {
            break label705;
          }
        }
        i = 1;
        break label707;
        label705:
        i = 0;
        label707:
        localObject4 = ((e)localObject3).V();
        localObject5 = e.b.c;
        if ((localObject4 == localObject5) && (!bool))
        {
          if ((((e)localObject3).V() == localObject5) && (((e)localObject3).D >= 0) && (((e)localObject3).C >= 0) && ((((e)localObject3).X() == 8) || ((((e)localObject3).x == 0) && (((e)localObject3).x() == 0.0F))) && (!((e)localObject3).m0()) && (!((e)localObject3).n0()) && (i != 0) && (!((e)localObject3).m0())) {
            g(k, parame, paramb, (e)localObject3);
          }
        }
        else if (!((e)localObject3).o0())
        {
          localObject4 = ((e)localObject3).R;
          if ((localObject2 == localObject4) && (((e)localObject3).T.f == null))
          {
            i = ((d)localObject4).f() + j;
            ((e)localObject3).M0(i, ((e)localObject3).z() + i);
          }
          for (;;)
          {
            i(k, (e)localObject3, paramb);
            break;
            localObject5 = ((e)localObject3).T;
            if ((localObject2 != localObject5) || (((d)localObject4).f != null)) {
              break label944;
            }
            i = j - ((d)localObject5).f();
            ((e)localObject3).M0(i - ((e)localObject3).z(), i);
          }
          label944:
          if ((i != 0) && (!((e)localObject3).m0())) {
            f(k, paramb, (e)localObject3);
          }
        }
      }
    }
    localObject1 = parame.q(d.b.f);
    if ((((d)localObject1).d() != null) && (((d)localObject1).n()))
    {
      i = ((d)localObject1).e();
      localObject1 = ((d)localObject1).d().iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        localObject3 = ((d)localObject2).d;
        j = paramInt + 1;
        bool = a(j, (e)localObject3);
        if ((((e)localObject3).o0()) && (bool)) {
          f.W1(j, (e)localObject3, paramb, new b.a(), b.a.k);
        }
        if (((((e)localObject3).V() == e.b.c) && (!bool)) || (((e)localObject3).o0()) || (localObject2 != ((e)localObject3).U)) {
          continue;
        }
        ((e)localObject3).I0(((d)localObject2).f() + i);
      }
      try
      {
        i(j, (e)localObject3, paramb);
      }
      finally {}
    }
    parame.t0();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.h
 * JD-Core Version:    0.7.0.1
 */