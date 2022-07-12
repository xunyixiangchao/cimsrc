package l0;

import java.util.Iterator;
import java.util.List;
import k0.a;
import k0.e;
import k0.j;

class k
  extends p
{
  public k(e parame)
  {
    super(parame);
  }
  
  private void q(f paramf)
  {
    this.h.k.add(paramf);
    paramf.l.add(this.h);
  }
  
  public void a(d paramd)
  {
    paramd = (a)this.b;
    int n = paramd.z1();
    Iterator localIterator = this.h.l.iterator();
    int i = 0;
    int j = -1;
    while (localIterator.hasNext())
    {
      int k = ((f)localIterator.next()).g;
      int m;
      if (j != -1)
      {
        m = j;
        if (k >= j) {}
      }
      else
      {
        m = k;
      }
      j = m;
      if (i < k)
      {
        i = k;
        j = m;
      }
    }
    if ((n != 0) && (n != 2))
    {
      this.h.d(i + paramd.A1());
      return;
    }
    this.h.d(j + paramd.A1());
  }
  
  void d()
  {
    Object localObject1 = this.b;
    if ((localObject1 instanceof a))
    {
      this.h.b = true;
      localObject1 = (a)localObject1;
      int n = ((a)localObject1).z1();
      boolean bool = ((a)localObject1).y1();
      int j = 0;
      int k = 0;
      int m = 0;
      int i = 0;
      Object localObject2;
      if (n != 0)
      {
        if (n != 1)
        {
          if (n != 2)
          {
            if (n != 3) {
              return;
            }
            this.h.e = f.a.g;
            while (i < ((j)localObject1).W0)
            {
              localObject2 = localObject1.V0[i];
              if ((bool) || (((e)localObject2).X() != 8))
              {
                localObject2 = ((e)localObject2).f.i;
                ((f)localObject2).k.add(this.h);
                this.h.l.add(localObject2);
              }
              i += 1;
            }
          }
          this.h.e = f.a.f;
          i = j;
          while (i < ((j)localObject1).W0)
          {
            localObject2 = localObject1.V0[i];
            if ((bool) || (((e)localObject2).X() != 8))
            {
              localObject2 = ((e)localObject2).f.h;
              ((f)localObject2).k.add(this.h);
              this.h.l.add(localObject2);
            }
            i += 1;
          }
          q(this.b.f.h);
          localObject1 = this.b.f;
        }
        else
        {
          this.h.e = f.a.e;
          i = k;
          while (i < ((j)localObject1).W0)
          {
            localObject2 = localObject1.V0[i];
            if ((bool) || (((e)localObject2).X() != 8))
            {
              localObject2 = ((e)localObject2).e.i;
              ((f)localObject2).k.add(this.h);
              this.h.l.add(localObject2);
            }
            i += 1;
          }
        }
      }
      else
      {
        this.h.e = f.a.d;
        i = m;
        while (i < ((j)localObject1).W0)
        {
          localObject2 = localObject1.V0[i];
          if ((bool) || (((e)localObject2).X() != 8))
          {
            localObject2 = ((e)localObject2).e.h;
            ((f)localObject2).k.add(this.h);
            this.h.l.add(localObject2);
          }
          i += 1;
        }
        q(this.b.e.h);
        localObject1 = this.b.e;
      }
      q(((p)localObject1).i);
    }
  }
  
  public void e()
  {
    e locale = this.b;
    if ((locale instanceof a))
    {
      int i = ((a)locale).z1();
      if ((i != 0) && (i != 1))
      {
        this.b.r1(this.h.g);
        return;
      }
      this.b.q1(this.h.g);
    }
  }
  
  void f()
  {
    this.c = null;
    this.h.c();
  }
  
  boolean m()
  {
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.k
 * JD-Core Version:    0.7.0.1
 */