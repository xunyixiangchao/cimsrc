package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.y;
import java.util.HashMap;
import java.util.Map;

public final class e
  implements Thread.UncaughtExceptionHandler
{
  private static String h;
  private static final Object i = new Object();
  private Context a;
  private b b;
  private com.tencent.bugly.crashreport.common.strategy.a c;
  private com.tencent.bugly.crashreport.common.info.a d;
  private Thread.UncaughtExceptionHandler e;
  private Thread.UncaughtExceptionHandler f;
  private boolean g = false;
  private int j;
  
  public e(Context paramContext, b paramb, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1)
  {
    this.a = paramContext;
    this.b = paramb;
    this.c = parama;
    this.d = parama1;
  }
  
  private static String a(Throwable paramThrowable, int paramInt)
  {
    if (paramThrowable == null) {
      return null;
    }
    localStringBuilder = new StringBuilder();
    try
    {
      if (paramThrowable.getStackTrace() != null)
      {
        paramThrowable = paramThrowable.getStackTrace();
        int m = paramThrowable.length;
        int k = 0;
        while (k < m)
        {
          Object localObject = paramThrowable[k];
          if ((paramInt > 0) && (localStringBuilder.length() >= paramInt))
          {
            paramThrowable = new StringBuilder("\n[Stack over limit size :");
            paramThrowable.append(paramInt);
            paramThrowable.append(" , has been cutted !]");
            localStringBuilder.append(paramThrowable.toString());
            return localStringBuilder.toString();
          }
          localStringBuilder.append(localObject.toString());
          localStringBuilder.append("\n");
          k += 1;
        }
      }
      return localStringBuilder.toString();
    }
    finally
    {
      y.e("gen stack error %s", new Object[] { paramThrowable.toString() });
    }
  }
  
  private static void a(CrashDetailBean paramCrashDetailBean, Throwable paramThrowable, boolean paramBoolean)
  {
    String str3 = paramThrowable.getClass().getName();
    String str2 = b(paramThrowable, 1000);
    int k = paramThrowable.getStackTrace().length;
    boolean bool;
    if (paramThrowable.getCause() != null) {
      bool = true;
    } else {
      bool = false;
    }
    y.e("stack frame :%d, has cause %b", new Object[] { Integer.valueOf(k), Boolean.valueOf(bool) });
    k = paramThrowable.getStackTrace().length;
    Object localObject2 = "";
    String str1;
    if (k > 0) {
      str1 = paramThrowable.getStackTrace()[0].toString();
    } else {
      str1 = "";
    }
    for (Object localObject1 = paramThrowable; (localObject1 != null) && (((Throwable)localObject1).getCause() != null); localObject1 = ((Throwable)localObject1).getCause()) {}
    if ((localObject1 != null) && (localObject1 != paramThrowable))
    {
      paramCrashDetailBean.n = localObject1.getClass().getName();
      paramCrashDetailBean.o = b((Throwable)localObject1, 1000);
      if (((Throwable)localObject1).getStackTrace().length > 0) {
        paramCrashDetailBean.p = localObject1.getStackTrace()[0].toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str3);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append("\n");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("\n......");
      ((StringBuilder)localObject2).append("\nCaused by:\n");
      ((StringBuilder)localObject2).append(paramCrashDetailBean.n);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(paramCrashDetailBean.o);
      ((StringBuilder)localObject2).append("\n");
      paramThrowable = a((Throwable)localObject1, c.f);
      ((StringBuilder)localObject2).append(paramThrowable);
      paramCrashDetailBean.q = ((StringBuilder)localObject2).toString();
    }
    else
    {
      paramCrashDetailBean.n = str3;
      localObject1 = localObject2;
      if (c.a().m())
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          y.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
          localObject1 = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append((String)localObject1);
      paramCrashDetailBean.o = ((StringBuilder)localObject2).toString();
      paramCrashDetailBean.p = str1;
      paramThrowable = a(paramThrowable, c.f);
      paramCrashDetailBean.q = paramThrowable;
    }
    paramCrashDetailBean.u = ab.a(paramCrashDetailBean.q.getBytes());
    paramCrashDetailBean.z.put(paramCrashDetailBean.B, paramThrowable);
  }
  
  private static boolean a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    if (paramUncaughtExceptionHandler == null) {
      return true;
    }
    paramUncaughtExceptionHandler = paramUncaughtExceptionHandler.getClass().getName();
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int m = arrayOfStackTraceElement.length;
    int k = 0;
    while (k < m)
    {
      Object localObject = arrayOfStackTraceElement[k];
      String str = ((StackTraceElement)localObject).getClassName();
      localObject = ((StackTraceElement)localObject).getMethodName();
      if ((paramUncaughtExceptionHandler.equals(str)) && ("uncaughtException".equals(localObject))) {
        return false;
      }
      k += 1;
    }
    return true;
  }
  
  private static boolean a(Thread paramThread)
  {
    synchronized (i)
    {
      if (h != null)
      {
        boolean bool = paramThread.getName().equals(h);
        if (bool) {
          return true;
        }
      }
      h = paramThread.getName();
      return false;
    }
  }
  
  private CrashDetailBean b(Thread paramThread, Throwable paramThrowable, boolean paramBoolean1, String paramString, byte[] paramArrayOfByte, boolean paramBoolean2)
  {
    if (paramThrowable == null)
    {
      y.d("We can do nothing with a null throwable.", new Object[0]);
      return null;
    }
    CrashDetailBean localCrashDetailBean = new CrashDetailBean();
    localCrashDetailBean.r = System.currentTimeMillis();
    localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.j();
    localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
    localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.l();
    localCrashDetailBean.F = this.d.o();
    localCrashDetailBean.G = this.d.n();
    localCrashDetailBean.H = this.d.p();
    localCrashDetailBean.I = com.tencent.bugly.crashreport.common.info.b.f();
    localCrashDetailBean.J = com.tencent.bugly.crashreport.common.info.b.g();
    localCrashDetailBean.K = com.tencent.bugly.crashreport.common.info.b.h();
    localCrashDetailBean.w = ab.a(c.e, null);
    Object localObject = aa.a();
    localCrashDetailBean.y = ((byte[])localObject);
    if (localObject == null) {
      k = 0;
    } else {
      k = localObject.length;
    }
    y.a("user log size:%d", new Object[] { Integer.valueOf(k) });
    if (paramBoolean1) {
      k = 0;
    } else {
      k = 2;
    }
    localCrashDetailBean.b = k;
    localCrashDetailBean.e = this.d.k();
    localObject = this.d;
    localCrashDetailBean.f = ((com.tencent.bugly.crashreport.common.info.a)localObject).i;
    localCrashDetailBean.g = ((com.tencent.bugly.crashreport.common.info.a)localObject).u();
    localCrashDetailBean.m = this.d.g();
    localCrashDetailBean.z = ab.a(paramBoolean2, c.f, false);
    localCrashDetailBean.A = this.d.d;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramThread.getName());
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(paramThread.getId());
    ((StringBuilder)localObject).append(")");
    localCrashDetailBean.B = ((StringBuilder)localObject).toString();
    localCrashDetailBean.L = this.d.w();
    localCrashDetailBean.h = this.d.t();
    localCrashDetailBean.i = this.d.F();
    paramThread = this.d;
    localCrashDetailBean.P = paramThread.a;
    localCrashDetailBean.Q = paramThread.a();
    a(localCrashDetailBean, paramThrowable, paramBoolean1);
    if (paramBoolean1) {}
    try
    {
      this.b.d(localCrashDetailBean);
    }
    finally
    {
      for (;;)
      {
        continue;
        k = 0;
        continue;
        int m = 0;
      }
    }
    if ((paramString != null) && (paramString.length() > 0))
    {
      k = 1;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
        break label573;
      }
      m = 1;
      if (k != 0)
      {
        paramThread = new HashMap(1);
        localCrashDetailBean.R = paramThread;
        paramThread.put("UserData", paramString);
      }
      if (m != 0) {
        localCrashDetailBean.X = paramArrayOfByte;
      }
      localCrashDetailBean.T = this.d.D();
      localCrashDetailBean.U = this.d.E();
      localCrashDetailBean.V = this.d.x();
      localCrashDetailBean.W = this.d.C();
      return localCrashDetailBean;
      y.e("handle crash error %s", new Object[] { paramThread.toString() });
      return localCrashDetailBean;
    }
  }
  
  private static String b(Throwable paramThrowable, int paramInt)
  {
    paramThrowable = paramThrowable.getMessage();
    if (paramThrowable == null) {
      return "";
    }
    if (paramThrowable.length() <= 1000) {
      return paramThrowable;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.substring(0, 1000));
    localStringBuilder.append("\n[Message over limit size:1000");
    localStringBuilder.append(", has been cutted!]");
    return localStringBuilder.toString();
  }
  
  public final void a()
  {
    try
    {
      if (this.j >= 10)
      {
        y.a("java crash handler over %d, no need set.", new Object[] { Integer.valueOf(10) });
        return;
      }
      this.g = true;
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      if (localUncaughtExceptionHandler != null)
      {
        boolean bool = e.class.getName().equals(localUncaughtExceptionHandler.getClass().getName());
        if (bool) {
          return;
        }
        if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(localUncaughtExceptionHandler.getClass().getName()))
        {
          y.a("backup system java handler: %s", new Object[] { localUncaughtExceptionHandler.toString() });
          this.f = localUncaughtExceptionHandler;
        }
        for (;;)
        {
          this.e = localUncaughtExceptionHandler;
          break;
          y.a("backup java handler: %s", new Object[] { localUncaughtExceptionHandler.toString() });
        }
      }
      Thread.setDefaultUncaughtExceptionHandler(this);
      this.j += 1;
      y.a("registered java monitor: %s", new Object[] { toString() });
      return;
    }
    finally {}
  }
  
  public final void a(StrategyBean paramStrategyBean)
  {
    if (paramStrategyBean != null) {
      try
      {
        boolean bool = paramStrategyBean.e;
        if (bool != this.g)
        {
          y.a("java changed to %b", new Object[] { Boolean.valueOf(bool) });
          if (paramStrategyBean.e)
          {
            a();
            return;
          }
          b();
        }
      }
      finally {}
    }
  }
  
  public final void a(Thread paramThread, Throwable paramThrowable, boolean paramBoolean1, String paramString, byte[] paramArrayOfByte, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      y.e("Java Crash Happen cause by %s(%d)", new Object[] { paramThread.getName(), Long.valueOf(paramThread.getId()) });
      if (a(paramThread))
      {
        y.a("this class has handled this exception", new Object[0]);
        if (this.f != null)
        {
          y.a("call system handler", new Object[0]);
          this.f.uncaughtException(paramThread, paramThrowable);
        }
        else
        {
          y.e("current process die", new Object[0]);
          Process.killProcess(Process.myPid());
          System.exit(1);
        }
      }
    }
    else
    {
      y.e("Java Catch Happen", new Object[0]);
    }
    try
    {
      if (!this.g)
      {
        y.c("Java crash handler is disable. Just return.", new Object[0]);
        if (paramBoolean1)
        {
          paramString = this.e;
          if ((paramString != null) && (a(paramString)))
          {
            y.e("sys default last handle start!", new Object[0]);
            this.e.uncaughtException(paramThread, paramThrowable);
            y.e("sys default last handle end!", new Object[0]);
            return;
          }
          if (this.f != null)
          {
            y.e("system handle start!", new Object[0]);
            this.f.uncaughtException(paramThread, paramThrowable);
            y.e("system handle end!", new Object[0]);
            return;
          }
          y.e("crashreport last handle start!", new Object[0]);
          y.e("current process die", new Object[0]);
          Process.killProcess(Process.myPid());
          System.exit(1);
          y.e("crashreport last handle end!", new Object[0]);
        }
        return;
      }
      if (!this.c.b()) {
        y.d("no remote but still store!", new Object[0]);
      }
      boolean bool = this.c.c().e;
      if ((bool) || (!this.c.b())) {
        break label514;
      }
      y.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
      if (!paramBoolean1) {
        break label1219;
      }
      paramString = "JAVA_CRASH";
    }
    finally
    {
      for (;;)
      {
        try
        {
          if (!y.a(paramString)) {
            paramString.printStackTrace();
          }
          if (paramBoolean1)
          {
            paramString = this.e;
            if ((paramString != null) && (a(paramString)))
            {
              y.e("sys default last handle start!", new Object[0]);
              this.e.uncaughtException(paramThread, paramThrowable);
              y.e("sys default last handle end!", new Object[0]);
              return;
            }
            if (this.f != null)
            {
              y.e("system handle start!", new Object[0]);
              this.f.uncaughtException(paramThread, paramThrowable);
              y.e("system handle end!", new Object[0]);
              return;
            }
            y.e("crashreport last handle start!", new Object[0]);
            y.e("current process die", new Object[0]);
            Process.killProcess(Process.myPid());
            System.exit(1);
            y.e("crashreport last handle end!", new Object[0]);
          }
          return;
        }
        finally
        {
          if (paramBoolean1)
          {
            paramArrayOfByte = this.e;
            if ((paramArrayOfByte != null) && (a(paramArrayOfByte)))
            {
              y.e("sys default last handle start!", new Object[0]);
              this.e.uncaughtException(paramThread, paramThrowable);
              y.e("sys default last handle end!", new Object[0]);
            }
            else if (this.f != null)
            {
              y.e("system handle start!", new Object[0]);
              this.f.uncaughtException(paramThread, paramThrowable);
              y.e("system handle end!", new Object[0]);
            }
            else
            {
              y.e("crashreport last handle start!", new Object[0]);
              y.e("current process die", new Object[0]);
              Process.killProcess(Process.myPid());
              System.exit(1);
              y.e("crashreport last handle end!", new Object[0]);
            }
          }
        }
        paramString = "JAVA_CATCH";
      }
    }
    b.a(paramString, ab.a(), this.d.d, paramThread.getName(), ab.a(paramThrowable), null);
    if (paramBoolean1)
    {
      paramString = this.e;
      if ((paramString != null) && (a(paramString)))
      {
        y.e("sys default last handle start!", new Object[0]);
        this.e.uncaughtException(paramThread, paramThrowable);
        y.e("sys default last handle end!", new Object[0]);
        return;
      }
      if (this.f != null)
      {
        y.e("system handle start!", new Object[0]);
        this.f.uncaughtException(paramThread, paramThrowable);
        y.e("system handle end!", new Object[0]);
        return;
      }
      y.e("crashreport last handle start!", new Object[0]);
      y.e("current process die", new Object[0]);
      Process.killProcess(Process.myPid());
      System.exit(1);
      y.e("crashreport last handle end!", new Object[0]);
    }
    return;
    label514:
    paramArrayOfByte = b(paramThread, paramThrowable, paramBoolean1, paramString, paramArrayOfByte, paramBoolean2);
    if (paramArrayOfByte == null)
    {
      y.e("pkg crash datas fail!", new Object[0]);
      if (paramBoolean1)
      {
        paramString = this.e;
        if ((paramString != null) && (a(paramString)))
        {
          y.e("sys default last handle start!", new Object[0]);
          this.e.uncaughtException(paramThread, paramThrowable);
          y.e("sys default last handle end!", new Object[0]);
          return;
        }
        if (this.f != null)
        {
          y.e("system handle start!", new Object[0]);
          this.f.uncaughtException(paramThread, paramThrowable);
          y.e("system handle end!", new Object[0]);
          return;
        }
        y.e("crashreport last handle start!", new Object[0]);
        y.e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
        y.e("crashreport last handle end!", new Object[0]);
      }
      return;
    }
    if (paramBoolean1) {
      paramString = "JAVA_CRASH";
    } else {
      paramString = "JAVA_CATCH";
    }
    b.a(paramString, ab.a(), this.d.d, paramThread.getName(), ab.a(paramThrowable), paramArrayOfByte);
    if (!this.b.a(paramArrayOfByte)) {
      this.b.a(paramArrayOfByte, 3000L, paramBoolean1);
    }
    if (paramBoolean1) {
      this.b.c(paramArrayOfByte);
    }
    if (paramBoolean1)
    {
      paramString = this.e;
      if ((paramString != null) && (a(paramString)))
      {
        y.e("sys default last handle start!", new Object[0]);
        this.e.uncaughtException(paramThread, paramThrowable);
        y.e("sys default last handle end!", new Object[0]);
        return;
      }
      if (this.f != null)
      {
        y.e("system handle start!", new Object[0]);
        this.f.uncaughtException(paramThread, paramThrowable);
        y.e("system handle end!", new Object[0]);
        return;
      }
      y.e("crashreport last handle start!", new Object[0]);
      y.e("current process die", new Object[0]);
      Process.killProcess(Process.myPid());
      System.exit(1);
      y.e("crashreport last handle end!", new Object[0]);
      return;
    }
  }
  
  public final void b()
  {
    try
    {
      this.g = false;
      y.a("close java monitor!", new Object[0]);
      if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName()))
      {
        y.a("Java monitor to unregister: %s", new Object[] { toString() });
        Thread.setDefaultUncaughtExceptionHandler(this.e);
        this.j -= 1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    synchronized (i)
    {
      a(paramThread, paramThrowable, true, null, null, this.d.h());
      return;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.crash.e
 * JD-Core Version:    0.7.0.1
 */