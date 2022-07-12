package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.proguard.m;
import com.tencent.bugly.proguard.y;

public class CrashModule
  extends a
{
  public static final int MODULE_ID = 1004;
  private static int c;
  private static CrashModule e = new CrashModule();
  private long a;
  private BuglyStrategy.a b;
  private boolean d = false;
  
  private void a(Context paramContext, BuglyStrategy paramBuglyStrategy)
  {
    if (paramBuglyStrategy == null) {
      return;
    }
    try
    {
      String str = paramBuglyStrategy.getLibBuglySOFilePath();
      if (!TextUtils.isEmpty(str))
      {
        com.tencent.bugly.crashreport.common.info.a.a(paramContext).l = str;
        y.a("setted libBugly.so file path :%s", new Object[] { str });
      }
      if (paramBuglyStrategy.getCrashHandleCallback() != null)
      {
        this.b = paramBuglyStrategy.getCrashHandleCallback();
        y.a("setted CrashHanldeCallback", new Object[0]);
      }
      if (paramBuglyStrategy.getAppReportDelay() > 0L)
      {
        long l = paramBuglyStrategy.getAppReportDelay();
        this.a = l;
        y.a("setted delay: %d", new Object[] { Long.valueOf(l) });
      }
      return;
    }
    finally {}
  }
  
  public static CrashModule getInstance()
  {
    CrashModule localCrashModule = e;
    localCrashModule.id = 1004;
    return localCrashModule;
  }
  
  public String[] getTables()
  {
    return new String[] { "t_cr" };
  }
  
  public boolean hasInitialized()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void init(Context paramContext, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        if (!this.d)
        {
          y.a("Initializing crash module.", new Object[0]);
          Object localObject = m.a();
          int i = c + 1;
          c = i;
          ((m)localObject).a(1004, i);
          this.d = true;
          CrashReport.setContext(paramContext);
          a(paramContext, paramBuglyStrategy);
          localObject = c.a(1004, paramContext, paramBoolean, this.b, null, null);
          ((c)localObject).f();
          if (paramBuglyStrategy != null)
          {
            ((c)localObject).a(paramBuglyStrategy.getCallBackType());
            ((c)localObject).a(paramBuglyStrategy.getCloseErrorCallback());
            c.l = paramBuglyStrategy.isUploadSpotCrash();
            com.tencent.bugly.crashreport.common.info.a.a(paramContext).b(paramBuglyStrategy.isEnableRecordAnrMainStack());
          }
          if ((paramBuglyStrategy != null) && (paramBuglyStrategy.isEnableCatchAnrTrace())) {
            ((c)localObject).k();
          }
          ((c)localObject).o();
          if ((paramBuglyStrategy != null) && (!paramBuglyStrategy.isEnableNativeCrashMonitor()))
          {
            y.a("[crash] Closed native crash monitor!", new Object[0]);
            ((c)localObject).g();
          }
          else
          {
            ((c)localObject).h();
          }
          if ((paramBuglyStrategy != null) && (!paramBuglyStrategy.isEnableANRCrashMonitor()))
          {
            y.a("[crash] Closed ANR monitor!", new Object[0]);
            ((c)localObject).j();
          }
          else
          {
            ((c)localObject).i();
          }
          if (paramBuglyStrategy != null) {
            c.d = paramBuglyStrategy.isMerged();
          }
          if (paramBuglyStrategy == null) {
            break label316;
          }
          l = paramBuglyStrategy.getAppReportDelay();
          ((c)localObject).a(l);
          ((c)localObject).n();
          d.a(paramContext);
          paramBuglyStrategy = BuglyBroadcastReceiver.getInstance();
          paramBuglyStrategy.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
          paramBuglyStrategy.register(paramContext);
          paramContext = m.a();
          i = c - 1;
          c = i;
          paramContext.a(1004, i);
          return;
        }
      }
      finally {}
      return;
      label316:
      long l = 0L;
    }
  }
  
  public void onServerStrategyChanged(StrategyBean paramStrategyBean)
  {
    if (paramStrategyBean == null) {
      return;
    }
    c localc = c.a();
    if (localc != null) {
      localc.a(paramStrategyBean);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.CrashModule
 * JD-Core Version:    0.7.0.1
 */