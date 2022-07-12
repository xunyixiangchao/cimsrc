package a0;

import android.content.Context;
import s.s0;
import s.t2;
import s.u1;
import s.u2;
import s.u2.b;
import s.y1;

public final class k
  implements u2
{
  private final l b;
  private final m c;
  
  public k(int paramInt, n paramn, Context paramContext)
  {
    this.b = new l(paramInt, paramn, paramContext);
    this.c = new m(paramInt, paramn, paramContext);
  }
  
  public s0 a(u2.b paramb, int paramInt)
  {
    paramInt = a.a[paramb.ordinal()];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return null;
        }
        throw new IllegalArgumentException("CameraX Extensions doesn't support VideoCapture!");
      }
      paramb = this.c.a();
    }
    else
    {
      paramb = this.b.a();
    }
    paramb = u1.N(paramb);
    paramb.G(t2.u, Boolean.TRUE);
    return y1.K(paramb);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.k
 * JD-Core Version:    0.7.0.1
 */