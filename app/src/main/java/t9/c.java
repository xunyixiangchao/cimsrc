package t9;

import a9.f;
import aa.e;
import aa.e.a;

public final class c
{
  public static final a d = new a(null);
  public static final e e;
  public static final e f;
  public static final e g;
  public static final e h;
  public static final e i;
  public static final e j;
  public final e a;
  public final e b;
  public final int c;
  
  static
  {
    e.a locala = e.d;
    e = locala.c(":");
    f = locala.c(":status");
    g = locala.c(":method");
    h = locala.c(":path");
    i = locala.c(":scheme");
    j = locala.c(":authority");
  }
  
  public c(e parame1, e parame2)
  {
    this.a = parame1;
    this.b = parame2;
    this.c = (parame1.r() + 32 + parame2.r());
  }
  
  public c(e parame, String paramString)
  {
    this(parame, e.d.c(paramString));
  }
  
  public c(String paramString1, String paramString2)
  {
    this(locala.c(paramString1), locala.c(paramString2));
  }
  
  public final e a()
  {
    return this.a;
  }
  
  public final e b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    if (!f.a(this.a, paramObject.a)) {
      return false;
    }
    return f.a(this.b, paramObject.b);
  }
  
  public int hashCode()
  {
    return this.a.hashCode() * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.u());
    localStringBuilder.append(": ");
    localStringBuilder.append(this.b.u());
    return localStringBuilder.toString();
  }
  
  public static final class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t9.c
 * JD-Core Version:    0.7.0.1
 */