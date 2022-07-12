package t;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import x0.h;

final class g
  implements Executor
{
  final Deque<Runnable> a = new ArrayDeque();
  private final Executor b;
  private final b c = new b();
  c d = c.a;
  long e = 0L;
  
  g(Executor paramExecutor)
  {
    this.b = ((Executor)h.g(paramExecutor));
  }
  
  public void execute(final Runnable paramRunnable)
  {
    h.g(paramRunnable);
    for (;;)
    {
      synchronized (this.a)
      {
        ??? = this.d;
        c localc;
        int j;
        if (??? != c.d)
        {
          localc = c.c;
          if (??? != localc)
          {
            long l = this.e;
            ??? = new a(paramRunnable);
            this.a.add(???);
            paramRunnable = c.b;
            this.d = paramRunnable;
            j = 1;
            i = 1;
            try
            {
              this.b.execute(this.c);
              if (this.d == paramRunnable) {
                i = 0;
              }
              if (i != 0) {
                return;
              }
              synchronized (this.a)
              {
                if ((this.e == l) && (this.d == paramRunnable)) {
                  this.d = localc;
                }
                return;
              }
              synchronized (this.a)
              {
                localc = this.d;
                if (((localc != c.a) && (localc != c.b)) || (!this.a.removeLastOccurrence(???))) {
                  break label261;
                }
                i = j;
                if (((paramRunnable instanceof RejectedExecutionException)) && (i == 0)) {
                  return;
                }
                throw paramRunnable;
              }
            }
            catch (Error paramRunnable) {}catch (RuntimeException paramRunnable) {}
          }
        }
        this.a.add(paramRunnable);
        return;
      }
      label261:
      int i = 0;
    }
  }
  
  class a
    implements Runnable
  {
    a(Runnable paramRunnable) {}
    
    public void run()
    {
      paramRunnable.run();
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    /* Error */
    private void a()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: iconst_0
      //   3: istore_1
      //   4: iload_1
      //   5: istore 4
      //   7: aload_0
      //   8: getfield 15	t/g$b:a	Lt/g;
      //   11: getfield 24	t/g:a	Ljava/util/Deque;
      //   14: astore 6
      //   16: iload_1
      //   17: istore 4
      //   19: aload 6
      //   21: monitorenter
      //   22: iload_2
      //   23: istore_3
      //   24: iload_2
      //   25: ifne +63 -> 88
      //   28: aload_0
      //   29: getfield 15	t/g$b:a	Lt/g;
      //   32: astore 7
      //   34: aload 7
      //   36: getfield 28	t/g:d	Lt/g$c;
      //   39: astore 8
      //   41: getstatic 31	t/g$c:d	Lt/g$c;
      //   44: astore 9
      //   46: aload 8
      //   48: aload 9
      //   50: if_acmpne +17 -> 67
      //   53: aload 6
      //   55: monitorexit
      //   56: iload_1
      //   57: ifeq +9 -> 66
      //   60: invokestatic 37	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   63: invokevirtual 40	java/lang/Thread:interrupt	()V
      //   66: return
      //   67: aload 7
      //   69: aload 7
      //   71: getfield 44	t/g:e	J
      //   74: lconst_1
      //   75: ladd
      //   76: putfield 44	t/g:e	J
      //   79: aload 7
      //   81: aload 9
      //   83: putfield 28	t/g:d	Lt/g$c;
      //   86: iconst_1
      //   87: istore_3
      //   88: aload_0
      //   89: getfield 15	t/g$b:a	Lt/g;
      //   92: getfield 24	t/g:a	Ljava/util/Deque;
      //   95: invokeinterface 50 1 0
      //   100: checkcast 6	java/lang/Runnable
      //   103: astore 7
      //   105: aload 7
      //   107: ifnonnull +27 -> 134
      //   110: aload_0
      //   111: getfield 15	t/g$b:a	Lt/g;
      //   114: getstatic 52	t/g$c:a	Lt/g$c;
      //   117: putfield 28	t/g:d	Lt/g$c;
      //   120: aload 6
      //   122: monitorexit
      //   123: iload_1
      //   124: ifeq +9 -> 133
      //   127: invokestatic 37	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   130: invokevirtual 40	java/lang/Thread:interrupt	()V
      //   133: return
      //   134: aload 6
      //   136: monitorexit
      //   137: iload_1
      //   138: istore 4
      //   140: invokestatic 56	java/lang/Thread:interrupted	()Z
      //   143: istore 5
      //   145: iload_1
      //   146: iload 5
      //   148: ior
      //   149: istore_1
      //   150: iload_1
      //   151: istore 4
      //   153: aload 7
      //   155: invokeinterface 59 1 0
      //   160: iload_3
      //   161: istore_2
      //   162: goto -158 -> 4
      //   165: astore 6
      //   167: iload_1
      //   168: istore 4
      //   170: new 61	java/lang/StringBuilder
      //   173: dup
      //   174: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   177: astore 8
      //   179: iload_1
      //   180: istore 4
      //   182: aload 8
      //   184: ldc 64
      //   186: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   189: pop
      //   190: iload_1
      //   191: istore 4
      //   193: aload 8
      //   195: aload 7
      //   197: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   200: pop
      //   201: iload_1
      //   202: istore 4
      //   204: ldc 73
      //   206: aload 8
      //   208: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   211: aload 6
      //   213: invokestatic 82	androidx/camera/core/n1:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   216: iload_3
      //   217: istore_2
      //   218: goto -214 -> 4
      //   221: astore 7
      //   223: aload 6
      //   225: monitorexit
      //   226: iload_1
      //   227: istore 4
      //   229: aload 7
      //   231: athrow
      //   232: astore 6
      //   234: iload 4
      //   236: ifeq +9 -> 245
      //   239: invokestatic 37	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   242: invokevirtual 40	java/lang/Thread:interrupt	()V
      //   245: aload 6
      //   247: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	248	0	this	b
      //   3	224	1	bool1	boolean
      //   1	217	2	i	int
      //   23	194	3	j	int
      //   5	230	4	k	int
      //   143	6	5	bool2	boolean
      //   14	121	6	localDeque	Deque
      //   165	59	6	localRuntimeException	RuntimeException
      //   232	14	6	localObject1	Object
      //   32	164	7	localObject2	Object
      //   221	9	7	localObject3	Object
      //   39	168	8	localObject4	Object
      //   44	38	9	localc	g.c
      // Exception table:
      //   from	to	target	type
      //   153	160	165	java/lang/RuntimeException
      //   28	46	221	finally
      //   53	56	221	finally
      //   67	86	221	finally
      //   88	105	221	finally
      //   110	123	221	finally
      //   134	137	221	finally
      //   223	226	221	finally
      //   7	16	232	finally
      //   19	22	232	finally
      //   140	145	232	finally
      //   153	160	232	finally
      //   170	179	232	finally
      //   182	190	232	finally
      //   193	201	232	finally
      //   204	216	232	finally
      //   229	232	232	finally
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 86	t/g$b:a	()V
      //   4: return
      //   5: astore_2
      //   6: aload_0
      //   7: getfield 15	t/g$b:a	Lt/g;
      //   10: getfield 24	t/g:a	Ljava/util/Deque;
      //   13: astore_1
      //   14: aload_1
      //   15: monitorenter
      //   16: aload_0
      //   17: getfield 15	t/g$b:a	Lt/g;
      //   20: getstatic 52	t/g$c:a	Lt/g$c;
      //   23: putfield 28	t/g:d	Lt/g$c;
      //   26: aload_1
      //   27: monitorexit
      //   28: aload_2
      //   29: athrow
      //   30: astore_2
      //   31: aload_1
      //   32: monitorexit
      //   33: aload_2
      //   34: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	35	0	this	b
      //   13	19	1	localDeque	Deque
      //   5	24	2	localError	Error
      //   30	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   0	4	5	java/lang/Error
      //   16	28	30	finally
      //   31	33	30	finally
    }
  }
  
  static enum c
  {
    static
    {
      c localc1 = new c("IDLE", 0);
      a = localc1;
      c localc2 = new c("QUEUING", 1);
      b = localc2;
      c localc3 = new c("QUEUED", 2);
      c = localc3;
      c localc4 = new c("RUNNING", 3);
      d = localc4;
      e = new c[] { localc1, localc2, localc3, localc4 };
    }
    
    private c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t.g
 * JD-Core Version:    0.7.0.1
 */