package x9;

import a9.f;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public final class b
  implements e
{
  private final Map<X500Principal, Set<X509Certificate>> a;
  
  public b(X509Certificate... paramVarArgs)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      X509Certificate localX509Certificate = paramVarArgs[i];
      i += 1;
      X500Principal localX500Principal = localX509Certificate.getSubjectX500Principal();
      f.e(localX500Principal, "caCert.subjectX500Principal");
      Object localObject2 = localLinkedHashMap.get(localX500Principal);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedHashSet();
        localLinkedHashMap.put(localX500Principal, localObject1);
      }
      ((Set)localObject1).add(localX509Certificate);
    }
    this.a = localLinkedHashMap;
  }
  
  public X509Certificate a(X509Certificate paramX509Certificate)
  {
    f.f(paramX509Certificate, "cert");
    Object localObject1 = paramX509Certificate.getIssuerX500Principal();
    localObject1 = (Set)this.a.get(localObject1);
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    Iterator localIterator = ((Iterable)localObject1).iterator();
    label83:
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = localIterator.next();
      X509Certificate localX509Certificate = (X509Certificate)localObject1;
      try
      {
        paramX509Certificate.verify(localX509Certificate.getPublicKey());
        i = 1;
      }
      catch (Exception localException)
      {
        int i;
        break label83;
      }
      i = 0;
    } while (i == 0);
    return (X509Certificate)localObject1;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof b)) && (f.a(((b)paramObject).a, this.a)));
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x9.b
 * JD-Core Version:    0.7.0.1
 */