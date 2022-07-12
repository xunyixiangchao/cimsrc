package s;

import android.os.Handler;
import java.util.concurrent.Executor;

public abstract class k0
{
  public static k0 a(Executor paramExecutor, Handler paramHandler)
  {
    return new c(paramExecutor, paramHandler);
  }
  
  public abstract Executor b();
  
  public abstract Handler c();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.k0
 * JD-Core Version:    0.7.0.1
 */