package l9;

import a9.f;
import b9.a;
import f9.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import m9.d;
import o8.h;

public final class w
  implements Iterable<h<? extends String, ? extends String>>, a
{
  public static final b b = new b(null);
  private final String[] a;
  
  public w(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
  }
  
  public static final w e(String... paramVarArgs)
  {
    return b.a(paramVarArgs);
  }
  
  public final String a(String paramString)
  {
    f.f(paramString, "name");
    return d.h(this.a, paramString);
  }
  
  public final String[] b()
  {
    return this.a;
  }
  
  public final String c(int paramInt)
  {
    return d.k(this, paramInt);
  }
  
  public final a d()
  {
    return d.l(this);
  }
  
  public boolean equals(Object paramObject)
  {
    return d.f(this, paramObject);
  }
  
  public final String f(int paramInt)
  {
    return d.p(this, paramInt);
  }
  
  public final List<String> g(String paramString)
  {
    f.f(paramString, "name");
    return d.q(this, paramString);
  }
  
  public int hashCode()
  {
    return d.g(this);
  }
  
  public Iterator<h<String, String>> iterator()
  {
    return d.j(this);
  }
  
  public final int size()
  {
    return this.a.length / 2;
  }
  
  public String toString()
  {
    return d.o(this);
  }
  
  public static final class a
  {
    private final List<String> a = new ArrayList(20);
    
    public final a a(String paramString1, String paramString2)
    {
      f.f(paramString1, "name");
      f.f(paramString2, "value");
      return d.b(this, paramString1, paramString2);
    }
    
    public final a b(w paramw)
    {
      f.f(paramw, "headers");
      return d.c(this, paramw);
    }
    
    public final a c(String paramString)
    {
      f.f(paramString, "line");
      int i = l.M(paramString, ':', 1, false, 4, null);
      if (i != -1)
      {
        str = paramString.substring(0, i);
        f.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
        paramString = paramString.substring(i + 1);
        f.e(paramString, "this as java.lang.String).substring(startIndex)");
        d(str, paramString);
        return this;
      }
      String str = paramString;
      if (paramString.charAt(0) == ':')
      {
        str = paramString.substring(1);
        f.e(str, "this as java.lang.String).substring(startIndex)");
      }
      d("", str);
      return this;
    }
    
    public final a d(String paramString1, String paramString2)
    {
      f.f(paramString1, "name");
      f.f(paramString2, "value");
      return d.d(this, paramString1, paramString2);
    }
    
    public final a e(String paramString1, String paramString2)
    {
      f.f(paramString1, "name");
      f.f(paramString2, "value");
      d.r(paramString1);
      d(paramString1, paramString2);
      return this;
    }
    
    public final w f()
    {
      return d.e(this);
    }
    
    public final List<String> g()
    {
      return this.a;
    }
    
    public final a h(String paramString)
    {
      f.f(paramString, "name");
      return d.m(this, paramString);
    }
    
    public final a i(String paramString1, String paramString2)
    {
      f.f(paramString1, "name");
      f.f(paramString2, "value");
      return d.n(this, paramString1, paramString2);
    }
  }
  
  public static final class b
  {
    public final w a(String... paramVarArgs)
    {
      f.f(paramVarArgs, "namesAndValues");
      return d.i((String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.w
 * JD-Core Version:    0.7.0.1
 */