package c9;

public final class c
  extends a
{
  public static final a e = new a(null);
  private static final c f = new c(1, 0);
  
  public c(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof c)) {
      if ((!isEmpty()) || (!((c)paramObject).isEmpty()))
      {
        int i = a();
        paramObject = (c)paramObject;
        if ((i != paramObject.a()) || (b() != paramObject.b())) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public boolean f(int paramInt)
  {
    return (a() <= paramInt) && (paramInt <= b());
  }
  
  public Integer g()
  {
    return Integer.valueOf(b());
  }
  
  public Integer h()
  {
    return Integer.valueOf(a());
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return a() * 31 + b();
  }
  
  public boolean isEmpty()
  {
    return a() > b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("..");
    localStringBuilder.append(b());
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public final c a()
    {
      return c.e();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c9.c
 * JD-Core Version:    0.7.0.1
 */