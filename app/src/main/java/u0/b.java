package u0;

import android.os.CancellationSignal;

public final class b
{
  private boolean a;
  private a b;
  private Object c;
  private boolean d;
  
  private void e()
  {
    for (;;)
    {
      if (this.d) {}
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException) {}
      return;
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	u0/b:a	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 28	u0/b:a	Z
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 23	u0/b:d	Z
    //   22: aload_0
    //   23: getfield 30	u0/b:b	Lu0/b$a;
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 32	u0/b:c	Ljava/lang/Object;
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: ifnull +12 -> 47
    //   38: aload_1
    //   39: invokeinterface 34 1 0
    //   44: goto +3 -> 47
    //   47: aload_2
    //   48: ifnull +33 -> 81
    //   51: aload_2
    //   52: checkcast 36	android/os/CancellationSignal
    //   55: invokevirtual 39	android/os/CancellationSignal:cancel	()V
    //   58: goto +23 -> 81
    //   61: aload_0
    //   62: monitorenter
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 23	u0/b:d	Z
    //   68: aload_0
    //   69: invokevirtual 42	java/lang/Object:notifyAll	()V
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    //   81: aload_0
    //   82: monitorenter
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 23	u0/b:d	Z
    //   88: aload_0
    //   89: invokevirtual 42	java/lang/Object:notifyAll	()V
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: goto -45 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	b
    //   26	49	1	locala	a
    //   76	4	1	localObject1	Object
    //   95	4	1	localObject2	Object
    //   100	4	1	localObject3	Object
    //   105	1	1	localObject4	Object
    //   31	21	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   63	74	76	finally
    //   77	79	76	finally
    //   83	94	95	finally
    //   96	98	95	finally
    //   2	11	100	finally
    //   12	34	100	finally
    //   101	103	100	finally
    //   38	44	105	finally
    //   51	58	105	finally
  }
  
  public Object b()
  {
    try
    {
      if (this.c == null)
      {
        localObject1 = new CancellationSignal();
        this.c = localObject1;
        if (this.a)
        {
          CancellationSignal localCancellationSignal = (CancellationSignal)localObject1;
          ((CancellationSignal)localObject1).cancel();
        }
      }
      Object localObject1 = this.c;
      return localObject1;
    }
    finally {}
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally {}
  }
  
  public void d(a parama)
  {
    try
    {
      e();
      if (this.b == parama) {
        return;
      }
      this.b = parama;
      if ((this.a) && (parama != null))
      {
        parama.a();
        return;
      }
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u0.b
 * JD-Core Version:    0.7.0.1
 */