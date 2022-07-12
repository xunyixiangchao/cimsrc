package x9;

import aa.z;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import m9.e;

public final class d
  implements HostnameVerifier
{
  public static final d a = new d();
  
  private final String b(String paramString)
  {
    Object localObject = paramString;
    if (d(paramString))
    {
      localObject = Locale.US;
      a9.f.e(localObject, "US");
      localObject = paramString.toLowerCase((Locale)localObject);
      a9.f.e(localObject, "this as java.lang.String).toLowerCase(locale)");
    }
    return localObject;
  }
  
  private final List<String> c(X509Certificate paramX509Certificate, int paramInt)
  {
    try
    {
      Object localObject1 = paramX509Certificate.getSubjectAlternativeNames();
      if (localObject1 == null) {
        return p8.l.h();
      }
      paramX509Certificate = new ArrayList();
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (List)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((List)localObject2).size() >= 2) && (a9.f.a(((List)localObject2).get(0), Integer.valueOf(paramInt))))
        {
          localObject2 = ((List)localObject2).get(1);
          if (localObject2 != null) {
            paramX509Certificate.add((String)localObject2);
          }
        }
      }
      return paramX509Certificate;
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      label123:
      break label123;
    }
    return p8.l.h();
  }
  
  private final boolean d(String paramString)
  {
    int i = paramString.length();
    boolean bool = false;
    if (i == (int)z.b(paramString, 0, 0, 3, null)) {
      bool = true;
    }
    return bool;
  }
  
  private final boolean f(String paramString1, String paramString2)
  {
    int i;
    if ((paramString1 != null) && (paramString1.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (!f9.l.x(paramString1, ".", false, 2, null)))
    {
      if (f9.l.k(paramString1, "..", false, 2, null)) {
        return false;
      }
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i == 0) && (!f9.l.x(paramString2, ".", false, 2, null)))
      {
        if (f9.l.k(paramString2, "..", false, 2, null)) {
          return false;
        }
        String str = paramString1;
        if (!f9.l.k(paramString1, ".", false, 2, null)) {
          str = a9.f.m(paramString1, ".");
        }
        paramString1 = paramString2;
        if (!f9.l.k(paramString2, ".", false, 2, null)) {
          paramString1 = a9.f.m(paramString2, ".");
        }
        paramString1 = b(paramString1);
        if (!f9.l.C(paramString1, "*", false, 2, null)) {
          return a9.f.a(str, paramString1);
        }
        if (f9.l.x(paramString1, "*.", false, 2, null))
        {
          if (f9.l.M(paramString1, '*', 1, false, 4, null) != -1) {
            return false;
          }
          if (str.length() < paramString1.length()) {
            return false;
          }
          if (a9.f.a("*.", paramString1)) {
            return false;
          }
          paramString1 = paramString1.substring(1);
          a9.f.e(paramString1, "this as java.lang.String).substring(startIndex)");
          if (!f9.l.k(str, paramString1, false, 2, null)) {
            return false;
          }
          i = str.length() - paramString1.length();
          return (i <= 0) || (f9.l.R(str, '.', i - 1, false, 4, null) == -1);
        }
      }
    }
    return false;
  }
  
  private final boolean g(String paramString, X509Certificate paramX509Certificate)
  {
    paramString = b(paramString);
    paramX509Certificate = c(paramX509Certificate, 2);
    boolean bool1 = paramX509Certificate instanceof Collection;
    boolean bool2 = false;
    if ((bool1) && (paramX509Certificate.isEmpty())) {
      return false;
    }
    paramX509Certificate = paramX509Certificate.iterator();
    String str;
    do
    {
      bool1 = bool2;
      if (!paramX509Certificate.hasNext()) {
        break;
      }
      str = (String)paramX509Certificate.next();
    } while (!a.f(paramString, str));
    bool1 = true;
    return bool1;
  }
  
  private final boolean h(String paramString, X509Certificate paramX509Certificate)
  {
    paramString = m9.f.a(paramString);
    paramX509Certificate = c(paramX509Certificate, 7);
    boolean bool1 = paramX509Certificate instanceof Collection;
    boolean bool2 = false;
    if ((bool1) && (paramX509Certificate.isEmpty())) {
      return false;
    }
    paramX509Certificate = paramX509Certificate.iterator();
    do
    {
      bool1 = bool2;
      if (!paramX509Certificate.hasNext()) {
        break;
      }
    } while (!a9.f.a(paramString, m9.f.a((String)paramX509Certificate.next())));
    bool1 = true;
    return bool1;
  }
  
  public final List<String> a(X509Certificate paramX509Certificate)
  {
    a9.f.f(paramX509Certificate, "certificate");
    return p8.l.D(c(paramX509Certificate, 7), c(paramX509Certificate, 2));
  }
  
  public final boolean e(String paramString, X509Certificate paramX509Certificate)
  {
    a9.f.f(paramString, "host");
    a9.f.f(paramX509Certificate, "certificate");
    if (e.a(paramString)) {
      return h(paramString, paramX509Certificate);
    }
    return g(paramString, paramX509Certificate);
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    a9.f.f(paramString, "host");
    a9.f.f(paramSSLSession, "session");
    if (!d(paramString)) {
      return false;
    }
    try
    {
      paramSSLSession = paramSSLSession.getPeerCertificates()[0];
      if (paramSSLSession != null) {
        return e(paramString, (X509Certificate)paramSSLSession);
      }
      throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    }
    catch (SSLException paramString) {}
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x9.d
 * JD-Core Version:    0.7.0.1
 */