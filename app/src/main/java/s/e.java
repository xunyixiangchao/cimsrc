package s;

import java.util.Objects;

final class e
  extends c1
{
  private final Object a;
  
  e(Object paramObject)
  {
    Objects.requireNonNull(paramObject, "Null value");
    this.a = paramObject;
  }
  
  public Object b()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof c1))
    {
      paramObject = (c1)paramObject;
      return this.a.equals(paramObject.b());
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() ^ 0xF4243;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Identifier{value=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.e
 * JD-Core Version:    0.7.0.1
 */