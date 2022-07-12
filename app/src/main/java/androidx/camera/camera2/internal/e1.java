package androidx.camera.camera2.internal;

import m.b;
import m.d;
import s.g2;
import s.g2.b;
import s.g2.d;
import s.s0;
import s.t2;
import s.u1;
import s.y1;

final class e1
  implements g2.d
{
  static final e1 a = new e1();
  
  public void a(t2<?> paramt2, g2.b paramb)
  {
    g2 localg2 = paramt2.k(null);
    Object localObject = y1.J();
    int i = g2.a().l();
    if (localg2 != null)
    {
      i = localg2.l();
      paramb.a(localg2.b());
      paramb.c(localg2.i());
      paramb.b(localg2.g());
      localObject = localg2.d();
    }
    paramb.r((s0)localObject);
    paramt2 = new b(paramt2);
    paramb.t(paramt2.M(i));
    paramb.e(paramt2.N(i1.b()));
    paramb.k(paramt2.Q(h1.b()));
    paramb.d(n1.d(paramt2.P(k0.c())));
    localObject = u1.M();
    ((u1)localObject).G(b.F, paramt2.J(d.e()));
    ((u1)localObject).G(b.H, paramt2.O(null));
    paramb.g((s0)localObject);
    paramb.g(paramt2.K());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.e1
 * JD-Core Version:    0.7.0.1
 */