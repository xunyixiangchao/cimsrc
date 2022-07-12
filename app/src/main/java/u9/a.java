package u9;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.security.NetworkSecurityPolicy;
import android.util.CloseGuard;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import l9.c0;
import p8.l;
import v9.b;
import v9.b.a;
import v9.f.a;
import v9.g;
import v9.g.b;
import v9.h.b;
import v9.i;
import v9.j;
import x9.c;

public final class a
  extends h
{
  public static final a e = new a(null);
  private static final boolean f;
  private final List<j> d;
  
  static
  {
    boolean bool;
    if ((h.a.h()) && (Build.VERSION.SDK_INT >= 29)) {
      bool = true;
    } else {
      bool = false;
    }
    f = bool;
  }
  
  public a()
  {
    Object localObject1 = l.l(new j[] { v9.a.a.a(), new i(v9.f.f.d()), new i(v9.h.a.a()), new i(g.a.a()) });
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((j)localObject2).c()) {
        localArrayList.add(localObject2);
      }
    }
    this.d = localArrayList;
  }
  
  public c c(X509TrustManager paramX509TrustManager)
  {
    a9.f.f(paramX509TrustManager, "trustManager");
    b localb = b.d.a(paramX509TrustManager);
    Object localObject = localb;
    if (localb == null) {
      localObject = super.c(paramX509TrustManager);
    }
    return localObject;
  }
  
  public void e(SSLSocket paramSSLSocket, String paramString, List<? extends c0> paramList)
  {
    a9.f.f(paramSSLSocket, "sslSocket");
    a9.f.f(paramList, "protocols");
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((j)localObject).a(paramSSLSocket)) {
        break label62;
      }
    }
    Object localObject = null;
    label62:
    localObject = (j)localObject;
    if (localObject == null) {
      return;
    }
    ((j)localObject).d(paramSSLSocket, paramString, paramList);
  }
  
  public String g(SSLSocket paramSSLSocket)
  {
    a9.f.f(paramSSLSocket, "sslSocket");
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((j)localObject).a(paramSSLSocket)) {
        break label50;
      }
    }
    Object localObject = null;
    label50:
    localObject = (j)localObject;
    if (localObject == null) {
      return null;
    }
    return ((j)localObject).b(paramSSLSocket);
  }
  
  public Object h(String paramString)
  {
    a9.f.f(paramString, "closer");
    if (Build.VERSION.SDK_INT >= 30)
    {
      CloseGuard localCloseGuard = new CloseGuard();
      localCloseGuard.open(paramString);
      return localCloseGuard;
    }
    return super.h(paramString);
  }
  
  @SuppressLint({"NewApi"})
  public boolean i(String paramString)
  {
    a9.f.f(paramString, "hostname");
    return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(paramString);
  }
  
  public void l(String paramString, Object paramObject)
  {
    a9.f.f(paramString, "message");
    if (Build.VERSION.SDK_INT >= 30)
    {
      Objects.requireNonNull(paramObject, "null cannot be cast to non-null type android.util.CloseGuard");
      ((CloseGuard)paramObject).warnIfOpen();
      return;
    }
    super.l(paramString, paramObject);
  }
  
  public static final class a
  {
    public final h a()
    {
      if (b()) {
        return new a();
      }
      return null;
    }
    
    public final boolean b()
    {
      return a.p();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u9.a
 * JD-Core Version:    0.7.0.1
 */