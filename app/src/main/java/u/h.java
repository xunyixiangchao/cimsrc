package u;

import androidx.concurrent.futures.c;
import androidx.concurrent.futures.c.a;
import androidx.concurrent.futures.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class h<V>
  implements u7.a<List<V>>
{
  List<? extends u7.a<? extends V>> a;
  List<V> b;
  private final boolean c;
  private final AtomicInteger d;
  private final u7.a<List<V>> e;
  c.a<List<V>> f;
  
  h(List<? extends u7.a<? extends V>> paramList, boolean paramBoolean, Executor paramExecutor)
  {
    this.a = ((List)x0.h.g(paramList));
    this.b = new ArrayList(paramList.size());
    this.c = paramBoolean;
    this.d = new AtomicInteger(paramList.size());
    this.e = c.a(new a());
    d(paramExecutor);
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	u/h:a	Ljava/util/List;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +69 -> 75
    //   9: aload_0
    //   10: invokevirtual 85	u/h:isDone	()Z
    //   13: ifne +62 -> 75
    //   16: aload_1
    //   17: invokeinterface 89 1 0
    //   22: astore_1
    //   23: aload_1
    //   24: invokeinterface 94 1 0
    //   29: ifeq +46 -> 75
    //   32: aload_1
    //   33: invokeinterface 98 1 0
    //   38: checkcast 7	u7/a
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 101 1 0
    //   48: ifne -25 -> 23
    //   51: aload_2
    //   52: invokeinterface 104 1 0
    //   57: pop
    //   58: goto -16 -> 42
    //   61: aload_0
    //   62: getfield 56	u/h:c	Z
    //   65: ifeq -23 -> 42
    //   68: return
    //   69: astore_1
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: aload_1
    //   74: athrow
    //   75: return
    //   76: astore_3
    //   77: goto -16 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	h
    //   4	29	1	localObject1	Object
    //   69	2	1	localInterruptedException	java.lang.InterruptedException
    //   72	2	1	localError	java.lang.Error
    //   41	11	2	locala	u7.a
    //   76	1	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   51	58	69	java/lang/InterruptedException
    //   51	58	72	java/lang/Error
    //   51	58	76	finally
  }
  
  private void d(Executor paramExecutor)
  {
    h(new b(), t.a.a());
    if (this.a.isEmpty())
    {
      this.f.c(new ArrayList(this.b));
      return;
    }
    int j = 0;
    final int i = 0;
    while (i < this.a.size())
    {
      this.b.add(null);
      i += 1;
    }
    List localList = this.a;
    i = j;
    while (i < localList.size())
    {
      final u7.a locala = (u7.a)localList.get(i);
      locala.h(new c(i, locala), paramExecutor);
      i += 1;
    }
  }
  
  public List<V> b()
  {
    a();
    return (List)this.e.get();
  }
  
  public List<V> c(long paramLong, TimeUnit paramTimeUnit)
  {
    return (List)this.e.get(paramLong, paramTimeUnit);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((u7.a)((Iterator)localObject).next()).cancel(paramBoolean);
      }
    }
    return this.e.cancel(paramBoolean);
  }
  
  /* Error */
  void e(int paramInt, Future<? extends V> paramFuture)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	u/h:b	Ljava/util/List;
    //   4: astore 9
    //   6: aload_0
    //   7: invokevirtual 85	u/h:isDone	()Z
    //   10: ifne +482 -> 492
    //   13: aload 9
    //   15: ifnonnull +6 -> 21
    //   18: goto +474 -> 492
    //   21: iconst_1
    //   22: istore 4
    //   24: iconst_1
    //   25: istore 5
    //   27: iconst_1
    //   28: istore 6
    //   30: iconst_1
    //   31: istore 7
    //   33: iconst_1
    //   34: istore 8
    //   36: iconst_1
    //   37: istore_3
    //   38: aload_2
    //   39: invokeinterface 101 1 0
    //   44: ldc 159
    //   46: invokestatic 163	x0/h:j	(ZLjava/lang/String;)V
    //   49: aload 9
    //   51: iload_1
    //   52: aload_2
    //   53: invokestatic 168	u/f:e	(Ljava/util/concurrent/Future;)Ljava/lang/Object;
    //   56: invokeinterface 172 3 0
    //   61: pop
    //   62: aload_0
    //   63: getfield 61	u/h:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   66: invokevirtual 175	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   69: istore_1
    //   70: iload_1
    //   71: iflt +6 -> 77
    //   74: goto +5 -> 79
    //   77: iconst_0
    //   78: istore_3
    //   79: iload_3
    //   80: ldc 177
    //   82: invokestatic 163	x0/h:j	(ZLjava/lang/String;)V
    //   85: iload_1
    //   86: ifne +335 -> 421
    //   89: aload_0
    //   90: getfield 54	u/h:b	Ljava/util/List;
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull +26 -> 121
    //   98: aload_0
    //   99: getfield 119	u/h:f	Landroidx/concurrent/futures/c$a;
    //   102: astore 9
    //   104: new 45	java/util/ArrayList
    //   107: dup
    //   108: aload_2
    //   109: invokespecial 122	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   112: astore_2
    //   113: aload 9
    //   115: aload_2
    //   116: invokevirtual 127	androidx/concurrent/futures/c$a:c	(Ljava/lang/Object;)Z
    //   119: pop
    //   120: return
    //   121: aload_0
    //   122: invokevirtual 85	u/h:isDone	()Z
    //   125: invokestatic 181	x0/h:i	(Z)V
    //   128: return
    //   129: astore_2
    //   130: goto +292 -> 422
    //   133: astore_2
    //   134: aload_0
    //   135: getfield 119	u/h:f	Landroidx/concurrent/futures/c$a;
    //   138: aload_2
    //   139: invokevirtual 184	androidx/concurrent/futures/c$a:f	(Ljava/lang/Throwable;)Z
    //   142: pop
    //   143: aload_0
    //   144: getfield 61	u/h:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   147: invokevirtual 175	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   150: istore_1
    //   151: iload_1
    //   152: iflt +9 -> 161
    //   155: iload 4
    //   157: istore_3
    //   158: goto +5 -> 163
    //   161: iconst_0
    //   162: istore_3
    //   163: iload_3
    //   164: ldc 177
    //   166: invokestatic 163	x0/h:j	(ZLjava/lang/String;)V
    //   169: iload_1
    //   170: ifne +251 -> 421
    //   173: aload_0
    //   174: getfield 54	u/h:b	Ljava/util/List;
    //   177: astore_2
    //   178: aload_2
    //   179: ifnull -58 -> 121
    //   182: aload_0
    //   183: getfield 119	u/h:f	Landroidx/concurrent/futures/c$a;
    //   186: astore 9
    //   188: new 45	java/util/ArrayList
    //   191: dup
    //   192: aload_2
    //   193: invokespecial 122	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   196: astore_2
    //   197: goto -84 -> 113
    //   200: astore_2
    //   201: aload_0
    //   202: getfield 56	u/h:c	Z
    //   205: ifeq +12 -> 217
    //   208: aload_0
    //   209: getfield 119	u/h:f	Landroidx/concurrent/futures/c$a;
    //   212: aload_2
    //   213: invokevirtual 184	androidx/concurrent/futures/c$a:f	(Ljava/lang/Throwable;)Z
    //   216: pop
    //   217: aload_0
    //   218: getfield 61	u/h:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   221: invokevirtual 175	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   224: istore_1
    //   225: iload_1
    //   226: iflt +9 -> 235
    //   229: iload 5
    //   231: istore_3
    //   232: goto +5 -> 237
    //   235: iconst_0
    //   236: istore_3
    //   237: iload_3
    //   238: ldc 177
    //   240: invokestatic 163	x0/h:j	(ZLjava/lang/String;)V
    //   243: iload_1
    //   244: ifne +177 -> 421
    //   247: aload_0
    //   248: getfield 54	u/h:b	Ljava/util/List;
    //   251: astore_2
    //   252: aload_2
    //   253: ifnull -132 -> 121
    //   256: aload_0
    //   257: getfield 119	u/h:f	Landroidx/concurrent/futures/c$a;
    //   260: astore 9
    //   262: new 45	java/util/ArrayList
    //   265: dup
    //   266: aload_2
    //   267: invokespecial 122	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   270: astore_2
    //   271: goto -158 -> 113
    //   274: astore_2
    //   275: aload_0
    //   276: getfield 56	u/h:c	Z
    //   279: ifeq +15 -> 294
    //   282: aload_0
    //   283: getfield 119	u/h:f	Landroidx/concurrent/futures/c$a;
    //   286: aload_2
    //   287: invokevirtual 188	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   290: invokevirtual 184	androidx/concurrent/futures/c$a:f	(Ljava/lang/Throwable;)Z
    //   293: pop
    //   294: aload_0
    //   295: getfield 61	u/h:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   298: invokevirtual 175	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   301: istore_1
    //   302: iload_1
    //   303: iflt +9 -> 312
    //   306: iload 6
    //   308: istore_3
    //   309: goto +5 -> 314
    //   312: iconst_0
    //   313: istore_3
    //   314: iload_3
    //   315: ldc 177
    //   317: invokestatic 163	x0/h:j	(ZLjava/lang/String;)V
    //   320: iload_1
    //   321: ifne +100 -> 421
    //   324: aload_0
    //   325: getfield 54	u/h:b	Ljava/util/List;
    //   328: astore_2
    //   329: aload_2
    //   330: ifnull -209 -> 121
    //   333: aload_0
    //   334: getfield 119	u/h:f	Landroidx/concurrent/futures/c$a;
    //   337: astore 9
    //   339: new 45	java/util/ArrayList
    //   342: dup
    //   343: aload_2
    //   344: invokespecial 122	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   347: astore_2
    //   348: goto -235 -> 113
    //   351: aload_0
    //   352: getfield 56	u/h:c	Z
    //   355: ifeq +9 -> 364
    //   358: aload_0
    //   359: iconst_0
    //   360: invokevirtual 189	u/h:cancel	(Z)Z
    //   363: pop
    //   364: aload_0
    //   365: getfield 61	u/h:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   368: invokevirtual 175	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   371: istore_1
    //   372: iload_1
    //   373: iflt +9 -> 382
    //   376: iload 7
    //   378: istore_3
    //   379: goto +5 -> 384
    //   382: iconst_0
    //   383: istore_3
    //   384: iload_3
    //   385: ldc 177
    //   387: invokestatic 163	x0/h:j	(ZLjava/lang/String;)V
    //   390: iload_1
    //   391: ifne +30 -> 421
    //   394: aload_0
    //   395: getfield 54	u/h:b	Ljava/util/List;
    //   398: astore_2
    //   399: aload_2
    //   400: ifnull -279 -> 121
    //   403: aload_0
    //   404: getfield 119	u/h:f	Landroidx/concurrent/futures/c$a;
    //   407: astore 9
    //   409: new 45	java/util/ArrayList
    //   412: dup
    //   413: aload_2
    //   414: invokespecial 122	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   417: astore_2
    //   418: goto -305 -> 113
    //   421: return
    //   422: aload_0
    //   423: getfield 61	u/h:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   426: invokevirtual 175	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   429: istore_1
    //   430: iload_1
    //   431: iflt +9 -> 440
    //   434: iload 8
    //   436: istore_3
    //   437: goto +5 -> 442
    //   440: iconst_0
    //   441: istore_3
    //   442: iload_3
    //   443: ldc 177
    //   445: invokestatic 163	x0/h:j	(ZLjava/lang/String;)V
    //   448: iload_1
    //   449: ifne +41 -> 490
    //   452: aload_0
    //   453: getfield 54	u/h:b	Ljava/util/List;
    //   456: astore 9
    //   458: aload 9
    //   460: ifnull +23 -> 483
    //   463: aload_0
    //   464: getfield 119	u/h:f	Landroidx/concurrent/futures/c$a;
    //   467: new 45	java/util/ArrayList
    //   470: dup
    //   471: aload 9
    //   473: invokespecial 122	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   476: invokevirtual 127	androidx/concurrent/futures/c$a:c	(Ljava/lang/Object;)Z
    //   479: pop
    //   480: goto +10 -> 490
    //   483: aload_0
    //   484: invokevirtual 85	u/h:isDone	()Z
    //   487: invokestatic 181	x0/h:i	(Z)V
    //   490: aload_2
    //   491: athrow
    //   492: aload_0
    //   493: getfield 56	u/h:c	Z
    //   496: ldc 191
    //   498: invokestatic 163	x0/h:j	(ZLjava/lang/String;)V
    //   501: return
    //   502: astore_2
    //   503: goto -152 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	this	h
    //   0	506	1	paramInt	int
    //   0	506	2	paramFuture	Future<? extends V>
    //   37	406	3	bool1	boolean
    //   22	134	4	bool2	boolean
    //   25	205	5	bool3	boolean
    //   28	279	6	bool4	boolean
    //   31	346	7	bool5	boolean
    //   34	401	8	bool6	boolean
    //   4	468	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   38	62	129	finally
    //   134	143	129	finally
    //   201	217	129	finally
    //   275	294	129	finally
    //   351	364	129	finally
    //   38	62	133	java/lang/Error
    //   38	62	200	java/lang/RuntimeException
    //   38	62	274	java/util/concurrent/ExecutionException
    //   38	62	502	java/util/concurrent/CancellationException
  }
  
  public void h(Runnable paramRunnable, Executor paramExecutor)
  {
    this.e.h(paramRunnable, paramExecutor);
  }
  
  public boolean isCancelled()
  {
    return this.e.isCancelled();
  }
  
  public boolean isDone()
  {
    return this.e.isDone();
  }
  
  class a
    implements c.c<List<V>>
  {
    a() {}
    
    public Object a(c.a<List<V>> parama)
    {
      boolean bool;
      if (h.this.f == null) {
        bool = true;
      } else {
        bool = false;
      }
      x0.h.j(bool, "The result can only set once!");
      h.this.f = parama;
      parama = new StringBuilder();
      parama.append("ListFuture[");
      parama.append(this);
      parama.append("]");
      return parama.toString();
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      h localh = h.this;
      localh.b = null;
      localh.a = null;
    }
  }
  
  class c
    implements Runnable
  {
    c(int paramInt, u7.a parama) {}
    
    public void run()
    {
      h.this.e(i, locala);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u.h
 * JD-Core Version:    0.7.0.1
 */