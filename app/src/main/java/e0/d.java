package e0;

import android.os.Build;
import android.os.Build.VERSION;
import s.b2;

public class d
  implements b2
{
  private static boolean a()
  {
    return ("OPPO".equalsIgnoreCase(Build.MANUFACTURER)) && ("OP4E75L1".equalsIgnoreCase(Build.DEVICE));
  }
  
  private static boolean b()
  {
    if ("SAMSUNG".equalsIgnoreCase(Build.MANUFACTURER))
    {
      String str = Build.DEVICE;
      if (("F2Q".equalsIgnoreCase(str)) || ("Q2Q".equalsIgnoreCase(str))) {
        return true;
      }
    }
    return false;
  }
  
  static boolean c()
  {
    return (Build.VERSION.SDK_INT < 33) && ((b()) || (a()));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e0.d
 * JD-Core Version:    0.7.0.1
 */