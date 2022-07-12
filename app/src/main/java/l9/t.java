package l9;

import a9.f;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

public abstract class t
{
  public static final b a = new b(null);
  public static final t b = new a();
  
  public void A(e parame, v paramv)
  {
    f.f(parame, "call");
  }
  
  public void B(e parame)
  {
    f.f(parame, "call");
  }
  
  public void a(e parame, f0 paramf0)
  {
    f.f(parame, "call");
    f.f(paramf0, "cachedResponse");
  }
  
  public void b(e parame, f0 paramf0)
  {
    f.f(parame, "call");
    f.f(paramf0, "response");
  }
  
  public void c(e parame)
  {
    f.f(parame, "call");
  }
  
  public void d(e parame, IOException paramIOException)
  {
    f.f(parame, "call");
    f.f(paramIOException, "ioe");
  }
  
  public void e(e parame)
  {
    f.f(parame, "call");
  }
  
  public void f(e parame)
  {
    f.f(parame, "call");
  }
  
  public void g(e parame, InetSocketAddress paramInetSocketAddress, Proxy paramProxy, c0 paramc0)
  {
    f.f(parame, "call");
    f.f(paramInetSocketAddress, "inetSocketAddress");
    f.f(paramProxy, "proxy");
  }
  
  public void h(e parame, InetSocketAddress paramInetSocketAddress, Proxy paramProxy, c0 paramc0, IOException paramIOException)
  {
    f.f(parame, "call");
    f.f(paramInetSocketAddress, "inetSocketAddress");
    f.f(paramProxy, "proxy");
    f.f(paramIOException, "ioe");
  }
  
  public void i(e parame, InetSocketAddress paramInetSocketAddress, Proxy paramProxy)
  {
    f.f(parame, "call");
    f.f(paramInetSocketAddress, "inetSocketAddress");
    f.f(paramProxy, "proxy");
  }
  
  public void j(e parame, j paramj)
  {
    f.f(parame, "call");
    f.f(paramj, "connection");
  }
  
  public void k(e parame, j paramj)
  {
    f.f(parame, "call");
    f.f(paramj, "connection");
  }
  
  public void l(e parame, String paramString, List<InetAddress> paramList)
  {
    f.f(parame, "call");
    f.f(paramString, "domainName");
    f.f(paramList, "inetAddressList");
  }
  
  public void m(e parame, String paramString)
  {
    f.f(parame, "call");
    f.f(paramString, "domainName");
  }
  
  public void n(e parame, x paramx, List<Proxy> paramList)
  {
    f.f(parame, "call");
    f.f(paramx, "url");
    f.f(paramList, "proxies");
  }
  
  public void o(e parame, x paramx)
  {
    f.f(parame, "call");
    f.f(paramx, "url");
  }
  
  public void p(e parame, long paramLong)
  {
    f.f(parame, "call");
  }
  
  public void q(e parame)
  {
    f.f(parame, "call");
  }
  
  public void r(e parame, IOException paramIOException)
  {
    f.f(parame, "call");
    f.f(paramIOException, "ioe");
  }
  
  public void s(e parame, d0 paramd0)
  {
    f.f(parame, "call");
    f.f(paramd0, "request");
  }
  
  public void t(e parame)
  {
    f.f(parame, "call");
  }
  
  public void u(e parame, long paramLong)
  {
    f.f(parame, "call");
  }
  
  public void v(e parame)
  {
    f.f(parame, "call");
  }
  
  public void w(e parame, IOException paramIOException)
  {
    f.f(parame, "call");
    f.f(paramIOException, "ioe");
  }
  
  public void x(e parame, f0 paramf0)
  {
    f.f(parame, "call");
    f.f(paramf0, "response");
  }
  
  public void y(e parame)
  {
    f.f(parame, "call");
  }
  
  public void z(e parame, f0 paramf0)
  {
    f.f(parame, "call");
    f.f(paramf0, "response");
  }
  
  public static final class a
    extends t
  {}
  
  public static final class b {}
  
  public static abstract interface c
  {
    public abstract t a(e parame);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.t
 * JD-Core Version:    0.7.0.1
 */