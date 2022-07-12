package y7;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import v7.f;
import v7.v;
import v7.w;
import x7.i;

public final class b
  implements w
{
  private final x7.c a;
  
  public b(x7.c paramc)
  {
    this.a = paramc;
  }
  
  public <T> v<T> a(f paramf, com.google.gson.reflect.a<T> parama)
  {
    Type localType = parama.getType();
    Class localClass = parama.getRawType();
    if (!Collection.class.isAssignableFrom(localClass)) {
      return null;
    }
    localType = x7.b.h(localType, localClass);
    return new a(paramf, localType, paramf.k(com.google.gson.reflect.a.get(localType)), this.a.a(parama));
  }
  
  private static final class a<E>
    extends v<Collection<E>>
  {
    private final v<E> a;
    private final i<? extends Collection<E>> b;
    
    public a(f paramf, Type paramType, v<E> paramv, i<? extends Collection<E>> parami)
    {
      this.a = new m(paramf, paramv, paramType);
      this.b = parami;
    }
    
    public Collection<E> e(b8.a parama)
    {
      if (parama.u0() == b8.b.i)
      {
        parama.q0();
        return null;
      }
      Collection localCollection = (Collection)this.b.a();
      parama.a();
      while (parama.g0()) {
        localCollection.add(this.a.b(parama));
      }
      parama.d0();
      return localCollection;
    }
    
    public void f(b8.c paramc, Collection<E> paramCollection)
    {
      if (paramCollection == null)
      {
        paramc.k0();
        return;
      }
      paramc.h();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        this.a.d(paramc, localObject);
      }
      paramc.d0();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.b
 * JD-Core Version:    0.7.0.1
 */