package u7;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract interface a<V>
  extends Future<V>
{
  public abstract void h(Runnable paramRunnable, Executor paramExecutor);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u7.a
 * JD-Core Version:    0.7.0.1
 */