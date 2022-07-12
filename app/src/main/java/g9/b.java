package g9;

import java.text.DecimalFormat;

public final class b
{
  private static final boolean a;
  private static final ThreadLocal<DecimalFormat>[] b;
  
  static
  {
    int i = 0;
    a = false;
    ThreadLocal[] arrayOfThreadLocal = new ThreadLocal[4];
    while (i < 4)
    {
      arrayOfThreadLocal[i] = new ThreadLocal();
      i += 1;
    }
    b = arrayOfThreadLocal;
  }
  
  public static final boolean a()
  {
    return a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g9.b
 * JD-Core Version:    0.7.0.1
 */