package m1;

import androidx.room.f0;
import java.util.concurrent.atomic.AtomicBoolean;
import p1.k;

public abstract class m
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  private final f0 b;
  private volatile k c;
  
  public m(f0 paramf0)
  {
    this.b = paramf0;
  }
  
  private k c()
  {
    String str = d();
    return this.b.g(str);
  }
  
  private k e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.c == null) {
        this.c = c();
      }
      return this.c;
    }
    return c();
  }
  
  public k a()
  {
    b();
    return e(this.a.compareAndSet(false, true));
  }
  
  protected void b()
  {
    this.b.c();
  }
  
  protected abstract String d();
  
  public void f(k paramk)
  {
    if (paramk == this.c) {
      this.a.set(false);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m1.m
 * JD-Core Version:    0.7.0.1
 */