package z;

import androidx.camera.core.d1;
import androidx.camera.core.e1;
import s.n;
import s.p;
import s.q;
import s.t;
import s.u;

public final class e
  extends a<e1>
{
  public e(int paramInt, c<e1> paramc)
  {
    super(paramInt, paramc);
  }
  
  private boolean e(d1 paramd1)
  {
    paramd1 = u.a(paramd1);
    if ((paramd1.g() != p.f) && (paramd1.g() != p.d)) {
      return false;
    }
    if (paramd1.c() != n.e) {
      return false;
    }
    return paramd1.d() == q.d;
  }
  
  public void d(e1 parame1)
  {
    if (e(parame1.q()))
    {
      super.b(parame1);
      return;
    }
    this.d.a(parame1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z.e
 * JD-Core Version:    0.7.0.1
 */