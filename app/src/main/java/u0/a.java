package u0;

import android.os.Build.VERSION;

public class a
{
  protected static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = "REL".equals(paramString2);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramString2.compareTo(paramString1) >= 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  @Deprecated
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 30;
  }
  
  public static boolean c()
  {
    return (Build.VERSION.SDK_INT >= 31) || (a("S", Build.VERSION.CODENAME));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u0.a
 * JD-Core Version:    0.7.0.1
 */