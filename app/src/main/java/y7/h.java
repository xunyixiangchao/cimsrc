package y7;

import b8.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import v7.f;
import v7.v;
import v7.w;

public final class h
  extends v<Object>
{
  public static final w b = new a();
  private final f a;
  
  h(f paramf)
  {
    this.a = paramf;
  }
  
  public Object b(b8.a parama)
  {
    Object localObject = parama.u0();
    switch (b.a[localObject.ordinal()])
    {
    default: 
      throw new IllegalStateException();
    case 6: 
      parama.q0();
      return null;
    case 5: 
      return Boolean.valueOf(parama.k0());
    case 4: 
      return Double.valueOf(parama.l0());
    case 3: 
      return parama.s0();
    case 2: 
      localObject = new x7.h();
      parama.g();
      while (parama.g0()) {
        ((Map)localObject).put(parama.o0(), b(parama));
      }
      parama.e0();
      return localObject;
    }
    localObject = new ArrayList();
    parama.a();
    while (parama.g0()) {
      ((List)localObject).add(b(parama));
    }
    parama.d0();
    return localObject;
  }
  
  public void d(c paramc, Object paramObject)
  {
    if (paramObject == null)
    {
      paramc.k0();
      return;
    }
    v localv = this.a.l(paramObject.getClass());
    if ((localv instanceof h))
    {
      paramc.i();
      paramc.e0();
      return;
    }
    localv.d(paramc, paramObject);
  }
  
  static final class a
    implements w
  {
    public <T> v<T> a(f paramf, com.google.gson.reflect.a<T> parama)
    {
      if (parama.getRawType() == Object.class) {
        return new h(paramf);
      }
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.h
 * JD-Core Version:    0.7.0.1
 */