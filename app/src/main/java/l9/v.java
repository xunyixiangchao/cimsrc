package l9;

import a9.f;
import a9.g;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import m9.o;
import o8.d;
import o8.e;
import p8.l;
import z8.a;

public final class v
{
  public static final a e = new a(null);
  private final i0 a;
  private final i b;
  private final List<Certificate> c;
  private final d d;
  
  public v(i0 parami0, i parami, List<? extends Certificate> paramList, a<? extends List<? extends Certificate>> parama)
  {
    this.a = parami0;
    this.b = parami;
    this.c = paramList;
    this.d = e.a(new b(parama));
  }
  
  private final String b(Certificate paramCertificate)
  {
    if ((paramCertificate instanceof X509Certificate)) {
      return ((X509Certificate)paramCertificate).getSubjectDN().toString();
    }
    paramCertificate = paramCertificate.getType();
    f.e(paramCertificate, "type");
    return paramCertificate;
  }
  
  public final i a()
  {
    return this.b;
  }
  
  public final List<Certificate> c()
  {
    return this.c;
  }
  
  public final List<Certificate> d()
  {
    return (List)this.d.getValue();
  }
  
  public final i0 e()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof v))
    {
      paramObject = (v)paramObject;
      if ((paramObject.a == this.a) && (f.a(paramObject.b, this.b)) && (f.a(paramObject.d(), d())) && (f.a(paramObject.c, this.c))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return (((527 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + d().hashCode()) * 31 + this.c.hashCode();
  }
  
  public String toString()
  {
    Object localObject2 = d();
    Object localObject1 = new ArrayList(l.q((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(b((Certificate)((Iterator)localObject2).next()));
    }
    localObject2 = localObject1.toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Handshake{tlsVersion=");
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append(" cipherSuite=");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(" peerCertificates=");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(" localCertificates=");
    Object localObject3 = this.c;
    localObject2 = new ArrayList(l.q((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(b((Certificate)((Iterator)localObject3).next()));
    }
    ((StringBuilder)localObject1).append(localObject2);
    ((StringBuilder)localObject1).append('}');
    return ((StringBuilder)localObject1).toString();
  }
  
  public static final class a
  {
    private final List<Certificate> b(Certificate[] paramArrayOfCertificate)
    {
      if (paramArrayOfCertificate != null) {
        return o.k(Arrays.copyOf(paramArrayOfCertificate, paramArrayOfCertificate.length));
      }
      return l.h();
    }
    
    public final v a(SSLSession paramSSLSession)
    {
      f.f(paramSSLSession, "<this>");
      Object localObject = paramSSLSession.getCipherSuite();
      i locali;
      i0 locali0;
      if (localObject != null)
      {
        boolean bool;
        if (f.a(localObject, "TLS_NULL_WITH_NULL_NULL")) {
          bool = true;
        } else {
          bool = f.a(localObject, "SSL_NULL_WITH_NULL_NULL");
        }
        if (!bool)
        {
          locali = i.b.b((String)localObject);
          localObject = paramSSLSession.getProtocol();
          if (localObject != null) {
            if (!f.a("NONE", localObject)) {
              locali0 = i0.b.a((String)localObject);
            }
          }
        }
      }
      try
      {
        localObject = b(paramSSLSession.getPeerCertificates());
      }
      catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
      {
        label94:
        break label94;
      }
      localObject = l.h();
      return new v(locali0, locali, b(paramSSLSession.getLocalCertificates()), new a((List)localObject));
      throw new IOException("tlsVersion == NONE");
      throw new IllegalStateException("tlsVersion == null".toString());
      throw new IOException(f.m("cipherSuite == ", localObject));
      throw new IllegalStateException("cipherSuite == null".toString());
    }
    
    static final class a
      extends g
      implements a<List<? extends Certificate>>
    {
      a(List<? extends Certificate> paramList)
      {
        super();
      }
      
      public final List<Certificate> d()
      {
        return this.b;
      }
    }
  }
  
  static final class b
    extends g
    implements a<List<? extends Certificate>>
  {
    b(a<? extends List<? extends Certificate>> parama)
    {
      super();
    }
    
    public final List<Certificate> d()
    {
      try
      {
        List localList = (List)this.b.b();
        return localList;
      }
      catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
      {
        label15:
        break label15;
      }
      return l.h();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.v
 * JD-Core Version:    0.7.0.1
 */