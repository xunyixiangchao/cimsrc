package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;

public class u
  implements l
{
  private static final u i = new u();
  private int a = 0;
  private int b = 0;
  private boolean c = true;
  private boolean d = true;
  private Handler e;
  private final m f = new m(this);
  private Runnable g = new a();
  ReportFragment.a h = new b();
  
  public static l h()
  {
    return i;
  }
  
  static void i(Context paramContext)
  {
    i.e(paramContext);
  }
  
  void a()
  {
    int j = this.b - 1;
    this.b = j;
    if (j == 0) {
      this.e.postDelayed(this.g, 700L);
    }
  }
  
  void b()
  {
    int j = this.b + 1;
    this.b = j;
    if (j == 1)
    {
      if (this.c)
      {
        this.f.h(h.b.ON_RESUME);
        this.c = false;
        return;
      }
      this.e.removeCallbacks(this.g);
    }
  }
  
  void c()
  {
    int j = this.a + 1;
    this.a = j;
    if ((j == 1) && (this.d))
    {
      this.f.h(h.b.ON_START);
      this.d = false;
    }
  }
  
  void d()
  {
    this.a -= 1;
    g();
  }
  
  void e(Context paramContext)
  {
    this.e = new Handler();
    this.f.h(h.b.ON_CREATE);
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
  }
  
  void f()
  {
    if (this.b == 0)
    {
      this.c = true;
      this.f.h(h.b.ON_PAUSE);
    }
  }
  
  void g()
  {
    if ((this.a == 0) && (this.c))
    {
      this.f.h(h.b.ON_STOP);
      this.d = true;
    }
  }
  
  public h getLifecycle()
  {
    return this.f;
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      u.this.f();
      u.this.g();
    }
  }
  
  class b
    implements ReportFragment.a
  {
    b() {}
    
    public void a()
    {
      u.this.c();
    }
    
    public void b() {}
    
    public void onResume()
    {
      u.this.b();
    }
  }
  
  class c
    extends e
  {
    c() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      if (Build.VERSION.SDK_INT < 29) {
        ReportFragment.f(paramActivity).h(u.this.h);
      }
    }
    
    public void onActivityPaused(Activity paramActivity)
    {
      u.this.a();
    }
    
    public void onActivityPreCreated(Activity paramActivity, Bundle paramBundle)
    {
      paramActivity.registerActivityLifecycleCallbacks(new a());
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
      u.this.d();
    }
    
    class a
      extends e
    {
      a() {}
      
      public void onActivityPostResumed(Activity paramActivity)
      {
        u.this.b();
      }
      
      public void onActivityPostStarted(Activity paramActivity)
      {
        u.this.c();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.u
 * JD-Core Version:    0.7.0.1
 */