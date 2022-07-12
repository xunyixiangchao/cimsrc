package l0;

import java.util.List;
import k0.d.b;
import k0.e;
import k0.e.b;
import k0.i;

public class n
  extends p
{
  public f k;
  g l;
  
  public n(e parame)
  {
    super(parame);
    parame = new f(this);
    this.k = parame;
    this.l = null;
    this.h.e = f.a.f;
    this.i.e = f.a.g;
    parame.e = f.a.h;
    this.f = 1;
  }
  
  public void a(d paramd)
  {
    int i = a.a[this.j.ordinal()];
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          localObject = this.b;
          n(paramd, ((e)localObject).R, ((e)localObject).T, 1);
        }
      }
      else {
        o(paramd);
      }
    }
    else {
      p(paramd);
    }
    paramd = this.e;
    float f;
    if ((paramd.c) && (!paramd.j) && (this.d == e.b.c))
    {
      paramd = this.b;
      i = paramd.x;
      if (i != 2)
      {
        if ((i != 3) || (!paramd.e.e.j)) {
          break label266;
        }
        i = paramd.y();
        if (i != -1) {
          if (i != 0)
          {
            if (i != 1)
            {
              i = 0;
              break label208;
            }
          }
          else
          {
            paramd = this.b;
            f = paramd.e.e.g * paramd.x();
            break label202;
          }
        }
        paramd = this.b;
        f = paramd.e.e.g / paramd.x();
      }
      label202:
      for (i = (int)(f + 0.5F);; i = (int)(paramd.g * f + 0.5F))
      {
        label208:
        this.e.d(i);
        break;
        paramd = paramd.M();
        if (paramd == null) {
          break;
        }
        paramd = paramd.f.e;
        if (!paramd.j) {
          break;
        }
        f = this.b.E;
      }
    }
    label266:
    paramd = this.h;
    if (paramd.c)
    {
      localObject = this.i;
      if (!((f)localObject).c) {
        return;
      }
      if ((paramd.j) && (((f)localObject).j) && (this.e.j)) {
        return;
      }
      int j;
      if ((!this.e.j) && (this.d == e.b.c))
      {
        paramd = this.b;
        if ((paramd.w == 0) && (!paramd.m0()))
        {
          localObject = (f)this.h.l.get(0);
          paramd = (f)this.i.l.get(0);
          i = ((f)localObject).g;
          localObject = this.h;
          i += ((f)localObject).f;
          j = paramd.g + this.i.f;
          ((f)localObject).d(i);
          this.i.d(j);
          this.e.d(j - i);
          return;
        }
      }
      if ((!this.e.j) && (this.d == e.b.c) && (this.a == 1) && (this.h.l.size() > 0) && (this.i.l.size() > 0))
      {
        paramd = (f)this.h.l.get(0);
        localObject = (f)this.i.l.get(0);
        i = paramd.g;
        j = this.h.f;
        i = ((f)localObject).g + this.i.f - (i + j);
        paramd = this.e;
        j = paramd.m;
        if (i < j) {
          paramd.d(i);
        } else {
          paramd.d(j);
        }
      }
      if (!this.e.j) {
        return;
      }
      if ((this.h.l.size() > 0) && (this.i.l.size() > 0))
      {
        paramd = (f)this.h.l.get(0);
        localObject = (f)this.i.l.get(0);
        i = paramd.g + this.h.f;
        j = ((f)localObject).g + this.i.f;
        f = this.b.T();
        if (paramd == localObject)
        {
          i = paramd.g;
          j = ((f)localObject).g;
          f = 0.5F;
        }
        int m = this.e.g;
        this.h.d((int)(i + 0.5F + (j - i - m) * f));
        this.i.d(this.h.g + this.e.g);
      }
    }
  }
  
  void d()
  {
    Object localObject1 = this.b;
    if (((e)localObject1).a) {
      this.e.d(((e)localObject1).z());
    }
    int i;
    if (!this.e.j)
    {
      this.d = this.b.V();
      if (this.b.b0()) {
        this.l = new a(this);
      }
      localObject1 = this.d;
      if (localObject1 != e.b.c)
      {
        if (localObject1 == e.b.d)
        {
          localObject1 = this.b.M();
          if ((localObject1 != null) && (((e)localObject1).V() == e.b.a))
          {
            i = ((e)localObject1).z();
            int j = this.b.R.f();
            int m = this.b.T.f();
            b(this.h, ((e)localObject1).f.h, this.b.R.f());
            b(this.i, ((e)localObject1).f.i, -this.b.T.f());
            this.e.d(i - j - m);
            return;
          }
        }
        if (this.d == e.b.a) {
          this.e.d(this.b.z());
        }
      }
    }
    else if (this.d == e.b.d)
    {
      localObject1 = this.b.M();
      if ((localObject1 != null) && (((e)localObject1).V() == e.b.a))
      {
        b(this.h, ((e)localObject1).f.h, this.b.R.f());
        b(this.i, ((e)localObject1).f.i, -this.b.T.f());
        return;
      }
    }
    Object localObject2 = this.e;
    boolean bool = ((f)localObject2).j;
    if (bool)
    {
      localObject1 = this.b;
      if (((e)localObject1).a)
      {
        localObject2 = ((e)localObject1).Y;
        if ((localObject2[2].f != null) && (localObject2[3].f != null))
        {
          if (((e)localObject1).m0())
          {
            this.h.f = this.b.Y[2].f();
            this.i.f = (-this.b.Y[3].f());
          }
          else
          {
            localObject1 = h(this.b.Y[2]);
            if (localObject1 != null) {
              b(this.h, (f)localObject1, this.b.Y[2].f());
            }
            localObject1 = h(this.b.Y[3]);
            if (localObject1 != null) {
              b(this.i, (f)localObject1, -this.b.Y[3].f());
            }
            this.h.b = true;
            this.i.b = true;
          }
          if (!this.b.b0()) {
            return;
          }
        }
        for (;;)
        {
          localObject1 = this.k;
          localObject2 = this.h;
          for (i = this.b.r();; i = this.e.g)
          {
            b((f)localObject1, (f)localObject2, i);
            return;
            if (localObject2[2].f != null)
            {
              localObject1 = h(localObject2[2]);
              if (localObject1 == null) {
                return;
              }
              b(this.h, (f)localObject1, this.b.Y[2].f());
              b(this.i, this.h, this.e.g);
              if (!this.b.b0()) {
                return;
              }
              break;
            }
            if (localObject2[3].f != null)
            {
              localObject1 = h(localObject2[3]);
              if (localObject1 != null)
              {
                b(this.i, (f)localObject1, -this.b.Y[3].f());
                b(this.h, this.i, -this.e.g);
              }
              if (!this.b.b0()) {
                return;
              }
              break;
            }
            if (localObject2[4].f == null) {
              break label815;
            }
            localObject1 = h(localObject2[4]);
            if (localObject1 == null) {
              return;
            }
            b(this.k, (f)localObject1, 0);
            b(this.h, this.k, -this.b.r());
            localObject1 = this.i;
            localObject2 = this.h;
          }
          label815:
          if (((localObject1 instanceof i)) || (((e)localObject1).M() == null) || (this.b.q(d.b.g).f != null)) {
            break;
          }
          localObject1 = this.b.M().f.h;
          b(this.h, (f)localObject1, this.b.a0());
          b(this.i, this.h, this.e.g);
          if (!this.b.b0()) {
            break;
          }
        }
      }
    }
    if ((!bool) && (this.d == e.b.c))
    {
      localObject1 = this.b;
      i = ((e)localObject1).x;
      if (i != 2)
      {
        if ((i != 3) || (((e)localObject1).m0())) {
          break label1099;
        }
        localObject1 = this.b;
        if (((e)localObject1).w == 3) {
          break label1099;
        }
        localObject1 = ((e)localObject1).e;
      }
      else
      {
        localObject1 = ((e)localObject1).M();
        if (localObject1 == null) {
          break label1099;
        }
        localObject1 = ((e)localObject1).f;
      }
      localObject1 = ((p)localObject1).e;
      this.e.l.add(localObject1);
      ((f)localObject1).k.add(this.e);
      localObject1 = this.e;
      ((f)localObject1).b = true;
      ((f)localObject1).k.add(this.h);
      this.e.k.add(this.i);
    }
    else
    {
      ((f)localObject2).b(this);
    }
    label1099:
    localObject1 = this.b;
    localObject2 = ((e)localObject1).Y;
    if ((localObject2[2].f != null) && (localObject2[3].f != null))
    {
      if (((e)localObject1).m0())
      {
        this.h.f = this.b.Y[2].f();
        this.i.f = (-this.b.Y[3].f());
      }
      else
      {
        localObject1 = h(this.b.Y[2]);
        localObject2 = h(this.b.Y[3]);
        if (localObject1 != null) {
          ((f)localObject1).b(this);
        }
        if (localObject2 != null) {
          ((f)localObject2).b(this);
        }
        this.j = p.b.d;
      }
      if (this.b.b0())
      {
        localObject1 = this.k;
        localObject2 = this.h;
      }
    }
    else
    {
      for (g localg = this.l;; localg = this.e)
      {
        c((f)localObject1, (f)localObject2, 1, localg);
        break label1768;
        if (localObject2[2].f != null)
        {
          localObject1 = h(localObject2[2]);
          if (localObject1 == null) {
            break label1768;
          }
          b(this.h, (f)localObject1, this.b.Y[2].f());
          c(this.i, this.h, 1, this.e);
          if (this.b.b0()) {
            c(this.k, this.h, 1, this.l);
          }
          localObject1 = this.d;
          localObject2 = e.b.c;
          if ((localObject1 != localObject2) || (this.b.x() <= 0.0F)) {
            break label1768;
          }
          localObject1 = this.b.e;
          if (((p)localObject1).d != localObject2) {
            break label1768;
          }
          break label1719;
        }
        if (localObject2[3].f != null)
        {
          localObject1 = h(localObject2[3]);
          if (localObject1 == null) {
            break label1768;
          }
          b(this.i, (f)localObject1, -this.b.Y[3].f());
          c(this.h, this.i, -1, this.e);
          if (!this.b.b0()) {
            break label1768;
          }
          break;
        }
        if (localObject2[4].f == null) {
          break label1578;
        }
        localObject1 = h(localObject2[4]);
        if (localObject1 == null) {
          break label1768;
        }
        b(this.k, (f)localObject1, 0);
        c(this.h, this.k, -1, this.l);
        localObject1 = this.i;
        localObject2 = this.h;
      }
      label1578:
      if ((!(localObject1 instanceof i)) && (((e)localObject1).M() != null))
      {
        localObject1 = this.b.M().f.h;
        b(this.h, (f)localObject1, this.b.a0());
        c(this.i, this.h, 1, this.e);
        if (this.b.b0()) {
          c(this.k, this.h, 1, this.l);
        }
        localObject1 = this.d;
        localObject2 = e.b.c;
        if ((localObject1 == localObject2) && (this.b.x() > 0.0F))
        {
          localObject1 = this.b.e;
          if (((p)localObject1).d == localObject2)
          {
            label1719:
            ((p)localObject1).e.k.add(this.e);
            this.e.l.add(this.b.e.e);
            this.e.a = this;
          }
        }
      }
    }
    label1768:
    if (this.e.l.size() == 0) {
      this.e.c = true;
    }
  }
  
  public void e()
  {
    f localf = this.h;
    if (localf.j) {
      this.b.r1(localf.g);
    }
  }
  
  void f()
  {
    this.c = null;
    this.h.c();
    this.i.c();
    this.k.c();
    this.e.c();
    this.g = false;
  }
  
  boolean m()
  {
    if (this.d == e.b.c) {
      return this.b.x == 0;
    }
    return true;
  }
  
  void q()
  {
    this.g = false;
    this.h.c();
    this.h.j = false;
    this.i.c();
    this.i.j = false;
    this.k.c();
    this.k.j = false;
    this.e.j = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VerticalRun ");
    localStringBuilder.append(this.b.v());
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.n
 * JD-Core Version:    0.7.0.1
 */