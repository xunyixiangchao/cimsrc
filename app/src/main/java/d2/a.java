package d2;

import android.os.Process;
import b2.f;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import x2.k;

final class a
{
  private final boolean a;
  private final Executor b;
  final Map<f, d> c = new HashMap();
  private final ReferenceQueue<p<?>> d = new ReferenceQueue();
  private p.a e;
  private volatile boolean f;
  private volatile c g;
  
  a(boolean paramBoolean)
  {
    this(paramBoolean, Executors.newSingleThreadExecutor(new a()));
  }
  
  a(boolean paramBoolean, Executor paramExecutor)
  {
    this.a = paramBoolean;
    this.b = paramExecutor;
    paramExecutor.execute(new b());
  }
  
  void a(f paramf, p<?> paramp)
  {
    try
    {
      paramp = new d(paramf, paramp, this.d, this.a);
      paramf = (d)this.c.put(paramf, paramp);
      if (paramf != null) {
        paramf.a();
      }
      return;
    }
    finally {}
  }
  
  void b()
  {
    while (!this.f)
    {
      try
      {
        c((d)this.d.remove());
        c localc = this.g;
        if (localc == null) {
          continue;
        }
        localc.a();
      }
      catch (InterruptedException localInterruptedException)
      {
        label39:
        break label39;
      }
      Thread.currentThread().interrupt();
    }
  }
  
  void c(d paramd)
  {
    try
    {
      this.c.remove(paramd.a);
      if (paramd.b)
      {
        Object localObject = paramd.c;
        if (localObject != null)
        {
          localObject = new p((v)localObject, true, false, paramd.a, this.e);
          this.e.d(paramd.a, (p)localObject);
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  void d(f paramf)
  {
    try
    {
      paramf = (d)this.c.remove(paramf);
      if (paramf != null) {
        paramf.a();
      }
      return;
    }
    finally {}
  }
  
  p<?> e(f paramf)
  {
    try
    {
      paramf = (d)this.c.get(paramf);
      if (paramf == null) {
        return null;
      }
      p localp = (p)paramf.get();
      if (localp == null) {
        c(paramf);
      }
      return localp;
    }
    finally {}
  }
  
  /* Error */
  void f(p.a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 120	d2/a:e	Ld2/p$a;
    //   9: aload_0
    //   10: monitorexit
    //   11: aload_1
    //   12: monitorexit
    //   13: return
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	a
    //   0	24	1	parama	p.a
    //   14	4	2	localObject1	Object
    //   19	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	11	14	finally
    //   15	17	14	finally
    //   2	4	19	finally
    //   11	13	19	finally
    //   17	19	19	finally
    //   20	22	19	finally
  }
  
  class a
    implements ThreadFactory
  {
    public Thread newThread(final Runnable paramRunnable)
    {
      return new Thread(new a(paramRunnable), "glide-active-resources");
    }
    
    class a
      implements Runnable
    {
      a(Runnable paramRunnable) {}
      
      public void run()
      {
        Process.setThreadPriority(10);
        paramRunnable.run();
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      a.this.b();
    }
  }
  
  static abstract interface c
  {
    public abstract void a();
  }
  
  static final class d
    extends WeakReference<p<?>>
  {
    final f a;
    final boolean b;
    v<?> c;
    
    d(f paramf, p<?> paramp, ReferenceQueue<? super p<?>> paramReferenceQueue, boolean paramBoolean)
    {
      super(paramReferenceQueue);
      this.a = ((f)k.d(paramf));
      if ((paramp.f()) && (paramBoolean)) {
        paramf = (v)k.d(paramp.e());
      } else {
        paramf = null;
      }
      this.c = paramf;
      this.b = paramp.f();
    }
    
    void a()
    {
      this.c = null;
      clear();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.a
 * JD-Core Version:    0.7.0.1
 */