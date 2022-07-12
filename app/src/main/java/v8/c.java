package v8;

public final class c
{
  private static final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return e(e(paramInt1, paramInt3) - e(paramInt2, paramInt3), paramInt3);
  }
  
  private static final long b(long paramLong1, long paramLong2, long paramLong3)
  {
    return f(f(paramLong1, paramLong3) - f(paramLong2, paramLong3), paramLong3);
  }
  
  public static final int c(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      if (paramInt1 >= paramInt2) {
        return paramInt2;
      }
      return paramInt2 - a(paramInt2, paramInt1, paramInt3);
    }
    if (paramInt3 < 0)
    {
      if (paramInt1 <= paramInt2) {
        return paramInt2;
      }
      return paramInt2 + a(paramInt1, paramInt2, -paramInt3);
    }
    throw new IllegalArgumentException("Step is zero.");
  }
  
  public static final long d(long paramLong1, long paramLong2, long paramLong3)
  {
    boolean bool = paramLong3 < 0L;
    if (bool)
    {
      if (paramLong1 >= paramLong2) {
        return paramLong2;
      }
      return paramLong2 - b(paramLong2, paramLong1, paramLong3);
    }
    if (bool)
    {
      if (paramLong1 <= paramLong2) {
        return paramLong2;
      }
      return paramLong2 + b(paramLong1, paramLong2, -paramLong3);
    }
    throw new IllegalArgumentException("Step is zero.");
  }
  
  private static final int e(int paramInt1, int paramInt2)
  {
    paramInt1 %= paramInt2;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return paramInt1 + paramInt2;
  }
  
  private static final long f(long paramLong1, long paramLong2)
  {
    paramLong1 %= paramLong2;
    if (paramLong1 >= 0L) {
      return paramLong1;
    }
    return paramLong1 + paramLong2;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v8.c
 * JD-Core Version:    0.7.0.1
 */