package o9;

import a9.f;
import java.io.Closeable;
import l9.c;
import l9.c0;
import l9.d0;
import l9.e;
import l9.f0;
import l9.f0.a;
import l9.g0;
import l9.t;
import l9.w;
import l9.w.a;
import l9.y;
import l9.y.a;
import m9.o;
import q9.h;

public final class a
  implements y
{
  public static final a a = new a(null);
  
  public a(c paramc) {}
  
  public f0 a(y.a parama)
  {
    f.f(parama, "chain");
    e locale = parama.call();
    Object localObject1 = new b.b(System.currentTimeMillis(), parama.h(), null).b();
    d0 locald0 = ((b)localObject1).b();
    f0 localf0 = ((b)localObject1).a();
    if ((locale instanceof h)) {
      localObject1 = (h)locale;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((h)localObject1).o();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = t.b;
    }
    if ((locald0 == null) && (localf0 == null))
    {
      parama = new f0.a().q(parama.h()).o(c0.d).e(504).l("Unsatisfiable Request (only-if-cached)").b(o.c).r(-1L).p(System.currentTimeMillis()).c();
      ((t)localObject2).z(locale, parama);
      return parama;
    }
    if (locald0 == null)
    {
      f.c(localf0);
      parama = localf0.m0().d(a.b(a, localf0)).c();
      ((t)localObject2).b(locale, parama);
      return parama;
    }
    if (localf0 != null) {
      ((t)localObject2).a(locale, localf0);
    }
    try
    {
      parama = parama.a(locald0);
      if (localf0 != null)
      {
        int i = 0;
        if ((parama != null) && (parama.B() == 304)) {
          i = 1;
        }
        if (i == 0)
        {
          localObject1 = localf0.a();
          if (localObject1 != null) {
            m9.l.f((Closeable)localObject1);
          }
        }
        else
        {
          localObject1 = localf0.m0();
          localObject2 = a;
          ((f0.a)localObject1).j(a.a((a)localObject2, localf0.i0(), parama.i0())).r(parama.r0()).p(parama.p0()).d(a.b((a)localObject2, localf0)).m(a.b((a)localObject2, parama)).c();
          parama = parama.a();
          f.c(parama);
          parama.close();
          f.c(null);
          throw null;
        }
      }
      f.c(parama);
      localObject1 = parama.m0();
      localObject2 = a;
      return ((f0.a)localObject1).d(a.b((a)localObject2, localf0)).m(a.b((a)localObject2, parama)).c();
    }
    finally {}
  }
  
  public static final class a
  {
    private final w c(w paramw1, w paramw2)
    {
      w.a locala = new w.a();
      int k = paramw1.size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        String str1 = paramw1.c(i);
        String str2 = paramw1.f(i);
        if (((!f9.l.l("Warning", str1, true)) || (!f9.l.x(str2, "1", false, 2, null))) && ((d(str1)) || (!e(str1)) || (paramw2.a(str1) == null))) {
          locala.d(str1, str2);
        }
        i += 1;
      }
      k = paramw2.size();
      i = j;
      while (i < k)
      {
        paramw1 = paramw2.c(i);
        if ((!d(paramw1)) && (e(paramw1))) {
          locala.d(paramw1, paramw2.f(i));
        }
        i += 1;
      }
      return locala.f();
    }
    
    private final boolean d(String paramString)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (!f9.l.l("Content-Length", paramString, true))
      {
        bool1 = bool2;
        if (!f9.l.l("Content-Encoding", paramString, true))
        {
          if (f9.l.l("Content-Type", paramString, true)) {
            return true;
          }
          bool1 = false;
        }
      }
      return bool1;
    }
    
    private final boolean e(String paramString)
    {
      return (!f9.l.l("Connection", paramString, true)) && (!f9.l.l("Keep-Alive", paramString, true)) && (!f9.l.l("Proxy-Authenticate", paramString, true)) && (!f9.l.l("Proxy-Authorization", paramString, true)) && (!f9.l.l("TE", paramString, true)) && (!f9.l.l("Trailers", paramString, true)) && (!f9.l.l("Transfer-Encoding", paramString, true)) && (!f9.l.l("Upgrade", paramString, true));
    }
    
    private final f0 f(f0 paramf0)
    {
      g0 localg0;
      if (paramf0 == null) {
        localg0 = null;
      } else {
        localg0 = paramf0.a();
      }
      f0 localf0 = paramf0;
      if (localg0 != null) {
        localf0 = paramf0.m0().b(null).c();
      }
      return localf0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o9.a
 * JD-Core Version:    0.7.0.1
 */