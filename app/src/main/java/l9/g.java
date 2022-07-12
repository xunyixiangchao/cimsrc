package l9;

import a9.f;
import a9.m;
import aa.e;
import aa.e.a;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import x9.c;
import z8.a;
import z8.a<+Ljava.util.List<+Ljava.security.cert.X509Certificate;>;>;

public final class g
{
  public static final b c = new b(null);
  public static final g d = new a().a();
  private final Set<c> a;
  private final c b;
  
  public g(Set<c> paramSet, c paramc)
  {
    this.a = paramSet;
    this.b = paramc;
  }
  
  public final void a(final String paramString, final List<? extends Certificate> paramList)
  {
    f.f(paramString, "hostname");
    f.f(paramList, "peerCertificates");
    b(paramString, new d(this, paramList, paramString));
  }
  
  public final void b(String paramString, a<? extends List<? extends X509Certificate>> parama)
  {
    f.f(paramString, "hostname");
    f.f(parama, "cleanedPeerCertificatesFn");
    List localList1 = c(paramString);
    if (localList1.isEmpty()) {
      return;
    }
    List localList2 = (List)parama.b();
    Iterator localIterator1 = localList2.iterator();
    c localc;
    Object localObject2;
    do
    {
      X509Certificate localX509Certificate;
      do
      {
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localX509Certificate = (X509Certificate)localIterator1.next();
          localIterator2 = localList1.iterator();
          localObject1 = null;
          parama = null;
        }
        localc = (c)localIterator2.next();
        localObject2 = localc.b();
        if (!f.a(localObject2, "sha256")) {
          break;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = c.c(localX509Certificate);
        }
        localObject1 = localObject2;
      } while (!f.a(localc.a(), localObject2));
      return;
      if (!f.a(localObject2, "sha1")) {
        break;
      }
      localObject2 = parama;
      if (parama == null) {
        localObject2 = c.b(localX509Certificate);
      }
      parama = (a<? extends List<? extends X509Certificate>>)localObject2;
    } while (!f.a(localc.a(), localObject2));
    return;
    throw new AssertionError(f.m("unsupported hashAlgorithm: ", localc.b()));
    parama = new StringBuilder();
    parama.append("Certificate pinning failure!");
    parama.append("\n  Peer certificate chain:");
    Object localObject1 = localList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (X509Certificate)((Iterator)localObject1).next();
      parama.append("\n    ");
      parama.append(c.a((Certificate)localObject2));
      parama.append(": ");
      parama.append(((X509Certificate)localObject2).getSubjectDN().getName());
    }
    parama.append("\n  Pinned certificates for ");
    parama.append(paramString);
    parama.append(":");
    paramString = localList1.iterator();
    while (paramString.hasNext())
    {
      localObject1 = (c)paramString.next();
      parama.append("\n    ");
      parama.append(localObject1);
    }
    paramString = parama.toString();
    f.e(paramString, "StringBuilder().apply(builderAction).toString()");
    throw new SSLPeerUnverifiedException(paramString);
  }
  
  public final List<c> c(String paramString)
  {
    f.f(paramString, "hostname");
    Object localObject2 = this.a;
    Object localObject1 = p8.l.h();
    Iterator localIterator = ((Iterable)localObject2).iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = localIterator.next();
      if (((c)localObject3).c(paramString))
      {
        localObject2 = localObject1;
        if (((List)localObject1).isEmpty()) {
          localObject2 = new ArrayList();
        }
        m.a(localObject2).add(localObject3);
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public final c d()
  {
    return this.b;
  }
  
  public final g e(c paramc)
  {
    f.f(paramc, "certificateChainCleaner");
    if (f.a(this.b, paramc)) {
      return this;
    }
    return new g(this.a, paramc);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof g))
    {
      paramObject = (g)paramObject;
      if ((f.a(paramObject.a, this.a)) && (f.a(paramObject.b, this.b))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.a.hashCode();
    c localc = this.b;
    int i;
    if (localc == null) {
      i = 0;
    } else {
      i = localc.hashCode();
    }
    return (1517 + j) * 41 + i;
  }
  
  public static final class a
  {
    private final List<g.c> a = new ArrayList();
    
    public final g a()
    {
      return new g(p8.l.M(this.a), null, 2, null);
    }
  }
  
  public static final class b
  {
    public final String a(Certificate paramCertificate)
    {
      f.f(paramCertificate, "certificate");
      if ((paramCertificate instanceof X509Certificate)) {
        return f.m("sha256/", c((X509Certificate)paramCertificate).a());
      }
      throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
    }
    
    public final e b(X509Certificate paramX509Certificate)
    {
      f.f(paramX509Certificate, "<this>");
      e.a locala = e.d;
      paramX509Certificate = paramX509Certificate.getPublicKey().getEncoded();
      f.e(paramX509Certificate, "publicKey.encoded");
      return e.a.e(locala, paramX509Certificate, 0, 0, 3, null).p();
    }
    
    public final e c(X509Certificate paramX509Certificate)
    {
      f.f(paramX509Certificate, "<this>");
      e.a locala = e.d;
      paramX509Certificate = paramX509Certificate.getPublicKey().getEncoded();
      f.e(paramX509Certificate, "publicKey.encoded");
      return e.a.e(locala, paramX509Certificate, 0, 0, 3, null).q();
    }
  }
  
  public static final class c
  {
    private final String a;
    private final String b;
    private final e c;
    
    public final e a()
    {
      return this.c;
    }
    
    public final String b()
    {
      return this.b;
    }
    
    public final boolean c(String paramString)
    {
      f.f(paramString, "hostname");
      String str = this.a;
      boolean bool2 = false;
      int i;
      int j;
      if (f9.l.x(str, "**.", false, 2, null))
      {
        i = this.a.length() - 3;
        j = paramString.length() - i;
        bool1 = bool2;
        if (!f9.l.o(paramString, paramString.length() - i, this.a, 3, i, false, 16, null)) {
          break label186;
        }
        if (j != 0)
        {
          bool1 = bool2;
          if (paramString.charAt(j - 1) != '.') {
            break label186;
          }
        }
      }
      for (;;)
      {
        return true;
        if (!f9.l.x(this.a, "*.", false, 2, null)) {
          break;
        }
        i = this.a.length() - 1;
        j = paramString.length();
        bool1 = bool2;
        if (!f9.l.o(paramString, paramString.length() - i, this.a, 1, i, false, 16, null)) {
          break label186;
        }
        bool1 = bool2;
        if (f9.l.R(paramString, '.', j - i - 1, false, 4, null) != -1) {
          break label186;
        }
      }
      boolean bool1 = f.a(paramString, this.a);
      label186:
      return bool1;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof c)) {
        return false;
      }
      String str = this.a;
      paramObject = (c)paramObject;
      if (!f.a(str, paramObject.a)) {
        return false;
      }
      if (!f.a(this.b, paramObject.b)) {
        return false;
      }
      return f.a(this.c, paramObject.c);
    }
    
    public int hashCode()
    {
      return (this.a.hashCode() * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append('/');
      localStringBuilder.append(this.c.a());
      return localStringBuilder.toString();
    }
  }
  
  static final class d
    extends a9.g
    implements a<List<? extends X509Certificate>>
  {
    d(g paramg, List<? extends Certificate> paramList, String paramString)
    {
      super();
    }
    
    public final List<X509Certificate> d()
    {
      Object localObject1 = this.b.d();
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((c)localObject1).a(paramList, paramString);
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramList;
      }
      localObject1 = new ArrayList(p8.l.q((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add((X509Certificate)((Iterator)localObject2).next());
      }
      return localObject1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.g
 * JD-Core Version:    0.7.0.1
 */