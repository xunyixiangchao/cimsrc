package q9;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import p8.e;
import p9.d.a;

public final class f
  implements d
{
  private final n a;
  private final p9.d b;
  private final long c;
  private long d;
  private final CopyOnWriteArrayList<n.c> e;
  private final e<n.c> f;
  private final BlockingQueue<n.a> g;
  
  public f(n paramn, p9.d paramd)
  {
    this.a = paramn;
    this.b = paramd;
    this.c = TimeUnit.MILLISECONDS.toNanos(250L);
    this.d = -9223372036854775808L;
    this.e = new CopyOnWriteArrayList();
    this.f = new e();
    this.g = paramd.f().b(new LinkedBlockingDeque());
  }
  
  private final n.a e(long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.e.isEmpty()) {
      return null;
    }
    paramTimeUnit = (n.a)this.g.poll(paramLong, paramTimeUnit);
    if (paramTimeUnit == null) {
      return null;
    }
    this.e.remove(paramTimeUnit.d());
    return paramTimeUnit;
  }
  
  private final void f()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      n.c localc = (n.c)localIterator.next();
      localc.cancel();
      localc = localc.a();
      if (localc != null) {
        this.f.add(localc);
      }
    }
    this.e.clear();
  }
  
  /* Error */
  private final n.a g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	q9/f:f	Lp8/e;
    //   4: invokeinterface 138 1 0
    //   9: iconst_1
    //   10: ixor
    //   11: ifeq +17 -> 28
    //   14: aload_0
    //   15: getfield 70	q9/f:f	Lp8/e;
    //   18: invokevirtual 141	p8/e:l	()Ljava/lang/Object;
    //   21: checkcast 123	q9/n$c
    //   24: astore_1
    //   25: goto +42 -> 67
    //   28: aload_0
    //   29: invokevirtual 144	q9/f:b	()Lq9/n;
    //   32: aconst_null
    //   33: iconst_1
    //   34: aconst_null
    //   35: invokestatic 149	q9/n$b:a	(Lq9/n;Lq9/i;ILjava/lang/Object;)Z
    //   38: ifeq +149 -> 187
    //   41: aload_0
    //   42: invokevirtual 144	q9/f:b	()Lq9/n;
    //   45: invokeinterface 153 1 0
    //   50: astore_1
    //   51: goto -26 -> 25
    //   54: astore_1
    //   55: new 155	q9/e
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 158	q9/e:<init>	(Ljava/lang/Throwable;)V
    //   63: astore_1
    //   64: goto -39 -> 25
    //   67: aload_1
    //   68: invokeinterface 160 1 0
    //   73: ifeq +17 -> 90
    //   76: new 101	q9/n$a
    //   79: dup
    //   80: aload_1
    //   81: aconst_null
    //   82: aconst_null
    //   83: bipush 6
    //   85: aconst_null
    //   86: invokespecial 163	q9/n$a:<init>	(Lq9/n$c;Lq9/n$c;Ljava/lang/Throwable;ILa9/d;)V
    //   89: areturn
    //   90: aload_1
    //   91: instanceof 155
    //   94: ifeq +11 -> 105
    //   97: aload_1
    //   98: checkcast 155	q9/e
    //   101: invokevirtual 165	q9/e:g	()Lq9/n$a;
    //   104: areturn
    //   105: aload_0
    //   106: getfield 65	q9/f:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   109: aload_1
    //   110: invokeinterface 133 2 0
    //   115: pop
    //   116: new 167	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   123: astore_2
    //   124: aload_2
    //   125: getstatic 173	m9/o:f	Ljava/lang/String;
    //   128: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_2
    //   133: ldc 179
    //   135: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_2
    //   140: aload_0
    //   141: invokevirtual 144	q9/f:b	()Lq9/n;
    //   144: invokeinterface 182 1 0
    //   149: invokevirtual 187	l9/a:l	()Ll9/x;
    //   152: invokevirtual 193	l9/x:p	()Ljava/lang/String;
    //   155: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_2
    //   160: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore_2
    //   164: aload_0
    //   165: getfield 42	q9/f:b	Lp9/d;
    //   168: invokevirtual 200	p9/d:i	()Lp9/c;
    //   171: new 8	q9/f$a
    //   174: dup
    //   175: aload_2
    //   176: aload_1
    //   177: aload_0
    //   178: invokespecial 203	q9/f$a:<init>	(Ljava/lang/String;Lq9/n$c;Lq9/f;)V
    //   181: lconst_0
    //   182: iconst_2
    //   183: aconst_null
    //   184: invokestatic 209	p9/c:m	(Lp9/c;Lp9/a;JILjava/lang/Object;)V
    //   187: aconst_null
    //   188: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	f
    //   24	27	1	localc	n.c
    //   54	6	1	localThrowable	Throwable
    //   63	114	1	locale	e
    //   123	53	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   41	51	54	finally
  }
  
  public i a()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        if ((!(this.e.isEmpty() ^ true)) && (!(this.f.isEmpty() ^ true)))
        {
          boolean bool = n.b.a(b(), null, 1, null);
          if (!bool)
          {
            f();
            a9.f.c(localObject4);
            throw localObject4;
          }
        }
        if (!b().i())
        {
          long l2 = this.b.f().e();
          long l1 = this.d - l2;
          if (!this.e.isEmpty()) {
            if (l1 > 0L) {
              break label347;
            }
          }
          localObject3 = g();
          l1 = this.c;
          this.d = (l2 + l1);
          Object localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject3 = e(l1, TimeUnit.NANOSECONDS);
            localObject1 = localObject3;
            if (localObject3 == null) {
              continue;
            }
          }
          Object localObject5 = localObject1;
          if (((n.a)localObject1).f())
          {
            f();
            localObject3 = localObject1;
            if (!((n.a)localObject1).d().d()) {
              localObject3 = ((n.a)localObject1).d().b();
            }
            localObject5 = localObject3;
            if (((n.a)localObject3).f())
            {
              localObject1 = ((n.a)localObject3).d().c();
              return localObject1;
            }
          }
          localObject3 = localObject5.e();
          localObject1 = localObject4;
          if (localObject3 != null) {
            if ((localObject3 instanceof IOException))
            {
              if (localObject4 == null)
              {
                localObject1 = (IOException)localObject3;
              }
              else
              {
                o8.a.a(localObject4, (Throwable)localObject3);
                localObject1 = localObject4;
              }
            }
            else {
              throw ((Throwable)localObject3);
            }
          }
          localObject3 = localObject5.c();
          localObject4 = localObject1;
          if (localObject3 == null) {
            continue;
          }
          this.f.c(localObject3);
          localObject4 = localObject1;
        }
        else
        {
          throw new IOException("Canceled");
        }
      }
      finally
      {
        f();
      }
      label347:
      Object localObject3 = null;
    }
  }
  
  public n b()
  {
    return this.a;
  }
  
  public static final class a
    extends p9.a
  {
    a(String paramString, n.c paramc, f paramf)
    {
      super(false, 2, null);
    }
    
    /* Error */
    public long f()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	q9/f$a:f	Lq9/n$c;
      //   4: invokeinterface 31 1 0
      //   9: astore_1
      //   10: goto +20 -> 30
      //   13: astore_1
      //   14: new 33	q9/n$a
      //   17: dup
      //   18: aload_0
      //   19: getfield 20	q9/f$a:f	Lq9/n$c;
      //   22: aconst_null
      //   23: aload_1
      //   24: iconst_2
      //   25: aconst_null
      //   26: invokespecial 36	q9/n$a:<init>	(Lq9/n$c;Lq9/n$c;Ljava/lang/Throwable;ILa9/d;)V
      //   29: astore_1
      //   30: aload_0
      //   31: getfield 22	q9/f$a:g	Lq9/f;
      //   34: invokestatic 40	q9/f:d	(Lq9/f;)Ljava/util/concurrent/CopyOnWriteArrayList;
      //   37: aload_0
      //   38: getfield 20	q9/f$a:f	Lq9/n$c;
      //   41: invokevirtual 46	java/util/concurrent/CopyOnWriteArrayList:contains	(Ljava/lang/Object;)Z
      //   44: ifeq +16 -> 60
      //   47: aload_0
      //   48: getfield 22	q9/f$a:g	Lq9/f;
      //   51: invokestatic 50	q9/f:c	(Lq9/f;)Ljava/util/concurrent/BlockingQueue;
      //   54: aload_1
      //   55: invokeinterface 56 2 0
      //   60: ldc2_w 57
      //   63: lreturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	64	0	this	a
      //   9	1	1	locala1	n.a
      //   13	11	1	localThrowable	Throwable
      //   29	26	1	locala2	n.a
      // Exception table:
      //   from	to	target	type
      //   0	10	13	finally
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.f
 * JD-Core Version:    0.7.0.1
 */