package l9;

import f9.l;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class h0
{
  private final a a;
  private final Proxy b;
  private final InetSocketAddress c;
  
  public h0(a parama, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    this.a = parama;
    this.b = paramProxy;
    this.c = paramInetSocketAddress;
  }
  
  public final a a()
  {
    return this.a;
  }
  
  public final Proxy b()
  {
    return this.b;
  }
  
  public final boolean c()
  {
    return (this.a.k() != null) && (this.b.type() == Proxy.Type.HTTP);
  }
  
  public final InetSocketAddress d()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof h0))
    {
      paramObject = (h0)paramObject;
      if ((a9.f.a(paramObject.a, this.a)) && (a9.f.a(paramObject.b, this.b)) && (a9.f.a(paramObject.c, this.c))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((527 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = a().l().i();
    Object localObject = d().getAddress();
    if (localObject == null) {}
    do
    {
      localObject = null;
      break;
      localObject = ((InetAddress)localObject).getHostAddress();
    } while (localObject == null);
    localObject = m9.f.a((String)localObject);
    if (l.B(str, ':', false, 2, null))
    {
      localStringBuilder.append("[");
      localStringBuilder.append(str);
      localStringBuilder.append("]");
    }
    else
    {
      localStringBuilder.append(str);
    }
    if ((a().l().n() != d().getPort()) || (a9.f.a(str, localObject)))
    {
      localStringBuilder.append(":");
      localStringBuilder.append(a().l().n());
    }
    if (!a9.f.a(str, localObject))
    {
      if (a9.f.a(b(), Proxy.NO_PROXY)) {
        str = " at ";
      } else {
        str = " via proxy ";
      }
      localStringBuilder.append(str);
      if (localObject == null)
      {
        localStringBuilder.append("<unresolved>");
      }
      else if (l.B((CharSequence)localObject, ':', false, 2, null))
      {
        localStringBuilder.append("[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("]");
      }
      else
      {
        localStringBuilder.append((String)localObject);
      }
      localStringBuilder.append(":");
      localStringBuilder.append(d().getPort());
    }
    localObject = localStringBuilder.toString();
    a9.f.e(localObject, "StringBuilder().apply(builderAction).toString()");
    return localObject;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.h0
 * JD-Core Version:    0.7.0.1
 */