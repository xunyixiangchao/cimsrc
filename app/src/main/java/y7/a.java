package y7;

import b8.c;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;
import v7.f;
import v7.v;
import v7.w;

public final class a<E>
  extends v<Object>
{
  public static final w c = new a();
  private final Class<E> a;
  private final v<E> b;
  
  public a(f paramf, v<E> paramv, Class<E> paramClass)
  {
    this.b = new m(paramf, paramv, paramClass);
    this.a = paramClass;
  }
  
  public Object b(b8.a parama)
  {
    if (parama.u0() == b8.b.i)
    {
      parama.q0();
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    parama.a();
    while (parama.g0()) {
      localArrayList.add(this.b.b(parama));
    }
    parama.d0();
    int j = localArrayList.size();
    parama = Array.newInstance(this.a, j);
    int i = 0;
    while (i < j)
    {
      Array.set(parama, i, localArrayList.get(i));
      i += 1;
    }
    return parama;
  }
  
  public void d(c paramc, Object paramObject)
  {
    if (paramObject == null)
    {
      paramc.k0();
      return;
    }
    paramc.h();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.b.d(paramc, localObject);
      i += 1;
    }
    paramc.d0();
  }
  
  static final class a
    implements w
  {
    public <T> v<T> a(f paramf, com.google.gson.reflect.a<T> parama)
    {
      parama = parama.getType();
      if ((!(parama instanceof GenericArrayType)) && ((!(parama instanceof Class)) || (!((Class)parama).isArray()))) {
        return null;
      }
      parama = x7.b.g(parama);
      return new a(paramf, paramf.k(com.google.gson.reflect.a.get(parama)), x7.b.k(parama));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.a
 * JD-Core Version:    0.7.0.1
 */