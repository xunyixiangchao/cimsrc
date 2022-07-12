package x9;

import a9.f;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import u9.h;
import u9.h.a;

public abstract class c
{
  public static final a a = new a(null);
  
  public abstract List<Certificate> a(List<? extends Certificate> paramList, String paramString);
  
  public static final class a
  {
    public final c a(X509TrustManager paramX509TrustManager)
    {
      f.f(paramX509TrustManager, "trustManager");
      return h.a.g().c(paramX509TrustManager);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x9.c
 * JD-Core Version:    0.7.0.1
 */