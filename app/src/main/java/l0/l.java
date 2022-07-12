package l0;

import java.util.List;
import k0.d.b;
import k0.e;
import k0.e.b;
import k0.i;

public class l
  extends p
{
  private static int[] k = new int[2];
  
  public l(e parame)
  {
    super(parame);
    this.h.e = f.a.d;
    this.i.e = f.a.e;
    this.f = 0;
  }
  
  private void q(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    paramInt1 = paramInt2 - paramInt1;
    paramInt2 = paramInt4 - paramInt3;
    if (paramInt5 != -1)
    {
      if (paramInt5 != 0)
      {
        if (paramInt5 != 1) {
          return;
        }
        paramInt2 = (int)(paramInt1 * paramFloat + 0.5F);
        paramArrayOfInt[0] = paramInt1;
        paramArrayOfInt[1] = paramInt2;
        return;
      }
      paramArrayOfInt[0] = ((int)(paramInt2 * paramFloat + 0.5F));
      paramArrayOfInt[1] = paramInt2;
      return;
    }
    paramInt3 = (int)(paramInt2 * paramFloat + 0.5F);
    paramInt4 = (int)(paramInt1 / paramFloat + 0.5F);
    if (paramInt3 <= paramInt1)
    {
      paramArrayOfInt[0] = paramInt3;
      paramArrayOfInt[1] = paramInt2;
      return;
    }
    if (paramInt4 <= paramInt2)
    {
      paramArrayOfInt[0] = paramInt1;
      paramArrayOfInt[1] = paramInt4;
    }
  }
  
  public void a(d paramd)
  {
    int i = a.a[this.j.ordinal()];
    Object localObject1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          localObject1 = this.b;
          n(paramd, ((e)localObject1).Q, ((e)localObject1).S, 0);
        }
      }
      else {
        o(paramd);
      }
    }
    else {
      p(paramd);
    }
    float f;
    label201:
    label207:
    int j;
    int m;
    if ((!this.e.j) && (this.d == e.b.c))
    {
      Object localObject2 = this.b;
      i = ((e)localObject2).w;
      if (i != 2)
      {
        if (i != 3) {
          break label1465;
        }
        i = ((e)localObject2).x;
        if ((i != 0) && (i != 3))
        {
          i = ((e)localObject2).y();
          if (i != -1) {
            if (i != 0)
            {
              if (i != 1)
              {
                i = 0;
                break label207;
              }
            }
            else
            {
              paramd = this.b;
              f = paramd.f.e.g / paramd.x();
              break label201;
            }
          }
          paramd = this.b;
          f = paramd.f.e.g * paramd.x();
        }
      }
      for (i = (int)(f + 0.5F);; i = (int)(paramd.g * f + 0.5F))
      {
        this.e.d(i);
        break;
        localObject1 = ((e)localObject2).f;
        paramd = ((p)localObject1).h;
        localObject1 = ((p)localObject1).i;
        if (((e)localObject2).Q.f != null) {
          i = 1;
        } else {
          i = 0;
        }
        if (((e)localObject2).R.f != null) {
          j = 1;
        } else {
          j = 0;
        }
        if (((e)localObject2).S.f != null) {
          m = 1;
        } else {
          m = 0;
        }
        int n;
        if (((e)localObject2).T.f != null) {
          n = 1;
        } else {
          n = 0;
        }
        int i1 = ((e)localObject2).y();
        if ((i != 0) && (j != 0) && (m != 0) && (n != 0))
        {
          f = this.b.x();
          int i2;
          int i3;
          int i4;
          int i5;
          if ((paramd.j) && (((f)localObject1).j))
          {
            localObject2 = this.h;
            if (((f)localObject2).c)
            {
              if (!this.i.c) {
                return;
              }
              i = ((f)((f)localObject2).l.get(0)).g;
              j = this.h.f;
              m = ((f)this.i.l.get(0)).g;
              n = this.i.f;
              i2 = paramd.g;
              i3 = paramd.f;
              i4 = ((f)localObject1).g;
              i5 = ((f)localObject1).f;
              q(k, i + j, m - n, i2 + i3, i4 - i5, f, i1);
              this.e.d(k[0]);
              this.b.f.e.d(k[1]);
            }
            return;
          }
          localObject2 = this.h;
          if (((f)localObject2).j)
          {
            f localf = this.i;
            if (localf.j) {
              if (paramd.c)
              {
                if (!((f)localObject1).c) {
                  return;
                }
                i = ((f)localObject2).g;
                j = ((f)localObject2).f;
                m = localf.g;
                n = localf.f;
                i2 = ((f)paramd.l.get(0)).g;
                i3 = paramd.f;
                i4 = ((f)((f)localObject1).l.get(0)).g;
                i5 = ((f)localObject1).f;
                q(k, i + j, m - n, i2 + i3, i4 - i5, f, i1);
                this.e.d(k[0]);
                this.b.f.e.d(k[1]);
              }
              else
              {
                return;
              }
            }
          }
          localObject2 = this.h;
          if ((((f)localObject2).c) && (this.i.c) && (paramd.c))
          {
            if (!((f)localObject1).c) {
              return;
            }
            i = ((f)((f)localObject2).l.get(0)).g;
            j = this.h.f;
            m = ((f)this.i.l.get(0)).g;
            n = this.i.f;
            i2 = ((f)paramd.l.get(0)).g;
            i3 = paramd.f;
            i4 = ((f)((f)localObject1).l.get(0)).g;
            i5 = ((f)localObject1).f;
            q(k, i + j, m - n, i2 + i3, i4 - i5, f, i1);
            this.e.d(k[0]);
            paramd = this.b.f.e;
            i = k[1];
          }
        }
        else
        {
          if ((i != 0) && (m != 0))
          {
            if (this.h.c)
            {
              if (!this.i.c) {
                return;
              }
              f = this.b.x();
              i = ((f)this.h.l.get(0)).g + this.h.f;
              j = ((f)this.i.l.get(0)).g - this.i.f;
              if ((i1 != -1) && (i1 != 0))
              {
                if (i1 != 1) {
                  break;
                }
                j = g(j - i, 0);
                n = (int)(j / f + 0.5F);
                m = g(n, 1);
                i = m;
                if (n == m) {
                  break label1151;
                }
                f = m * f;
                i = m;
              }
              else
              {
                j = g(j - i, 0);
                n = (int)(j * f + 0.5F);
                m = g(n, 1);
                i = m;
                if (n == m) {
                  break label1151;
                }
                f = m / f;
                i = m;
              }
              j = (int)(f + 0.5F);
              label1151:
              this.e.d(j);
              this.b.f.e.d(i);
              break;
            }
            return;
          }
          if ((j == 0) || (n == 0)) {
            break;
          }
          if (!paramd.c) {
            break label1416;
          }
          if (!((f)localObject1).c) {
            return;
          }
          f = this.b.x();
          i = ((f)paramd.l.get(0)).g + paramd.f;
          j = ((f)((f)localObject1).l.get(0)).g - ((f)localObject1).f;
          if (i1 != -1) {
            if (i1 != 0)
            {
              if (i1 != 1) {
                break;
              }
            }
            else
            {
              i = g(j - i, 1);
              n = (int)(i * f + 0.5F);
              m = g(n, 0);
              j = m;
              if (n == m) {
                break label1388;
              }
              f = m / f;
              j = m;
              break label1382;
            }
          }
          i = g(j - i, 1);
          n = (int)(i / f + 0.5F);
          m = g(n, 0);
          j = m;
          if (n != m)
          {
            f = m * f;
            j = m;
            label1382:
            i = (int)(f + 0.5F);
          }
          label1388:
          this.e.d(j);
          paramd = this.b.f.e;
        }
        paramd.d(i);
        break;
        label1416:
        return;
        paramd = ((e)localObject2).M();
        if (paramd == null) {
          break;
        }
        paramd = paramd.e.e;
        if (!paramd.j) {
          break;
        }
        f = this.b.B;
      }
    }
    label1465:
    paramd = this.h;
    if (paramd.c)
    {
      localObject1 = this.i;
      if (!((f)localObject1).c) {
        return;
      }
      if ((paramd.j) && (((f)localObject1).j) && (this.e.j)) {
        return;
      }
      if ((!this.e.j) && (this.d == e.b.c))
      {
        paramd = this.b;
        if ((paramd.w == 0) && (!paramd.k0()))
        {
          localObject1 = (f)this.h.l.get(0);
          paramd = (f)this.i.l.get(0);
          i = ((f)localObject1).g;
          localObject1 = this.h;
          i += ((f)localObject1).f;
          j = paramd.g + this.i.f;
          ((f)localObject1).d(i);
          this.i.d(j);
          this.e.d(j - i);
          return;
        }
      }
      if ((!this.e.j) && (this.d == e.b.c) && (this.a == 1) && (this.h.l.size() > 0) && (this.i.l.size() > 0))
      {
        paramd = (f)this.h.l.get(0);
        localObject1 = (f)this.i.l.get(0);
        i = paramd.g;
        j = this.h.f;
        i = Math.min(((f)localObject1).g + this.i.f - (i + j), this.e.m);
        paramd = this.b;
        m = paramd.A;
        j = Math.max(paramd.z, i);
        i = j;
        if (m > 0) {
          i = Math.min(m, j);
        }
        this.e.d(i);
      }
      if (!this.e.j) {
        return;
      }
      paramd = (f)this.h.l.get(0);
      localObject1 = (f)this.i.l.get(0);
      i = paramd.g + this.h.f;
      j = ((f)localObject1).g + this.i.f;
      f = this.b.A();
      if (paramd == localObject1)
      {
        i = paramd.g;
        j = ((f)localObject1).g;
        f = 0.5F;
      }
      m = this.e.g;
      this.h.d((int)(i + 0.5F + (j - i - m) * f));
      this.i.d(this.h.g + this.e.g);
    }
  }
  
  void d()
  {
    Object localObject1 = this.b;
    if (((e)localObject1).a) {
      this.e.d(((e)localObject1).Y());
    }
    int i;
    if (!this.e.j)
    {
      localObject2 = this.b.C();
      this.d = ((e.b)localObject2);
      if (localObject2 != e.b.c)
      {
        localObject1 = e.b.d;
        if (localObject2 == localObject1)
        {
          localObject2 = this.b.M();
          if ((localObject2 != null) && ((((e)localObject2).C() == e.b.a) || (((e)localObject2).C() == localObject1)))
          {
            i = ((e)localObject2).Y();
            int j = this.b.Q.f();
            int m = this.b.S.f();
            b(this.h, ((e)localObject2).e.h, this.b.Q.f());
            b(this.i, ((e)localObject2).e.i, -this.b.S.f());
            this.e.d(i - j - m);
            return;
          }
        }
        if (this.d == e.b.a) {
          this.e.d(this.b.Y());
        }
      }
    }
    else
    {
      localObject2 = this.d;
      localObject1 = e.b.d;
      if (localObject2 == localObject1)
      {
        localObject2 = this.b.M();
        if ((localObject2 != null) && ((((e)localObject2).C() == e.b.a) || (((e)localObject2).C() == localObject1)))
        {
          b(this.h, ((e)localObject2).e.h, this.b.Q.f());
          b(this.i, ((e)localObject2).e.i, -this.b.S.f());
          return;
        }
      }
    }
    localObject1 = this.e;
    if (((f)localObject1).j)
    {
      localObject2 = this.b;
      if (((e)localObject2).a)
      {
        localObject1 = ((e)localObject2).Y;
        if ((localObject1[0].f != null) && (localObject1[1].f != null))
        {
          if (((e)localObject2).k0())
          {
            this.h.f = this.b.Y[0].f();
            localObject1 = this.i;
            localObject2 = this.b.Y[1];
            break label1425;
          }
          localObject1 = h(this.b.Y[0]);
          if (localObject1 != null) {
            b(this.h, (f)localObject1, this.b.Y[0].f());
          }
          localObject1 = h(this.b.Y[1]);
          if (localObject1 != null) {
            b(this.i, (f)localObject1, -this.b.Y[1].f());
          }
          this.h.b = true;
          this.i.b = true;
          return;
        }
        if (localObject1[0].f != null)
        {
          localObject1 = h(localObject1[0]);
          if (localObject1 == null) {
            return;
          }
          localObject2 = this.h;
          i = this.b.Y[0].f();
        }
        else
        {
          if (localObject1[1].f != null)
          {
            localObject1 = h(localObject1[1]);
            if (localObject1 == null) {
              return;
            }
            b(this.i, (f)localObject1, -this.b.Y[1].f());
            localObject1 = this.h;
            localObject2 = this.i;
            i = -this.e.g;
            break label747;
          }
          if (((localObject2 instanceof i)) || (((e)localObject2).M() == null) || (this.b.q(d.b.g).f != null)) {
            return;
          }
          localObject1 = this.b.M().e.h;
          localObject2 = this.h;
          i = this.b.Z();
        }
        b((f)localObject2, (f)localObject1, i);
        localObject1 = this.i;
        localObject2 = this.h;
        i = this.e.g;
        label747:
        b((f)localObject1, (f)localObject2, i);
        return;
      }
    }
    if (this.d == e.b.c)
    {
      localObject2 = this.b;
      i = ((e)localObject2).w;
      if (i != 2)
      {
        if (i != 3) {
          break label1348;
        }
        if (((e)localObject2).x == 3)
        {
          this.h.a = this;
          this.i.a = this;
          n localn = ((e)localObject2).f;
          localn.h.a = this;
          localn.i.a = this;
          ((f)localObject1).a = this;
          if (((e)localObject2).m0())
          {
            this.e.l.add(this.b.f.e);
            this.b.f.e.k.add(this.e);
            localObject1 = this.b.f;
            ((p)localObject1).e.a = this;
            this.e.l.add(((p)localObject1).h);
            this.e.l.add(this.b.f.i);
            this.b.f.h.k.add(this.e);
            localObject1 = this.b.f.i.k;
            break label1232;
          }
          if (this.b.k0())
          {
            this.b.f.e.l.add(this.e);
            localObject1 = this.e.k;
            localObject2 = this.b.f.e;
            break label1338;
          }
          localObject1 = this.b.f.e;
        }
        else
        {
          localObject2 = ((e)localObject2).f.e;
          ((f)localObject1).l.add(localObject2);
          ((f)localObject2).k.add(this.e);
          this.b.f.h.k.add(this.e);
          this.b.f.i.k.add(this.e);
          localObject1 = this.e;
          ((f)localObject1).b = true;
          ((f)localObject1).k.add(this.h);
          this.e.k.add(this.i);
          this.h.l.add(this.e);
          localObject1 = this.i;
        }
        localObject1 = ((f)localObject1).l;
        label1232:
        localObject2 = this.e;
      }
      else
      {
        localObject1 = ((e)localObject2).M();
        if (localObject1 == null) {
          break label1348;
        }
        localObject1 = ((e)localObject1).f.e;
        this.e.l.add(localObject1);
        ((f)localObject1).k.add(this.e);
        localObject1 = this.e;
        ((f)localObject1).b = true;
        ((f)localObject1).k.add(this.h);
        localObject1 = this.e.k;
        localObject2 = this.i;
      }
      label1338:
      ((List)localObject1).add(localObject2);
    }
    label1348:
    localObject1 = this.b;
    Object localObject2 = ((e)localObject1).Y;
    if ((localObject2[0].f != null) && (localObject2[1].f != null))
    {
      if (((e)localObject1).k0())
      {
        this.h.f = this.b.Y[0].f();
        localObject1 = this.i;
        localObject2 = this.b.Y[1];
        label1425:
        ((f)localObject1).f = (-((k0.d)localObject2).f());
        return;
      }
      localObject1 = h(this.b.Y[0]);
      localObject2 = h(this.b.Y[1]);
      if (localObject1 != null) {
        ((f)localObject1).b(this);
      }
      if (localObject2 != null) {
        ((f)localObject2).b(this);
      }
      this.j = p.b.d;
      return;
    }
    if (localObject2[0].f != null)
    {
      localObject1 = h(localObject2[0]);
      if (localObject1 == null) {
        return;
      }
      localObject2 = this.h;
      i = this.b.Y[0].f();
    }
    else
    {
      if (localObject2[1].f != null)
      {
        localObject1 = h(localObject2[1]);
        if (localObject1 == null) {
          return;
        }
        b(this.i, (f)localObject1, -this.b.Y[1].f());
        c(this.h, this.i, -1, this.e);
        return;
      }
      if (((localObject1 instanceof i)) || (((e)localObject1).M() == null)) {
        return;
      }
      localObject1 = this.b.M().e.h;
      localObject2 = this.h;
      i = this.b.Z();
    }
    b((f)localObject2, (f)localObject1, i);
    c(this.i, this.h, 1, this.e);
  }
  
  public void e()
  {
    f localf = this.h;
    if (localf.j) {
      this.b.q1(localf.g);
    }
  }
  
  void f()
  {
    this.c = null;
    this.h.c();
    this.i.c();
    this.e.c();
    this.g = false;
  }
  
  boolean m()
  {
    if (this.d == e.b.c) {
      return this.b.w == 0;
    }
    return true;
  }
  
  void r()
  {
    this.g = false;
    this.h.c();
    this.h.j = false;
    this.i.c();
    this.i.j = false;
    this.e.j = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HorizontalRun ");
    localStringBuilder.append(this.b.v());
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.l
 * JD-Core Version:    0.7.0.1
 */