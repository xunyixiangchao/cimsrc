package q9;

import a9.f;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import l9.a;
import l9.h0;
import l9.s;
import l9.t;
import l9.x;
import p8.l;

public final class o
{
  public static final a j = new a(null);
  private final a a;
  private final m b;
  private final l9.e c;
  private final boolean d;
  private final t e;
  private List<? extends Proxy> f;
  private int g;
  private List<? extends InetSocketAddress> h;
  private final List<h0> i;
  
  public o(a parama, m paramm, l9.e parame, boolean paramBoolean, t paramt)
  {
    this.a = parama;
    this.b = paramm;
    this.c = parame;
    this.d = paramBoolean;
    this.e = paramt;
    this.f = l.h();
    this.h = l.h();
    this.i = new ArrayList();
    f(parama.l(), parama.g());
  }
  
  private final boolean b()
  {
    return this.g < this.f.size();
  }
  
  private final Proxy d()
  {
    if (b())
    {
      localObject = this.f;
      int k = this.g;
      this.g = (k + 1);
      localObject = (Proxy)((List)localObject).get(k);
      e((Proxy)localObject);
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No route to ");
    ((StringBuilder)localObject).append(this.a.l().i());
    ((StringBuilder)localObject).append("; exhausted proxy configurations: ");
    ((StringBuilder)localObject).append(this.f);
    throw new SocketException(((StringBuilder)localObject).toString());
  }
  
  private final void e(Proxy paramProxy)
  {
    ArrayList localArrayList = new ArrayList();
    this.h = localArrayList;
    Object localObject1;
    int k;
    if ((paramProxy.type() != Proxy.Type.DIRECT) && (paramProxy.type() != Proxy.Type.SOCKS))
    {
      Object localObject2 = paramProxy.address();
      if ((localObject2 instanceof InetSocketAddress))
      {
        localObject1 = j;
        f.e(localObject2, "proxyAddress");
        localObject2 = (InetSocketAddress)localObject2;
        localObject1 = ((a)localObject1).a((InetSocketAddress)localObject2);
        k = ((InetSocketAddress)localObject2).getPort();
      }
      else
      {
        throw new IllegalArgumentException(f.m("Proxy.address() is not an InetSocketAddress: ", localObject2.getClass()).toString());
      }
    }
    else
    {
      localObject1 = this.a.l().i();
      k = this.a.l().n();
    }
    int n = 0;
    int m = n;
    if (1 <= k)
    {
      m = n;
      if (k < 65536) {
        m = 1;
      }
    }
    if (m != 0)
    {
      if (paramProxy.type() == Proxy.Type.SOCKS)
      {
        localArrayList.add(InetSocketAddress.createUnresolved((String)localObject1, k));
        return;
      }
      if (m9.e.a((String)localObject1))
      {
        paramProxy = l.d(InetAddress.getByName((String)localObject1));
      }
      else
      {
        this.e.m(this.c, (String)localObject1);
        paramProxy = this.a.c().a((String)localObject1);
        if (paramProxy.isEmpty()) {
          break label317;
        }
        this.e.l(this.c, (String)localObject1, paramProxy);
      }
      localObject1 = paramProxy;
      if (this.d) {
        localObject1 = g.a(paramProxy);
      }
      paramProxy = ((List)localObject1).iterator();
      while (paramProxy.hasNext()) {
        localArrayList.add(new InetSocketAddress((InetAddress)paramProxy.next(), k));
      }
      return;
      label317:
      paramProxy = new StringBuilder();
      paramProxy.append(this.a.c());
      paramProxy.append(" returned no addresses for ");
      paramProxy.append((String)localObject1);
      throw new UnknownHostException(paramProxy.toString());
    }
    paramProxy = new StringBuilder();
    paramProxy.append("No route to ");
    paramProxy.append((String)localObject1);
    paramProxy.append(':');
    paramProxy.append(k);
    paramProxy.append("; port is out of range");
    throw new SocketException(paramProxy.toString());
  }
  
  private final void f(x paramx, Proxy paramProxy)
  {
    this.e.o(this.c, paramx);
    paramProxy = g(paramProxy, paramx, this);
    this.f = paramProxy;
    this.g = 0;
    this.e.n(this.c, paramx, paramProxy);
  }
  
  private static final List<Proxy> g(Proxy paramProxy, x paramx, o paramo)
  {
    if (paramProxy != null) {
      return l.d(paramProxy);
    }
    paramProxy = paramx.s();
    if (paramProxy.getHost() == null) {
      return m9.o.k(new Proxy[] { Proxy.NO_PROXY });
    }
    paramProxy = paramo.a.i().select(paramProxy);
    int k;
    if ((paramProxy != null) && (!paramProxy.isEmpty())) {
      k = 0;
    } else {
      k = 1;
    }
    if (k != 0) {
      return m9.o.k(new Proxy[] { Proxy.NO_PROXY });
    }
    f.e(paramProxy, "proxiesOrNull");
    return m9.o.u(paramProxy);
  }
  
  public final boolean a()
  {
    boolean bool2 = b();
    boolean bool1 = true;
    if (!bool2)
    {
      if ((this.i.isEmpty() ^ true)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public final b c()
  {
    if (a())
    {
      ArrayList localArrayList = new ArrayList();
      do
      {
        if (!b()) {
          break;
        }
        Proxy localProxy = d();
        Iterator localIterator = this.h.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (InetSocketAddress)localIterator.next();
          localObject = new h0(this.a, localProxy, (InetSocketAddress)localObject);
          if (this.b.c((h0)localObject)) {
            this.i.add(localObject);
          } else {
            localArrayList.add(localObject);
          }
        }
      } while (!(localArrayList.isEmpty() ^ true));
      if (localArrayList.isEmpty())
      {
        l.s(localArrayList, this.i);
        this.i.clear();
      }
      return new b(localArrayList);
    }
    throw new NoSuchElementException();
  }
  
  public static final class a
  {
    public final String a(InetSocketAddress paramInetSocketAddress)
    {
      f.f(paramInetSocketAddress, "<this>");
      Object localObject = paramInetSocketAddress.getAddress();
      if (localObject == null) {
        localObject = paramInetSocketAddress.getHostName();
      }
      for (paramInetSocketAddress = "hostName";; paramInetSocketAddress = "address.hostAddress")
      {
        f.e(localObject, paramInetSocketAddress);
        return localObject;
        localObject = ((InetAddress)localObject).getHostAddress();
      }
    }
  }
  
  public static final class b
  {
    private final List<h0> a;
    private int b;
    
    public b(List<h0> paramList)
    {
      this.a = paramList;
    }
    
    public final List<h0> a()
    {
      return this.a;
    }
    
    public final boolean b()
    {
      return this.b < this.a.size();
    }
    
    public final h0 c()
    {
      if (b())
      {
        List localList = this.a;
        int i = this.b;
        this.b = (i + 1);
        return (h0)localList.get(i);
      }
      throw new NoSuchElementException();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.o
 * JD-Core Version:    0.7.0.1
 */