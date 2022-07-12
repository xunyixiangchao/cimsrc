package v9;

import a9.f;
import java.util.List;
import javax.net.ssl.SSLSocket;
import l9.c0;

public final class i
  implements j
{
  private final a a;
  private j b;
  
  public i(a parama)
  {
    this.a = parama;
  }
  
  private final j e(SSLSocket paramSSLSocket)
  {
    try
    {
      if ((this.b == null) && (this.a.a(paramSSLSocket))) {
        this.b = this.a.b(paramSSLSocket);
      }
      paramSSLSocket = this.b;
      return paramSSLSocket;
    }
    finally {}
  }
  
  public boolean a(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "sslSocket");
    return this.a.a(paramSSLSocket);
  }
  
  public String b(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "sslSocket");
    j localj = e(paramSSLSocket);
    if (localj == null) {
      return null;
    }
    return localj.b(paramSSLSocket);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d(SSLSocket paramSSLSocket, String paramString, List<? extends c0> paramList)
  {
    f.f(paramSSLSocket, "sslSocket");
    f.f(paramList, "protocols");
    j localj = e(paramSSLSocket);
    if (localj == null) {
      return;
    }
    localj.d(paramSSLSocket, paramString, paramList);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(SSLSocket paramSSLSocket);
    
    public abstract j b(SSLSocket paramSSLSocket);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v9.i
 * JD-Core Version:    0.7.0.1
 */