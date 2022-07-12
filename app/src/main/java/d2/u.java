package d2;

import x0.e;
import x2.k;
import y2.a;
import y2.a.d;
import y2.a.f;
import y2.c;

final class u<Z>
  implements v<Z>, a.f
{
  private static final e<u<?>> e = a.d(20, new a());
  private final c a = c.a();
  private v<Z> b;
  private boolean c;
  private boolean d;
  
  private void b(v<Z> paramv)
  {
    this.d = false;
    this.c = true;
    this.b = paramv;
  }
  
  static <Z> u<Z> f(v<Z> paramv)
  {
    u localu = (u)k.d((u)e.b());
    localu.b(paramv);
    return localu;
  }
  
  private void g()
  {
    this.b = null;
    e.a(this);
  }
  
  public void a()
  {
    try
    {
      this.a.c();
      this.d = true;
      if (!this.c)
      {
        this.b.a();
        g();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int c()
  {
    return this.b.c();
  }
  
  public Class<Z> d()
  {
    return this.b.d();
  }
  
  public c e()
  {
    return this.a;
  }
  
  public Z get()
  {
    return this.b.get();
  }
  
  void h()
  {
    try
    {
      this.a.c();
      if (this.c)
      {
        this.c = false;
        if (this.d) {
          a();
        }
        return;
      }
      throw new IllegalStateException("Already unlocked");
    }
    finally {}
  }
  
  class a
    implements a.d<u<?>>
  {
    public u<?> b()
    {
      return new u();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.u
 * JD-Core Version:    0.7.0.1
 */