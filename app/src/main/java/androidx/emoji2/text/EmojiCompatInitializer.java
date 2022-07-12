package androidx.emoji2.text;

import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.h;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import u0.f;

public class EmojiCompatInitializer
  implements r1.a<Boolean>
{
  public List<Class<? extends r1.a<?>>> a()
  {
    return Collections.singletonList(ProcessLifecycleInitializer.class);
  }
  
  public Boolean c(Context paramContext)
  {
    d.g(new a(paramContext));
    d(paramContext);
    return Boolean.TRUE;
  }
  
  void d(final Context paramContext)
  {
    paramContext = ((androidx.lifecycle.l)androidx.startup.a.c(paramContext).d(ProcessLifecycleInitializer.class)).getLifecycle();
    paramContext.a(new androidx.lifecycle.d()
    {
      public void onResume(androidx.lifecycle.l paramAnonymousl)
      {
        EmojiCompatInitializer.this.e();
        paramContext.c(this);
      }
    });
  }
  
  void e()
  {
    b.d().postDelayed(new c(), 500L);
  }
  
  static class a
    extends d.c
  {
    protected a(Context paramContext)
    {
      super();
      b(1);
    }
  }
  
  static class b
    implements d.g
  {
    private final Context a;
    
    b(Context paramContext)
    {
      this.a = paramContext.getApplicationContext();
    }
    
    public void a(d.h paramh)
    {
      ThreadPoolExecutor localThreadPoolExecutor = b.b("EmojiCompatInitializer");
      localThreadPoolExecutor.execute(new e(this, paramh, localThreadPoolExecutor));
    }
    
    void c(final d.h paramh, final ThreadPoolExecutor paramThreadPoolExecutor)
    {
      try
      {
        i locali = c.a(this.a);
        if (locali != null)
        {
          locali.c(paramThreadPoolExecutor);
          locali.a().a(new a(paramh, paramThreadPoolExecutor));
          return;
        }
        throw new RuntimeException("EmojiCompat font provider not available on this device.");
      }
      finally
      {
        paramh.a(localThrowable);
        paramThreadPoolExecutor.shutdown();
      }
    }
    
    class a
      extends d.h
    {
      a(d.h paramh, ThreadPoolExecutor paramThreadPoolExecutor) {}
      
      public void a(Throwable paramThrowable)
      {
        try
        {
          paramh.a(paramThrowable);
          return;
        }
        finally
        {
          paramThreadPoolExecutor.shutdown();
        }
      }
      
      public void b(l paraml)
      {
        try
        {
          paramh.b(paraml);
          return;
        }
        finally
        {
          paramThreadPoolExecutor.shutdown();
        }
      }
    }
  }
  
  static class c
    implements Runnable
  {
    public void run()
    {
      try
      {
        f.a("EmojiCompat.EmojiCompatInitializer.run");
        if (d.h()) {
          d.b().k();
        }
        return;
      }
      finally
      {
        f.b();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.emoji2.text.EmojiCompatInitializer
 * JD-Core Version:    0.7.0.1
 */