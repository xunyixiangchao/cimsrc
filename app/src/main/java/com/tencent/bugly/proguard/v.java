package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public final class v
{
  private static v a;
  private final o b;
  private final Context c;
  private Map<Integer, Long> d = new HashMap();
  private long e;
  private long f;
  private LinkedBlockingQueue<Runnable> g = new LinkedBlockingQueue();
  private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue();
  private final Object i = new Object();
  private int j = 0;
  
  private v(Context paramContext)
  {
    this.c = paramContext;
    this.b = o.a();
  }
  
  public static v a()
  {
    try
    {
      v localv = a;
      return localv;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static v a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new v(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt, LinkedBlockingQueue<Runnable> paramLinkedBlockingQueue)
  {
    x localx = x.a();
    if (paramInt > 0) {
      y.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    }
    int k = 0;
    while (k < paramInt)
    {
      final Runnable localRunnable = (Runnable)paramLinkedBlockingQueue.poll();
      if (localRunnable != null) {
        synchronized (this.i)
        {
          if ((this.j >= 2) && (localx != null))
          {
            localx.a(localRunnable);
          }
          else
          {
            y.a("[UploadManager] Create and start a new thread to execute a upload task: %s", new Object[] { "BUGLY_ASYNC_UPLOAD" });
            if (ab.a(new a(localRunnable), "BUGLY_ASYNC_UPLOAD") != null) {
              synchronized (this.i)
              {
                this.j += 1;
              }
            }
            y.d("[UploadManager] Failed to start a thread to execute asynchronous upload task,will try again next time.", new Object[0]);
            a(localRunnable, true);
          }
          k += 1;
        }
      }
    }
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (paramRunnable == null) {
      y.d("[UploadManager] Upload task should not be null", new Object[0]);
    }
    y.c("[UploadManager] Add upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (paramBoolean2)
    {
      if (paramRunnable == null)
      {
        y.d("[UploadManager] Upload task should not be null", new Object[0]);
        return;
      }
      y.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      Thread localThread = ab.a(paramRunnable, "BUGLY_SYNC_UPLOAD");
      if (localThread == null)
      {
        y.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
        a(paramRunnable, true);
        return;
      }
      try
      {
        localThread.join(paramLong);
        return;
      }
      finally
      {
        y.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", new Object[] { localObject.getMessage() });
        a(paramRunnable, true);
        c(0);
        return;
      }
    }
    a(paramRunnable, paramBoolean1);
    c(0);
  }
  
  /* Error */
  private static void a(LinkedBlockingQueue<Runnable> paramLinkedBlockingQueue1, LinkedBlockingQueue<Runnable> paramLinkedBlockingQueue2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iload_3
    //   3: iload_2
    //   4: if_icmpge +58 -> 62
    //   7: aload_0
    //   8: invokevirtual 161	java/util/concurrent/LinkedBlockingQueue:peek	()Ljava/lang/Object;
    //   11: checkcast 101	java/lang/Runnable
    //   14: astore 4
    //   16: aload 4
    //   18: ifnull +44 -> 62
    //   21: aload_1
    //   22: aload 4
    //   24: invokevirtual 165	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
    //   27: aload_0
    //   28: invokevirtual 99	java/util/concurrent/LinkedBlockingQueue:poll	()Ljava/lang/Object;
    //   31: pop
    //   32: goto +23 -> 55
    //   35: astore 4
    //   37: ldc 167
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload 4
    //   47: invokevirtual 154	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   50: aastore
    //   51: invokestatic 140	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   54: pop
    //   55: iload_3
    //   56: iconst_1
    //   57: iadd
    //   58: istore_3
    //   59: goto -57 -> 2
    //   62: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramLinkedBlockingQueue1	LinkedBlockingQueue<Runnable>
    //   0	63	1	paramLinkedBlockingQueue2	LinkedBlockingQueue<Runnable>
    //   0	63	2	paramInt	int
    //   1	58	3	k	int
    //   14	9	4	localRunnable	Runnable
    //   35	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	32	35	finally
  }
  
  private boolean a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramRunnable == null)
    {
      y.a("[UploadManager] Upload task should not be null", new Object[0]);
      return false;
    }
    try
    {
      y.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      Object localObject = this.i;
      if (paramBoolean) {}
      try
      {
        for (LinkedBlockingQueue localLinkedBlockingQueue = this.g;; localLinkedBlockingQueue = this.h)
        {
          localLinkedBlockingQueue.put(paramRunnable);
          break;
        }
        return true;
      }
      finally {}
      return false;
    }
    finally
    {
      y.e("[UploadManager] Failed to add upload task to queue: %s", new Object[] { paramRunnable.getMessage() });
    }
  }
  
  private void c(final int paramInt)
  {
    x localx = x.a();
    LinkedBlockingQueue localLinkedBlockingQueue2 = new LinkedBlockingQueue();
    final LinkedBlockingQueue localLinkedBlockingQueue1 = new LinkedBlockingQueue();
    for (;;)
    {
      synchronized (this.i)
      {
        y.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        int k = this.g.size();
        paramInt = this.h.size();
        if ((k == 0) && (paramInt == 0))
        {
          y.c("[UploadManager] There is no upload task in queue.", new Object[0]);
          return;
        }
        if ((localx != null) && (localx.c()))
        {
          a(this.g, localLinkedBlockingQueue2, k);
          a(this.h, localLinkedBlockingQueue1, paramInt);
          a(k, localLinkedBlockingQueue2);
          if (paramInt > 0) {
            y.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
          }
          ??? = x.a();
          if (??? != null) {
            ((x)???).a(new b(paramInt, localLinkedBlockingQueue1));
          }
          return;
        }
      }
      paramInt = 0;
    }
  }
  
  public final long a(int paramInt)
  {
    if (paramInt >= 0) {}
    try
    {
      Long localLong = (Long)this.d.get(Integer.valueOf(paramInt));
      if (localLong != null)
      {
        long l = localLong.longValue();
        return l;
        y.e("[UploadManager] Unknown upload ID: %d", new Object[] { Integer.valueOf(paramInt) });
      }
      return 0L;
    }
    finally {}
  }
  
  public final long a(boolean paramBoolean)
  {
    long l4 = ab.b();
    int k;
    if (paramBoolean) {
      k = 5;
    } else {
      k = 3;
    }
    List localList = this.b.a(k);
    long l2;
    long l1;
    if ((localList != null) && (localList.size() > 0))
    {
      long l3 = 0L;
      l2 = l3;
      try
      {
        q localq = (q)localList.get(0);
        l2 = l3;
        l1 = l3;
        if (localq.e >= l4)
        {
          l2 = l3;
          l1 = ab.b(localq.g);
          if (k == 3)
          {
            l2 = l1;
            this.e = l1;
          }
          else
          {
            l2 = l1;
            this.f = l1;
          }
          l2 = l1;
          localList.remove(localq);
        }
      }
      finally
      {
        y.a(localThrowable);
        l1 = l2;
      }
      l2 = l1;
      if (localList.size() > 0)
      {
        this.b.a(localList);
        l2 = l1;
      }
    }
    else
    {
      if (paramBoolean) {
        l1 = this.f;
      } else {
        l1 = this.e;
      }
      l2 = l1;
    }
    y.c("[UploadManager] Local network consume: %d KB", new Object[] { Long.valueOf(l2 / 1024L) });
    return l2;
  }
  
  public final void a(int paramInt, long paramLong)
  {
    if (paramInt >= 0) {}
    try
    {
      this.d.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
      q localq = new q();
      localq.b = paramInt;
      localq.e = paramLong;
      localq.c = "";
      localq.d = "";
      localq.g = new byte[0];
      this.b.b(paramInt);
      this.b.a(localq);
      y.c("[UploadManager] Uploading(ID:%d) time: %s", new Object[] { Integer.valueOf(paramInt), ab.a(paramLong) });
      return;
    }
    finally {}
    y.e("[UploadManager] Unknown uploading ID: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public final void a(int paramInt, an paraman, String paramString1, String paramString2, u paramu, long paramLong, boolean paramBoolean)
  {
    int k = paraman.g;
    paraman = a.a(paraman);
    try
    {
      a(new w(this.c, paramInt, k, paraman, paramString1, paramString2, paramu, true, paramBoolean), true, true, paramLong);
      return;
    }
    finally
    {
      break label48;
    }
  }
  
  public final void a(int paramInt, an paraman, String paramString1, String paramString2, u paramu, boolean paramBoolean)
  {
    int k = paraman.g;
    paraman = a.a(paraman);
    try
    {
      a(new w(this.c, paramInt, k, paraman, paramString1, paramString2, paramu, 0, 0, false, null), paramBoolean, false, 0L);
      return;
    }
    finally
    {
      break label49;
    }
  }
  
  protected final void a(long paramLong, boolean paramBoolean)
  {
    int k;
    if (paramBoolean) {
      k = 5;
    } else {
      k = 3;
    }
    try
    {
      q localq = new q();
      localq.b = k;
      localq.e = ab.b();
      localq.c = "";
      localq.d = "";
      localq.g = ab.c(paramLong);
      this.b.b(k);
      this.b.a(localq);
      if (paramBoolean) {
        this.f = paramLong;
      } else {
        this.e = paramLong;
      }
      y.c("[UploadManager] Network total consume: %d KB", new Object[] { Long.valueOf(paramLong / 1024L) });
      return;
    }
    finally {}
  }
  
  public final boolean b(int paramInt)
  {
    if (b.c)
    {
      y.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
      return true;
    }
    long l = System.currentTimeMillis() - a(paramInt);
    y.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(paramInt) });
    if (l < 30000L)
    {
      y.a("[UploadManager] Data only be uploaded once in %d seconds.", new Object[] { Long.valueOf(30L) });
      return false;
    }
    return true;
  }
  
  final class a
    implements Runnable
  {
    a(Runnable paramRunnable) {}
    
    public final void run()
    {
      localRunnable.run();
      synchronized (v.a(v.this))
      {
        v.b(v.this);
        return;
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b(int paramInt, LinkedBlockingQueue paramLinkedBlockingQueue) {}
    
    public final void run()
    {
      int i = 0;
      while (i < paramInt)
      {
        Runnable localRunnable = (Runnable)localLinkedBlockingQueue1.poll();
        if (localRunnable == null) {
          break;
        }
        localRunnable.run();
        i += 1;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.v
 * JD-Core Version:    0.7.0.1
 */