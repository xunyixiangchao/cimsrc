package c9;

import java.util.NoSuchElementException;
import p8.b0;

public final class e
  extends b0
{
  private final long a;
  private final long b;
  private boolean c;
  private long d;
  
  public e(long paramLong1, long paramLong2, long paramLong3)
  {
    this.a = paramLong3;
    this.b = paramLong2;
    boolean bool = true;
    if (paramLong3 > 0L ? paramLong1 > paramLong2 : paramLong1 < paramLong2) {
      bool = false;
    }
    this.c = bool;
    if (!bool) {
      paramLong1 = paramLong2;
    }
    this.d = paramLong1;
  }
  
  public long a()
  {
    long l = this.d;
    if (l == this.b)
    {
      if (this.c)
      {
        this.c = false;
        return l;
      }
      throw new NoSuchElementException();
    }
    this.d = (this.a + l);
    return l;
  }
  
  public boolean hasNext()
  {
    return this.c;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c9.e
 * JD-Core Version:    0.7.0.1
 */