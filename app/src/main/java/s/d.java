package s;

import java.util.Objects;

final class d<T>
  extends s0.a<T>
{
  private final String a;
  private final Class<T> b;
  private final Object c;
  
  d(String paramString, Class<T> paramClass, Object paramObject)
  {
    Objects.requireNonNull(paramString, "Null id");
    this.a = paramString;
    Objects.requireNonNull(paramClass, "Null valueClass");
    this.b = paramClass;
    this.c = paramObject;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public Object d()
  {
    return this.c;
  }
  
  public Class<T> e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof s0.a))
    {
      Object localObject = (s0.a)paramObject;
      if ((this.a.equals(((s0.a)localObject).c())) && (this.b.equals(((s0.a)localObject).e())))
      {
        paramObject = this.c;
        localObject = ((s0.a)localObject).d();
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
    int k = this.b.hashCode();
    Object localObject = this.c;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    return ((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Option{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", valueClass=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", token=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.d
 * JD-Core Version:    0.7.0.1
 */