package l0;

import java.util.List;
import k0.e;
import k0.h;

class j
  extends p
{
  public j(e parame)
  {
    super(parame);
    parame.e.f();
    parame.f.f();
    this.f = ((h)parame).w1();
  }
  
  private void q(f paramf)
  {
    this.h.k.add(paramf);
    paramf.l.add(this.h);
  }
  
  public void a(d paramd)
  {
    paramd = this.h;
    if (!paramd.c) {
      return;
    }
    if (paramd.j) {
      return;
    }
    paramd = (f)paramd.l.get(0);
    h localh = (h)this.b;
    int i = (int)(paramd.g * localh.z1() + 0.5F);
    this.h.d(i);
  }
  
  void d()
  {
    Object localObject = (h)this.b;
    int i = ((h)localObject).x1();
    int j = ((h)localObject).y1();
    ((h)localObject).z1();
    if (((h)localObject).w1() == 1)
    {
      localObject = this.h;
      if (i != -1)
      {
        ((f)localObject).l.add(this.b.c0.e.h);
        this.b.c0.e.h.k.add(this.h);
        localObject = this.h;
      }
      for (;;)
      {
        ((f)localObject).f = i;
        break label222;
        if (j == -1) {
          break;
        }
        ((f)localObject).l.add(this.b.c0.e.i);
        this.b.c0.e.i.k.add(this.h);
        localObject = this.h;
        i = -j;
      }
      ((f)localObject).b = true;
      ((f)localObject).l.add(this.b.c0.e.i);
      this.b.c0.e.i.k.add(this.h);
      label222:
      q(this.b.e.h);
      localObject = this.b.e;
    }
    else
    {
      localObject = this.h;
      if (i != -1)
      {
        ((f)localObject).l.add(this.b.c0.f.h);
        this.b.c0.f.h.k.add(this.h);
        localObject = this.h;
      }
      for (;;)
      {
        ((f)localObject).f = i;
        break label438;
        if (j == -1) {
          break;
        }
        ((f)localObject).l.add(this.b.c0.f.i);
        this.b.c0.f.i.k.add(this.h);
        localObject = this.h;
        i = -j;
      }
      ((f)localObject).b = true;
      ((f)localObject).l.add(this.b.c0.f.i);
      this.b.c0.f.i.k.add(this.h);
      label438:
      q(this.b.f.h);
      localObject = this.b.f;
    }
    q(((p)localObject).i);
  }
  
  public void e()
  {
    if (((h)this.b).w1() == 1)
    {
      this.b.q1(this.h.g);
      return;
    }
    this.b.r1(this.h.g);
  }
  
  void f()
  {
    this.h.c();
  }
  
  boolean m()
  {
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.j
 * JD-Core Version:    0.7.0.1
 */