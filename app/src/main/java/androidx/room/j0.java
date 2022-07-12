package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

class j0
  implements Executor
{
  private final Executor a;
  private final ArrayDeque<Runnable> b = new ArrayDeque();
  private Runnable c;
  
  j0(Executor paramExecutor)
  {
    this.a = paramExecutor;
  }
  
  void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.b.poll();
      this.c = localRunnable;
      if (localRunnable != null) {
        this.a.execute(localRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void execute(final Runnable paramRunnable)
  {
    try
    {
      this.b.offer(new a(paramRunnable));
      if (this.c == null) {
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  class a
    implements Runnable
  {
    a(Runnable paramRunnable) {}
    
    public void run()
    {
      try
      {
        paramRunnable.run();
        return;
      }
      finally
      {
        j0.this.a();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.j0
 * JD-Core Version:    0.7.0.1
 */