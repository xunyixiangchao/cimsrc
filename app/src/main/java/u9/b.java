package u9;

import android.os.Build.VERSION;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import l9.c0;
import p8.l;
import v9.f.a;
import v9.g;
import v9.g.b;
import v9.h.b;
import v9.i;
import v9.j;
import v9.k;
import v9.k.a;
import x9.c;
import x9.e;

public final class b
  extends h
{
  public static final a e = new a(null);
  private static final boolean f;
  private final List<j> d;
  
  static
  {
    boolean bool2 = h.a.h();
    boolean bool1 = false;
    if ((bool2) && (Build.VERSION.SDK_INT < 30)) {
      bool1 = true;
    }
    f = bool1;
  }
  
  public b()
  {
    Object localObject1 = l.l(new j[] { k.a.b(k.j, null, 1, null), new i(v9.f.f.d()), new i(v9.h.a.a()), new i(g.a.a()) });
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((j)localObject2).c()) {
        localArrayList.add(localObject2);
      }
    }
    this.d = localArrayList;
  }
  
  public c c(X509TrustManager paramX509TrustManager)
  {
    a9.f.f(paramX509TrustManager, "trustManager");
    v9.b localb = v9.b.d.a(paramX509TrustManager);
    Object localObject = localb;
    if (localb == null) {
      localObject = super.c(paramX509TrustManager);
    }
    return localObject;
  }
  
  public e d(X509TrustManager paramX509TrustManager)
  {
    a9.f.f(paramX509TrustManager, "trustManager");
    try
    {
      Object localObject = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      ((Method)localObject).setAccessible(true);
      a9.f.e(localObject, "method");
      localObject = new b(paramX509TrustManager, (Method)localObject);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label48:
      break label48;
    }
    return super.d(paramX509TrustManager);
  }
  
  public void e(SSLSocket paramSSLSocket, String paramString, List<c0> paramList)
  {
    a9.f.f(paramSSLSocket, "sslSocket");
    a9.f.f(paramList, "protocols");
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((j)localObject).a(paramSSLSocket)) {
        break label62;
      }
    }
    Object localObject = null;
    label62:
    localObject = (j)localObject;
    if (localObject == null) {
      return;
    }
    ((j)localObject).d(paramSSLSocket, paramString, paramList);
  }
  
  public void f(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    a9.f.f(paramSocket, "socket");
    a9.f.f(paramInetSocketAddress, "address");
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    }
    catch (ClassCastException paramSocket)
    {
      if (Build.VERSION.SDK_INT == 26) {
        throw new IOException("Exception in connect", paramSocket);
      }
      throw paramSocket;
    }
  }
  
  public String g(SSLSocket paramSSLSocket)
  {
    a9.f.f(paramSSLSocket, "sslSocket");
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((j)localObject).a(paramSSLSocket)) {
        break label50;
      }
    }
    Object localObject = null;
    label50:
    localObject = (j)localObject;
    if (localObject == null) {
      return null;
    }
    return ((j)localObject).b(paramSSLSocket);
  }
  
  public boolean i(String paramString)
  {
    a9.f.f(paramString, "hostname");
    if (Build.VERSION.SDK_INT >= 24) {
      return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(paramString);
    }
    return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
  }
  
  public static final class a
  {
    public final h a()
    {
      if (b()) {
        return new b();
      }
      return null;
    }
    
    public final boolean b()
    {
      return b.p();
    }
  }
  
  public static final class b
    implements e
  {
    private final X509TrustManager a;
    private final Method b;
    
    public b(X509TrustManager paramX509TrustManager, Method paramMethod)
    {
      this.a = paramX509TrustManager;
      this.b = paramMethod;
    }
    
    public X509Certificate a(X509Certificate paramX509Certificate)
    {
      a9.f.f(paramX509Certificate, "cert");
      try
      {
        paramX509Certificate = this.b.invoke(this.a, new Object[] { paramX509Certificate });
        if (paramX509Certificate != null) {
          return ((TrustAnchor)paramX509Certificate).getTrustedCert();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
      }
      catch (IllegalAccessException paramX509Certificate)
      {
        throw new AssertionError("unable to get issues and signature", paramX509Certificate);
      }
      catch (InvocationTargetException paramX509Certificate)
      {
        label48:
        break label48;
      }
      return null;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      if (!a9.f.a(this.a, paramObject.a)) {
        return false;
      }
      return a9.f.a(this.b, paramObject.b);
    }
    
    public int hashCode()
    {
      return this.a.hashCode() * 31 + this.b.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CustomTrustRootIndex(trustManager=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", findByIssuerAndSignatureMethod=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u9.b
 * JD-Core Version:    0.7.0.1
 */