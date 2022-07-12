package x;

import android.os.Build;
import s.b2;
import s.n0;
import s.s0.a;

public final class c
  implements b2
{
  private static boolean a()
  {
    return ("HONOR".equalsIgnoreCase(Build.BRAND)) && ("STK-LX1".equalsIgnoreCase(Build.MODEL));
  }
  
  private static boolean b()
  {
    return ("HUAWEI".equalsIgnoreCase(Build.BRAND)) && ("SNE-LX1".equalsIgnoreCase(Build.MODEL));
  }
  
  static boolean d()
  {
    return (b()) || (a());
  }
  
  public boolean c(s0.a<?> parama)
  {
    return parama != n0.h;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x.c
 * JD-Core Version:    0.7.0.1
 */