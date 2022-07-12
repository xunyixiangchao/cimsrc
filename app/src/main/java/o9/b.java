package o9;

import a9.f;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import l9.d;
import l9.d0;
import l9.d0.a;
import l9.f0;
import l9.f0.a;
import l9.w;
import l9.w.a;
import l9.x;
import r9.c;

public final class b
{
  public static final a c = new a(null);
  private final d0 a;
  private final f0 b;
  
  public b(d0 paramd0, f0 paramf0)
  {
    this.a = paramd0;
    this.b = paramf0;
  }
  
  public final f0 a()
  {
    return this.b;
  }
  
  public final d0 b()
  {
    return this.a;
  }
  
  public static final class a
  {
    public final boolean a(f0 paramf0, d0 paramd0)
    {
      f.f(paramf0, "response");
      f.f(paramd0, "request");
      int i = paramf0.B();
      boolean bool2 = false;
      if ((i != 200) && (i != 410) && (i != 414) && (i != 501) && (i != 203) && (i != 204)) {
        if (i != 307)
        {
          if ((i == 308) || (i == 404) || (i == 405)) {}
        }
        else {
          switch (i)
          {
          default: 
            return false;
          case 302: 
            if ((f0.h0(paramf0, "Expires", null, 2, null) == null) && (paramf0.g().e() == -1) && (!paramf0.g().d()) && (!paramf0.g().c())) {
              return false;
            }
            break;
          }
        }
      }
      boolean bool1 = bool2;
      if (!paramf0.g().j())
      {
        bool1 = bool2;
        if (!paramd0.b().j()) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public static final class b
  {
    private final long a;
    private final d0 b;
    private final f0 c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l;
    
    public b(long paramLong, d0 paramd0, f0 paramf0)
    {
      this.a = paramLong;
      this.b = paramd0;
      this.c = paramf0;
      this.l = -1;
      if (paramf0 != null)
      {
        this.i = paramf0.r0();
        this.j = paramf0.p0();
        paramd0 = paramf0.i0();
        int m = 0;
        int n = paramd0.size();
        while (m < n)
        {
          paramf0 = paramd0.c(m);
          String str = paramd0.f(m);
          if (f9.l.l(paramf0, "Date", true))
          {
            this.d = c.a(str);
            this.e = str;
          }
          else if (f9.l.l(paramf0, "Expires", true))
          {
            this.h = c.a(str);
          }
          else if (f9.l.l(paramf0, "Last-Modified", true))
          {
            this.f = c.a(str);
            this.g = str;
          }
          else if (f9.l.l(paramf0, "ETag", true))
          {
            this.k = str;
          }
          else if (f9.l.l(paramf0, "Age", true))
          {
            this.l = m9.l.D(str, -1);
          }
          m += 1;
        }
      }
    }
    
    private final long a()
    {
      Date localDate = this.d;
      long l1 = 0L;
      if (localDate != null) {
        l1 = Math.max(0L, this.j - localDate.getTime());
      }
      int m = this.l;
      long l2 = l1;
      if (m != -1) {
        l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(m));
      }
      l1 = this.j;
      return l2 + (l1 - this.i) + (this.a - l1);
    }
    
    private final b c()
    {
      if (this.c == null) {
        return new b(this.b, null);
      }
      if ((this.b.f()) && (this.c.f0() == null)) {
        return new b(this.b, null);
      }
      if (!b.c.a(this.c, this.b)) {
        return new b(this.b, null);
      }
      Object localObject1 = this.b.b();
      if ((!((d)localObject1).i()) && (!e(this.b)))
      {
        Object localObject2 = this.c.g();
        long l5 = a();
        long l2 = d();
        long l1 = l2;
        if (((d)localObject1).e() != -1) {
          l1 = Math.min(l2, TimeUnit.SECONDS.toMillis(((d)localObject1).e()));
        }
        int m = ((d)localObject1).g();
        long l4 = 0L;
        if (m != -1) {
          l2 = TimeUnit.SECONDS.toMillis(((d)localObject1).g());
        } else {
          l2 = 0L;
        }
        long l3 = l4;
        if (!((d)localObject2).h())
        {
          l3 = l4;
          if (((d)localObject1).f() != -1) {
            l3 = TimeUnit.SECONDS.toMillis(((d)localObject1).f());
          }
        }
        if (!((d)localObject2).i())
        {
          l2 += l5;
          if (l2 < l3 + l1)
          {
            localObject1 = this.c.m0();
            if (l2 >= l1) {
              ((f0.a)localObject1).a("Warning", "110 HttpURLConnection \"Response is stale\"");
            }
            if ((l5 > 86400000L) && (f())) {
              ((f0.a)localObject1).a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }
            return new b(null, ((f0.a)localObject1).c());
          }
        }
        localObject1 = this.k;
        localObject2 = "If-Modified-Since";
        if (localObject1 != null)
        {
          localObject2 = "If-None-Match";
        }
        else if (this.f != null)
        {
          localObject1 = this.g;
        }
        else
        {
          if (this.d == null) {
            break label437;
          }
          localObject1 = this.e;
        }
        w.a locala = this.b.e().d();
        f.c(localObject1);
        locala.d((String)localObject2, (String)localObject1);
        return new b(this.b.h().f(locala.f()).b(), this.c);
        label437:
        return new b(this.b, null);
      }
      return new b(this.b, null);
    }
    
    private final long d()
    {
      Object localObject = this.c;
      f.c(localObject);
      localObject = ((f0)localObject).g();
      if (((d)localObject).e() != -1) {
        return TimeUnit.SECONDS.toMillis(((d)localObject).e());
      }
      Date localDate2 = this.h;
      Date localDate1 = null;
      localObject = null;
      long l1 = 0L;
      if (localDate2 != null)
      {
        localDate1 = this.d;
        if (localDate1 != null) {
          localObject = Long.valueOf(localDate1.getTime());
        }
        if (localObject == null) {
          l2 = this.j;
        } else {
          l2 = ((Long)localObject).longValue();
        }
        l2 = localDate2.getTime() - l2;
        if (l2 > 0L) {
          l1 = l2;
        }
        return l1;
      }
      long l2 = l1;
      if (this.f != null)
      {
        l2 = l1;
        if (this.c.q0().j().o() == null)
        {
          localObject = this.d;
          if (localObject == null) {
            localObject = localDate1;
          } else {
            localObject = Long.valueOf(((Date)localObject).getTime());
          }
          if (localObject == null) {
            l2 = this.i;
          } else {
            l2 = ((Long)localObject).longValue();
          }
          localObject = this.f;
          f.c(localObject);
          long l3 = l2 - ((Date)localObject).getTime();
          l2 = l1;
          if (l3 > 0L) {
            l2 = l3 / 10;
          }
        }
      }
      return l2;
    }
    
    private final boolean e(d0 paramd0)
    {
      return (paramd0.d("If-Modified-Since") != null) || (paramd0.d("If-None-Match") != null);
    }
    
    private final boolean f()
    {
      f0 localf0 = this.c;
      f.c(localf0);
      return (localf0.g().e() == -1) && (this.h == null);
    }
    
    public final b b()
    {
      b localb2 = c();
      b localb1 = localb2;
      if (localb2.b() != null)
      {
        localb1 = localb2;
        if (this.b.b().l()) {
          localb1 = new b(null, null);
        }
      }
      return localb1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o9.b
 * JD-Core Version:    0.7.0.1
 */