package t9;

import aa.b;
import aa.e;
import aa.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class d
{
  public static final d a;
  private static final c[] b;
  private static final Map<e, Integer> c;
  
  static
  {
    d locald = new d();
    a = locald;
    c localc1 = new c(c.j, "");
    Object localObject1 = c.g;
    c localc2 = new c((e)localObject1, "GET");
    localObject1 = new c((e)localObject1, "POST");
    Object localObject2 = c.h;
    c localc3 = new c((e)localObject2, "/");
    localObject2 = new c((e)localObject2, "/index.html");
    Object localObject3 = c.i;
    c localc4 = new c((e)localObject3, "http");
    localObject3 = new c((e)localObject3, "https");
    e locale = c.f;
    b = new c[] { localc1, localc2, localObject1, localc3, localObject2, localc4, localObject3, new c(locale, "200"), new c(locale, "204"), new c(locale, "206"), new c(locale, "304"), new c(locale, "400"), new c(locale, "404"), new c(locale, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "") };
    c = locald.d();
  }
  
  private final Map<e, Integer> d()
  {
    c[] arrayOfc = b;
    Object localObject = new LinkedHashMap(arrayOfc.length);
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      arrayOfc = b;
      if (!((LinkedHashMap)localObject).containsKey(arrayOfc[i].a)) {
        ((Map)localObject).put(arrayOfc[i].a, Integer.valueOf(i));
      }
      i += 1;
    }
    localObject = Collections.unmodifiableMap((Map)localObject);
    a9.f.e(localObject, "unmodifiableMap(result)");
    return localObject;
  }
  
  public final e a(e parame)
  {
    a9.f.f(parame, "name");
    int k = parame.r();
    int i = 0;
    while (i < k)
    {
      int j = (byte)65;
      int m = (byte)90;
      int n = parame.d(i);
      if ((j <= n) && (n <= m)) {
        j = 1;
      } else {
        j = 0;
      }
      if (j == 0) {
        i += 1;
      } else {
        throw new IOException(a9.f.m("PROTOCOL_ERROR response malformed: mixed case name: ", parame.u()));
      }
    }
    return parame;
  }
  
  public final Map<e, Integer> b()
  {
    return c;
  }
  
  public final c[] c()
  {
    return b;
  }
  
  public static final class a
  {
    private final int a;
    private int b;
    private final List<c> c;
    private final aa.d d;
    public c[] e;
    private int f;
    public int g;
    public int h;
    
    public a(x paramx, int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = new ArrayList();
      this.d = aa.l.b(paramx);
      paramx = new c[8];
      this.e = paramx;
      this.f = (paramx.length - 1);
    }
    
    private final void a()
    {
      int i = this.b;
      int j = this.h;
      if (i < j)
      {
        if (i == 0)
        {
          b();
          return;
        }
        d(j - i);
      }
    }
    
    private final void b()
    {
      p8.f.l(this.e, null, 0, 0, 6, null);
      this.f = (this.e.length - 1);
      this.g = 0;
      this.h = 0;
    }
    
    private final int c(int paramInt)
    {
      return this.f + 1 + paramInt;
    }
    
    private final int d(int paramInt)
    {
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.e.length - 1;
        int j = paramInt;
        paramInt = k;
        for (;;)
        {
          k = this.f;
          if ((i < k) || (j <= 0)) {
            break;
          }
          localObject = this.e[i];
          a9.f.c(localObject);
          k = ((c)localObject).c;
          j -= k;
          this.h -= k;
          this.g -= 1;
          paramInt += 1;
          i -= 1;
        }
        Object localObject = this.e;
        System.arraycopy(localObject, k + 1, localObject, k + 1 + paramInt, this.g);
        this.f += paramInt;
        i = paramInt;
      }
      return i;
    }
    
    private final e f(int paramInt)
    {
      Object localObject;
      if (h(paramInt)) {
        localObject = d.a.c()[paramInt];
      }
      for (;;)
      {
        return ((c)localObject).a;
        int i = c(paramInt - d.a.c().length);
        if (i < 0) {
          break;
        }
        localObject = this.e;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        a9.f.c(localObject);
      }
      throw new IOException(a9.f.m("Header index too large ", Integer.valueOf(paramInt + 1)));
    }
    
    private final void g(int paramInt, c paramc)
    {
      this.c.add(paramc);
      int j = paramc.c;
      int i = j;
      Object localObject;
      if (paramInt != -1)
      {
        localObject = this.e[c(paramInt)];
        a9.f.c(localObject);
        i = j - ((c)localObject).c;
      }
      j = this.b;
      if (i > j)
      {
        b();
        return;
      }
      j = d(this.h + i - j);
      if (paramInt == -1)
      {
        paramInt = this.g;
        localObject = this.e;
        if (paramInt + 1 > localObject.length)
        {
          c[] arrayOfc = new c[localObject.length * 2];
          System.arraycopy(localObject, 0, arrayOfc, localObject.length, localObject.length);
          this.f = (this.e.length - 1);
          this.e = arrayOfc;
        }
        paramInt = this.f;
        this.f = (paramInt - 1);
        this.e[paramInt] = paramc;
        this.g += 1;
      }
      else
      {
        int k = c(paramInt);
        this.e[(paramInt + (k + j))] = paramc;
      }
      this.h += i;
    }
    
    private final boolean h(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= d.a.c().length - 1);
    }
    
    private final int i()
    {
      return m9.l.b(this.d.readByte(), 255);
    }
    
    private final void l(int paramInt)
    {
      Object localObject1;
      if (h(paramInt))
      {
        localObject1 = d.a.c()[paramInt];
        this.c.add(localObject1);
        return;
      }
      int i = c(paramInt - d.a.c().length);
      if (i >= 0)
      {
        Object localObject2 = this.e;
        if (i < localObject2.length)
        {
          localObject1 = this.c;
          localObject2 = localObject2[i];
          a9.f.c(localObject2);
          ((Collection)localObject1).add(localObject2);
          return;
        }
      }
      throw new IOException(a9.f.m("Header index too large ", Integer.valueOf(paramInt + 1)));
    }
    
    private final void n(int paramInt)
    {
      g(-1, new c(f(paramInt), j()));
    }
    
    private final void o()
    {
      g(-1, new c(d.a.a(j()), j()));
    }
    
    private final void p(int paramInt)
    {
      e locale1 = f(paramInt);
      e locale2 = j();
      this.c.add(new c(locale1, locale2));
    }
    
    private final void q()
    {
      e locale1 = d.a.a(j());
      e locale2 = j();
      this.c.add(new c(locale1, locale2));
    }
    
    public final List<c> e()
    {
      List localList = p8.l.J(this.c);
      this.c.clear();
      return localList;
    }
    
    public final e j()
    {
      int j = i();
      int i;
      if ((j & 0x80) == 128) {
        i = 1;
      } else {
        i = 0;
      }
      long l = m(j, 127);
      if (i != 0)
      {
        b localb = new b();
        k.a.b(this.d, l, localb);
        return localb.p0();
      }
      return this.d.o(l);
    }
    
    public final void k()
    {
      while (!this.d.D())
      {
        int i = m9.l.b(this.d.readByte(), 255);
        if (i != 128)
        {
          if ((i & 0x80) == 128)
          {
            l(m(i, 127) - 1);
          }
          else if (i == 64)
          {
            o();
          }
          else if ((i & 0x40) == 64)
          {
            n(m(i, 63) - 1);
          }
          else if ((i & 0x20) == 32)
          {
            i = m(i, 31);
            this.b = i;
            if ((i >= 0) && (i <= this.a)) {
              a();
            } else {
              throw new IOException(a9.f.m("Invalid dynamic table size update ", Integer.valueOf(this.b)));
            }
          }
          else if ((i != 16) && (i != 0))
          {
            p(m(i, 15) - 1);
          }
          else
          {
            q();
          }
        }
        else {
          throw new IOException("index == 0");
        }
      }
    }
    
    public final int m(int paramInt1, int paramInt2)
    {
      paramInt1 &= paramInt2;
      if (paramInt1 < paramInt2) {
        return paramInt1;
      }
      paramInt1 = 0;
      int i;
      for (;;)
      {
        i = i();
        if ((i & 0x80) == 0) {
          break;
        }
        paramInt2 += ((i & 0x7F) << paramInt1);
        paramInt1 += 7;
      }
      return paramInt2 + (i << paramInt1);
    }
  }
  
  public static final class b
  {
    public int a;
    private final boolean b;
    private final b c;
    private int d;
    private boolean e;
    public int f;
    public c[] g;
    private int h;
    public int i;
    public int j;
    
    public b(int paramInt, boolean paramBoolean, b paramb)
    {
      this.a = paramInt;
      this.b = paramBoolean;
      this.c = paramb;
      this.d = 2147483647;
      this.f = paramInt;
      paramb = new c[8];
      this.g = paramb;
      this.h = (paramb.length - 1);
    }
    
    private final void a()
    {
      int k = this.f;
      int m = this.j;
      if (k < m)
      {
        if (k == 0)
        {
          b();
          return;
        }
        c(m - k);
      }
    }
    
    private final void b()
    {
      p8.f.l(this.g, null, 0, 0, 6, null);
      this.h = (this.g.length - 1);
      this.i = 0;
      this.j = 0;
    }
    
    private final int c(int paramInt)
    {
      int k = 0;
      int n = 0;
      if (paramInt > 0)
      {
        k = this.g.length - 1;
        int m = paramInt;
        paramInt = n;
        for (;;)
        {
          n = this.h;
          if ((k < n) || (m <= 0)) {
            break;
          }
          localObject = this.g[k];
          a9.f.c(localObject);
          m -= ((c)localObject).c;
          n = this.j;
          localObject = this.g[k];
          a9.f.c(localObject);
          this.j = (n - ((c)localObject).c);
          this.i -= 1;
          paramInt += 1;
          k -= 1;
        }
        Object localObject = this.g;
        System.arraycopy(localObject, n + 1, localObject, n + 1 + paramInt, this.i);
        localObject = this.g;
        k = this.h;
        Arrays.fill((Object[])localObject, k + 1, k + 1 + paramInt, null);
        this.h += paramInt;
        k = paramInt;
      }
      return k;
    }
    
    private final void d(c paramc)
    {
      int k = paramc.c;
      int m = this.f;
      if (k > m)
      {
        b();
        return;
      }
      c(this.j + k - m);
      m = this.i;
      c[] arrayOfc1 = this.g;
      if (m + 1 > arrayOfc1.length)
      {
        c[] arrayOfc2 = new c[arrayOfc1.length * 2];
        System.arraycopy(arrayOfc1, 0, arrayOfc2, arrayOfc1.length, arrayOfc1.length);
        this.h = (this.g.length - 1);
        this.g = arrayOfc2;
      }
      m = this.h;
      this.h = (m - 1);
      this.g[m] = paramc;
      this.i += 1;
      this.j += k;
    }
    
    public final void e(int paramInt)
    {
      this.a = paramInt;
      paramInt = Math.min(paramInt, 16384);
      int k = this.f;
      if (k == paramInt) {
        return;
      }
      if (paramInt < k) {
        this.d = Math.min(this.d, paramInt);
      }
      this.e = true;
      this.f = paramInt;
      a();
    }
    
    public final void f(e parame)
    {
      a9.f.f(parame, "data");
      if (this.b)
      {
        k localk = k.a;
        if (localk.d(parame) < parame.r())
        {
          b localb = new b();
          localk.c(parame, localb);
          parame = localb.p0();
          k = parame.r();
          m = 128;
          break label73;
        }
      }
      int k = parame.r();
      int m = 0;
      label73:
      h(k, 127, m);
      this.c.D0(parame);
    }
    
    public final void g(List<c> paramList)
    {
      a9.f.f(paramList, "headerBlock");
      int k;
      if (this.e)
      {
        k = this.d;
        if (k < this.f) {
          h(k, 31, 32);
        }
        this.e = false;
        this.d = 2147483647;
        h(this.f, 31, 32);
      }
      int i4 = paramList.size();
      int n = 0;
      while (n < i4)
      {
        c localc = (c)paramList.get(n);
        e locale1 = localc.a.t();
        e locale2 = localc.b;
        Object localObject = d.a;
        Integer localInteger = (Integer)((d)localObject).b().get(locale1);
        int m;
        int i1;
        if (localInteger != null)
        {
          m = localInteger.intValue() + 1;
          if ((2 <= m) && (m < 8)) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0)
          {
            if (a9.f.a(localObject.c()[(m - 1)].b, locale2))
            {
              k = m;
              break label230;
            }
            if (a9.f.a(localObject.c()[m].b, locale2))
            {
              i1 = m + 1;
              k = m;
              m = i1;
              break label230;
            }
          }
          k = m;
          m = -1;
        }
        else
        {
          k = -1;
          m = k;
        }
        label230:
        int i2 = k;
        int i3 = m;
        if (m == -1)
        {
          i1 = this.h + 1;
          int i5 = this.g.length;
          for (;;)
          {
            i2 = k;
            i3 = m;
            if (i1 >= i5) {
              break;
            }
            localObject = this.g[i1];
            a9.f.c(localObject);
            i2 = k;
            if (a9.f.a(((c)localObject).a, locale1))
            {
              localObject = this.g[i1];
              a9.f.c(localObject);
              if (a9.f.a(((c)localObject).b, locale2))
              {
                m = this.h;
                i3 = d.a.c().length + (i1 - m);
                i2 = k;
                break;
              }
              i2 = k;
              if (k == -1)
              {
                k = this.h;
                i2 = d.a.c().length + (i1 - k);
              }
            }
            i1 += 1;
            k = i2;
          }
        }
        if (i3 != -1)
        {
          h(i3, 127, 128);
        }
        else
        {
          if (i2 == -1)
          {
            this.c.H0(64);
            f(locale1);
          }
          for (;;)
          {
            f(locale2);
            d(localc);
            break;
            if ((locale1.s(c.e)) && (!a9.f.a(c.j, locale1)))
            {
              h(i2, 15, 0);
              f(locale2);
              break;
            }
            h(i2, 63, 64);
          }
        }
        n += 1;
      }
    }
    
    public final void h(int paramInt1, int paramInt2, int paramInt3)
    {
      b localb;
      if (paramInt1 < paramInt2)
      {
        localb = this.c;
        paramInt1 |= paramInt3;
      }
      for (;;)
      {
        localb.H0(paramInt1);
        return;
        this.c.H0(paramInt3 | paramInt2);
        paramInt1 -= paramInt2;
        while (paramInt1 >= 128)
        {
          this.c.H0(0x80 | paramInt1 & 0x7F);
          paramInt1 >>>= 7;
        }
        localb = this.c;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t9.d
 * JD-Core Version:    0.7.0.1
 */