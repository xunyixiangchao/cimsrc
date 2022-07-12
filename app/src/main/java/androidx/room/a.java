package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import o1.e;
import p1.g;
import p1.h;

final class a
{
  private h a = null;
  private final Handler b = new Handler(Looper.getMainLooper());
  Runnable c = null;
  final Object d = new Object();
  final long e;
  final Executor f;
  int g = 0;
  long h = SystemClock.uptimeMillis();
  g i;
  private boolean j = false;
  private final Runnable k = new a();
  final Runnable l = new b();
  
  a(long paramLong, TimeUnit paramTimeUnit, Executor paramExecutor)
  {
    this.e = paramTimeUnit.toMillis(paramLong);
    this.f = paramExecutor;
  }
  
  public void a()
  {
    synchronized (this.d)
    {
      this.j = true;
      g localg = this.i;
      if (localg != null) {
        localg.close();
      }
      this.i = null;
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.d)
    {
      int m = this.g;
      if (m > 0)
      {
        m -= 1;
        this.g = m;
        if (m == 0)
        {
          if (this.i == null) {
            return;
          }
          this.b.postDelayed(this.k, this.e);
        }
        return;
      }
      throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
    }
  }
  
  public <V> V c(k.a<g, V> parama)
  {
    try
    {
      parama = parama.a(e());
      return parama;
    }
    finally
    {
      b();
    }
  }
  
  public g d()
  {
    synchronized (this.d)
    {
      g localg = this.i;
      return localg;
    }
  }
  
  public g e()
  {
    synchronized (this.d)
    {
      this.b.removeCallbacks(this.k);
      this.g += 1;
      if (!this.j)
      {
        Object localObject2 = this.i;
        if ((localObject2 != null) && (((g)localObject2).isOpen()))
        {
          localObject2 = this.i;
          return localObject2;
        }
        localObject2 = this.a;
        if (localObject2 != null)
        {
          localObject2 = ((h)localObject2).X();
          this.i = ((g)localObject2);
          return localObject2;
        }
        throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
      }
      throw new IllegalStateException("Attempting to open already closed database.");
    }
  }
  
  public void f(h paramh)
  {
    if (this.a != null)
    {
      Log.e("ROOM", "AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
      return;
    }
    this.a = paramh;
  }
  
  public boolean g()
  {
    return this.j ^ true;
  }
  
  public void h(Runnable paramRunnable)
  {
    this.c = paramRunnable;
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      a locala = a.this;
      locala.f.execute(locala.l);
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      synchronized (a.this.d)
      {
        long l = SystemClock.uptimeMillis();
        Object localObject2 = a.this;
        if (l - ((a)localObject2).h < ((a)localObject2).e) {
          return;
        }
        if (((a)localObject2).g != 0) {
          return;
        }
        localObject2 = ((a)localObject2).c;
        if (localObject2 != null)
        {
          ((Runnable)localObject2).run();
          localObject2 = a.this.i;
          if (localObject2 != null)
          {
            boolean bool = ((g)localObject2).isOpen();
            if (bool)
            {
              try
              {
                a.this.i.close();
              }
              catch (IOException localIOException)
              {
                e.a(localIOException);
              }
              a.this.i = null;
            }
          }
          return;
        }
        throw new IllegalStateException("mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.a
 * JD-Core Version:    0.7.0.1
 */