package n9;

import a9.f;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import l9.b;
import l9.d0;
import l9.d0.a;
import l9.f0;
import l9.h;
import l9.h0;
import l9.q;
import l9.s;
import l9.x;

public final class a
  implements b
{
  private final s d;
  
  public a(s params)
  {
    this.d = params;
  }
  
  private final InetAddress b(Proxy paramProxy, x paramx, s params)
  {
    Proxy.Type localType = paramProxy.type();
    int i;
    if (localType == null) {
      i = -1;
    } else {
      i = a.a[localType.ordinal()];
    }
    if (i == 1) {
      return (InetAddress)p8.l.x(params.a(paramx.i()));
    }
    paramProxy = paramProxy.address();
    Objects.requireNonNull(paramProxy, "null cannot be cast to non-null type java.net.InetSocketAddress");
    paramProxy = ((InetSocketAddress)paramProxy).getAddress();
    f.e(paramProxy, "address() as InetSocketAddress).address");
    return paramProxy;
  }
  
  public d0 a(h0 paramh0, f0 paramf0)
  {
    f.f(paramf0, "response");
    Object localObject2 = paramf0.i();
    d0 locald0 = paramf0.q0();
    x localx = locald0.j();
    int i;
    if (paramf0.B() == 407) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramh0 == null) {
      paramf0 = null;
    } else {
      paramf0 = paramh0.b();
    }
    Object localObject1 = paramf0;
    if (paramf0 == null) {
      localObject1 = Proxy.NO_PROXY;
    }
    Iterator localIterator = ((List)localObject2).iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (f9.l.l("Basic", localh.d(), true))
      {
        if (paramh0 == null) {}
        do
        {
          paramf0 = null;
          break;
          paramf0 = paramh0.a();
        } while (paramf0 == null);
        paramf0 = paramf0.c();
        localObject2 = paramf0;
        if (paramf0 == null) {
          localObject2 = this.d;
        }
        if (i != 0)
        {
          paramf0 = ((Proxy)localObject1).address();
          Objects.requireNonNull(paramf0, "null cannot be cast to non-null type java.net.InetSocketAddress");
          paramf0 = (InetSocketAddress)paramf0;
          String str = paramf0.getHostName();
          f.e(localObject1, "proxy");
          paramf0 = Authenticator.requestPasswordAuthentication(str, b((Proxy)localObject1, localx, (s)localObject2), paramf0.getPort(), localx.r(), localh.c(), localh.d(), localx.t(), Authenticator.RequestorType.PROXY);
        }
        else
        {
          paramf0 = localx.i();
          f.e(localObject1, "proxy");
          paramf0 = Authenticator.requestPasswordAuthentication(paramf0, b((Proxy)localObject1, localx, (s)localObject2), localx.n(), localx.r(), localh.c(), localh.d(), localx.t(), Authenticator.RequestorType.SERVER);
        }
        if (paramf0 != null)
        {
          if (i != 0) {
            paramh0 = "Proxy-Authorization";
          } else {
            paramh0 = "Authorization";
          }
          localObject1 = paramf0.getUserName();
          f.e(localObject1, "auth.userName");
          paramf0 = paramf0.getPassword();
          f.e(paramf0, "auth.password");
          paramf0 = q.a((String)localObject1, new String(paramf0), localh.b());
          return locald0.h().e(paramh0, paramf0).b();
        }
      }
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n9.a
 * JD-Core Version:    0.7.0.1
 */