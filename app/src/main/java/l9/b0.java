package l9;

import a9.f;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import m9.o;
import q9.m;
import u9.h.a;
import w9.a;
import x9.c.a;

public class b0
  implements Cloneable, e.a
{
  public static final b G = new b(null);
  private static final List<c0> H = o.k(new c0[] { c0.f, c0.d });
  private static final List<l> I = o.k(new l[] { l.i, l.k });
  private final int A;
  private final int B;
  private final long C;
  private final m E;
  private final p9.d F;
  private final r a;
  private final k b;
  private final List<y> c;
  private final List<y> d;
  private final t.c e;
  private final boolean f;
  private final boolean g;
  private final b h;
  private final boolean i;
  private final boolean j;
  private final p k;
  private final s l;
  private final Proxy m;
  private final ProxySelector n;
  private final b o;
  private final SocketFactory p;
  private final SSLSocketFactory q;
  private final X509TrustManager r;
  private final List<l> s;
  private final List<c0> t;
  private final HostnameVerifier u;
  private final g v;
  private final x9.c w;
  private final int x;
  private final int y;
  private final int z;
  
  public b0()
  {
    this(new a());
  }
  
  public b0(a parama)
  {
    this.a = parama.n();
    this.b = parama.k();
    this.c = o.u(parama.u());
    this.d = o.u(parama.w());
    this.e = parama.p();
    this.f = parama.D();
    this.g = parama.q();
    this.h = parama.e();
    this.i = parama.r();
    this.j = parama.s();
    this.k = parama.m();
    parama.f();
    this.l = parama.o();
    this.m = parama.z();
    if (parama.z() != null) {}
    do
    {
      localObject2 = a.a;
      break;
      localObject2 = parama.B();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ProxySelector.getDefault();
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    this.n = ((ProxySelector)localObject2);
    this.o = parama.A();
    this.p = parama.F();
    List localList = parama.l();
    this.s = localList;
    this.t = parama.y();
    this.u = parama.t();
    this.x = parama.g();
    this.y = parama.j();
    this.z = parama.C();
    this.A = parama.I();
    this.B = parama.x();
    this.C = parama.v();
    Object localObject2 = parama.E();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new m();
    }
    this.E = ((m)localObject1);
    localObject2 = parama.H();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = p9.d.k;
    }
    this.F = ((p9.d)localObject1);
    boolean bool = localList instanceof Collection;
    int i2 = 1;
    int i1;
    if ((bool) && (localList.isEmpty()))
    {
      i1 = i2;
    }
    else
    {
      localObject1 = localList.iterator();
      do
      {
        i1 = i2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!((l)((Iterator)localObject1).next()).f());
      i1 = 0;
    }
    if (i1 != 0)
    {
      this.q = null;
      this.w = null;
      this.r = null;
    }
    for (parama = g.d;; parama = parama.e((x9.c)localObject1))
    {
      this.v = parama;
      break;
      if (parama.G() != null)
      {
        this.q = parama.G();
        localObject1 = parama.h();
        f.c(localObject1);
        this.w = ((x9.c)localObject1);
        localObject2 = parama.J();
        f.c(localObject2);
        this.r = ((X509TrustManager)localObject2);
      }
      else
      {
        localObject2 = u9.h.a;
        localObject1 = ((h.a)localObject2).g().o();
        this.r = ((X509TrustManager)localObject1);
        localObject2 = ((h.a)localObject2).g();
        f.c(localObject1);
        this.q = ((u9.h)localObject2).n((X509TrustManager)localObject1);
        localObject2 = x9.c.a;
        f.c(localObject1);
        localObject1 = ((c.a)localObject2).a((X509TrustManager)localObject1);
        this.w = ((x9.c)localObject1);
      }
      parama = parama.i();
      f.c(localObject1);
    }
    J();
  }
  
  private final void J()
  {
    boolean bool = this.c.contains(null);
    int i2 = 1;
    if ((bool ^ true))
    {
      if ((this.d.contains(null) ^ true))
      {
        Object localObject = this.s;
        if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {}
        do
        {
          while (!((Iterator)localObject).hasNext())
          {
            i1 = 1;
            break;
            localObject = ((Iterable)localObject).iterator();
          }
        } while (!((l)((Iterator)localObject).next()).f());
        int i1 = 0;
        if (i1 != 0)
        {
          if (this.q == null) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i1 != 0)
          {
            if (this.w == null) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if (i1 != 0)
            {
              if (this.r == null) {
                i1 = i2;
              } else {
                i1 = 0;
              }
              if (i1 != 0)
              {
                if (f.a(this.v, g.d)) {
                  return;
                }
                throw new IllegalStateException("Check failed.".toString());
              }
              throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
          }
          throw new IllegalStateException("Check failed.".toString());
        }
        if (this.q != null)
        {
          if (this.w != null)
          {
            if (this.r != null) {
              return;
            }
            throw new IllegalStateException("x509TrustManager == null".toString());
          }
          throw new IllegalStateException("certificateChainCleaner == null".toString());
        }
        throw new IllegalStateException("sslSocketFactory == null".toString());
      }
      throw new IllegalStateException(f.m("Null network interceptor: ", y()).toString());
    }
    throw new IllegalStateException(f.m("Null interceptor: ", x()).toString());
  }
  
  public final List<c0> A()
  {
    return this.t;
  }
  
  public final Proxy C()
  {
    return this.m;
  }
  
  public final b D()
  {
    return this.o;
  }
  
  public final ProxySelector E()
  {
    return this.n;
  }
  
  public final int F()
  {
    return this.z;
  }
  
  public final boolean G()
  {
    return this.f;
  }
  
  public final SocketFactory H()
  {
    return this.p;
  }
  
  public final SSLSocketFactory I()
  {
    SSLSocketFactory localSSLSocketFactory = this.q;
    if (localSSLSocketFactory != null) {
      return localSSLSocketFactory;
    }
    throw new IllegalStateException("CLEARTEXT-only client");
  }
  
  public final int K()
  {
    return this.A;
  }
  
  public e a(d0 paramd0)
  {
    f.f(paramd0, "request");
    return new q9.h(this, paramd0, false);
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public final b d()
  {
    return this.h;
  }
  
  public final c e()
  {
    return null;
  }
  
  public final int f()
  {
    return this.x;
  }
  
  public final g j()
  {
    return this.v;
  }
  
  public final int k()
  {
    return this.y;
  }
  
  public final k l()
  {
    return this.b;
  }
  
  public final List<l> m()
  {
    return this.s;
  }
  
  public final p n()
  {
    return this.k;
  }
  
  public final r o()
  {
    return this.a;
  }
  
  public final s p()
  {
    return this.l;
  }
  
  public final t.c q()
  {
    return this.e;
  }
  
  public final boolean r()
  {
    return this.g;
  }
  
  public final boolean s()
  {
    return this.i;
  }
  
  public final boolean t()
  {
    return this.j;
  }
  
  public final m u()
  {
    return this.E;
  }
  
  public final p9.d v()
  {
    return this.F;
  }
  
  public final HostnameVerifier w()
  {
    return this.u;
  }
  
  public final List<y> x()
  {
    return this.c;
  }
  
  public final List<y> y()
  {
    return this.d;
  }
  
  public final int z()
  {
    return this.B;
  }
  
  public static final class a
  {
    private int A;
    private int B;
    private long C;
    private m D;
    private p9.d E;
    private r a = new r();
    private k b = new k();
    private final List<y> c = new ArrayList();
    private final List<y> d = new ArrayList();
    private t.c e = o.c(t.b);
    private boolean f = true;
    private boolean g;
    private b h;
    private boolean i;
    private boolean j;
    private p k;
    private s l;
    private Proxy m;
    private ProxySelector n;
    private b o;
    private SocketFactory p;
    private SSLSocketFactory q;
    private X509TrustManager r;
    private List<l> s;
    private List<? extends c0> t;
    private HostnameVerifier u;
    private g v;
    private x9.c w;
    private int x;
    private int y;
    private int z;
    
    public a()
    {
      Object localObject = b.b;
      this.h = ((b)localObject);
      this.i = true;
      this.j = true;
      this.k = p.b;
      this.l = s.b;
      this.o = ((b)localObject);
      localObject = SocketFactory.getDefault();
      f.e(localObject, "getDefault()");
      this.p = ((SocketFactory)localObject);
      localObject = b0.G;
      this.s = ((b0.b)localObject).a();
      this.t = ((b0.b)localObject).b();
      this.u = x9.d.a;
      this.v = g.d;
      this.y = 10000;
      this.z = 10000;
      this.A = 10000;
      this.C = 1024L;
    }
    
    public final b A()
    {
      return this.o;
    }
    
    public final ProxySelector B()
    {
      return this.n;
    }
    
    public final int C()
    {
      return this.z;
    }
    
    public final boolean D()
    {
      return this.f;
    }
    
    public final m E()
    {
      return this.D;
    }
    
    public final SocketFactory F()
    {
      return this.p;
    }
    
    public final SSLSocketFactory G()
    {
      return this.q;
    }
    
    public final p9.d H()
    {
      return this.E;
    }
    
    public final int I()
    {
      return this.A;
    }
    
    public final X509TrustManager J()
    {
      return this.r;
    }
    
    public final a K(HostnameVerifier paramHostnameVerifier)
    {
      f.f(paramHostnameVerifier, "hostnameVerifier");
      if (!f.a(paramHostnameVerifier, t())) {
        Q(null);
      }
      O(paramHostnameVerifier);
      return this;
    }
    
    public final a L(long paramLong, TimeUnit paramTimeUnit)
    {
      f.f(paramTimeUnit, "unit");
      P(o.f("timeout", paramLong, paramTimeUnit));
      return this;
    }
    
    public final void M(x9.c paramc)
    {
      this.w = paramc;
    }
    
    public final void N(int paramInt)
    {
      this.y = paramInt;
    }
    
    public final void O(HostnameVerifier paramHostnameVerifier)
    {
      f.f(paramHostnameVerifier, "<set-?>");
      this.u = paramHostnameVerifier;
    }
    
    public final void P(int paramInt)
    {
      this.z = paramInt;
    }
    
    public final void Q(m paramm)
    {
      this.D = paramm;
    }
    
    public final void R(SSLSocketFactory paramSSLSocketFactory)
    {
      this.q = paramSSLSocketFactory;
    }
    
    public final void S(int paramInt)
    {
      this.A = paramInt;
    }
    
    public final void T(X509TrustManager paramX509TrustManager)
    {
      this.r = paramX509TrustManager;
    }
    
    public final a U(SSLSocketFactory paramSSLSocketFactory, X509TrustManager paramX509TrustManager)
    {
      f.f(paramSSLSocketFactory, "sslSocketFactory");
      f.f(paramX509TrustManager, "trustManager");
      if ((!f.a(paramSSLSocketFactory, G())) || (!f.a(paramX509TrustManager, J()))) {
        Q(null);
      }
      R(paramSSLSocketFactory);
      M(x9.c.a.a(paramX509TrustManager));
      T(paramX509TrustManager);
      return this;
    }
    
    public final a V(long paramLong, TimeUnit paramTimeUnit)
    {
      f.f(paramTimeUnit, "unit");
      S(o.f("timeout", paramLong, paramTimeUnit));
      return this;
    }
    
    public final a a(y paramy)
    {
      f.f(paramy, "interceptor");
      u().add(paramy);
      return this;
    }
    
    public final a b(y paramy)
    {
      f.f(paramy, "interceptor");
      w().add(paramy);
      return this;
    }
    
    public final b0 c()
    {
      return new b0(this);
    }
    
    public final a d(long paramLong, TimeUnit paramTimeUnit)
    {
      f.f(paramTimeUnit, "unit");
      N(o.f("timeout", paramLong, paramTimeUnit));
      return this;
    }
    
    public final b e()
    {
      return this.h;
    }
    
    public final c f()
    {
      return null;
    }
    
    public final int g()
    {
      return this.x;
    }
    
    public final x9.c h()
    {
      return this.w;
    }
    
    public final g i()
    {
      return this.v;
    }
    
    public final int j()
    {
      return this.y;
    }
    
    public final k k()
    {
      return this.b;
    }
    
    public final List<l> l()
    {
      return this.s;
    }
    
    public final p m()
    {
      return this.k;
    }
    
    public final r n()
    {
      return this.a;
    }
    
    public final s o()
    {
      return this.l;
    }
    
    public final t.c p()
    {
      return this.e;
    }
    
    public final boolean q()
    {
      return this.g;
    }
    
    public final boolean r()
    {
      return this.i;
    }
    
    public final boolean s()
    {
      return this.j;
    }
    
    public final HostnameVerifier t()
    {
      return this.u;
    }
    
    public final List<y> u()
    {
      return this.c;
    }
    
    public final long v()
    {
      return this.C;
    }
    
    public final List<y> w()
    {
      return this.d;
    }
    
    public final int x()
    {
      return this.B;
    }
    
    public final List<c0> y()
    {
      return this.t;
    }
    
    public final Proxy z()
    {
      return this.m;
    }
  }
  
  public static final class b
  {
    public final List<l> a()
    {
      return b0.b();
    }
    
    public final List<c0> b()
    {
      return b0.c();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.b0
 * JD-Core Version:    0.7.0.1
 */