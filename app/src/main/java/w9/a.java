package w9;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import p8.l;

public final class a
  extends ProxySelector
{
  public static final a a = new a();
  
  public void connectFailed(URI paramURI, SocketAddress paramSocketAddress, IOException paramIOException) {}
  
  public List<Proxy> select(URI paramURI)
  {
    if (paramURI != null) {
      return l.d(Proxy.NO_PROXY);
    }
    throw new IllegalArgumentException("uri must not be null".toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w9.a
 * JD-Core Version:    0.7.0.1
 */