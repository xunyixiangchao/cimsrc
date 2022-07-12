package aa;

import a9.f;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import o8.o;

public class a
  extends y
{
  public static final a i = new a(null);
  private static final long j;
  private static final long k;
  private static a l;
  private boolean f;
  private a g;
  private long h;
  
  static
  {
    long l1 = TimeUnit.SECONDS.toMillis(60L);
    j = l1;
    k = TimeUnit.MILLISECONDS.toNanos(l1);
  }
  
  private final long w(long paramLong)
  {
    return this.h - paramLong;
  }
  
  public final IOException n(IOException paramIOException)
  {
    return v(paramIOException);
  }
  
  public final void t()
  {
    long l1 = h();
    boolean bool = e();
    if ((l1 == 0L) && (!bool)) {
      return;
    }
    a.b(i, this, l1, bool);
  }
  
  public final boolean u()
  {
    return a.a(i, this);
  }
  
  protected IOException v(IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  public final v x(final v paramv)
  {
    f.f(paramv, "sink");
    return new c(this, paramv);
  }
  
  public final x y(final x paramx)
  {
    f.f(paramx, "source");
    return new d(this, paramx);
  }
  
  protected void z() {}
  
  public static final class a
  {
    private final boolean d(a parama)
    {
      try
      {
        boolean bool = a.l(parama);
        if (!bool) {
          return false;
        }
        a.q(parama, false);
        for (a locala = a.i(); locala != null; locala = a.m(locala)) {
          if (a.m(locala) == parama)
          {
            a.r(locala, a.m(parama));
            a.r(parama, null);
            return false;
          }
        }
        return true;
      }
      finally {}
    }
    
    private final void e(a parama, long paramLong, boolean paramBoolean)
    {
      for (;;)
      {
        boolean bool;
        try
        {
          if ((a.l(parama) ^ true))
          {
            a.q(parama, true);
            Object localObject;
            if (a.i() == null)
            {
              localObject = a.i;
              a.p(new a());
              new a.b().start();
            }
            long l = System.nanoTime();
            bool = paramLong < 0L;
            if ((bool) && (paramBoolean))
            {
              paramLong = Math.min(paramLong, parama.c() - l);
              a.s(parama, paramLong + l);
              if (paramBoolean)
              {
                a.s(parama, parama.c());
                paramLong = a.o(parama, l);
                localObject = a.i();
                f.c(localObject);
                if (a.m((a)localObject) != null)
                {
                  a locala = a.m((a)localObject);
                  f.c(locala);
                  if (paramLong >= a.o(locala, l))
                  {
                    localObject = a.m((a)localObject);
                    continue;
                  }
                }
                a.r(parama, a.m((a)localObject));
                a.r((a)localObject, parama);
                if (localObject == a.i()) {
                  a.class.notify();
                }
                parama = o.a;
                return;
              }
              throw new AssertionError();
            }
          }
          else
          {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
          }
        }
        finally {}
        if (!bool) {}
      }
    }
    
    public final a c()
    {
      Object localObject = a.i();
      f.c(localObject);
      localObject = a.m((a)localObject);
      a locala1 = null;
      long l1 = System.nanoTime();
      if (localObject == null)
      {
        a.class.wait(a.j());
        a locala2 = a.i();
        f.c(locala2);
        localObject = locala1;
        if (a.m(locala2) == null)
        {
          localObject = locala1;
          if (System.nanoTime() - l1 >= a.k()) {
            localObject = a.i();
          }
        }
        return localObject;
      }
      l1 = a.o((a)localObject, l1);
      if (l1 > 0L)
      {
        long l2 = l1 / 1000000L;
        a.class.wait(l2, (int)(l1 - 1000000L * l2));
        return null;
      }
      locala1 = a.i();
      f.c(locala1);
      a.r(locala1, a.m((a)localObject));
      a.r((a)localObject, null);
      return localObject;
    }
  }
  
  private static final class b
    extends Thread
  {
    public b()
    {
      super();
      setDaemon(true);
    }
    
    public void run()
    {
      try
      {
        for (;;)
        {
          try
          {
            a locala = a.i.c();
            if (locala == a.i())
            {
              a.p(null);
              return;
            }
            o localo = o.a;
            if (locala != null) {
              locala.z();
            }
          }
          finally {}
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public static final class c
    implements v
  {
    c(a parama, v paramv) {}
    
    /* Error */
    public void L(b paramb, long paramLong)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc 31
      //   3: invokestatic 37	a9/f:f	(Ljava/lang/Object;Ljava/lang/String;)V
      //   6: aload_1
      //   7: invokevirtual 43	aa/b:z0	()J
      //   10: lconst_0
      //   11: lload_2
      //   12: invokestatic 48	aa/c0:b	(JJJ)V
      //   15: lconst_0
      //   16: lstore 4
      //   18: lload_2
      //   19: lconst_0
      //   20: lcmp
      //   21: ifle +155 -> 176
      //   24: aload_1
      //   25: getfield 51	aa/b:a	Laa/s;
      //   28: astore 8
      //   30: aload 8
      //   32: invokestatic 55	a9/f:c	(Ljava/lang/Object;)V
      //   35: lload 4
      //   37: lstore 6
      //   39: lload 4
      //   41: ldc2_w 56
      //   44: lcmp
      //   45: ifge +43 -> 88
      //   48: lload 4
      //   50: aload 8
      //   52: getfield 62	aa/s:c	I
      //   55: aload 8
      //   57: getfield 64	aa/s:b	I
      //   60: isub
      //   61: i2l
      //   62: ladd
      //   63: lstore 4
      //   65: lload 4
      //   67: lload_2
      //   68: lcmp
      //   69: iflt +9 -> 78
      //   72: lload_2
      //   73: lstore 6
      //   75: goto +13 -> 88
      //   78: aload 8
      //   80: getfield 66	aa/s:f	Laa/s;
      //   83: astore 8
      //   85: goto -55 -> 30
      //   88: aload_0
      //   89: getfield 19	aa/a$c:a	Laa/a;
      //   92: astore 8
      //   94: aload_0
      //   95: getfield 21	aa/a$c:b	Laa/v;
      //   98: astore 9
      //   100: aload 8
      //   102: invokevirtual 69	aa/a:t	()V
      //   105: aload 9
      //   107: aload_1
      //   108: lload 6
      //   110: invokeinterface 71 4 0
      //   115: getstatic 76	o8/o:a	Lo8/o;
      //   118: astore 9
      //   120: aload 8
      //   122: invokevirtual 80	aa/a:u	()Z
      //   125: ifne +11 -> 136
      //   128: lload_2
      //   129: lload 6
      //   131: lsub
      //   132: lstore_2
      //   133: goto -118 -> 15
      //   136: aload 8
      //   138: aconst_null
      //   139: invokevirtual 84	aa/a:n	(Ljava/io/IOException;)Ljava/io/IOException;
      //   142: athrow
      //   143: astore_1
      //   144: goto +24 -> 168
      //   147: astore_1
      //   148: aload 8
      //   150: invokevirtual 80	aa/a:u	()Z
      //   153: ifne +6 -> 159
      //   156: goto +10 -> 166
      //   159: aload 8
      //   161: aload_1
      //   162: invokevirtual 84	aa/a:n	(Ljava/io/IOException;)Ljava/io/IOException;
      //   165: astore_1
      //   166: aload_1
      //   167: athrow
      //   168: aload 8
      //   170: invokevirtual 80	aa/a:u	()Z
      //   173: pop
      //   174: aload_1
      //   175: athrow
      //   176: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	177	0	this	c
      //   0	177	1	paramb	b
      //   0	177	2	paramLong	long
      //   16	50	4	l1	long
      //   37	93	6	l2	long
      //   28	141	8	localObject1	Object
      //   98	21	9	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   105	120	143	finally
      //   148	156	143	finally
      //   159	166	143	finally
      //   166	168	143	finally
      //   105	120	147	java/io/IOException
    }
    
    public a a()
    {
      return this.a;
    }
    
    /* Error */
    public void close()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	aa/a$c:a	Laa/a;
      //   4: astore_2
      //   5: aload_0
      //   6: getfield 21	aa/a$c:b	Laa/v;
      //   9: astore_1
      //   10: aload_2
      //   11: invokevirtual 69	aa/a:t	()V
      //   14: aload_1
      //   15: invokeinterface 91 1 0
      //   20: getstatic 76	o8/o:a	Lo8/o;
      //   23: astore_1
      //   24: aload_2
      //   25: invokevirtual 80	aa/a:u	()Z
      //   28: ifne +4 -> 32
      //   31: return
      //   32: aload_2
      //   33: aconst_null
      //   34: invokevirtual 84	aa/a:n	(Ljava/io/IOException;)Ljava/io/IOException;
      //   37: athrow
      //   38: astore_1
      //   39: goto +22 -> 61
      //   42: astore_1
      //   43: aload_2
      //   44: invokevirtual 80	aa/a:u	()Z
      //   47: ifne +6 -> 53
      //   50: goto +9 -> 59
      //   53: aload_2
      //   54: aload_1
      //   55: invokevirtual 84	aa/a:n	(Ljava/io/IOException;)Ljava/io/IOException;
      //   58: astore_1
      //   59: aload_1
      //   60: athrow
      //   61: aload_2
      //   62: invokevirtual 80	aa/a:u	()Z
      //   65: pop
      //   66: aload_1
      //   67: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	68	0	this	c
      //   9	15	1	localObject1	Object
      //   38	1	1	localObject2	Object
      //   42	13	1	localIOException1	IOException
      //   58	9	1	localIOException2	IOException
      //   4	58	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   14	24	38	finally
      //   43	50	38	finally
      //   53	59	38	finally
      //   59	61	38	finally
      //   14	24	42	java/io/IOException
    }
    
    /* Error */
    public void flush()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	aa/a$c:a	Laa/a;
      //   4: astore_2
      //   5: aload_0
      //   6: getfield 21	aa/a$c:b	Laa/v;
      //   9: astore_1
      //   10: aload_2
      //   11: invokevirtual 69	aa/a:t	()V
      //   14: aload_1
      //   15: invokeinterface 94 1 0
      //   20: getstatic 76	o8/o:a	Lo8/o;
      //   23: astore_1
      //   24: aload_2
      //   25: invokevirtual 80	aa/a:u	()Z
      //   28: ifne +4 -> 32
      //   31: return
      //   32: aload_2
      //   33: aconst_null
      //   34: invokevirtual 84	aa/a:n	(Ljava/io/IOException;)Ljava/io/IOException;
      //   37: athrow
      //   38: astore_1
      //   39: goto +22 -> 61
      //   42: astore_1
      //   43: aload_2
      //   44: invokevirtual 80	aa/a:u	()Z
      //   47: ifne +6 -> 53
      //   50: goto +9 -> 59
      //   53: aload_2
      //   54: aload_1
      //   55: invokevirtual 84	aa/a:n	(Ljava/io/IOException;)Ljava/io/IOException;
      //   58: astore_1
      //   59: aload_1
      //   60: athrow
      //   61: aload_2
      //   62: invokevirtual 80	aa/a:u	()Z
      //   65: pop
      //   66: aload_1
      //   67: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	68	0	this	c
      //   9	15	1	localObject1	Object
      //   38	1	1	localObject2	Object
      //   42	13	1	localIOException1	IOException
      //   58	9	1	localIOException2	IOException
      //   4	58	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   14	24	38	finally
      //   43	50	38	finally
      //   53	59	38	finally
      //   59	61	38	finally
      //   14	24	42	java/io/IOException
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AsyncTimeout.sink(");
      localStringBuilder.append(paramv);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
  
  public static final class d
    implements x
  {
    d(a parama, x paramx) {}
    
    public a a()
    {
      return this.a;
    }
    
    /* Error */
    public void close()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	aa/a$d:a	Laa/a;
      //   4: astore_2
      //   5: aload_0
      //   6: getfield 21	aa/a$d:b	Laa/x;
      //   9: astore_1
      //   10: aload_2
      //   11: invokevirtual 36	aa/a:t	()V
      //   14: aload_1
      //   15: invokeinterface 38 1 0
      //   20: getstatic 43	o8/o:a	Lo8/o;
      //   23: astore_1
      //   24: aload_2
      //   25: invokevirtual 47	aa/a:u	()Z
      //   28: ifne +4 -> 32
      //   31: return
      //   32: aload_2
      //   33: aconst_null
      //   34: invokevirtual 51	aa/a:n	(Ljava/io/IOException;)Ljava/io/IOException;
      //   37: athrow
      //   38: astore_1
      //   39: goto +22 -> 61
      //   42: astore_1
      //   43: aload_2
      //   44: invokevirtual 47	aa/a:u	()Z
      //   47: ifne +6 -> 53
      //   50: goto +9 -> 59
      //   53: aload_2
      //   54: aload_1
      //   55: invokevirtual 51	aa/a:n	(Ljava/io/IOException;)Ljava/io/IOException;
      //   58: astore_1
      //   59: aload_1
      //   60: athrow
      //   61: aload_2
      //   62: invokevirtual 47	aa/a:u	()Z
      //   65: pop
      //   66: aload_1
      //   67: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	68	0	this	d
      //   9	15	1	localObject1	Object
      //   38	1	1	localObject2	Object
      //   42	13	1	localIOException1	IOException
      //   58	9	1	localIOException2	IOException
      //   4	58	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   14	24	38	finally
      //   43	50	38	finally
      //   53	59	38	finally
      //   59	61	38	finally
      //   14	24	42	java/io/IOException
    }
    
    /* Error */
    public long k(b paramb, long paramLong)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc 55
      //   3: invokestatic 61	a9/f:f	(Ljava/lang/Object;Ljava/lang/String;)V
      //   6: aload_0
      //   7: getfield 19	aa/a$d:a	Laa/a;
      //   10: astore 4
      //   12: aload_0
      //   13: getfield 21	aa/a$d:b	Laa/x;
      //   16: astore 5
      //   18: aload 4
      //   20: invokevirtual 36	aa/a:t	()V
      //   23: aload 5
      //   25: aload_1
      //   26: lload_2
      //   27: invokeinterface 63 4 0
      //   32: lstore_2
      //   33: aload 4
      //   35: invokevirtual 47	aa/a:u	()Z
      //   38: ifne +5 -> 43
      //   41: lload_2
      //   42: lreturn
      //   43: aload 4
      //   45: aconst_null
      //   46: invokevirtual 51	aa/a:n	(Ljava/io/IOException;)Ljava/io/IOException;
      //   49: athrow
      //   50: astore_1
      //   51: goto +24 -> 75
      //   54: astore_1
      //   55: aload 4
      //   57: invokevirtual 47	aa/a:u	()Z
      //   60: ifne +6 -> 66
      //   63: goto +10 -> 73
      //   66: aload 4
      //   68: aload_1
      //   69: invokevirtual 51	aa/a:n	(Ljava/io/IOException;)Ljava/io/IOException;
      //   72: astore_1
      //   73: aload_1
      //   74: athrow
      //   75: aload 4
      //   77: invokevirtual 47	aa/a:u	()Z
      //   80: pop
      //   81: aload_1
      //   82: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	d
      //   0	83	1	paramb	b
      //   0	83	2	paramLong	long
      //   10	66	4	locala	a
      //   16	8	5	localx	x
      // Exception table:
      //   from	to	target	type
      //   23	33	50	finally
      //   55	63	50	finally
      //   66	73	50	finally
      //   73	75	50	finally
      //   23	33	54	java/io/IOException
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AsyncTimeout.source(");
      localStringBuilder.append(paramx);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.a
 * JD-Core Version:    0.7.0.1
 */