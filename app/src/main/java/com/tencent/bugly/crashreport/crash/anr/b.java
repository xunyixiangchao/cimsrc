package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ad;
import com.tencent.bugly.proguard.ad.a;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
{
  private static b m;
  private final AtomicBoolean a = new AtomicBoolean(false);
  private final Context b;
  private final ActivityManager c;
  private final com.tencent.bugly.crashreport.common.info.a d;
  private final x e;
  private final com.tencent.bugly.crashreport.crash.b f;
  private final Object g = new Object();
  private String h;
  private FileObserver i;
  private boolean j = true;
  private ad k;
  private int l;
  private long n = 0L;
  
  private b(Context paramContext, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1, x paramx, com.tencent.bugly.crashreport.crash.b paramb)
  {
    parama = ab.a(paramContext);
    this.b = parama;
    this.c = ((ActivityManager)parama.getSystemService("activity"));
    this.h = paramContext.getDir("bugly", 0).getAbsolutePath();
    this.d = parama1;
    this.e = paramx;
    this.f = paramb;
  }
  
  private CrashDetailBean a(a parama)
  {
    CrashDetailBean localCrashDetailBean = new CrashDetailBean();
    for (;;)
    {
      try
      {
        localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.j();
        localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
        localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.l();
        localCrashDetailBean.F = this.d.o();
        localCrashDetailBean.G = this.d.n();
        localCrashDetailBean.H = this.d.p();
        localCrashDetailBean.I = com.tencent.bugly.crashreport.common.info.b.f();
        localCrashDetailBean.J = com.tencent.bugly.crashreport.common.info.b.g();
        localCrashDetailBean.K = com.tencent.bugly.crashreport.common.info.b.h();
        if (!com.tencent.bugly.crashreport.common.info.b.o()) {
          localCrashDetailBean.w = ab.a(com.tencent.bugly.crashreport.crash.c.e, null);
        }
        localCrashDetailBean.b = 3;
        localCrashDetailBean.e = this.d.k();
        localObject = this.d;
        localCrashDetailBean.f = ((com.tencent.bugly.crashreport.common.info.a)localObject).i;
        localCrashDetailBean.g = ((com.tencent.bugly.crashreport.common.info.a)localObject).u();
        localCrashDetailBean.m = this.d.g();
        localCrashDetailBean.n = "ANR_EXCEPTION";
        localCrashDetailBean.o = parama.f;
        localCrashDetailBean.q = parama.g;
        localObject = new HashMap();
        localCrashDetailBean.S = ((Map)localObject);
        ((Map)localObject).put("BUGLY_CR_01", parama.e);
        int i1 = -1;
        localObject = localCrashDetailBean.q;
        if (localObject != null) {
          i1 = ((String)localObject).indexOf("\n");
        }
        if (i1 > 0)
        {
          localObject = localCrashDetailBean.q.substring(0, i1);
          localCrashDetailBean.p = ((String)localObject);
          localCrashDetailBean.r = parama.c;
          localObject = localCrashDetailBean.q;
          if (localObject != null) {
            localCrashDetailBean.u = ab.a(((String)localObject).getBytes());
          }
          localCrashDetailBean.z = parama.b;
          localCrashDetailBean.A = parama.a;
          localCrashDetailBean.B = "main(1)";
          localCrashDetailBean.L = this.d.w();
          localCrashDetailBean.h = this.d.t();
          localCrashDetailBean.i = this.d.F();
          localCrashDetailBean.v = parama.d;
          parama = this.d;
          localCrashDetailBean.O = parama.m;
          localCrashDetailBean.P = parama.a;
          localCrashDetailBean.Q = parama.a();
          if (!com.tencent.bugly.crashreport.common.info.b.o()) {
            this.f.d(localCrashDetailBean);
          }
          localCrashDetailBean.T = this.d.D();
          localCrashDetailBean.U = this.d.E();
          localCrashDetailBean.V = this.d.x();
          localCrashDetailBean.W = this.d.C();
          localCrashDetailBean.y = aa.a();
          return localCrashDetailBean;
        }
      }
      finally
      {
        if (!y.a(parama)) {
          parama.printStackTrace();
        }
        return localCrashDetailBean;
      }
      Object localObject = "GET_FAIL";
    }
  }
  
  public static b a(Context paramContext, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1, x paramx, o paramo, com.tencent.bugly.crashreport.crash.b paramb, BuglyStrategy.a parama2)
  {
    if (m == null) {
      m = new b(paramContext, parama, parama1, paramx, paramb);
    }
    return m;
  }
  
  private static String a(List<c> paramList, long paramLong)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder(4096);
      localStringBuilder.append("\n>>>>> 以下为anr过程中主线程堆栈记录，可根据堆栈出现次数推测在该堆栈阻塞的时间，出现次数越多对anr贡献越大，越可能是造成anr的原因 >>>>>\n");
      localStringBuilder.append("\n>>>>> Thread Stack Traces Records Start >>>>>\n");
      int i1 = 0;
      while (i1 < paramList.size())
      {
        c localc = (c)paramList.get(i1);
        localStringBuilder.append("Thread name:");
        localStringBuilder.append(localc.b());
        localStringBuilder.append("\n");
        long l1 = localc.c() - paramLong;
        String str;
        if (l1 <= 0L) {
          str = "before ";
        } else {
          str = "after ";
        }
        localStringBuilder.append("Got ");
        localStringBuilder.append(str);
        localStringBuilder.append("anr:");
        localStringBuilder.append(Math.abs(l1));
        localStringBuilder.append("ms\n");
        localStringBuilder.append(localc.a());
        localStringBuilder.append("\n");
        if (localStringBuilder.length() << 1 >= 101376) {
          break;
        }
        i1 += 1;
      }
      localStringBuilder.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
      return localStringBuilder.toString();
    }
    return "main thread stack not enable";
  }
  
  private void a(long paramLong, String arg3)
  {
    for (;;)
    {
      try
      {
        y.c("anr time:%s", new Object[] { Long.valueOf(paramLong) });
      }
      finally
      {
        try
        {
          Object localObject4;
          y.b(???);
          return;
        }
        finally
        {
          b(false);
        }
        boolean bool = false;
        continue;
        bool = true;
        continue;
      }
      synchronized (this.g)
      {
        if (this.k != null)
        {
          y.c("Disable record main stack trace.", new Object[0]);
          this.k.d();
        }
        ??? = ab.a(Looper.getMainLooper().getThread());
        localObject4 = ab.a(this.d.i(), com.tencent.bugly.crashreport.crash.c.f, false);
        ??? = this.b;
        if (!com.tencent.bugly.crashreport.common.info.b.d((Context)???)) {
          if (com.tencent.bugly.crashreport.common.info.b.e((Context)???))
          {
            continue;
            y.c("isAnrCrashDevice:%s", new Object[] { Boolean.valueOf(bool) });
            if (bool) {
              ??? = com.tencent.bugly.proguard.a.a(this.c, 0L);
            } else {
              ??? = com.tencent.bugly.proguard.a.a(this.c, 21000L);
            }
            if (??? == null)
            {
              y.c("proc state is invisible or not my proc!", new Object[0]);
              b(false);
              return;
            }
            a locala = new a();
            locala.c = paramLong;
            locala.a = ((ActivityManager.ProcessErrorStateInfo)???).processName;
            locala.f = ((ActivityManager.ProcessErrorStateInfo)???).shortMsg;
            locala.e = ((ActivityManager.ProcessErrorStateInfo)???).longMsg;
            locala.b = ((Map)localObject4);
            locala.g = ((String)???);
            if (TextUtils.isEmpty((CharSequence)???)) {
              locala.g = "main stack is null , some error may be encountered.";
            }
            long l1 = locala.c;
            ??? = locala.d;
            ??? = locala.a;
            localObject4 = locala.g;
            String str1 = locala.f;
            String str2 = locala.e;
            Map localMap = locala.b;
            int i1;
            if (localMap == null) {
              i1 = 0;
            } else {
              i1 = localMap.size();
            }
            y.c("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", new Object[] { Long.valueOf(l1), ???, ???, localObject4, str1, str2, Integer.valueOf(i1) });
            y.a("found visible anr , start to upload!", new Object[0]);
            y.c("trace file:%s", new Object[] { ??? });
            if ((!TextUtils.isEmpty(???)) && (new File(???).exists()))
            {
              ??? = this.h;
              ??? = new StringBuilder("bugly_trace_");
              ((StringBuilder)???).append(paramLong);
              ((StringBuilder)???).append(".txt");
              ??? = new File((String)???, ((StringBuilder)???).toString());
              y.c("trace file exists", new Object[0]);
              if (???.startsWith("/data/anr/")) {
                y.a("backup trace isOK:%s", new Object[] { Boolean.valueOf(a(???, ((File)???).getAbsolutePath(), locala.a)) });
              } else {
                y.a("trace file rename :%s", new Object[] { Boolean.valueOf(new File(???).renameTo((File)???)) });
              }
              ??? = null;
              synchronized (this.g)
              {
                localObject4 = this.k;
                if (localObject4 != null) {
                  ??? = ((ad)localObject4).c();
                }
                if (??? != null)
                {
                  ??? = a(???, paramLong);
                  y.c("save main stack trace", new Object[0]);
                  z.a((File)???, ???, 2147483647L, true);
                }
                locala.d = ((File)???).getAbsolutePath();
              }
            }
            y.c("trace file is null or not exists, just ignore", new Object[0]);
            ??? = a(locala);
            if (??? == null)
            {
              y.e("pack anr fail!", new Object[0]);
            }
            else
            {
              com.tencent.bugly.crashreport.crash.c.a().a(???);
              if (???.a >= 0L) {
                y.a("backup anr record success!", new Object[0]);
              } else {
                y.d("backup anr record fail!", new Object[0]);
              }
              com.tencent.bugly.crashreport.crash.b.a("ANR", ab.a(paramLong), locala.a, "main", locala.g, ???);
              if (!this.f.a(???)) {
                this.f.a(???, 3000L, true);
              }
              this.f.c(???);
            }
            synchronized (this.g)
            {
              if (this.k != null)
              {
                y.c("Finish anr process.", new Object[0]);
                this.k.b(true);
              }
              b(false);
              return;
            }
          }
        }
      }
    }
  }
  
  private boolean a(long paramLong)
  {
    if (Math.abs(paramLong - this.n) < 10000L)
    {
      y.d("should not process ANR too Fre in %dms", new Object[] { Integer.valueOf(10000) });
      return true;
    }
    this.n = paramLong;
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = TraceFileHelper.readTargetDumpInfo(paramString3, paramString1, true);
    if (paramString1 != null)
    {
      Object localObject = paramString1.d;
      if ((localObject != null) && (!((Map)localObject).isEmpty()))
      {
        paramString3 = new StringBuilder(1024);
        localObject = (String[])paramString1.d.get("main");
        if ((localObject != null) && (localObject.length >= 3))
        {
          paramString3.append("\"main\" tid=");
          paramString3.append(localObject[2]);
          paramString3.append(" :\n");
          paramString3.append(localObject[0]);
          paramString3.append("\n");
          paramString3.append(localObject[1]);
          paramString3.append("\n\n");
        }
        paramString1 = paramString1.d.entrySet().iterator();
        while (paramString1.hasNext())
        {
          localObject = (Map.Entry)paramString1.next();
          if ((!((String)((Map.Entry)localObject).getKey()).equals("main")) && (((Map.Entry)localObject).getValue() != null) && (((String[])((Map.Entry)localObject).getValue()).length >= 3))
          {
            paramString3.append("\"");
            paramString3.append((String)((Map.Entry)localObject).getKey());
            paramString3.append("\" tid=");
            paramString3.append(((String[])localObject.getValue())[2]);
            paramString3.append(" :\n");
            paramString3.append(((String[])localObject.getValue())[0]);
            paramString3.append("\n");
            paramString3.append(((String[])localObject.getValue())[1]);
            paramString3.append("\n\n");
          }
        }
        return z.a(paramString2, paramString3.toString(), paramString3.length() * 2);
      }
    }
    y.e("not found trace dump for %s", new Object[] { paramString3 });
    return false;
  }
  
  private boolean b(boolean paramBoolean)
  {
    boolean bool = this.a.compareAndSet(paramBoolean ^ true, paramBoolean);
    y.c("tryChangeAnrState to %s, success:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    return bool;
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 731	com/tencent/bugly/crashreport/crash/anr/b:e	()Z
    //   6: ifeq +17 -> 23
    //   9: ldc_w 733
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 579	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: new 6	com/tencent/bugly/crashreport/crash/anr/b$a
    //   26: dup
    //   27: aload_0
    //   28: ldc_w 530
    //   31: bipush 8
    //   33: invokespecial 736	com/tencent/bugly/crashreport/crash/anr/b$a:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   36: astore_1
    //   37: aload_0
    //   38: aload_1
    //   39: putfield 738	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   42: aload_1
    //   43: invokevirtual 743	android/os/FileObserver:startWatching	()V
    //   46: ldc_w 745
    //   49: iconst_0
    //   50: anewarray 4	java/lang/Object
    //   53: invokestatic 510	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   56: pop
    //   57: aload_0
    //   58: getfield 99	com/tencent/bugly/crashreport/crash/anr/b:e	Lcom/tencent/bugly/proguard/x;
    //   61: new 10	com/tencent/bugly/crashreport/crash/anr/b$b
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 747	com/tencent/bugly/crashreport/crash/anr/b$b:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   69: invokevirtual 752	com/tencent/bugly/proguard/x:a	(Ljava/lang/Runnable;)Z
    //   72: pop
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: astore_1
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 738	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   82: ldc_w 754
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 579	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   92: pop
    //   93: aload_1
    //   94: invokestatic 334	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   97: ifne +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 339	java/lang/Throwable:printStackTrace	()V
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	b
    //   36	7	1	locala	a
    //   76	25	1	localThrowable	Throwable
    //   107	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   42	73	76	finally
    //   2	20	107	finally
    //   23	42	107	finally
    //   77	104	107	finally
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      g();
      return;
    }
    finally {}
    h();
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 731	com/tencent/bugly/crashreport/crash/anr/b:e	()Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 761
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 579	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 738	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   27: invokevirtual 764	android/os/FileObserver:stopWatching	()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 738	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   35: ldc_w 766
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 579	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: ldc_w 768
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 579	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_1
    //   62: invokestatic 334	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   65: ifne +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 339	java/lang/Throwable:printStackTrace	()V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	b
    //   49	20	1	localThrowable	Throwable
    //   75	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	46	49	finally
    //   2	20	75	finally
    //   50	72	75	finally
  }
  
  private void d(boolean paramBoolean)
  {
    try
    {
      if (this.j != paramBoolean)
      {
        y.a("user change anr %b", new Object[] { Boolean.valueOf(paramBoolean) });
        this.j = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private boolean e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 738	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	b
    //   12	7	1	bool	boolean
    //   6	2	2	localFileObserver	FileObserver
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  private boolean f()
  {
    try
    {
      boolean bool = this.j;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 731	com/tencent/bugly/crashreport/crash/anr/b:e	()Z
    //   6: ifeq +17 -> 23
    //   9: ldc_w 733
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 579	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 95	com/tencent/bugly/crashreport/crash/anr/b:h	Ljava/lang/String;
    //   27: invokestatic 496	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: istore_2
    //   31: iload_2
    //   32: ifeq +6 -> 38
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: getfield 58	com/tencent/bugly/crashreport/crash/anr/b:g	Ljava/lang/Object;
    //   42: astore_3
    //   43: aload_3
    //   44: monitorenter
    //   45: aload_0
    //   46: getfield 429	com/tencent/bugly/crashreport/crash/anr/b:k	Lcom/tencent/bugly/proguard/ad;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +11 -> 64
    //   56: aload 4
    //   58: invokevirtual 775	java/lang/Thread:isAlive	()Z
    //   61: ifne +100 -> 161
    //   64: new 433	com/tencent/bugly/proguard/ad
    //   67: dup
    //   68: invokespecial 776	com/tencent/bugly/proguard/ad:<init>	()V
    //   71: astore 4
    //   73: aload_0
    //   74: aload 4
    //   76: putfield 429	com/tencent/bugly/crashreport/crash/anr/b:k	Lcom/tencent/bugly/proguard/ad;
    //   79: aload 4
    //   81: aload_0
    //   82: getfield 97	com/tencent/bugly/crashreport/crash/anr/b:d	Lcom/tencent/bugly/crashreport/common/info/a;
    //   85: invokevirtual 778	com/tencent/bugly/crashreport/common/info/a:j	()Z
    //   88: invokevirtual 780	com/tencent/bugly/proguard/ad:a	(Z)V
    //   91: aload_0
    //   92: getfield 429	com/tencent/bugly/crashreport/crash/anr/b:k	Lcom/tencent/bugly/proguard/ad;
    //   95: new 12	com/tencent/bugly/crashreport/crash/anr/b$c
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 781	com/tencent/bugly/crashreport/crash/anr/b$c:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   103: invokevirtual 784	com/tencent/bugly/proguard/ad:a	(Lcom/tencent/bugly/proguard/ad$a;)V
    //   106: aload_0
    //   107: getfield 429	com/tencent/bugly/crashreport/crash/anr/b:k	Lcom/tencent/bugly/proguard/ad;
    //   110: astore 4
    //   112: new 355	java/lang/StringBuilder
    //   115: dup
    //   116: ldc_w 786
    //   119: invokespecial 521	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: astore 5
    //   124: aload_0
    //   125: getfield 788	com/tencent/bugly/crashreport/crash/anr/b:l	I
    //   128: istore_1
    //   129: aload_0
    //   130: iload_1
    //   131: iconst_1
    //   132: iadd
    //   133: putfield 788	com/tencent/bugly/crashreport/crash/anr/b:l	I
    //   136: aload 5
    //   138: iload_1
    //   139: invokevirtual 791	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 4
    //   145: aload 5
    //   147: invokevirtual 411	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokevirtual 794	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   153: aload_0
    //   154: getfield 429	com/tencent/bugly/crashreport/crash/anr/b:k	Lcom/tencent/bugly/proguard/ad;
    //   157: invokevirtual 796	com/tencent/bugly/proguard/ad:b	()Z
    //   160: pop
    //   161: aload_3
    //   162: monitorexit
    //   163: new 14	com/tencent/bugly/crashreport/crash/anr/b$d
    //   166: dup
    //   167: aload_0
    //   168: aload_0
    //   169: getfield 95	com/tencent/bugly/crashreport/crash/anr/b:h	Ljava/lang/String;
    //   172: bipush 8
    //   174: invokespecial 797	com/tencent/bugly/crashreport/crash/anr/b$d:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   177: astore_3
    //   178: aload_0
    //   179: aload_3
    //   180: putfield 738	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   183: aload_3
    //   184: invokevirtual 743	android/os/FileObserver:startWatching	()V
    //   187: ldc_w 799
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload_0
    //   197: getfield 95	com/tencent/bugly/crashreport/crash/anr/b:h	Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 510	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   204: pop
    //   205: aload_0
    //   206: getfield 99	com/tencent/bugly/crashreport/crash/anr/b:e	Lcom/tencent/bugly/proguard/x;
    //   209: new 16	com/tencent/bugly/crashreport/crash/anr/b$e
    //   212: dup
    //   213: aload_0
    //   214: invokespecial 800	com/tencent/bugly/crashreport/crash/anr/b$e:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   217: invokevirtual 752	com/tencent/bugly/proguard/x:a	(Ljava/lang/Runnable;)Z
    //   220: pop
    //   221: aload_0
    //   222: monitorexit
    //   223: return
    //   224: astore_3
    //   225: aload_0
    //   226: aconst_null
    //   227: putfield 738	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   230: ldc_w 802
    //   233: iconst_0
    //   234: anewarray 4	java/lang/Object
    //   237: invokestatic 579	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   240: pop
    //   241: aload_3
    //   242: invokestatic 334	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   245: ifne +7 -> 252
    //   248: aload_3
    //   249: invokevirtual 339	java/lang/Throwable:printStackTrace	()V
    //   252: aload_0
    //   253: monitorexit
    //   254: return
    //   255: astore 4
    //   257: aload_3
    //   258: monitorexit
    //   259: aload 4
    //   261: athrow
    //   262: astore_3
    //   263: aload_0
    //   264: monitorexit
    //   265: aload_3
    //   266: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	b
    //   128	11	1	i1	int
    //   30	2	2	bool	boolean
    //   224	34	3	localThrowable	Throwable
    //   262	4	3	localObject2	Object
    //   49	95	4	localad	ad
    //   255	5	4	localObject3	Object
    //   122	24	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   183	221	224	finally
    //   45	51	255	finally
    //   56	64	255	finally
    //   64	161	255	finally
    //   161	163	255	finally
    //   2	20	262	finally
    //   23	31	262	finally
    //   38	45	262	finally
    //   163	183	262	finally
    //   225	252	262	finally
    //   257	262	262	finally
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 731	com/tencent/bugly/crashreport/crash/anr/b:e	()Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 761
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 579	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 58	com/tencent/bugly/crashreport/crash/anr/b:g	Ljava/lang/Object;
    //   27: astore_1
    //   28: aload_1
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 429	com/tencent/bugly/crashreport/crash/anr/b:k	Lcom/tencent/bugly/proguard/ad;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnull +13 -> 49
    //   39: aload_2
    //   40: invokevirtual 803	com/tencent/bugly/proguard/ad:a	()Z
    //   43: pop
    //   44: aload_0
    //   45: aconst_null
    //   46: putfield 429	com/tencent/bugly/crashreport/crash/anr/b:k	Lcom/tencent/bugly/proguard/ad;
    //   49: aload_1
    //   50: monitorexit
    //   51: ldc_w 805
    //   54: iconst_0
    //   55: anewarray 4	java/lang/Object
    //   58: invokestatic 510	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   61: pop
    //   62: aload_0
    //   63: getfield 738	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   66: invokevirtual 764	android/os/FileObserver:stopWatching	()V
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 738	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   74: ldc_w 766
    //   77: iconst_0
    //   78: anewarray 4	java/lang/Object
    //   81: invokestatic 579	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   84: pop
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: astore_1
    //   89: ldc_w 768
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokestatic 579	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   99: pop
    //   100: aload_1
    //   101: invokestatic 334	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   104: ifne +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 339	java/lang/Throwable:printStackTrace	()V
    //   111: aload_0
    //   112: monitorexit
    //   113: return
    //   114: astore_2
    //   115: aload_1
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	b
    //   88	28	1	localThrowable	Throwable
    //   119	4	1	localObject2	Object
    //   34	6	2	localad	ad
    //   114	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   62	85	88	finally
    //   30	35	114	finally
    //   39	49	114	finally
    //   49	51	114	finally
    //   2	20	119	finally
    //   23	30	119	finally
    //   51	62	119	finally
    //   89	111	119	finally
    //   115	119	119	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    d(paramBoolean);
    boolean bool = f();
    com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
    paramBoolean = bool;
    if (locala != null) {
      if ((bool) && (locala.c().e)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
    if (paramBoolean != e())
    {
      y.a("anr changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
      c(paramBoolean);
    }
  }
  
  public final boolean a()
  {
    return this.a.get();
  }
  
  public final void b()
  {
    try
    {
      y.d("customer decides whether to open or close.", new Object[0]);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final class a
    extends FileObserver
  {
    a(String paramString, int paramInt)
    {
      super(8);
    }
    
    public final void onEvent(int paramInt, final String paramString)
    {
      if (paramString == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("/data/anr/");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      y.d("watching file %s", new Object[] { paramString });
      if (!paramString.contains("trace"))
      {
        y.d("not anr file %s", new Object[] { paramString });
        return;
      }
      b.a(b.this).a(new a(paramString));
    }
    
    final class a
      implements Runnable
    {
      a(String paramString) {}
      
      public final void run()
      {
        b.a(b.this, paramString);
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      b.b(b.this);
    }
  }
  
  final class c
    implements ad.a
  {
    c() {}
    
    public final void a(boolean paramBoolean, long paramLong)
    {
      if (!paramBoolean) {
        return;
      }
      if (b.this.a())
      {
        y.c("anr is processing, return", new Object[0]);
        return;
      }
      y.c("main thread blocked overdue, blockTime:%s", new Object[] { Long.valueOf(paramLong) });
      if (!com.tencent.bugly.proguard.a.a(b.c(b.this)))
      {
        y.c("proc is not in anr, wait next check", new Object[0]);
        return;
      }
      paramLong = System.currentTimeMillis();
      if (b.a(b.this, paramLong)) {
        return;
      }
      if (!b.a(b.this, true)) {
        return;
      }
      y.c("found anr", new Object[0]);
      Object localObject = NativeCrashHandler.getInstance();
      if ((localObject != null) && (((NativeCrashHandler)localObject).isEnableCatchAnrTrace()))
      {
        y.c("anr trace enable, do dump trace", new Object[0]);
        ((NativeCrashHandler)localObject).dumpAnrNativeStack();
        return;
      }
      y.c("anr trace not enable", new Object[0]);
      localObject = b.d(b.this);
      StringBuilder localStringBuilder = new StringBuilder("manual_bugly_trace_");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(".txt");
      localObject = new File((String)localObject, localStringBuilder.toString());
      y.a("create new trace file:%s", new Object[] { ((File)localObject).getAbsoluteFile() });
      z.a((File)localObject, "android trace not enable\n", 101376L, true);
    }
  }
  
  final class d
    extends FileObserver
  {
    d(String paramString, int paramInt)
    {
      super(8);
    }
    
    public final void onEvent(int paramInt, String paramString)
    {
      if (paramString == null) {
        return;
      }
      y.d("observe file, dir:%s fileName:%s", new Object[] { b.d(b.this), paramString });
      if (!b.a(paramString))
      {
        y.c("not manual trace file, ignore.", new Object[0]);
        return;
      }
      if (!b.this.a())
      {
        y.c("proc is not in anr, just ignore", new Object[0]);
        return;
      }
      long l = z.a(paramString, "manual_bugly_trace_", ".txt");
      b localb = b.this;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.d(b.this));
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      b.a(localb, l, localStringBuilder.toString());
      y.c("Finish handling one anr.", new Object[0]);
    }
  }
  
  final class e
    implements Runnable
  {
    e() {}
    
    public final void run()
    {
      b.b(b.this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.b
 * JD-Core Version:    0.7.0.1
 */