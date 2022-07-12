package m9;

import a9.f;
import l9.c0;
import l9.d;
import l9.d.b;
import l9.d0;
import l9.f0;
import l9.f0.a;
import l9.g0;
import l9.w;
import l9.w.a;

public final class k
{
  private static final void a(f0 paramf0)
  {
    if (paramf0 == null) {
      return;
    }
    int i;
    if (paramf0.a() == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    throw new IllegalArgumentException("priorResponse.body != null".toString());
  }
  
  private static final void b(String paramString, f0 paramf0)
  {
    if (paramf0 == null) {
      return;
    }
    g0 localg0 = paramf0.a();
    int j = 1;
    int i;
    if (localg0 == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramf0.l0() == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramf0.h() == null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if (paramf0.n0() == null) {
            i = j;
          } else {
            i = 0;
          }
          if (i != 0) {
            return;
          }
          throw new IllegalArgumentException(f.m(paramString, ".priorResponse != null").toString());
        }
        throw new IllegalArgumentException(f.m(paramString, ".cacheResponse != null").toString());
      }
      throw new IllegalArgumentException(f.m(paramString, ".networkResponse != null").toString());
    }
    throw new IllegalArgumentException(f.m(paramString, ".body != null").toString());
  }
  
  public static final f0.a c(f0.a parama, String paramString1, String paramString2)
  {
    f.f(parama, "<this>");
    f.f(paramString1, "name");
    f.f(paramString2, "value");
    parama.g().a(paramString1, paramString2);
    return parama;
  }
  
  public static final f0.a d(f0.a parama, g0 paramg0)
  {
    f.f(parama, "<this>");
    parama.s(paramg0);
    return parama;
  }
  
  public static final f0.a e(f0.a parama, f0 paramf0)
  {
    f.f(parama, "<this>");
    b("cacheResponse", paramf0);
    parama.t(paramf0);
    return parama;
  }
  
  public static final void f(f0 paramf0)
  {
    f.f(paramf0, "<this>");
    paramf0 = paramf0.a();
    if (paramf0 != null)
    {
      paramf0.close();
      return;
    }
    throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
  }
  
  public static final f0.a g(f0.a parama, int paramInt)
  {
    f.f(parama, "<this>");
    parama.u(paramInt);
    return parama;
  }
  
  public static final String h(f0 paramf0, String paramString1, String paramString2)
  {
    f.f(paramf0, "<this>");
    f.f(paramString1, "name");
    paramf0 = paramf0.i0().a(paramString1);
    if (paramf0 == null) {
      return paramString2;
    }
    return paramf0;
  }
  
  public static final f0.a i(f0.a parama, String paramString1, String paramString2)
  {
    f.f(parama, "<this>");
    f.f(paramString1, "name");
    f.f(paramString2, "value");
    parama.g().i(paramString1, paramString2);
    return parama;
  }
  
  public static final f0.a j(f0.a parama, w paramw)
  {
    f.f(parama, "<this>");
    f.f(paramw, "headers");
    parama.w(paramw.d());
    return parama;
  }
  
  public static final f0.a k(f0.a parama, String paramString)
  {
    f.f(parama, "<this>");
    f.f(paramString, "message");
    parama.x(paramString);
    return parama;
  }
  
  public static final f0.a l(f0.a parama, f0 paramf0)
  {
    f.f(parama, "<this>");
    b("networkResponse", paramf0);
    parama.y(paramf0);
    return parama;
  }
  
  public static final f0.a m(f0 paramf0)
  {
    f.f(paramf0, "<this>");
    return new f0.a(paramf0);
  }
  
  public static final f0.a n(f0.a parama, f0 paramf0)
  {
    f.f(parama, "<this>");
    a(paramf0);
    parama.z(paramf0);
    return parama;
  }
  
  public static final f0.a o(f0.a parama, c0 paramc0)
  {
    f.f(parama, "<this>");
    f.f(paramc0, "protocol");
    parama.A(paramc0);
    return parama;
  }
  
  public static final f0.a p(f0.a parama, d0 paramd0)
  {
    f.f(parama, "<this>");
    f.f(paramd0, "request");
    parama.C(paramd0);
    return parama;
  }
  
  public static final String q(f0 paramf0)
  {
    f.f(paramf0, "<this>");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Response{protocol=");
    localStringBuilder.append(paramf0.o0());
    localStringBuilder.append(", code=");
    localStringBuilder.append(paramf0.B());
    localStringBuilder.append(", message=");
    localStringBuilder.append(paramf0.k0());
    localStringBuilder.append(", url=");
    localStringBuilder.append(paramf0.q0().j());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static final d r(f0 paramf0)
  {
    f.f(paramf0, "<this>");
    d locald2 = paramf0.e0();
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = d.n.a(paramf0.i0());
      paramf0.s0(locald1);
    }
    return locald1;
  }
  
  public static final boolean s(f0 paramf0)
  {
    f.f(paramf0, "<this>");
    int i = paramf0.B();
    if ((i != 307) && (i != 308)) {
      switch (i)
      {
      default: 
        return false;
      }
    }
    return true;
  }
  
  public static final boolean t(f0 paramf0)
  {
    f.f(paramf0, "<this>");
    int i = paramf0.B();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (200 <= i)
    {
      bool1 = bool2;
      if (i < 300) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.k
 * JD-Core Version:    0.7.0.1
 */