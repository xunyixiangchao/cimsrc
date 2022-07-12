package b2;

import java.security.MessageDigest;
import x2.k;

public final class g<T>
{
  private static final b<Object> e = new a();
  private final T a;
  private final b<T> b;
  private final String c;
  private volatile byte[] d;
  
  private g(String paramString, T paramT, b<T> paramb)
  {
    this.c = k.b(paramString);
    this.a = paramT;
    this.b = ((b)k.d(paramb));
  }
  
  public static <T> g<T> a(String paramString, T paramT, b<T> paramb)
  {
    return new g(paramString, paramT, paramb);
  }
  
  private static <T> b<T> b()
  {
    return e;
  }
  
  private byte[] d()
  {
    if (this.d == null) {
      this.d = this.c.getBytes(f.a);
    }
    return this.d;
  }
  
  public static <T> g<T> e(String paramString)
  {
    return new g(paramString, null, b());
  }
  
  public static <T> g<T> f(String paramString, T paramT)
  {
    return new g(paramString, paramT, b());
  }
  
  public T c()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof g))
    {
      paramObject = (g)paramObject;
      return this.c.equals(paramObject.c);
    }
    return false;
  }
  
  public void g(T paramT, MessageDigest paramMessageDigest)
  {
    this.b.a(d(), paramT, paramMessageDigest);
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Option{key='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  class a
    implements g.b<Object>
  {
    public void a(byte[] paramArrayOfByte, Object paramObject, MessageDigest paramMessageDigest) {}
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(byte[] paramArrayOfByte, T paramT, MessageDigest paramMessageDigest);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b2.g
 * JD-Core Version:    0.7.0.1
 */