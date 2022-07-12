package androidx.camera.core;

final class g
  extends u.a
{
  private final int a;
  private final Throwable b;
  
  g(int paramInt, Throwable paramThrowable)
  {
    this.a = paramInt;
    this.b = paramThrowable;
  }
  
  public Throwable c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof u.a))
    {
      Object localObject = (u.a)paramObject;
      if (this.a == ((u.a)localObject).d())
      {
        paramObject = this.b;
        localObject = ((u.a)localObject).c();
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
    int j = this.a;
    Throwable localThrowable = this.b;
    int i;
    if (localThrowable == null) {
      i = 0;
    } else {
      i = localThrowable.hashCode();
    }
    return (j ^ 0xF4243) * 1000003 ^ i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StateError{code=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", cause=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.g
 * JD-Core Version:    0.7.0.1
 */