package aa;

import a9.f;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class y
{
  public static final b d = new b(null);
  public static final y e = new a();
  private boolean a;
  private long b;
  private long c;
  
  public y a()
  {
    this.a = false;
    return this;
  }
  
  public y b()
  {
    this.c = 0L;
    return this;
  }
  
  public long c()
  {
    if (this.a) {
      return this.b;
    }
    throw new IllegalStateException("No deadline".toString());
  }
  
  public y d(long paramLong)
  {
    this.a = true;
    this.b = paramLong;
    return this;
  }
  
  public boolean e()
  {
    return this.a;
  }
  
  public void f()
  {
    if (!Thread.currentThread().isInterrupted())
    {
      if (this.a)
      {
        if (this.b - System.nanoTime() > 0L) {
          return;
        }
        throw new InterruptedIOException("deadline reached");
      }
      return;
    }
    throw new InterruptedIOException("interrupted");
  }
  
  public y g(long paramLong, TimeUnit paramTimeUnit)
  {
    f.f(paramTimeUnit, "unit");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.c = paramTimeUnit.toNanos(paramLong);
      return this;
    }
    throw new IllegalArgumentException(f.m("timeout < 0: ", Long.valueOf(paramLong)).toString());
  }
  
  public long h()
  {
    return this.c;
  }
  
  public static final class a
    extends y
  {
    public y d(long paramLong)
    {
      return this;
    }
    
    public void f() {}
    
    public y g(long paramLong, TimeUnit paramTimeUnit)
    {
      f.f(paramTimeUnit, "unit");
      return this;
    }
  }
  
  public static final class b {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.y
 * JD-Core Version:    0.7.0.1
 */