package s;

import java.util.Objects;

final class h
  extends l2
{
  private final l2.b a;
  private final l2.a b;
  
  h(l2.b paramb, l2.a parama)
  {
    Objects.requireNonNull(paramb, "Null configType");
    this.a = paramb;
    Objects.requireNonNull(parama, "Null configSize");
    this.b = parama;
  }
  
  public l2.a b()
  {
    return this.b;
  }
  
  public l2.b c()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof l2))
    {
      paramObject = (l2)paramObject;
      return (this.a.equals(paramObject.c())) && (this.b.equals(paramObject.b()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SurfaceConfig{configType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", configSize=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.h
 * JD-Core Version:    0.7.0.1
 */