package v8;

import a9.f;
import f9.l;

public final class b
{
  public static final a a;
  
  static
  {
    int i = a();
    if ((i >= 65544) || (i < 65536)) {}
    try
    {
      localObject = x8.a.class.newInstance();
      f.e(localObject, "forName(\"kotlin.internal…entations\").newInstance()");
      if (localObject == null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      Object localObject;
      a locala;
      label50:
      ClassLoader localClassLoader;
      StringBuilder localStringBuilder;
      break label127;
    }
    try
    {
      locala = (a)localObject;
    }
    catch (ClassCastException localClassCastException1)
    {
      break label50;
    }
    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    localObject = localObject.getClass().getClassLoader();
    localClassLoader = a.class.getClassLoader();
    if (!f.a(localObject, localClassLoader))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Instance class was loaded from a different classloader: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", base type classloader: ");
      localStringBuilder.append(localClassLoader);
      throw new ClassNotFoundException(localStringBuilder.toString(), locala);
    }
    throw locala;
    try
    {
      label127:
      localObject = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
      f.e(localObject, "forName(\"kotlin.internal…entations\").newInstance()");
      if (localObject == null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      break label241;
    }
    try
    {
      locala = (a)localObject;
    }
    catch (ClassCastException localClassCastException2)
    {
      break label164;
    }
    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    label164:
    localObject = localObject.getClass().getClassLoader();
    localClassLoader = a.class.getClassLoader();
    if (!f.a(localObject, localClassLoader))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Instance class was loaded from a different classloader: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", base type classloader: ");
      localStringBuilder.append(localClassLoader);
      throw new ClassNotFoundException(localStringBuilder.toString(), locala);
    }
    throw locala;
    label241:
    if ((i >= 65543) || (i < 65536)) {}
    try
    {
      localObject = w8.a.class.newInstance();
      f.e(localObject, "forName(\"kotlin.internal…entations\").newInstance()");
      if (localObject == null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException3)
    {
      break label364;
    }
    try
    {
      locala = (a)localObject;
    }
    catch (ClassCastException localClassCastException3)
    {
      break label287;
    }
    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    label287:
    localObject = localObject.getClass().getClassLoader();
    localClassLoader = a.class.getClassLoader();
    if (!f.a(localObject, localClassLoader))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Instance class was loaded from a different classloader: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", base type classloader: ");
      localStringBuilder.append(localClassLoader);
      throw new ClassNotFoundException(localStringBuilder.toString(), locala);
    }
    throw locala;
    try
    {
      label364:
      localObject = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
      f.e(localObject, "forName(\"kotlin.internal…entations\").newInstance()");
      if (localObject == null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException4)
    {
      label401:
      label478:
      break label478;
    }
    try
    {
      locala = (a)localObject;
    }
    catch (ClassCastException localClassCastException4)
    {
      break label401;
    }
    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    localObject = localObject.getClass().getClassLoader();
    localClassLoader = a.class.getClassLoader();
    if (!f.a(localObject, localClassLoader))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Instance class was loaded from a different classloader: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", base type classloader: ");
      localStringBuilder.append(localClassLoader);
      throw new ClassNotFoundException(localStringBuilder.toString(), locala);
    }
    throw locala;
    locala = new a();
    a = locala;
  }
  
  private static final int a()
  {
    String str2 = System.getProperty("java.specification.version");
    if (str2 == null) {
      return 65542;
    }
    int k = l.M(str2, '.', 0, false, 6, null);
    if (k < 0) {}
    try
    {
      i = Integer.parseInt(str2);
      return i * 65536;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        int m;
        String str1;
        int i = Integer.parseInt(str1);
        int j = Integer.parseInt(str2);
        return i * 65536 + j;
      }
      catch (NumberFormatException localNumberFormatException2) {}
      localNumberFormatException1 = localNumberFormatException1;
      return 65542;
    }
    m = k + 1;
    j = l.M(str2, '.', m, false, 4, null);
    i = j;
    if (j < 0) {
      i = str2.length();
    }
    str1 = str2.substring(0, k);
    f.e(str1, "this as java.lang.String…ing(startIndex, endIndex)");
    str2 = str2.substring(m, i);
    f.e(str2, "this as java.lang.String…ing(startIndex, endIndex)");
    return 65542;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v8.b
 * JD-Core Version:    0.7.0.1
 */