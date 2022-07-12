package u9;

import a9.f;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import l9.c0;

public final class e
  extends h
{
  public static final b i = new b(null);
  private final Method d;
  private final Method e;
  private final Method f;
  private final Class<?> g;
  private final Class<?> h;
  
  public e(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
  {
    this.d = paramMethod1;
    this.e = paramMethod2;
    this.f = paramMethod3;
    this.g = paramClass1;
    this.h = paramClass2;
  }
  
  public void b(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "sslSocket");
    try
    {
      this.f.invoke(null, new Object[] { paramSSLSocket });
      return;
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      throw new AssertionError("failed to remove ALPN", paramSSLSocket);
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError("failed to remove ALPN", paramSSLSocket);
    }
  }
  
  public void e(SSLSocket paramSSLSocket, String paramString, List<? extends c0> paramList)
  {
    f.f(paramSSLSocket, "sslSocket");
    f.f(paramList, "protocols");
    Object localObject = h.a.b(paramList);
    try
    {
      paramString = h.class.getClassLoader();
      paramList = this.g;
      Class localClass = this.h;
      localObject = new a((List)localObject);
      paramString = Proxy.newProxyInstance(paramString, new Class[] { paramList, localClass }, (InvocationHandler)localObject);
      this.d.invoke(null, new Object[] { paramSSLSocket, paramString });
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError("failed to set ALPN", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      throw new AssertionError("failed to set ALPN", paramSSLSocket);
    }
  }
  
  public String g(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "sslSocket");
    try
    {
      paramSSLSocket = Proxy.getInvocationHandler(this.e.invoke(null, new Object[] { paramSSLSocket }));
      if (paramSSLSocket != null)
      {
        paramSSLSocket = (a)paramSSLSocket;
        if ((!paramSSLSocket.b()) && (paramSSLSocket.a() == null))
        {
          h.k(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
          return null;
        }
        if (paramSSLSocket.b()) {
          return null;
        }
        return paramSSLSocket.a();
      }
      throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError("failed to get ALPN selected protocol", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      throw new AssertionError("failed to get ALPN selected protocol", paramSSLSocket);
    }
  }
  
  private static final class a
    implements InvocationHandler
  {
    private final List<String> a;
    private boolean b;
    private String c;
    
    public a(List<String> paramList)
    {
      this.a = paramList;
    }
    
    public final String a()
    {
      return this.c;
    }
    
    public final boolean b()
    {
      return this.b;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      f.f(paramObject, "proxy");
      f.f(paramMethod, "method");
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = new Object[0];
      }
      paramArrayOfObject = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      if ((f.a(paramArrayOfObject, "supports")) && (f.a(Boolean.TYPE, localClass))) {
        return Boolean.TRUE;
      }
      if ((f.a(paramArrayOfObject, "unsupported")) && (f.a(Void.TYPE, localClass)))
      {
        this.b = true;
        return null;
      }
      int i;
      if (f.a(paramArrayOfObject, "protocols"))
      {
        if (paramObject.length == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return this.a;
        }
      }
      if (((f.a(paramArrayOfObject, "selectProtocol")) || (f.a(paramArrayOfObject, "select"))) && (f.a(String.class, localClass)) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = paramObject[0];
        Objects.requireNonNull(paramObject, "null cannot be cast to non-null type kotlin.collections.List<*>");
        paramObject = (List)paramObject;
        int j = paramObject.size();
        if (j >= 0)
        {
          i = 0;
          for (;;)
          {
            paramMethod = paramObject.get(i);
            Objects.requireNonNull(paramMethod, "null cannot be cast to non-null type kotlin.String");
            paramMethod = (String)paramMethod;
            if (this.a.contains(paramMethod))
            {
              this.c = paramMethod;
              return paramMethod;
            }
            if (i == j) {
              break;
            }
            i += 1;
          }
        }
        paramObject = (String)this.a.get(0);
        this.c = paramObject;
        return paramObject;
      }
      if (((f.a(paramArrayOfObject, "protocolSelected")) || (f.a(paramArrayOfObject, "selected"))) && (paramObject.length == 1))
      {
        paramObject = paramObject[0];
        Objects.requireNonNull(paramObject, "null cannot be cast to non-null type kotlin.String");
        this.c = ((String)paramObject);
        return null;
      }
      return paramMethod.invoke(this, Arrays.copyOf(paramObject, paramObject.length));
    }
  }
  
  public static final class b
  {
    public final h a()
    {
      Object localObject1 = System.getProperty("java.specification.version", "unknown");
      try
      {
        f.e(localObject1, "jvmVersion");
        int i = Integer.parseInt((String)localObject1);
        if (i >= 9) {
          return null;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          try
          {
            Object localObject2 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
            Object localObject3 = Class.forName(f.m("org.eclipse.jetty.alpn.ALPN", "$Provider"), true, null);
            localObject1 = Class.forName(f.m("org.eclipse.jetty.alpn.ALPN", "$ClientProvider"), true, null);
            Class localClass = Class.forName(f.m("org.eclipse.jetty.alpn.ALPN", "$ServerProvider"), true, null);
            localObject3 = ((Class)localObject2).getMethod("put", new Class[] { SSLSocket.class, localObject3 });
            Method localMethod = ((Class)localObject2).getMethod("get", new Class[] { SSLSocket.class });
            localObject2 = ((Class)localObject2).getMethod("remove", new Class[] { SSLSocket.class });
            f.e(localObject3, "putMethod");
            f.e(localMethod, "getMethod");
            f.e(localObject2, "removeMethod");
            f.e(localObject1, "clientProviderClass");
            f.e(localClass, "serverProviderClass");
            localObject1 = new e((Method)localObject3, localMethod, (Method)localObject2, (Class)localObject1, localClass);
            return localObject1;
          }
          catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException) {}
          localNumberFormatException = localNumberFormatException;
        }
      }
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u9.e
 * JD-Core Version:    0.7.0.1
 */