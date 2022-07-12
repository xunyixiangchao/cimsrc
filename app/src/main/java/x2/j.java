package x2;

public class j
{
  private Class<?> a;
  private Class<?> b;
  private Class<?> c;
  
  public j() {}
  
  public j(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3)
  {
    a(paramClass1, paramClass2, paramClass3);
  }
  
  public void a(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3)
  {
    this.a = paramClass1;
    this.b = paramClass2;
    this.c = paramClass3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (j)paramObject;
      if (!this.a.equals(paramObject.a)) {
        return false;
      }
      if (!this.b.equals(paramObject.b)) {
        return false;
      }
      return l.d(this.c, paramObject.c);
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.a.hashCode();
    int k = this.b.hashCode();
    Class localClass = this.c;
    int i;
    if (localClass != null) {
      i = localClass.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiClassKey{first=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", second=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x2.j
 * JD-Core Version:    0.7.0.1
 */