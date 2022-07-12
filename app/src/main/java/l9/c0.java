package l9;

import a9.f;
import f9.l;
import java.io.IOException;

public enum c0
{
  public static final a b = new a(null);
  private final String a;
  
  private c0(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    return this.a;
  }
  
  public static final class a
  {
    public final c0 a(String paramString)
    {
      f.f(paramString, "protocol");
      c0 localc0 = c0.c;
      if (f.a(paramString, c0.b(localc0))) {
        return localc0;
      }
      localc0 = c0.d;
      if (f.a(paramString, c0.b(localc0))) {
        return localc0;
      }
      localc0 = c0.g;
      if (f.a(paramString, c0.b(localc0))) {
        return localc0;
      }
      localc0 = c0.f;
      if (f.a(paramString, c0.b(localc0))) {
        return localc0;
      }
      localc0 = c0.e;
      if (f.a(paramString, c0.b(localc0))) {
        return localc0;
      }
      localc0 = c0.h;
      if (f.a(paramString, c0.b(localc0))) {
        return localc0;
      }
      localc0 = c0.i;
      if (l.x(paramString, c0.b(localc0), false, 2, null)) {
        return localc0;
      }
      throw new IOException(f.m("Unexpected protocol: ", paramString));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.c0
 * JD-Core Version:    0.7.0.1
 */