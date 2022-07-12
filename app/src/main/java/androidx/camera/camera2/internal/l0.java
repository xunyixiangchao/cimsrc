package androidx.camera.camera2.internal;

import m.b;
import s.n0;
import s.n0.a;
import s.n0.b;
import s.s0;
import s.t2;
import s.y1;

class l0
  implements n0.b
{
  static final l0 a = new l0();
  
  public void a(t2<?> paramt2, n0.a parama)
  {
    n0 localn0 = paramt2.x(null);
    Object localObject = y1.J();
    int i = n0.a().g();
    if (localn0 != null)
    {
      i = localn0.g();
      parama.a(localn0.b());
      localObject = localn0.d();
    }
    parama.o((s0)localObject);
    paramt2 = new b(paramt2);
    parama.p(paramt2.M(i));
    parama.c(n1.d(paramt2.P(k0.c())));
    parama.e(paramt2.K());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.l0
 * JD-Core Version:    0.7.0.1
 */