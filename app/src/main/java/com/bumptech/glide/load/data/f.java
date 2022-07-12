package com.bumptech.glide.load.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import x2.k;

public class f
{
  private static final e.a<?> b = new a();
  private final Map<Class<?>, e.a<?>> a = new HashMap();
  
  public <T> e<T> a(T paramT)
  {
    try
    {
      k.d(paramT);
      Object localObject2 = (e.a)this.a.get(paramT.getClass());
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        Iterator localIterator = this.a.values().iterator();
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (e.a)localIterator.next();
        } while (!((e.a)localObject1).a().isAssignableFrom(paramT.getClass()));
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = b;
      }
      paramT = ((e.a)localObject2).b(paramT);
      return paramT;
    }
    finally {}
  }
  
  public void b(e.a<?> parama)
  {
    try
    {
      this.a.put(parama.a(), parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  class a
    implements e.a<Object>
  {
    public Class<Object> a()
    {
      throw new UnsupportedOperationException("Not implemented");
    }
    
    public e<Object> b(Object paramObject)
    {
      return new f.b(paramObject);
    }
  }
  
  private static final class b
    implements e<Object>
  {
    private final Object a;
    
    b(Object paramObject)
    {
      this.a = paramObject;
    }
    
    public Object a()
    {
      return this.a;
    }
    
    public void b() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.data.f
 * JD-Core Version:    0.7.0.1
 */