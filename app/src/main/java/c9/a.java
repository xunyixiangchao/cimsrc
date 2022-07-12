package c9;

import p8.a0;
import v8.c;

public class a
  implements Iterable<Integer>, b9.a
{
  public static final a d = new a(null);
  private final int a;
  private final int b;
  private final int c;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 0)
    {
      if (paramInt3 != -2147483648)
      {
        this.a = paramInt1;
        this.b = c.c(paramInt1, paramInt2, paramInt3);
        this.c = paramInt3;
        return;
      }
      throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }
    throw new IllegalArgumentException("Step must be non-zero.");
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public a0 d()
  {
    return new b(this.a, this.b, this.c);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      if ((!isEmpty()) || (!((a)paramObject).isEmpty()))
      {
        int i = this.a;
        paramObject = (a)paramObject;
        if ((i != paramObject.a) || (this.b != paramObject.b) || (this.c != paramObject.c)) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return (this.a * 31 + this.b) * 31 + this.c;
  }
  
  public boolean isEmpty()
  {
    if (this.c > 0)
    {
      if (this.a > this.b) {
        return true;
      }
    }
    else if (this.a < this.b) {
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    int i;
    if (this.c > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("..");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" step ");
      i = this.c;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(" downTo ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" step ");
      i = -this.c;
    }
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public final a a(int paramInt1, int paramInt2, int paramInt3)
    {
      return new a(paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c9.a
 * JD-Core Version:    0.7.0.1
 */