package androidx.camera.core;

import android.graphics.Matrix;
import androidx.camera.core.impl.utils.g.b;
import s.n2;

abstract class l1
  implements d1
{
  public static d1 e(n2 paramn2, long paramLong, int paramInt, Matrix paramMatrix)
  {
    return new h(paramn2, paramLong, paramInt, paramMatrix);
  }
  
  public abstract n2 a();
  
  public void b(g.b paramb)
  {
    paramb.m(c());
  }
  
  public abstract int c();
  
  public abstract Matrix d();
  
  public abstract long getTimestamp();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.l1
 * JD-Core Version:    0.7.0.1
 */