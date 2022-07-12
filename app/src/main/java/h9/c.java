package h9;

public class c
{
  private static final String[] a = new String[0];
  
  private static String[] a(char paramChar, i9.b paramb)
  {
    String[] arrayOfString = b(paramChar);
    if (arrayOfString != null)
    {
      int i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = b.b(arrayOfString[i], paramb);
        i += 1;
      }
      return arrayOfString;
    }
    return a;
  }
  
  private static String[] b(char paramChar)
  {
    return a.c().b(paramChar);
  }
  
  public static String[] c(char paramChar, i9.b paramb)
  {
    return a(paramChar, paramb);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h9.c
 * JD-Core Version:    0.7.0.1
 */