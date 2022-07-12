package q9;

import a9.f;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class q
{
  public static final boolean a(IOException paramIOException)
  {
    f.f(paramIOException, "e");
    boolean bool2 = paramIOException instanceof ProtocolException;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramIOException instanceof InterruptedIOException)) {
      return false;
    }
    if (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) {
      return false;
    }
    if ((paramIOException instanceof SSLPeerUnverifiedException)) {
      return false;
    }
    if ((paramIOException instanceof SSLException)) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.q
 * JD-Core Version:    0.7.0.1
 */