package s2;

import g0.a;
import g0.g;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import x2.j;

public class d
{
  private final AtomicReference<j> a = new AtomicReference();
  private final a<j, List<Class<?>>> b = new a();
  
  public List<Class<?>> a(Class<?> paramClass1, Class<?> arg2, Class<?> paramClass3)
  {
    j localj = (j)this.a.getAndSet(null);
    if (localj == null)
    {
      paramClass1 = new j(paramClass1, ???, paramClass3);
    }
    else
    {
      localj.a(paramClass1, ???, paramClass3);
      paramClass1 = localj;
    }
    synchronized (this.b)
    {
      paramClass3 = (List)this.b.get(paramClass1);
      this.a.set(paramClass1);
      return paramClass3;
    }
  }
  
  public void b(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3, List<Class<?>> paramList)
  {
    synchronized (this.b)
    {
      this.b.put(new j(paramClass1, paramClass2, paramClass3), paramList);
      return;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s2.d
 * JD-Core Version:    0.7.0.1
 */