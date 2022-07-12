package v9;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import u9.h;
import u9.h.a;

public final class k
  extends f
{
  public static final a j = new a(null);
  private final Class<? super SSLSocketFactory> h;
  private final Class<?> i;
  
  public k(Class<? super SSLSocket> paramClass, Class<? super SSLSocketFactory> paramClass1, Class<?> paramClass2)
  {
    super(paramClass);
    this.h = paramClass1;
    this.i = paramClass2;
  }
  
  public static final class a
  {
    public final j a(String paramString)
    {
      a9.f.f(paramString, "packageName");
      try
      {
        Class localClass1 = Class.forName(a9.f.m(paramString, ".OpenSSLSocketImpl"));
        Class localClass2 = Class.forName(a9.f.m(paramString, ".OpenSSLSocketFactoryImpl"));
        paramString = Class.forName(a9.f.m(paramString, ".SSLParametersImpl"));
        a9.f.e(paramString, "paramsClass");
        paramString = new k(localClass1, localClass2, paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        h.a.g().j("unable to load android socket classes", 5, paramString);
      }
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v9.k
 * JD-Core Version:    0.7.0.1
 */