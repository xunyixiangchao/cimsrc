package p9;

import a9.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import m9.l;
import m9.o;

public final class d
{
  public static final b i = new b(null);
  private static final Logger j;
  public static final d k = new d(new c(o.o(f.m(o.f, " TaskRunner"), true)), null, 2, null);
  private final a a;
  private final Logger b;
  private int c;
  private boolean d;
  private long e;
  private final List<c> f;
  private final List<c> g;
  private final Runnable h;
  
  static
  {
    Logger localLogger = Logger.getLogger(d.class.getName());
    f.e(localLogger, "getLogger(TaskRunner::class.java.name)");
    j = localLogger;
  }
  
  public d(a parama, Logger paramLogger)
  {
    this.a = parama;
    this.b = paramLogger;
    this.c = 10000;
    this.f = new ArrayList();
    this.g = new ArrayList();
    this.h = new d(this);
  }
  
  private final void b(a parama, long paramLong)
  {
    if ((o.e) && (!Thread.holdsLock(this)))
    {
      parama = new StringBuilder();
      parama.append("Thread ");
      parama.append(Thread.currentThread().getName());
      parama.append(" MUST hold lock on ");
      parama.append(this);
      throw new AssertionError(parama.toString());
    }
    c localc = parama.d();
    f.c(localc);
    int m;
    if (localc.e() == parama) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      boolean bool = localc.f();
      localc.p(false);
      localc.o(null);
      this.f.remove(localc);
      if ((paramLong != -1L) && (!bool) && (!localc.i())) {
        localc.n(parama, paramLong, true);
      }
      if ((localc.g().isEmpty() ^ true)) {
        this.g.add(localc);
      }
      return;
    }
    throw new IllegalStateException("Check failed.".toString());
  }
  
  private final void d(a parama)
  {
    if ((o.e) && (!Thread.holdsLock(this)))
    {
      parama = new StringBuilder();
      parama.append("Thread ");
      parama.append(Thread.currentThread().getName());
      parama.append(" MUST hold lock on ");
      parama.append(this);
      throw new AssertionError(parama.toString());
    }
    parama.g(-1L);
    c localc = parama.d();
    f.c(localc);
    localc.g().remove(parama);
    this.g.remove(localc);
    localc.o(parama);
    this.f.add(localc);
  }
  
  /* Error */
  private final void j(a parama)
  {
    // Byte code:
    //   0: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: astore 4
    //   5: aload 4
    //   7: invokevirtual 142	java/lang/Thread:getName	()Ljava/lang/String;
    //   10: astore 5
    //   12: aload 4
    //   14: aload_1
    //   15: invokevirtual 213	p9/a:b	()Ljava/lang/String;
    //   18: invokevirtual 216	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: invokevirtual 219	p9/a:f	()J
    //   25: lstore_2
    //   26: aload_0
    //   27: monitorenter
    //   28: aload_0
    //   29: aload_1
    //   30: lload_2
    //   31: invokespecial 221	p9/d:b	(Lp9/a;J)V
    //   34: getstatic 226	o8/o:a	Lo8/o;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload 4
    //   42: aload 5
    //   44: invokevirtual 216	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   47: return
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: astore 6
    //   55: aload_0
    //   56: monitorenter
    //   57: aload_0
    //   58: aload_1
    //   59: ldc2_w 182
    //   62: invokespecial 221	p9/d:b	(Lp9/a;J)V
    //   65: getstatic 226	o8/o:a	Lo8/o;
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 4
    //   73: aload 5
    //   75: invokevirtual 216	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   78: aload 6
    //   80: athrow
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	d
    //   0	86	1	parama	a
    //   25	6	2	l	long
    //   3	69	4	localThread	Thread
    //   10	64	5	str	java.lang.String
    //   53	26	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	38	48	finally
    //   21	26	53	finally
    //   57	69	81	finally
  }
  
  /* Error */
  public final a c()
  {
    // Byte code:
    //   0: getstatic 122	m9/o:e	Z
    //   3: ifeq +70 -> 73
    //   6: aload_0
    //   7: invokestatic 128	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +6 -> 16
    //   13: goto +60 -> 73
    //   16: new 130	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   23: astore 8
    //   25: aload 8
    //   27: ldc 133
    //   29: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 8
    //   35: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   38: invokevirtual 142	java/lang/Thread:getName	()Ljava/lang/String;
    //   41: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 8
    //   47: ldc 147
    //   49: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 8
    //   55: aload_0
    //   56: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: new 149	java/lang/AssertionError
    //   63: dup
    //   64: aload 8
    //   66: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 155	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   72: athrow
    //   73: aload_0
    //   74: getfield 108	p9/d:g	Ljava/util/List;
    //   77: invokeinterface 229 1 0
    //   82: ifeq +5 -> 87
    //   85: aconst_null
    //   86: areturn
    //   87: aload_0
    //   88: getfield 97	p9/d:a	Lp9/d$a;
    //   91: invokeinterface 231 1 0
    //   96: lstore 4
    //   98: ldc2_w 232
    //   101: lstore_2
    //   102: aload_0
    //   103: getfield 108	p9/d:g	Ljava/util/List;
    //   106: invokeinterface 237 1 0
    //   111: astore 10
    //   113: aconst_null
    //   114: astore 8
    //   116: aload 10
    //   118: invokeinterface 242 1 0
    //   123: ifeq +75 -> 198
    //   126: aload 10
    //   128: invokeinterface 246 1 0
    //   133: checkcast 164	p9/c
    //   136: invokevirtual 192	p9/c:g	()Ljava/util/List;
    //   139: iconst_0
    //   140: invokeinterface 250 2 0
    //   145: checkcast 157	p9/a
    //   148: astore 9
    //   150: lconst_0
    //   151: aload 9
    //   153: invokevirtual 252	p9/a:c	()J
    //   156: lload 4
    //   158: lsub
    //   159: invokestatic 258	java/lang/Math:max	(JJ)J
    //   162: lstore 6
    //   164: lload 6
    //   166: lconst_0
    //   167: lcmp
    //   168: ifle +13 -> 181
    //   171: lload 6
    //   173: lload_2
    //   174: invokestatic 261	java/lang/Math:min	(JJ)J
    //   177: lstore_2
    //   178: goto -62 -> 116
    //   181: aload 8
    //   183: ifnull +8 -> 191
    //   186: iconst_1
    //   187: istore_1
    //   188: goto +12 -> 200
    //   191: aload 9
    //   193: astore 8
    //   195: goto -79 -> 116
    //   198: iconst_0
    //   199: istore_1
    //   200: aload 8
    //   202: ifnull +51 -> 253
    //   205: aload_0
    //   206: aload 8
    //   208: invokespecial 263	p9/d:d	(Lp9/a;)V
    //   211: iload_1
    //   212: ifne +24 -> 236
    //   215: aload_0
    //   216: getfield 265	p9/d:d	Z
    //   219: ifne +31 -> 250
    //   222: aload_0
    //   223: getfield 108	p9/d:g	Ljava/util/List;
    //   226: invokeinterface 197 1 0
    //   231: iconst_1
    //   232: ixor
    //   233: ifeq +17 -> 250
    //   236: aload_0
    //   237: getfield 97	p9/d:a	Lp9/d$a;
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 113	p9/d:h	Ljava/lang/Runnable;
    //   245: invokeinterface 268 3 0
    //   250: aload 8
    //   252: areturn
    //   253: aload_0
    //   254: getfield 265	p9/d:d	Z
    //   257: ifeq +27 -> 284
    //   260: lload_2
    //   261: aload_0
    //   262: getfield 270	p9/d:e	J
    //   265: lload 4
    //   267: lsub
    //   268: lcmp
    //   269: ifge +13 -> 282
    //   272: aload_0
    //   273: getfield 97	p9/d:a	Lp9/d$a;
    //   276: aload_0
    //   277: invokeinterface 272 2 0
    //   282: aconst_null
    //   283: areturn
    //   284: aload_0
    //   285: iconst_1
    //   286: putfield 265	p9/d:d	Z
    //   289: aload_0
    //   290: lload 4
    //   292: lload_2
    //   293: ladd
    //   294: putfield 270	p9/d:e	J
    //   297: aload_0
    //   298: getfield 97	p9/d:a	Lp9/d$a;
    //   301: aload_0
    //   302: lload_2
    //   303: invokeinterface 275 4 0
    //   308: aload_0
    //   309: iconst_0
    //   310: putfield 265	p9/d:d	Z
    //   313: goto -240 -> 73
    //   316: astore 8
    //   318: goto +10 -> 328
    //   321: aload_0
    //   322: invokevirtual 277	p9/d:e	()V
    //   325: goto -17 -> 308
    //   328: aload_0
    //   329: iconst_0
    //   330: putfield 265	p9/d:d	Z
    //   333: aload 8
    //   335: athrow
    //   336: astore 8
    //   338: goto -17 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	d
    //   187	25	1	m	int
    //   101	202	2	l1	long
    //   96	195	4	l2	long
    //   162	10	6	l3	long
    //   23	228	8	localObject1	Object
    //   316	18	8	localObject2	Object
    //   336	1	8	localInterruptedException	java.lang.InterruptedException
    //   148	44	9	locala	a
    //   111	16	10	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   297	308	316	finally
    //   321	325	316	finally
    //   297	308	336	java/lang/InterruptedException
  }
  
  public final void e()
  {
    Object localObject;
    if ((o.e) && (!Thread.holdsLock(this)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Thread ");
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      ((StringBuilder)localObject).append(" MUST hold lock on ");
      ((StringBuilder)localObject).append(this);
      throw new AssertionError(((StringBuilder)localObject).toString());
    }
    int m = this.f.size() - 1;
    int n;
    if (m >= 0) {
      for (;;)
      {
        n = m - 1;
        ((c)this.f.get(m)).b();
        if (n < 0) {
          break;
        }
        m = n;
      }
    }
    m = this.g.size() - 1;
    if (m >= 0) {
      for (;;)
      {
        n = m - 1;
        localObject = (c)this.g.get(m);
        ((c)localObject).b();
        if (((c)localObject).g().isEmpty()) {
          this.g.remove(m);
        }
        if (n < 0) {
          return;
        }
        m = n;
      }
    }
  }
  
  public final a f()
  {
    return this.a;
  }
  
  public final Logger g()
  {
    return this.b;
  }
  
  public final void h(c paramc)
  {
    f.f(paramc, "taskQueue");
    if ((o.e) && (!Thread.holdsLock(this)))
    {
      paramc = new StringBuilder();
      paramc.append("Thread ");
      paramc.append(Thread.currentThread().getName());
      paramc.append(" MUST hold lock on ");
      paramc.append(this);
      throw new AssertionError(paramc.toString());
    }
    if (paramc.e() == null) {
      if ((paramc.g().isEmpty() ^ true)) {
        l.a(this.g, paramc);
      } else {
        this.g.remove(paramc);
      }
    }
    if (this.d)
    {
      this.a.c(this);
      return;
    }
    this.a.a(this, this.h);
  }
  
  public final c i()
  {
    try
    {
      int m = this.c;
      this.c = (m + 1);
      return new c(this, f.m("Q", Integer.valueOf(m)));
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(d paramd, Runnable paramRunnable);
    
    public abstract <T> BlockingQueue<T> b(BlockingQueue<T> paramBlockingQueue);
    
    public abstract void c(d paramd);
    
    public abstract void d(d paramd, long paramLong);
    
    public abstract long e();
  }
  
  public static final class b {}
  
  public static final class c
    implements d.a
  {
    private final ThreadPoolExecutor a;
    
    public c(ThreadFactory paramThreadFactory)
    {
      this.a = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), paramThreadFactory);
    }
    
    public void a(d paramd, Runnable paramRunnable)
    {
      f.f(paramd, "taskRunner");
      f.f(paramRunnable, "runnable");
      this.a.execute(paramRunnable);
    }
    
    public <T> BlockingQueue<T> b(BlockingQueue<T> paramBlockingQueue)
    {
      f.f(paramBlockingQueue, "queue");
      return paramBlockingQueue;
    }
    
    public void c(d paramd)
    {
      f.f(paramd, "taskRunner");
      paramd.notify();
    }
    
    public void d(d paramd, long paramLong)
    {
      f.f(paramd, "taskRunner");
      long l = paramLong / 1000000L;
      if ((l > 0L) || (paramLong > 0L)) {
        paramd.wait(l, (int)(paramLong - 1000000L * l));
      }
    }
    
    public long e()
    {
      return System.nanoTime();
    }
  }
  
  public static final class d
    implements Runnable
  {
    d(d paramd) {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 16	p9/d$d:a	Lp9/d;
      //   4: astore 5
      //   6: aload 5
      //   8: monitorenter
      //   9: aload 5
      //   11: invokevirtual 25	p9/d:c	()Lp9/a;
      //   14: astore 4
      //   16: aload 5
      //   18: monitorexit
      //   19: aload 4
      //   21: ifnonnull +4 -> 25
      //   24: return
      //   25: aload_0
      //   26: getfield 16	p9/d$d:a	Lp9/d;
      //   29: invokevirtual 29	p9/d:g	()Ljava/util/logging/Logger;
      //   32: astore 5
      //   34: aload 4
      //   36: invokevirtual 35	p9/a:d	()Lp9/c;
      //   39: astore 6
      //   41: aload 6
      //   43: invokestatic 40	a9/f:c	(Ljava/lang/Object;)V
      //   46: aload_0
      //   47: getfield 16	p9/d$d:a	Lp9/d;
      //   50: astore 7
      //   52: ldc2_w 41
      //   55: lstore_1
      //   56: aload 5
      //   58: getstatic 48	java/util/logging/Level:FINE	Ljava/util/logging/Level;
      //   61: invokevirtual 54	java/util/logging/Logger:isLoggable	(Ljava/util/logging/Level;)Z
      //   64: istore_3
      //   65: iload_3
      //   66: ifeq +28 -> 94
      //   69: aload 6
      //   71: invokevirtual 60	p9/c:j	()Lp9/d;
      //   74: invokevirtual 64	p9/d:f	()Lp9/d$a;
      //   77: invokeinterface 70 1 0
      //   82: lstore_1
      //   83: aload 5
      //   85: aload 4
      //   87: aload 6
      //   89: ldc 72
      //   91: invokestatic 77	p9/b:a	(Ljava/util/logging/Logger;Lp9/a;Lp9/c;Ljava/lang/String;)V
      //   94: aload 7
      //   96: aload 4
      //   98: invokestatic 80	p9/d:a	(Lp9/d;Lp9/a;)V
      //   101: getstatic 85	o8/o:a	Lo8/o;
      //   104: astore 7
      //   106: iload_3
      //   107: ifeq -107 -> 0
      //   110: aload 5
      //   112: aload 4
      //   114: aload 6
      //   116: ldc 87
      //   118: aload 6
      //   120: invokevirtual 60	p9/c:j	()Lp9/d;
      //   123: invokevirtual 64	p9/d:f	()Lp9/d$a;
      //   126: invokeinterface 70 1 0
      //   131: lload_1
      //   132: lsub
      //   133: invokestatic 91	p9/b:b	(J)Ljava/lang/String;
      //   136: invokestatic 95	a9/f:m	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   139: invokestatic 77	p9/b:a	(Ljava/util/logging/Logger;Lp9/a;Lp9/c;Ljava/lang/String;)V
      //   142: goto -142 -> 0
      //   145: astore 7
      //   147: goto +40 -> 187
      //   150: astore 8
      //   152: aload 7
      //   154: monitorenter
      //   155: aload 7
      //   157: invokevirtual 64	p9/d:f	()Lp9/d$a;
      //   160: aload 7
      //   162: aload_0
      //   163: invokeinterface 98 3 0
      //   168: getstatic 85	o8/o:a	Lo8/o;
      //   171: astore 9
      //   173: aload 7
      //   175: monitorexit
      //   176: aload 8
      //   178: athrow
      //   179: astore 8
      //   181: aload 7
      //   183: monitorexit
      //   184: aload 8
      //   186: athrow
      //   187: iload_3
      //   188: ifeq +35 -> 223
      //   191: aload 5
      //   193: aload 4
      //   195: aload 6
      //   197: ldc 100
      //   199: aload 6
      //   201: invokevirtual 60	p9/c:j	()Lp9/d;
      //   204: invokevirtual 64	p9/d:f	()Lp9/d$a;
      //   207: invokeinterface 70 1 0
      //   212: lload_1
      //   213: lsub
      //   214: invokestatic 91	p9/b:b	(J)Ljava/lang/String;
      //   217: invokestatic 95	a9/f:m	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   220: invokestatic 77	p9/b:a	(Ljava/util/logging/Logger;Lp9/a;Lp9/c;Ljava/lang/String;)V
      //   223: aload 7
      //   225: athrow
      //   226: astore 4
      //   228: aload 5
      //   230: monitorexit
      //   231: aload 4
      //   233: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	234	0	this	d
      //   55	158	1	l	long
      //   64	124	3	bool	boolean
      //   14	180	4	locala	a
      //   226	6	4	localObject1	Object
      //   4	225	5	localObject2	Object
      //   39	161	6	localc	c
      //   50	55	7	localObject3	Object
      //   145	79	7	locald	d
      //   150	27	8	localObject4	Object
      //   179	6	8	localObject5	Object
      //   171	1	9	localo	o8.o
      // Exception table:
      //   from	to	target	type
      //   101	106	145	finally
      //   152	155	145	finally
      //   173	179	145	finally
      //   181	187	145	finally
      //   94	101	150	finally
      //   155	173	179	finally
      //   9	16	226	finally
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p9.d
 * JD-Core Version:    0.7.0.1
 */