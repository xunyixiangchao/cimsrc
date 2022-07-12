package v9;

import a9.f;
import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build.VERSION;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import l9.c0;
import u9.h;
import u9.h.a;

@SuppressLint({"NewApi"})
public final class a
  implements j
{
  public static final a a = new a(null);
  
  public boolean a(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "sslSocket");
    return SSLSockets.isSupportedSocket(paramSSLSocket);
  }
  
  @SuppressLint({"NewApi"})
  public String b(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "sslSocket");
    try
    {
      paramSSLSocket = paramSSLSocket.getApplicationProtocol();
      boolean bool;
      if (paramSSLSocket == null) {
        bool = true;
      } else {
        bool = f.a(paramSSLSocket, "");
      }
      if (bool) {
        return null;
      }
      return paramSSLSocket;
    }
    catch (UnsupportedOperationException paramSSLSocket) {}
    return null;
  }
  
  public boolean c()
  {
    return a.b();
  }
  
  @SuppressLint({"NewApi"})
  public void d(SSLSocket paramSSLSocket, String paramString, List<? extends c0> paramList)
  {
    f.f(paramSSLSocket, "sslSocket");
    f.f(paramList, "protocols");
    try
    {
      SSLSockets.setUseSessionTickets(paramSSLSocket, true);
      paramString = paramSSLSocket.getSSLParameters();
      paramList = h.a.b(paramList).toArray(new String[0]);
      if (paramList != null)
      {
        paramString.setApplicationProtocols((String[])paramList);
        paramSSLSocket.setSSLParameters(paramString);
        return;
      }
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
    catch (IllegalArgumentException paramSSLSocket)
    {
      throw new IOException("Android internal error", paramSSLSocket);
    }
  }
  
  public static final class a
  {
    public final j a()
    {
      if (b()) {
        return new a();
      }
      return null;
    }
    
    public final boolean b()
    {
      return (h.a.h()) && (Build.VERSION.SDK_INT >= 29);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v9.a
 * JD-Core Version:    0.7.0.1
 */