package l9;

import f9.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m9.e;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase.a;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import r9.c;

public final class o
{
  public static final a j = new a(null);
  private static final Pattern k = Pattern.compile("(\\d{2,4})[^\\d]*");
  private static final Pattern l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
  private static final Pattern m = Pattern.compile("(\\d{1,2})[^\\d]*");
  private static final Pattern n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  private final String a;
  private final String b;
  private final long c;
  private final String d;
  private final String e;
  private final boolean f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  
  private o(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLong;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    this.h = paramBoolean3;
    this.i = paramBoolean4;
  }
  
  public final String e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof o))
    {
      paramObject = (o)paramObject;
      if ((a9.f.a(paramObject.a, this.a)) && (a9.f.a(paramObject.b, this.b)) && (paramObject.c == this.c) && (a9.f.a(paramObject.d, this.d)) && (a9.f.a(paramObject.e, this.e)) && (paramObject.f == this.f) && (paramObject.g == this.g) && (paramObject.h == this.h) && (paramObject.i == this.i)) {
        return true;
      }
    }
    return false;
  }
  
  public final long f()
  {
    return this.c;
  }
  
  public final boolean g()
  {
    return this.i;
  }
  
  public final boolean h()
  {
    return this.g;
  }
  
  @IgnoreJRERequirement
  public int hashCode()
  {
    return ((((((((527 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + m.a(this.c)) * 31 + this.d.hashCode()) * 31 + this.e.hashCode()) * 31 + n.a(this.f)) * 31 + n.a(this.g)) * 31 + n.a(this.h)) * 31 + n.a(this.i);
  }
  
  public final String i()
  {
    return this.a;
  }
  
  public final String j()
  {
    return this.e;
  }
  
  public final boolean k()
  {
    return this.h;
  }
  
  public final boolean l()
  {
    return this.f;
  }
  
  public final String m(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i());
    localStringBuilder.append('=');
    localStringBuilder.append(n());
    if (k())
    {
      if (f() == -9223372036854775808L)
      {
        str = "; max-age=0";
      }
      else
      {
        localStringBuilder.append("; expires=");
        str = c.b(new Date(f()));
      }
      localStringBuilder.append(str);
    }
    if (!g())
    {
      localStringBuilder.append("; domain=");
      if (paramBoolean) {
        localStringBuilder.append(".");
      }
      localStringBuilder.append(e());
    }
    localStringBuilder.append("; path=");
    localStringBuilder.append(j());
    if (l()) {
      localStringBuilder.append("; secure");
    }
    if (h()) {
      localStringBuilder.append("; httponly");
    }
    String str = localStringBuilder.toString();
    a9.f.e(str, "toString()");
    return str;
  }
  
  public final String n()
  {
    return this.b;
  }
  
  public String toString()
  {
    return m(false);
  }
  
  public static final class a
  {
    private final int a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      while (paramInt1 < paramInt2)
      {
        int k = paramString.charAt(paramInt1);
        int j = 0;
        if (((k >= 32) || (k == 9)) && (k < 127))
        {
          if ((k <= 57) && (48 <= k)) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            if ((k <= 122) && (97 <= k)) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 0)
            {
              if ((k <= 90) && (65 <= k)) {
                i = 1;
              } else {
                i = 0;
              }
              if (i == 0)
              {
                i = j;
                if (k != 58) {
                  break label134;
                }
              }
            }
          }
        }
        int i = 1;
        label134:
        if (i == (paramBoolean ^ true)) {
          return paramInt1;
        }
        paramInt1 += 1;
      }
      return paramInt2;
    }
    
    private final boolean b(String paramString1, String paramString2)
    {
      if (a9.f.a(paramString1, paramString2)) {
        return true;
      }
      return (f9.l.k(paramString1, paramString2, false, 2, null)) && (paramString1.charAt(paramString1.length() - paramString2.length() - 1) == '.') && (!e.a(paramString1));
    }
    
    private final String f(String paramString)
    {
      if ((f9.l.k(paramString, ".", false, 2, null) ^ true))
      {
        paramString = m9.f.a(f9.l.d0(paramString, "."));
        if (paramString != null) {
          return paramString;
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException("Failed requirement.".toString());
    }
    
    private final long g(String paramString, int paramInt1, int paramInt2)
    {
      int i7 = a(paramString, paramInt1, paramInt2, false);
      Matcher localMatcher = o.c().matcher(paramString);
      int i1 = -1;
      paramInt1 = i1;
      int i = paramInt1;
      int j = i;
      int k = j;
      int m = k;
      int n = paramInt1;
      paramInt1 = i1;
      while (i7 < paramInt2)
      {
        int i8 = a(paramString, i7 + 1, paramInt2, true);
        localMatcher.region(i7, i8);
        String str;
        int i2;
        int i5;
        int i6;
        int i3;
        int i4;
        if ((n == -1) && (localMatcher.usePattern(o.c()).matches()))
        {
          str = localMatcher.group(1);
          a9.f.e(str, "matcher.group(1)");
          i2 = Integer.parseInt(str);
          str = localMatcher.group(2);
          a9.f.e(str, "matcher.group(2)");
          i5 = Integer.parseInt(str);
          str = localMatcher.group(3);
          a9.f.e(str, "matcher.group(3)");
          i6 = Integer.parseInt(str);
          i1 = paramInt1;
          i3 = i;
          i4 = j;
        }
        else if ((i == -1) && (localMatcher.usePattern(o.a()).matches()))
        {
          str = localMatcher.group(1);
          a9.f.e(str, "matcher.group(1)");
          i3 = Integer.parseInt(str);
          i1 = paramInt1;
          i2 = n;
          i4 = j;
          i5 = k;
          i6 = m;
        }
        else if ((j == -1) && (localMatcher.usePattern(o.b()).matches()))
        {
          str = localMatcher.group(1);
          a9.f.e(str, "matcher.group(1)");
          Object localObject = Locale.US;
          a9.f.e(localObject, "US");
          str = str.toLowerCase((Locale)localObject);
          a9.f.e(str, "this as java.lang.String).toLowerCase(locale)");
          localObject = o.b().pattern();
          a9.f.e(localObject, "MONTH_PATTERN.pattern()");
          i4 = f9.l.N((CharSequence)localObject, str, 0, false, 6, null) / 4;
          i1 = paramInt1;
          i2 = n;
          i3 = i;
          i5 = k;
          i6 = m;
        }
        else
        {
          i1 = paramInt1;
          i2 = n;
          i3 = i;
          i4 = j;
          i5 = k;
          i6 = m;
          if (paramInt1 == -1)
          {
            i1 = paramInt1;
            i2 = n;
            i3 = i;
            i4 = j;
            i5 = k;
            i6 = m;
            if (localMatcher.usePattern(o.d()).matches())
            {
              str = localMatcher.group(1);
              a9.f.e(str, "matcher.group(1)");
              i1 = Integer.parseInt(str);
              i6 = m;
              i5 = k;
              i4 = j;
              i3 = i;
              i2 = n;
            }
          }
        }
        i7 = a(paramString, i8 + 1, paramInt2, false);
        paramInt1 = i1;
        n = i2;
        i = i3;
        j = i4;
        k = i5;
        m = i6;
      }
      if ((70 <= paramInt1) && (paramInt1 < 100)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      paramInt2 = paramInt1;
      if (i1 != 0) {
        paramInt2 = paramInt1 + 1900;
      }
      if ((paramInt2 >= 0) && (paramInt2 < 70)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      paramInt1 = paramInt2;
      if (i1 != 0) {
        paramInt1 = paramInt2 + 2000;
      }
      if (paramInt1 >= 1601) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      if (paramInt2 != 0)
      {
        if (j != -1) {
          paramInt2 = 1;
        } else {
          paramInt2 = 0;
        }
        if (paramInt2 != 0)
        {
          if ((1 <= i) && (i < 32)) {
            paramInt2 = 1;
          } else {
            paramInt2 = 0;
          }
          if (paramInt2 != 0)
          {
            if ((n >= 0) && (n < 24)) {
              paramInt2 = 1;
            } else {
              paramInt2 = 0;
            }
            if (paramInt2 != 0)
            {
              if ((k >= 0) && (k < 60)) {
                paramInt2 = 1;
              } else {
                paramInt2 = 0;
              }
              if (paramInt2 != 0)
              {
                if ((m >= 0) && (m < 60)) {
                  paramInt2 = 1;
                } else {
                  paramInt2 = 0;
                }
                if (paramInt2 != 0)
                {
                  paramString = new GregorianCalendar(m9.o.d);
                  paramString.setLenient(false);
                  paramString.set(1, paramInt1);
                  paramString.set(2, j - 1);
                  paramString.set(5, i);
                  paramString.set(11, n);
                  paramString.set(12, k);
                  paramString.set(13, m);
                  paramString.set(14, 0);
                  return paramString.getTimeInMillis();
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
              }
              throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
          }
          throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
      }
      throw new IllegalArgumentException("Failed requirement.".toString());
    }
    
    private final long h(String paramString)
    {
      try
      {
        long l = Long.parseLong(paramString);
        if (l <= 0L) {
          return -9223372036854775808L;
        }
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (new j("-?\\d+").b(paramString))
        {
          if (f9.l.x(paramString, "-", false, 2, null)) {
            return -9223372036854775808L;
          }
          return 9223372036854775807L;
        }
        throw localNumberFormatException;
      }
    }
    
    public final o c(x paramx, String paramString)
    {
      a9.f.f(paramx, "url");
      a9.f.f(paramString, "setCookie");
      return d(System.currentTimeMillis(), paramx, paramString);
    }
    
    public final o d(long paramLong, x paramx, String paramString)
    {
      a9.f.f(paramx, "url");
      a9.f.f(paramString, "setCookie");
      int j = m9.l.j(paramString, ';', 0, 0, 6, null);
      int k = m9.l.j(paramString, '=', 0, j, 2, null);
      if (k == j) {
        return null;
      }
      String str1 = m9.l.F(paramString, 0, k, 1, null);
      int i;
      if (str1.length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i == 0) && (m9.l.p(str1) == -1))
      {
        String str2 = m9.l.E(paramString, k + 1, j);
        if (m9.l.p(str2) != -1) {
          return null;
        }
        i = j + 1;
        j = paramString.length();
        localObject2 = null;
        localObject1 = localObject2;
        bool5 = false;
        bool1 = bool5;
        bool3 = bool1;
        bool2 = true;
        l2 = -1L;
        l1 = 253402300799999L;
        boolean bool4 = bool1;
        bool1 = bool5;
        while (i < j)
        {
          k = m9.l.h(paramString, ';', i, j);
          int m = m9.l.h(paramString, '=', i, k);
          String str3 = m9.l.E(paramString, i, m);
          if (m < k) {
            localObject3 = m9.l.E(paramString, m + 1, k);
          } else {
            localObject3 = "";
          }
          if (f9.l.l(str3, "expires", true)) {}
          try
          {
            l3 = g((String)localObject3, 0, ((String)localObject3).length());
            l1 = l3;
            if (f9.l.l(str3, "max-age", true))
            {
              l3 = h((String)localObject3);
              l2 = l3;
              bool6 = true;
              localObject3 = localObject2;
              l3 = l2;
              bool5 = bool1;
              bool7 = bool2;
              localObject5 = localObject1;
              l4 = l1;
            }
            else if (f9.l.l(str3, "domain", true))
            {
              localObject3 = f((String)localObject3);
              bool7 = false;
              l3 = l2;
              bool5 = bool1;
              bool6 = bool3;
              localObject5 = localObject1;
              l4 = l1;
            }
            else if (f9.l.l(str3, "path", true))
            {
              localObject5 = localObject3;
              localObject3 = localObject2;
              l3 = l2;
              bool5 = bool1;
              bool6 = bool3;
              bool7 = bool2;
              l4 = l1;
            }
            else if (f9.l.l(str3, "secure", true))
            {
              bool5 = true;
              localObject3 = localObject2;
              l3 = l2;
              bool6 = bool3;
              bool7 = bool2;
              localObject5 = localObject1;
              l4 = l1;
            }
            else
            {
              localObject3 = localObject2;
              l3 = l2;
              bool5 = bool1;
              bool6 = bool3;
              bool7 = bool2;
              localObject5 = localObject1;
              l4 = l1;
              if (f9.l.l(str3, "httponly", true))
              {
                bool4 = true;
                l4 = l1;
                localObject5 = localObject1;
                bool7 = bool2;
                bool6 = bool3;
                bool5 = bool1;
                l3 = l2;
                localObject3 = localObject2;
              }
            }
          }
          catch (IllegalArgumentException|NumberFormatException localIllegalArgumentException)
          {
            for (;;)
            {
              Object localObject4 = localObject2;
              long l3 = l2;
              bool5 = bool1;
              boolean bool6 = bool3;
              boolean bool7 = bool2;
              Object localObject5 = localObject1;
              long l4 = l1;
            }
          }
          i = k + 1;
          localObject2 = localObject3;
          l2 = l3;
          bool1 = bool5;
          bool3 = bool6;
          bool2 = bool7;
          localObject1 = localObject5;
          l1 = l4;
        }
        l3 = -9223372036854775808L;
        if (l2 == -9223372036854775808L) {
          paramLong = l3;
        }
        for (;;)
        {
          break;
          if (l2 != -1L)
          {
            if (l2 <= 9223372036854775L) {
              l1 = l2 * 1000;
            } else {
              l1 = 9223372036854775807L;
            }
            l1 = paramLong + l1;
            if (l1 >= paramLong)
            {
              paramLong = l1;
              if (l1 <= 253402300799999L) {
                continue;
              }
            }
            paramLong = 253402300799999L;
          }
          else
          {
            paramLong = l1;
          }
        }
        Object localObject3 = paramx.i();
        if (localObject2 == null)
        {
          paramString = (String)localObject3;
        }
        else
        {
          if (!b((String)localObject3, (String)localObject2)) {
            return null;
          }
          paramString = (String)localObject2;
        }
        if ((((String)localObject3).length() != paramString.length()) && (PublicSuffixDatabase.e.c().c(paramString) == null)) {
          return null;
        }
        localObject2 = "/";
        if ((localObject1 != null) && (f9.l.x((String)localObject1, "/", false, 2, null)))
        {
          paramx = (x)localObject1;
        }
        else
        {
          localObject1 = paramx.d();
          i = f9.l.R((CharSequence)localObject1, '/', 0, false, 6, null);
          paramx = (x)localObject2;
          if (i != 0)
          {
            paramx = ((String)localObject1).substring(0, i);
            a9.f.e(paramx, "this as java.lang.String…ing(startIndex, endIndex)");
          }
        }
        return new o(str1, str2, paramLong, paramString, paramx, bool1, bool4, bool3, bool2, null);
      }
      else
      {
        return null;
      }
    }
    
    public final List<o> e(x paramx, w paramw)
    {
      a9.f.f(paramx, "url");
      a9.f.f(paramw, "headers");
      List localList = paramw.g("Set-Cookie");
      int j = localList.size();
      paramw = null;
      int i = 0;
      if (i < j)
      {
        o localo = c(paramx, (String)localList.get(i));
        if (localo == null) {}
        for (;;)
        {
          i += 1;
          break;
          Object localObject = paramw;
          if (paramw == null) {
            localObject = new ArrayList();
          }
          ((List)localObject).add(localo);
          paramw = (w)localObject;
        }
      }
      if (paramw != null)
      {
        paramx = Collections.unmodifiableList(paramw);
        a9.f.e(paramx, "{\n        Collections.un…ableList(cookies)\n      }");
        return paramx;
      }
      return p8.l.h();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.o
 * JD-Core Version:    0.7.0.1
 */