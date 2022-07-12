package o8;

import a9.f;
import java.io.Serializable;

public final class i<T>
  implements Serializable
{
  public static final a a = new a(null);
  
  public static <T> Object a(Object paramObject)
  {
    return paramObject;
  }
  
  public static final class a {}
  
  public static final class b
    implements Serializable
  {
    public final Throwable a;
    
    public b(Throwable paramThrowable)
    {
      this.a = paramThrowable;
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof b)) && (f.a(this.a, ((b)paramObject).a));
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failure(");
      localStringBuilder.append(this.a);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o8.i
 * JD-Core Version:    0.7.0.1
 */