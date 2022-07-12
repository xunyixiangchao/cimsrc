package h2;

import com.bumptech.glide.i.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x0.e;

public class p
{
  private final r a;
  private final a b = new a();
  
  private p(r paramr)
  {
    this.a = paramr;
  }
  
  public p(e<List<Throwable>> parame)
  {
    this(new r(parame));
  }
  
  private static <A> Class<A> b(A paramA)
  {
    return paramA.getClass();
  }
  
  private <A> List<n<A, ?>> e(Class<A> paramClass)
  {
    try
    {
      List localList2 = this.b.b(paramClass);
      List localList1 = localList2;
      if (localList2 == null)
      {
        localList1 = Collections.unmodifiableList(this.a.e(paramClass));
        this.b.c(paramClass, localList1);
      }
      return localList1;
    }
    finally {}
  }
  
  private <Model, Data> void g(List<o<? extends Model, ? extends Data>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((o)paramList.next()).c();
    }
  }
  
  public <Model, Data> void a(Class<Model> paramClass, Class<Data> paramClass1, o<? extends Model, ? extends Data> paramo)
  {
    try
    {
      this.a.b(paramClass, paramClass1, paramo);
      this.b.a();
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public List<Class<?>> c(Class<?> paramClass)
  {
    try
    {
      paramClass = this.a.g(paramClass);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public <A> List<n<A, ?>> d(A paramA)
  {
    List localList = e(b(paramA));
    if (!localList.isEmpty())
    {
      int m = localList.size();
      Object localObject1 = Collections.emptyList();
      int i = 1;
      int k = 0;
      while (k < m)
      {
        n localn = (n)localList.get(k);
        Object localObject2 = localObject1;
        int j = i;
        if (localn.a(paramA))
        {
          j = i;
          if (i != 0)
          {
            localObject1 = new ArrayList(m - k);
            j = 0;
          }
          ((List)localObject1).add(localn);
          localObject2 = localObject1;
        }
        k += 1;
        localObject1 = localObject2;
        i = j;
      }
      if (!((List)localObject1).isEmpty()) {
        return localObject1;
      }
      throw new i.c(paramA, localList);
    }
    throw new i.c(paramA);
  }
  
  public <Model, Data> void f(Class<Model> paramClass, Class<Data> paramClass1, o<? extends Model, ? extends Data> paramo)
  {
    try
    {
      g(this.a.j(paramClass, paramClass1, paramo));
      this.b.a();
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  private static class a
  {
    private final Map<Class<?>, a<?>> a = new HashMap();
    
    public void a()
    {
      this.a.clear();
    }
    
    public <Model> List<n<Model, ?>> b(Class<Model> paramClass)
    {
      paramClass = (a)this.a.get(paramClass);
      if (paramClass == null) {
        return null;
      }
      return paramClass.a;
    }
    
    public <Model> void c(Class<Model> paramClass, List<n<Model, ?>> paramList)
    {
      if ((a)this.a.put(paramClass, new a(paramList)) == null) {
        return;
      }
      paramList = new StringBuilder();
      paramList.append("Already cached loaders for model: ");
      paramList.append(paramClass);
      throw new IllegalStateException(paramList.toString());
    }
    
    private static class a<Model>
    {
      final List<n<Model, ?>> a;
      
      public a(List<n<Model, ?>> paramList)
      {
        this.a = paramList;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.p
 * JD-Core Version:    0.7.0.1
 */