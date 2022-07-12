package r9;

import a9.f;
import aa.i;
import aa.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import l9.d0;
import l9.d0.a;
import l9.e0;
import l9.f0;
import l9.f0.a;
import l9.g0;
import l9.p;
import l9.w;
import l9.w.a;
import l9.y;
import l9.y.a;
import l9.z;

public final class a
  implements y
{
  private final p a;
  
  public a(p paramp)
  {
    this.a = paramp;
  }
  
  private final String b(List<l9.o> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        p8.l.p();
      }
      localObject = (l9.o)localObject;
      if (i > 0) {
        localStringBuilder.append("; ");
      }
      localStringBuilder.append(((l9.o)localObject).i());
      localStringBuilder.append('=');
      localStringBuilder.append(((l9.o)localObject).n());
      i += 1;
    }
    paramList = localStringBuilder.toString();
    f.e(paramList, "StringBuilder().apply(builderAction).toString()");
    return paramList;
  }
  
  public f0 a(y.a parama)
  {
    f.f(parama, "chain");
    Object localObject1 = parama.h();
    Object localObject2 = ((d0)localObject1).h();
    Object localObject3 = ((d0)localObject1).a();
    if (localObject3 != null)
    {
      z localz = ((e0)localObject3).b();
      if (localz != null) {
        ((d0.a)localObject2).e("Content-Type", localz.toString());
      }
      long l = ((e0)localObject3).a();
      if (l != -1L)
      {
        ((d0.a)localObject2).e("Content-Length", String.valueOf(l));
        ((d0.a)localObject2).h("Transfer-Encoding");
      }
      else
      {
        ((d0.a)localObject2).e("Transfer-Encoding", "chunked");
        ((d0.a)localObject2).h("Content-Length");
      }
    }
    localObject3 = ((d0)localObject1).d("Host");
    int j = 0;
    if (localObject3 == null) {
      ((d0.a)localObject2).e("Host", m9.o.t(((d0)localObject1).j(), false, 1, null));
    }
    if (((d0)localObject1).d("Connection") == null) {
      ((d0.a)localObject2).e("Connection", "Keep-Alive");
    }
    int i = j;
    if (((d0)localObject1).d("Accept-Encoding") == null)
    {
      i = j;
      if (((d0)localObject1).d("Range") == null)
      {
        ((d0.a)localObject2).e("Accept-Encoding", "gzip");
        i = 1;
      }
    }
    localObject3 = this.a.a(((d0)localObject1).j());
    if ((((Collection)localObject3).isEmpty() ^ true)) {
      ((d0.a)localObject2).e("Cookie", b((List)localObject3));
    }
    if (((d0)localObject1).d("User-Agent") == null) {
      ((d0.a)localObject2).e("User-Agent", "okhttp/5.0.0-alpha.6");
    }
    localObject1 = ((d0.a)localObject2).b();
    parama = parama.a((d0)localObject1);
    e.f(this.a, ((d0)localObject1).j(), parama.i0());
    localObject1 = parama.m0().q((d0)localObject1);
    if ((i != 0) && (f9.l.l("gzip", f0.h0(parama, "Content-Encoding", null, 2, null), true)) && (e.b(parama)))
    {
      localObject2 = parama.a();
      if (localObject2 != null)
      {
        localObject2 = new i(((g0)localObject2).e0());
        ((f0.a)localObject1).j(parama.i0().d().h("Content-Encoding").h("Content-Length").f());
        ((f0.a)localObject1).b(new h(f0.h0(parama, "Content-Type", null, 2, null), -1L, aa.l.b((x)localObject2)));
      }
    }
    return ((f0.a)localObject1).c();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r9.a
 * JD-Core Version:    0.7.0.1
 */