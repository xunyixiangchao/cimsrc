package l3;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import i3.e;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import l9.b0;
import l9.b0.a;
import l9.d0;
import l9.d0.a;
import l9.f0;
import l9.y;
import l9.y.a;
import y9.a;
import y9.a.a;
import y9.a.b;

public class g
{
  static X509TrustManager a = new a();
  
  public static b0 b()
  {
    b0.a locala = new b0.a();
    TimeUnit localTimeUnit = TimeUnit.SECONDS;
    return locala.d(10L, localTimeUnit).L(10L, localTimeUnit).V(10L, localTimeUnit).a(new d(null)).a(new b(null)).a(new c(a.a.c, null)).c();
  }
  
  public static b0 c()
  {
    try
    {
      Object localObject1 = SSLContext.getInstance("SSL");
      Object localObject2 = a;
      Object localObject3 = new SecureRandom();
      ((SSLContext)localObject1).init(null, new TrustManager[] { localObject2 }, (SecureRandom)localObject3);
      localObject2 = new b0.a();
      localObject3 = TimeUnit.SECONDS;
      localObject1 = ((b0.a)localObject2).d(5L, (TimeUnit)localObject3).L(5L, (TimeUnit)localObject3).V(5L, (TimeUnit)localObject3).U(((SSLContext)localObject1).getSocketFactory(), a).a(new d(null)).a(new b(null)).a(new c(null)).K(f.a).c();
      return localObject1;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
  
  class a
    implements X509TrustManager
  {
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return new X509Certificate[0];
    }
  }
  
  private static class b
    implements y
  {
    public f0 a(y.a parama)
    {
      return parama.a(parama.h().h().a("x-app-type", String.valueOf(0)).a("x-app-version", String.valueOf(330)).a("x-app-language", Resources.getSystem().getConfiguration().locale.toString()).b());
    }
  }
  
  private static class c
    implements y, a.b
  {
    private final a a;
    
    private c()
    {
      this(a.a.d);
    }
    
    private c(a.a parama)
    {
      a locala = new a(this);
      this.a = locala;
      locala.e(parama);
    }
    
    public f0 a(y.a parama)
    {
      return parama.a(parama.h());
    }
    
    public void b(String paramString)
    {
      Log.i("OkHttp", paramString);
    }
  }
  
  private static class d
    implements y
  {
    public f0 a(y.a parama)
    {
      Object localObject = e.e();
      if (localObject == null) {}
      for (localObject = parama.h();; localObject = parama.h().h().a("access-token", (String)localObject).b()) {
        return parama.a((d0)localObject);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l3.g
 * JD-Core Version:    0.7.0.1
 */