package s2;

import b2.k;
import java.util.ArrayList;
import java.util.List;

public class f
{
  private final List<a<?>> a = new ArrayList();
  
  public <Z> void a(Class<Z> paramClass, k<Z> paramk)
  {
    try
    {
      this.a.add(new a(paramClass, paramk));
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public <Z> k<Z> b(Class<Z> paramClass)
  {
    int i = 0;
    try
    {
      int j = this.a.size();
      while (i < j)
      {
        a locala = (a)this.a.get(i);
        if (locala.a(paramClass))
        {
          paramClass = locala.b;
          return paramClass;
        }
        i += 1;
      }
      return null;
    }
    finally {}
  }
  
  private static final class a<T>
  {
    private final Class<T> a;
    final k<T> b;
    
    a(Class<T> paramClass, k<T> paramk)
    {
      this.a = paramClass;
      this.b = paramk;
    }
    
    boolean a(Class<?> paramClass)
    {
      return this.a.isAssignableFrom(paramClass);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s2.f
 * JD-Core Version:    0.7.0.1
 */