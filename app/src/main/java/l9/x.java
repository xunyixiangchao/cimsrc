package l9;

import aa.b;
import c9.a;
import c9.g;
import f9.d;
import f9.j;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class x
{
  public static final b k = new b(null);
  private static final char[] l = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final int e;
  private final List<String> f;
  private final List<String> g;
  private final String h;
  private final String i;
  private final boolean j;
  
  public x(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, List<String> paramList1, List<String> paramList2, String paramString5, String paramString6)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramInt;
    this.f = paramList1;
    this.g = paramList2;
    this.h = paramString5;
    this.i = paramString6;
    this.j = a9.f.a(paramString1, "https");
  }
  
  public static final x h(String paramString)
  {
    return k.d(paramString);
  }
  
  public final String b()
  {
    if (this.h == null) {
      return null;
    }
    int m = f9.l.M(this.i, '#', 0, false, 6, null);
    String str = this.i.substring(m + 1);
    a9.f.e(str, "this as java.lang.String).substring(startIndex)");
    return str;
  }
  
  public final String c()
  {
    if (this.c.length() == 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0) {
      return "";
    }
    int m = f9.l.M(this.i, ':', this.a.length() + 3, false, 4, null);
    int n = f9.l.M(this.i, '@', 0, false, 6, null);
    String str = this.i.substring(m + 1, n);
    a9.f.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
    return str;
  }
  
  public final String d()
  {
    int m = f9.l.M(this.i, '/', this.a.length() + 3, false, 4, null);
    String str = this.i;
    int n = m9.l.i(str, "?#", m, str.length());
    str = this.i.substring(m, n);
    a9.f.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
    return str;
  }
  
  public final List<String> e()
  {
    int m = f9.l.M(this.i, '/', this.a.length() + 3, false, 4, null);
    Object localObject = this.i;
    int n = m9.l.i((String)localObject, "?#", m, ((String)localObject).length());
    localObject = new ArrayList();
    while (m < n)
    {
      int i1 = m + 1;
      m = m9.l.h(this.i, '/', i1, n);
      String str = this.i.substring(i1, m);
      a9.f.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
      ((List)localObject).add(str);
    }
    return localObject;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof x)) && (a9.f.a(((x)paramObject).i, this.i));
  }
  
  public final String f()
  {
    if (this.g == null) {
      return null;
    }
    int m = f9.l.M(this.i, '?', 0, false, 6, null) + 1;
    String str = this.i;
    int n = m9.l.h(str, '#', m, str.length());
    str = this.i.substring(m, n);
    a9.f.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
    return str;
  }
  
  public final String g()
  {
    if (this.b.length() == 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0) {
      return "";
    }
    int m = this.a.length() + 3;
    String str = this.i;
    int n = m9.l.i(str, ":@", m, str.length());
    str = this.i.substring(m, n);
    a9.f.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
    return str;
  }
  
  public int hashCode()
  {
    return this.i.hashCode();
  }
  
  public final String i()
  {
    return this.d;
  }
  
  public final boolean j()
  {
    return this.j;
  }
  
  public final a k()
  {
    a locala = new a();
    locala.E(this.a);
    locala.B(g());
    locala.z(c());
    locala.C(this.d);
    int m;
    if (this.e != k.c(this.a)) {
      m = this.e;
    } else {
      m = -1;
    }
    locala.D(m);
    locala.h().clear();
    locala.h().addAll(e());
    locala.e(f());
    locala.y(b());
    return locala;
  }
  
  public final a l(String paramString)
  {
    a9.f.f(paramString, "link");
    try
    {
      paramString = new a().q(this, paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      label21:
      break label21;
    }
    return null;
  }
  
  public final List<String> m()
  {
    return this.f;
  }
  
  public final int n()
  {
    return this.e;
  }
  
  public final String o()
  {
    if (this.g == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    k.j(this.g, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public final String p()
  {
    a locala = l("/...");
    a9.f.c(locala);
    return locala.F("").r("").c().toString();
  }
  
  public final x q(String paramString)
  {
    a9.f.f(paramString, "link");
    paramString = l(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.c();
  }
  
  public final String r()
  {
    return this.a;
  }
  
  public final URI s()
  {
    Object localObject = k().v().toString();
    try
    {
      URI localURI = new URI((String)localObject);
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException) {}
    try
    {
      localObject = URI.create(new j("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").c((CharSequence)localObject, ""));
      a9.f.e(localObject, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
      return localObject;
    }
    catch (Exception localException)
    {
      label52:
      break label52;
    }
    throw new RuntimeException(localURISyntaxException);
  }
  
  public final URL t()
  {
    try
    {
      URL localURL = new URL(this.i);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new RuntimeException(localMalformedURLException);
    }
  }
  
  public String toString()
  {
    return this.i;
  }
  
  public static final class a
  {
    public static final a i = new a(null);
    private String a;
    private String b = "";
    private String c = "";
    private String d;
    private int e = -1;
    private final List<String> f;
    private List<String> g;
    private String h;
    
    public a()
    {
      ArrayList localArrayList = new ArrayList();
      this.f = localArrayList;
      localArrayList.add("");
    }
    
    private final int d()
    {
      int j = this.e;
      if (j != -1) {
        return j;
      }
      x.b localb = x.k;
      String str = this.a;
      a9.f.c(str);
      return localb.c(str);
    }
    
    private final boolean o(String paramString)
    {
      boolean bool2 = a9.f.a(paramString, ".");
      boolean bool1 = true;
      if (!bool2)
      {
        if (f9.l.l(paramString, "%2e", true)) {
          return true;
        }
        bool1 = false;
      }
      return bool1;
    }
    
    private final boolean p(String paramString)
    {
      boolean bool3 = a9.f.a(paramString, "..");
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (!bool3)
      {
        bool1 = bool2;
        if (!f9.l.l(paramString, "%2e.", true))
        {
          bool1 = bool2;
          if (!f9.l.l(paramString, ".%2e", true))
          {
            if (f9.l.l(paramString, "%2e%2e", true)) {
              return true;
            }
            bool1 = false;
          }
        }
      }
      return bool1;
    }
    
    private final void s()
    {
      List localList = this.f;
      int j;
      if (((String)localList.remove(localList.size() - 1)).length() == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if ((j != 0) && ((this.f.isEmpty() ^ true)))
      {
        localList = this.f;
        localList.set(localList.size() - 1, "");
        return;
      }
      this.f.add("");
    }
    
    private final void u(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      paramString = x.b.b(x.k, paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false, false, false, null, 240, null);
      if (o(paramString)) {
        return;
      }
      if (p(paramString))
      {
        s();
        return;
      }
      List localList = this.f;
      if (((CharSequence)localList.get(localList.size() - 1)).length() == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0)
      {
        localList = this.f;
        localList.set(localList.size() - 1, paramString);
      }
      else
      {
        this.f.add(paramString);
      }
      if (paramBoolean1) {
        this.f.add("");
      }
    }
    
    private final void w(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2) {
        return;
      }
      int j = paramString.charAt(paramInt1);
      if ((j != 47) && (j != 92))
      {
        List localList = this.f;
        localList.set(localList.size() - 1, "");
      }
      else
      {
        this.f.clear();
        this.f.add("");
        paramInt1 += 1;
      }
      while (paramInt1 < paramInt2)
      {
        j = m9.l.i(paramString, "/\\", paramInt1, paramInt2);
        boolean bool;
        if (j < paramInt2) {
          bool = true;
        } else {
          bool = false;
        }
        u(paramString, paramInt1, j, bool, true);
        paramInt1 = j;
        if (bool) {
          paramInt1 = j + 1;
        }
      }
    }
    
    public final void A(List<String> paramList)
    {
      this.g = paramList;
    }
    
    public final void B(String paramString)
    {
      a9.f.f(paramString, "<set-?>");
      this.b = paramString;
    }
    
    public final void C(String paramString)
    {
      this.d = paramString;
    }
    
    public final void D(int paramInt)
    {
      this.e = paramInt;
    }
    
    public final void E(String paramString)
    {
      this.a = paramString;
    }
    
    public final a F(String paramString)
    {
      a9.f.f(paramString, "username");
      B(x.b.b(x.k, paramString, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
      return this;
    }
    
    public final a a(String paramString1, String paramString2)
    {
      a9.f.f(paramString1, "encodedName");
      if (i() == null) {
        A(new ArrayList());
      }
      List localList = i();
      a9.f.c(localList);
      x.b localb = x.k;
      localList.add(x.b.b(localb, paramString1, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
      localList = i();
      a9.f.c(localList);
      if (paramString2 == null) {
        paramString1 = null;
      } else {
        paramString1 = x.b.b(localb, paramString2, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null);
      }
      localList.add(paramString1);
      return this;
    }
    
    public final a b(String paramString1, String paramString2)
    {
      a9.f.f(paramString1, "name");
      if (i() == null) {
        A(new ArrayList());
      }
      List localList = i();
      a9.f.c(localList);
      x.b localb = x.k;
      localList.add(x.b.b(localb, paramString1, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
      localList = i();
      a9.f.c(localList);
      if (paramString2 == null) {
        paramString1 = null;
      } else {
        paramString1 = x.b.b(localb, paramString2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null);
      }
      localList.add(paramString1);
      return this;
    }
    
    public final x c()
    {
      String str1 = this.a;
      if (str1 != null)
      {
        Object localObject1 = x.k;
        String str2 = x.b.g((x.b)localObject1, this.b, 0, 0, false, 7, null);
        String str3 = x.b.g((x.b)localObject1, this.c, 0, 0, false, 7, null);
        String str4 = this.d;
        if (str4 != null)
        {
          int j = d();
          localObject1 = this.f;
          ArrayList localArrayList = new ArrayList(p8.l.q((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            localArrayList.add(x.b.g(x.k, (String)localObject2, 0, 0, false, 7, null));
          }
          localObject1 = this.g;
          if (localObject1 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject2 = new ArrayList(p8.l.q((Iterable)localObject1, 10));
            Iterator localIterator = ((Iterable)localObject1).iterator();
            for (;;)
            {
              localObject1 = localObject2;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = (String)localIterator.next();
              if (localObject1 == null) {
                localObject1 = null;
              } else {
                localObject1 = x.b.g(x.k, (String)localObject1, 0, 0, true, 3, null);
              }
              ((Collection)localObject2).add(localObject1);
            }
          }
          Object localObject2 = this.h;
          if (localObject2 == null) {
            localObject2 = null;
          } else {
            localObject2 = x.b.g(x.k, (String)localObject2, 0, 0, false, 7, null);
          }
          return new x(str1, str2, str3, str4, j, localArrayList, (List)localObject1, (String)localObject2, toString());
        }
        throw new IllegalStateException("host == null");
      }
      throw new IllegalStateException("scheme == null");
    }
    
    public final a e(String paramString)
    {
      Object localObject = null;
      if (paramString == null)
      {
        paramString = localObject;
      }
      else
      {
        x.b localb = x.k;
        paramString = x.b.b(localb, paramString, 0, 0, " \"'<>#", true, false, true, false, null, 211, null);
        if (paramString == null) {
          paramString = localObject;
        } else {
          paramString = localb.i(paramString);
        }
      }
      A(paramString);
      return this;
    }
    
    public final String f()
    {
      return this.h;
    }
    
    public final String g()
    {
      return this.c;
    }
    
    public final List<String> h()
    {
      return this.f;
    }
    
    public final List<String> i()
    {
      return this.g;
    }
    
    public final String j()
    {
      return this.b;
    }
    
    public final String k()
    {
      return this.d;
    }
    
    public final int l()
    {
      return this.e;
    }
    
    public final String m()
    {
      return this.a;
    }
    
    public final a n(String paramString)
    {
      a9.f.f(paramString, "host");
      String str = m9.f.a(x.b.g(x.k, paramString, 0, 0, false, 7, null));
      if (str != null)
      {
        C(str);
        return this;
      }
      throw new IllegalArgumentException(a9.f.m("unexpected host: ", paramString));
    }
    
    public final a q(x paramx, String paramString)
    {
      String str = paramString;
      a9.f.f(str, "input");
      int j = m9.l.r(str, 0, 0, 3, null);
      int n = m9.l.t(str, j, 0, 2, null);
      Object localObject2 = i;
      int k = a.c((a)localObject2, str, j, n);
      Object localObject1 = "this as java.lang.String…ing(startIndex, endIndex)";
      int m = -1;
      int i2 = 1;
      if (k != -1)
      {
        if (f9.l.u(str, "https:", j, true))
        {
          this.a = "https";
          j += 6;
        }
        else if (f9.l.u(str, "http:", j, true))
        {
          this.a = "http";
          j += 5;
        }
        else
        {
          paramx = new StringBuilder();
          paramx.append("Expected URL scheme 'http' or 'https' but was '");
          paramString = str.substring(0, k);
          a9.f.e(paramString, "this as java.lang.String…ing(startIndex, endIndex)");
          paramx.append(paramString);
          paramx.append('\'');
          throw new IllegalArgumentException(paramx.toString());
        }
      }
      else
      {
        if (paramx == null) {
          break label1143;
        }
        this.a = paramx.r();
      }
      k = a.d((a)localObject2, str, j, n);
      int i3;
      int i1;
      int i5;
      int i4;
      if ((k < 2) && (paramx != null) && (a9.f.a(paramx.r(), this.a)))
      {
        this.b = paramx.g();
        this.c = paramx.c();
        this.d = paramx.i();
        this.e = paramx.n();
        this.f.clear();
        this.f.addAll(paramx.e());
        if ((j == n) || (str.charAt(j) == '#')) {
          e(paramx.f());
        }
      }
      else
      {
        i3 = j + k;
        k = 0;
        i1 = k;
        paramx = (x)localObject1;
        j = i2;
        i5 = m9.l.i(str, "@/\\?#", i3, n);
        if (i5 != n) {
          i4 = str.charAt(i5);
        } else {
          i4 = m;
        }
        if (i4 == 64)
        {
          if (k == 0)
          {
            i2 = m9.l.h(str, ':', i3, i5);
            x.b localb = x.k;
            m = j;
            localObject2 = x.b.b(localb, paramString, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
            localObject1 = localObject2;
            if (i1 != 0)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(this.b);
              ((StringBuilder)localObject1).append("%40");
              ((StringBuilder)localObject1).append((String)localObject2);
              localObject1 = ((StringBuilder)localObject1).toString();
            }
            this.b = ((String)localObject1);
            if (i2 != i5)
            {
              this.c = x.b.b(localb, paramString, i2 + 1, i5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
              k = m;
            }
            i1 = m;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.c);
            ((StringBuilder)localObject1).append("%40");
            ((StringBuilder)localObject1).append(x.b.b(x.k, paramString, i3, i5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
            this.c = ((StringBuilder)localObject1).toString();
          }
          i3 = i5 + 1;
          m = -1;
        }
      }
      for (;;)
      {
        break;
        if (i4 == m) {}
        while (i4 == 47)
        {
          i2 = j;
          break;
        }
        i2 = 0;
        if (i2 != 0) {}
        while (i4 == 92)
        {
          i2 = j;
          break;
        }
        i2 = 0;
        if (i2 != 0) {
          i2 = j;
        } else if (i4 == 63) {
          i2 = j;
        } else {
          i2 = 0;
        }
        if (i2 != 0) {
          i2 = j;
        } else if (i4 == 35) {
          i2 = j;
        } else {
          i2 = 0;
        }
        if (i2 != 0)
        {
          localObject1 = i;
          i1 = a.b((a)localObject1, str, i3, i5);
          i2 = i1 + 1;
          if (i2 < i5)
          {
            this.d = m9.f.a(x.b.g(x.k, paramString, i3, i1, false, 4, null));
            k = a.a((a)localObject1, str, i2, i5);
            this.e = k;
            if (k != m) {
              k = j;
            } else {
              k = 0;
            }
            if (k == 0)
            {
              paramString = new StringBuilder();
              paramString.append("Invalid URL port: \"");
              str = str.substring(i2, i5);
              a9.f.e(str, paramx);
              paramString.append(str);
              paramString.append('"');
              throw new IllegalArgumentException(paramString.toString().toString());
            }
          }
          else
          {
            localObject1 = x.k;
            this.d = m9.f.a(x.b.g((x.b)localObject1, paramString, i3, i1, false, 4, null));
            localObject2 = this.a;
            a9.f.c(localObject2);
            this.e = ((x.b)localObject1).c((String)localObject2);
          }
          if (this.d == null) {
            j = 0;
          }
          if (j != 0)
          {
            j = i5;
            k = m9.l.i(str, "?#", j, n);
            w(str, j, k);
            j = k;
            if (k < n)
            {
              j = k;
              if (str.charAt(k) == '?')
              {
                j = m9.l.h(str, '#', k, n);
                paramx = x.k;
                this.g = paramx.i(x.b.b(paramx, paramString, k + 1, j, " \"'<>#", true, false, true, false, null, 208, null));
              }
            }
            if ((j < n) && (str.charAt(j) == '#')) {
              this.h = x.b.b(x.k, paramString, j + 1, n, "", true, false, false, true, null, 176, null);
            }
            return this;
          }
          paramString = new StringBuilder();
          paramString.append("Invalid URL host: \"");
          str = str.substring(i3, i1);
          a9.f.e(str, paramx);
          paramString.append(str);
          paramString.append('"');
          throw new IllegalArgumentException(paramString.toString().toString());
        }
      }
      label1143:
      paramx = str;
      if (paramString.length() > 6) {
        paramx = a9.f.m(f9.l.p0(str, 6), "...");
      }
      throw new IllegalArgumentException(a9.f.m("Expected URL scheme 'http' or 'https' but no scheme was found for ", paramx));
    }
    
    public final a r(String paramString)
    {
      a9.f.f(paramString, "password");
      z(x.b.b(x.k, paramString, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
      return this;
    }
    
    public final a t(int paramInt)
    {
      int k = 0;
      int j = k;
      if (1 <= paramInt)
      {
        j = k;
        if (paramInt < 65536) {
          j = 1;
        }
      }
      if (j != 0)
      {
        D(paramInt);
        return this;
      }
      throw new IllegalArgumentException(a9.f.m("unexpected port: ", Integer.valueOf(paramInt)).toString());
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (m() != null)
      {
        localStringBuilder.append(m());
        localObject1 = "://";
      }
      else
      {
        localObject1 = "//";
      }
      localStringBuilder.append((String)localObject1);
      int j = j().length();
      int k = 1;
      if (j > 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j == 0)
      {
        if (g().length() > 0) {
          j = 1;
        } else {
          j = 0;
        }
        if (j == 0) {}
      }
      else
      {
        localStringBuilder.append(j());
        if (g().length() > 0) {
          j = k;
        } else {
          j = 0;
        }
        if (j != 0)
        {
          localStringBuilder.append(':');
          localStringBuilder.append(g());
        }
        localStringBuilder.append('@');
      }
      if (k() != null)
      {
        localObject1 = k();
        a9.f.c(localObject1);
        if (f9.l.B((CharSequence)localObject1, ':', false, 2, null))
        {
          localStringBuilder.append('[');
          localStringBuilder.append(k());
          localStringBuilder.append(']');
        }
        else
        {
          localStringBuilder.append(k());
        }
      }
      Object localObject2;
      if ((l() != -1) || (m() != null))
      {
        j = d();
        if (m() != null)
        {
          localObject1 = x.k;
          localObject2 = m();
          a9.f.c(localObject2);
          if (j == ((x.b)localObject1).c((String)localObject2)) {}
        }
        else
        {
          localStringBuilder.append(':');
          localStringBuilder.append(j);
        }
      }
      Object localObject1 = x.k;
      ((x.b)localObject1).h(h(), localStringBuilder);
      if (i() != null)
      {
        localStringBuilder.append('?');
        localObject2 = i();
        a9.f.c(localObject2);
        ((x.b)localObject1).j((List)localObject2, localStringBuilder);
      }
      if (f() != null)
      {
        localStringBuilder.append('#');
        localStringBuilder.append(f());
      }
      localObject1 = localStringBuilder.toString();
      a9.f.e(localObject1, "StringBuilder().apply(builderAction).toString()");
      return localObject1;
    }
    
    public final a v()
    {
      Object localObject1 = k();
      Object localObject2 = null;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = new j("[\"<>^`{|}]").c((CharSequence)localObject1, "");
      }
      C((String)localObject1);
      int m = h().size();
      int k = 0;
      int j = 0;
      while (j < m)
      {
        h().set(j, x.b.b(x.k, (String)h().get(j), 0, 0, "[]", true, true, false, false, null, 227, null));
        j += 1;
      }
      List localList = i();
      if (localList != null)
      {
        m = localList.size();
        j = k;
        while (j < m)
        {
          localObject1 = (String)localList.get(j);
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = x.b.b(x.k, (String)localObject1, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null);
          }
          localList.set(j, localObject1);
          j += 1;
        }
      }
      localObject1 = f();
      if (localObject1 == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = x.b.b(x.k, (String)localObject1, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null);
      }
      y((String)localObject1);
      return this;
    }
    
    public final a x(String paramString)
    {
      a9.f.f(paramString, "scheme");
      String str = "http";
      if (f9.l.l(paramString, "http", true)) {}
      for (paramString = str;; paramString = str)
      {
        E(paramString);
        return this;
        str = "https";
        if (!f9.l.l(paramString, "https", true)) {
          break;
        }
      }
      throw new IllegalArgumentException(a9.f.m("unexpected scheme: ", paramString));
    }
    
    public final void y(String paramString)
    {
      this.h = paramString;
    }
    
    public final void z(String paramString)
    {
      a9.f.f(paramString, "<set-?>");
      this.c = paramString;
    }
    
    public static final class a
    {
      private final int e(String paramString, int paramInt1, int paramInt2)
      {
        int i = -1;
        try
        {
          int j = Integer.parseInt(x.b.b(x.k, paramString, paramInt1, paramInt2, "", false, false, false, false, null, 248, null));
          paramInt2 = 0;
          paramInt1 = paramInt2;
          if (1 <= j)
          {
            paramInt1 = paramInt2;
            if (j < 65536) {
              paramInt1 = 1;
            }
          }
          paramInt2 = i;
          if (paramInt1 != 0) {
            paramInt2 = j;
          }
          return paramInt2;
        }
        catch (NumberFormatException paramString) {}
        return -1;
      }
      
      private final int f(String paramString, int paramInt1, int paramInt2)
      {
        while (paramInt1 < paramInt2)
        {
          int j = paramString.charAt(paramInt1);
          int i;
          if (j == 91)
          {
            i = paramInt1;
            do
            {
              paramInt1 = i + 1;
              i = paramInt1;
              if (paramInt1 >= paramInt2) {
                break;
              }
              i = paramInt1;
            } while (paramString.charAt(paramInt1) != ']');
            i = paramInt1;
          }
          else
          {
            i = paramInt1;
            if (j == 58) {
              return paramInt1;
            }
          }
          paramInt1 = i + 1;
        }
        return paramInt2;
      }
      
      private final int g(String paramString, int paramInt1, int paramInt2)
      {
        int j = -1;
        if (paramInt2 - paramInt1 < 2) {
          return -1;
        }
        int k = paramString.charAt(paramInt1);
        if ((a9.f.h(k, 97) < 0) || (a9.f.h(k, 122) > 0))
        {
          i = j;
          if (a9.f.h(k, 65) < 0) {
            break label272;
          }
          if (a9.f.h(k, 90) > 0) {
            return -1;
          }
        }
        paramInt1 += 1;
        int m;
        for (;;)
        {
          i = j;
          if (paramInt1 >= paramInt2) {
            break label272;
          }
          m = paramString.charAt(paramInt1);
          k = 0;
          if ((97 <= m) && (m < 123)) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {}
          while ((65 <= m) && (m < 91))
          {
            i = 1;
            break;
          }
          i = 0;
          if (i != 0) {}
          while ((48 <= m) && (m < 58))
          {
            i = 1;
            break;
          }
          i = 0;
          if (i != 0) {}
          while (m == 43)
          {
            i = 1;
            break;
          }
          i = 0;
          if (i != 0) {}
          while (m == 45)
          {
            i = 1;
            break;
          }
          i = 0;
          if (i != 0) {}
          do
          {
            i = 1;
            break;
            i = k;
          } while (m == 46);
          if (i == 0) {
            break;
          }
          paramInt1 += 1;
        }
        int i = j;
        if (m == 58) {
          i = paramInt1;
        }
        label272:
        return i;
      }
      
      private final int h(String paramString, int paramInt1, int paramInt2)
      {
        int i = 0;
        while (paramInt1 < paramInt2)
        {
          int j = paramString.charAt(paramInt1);
          if ((j != 92) && (j != 47)) {
            break;
          }
          i += 1;
          paramInt1 += 1;
        }
        return i;
      }
    }
  }
  
  public static final class b
  {
    private final boolean e(String paramString, int paramInt1, int paramInt2)
    {
      int i = paramInt1 + 2;
      return (i < paramInt2) && (paramString.charAt(paramInt1) == '%') && (m9.l.z(paramString.charAt(paramInt1 + 1)) != -1) && (m9.l.z(paramString.charAt(i)) != -1);
    }
    
    private final void k(b paramb, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
    {
      Object localObject1 = null;
      while (paramInt1 < paramInt2)
      {
        int i = paramString1.codePointAt(paramInt1);
        if ((!paramBoolean1) || ((i == 9) || (i == 10) || (i == 12) || (i != 13)))
        {
          Object localObject2 = "+";
          if ((i == 32) && (paramString2 == " !\"#$&'()+,/:;<=>?@[\\]^`{|}~")) {}
          for (;;)
          {
            paramb.N0((String)localObject2);
            break;
            if ((i != 43) || (!paramBoolean3)) {
              break label107;
            }
            if (!paramBoolean1) {
              localObject2 = "%2B";
            }
          }
          label107:
          if ((i >= 32) && (i != 127) && ((i < 128) || (paramBoolean4)) && (!f9.l.B(paramString2, (char)i, false, 2, null)) && ((i != 37) || ((paramBoolean1) && ((!paramBoolean2) || (e(paramString1, paramInt1, paramInt2))))))
          {
            paramb.P0(i);
          }
          else
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new b();
            }
            if ((paramCharset != null) && (!a9.f.a(paramCharset, d.b))) {
              ((b)localObject2).M0(paramString1, paramInt1, Character.charCount(i) + paramInt1, paramCharset);
            } else {
              ((b)localObject2).P0(i);
            }
            for (;;)
            {
              localObject1 = localObject2;
              if (((b)localObject2).D()) {
                break;
              }
              int j = ((b)localObject2).readByte() & 0xFF;
              paramb.H0(37);
              paramb.H0(x.a()[(j >> 4 & 0xF)]);
              paramb.H0(x.a()[(j & 0xF)]);
            }
          }
        }
        paramInt1 += Character.charCount(i);
      }
    }
    
    private final void l(b paramb, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      while (paramInt1 < paramInt2)
      {
        int i = paramString.codePointAt(paramInt1);
        if (i == 37)
        {
          int j = paramInt1 + 2;
          if (j < paramInt2)
          {
            int k = m9.l.z(paramString.charAt(paramInt1 + 1));
            int m = m9.l.z(paramString.charAt(j));
            if ((k == -1) || (m == -1)) {
              break label117;
            }
            paramb.H0((k << 4) + m);
            paramInt1 = Character.charCount(i) + j;
            continue;
          }
        }
        if ((i == 43) && (paramBoolean))
        {
          paramb.H0(32);
          paramInt1 += 1;
        }
        else
        {
          label117:
          paramb.P0(i);
          paramInt1 += Character.charCount(i);
        }
      }
    }
    
    public final String a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
    {
      a9.f.f(paramString1, "<this>");
      a9.f.f(paramString2, "encodeSet");
      int i = paramInt1;
      while (i < paramInt2)
      {
        int j = paramString1.codePointAt(i);
        if ((j >= 32) && (j != 127) && ((j < 128) || (paramBoolean4)) && (!f9.l.B(paramString2, (char)j, false, 2, null)))
        {
          if (j == 37)
          {
            if (!paramBoolean1) {
              break label130;
            }
            if (paramBoolean2) {
              if (!e(paramString1, i, paramInt2)) {
                break label130;
              }
            }
          }
          if ((j != 43) || (!paramBoolean3))
          {
            i += Character.charCount(j);
            continue;
          }
        }
        label130:
        b localb = new b();
        localb.O0(paramString1, paramInt1, i);
        k(localb, paramString1, i, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramCharset);
        return localb.v0();
      }
      paramString1 = paramString1.substring(paramInt1, paramInt2);
      a9.f.e(paramString1, "this as java.lang.String…ing(startIndex, endIndex)");
      return paramString1;
    }
    
    public final int c(String paramString)
    {
      a9.f.f(paramString, "scheme");
      if (a9.f.a(paramString, "http")) {
        return 80;
      }
      if (a9.f.a(paramString, "https")) {
        return 443;
      }
      return -1;
    }
    
    public final x d(String paramString)
    {
      a9.f.f(paramString, "<this>");
      return new x.a().q(null, paramString).c();
    }
    
    public final String f(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      a9.f.f(paramString, "<this>");
      int i = paramInt1;
      while (i < paramInt2)
      {
        int j = paramString.charAt(i);
        if ((j != 37) && ((j != 43) || (!paramBoolean)))
        {
          i += 1;
        }
        else
        {
          b localb = new b();
          localb.O0(paramString, paramInt1, i);
          l(localb, paramString, i, paramInt2, paramBoolean);
          return localb.v0();
        }
      }
      paramString = paramString.substring(paramInt1, paramInt2);
      a9.f.e(paramString, "this as java.lang.String…ing(startIndex, endIndex)");
      return paramString;
    }
    
    public final void h(List<String> paramList, StringBuilder paramStringBuilder)
    {
      a9.f.f(paramList, "<this>");
      a9.f.f(paramStringBuilder, "out");
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        paramStringBuilder.append('/');
        paramStringBuilder.append((String)paramList.get(i));
        i += 1;
      }
    }
    
    public final List<String> i(String paramString)
    {
      a9.f.f(paramString, "<this>");
      ArrayList localArrayList = new ArrayList();
      int j;
      for (int i = 0; i <= paramString.length(); i = j + 1)
      {
        int k = f9.l.M(paramString, '&', i, false, 4, null);
        j = k;
        if (k == -1) {
          j = paramString.length();
        }
        k = f9.l.M(paramString, '=', i, false, 4, null);
        String str;
        if ((k != -1) && (k <= j))
        {
          str = paramString.substring(i, k);
          a9.f.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
          localArrayList.add(str);
          str = paramString.substring(k + 1, j);
          a9.f.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        else
        {
          str = paramString.substring(i, j);
          a9.f.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
          localArrayList.add(str);
          str = null;
        }
        localArrayList.add(str);
      }
      return localArrayList;
    }
    
    public final void j(List<String> paramList, StringBuilder paramStringBuilder)
    {
      a9.f.f(paramList, "<this>");
      a9.f.f(paramStringBuilder, "out");
      Object localObject = g.h(g.i(0, paramList.size()), 2);
      int j = ((a)localObject).a();
      int k = ((a)localObject).b();
      int m = ((a)localObject).c();
      int i;
      if (m > 0)
      {
        i = j;
        if (j <= k) {}
      }
      else
      {
        if ((m >= 0) || (k > j)) {
          return;
        }
        i = j;
      }
      for (;;)
      {
        localObject = (String)paramList.get(i);
        String str = (String)paramList.get(i + 1);
        if (i > 0) {
          paramStringBuilder.append('&');
        }
        paramStringBuilder.append((String)localObject);
        if (str != null)
        {
          paramStringBuilder.append('=');
          paramStringBuilder.append(str);
        }
        if (i == k) {
          return;
        }
        i += m;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.x
 * JD-Core Version:    0.7.0.1
 */