package com.baidu.platform.comapi.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class h
{
  private static final ExecutorService a = Executors.newSingleThreadExecutor(new b("Single"));
  private static final Handler b = new Handler(Looper.getMainLooper());
  private static final ExecutorService c = e.a("DefaultPool");
  
  static
  {
    Executors.newFixedThreadPool(4, new b("FixedPool"));
  }
  
  public static ExecutorService a()
  {
    return c;
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    b.postDelayed(paramRunnable, paramLong);
  }
  
  public static ExecutorService b()
  {
    return a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.h
 * JD-Core Version:    0.7.0.1
 */