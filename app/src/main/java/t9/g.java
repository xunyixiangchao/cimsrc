package t9;

import aa.v;
import aa.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import l9.b0;
import l9.c0;
import l9.d0;
import l9.f0;
import l9.f0.a;
import l9.w;
import l9.w.a;
import m9.o;
import r9.d;
import r9.d.a;
import r9.e;
import r9.k;
import r9.k.a;

public final class g
  implements d
{
  public static final a g = new a(null);
  private static final List<String> h = o.k(new String[] { "connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority" });
  private static final List<String> i = o.k(new String[] { "connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade" });
  private final d.a a;
  private final r9.g b;
  private final f c;
  private volatile i d;
  private final c0 e;
  private volatile boolean f;
  
  public g(b0 paramb0, d.a parama, r9.g paramg, f paramf)
  {
    this.a = parama;
    this.b = paramg;
    this.c = paramf;
    parama = paramb0.A();
    paramb0 = c0.g;
    if (!parama.contains(paramb0)) {
      paramb0 = c0.f;
    }
    this.e = paramb0;
  }
  
  public long a(f0 paramf0)
  {
    a9.f.f(paramf0, "response");
    if (!e.b(paramf0)) {
      return 0L;
    }
    return o.j(paramf0);
  }
  
  public v b(d0 paramd0, long paramLong)
  {
    a9.f.f(paramd0, "request");
    paramd0 = this.d;
    a9.f.c(paramd0);
    return paramd0.n();
  }
  
  public void c()
  {
    i locali = this.d;
    a9.f.c(locali);
    locali.n().close();
  }
  
  public void cancel()
  {
    this.f = true;
    i locali = this.d;
    if (locali == null) {
      return;
    }
    locali.f(b.k);
  }
  
  public void d(d0 paramd0)
  {
    a9.f.f(paramd0, "request");
    if (this.d != null) {
      return;
    }
    boolean bool;
    if (paramd0.a() != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramd0 = g.a(paramd0);
    this.d = this.c.H0(paramd0, bool);
    if (!this.f)
    {
      paramd0 = this.d;
      a9.f.c(paramd0);
      Object localObject = paramd0.v();
      long l = this.b.g();
      paramd0 = TimeUnit.MILLISECONDS;
      ((y)localObject).g(l, paramd0);
      localObject = this.d;
      a9.f.c(localObject);
      ((i)localObject).G().g(this.b.j(), paramd0);
      return;
    }
    paramd0 = this.d;
    a9.f.c(paramd0);
    paramd0.f(b.k);
    throw new IOException("Canceled");
  }
  
  public void e()
  {
    this.c.flush();
  }
  
  public d.a f()
  {
    return this.a;
  }
  
  public aa.x g(f0 paramf0)
  {
    a9.f.f(paramf0, "response");
    paramf0 = this.d;
    a9.f.c(paramf0);
    return paramf0.p();
  }
  
  public f0.a h(boolean paramBoolean)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((i)localObject).E();
      f0.a locala = g.b((w)localObject, this.e);
      localObject = locala;
      if (paramBoolean)
      {
        localObject = locala;
        if (locala.f() == 100) {
          localObject = null;
        }
      }
      return localObject;
    }
    throw new IOException("stream wasn't created");
  }
  
  public static final class a
  {
    public final List<c> a(d0 paramd0)
    {
      a9.f.f(paramd0, "request");
      w localw = paramd0.e();
      ArrayList localArrayList = new ArrayList(localw.size() + 4);
      localArrayList.add(new c(c.g, paramd0.g()));
      localArrayList.add(new c(c.h, r9.i.a.c(paramd0.j())));
      Object localObject = paramd0.d("Host");
      if (localObject != null) {
        localArrayList.add(new c(c.j, (String)localObject));
      }
      localArrayList.add(new c(c.i, paramd0.j().r()));
      int i = 0;
      int j = localw.size();
      while (i < j)
      {
        paramd0 = localw.c(i);
        localObject = Locale.US;
        a9.f.e(localObject, "US");
        paramd0 = paramd0.toLowerCase((Locale)localObject);
        a9.f.e(paramd0, "this as java.lang.String).toLowerCase(locale)");
        if ((!g.i().contains(paramd0)) || ((a9.f.a(paramd0, "te")) && (a9.f.a(localw.f(i), "trailers")))) {
          localArrayList.add(new c(paramd0, localw.f(i)));
        }
        i += 1;
      }
      return localArrayList;
    }
    
    public final f0.a b(w paramw, c0 paramc0)
    {
      a9.f.f(paramw, "headerBlock");
      a9.f.f(paramc0, "protocol");
      w.a locala = new w.a();
      int j = paramw.size();
      Object localObject1 = null;
      int i = 0;
      while (i < j)
      {
        String str1 = paramw.c(i);
        String str2 = paramw.f(i);
        Object localObject2;
        if (a9.f.a(str1, ":status"))
        {
          localObject2 = k.d.a(a9.f.m("HTTP/1.1 ", str2));
        }
        else
        {
          localObject2 = localObject1;
          if (!g.j().contains(str1))
          {
            locala.d(str1, str2);
            localObject2 = localObject1;
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      if (localObject1 != null) {
        return new f0.a().o(paramc0).e(localObject1.b).l(localObject1.c).j(locala.f());
      }
      throw new ProtocolException("Expected ':status' header not present");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t9.g
 * JD-Core Version:    0.7.0.1
 */