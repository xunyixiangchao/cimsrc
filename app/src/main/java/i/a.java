package i;

import java.util.concurrent.Executor;

public class a
  extends c
{
  private static volatile a c;
  private static final Executor d = new a();
  private static final Executor e = new b();
  private c a;
  private c b;
  
  private a()
  {
    b localb = new b();
    this.b = localb;
    this.a = localb;
  }
  
  public static Executor d()
  {
    return e;
  }
  
  public static a e()
  {
    if (c != null) {
      return c;
    }
    try
    {
      if (c == null) {
        c = new a();
      }
      return c;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.a(paramRunnable);
  }
  
  public boolean b()
  {
    return this.a.b();
  }
  
  public void c(Runnable paramRunnable)
  {
    this.a.c(paramRunnable);
  }
  
  static final class a
    implements Executor
  {
    public void execute(Runnable paramRunnable)
    {
      a.e().c(paramRunnable);
    }
  }
  
  static final class b
    implements Executor
  {
    public void execute(Runnable paramRunnable)
    {
      a.e().a(paramRunnable);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i.a
 * JD-Core Version:    0.7.0.1
 */