package s9;

import a9.f;
import aa.c;
import aa.h;
import aa.v;
import aa.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;
import l9.b0;
import l9.d0;
import l9.e0;
import l9.f0;
import l9.f0.a;
import l9.h0;
import l9.p;
import l9.w;
import m9.o;
import r9.d.a;
import r9.e;
import r9.i;
import r9.k;
import r9.k.a;

public final class b
  implements r9.d
{
  public static final d h = new d(null);
  private final b0 a;
  private final d.a b;
  private final aa.d c;
  private final c d;
  private int e;
  private final a f;
  private w g;
  
  public b(b0 paramb0, d.a parama, aa.d paramd, c paramc)
  {
    this.a = paramb0;
    this.b = parama;
    this.c = paramd;
    this.d = paramc;
    this.f = new a(paramd);
  }
  
  private final void r(h paramh)
  {
    y localy = paramh.i();
    paramh.j(y.e);
    localy.a();
    localy.b();
  }
  
  private final boolean s(d0 paramd0)
  {
    return f9.l.l("chunked", paramd0.d("Transfer-Encoding"), true);
  }
  
  private final boolean t(f0 paramf0)
  {
    return f9.l.l("chunked", f0.h0(paramf0, "Transfer-Encoding", null, 2, null), true);
  }
  
  private final v u()
  {
    int j = this.e;
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i != 0)
    {
      this.e = 2;
      return new b();
    }
    throw new IllegalStateException(f.m("state: ", Integer.valueOf(j)).toString());
  }
  
  private final aa.x v(l9.x paramx)
  {
    int j = this.e;
    int i;
    if (j == 4) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.e = 5;
      return new c(paramx);
    }
    throw new IllegalStateException(f.m("state: ", Integer.valueOf(j)).toString());
  }
  
  private final aa.x w(long paramLong)
  {
    int j = this.e;
    int i;
    if (j == 4) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.e = 5;
      return new e(paramLong);
    }
    throw new IllegalStateException(f.m("state: ", Integer.valueOf(j)).toString());
  }
  
  private final v x()
  {
    int j = this.e;
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i != 0)
    {
      this.e = 2;
      return new f();
    }
    throw new IllegalStateException(f.m("state: ", Integer.valueOf(j)).toString());
  }
  
  private final aa.x y()
  {
    int j = this.e;
    int i;
    if (j == 4) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.e = 5;
      f().h();
      return new g();
    }
    throw new IllegalStateException(f.m("state: ", Integer.valueOf(j)).toString());
  }
  
  public final void A(w paramw, String paramString)
  {
    f.f(paramw, "headers");
    f.f(paramString, "requestLine");
    int k = this.e;
    int j = 0;
    int i;
    if (k == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.d.V(paramString).V("\r\n");
      k = paramw.size();
      i = j;
      while (i < k)
      {
        this.d.V(paramw.c(i)).V(": ").V(paramw.f(i)).V("\r\n");
        i += 1;
      }
      this.d.V("\r\n");
      this.e = 1;
      return;
    }
    throw new IllegalStateException(f.m("state: ", Integer.valueOf(k)).toString());
  }
  
  public long a(f0 paramf0)
  {
    f.f(paramf0, "response");
    if (!e.b(paramf0)) {
      return 0L;
    }
    if (t(paramf0)) {
      return -1L;
    }
    return o.j(paramf0);
  }
  
  public v b(d0 paramd0, long paramLong)
  {
    f.f(paramd0, "request");
    if ((paramd0.a() != null) && (paramd0.a().e())) {
      throw new ProtocolException("Duplex connections are not supported for HTTP/1");
    }
    if (s(paramd0)) {
      return u();
    }
    if (paramLong != -1L) {
      return x();
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public void c()
  {
    this.d.flush();
  }
  
  public void cancel()
  {
    f().cancel();
  }
  
  public void d(d0 paramd0)
  {
    f.f(paramd0, "request");
    Object localObject = i.a;
    Proxy.Type localType = f().e().b().type();
    f.e(localType, "carrier.route.proxy.type()");
    localObject = ((i)localObject).a(paramd0, localType);
    A(paramd0.e(), (String)localObject);
  }
  
  public void e()
  {
    this.d.flush();
  }
  
  public d.a f()
  {
    return this.b;
  }
  
  public aa.x g(f0 paramf0)
  {
    f.f(paramf0, "response");
    long l;
    if (!e.b(paramf0)) {
      l = 0L;
    }
    do
    {
      return w(l);
      if (t(paramf0)) {
        return v(paramf0.q0().j());
      }
      l = o.j(paramf0);
    } while (l != -1L);
    return y();
  }
  
  public f0.a h(boolean paramBoolean)
  {
    int k = this.e;
    int j = 1;
    int i = j;
    if (k != 1)
    {
      i = j;
      if (k != 2) {
        if (k == 3) {
          i = j;
        } else {
          i = 0;
        }
      }
    }
    if (i != 0) {
      try
      {
        k localk = k.d.a(this.f.b());
        f0.a locala = new f0.a().o(localk.a).e(localk.b).l(localk.c).j(this.f.a());
        if ((paramBoolean) && (localk.b == 100)) {
          return null;
        }
        if (localk.b == 100)
        {
          this.e = 3;
          return locala;
        }
        this.e = 4;
        return locala;
      }
      catch (EOFException localEOFException)
      {
        throw new IOException(f.m("unexpected end of stream on ", f().e().a().l().p()), localEOFException);
      }
    }
    throw new IllegalStateException(f.m("state: ", Integer.valueOf(k)).toString());
  }
  
  public final void z(f0 paramf0)
  {
    f.f(paramf0, "response");
    long l = o.j(paramf0);
    if (l == -1L) {
      return;
    }
    paramf0 = w(l);
    o.n(paramf0, 2147483647, TimeUnit.MILLISECONDS);
    paramf0.close();
  }
  
  private abstract class a
    implements aa.x
  {
    private final h a;
    private boolean b;
    
    public a()
    {
      this.a = new h(b.m(this$1).c());
    }
    
    protected final boolean a()
    {
      return this.b;
    }
    
    public y c()
    {
      return this.a;
    }
    
    public final void g()
    {
      if (b.n(this.c) == 6) {
        return;
      }
      if (b.n(this.c) == 5)
      {
        b.i(this.c, this.a);
        b.p(this.c, 6);
        return;
      }
      throw new IllegalStateException(f.m("state: ", Integer.valueOf(b.n(this.c))));
    }
    
    protected final void h(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public long k(aa.b paramb, long paramLong)
    {
      f.f(paramb, "sink");
      try
      {
        paramLong = b.m(this.c).k(paramb, paramLong);
        return paramLong;
      }
      catch (IOException paramb)
      {
        this.c.f().h();
        g();
        throw paramb;
      }
    }
  }
  
  private final class b
    implements v
  {
    private final h a;
    private boolean b;
    
    public b()
    {
      this.a = new h(b.l(this$1).c());
    }
    
    public void L(aa.b paramb, long paramLong)
    {
      f.f(paramb, "source");
      if ((this.b ^ true))
      {
        if (paramLong == 0L) {
          return;
        }
        b.l(this.c).l(paramLong);
        b.l(this.c).V("\r\n");
        b.l(this.c).L(paramb, paramLong);
        b.l(this.c).V("\r\n");
        return;
      }
      throw new IllegalStateException("closed".toString());
    }
    
    public y c()
    {
      return this.a;
    }
    
    public void close()
    {
      try
      {
        boolean bool = this.b;
        if (bool) {
          return;
        }
        this.b = true;
        b.l(this.c).V("0\r\n\r\n");
        b.i(this.c, this.a);
        b.p(this.c, 3);
        return;
      }
      finally {}
    }
    
    public void flush()
    {
      try
      {
        boolean bool = this.b;
        if (bool) {
          return;
        }
        b.l(this.c).flush();
        return;
      }
      finally {}
    }
  }
  
  private final class c
    extends b.a
  {
    private final l9.x d;
    private long e;
    private boolean f;
    
    public c()
    {
      super();
      this.d = localObject;
      this.e = -1L;
      this.f = true;
    }
    
    private final void i()
    {
      if (this.e != -1L) {
        b.m(b.this).z();
      }
      for (;;)
      {
        try
        {
          this.e = b.m(b.this).b0();
          Object localObject1 = f9.l.o0(b.m(b.this).z()).toString();
          if (this.e >= 0L)
          {
            if (((CharSequence)localObject1).length() <= 0) {
              break label248;
            }
            i = 1;
            if (i != 0)
            {
              boolean bool = f9.l.x((String)localObject1, ";", false, 2, null);
              if (!bool) {}
            }
            else
            {
              if (this.e == 0L)
              {
                this.f = false;
                localObject1 = b.this;
                b.q((b)localObject1, b.k((b)localObject1).a());
                localObject1 = b.j(b.this);
                f.c(localObject1);
                localObject1 = ((b0)localObject1).n();
                localObject2 = this.d;
                w localw = b.o(b.this);
                f.c(localw);
                e.f((p)localObject1, (l9.x)localObject2, localw);
                g();
              }
              return;
            }
          }
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("expected chunk size and optional extensions but was \"");
          ((StringBuilder)localObject2).append(this.e);
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append('"');
          throw new ProtocolException(((StringBuilder)localObject2).toString());
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw new ProtocolException(localNumberFormatException.getMessage());
        }
        label248:
        int i = 0;
      }
    }
    
    public void close()
    {
      if (a()) {
        return;
      }
      if ((this.f) && (!o.h(this, 100, TimeUnit.MILLISECONDS)))
      {
        b.this.f().h();
        g();
      }
      h(true);
    }
    
    public long k(aa.b paramb, long paramLong)
    {
      f.f(paramb, "sink");
      int i;
      if (paramLong >= 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((a() ^ true))
        {
          if (!this.f) {
            return -1L;
          }
          long l = this.e;
          if ((l == 0L) || (l == -1L))
          {
            i();
            if (!this.f) {
              return -1L;
            }
          }
          paramLong = super.k(paramb, Math.min(paramLong, this.e));
          if (paramLong != -1L)
          {
            this.e -= paramLong;
            return paramLong;
          }
          b.this.f().h();
          paramb = new ProtocolException("unexpected end of stream");
          g();
          throw paramb;
        }
        throw new IllegalStateException("closed".toString());
      }
      throw new IllegalArgumentException(f.m("byteCount < 0: ", Long.valueOf(paramLong)).toString());
    }
  }
  
  public static final class d {}
  
  private final class e
    extends b.a
  {
    private long d;
    
    public e()
    {
      super();
      Object localObject;
      this.d = localObject;
      if (localObject == 0L) {
        g();
      }
    }
    
    public void close()
    {
      if (a()) {
        return;
      }
      if ((this.d != 0L) && (!o.h(this, 100, TimeUnit.MILLISECONDS)))
      {
        b.this.f().h();
        g();
      }
      h(true);
    }
    
    public long k(aa.b paramb, long paramLong)
    {
      f.f(paramb, "sink");
      int i;
      if (paramLong >= 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((a() ^ true))
        {
          long l = this.d;
          if (l == 0L) {
            return -1L;
          }
          paramLong = super.k(paramb, Math.min(l, paramLong));
          if (paramLong != -1L)
          {
            l = this.d - paramLong;
            this.d = l;
            if (l == 0L) {
              g();
            }
            return paramLong;
          }
          b.this.f().h();
          paramb = new ProtocolException("unexpected end of stream");
          g();
          throw paramb;
        }
        throw new IllegalStateException("closed".toString());
      }
      throw new IllegalArgumentException(f.m("byteCount < 0: ", Long.valueOf(paramLong)).toString());
    }
  }
  
  private final class f
    implements v
  {
    private final h a;
    private boolean b;
    
    public f()
    {
      this.a = new h(b.l(this$1).c());
    }
    
    public void L(aa.b paramb, long paramLong)
    {
      f.f(paramb, "source");
      if ((this.b ^ true))
      {
        m9.l.e(paramb.z0(), 0L, paramLong);
        b.l(this.c).L(paramb, paramLong);
        return;
      }
      throw new IllegalStateException("closed".toString());
    }
    
    public y c()
    {
      return this.a;
    }
    
    public void close()
    {
      if (this.b) {
        return;
      }
      this.b = true;
      b.i(this.c, this.a);
      b.p(this.c, 3);
    }
    
    public void flush()
    {
      if (this.b) {
        return;
      }
      b.l(this.c).flush();
    }
  }
  
  private final class g
    extends b.a
  {
    private boolean d;
    
    public g()
    {
      super();
    }
    
    public void close()
    {
      if (a()) {
        return;
      }
      if (!this.d) {
        g();
      }
      h(true);
    }
    
    public long k(aa.b paramb, long paramLong)
    {
      f.f(paramb, "sink");
      int i;
      if (paramLong >= 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((a() ^ true))
        {
          if (this.d) {
            return -1L;
          }
          paramLong = super.k(paramb, paramLong);
          if (paramLong == -1L)
          {
            this.d = true;
            g();
            return -1L;
          }
          return paramLong;
        }
        throw new IllegalStateException("closed".toString());
      }
      throw new IllegalArgumentException(f.m("byteCount < 0: ", Long.valueOf(paramLong)).toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s9.b
 * JD-Core Version:    0.7.0.1
 */