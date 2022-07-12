package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.crashreport.crash.anr.c;
import java.util.List;

public final class ad
  extends Thread
{
  private boolean a = false;
  private boolean b = true;
  private boolean c = false;
  private int d = 1;
  private ac e;
  private a f;
  private boolean g = true;
  
  private void a(ac paramac)
  {
    try
    {
      boolean bool = this.b;
      if (bool) {
        return;
      }
      if ((this.c) && (!paramac.b()))
      {
        y.c("Restart getting main stack trace.", new Object[0]);
        this.b = true;
        this.c = false;
      }
      return;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    this.f = parama;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder("set record stack trace enable:");
    localStringBuilder.append(paramBoolean);
    y.c(localStringBuilder.toString(), new Object[0]);
  }
  
  public final boolean a()
  {
    this.a = true;
    if (!isAlive()) {
      return false;
    }
    try
    {
      interrupt();
    }
    catch (Exception localException)
    {
      y.b(localException);
    }
    y.d("MainHandlerChecker is reset to null.", new Object[0]);
    this.e = null;
    return true;
  }
  
  public final void b(boolean paramBoolean)
  {
    try
    {
      this.c = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean b()
  {
    Handler localHandler = new Handler(Looper.getMainLooper());
    ac localac = this.e;
    if (localac != null) {
      localac.a(5000L);
    } else {
      this.e = new ac(localHandler, localHandler.getLooper().getThread().getName(), 5000L);
    }
    if (isAlive()) {
      return false;
    }
    try
    {
      start();
      return true;
    }
    catch (Exception localException)
    {
      y.b(localException);
    }
    return false;
  }
  
  public final List<c> c()
  {
    return this.e.b(200000L);
  }
  
  public final void d()
  {
    try
    {
      this.b = false;
      y.c("Record stack trace is disabled.", new Object[0]);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void run()
  {
    long l1 = System.currentTimeMillis();
    if (!this.a) {}
    for (;;)
    {
      int j;
      try
      {
        ac localac = this.e;
        int k = 0;
        if (localac == null)
        {
          y.c("Main handler checker is null. Stop thread monitor.", new Object[0]);
          return;
        }
        localac.a();
        a(localac);
        boolean bool = this.g;
        int m = 1;
        j = 1;
        i = k;
        if (bool) {
          if (!this.b)
          {
            i = k;
          }
          else
          {
            long l2 = localac.c();
            i = k;
            if (l2 > 1510L) {
              if (l2 >= 199990L)
              {
                i = k;
              }
              else
              {
                if (l2 <= 5010L)
                {
                  this.d = 1;
                  y.c("timeSinceMsgSent in [2s, 5s], record stack", new Object[0]);
                  j = m;
                  break label266;
                }
                i = this.d + 1;
                this.d = i;
                if ((i & i - 1) != 0) {
                  break label271;
                }
                i = j;
                j = i;
                if (i == 0) {
                  break label266;
                }
                y.c("timeSinceMsgSent in (5s, 200s), should record stack:true", new Object[0]);
                j = i;
                break label266;
              }
            }
          }
        }
        if (i != 0) {
          localac.d();
        }
        a locala = this.f;
        if ((locala != null) && (this.b)) {
          locala.a(localac.b(), localac.c());
        }
        ab.b(500L - (System.currentTimeMillis() - l1) % 500L);
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}catch (Exception localException) {}
      y.b(localException);
      break;
      return;
      label266:
      int i = j;
      continue;
      label271:
      i = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, long paramLong);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.ad
 * JD-Core Version:    0.7.0.1
 */