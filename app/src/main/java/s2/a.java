package s2;

import b2.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  private final List<a<?>> a = new ArrayList();
  
  public <T> void a(Class<T> paramClass, d<T> paramd)
  {
    try
    {
      this.a.add(new a(paramClass, paramd));
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public <T> d<T> b(Class<T> paramClass)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a(paramClass))
        {
          paramClass = locala.b;
          return paramClass;
        }
      }
      return null;
    }
    finally {}
  }
  
  private static final class a<T>
  {
    private final Class<T> a;
    final d<T> b;
    
    a(Class<T> paramClass, d<T> paramd)
    {
      this.a = paramClass;
      this.b = paramd;
    }
    
    boolean a(Class<?> paramClass)
    {
      return this.a.isAssignableFrom(paramClass);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s2.a
 * JD-Core Version:    0.7.0.1
 */