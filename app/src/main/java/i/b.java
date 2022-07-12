package i;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b
  extends c
{
  private final Object a = new Object();
  private final ExecutorService b = Executors.newFixedThreadPool(4, new a());
  private volatile Handler c;
  
  private static Handler d(Looper paramLooper)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return Handler.createAsync(paramLooper);
    }
    try
    {
      Handler localHandler = (Handler)Handler.class.getDeclaredConstructor(new Class[] { Looper.class, Handler.Callback.class, Boolean.TYPE }).newInstance(new Object[] { paramLooper, null, Boolean.TRUE });
      return localHandler;
    }
    catch (IllegalAccessException|InstantiationException|NoSuchMethodException localIllegalAccessException)
    {
      break label74;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label65:
      label74:
      break label65;
    }
    return new Handler(paramLooper);
    return new Handler(paramLooper);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.b.execute(paramRunnable);
  }
  
  public boolean b()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public void c(Runnable paramRunnable)
  {
    if (this.c == null) {
      synchronized (this.a)
      {
        if (this.c == null) {
          this.c = d(Looper.getMainLooper());
        }
      }
    }
    this.c.post(paramRunnable);
  }
  
  class a
    implements ThreadFactory
  {
    private final AtomicInteger a = new AtomicInteger(0);
    
    a() {}
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      paramRunnable.setName(String.format("arch_disk_io_%d", new Object[] { Integer.valueOf(this.a.getAndIncrement()) }));
      return paramRunnable;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i.b
 * JD-Core Version:    0.7.0.1
 */