package l9;

import a9.f;
import java.nio.charset.Charset;
import m9.g;

public final class z
{
  public static final a e = new a(null);
  private final String a;
  private final String b;
  private final String c;
  private final String[] d;
  
  public z(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramArrayOfString;
  }
  
  public static final z b(String paramString)
  {
    return e.a(paramString);
  }
  
  public static final z f(String paramString)
  {
    return e.b(paramString);
  }
  
  public final Charset a(Charset paramCharset)
  {
    Object localObject = e("charset");
    if (localObject == null) {
      return paramCharset;
    }
    try
    {
      localObject = Charset.forName((String)localObject);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return paramCharset;
  }
  
  public final String c()
  {
    return this.a;
  }
  
  public final String[] d()
  {
    return this.d;
  }
  
  public final String e(String paramString)
  {
    f.f(paramString, "name");
    return g.c(this, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    return g.a(this, paramObject);
  }
  
  public final String g()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    return g.b(this);
  }
  
  public String toString()
  {
    return g.f(this);
  }
  
  public static final class a
  {
    public final z a(String paramString)
    {
      f.f(paramString, "<this>");
      return g.d(paramString);
    }
    
    public final z b(String paramString)
    {
      f.f(paramString, "<this>");
      return g.e(paramString);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.z
 * JD-Core Version:    0.7.0.1
 */