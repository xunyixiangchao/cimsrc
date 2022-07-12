package x0;

public class d<F, S>
{
  public final F a;
  public final S b;
  
  public d(F paramF, S paramS)
  {
    this.a = paramF;
    this.b = paramS;
  }
  
  public static <A, B> d<A, B> a(A paramA, B paramB)
  {
    return new d(paramA, paramB);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof d;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (d)paramObject;
    bool1 = bool2;
    if (c.a(paramObject.a, this.a))
    {
      bool1 = bool2;
      if (c.a(paramObject.b, this.b)) {
        bool1 = true;
      }
    }
    return bool1;
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
    return i ^ j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Pair{");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x0.d
 * JD-Core Version:    0.7.0.1
 */