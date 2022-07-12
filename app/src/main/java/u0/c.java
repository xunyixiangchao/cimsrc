package u0;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import x0.h;

public final class c
{
  public static Executor a(Handler paramHandler)
  {
    return new a(paramHandler);
  }
  
  private static class a
    implements Executor
  {
    private final Handler a;
    
    a(Handler paramHandler)
    {
      this.a = ((Handler)h.g(paramHandler));
    }
    
    public void execute(Runnable paramRunnable)
    {
      if (this.a.post((Runnable)h.g(paramRunnable))) {
        return;
      }
      paramRunnable = new StringBuilder();
      paramRunnable.append(this.a);
      paramRunnable.append(" is shutting down");
      throw new RejectedExecutionException(paramRunnable.toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u0.c
 * JD-Core Version:    0.7.0.1
 */