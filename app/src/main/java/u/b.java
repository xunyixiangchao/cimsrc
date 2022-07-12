package u;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import x0.h;

class b<I, O>
  extends d<O>
  implements Runnable
{
  private a<? super I, ? extends O> c;
  private final BlockingQueue<Boolean> d = new LinkedBlockingQueue(1);
  private final CountDownLatch e = new CountDownLatch(1);
  private u7.a<? extends I> f;
  volatile u7.a<? extends O> g;
  
  b(a<? super I, ? extends O> parama, u7.a<? extends I> parama1)
  {
    this.c = ((a)h.g(parama));
    this.f = ((u7.a)h.g(parama1));
  }
  
  private void f(Future<?> paramFuture, boolean paramBoolean)
  {
    if (paramFuture != null) {
      paramFuture.cancel(paramBoolean);
    }
  }
  
  /* Error */
  private <E> void g(BlockingQueue<E> paramBlockingQueue, E paramE)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: aload_2
    //   4: invokeinterface 72 2 0
    //   9: iload_3
    //   10: ifeq +9 -> 19
    //   13: invokestatic 78	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 81	java/lang/Thread:interrupt	()V
    //   19: return
    //   20: astore_1
    //   21: iload_3
    //   22: ifeq +9 -> 31
    //   25: invokestatic 78	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   28: invokevirtual 81	java/lang/Thread:interrupt	()V
    //   31: aload_1
    //   32: athrow
    //   33: iconst_1
    //   34: istore_3
    //   35: goto -33 -> 2
    //   38: astore 4
    //   40: goto -7 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	b
    //   0	43	1	paramBlockingQueue	BlockingQueue<E>
    //   0	43	2	paramE	E
    //   1	34	3	i	int
    //   38	1	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	9	20	finally
    //   2	9	38	java/lang/InterruptedException
  }
  
  /* Error */
  private <E> E i(BlockingQueue<E> paramBlockingQueue)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: invokeinterface 88 1 0
    //   8: astore_3
    //   9: iload_2
    //   10: ifeq +9 -> 19
    //   13: invokestatic 78	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 81	java/lang/Thread:interrupt	()V
    //   19: aload_3
    //   20: areturn
    //   21: astore_1
    //   22: iload_2
    //   23: ifeq +9 -> 32
    //   26: invokestatic 78	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   29: invokevirtual 81	java/lang/Thread:interrupt	()V
    //   32: aload_1
    //   33: athrow
    //   34: iconst_1
    //   35: istore_2
    //   36: goto -34 -> 2
    //   39: astore_3
    //   40: goto -6 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	b
    //   0	43	1	paramBlockingQueue	BlockingQueue<E>
    //   1	35	2	i	int
    //   8	12	3	localObject	Object
    //   39	1	3	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	9	21	finally
    //   2	9	39	java/lang/InterruptedException
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    if (super.cancel(paramBoolean))
    {
      g(this.d, Boolean.valueOf(paramBoolean));
      f(this.f, paramBoolean);
      f(this.g, paramBoolean);
      return true;
    }
    return false;
  }
  
  public O get()
  {
    if (!isDone())
    {
      u7.a locala = this.f;
      if (locala != null) {
        locala.get();
      }
      this.e.await();
      locala = this.g;
      if (locala != null) {
        locala.get();
      }
    }
    return super.get();
  }
  
  public O get(long paramLong, TimeUnit paramTimeUnit)
  {
    long l = paramLong;
    Object localObject2 = paramTimeUnit;
    if (!isDone())
    {
      localObject2 = TimeUnit.NANOSECONDS;
      l = paramLong;
      Object localObject1 = paramTimeUnit;
      if (paramTimeUnit != localObject2)
      {
        l = ((TimeUnit)localObject2).convert(paramLong, paramTimeUnit);
        localObject1 = localObject2;
      }
      paramTimeUnit = this.f;
      paramLong = l;
      if (paramTimeUnit != null)
      {
        paramLong = System.nanoTime();
        paramTimeUnit.get(l, (TimeUnit)localObject1);
        paramLong = l - Math.max(0L, System.nanoTime() - paramLong);
      }
      l = System.nanoTime();
      if (this.e.await(paramLong, (TimeUnit)localObject1))
      {
        paramLong -= Math.max(0L, System.nanoTime() - l);
        paramTimeUnit = this.g;
        l = paramLong;
        localObject2 = localObject1;
        if (paramTimeUnit != null)
        {
          paramTimeUnit.get(paramLong, (TimeUnit)localObject1);
          l = paramLong;
          localObject2 = localObject1;
        }
      }
      else
      {
        throw new TimeoutException();
      }
    }
    return super.get(l, (TimeUnit)localObject2);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	u/b:f	Lu7/a;
    //   4: invokestatic 163	u/f:e	(Ljava/util/concurrent/Future;)Ljava/lang/Object;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 48	u/b:c	Lu/a;
    //   12: aload_1
    //   13: invokeinterface 167 2 0
    //   18: astore_1
    //   19: aload_0
    //   20: aload_1
    //   21: putfield 102	u/b:g	Lu7/a;
    //   24: aload_0
    //   25: invokevirtual 170	u/d:isCancelled	()Z
    //   28: ifeq +47 -> 75
    //   31: aload_1
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 34	u/b:d	Ljava/util/concurrent/BlockingQueue;
    //   37: invokespecial 172	u/b:i	(Ljava/util/concurrent/BlockingQueue;)Ljava/lang/Object;
    //   40: checkcast 92	java/lang/Boolean
    //   43: invokevirtual 175	java/lang/Boolean:booleanValue	()Z
    //   46: invokeinterface 62 2 0
    //   51: pop
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 102	u/b:g	Lu7/a;
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 48	u/b:c	Lu/a;
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 52	u/b:f	Lu7/a;
    //   67: aload_0
    //   68: getfield 39	u/b:e	Ljava/util/concurrent/CountDownLatch;
    //   71: invokevirtual 178	java/util/concurrent/CountDownLatch:countDown	()V
    //   74: return
    //   75: aload_1
    //   76: new 9	u/b$a
    //   79: dup
    //   80: aload_0
    //   81: aload_1
    //   82: invokespecial 181	u/b$a:<init>	(Lu/b;Lu7/a;)V
    //   85: invokestatic 186	t/a:a	()Ljava/util/concurrent/Executor;
    //   88: invokeinterface 190 3 0
    //   93: goto +31 -> 124
    //   96: astore_1
    //   97: aload_0
    //   98: aload_1
    //   99: invokevirtual 194	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   102: invokevirtual 197	u/d:c	(Ljava/lang/Throwable;)Z
    //   105: pop
    //   106: goto -49 -> 57
    //   109: aload_0
    //   110: iconst_0
    //   111: invokevirtual 198	u/b:cancel	(Z)Z
    //   114: pop
    //   115: goto -58 -> 57
    //   118: aload_0
    //   119: aload_1
    //   120: invokevirtual 197	u/d:c	(Ljava/lang/Throwable;)Z
    //   123: pop
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 48	u/b:c	Lu/a;
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 52	u/b:f	Lu7/a;
    //   134: aload_0
    //   135: getfield 39	u/b:e	Ljava/util/concurrent/CountDownLatch;
    //   138: invokevirtual 178	java/util/concurrent/CountDownLatch:countDown	()V
    //   141: return
    //   142: aload_1
    //   143: invokevirtual 199	java/lang/reflect/UndeclaredThrowableException:getCause	()Ljava/lang/Throwable;
    //   146: astore_1
    //   147: goto -29 -> 118
    //   150: aload_0
    //   151: aconst_null
    //   152: putfield 48	u/b:c	Lu/a;
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 52	u/b:f	Lu7/a;
    //   160: aload_0
    //   161: getfield 39	u/b:e	Ljava/util/concurrent/CountDownLatch;
    //   164: invokevirtual 178	java/util/concurrent/CountDownLatch:countDown	()V
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: goto -61 -> 109
    //   173: astore_1
    //   174: goto -24 -> 150
    //   177: astore_1
    //   178: goto -60 -> 118
    //   181: astore_1
    //   182: goto -64 -> 118
    //   185: astore_1
    //   186: goto -44 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	b
    //   7	75	1	localObject1	Object
    //   96	47	1	localExecutionException	java.util.concurrent.ExecutionException
    //   146	22	1	localThrowable	java.lang.Throwable
    //   169	1	1	localCancellationException	java.util.concurrent.CancellationException
    //   173	1	1	localObject2	Object
    //   177	1	1	localError	java.lang.Error
    //   181	1	1	localException	java.lang.Exception
    //   185	1	1	localUndeclaredThrowableException	java.lang.reflect.UndeclaredThrowableException
    // Exception table:
    //   from	to	target	type
    //   0	8	96	java/util/concurrent/ExecutionException
    //   0	8	169	java/util/concurrent/CancellationException
    //   0	8	173	finally
    //   8	57	173	finally
    //   75	93	173	finally
    //   97	106	173	finally
    //   109	115	173	finally
    //   118	124	173	finally
    //   142	147	173	finally
    //   0	8	177	java/lang/Error
    //   8	57	177	java/lang/Error
    //   75	93	177	java/lang/Error
    //   97	106	177	java/lang/Error
    //   109	115	177	java/lang/Error
    //   0	8	181	java/lang/Exception
    //   8	57	181	java/lang/Exception
    //   75	93	181	java/lang/Exception
    //   97	106	181	java/lang/Exception
    //   109	115	181	java/lang/Exception
    //   0	8	185	java/lang/reflect/UndeclaredThrowableException
    //   8	57	185	java/lang/reflect/UndeclaredThrowableException
    //   75	93	185	java/lang/reflect/UndeclaredThrowableException
    //   97	106	185	java/lang/reflect/UndeclaredThrowableException
    //   109	115	185	java/lang/reflect/UndeclaredThrowableException
  }
  
  class a
    implements Runnable
  {
    a(u7.a parama) {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	u/b$a:b	Lu/b;
      //   4: aload_0
      //   5: getfield 21	u/b$a:a	Lu7/a;
      //   8: invokestatic 34	u/f:e	(Ljava/util/concurrent/Future;)Ljava/lang/Object;
      //   11: invokevirtual 39	u/d:b	(Ljava/lang/Object;)Z
      //   14: pop
      //   15: aload_0
      //   16: getfield 19	u/b$a:b	Lu/b;
      //   19: aconst_null
      //   20: putfield 42	u/b:g	Lu7/a;
      //   23: return
      //   24: astore_1
      //   25: goto +37 -> 62
      //   28: astore_1
      //   29: aload_0
      //   30: getfield 19	u/b$a:b	Lu/b;
      //   33: aload_1
      //   34: invokevirtual 46	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
      //   37: invokevirtual 50	u/d:c	(Ljava/lang/Throwable;)Z
      //   40: pop
      //   41: goto -26 -> 15
      //   44: aload_0
      //   45: getfield 19	u/b$a:b	Lu/b;
      //   48: iconst_0
      //   49: invokevirtual 54	u/b:cancel	(Z)Z
      //   52: pop
      //   53: aload_0
      //   54: getfield 19	u/b$a:b	Lu/b;
      //   57: aconst_null
      //   58: putfield 42	u/b:g	Lu7/a;
      //   61: return
      //   62: aload_0
      //   63: getfield 19	u/b$a:b	Lu/b;
      //   66: aconst_null
      //   67: putfield 42	u/b:g	Lu7/a;
      //   70: aload_1
      //   71: athrow
      //   72: astore_1
      //   73: goto -29 -> 44
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	a
      //   24	1	1	localObject	Object
      //   28	43	1	localExecutionException	java.util.concurrent.ExecutionException
      //   72	1	1	localCancellationException	java.util.concurrent.CancellationException
      // Exception table:
      //   from	to	target	type
      //   0	15	24	finally
      //   29	41	24	finally
      //   44	53	24	finally
      //   0	15	28	java/util/concurrent/ExecutionException
      //   0	15	72	java/util/concurrent/CancellationException
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u.b
 * JD-Core Version:    0.7.0.1
 */