package v9;

import a9.f;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import l9.c0;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import u9.c;
import u9.c.a;
import u9.h;
import u9.h.a;

public final class g
  implements j
{
  public static final b a = new b(null);
  private static final i.a b = new a();
  
  public boolean a(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "sslSocket");
    return paramSSLSocket instanceof BCSSLSocket;
  }
  
  public String b(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "sslSocket");
    paramSSLSocket = ((BCSSLSocket)paramSSLSocket).getApplicationProtocol();
    boolean bool;
    if (paramSSLSocket == null) {
      bool = true;
    } else {
      bool = f.a(paramSSLSocket, "");
    }
    if (bool) {
      paramSSLSocket = null;
    }
    return paramSSLSocket;
  }
  
  public boolean c()
  {
    return c.e.b();
  }
  
  public void d(SSLSocket paramSSLSocket, String paramString, List<? extends c0> paramList)
  {
    f.f(paramSSLSocket, "sslSocket");
    f.f(paramList, "protocols");
    if (a(paramSSLSocket))
    {
      paramSSLSocket = (BCSSLSocket)paramSSLSocket;
      paramString = paramSSLSocket.getParameters();
      paramList = h.a.b(paramList).toArray(new String[0]);
      Objects.requireNonNull(paramList, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
      paramString.setApplicationProtocols((String[])paramList);
      paramSSLSocket.setParameters(paramString);
    }
  }
  
  public static final class a
    implements i.a
  {
    public boolean a(SSLSocket paramSSLSocket)
    {
      f.f(paramSSLSocket, "sslSocket");
      return (c.e.b()) && ((paramSSLSocket instanceof BCSSLSocket));
    }
    
    public j b(SSLSocket paramSSLSocket)
    {
      f.f(paramSSLSocket, "sslSocket");
      return new g();
    }
  }
  
  public static final class b
  {
    public final i.a a()
    {
      return g.e();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v9.g
 * JD-Core Version:    0.7.0.1
 */