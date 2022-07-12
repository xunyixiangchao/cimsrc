package v9;

import a9.f;
import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import x9.c;

public final class b
  extends c
{
  public static final a d = new a(null);
  private final X509TrustManager b;
  private final X509TrustManagerExtensions c;
  
  public b(X509TrustManager paramX509TrustManager, X509TrustManagerExtensions paramX509TrustManagerExtensions)
  {
    this.b = paramX509TrustManager;
    this.c = paramX509TrustManagerExtensions;
  }
  
  public List<Certificate> a(List<? extends Certificate> paramList, String paramString)
  {
    f.f(paramList, "chain");
    f.f(paramString, "hostname");
    paramList = paramList.toArray(new X509Certificate[0]);
    Objects.requireNonNull(paramList, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    paramList = (X509Certificate[])paramList;
    try
    {
      paramList = this.c.checkServerTrusted(paramList, "RSA", paramString);
      f.e(paramList, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
      return paramList;
    }
    catch (CertificateException paramList)
    {
      paramString = new SSLPeerUnverifiedException(paramList.getMessage());
      paramString.initCause(paramList);
      throw paramString;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof b)) && (((b)paramObject).b == this.b);
  }
  
  public int hashCode()
  {
    return System.identityHashCode(this.b);
  }
  
  public static final class a
  {
    public final b a(X509TrustManager paramX509TrustManager)
    {
      f.f(paramX509TrustManager, "trustManager");
      b localb = null;
      try
      {
        localX509TrustManagerExtensions = new X509TrustManagerExtensions(paramX509TrustManager);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        X509TrustManagerExtensions localX509TrustManagerExtensions;
        label20:
        break label20;
      }
      localX509TrustManagerExtensions = null;
      if (localX509TrustManagerExtensions != null) {
        localb = new b(paramX509TrustManager, localX509TrustManagerExtensions);
      }
      return localb;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v9.b
 * JD-Core Version:    0.7.0.1
 */