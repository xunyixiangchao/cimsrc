package c9;

public final class f
  extends d
{
  public static final a e = new a(null);
  private static final f f = new f(1L, 0L);
  
  public f(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2, 1L);
  }
  
  public boolean d(long paramLong)
  {
    return (a() <= paramLong) && (paramLong <= b());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof f)) {
      if ((!isEmpty()) || (!((f)paramObject).isEmpty()))
      {
        long l = a();
        paramObject = (f)paramObject;
        if ((l != paramObject.a()) || (b() != paramObject.b())) {}
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
    return (int)(31 * (a() ^ a() >>> 32) + (b() ^ b() >>> 32));
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
  
  public static final class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c9.f
 * JD-Core Version:    0.7.0.1
 */