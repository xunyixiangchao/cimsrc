package com.baidu.platform.comapi;

import android.app.Application;
import android.content.Context;
import com.baidu.platform.comapi.d.c;
import com.baidu.vi.VIContext;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class b
{
  private static final AtomicBoolean a = new AtomicBoolean(false);
  private static final AtomicBoolean b = new AtomicBoolean(false);
  private static Context c;
  private static a d;
  private static final CountDownLatch e = new CountDownLatch(1);
  private static boolean f;
  private static boolean g;
  private static boolean h;
  
  static
  {
    new AtomicBoolean(false);
  }
  
  public static void a()
  {
    d.a();
    a.set(false);
  }
  
  public static void a(Application paramApplication, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramApplication != null)
    {
      f = paramBoolean2;
      g = paramBoolean3;
      h = paramBoolean4;
      if (c == null) {
        c = paramApplication;
      }
      VIContext.init(paramApplication);
      return;
    }
    throw new RuntimeException("BDMapSDKException: Application Context is null");
  }
  
  public static void a(com.baidu.platform.comapi.d.b paramb)
  {
    for (;;)
    {
      AtomicBoolean localAtomicBoolean = b;
      boolean bool = localAtomicBoolean.get();
      if (bool) {
        return;
      }
      if (localAtomicBoolean.compareAndSet(bool, true))
      {
        if (paramb != null) {}
        try
        {
          c.b.a(paramb);
        }
        finally
        {
          e.countDown();
        }
      }
    }
  }
  
  public static Context b()
  {
    return c;
  }
  
  public static void c()
  {
    Object localObject;
    do
    {
      boolean bool;
      do
      {
        localObject = a;
        bool = ((AtomicBoolean)localObject).get();
        if (bool) {
          return;
        }
      } while (!((AtomicBoolean)localObject).compareAndSet(bool, true));
      localObject = new a();
      d = (a)localObject;
    } while (((a)localObject).a(c));
    throw new RuntimeException("BDMapSDKException: engine init failed");
  }
  
  public static boolean d()
  {
    return h;
  }
  
  public static boolean e()
  {
    return f;
  }
  
  public static boolean f()
  {
    return b.get();
  }
  
  public static boolean g()
  {
    return g;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.b
 * JD-Core Version:    0.7.0.1
 */