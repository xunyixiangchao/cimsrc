package l9;

import a9.f;
import java.io.Closeable;
import java.util.List;
import m9.k;
import p8.l;
import q9.c;
import r9.e;

public final class f0
  implements Closeable
{
  private final d0 a;
  private final c0 b;
  private final String c;
  private final int d;
  private final v e;
  private final w f;
  private final g0 g;
  private final f0 h;
  private final f0 i;
  private final f0 j;
  private final long k;
  private final long l;
  private final c m;
  private d n;
  private final boolean o;
  private final boolean p;
  
  public f0(d0 paramd0, c0 paramc0, String paramString, int paramInt, v paramv, w paramw, g0 paramg0, f0 paramf01, f0 paramf02, f0 paramf03, long paramLong1, long paramLong2, c paramc)
  {
    this.a = paramd0;
    this.b = paramc0;
    this.c = paramString;
    this.d = paramInt;
    this.e = paramv;
    this.f = paramw;
    this.g = paramg0;
    this.h = paramf01;
    this.i = paramf02;
    this.j = paramf03;
    this.k = paramLong1;
    this.l = paramLong2;
    this.m = paramc;
    this.o = k.t(this);
    this.p = k.s(this);
  }
  
  public final int B()
  {
    return this.d;
  }
  
  public final g0 a()
  {
    return this.g;
  }
  
  public void close()
  {
    k.f(this);
  }
  
  public final c d0()
  {
    return this.m;
  }
  
  public final d e0()
  {
    return this.n;
  }
  
  public final v f0()
  {
    return this.e;
  }
  
  public final d g()
  {
    return k.r(this);
  }
  
  public final String g0(String paramString1, String paramString2)
  {
    f.f(paramString1, "name");
    return k.h(this, paramString1, paramString2);
  }
  
  public final f0 h()
  {
    return this.i;
  }
  
  public final List<h> i()
  {
    w localw = this.f;
    int i1 = this.d;
    String str;
    if (i1 != 401)
    {
      if (i1 != 407) {
        return l.h();
      }
      str = "Proxy-Authenticate";
    }
    else
    {
      str = "WWW-Authenticate";
    }
    return e.a(localw, str);
  }
  
  public final w i0()
  {
    return this.f;
  }
  
  public final boolean j0()
  {
    return this.o;
  }
  
  public final String k0()
  {
    return this.c;
  }
  
  public final f0 l0()
  {
    return this.h;
  }
  
  public final a m0()
  {
    return k.m(this);
  }
  
  public final f0 n0()
  {
    return this.j;
  }
  
  public final c0 o0()
  {
    return this.b;
  }
  
  public final long p0()
  {
    return this.l;
  }
  
  public final d0 q0()
  {
    return this.a;
  }
  
  public final long r0()
  {
    return this.k;
  }
  
  public final void s0(d paramd)
  {
    this.n = paramd;
  }
  
  public String toString()
  {
    return k.q(this);
  }
  
  public static class a
  {
    private d0 a;
    private c0 b;
    private int c = -1;
    private String d;
    private v e;
    private w.a f;
    private g0 g;
    private f0 h;
    private f0 i;
    private f0 j;
    private long k;
    private long l;
    private c m;
    
    public a()
    {
      this.f = new w.a();
    }
    
    public a(f0 paramf0)
    {
      this.a = paramf0.q0();
      this.b = paramf0.o0();
      this.c = paramf0.B();
      this.d = paramf0.k0();
      this.e = paramf0.f0();
      this.f = paramf0.i0().d();
      this.g = paramf0.a();
      this.h = paramf0.l0();
      this.i = paramf0.h();
      this.j = paramf0.n0();
      this.k = paramf0.r0();
      this.l = paramf0.p0();
      this.m = paramf0.d0();
    }
    
    public final void A(c0 paramc0)
    {
      this.b = paramc0;
    }
    
    public final void B(long paramLong)
    {
      this.l = paramLong;
    }
    
    public final void C(d0 paramd0)
    {
      this.a = paramd0;
    }
    
    public final void D(long paramLong)
    {
      this.k = paramLong;
    }
    
    public a a(String paramString1, String paramString2)
    {
      f.f(paramString1, "name");
      f.f(paramString2, "value");
      return k.c(this, paramString1, paramString2);
    }
    
    public a b(g0 paramg0)
    {
      return k.d(this, paramg0);
    }
    
    public f0 c()
    {
      int i1 = this.c;
      int n;
      if (i1 >= 0) {
        n = 1;
      } else {
        n = 0;
      }
      if (n != 0)
      {
        d0 locald0 = this.a;
        if (locald0 != null)
        {
          c0 localc0 = this.b;
          if (localc0 != null)
          {
            String str = this.d;
            if (str != null) {
              return new f0(locald0, localc0, str, i1, this.e, this.f.f(), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
            }
            throw new IllegalStateException("message == null".toString());
          }
          throw new IllegalStateException("protocol == null".toString());
        }
        throw new IllegalStateException("request == null".toString());
      }
      throw new IllegalStateException(f.m("code < 0: ", Integer.valueOf(f())).toString());
    }
    
    public a d(f0 paramf0)
    {
      return k.e(this, paramf0);
    }
    
    public a e(int paramInt)
    {
      return k.g(this, paramInt);
    }
    
    public final int f()
    {
      return this.c;
    }
    
    public final w.a g()
    {
      return this.f;
    }
    
    public a h(v paramv)
    {
      v(paramv);
      return this;
    }
    
    public a i(String paramString1, String paramString2)
    {
      f.f(paramString1, "name");
      f.f(paramString2, "value");
      return k.i(this, paramString1, paramString2);
    }
    
    public a j(w paramw)
    {
      f.f(paramw, "headers");
      return k.j(this, paramw);
    }
    
    public final void k(c paramc)
    {
      f.f(paramc, "deferredTrailers");
      this.m = paramc;
    }
    
    public a l(String paramString)
    {
      f.f(paramString, "message");
      return k.k(this, paramString);
    }
    
    public a m(f0 paramf0)
    {
      return k.l(this, paramf0);
    }
    
    public a n(f0 paramf0)
    {
      return k.n(this, paramf0);
    }
    
    public a o(c0 paramc0)
    {
      f.f(paramc0, "protocol");
      return k.o(this, paramc0);
    }
    
    public a p(long paramLong)
    {
      B(paramLong);
      return this;
    }
    
    public a q(d0 paramd0)
    {
      f.f(paramd0, "request");
      return k.p(this, paramd0);
    }
    
    public a r(long paramLong)
    {
      D(paramLong);
      return this;
    }
    
    public final void s(g0 paramg0)
    {
      this.g = paramg0;
    }
    
    public final void t(f0 paramf0)
    {
      this.i = paramf0;
    }
    
    public final void u(int paramInt)
    {
      this.c = paramInt;
    }
    
    public final void v(v paramv)
    {
      this.e = paramv;
    }
    
    public final void w(w.a parama)
    {
      f.f(parama, "<set-?>");
      this.f = parama;
    }
    
    public final void x(String paramString)
    {
      this.d = paramString;
    }
    
    public final void y(f0 paramf0)
    {
      this.h = paramf0;
    }
    
    public final void z(f0 paramf0)
    {
      this.j = paramf0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.f0
 * JD-Core Version:    0.7.0.1
 */