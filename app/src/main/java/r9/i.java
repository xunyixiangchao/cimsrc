package r9;

import a9.f;
import java.net.Proxy.Type;
import l9.d0;
import l9.x;

public final class i
{
  public static final i a = new i();
  
  private final boolean b(d0 paramd0, Proxy.Type paramType)
  {
    return (!paramd0.f()) && (paramType == Proxy.Type.HTTP);
  }
  
  public final String a(d0 paramd0, Proxy.Type paramType)
  {
    f.f(paramd0, "request");
    f.f(paramType, "proxyType");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramd0.g());
    localStringBuilder.append(' ');
    i locali = a;
    boolean bool = locali.b(paramd0, paramType);
    paramd0 = paramd0.j();
    if (bool) {
      localStringBuilder.append(paramd0);
    } else {
      localStringBuilder.append(locali.c(paramd0));
    }
    localStringBuilder.append(" HTTP/1.1");
    paramd0 = localStringBuilder.toString();
    f.e(paramd0, "StringBuilder().apply(builderAction).toString()");
    return paramd0;
  }
  
  public final String c(x paramx)
  {
    f.f(paramx, "url");
    String str1 = paramx.d();
    String str2 = paramx.f();
    paramx = str1;
    if (str2 != null)
    {
      paramx = new StringBuilder();
      paramx.append(str1);
      paramx.append('?');
      paramx.append(str2);
      paramx = paramx.toString();
    }
    return paramx;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r9.i
 * JD-Core Version:    0.7.0.1
 */