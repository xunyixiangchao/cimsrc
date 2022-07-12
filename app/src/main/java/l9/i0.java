package l9;

import a9.f;

public enum i0
{
  public static final a b = new a(null);
  private final String a;
  
  private i0(String paramString)
  {
    this.a = paramString;
  }
  
  public final String b()
  {
    return this.a;
  }
  
  public static final class a
  {
    public final i0 a(String paramString)
    {
      f.f(paramString, "javaName");
      int i = paramString.hashCode();
      if (i != 79201641)
      {
        if (i != 79923350) {
          switch (i)
          {
          default: 
            break;
          case -503070501: 
            if (!paramString.equals("TLSv1.3")) {
              break;
            }
            return i0.c;
          case -503070502: 
            if (!paramString.equals("TLSv1.2")) {
              break;
            }
            return i0.d;
          case -503070503: 
            if (!paramString.equals("TLSv1.1")) {
              break;
            }
            return i0.e;
          }
        } else if (paramString.equals("TLSv1")) {
          return i0.f;
        }
      }
      else if (paramString.equals("SSLv3")) {
        return i0.g;
      }
      throw new IllegalArgumentException(f.m("Unexpected TLS version: ", paramString));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.i0
 * JD-Core Version:    0.7.0.1
 */