package k0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class g
  extends m
{
  private int A1 = 0;
  private int B1 = -1;
  private int C1 = 0;
  private ArrayList<a> D1 = new ArrayList();
  private e[] E1 = null;
  private e[] F1 = null;
  private int[] G1 = null;
  private e[] H1;
  private int I1 = 0;
  private int k1 = -1;
  private int l1 = -1;
  private int m1 = -1;
  private int n1 = -1;
  private int o1 = -1;
  private int p1 = -1;
  private float q1 = 0.5F;
  private float r1 = 0.5F;
  private float s1 = 0.5F;
  private float t1 = 0.5F;
  private float u1 = 0.5F;
  private float v1 = 0.5F;
  private int w1 = 0;
  private int x1 = 0;
  private int y1 = 2;
  private int z1 = 2;
  
  private void n2(boolean paramBoolean)
  {
    if ((this.G1 != null) && (this.F1 != null))
    {
      if (this.E1 == null) {
        return;
      }
      int i = 0;
      while (i < this.I1)
      {
        this.H1[i].x0();
        i += 1;
      }
      Object localObject1 = this.G1;
      int m = localObject1[0];
      int n = localObject1[1];
      localObject1 = null;
      float f = this.q1;
      i = 0;
      int j;
      e locale;
      Object localObject2;
      while (i < m)
      {
        if (paramBoolean)
        {
          j = m - i - 1;
          f = 1.0F - this.q1;
        }
        else
        {
          j = i;
        }
        locale = this.F1[j];
        localObject2 = localObject1;
        if (locale != null) {
          if (locale.X() == 8)
          {
            localObject2 = localObject1;
          }
          else
          {
            if (i == 0)
            {
              locale.l(locale.Q, this.Q, D1());
              locale.R0(this.k1);
              locale.Q0(f);
            }
            if (i == m - 1) {
              locale.l(locale.S, this.S, E1());
            }
            if ((i > 0) && (localObject1 != null))
            {
              locale.l(locale.Q, ((e)localObject1).S, this.w1);
              ((e)localObject1).l(((e)localObject1).S, locale.Q, 0);
            }
            localObject2 = locale;
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      i = 0;
      while (i < n)
      {
        locale = this.E1[i];
        localObject2 = localObject1;
        if (locale != null) {
          if (locale.X() == 8)
          {
            localObject2 = localObject1;
          }
          else
          {
            if (i == 0)
            {
              locale.l(locale.R, this.R, F1());
              locale.i1(this.l1);
              locale.h1(this.r1);
            }
            if (i == n - 1) {
              locale.l(locale.T, this.T, C1());
            }
            if ((i > 0) && (localObject1 != null))
            {
              locale.l(locale.R, ((e)localObject1).T, this.x1);
              ((e)localObject1).l(((e)localObject1).T, locale.R, 0);
            }
            localObject2 = locale;
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      i = 0;
      while (i < m)
      {
        j = 0;
        while (j < n)
        {
          int k = j * m + i;
          if (this.C1 == 1) {
            k = i * n + j;
          }
          localObject1 = this.H1;
          if (k < localObject1.length)
          {
            localObject1 = localObject1[k];
            if ((localObject1 != null) && (((e)localObject1).X() != 8))
            {
              localObject2 = this.F1[i];
              locale = this.E1[j];
              if (localObject1 != localObject2)
              {
                ((e)localObject1).l(((e)localObject1).Q, ((e)localObject2).Q, 0);
                ((e)localObject1).l(((e)localObject1).S, ((e)localObject2).S, 0);
              }
              if (localObject1 != locale)
              {
                ((e)localObject1).l(((e)localObject1).R, locale.R, 0);
                ((e)localObject1).l(((e)localObject1).T, locale.T, 0);
              }
            }
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  private final int o2(e parame, int paramInt)
  {
    if (parame == null) {
      return 0;
    }
    if (parame.V() == e.b.c)
    {
      int i = parame.x;
      if (i == 0) {
        return 0;
      }
      if (i == 2)
      {
        paramInt = (int)(parame.E * paramInt);
        if (paramInt != parame.z())
        {
          parame.c1(true);
          H1(parame, parame.C(), parame.Y(), e.b.a, paramInt);
        }
        return paramInt;
      }
      if (i == 1) {
        return parame.z();
      }
      if (i == 3) {
        return (int)(parame.Y() * parame.f0 + 0.5F);
      }
    }
    return parame.z();
  }
  
  private final int p2(e parame, int paramInt)
  {
    if (parame == null) {
      return 0;
    }
    if (parame.C() == e.b.c)
    {
      int i = parame.w;
      if (i == 0) {
        return 0;
      }
      if (i == 2)
      {
        paramInt = (int)(parame.B * paramInt);
        if (paramInt != parame.Y())
        {
          parame.c1(true);
          H1(parame, e.b.a, paramInt, parame.V(), parame.z());
        }
        return paramInt;
      }
      if (i == 1) {
        return parame.Y();
      }
      if (i == 3) {
        return (int)(parame.z() * parame.f0 + 0.5F);
      }
    }
    return parame.Y();
  }
  
  private void q2(e[] paramArrayOfe, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    int i = this.B1;
    int k;
    int m;
    Object localObject;
    if (paramInt2 == 0)
    {
      k = i;
      if (i <= 0)
      {
        k = 0;
        i = k;
        j = i;
        m = i;
        i = k;
        for (;;)
        {
          k = i;
          if (m >= paramInt1) {
            break;
          }
          k = j;
          if (m > 0) {
            k = j + this.w1;
          }
          localObject = paramArrayOfe[m];
          if (localObject == null)
          {
            j = k;
          }
          else
          {
            j = k + p2((e)localObject, paramInt3);
            if (j > paramInt3)
            {
              k = i;
              break;
            }
            i += 1;
          }
          m += 1;
        }
      }
      j = k;
      i = 0;
    }
    else
    {
      k = i;
      if (i <= 0)
      {
        k = 0;
        i = k;
        j = i;
        m = i;
        i = k;
        for (;;)
        {
          k = i;
          if (m >= paramInt1) {
            break;
          }
          k = j;
          if (m > 0) {
            k = j + this.x1;
          }
          localObject = paramArrayOfe[m];
          if (localObject == null)
          {
            j = k;
          }
          else
          {
            j = k + o2((e)localObject, paramInt3);
            if (j > paramInt3)
            {
              k = i;
              break;
            }
            i += 1;
          }
          m += 1;
        }
      }
      j = 0;
      i = k;
    }
    if (this.G1 == null) {
      this.G1 = new int[2];
    }
    int i1;
    if (i == 0)
    {
      i1 = i;
      m = j;
      if (paramInt2 == 1) {}
    }
    else
    {
      if ((j != 0) || (paramInt2 != 0)) {
        break label322;
      }
      m = j;
      i1 = i;
    }
    int i2 = 1;
    i = i1;
    int j = m;
    break label325;
    label322:
    i2 = 0;
    for (;;)
    {
      label325:
      if (i2 != 0) {
        break label866;
      }
      if (paramInt2 == 0) {
        i = (int)Math.ceil(paramInt1 / j);
      } else {
        j = (int)Math.ceil(paramInt1 / i);
      }
      localObject = this.F1;
      if ((localObject != null) && (localObject.length >= j)) {
        Arrays.fill((Object[])localObject, null);
      } else {
        this.F1 = new e[j];
      }
      localObject = this.E1;
      if ((localObject != null) && (localObject.length >= i)) {
        Arrays.fill((Object[])localObject, null);
      } else {
        this.E1 = new e[i];
      }
      k = 0;
      while (k < j)
      {
        m = 0;
        while (m < i)
        {
          n = m * j + k;
          if (paramInt2 == 1) {
            n = k * i + m;
          }
          if (n < paramArrayOfe.length)
          {
            localObject = paramArrayOfe[n];
            if (localObject != null)
            {
              n = p2((e)localObject, paramInt3);
              e[] arrayOfe = this.F1;
              if ((arrayOfe[k] == null) || (arrayOfe[k].Y() < n)) {
                this.F1[k] = localObject;
              }
              n = o2((e)localObject, paramInt3);
              arrayOfe = this.E1;
              if ((arrayOfe[m] == null) || (arrayOfe[m].z() < n)) {
                this.E1[m] = localObject;
              }
            }
          }
          m += 1;
        }
        k += 1;
      }
      m = 0;
      for (k = m; m < j; k = n)
      {
        localObject = this.F1[m];
        n = k;
        if (localObject != null)
        {
          n = k;
          if (m > 0) {
            n = k + this.w1;
          }
          n += p2((e)localObject, paramInt3);
        }
        m += 1;
      }
      m = 0;
      for (int n = m; m < i; n = i1)
      {
        localObject = this.E1[m];
        i1 = n;
        if (localObject != null)
        {
          i1 = n;
          if (m > 0) {
            i1 = n + this.x1;
          }
          i1 += o2((e)localObject, paramInt3);
        }
        m += 1;
      }
      paramArrayOfInt[0] = k;
      paramArrayOfInt[1] = n;
      if (paramInt2 == 0)
      {
        i1 = i;
        m = j;
        if (k <= paramInt3) {
          break;
        }
        i1 = i;
        m = j;
        if (j <= 1) {
          break;
        }
        j -= 1;
        continue;
      }
      i1 = i;
      m = j;
      if (n <= paramInt3) {
        break;
      }
      i1 = i;
      m = j;
      if (i <= 1) {
        break;
      }
      i -= 1;
    }
    label866:
    paramArrayOfe = this.G1;
    paramArrayOfe[0] = j;
    paramArrayOfe[1] = i;
  }
  
  private void r2(e[] paramArrayOfe, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    if (paramInt1 == 0) {
      return;
    }
    this.D1.clear();
    Object localObject2 = new a(paramInt2, this.Q, this.R, this.S, this.T, paramInt3);
    this.D1.add(localObject2);
    int i = 0;
    int i1 = 0;
    int j = i1;
    int k = j;
    int n = j;
    Object localObject1 = localObject2;
    int m = k;
    if (paramInt2 == 0)
    {
      m = k;
      localObject1 = localObject2;
      k = j;
      for (i = i1;; i = j)
      {
        j = i;
        if (m >= paramInt1) {
          break;
        }
        localObject3 = paramArrayOfe[m];
        i1 = p2((e)localObject3, paramInt3);
        j = i;
        if (((e)localObject3).C() == e.b.c) {
          j = i + 1;
        }
        if (((k == paramInt3) || (this.w1 + k + i1 > paramInt3)) && (a.a((a)localObject1) != null)) {
          i = 1;
        } else {
          i = 0;
        }
        n = i;
        if (i == 0)
        {
          n = i;
          if (m > 0)
          {
            i2 = this.B1;
            n = i;
            if (i2 > 0)
            {
              n = i;
              if (m % i2 == 0) {
                n = 1;
              }
            }
          }
        }
        if (n != 0)
        {
          localObject2 = new a(paramInt2, this.Q, this.R, this.S, this.T, paramInt3);
          ((a)localObject2).i(m);
          this.D1.add(localObject2);
        }
        do
        {
          k = i1;
          localObject1 = localObject2;
          break;
          localObject2 = localObject1;
        } while (m <= 0);
        k += this.w1 + i1;
        ((a)localObject1).b((e)localObject3);
        m += 1;
      }
    }
    for (;;)
    {
      j = i;
      if (m >= paramInt1) {
        break;
      }
      localObject3 = paramArrayOfe[m];
      i1 = o2((e)localObject3, paramInt3);
      j = i;
      if (((e)localObject3).V() == e.b.c) {
        j = i + 1;
      }
      if (((n == paramInt3) || (this.x1 + n + i1 > paramInt3)) && (a.a((a)localObject1) != null)) {
        i = 1;
      } else {
        i = 0;
      }
      k = i;
      if (i == 0)
      {
        k = i;
        if (m > 0)
        {
          i2 = this.B1;
          k = i;
          if (i2 > 0)
          {
            k = i;
            if (m % i2 == 0) {
              k = 1;
            }
          }
        }
      }
      if (k != 0)
      {
        localObject2 = new a(paramInt2, this.Q, this.R, this.S, this.T, paramInt3);
        ((a)localObject2).i(m);
        this.D1.add(localObject2);
      }
      do
      {
        k = i1;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
      } while (m <= 0);
      k = n + (this.x1 + i1);
      ((a)localObject1).b((e)localObject3);
      m += 1;
      i = j;
      n = k;
    }
    int i3 = this.D1.size();
    paramArrayOfe = this.Q;
    Object localObject3 = this.R;
    localObject1 = this.S;
    localObject2 = this.T;
    k = D1();
    m = F1();
    i1 = E1();
    n = C1();
    Object localObject4 = C();
    Object localObject5 = e.b.b;
    if ((localObject4 != localObject5) && (V() != localObject5)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    if ((j > 0) && (paramInt1 != 0))
    {
      paramInt1 = 0;
      while (paramInt1 < i3)
      {
        localObject4 = (a)this.D1.get(paramInt1);
        if (paramInt2 == 0) {
          i = ((a)localObject4).f();
        } else {
          i = ((a)localObject4).e();
        }
        ((a)localObject4).g(paramInt3 - i);
        paramInt1 += 1;
      }
    }
    j = 0;
    i = j;
    paramInt1 = i;
    for (int i2 = i; paramInt1 < i3; i2 = i)
    {
      localObject5 = (a)this.D1.get(paramInt1);
      if (paramInt2 == 0)
      {
        if (paramInt1 < i3 - 1)
        {
          localObject2 = a.a((a)this.D1.get(paramInt1 + 1)).R;
          i = 0;
        }
        else
        {
          localObject2 = this.T;
          i = C1();
        }
        localObject4 = a.a((a)localObject5).T;
        ((a)localObject5).j(paramInt2, paramArrayOfe, (d)localObject3, (d)localObject1, (d)localObject2, k, m, i1, i, paramInt3);
        m = Math.max(i2, ((a)localObject5).f());
        n = j + ((a)localObject5).e();
        j = n;
        if (paramInt1 > 0) {
          j = n + this.x1;
        }
        i2 = 0;
        localObject3 = localObject4;
        n = i;
        i = m;
        m = i2;
      }
      else
      {
        i1 = paramInt1;
        if (i1 < i3 - 1)
        {
          localObject1 = a.a((a)this.D1.get(i1 + 1)).Q;
          i = 0;
        }
        else
        {
          localObject1 = this.S;
          i = E1();
        }
        localObject4 = a.a((a)localObject5).S;
        ((a)localObject5).j(paramInt2, paramArrayOfe, (d)localObject3, (d)localObject1, (d)localObject2, k, m, i, n, paramInt3);
        k = i2 + ((a)localObject5).f();
        i2 = Math.max(j, ((a)localObject5).e());
        j = k;
        if (i1 > 0) {
          j = k + this.w1;
        }
        k = i2;
        i2 = 0;
        i1 = i;
        paramArrayOfe = (e[])localObject4;
        i = j;
        j = k;
        k = i2;
      }
      paramInt1 += 1;
    }
    paramArrayOfInt[0] = i2;
    paramArrayOfInt[1] = j;
  }
  
  private void s2(e[] paramArrayOfe, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    if (paramInt1 == 0) {
      return;
    }
    this.D1.clear();
    Object localObject1 = new a(paramInt2, this.Q, this.R, this.S, this.T, paramInt3);
    this.D1.add(localObject1);
    int m = 0;
    int n = 0;
    int i = n;
    if (paramInt2 == 0)
    {
      j = i;
      m = j;
      k = j;
      for (;;)
      {
        j = i;
        if (m >= paramInt1) {
          break;
        }
        i2 = n + 1;
        localObject2 = paramArrayOfe[m];
        n = p2((e)localObject2, paramInt3);
        j = i;
        if (((e)localObject2).C() == e.b.c) {
          j = i + 1;
        }
        if (((k == paramInt3) || (this.w1 + k + n > paramInt3)) && (a.a((a)localObject1) != null)) {
          i = 1;
        } else {
          i = 0;
        }
        i1 = i;
        if (i == 0)
        {
          i1 = i;
          if (m > 0)
          {
            i3 = this.B1;
            i1 = i;
            if (i3 > 0)
            {
              i1 = i;
              if (i2 > i3) {
                i1 = 1;
              }
            }
          }
        }
        if (i1 != 0)
        {
          localObject1 = new a(paramInt2, this.Q, this.R, this.S, this.T, paramInt3);
          ((a)localObject1).i(m);
          this.D1.add(localObject1);
          i = i2;
          k = n;
        }
        else
        {
          if (m > 0) {
            k += this.w1 + n;
          } else {
            k = n;
          }
          i = 0;
        }
        ((a)localObject1).b((e)localObject2);
        m += 1;
        n = i;
        i = j;
      }
    }
    int k = i;
    for (;;)
    {
      j = i;
      if (k >= paramInt1) {
        break;
      }
      localObject3 = paramArrayOfe[k];
      i1 = o2((e)localObject3, paramInt3);
      j = i;
      if (((e)localObject3).V() == e.b.c) {
        j = i + 1;
      }
      if (((m == paramInt3) || (this.x1 + m + i1 > paramInt3)) && (a.a((a)localObject1) != null)) {
        i = 1;
      } else {
        i = 0;
      }
      n = i;
      if (i == 0)
      {
        n = i;
        if (k > 0)
        {
          i2 = this.B1;
          n = i;
          if (i2 > 0)
          {
            n = i;
            if (i2 < 0) {
              n = 1;
            }
          }
        }
      }
      if (n != 0)
      {
        localObject2 = new a(paramInt2, this.Q, this.R, this.S, this.T, paramInt3);
        ((a)localObject2).i(k);
        this.D1.add(localObject2);
      }
      do
      {
        i = i1;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
      } while (k <= 0);
      i = m + (this.x1 + i1);
      ((a)localObject1).b((e)localObject3);
      k += 1;
      m = i;
      i = j;
    }
    int i3 = this.D1.size();
    paramArrayOfe = this.Q;
    Object localObject3 = this.R;
    localObject1 = this.S;
    Object localObject2 = this.T;
    k = D1();
    m = F1();
    int i1 = E1();
    n = C1();
    Object localObject4 = C();
    Object localObject5 = e.b.b;
    if ((localObject4 != localObject5) && (V() != localObject5)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    if ((j > 0) && (paramInt1 != 0))
    {
      paramInt1 = 0;
      while (paramInt1 < i3)
      {
        localObject4 = (a)this.D1.get(paramInt1);
        if (paramInt2 == 0) {
          i = ((a)localObject4).f();
        } else {
          i = ((a)localObject4).e();
        }
        ((a)localObject4).g(paramInt3 - i);
        paramInt1 += 1;
      }
    }
    int j = 0;
    i = j;
    paramInt1 = i;
    for (int i2 = i; paramInt1 < i3; i2 = i)
    {
      localObject5 = (a)this.D1.get(paramInt1);
      if (paramInt2 == 0)
      {
        if (paramInt1 < i3 - 1)
        {
          localObject2 = a.a((a)this.D1.get(paramInt1 + 1)).R;
          i = 0;
        }
        else
        {
          localObject2 = this.T;
          i = C1();
        }
        localObject4 = a.a((a)localObject5).T;
        ((a)localObject5).j(paramInt2, paramArrayOfe, (d)localObject3, (d)localObject1, (d)localObject2, k, m, i1, i, paramInt3);
        m = Math.max(i2, ((a)localObject5).f());
        n = j + ((a)localObject5).e();
        j = n;
        if (paramInt1 > 0) {
          j = n + this.x1;
        }
        i2 = 0;
        localObject3 = localObject4;
        n = i;
        i = m;
        m = i2;
      }
      else
      {
        i1 = paramInt1;
        if (i1 < i3 - 1)
        {
          localObject1 = a.a((a)this.D1.get(i1 + 1)).Q;
          i = 0;
        }
        else
        {
          localObject1 = this.S;
          i = E1();
        }
        localObject4 = a.a((a)localObject5).S;
        ((a)localObject5).j(paramInt2, paramArrayOfe, (d)localObject3, (d)localObject1, (d)localObject2, k, m, i, n, paramInt3);
        k = i2 + ((a)localObject5).f();
        i2 = Math.max(j, ((a)localObject5).e());
        j = k;
        if (i1 > 0) {
          j = k + this.w1;
        }
        k = i2;
        i2 = 0;
        i1 = i;
        paramArrayOfe = (e[])localObject4;
        i = j;
        j = k;
        k = i2;
      }
      paramInt1 += 1;
    }
    paramArrayOfInt[0] = i2;
    paramArrayOfInt[1] = j;
  }
  
  private void t2(e[] paramArrayOfe, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    if (paramInt1 == 0) {
      return;
    }
    a locala;
    if (this.D1.size() == 0)
    {
      locala = new a(paramInt2, this.Q, this.R, this.S, this.T, paramInt3);
      this.D1.add(locala);
    }
    else
    {
      locala = (a)this.D1.get(0);
      locala.c();
      d locald1 = this.Q;
      d locald2 = this.R;
      d locald3 = this.S;
      d locald4 = this.T;
      int i = D1();
      int j = F1();
      int k = E1();
      int m = C1();
      locala.j(paramInt2, locald1, locald2, locald3, locald4, i, j, k, m, paramInt3);
    }
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      locala.b(paramArrayOfe[paramInt2]);
      paramInt2 += 1;
    }
    paramArrayOfInt[0] = locala.f();
    paramArrayOfInt[1] = locala.e();
  }
  
  public void A2(int paramInt)
  {
    this.w1 = paramInt;
  }
  
  public void B2(int paramInt)
  {
    this.k1 = paramInt;
  }
  
  public void C2(float paramFloat)
  {
    this.u1 = paramFloat;
  }
  
  public void D2(int paramInt)
  {
    this.o1 = paramInt;
  }
  
  public void E2(float paramFloat)
  {
    this.v1 = paramFloat;
  }
  
  public void F2(int paramInt)
  {
    this.p1 = paramInt;
  }
  
  public void G1(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.W0 > 0) && (!I1()))
    {
      L1(0, 0);
      K1(false);
      return;
    }
    int i2 = D1();
    int i3 = E1();
    int n = F1();
    int i1 = C1();
    int[] arrayOfInt = new int[2];
    int j = paramInt2 - i2 - i3;
    int i = this.C1;
    if (i == 1) {
      j = paramInt4 - n - i1;
    }
    if (i == 0)
    {
      if (this.k1 == -1) {
        this.k1 = 0;
      }
      if (this.l1 != -1) {
        break label141;
      }
    }
    else
    {
      if (this.k1 == -1) {
        this.k1 = 0;
      }
      if (this.l1 != -1) {
        break label141;
      }
    }
    this.l1 = 0;
    label141:
    e[] arrayOfe = this.V0;
    i = 0;
    int m;
    for (int k = i;; k = m)
    {
      m = this.W0;
      if (i >= m) {
        break;
      }
      m = k;
      if (this.V0[i].X() == 8) {
        m = k + 1;
      }
      i += 1;
    }
    if (k > 0)
    {
      arrayOfe = new e[m - k];
      k = 0;
      for (i = 0; k < this.W0; i = m)
      {
        e locale = this.V0[k];
        m = i;
        if (locale.X() != 8)
        {
          arrayOfe[i] = locale;
          m = i + 1;
        }
        k += 1;
      }
    }
    else
    {
      i = m;
    }
    this.H1 = arrayOfe;
    this.I1 = i;
    k = this.A1;
    if (k != 0) {
      if (k != 1) {
        if (k != 2) {
          if (k == 3) {}
        }
      }
    }
    boolean bool;
    for (;;)
    {
      bool = true;
      break;
      s2(arrayOfe, i, this.C1, j, arrayOfInt);
      continue;
      q2(arrayOfe, i, this.C1, j, arrayOfInt);
      continue;
      r2(arrayOfe, i, this.C1, j, arrayOfInt);
      continue;
      t2(arrayOfe, i, this.C1, j, arrayOfInt);
    }
    j = arrayOfInt[0] + i2 + i3;
    i = arrayOfInt[1] + n + i1;
    if (paramInt1 == 1073741824) {
      paramInt1 = paramInt2;
    } else if (paramInt1 == -2147483648) {
      paramInt1 = Math.min(j, paramInt2);
    } else if (paramInt1 == 0) {
      paramInt1 = j;
    } else {
      paramInt1 = 0;
    }
    if (paramInt3 == 1073741824) {
      paramInt2 = paramInt4;
    } else if (paramInt3 == -2147483648) {
      paramInt2 = Math.min(i, paramInt4);
    } else if (paramInt3 == 0) {
      paramInt2 = i;
    } else {
      paramInt2 = 0;
    }
    L1(paramInt1, paramInt2);
    o1(paramInt1);
    P0(paramInt2);
    if (this.W0 <= 0) {
      bool = false;
    }
    K1(bool);
  }
  
  public void G2(int paramInt)
  {
    this.B1 = paramInt;
  }
  
  public void H2(int paramInt)
  {
    this.C1 = paramInt;
  }
  
  public void I2(int paramInt)
  {
    this.z1 = paramInt;
  }
  
  public void J2(float paramFloat)
  {
    this.r1 = paramFloat;
  }
  
  public void K2(int paramInt)
  {
    this.x1 = paramInt;
  }
  
  public void L2(int paramInt)
  {
    this.l1 = paramInt;
  }
  
  public void M2(int paramInt)
  {
    this.A1 = paramInt;
  }
  
  public void g(h0.d paramd, boolean paramBoolean)
  {
    super.g(paramd, paramBoolean);
    if ((M() != null) && (((f)M()).T1())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    int i = this.A1;
    if (i != 0)
    {
      int j;
      boolean bool;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            j = this.D1.size();
            i = 0;
            while (i < j)
            {
              paramd = (a)this.D1.get(i);
              if (i == j - 1) {
                bool = true;
              } else {
                bool = false;
              }
              paramd.d(paramBoolean, i, bool);
              i += 1;
            }
          }
        }
        else {
          n2(paramBoolean);
        }
      }
      else
      {
        j = this.D1.size();
        i = 0;
        while (i < j)
        {
          paramd = (a)this.D1.get(i);
          if (i == j - 1) {
            bool = true;
          } else {
            bool = false;
          }
          paramd.d(paramBoolean, i, bool);
          i += 1;
        }
      }
    }
    else if (this.D1.size() > 0)
    {
      ((a)this.D1.get(0)).d(paramBoolean, 0, true);
    }
    K1(false);
  }
  
  public void n(e parame, HashMap<e, e> paramHashMap)
  {
    super.n(parame, paramHashMap);
    parame = (g)parame;
    this.k1 = parame.k1;
    this.l1 = parame.l1;
    this.m1 = parame.m1;
    this.n1 = parame.n1;
    this.o1 = parame.o1;
    this.p1 = parame.p1;
    this.q1 = parame.q1;
    this.r1 = parame.r1;
    this.s1 = parame.s1;
    this.t1 = parame.t1;
    this.u1 = parame.u1;
    this.v1 = parame.v1;
    this.w1 = parame.w1;
    this.x1 = parame.x1;
    this.y1 = parame.y1;
    this.z1 = parame.z1;
    this.A1 = parame.A1;
    this.B1 = parame.B1;
    this.C1 = parame.C1;
  }
  
  public void u2(float paramFloat)
  {
    this.s1 = paramFloat;
  }
  
  public void v2(int paramInt)
  {
    this.m1 = paramInt;
  }
  
  public void w2(float paramFloat)
  {
    this.t1 = paramFloat;
  }
  
  public void x2(int paramInt)
  {
    this.n1 = paramInt;
  }
  
  public void y2(int paramInt)
  {
    this.y1 = paramInt;
  }
  
  public void z2(float paramFloat)
  {
    this.q1 = paramFloat;
  }
  
  private class a
  {
    private int a;
    private e b = null;
    int c = 0;
    private d d;
    private d e;
    private d f;
    private d g;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    
    public a(int paramInt1, d paramd1, d paramd2, d paramd3, d paramd4, int paramInt2)
    {
      this.a = paramInt1;
      this.d = paramd1;
      this.e = paramd2;
      this.f = paramd3;
      this.g = paramd4;
      this.h = g.this.D1();
      this.i = g.this.F1();
      this.j = g.this.E1();
      this.k = g.this.C1();
      this.q = paramInt2;
    }
    
    private void h()
    {
      this.l = 0;
      this.m = 0;
      this.b = null;
      this.c = 0;
      int i3 = this.o;
      int i1 = 0;
      while (i1 < i3)
      {
        if (this.n + i1 >= g.h2(g.this)) {
          return;
        }
        e locale = g.i2(g.this)[(this.n + i1)];
        int i4;
        int i2;
        if (this.a == 0)
        {
          i4 = locale.Y();
          i2 = g.T1(g.this);
          if (locale.X() == 8) {
            i2 = 0;
          }
          this.l += i4 + i2;
          i2 = g.g2(g.this, locale, this.q);
          if ((this.b == null) || (this.c < i2))
          {
            this.b = locale;
            this.c = i2;
            this.m = i2;
          }
        }
        else
        {
          i4 = g.f2(g.this, locale, this.q);
          int i5 = g.g2(g.this, locale, this.q);
          i2 = g.U1(g.this);
          if (locale.X() == 8) {
            i2 = 0;
          }
          this.m += i5 + i2;
          if ((this.b == null) || (this.c < i4))
          {
            this.b = locale;
            this.c = i4;
            this.l = i4;
          }
        }
        i1 += 1;
      }
    }
    
    public void b(e parame)
    {
      int i1 = this.a;
      int i2 = 0;
      int i3 = 0;
      if (i1 == 0)
      {
        i1 = g.f2(g.this, parame, this.q);
        if (parame.C() == e.b.c)
        {
          this.p += 1;
          i1 = 0;
        }
        i2 = g.T1(g.this);
        if (parame.X() == 8) {
          i2 = i3;
        }
        this.l += i1 + i2;
        i1 = g.g2(g.this, parame, this.q);
        if ((this.b == null) || (this.c < i1))
        {
          this.b = parame;
          this.c = i1;
          this.m = i1;
        }
      }
      else
      {
        int i4 = g.f2(g.this, parame, this.q);
        i1 = g.g2(g.this, parame, this.q);
        if (parame.V() == e.b.c)
        {
          this.p += 1;
          i1 = 0;
        }
        i3 = g.U1(g.this);
        if (parame.X() != 8) {
          i2 = i3;
        }
        this.m += i1 + i2;
        if ((this.b == null) || (this.c < i4))
        {
          this.b = parame;
          this.c = i4;
          this.l = i4;
        }
      }
      this.o += 1;
    }
    
    public void c()
    {
      this.c = 0;
      this.b = null;
      this.l = 0;
      this.m = 0;
      this.n = 0;
      this.o = 0;
      this.p = 0;
    }
    
    public void d(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      int i7 = this.o;
      int i1 = 0;
      Object localObject1;
      while ((i1 < i7) && (this.n + i1 < g.h2(g.this)))
      {
        localObject1 = g.i2(g.this)[(this.n + i1)];
        if (localObject1 != null) {
          ((e)localObject1).x0();
        }
        i1 += 1;
      }
      if (i7 != 0)
      {
        if (this.b == null) {
          return;
        }
        int i4;
        if ((paramBoolean2) && (paramInt == 0)) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        i1 = 0;
        int i2 = -1;
        for (int i3 = i2; i1 < i7; i3 = i5)
        {
          if (paramBoolean1) {
            i5 = i7 - 1 - i1;
          } else {
            i5 = i1;
          }
          if (this.n + i5 >= g.h2(g.this)) {
            break;
          }
          localObject1 = g.i2(g.this)[(this.n + i5)];
          int i6 = i2;
          i5 = i3;
          if (localObject1 != null)
          {
            i6 = i2;
            i5 = i3;
            if (((e)localObject1).X() == 0)
            {
              i3 = i2;
              if (i2 == -1) {
                i3 = i1;
              }
              i5 = i1;
              i6 = i3;
            }
          }
          i1 += 1;
          i2 = i6;
        }
        Object localObject2 = null;
        localObject1 = null;
        label470:
        float f2;
        float f1;
        label735:
        d locald;
        if (this.a == 0)
        {
          locale1 = this.b;
          locale1.i1(g.j2(g.this));
          i5 = this.i;
          i1 = i5;
          if (paramInt > 0) {
            i1 = i5 + g.U1(g.this);
          }
          locale1.R.a(this.e, i1);
          if (paramBoolean2) {
            locale1.T.a(this.g, this.k);
          }
          if (paramInt > 0) {
            this.e.d.T.a(locale1.R, 0);
          }
          paramInt = g.k2(g.this);
          i5 = 3;
          if ((paramInt == 3) && (!locale1.b0()))
          {
            paramInt = 0;
            while (paramInt < i7)
            {
              if (paramBoolean1) {
                i1 = i7 - 1 - paramInt;
              } else {
                i1 = paramInt;
              }
              if (this.n + i1 >= g.h2(g.this)) {
                break;
              }
              localObject2 = g.i2(g.this)[(this.n + i1)];
              if (((e)localObject2).b0()) {
                break label470;
              }
              paramInt += 1;
            }
          }
          localObject2 = locale1;
          i1 = 0;
          paramInt = i5;
          while (i1 < i7)
          {
            if (paramBoolean1) {
              i5 = i7 - 1 - i1;
            } else {
              i5 = i1;
            }
            if (this.n + i5 >= g.h2(g.this)) {
              return;
            }
            e locale2 = g.i2(g.this)[(this.n + i5)];
            if (locale2 != null)
            {
              if (i1 == 0) {
                locale2.l(locale2.Q, this.d, this.h);
              }
              if (i5 == 0)
              {
                i5 = g.l2(g.this);
                f2 = g.m2(g.this);
                f1 = f2;
                if (paramBoolean1) {
                  f1 = 1.0F - f2;
                }
                if ((this.n == 0) && (g.V1(g.this) != -1))
                {
                  paramInt = g.V1(g.this);
                  if (paramBoolean1)
                  {
                    f1 = g.W1(g.this);
                    f1 = 1.0F - f1;
                  }
                }
                for (f1 = g.W1(g.this);; f1 = g.Y1(g.this))
                {
                  f2 = f1;
                  break label735;
                  paramInt = i5;
                  f2 = f1;
                  if (!paramBoolean2) {
                    break label735;
                  }
                  paramInt = i5;
                  f2 = f1;
                  if (g.X1(g.this) == -1) {
                    break label735;
                  }
                  paramInt = g.X1(g.this);
                  if (paramBoolean1)
                  {
                    f1 = g.Y1(g.this);
                    break;
                  }
                }
                locale2.R0(paramInt);
                locale2.Q0(f2);
              }
              if (i1 == i7 - 1) {
                locale2.l(locale2.S, this.f, this.j);
              }
              if (localObject1 != null)
              {
                locale2.Q.a(((e)localObject1).S, g.T1(g.this));
                if (i1 == i2) {
                  locale2.Q.u(this.h);
                }
                ((e)localObject1).S.a(locale2.Q, 0);
                if (i1 == i3 + 1) {
                  ((e)localObject1).S.u(this.j);
                }
              }
              if (locale2 != locale1)
              {
                i5 = g.k2(g.this);
                paramInt = 3;
                if ((i5 == 3) && (((e)localObject2).b0()) && (locale2 != localObject2) && (locale2.b0()))
                {
                  localObject1 = locale2.U;
                  locald = ((e)localObject2).U;
                }
                else
                {
                  i5 = g.k2(g.this);
                  if (i5 != 0)
                  {
                    if (i5 != 1)
                    {
                      localObject1 = locale2.R;
                      if (i4 != 0)
                      {
                        ((d)localObject1).a(this.e, this.i);
                        locale2.T.a(this.g, this.k);
                        localObject1 = locale2;
                        break label1055;
                      }
                      ((d)localObject1).a(locale1.R, 0);
                    }
                    localObject1 = locale2.T;
                    locald = locale1.T;
                  }
                  else
                  {
                    localObject1 = locale2.R;
                    locald = locale1.R;
                  }
                }
                ((d)localObject1).a(locald, 0);
                localObject1 = locale2;
              }
              else
              {
                paramInt = 3;
                localObject1 = locale2;
              }
            }
            label1055:
            i1 += 1;
          }
        }
        e locale1 = this.b;
        locale1.R0(g.l2(g.this));
        int i5 = this.h;
        i1 = i5;
        if (paramInt > 0) {
          i1 = i5 + g.T1(g.this);
        }
        if (paramBoolean1)
        {
          locale1.S.a(this.f, i1);
          if (paramBoolean2) {
            locale1.Q.a(this.d, this.j);
          }
          if (paramInt <= 0) {
            break label1242;
          }
          localObject1 = this.f.d.Q;
          locald = locale1.S;
        }
        else
        {
          locale1.Q.a(this.d, i1);
          if (paramBoolean2) {
            locale1.S.a(this.f, this.j);
          }
          if (paramInt <= 0) {
            break label1242;
          }
          localObject1 = this.d.d.S;
          locald = locale1.Q;
        }
        ((d)localObject1).a(locald, 0);
        label1242:
        i1 = 0;
        localObject1 = localObject2;
        while (i1 < i7)
        {
          if (this.n + i1 >= g.h2(g.this)) {
            return;
          }
          localObject2 = g.i2(g.this)[(this.n + i1)];
          if (localObject2 != null)
          {
            if (i1 == 0)
            {
              ((e)localObject2).l(((e)localObject2).R, this.e, this.i);
              i5 = g.j2(g.this);
              f2 = g.Z1(g.this);
              if ((this.n == 0) && (g.a2(g.this) != -1))
              {
                paramInt = g.a2(g.this);
                f1 = g.b2(g.this);
              }
              else
              {
                paramInt = i5;
                f1 = f2;
                if (paramBoolean2)
                {
                  paramInt = i5;
                  f1 = f2;
                  if (g.c2(g.this) != -1)
                  {
                    paramInt = g.c2(g.this);
                    f1 = g.d2(g.this);
                  }
                }
              }
              ((e)localObject2).i1(paramInt);
              ((e)localObject2).h1(f1);
            }
            if (i1 == i7 - 1) {
              ((e)localObject2).l(((e)localObject2).T, this.g, this.k);
            }
            if (localObject1 != null)
            {
              ((e)localObject2).R.a(((e)localObject1).T, g.U1(g.this));
              if (i1 == i2) {
                ((e)localObject2).R.u(this.i);
              }
              ((e)localObject1).T.a(((e)localObject2).R, 0);
              if (i1 == i3 + 1) {
                ((e)localObject1).T.u(this.k);
              }
            }
            if (localObject2 != locale1)
            {
              paramInt = g.e2(g.this);
              if (paramBoolean1)
              {
                if (paramInt != 0) {
                  if (paramInt != 1)
                  {
                    if (paramInt != 2) {
                      break label1760;
                    }
                    ((e)localObject2).Q.a(locale1.Q, 0);
                  }
                  else
                  {
                    localObject1 = ((e)localObject2).Q;
                    locald = locale1.Q;
                    break label1630;
                  }
                }
                localObject1 = ((e)localObject2).S;
                locald = locale1.S;
                label1630:
                ((d)localObject1).a(locald, 0);
              }
              else
              {
                if (paramInt != 0)
                {
                  if (paramInt != 1)
                  {
                    if (paramInt != 2) {
                      break label1760;
                    }
                    localObject1 = ((e)localObject2).Q;
                    if (i4 != 0)
                    {
                      ((d)localObject1).a(this.d, this.h);
                      ((e)localObject2).S.a(this.f, this.j);
                      break label1760;
                    }
                    ((d)localObject1).a(locale1.Q, 0);
                  }
                  localObject1 = ((e)localObject2).S;
                  locald = locale1.S;
                }
                else
                {
                  localObject1 = ((e)localObject2).Q;
                  locald = locale1.Q;
                }
                ((d)localObject1).a(locald, 0);
              }
            }
            label1760:
            localObject1 = localObject2;
          }
          i1 += 1;
        }
      }
    }
    
    public int e()
    {
      if (this.a == 1) {
        return this.m - g.U1(g.this);
      }
      return this.m;
    }
    
    public int f()
    {
      if (this.a == 0) {
        return this.l - g.T1(g.this);
      }
      return this.l;
    }
    
    public void g(int paramInt)
    {
      int i1 = this.p;
      if (i1 == 0) {
        return;
      }
      int i4 = this.o;
      paramInt /= i1;
      i1 = 0;
      while ((i1 < i4) && (this.n + i1 < g.h2(g.this)))
      {
        e locale = g.i2(g.this)[(this.n + i1)];
        g localg;
        e.b localb1;
        e.b localb2;
        int i3;
        int i2;
        if (this.a == 0)
        {
          if ((locale == null) || (locale.C() != e.b.c) || (locale.w != 0)) {
            break label189;
          }
          localg = g.this;
          localb1 = e.b.a;
          localb2 = locale.V();
          i3 = locale.z();
          i2 = paramInt;
        }
        else
        {
          if ((locale == null) || (locale.V() != e.b.c) || (locale.x != 0)) {
            break label189;
          }
          localg = g.this;
          localb1 = locale.C();
          i2 = locale.Y();
          localb2 = e.b.a;
          i3 = paramInt;
        }
        localg.H1(locale, localb1, i2, localb2, i3);
        label189:
        i1 += 1;
      }
      h();
    }
    
    public void i(int paramInt)
    {
      this.n = paramInt;
    }
    
    public void j(int paramInt1, d paramd1, d paramd2, d paramd3, d paramd4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.a = paramInt1;
      this.d = paramd1;
      this.e = paramd2;
      this.f = paramd3;
      this.g = paramd4;
      this.h = paramInt2;
      this.i = paramInt3;
      this.j = paramInt4;
      this.k = paramInt5;
      this.q = paramInt6;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.g
 * JD-Core Version:    0.7.0.1
 */