package p;

import android.os.Build;
import n.z;
import x.d;

public final class g0
  implements d
{
  private static boolean a()
  {
    return ("motorola".equalsIgnoreCase(Build.BRAND)) && ("MotoG3".equalsIgnoreCase(Build.MODEL));
  }
  
  private static boolean b()
  {
    return ("samsung".equalsIgnoreCase(Build.BRAND)) && ("SM-G532F".equalsIgnoreCase(Build.MODEL));
  }
  
  private static boolean c()
  {
    return ("samsung".equalsIgnoreCase(Build.BRAND)) && ("SM-J700F".equalsIgnoreCase(Build.MODEL));
  }
  
  static boolean d(z paramz)
  {
    return (a()) || (b()) || (c());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.g0
 * JD-Core Version:    0.7.0.1
 */