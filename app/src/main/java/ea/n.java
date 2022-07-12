package ea;

import aa.g;
import aa.l;
import aa.x;
import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import l9.e;
import l9.e.a;
import l9.f0;
import l9.f0.a;
import l9.g0;
import l9.z;

final class n<T>
  implements b<T>
{
  private final s a;
  private final Object[] b;
  private final e.a c;
  private final f<g0, T> d;
  private volatile boolean e;
  @Nullable
  @GuardedBy("this")
  private e f;
  @Nullable
  @GuardedBy("this")
  private Throwable g;
  @GuardedBy("this")
  private boolean h;
  
  n(s params, Object[] paramArrayOfObject, e.a parama, f<g0, T> paramf)
  {
    this.a = params;
    this.b = paramArrayOfObject;
    this.c = parama;
    this.d = paramf;
  }
  
  private e b()
  {
    e locale = this.c.a(this.a.a(this.b));
    Objects.requireNonNull(locale, "Call.Factory returned null.");
    return locale;
  }
  
  @GuardedBy("this")
  private e c()
  {
    Object localObject = this.f;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.g;
    if (localObject != null)
    {
      if (!(localObject instanceof IOException))
      {
        if ((localObject instanceof RuntimeException)) {
          throw ((RuntimeException)localObject);
        }
        throw ((Error)localObject);
      }
      throw ((IOException)localObject);
    }
    try
    {
      localObject = b();
      this.f = ((e)localObject);
      return localObject;
    }
    catch (IOException localIOException) {}catch (Error localError) {}catch (RuntimeException localRuntimeException) {}
    y.s(localRuntimeException);
    this.g = localRuntimeException;
    throw localRuntimeException;
  }
  
  /* Error */
  public void B(final d<T> paramd)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 93
    //   3: invokestatic 70	java/util/Objects:requireNonNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 95	ea/n:h	Z
    //   13: ifne +115 -> 128
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 95	ea/n:h	Z
    //   21: aload_0
    //   22: getfield 78	ea/n:f	Ll9/e;
    //   25: astore 4
    //   27: aload_0
    //   28: getfield 80	ea/n:g	Ljava/lang/Throwable;
    //   31: astore 5
    //   33: aload 4
    //   35: astore_2
    //   36: aload 5
    //   38: astore_3
    //   39: aload 4
    //   41: ifnonnull +43 -> 84
    //   44: aload 4
    //   46: astore_2
    //   47: aload 5
    //   49: astore_3
    //   50: aload 5
    //   52: ifnonnull +32 -> 84
    //   55: aload_0
    //   56: invokespecial 82	ea/n:b	()Ll9/e;
    //   59: astore_2
    //   60: aload_0
    //   61: aload_2
    //   62: putfield 78	ea/n:f	Ll9/e;
    //   65: aload 5
    //   67: astore_3
    //   68: goto +16 -> 84
    //   71: astore_3
    //   72: aload_3
    //   73: invokestatic 88	ea/y:s	(Ljava/lang/Throwable;)V
    //   76: aload_0
    //   77: aload_3
    //   78: putfield 80	ea/n:g	Ljava/lang/Throwable;
    //   81: aload 4
    //   83: astore_2
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_3
    //   87: ifnull +12 -> 99
    //   90: aload_1
    //   91: aload_0
    //   92: aload_3
    //   93: invokeinterface 100 3 0
    //   98: return
    //   99: aload_0
    //   100: getfield 102	ea/n:e	Z
    //   103: ifeq +9 -> 112
    //   106: aload_2
    //   107: invokeinterface 107 1 0
    //   112: aload_2
    //   113: new 9	ea/n$a
    //   116: dup
    //   117: aload_0
    //   118: aload_1
    //   119: invokespecial 110	ea/n$a:<init>	(Lea/n;Lea/d;)V
    //   122: invokeinterface 114 2 0
    //   127: return
    //   128: new 116	java/lang/IllegalStateException
    //   131: dup
    //   132: ldc 118
    //   134: invokespecial 121	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   137: athrow
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	n
    //   0	143	1	paramd	d<T>
    //   35	78	2	locale1	e
    //   38	30	3	localThrowable1	Throwable
    //   71	22	3	localThrowable2	Throwable
    //   25	57	4	locale2	e
    //   31	35	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   55	65	71	finally
    //   9	33	138	finally
    //   72	81	138	finally
    //   84	86	138	finally
    //   128	138	138	finally
    //   139	141	138	finally
  }
  
  public n<T> a()
  {
    return new n(this.a, this.b, this.c, this.d);
  }
  
  public void cancel()
  {
    this.e = true;
    try
    {
      e locale = this.f;
      if (locale != null) {
        locale.cancel();
      }
      return;
    }
    finally {}
  }
  
  t<T> d(f0 paramf0)
  {
    Object localObject = paramf0.a();
    f0 localf0 = paramf0.m0().b(new c(((g0)localObject).B(), ((g0)localObject).i())).c();
    int i = localf0.B();
    if ((i >= 200) && (i < 300))
    {
      if ((i != 204) && (i != 205))
      {
        paramf0 = new b((g0)localObject);
        try
        {
          localObject = t.f(this.d.convert(paramf0), localf0);
          return localObject;
        }
        catch (RuntimeException localRuntimeException)
        {
          paramf0.f0();
          throw localRuntimeException;
        }
      }
      localRuntimeException.close();
      return t.f(null, localf0);
    }
    try
    {
      paramf0 = t.c(y.a(localRuntimeException), localf0);
      return paramf0;
    }
    finally
    {
      localRuntimeException.close();
    }
  }
  
  public t<T> g()
  {
    try
    {
      if (!this.h)
      {
        this.h = true;
        e locale = c();
        if (this.e) {
          locale.cancel();
        }
        return d(locale.g());
      }
      throw new IllegalStateException("Already executed.");
    }
    finally {}
  }
  
  /* Error */
  public l9.d0 h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 194	ea/n:c	()Ll9/e;
    //   6: invokeinterface 202 1 0
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: astore_1
    //   17: goto +15 -> 32
    //   20: astore_1
    //   21: new 72	java/lang/RuntimeException
    //   24: dup
    //   25: ldc 204
    //   27: aload_1
    //   28: invokespecial 207	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   31: athrow
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	n
    //   11	4	1	locald0	l9.d0
    //   16	1	1	localObject	Object
    //   20	15	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
    //   21	32	16	finally
    //   2	12	20	java/io/IOException
  }
  
  public boolean i()
  {
    boolean bool2 = this.e;
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    for (;;)
    {
      try
      {
        e locale = this.f;
        if ((locale != null) && (locale.i())) {
          return bool1;
        }
      }
      finally {}
      bool1 = false;
    }
  }
  
  class a
    implements l9.f
  {
    private void a(Throwable paramThrowable)
    {
      try
      {
        paramd.a(this.b, paramThrowable);
        return;
      }
      finally
      {
        y.s(paramThrowable);
        paramThrowable.printStackTrace();
      }
    }
    
    public void c(e parame, f0 paramf0)
    {
      try
      {
        parame = this.b.d(paramf0);
        try
        {
          paramd.c(this.b, parame);
          return;
        }
        finally
        {
          y.s(parame);
          parame.printStackTrace();
          return;
        }
        return;
      }
      finally
      {
        y.s(parame);
        a(parame);
      }
    }
    
    public void d(e parame, IOException paramIOException)
    {
      a(paramIOException);
    }
  }
  
  static final class b
    extends g0
  {
    private final g0 c;
    private final aa.d d;
    @Nullable
    IOException e;
    
    b(g0 paramg0)
    {
      this.c = paramg0;
      this.d = l.b(new a(paramg0.e0()));
    }
    
    public z B()
    {
      return this.c.B();
    }
    
    public void close()
    {
      this.c.close();
    }
    
    public aa.d e0()
    {
      return this.d;
    }
    
    void f0()
    {
      IOException localIOException = this.e;
      if (localIOException == null) {
        return;
      }
      throw localIOException;
    }
    
    public long i()
    {
      return this.c.i();
    }
    
    class a
      extends g
    {
      a(x paramx)
      {
        super();
      }
      
      public long k(aa.b paramb, long paramLong)
      {
        try
        {
          paramLong = super.k(paramb, paramLong);
          return paramLong;
        }
        catch (IOException paramb)
        {
          n.b.this.e = paramb;
          throw paramb;
        }
      }
    }
  }
  
  static final class c
    extends g0
  {
    @Nullable
    private final z c;
    private final long d;
    
    c(@Nullable z paramz, long paramLong)
    {
      this.c = paramz;
      this.d = paramLong;
    }
    
    public z B()
    {
      return this.c;
    }
    
    public aa.d e0()
    {
      throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
    
    public long i()
    {
      return this.d;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.n
 * JD-Core Version:    0.7.0.1
 */