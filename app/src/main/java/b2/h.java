package b2;

import g0.a;
import java.security.MessageDigest;
import x2.b;

public final class h
  implements f
{
  private final a<g<?>, Object> b = new b();
  
  private static <T> void f(g<T> paramg, Object paramObject, MessageDigest paramMessageDigest)
  {
    paramg.g(paramObject, paramMessageDigest);
  }
  
  public void b(MessageDigest paramMessageDigest)
  {
    int i = 0;
    while (i < this.b.size())
    {
      f((g)this.b.i(i), this.b.m(i), paramMessageDigest);
      i += 1;
    }
  }
  
  public <T> T c(g<T> paramg)
  {
    if (this.b.containsKey(paramg)) {
      return this.b.get(paramg);
    }
    return paramg.c();
  }
  
  public void d(h paramh)
  {
    this.b.j(paramh.b);
  }
  
  public <T> h e(g<T> paramg, T paramT)
  {
    this.b.put(paramg, paramT);
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof h))
    {
      paramObject = (h)paramObject;
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Options{values=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b2.h
 * JD-Core Version:    0.7.0.1
 */