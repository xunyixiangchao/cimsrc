package m9;

import a9.f;
import g9.a;
import g9.c;
import l9.d.a;
import l9.d.b;
import l9.w;

public final class b
{
  public static final l9.d a(d.a parama)
  {
    f.f(parama, "<this>");
    return new l9.d(parama.f(), parama.g(), parama.c(), -1, false, false, false, parama.d(), parama.e(), parama.i(), parama.h(), parama.b(), null);
  }
  
  public static final int b(long paramLong)
  {
    if (paramLong > 2147483647L) {
      return 2147483647;
    }
    return (int)paramLong;
  }
  
  public static final l9.d c(d.b paramb)
  {
    f.f(paramb, "<this>");
    return new d.a().l().j(2147483647, g9.d.e).a();
  }
  
  public static final l9.d d(d.b paramb)
  {
    f.f(paramb, "<this>");
    return new d.a().k().a();
  }
  
  public static final d.a e(d.a parama, int paramInt, g9.d paramd)
  {
    f.f(parama, "<this>");
    f.f(paramd, "timeUnit");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      parama.m(b(a.k(c.h(paramInt, paramd))));
      return parama;
    }
    throw new IllegalArgumentException(f.m("maxStale < 0: ", Integer.valueOf(paramInt)).toString());
  }
  
  public static final d.a f(d.a parama)
  {
    f.f(parama, "<this>");
    parama.n(true);
    return parama;
  }
  
  public static final d.a g(d.a parama)
  {
    f.f(parama, "<this>");
    parama.o(true);
    return parama;
  }
  
  public static final l9.d h(d.b paramb, w paramw)
  {
    f.f(paramb, "<this>");
    f.f(paramw, "headers");
    int i8 = paramw.size();
    boolean bool9 = true;
    int j = 1;
    int i2 = 0;
    paramb = null;
    boolean bool8 = false;
    boolean bool7 = false;
    int i1 = -1;
    int n = -1;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    int m = -1;
    int k = -1;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool18;
    for (boolean bool1 = false;; bool1 = bool18)
    {
      Object localObject = paramw;
      if (i2 >= i8) {
        break;
      }
      String str2 = ((w)localObject).c(i2);
      String str1 = ((w)localObject).f(i2);
      boolean bool10;
      int i7;
      boolean bool11;
      boolean bool12;
      int i3;
      int i4;
      boolean bool13;
      boolean bool14;
      boolean bool15;
      int i5;
      int i6;
      boolean bool16;
      boolean bool17;
      if (f9.l.l(str2, "Cache-Control", bool9))
      {
        if (paramb == null)
        {
          paramb = str1;
          break label189;
        }
      }
      else
      {
        bool10 = bool9;
        i7 = j;
        localObject = paramb;
        bool11 = bool8;
        bool12 = bool7;
        i3 = i1;
        i4 = n;
        bool13 = bool6;
        bool14 = bool5;
        bool15 = bool4;
        i5 = m;
        i6 = k;
        bool16 = bool3;
        bool17 = bool2;
        bool18 = bool1;
        if (!f9.l.l(str2, "Pragma", bool9)) {
          break label764;
        }
      }
      j = 0;
      label189:
      int i = 0;
      for (;;)
      {
        bool10 = bool9;
        i7 = j;
        localObject = paramb;
        bool11 = bool8;
        bool12 = bool7;
        i3 = i1;
        i4 = n;
        bool13 = bool6;
        bool14 = bool5;
        bool15 = bool4;
        i5 = m;
        i6 = k;
        bool16 = bool3;
        bool17 = bool2;
        bool18 = bool1;
        if (i >= str1.length()) {
          break;
        }
        i3 = j(str1, "=,;", i);
        localObject = str1.substring(i, i3);
        f.e(localObject, "this as java.lang.String…ing(startIndex, endIndex)");
        str2 = f9.l.o0((CharSequence)localObject).toString();
        if ((i3 != str1.length()) && (str1.charAt(i3) != ',') && (str1.charAt(i3) != ';'))
        {
          i3 = l.u(str1, i3 + 1);
          if ((i3 < str1.length()) && (str1.charAt(i3) == '"'))
          {
            i = i3 + 1;
            i3 = f9.l.M(str1, '"', i, false, 4, null);
            localObject = str1.substring(i, i3);
            f.e(localObject, "this as java.lang.String…ing(startIndex, endIndex)");
            i = i3 + 1;
          }
          else
          {
            i = j(str1, ",;", i3);
            localObject = str1.substring(i3, i);
            f.e(localObject, "this as java.lang.String…ing(startIndex, endIndex)");
            localObject = f9.l.o0((CharSequence)localObject).toString();
          }
        }
        else
        {
          i = i3 + 1;
          localObject = null;
        }
        bool9 = true;
        if (f9.l.l("no-cache", str2, true))
        {
          bool8 = true;
        }
        else if (f9.l.l("no-store", str2, true))
        {
          bool7 = true;
        }
        else
        {
          if (f9.l.l("max-age", str2, true))
          {
            i3 = l.D((String)localObject, -1);
            i6 = k;
            i5 = m;
            i4 = n;
          }
          label697:
          do
          {
            for (;;)
            {
              i1 = i3;
              n = i4;
              m = i5;
              k = i6;
              break;
              if (f9.l.l("s-maxage", str2, true))
              {
                i4 = l.D((String)localObject, -1);
                i3 = i1;
                i5 = m;
                i6 = k;
              }
              else
              {
                if (f9.l.l("private", str2, true))
                {
                  bool6 = true;
                  break;
                }
                if (f9.l.l("public", str2, true))
                {
                  bool5 = true;
                  break;
                }
                if (f9.l.l("must-revalidate", str2, true))
                {
                  bool4 = true;
                  break;
                }
                if (f9.l.l("max-stale", str2, true))
                {
                  i5 = l.D((String)localObject, 2147483647);
                  i3 = i1;
                  i4 = n;
                  i6 = k;
                }
                else
                {
                  if (!f9.l.l("min-fresh", str2, true)) {
                    break label697;
                  }
                  i6 = l.D((String)localObject, -1);
                  i3 = i1;
                  i4 = n;
                  i5 = m;
                }
              }
            }
            if (f9.l.l("only-if-cached", str2, true))
            {
              bool3 = true;
              break;
            }
            if (f9.l.l("no-transform", str2, true))
            {
              bool2 = true;
              break;
            }
            i3 = i1;
            i4 = n;
            i5 = m;
            i6 = k;
          } while (!f9.l.l("immutable", str2, true));
          bool1 = true;
        }
      }
      label764:
      i2 += 1;
      bool9 = bool10;
      j = i7;
      paramb = (d.b)localObject;
      bool8 = bool11;
      bool7 = bool12;
      i1 = i3;
      n = i4;
      bool6 = bool13;
      bool5 = bool14;
      bool4 = bool15;
      m = i5;
      k = i6;
      bool3 = bool16;
      bool2 = bool17;
    }
    if (j == 0) {
      paramb = null;
    }
    return new l9.d(bool8, bool7, i1, n, bool6, bool5, bool4, m, k, bool3, bool2, bool1, paramb);
  }
  
  public static final String i(l9.d paramd)
  {
    f.f(paramd, "<this>");
    String str = paramd.a();
    Object localObject = str;
    if (str == null)
    {
      localObject = new StringBuilder();
      if (paramd.i()) {
        ((StringBuilder)localObject).append("no-cache, ");
      }
      if (paramd.j()) {
        ((StringBuilder)localObject).append("no-store, ");
      }
      if (paramd.e() != -1)
      {
        ((StringBuilder)localObject).append("max-age=");
        ((StringBuilder)localObject).append(paramd.e());
        ((StringBuilder)localObject).append(", ");
      }
      if (paramd.m() != -1)
      {
        ((StringBuilder)localObject).append("s-maxage=");
        ((StringBuilder)localObject).append(paramd.m());
        ((StringBuilder)localObject).append(", ");
      }
      if (paramd.c()) {
        ((StringBuilder)localObject).append("private, ");
      }
      if (paramd.d()) {
        ((StringBuilder)localObject).append("public, ");
      }
      if (paramd.h()) {
        ((StringBuilder)localObject).append("must-revalidate, ");
      }
      if (paramd.f() != -1)
      {
        ((StringBuilder)localObject).append("max-stale=");
        ((StringBuilder)localObject).append(paramd.f());
        ((StringBuilder)localObject).append(", ");
      }
      if (paramd.g() != -1)
      {
        ((StringBuilder)localObject).append("min-fresh=");
        ((StringBuilder)localObject).append(paramd.g());
        ((StringBuilder)localObject).append(", ");
      }
      if (paramd.l()) {
        ((StringBuilder)localObject).append("only-if-cached, ");
      }
      if (paramd.k()) {
        ((StringBuilder)localObject).append("no-transform, ");
      }
      if (paramd.b()) {
        ((StringBuilder)localObject).append("immutable, ");
      }
      int i;
      if (((CharSequence)localObject).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return "";
      }
      f.e(((StringBuilder)localObject).delete(((StringBuilder)localObject).length() - 2, ((StringBuilder)localObject).length()), "this.delete(startIndex, endIndex)");
      localObject = ((StringBuilder)localObject).toString();
      f.e(localObject, "StringBuilder().apply(builderAction).toString()");
      paramd.n((String)localObject);
    }
    return localObject;
  }
  
  private static final int j(String paramString1, String paramString2, int paramInt)
  {
    int i = paramString1.length();
    while (paramInt < i)
    {
      if (f9.l.B(paramString2, paramString1.charAt(paramInt), false, 2, null)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramString1.length();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.b
 * JD-Core Version:    0.7.0.1
 */