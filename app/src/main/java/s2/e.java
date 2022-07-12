package s2;

import b2.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e
{
  private final List<String> a = new ArrayList();
  private final Map<String, List<a<?, ?>>> b = new HashMap();
  
  private List<a<?, ?>> c(String paramString)
  {
    try
    {
      if (!this.a.contains(paramString)) {
        this.a.add(paramString);
      }
      List localList = (List)this.b.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.b.put(paramString, localObject);
      }
      return localObject;
    }
    finally {}
  }
  
  public <T, R> void a(String paramString, j<T, R> paramj, Class<T> paramClass, Class<R> paramClass1)
  {
    try
    {
      c(paramString).add(new a(paramClass, paramClass1, paramj));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public <T, R> List<j<T, R>> b(Class<T> paramClass, Class<R> paramClass1)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (List)this.b.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala = (a)((Iterator)localObject).next();
            if (locala.a(paramClass, paramClass1)) {
              localArrayList.add(locala.c);
            }
          }
        }
      }
      return localArrayList;
    }
    finally {}
  }
  
  public <T, R> List<Class<R>> d(Class<T> paramClass, Class<R> paramClass1)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (List)this.b.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala = (a)((Iterator)localObject).next();
            if ((locala.a(paramClass, paramClass1)) && (!localArrayList.contains(locala.b))) {
              localArrayList.add(locala.b);
            }
          }
        }
      }
      return localArrayList;
    }
    finally {}
  }
  
  public void e(List<String> paramList)
  {
    try
    {
      Object localObject1 = new ArrayList(this.a);
      this.a.clear();
      Object localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        this.a.add(str);
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!paramList.contains(localObject2)) {
          this.a.add(localObject2);
        }
      }
      return;
    }
    finally {}
  }
  
  private static class a<T, R>
  {
    private final Class<T> a;
    final Class<R> b;
    final j<T, R> c;
    
    public a(Class<T> paramClass, Class<R> paramClass1, j<T, R> paramj)
    {
      this.a = paramClass;
      this.b = paramClass1;
      this.c = paramj;
    }
    
    public boolean a(Class<?> paramClass1, Class<?> paramClass2)
    {
      return (this.a.isAssignableFrom(paramClass1)) && (paramClass2.isAssignableFrom(this.b));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s2.e
 * JD-Core Version:    0.7.0.1
 */