package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy.a;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static int a = 0;
  public static boolean b = false;
  public static int c = 2;
  public static boolean d = false;
  public static int e = 20480;
  public static int f = 20480;
  public static long g = 604800000L;
  public static String h;
  public static boolean i = false;
  public static String j;
  public static int k = 5000;
  public static boolean l = true;
  public static boolean m = false;
  public static String n;
  public static String o;
  private static c r;
  public final b p;
  private final Context q;
  private final e s;
  private final NativeCrashHandler t;
  private com.tencent.bugly.crashreport.common.strategy.a u;
  private x v;
  private final com.tencent.bugly.crashreport.crash.anr.b w;
  private Boolean x;
  private int y = 31;
  private boolean z = false;
  
  private c(int paramInt, Context paramContext, x paramx, boolean paramBoolean, BuglyStrategy.a parama, n paramn, String paramString)
  {
    a = paramInt;
    paramContext = ab.a(paramContext);
    this.q = paramContext;
    this.u = com.tencent.bugly.crashreport.common.strategy.a.a();
    this.v = paramx;
    Object localObject = v.a();
    o localo = o.a();
    paramn = new b(paramInt, paramContext, (v)localObject, localo, this.u, parama, paramn);
    this.p = paramn;
    localObject = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    this.s = new e(paramContext, paramn, this.u, (com.tencent.bugly.crashreport.common.info.a)localObject);
    paramString = NativeCrashHandler.getInstance(paramContext, (com.tencent.bugly.crashreport.common.info.a)localObject, paramn, this.u, paramx, paramBoolean, paramString);
    this.t = paramString;
    ((com.tencent.bugly.crashreport.common.info.a)localObject).D = paramString;
    this.w = com.tencent.bugly.crashreport.crash.anr.b.a(paramContext, this.u, (com.tencent.bugly.crashreport.common.info.a)localObject, paramx, localo, paramn, parama);
  }
  
  public static c a()
  {
    try
    {
      c localc = r;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static c a(int paramInt, Context paramContext, boolean paramBoolean, BuglyStrategy.a parama, n paramn, String paramString)
  {
    try
    {
      if (r == null) {
        r = new c(1004, paramContext, x.a(), paramBoolean, parama, null, null);
      }
      paramContext = r;
      return paramContext;
    }
    finally {}
  }
  
  public final void a(int paramInt)
  {
    this.y = paramInt;
  }
  
  public final void a(long paramLong)
  {
    x.a().a(new b(), paramLong);
  }
  
  public final void a(StrategyBean paramStrategyBean)
  {
    this.s.a(paramStrategyBean);
    this.t.onStrategyChanged(paramStrategyBean);
    this.w.b();
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean)
  {
    this.p.e(paramCrashDetailBean);
  }
  
  public final void a(final Thread paramThread, final Throwable paramThrowable, boolean paramBoolean1, String paramString, byte[] paramArrayOfByte, final boolean paramBoolean2, boolean paramBoolean3)
  {
    this.v.a(new a(false, paramThread, paramThrowable, null, null, true, paramBoolean2));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      this.t.testNativeCrash(paramBoolean1, paramBoolean2, paramBoolean3);
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
    Object localObject1 = this.x;
    if (localObject1 != null) {
      return ((Boolean)localObject1).booleanValue();
    }
    localObject1 = com.tencent.bugly.crashreport.common.info.a.b().d;
    Object localObject2 = o.a().a(1);
    ArrayList localArrayList = new ArrayList();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        q localq = (q)((Iterator)localObject2).next();
        if (((String)localObject1).equals(localq.c))
        {
          this.x = Boolean.TRUE;
          localArrayList.add(localq);
        }
      }
      if (localArrayList.size() > 0) {
        o.a().a(localArrayList);
      }
      return true;
    }
    this.x = Boolean.FALSE;
    return false;
  }
  
  public final void c()
  {
    try
    {
      this.s.a();
      this.t.setUserOpened(true);
      this.w.a(true);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void d()
  {
    try
    {
      this.s.b();
      this.t.setUserOpened(false);
      this.w.a(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void e()
  {
    this.s.b();
  }
  
  public final void f()
  {
    this.s.a();
  }
  
  public final void g()
  {
    this.t.setUserOpened(false);
  }
  
  public final void h()
  {
    this.t.setUserOpened(true);
  }
  
  public final void i()
  {
    this.w.a(true);
  }
  
  public final void j()
  {
    this.w.a(false);
  }
  
  public final void k()
  {
    this.t.enableCatchAnrTrace();
  }
  
  /* Error */
  public final void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_1
    //   4: iload_1
    //   5: iconst_1
    //   6: iadd
    //   7: istore_2
    //   8: iload_1
    //   9: bipush 30
    //   11: if_icmpge +51 -> 62
    //   14: ldc 248
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: iload_2
    //   23: invokestatic 254	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 259	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   30: pop
    //   31: ldc2_w 260
    //   34: invokestatic 263	com/tencent/bugly/proguard/ab:b	(J)V
    //   37: iload_2
    //   38: istore_1
    //   39: goto -35 -> 4
    //   42: astore_3
    //   43: aload_3
    //   44: invokestatic 266	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   47: ifne +7 -> 54
    //   50: aload_3
    //   51: invokevirtual 271	java/lang/Throwable:printStackTrace	()V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: astore_3
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_3
    //   61: athrow
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	c
    //   3	36	1	i1	int
    //   7	31	2	i2	int
    //   42	9	3	localThrowable	Throwable
    //   57	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	37	42	finally
    //   43	54	57	finally
  }
  
  public final boolean m()
  {
    return this.w.a();
  }
  
  public final void n()
  {
    this.t.checkUploadRecordCrash();
  }
  
  public final void o()
  {
    if (com.tencent.bugly.crashreport.common.info.a.b().d.equals(AppInfo.a(this.q))) {
      this.t.removeEmptyNativeRecordFiles();
    }
  }
  
  public final boolean p()
  {
    return this.z;
  }
  
  public final boolean q()
  {
    return (this.y & 0x10) > 0;
  }
  
  public final boolean r()
  {
    return (this.y & 0x8) > 0;
  }
  
  public final boolean s()
  {
    return (this.y & 0x4) > 0;
  }
  
  public final boolean t()
  {
    return (this.y & 0x2) > 0;
  }
  
  public final boolean u()
  {
    return (this.y & 0x1) > 0;
  }
  
  final class a
    implements Runnable
  {
    a(boolean paramBoolean1, Thread paramThread, Throwable paramThrowable, String paramString, byte[] paramArrayOfByte, boolean paramBoolean2, boolean paramBoolean3) {}
    
    public final void run()
    {
      try
      {
        y.c("post a throwable %b", new Object[] { Boolean.valueOf(this.a) });
        c.a(c.this).a(paramThread, paramThrowable, false, this.d, this.e, this.f);
        if (paramBoolean2)
        {
          y.a("clear user datas", new Object[0]);
          com.tencent.bugly.crashreport.common.info.a.a(c.b(c.this)).y();
        }
        return;
      }
      finally
      {
        if (!y.b(localThrowable)) {
          localThrowable.printStackTrace();
        }
        y.e("java catch error: %s", new Object[] { paramThrowable.toString() });
      }
    }
  }
  
  final class b
    extends Thread
  {
    b() {}
    
    public final void run()
    {
      boolean bool = ab.a(c.b(c.this), "local_crash_lock", 10000L);
      int i = 0;
      if (!bool)
      {
        y.c("Failed to lock file for uploading local crash.", new Object[0]);
        return;
      }
      t.a().b();
      Object localObject = c.this.p.a();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        y.c("Size of crash list: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
        int j = ((List)localObject).size();
        if (j > 20L)
        {
          ArrayList localArrayList = new ArrayList();
          Collections.sort((List)localObject);
          while (i < 20L)
          {
            localArrayList.add(((List)localObject).get(j - 1 - i));
            i += 1;
          }
          localObject = localArrayList;
        }
        c.this.p.a((List)localObject, 0L, false, false, false);
      }
      else
      {
        y.c("no crash need to be uploaded at this start", new Object[0]);
      }
      ab.b(c.b(c.this), "local_crash_lock");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.crash.c
 * JD-Core Version:    0.7.0.1
 */