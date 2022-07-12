package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.bugly.crashreport.crash.anr.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ac
  implements Runnable
{
  private final Handler a;
  private final List<c> b = new LinkedList();
  private long c;
  private final long d;
  private boolean e;
  private long f;
  
  ac(Handler paramHandler, String paramString, long paramLong)
  {
    this.a = paramHandler;
    this.c = 5000L;
    this.d = 5000L;
    this.e = true;
  }
  
  public final void a()
  {
    if (!this.e) {
      return;
    }
    this.e = false;
    this.f = SystemClock.uptimeMillis();
    this.a.post(this);
  }
  
  public final void a(long paramLong)
  {
    this.c = 5000L;
  }
  
  public final List<c> b(long paramLong)
  {
    paramLong = System.currentTimeMillis();
    for (;;)
    {
      int i;
      synchronized (this.b)
      {
        ArrayList localArrayList = new ArrayList(this.b.size());
        i = 0;
        if (i < this.b.size())
        {
          c localc = (c)this.b.get(i);
          if ((!localc.d()) && (paramLong - localc.c() < 200000L))
          {
            localArrayList.add(localc);
            localc.a(true);
          }
        }
        else
        {
          return localArrayList;
        }
      }
      i += 1;
    }
  }
  
  public final boolean b()
  {
    return (!this.e) && (SystemClock.uptimeMillis() >= this.f + this.c);
  }
  
  public final long c()
  {
    return SystemClock.uptimeMillis() - this.f;
  }
  
  /* Error */
  public final void d()
  {
    // Byte code:
    //   0: new 96	java/lang/StringBuilder
    //   3: dup
    //   4: sipush 1024
    //   7: invokespecial 97	java/lang/StringBuilder:<init>	(I)V
    //   10: astore_3
    //   11: invokestatic 100	java/lang/System:nanoTime	()J
    //   14: pop2
    //   15: aload_0
    //   16: getfield 29	com/tencent/bugly/proguard/ac:a	Landroid/os/Handler;
    //   19: invokevirtual 104	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   22: invokevirtual 110	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   25: invokevirtual 116	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   28: astore 4
    //   30: aload 4
    //   32: arraylength
    //   33: ifne +13 -> 46
    //   36: aload_3
    //   37: ldc 118
    //   39: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: goto +69 -> 112
    //   46: aload 4
    //   48: arraylength
    //   49: istore_2
    //   50: iconst_0
    //   51: istore_1
    //   52: iload_1
    //   53: iload_2
    //   54: if_icmpge +58 -> 112
    //   57: aload_3
    //   58: aload 4
    //   60: iload_1
    //   61: aaload
    //   62: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_3
    //   67: ldc 127
    //   69: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: iload_1
    //   74: iconst_1
    //   75: iadd
    //   76: istore_1
    //   77: goto -25 -> 52
    //   80: astore 4
    //   82: aload_3
    //   83: ldc 129
    //   85: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_3
    //   90: aload 4
    //   92: invokevirtual 133	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   95: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_3
    //   100: ldc 127
    //   102: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 4
    //   108: invokestatic 138	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   111: pop
    //   112: invokestatic 100	java/lang/System:nanoTime	()J
    //   115: pop2
    //   116: new 76	com/tencent/bugly/crashreport/crash/anr/c
    //   119: dup
    //   120: aload_3
    //   121: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 59	java/lang/System:currentTimeMillis	()J
    //   127: invokespecial 144	com/tencent/bugly/crashreport/crash/anr/c:<init>	(Ljava/lang/String;J)V
    //   130: astore 4
    //   132: aload 4
    //   134: aload_0
    //   135: getfield 29	com/tencent/bugly/proguard/ac:a	Landroid/os/Handler;
    //   138: invokevirtual 104	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   141: invokevirtual 110	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   144: invokevirtual 147	java/lang/Thread:getName	()Ljava/lang/String;
    //   147: invokevirtual 150	com/tencent/bugly/crashreport/crash/anr/c:a	(Ljava/lang/String;)V
    //   150: aload_0
    //   151: getfield 27	com/tencent/bugly/proguard/ac:b	Ljava/util/List;
    //   154: astore_3
    //   155: aload_3
    //   156: monitorenter
    //   157: aload_0
    //   158: getfield 27	com/tencent/bugly/proguard/ac:b	Ljava/util/List;
    //   161: invokeinterface 67 1 0
    //   166: bipush 32
    //   168: if_icmplt +17 -> 185
    //   171: aload_0
    //   172: getfield 27	com/tencent/bugly/proguard/ac:b	Ljava/util/List;
    //   175: iconst_0
    //   176: invokeinterface 153 2 0
    //   181: pop
    //   182: goto -25 -> 157
    //   185: aload_0
    //   186: getfield 27	com/tencent/bugly/proguard/ac:b	Ljava/util/List;
    //   189: aload 4
    //   191: invokeinterface 87 2 0
    //   196: pop
    //   197: aload_3
    //   198: monitorexit
    //   199: return
    //   200: astore 4
    //   202: aload_3
    //   203: monitorexit
    //   204: aload 4
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	ac
    //   51	26	1	i	int
    //   49	6	2	j	int
    //   28	31	4	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    //   80	27	4	localSecurityException	java.lang.SecurityException
    //   130	60	4	localc	c
    //   200	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	43	80	java/lang/SecurityException
    //   46	50	80	java/lang/SecurityException
    //   57	73	80	java/lang/SecurityException
    //   157	182	200	finally
    //   185	199	200	finally
  }
  
  public final void run()
  {
    this.e = true;
    this.c = this.d;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.ac
 * JD-Core Version:    0.7.0.1
 */