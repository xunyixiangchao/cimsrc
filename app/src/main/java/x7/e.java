package x7;

public final class e
{
  private static final int a = ;
  
  private static int a()
  {
    return d(System.getProperty("java.version"));
  }
  
  private static int b(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if (!Character.isDigit(c)) {
          break;
        }
        localStringBuilder.append(c);
        i += 1;
      }
      i = Integer.parseInt(localStringBuilder.toString());
      return i;
    }
    catch (NumberFormatException paramString)
    {
      label54:
      break label54;
    }
    return -1;
  }
  
  public static int c()
  {
    return a;
  }
  
  static int d(String paramString)
  {
    int j = f(paramString);
    int i = j;
    if (j == -1) {
      i = b(paramString);
    }
    if (i == -1) {
      return 6;
    }
    return i;
  }
  
  public static boolean e()
  {
    return a >= 9;
  }
  
  private static int f(String paramString)
  {
    try
    {
      paramString = paramString.split("[._]");
      int i = Integer.parseInt(paramString[0]);
      if ((i == 1) && (paramString.length > 1))
      {
        i = Integer.parseInt(paramString[1]);
        return i;
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      label36:
      break label36;
    }
    return -1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x7.e
 * JD-Core Version:    0.7.0.1
 */