package d2;

import android.os.Build.VERSION;
import android.util.Log;
import b2.k;
import b2.l;
import com.bumptech.glide.i;
import com.bumptech.glide.i.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k2.m;
import y2.a.f;
import y2.b;

class h<R>
  implements f.a, Runnable, Comparable<h<?>>, a.f
{
  private b2.a A;
  private com.bumptech.glide.load.data.d<?> B;
  private volatile f C;
  private volatile boolean E;
  private volatile boolean F;
  private boolean G;
  private final g<R> a = new g();
  private final List<Throwable> b = new ArrayList();
  private final y2.c c = y2.c.a();
  private final e d;
  private final x0.e<h<?>> e;
  private final d<?> f = new d();
  private final f g = new f();
  private com.bumptech.glide.e h;
  private b2.f i;
  private com.bumptech.glide.h j;
  private n k;
  private int l;
  private int m;
  private j n;
  private b2.h o;
  private b<R> p;
  private int q;
  private h r;
  private g s;
  private long t;
  private boolean u;
  private Object v;
  private Thread w;
  private b2.f x;
  private b2.f y;
  private Object z;
  
  h(e parame, x0.e<h<?>> parame1)
  {
    this.d = parame;
    this.e = parame1;
  }
  
  private void A()
  {
    int i1 = a.a[this.s.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 == 3)
        {
          i();
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unrecognized run reason: ");
        localStringBuilder.append(this.s);
        throw new IllegalStateException(localStringBuilder.toString());
      }
    }
    else
    {
      this.r = k(h.a);
      this.C = j();
    }
    y();
  }
  
  private void B()
  {
    this.c.c();
    if (this.E)
    {
      Object localObject;
      if (this.b.isEmpty())
      {
        localObject = null;
      }
      else
      {
        localObject = this.b;
        localObject = (Throwable)((List)localObject).get(((List)localObject).size() - 1);
      }
      throw new IllegalStateException("Already notified", (Throwable)localObject);
    }
    this.E = true;
  }
  
  private <Data> v<R> g(com.bumptech.glide.load.data.d<?> paramd, Data paramData, b2.a parama)
  {
    if (paramData == null)
    {
      paramd.b();
      return null;
    }
    try
    {
      long l1 = x2.g.b();
      paramData = h(paramData, parama);
      if (Log.isLoggable("DecodeJob", 2))
      {
        parama = new StringBuilder();
        parama.append("Decoded result ");
        parama.append(paramData);
        o(parama.toString(), l1);
      }
      return paramData;
    }
    finally
    {
      paramd.b();
    }
  }
  
  private <Data> v<R> h(Data paramData, b2.a parama)
  {
    return z(paramData, parama, this.a.h(paramData.getClass()));
  }
  
  private void i()
  {
    if (Log.isLoggable("DecodeJob", 2))
    {
      long l1 = this.t;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("data: ");
      ((StringBuilder)localObject).append(this.z);
      ((StringBuilder)localObject).append(", cache key: ");
      ((StringBuilder)localObject).append(this.x);
      ((StringBuilder)localObject).append(", fetcher: ");
      ((StringBuilder)localObject).append(this.B);
      p("Retrieved data", l1, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    try
    {
      v localv = g(this.B, this.z, this.A);
      localObject = localv;
    }
    catch (q localq)
    {
      localq.i(this.y, this.A);
      this.b.add(localq);
    }
    if (localObject != null)
    {
      r((v)localObject, this.A, this.G);
      return;
    }
    y();
  }
  
  private f j()
  {
    int i1 = a.b[this.r.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 == 4) {
            return null;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unrecognized stage: ");
          localStringBuilder.append(this.r);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        return new z(this.a, this);
      }
      return new c(this.a, this);
    }
    return new w(this.a, this);
  }
  
  private h k(h paramh)
  {
    int i1 = a.b[paramh.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if ((i1 != 3) && (i1 != 4))
        {
          if (i1 == 5)
          {
            if (this.n.b()) {
              return h.b;
            }
            return k(h.b);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unrecognized stage: ");
          localStringBuilder.append(paramh);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        return h.f;
      }
      if (this.u) {
        return h.f;
      }
      return h.d;
    }
    if (this.n.a()) {
      return h.c;
    }
    return k(h.c);
  }
  
  private b2.h l(b2.a parama)
  {
    b2.h localh = this.o;
    if (Build.VERSION.SDK_INT < 26) {
      return localh;
    }
    boolean bool;
    if ((parama != b2.a.d) && (!this.a.x())) {
      bool = false;
    } else {
      bool = true;
    }
    parama = m.j;
    Boolean localBoolean = (Boolean)localh.c(parama);
    if ((localBoolean != null) && ((!localBoolean.booleanValue()) || (bool))) {
      return localh;
    }
    localh = new b2.h();
    localh.d(this.o);
    localh.e(parama, Boolean.valueOf(bool));
    return localh;
  }
  
  private int m()
  {
    return this.j.ordinal();
  }
  
  private void o(String paramString, long paramLong)
  {
    p(paramString, paramLong, null);
  }
  
  private void p(String paramString1, long paramLong, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" in ");
    localStringBuilder.append(x2.g.a(paramLong));
    localStringBuilder.append(", load key: ");
    localStringBuilder.append(this.k);
    if (paramString2 != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(", ");
      paramString1.append(paramString2);
      paramString1 = paramString1.toString();
    }
    else
    {
      paramString1 = "";
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", thread: ");
    localStringBuilder.append(Thread.currentThread().getName());
    Log.v("DecodeJob", localStringBuilder.toString());
  }
  
  private void q(v<R> paramv, b2.a parama, boolean paramBoolean)
  {
    B();
    this.p.a(paramv, parama, paramBoolean);
  }
  
  /* Error */
  private void r(v<R> paramv, b2.a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 392
    //   3: invokestatic 396	y2/b:a	(Ljava/lang/String;)V
    //   6: aload_1
    //   7: instanceof 398
    //   10: ifeq +12 -> 22
    //   13: aload_1
    //   14: checkcast 398	d2/r
    //   17: invokeinterface 399 1 0
    //   22: aconst_null
    //   23: astore 4
    //   25: aload_1
    //   26: astore 5
    //   28: aload_0
    //   29: getfield 116	d2/h:f	Ld2/h$d;
    //   32: invokevirtual 401	d2/h$d:c	()Z
    //   35: ifeq +13 -> 48
    //   38: aload_1
    //   39: invokestatic 406	d2/u:f	(Ld2/v;)Ld2/u;
    //   42: astore 5
    //   44: aload 5
    //   46: astore 4
    //   48: aload_0
    //   49: aload 5
    //   51: aload_2
    //   52: iload_3
    //   53: invokespecial 408	d2/h:q	(Ld2/v;Lb2/a;Z)V
    //   56: aload_0
    //   57: getstatic 410	d2/h$h:e	Ld2/h$h;
    //   60: putfield 167	d2/h:r	Ld2/h$h;
    //   63: aload_0
    //   64: getfield 116	d2/h:f	Ld2/h$d;
    //   67: invokevirtual 401	d2/h$d:c	()Z
    //   70: ifeq +18 -> 88
    //   73: aload_0
    //   74: getfield 116	d2/h:f	Ld2/h$d;
    //   77: aload_0
    //   78: getfield 121	d2/h:d	Ld2/h$e;
    //   81: aload_0
    //   82: getfield 314	d2/h:o	Lb2/h;
    //   85: invokevirtual 413	d2/h$d:b	(Ld2/h$e;Lb2/h;)V
    //   88: aload 4
    //   90: ifnull +8 -> 98
    //   93: aload 4
    //   95: invokevirtual 415	d2/u:h	()V
    //   98: aload_0
    //   99: invokespecial 417	d2/h:t	()V
    //   102: invokestatic 419	y2/b:e	()V
    //   105: return
    //   106: astore_1
    //   107: aload 4
    //   109: ifnull +8 -> 117
    //   112: aload 4
    //   114: invokevirtual 415	d2/u:h	()V
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: invokestatic 419	y2/b:e	()V
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	h
    //   0	125	1	paramv	v<R>
    //   0	125	2	parama	b2.a
    //   0	125	3	paramBoolean	boolean
    //   23	90	4	localObject1	Object
    //   26	24	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   63	88	106	finally
    //   6	22	119	finally
    //   28	44	119	finally
    //   48	63	119	finally
    //   93	98	119	finally
    //   98	102	119	finally
    //   112	117	119	finally
    //   117	119	119	finally
  }
  
  private void s()
  {
    B();
    q localq = new q("Failed to load resource", new ArrayList(this.b));
    this.p.c(localq);
    u();
  }
  
  private void t()
  {
    if (this.g.b()) {
      x();
    }
  }
  
  private void u()
  {
    if (this.g.c()) {
      x();
    }
  }
  
  private void x()
  {
    this.g.e();
    this.f.a();
    this.a.a();
    this.E = false;
    this.h = null;
    this.i = null;
    this.o = null;
    this.j = null;
    this.k = null;
    this.p = null;
    this.r = null;
    this.C = null;
    this.w = null;
    this.x = null;
    this.z = null;
    this.A = null;
    this.B = null;
    this.t = 0L;
    this.F = false;
    this.v = null;
    this.b.clear();
    this.e.a(this);
  }
  
  private void y()
  {
    this.w = Thread.currentThread();
    this.t = x2.g.b();
    boolean bool1 = false;
    boolean bool2;
    do
    {
      bool2 = bool1;
      if (this.F) {
        break;
      }
      bool2 = bool1;
      if (this.C == null) {
        break;
      }
      bool1 = this.C.e();
      bool2 = bool1;
      if (bool1) {
        break;
      }
      this.r = k(this.r);
      this.C = j();
    } while (this.r != h.d);
    a();
    return;
    if (((this.r == h.f) || (this.F)) && (!bool2)) {
      s();
    }
  }
  
  private <Data, ResourceType> v<R> z(Data paramData, b2.a parama, t<Data, ResourceType, R> paramt)
  {
    b2.h localh = l(parama);
    paramData = this.h.i().l(paramData);
    try
    {
      parama = paramt.a(paramData, localh, this.l, this.m, new c(parama));
      return parama;
    }
    finally
    {
      paramData.b();
    }
  }
  
  boolean C()
  {
    h localh = k(h.a);
    return (localh == h.b) || (localh == h.c);
  }
  
  public void a()
  {
    this.s = g.b;
    this.p.d(this);
  }
  
  public void b(b2.f paramf, Exception paramException, com.bumptech.glide.load.data.d<?> paramd, b2.a parama)
  {
    paramd.b();
    paramException = new q("Fetching data failed", paramException);
    paramException.j(paramf, parama, paramd.a());
    this.b.add(paramException);
    if (Thread.currentThread() != this.w)
    {
      this.s = g.b;
      this.p.d(this);
      return;
    }
    y();
  }
  
  public void c(b2.f paramf1, Object paramObject, com.bumptech.glide.load.data.d<?> paramd, b2.a parama, b2.f paramf2)
  {
    this.x = paramf1;
    this.z = paramObject;
    this.B = paramd;
    this.A = parama;
    this.y = paramf2;
    paramObject = this.a.c();
    boolean bool = false;
    if (paramf1 != paramObject.get(0)) {
      bool = true;
    }
    this.G = bool;
    if (Thread.currentThread() != this.w)
    {
      this.s = g.c;
      this.p.d(this);
      return;
    }
    b.a("DecodeJob.decodeFromRetrievedData");
    try
    {
      i();
      return;
    }
    finally
    {
      b.e();
    }
  }
  
  public void d()
  {
    this.F = true;
    f localf = this.C;
    if (localf != null) {
      localf.cancel();
    }
  }
  
  public y2.c e()
  {
    return this.c;
  }
  
  public int f(h<?> paramh)
  {
    int i2 = m() - paramh.m();
    int i1 = i2;
    if (i2 == 0) {
      i1 = this.q - paramh.q;
    }
    return i1;
  }
  
  h<R> n(com.bumptech.glide.e parame, Object paramObject, n paramn, b2.f paramf, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, com.bumptech.glide.h paramh, j paramj, Map<Class<?>, l<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b2.h paramh1, b<R> paramb, int paramInt3)
  {
    this.a.v(parame, paramObject, paramf, paramInt1, paramInt2, paramj, paramClass, paramClass1, paramh, paramh1, paramMap, paramBoolean1, paramBoolean2, this.d);
    this.h = parame;
    this.i = paramf;
    this.j = paramh;
    this.k = paramn;
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramj;
    this.u = paramBoolean3;
    this.o = paramh1;
    this.p = paramb;
    this.q = paramInt3;
    this.s = g.a;
    this.v = paramObject;
    return this;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc_w 541
    //   3: aload_0
    //   4: getfield 131	d2/h:s	Ld2/h$g;
    //   7: aload_0
    //   8: getfield 450	d2/h:v	Ljava/lang/Object;
    //   11: invokestatic 544	y2/b:c	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield 252	d2/h:B	Lcom/bumptech/glide/load/data/d;
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 448	d2/h:F	Z
    //   23: ifeq +21 -> 44
    //   26: aload_0
    //   27: invokespecial 464	d2/h:s	()V
    //   30: aload_1
    //   31: ifnull +9 -> 40
    //   34: aload_1
    //   35: invokeinterface 203 1 0
    //   40: invokestatic 419	y2/b:e	()V
    //   43: return
    //   44: aload_0
    //   45: invokespecial 546	d2/h:A	()V
    //   48: aload_1
    //   49: ifnull +9 -> 58
    //   52: aload_1
    //   53: invokeinterface 203 1 0
    //   58: invokestatic 419	y2/b:e	()V
    //   61: return
    //   62: astore_2
    //   63: ldc 213
    //   65: iconst_3
    //   66: invokestatic 219	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   69: ifeq +56 -> 125
    //   72: new 141	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   79: astore_3
    //   80: aload_3
    //   81: ldc_w 548
    //   84: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_3
    //   89: aload_0
    //   90: getfield 448	d2/h:F	Z
    //   93: invokevirtual 551	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_3
    //   98: ldc_w 553
    //   101: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_3
    //   106: aload_0
    //   107: getfield 167	d2/h:r	Ld2/h$h;
    //   110: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: ldc 213
    //   116: aload_3
    //   117: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: aload_2
    //   121: invokestatic 556	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   124: pop
    //   125: aload_0
    //   126: getfield 167	d2/h:r	Ld2/h$h;
    //   129: getstatic 410	d2/h$h:e	Ld2/h$h;
    //   132: if_acmpeq +18 -> 150
    //   135: aload_0
    //   136: getfield 106	d2/h:b	Ljava/util/List;
    //   139: aload_2
    //   140: invokeinterface 270 2 0
    //   145: pop
    //   146: aload_0
    //   147: invokespecial 464	d2/h:s	()V
    //   150: aload_0
    //   151: getfield 448	d2/h:F	Z
    //   154: ifne +5 -> 159
    //   157: aload_2
    //   158: athrow
    //   159: aload_2
    //   160: athrow
    //   161: astore_2
    //   162: aload_2
    //   163: athrow
    //   164: astore_2
    //   165: aload_1
    //   166: ifnull +9 -> 175
    //   169: aload_1
    //   170: invokeinterface 203 1 0
    //   175: invokestatic 419	y2/b:e	()V
    //   178: aload_2
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	h
    //   18	152	1	locald	com.bumptech.glide.load.data.d
    //   62	98	2	localThrowable	Throwable
    //   161	2	2	localb	b
    //   164	15	2	localObject	Object
    //   79	38	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	30	62	finally
    //   44	48	62	finally
    //   19	30	161	d2/b
    //   44	48	161	d2/b
    //   63	125	164	finally
    //   125	150	164	finally
    //   150	159	164	finally
    //   159	161	164	finally
    //   162	164	164	finally
  }
  
  <Z> v<Z> v(b2.a parama, v<Z> paramv)
  {
    Class localClass = paramv.get().getClass();
    Object localObject1 = b2.a.d;
    Object localObject2 = null;
    l locall;
    if (parama != localObject1)
    {
      locall = this.a.s(localClass);
      localObject1 = locall.a(this.h, paramv, this.l, this.m);
    }
    else
    {
      localObject1 = paramv;
      locall = null;
    }
    if (!paramv.equals(localObject1)) {
      paramv.a();
    }
    b2.c localc;
    if (this.a.w((v)localObject1))
    {
      paramv = this.a.n((v)localObject1);
      localc = paramv.b(this.o);
    }
    else
    {
      localc = b2.c.c;
      paramv = localObject2;
    }
    boolean bool = this.a.y(this.x);
    if (this.n.d(bool ^ true, parama, localc))
    {
      if (paramv != null)
      {
        int i1 = a.c[localc.ordinal()];
        if (i1 != 1)
        {
          if (i1 == 2)
          {
            parama = new x(this.a.b(), this.x, this.i, this.l, this.m, locall, localClass, this.o);
          }
          else
          {
            parama = new StringBuilder();
            parama.append("Unknown strategy: ");
            parama.append(localc);
            throw new IllegalArgumentException(parama.toString());
          }
        }
        else {
          parama = new d(this.x, this.i);
        }
        localObject1 = u.f((v)localObject1);
        this.f.d(parama, paramv, (u)localObject1);
        return localObject1;
      }
      throw new i.d(((v)localObject1).get().getClass());
    }
    return localObject1;
  }
  
  void w(boolean paramBoolean)
  {
    if (this.g.d(paramBoolean)) {
      x();
    }
  }
  
  static abstract interface b<R>
  {
    public abstract void a(v<R> paramv, b2.a parama, boolean paramBoolean);
    
    public abstract void c(q paramq);
    
    public abstract void d(h<?> paramh);
  }
  
  private final class c<Z>
    implements i.a<Z>
  {
    private final b2.a a;
    
    c(b2.a parama)
    {
      this.a = parama;
    }
    
    public v<Z> a(v<Z> paramv)
    {
      return h.this.v(this.a, paramv);
    }
  }
  
  private static class d<Z>
  {
    private b2.f a;
    private k<Z> b;
    private u<Z> c;
    
    void a()
    {
      this.a = null;
      this.b = null;
      this.c = null;
    }
    
    void b(h.e parame, b2.h paramh)
    {
      b.a("DecodeJob.encode");
      try
      {
        parame.a().a(this.a, new e(this.b, this.c, paramh));
        return;
      }
      finally
      {
        this.c.h();
        b.e();
      }
    }
    
    boolean c()
    {
      return this.c != null;
    }
    
    <X> void d(b2.f paramf, k<X> paramk, u<X> paramu)
    {
      this.a = paramf;
      this.b = paramk;
      this.c = paramu;
    }
  }
  
  static abstract interface e
  {
    public abstract f2.a a();
  }
  
  private static class f
  {
    private boolean a;
    private boolean b;
    private boolean c;
    
    private boolean a(boolean paramBoolean)
    {
      return ((this.c) || (paramBoolean) || (this.b)) && (this.a);
    }
    
    boolean b()
    {
      try
      {
        this.b = true;
        boolean bool = a(false);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    boolean c()
    {
      try
      {
        this.c = true;
        boolean bool = a(false);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    boolean d(boolean paramBoolean)
    {
      try
      {
        this.a = true;
        paramBoolean = a(paramBoolean);
        return paramBoolean;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    void e()
    {
      try
      {
        this.b = false;
        this.a = false;
        this.c = false;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  private static enum g
  {
    static
    {
      g localg1 = new g("INITIALIZE", 0);
      a = localg1;
      g localg2 = new g("SWITCH_TO_SOURCE_SERVICE", 1);
      b = localg2;
      g localg3 = new g("DECODE_DATA", 2);
      c = localg3;
      d = new g[] { localg1, localg2, localg3 };
    }
    
    private g() {}
  }
  
  private static enum h
  {
    static
    {
      h localh1 = new h("INITIALIZE", 0);
      a = localh1;
      h localh2 = new h("RESOURCE_CACHE", 1);
      b = localh2;
      h localh3 = new h("DATA_CACHE", 2);
      c = localh3;
      h localh4 = new h("SOURCE", 3);
      d = localh4;
      h localh5 = new h("ENCODE", 4);
      e = localh5;
      h localh6 = new h("FINISHED", 5);
      f = localh6;
      g = new h[] { localh1, localh2, localh3, localh4, localh5, localh6 };
    }
    
    private h() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.h
 * JD-Core Version:    0.7.0.1
 */