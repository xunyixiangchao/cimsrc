package c9;

import b9.a;
import p8.b0;
import v8.c;

public class d
  implements Iterable<Long>, a
{
  public static final a d = new a(null);
  private final long a;
  private final long b;
  private final long c;
  
  public d(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 != 0L)
    {
      if (paramLong3 != -9223372036854775808L)
      {
        this.a = paramLong1;
        this.b = c.d(paramLong1, paramLong2, paramLong3);
        this.c = paramLong3;
        return;
      }
      throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    }
    throw new IllegalArgumentException("Step must be non-zero.");
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public b0 c()
  {
    return new e(this.a, this.b, this.c);
  }
  
  public static final class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c9.d
 * JD-Core Version:    0.7.0.1
 */