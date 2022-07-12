package u9;

import f9.l;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import l9.c0;

public class f
  extends h
{
  public static final a d;
  private static final boolean e;
  private static final Integer f;
  
  static
  {
    Integer localInteger = null;
    d = new a(null);
    String str = System.getProperty("java.specification.version");
    if (str != null) {
      localInteger = l.f(str);
    }
    f = localInteger;
    boolean bool = true;
    if (localInteger != null) {
      if (localInteger.intValue() >= 9) {
        break label70;
      }
    }
    for (;;)
    {
      bool = false;
      try
      {
        SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
        label70:
        e = bool;
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}
    }
  }
  
  public void e(SSLSocket paramSSLSocket, String paramString, List<c0> paramList)
  {
    a9.f.f(paramSSLSocket, "sslSocket");
    a9.f.f(paramList, "protocols");
    paramString = paramSSLSocket.getSSLParameters();
    paramList = h.a.b(paramList).toArray(new String[0]);
    Objects.requireNonNull(paramList, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    paramString.setApplicationProtocols((String[])paramList);
    paramSSLSocket.setSSLParameters(paramString);
  }
  
  public String g(SSLSocket paramSSLSocket)
  {
    a9.f.f(paramSSLSocket, "sslSocket");
    try
    {
      paramSSLSocket = paramSSLSocket.getApplicationProtocol();
      boolean bool;
      if (paramSSLSocket == null) {
        bool = true;
      } else {
        bool = a9.f.a(paramSSLSocket, "");
      }
      if (bool) {
        return null;
      }
      return paramSSLSocket;
    }
    catch (UnsupportedOperationException paramSSLSocket) {}
    return null;
  }
  
  public SSLContext m()
  {
    Object localObject = f;
    if ((localObject != null) && (((Integer)localObject).intValue() >= 9)) {
      localObject = SSLContext.getInstance("TLS");
    }
    for (String str = "getInstance(\"TLS\")";; str = "try {\n          // Based…Instance(\"TLS\")\n        }")
    {
      a9.f.e(localObject, str);
      return localObject;
      try
      {
        localObject = SSLContext.getInstance("TLSv1.3");
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        label42:
        break label42;
      }
      localObject = SSLContext.getInstance("TLS");
    }
  }
  
  public static final class a
  {
    public final f a()
    {
      if (b()) {
        return new f();
      }
      return null;
    }
    
    public final boolean b()
    {
      return f.p();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u9.f
 * JD-Core Version:    0.7.0.1
 */