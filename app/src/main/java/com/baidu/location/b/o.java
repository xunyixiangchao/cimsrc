package com.baidu.location.b;

import android.os.HandlerThread;

public class o
{
  private static HandlerThread a;
  
  /* Error */
  public static HandlerThread a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 12	com/baidu/location/b/o:a	Landroid/os/HandlerThread;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +35 -> 43
    //   11: new 14	android/os/HandlerThread
    //   14: dup
    //   15: ldc 16
    //   17: bipush 10
    //   19: invokespecial 20	android/os/HandlerThread:<init>	(Ljava/lang/String;I)V
    //   22: astore_0
    //   23: aload_0
    //   24: putstatic 12	com/baidu/location/b/o:a	Landroid/os/HandlerThread;
    //   27: aload_0
    //   28: invokevirtual 23	android/os/HandlerThread:start	()V
    //   31: goto +12 -> 43
    //   34: astore_0
    //   35: aload_0
    //   36: invokevirtual 28	java/lang/Throwable:printStackTrace	()V
    //   39: aconst_null
    //   40: putstatic 12	com/baidu/location/b/o:a	Landroid/os/HandlerThread;
    //   43: getstatic 12	com/baidu/location/b/o:a	Landroid/os/HandlerThread;
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	22	0	localHandlerThread1	HandlerThread
    //   34	2	0	localObject1	Object
    //   46	5	0	localHandlerThread2	HandlerThread
    //   52	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	31	34	finally
    //   3	7	52	finally
    //   35	43	52	finally
    //   43	47	52	finally
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.o
 * JD-Core Version:    0.7.0.1
 */