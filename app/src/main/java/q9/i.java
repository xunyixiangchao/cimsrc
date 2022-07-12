package q9;

import aa.c;
import aa.y;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import l9.b0;
import l9.c0;
import l9.h0;
import m9.o;
import r9.d.a;
import t9.f.b;
import t9.f.c;
import t9.f.d;
import t9.n;

public final class i
  extends f.d
  implements l9.j, d.a
{
  public static final a v = new a(null);
  private final p9.d c;
  private final j d;
  private final h0 e;
  private Socket f;
  private Socket g;
  private l9.v h;
  private c0 i;
  private aa.d j;
  private c k;
  private final int l;
  private t9.f m;
  private boolean n;
  private boolean o;
  private int p;
  private int q;
  private int r;
  private int s;
  private final List<Reference<h>> t;
  private long u;
  
  public i(p9.d paramd, j paramj, h0 paramh0, Socket paramSocket1, Socket paramSocket2, l9.v paramv, c0 paramc0, aa.d paramd1, c paramc, int paramInt)
  {
    this.c = paramd;
    this.d = paramj;
    this.e = paramh0;
    this.f = paramSocket1;
    this.g = paramSocket2;
    this.h = paramv;
    this.i = paramc0;
    this.j = paramd1;
    this.k = paramc;
    this.l = paramInt;
    this.s = 1;
    this.t = new ArrayList();
    this.u = 9223372036854775807L;
  }
  
  private final boolean A(l9.x paramx)
  {
    if ((o.e) && (!Thread.holdsLock(this)))
    {
      paramx = new StringBuilder();
      paramx.append("Thread ");
      paramx.append(Thread.currentThread().getName());
      paramx.append(" MUST hold lock on ");
      paramx.append(this);
      throw new AssertionError(paramx.toString());
    }
    Object localObject = e().a().l();
    int i1 = paramx.n();
    int i2 = ((l9.x)localObject).n();
    boolean bool2 = false;
    if (i1 != i2) {
      return false;
    }
    if (a9.f.a(paramx.i(), ((l9.x)localObject).i())) {
      return true;
    }
    boolean bool1 = bool2;
    if (!this.o)
    {
      localObject = this.h;
      bool1 = bool2;
      if (localObject != null)
      {
        a9.f.c(localObject);
        bool1 = bool2;
        if (d(paramx, (l9.v)localObject)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private final boolean d(l9.x paramx, l9.v paramv)
  {
    paramv = paramv.d();
    return ((paramv.isEmpty() ^ true)) && (x9.d.a.e(paramx.i(), (X509Certificate)paramv.get(0)));
  }
  
  private final boolean u(List<h0> paramList)
  {
    if (((paramList instanceof Collection)) && (paramList.isEmpty())) {}
    int i1;
    do
    {
      while (!paramList.hasNext())
      {
        return false;
        paramList = paramList.iterator();
      }
      h0 localh0 = (h0)paramList.next();
      if ((localh0.b().type() == Proxy.Type.DIRECT) && (e().b().type() == Proxy.Type.DIRECT) && (a9.f.a(e().d(), localh0.d()))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    } while (i1 == 0);
    return true;
  }
  
  private final void z()
  {
    Object localObject = this.g;
    a9.f.c(localObject);
    aa.d locald = this.j;
    a9.f.c(locald);
    c localc = this.k;
    a9.f.c(localc);
    ((Socket)localObject).setSoTimeout(0);
    localObject = new f.b(true, this.c).s((Socket)localObject, e().a().l().i(), locald, localc).k(this).l(this.l).a();
    this.m = ((t9.f)localObject);
    this.s = t9.f.C.a().d();
    t9.f.U0((t9.f)localObject, false, 1, null);
  }
  
  public c0 a()
  {
    c0 localc0 = this.i;
    a9.f.c(localc0);
    return localc0;
  }
  
  public void b(t9.f paramf, t9.m paramm)
  {
    try
    {
      a9.f.f(paramf, "connection");
      a9.f.f(paramm, "settings");
      this.s = paramm.d();
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  public void c(t9.i parami)
  {
    a9.f.f(parami, "stream");
    parami.d(t9.b.j, null);
  }
  
  public void cancel()
  {
    Socket localSocket = this.f;
    if (localSocket == null) {
      return;
    }
    o.g(localSocket);
  }
  
  public h0 e()
  {
    return this.e;
  }
  
  public final void f(b0 paramb0, h0 paramh0, IOException paramIOException)
  {
    a9.f.f(paramb0, "client");
    a9.f.f(paramh0, "failedRoute");
    a9.f.f(paramIOException, "failure");
    if (paramh0.b().type() != Proxy.Type.DIRECT)
    {
      l9.a locala = paramh0.a();
      locala.i().connectFailed(locala.l().s(), paramh0.b().address(), paramIOException);
    }
    paramb0.u().b(paramh0);
  }
  
  public void g(h paramh, IOException paramIOException)
  {
    try
    {
      a9.f.f(paramh, "call");
      int i1;
      if ((paramIOException instanceof n)) {
        if (((n)paramIOException).a == t9.b.j)
        {
          i1 = this.r + 1;
          this.r = i1;
          if (i1 <= 1) {
            break label153;
          }
          this.n = true;
          i1 = this.p;
        }
      }
      for (;;)
      {
        this.p = (i1 + 1);
        break;
        if ((((n)paramIOException).a == t9.b.k) && (paramh.i())) {
          break;
        }
        this.n = true;
        i1 = this.p;
        continue;
        if ((q()) && (!(paramIOException instanceof t9.a))) {
          break;
        }
        this.n = true;
        if (this.q != 0) {
          break;
        }
        if (paramIOException != null) {
          f(paramh.m(), e(), paramIOException);
        }
        i1 = this.p;
      }
      label153:
      return;
    }
    finally {}
  }
  
  public void h()
  {
    try
    {
      this.n = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final List<Reference<h>> i()
  {
    return this.t;
  }
  
  public final long j()
  {
    return this.u;
  }
  
  public final boolean k()
  {
    return this.n;
  }
  
  public final int l()
  {
    return this.p;
  }
  
  public l9.v m()
  {
    return this.h;
  }
  
  public final void n()
  {
    try
    {
      this.q += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean o(l9.a parama, List<h0> paramList)
  {
    a9.f.f(parama, "address");
    if ((o.e) && (!Thread.holdsLock(this)))
    {
      parama = new StringBuilder();
      parama.append("Thread ");
      parama.append(Thread.currentThread().getName());
      parama.append(" MUST hold lock on ");
      parama.append(this);
      throw new AssertionError(parama.toString());
    }
    if (this.t.size() < this.s)
    {
      if (this.n) {
        return false;
      }
      if (!e().a().d(parama)) {
        return false;
      }
      if (a9.f.a(parama.l().i(), t().a().l().i())) {
        return true;
      }
      if (this.m == null) {
        return false;
      }
      if (paramList != null)
      {
        if (!u(paramList)) {
          return false;
        }
        if (parama.e() != x9.d.a) {
          return false;
        }
        if (!A(parama.l())) {
          return false;
        }
      }
    }
    try
    {
      paramList = parama.a();
      a9.f.c(paramList);
      parama = parama.l().i();
      l9.v localv = m();
      a9.f.c(localv);
      paramList.a(parama, localv.d());
      return true;
    }
    catch (SSLPeerUnverifiedException parama) {}
    return false;
    return false;
  }
  
  public final boolean p(boolean paramBoolean)
  {
    if ((o.e) && (Thread.holdsLock(this)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Thread ");
      ((StringBuilder)localObject1).append(Thread.currentThread().getName());
      ((StringBuilder)localObject1).append(" MUST NOT hold lock on ");
      ((StringBuilder)localObject1).append(this);
      throw new AssertionError(((StringBuilder)localObject1).toString());
    }
    long l1 = System.nanoTime();
    Object localObject3 = this.f;
    a9.f.c(localObject3);
    Object localObject1 = this.g;
    a9.f.c(localObject1);
    aa.d locald = this.j;
    a9.f.c(locald);
    if ((!((Socket)localObject3).isClosed()) && (!((Socket)localObject1).isClosed()) && (!((Socket)localObject1).isInputShutdown()) && (!((Socket)localObject1).isOutputShutdown()))
    {
      localObject3 = this.m;
      if (localObject3 != null) {
        return ((t9.f)localObject3).F0(l1);
      }
      try
      {
        long l2 = j();
        if ((l1 - l2 >= 10000000000L) && (paramBoolean)) {
          return o.l((Socket)localObject1, locald);
        }
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final boolean q()
  {
    return this.m != null;
  }
  
  public final r9.d r(b0 paramb0, r9.g paramg)
  {
    a9.f.f(paramb0, "client");
    a9.f.f(paramg, "chain");
    Object localObject1 = this.g;
    a9.f.c(localObject1);
    aa.d locald = this.j;
    a9.f.c(locald);
    c localc = this.k;
    a9.f.c(localc);
    Object localObject2 = this.m;
    if (localObject2 != null) {
      return new t9.g(paramb0, this, paramg, (t9.f)localObject2);
    }
    ((Socket)localObject1).setSoTimeout(paramg.k());
    localObject1 = locald.c();
    long l1 = paramg.g();
    localObject2 = TimeUnit.MILLISECONDS;
    ((y)localObject1).g(l1, (TimeUnit)localObject2);
    localc.c().g(paramg.j(), (TimeUnit)localObject2);
    return new s9.b(paramb0, this, locald, localc);
  }
  
  public final void s()
  {
    try
    {
      this.o = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public h0 t()
  {
    return e();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Connection{");
    localStringBuilder.append(e().a().l().i());
    localStringBuilder.append(':');
    localStringBuilder.append(e().a().l().n());
    localStringBuilder.append(", proxy=");
    localStringBuilder.append(e().b());
    localStringBuilder.append(" hostAddress=");
    localStringBuilder.append(e().d());
    localStringBuilder.append(" cipherSuite=");
    Object localObject2 = this.h;
    Object localObject1 = "none";
    if (localObject2 != null)
    {
      localObject2 = ((l9.v)localObject2).a();
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(" protocol=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final void v(long paramLong)
  {
    this.u = paramLong;
  }
  
  public final void w(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public Socket x()
  {
    Socket localSocket = this.g;
    a9.f.c(localSocket);
    return localSocket;
  }
  
  public final void y()
  {
    this.u = System.nanoTime();
    c0 localc0 = this.i;
    if ((localc0 == c0.f) || (localc0 == c0.g)) {
      z();
    }
  }
  
  public static final class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.i
 * JD-Core Version:    0.7.0.1
 */