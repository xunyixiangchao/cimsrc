package v9;

import f9.d;
import f9.l;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import l9.c0;
import u9.b;
import u9.b.a;
import u9.h;
import u9.h.a;

public class f
  implements j
{
  public static final a f;
  private static final i.a g;
  private final Class<? super SSLSocket> a;
  private final Method b;
  private final Method c;
  private final Method d;
  private final Method e;
  
  static
  {
    a locala = new a(null);
    f = locala;
    g = locala.c("com.google.android.gms.org.conscrypt");
  }
  
  public f(Class<? super SSLSocket> paramClass)
  {
    this.a = paramClass;
    Method localMethod = paramClass.getDeclaredMethod("setUseSessionTickets", new Class[] { Boolean.TYPE });
    a9.f.e(localMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
    this.b = localMethod;
    this.c = paramClass.getMethod("setHostname", new Class[] { String.class });
    this.d = paramClass.getMethod("getAlpnSelectedProtocol", new Class[0]);
    this.e = paramClass.getMethod("setAlpnProtocols", new Class[] { [B.class });
  }
  
  public boolean a(SSLSocket paramSSLSocket)
  {
    a9.f.f(paramSSLSocket, "sslSocket");
    return this.a.isInstance(paramSSLSocket);
  }
  
  public String b(SSLSocket paramSSLSocket)
  {
    a9.f.f(paramSSLSocket, "sslSocket");
    if (!a(paramSSLSocket)) {
      return null;
    }
    try
    {
      paramSSLSocket = (byte[])this.d.invoke(paramSSLSocket, new Object[0]);
      if (paramSSLSocket == null) {
        return null;
      }
      paramSSLSocket = new String(paramSSLSocket, d.b);
      return paramSSLSocket;
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      throw new AssertionError(paramSSLSocket);
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError(paramSSLSocket);
    }
    catch (NullPointerException paramSSLSocket)
    {
      if (a9.f.a(paramSSLSocket.getMessage(), "ssl == null")) {
        return null;
      }
      throw paramSSLSocket;
    }
  }
  
  public boolean c()
  {
    return b.e.b();
  }
  
  public void d(SSLSocket paramSSLSocket, String paramString, List<? extends c0> paramList)
  {
    a9.f.f(paramSSLSocket, "sslSocket");
    a9.f.f(paramList, "protocols");
    if (a(paramSSLSocket)) {
      try
      {
        this.b.invoke(paramSSLSocket, new Object[] { Boolean.TRUE });
        if (paramString != null) {
          this.c.invoke(paramSSLSocket, new Object[] { paramString });
        }
        this.e.invoke(paramSSLSocket, new Object[] { h.a.c(paramList) });
        return;
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
    }
  }
  
  public static final class a
  {
    private final f b(Class<? super SSLSocket> paramClass)
    {
      Object localObject = paramClass;
      while ((localObject != null) && (!a9.f.a(((Class)localObject).getSimpleName(), "OpenSSLSocketImpl")))
      {
        localObject = ((Class)localObject).getSuperclass();
        if (localObject == null) {
          throw new AssertionError(a9.f.m("No OpenSSLSocketImpl superclass of socket of type ", paramClass));
        }
      }
      a9.f.c(localObject);
      return new f((Class)localObject);
    }
    
    public final i.a c(String paramString)
    {
      a9.f.f(paramString, "packageName");
      return new a(paramString);
    }
    
    public final i.a d()
    {
      return f.e();
    }
    
    public static final class a
      implements i.a
    {
      a(String paramString) {}
      
      public boolean a(SSLSocket paramSSLSocket)
      {
        a9.f.f(paramSSLSocket, "sslSocket");
        paramSSLSocket = paramSSLSocket.getClass().getName();
        a9.f.e(paramSSLSocket, "sslSocket.javaClass.name");
        return l.x(paramSSLSocket, a9.f.m(this.a, "."), false, 2, null);
      }
      
      public j b(SSLSocket paramSSLSocket)
      {
        a9.f.f(paramSSLSocket, "sslSocket");
        return f.a.a(f.f, paramSSLSocket.getClass());
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v9.f
 * JD-Core Version:    0.7.0.1
 */