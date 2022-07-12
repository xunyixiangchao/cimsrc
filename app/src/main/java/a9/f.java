package a9;

import java.util.Arrays;
import o8.c;
import o8.n;

public class f
{
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static void b(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append(paramString);
    paramObject.append(" must not be null");
    throw ((IllegalStateException)k(new IllegalStateException(paramObject.toString())));
  }
  
  public static void c(Object paramObject)
  {
    if (paramObject == null) {
      n();
    }
  }
  
  public static void d(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      o(paramString);
    }
  }
  
  public static void e(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append(paramString);
    paramObject.append(" must not be null");
    throw ((NullPointerException)k(new NullPointerException(paramObject.toString())));
  }
  
  public static void f(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      r(paramString);
    }
  }
  
  public static void g(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      q(paramString);
    }
  }
  
  public static int h(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  public static int i(long paramLong1, long paramLong2)
  {
    boolean bool = paramLong1 < paramLong2;
    if (bool) {
      return -1;
    }
    if (!bool) {
      return 0;
    }
    return 1;
  }
  
  private static String j(String paramString)
  {
    Object localObject = java.lang.Thread.currentThread().getStackTrace()[4];
    String str = ((StackTraceElement)localObject).getClassName();
    localObject = ((StackTraceElement)localObject).getMethodName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Parameter specified as non-null is null: method ");
    localStringBuilder.append(str);
    localStringBuilder.append(".");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", parameter ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static <T extends Throwable> T k(T paramT)
  {
    return l(paramT, f.class.getName());
  }
  
  static <T extends Throwable> T l(T paramT, String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramT.getStackTrace();
    int k = arrayOfStackTraceElement.length;
    int j = -1;
    int i = 0;
    while (i < k)
    {
      if (paramString.equals(arrayOfStackTraceElement[i].getClassName())) {
        j = i;
      }
      i += 1;
    }
    paramT.setStackTrace((StackTraceElement[])Arrays.copyOfRange(arrayOfStackTraceElement, j + 1, k));
    return paramT;
  }
  
  public static String m(String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramObject);
    return localStringBuilder.toString();
  }
  
  public static void n()
  {
    throw ((NullPointerException)k(new NullPointerException()));
  }
  
  public static void o(String paramString)
  {
    throw ((NullPointerException)k(new NullPointerException(paramString)));
  }
  
  public static void p()
  {
    throw ((c)k(new c()));
  }
  
  private static void q(String paramString)
  {
    throw ((IllegalArgumentException)k(new IllegalArgumentException(j(paramString))));
  }
  
  private static void r(String paramString)
  {
    throw ((NullPointerException)k(new NullPointerException(j(paramString))));
  }
  
  public static void s(String paramString)
  {
    throw ((n)k(new n(paramString)));
  }
  
  public static void t(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lateinit property ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" has not been initialized");
    s(localStringBuilder.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a9.f
 * JD-Core Version:    0.7.0.1
 */