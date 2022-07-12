package ca;

import java.io.File;

public class b
{
  public static final String a = Character.toString('.');
  private static final char b = File.separatorChar;
  private static final char c;
  
  static
  {
    char c1;
    if (g()) {
      c1 = '/';
    } else {
      c1 = '\\';
    }
    c = c1;
  }
  
  private static void a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j) {
      if (paramString.charAt(i) != 0) {
        i += 1;
      } else {
        throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
      }
    }
  }
  
  public static String b(String paramString)
  {
    return h(d(paramString));
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = e(paramString);
    if (i == -1) {
      return "";
    }
    return paramString.substring(i + 1);
  }
  
  public static String d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    a(paramString);
    return paramString.substring(f(paramString) + 1);
  }
  
  public static int e(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    int i = paramString.lastIndexOf('.');
    if (f(paramString) > i) {
      return -1;
    }
    return i;
  }
  
  public static int f(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return Math.max(paramString.lastIndexOf('/'), paramString.lastIndexOf('\\'));
  }
  
  static boolean g()
  {
    return b == '\\';
  }
  
  public static String h(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    a(paramString);
    int i = e(paramString);
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ca.b
 * JD-Core Version:    0.7.0.1
 */