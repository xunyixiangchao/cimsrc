package t9;

import aa.a;
import aa.d;
import aa.v;
import aa.x;
import aa.y;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collection;
import l9.w;

public final class i
{
  public static final a o = new a(null);
  private final int a;
  private final f b;
  private long c;
  private long d;
  private long e;
  private long f;
  private final ArrayDeque<w> g;
  private boolean h;
  private final c i;
  private final b j;
  private final d k;
  private final d l;
  private b m;
  private IOException n;
  
  public i(int paramInt, f paramf, boolean paramBoolean1, boolean paramBoolean2, w paramw)
  {
    this.a = paramInt;
    this.b = paramf;
    this.f = paramf.y0().c();
    ArrayDeque localArrayDeque = new ArrayDeque();
    this.g = localArrayDeque;
    this.i = new c(paramf.x0().c(), paramBoolean2);
    this.j = new b(paramBoolean1);
    this.k = new d();
    this.l = new d();
    if (paramw != null)
    {
      if ((t() ^ true))
      {
        localArrayDeque.add(paramw);
        return;
      }
      throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
    }
    if (t()) {
      return;
    }
    throw new IllegalStateException("remotely-initiated streams should have headers".toString());
  }
  
  private final boolean e(b paramb, IOException paramIOException)
  {
    if ((m9.o.e) && (Thread.holdsLock(this)))
    {
      paramb = new StringBuilder();
      paramb.append("Thread ");
      paramb.append(Thread.currentThread().getName());
      paramb.append(" MUST NOT hold lock on ");
      paramb.append(this);
      throw new AssertionError(paramb.toString());
    }
    try
    {
      b localb = h();
      if (localb != null) {
        return false;
      }
      if (p().g())
      {
        boolean bool = o().h();
        if (bool) {
          return false;
        }
      }
      z(paramb);
      A(paramIOException);
      notifyAll();
      paramb = o8.o.a;
      this.b.N0(this.a);
      return true;
    }
    finally {}
  }
  
  public final void A(IOException paramIOException)
  {
    this.n = paramIOException;
  }
  
  public final void B(long paramLong)
  {
    this.d = paramLong;
  }
  
  public final void C(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final void D(long paramLong)
  {
    this.e = paramLong;
  }
  
  /* Error */
  public final w E()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 98	t9/i:k	Lt9/i$d;
    //   6: invokevirtual 212	aa/a:t	()V
    //   9: aload_0
    //   10: getfield 80	t9/i:g	Ljava/util/ArrayDeque;
    //   13: invokevirtual 215	java/util/ArrayDeque:isEmpty	()Z
    //   16: ifeq +17 -> 33
    //   19: aload_0
    //   20: getfield 217	t9/i:m	Lt9/b;
    //   23: ifnonnull +10 -> 33
    //   26: aload_0
    //   27: invokevirtual 220	t9/i:F	()V
    //   30: goto -21 -> 9
    //   33: aload_0
    //   34: getfield 98	t9/i:k	Lt9/i$d;
    //   37: invokevirtual 222	t9/i$d:A	()V
    //   40: aload_0
    //   41: getfield 80	t9/i:g	Ljava/util/ArrayDeque;
    //   44: invokeinterface 223 1 0
    //   49: iconst_1
    //   50: ixor
    //   51: ifeq +26 -> 77
    //   54: aload_0
    //   55: getfield 80	t9/i:g	Ljava/util/ArrayDeque;
    //   58: invokevirtual 227	java/util/ArrayDeque:removeFirst	()Ljava/lang/Object;
    //   61: astore_1
    //   62: aload_1
    //   63: ldc 229
    //   65: invokestatic 231	a9/f:e	(Ljava/lang/Object;Ljava/lang/String;)V
    //   68: aload_1
    //   69: checkcast 233	l9/w
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: areturn
    //   77: aload_0
    //   78: getfield 196	t9/i:n	Ljava/io/IOException;
    //   81: astore_2
    //   82: aload_2
    //   83: astore_1
    //   84: aload_2
    //   85: ifnonnull +21 -> 106
    //   88: aload_0
    //   89: getfield 217	t9/i:m	Lt9/b;
    //   92: astore_1
    //   93: aload_1
    //   94: invokestatic 235	a9/f:c	(Ljava/lang/Object;)V
    //   97: new 237	t9/n
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 239	t9/n:<init>	(Lt9/b;)V
    //   105: astore_1
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 98	t9/i:k	Lt9/i$d;
    //   113: invokevirtual 222	t9/i$d:A	()V
    //   116: aload_1
    //   117: athrow
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	i
    //   61	46	1	localObject1	Object
    //   108	9	1	localObject2	Object
    //   118	4	1	localObject3	Object
    //   81	4	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   9	30	108	finally
    //   2	9	118	finally
    //   33	73	118	finally
    //   77	82	118	finally
    //   88	106	118	finally
    //   106	108	118	finally
    //   109	118	118	finally
  }
  
  public final void F()
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      label5:
      break label5;
    }
    Thread.currentThread().interrupt();
    throw new InterruptedIOException();
  }
  
  public final y G()
  {
    return this.l;
  }
  
  public final void a(long paramLong)
  {
    this.f += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public final void b()
  {
    Object localObject1;
    if ((m9.o.e) && (Thread.holdsLock(this)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Thread ");
      ((StringBuilder)localObject1).append(Thread.currentThread().getName());
      ((StringBuilder)localObject1).append(" MUST NOT hold lock on ");
      ((StringBuilder)localObject1).append(this);
      throw new AssertionError(((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        if ((p().g()) || (!p().a())) {
          break label163;
        }
        if (o().h()) {
          break label158;
        }
        if (!o().g()) {
          break label163;
        }
      }
      finally {}
      boolean bool = u();
      localObject1 = o8.o.a;
      if (i1 != 0)
      {
        d(b.k, null);
        return;
      }
      if (!bool) {
        this.b.N0(this.a);
      }
      return;
      label158:
      int i1 = 1;
      continue;
      label163:
      i1 = 0;
    }
  }
  
  public final void c()
  {
    if (!this.j.g())
    {
      if (!this.j.h())
      {
        if (this.m != null)
        {
          IOException localIOException = this.n;
          Object localObject = localIOException;
          if (localIOException == null)
          {
            localObject = this.m;
            a9.f.c(localObject);
            localObject = new n((b)localObject);
          }
          throw ((Throwable)localObject);
        }
        return;
      }
      throw new IOException("stream finished");
    }
    throw new IOException("stream closed");
  }
  
  public final void d(b paramb, IOException paramIOException)
  {
    a9.f.f(paramb, "rstStatusCode");
    if (!e(paramb, paramIOException)) {
      return;
    }
    this.b.Z0(this.a, paramb);
  }
  
  public final void f(b paramb)
  {
    a9.f.f(paramb, "errorCode");
    if (!e(paramb, null)) {
      return;
    }
    this.b.a1(this.a, paramb);
  }
  
  public final f g()
  {
    return this.b;
  }
  
  public final b h()
  {
    try
    {
      b localb = this.m;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final IOException i()
  {
    return this.n;
  }
  
  public final int j()
  {
    return this.a;
  }
  
  public final long k()
  {
    return this.d;
  }
  
  public final long l()
  {
    return this.c;
  }
  
  public final d m()
  {
    return this.k;
  }
  
  public final v n()
  {
    for (;;)
    {
      try
      {
        if (this.h) {
          break label58;
        }
        if (!t()) {
          break label53;
        }
      }
      finally {}
      if (i1 != 0)
      {
        o8.o localo = o8.o.a;
        return this.j;
      }
      throw new IllegalStateException("reply before requesting the sink".toString());
      label53:
      int i1 = 0;
      continue;
      label58:
      i1 = 1;
    }
  }
  
  public final b o()
  {
    return this.j;
  }
  
  public final c p()
  {
    return this.i;
  }
  
  public final long q()
  {
    return this.f;
  }
  
  public final long r()
  {
    return this.e;
  }
  
  public final d s()
  {
    return this.l;
  }
  
  public final boolean t()
  {
    int i1;
    if ((this.a & 0x1) == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    return this.b.s0() == i1;
  }
  
  public final boolean u()
  {
    try
    {
      b localb = this.m;
      if (localb != null) {
        return false;
      }
      if (((this.i.g()) || (this.i.a())) && ((this.j.h()) || (this.j.g())))
      {
        boolean bool = this.h;
        if (bool) {
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  public final y v()
  {
    return this.k;
  }
  
  public final void w(d paramd, int paramInt)
  {
    a9.f.f(paramd, "source");
    if ((m9.o.e) && (Thread.holdsLock(this)))
    {
      paramd = new StringBuilder();
      paramd.append("Thread ");
      paramd.append(Thread.currentThread().getName());
      paramd.append(" MUST NOT hold lock on ");
      paramd.append(this);
      throw new AssertionError(paramd.toString());
    }
    this.i.B(paramd, paramInt);
  }
  
  public final void x(w paramw, boolean paramBoolean)
  {
    a9.f.f(paramw, "headers");
    if ((m9.o.e) && (Thread.holdsLock(this)))
    {
      paramw = new StringBuilder();
      paramw.append("Thread ");
      paramw.append(Thread.currentThread().getName());
      paramw.append(" MUST NOT hold lock on ");
      paramw.append(this);
      throw new AssertionError(paramw.toString());
    }
    try
    {
      if ((this.h) && (paramBoolean))
      {
        p().f0(paramw);
      }
      else
      {
        this.h = true;
        this.g.add(paramw);
      }
      if (paramBoolean) {
        p().e0(true);
      }
      paramBoolean = u();
      notifyAll();
      paramw = o8.o.a;
      if (!paramBoolean) {
        this.b.N0(this.a);
      }
      return;
    }
    finally {}
  }
  
  public final void y(b paramb)
  {
    try
    {
      a9.f.f(paramb, "errorCode");
      if (this.m == null)
      {
        this.m = paramb;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public final void z(b paramb)
  {
    this.m = paramb;
  }
  
  public static final class a {}
  
  public final class b
    implements v
  {
    private boolean a;
    private final aa.b b;
    private w c;
    private boolean d;
    
    public b()
    {
      boolean bool;
      this.a = bool;
      this.b = new aa.b();
    }
    
    private final void a(boolean paramBoolean)
    {
      for (;;)
      {
        synchronized (i.this)
        {
          ???.s().t();
          try
          {
            if ((???.r() >= ???.q()) && (!h()) && (!g()) && (???.h() == null))
            {
              ???.F();
              continue;
            }
            ???.s().A();
            ???.c();
            long l = Math.min(???.q() - ???.r(), this.b.z0());
            ???.D(???.r() + l);
            if ((paramBoolean) && (l == this.b.z0()))
            {
              paramBoolean = true;
              o8.o localo = o8.o.a;
              i.this.s().t();
              try
              {
                i.this.g().W0(i.this.j(), paramBoolean, this.b, l);
                return;
              }
              finally
              {
                i.this.s().A();
              }
              localObject3 = finally;
            }
          }
          finally
          {
            localObject1.s().A();
          }
        }
        paramBoolean = false;
      }
    }
    
    public void L(aa.b paramb, long paramLong)
    {
      a9.f.f(paramb, "source");
      i locali = i.this;
      if ((m9.o.e) && (Thread.holdsLock(locali)))
      {
        paramb = new StringBuilder();
        paramb.append("Thread ");
        paramb.append(Thread.currentThread().getName());
        paramb.append(" MUST NOT hold lock on ");
        paramb.append(locali);
        throw new AssertionError(paramb.toString());
      }
      this.b.L(paramb, paramLong);
      while (this.b.z0() >= 16384L) {
        a(false);
      }
    }
    
    public y c()
    {
      return i.this.s();
    }
    
    public void close()
    {
      ??? = i.this;
      Object localObject2;
      if ((m9.o.e) && (Thread.holdsLock(???)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Thread ");
        ((StringBuilder)localObject2).append(Thread.currentThread().getName());
        ((StringBuilder)localObject2).append(" MUST NOT hold lock on ");
        ((StringBuilder)localObject2).append(???);
        throw new AssertionError(((StringBuilder)localObject2).toString());
      }
      for (;;)
      {
        synchronized (i.this)
        {
          bool = g();
          if (bool) {
            return;
          }
          if (((i)???).h() == null)
          {
            bool = true;
            localObject2 = o8.o.a;
            if (!i.this.o().a)
            {
              int i;
              if (this.b.z0() > 0L) {
                i = 1;
              } else {
                i = 0;
              }
              int j;
              if (this.c != null) {
                j = 1;
              } else {
                j = 0;
              }
              if (j != 0)
              {
                if (this.b.z0() > 0L)
                {
                  a(false);
                  continue;
                }
                ??? = i.this.g();
                i = i.this.j();
                localObject2 = this.c;
                a9.f.c(localObject2);
                ((f)???).X0(i, bool, m9.o.q((w)localObject2));
              }
              else if (i != 0)
              {
                if (this.b.z0() > 0L)
                {
                  a(true);
                  continue;
                }
              }
              else if (bool)
              {
                i.this.g().W0(i.this.j(), true, null, 0L);
              }
            }
            synchronized (i.this)
            {
              i(true);
              localObject2 = o8.o.a;
              i.this.g().flush();
              i.this.b();
              return;
            }
          }
        }
        boolean bool = false;
      }
    }
    
    public void flush()
    {
      ??? = i.this;
      Object localObject1;
      if ((m9.o.e) && (Thread.holdsLock(???)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Thread ");
        ((StringBuilder)localObject1).append(Thread.currentThread().getName());
        ((StringBuilder)localObject1).append(" MUST NOT hold lock on ");
        ((StringBuilder)localObject1).append(???);
        throw new AssertionError(((StringBuilder)localObject1).toString());
      }
      synchronized (i.this)
      {
        ???.c();
        localObject1 = o8.o.a;
        while (this.b.z0() > 0L)
        {
          a(false);
          i.this.g().flush();
        }
        return;
      }
    }
    
    public final boolean g()
    {
      return this.d;
    }
    
    public final boolean h()
    {
      return this.a;
    }
    
    public final void i(boolean paramBoolean)
    {
      this.d = paramBoolean;
    }
  }
  
  public final class c
    implements x
  {
    private final long a;
    private boolean b;
    private final aa.b c;
    private final aa.b d;
    private w e;
    private boolean f;
    
    public c(boolean paramBoolean)
    {
      this.a = ???;
      boolean bool1;
      this.b = bool1;
      this.c = new aa.b();
      this.d = new aa.b();
    }
    
    private final void g0(long paramLong)
    {
      i locali = i.this;
      if ((m9.o.e) && (Thread.holdsLock(locali)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Thread ");
        localStringBuilder.append(Thread.currentThread().getName());
        localStringBuilder.append(" MUST NOT hold lock on ");
        localStringBuilder.append(locali);
        throw new AssertionError(localStringBuilder.toString());
      }
      i.this.g().V0(paramLong);
    }
    
    public final void B(d paramd, long paramLong)
    {
      a9.f.f(paramd, "source");
      ??? = i.this;
      long l1 = paramLong;
      if (m9.o.e) {
        if (!Thread.holdsLock(???))
        {
          l1 = paramLong;
        }
        else
        {
          paramd = new StringBuilder();
          paramd.append("Thread ");
          paramd.append(Thread.currentThread().getName());
          paramd.append(" MUST NOT hold lock on ");
          paramd.append(???);
          throw new AssertionError(paramd.toString());
        }
      }
      if (l1 > 0L) {}
      for (;;)
      {
        synchronized (i.this)
        {
          for (;;)
          {
            boolean bool = g();
            paramLong = h().z0();
            long l2 = this.a;
            int j = 1;
            if (paramLong + l1 <= l2) {
              break label338;
            }
            i = 1;
            o8.o localo = o8.o.a;
            if (i != 0)
            {
              paramd.skip(l1);
              i.this.f(b.f);
              return;
            }
            if (bool)
            {
              paramd.skip(l1);
              return;
            }
            paramLong = paramd.k(this.c, l1);
            if (paramLong != -1L)
            {
              l2 = l1 - paramLong;
              synchronized (i.this)
              {
                if (a())
                {
                  paramLong = i().z0();
                  i().a();
                }
                else
                {
                  if (h().z0() != 0L) {
                    break label344;
                  }
                  i = j;
                  h().G0(i());
                  if (i != 0) {
                    ???.notifyAll();
                  }
                  paramLong = 0L;
                }
                l1 = l2;
                if (paramLong <= 0L) {
                  break;
                }
                g0(paramLong);
                l1 = l2;
              }
            }
          }
          throw new EOFException();
        }
        return;
        label338:
        int i = 0;
        continue;
        label344:
        i = 0;
      }
    }
    
    public final boolean a()
    {
      return this.f;
    }
    
    public y c()
    {
      return i.this.m();
    }
    
    public void close()
    {
      synchronized (i.this)
      {
        d0(true);
        long l = h().z0();
        h().a();
        ???.notifyAll();
        o8.o localo = o8.o.a;
        if (l > 0L) {
          g0(l);
        }
        i.this.b();
        return;
      }
    }
    
    public final void d0(boolean paramBoolean)
    {
      this.f = paramBoolean;
    }
    
    public final void e0(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public final void f0(w paramw)
    {
      this.e = paramw;
    }
    
    public final boolean g()
    {
      return this.b;
    }
    
    public final aa.b h()
    {
      return this.d;
    }
    
    public final aa.b i()
    {
      return this.c;
    }
    
    public long k(aa.b paramb, long paramLong)
    {
      a9.f.f(paramb, "sink");
      int i;
      if (paramLong >= 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        for (;;)
        {
          Object localObject2 = null;
          synchronized (i.this)
          {
            ???.m().t();
            Object localObject1 = localObject2;
            try
            {
              if (???.h() != null)
              {
                localObject1 = localObject2;
                if (!g())
                {
                  localObject2 = ???.i();
                  localObject1 = localObject2;
                  if (localObject2 == null)
                  {
                    localObject1 = ???.h();
                    a9.f.c(localObject1);
                    localObject1 = new n((b)localObject1);
                  }
                }
              }
              if (!a())
              {
                long l1;
                if (h().z0() > 0L)
                {
                  long l2 = h().k(paramb, Math.min(paramLong, h().z0()));
                  ???.C(???.l() + l2);
                  long l3 = ???.l() - ???.k();
                  l1 = l2;
                  if (localObject1 == null)
                  {
                    l1 = l2;
                    if (l3 >= ???.g().x0().c() / 2)
                    {
                      ???.g().b1(???.j(), l3);
                      ???.B(???.l());
                      l1 = l2;
                    }
                  }
                }
                else
                {
                  if ((!g()) && (localObject1 == null))
                  {
                    ???.F();
                    l1 = -1L;
                    i = 1;
                    break label275;
                  }
                  l1 = -1L;
                }
                i = 0;
                label275:
                ???.m().A();
                localObject2 = o8.o.a;
                if (i == 0)
                {
                  if (l1 != -1L)
                  {
                    g0(l1);
                    return l1;
                  }
                  if (localObject1 == null) {
                    return -1L;
                  }
                  throw ((Throwable)localObject1);
                }
              }
              else
              {
                throw new IOException("stream closed");
              }
            }
            finally
            {
              ???.m().A();
            }
          }
        }
      }
      throw new IllegalArgumentException(a9.f.m("byteCount < 0: ", Long.valueOf(paramLong)).toString());
    }
  }
  
  public final class d
    extends a
  {
    public final void A()
    {
      if (!u()) {
        return;
      }
      throw v(null);
    }
    
    protected IOException v(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      return localSocketTimeoutException;
    }
    
    protected void z()
    {
      this.m.f(b.k);
      this.m.g().O0();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t9.i
 * JD-Core Version:    0.7.0.1
 */