package q9;

import a9.f;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;
import l9.a;
import l9.b0;
import l9.c0;
import l9.d0;
import l9.d0.a;
import l9.f0;
import l9.f0.a;
import l9.h0;
import l9.t;
import l9.x;
import r9.g;
import u9.h.a;

public final class k
  implements n
{
  private final b0 a;
  private final a b;
  private final h c;
  private final boolean d;
  private o.b e;
  private o f;
  private h0 g;
  
  public k(b0 paramb0, a parama, h paramh, g paramg)
  {
    this.a = paramb0;
    this.b = parama;
    this.c = paramh;
    this.d = (f.a(paramg.i().g(), "GET") ^ true);
  }
  
  private final d0 e(h0 paramh0)
  {
    d0 locald0 = new d0.a().p(paramh0.a().l()).g("CONNECT", null).e("Host", m9.o.s(paramh0.a().l(), true)).e("Proxy-Connection", "Keep-Alive").e("User-Agent", "okhttp/5.0.0-alpha.6").b();
    f0 localf0 = new f0.a().q(locald0).o(c0.d).e(407).l("Preemptive Authenticate").b(m9.o.c).r(-1L).p(-1L).i("Proxy-Authenticate", "OkHttp-Preemptive").c();
    paramh0 = paramh0.a().h().a(paramh0, localf0);
    if (paramh0 == null) {
      return locald0;
    }
    return paramh0;
  }
  
  private final b f()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      this.g = null;
      return h(this, (h0)localObject, null, 2, null);
    }
    localObject = this.e;
    if ((localObject != null) && (((o.b)localObject).b())) {
      return h(this, ((o.b)localObject).c(), null, 2, null);
    }
    o localo = this.f;
    localObject = localo;
    if (localo == null)
    {
      localObject = new o(c(), this.c.m().u(), this.c, this.a.r(), this.c.o());
      this.f = ((o)localObject);
    }
    if (((o)localObject).a())
    {
      localObject = ((o)localObject).c();
      this.e = ((o.b)localObject);
      if (!this.c.i()) {
        return g(((o.b)localObject).c(), ((o.b)localObject).a());
      }
      throw new IOException("Canceled");
    }
    throw new IOException("exhausted all routes");
  }
  
  private final l j()
  {
    i locali = this.c.n();
    if (locali == null) {
      return null;
    }
    boolean bool = locali.p(this.d);
    int i = 1;
    if (!bool) {}
    for (;;)
    {
      try
      {
        locali.w(true);
        Object localObject1 = this.c;
        localObject1 = ((h)localObject1).y();
        continue;
        if (!locali.k()) {
          if (d(locali.t().a().l())) {
            break label176;
          }
        }
        localObject1 = this.c;
        continue;
        if (this.c.n() != null)
        {
          if (localObject1 != null) {
            i = 0;
          }
          if (i != 0) {
            return new l(locali);
          }
          throw new IllegalStateException("Check failed.".toString());
        }
        if (localObject1 != null) {
          m9.o.g((Socket)localObject1);
        }
        this.c.o().k(this.c, locali);
        return null;
      }
      finally {}
      label176:
      Object localObject3 = null;
    }
  }
  
  private final h0 m(i parami)
  {
    try
    {
      int i = parami.l();
      if (i != 0) {
        return null;
      }
      boolean bool = parami.k();
      if (!bool) {
        return null;
      }
      bool = m9.o.e(parami.t().a().l(), c().l());
      if (!bool) {
        return null;
      }
      h0 localh0 = parami.t();
      return localh0;
    }
    finally {}
  }
  
  public boolean a(i parami)
  {
    if (this.g != null) {
      return true;
    }
    if (parami != null)
    {
      parami = m(parami);
      if (parami != null)
      {
        this.g = parami;
        return true;
      }
    }
    parami = this.e;
    int i = 0;
    if ((parami != null) && (parami.b() == true)) {
      i = 1;
    }
    if (i != 0) {
      return true;
    }
    parami = this.f;
    if (parami == null) {
      return true;
    }
    return parami.a();
  }
  
  public n.c b()
  {
    Object localObject = j();
    if (localObject != null) {
      return localObject;
    }
    localObject = l(this, null, null, 3, null);
    if (localObject != null) {
      return localObject;
    }
    localObject = f();
    l locall = k((b)localObject, ((b)localObject).p());
    if (locall != null) {
      return locall;
    }
    return localObject;
  }
  
  public a c()
  {
    return this.b;
  }
  
  public boolean d(x paramx)
  {
    f.f(paramx, "url");
    x localx = c().l();
    return (paramx.n() == localx.n()) && (f.a(paramx.i(), localx.i()));
  }
  
  public final b g(h0 paramh0, List<h0> paramList)
  {
    f.f(paramh0, "route");
    Object localObject;
    if (paramh0.a().k() == null)
    {
      if (paramh0.a().b().contains(l9.l.k))
      {
        localObject = paramh0.a().l().i();
        if (!u9.h.a.g().i((String)localObject))
        {
          paramh0 = new StringBuilder();
          paramh0.append("CLEARTEXT communication to ");
          paramh0.append((String)localObject);
          paramh0.append(" not permitted by network security policy");
          throw new UnknownServiceException(paramh0.toString());
        }
      }
      else
      {
        throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
      }
    }
    else {
      if (paramh0.a().f().contains(c0.g)) {
        break label174;
      }
    }
    if (paramh0.c()) {
      localObject = e(paramh0);
    } else {
      localObject = null;
    }
    return new b(this.a, this.c, this, paramh0, paramList, 0, (d0)localObject, -1, false);
    label174:
    throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
  }
  
  public boolean i()
  {
    return this.c.i();
  }
  
  public final l k(b paramb, List<h0> paramList)
  {
    j localj = this.a.l().a();
    boolean bool2 = this.d;
    a locala = c();
    h localh = this.c;
    boolean bool1;
    if ((paramb != null) && (paramb.d())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramList = localj.a(bool2, locala, localh, paramList, bool1);
    if (paramList == null) {
      return null;
    }
    if (paramb != null)
    {
      this.g = paramb.e();
      paramb.i();
    }
    this.c.o().j(this.c, paramList);
    return new l(paramList);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.k
 * JD-Core Version:    0.7.0.1
 */