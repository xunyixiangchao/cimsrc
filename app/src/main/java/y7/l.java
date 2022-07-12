package y7;

import b8.c;
import v7.f;
import v7.j;
import v7.k;
import v7.r;
import v7.s;
import v7.v;
import v7.w;

public final class l<T>
  extends v<T>
{
  private final s<T> a;
  private final k<T> b;
  final f c;
  private final com.google.gson.reflect.a<T> d;
  private final w e;
  private final l<T>.b f = new b(null);
  private v<T> g;
  
  public l(s<T> params, k<T> paramk, f paramf, com.google.gson.reflect.a<T> parama, w paramw)
  {
    this.a = params;
    this.b = paramk;
    this.c = paramf;
    this.d = parama;
    this.e = paramw;
  }
  
  private v<T> e()
  {
    v localv = this.g;
    if (localv != null) {
      return localv;
    }
    localv = this.c.m(this.e, this.d);
    this.g = localv;
    return localv;
  }
  
  public T b(b8.a parama)
  {
    if (this.b == null) {
      return e().b(parama);
    }
    parama = x7.l.a(parama);
    if (parama.e()) {
      return null;
    }
    return this.b.a(parama, this.d.getType(), this.f);
  }
  
  public void d(c paramc, T paramT)
  {
    s locals = this.a;
    if (locals == null)
    {
      e().d(paramc, paramT);
      return;
    }
    if (paramT == null)
    {
      paramc.k0();
      return;
    }
    x7.l.b(locals.a(paramT, this.d.getType(), this.f), paramc);
  }
  
  private final class b
    implements r, j
  {
    private b() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.l
 * JD-Core Version:    0.7.0.1
 */