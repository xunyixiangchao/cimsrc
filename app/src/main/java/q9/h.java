package q9;

import aa.y;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import l9.b0;
import l9.d0;
import l9.e;
import l9.f0;
import l9.r;
import l9.t;
import l9.t.c;
import l9.x;

public final class h
  implements e, Cloneable
{
  private final b0 a;
  private final d0 b;
  private final boolean c;
  private final j d;
  private final t e;
  private final c f;
  private final AtomicBoolean g;
  private Object h;
  private d i;
  private i j;
  private boolean k;
  private c l;
  private boolean m;
  private boolean n;
  private boolean o;
  private volatile boolean p;
  private volatile c q;
  private final CopyOnWriteArrayList<n.c> r;
  
  public h(b0 paramb0, d0 paramd0, boolean paramBoolean)
  {
    this.a = paramb0;
    this.b = paramd0;
    this.c = paramBoolean;
    this.d = paramb0.l().a();
    this.e = paramb0.q().a(this);
    paramb0 = new c(this);
    paramb0.g(m().f(), TimeUnit.MILLISECONDS);
    this.f = paramb0;
    this.g = new AtomicBoolean();
    this.o = true;
    this.r = new CopyOnWriteArrayList();
  }
  
  private final <E extends IOException> E C(E paramE)
  {
    if (this.k) {
      return paramE;
    }
    if (!this.f.u()) {
      return paramE;
    }
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramE != null) {
      localInterruptedIOException.initCause(paramE);
    }
    return localInterruptedIOException;
  }
  
  private final String D()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (i()) {
      str = "canceled ";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    if (this.c) {
      str = "web socket";
    } else {
      str = "call";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" to ");
    localStringBuilder.append(x());
    return localStringBuilder.toString();
  }
  
  private final <E extends IOException> E d(E paramE)
  {
    boolean bool = m9.o.e;
    if ((bool) && (Thread.holdsLock(this)))
    {
      paramE = new StringBuilder();
      paramE.append("Thread ");
      paramE.append(Thread.currentThread().getName());
      paramE.append(" MUST NOT hold lock on ");
      paramE.append(this);
      throw new AssertionError(paramE.toString());
    }
    Object localObject = this.j;
    if (localObject != null)
    {
      if ((bool) && (Thread.holdsLock(localObject)))
      {
        paramE = new StringBuilder();
        paramE.append("Thread ");
        paramE.append(Thread.currentThread().getName());
        paramE.append(" MUST NOT hold lock on ");
        paramE.append(localObject);
        throw new AssertionError(paramE.toString());
      }
      try
      {
        Socket localSocket = y();
        if (this.j == null)
        {
          if (localSocket != null) {
            m9.o.g(localSocket);
          }
          this.e.k(this, (l9.j)localObject);
        }
        else
        {
          int i1;
          if (localSocket == null) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i1 == 0) {
            throw new IllegalStateException("Check failed.".toString());
          }
        }
      }
      finally {}
    }
    localObject = C(paramE);
    if (paramE != null)
    {
      paramE = this.e;
      a9.f.c(localObject);
      paramE.d(this, (IOException)localObject);
      return localObject;
    }
    this.e.c(this);
    return localObject;
  }
  
  private final void e()
  {
    this.h = u9.h.a.g().h("response.body().close()");
    this.e.e(this);
  }
  
  private final l9.a j(x paramx)
  {
    Object localObject2;
    Object localObject1;
    l9.g localg;
    Object localObject3;
    if (paramx.j())
    {
      localObject2 = this.a.I();
      localObject1 = this.a.w();
      localg = this.a.j();
      localObject3 = localg;
    }
    else
    {
      localg = null;
      localObject1 = localg;
      localObject3 = localObject1;
      localObject2 = localg;
    }
    return new l9.a(paramx.i(), paramx.n(), this.a.p(), this.a.H(), (SSLSocketFactory)localObject2, (HostnameVerifier)localObject1, (l9.g)localObject3, this.a.D(), this.a.C(), this.a.A(), this.a.m(), this.a.E());
  }
  
  public final void A()
  {
    if ((this.k ^ true))
    {
      this.k = true;
      this.f.u();
      return;
    }
    throw new IllegalStateException("Check failed.".toString());
  }
  
  public final void c(i parami)
  {
    a9.f.f(parami, "connection");
    if ((m9.o.e) && (!Thread.holdsLock(parami)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Thread ");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(" MUST hold lock on ");
      localStringBuilder.append(parami);
      throw new AssertionError(localStringBuilder.toString());
    }
    int i1;
    if (this.j == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      this.j = parami;
      parami.i().add(new b(this, this.h));
      return;
    }
    throw new IllegalStateException("Check failed.".toString());
  }
  
  public void cancel()
  {
    if (this.p) {
      return;
    }
    this.p = true;
    Object localObject = this.q;
    if (localObject != null) {
      ((c)localObject).b();
    }
    localObject = this.r.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((n.c)((Iterator)localObject).next()).cancel();
    }
    this.e.f(this);
  }
  
  public void d0(l9.f paramf)
  {
    a9.f.f(paramf, "responseCallback");
    if (this.g.compareAndSet(false, true))
    {
      e();
      this.a.o().b(new a(paramf));
      return;
    }
    throw new IllegalStateException("Already Executed".toString());
  }
  
  public e f()
  {
    return new h(this.a, this.b, this.c);
  }
  
  public f0 g()
  {
    if (this.g.compareAndSet(false, true))
    {
      this.f.t();
      e();
      try
      {
        this.a.o().c(this);
        f0 localf0 = t();
        return localf0;
      }
      finally
      {
        this.a.o().h(this);
      }
    }
    throw new IllegalStateException("Already Executed".toString());
  }
  
  public d0 h()
  {
    return this.b;
  }
  
  public boolean i()
  {
    return this.p;
  }
  
  public final void k(d0 paramd0, boolean paramBoolean, r9.g paramg)
  {
    a9.f.f(paramd0, "request");
    a9.f.f(paramg, "chain");
    int i1;
    if (this.l == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      try
      {
        if ((this.n ^ true))
        {
          if ((this.m ^ true))
          {
            o8.o localo = o8.o.a;
            if (paramBoolean)
            {
              paramd0 = new k(this.a, j(paramd0.j()), this, paramg);
              if (this.a.r()) {
                paramd0 = new f(paramd0, this.a.v());
              } else {
                paramd0 = new p(paramd0);
              }
              this.i = paramd0;
            }
            return;
          }
          throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
      }
      finally {}
    }
    throw new IllegalStateException("Check failed.".toString());
  }
  
  public final void l(boolean paramBoolean)
  {
    try
    {
      if (this.o)
      {
        Object localObject1 = o8.o.a;
        if (paramBoolean)
        {
          localObject1 = this.q;
          if (localObject1 != null) {
            ((c)localObject1).d();
          }
        }
        this.l = null;
        return;
      }
      throw new IllegalStateException("released".toString());
    }
    finally {}
  }
  
  public final b0 m()
  {
    return this.a;
  }
  
  public final i n()
  {
    return this.j;
  }
  
  public final t o()
  {
    return this.e;
  }
  
  public final boolean p()
  {
    return this.c;
  }
  
  public final c q()
  {
    return this.l;
  }
  
  public final d0 r()
  {
    return this.b;
  }
  
  public final CopyOnWriteArrayList<n.c> s()
  {
    return this.r;
  }
  
  /* Error */
  public final f0 t()
  {
    // Byte code:
    //   0: new 450	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 451	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: getfield 61	q9/h:a	Ll9/b0;
    //   13: invokevirtual 453	l9/b0:x	()Ljava/util/List;
    //   16: invokestatic 458	p8/l:s	(Ljava/util/Collection;Ljava/lang/Iterable;)Z
    //   19: pop
    //   20: aload_3
    //   21: new 460	r9/j
    //   24: dup
    //   25: aload_0
    //   26: getfield 61	q9/h:a	Ll9/b0;
    //   29: invokespecial 463	r9/j:<init>	(Ll9/b0;)V
    //   32: invokeinterface 466 2 0
    //   37: pop
    //   38: aload_3
    //   39: new 468	r9/a
    //   42: dup
    //   43: aload_0
    //   44: getfield 61	q9/h:a	Ll9/b0;
    //   47: invokevirtual 471	l9/b0:n	()Ll9/p;
    //   50: invokespecial 474	r9/a:<init>	(Ll9/p;)V
    //   53: invokeinterface 466 2 0
    //   58: pop
    //   59: aload_0
    //   60: getfield 61	q9/h:a	Ll9/b0;
    //   63: invokevirtual 477	l9/b0:e	()Ll9/c;
    //   66: pop
    //   67: aload_3
    //   68: new 479	o9/a
    //   71: dup
    //   72: aconst_null
    //   73: invokespecial 482	o9/a:<init>	(Ll9/c;)V
    //   76: invokeinterface 466 2 0
    //   81: pop
    //   82: aload_3
    //   83: getstatic 487	q9/a:a	Lq9/a;
    //   86: invokeinterface 466 2 0
    //   91: pop
    //   92: aload_0
    //   93: getfield 65	q9/h:c	Z
    //   96: ifne +15 -> 111
    //   99: aload_3
    //   100: aload_0
    //   101: getfield 61	q9/h:a	Ll9/b0;
    //   104: invokevirtual 489	l9/b0:y	()Ljava/util/List;
    //   107: invokestatic 458	p8/l:s	(Ljava/util/Collection;Ljava/lang/Iterable;)Z
    //   110: pop
    //   111: aload_3
    //   112: new 491	r9/b
    //   115: dup
    //   116: aload_0
    //   117: getfield 65	q9/h:c	Z
    //   120: invokespecial 493	r9/b:<init>	(Z)V
    //   123: invokeinterface 466 2 0
    //   128: pop
    //   129: new 495	r9/g
    //   132: dup
    //   133: aload_0
    //   134: aload_3
    //   135: iconst_0
    //   136: aconst_null
    //   137: aload_0
    //   138: getfield 63	q9/h:b	Ll9/d0;
    //   141: aload_0
    //   142: getfield 61	q9/h:a	Ll9/b0;
    //   145: invokevirtual 497	l9/b0:k	()I
    //   148: aload_0
    //   149: getfield 61	q9/h:a	Ll9/b0;
    //   152: invokevirtual 500	l9/b0:F	()I
    //   155: aload_0
    //   156: getfield 61	q9/h:a	Ll9/b0;
    //   159: invokevirtual 503	l9/b0:K	()I
    //   162: invokespecial 506	r9/g:<init>	(Lq9/h;Ljava/util/List;ILq9/c;Ll9/d0;III)V
    //   165: astore_3
    //   166: iconst_0
    //   167: istore_1
    //   168: aload_3
    //   169: aload_0
    //   170: getfield 63	q9/h:b	Ll9/d0;
    //   173: invokevirtual 509	r9/g:a	(Ll9/d0;)Ll9/f0;
    //   176: astore_3
    //   177: aload_0
    //   178: invokevirtual 152	q9/h:i	()Z
    //   181: istore_2
    //   182: iload_2
    //   183: ifne +11 -> 194
    //   186: aload_0
    //   187: aconst_null
    //   188: invokevirtual 511	q9/h:w	(Ljava/io/IOException;)Ljava/io/IOException;
    //   191: pop
    //   192: aload_3
    //   193: areturn
    //   194: aload_3
    //   195: invokestatic 516	m9/l:f	(Ljava/io/Closeable;)V
    //   198: new 448	java/io/IOException
    //   201: dup
    //   202: ldc_w 518
    //   205: invokespecial 519	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   208: athrow
    //   209: astore_3
    //   210: goto +30 -> 240
    //   213: astore_3
    //   214: aload_0
    //   215: aload_3
    //   216: invokevirtual 511	q9/h:w	(Ljava/io/IOException;)Ljava/io/IOException;
    //   219: astore_3
    //   220: aload_3
    //   221: ifnonnull +14 -> 235
    //   224: new 521	java/lang/NullPointerException
    //   227: dup
    //   228: ldc_w 523
    //   231: invokespecial 524	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   234: athrow
    //   235: aload_3
    //   236: athrow
    //   237: astore_3
    //   238: iconst_1
    //   239: istore_1
    //   240: iload_1
    //   241: ifne +9 -> 250
    //   244: aload_0
    //   245: aconst_null
    //   246: invokevirtual 511	q9/h:w	(Ljava/io/IOException;)Ljava/io/IOException;
    //   249: pop
    //   250: aload_3
    //   251: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	h
    //   167	74	1	i1	int
    //   181	2	2	bool	boolean
    //   7	188	3	localObject1	Object
    //   209	1	3	localObject2	Object
    //   213	3	3	localIOException1	IOException
    //   219	17	3	localIOException2	IOException
    //   237	14	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   168	182	209	finally
    //   194	209	209	finally
    //   168	182	213	java/io/IOException
    //   194	209	213	java/io/IOException
    //   214	220	237	finally
    //   224	235	237	finally
    //   235	237	237	finally
  }
  
  public final c u(r9.g paramg)
  {
    a9.f.f(paramg, "chain");
    try
    {
      if (this.o)
      {
        if ((this.n ^ true))
        {
          if ((this.m ^ true))
          {
            Object localObject = o8.o.a;
            localObject = this.i;
            a9.f.c(localObject);
            paramg = ((d)localObject).a().r(this.a, paramg);
            paramg = new c(this, this.e, (d)localObject, paramg);
            this.l = paramg;
            this.q = paramg;
            try
            {
              this.m = true;
              this.n = true;
              if (!this.p) {
                return paramg;
              }
              throw new IOException("Canceled");
            }
            finally {}
          }
          throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
      }
      throw new IllegalStateException("released".toString());
    }
    finally {}
  }
  
  public final <E extends IOException> E v(c paramc, boolean paramBoolean1, boolean paramBoolean2, E paramE)
  {
    a9.f.f(paramc, "exchange");
    if (!a9.f.a(paramc, this.q)) {
      return paramE;
    }
    int i3 = 0;
    i1 = 0;
    if (paramBoolean1) {}
    try
    {
      if (!this.m) {
        if ((!paramBoolean2) || (!this.n)) {
          break label194;
        }
      }
      if (paramBoolean1) {
        this.m = false;
      }
      if (paramBoolean2) {
        this.n = false;
      }
      paramBoolean1 = this.m;
      if ((paramBoolean1) || (this.n)) {
        break label185;
      }
      i1 = 1;
    }
    finally
    {
      for (;;)
      {
        continue;
        i1 = 0;
        continue;
        continue;
        int i2 = 0;
      }
    }
    i2 = i3;
    if (!paramBoolean1)
    {
      i2 = i3;
      if (!this.n)
      {
        i2 = i3;
        if (!this.o)
        {
          i2 = 1;
          break label191;
          paramc = o8.o.a;
          if (i1 != 0)
          {
            this.q = null;
            paramc = this.j;
            if (paramc != null) {
              paramc.n();
            }
          }
          if (i2 != 0) {
            return d(paramE);
          }
          return paramE;
          throw paramc;
        }
      }
    }
  }
  
  public final IOException w(IOException paramIOException)
  {
    try
    {
      boolean bool = this.o;
      int i2 = 0;
      int i1 = i2;
      if (bool)
      {
        this.o = false;
        i1 = i2;
        if (!this.m)
        {
          i1 = i2;
          if (!this.n) {
            i1 = 1;
          }
        }
      }
      Object localObject = o8.o.a;
      localObject = paramIOException;
      if (i1 != 0) {
        localObject = d(paramIOException);
      }
      return localObject;
    }
    finally {}
  }
  
  public final String x()
  {
    return this.b.j().p();
  }
  
  public final Socket y()
  {
    i locali = this.j;
    a9.f.c(locali);
    if ((m9.o.e) && (!Thread.holdsLock(locali)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Thread ");
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      ((StringBuilder)localObject).append(" MUST hold lock on ");
      ((StringBuilder)localObject).append(locali);
      throw new AssertionError(((StringBuilder)localObject).toString());
    }
    Object localObject = locali.i();
    Iterator localIterator = ((List)localObject).iterator();
    int i2 = 0;
    int i1 = 0;
    while (localIterator.hasNext())
    {
      if (a9.f.a(((Reference)localIterator.next()).get(), this)) {
        break label144;
      }
      i1 += 1;
    }
    i1 = -1;
    label144:
    if (i1 != -1) {
      i2 = 1;
    }
    if (i2 != 0)
    {
      ((List)localObject).remove(i1);
      this.j = null;
      if (((List)localObject).isEmpty())
      {
        locali.v(System.nanoTime());
        if (this.d.c(locali)) {
          return locali.x();
        }
      }
      return null;
    }
    throw new IllegalStateException("Check failed.".toString());
  }
  
  public final boolean z()
  {
    Object localObject = this.q;
    boolean bool2 = false;
    if (localObject == null) {}
    while (((c)localObject).k() != true)
    {
      i1 = 0;
      break;
    }
    int i1 = 1;
    boolean bool1 = bool2;
    if (i1 != 0)
    {
      localObject = this.i;
      a9.f.c(localObject);
      n localn = ((d)localObject).b();
      localObject = this.q;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((c)localObject).h();
      }
      bool1 = bool2;
      if (localn.a((i)localObject)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final class a
    implements Runnable
  {
    private final l9.f a;
    private volatile AtomicInteger b;
    
    public a()
    {
      this.a = localObject;
      this.b = new AtomicInteger(0);
    }
    
    /* Error */
    public final void a(java.util.concurrent.ExecutorService paramExecutorService)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc 48
      //   3: invokestatic 24	a9/f:f	(Ljava/lang/Object;Ljava/lang/String;)V
      //   6: aload_0
      //   7: getfield 28	q9/h$a:c	Lq9/h;
      //   10: invokevirtual 52	q9/h:m	()Ll9/b0;
      //   13: invokevirtual 58	l9/b0:o	()Ll9/r;
      //   16: astore_2
      //   17: getstatic 64	m9/o:e	Z
      //   20: ifeq +64 -> 84
      //   23: aload_2
      //   24: invokestatic 70	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
      //   27: ifne +6 -> 33
      //   30: goto +54 -> 84
      //   33: new 72	java/lang/StringBuilder
      //   36: dup
      //   37: invokespecial 73	java/lang/StringBuilder:<init>	()V
      //   40: astore_1
      //   41: aload_1
      //   42: ldc 75
      //   44: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: pop
      //   48: aload_1
      //   49: invokestatic 83	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   52: invokevirtual 87	java/lang/Thread:getName	()Ljava/lang/String;
      //   55: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   58: pop
      //   59: aload_1
      //   60: ldc 92
      //   62: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   65: pop
      //   66: aload_1
      //   67: aload_2
      //   68: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   71: pop
      //   72: new 94	java/lang/AssertionError
      //   75: dup
      //   76: aload_1
      //   77: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   80: invokespecial 100	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
      //   83: athrow
      //   84: aload_1
      //   85: aload_0
      //   86: invokeinterface 106 2 0
      //   91: return
      //   92: astore_1
      //   93: goto +58 -> 151
      //   96: astore_1
      //   97: new 108	java/io/InterruptedIOException
      //   100: dup
      //   101: ldc 110
      //   103: invokespecial 113	java/io/InterruptedIOException:<init>	(Ljava/lang/String;)V
      //   106: astore_2
      //   107: aload_2
      //   108: aload_1
      //   109: invokevirtual 117	java/io/InterruptedIOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
      //   112: pop
      //   113: aload_0
      //   114: getfield 28	q9/h$a:c	Lq9/h;
      //   117: aload_2
      //   118: invokevirtual 121	q9/h:w	(Ljava/io/IOException;)Ljava/io/IOException;
      //   121: pop
      //   122: aload_0
      //   123: getfield 33	q9/h$a:a	Ll9/f;
      //   126: aload_0
      //   127: getfield 28	q9/h$a:c	Lq9/h;
      //   130: aload_2
      //   131: invokeinterface 127 3 0
      //   136: aload_0
      //   137: getfield 28	q9/h$a:c	Lq9/h;
      //   140: invokevirtual 52	q9/h:m	()Ll9/b0;
      //   143: invokevirtual 58	l9/b0:o	()Ll9/r;
      //   146: aload_0
      //   147: invokevirtual 133	l9/r:g	(Lq9/h$a;)V
      //   150: return
      //   151: aload_0
      //   152: getfield 28	q9/h$a:c	Lq9/h;
      //   155: invokevirtual 52	q9/h:m	()Ll9/b0;
      //   158: invokevirtual 58	l9/b0:o	()Ll9/r;
      //   161: aload_0
      //   162: invokevirtual 133	l9/r:g	(Lq9/h$a;)V
      //   165: aload_1
      //   166: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	167	0	this	a
      //   0	167	1	paramExecutorService	java.util.concurrent.ExecutorService
      //   16	115	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   84	91	92	finally
      //   97	136	92	finally
      //   84	91	96	java/util/concurrent/RejectedExecutionException
    }
    
    public final h b()
    {
      return h.this;
    }
    
    public final AtomicInteger c()
    {
      return this.b;
    }
    
    public final String d()
    {
      return h.this.r().j().i();
    }
    
    public final void e(a parama)
    {
      a9.f.f(parama, "other");
      this.b = parama.b;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: ldc 157
      //   2: aload_0
      //   3: getfield 28	q9/h$a:c	Lq9/h;
      //   6: invokevirtual 160	q9/h:x	()Ljava/lang/String;
      //   9: invokestatic 163	a9/f:m	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   12: astore_3
      //   13: aload_0
      //   14: getfield 28	q9/h$a:c	Lq9/h;
      //   17: astore 6
      //   19: invokestatic 83	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   22: astore 4
      //   24: aload 4
      //   26: invokevirtual 87	java/lang/Thread:getName	()Ljava/lang/String;
      //   29: astore 5
      //   31: aload 4
      //   33: aload_3
      //   34: invokevirtual 166	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   37: aload 6
      //   39: invokestatic 169	q9/h:a	(Lq9/h;)Lq9/h$c;
      //   42: invokevirtual 174	aa/a:t	()V
      //   45: aload 6
      //   47: invokevirtual 177	q9/h:t	()Ll9/f0;
      //   50: astore_3
      //   51: iconst_1
      //   52: istore_2
      //   53: iconst_1
      //   54: istore_1
      //   55: aload_0
      //   56: getfield 33	q9/h$a:a	Ll9/f;
      //   59: aload 6
      //   61: aload_3
      //   62: invokeinterface 180 3 0
      //   67: aload 6
      //   69: invokevirtual 52	q9/h:m	()Ll9/b0;
      //   72: invokevirtual 58	l9/b0:o	()Ll9/r;
      //   75: astore_3
      //   76: aload_3
      //   77: aload_0
      //   78: invokevirtual 133	l9/r:g	(Lq9/h$a;)V
      //   81: goto +113 -> 194
      //   84: astore_3
      //   85: goto +12 -> 97
      //   88: astore_3
      //   89: iload_2
      //   90: istore_1
      //   91: goto +51 -> 142
      //   94: astore_3
      //   95: iconst_0
      //   96: istore_1
      //   97: aload 6
      //   99: invokevirtual 183	q9/h:cancel	()V
      //   102: iload_1
      //   103: ifne +37 -> 140
      //   106: new 155	java/io/IOException
      //   109: dup
      //   110: ldc 185
      //   112: aload_3
      //   113: invokestatic 163	a9/f:m	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   116: invokespecial 186	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   119: astore 7
      //   121: aload 7
      //   123: aload_3
      //   124: invokestatic 191	o8/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
      //   127: aload_0
      //   128: getfield 33	q9/h$a:a	Ll9/f;
      //   131: aload 6
      //   133: aload 7
      //   135: invokeinterface 127 3 0
      //   140: aload_3
      //   141: athrow
      //   142: iload_1
      //   143: ifeq +27 -> 170
      //   146: getstatic 196	u9/h:a	Lu9/h$a;
      //   149: invokevirtual 201	u9/h$a:g	()Lu9/h;
      //   152: ldc 203
      //   154: aload 6
      //   156: invokestatic 206	q9/h:b	(Lq9/h;)Ljava/lang/String;
      //   159: invokestatic 163	a9/f:m	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   162: iconst_4
      //   163: aload_3
      //   164: invokevirtual 209	u9/h:j	(Ljava/lang/String;ILjava/lang/Throwable;)V
      //   167: goto +15 -> 182
      //   170: aload_0
      //   171: getfield 33	q9/h$a:a	Ll9/f;
      //   174: aload 6
      //   176: aload_3
      //   177: invokeinterface 127 3 0
      //   182: aload 6
      //   184: invokevirtual 52	q9/h:m	()Ll9/b0;
      //   187: invokevirtual 58	l9/b0:o	()Ll9/r;
      //   190: astore_3
      //   191: goto -115 -> 76
      //   194: aload 4
      //   196: aload 5
      //   198: invokevirtual 166	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   201: return
      //   202: aload 6
      //   204: invokevirtual 52	q9/h:m	()Ll9/b0;
      //   207: invokevirtual 58	l9/b0:o	()Ll9/r;
      //   210: aload_0
      //   211: invokevirtual 133	l9/r:g	(Lq9/h$a;)V
      //   214: aload_3
      //   215: athrow
      //   216: astore_3
      //   217: aload 4
      //   219: aload 5
      //   221: invokevirtual 166	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   224: aload_3
      //   225: athrow
      //   226: astore_3
      //   227: goto -25 -> 202
      //   230: astore_3
      //   231: iconst_0
      //   232: istore_1
      //   233: goto -91 -> 142
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	236	0	this	a
      //   54	179	1	i	int
      //   52	38	2	j	int
      //   12	65	3	localObject1	Object
      //   84	1	3	localObject2	Object
      //   88	1	3	localIOException1	IOException
      //   94	83	3	localObject3	Object
      //   190	25	3	localr	r
      //   216	9	3	localObject4	Object
      //   226	1	3	localObject5	Object
      //   230	1	3	localIOException2	IOException
      //   22	196	4	localThread	Thread
      //   29	191	5	str	String
      //   17	186	6	localh	h
      //   119	15	7	localIOException3	IOException
      // Exception table:
      //   from	to	target	type
      //   55	67	84	finally
      //   55	67	88	java/io/IOException
      //   45	51	94	finally
      //   37	45	216	finally
      //   67	76	216	finally
      //   76	81	216	finally
      //   182	191	216	finally
      //   202	216	216	finally
      //   97	102	226	finally
      //   106	140	226	finally
      //   140	142	226	finally
      //   146	167	226	finally
      //   170	182	226	finally
      //   45	51	230	java/io/IOException
    }
  }
  
  public static final class b
    extends WeakReference<h>
  {
    private final Object a;
    
    public b(h paramh, Object paramObject)
    {
      super();
      this.a = paramObject;
    }
    
    public final Object a()
    {
      return this.a;
    }
  }
  
  public static final class c
    extends aa.a
  {
    c(h paramh) {}
    
    protected void z()
    {
      this.m.cancel();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.h
 * JD-Core Version:    0.7.0.1
 */