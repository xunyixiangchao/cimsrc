package u9;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import l9.b0;
import l9.c0;
import p8.l;

public class h
{
  public static final a a;
  private static volatile h b;
  private static final Logger c = Logger.getLogger(b0.class.getName());
  
  static
  {
    a locala = new a(null);
    a = locala;
    b = a.a(locala);
  }
  
  public void b(SSLSocket paramSSLSocket)
  {
    a9.f.f(paramSSLSocket, "sslSocket");
  }
  
  public x9.c c(X509TrustManager paramX509TrustManager)
  {
    a9.f.f(paramX509TrustManager, "trustManager");
    return new x9.a(d(paramX509TrustManager));
  }
  
  public x9.e d(X509TrustManager paramX509TrustManager)
  {
    a9.f.f(paramX509TrustManager, "trustManager");
    paramX509TrustManager = paramX509TrustManager.getAcceptedIssuers();
    a9.f.e(paramX509TrustManager, "trustManager.acceptedIssuers");
    return new x9.b((X509Certificate[])Arrays.copyOf(paramX509TrustManager, paramX509TrustManager.length));
  }
  
  public void e(SSLSocket paramSSLSocket, String paramString, List<c0> paramList)
  {
    a9.f.f(paramSSLSocket, "sslSocket");
    a9.f.f(paramList, "protocols");
  }
  
  public void f(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    a9.f.f(paramSocket, "socket");
    a9.f.f(paramInetSocketAddress, "address");
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String g(SSLSocket paramSSLSocket)
  {
    a9.f.f(paramSSLSocket, "sslSocket");
    return null;
  }
  
  public Object h(String paramString)
  {
    a9.f.f(paramString, "closer");
    if (c.isLoggable(Level.FINE)) {
      return new Throwable(paramString);
    }
    return null;
  }
  
  public boolean i(String paramString)
  {
    a9.f.f(paramString, "hostname");
    return true;
  }
  
  public void j(String paramString, int paramInt, Throwable paramThrowable)
  {
    a9.f.f(paramString, "message");
    Level localLevel;
    if (paramInt == 5) {
      localLevel = Level.WARNING;
    } else {
      localLevel = Level.INFO;
    }
    c.log(localLevel, paramString, paramThrowable);
  }
  
  public void l(String paramString, Object paramObject)
  {
    a9.f.f(paramString, "message");
    String str = paramString;
    if (paramObject == null) {
      str = a9.f.m(paramString, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
    }
    j(str, 5, (Throwable)paramObject);
  }
  
  public SSLContext m()
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLS");
    a9.f.e(localSSLContext, "getInstance(\"TLS\")");
    return localSSLContext;
  }
  
  public SSLSocketFactory n(X509TrustManager paramX509TrustManager)
  {
    a9.f.f(paramX509TrustManager, "trustManager");
    try
    {
      SSLContext localSSLContext = m();
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      a9.f.e(paramX509TrustManager, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      throw new AssertionError(a9.f.m("No System TLS: ", paramX509TrustManager), paramX509TrustManager);
    }
  }
  
  public X509TrustManager o()
  {
    Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    ((TrustManagerFactory)localObject).init(null);
    localObject = ((TrustManagerFactory)localObject).getTrustManagers();
    a9.f.c(localObject);
    int j = localObject.length;
    int i = 1;
    if ((j != 1) || (!(localObject[0] instanceof X509TrustManager))) {
      i = 0;
    }
    if (i != 0)
    {
      localObject = localObject[0];
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
      return (X509TrustManager)localObject;
    }
    localObject = Arrays.toString((Object[])localObject);
    a9.f.e(localObject, "toString(this)");
    throw new IllegalStateException(a9.f.m("Unexpected default trust managers: ", localObject).toString());
  }
  
  public String toString()
  {
    String str = getClass().getSimpleName();
    a9.f.e(str, "javaClass.simpleName");
    return str;
  }
  
  public static final class a
  {
    private final h d()
    {
      v9.c.a.b();
      h localh2 = a.e.a();
      h localh1 = localh2;
      if (localh2 == null)
      {
        localh1 = b.e.a();
        a9.f.c(localh1);
      }
      return localh1;
    }
    
    private final h e()
    {
      if (j())
      {
        localObject = d.e.b();
        if (localObject != null) {
          return localObject;
        }
      }
      if (i())
      {
        localObject = c.e.a();
        if (localObject != null) {
          return localObject;
        }
      }
      if (k())
      {
        localObject = g.e.a();
        if (localObject != null) {
          return localObject;
        }
      }
      Object localObject = f.d.a();
      if (localObject != null) {
        return localObject;
      }
      localObject = e.i.a();
      if (localObject != null) {
        return localObject;
      }
      return new h();
    }
    
    private final h f()
    {
      if (h()) {
        return d();
      }
      return e();
    }
    
    private final boolean i()
    {
      return a9.f.a("BC", java.security.Security.getProviders()[0].getName());
    }
    
    private final boolean j()
    {
      return a9.f.a("Conscrypt", java.security.Security.getProviders()[0].getName());
    }
    
    private final boolean k()
    {
      return a9.f.a("OpenJSSE", java.security.Security.getProviders()[0].getName());
    }
    
    public final List<String> b(List<? extends c0> paramList)
    {
      a9.f.f(paramList, "protocols");
      Object localObject1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject2 = paramList.next();
        int i;
        if ((c0)localObject2 != c0.c) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          ((Collection)localObject1).add(localObject2);
        }
      }
      paramList = new ArrayList(l.q((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramList.add(((c0)((Iterator)localObject1).next()).toString());
      }
      return paramList;
    }
    
    public final byte[] c(List<? extends c0> paramList)
    {
      a9.f.f(paramList, "protocols");
      aa.b localb = new aa.b();
      paramList = b(paramList).iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        localb.H0(str.length());
        localb.N0(str);
      }
      return localb.o0();
    }
    
    public final h g()
    {
      return h.a();
    }
    
    public final boolean h()
    {
      return a9.f.a("Dalvik", System.getProperty("java.vm.name"));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u9.h
 * JD-Core Version:    0.7.0.1
 */