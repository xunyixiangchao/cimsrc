package x2;

import java.util.concurrent.Executor;

public final class e
{
  private static final Executor a = new a();
  private static final Executor b = new b();
  
  public static Executor a()
  {
    return b;
  }
  
  public static Executor b()
  {
    return a;
  }
  
  class a
    implements Executor
  {
    public void execute(Runnable paramRunnable)
    {
      l.u(paramRunnable);
    }
  }
  
  class b
    implements Executor
  {
    public void execute(Runnable paramRunnable)
    {
      paramRunnable.run();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x2.e
 * JD-Core Version:    0.7.0.1
 */