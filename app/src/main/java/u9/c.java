package u9;

import a9.f;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import l9.c0;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

public final class c
  extends h
{
  public static final a e;
  private static final boolean f;
  private final Provider d = (Provider)new BouncyCastleJsseProvider();
  
  static
  {
    a locala = new a(null);
    e = locala;
    boolean bool = false;
    try
    {
      Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, locala.getClass().getClassLoader());
      bool = true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label31:
      break label31;
    }
    f = bool;
  }
  
  public void e(SSLSocket paramSSLSocket, String paramString, List<c0> paramList)
  {
    f.f(paramSSLSocket, "sslSocket");
    f.f(paramList, "protocols");
    if ((paramSSLSocket instanceof BCSSLSocket))
    {
      paramSSLSocket = (BCSSLSocket)paramSSLSocket;
      paramString = paramSSLSocket.getParameters();
      paramList = h.a.b(paramList).toArray(new String[0]);
      Objects.requireNonNull(paramList, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
      paramString.setApplicationProtocols((String[])paramList);
      paramSSLSocket.setParameters(paramString);
      return;
    }
    super.e(paramSSLSocket, paramString, paramList);
  }
  
  public String g(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "sslSocket");
    if ((paramSSLSocket instanceof BCSSLSocket))
    {
      paramSSLSocket = ((BCSSLSocket)paramSSLSocket).getApplicationProtocol();
      boolean bool;
      if (paramSSLSocket == null) {
        bool = true;
      } else {
        bool = f.a(paramSSLSocket, "");
      }
      if (bool) {
        return null;
      }
    }
    else
    {
      paramSSLSocket = super.g(paramSSLSocket);
    }
    return paramSSLSocket;
  }
  
  public SSLContext m()
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLS", this.d);
    f.e(localSSLContext, "getInstance(\"TLS\", provider)");
    return localSSLContext;
  }
  
  public X509TrustManager o()
  {
    Object localObject = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
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
      return (X509TrustManager)localObject;
    }
    localObject = Arrays.toString((Object[])localObject);
    f.e(localObject, "toString(this)");
    throw new IllegalStateException(f.m("Unexpected default trust managers: ", localObject).toString());
  }
  
  public static final class a
  {
    public final c a()
    {
      boolean bool = b();
      c localc = null;
      if (bool) {
        localc = new c(null);
      }
      return localc;
    }
    
    public final boolean b()
    {
      return c.p();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u9.c
 * JD-Core Version:    0.7.0.1
 */