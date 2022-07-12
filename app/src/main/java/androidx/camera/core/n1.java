package androidx.camera.core;

import android.os.Build.VERSION;
import android.util.Log;

public final class n1
{
  private static int a = 3;
  
  public static void a(String paramString1, String paramString2)
  {
    paramString1 = j(paramString1);
    if (g(paramString1, 3)) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    paramString1 = j(paramString1);
    if (g(paramString1, 3)) {
      Log.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    paramString1 = j(paramString1);
    if (g(paramString1, 6)) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    paramString1 = j(paramString1);
    if (g(paramString1, 6)) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    paramString1 = j(paramString1);
    if (g(paramString1, 4)) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static boolean f(String paramString)
  {
    return g(j(paramString), 3);
  }
  
  private static boolean g(String paramString, int paramInt)
  {
    return (a <= paramInt) || (Log.isLoggable(paramString, paramInt));
  }
  
  static void h()
  {
    a = 3;
  }
  
  static void i(int paramInt)
  {
    a = paramInt;
  }
  
  private static String j(String paramString)
  {
    String str = paramString;
    if (Build.VERSION.SDK_INT <= 25)
    {
      str = paramString;
      if (23 < paramString.length()) {
        str = paramString.substring(0, 23);
      }
    }
    return str;
  }
  
  public static void k(String paramString1, String paramString2)
  {
    paramString1 = j(paramString1);
    if (g(paramString1, 5)) {
      Log.w(paramString1, paramString2);
    }
  }
  
  public static void l(String paramString1, String paramString2, Throwable paramThrowable)
  {
    paramString1 = j(paramString1);
    if (g(paramString1, 5)) {
      Log.w(paramString1, paramString2, paramThrowable);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.n1
 * JD-Core Version:    0.7.0.1
 */