package u9;

import a9.f;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import l9.c0;
import org.conscrypt.Conscrypt;
import org.conscrypt.Conscrypt.Version;
import org.conscrypt.ConscryptHostnameVerifier;

public final class d
  extends h
{
  public static final a e;
  private static final boolean f;
  private final Provider d;
  
  static
  {
    a locala = new a(null);
    e = locala;
    bool2 = false;
    try
    {
      Class.forName("org.conscrypt.Conscrypt$Version", false, locala.getClass().getClassLoader());
      bool1 = bool2;
      if (Conscrypt.isAvailable())
      {
        boolean bool3 = locala.a(2, 1, 0);
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
    }
    catch (NoClassDefFoundError|ClassNotFoundException localNoClassDefFoundError)
    {
      for (;;)
      {
        boolean bool1 = bool2;
      }
    }
    f = bool1;
  }
  
  private d()
  {
    Provider localProvider = Conscrypt.newProvider();
    f.e(localProvider, "newProvider()");
    this.d = localProvider;
  }
  
  public void e(SSLSocket paramSSLSocket, String paramString, List<c0> paramList)
  {
    f.f(paramSSLSocket, "sslSocket");
    f.f(paramList, "protocols");
    if (Conscrypt.isConscrypt(paramSSLSocket))
    {
      Conscrypt.setUseSessionTickets(paramSSLSocket, true);
      paramString = h.a.b(paramList).toArray(new String[0]);
      Objects.requireNonNull(paramString, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
      Conscrypt.setApplicationProtocols(paramSSLSocket, (String[])paramString);
      return;
    }
    super.e(paramSSLSocket, paramString, paramList);
  }
  
  public String g(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "sslSocket");
    if (Conscrypt.isConscrypt(paramSSLSocket)) {
      return Conscrypt.getApplicationProtocol(paramSSLSocket);
    }
    return super.g(paramSSLSocket);
  }
  
  public SSLContext m()
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLS", this.d);
    f.e(localSSLContext, "getInstance(\"TLS\", provider)");
    return localSSLContext;
  }
  
  public SSLSocketFactory n(X509TrustManager paramX509TrustManager)
  {
    f.f(paramX509TrustManager, "trustManager");
    SSLContext localSSLContext = m();
    localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
    paramX509TrustManager = localSSLContext.getSocketFactory();
    f.e(paramX509TrustManager, "newSSLContext().apply {\n…null)\n    }.socketFactory");
    return paramX509TrustManager;
  }
  
  public X509TrustManager o()
  {
    Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    ((TrustManagerFactory)localObject).init(null);
    localObject = ((TrustManagerFactory)localObject).getTrustManagers();
    f.c(localObject);
    int j = localObject.length;
    int i = 1;
    if ((j != 1) || (!(localObject[0] instanceof X509TrustManager))) {
      i = 0;
    }
    if (i != 0)
    {
      localObject = localObject[0];
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
      localObject = (X509TrustManager)localObject;
      Conscrypt.setHostnameVerifier((TrustManager)localObject, (ConscryptHostnameVerifier)b.a);
      return localObject;
    }
    localObject = Arrays.toString((Object[])localObject);
    f.e(localObject, "toString(this)");
    throw new IllegalStateException(f.m("Unexpected default trust managers: ", localObject).toString());
  }
  
  public static final class a
  {
    public final boolean a(int paramInt1, int paramInt2, int paramInt3)
    {
      Conscrypt.Version localVersion = Conscrypt.version();
      boolean bool2 = false;
      boolean bool3 = false;
      boolean bool1 = false;
      if (localVersion == null) {
        return false;
      }
      if (localVersion.major() != paramInt1)
      {
        if (localVersion.major() > paramInt1) {
          bool1 = true;
        }
        return bool1;
      }
      if (localVersion.minor() != paramInt2)
      {
        bool1 = bool2;
        if (localVersion.minor() > paramInt2) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if (localVersion.patch() >= paramInt3) {
        bool1 = true;
      }
      return bool1;
    }
    
    public final d b()
    {
      boolean bool = c();
      d locald = null;
      if (bool) {
        locald = new d(null);
      }
      return locald;
    }
    
    public final boolean c()
    {
      return d.p();
    }
  }
  
  public static final class b
    implements ConscryptHostnameVerifier
  {
    public static final b a = new b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u9.d
 * JD-Core Version:    0.7.0.1
 */