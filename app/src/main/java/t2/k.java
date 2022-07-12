package t2;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.d.d;
import d2.k.d;
import d2.q;
import d2.v;
import d2.v<*>;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import x2.l;

public final class k<R>
  implements e, u2.g, j
{
  private static final boolean E = Log.isLoggable("GlideRequest", 2);
  private int A;
  private int B;
  private boolean C;
  private RuntimeException D;
  private int a;
  private final String b;
  private final y2.c c;
  private final Object d;
  private final h<R> e;
  private final f f;
  private final Context g;
  private final com.bumptech.glide.e h;
  private final Object i;
  private final Class<R> j;
  private final a<?> k;
  private final int l;
  private final int m;
  private final com.bumptech.glide.h n;
  private final u2.h<R> o;
  private final List<h<R>> p;
  private final v2.c<? super R> q;
  private final Executor r;
  private v<R> s;
  private k.d t;
  private long u;
  private volatile d2.k v;
  private a w;
  private Drawable x;
  private Drawable y;
  private Drawable z;
  
  private k(Context paramContext, com.bumptech.glide.e parame, Object paramObject1, Object paramObject2, Class<R> paramClass, a<?> parama, int paramInt1, int paramInt2, com.bumptech.glide.h paramh, u2.h<R> paramh1, h<R> paramh2, List<h<R>> paramList, f paramf, d2.k paramk, v2.c<? super R> paramc, Executor paramExecutor)
  {
    String str;
    if (E) {
      str = String.valueOf(super.hashCode());
    } else {
      str = null;
    }
    this.b = str;
    this.c = y2.c.a();
    this.d = paramObject1;
    this.g = paramContext;
    this.h = parame;
    this.i = paramObject2;
    this.j = paramClass;
    this.k = parama;
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramh;
    this.o = paramh1;
    this.e = paramh2;
    this.p = paramList;
    this.f = paramf;
    this.v = paramk;
    this.q = paramc;
    this.r = paramExecutor;
    this.w = a.a;
    if ((this.D == null) && (parame.g().a(d.d.class))) {
      this.D = new RuntimeException("Glide request origin trace");
    }
  }
  
  private void A(v<R> paramv, R paramR, b2.a parama, boolean paramBoolean)
  {
    paramBoolean = s();
    this.w = a.d;
    this.s = paramv;
    if (this.h.h() <= 3)
    {
      paramv = new StringBuilder();
      paramv.append("Finished loading ");
      paramv.append(paramR.getClass().getSimpleName());
      paramv.append(" from ");
      paramv.append(parama);
      paramv.append(" for ");
      paramv.append(this.i);
      paramv.append(" with size [");
      paramv.append(this.A);
      paramv.append("x");
      paramv.append(this.B);
      paramv.append("] in ");
      paramv.append(x2.g.a(this.u));
      paramv.append(" ms");
      Log.d("Glide", paramv.toString());
    }
    boolean bool3 = true;
    this.C = true;
    for (;;)
    {
      try
      {
        paramv = this.p;
        if (paramv != null)
        {
          paramv = paramv.iterator();
          bool1 = false;
          bool2 = bool1;
          if (paramv.hasNext())
          {
            bool1 |= ((h)paramv.next()).e(paramR, this.i, this.o, parama, paramBoolean);
            continue;
          }
          paramv = this.e;
          if ((paramv == null) || (!paramv.e(paramR, this.i, this.o, parama, paramBoolean))) {
            break label329;
          }
          bool1 = bool3;
          if (!(bool1 | bool2))
          {
            paramv = this.q.a(parama, paramBoolean);
            this.o.f(paramR, paramv);
          }
          this.C = false;
          x();
          y2.b.f("GlideRequest", this.a);
          return;
        }
      }
      finally
      {
        this.C = false;
      }
      boolean bool2 = false;
      continue;
      label329:
      boolean bool1 = false;
    }
  }
  
  private void B()
  {
    if (!l()) {
      return;
    }
    Object localObject2 = null;
    if (this.i == null) {
      localObject2 = q();
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = p();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = r();
    }
    this.o.c((Drawable)localObject2);
  }
  
  private void g()
  {
    if (!this.C) {
      return;
    }
    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
  }
  
  private boolean h()
  {
    f localf = this.f;
    return (localf == null) || (localf.e(this));
  }
  
  private boolean l()
  {
    f localf = this.f;
    return (localf == null) || (localf.c(this));
  }
  
  private boolean m()
  {
    f localf = this.f;
    return (localf == null) || (localf.d(this));
  }
  
  private void n()
  {
    g();
    this.c.c();
    this.o.b(this);
    k.d locald = this.t;
    if (locald != null)
    {
      locald.a();
      this.t = null;
    }
  }
  
  private void o(Object paramObject)
  {
    Object localObject = this.p;
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      h localh = (h)((Iterator)localObject).next();
      if ((localh instanceof c)) {
        ((c)localh).a(paramObject);
      }
    }
  }
  
  private Drawable p()
  {
    if (this.x == null)
    {
      Drawable localDrawable = this.k.p();
      this.x = localDrawable;
      if ((localDrawable == null) && (this.k.o() > 0)) {
        this.x = t(this.k.o());
      }
    }
    return this.x;
  }
  
  private Drawable q()
  {
    if (this.z == null)
    {
      Drawable localDrawable = this.k.q();
      this.z = localDrawable;
      if ((localDrawable == null) && (this.k.r() > 0)) {
        this.z = t(this.k.r());
      }
    }
    return this.z;
  }
  
  private Drawable r()
  {
    if (this.y == null)
    {
      Drawable localDrawable = this.k.w();
      this.y = localDrawable;
      if ((localDrawable == null) && (this.k.x() > 0)) {
        this.y = t(this.k.x());
      }
    }
    return this.y;
  }
  
  private boolean s()
  {
    f localf = this.f;
    return (localf == null) || (!localf.g().b());
  }
  
  private Drawable t(int paramInt)
  {
    Resources.Theme localTheme;
    if (this.k.D() != null) {
      localTheme = this.k.D();
    } else {
      localTheme = this.g.getTheme();
    }
    return m2.b.a(this.h, paramInt, localTheme);
  }
  
  private void u(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" this: ");
    localStringBuilder.append(this.b);
    Log.v("GlideRequest", localStringBuilder.toString());
  }
  
  private static int v(int paramInt, float paramFloat)
  {
    if (paramInt == -2147483648) {
      return paramInt;
    }
    return Math.round(paramFloat * paramInt);
  }
  
  private void w()
  {
    f localf = this.f;
    if (localf != null) {
      localf.h(this);
    }
  }
  
  private void x()
  {
    f localf = this.f;
    if (localf != null) {
      localf.a(this);
    }
  }
  
  public static <R> k<R> y(Context paramContext, com.bumptech.glide.e parame, Object paramObject1, Object paramObject2, Class<R> paramClass, a<?> parama, int paramInt1, int paramInt2, com.bumptech.glide.h paramh, u2.h<R> paramh1, h<R> paramh2, List<h<R>> paramList, f paramf, d2.k paramk, v2.c<? super R> paramc, Executor paramExecutor)
  {
    return new k(paramContext, parame, paramObject1, paramObject2, paramClass, parama, paramInt1, paramInt2, paramh, paramh1, paramh2, paramList, paramf, paramk, paramc, paramExecutor);
  }
  
  private void z(q paramq, int paramInt)
  {
    this.c.c();
    for (;;)
    {
      synchronized (this.d)
      {
        paramq.k(this.D);
        i1 = this.h.h();
        Object localObject2;
        if (i1 <= paramInt)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Load failed for ");
          ((StringBuilder)localObject2).append(this.i);
          ((StringBuilder)localObject2).append(" with size [");
          ((StringBuilder)localObject2).append(this.A);
          ((StringBuilder)localObject2).append("x");
          ((StringBuilder)localObject2).append(this.B);
          ((StringBuilder)localObject2).append("]");
          Log.w("Glide", ((StringBuilder)localObject2).toString(), paramq);
          if (i1 <= 4) {
            paramq.g("Glide");
          }
        }
        this.t = null;
        this.w = a.e;
        int i2 = 1;
        this.C = true;
        try
        {
          localObject2 = this.p;
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            paramInt = 0;
            i1 = paramInt;
            if (((Iterator)localObject2).hasNext())
            {
              paramInt |= ((h)((Iterator)localObject2).next()).m(paramq, this.i, this.o, s());
              continue;
            }
            localObject2 = this.e;
            if ((localObject2 == null) || (!((h)localObject2).m(paramq, this.i, this.o, s()))) {
              break label312;
            }
            paramInt = i2;
            if ((i1 | paramInt) == 0) {
              B();
            }
            this.C = false;
            w();
            y2.b.f("GlideRequest", this.a);
            return;
          }
        }
        finally
        {
          this.C = false;
        }
      }
      int i1 = 0;
      continue;
      label312:
      paramInt = 0;
    }
  }
  
  public void a(v<?> paramv, b2.a parama, boolean paramBoolean)
  {
    this.c.c();
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    for (;;)
    {
      try
      {
        Object localObject4 = this.d;
        localObject1 = localObject3;
        localObject1 = localObject2;
        try
        {
          this.t = null;
          if (paramv == null)
          {
            localObject1 = localObject2;
            paramv = new StringBuilder();
            localObject1 = localObject2;
            paramv.append("Expected to receive a Resource<R> with an object of ");
            localObject1 = localObject2;
            paramv.append(this.j);
            localObject1 = localObject2;
            paramv.append(" inside, but instead got null.");
            localObject1 = localObject2;
            c(new q(paramv.toString()));
            localObject1 = localObject2;
            return;
          }
          localObject1 = localObject2;
          localObject3 = paramv.get();
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (this.j.isAssignableFrom(localObject3.getClass()))
            {
              localObject1 = localObject2;
              boolean bool = m();
              if (bool) {}
            }
          }
          try
          {
            this.s = null;
            this.w = a.d;
            y2.b.f("GlideRequest", this.a);
            this.v.k(paramv);
            return;
          }
          finally
          {
            continue;
          }
          localObject1 = localObject2;
          A(paramv, localObject3, parama, paramBoolean);
          localObject1 = localObject2;
          return;
          this.s = null;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Expected to receive an object of ");
          ((StringBuilder)localObject1).append(this.j);
          ((StringBuilder)localObject1).append(" but instead got ");
          if (localObject3 == null) {
            break label415;
          }
          parama = localObject3.getClass();
          ((StringBuilder)localObject1).append(parama);
          ((StringBuilder)localObject1).append("{");
          ((StringBuilder)localObject1).append(localObject3);
          ((StringBuilder)localObject1).append("} inside Resource{");
          ((StringBuilder)localObject1).append(paramv);
          ((StringBuilder)localObject1).append("}.");
          if (localObject3 == null) {
            break label422;
          }
          parama = "";
          ((StringBuilder)localObject1).append(parama);
          c(new q(((StringBuilder)localObject1).toString()));
          this.v.k(paramv);
          return;
        }
        finally
        {
          paramv = (v<?>)localObject1;
        }
        localObject1 = paramv;
        localObject1 = paramv;
        throw parama;
      }
      finally
      {
        if (localObject1 != null) {
          this.v.k((v)localObject1);
        }
      }
      label415:
      parama = "";
      continue;
      label422:
      parama = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
    }
  }
  
  public boolean b()
  {
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.w == a.d)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void c(q paramq)
  {
    z(paramq, 5);
  }
  
  public void clear()
  {
    for (;;)
    {
      synchronized (this.d)
      {
        g();
        this.c.c();
        Object localObject1 = this.w;
        a locala = a.f;
        if (localObject1 == locala) {
          return;
        }
        n();
        localObject1 = this.s;
        if (localObject1 != null)
        {
          this.s = null;
          if (h()) {
            this.o.k(r());
          }
          y2.b.f("GlideRequest", this.a);
          this.w = locala;
          if (localObject1 != null) {
            this.v.k((v)localObject1);
          }
          return;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public Object d()
  {
    this.c.c();
    return this.d;
  }
  
  /* Error */
  public void e(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	t2/k:c	Ly2/c;
    //   4: invokevirtual 309	y2/c:c	()V
    //   7: aload_0
    //   8: getfield 112	t2/k:d	Ljava/lang/Object;
    //   11: astore 11
    //   13: aload 11
    //   15: monitorenter
    //   16: getstatic 86	t2/k:E	Z
    //   19: istore 4
    //   21: iload 4
    //   23: ifeq +43 -> 66
    //   26: new 181	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   33: astore 12
    //   35: aload 12
    //   37: ldc_w 462
    //   40: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 12
    //   46: aload_0
    //   47: getfield 219	t2/k:u	J
    //   50: invokestatic 224	x2/g:a	(J)D
    //   53: invokevirtual 227	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_0
    //   58: aload 12
    //   60: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 464	t2/k:u	(Ljava/lang/String;)V
    //   66: aload_0
    //   67: getfield 146	t2/k:w	Lt2/k$a;
    //   70: getstatic 466	t2/k$a:c	Lt2/k$a;
    //   73: if_acmpeq +7 -> 80
    //   76: aload 11
    //   78: monitorexit
    //   79: return
    //   80: getstatic 468	t2/k$a:b	Lt2/k$a;
    //   83: astore 12
    //   85: aload_0
    //   86: aload 12
    //   88: putfield 146	t2/k:w	Lt2/k$a;
    //   91: aload_0
    //   92: getfield 122	t2/k:k	Lt2/a;
    //   95: invokevirtual 471	t2/a:C	()F
    //   98: fstore_3
    //   99: aload_0
    //   100: iload_1
    //   101: fload_3
    //   102: invokestatic 473	t2/k:v	(IF)I
    //   105: putfield 209	t2/k:A	I
    //   108: aload_0
    //   109: iload_2
    //   110: fload_3
    //   111: invokestatic 473	t2/k:v	(IF)I
    //   114: putfield 215	t2/k:B	I
    //   117: iload 4
    //   119: ifeq +43 -> 162
    //   122: new 181	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   129: astore 13
    //   131: aload 13
    //   133: ldc_w 475
    //   136: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 13
    //   142: aload_0
    //   143: getfield 219	t2/k:u	J
    //   146: invokestatic 224	x2/g:a	(J)D
    //   149: invokevirtual 227	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_0
    //   154: aload 13
    //   156: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokespecial 464	t2/k:u	(Ljava/lang/String;)V
    //   162: aload_0
    //   163: getfield 138	t2/k:v	Ld2/k;
    //   166: astore 13
    //   168: aload_0
    //   169: getfield 116	t2/k:h	Lcom/bumptech/glide/e;
    //   172: astore 14
    //   174: aload_0
    //   175: getfield 118	t2/k:i	Ljava/lang/Object;
    //   178: astore 15
    //   180: aload_0
    //   181: getfield 122	t2/k:k	Lt2/a;
    //   184: invokevirtual 478	t2/a:A	()Lb2/f;
    //   187: astore 16
    //   189: aload_0
    //   190: getfield 209	t2/k:A	I
    //   193: istore_1
    //   194: aload_0
    //   195: getfield 215	t2/k:B	I
    //   198: istore_2
    //   199: aload_0
    //   200: getfield 122	t2/k:k	Lt2/a;
    //   203: invokevirtual 480	t2/a:z	()Ljava/lang/Class;
    //   206: astore 17
    //   208: aload_0
    //   209: getfield 120	t2/k:j	Ljava/lang/Class;
    //   212: astore 18
    //   214: aload_0
    //   215: getfield 128	t2/k:n	Lcom/bumptech/glide/h;
    //   218: astore 19
    //   220: aload_0
    //   221: getfield 122	t2/k:k	Lt2/a;
    //   224: invokevirtual 483	t2/a:n	()Ld2/j;
    //   227: astore 20
    //   229: aload_0
    //   230: getfield 122	t2/k:k	Lt2/a;
    //   233: invokevirtual 486	t2/a:E	()Ljava/util/Map;
    //   236: astore 21
    //   238: aload_0
    //   239: getfield 122	t2/k:k	Lt2/a;
    //   242: invokevirtual 489	t2/a:O	()Z
    //   245: istore 5
    //   247: aload_0
    //   248: getfield 122	t2/k:k	Lt2/a;
    //   251: invokevirtual 492	t2/a:K	()Z
    //   254: istore 6
    //   256: aload_0
    //   257: getfield 122	t2/k:k	Lt2/a;
    //   260: invokevirtual 495	t2/a:t	()Lb2/h;
    //   263: astore 22
    //   265: aload_0
    //   266: getfield 122	t2/k:k	Lt2/a;
    //   269: invokevirtual 497	t2/a:I	()Z
    //   272: istore 7
    //   274: aload_0
    //   275: getfield 122	t2/k:k	Lt2/a;
    //   278: invokevirtual 500	t2/a:G	()Z
    //   281: istore 8
    //   283: aload_0
    //   284: getfield 122	t2/k:k	Lt2/a;
    //   287: invokevirtual 503	t2/a:F	()Z
    //   290: istore 9
    //   292: aload_0
    //   293: getfield 122	t2/k:k	Lt2/a;
    //   296: invokevirtual 504	t2/a:s	()Z
    //   299: istore 10
    //   301: aload_0
    //   302: getfield 142	t2/k:r	Ljava/util/concurrent/Executor;
    //   305: astore 23
    //   307: aload 13
    //   309: aload 14
    //   311: aload 15
    //   313: aload 16
    //   315: iload_1
    //   316: iload_2
    //   317: aload 17
    //   319: aload 18
    //   321: aload 19
    //   323: aload 20
    //   325: aload 21
    //   327: iload 5
    //   329: iload 6
    //   331: aload 22
    //   333: iload 7
    //   335: iload 8
    //   337: iload 9
    //   339: iload 10
    //   341: aload_0
    //   342: aload 23
    //   344: invokevirtual 507	d2/k:f	(Lcom/bumptech/glide/e;Ljava/lang/Object;Lb2/f;IILjava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/h;Ld2/j;Ljava/util/Map;ZZLb2/h;ZZZZLt2/j;Ljava/util/concurrent/Executor;)Ld2/k$d;
    //   347: astore 14
    //   349: aload 11
    //   351: astore 13
    //   353: aload_0
    //   354: aload 14
    //   356: putfield 314	t2/k:t	Ld2/k$d;
    //   359: aload 11
    //   361: astore 13
    //   363: aload_0
    //   364: getfield 146	t2/k:w	Lt2/k$a;
    //   367: aload 12
    //   369: if_acmpeq +12 -> 381
    //   372: aload 11
    //   374: astore 13
    //   376: aload_0
    //   377: aconst_null
    //   378: putfield 314	t2/k:t	Ld2/k$d;
    //   381: iload 4
    //   383: ifeq +59 -> 442
    //   386: aload 11
    //   388: astore 13
    //   390: new 181	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   397: astore 12
    //   399: aload 11
    //   401: astore 13
    //   403: aload 12
    //   405: ldc_w 509
    //   408: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload 11
    //   414: astore 13
    //   416: aload 12
    //   418: aload_0
    //   419: getfield 219	t2/k:u	J
    //   422: invokestatic 224	x2/g:a	(J)D
    //   425: invokevirtual 227	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 11
    //   431: astore 13
    //   433: aload_0
    //   434: aload 12
    //   436: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokespecial 464	t2/k:u	(Ljava/lang/String;)V
    //   442: aload 11
    //   444: astore 13
    //   446: aload 11
    //   448: monitorexit
    //   449: return
    //   450: aload 11
    //   452: astore 13
    //   454: aload 11
    //   456: monitorexit
    //   457: aload 12
    //   459: athrow
    //   460: astore 12
    //   462: aload 13
    //   464: astore 11
    //   466: goto -16 -> 450
    //   469: astore 12
    //   471: goto -21 -> 450
    //   474: astore 12
    //   476: goto -26 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	k
    //   0	479	1	paramInt1	int
    //   0	479	2	paramInt2	int
    //   98	13	3	f1	float
    //   19	363	4	bool1	boolean
    //   245	83	5	bool2	boolean
    //   254	76	6	bool3	boolean
    //   272	62	7	bool4	boolean
    //   281	55	8	bool5	boolean
    //   290	48	9	bool6	boolean
    //   299	41	10	bool7	boolean
    //   11	454	11	localObject1	Object
    //   33	425	12	localObject2	Object
    //   460	1	12	localObject3	Object
    //   469	1	12	localObject4	Object
    //   474	1	12	localObject5	Object
    //   129	334	13	localObject6	Object
    //   172	183	14	localObject7	Object
    //   178	134	15	localObject8	Object
    //   187	127	16	localf	b2.f
    //   206	112	17	localClass1	Class
    //   212	108	18	localClass2	Class
    //   218	104	19	localh	com.bumptech.glide.h
    //   227	97	20	localj	d2.j
    //   236	90	21	localMap	java.util.Map
    //   263	69	22	localh1	b2.h
    //   305	38	23	localExecutor	Executor
    // Exception table:
    //   from	to	target	type
    //   353	359	460	finally
    //   363	372	460	finally
    //   376	381	460	finally
    //   390	399	460	finally
    //   403	412	460	finally
    //   416	429	460	finally
    //   433	442	460	finally
    //   446	449	460	finally
    //   454	457	460	finally
    //   307	349	469	finally
    //   16	21	474	finally
    //   26	66	474	finally
    //   66	79	474	finally
    //   80	117	474	finally
    //   122	162	474	finally
    //   162	307	474	finally
  }
  
  public boolean f()
  {
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.w == a.f)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void i()
  {
    for (;;)
    {
      synchronized (this.d)
      {
        g();
        this.c.c();
        this.u = x2.g.b();
        Object localObject4 = this.i;
        if (localObject4 == null)
        {
          if (l.t(this.l, this.m))
          {
            this.A = this.l;
            this.B = this.m;
          }
          if (q() == null)
          {
            i1 = 5;
            z(new q("Received null model"), i1);
          }
        }
        else
        {
          a locala = this.w;
          Object localObject2 = a.b;
          if (locala != localObject2)
          {
            if (locala == a.d)
            {
              a(this.s, b2.a.e, false);
              return;
            }
            o(localObject4);
            this.a = y2.b.b("GlideRequest");
            localObject4 = a.c;
            this.w = ((a)localObject4);
            if (l.t(this.l, this.m)) {
              e(this.l, this.m);
            } else {
              this.o.i(this);
            }
            locala = this.w;
            if (((locala == localObject2) || (locala == localObject4)) && (l())) {
              this.o.g(r());
            }
            if (E)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("finished run method in ");
              ((StringBuilder)localObject2).append(x2.g.a(this.u));
              u(((StringBuilder)localObject2).toString());
            }
            return;
          }
          throw new IllegalArgumentException("Cannot restart a running request");
        }
      }
      int i1 = 3;
    }
  }
  
  public boolean isRunning()
  {
    for (;;)
    {
      synchronized (this.d)
      {
        a locala = this.w;
        if (locala == a.b) {
          break label43;
        }
        if (locala == a.c)
        {
          break label43;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label43:
      bool = true;
    }
  }
  
  public boolean j()
  {
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.w == a.d)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean k(e arg1)
  {
    if (!(??? instanceof k)) {
      return false;
    }
    for (;;)
    {
      synchronized (this.d)
      {
        int i3 = this.l;
        int i4 = this.m;
        Object localObject1 = this.i;
        Class localClass = this.j;
        a locala1 = this.k;
        com.bumptech.glide.h localh1 = this.n;
        Object localObject4 = this.p;
        if (localObject4 != null)
        {
          i1 = ((List)localObject4).size();
          Object localObject5 = (k)???;
          synchronized (((k)localObject5).d)
          {
            int i5 = ((k)localObject5).l;
            int i6 = ((k)localObject5).m;
            ??? = ((k)localObject5).i;
            localObject4 = ((k)localObject5).j;
            a locala2 = ((k)localObject5).k;
            com.bumptech.glide.h localh2 = ((k)localObject5).n;
            localObject5 = ((k)localObject5).p;
            if (localObject5 == null) {
              break label238;
            }
            i2 = ((List)localObject5).size();
            return (i3 == i5) && (i4 == i6) && (l.c(localObject1, ???)) && (localClass.equals(localObject4)) && (locala1.equals(locala2)) && (localh1 == localh2) && (i1 == i2);
          }
        }
      }
      int i1 = 0;
      continue;
      label238:
      int i2 = 0;
    }
  }
  
  public void pause()
  {
    synchronized (this.d)
    {
      if (isRunning()) {
        clear();
      }
      return;
    }
  }
  
  public String toString()
  {
    synchronized (this.d)
    {
      Object localObject2 = this.i;
      Class localClass = this.j;
      ??? = new StringBuilder();
      ((StringBuilder)???).append(super.toString());
      ((StringBuilder)???).append("[model=");
      ((StringBuilder)???).append(localObject2);
      ((StringBuilder)???).append(", transcodeClass=");
      ((StringBuilder)???).append(localClass);
      ((StringBuilder)???).append("]");
      return ((StringBuilder)???).toString();
    }
  }
  
  private static enum a
  {
    static
    {
      a locala1 = new a("PENDING", 0);
      a = locala1;
      a locala2 = new a("RUNNING", 1);
      b = locala2;
      a locala3 = new a("WAITING_FOR_SIZE", 2);
      c = locala3;
      a locala4 = new a("COMPLETE", 3);
      d = locala4;
      a locala5 = new a("FAILED", 4);
      e = locala5;
      a locala6 = new a("CLEARED", 5);
      f = locala6;
      g = new a[] { locala1, locala2, locala3, locala4, locala5, locala6 };
    }
    
    private a() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t2.k
 * JD-Core Version:    0.7.0.1
 */