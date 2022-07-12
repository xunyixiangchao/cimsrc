package r9;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import l9.b;
import l9.b0;
import l9.d0;
import l9.d0.a;
import l9.e0;
import l9.f0;
import l9.f0.a;
import l9.h0;
import l9.x;
import l9.y;
import l9.y.a;
import m9.o;
import q9.c;
import q9.h;
import q9.i;
import t9.a;

public final class j
  implements y
{
  public static final a b = new a(null);
  private final b0 a;
  
  public j(b0 paramb0)
  {
    this.a = paramb0;
  }
  
  private final d0 b(f0 paramf0, String paramString)
  {
    boolean bool = this.a.s();
    e0 locale0 = null;
    if (!bool) {
      return null;
    }
    Object localObject = f0.h0(paramf0, "Location", null, 2, null);
    if (localObject == null) {
      return null;
    }
    x localx = paramf0.q0().j().q((String)localObject);
    if (localx == null) {
      return null;
    }
    if ((!a9.f.a(localx.r(), paramf0.q0().j().r())) && (!this.a.t())) {
      return null;
    }
    d0.a locala = paramf0.q0().h();
    if (f.a(paramString))
    {
      int j = paramf0.B();
      localObject = f.a;
      int i;
      if ((!((f)localObject).c(paramString)) && (j != 308) && (j != 307)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((((f)localObject).b(paramString)) && (j != 308) && (j != 307))
      {
        localObject = "GET";
      }
      else
      {
        localObject = paramString;
        if (i != 0)
        {
          locale0 = paramf0.q0().a();
          localObject = paramString;
        }
      }
      locala.g((String)localObject, locale0);
      if (i == 0)
      {
        locala.h("Transfer-Encoding");
        locala.h("Content-Length");
        locala.h("Content-Type");
      }
    }
    if (!o.e(paramf0.q0().j(), localx)) {
      locala.h("Authorization");
    }
    return locala.p(localx).b();
  }
  
  private final d0 c(f0 paramf0, c paramc)
  {
    if (paramc == null) {}
    do
    {
      localObject = null;
      break;
      localObject = paramc.h();
    } while (localObject == null);
    Object localObject = ((i)localObject).t();
    int i = paramf0.B();
    String str = paramf0.q0().g();
    if ((i != 307) && (i != 308))
    {
      if (i != 401) {
        if (i != 421) {
          if (i != 503) {
            if (i != 407) {
              if (i == 408) {}
            }
          }
        }
      }
      switch (i)
      {
      default: 
        return null;
        if (!this.a.G()) {
          return null;
        }
        paramc = paramf0.q0().a();
        if ((paramc != null) && (paramc.f())) {
          return null;
        }
        paramc = paramf0.n0();
        if ((paramc != null) && (paramc.B() == 408)) {
          return null;
        }
        if (g(paramf0, 0) > 0) {
          return null;
        }
        return paramf0.q0();
        a9.f.c(localObject);
        if (((h0)localObject).b().type() == Proxy.Type.HTTP) {
          return this.a.D().a((h0)localObject, paramf0);
        }
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
        paramc = paramf0.n0();
        if ((paramc != null) && (paramc.B() == 503)) {
          return null;
        }
        if (g(paramf0, 2147483647) == 0) {
          return paramf0.q0();
        }
        return null;
        localObject = paramf0.q0().a();
        if ((localObject != null) && (((e0)localObject).f())) {
          return null;
        }
        if (paramc != null)
        {
          if (!paramc.l()) {
            return null;
          }
          paramc.h().s();
          return paramf0.q0();
        }
        return null;
        return this.a.d().a((h0)localObject, paramf0);
      }
    }
    return b(paramf0, str);
  }
  
  private final boolean d(IOException paramIOException, boolean paramBoolean)
  {
    boolean bool1 = paramIOException instanceof ProtocolException;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if ((paramIOException instanceof InterruptedIOException))
    {
      bool1 = bool2;
      if ((paramIOException instanceof SocketTimeoutException))
      {
        bool1 = bool2;
        if (!paramBoolean) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) {
      return false;
    }
    return !(paramIOException instanceof SSLPeerUnverifiedException);
  }
  
  private final boolean e(IOException paramIOException, h paramh, d0 paramd0, boolean paramBoolean)
  {
    if (!this.a.G()) {
      return false;
    }
    if ((paramBoolean) && (f(paramIOException, paramd0))) {
      return false;
    }
    if (!d(paramIOException, paramBoolean)) {
      return false;
    }
    return paramh.z();
  }
  
  private final boolean f(IOException paramIOException, d0 paramd0)
  {
    paramd0 = paramd0.a();
    return ((paramd0 != null) && (paramd0.f())) || ((paramIOException instanceof FileNotFoundException));
  }
  
  private final int g(f0 paramf0, int paramInt)
  {
    paramf0 = f0.h0(paramf0, "Retry-After", null, 2, null);
    if (paramf0 == null) {
      return paramInt;
    }
    if (new f9.j("\\d+").b(paramf0))
    {
      paramf0 = Integer.valueOf(paramf0);
      a9.f.e(paramf0, "valueOf(header)");
      return paramf0.intValue();
    }
    return 2147483647;
  }
  
  public f0 a(y.a parama)
  {
    a9.f.f(parama, "chain");
    g localg = (g)parama;
    Object localObject1 = localg.i();
    h localh = localg.e();
    parama = p8.l.h();
    f0 localf0 = null;
    boolean bool = true;
    int i = 0;
    localh.k((d0)localObject1, bool, localg);
    for (;;)
    {
      try
      {
        for (;;)
        {
          bool = localh.i();
          if (bool) {
            break label302;
          }
          try
          {
            Object localObject2 = localg.a((d0)localObject1);
            localObject1 = ((f0)localObject2).m0().q((d0)localObject1);
            if (localf0 != null) {
              ((f0.a)localObject1).n(localf0.m0().b(null).c());
            }
            localf0 = ((f0.a)localObject1).c();
            localObject2 = localh.q();
            localObject1 = c(localf0, (c)localObject2);
            if (localObject1 == null)
            {
              if ((localObject2 != null) && (((c)localObject2).m())) {
                localh.A();
              }
              localh.l(false);
              return localf0;
            }
            localObject2 = ((d0)localObject1).a();
            if (localObject2 != null)
            {
              bool = ((e0)localObject2).f();
              if (bool)
              {
                localh.l(false);
                return localf0;
              }
            }
            localObject2 = localf0.a();
            if (localObject2 != null) {
              m9.l.f((Closeable)localObject2);
            }
            i += 1;
            if (i <= 20)
            {
              localh.l(true);
              bool = true;
              break;
            }
            throw new ProtocolException(a9.f.m("Too many follow-up requests: ", Integer.valueOf(i)));
          }
          catch (IOException localIOException)
          {
            if ((localIOException instanceof a)) {
              break label322;
            }
          }
        }
        bool = true;
        if (e(localIOException, localh, (d0)localObject1, bool))
        {
          parama = p8.l.E(parama, localIOException);
          localh.l(true);
          bool = false;
          break;
        }
        throw m9.l.G(localIOException, parama);
        label302:
        throw new IOException("Canceled");
      }
      finally
      {
        localh.l(true);
      }
      label322:
      bool = false;
    }
  }
  
  public static final class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r9.j
 * JD-Core Version:    0.7.0.1
 */