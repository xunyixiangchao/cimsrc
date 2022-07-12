package com.yanzhenjie.permission.bridge;

import java.util.concurrent.BlockingQueue;

final class c
  extends Thread
  implements b.a
{
  private final BlockingQueue<a> a;
  private a b;
  private b c;
  
  public c(BlockingQueue<a> paramBlockingQueue)
  {
    this.a = paramBlockingQueue;
  }
  
  private void a()
  {
    switch (this.b.d())
    {
    default: 
      return;
    case 8: 
      BridgeActivity.h(this.b.c());
      return;
    case 7: 
      BridgeActivity.d(this.b.c());
      return;
    case 6: 
      BridgeActivity.e(this.b.c());
      return;
    case 5: 
      BridgeActivity.a(this.b.c());
      return;
    case 4: 
      BridgeActivity.f(this.b.c());
      return;
    case 3: 
      BridgeActivity.c(this.b.c());
      return;
    case 2: 
      BridgeActivity.g(this.b.c(), this.b.b());
      return;
    }
    BridgeActivity.b(this.b.c());
  }
  
  public void b()
  {
    try
    {
      this.c.c();
      this.b.a().b();
      notify();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 20	com/yanzhenjie/permission/bridge/c:a	Ljava/util/concurrent/BlockingQueue;
    //   7: invokeinterface 88 1 0
    //   12: checkcast 27	com/yanzhenjie/permission/bridge/a
    //   15: putfield 25	com/yanzhenjie/permission/bridge/c:b	Lcom/yanzhenjie/permission/bridge/a;
    //   18: new 65	com/yanzhenjie/permission/bridge/b
    //   21: dup
    //   22: aload_0
    //   23: getfield 25	com/yanzhenjie/permission/bridge/c:b	Lcom/yanzhenjie/permission/bridge/a;
    //   26: invokevirtual 34	com/yanzhenjie/permission/bridge/a:c	()Ll8/c;
    //   29: invokevirtual 93	l8/c:c	()Landroid/content/Context;
    //   32: aload_0
    //   33: invokespecial 96	com/yanzhenjie/permission/bridge/b:<init>	(Landroid/content/Context;Lcom/yanzhenjie/permission/bridge/b$a;)V
    //   36: astore_1
    //   37: aload_0
    //   38: aload_1
    //   39: putfield 63	com/yanzhenjie/permission/bridge/c:c	Lcom/yanzhenjie/permission/bridge/b;
    //   42: aload_1
    //   43: invokevirtual 98	com/yanzhenjie/permission/bridge/b:a	()V
    //   46: aload_0
    //   47: invokespecial 99	com/yanzhenjie/permission/bridge/c:a	()V
    //   50: aload_0
    //   51: invokevirtual 102	java/lang/Object:wait	()V
    //   54: goto +8 -> 62
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 105	java/lang/InterruptedException:printStackTrace	()V
    //   62: aload_0
    //   63: monitorexit
    //   64: goto -64 -> 0
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: goto -11 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	c
    //   36	7	1	localb	b
    //   57	2	1	localInterruptedException1	java.lang.InterruptedException
    //   67	4	1	localObject	Object
    //   72	1	1	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   50	54	57	java/lang/InterruptedException
    //   2	18	67	finally
    //   18	50	67	finally
    //   50	54	67	finally
    //   58	62	67	finally
    //   62	64	67	finally
    //   68	70	67	finally
    //   2	18	72	java/lang/InterruptedException
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yanzhenjie.permission.bridge.c
 * JD-Core Version:    0.7.0.1
 */