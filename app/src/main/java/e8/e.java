package e8;

import com.yanzhenjie.permission.bridge.a.a;
import com.yanzhenjie.permission.bridge.d;
import l8.c;

class e
  extends a
  implements c8.e, a.a
{
  private c f;
  
  e(c paramc)
  {
    super(paramc);
    this.f = paramc;
  }
  
  public void b()
  {
    if (this.f.a())
    {
      d();
      e();
      return;
    }
    c();
  }
  
  public void g()
  {
    com.yanzhenjie.permission.bridge.a locala = new com.yanzhenjie.permission.bridge.a(this.f);
    locala.g(3);
    locala.e(this);
    d.b().a(locala);
  }
  
  public void start()
  {
    if (this.f.a())
    {
      d();
      e();
      return;
    }
    f(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e8.e
 * JD-Core Version:    0.7.0.1
 */