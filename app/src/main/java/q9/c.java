package q9;

import aa.b;
import aa.g;
import aa.l;
import aa.v;
import java.io.IOException;
import java.net.ProtocolException;
import l9.a;
import l9.d0;
import l9.e0;
import l9.f0;
import l9.f0.a;
import l9.g0;
import l9.h0;
import l9.t;
import r9.d.a;

public final class c
{
  private final h a;
  private final t b;
  private final d c;
  private final r9.d d;
  private boolean e;
  private boolean f;
  
  public c(h paramh, t paramt, d paramd, r9.d paramd1)
  {
    this.a = paramh;
    this.b = paramt;
    this.c = paramd;
    this.d = paramd1;
  }
  
  private final void t(IOException paramIOException)
  {
    this.f = true;
    this.d.f().g(this.a, paramIOException);
  }
  
  public final <E extends IOException> E a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, E paramE)
  {
    if (paramE != null) {
      t(paramE);
    }
    if (paramBoolean2)
    {
      t localt = this.b;
      h localh = this.a;
      if (paramE != null) {
        localt.r(localh, paramE);
      } else {
        localt.p(localh, paramLong);
      }
    }
    if (paramBoolean1) {
      if (paramE != null) {
        this.b.w(this.a, paramE);
      } else {
        this.b.u(this.a, paramLong);
      }
    }
    return this.a.v(this, paramBoolean2, paramBoolean1, paramE);
  }
  
  public final void b()
  {
    this.d.cancel();
  }
  
  public final v c(d0 paramd0, boolean paramBoolean)
  {
    a9.f.f(paramd0, "request");
    this.e = paramBoolean;
    e0 locale0 = paramd0.a();
    a9.f.c(locale0);
    long l = locale0.a();
    this.b.q(this.a);
    return new a(this.d.b(paramd0, l), l);
  }
  
  public final void d()
  {
    this.d.cancel();
    this.a.v(this, true, true, null);
  }
  
  public final void e()
  {
    try
    {
      this.d.c();
      return;
    }
    catch (IOException localIOException)
    {
      this.b.r(this.a, localIOException);
      t(localIOException);
      throw localIOException;
    }
  }
  
  public final void f()
  {
    try
    {
      this.d.e();
      return;
    }
    catch (IOException localIOException)
    {
      this.b.r(this.a, localIOException);
      t(localIOException);
      throw localIOException;
    }
  }
  
  public final h g()
  {
    return this.a;
  }
  
  public final i h()
  {
    Object localObject = this.d.f();
    if ((localObject instanceof i)) {
      localObject = (i)localObject;
    } else {
      localObject = null;
    }
    if (localObject != null) {
      return localObject;
    }
    throw new IllegalStateException("no connection for CONNECT tunnels".toString());
  }
  
  public final t i()
  {
    return this.b;
  }
  
  public final d j()
  {
    return this.c;
  }
  
  public final boolean k()
  {
    return this.f;
  }
  
  public final boolean l()
  {
    return a9.f.a(this.c.b().c().l().i(), this.d.f().e().a().l().i()) ^ true;
  }
  
  public final boolean m()
  {
    return this.e;
  }
  
  public final void n()
  {
    this.d.f().h();
  }
  
  public final void o()
  {
    this.a.v(this, true, false, null);
  }
  
  public final g0 p(f0 paramf0)
  {
    a9.f.f(paramf0, "response");
    try
    {
      String str = f0.h0(paramf0, "Content-Type", null, 2, null);
      long l = this.d.a(paramf0);
      paramf0 = new r9.h(str, l, l.b(new b(this.d.g(paramf0), l)));
      return paramf0;
    }
    catch (IOException paramf0)
    {
      this.b.w(this.a, paramf0);
      t(paramf0);
      throw paramf0;
    }
  }
  
  public final f0.a q(boolean paramBoolean)
  {
    try
    {
      f0.a locala = this.d.h(paramBoolean);
      if (locala == null) {
        return locala;
      }
      locala.k(this);
      return locala;
    }
    catch (IOException localIOException)
    {
      this.b.w(this.a, localIOException);
      t(localIOException);
      throw localIOException;
    }
  }
  
  public final void r(f0 paramf0)
  {
    a9.f.f(paramf0, "response");
    this.b.x(this.a, paramf0);
  }
  
  public final void s()
  {
    this.b.y(this.a);
  }
  
  public final void u(d0 paramd0)
  {
    a9.f.f(paramd0, "request");
    try
    {
      this.b.t(this.a);
      this.d.d(paramd0);
      this.b.s(this.a, paramd0);
      return;
    }
    catch (IOException paramd0)
    {
      this.b.r(this.a, paramd0);
      t(paramd0);
      throw paramd0;
    }
  }
  
  private final class a
    extends aa.f
  {
    private final long b;
    private boolean c;
    private long d;
    private boolean e;
    
    public a(long paramLong)
    {
      super();
      Object localObject;
      this.b = localObject;
    }
    
    private final <E extends IOException> E a(E paramE)
    {
      if (this.c) {
        return paramE;
      }
      this.c = true;
      return c.this.a(this.d, false, true, paramE);
    }
    
    public void L(b paramb, long paramLong)
    {
      a9.f.f(paramb, "source");
      if ((this.e ^ true))
      {
        long l = this.b;
        if ((l != -1L) && (this.d + paramLong > l))
        {
          paramb = new StringBuilder();
          paramb.append("expected ");
          paramb.append(this.b);
          paramb.append(" bytes but received ");
          paramb.append(this.d + paramLong);
          throw new ProtocolException(paramb.toString());
        }
        try
        {
          super.L(paramb, paramLong);
          this.d += paramLong;
          return;
        }
        catch (IOException paramb)
        {
          throw a(paramb);
        }
      }
      throw new IllegalStateException("closed".toString());
    }
    
    public void close()
    {
      if (this.e) {
        return;
      }
      this.e = true;
      long l = this.b;
      if ((l != -1L) && (this.d != l)) {
        throw new ProtocolException("unexpected end of stream");
      }
      try
      {
        super.close();
        a(null);
        return;
      }
      catch (IOException localIOException)
      {
        throw a(localIOException);
      }
    }
    
    public void flush()
    {
      try
      {
        super.flush();
        return;
      }
      catch (IOException localIOException)
      {
        throw a(localIOException);
      }
    }
  }
  
  public final class b
    extends g
  {
    private final long b;
    private long c;
    private boolean d;
    private boolean e;
    private boolean f;
    
    public b(long paramLong)
    {
      super();
      Object localObject;
      this.b = localObject;
      this.d = true;
      if (localObject == 0L) {
        g(null);
      }
    }
    
    public void close()
    {
      if (this.f) {
        return;
      }
      this.f = true;
      try
      {
        super.close();
        g(null);
        return;
      }
      catch (IOException localIOException)
      {
        throw g(localIOException);
      }
    }
    
    public final <E extends IOException> E g(E paramE)
    {
      if (this.e) {
        return paramE;
      }
      this.e = true;
      if ((paramE == null) && (this.d))
      {
        this.d = false;
        c.this.i().v(c.this.g());
      }
      return c.this.a(this.c, true, false, paramE);
    }
    
    public long k(b paramb, long paramLong)
    {
      a9.f.f(paramb, "sink");
      if ((this.f ^ true)) {
        try
        {
          paramLong = a().k(paramb, paramLong);
          if (this.d)
          {
            this.d = false;
            c.this.i().v(c.this.g());
          }
          if (paramLong == -1L)
          {
            g(null);
            return -1L;
          }
          long l1 = this.c + paramLong;
          long l2 = this.b;
          if ((l2 != -1L) && (l1 > l2))
          {
            paramb = new StringBuilder();
            paramb.append("expected ");
            paramb.append(this.b);
            paramb.append(" bytes but received ");
            paramb.append(l1);
            throw new ProtocolException(paramb.toString());
          }
          this.c = l1;
          if (l1 == l2) {
            g(null);
          }
          return paramLong;
        }
        catch (IOException paramb)
        {
          throw g(paramb);
        }
      }
      throw new IllegalStateException("closed".toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.c
 * JD-Core Version:    0.7.0.1
 */