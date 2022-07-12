package b0;

import a0.j;
import a0.o;
import android.os.Build;
import s.b2;

public class c
  implements b2
{
  private boolean a = a();
  
  private static boolean a()
  {
    if (j.b().a(o.c) < 0) {
      return false;
    }
    return j.d();
  }
  
  private static boolean b()
  {
    return ("motorola".equalsIgnoreCase(Build.BRAND)) && ("smith".equalsIgnoreCase(Build.DEVICE));
  }
  
  private static boolean c()
  {
    return ("google".equalsIgnoreCase(Build.BRAND)) && ("redfin".equalsIgnoreCase(Build.DEVICE));
  }
  
  static boolean d()
  {
    return (c()) || (b()) || (a());
  }
  
  public boolean e(String paramString, int paramInt)
  {
    if ((c()) && (!this.a)) {
      return true;
    }
    return (b()) && (("0".equals(paramString)) || ("1".equals(paramString))) && (1 == paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b0.c
 * JD-Core Version:    0.7.0.1
 */