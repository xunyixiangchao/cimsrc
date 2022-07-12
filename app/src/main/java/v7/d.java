package v7;

import java.lang.reflect.Field;
import java.util.Locale;

public enum d
  implements e
{
  static
  {
    a locala = new a("IDENTITY", 0);
    a = locala;
    b localb = new b("UPPER_CAMEL_CASE", 1);
    b = localb;
    c localc = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2);
    c = localc;
    d locald = new d("LOWER_CASE_WITH_UNDERSCORES", 3);
    d = locald;
    e locale = new e("LOWER_CASE_WITH_DASHES", 4);
    e = locale;
    f localf = new f("LOWER_CASE_WITH_DOTS", 5);
    f = localf;
    g = new d[] { locala, localb, localc, locald, locale, localf };
  }
  
  private d() {}
  
  private static String b(char paramChar, String paramString, int paramInt)
  {
    if (paramInt < paramString.length())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramChar);
      localStringBuilder.append(paramString.substring(paramInt));
      return localStringBuilder.toString();
    }
    return String.valueOf(paramChar);
  }
  
  static String c(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString1.length();
    int i = 0;
    while (i < j)
    {
      char c1 = paramString1.charAt(i);
      if ((Character.isUpperCase(c1)) && (localStringBuilder.length() != 0)) {
        localStringBuilder.append(paramString2);
      }
      localStringBuilder.append(c1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  static String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    char c1 = paramString.charAt(0);
    int j = paramString.length();
    while ((i < j - 1) && (!Character.isLetter(c1)))
    {
      localStringBuilder.append(c1);
      i += 1;
      c1 = paramString.charAt(i);
    }
    String str = paramString;
    if (!Character.isUpperCase(c1))
    {
      localStringBuilder.append(b(Character.toUpperCase(c1), paramString, i + 1));
      str = localStringBuilder.toString();
    }
    return str;
  }
  
  static enum a
  {
    a()
    {
      super(i, null);
    }
    
    public String a(Field paramField)
    {
      return paramField.getName();
    }
  }
  
  static enum b
  {
    b()
    {
      super(i, null);
    }
    
    public String a(Field paramField)
    {
      return d.d(paramField.getName());
    }
  }
  
  static enum c
  {
    c()
    {
      super(i, null);
    }
    
    public String a(Field paramField)
    {
      return d.d(d.c(paramField.getName(), " "));
    }
  }
  
  static enum d
  {
    d()
    {
      super(i, null);
    }
    
    public String a(Field paramField)
    {
      return d.c(paramField.getName(), "_").toLowerCase(Locale.ENGLISH);
    }
  }
  
  static enum e
  {
    e()
    {
      super(i, null);
    }
    
    public String a(Field paramField)
    {
      return d.c(paramField.getName(), "-").toLowerCase(Locale.ENGLISH);
    }
  }
  
  static enum f
  {
    f()
    {
      super(i, null);
    }
    
    public String a(Field paramField)
    {
      return d.c(paramField.getName(), ".").toLowerCase(Locale.ENGLISH);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v7.d
 * JD-Core Version:    0.7.0.1
 */