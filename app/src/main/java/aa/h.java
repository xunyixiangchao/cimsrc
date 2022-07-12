package aa;

import a9.f;
import java.util.concurrent.TimeUnit;

public class h
  extends y
{
  private y f;
  
  public h(y paramy)
  {
    this.f = paramy;
  }
  
  public y a()
  {
    return this.f.a();
  }
  
  public y b()
  {
    return this.f.b();
  }
  
  public long c()
  {
    return this.f.c();
  }
  
  public y d(long paramLong)
  {
    return this.f.d(paramLong);
  }
  
  public boolean e()
  {
    return this.f.e();
  }
  
  public void f()
  {
    this.f.f();
  }
  
  public y g(long paramLong, TimeUnit paramTimeUnit)
  {
    f.f(paramTimeUnit, "unit");
    return this.f.g(paramLong, paramTimeUnit);
  }
  
  public final y i()
  {
    return this.f;
  }
  
  public final h j(y paramy)
  {
    f.f(paramy, "delegate");
    this.f = paramy;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.h
 * JD-Core Version:    0.7.0.1
 */