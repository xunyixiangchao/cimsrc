package t;

import java.util.concurrent.Executor;

final class b
  implements Executor
{
  private static volatile b a;
  
  static Executor a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
    finally {}
  }
  
  public void execute(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t.b
 * JD-Core Version:    0.7.0.1
 */