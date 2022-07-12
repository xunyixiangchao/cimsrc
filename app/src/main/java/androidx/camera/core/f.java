package androidx.camera.core;

import java.util.Objects;

final class f
  extends u
{
  private final u.b a;
  private final u.a b;
  
  f(u.b paramb, u.a parama)
  {
    Objects.requireNonNull(paramb, "Null type");
    this.a = paramb;
    this.b = parama;
  }
  
  public u.a c()
  {
    return this.b;
  }
  
  public u.b d()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof u))
    {
      Object localObject = (u)paramObject;
      if (this.a.equals(((u)localObject).d()))
      {
        paramObject = this.b;
        localObject = ((u)localObject).c();
        if (paramObject == null)
        {
          if (localObject == null) {
            return true;
          }
        }
        else if (paramObject.equals(localObject)) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.a.hashCode();
    u.a locala = this.b;
    int i;
    if (locala == null) {
      i = 0;
    } else {
      i = locala.hashCode();
    }
    return (j ^ 0xF4243) * 1000003 ^ i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraState{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", error=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.f
 * JD-Core Version:    0.7.0.1
 */