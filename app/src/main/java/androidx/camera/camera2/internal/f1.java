package androidx.camera.camera2.internal;

import android.content.Context;
import android.view.Display;
import q.m;
import s.g2.b;
import s.j1;
import s.n0.a;
import s.s0;
import s.s0.a;
import s.t2;
import s.u1;
import s.u2;
import s.u2.b;
import s.y1;

public final class f1
  implements u2
{
  final x1 b;
  
  public f1(Context paramContext)
  {
    this.b = x1.b(paramContext);
  }
  
  public s0 a(u2.b paramb, int paramInt)
  {
    u1 localu1 = u1.M();
    Object localObject2 = new g2.b();
    Object localObject1 = a.a;
    int i = localObject1[paramb.ordinal()];
    int j = 5;
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        if (i == 4) {
          ((g2.b)localObject2).t(3);
        }
      }
      else {
        ((g2.b)localObject2).t(1);
      }
    }
    else
    {
      if (paramInt == 2) {
        i = 5;
      } else {
        i = 1;
      }
      ((g2.b)localObject2).t(i);
    }
    u2.b localb = u2.b.b;
    if (paramb == localb) {
      m.a((g2.b)localObject2);
    }
    localu1.G(t2.n, ((g2.b)localObject2).n());
    localu1.G(t2.p, e1.a);
    localObject2 = new n0.a();
    i = localObject1[paramb.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        if (i == 4) {
          ((n0.a)localObject2).p(3);
        }
      }
      else {
        ((n0.a)localObject2).p(1);
      }
    }
    else
    {
      if (paramInt == 2) {
        paramInt = j;
      } else {
        paramInt = 2;
      }
      ((n0.a)localObject2).p(paramInt);
    }
    localu1.G(t2.o, ((n0.a)localObject2).h());
    localObject2 = t2.q;
    if (paramb == u2.b.a) {
      localObject1 = c2.c;
    } else {
      localObject1 = l0.a;
    }
    localu1.G((s0.a)localObject2, localObject1);
    if (paramb == localb) {
      localu1.G(j1.l, this.b.d());
    }
    paramInt = this.b.c().getRotation();
    localu1.G(j1.h, Integer.valueOf(paramInt));
    if (paramb == u2.b.d) {
      localu1.G(t2.u, Boolean.TRUE);
    }
    return y1.K(localu1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.f1
 * JD-Core Version:    0.7.0.1
 */