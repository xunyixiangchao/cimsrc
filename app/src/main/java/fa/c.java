package fa;

import b8.a;
import b8.b;
import l9.g0;
import v7.m;
import v7.v;

final class c<T>
  implements ea.f<g0, T>
{
  private final v7.f a;
  private final v<T> b;
  
  c(v7.f paramf, v<T> paramv)
  {
    this.a = paramf;
    this.b = paramv;
  }
  
  public T a(g0 paramg0)
  {
    Object localObject3 = this.a.o(paramg0.g());
    try
    {
      Object localObject1 = this.b.b((a)localObject3);
      localObject3 = ((a)localObject3).u0();
      b localb = b.j;
      if (localObject3 == localb) {
        return localObject1;
      }
      throw new m("JSON document was not fully consumed.");
    }
    finally
    {
      paramg0.close();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     fa.c
 * JD-Core Version:    0.7.0.1
 */