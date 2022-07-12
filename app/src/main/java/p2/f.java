package p2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
{
  private final List<a<?, ?>> a = new ArrayList();
  
  public <Z, R> e<Z, R> a(Class<Z> paramClass, Class<R> paramClass1)
  {
    try
    {
      if (paramClass1.isAssignableFrom(paramClass))
      {
        paramClass = g.b();
        return paramClass;
      }
      Object localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        if (locala.a(paramClass, paramClass1))
        {
          paramClass = locala.c;
          return paramClass;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No transcoder registered to transcode from ");
      ((StringBuilder)localObject).append(paramClass);
      ((StringBuilder)localObject).append(" to ");
      ((StringBuilder)localObject).append(paramClass1);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    finally {}
  }
  
  public <Z, R> List<Class<R>> b(Class<Z> paramClass, Class<R> paramClass1)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (paramClass1.isAssignableFrom(paramClass))
      {
        localArrayList.add(paramClass1);
        return localArrayList;
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((locala.a(paramClass, paramClass1)) && (!localArrayList.contains(locala.b))) {
          localArrayList.add(locala.b);
        }
      }
      return localArrayList;
    }
    finally {}
  }
  
  public <Z, R> void c(Class<Z> paramClass, Class<R> paramClass1, e<Z, R> parame)
  {
    try
    {
      this.a.add(new a(paramClass, paramClass1, parame));
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  private static final class a<Z, R>
  {
    final Class<Z> a;
    final Class<R> b;
    final e<Z, R> c;
    
    a(Class<Z> paramClass, Class<R> paramClass1, e<Z, R> parame)
    {
      this.a = paramClass;
      this.b = paramClass1;
      this.c = parame;
    }
    
    public boolean a(Class<?> paramClass1, Class<?> paramClass2)
    {
      return (this.a.isAssignableFrom(paramClass1)) && (paramClass2.isAssignableFrom(this.b));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p2.f
 * JD-Core Version:    0.7.0.1
 */