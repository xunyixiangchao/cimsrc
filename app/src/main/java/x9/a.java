package x9;

import a9.f;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class a
  extends c
{
  public static final a c = new a(null);
  private final e b;
  
  public a(e parame)
  {
    this.b = parame;
  }
  
  private final boolean b(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2, int paramInt)
  {
    if (!f.a(paramX509Certificate1.getIssuerDN(), paramX509Certificate2.getSubjectDN())) {
      return false;
    }
    if (paramX509Certificate2.getBasicConstraints() < paramInt) {
      return false;
    }
    try
    {
      paramX509Certificate1.verify(paramX509Certificate2.getPublicKey());
      return true;
    }
    catch (GeneralSecurityException paramX509Certificate1) {}
    return false;
  }
  
  public List<Certificate> a(List<? extends Certificate> paramList, String paramString)
  {
    f.f(paramList, "chain");
    f.f(paramString, "hostname");
    paramList = new ArrayDeque(paramList);
    paramString = new ArrayList();
    Object localObject1 = paramList.removeFirst();
    f.e(localObject1, "queue.removeFirst()");
    paramString.add(localObject1);
    int j = 0;
    int i = 0;
    while (j < 9)
    {
      j += 1;
      localObject1 = (X509Certificate)paramString.get(paramString.size() - 1);
      Object localObject2 = this.b.a((X509Certificate)localObject1);
      if (localObject2 != null)
      {
        if ((paramString.size() > 1) || (!f.a(localObject1, localObject2))) {
          paramString.add(localObject2);
        }
        if (b((X509Certificate)localObject2, (X509Certificate)localObject2, paramString.size() - 2)) {
          return paramString;
        }
        i = 1;
      }
      else
      {
        localObject2 = paramList.iterator();
        f.e(localObject2, "queue.iterator()");
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = ((Iterator)localObject2).next();
            Objects.requireNonNull(localObject3, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            localObject3 = (X509Certificate)localObject3;
            if (b((X509Certificate)localObject1, (X509Certificate)localObject3, paramString.size() - 1))
            {
              ((Iterator)localObject2).remove();
              paramString.add(localObject3);
              break;
            }
          }
        }
        if (i != 0) {
          return paramString;
        }
        throw new SSLPeerUnverifiedException(f.m("Failed to find a trusted cert that signed ", localObject1));
      }
    }
    throw new SSLPeerUnverifiedException(f.m("Certificate chain too long: ", paramString));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    return ((paramObject instanceof a)) && (f.a(((a)paramObject).b, this.b));
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public static final class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x9.a
 * JD-Core Version:    0.7.0.1
 */