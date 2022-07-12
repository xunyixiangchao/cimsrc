package o8;

import a9.f;
import java.io.Serializable;

public final class h<A, B>
  implements Serializable
{
  private final A a;
  private final B b;
  
  public h(A paramA, B paramB)
  {
    this.a = paramA;
    this.b = paramB;
  }
  
  public final A a()
  {
    return this.a;
  }
  
  public final B b()
  {
    return this.b;
  }
  
  public final A c()
  {
    return this.a;
  }
  
  public final B d()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof h)) {
      return false;
    }
    paramObject = (h)paramObject;
    if (!f.a(this.a, paramObject.a)) {
      return false;
    }
    return f.a(this.b, paramObject.b);
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o8.h
 * JD-Core Version:    0.7.0.1
 */