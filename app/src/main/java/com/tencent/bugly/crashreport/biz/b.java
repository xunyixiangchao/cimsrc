package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static a a;
  private static boolean b = false;
  private static int c = 10;
  private static long d = 300000L;
  private static long e = 30000L;
  private static long f = 0L;
  private static int g = 0;
  private static long h = 0L;
  private static long i = 0L;
  private static long j = 0L;
  private static Application.ActivityLifecycleCallbacks k;
  private static Class<?> l;
  private static boolean m = true;
  
  public static void a()
  {
    a locala = a;
    if (locala != null) {
      locala.a(2, false, 0L);
    }
  }
  
  public static void a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = com.tencent.bugly.crashreport.common.strategy.a.a().c().o;
    }
    f = l1;
  }
  
  public static void a(Context paramContext)
  {
    if (b)
    {
      if (paramContext == null) {
        return;
      }
      Application localApplication = null;
      if ((paramContext.getApplicationContext() instanceof Application)) {
        localApplication = (Application)paramContext.getApplicationContext();
      }
      if (localApplication != null) {
        try
        {
          paramContext = k;
          if (paramContext != null) {
            localApplication.unregisterActivityLifecycleCallbacks(paramContext);
          }
        }
        catch (Exception paramContext)
        {
          if (!y.a(paramContext)) {
            paramContext.printStackTrace();
          }
        }
      }
      b = false;
    }
  }
  
  public static void a(Context paramContext, final BuglyStrategy paramBuglyStrategy)
  {
    if (b) {
      return;
    }
    boolean bool = com.tencent.bugly.crashreport.common.info.a.a(paramContext).e;
    m = bool;
    a = new a(paramContext, bool);
    b = true;
    long l1;
    if (paramBuglyStrategy != null)
    {
      l = paramBuglyStrategy.getUserInfoActivity();
      l1 = paramBuglyStrategy.getAppReportDelay();
    }
    else
    {
      l1 = 0L;
    }
    if (l1 <= 0L)
    {
      c(paramContext, paramBuglyStrategy);
      return;
    }
    x.a().a(new a(paramContext, paramBuglyStrategy), l1);
  }
  
  public static void a(StrategyBean paramStrategyBean, boolean paramBoolean)
  {
    a locala = a;
    if ((locala != null) && (!paramBoolean))
    {
      x localx = x.a();
      if (localx != null) {
        localx.a(new a.b(locala));
      }
    }
    if (paramStrategyBean == null) {
      return;
    }
    long l1 = paramStrategyBean.o;
    if (l1 > 0L) {
      e = l1;
    }
    int n = paramStrategyBean.t;
    if (n > 0) {
      c = n;
    }
    l1 = paramStrategyBean.u;
    if (l1 > 0L) {
      d = l1;
    }
  }
  
  private static boolean b(Context paramContext)
  {
    try
    {
      int n = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == n)
        {
          int i1 = localRunningAppProcessInfo.importance;
          if (i1 == 100) {
            return true;
          }
        }
      }
    }
    finally
    {
      y.b(paramContext);
    }
    return false;
  }
  
  private static void c(Context paramContext, BuglyStrategy paramBuglyStrategy)
  {
    boolean bool2;
    boolean bool1;
    if (paramBuglyStrategy != null)
    {
      bool2 = paramBuglyStrategy.recordUserInfoOnceADay();
      bool1 = paramBuglyStrategy.isEnableUserInfo();
    }
    else
    {
      bool1 = true;
      bool2 = false;
    }
    if (bool2)
    {
      paramBuglyStrategy = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
      Object localObject = paramBuglyStrategy.d;
      localObject = a.a((String)localObject);
      if (localObject != null)
      {
        n = 0;
        while (n < ((List)localObject).size())
        {
          UserInfoBean localUserInfoBean = (UserInfoBean)((List)localObject).get(n);
          if ((localUserInfoBean.n.equals(paramBuglyStrategy.i)) && (localUserInfoBean.b == 1))
          {
            long l1 = ab.b();
            if (l1 <= 0L) {
              break;
            }
            if (localUserInfoBean.e >= l1)
            {
              if (localUserInfoBean.f <= 0L)
              {
                paramBuglyStrategy = a;
                localObject = x.a();
                if (localObject != null) {
                  ((x)localObject).a(new a.b(paramBuglyStrategy));
                }
              }
              n = 0;
              break label179;
            }
          }
          n += 1;
        }
      }
      int n = 1;
      label179:
      if (n == 0) {
        return;
      }
      bool1 = false;
    }
    paramBuglyStrategy = com.tencent.bugly.crashreport.common.info.a.b();
    if ((paramBuglyStrategy != null) && (b(paramContext))) {
      paramBuglyStrategy.a(0, true);
    }
    if (bool1)
    {
      paramBuglyStrategy = null;
      if ((paramContext.getApplicationContext() instanceof Application)) {
        paramBuglyStrategy = (Application)paramContext.getApplicationContext();
      }
      if (paramBuglyStrategy != null) {
        try
        {
          if (k == null) {
            k = new b();
          }
          paramBuglyStrategy.registerActivityLifecycleCallbacks(k);
        }
        catch (Exception paramContext)
        {
          if (!y.a(paramContext)) {
            paramContext.printStackTrace();
          }
        }
      }
    }
    if (m)
    {
      i = System.currentTimeMillis();
      a.a(1, false, 0L);
      y.a("[session] launch app, new start", new Object[0]);
      a.a();
      paramContext = a;
      x.a().a(new a.e(paramContext, 21600000L), 21600000L);
    }
  }
  
  static final class a
    implements Runnable
  {
    a(Context paramContext, BuglyStrategy paramBuglyStrategy) {}
    
    public final void run()
    {
      b.b(this.a, paramBuglyStrategy);
    }
  }
  
  static final class b
    implements Application.ActivityLifecycleCallbacks
  {
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      paramActivity = paramActivity.getClass().getName();
      if ((b.b() != null) && (!b.b().getName().equals(paramActivity))) {
        return;
      }
      y.c(">>> %s onCreated <<<", new Object[] { paramActivity });
      paramBundle = com.tencent.bugly.crashreport.common.info.a.b();
      if (paramBundle != null) {
        paramBundle.B.add(b.a(paramActivity, "onCreated"));
      }
    }
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      paramActivity = paramActivity.getClass().getName();
      if ((b.b() != null) && (!b.b().getName().equals(paramActivity))) {
        return;
      }
      y.c(">>> %s onDestroyed <<<", new Object[] { paramActivity });
      com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
      if (locala != null) {
        locala.B.add(b.a(paramActivity, "onDestroyed"));
      }
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      paramActivity = paramActivity.getClass().getName();
      if ((b.b() != null) && (!b.b().getName().equals(paramActivity))) {
        return;
      }
      y.c(">>> %s onPaused <<<", new Object[] { paramActivity });
      com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
      if (locala == null) {
        return;
      }
      locala.B.add(b.a(paramActivity, "onPaused"));
      long l = System.currentTimeMillis();
      locala.q = l;
      locala.r = (l - locala.p);
      b.c(l);
      if (locala.r < 0L) {
        locala.r = 0L;
      }
      locala.o = "background";
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      paramActivity = paramActivity.getClass().getName();
      if ((b.b() != null) && (!b.b().getName().equals(paramActivity))) {
        return;
      }
      y.c(">>> %s onResumed <<<", new Object[] { paramActivity });
      com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
      if (locala == null) {
        return;
      }
      locala.B.add(b.a(paramActivity, "onResumed"));
      locala.o = paramActivity;
      long l1 = System.currentTimeMillis();
      locala.p = l1;
      locala.s = (l1 - b.c());
      long l2 = locala.p - b.d();
      if (b.e() > 0L) {
        l1 = b.e();
      } else {
        l1 = b.f();
      }
      if (l2 > l1)
      {
        locala.d();
        b.g();
        y.a("[session] launch app one times (app in background %d seconds and over %d seconds)", new Object[] { Long.valueOf(l2 / 1000L), Long.valueOf(b.f() / 1000L) });
        if (b.h() % b.i() == 0)
        {
          b.a.a(4, b.j(), 0L);
          return;
        }
        b.a.a(4, false, 0L);
        l1 = System.currentTimeMillis();
        if (l1 - b.k() > b.l())
        {
          b.b(l1);
          y.a("add a timer to upload hot start user info", new Object[0]);
          if (b.j())
          {
            paramActivity = b.a;
            l1 = b.l();
            x.a().a(new a.c(paramActivity, null, true), l1);
          }
        }
      }
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity)
    {
      y.c(">>> %s onStart <<<", new Object[] { paramActivity.getClass().getName() });
      com.tencent.bugly.crashreport.common.info.a.b().a(paramActivity.hashCode(), true);
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      y.c(">>> %s onStop <<<", new Object[] { paramActivity.getClass().getName() });
      com.tencent.bugly.crashreport.common.info.a.b().a(paramActivity.hashCode(), false);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.biz.b
 * JD-Core Version:    0.7.0.1
 */