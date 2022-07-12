package t9;

import a9.g;
import aa.e;
import aa.x;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import u9.h.a;

public final class f
  implements Closeable
{
  public static final c C = new c(null);
  private static final m E;
  private final e A;
  private final Set<Integer> B;
  private final boolean a;
  private final d b;
  private final Map<Integer, i> c;
  private final String d;
  private int e;
  private int f;
  private boolean g;
  private final p9.d h;
  private final p9.c i;
  private final p9.c j;
  private final p9.c k;
  private final l l;
  private long m;
  private long n;
  private long o;
  private long p;
  private long q;
  private long r;
  private final m s;
  private m t;
  private long u;
  private long v;
  private long w;
  private long x;
  private final Socket y;
  private final j z;
  
  static
  {
    m localm = new m();
    localm.h(7, 65535);
    localm.h(5, 16384);
    E = localm;
  }
  
  public f(b paramb)
  {
    boolean bool = paramb.b();
    this.a = bool;
    this.b = paramb.d();
    this.c = new LinkedHashMap();
    String str = paramb.c();
    this.d = str;
    int i1;
    if (paramb.b()) {
      i1 = 3;
    } else {
      i1 = 2;
    }
    this.f = i1;
    Object localObject = paramb.j();
    this.h = ((p9.d)localObject);
    p9.c localc = ((p9.d)localObject).i();
    this.i = localc;
    this.j = ((p9.d)localObject).i();
    this.k = ((p9.d)localObject).i();
    this.l = paramb.f();
    localObject = new m();
    if (paramb.b()) {
      ((m)localObject).h(7, 16777216);
    }
    this.s = ((m)localObject);
    localObject = E;
    this.t = ((m)localObject);
    this.x = ((m)localObject).c();
    this.y = paramb.h();
    this.z = new j(paramb.g(), bool);
    this.A = new e(new h(paramb.i(), bool));
    this.B = new LinkedHashSet();
    if (paramb.e() != 0)
    {
      final long l1 = TimeUnit.MILLISECONDS.toNanos(paramb.e());
      localc.k(a9.f.m(str, " ping"), l1, new a(this, l1));
    }
  }
  
  private final i G0(int paramInt, List<c> paramList, boolean paramBoolean)
  {
    boolean bool = paramBoolean ^ true;
    for (;;)
    {
      synchronized (this.z)
      {
        try
        {
          if (w0() > 1073741823) {
            S0(b.j);
          }
          if (!this.g)
          {
            int i2 = w0();
            Q0(w0() + 2);
            i locali = new i(i2, this, bool, false, null);
            if ((!paramBoolean) || (D0() >= C0())) {
              break label232;
            }
            if (locali.r() >= locali.q())
            {
              break label232;
              if (locali.u()) {
                B0().put(Integer.valueOf(i2), locali);
              }
              o8.o localo = o8.o.a;
              if (paramInt == 0)
              {
                E0().e0(bool, i2, paramList);
              }
              else
              {
                if (!(true ^ s0())) {
                  continue;
                }
                E0().h0(paramInt, i2, paramList);
              }
              if (i1 != 0) {
                this.z.flush();
              }
              return locali;
              throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
            }
          }
          else
          {
            throw new a();
          }
        }
        finally {}
      }
      int i1 = 0;
      continue;
      label232:
      i1 = 1;
    }
  }
  
  private final void r0(IOException paramIOException)
  {
    b localb = b.d;
    q0(localb, localb, paramIOException);
  }
  
  public final i A0(int paramInt)
  {
    try
    {
      i locali = (i)this.c.get(Integer.valueOf(paramInt));
      return locali;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Map<Integer, i> B0()
  {
    return this.c;
  }
  
  public final long C0()
  {
    return this.x;
  }
  
  public final long D0()
  {
    return this.w;
  }
  
  public final j E0()
  {
    return this.z;
  }
  
  public final boolean F0(long paramLong)
  {
    try
    {
      boolean bool = this.g;
      if (bool) {
        return false;
      }
      if (this.p < this.o)
      {
        long l1 = this.r;
        if (paramLong >= l1) {
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  public final i H0(List<c> paramList, boolean paramBoolean)
  {
    a9.f.f(paramList, "requestHeaders");
    return G0(0, paramList, paramBoolean);
  }
  
  public final void I0(final int paramInt1, aa.d paramd, final int paramInt2, final boolean paramBoolean)
  {
    a9.f.f(paramd, "source");
    final aa.b localb = new aa.b();
    long l1 = paramInt2;
    paramd.U(l1);
    paramd.k(localb, l1);
    paramd = this.j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append('[');
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("] onData");
    p9.c.d(paramd, localStringBuilder.toString(), 0L, false, new f(this, paramInt1, localb, paramInt2, paramBoolean), 6, null);
  }
  
  public final void J0(final int paramInt, final List<c> paramList, final boolean paramBoolean)
  {
    a9.f.f(paramList, "requestHeaders");
    p9.c localc = this.j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append('[');
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] onHeaders");
    p9.c.d(localc, localStringBuilder.toString(), 0L, false, new g(this, paramInt, paramList, paramBoolean), 6, null);
  }
  
  public final void K0(final int paramInt, final List<c> paramList)
  {
    a9.f.f(paramList, "requestHeaders");
    try
    {
      if (this.B.contains(Integer.valueOf(paramInt)))
      {
        a1(paramInt, b.d);
        return;
      }
      this.B.add(Integer.valueOf(paramInt));
      p9.c localc = this.j;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append('[');
      localStringBuilder.append(paramInt);
      localStringBuilder.append("] onRequest");
      p9.c.d(localc, localStringBuilder.toString(), 0L, false, new h(this, paramInt, paramList), 6, null);
      return;
    }
    finally {}
  }
  
  public final void L0(final int paramInt, final b paramb)
  {
    a9.f.f(paramb, "errorCode");
    p9.c localc = this.j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append('[');
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] onReset");
    p9.c.d(localc, localStringBuilder.toString(), 0L, false, new i(this, paramInt, paramb), 6, null);
  }
  
  public final boolean M0(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  public final i N0(int paramInt)
  {
    try
    {
      i locali = (i)this.c.remove(Integer.valueOf(paramInt));
      notifyAll();
      return locali;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void O0()
  {
    try
    {
      long l1 = this.p;
      long l2 = this.o;
      if (l1 < l2) {
        return;
      }
      this.o = (l2 + 1L);
      this.r = (System.nanoTime() + 1000000000);
      o8.o localo = o8.o.a;
      p9.c.d(this.i, a9.f.m(this.d, " ping"), 0L, false, new j(this), 6, null);
      return;
    }
    finally {}
  }
  
  public final void P0(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void Q0(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void R0(m paramm)
  {
    a9.f.f(paramm, "<set-?>");
    this.t = paramm;
  }
  
  public final void S0(b paramb)
  {
    a9.f.f(paramb, "statusCode");
    synchronized (this.z)
    {
      a9.h localh = new a9.h();
      try
      {
        boolean bool = this.g;
        if (bool) {
          return;
        }
        this.g = true;
        localh.a = u0();
        o8.o localo = o8.o.a;
        E0().d0(localh.a, paramb, m9.l.a);
        return;
      }
      finally {}
    }
  }
  
  public final void T0(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.z.g();
      this.z.j0(this.s);
      int i1 = this.s.c();
      if (i1 != 65535) {
        this.z.k0(0, i1 - 65535);
      }
    }
    p9.c.d(this.h.i(), this.d, 0L, false, this.A, 6, null);
  }
  
  public final void V0(long paramLong)
  {
    try
    {
      paramLong = this.u + paramLong;
      this.u = paramLong;
      paramLong -= this.v;
      if (paramLong >= this.s.c() / 2)
      {
        b1(0, paramLong);
        this.v += paramLong;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void W0(int paramInt, boolean paramBoolean, aa.b paramb, long paramLong)
  {
    // Byte code:
    //   0: lload 4
    //   2: lstore 8
    //   4: lload 4
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +15 -> 23
    //   11: aload_0
    //   12: getfield 185	t9/f:z	Lt9/j;
    //   15: iload_2
    //   16: iload_1
    //   17: aload_3
    //   18: iconst_0
    //   19: invokevirtual 530	t9/j:h	(ZILaa/b;I)V
    //   22: return
    //   23: lload 8
    //   25: lconst_0
    //   26: lcmp
    //   27: ifle +174 -> 201
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: invokevirtual 261	t9/f:D0	()J
    //   36: aload_0
    //   37: invokevirtual 264	t9/f:C0	()J
    //   40: lcmp
    //   41: iflt +37 -> 78
    //   44: aload_0
    //   45: invokevirtual 274	t9/f:B0	()Ljava/util/Map;
    //   48: iload_1
    //   49: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: invokeinterface 533 2 0
    //   57: ifeq +10 -> 67
    //   60: aload_0
    //   61: invokevirtual 536	java/lang/Object:wait	()V
    //   64: goto -32 -> 32
    //   67: new 538	java/io/IOException
    //   70: dup
    //   71: ldc_w 540
    //   74: invokespecial 541	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: lload 8
    //   80: aload_0
    //   81: invokevirtual 264	t9/f:C0	()J
    //   84: aload_0
    //   85: invokevirtual 261	t9/f:D0	()J
    //   88: lsub
    //   89: invokestatic 547	java/lang/Math:min	(JJ)J
    //   92: l2i
    //   93: aload_0
    //   94: invokevirtual 295	t9/f:E0	()Lt9/j;
    //   97: invokevirtual 549	t9/j:f0	()I
    //   100: invokestatic 552	java/lang/Math:min	(II)I
    //   103: istore 6
    //   105: aload_0
    //   106: invokevirtual 261	t9/f:D0	()J
    //   109: lstore 4
    //   111: iload 6
    //   113: i2l
    //   114: lstore 10
    //   116: aload_0
    //   117: lload 4
    //   119: lload 10
    //   121: ladd
    //   122: putfield 374	t9/f:w	J
    //   125: getstatic 291	o8/o:a	Lo8/o;
    //   128: astore 12
    //   130: aload_0
    //   131: monitorexit
    //   132: lload 8
    //   134: lload 10
    //   136: lsub
    //   137: lstore 8
    //   139: aload_0
    //   140: getfield 185	t9/f:z	Lt9/j;
    //   143: astore 12
    //   145: iload_2
    //   146: ifeq +16 -> 162
    //   149: lload 8
    //   151: lconst_0
    //   152: lcmp
    //   153: ifne +9 -> 162
    //   156: iconst_1
    //   157: istore 7
    //   159: goto +6 -> 165
    //   162: iconst_0
    //   163: istore 7
    //   165: aload 12
    //   167: iload 7
    //   169: iload_1
    //   170: aload_3
    //   171: iload 6
    //   173: invokevirtual 530	t9/j:h	(ZILaa/b;I)V
    //   176: goto -153 -> 23
    //   179: astore_3
    //   180: goto +17 -> 197
    //   183: invokestatic 558	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   186: invokevirtual 561	java/lang/Thread:interrupt	()V
    //   189: new 563	java/io/InterruptedIOException
    //   192: dup
    //   193: invokespecial 564	java/io/InterruptedIOException:<init>	()V
    //   196: athrow
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_3
    //   200: athrow
    //   201: return
    //   202: astore_3
    //   203: goto -20 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	f
    //   0	206	1	paramInt	int
    //   0	206	2	paramBoolean	boolean
    //   0	206	3	paramb	aa.b
    //   0	206	4	paramLong	long
    //   103	69	6	i1	int
    //   157	11	7	bool	boolean
    //   2	148	8	l1	long
    //   114	21	10	l2	long
    //   128	38	12	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	64	179	finally
    //   67	78	179	finally
    //   78	111	179	finally
    //   116	130	179	finally
    //   183	197	179	finally
    //   32	64	202	java/lang/InterruptedException
    //   67	78	202	java/lang/InterruptedException
  }
  
  public final void X0(int paramInt, boolean paramBoolean, List<c> paramList)
  {
    a9.f.f(paramList, "alternating");
    this.z.e0(paramBoolean, paramInt, paramList);
  }
  
  public final void Y0(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      this.z.g0(paramBoolean, paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      r0(localIOException);
    }
  }
  
  public final void Z0(int paramInt, b paramb)
  {
    a9.f.f(paramb, "statusCode");
    this.z.i0(paramInt, paramb);
  }
  
  public final void a1(final int paramInt, final b paramb)
  {
    a9.f.f(paramb, "errorCode");
    p9.c localc = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append('[');
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] writeSynReset");
    p9.c.d(localc, localStringBuilder.toString(), 0L, false, new k(this, paramInt, paramb), 6, null);
  }
  
  public final void b1(final int paramInt, final long paramLong)
  {
    p9.c localc = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append('[');
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] windowUpdate");
    p9.c.d(localc, localStringBuilder.toString(), 0L, false, new l(this, paramInt, paramLong), 6, null);
  }
  
  public void close()
  {
    q0(b.c, b.k, null);
  }
  
  public final void flush()
  {
    this.z.flush();
  }
  
  /* Error */
  public final void q0(b paramb1, b paramb2, IOException paramIOException)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 591
    //   4: invokestatic 116	a9/f:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_2
    //   8: ldc_w 593
    //   11: invokestatic 116	a9/f:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: getstatic 597	m9/o:e	Z
    //   17: ifeq +66 -> 83
    //   20: aload_0
    //   21: invokestatic 600	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   24: ifne +6 -> 30
    //   27: goto +56 -> 83
    //   30: new 407	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 408	java/lang/StringBuilder:<init>	()V
    //   37: astore_1
    //   38: aload_1
    //   39: ldc_w 602
    //   42: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: invokestatic 558	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   50: invokevirtual 605	java/lang/Thread:getName	()Ljava/lang/String;
    //   53: invokevirtual 608	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_1
    //   58: ldc_w 610
    //   61: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_1
    //   66: aload_0
    //   67: invokevirtual 608	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: new 612	java/lang/AssertionError
    //   74: dup
    //   75: aload_1
    //   76: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 615	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   82: athrow
    //   83: aload_0
    //   84: aload_1
    //   85: invokevirtual 246	t9/f:S0	(Lt9/b;)V
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_0
    //   91: monitorenter
    //   92: aload_0
    //   93: invokevirtual 274	t9/f:B0	()Ljava/util/Map;
    //   96: invokeinterface 618 1 0
    //   101: istore 6
    //   103: iconst_0
    //   104: istore 4
    //   106: iload 6
    //   108: iconst_1
    //   109: ixor
    //   110: ifeq +49 -> 159
    //   113: aload_0
    //   114: invokevirtual 274	t9/f:B0	()Ljava/util/Map;
    //   117: invokeinterface 622 1 0
    //   122: iconst_0
    //   123: anewarray 254	t9/i
    //   126: invokeinterface 628 2 0
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +15 -> 148
    //   136: aload_0
    //   137: invokevirtual 274	t9/f:B0	()Ljava/util/Map;
    //   140: invokeinterface 631 1 0
    //   145: goto +14 -> 159
    //   148: new 633	java/lang/NullPointerException
    //   151: dup
    //   152: ldc_w 635
    //   155: invokespecial 636	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   158: athrow
    //   159: getstatic 291	o8/o:a	Lo8/o;
    //   162: astore 7
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_1
    //   167: checkcast 638	[Lt9/i;
    //   170: astore_1
    //   171: aload_1
    //   172: ifnonnull +6 -> 178
    //   175: goto +36 -> 211
    //   178: aload_1
    //   179: arraylength
    //   180: istore 5
    //   182: iload 4
    //   184: iload 5
    //   186: if_icmpge +25 -> 211
    //   189: aload_1
    //   190: iload 4
    //   192: aaload
    //   193: astore 7
    //   195: iload 4
    //   197: iconst_1
    //   198: iadd
    //   199: istore 4
    //   201: aload 7
    //   203: aload_2
    //   204: aload_3
    //   205: invokevirtual 641	t9/i:d	(Lt9/b;Ljava/io/IOException;)V
    //   208: goto -26 -> 182
    //   211: aload_0
    //   212: invokevirtual 295	t9/f:E0	()Lt9/j;
    //   215: invokevirtual 643	t9/j:close	()V
    //   218: aload_0
    //   219: invokevirtual 646	t9/f:z0	()Ljava/net/Socket;
    //   222: invokevirtual 649	java/net/Socket:close	()V
    //   225: aload_0
    //   226: getfield 151	t9/f:i	Lp9/c;
    //   229: invokevirtual 651	p9/c:r	()V
    //   232: aload_0
    //   233: getfield 153	t9/f:j	Lp9/c;
    //   236: invokevirtual 651	p9/c:r	()V
    //   239: aload_0
    //   240: getfield 155	t9/f:k	Lp9/c;
    //   243: invokevirtual 651	p9/c:r	()V
    //   246: return
    //   247: astore_1
    //   248: aload_0
    //   249: monitorexit
    //   250: aload_1
    //   251: athrow
    //   252: astore_1
    //   253: goto -165 -> 88
    //   256: astore 7
    //   258: goto -76 -> 182
    //   261: astore_1
    //   262: goto -44 -> 218
    //   265: astore_1
    //   266: goto -41 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	f
    //   0	269	1	paramb1	b
    //   0	269	2	paramb2	b
    //   0	269	3	paramIOException	IOException
    //   104	96	4	i1	int
    //   180	7	5	i2	int
    //   101	9	6	bool	boolean
    //   162	40	7	localo	o8.o
    //   256	1	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   92	103	247	finally
    //   113	132	247	finally
    //   136	145	247	finally
    //   148	159	247	finally
    //   159	164	247	finally
    //   83	88	252	java/io/IOException
    //   201	208	256	java/io/IOException
    //   211	218	261	java/io/IOException
    //   218	225	265	java/io/IOException
  }
  
  public final boolean s0()
  {
    return this.a;
  }
  
  public final String t0()
  {
    return this.d;
  }
  
  public final int u0()
  {
    return this.e;
  }
  
  public final d v0()
  {
    return this.b;
  }
  
  public final int w0()
  {
    return this.f;
  }
  
  public final m x0()
  {
    return this.s;
  }
  
  public final m y0()
  {
    return this.t;
  }
  
  public final Socket z0()
  {
    return this.y;
  }
  
  static final class a
    extends g
    implements z8.a<Long>
  {
    a(f paramf, long paramLong)
    {
      super();
    }
    
    public final Long d()
    {
      synchronized (this.b)
      {
        int i;
        if (f.e0(???) < f.d0(???))
        {
          i = 1;
        }
        else
        {
          f.m0(???, f.d0(???) + 1L);
          i = 0;
        }
        ??? = this.b;
        if (i != 0)
        {
          f.a(???, null);
          l = -1L;
          return Long.valueOf(l);
        }
        ???.Y0(false, 1, 0);
        long l = l1;
      }
    }
  }
  
  public static final class b
  {
    private boolean a;
    private final p9.d b;
    public Socket c;
    public String d;
    public aa.d e;
    public aa.c f;
    private f.d g;
    private l h;
    private int i;
    
    public b(boolean paramBoolean, p9.d paramd)
    {
      this.a = paramBoolean;
      this.b = paramd;
      this.g = f.d.b;
      this.h = l.b;
    }
    
    public final f a()
    {
      return new f(this);
    }
    
    public final boolean b()
    {
      return this.a;
    }
    
    public final String c()
    {
      String str = this.d;
      if (str != null) {
        return str;
      }
      a9.f.t("connectionName");
      return null;
    }
    
    public final f.d d()
    {
      return this.g;
    }
    
    public final int e()
    {
      return this.i;
    }
    
    public final l f()
    {
      return this.h;
    }
    
    public final aa.c g()
    {
      aa.c localc = this.f;
      if (localc != null) {
        return localc;
      }
      a9.f.t("sink");
      return null;
    }
    
    public final Socket h()
    {
      Socket localSocket = this.c;
      if (localSocket != null) {
        return localSocket;
      }
      a9.f.t("socket");
      return null;
    }
    
    public final aa.d i()
    {
      aa.d locald = this.e;
      if (locald != null) {
        return locald;
      }
      a9.f.t("source");
      return null;
    }
    
    public final p9.d j()
    {
      return this.b;
    }
    
    public final b k(f.d paramd)
    {
      a9.f.f(paramd, "listener");
      n(paramd);
      return this;
    }
    
    public final b l(int paramInt)
    {
      o(paramInt);
      return this;
    }
    
    public final void m(String paramString)
    {
      a9.f.f(paramString, "<set-?>");
      this.d = paramString;
    }
    
    public final void n(f.d paramd)
    {
      a9.f.f(paramd, "<set-?>");
      this.g = paramd;
    }
    
    public final void o(int paramInt)
    {
      this.i = paramInt;
    }
    
    public final void p(aa.c paramc)
    {
      a9.f.f(paramc, "<set-?>");
      this.f = paramc;
    }
    
    public final void q(Socket paramSocket)
    {
      a9.f.f(paramSocket, "<set-?>");
      this.c = paramSocket;
    }
    
    public final void r(aa.d paramd)
    {
      a9.f.f(paramd, "<set-?>");
      this.e = paramd;
    }
    
    public final b s(Socket paramSocket, String paramString, aa.d paramd, aa.c paramc)
    {
      a9.f.f(paramSocket, "socket");
      a9.f.f(paramString, "peerName");
      a9.f.f(paramd, "source");
      a9.f.f(paramc, "sink");
      q(paramSocket);
      if (b())
      {
        paramSocket = new StringBuilder();
        paramSocket.append(m9.o.f);
        paramSocket.append(' ');
        paramSocket.append(paramString);
        paramSocket = paramSocket.toString();
      }
      else
      {
        paramSocket = a9.f.m("MockWebServer ", paramString);
      }
      m(paramSocket);
      r(paramd);
      p(paramc);
      return this;
    }
  }
  
  public static final class c
  {
    public final m a()
    {
      return f.i();
    }
  }
  
  public static abstract class d
  {
    public static final b a = new b(null);
    public static final d b = new a();
    
    public void b(f paramf, m paramm)
    {
      a9.f.f(paramf, "connection");
      a9.f.f(paramm, "settings");
    }
    
    public abstract void c(i parami);
    
    public static final class a
      extends f.d
    {
      public void c(i parami)
      {
        a9.f.f(parami, "stream");
        parami.d(b.j, null);
      }
    }
    
    public static final class b {}
  }
  
  public final class e
    implements h.c, z8.a<o8.o>
  {
    private final h a;
    
    public e()
    {
      this.a = localObject;
    }
    
    public void a(final boolean paramBoolean, final m paramm)
    {
      a9.f.f(paramm, "settings");
      p9.c.d(f.i0(f.this), a9.f.m(f.this.t0(), " applyAndAckSettings"), 0L, false, new d(this, paramBoolean, paramm), 6, null);
    }
    
    public void c() {}
    
    public void d(boolean paramBoolean, final int paramInt1, final int paramInt2)
    {
      if (paramBoolean)
      {
        f localf = f.this;
        if ((paramInt1 == 1) || ((paramInt1 == 2) || (paramInt1 != 3))) {}
        try
        {
          for (;;)
          {
            o8.o localo = o8.o.a;
            break;
            f.k0(localf, f.g(localf) + 1L);
            localf.notifyAll();
          }
          f.l0(localf, f.B(localf) + 1L);
          break label83;
          f.n0(localf, f.e0(localf) + 1L);
          label83:
          return;
        }
        finally {}
      }
      p9.c.d(f.i0(f.this), a9.f.m(f.this.t0(), " ping"), 0L, false, new c(f.this, paramInt1, paramInt2), 6, null);
    }
    
    public void e(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void f(boolean paramBoolean, int paramInt1, int paramInt2, final List<c> paramList)
    {
      a9.f.f(paramList, "headerBlock");
      if (f.this.M0(paramInt1))
      {
        f.this.J0(paramInt1, paramList, paramBoolean);
        return;
      }
      synchronized (f.this)
      {
        Object localObject1 = ???.A0(paramInt1);
        if (localObject1 == null)
        {
          boolean bool = f.j0(???);
          if (bool) {
            return;
          }
          paramInt2 = ???.u0();
          if (paramInt1 <= paramInt2) {
            return;
          }
          paramInt2 = ???.w0();
          if (paramInt1 % 2 == paramInt2 % 2) {
            return;
          }
          paramList = new i(paramInt1, ???, false, paramBoolean, m9.o.r(paramList));
          ???.P0(paramInt1);
          ???.B0().put(Integer.valueOf(paramInt1), paramList);
          localObject1 = f.h0(???).i();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(???.t0());
          ((StringBuilder)localObject2).append('[');
          ((StringBuilder)localObject2).append(paramInt1);
          ((StringBuilder)localObject2).append("] onStream");
          p9.c.d((p9.c)localObject1, ((StringBuilder)localObject2).toString(), 0L, false, new b(???, paramList), 6, null);
          return;
        }
        Object localObject2 = o8.o.a;
        ((i)localObject1).x(m9.o.r(paramList), paramBoolean);
        return;
      }
    }
    
    public void g(int paramInt, b paramb)
    {
      a9.f.f(paramb, "errorCode");
      if (f.this.M0(paramInt))
      {
        f.this.L0(paramInt, paramb);
        return;
      }
      i locali = f.this.N0(paramInt);
      if (locali == null) {
        return;
      }
      locali.y(paramb);
    }
    
    public void h(int paramInt, long paramLong)
    {
      if (paramInt == 0) {}
      synchronized (f.this)
      {
        f.p0((f)???, ((f)???).C0() + paramLong);
        ???.notifyAll();
        o8.o localo1 = o8.o.a;
      }
      if (??? != null) {
        try
        {
          ((i)???).a(paramLong);
          o8.o localo2 = o8.o.a;
          return;
        }
        finally
        {
          localObject3 = finally;
          throw localObject3;
        }
      }
    }
    
    public void i(int paramInt, b arg2, e parame)
    {
      a9.f.f(???, "errorCode");
      a9.f.f(parame, "debugData");
      parame.r();
      synchronized (f.this)
      {
        parame = ???.B0().values();
        int i = 0;
        parame = parame.toArray(new i[0]);
        if (parame != null)
        {
          f.o0(???, true);
          o8.o localo = o8.o.a;
          ??? = (i[])parame;
          int k = ???.length;
          while (i < k)
          {
            parame = ???[i];
            int j = i + 1;
            i = j;
            if (parame.j() > paramInt)
            {
              i = j;
              if (parame.t())
              {
                parame.y(b.j);
                f.this.N0(parame.j());
                i = j;
              }
            }
          }
          return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
      }
    }
    
    public void j(int paramInt1, int paramInt2, List<c> paramList)
    {
      a9.f.f(paramList, "requestHeaders");
      f.this.K0(paramInt2, paramList);
    }
    
    public void k(boolean paramBoolean, int paramInt1, aa.d paramd, int paramInt2)
    {
      a9.f.f(paramd, "source");
      if (f.this.M0(paramInt1))
      {
        f.this.I0(paramInt1, paramd, paramInt2, paramBoolean);
        return;
      }
      Object localObject = f.this.A0(paramInt1);
      if (localObject == null)
      {
        f.this.a1(paramInt1, b.d);
        localObject = f.this;
        long l = paramInt2;
        ((f)localObject).V0(l);
        paramd.skip(l);
        return;
      }
      ((i)localObject).w(paramd, paramInt2);
      if (paramBoolean) {
        ((i)localObject).x(m9.o.a, true);
      }
    }
    
    public final void l(boolean paramBoolean, m paramm)
    {
      a9.f.f(paramm, "settings");
      final a9.i locali = new a9.i();
      Object localObject2 = f.this.E0();
      f localf = f.this;
      for (;;)
      {
        try
        {
          try
          {
            m localm = localf.y0();
            Object localObject1;
            if (!paramBoolean)
            {
              localObject1 = new m();
              ((m)localObject1).g(localm);
              ((m)localObject1).g(paramm);
              paramm = (m)localObject1;
            }
            locali.a = paramm;
            long l = paramm.c() - localm.c();
            int i = 0;
            if ((l != 0L) && (!localf.B0().isEmpty()))
            {
              paramm = localf.B0().values().toArray(new i[0]);
              if (paramm != null) {
                paramm = (i[])paramm;
              } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
              }
              localf.R0((m)locali.a);
              p9.c.d(f.g0(localf), a9.f.m(localf.t0(), " onSettings"), 0L, false, new a(localf, locali), 6, null);
              localObject1 = o8.o.a;
              try
              {
                localf.E0().a((m)locali.a);
              }
              catch (IOException localIOException)
              {
                f.a(localf, localIOException);
              }
              o8.o localo = o8.o.a;
              if (paramm != null)
              {
                int j = paramm.length;
                if (i < j)
                {
                  localo = paramm[i];
                  i += 1;
                  try
                  {
                    localo.a(l);
                    localObject2 = o8.o.a;
                    continue;
                  }
                  finally
                  {
                    paramm = finally;
                    throw paramm;
                  }
                }
              }
              return;
            }
          }
          finally {}
          paramm = null;
        }
        finally {}
      }
    }
    
    /* Error */
    public void m()
    {
      // Byte code:
      //   0: getstatic 355	t9/b:e	Lt9/b;
      //   3: astore 4
      //   5: aconst_null
      //   6: astore_1
      //   7: aconst_null
      //   8: astore_2
      //   9: aload_0
      //   10: getfield 43	t9/f$e:a	Lt9/h;
      //   13: aload_0
      //   14: invokevirtual 360	t9/h:h	(Lt9/h$c;)V
      //   17: aload_0
      //   18: getfield 43	t9/f$e:a	Lt9/h;
      //   21: iconst_0
      //   22: aload_0
      //   23: invokevirtual 363	t9/h:g	(ZLt9/h$c;)Z
      //   26: ifeq +6 -> 32
      //   29: goto -12 -> 17
      //   32: getstatic 365	t9/b:c	Lt9/b;
      //   35: astore 5
      //   37: aload_2
      //   38: astore_1
      //   39: aload 5
      //   41: astore_2
      //   42: getstatic 367	t9/b:k	Lt9/b;
      //   45: astore_3
      //   46: aload_0
      //   47: getfield 38	t9/f$e:b	Lt9/f;
      //   50: aload 5
      //   52: aload_3
      //   53: aconst_null
      //   54: invokevirtual 371	t9/f:q0	(Lt9/b;Lt9/b;Ljava/io/IOException;)V
      //   57: goto +40 -> 97
      //   60: astore_3
      //   61: aload 5
      //   63: astore_2
      //   64: goto +14 -> 78
      //   67: astore_3
      //   68: aload 4
      //   70: astore_2
      //   71: goto +35 -> 106
      //   74: astore_3
      //   75: aload 4
      //   77: astore_2
      //   78: aload_3
      //   79: astore_1
      //   80: getstatic 289	t9/b:d	Lt9/b;
      //   83: astore 5
      //   85: aload_0
      //   86: getfield 38	t9/f$e:b	Lt9/f;
      //   89: aload 5
      //   91: aload 5
      //   93: aload_3
      //   94: invokevirtual 371	t9/f:q0	(Lt9/b;Lt9/b;Ljava/io/IOException;)V
      //   97: aload_0
      //   98: getfield 43	t9/f$e:a	Lt9/h;
      //   101: invokestatic 376	m9/l:f	(Ljava/io/Closeable;)V
      //   104: return
      //   105: astore_3
      //   106: aload_0
      //   107: getfield 38	t9/f$e:b	Lt9/f;
      //   110: aload_2
      //   111: aload 4
      //   113: aload_1
      //   114: invokevirtual 371	t9/f:q0	(Lt9/b;Lt9/b;Ljava/io/IOException;)V
      //   117: aload_0
      //   118: getfield 43	t9/f$e:a	Lt9/h;
      //   121: invokestatic 376	m9/l:f	(Ljava/io/Closeable;)V
      //   124: aload_3
      //   125: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	126	0	this	e
      //   6	108	1	localObject1	Object
      //   8	103	2	localObject2	Object
      //   45	8	3	localb1	b
      //   60	1	3	localIOException1	IOException
      //   67	1	3	localObject3	Object
      //   74	20	3	localIOException2	IOException
      //   105	20	3	localObject4	Object
      //   3	109	4	localb2	b
      //   35	57	5	localb3	b
      // Exception table:
      //   from	to	target	type
      //   42	46	60	java/io/IOException
      //   9	17	67	finally
      //   17	29	67	finally
      //   32	37	67	finally
      //   9	17	74	java/io/IOException
      //   17	29	74	java/io/IOException
      //   32	37	74	java/io/IOException
      //   42	46	105	finally
      //   80	85	105	finally
    }
    
    static final class a
      extends g
      implements z8.a<o8.o>
    {
      a(f paramf, a9.i<m> parami)
      {
        super();
      }
      
      public final void d()
      {
        this.b.v0().b(this.b, (m)locali.a);
      }
    }
    
    static final class b
      extends g
      implements z8.a<o8.o>
    {
      b(f paramf, i parami)
      {
        super();
      }
      
      public final void d()
      {
        try
        {
          this.b.v0().c(paramList);
          return;
        }
        catch (IOException localIOException1)
        {
          u9.h.a.g().j(a9.f.m("Http2Connection.Listener failure for ", this.b.t0()), 4, localIOException1);
          i locali = paramList;
          try
          {
            locali.d(b.d, localIOException1);
            return;
          }
          catch (IOException localIOException2) {}
        }
      }
    }
    
    static final class c
      extends g
      implements z8.a<o8.o>
    {
      c(f paramf, int paramInt1, int paramInt2)
      {
        super();
      }
      
      public final void d()
      {
        this.b.Y0(true, paramInt1, paramInt2);
      }
    }
    
    static final class d
      extends g
      implements z8.a<o8.o>
    {
      d(f.e parame, boolean paramBoolean, m paramm)
      {
        super();
      }
      
      public final void d()
      {
        this.b.l(paramBoolean, paramm);
      }
    }
  }
  
  static final class f
    extends g
    implements z8.a<o8.o>
  {
    f(f paramf, int paramInt1, aa.b paramb, int paramInt2, boolean paramBoolean)
    {
      super();
    }
    
    public final void d()
    {
      f localf = this.b;
      int i = paramInt1;
      aa.b localb = localb;
      int j = paramInt2;
      boolean bool1 = paramBoolean;
      boolean bool2;
      for (;;)
      {
        try
        {
          bool2 = f.f0(localf).d(i, localb, j, bool1);
          if (!bool2) {
            break label98;
          }
          localf.E0().i0(i, b.k);
        }
        catch (IOException localIOException)
        {
          return;
        }
        try
        {
          f.h(localf).remove(Integer.valueOf(i));
          return;
        }
        finally
        {
          localObject = finally;
          throw localObject;
        }
        return;
        label98:
        if (!bool2) {
          if (!bool1) {
            break;
          }
        }
      }
    }
  }
  
  static final class g
    extends g
    implements z8.a<o8.o>
  {
    g(f paramf, int paramInt, List<c> paramList, boolean paramBoolean)
    {
      super();
    }
    
    public final void d()
    {
      boolean bool1 = f.f0(this.b).b(paramInt, paramList, paramBoolean);
      f localf = this.b;
      int i = paramInt;
      boolean bool2 = paramBoolean;
      if (bool1) {
        break label90;
      }
      for (;;)
      {
        try
        {
          localf.E0().i0(i, b.k);
        }
        catch (IOException localIOException)
        {
          label90:
          return;
        }
        try
        {
          f.h(localf).remove(Integer.valueOf(i));
          return;
        }
        finally
        {
          localObject = finally;
          throw localObject;
        }
        return;
        if (!bool1) {
          if (!bool2) {
            break;
          }
        }
      }
    }
  }
  
  static final class h
    extends g
    implements z8.a<o8.o>
  {
    h(f paramf, int paramInt, List<c> paramList)
    {
      super();
    }
    
    public final void d()
    {
      boolean bool = f.f0(this.b).a(paramInt, paramList);
      f localf = this.b;
      int i = paramInt;
      if (bool) {}
      try
      {
        localf.E0().i0(i, b.k);
        try
        {
          f.h(localf).remove(Integer.valueOf(i));
          return;
        }
        finally
        {
          localObject = finally;
          throw localObject;
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  static final class i
    extends g
    implements z8.a<o8.o>
  {
    i(f paramf, int paramInt, b paramb)
    {
      super();
    }
    
    public final void d()
    {
      f.f0(this.b).c(paramInt, paramb);
      f localf = this.b;
      int i = paramInt;
      try
      {
        f.h(localf).remove(Integer.valueOf(i));
        o8.o localo = o8.o.a;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  static final class j
    extends g
    implements z8.a<o8.o>
  {
    j(f paramf)
    {
      super();
    }
    
    public final void d()
    {
      this.b.Y0(false, 2, 0);
    }
  }
  
  static final class k
    extends g
    implements z8.a<o8.o>
  {
    k(f paramf, int paramInt, b paramb)
    {
      super();
    }
    
    public final void d()
    {
      try
      {
        this.b.Z0(paramInt, paramb);
        return;
      }
      catch (IOException localIOException)
      {
        f.a(this.b, localIOException);
      }
    }
  }
  
  static final class l
    extends g
    implements z8.a<o8.o>
  {
    l(f paramf, int paramInt, long paramLong)
    {
      super();
    }
    
    public final void d()
    {
      try
      {
        this.b.E0().k0(paramInt, paramLong);
        return;
      }
      catch (IOException localIOException)
      {
        f.a(this.b, localIOException);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t9.f
 * JD-Core Version:    0.7.0.1
 */