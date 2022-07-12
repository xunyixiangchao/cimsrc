package r9;

import aa.v;
import java.io.IOException;
import java.net.ProtocolException;
import l9.d0;
import l9.e0;
import l9.f0;
import l9.f0.a;
import l9.g0;
import l9.y;
import l9.y.a;
import m9.o;
import q9.c;
import q9.i;

public final class b
  implements y
{
  private final boolean a;
  
  public b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public f0 a(y.a parama)
  {
    a9.f.f(parama, "chain");
    parama = (g)parama;
    c localc = parama.f();
    a9.f.c(localc);
    d0 locald0 = parama.i();
    e0 locale0 = locald0.a();
    long l = System.currentTimeMillis();
    Object localObject3 = null;
    Object localObject1;
    int i;
    Object localObject2;
    int k;
    int j;
    try
    {
      localc.u(locald0);
      if ((f.a(locald0.g())) && (locale0 != null))
      {
        if (f9.l.l("100-continue", locald0.d("Expect"), true))
        {
          localc.f();
          localObject1 = localc.q(true);
          try
          {
            localc.s();
            i = 0;
          }
          catch (IOException parama)
          {
            break label348;
          }
        }
        else
        {
          localObject1 = null;
          i = 1;
        }
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          k = i;
        }
      }
      try
      {
        if (locale0.e())
        {
          localObject2 = localObject1;
          k = i;
          localc.f();
          localObject2 = localObject1;
          k = i;
          locale0.g(aa.l.a(localc.c(locald0, true)));
          parama = (y.a)localObject1;
          j = i;
        }
        else
        {
          localObject2 = localObject1;
          k = i;
          parama = aa.l.a(localc.c(locald0, false));
          localObject2 = localObject1;
          k = i;
          locale0.g(parama);
          localObject2 = localObject1;
          k = i;
          parama.close();
          parama = (y.a)localObject1;
          j = i;
          break label294;
          localObject2 = localObject1;
          k = i;
          localc.o();
          parama = (y.a)localObject1;
          j = i;
          localObject2 = localObject1;
          k = i;
          if (!localc.h().q())
          {
            localObject2 = localObject1;
            k = i;
            localc.n();
            parama = (y.a)localObject1;
            j = i;
            break label294;
            localc.o();
            parama = null;
            j = 1;
          }
        }
        label294:
        if (locale0 != null)
        {
          localObject2 = parama;
          k = j;
          if (locale0.e()) {}
        }
        else
        {
          localObject2 = parama;
          k = j;
          localc.e();
        }
        localObject2 = null;
        localObject1 = parama;
      }
      catch (IOException parama)
      {
        localObject1 = localObject2;
        j = k;
      }
      label348:
      if ((parama instanceof t9.a)) {
        break label743;
      }
    }
    catch (IOException parama)
    {
      localObject1 = null;
      j = 1;
    }
    if (localc.k())
    {
      localObject2 = parama;
      parama = (y.a)localObject1;
      i = j;
      if (localObject1 != null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = localc.q(false);
        a9.f.c(localObject1);
        parama = (y.a)localObject1;
        i = j;
        if (j != 0)
        {
          localc.s();
          i = 0;
          parama = (y.a)localObject1;
        }
        parama = parama.q(locald0).h(localc.h().m()).r(l).p(System.currentTimeMillis()).c();
        k = parama.B();
        j = k;
        if (k == 100)
        {
          parama = localc.q(false);
          a9.f.c(parama);
          if (i != 0) {
            localc.s();
          }
          parama = parama.q(locald0).h(localc.h().m()).r(l).p(System.currentTimeMillis()).c();
          j = parama.B();
        }
        localc.r(parama);
        if ((this.a) && (j == 101))
        {
          parama = parama.m0().b(o.c);
          parama = parama.c();
        }
        else
        {
          parama = parama.m0().b(localc.p(parama));
          continue;
        }
        if ((!f9.l.l("close", parama.q0().d("Connection"), true)) && (!f9.l.l("close", f0.h0(parama, "Connection", null, 2, null), true))) {
          break label745;
        }
        localc.n();
      }
      catch (IOException parama)
      {
        if (localObject2 == null) {
          continue;
        }
        o8.a.a((Throwable)localObject2, parama);
        throw ((Throwable)localObject2);
        throw parama;
      }
      localObject1 = parama.a();
      if (localObject1 == null) {
        l = -1L;
      } else {
        l = ((g0)localObject1).i();
      }
      if (l > 0L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("HTTP ");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(" had non-zero Content-Length: ");
        parama = parama.a();
        if (parama == null) {
          parama = localObject3;
        } else {
          parama = Long.valueOf(parama.i());
        }
        ((StringBuilder)localObject1).append(parama);
        throw new ProtocolException(((StringBuilder)localObject1).toString());
      }
      return parama;
      throw parama;
      label743:
      throw parama;
      label745:
      if (j != 204) {
        if (j != 205) {}
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r9.b
 * JD-Core Version:    0.7.0.1
 */