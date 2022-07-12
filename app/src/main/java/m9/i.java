package m9;

import f9.l;
import l9.d0;
import l9.d0.a;
import l9.e0;
import l9.w;
import l9.w.a;

public final class i
{
  public static final String a(String paramString)
  {
    a9.f.f(paramString, "url");
    String str;
    if (l.v(paramString, "ws:", true))
    {
      str = paramString.substring(3);
      a9.f.e(str, "this as java.lang.String).substring(startIndex)");
    }
    for (paramString = "http:";; paramString = "https:")
    {
      return a9.f.m(paramString, str);
      if (!l.v(paramString, "wss:", true)) {
        break;
      }
      str = paramString.substring(4);
      a9.f.e(str, "this as java.lang.String).substring(startIndex)");
    }
    return paramString;
  }
  
  public static final d0.a b(d0.a parama, String paramString1, String paramString2)
  {
    a9.f.f(parama, "<this>");
    a9.f.f(paramString1, "name");
    a9.f.f(paramString2, "value");
    parama.c().a(paramString1, paramString2);
    return parama;
  }
  
  public static final String c(d0 paramd0, String paramString)
  {
    a9.f.f(paramd0, "<this>");
    a9.f.f(paramString, "name");
    return paramd0.e().a(paramString);
  }
  
  public static final d0.a d(d0.a parama, String paramString1, String paramString2)
  {
    a9.f.f(parama, "<this>");
    a9.f.f(paramString1, "name");
    a9.f.f(paramString2, "value");
    parama.c().i(paramString1, paramString2);
    return parama;
  }
  
  public static final d0.a e(d0.a parama, w paramw)
  {
    a9.f.f(parama, "<this>");
    a9.f.f(paramw, "headers");
    parama.j(paramw.d());
    return parama;
  }
  
  public static final d0.a f(d0.a parama, String paramString, e0 parame0)
  {
    a9.f.f(parama, "<this>");
    a9.f.f(paramString, "method");
    int i;
    if (paramString.length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (parame0 == null)
      {
        if (!(true ^ r9.f.d(paramString)))
        {
          parama = new StringBuilder();
          parama.append("method ");
          parama.append(paramString);
          parama.append(" must have a request body.");
          throw new IllegalArgumentException(parama.toString().toString());
        }
      }
      else {
        if (!r9.f.a(paramString)) {
          break label110;
        }
      }
      parama.k(paramString);
      parama.i(parame0);
      return parama;
      label110:
      parama = new StringBuilder();
      parama.append("method ");
      parama.append(paramString);
      parama.append(" must not have a request body.");
      throw new IllegalArgumentException(parama.toString().toString());
    }
    throw new IllegalArgumentException("method.isEmpty() == true".toString());
  }
  
  public static final d0.a g(d0.a parama, String paramString)
  {
    a9.f.f(parama, "<this>");
    a9.f.f(paramString, "name");
    parama.c().h(paramString);
    return parama;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.i
 * JD-Core Version:    0.7.0.1
 */