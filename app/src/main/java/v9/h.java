package v9;

import a9.f;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import l9.c0;
import org.conscrypt.Conscrypt;
import u9.d;
import u9.d.a;

public final class h
  implements j
{
  public static final b a = new b(null);
  private static final i.a b = new a();
  
  public boolean a(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "sslSocket");
    return Conscrypt.isConscrypt(paramSSLSocket);
  }
  
  public String b(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "sslSocket");
    if (a(paramSSLSocket)) {
      return Conscrypt.getApplicationProtocol(paramSSLSocket);
    }
    return null;
  }
  
  public boolean c()
  {
    return d.e.c();
  }
  
  public void d(SSLSocket paramSSLSocket, String paramString, List<? extends c0> paramList)
  {
    f.f(paramSSLSocket, "sslSocket");
    f.f(paramList, "protocols");
    if (a(paramSSLSocket))
    {
      Conscrypt.setUseSessionTickets(paramSSLSocket, true);
      paramString = u9.h.a.b(paramList).toArray(new String[0]);
      Objects.requireNonNull(paramString, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
      Conscrypt.setApplicationProtocols(paramSSLSocket, (String[])paramString);
    }
  }
  
  public static final class a
    implements i.a
  {
    public boolean a(SSLSocket paramSSLSocket)
    {
      f.f(paramSSLSocket, "sslSocket");
      return (d.e.c()) && (Conscrypt.isConscrypt(paramSSLSocket));
    }
    
    public j b(SSLSocket paramSSLSocket)
    {
      f.f(paramSSLSocket, "sslSocket");
      return new h();
    }
  }
  
  public static final class b
  {
    public final i.a a()
    {
      return h.e();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v9.h
 * JD-Core Version:    0.7.0.1
 */