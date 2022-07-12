package l9;

import a9.f;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import m9.o;

public final class a
{
  private final s a;
  private final SocketFactory b;
  private final SSLSocketFactory c;
  private final HostnameVerifier d;
  private final g e;
  private final b f;
  private final Proxy g;
  private final ProxySelector h;
  private final x i;
  private final List<c0> j;
  private final List<l> k;
  
  public a(String paramString, int paramInt, s params, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, g paramg, b paramb, Proxy paramProxy, List<? extends c0> paramList, List<l> paramList1, ProxySelector paramProxySelector)
  {
    this.a = params;
    this.b = paramSocketFactory;
    this.c = paramSSLSocketFactory;
    this.d = paramHostnameVerifier;
    this.e = paramg;
    this.f = paramb;
    this.g = paramProxy;
    this.h = paramProxySelector;
    paramSocketFactory = new x.a();
    if (paramSSLSocketFactory != null) {
      params = "https";
    } else {
      params = "http";
    }
    this.i = paramSocketFactory.x(params).n(paramString).t(paramInt).c();
    this.j = o.u(paramList);
    this.k = o.u(paramList1);
  }
  
  public final g a()
  {
    return this.e;
  }
  
  public final List<l> b()
  {
    return this.k;
  }
  
  public final s c()
  {
    return this.a;
  }
  
  public final boolean d(a parama)
  {
    f.f(parama, "that");
    return (f.a(this.a, parama.a)) && (f.a(this.f, parama.f)) && (f.a(this.j, parama.j)) && (f.a(this.k, parama.k)) && (f.a(this.h, parama.h)) && (f.a(this.g, parama.g)) && (f.a(this.c, parama.c)) && (f.a(this.d, parama.d)) && (f.a(this.e, parama.e)) && (this.i.n() == parama.i.n());
  }
  
  public final HostnameVerifier e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof a))
    {
      x localx = this.i;
      paramObject = (a)paramObject;
      if ((f.a(localx, paramObject.i)) && (d(paramObject))) {
        return true;
      }
    }
    return false;
  }
  
  public final List<c0> f()
  {
    return this.j;
  }
  
  public final Proxy g()
  {
    return this.g;
  }
  
  public final b h()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    return (((((((((527 + this.i.hashCode()) * 31 + this.a.hashCode()) * 31 + this.f.hashCode()) * 31 + this.j.hashCode()) * 31 + this.k.hashCode()) * 31 + this.h.hashCode()) * 31 + Objects.hashCode(this.g)) * 31 + Objects.hashCode(this.c)) * 31 + Objects.hashCode(this.d)) * 31 + Objects.hashCode(this.e);
  }
  
  public final ProxySelector i()
  {
    return this.h;
  }
  
  public final SocketFactory j()
  {
    return this.b;
  }
  
  public final SSLSocketFactory k()
  {
    return this.c;
  }
  
  public final x l()
  {
    return this.i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Address{");
    localStringBuilder.append(this.i.i());
    localStringBuilder.append(':');
    localStringBuilder.append(this.i.n());
    localStringBuilder.append(", ");
    Object localObject = this.g;
    String str;
    if (localObject != null)
    {
      str = "proxy=";
    }
    else
    {
      localObject = this.h;
      str = "proxySelector=";
    }
    localStringBuilder.append(f.m(str, localObject));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.a
 * JD-Core Version:    0.7.0.1
 */