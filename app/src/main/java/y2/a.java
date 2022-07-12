package y2;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import x0.e;
import x0.g;

public final class a
{
  private static final g<Object> a = new a();
  
  private static <T extends f> e<T> a(e<T> parame, d<T> paramd)
  {
    return b(parame, paramd, c());
  }
  
  private static <T> e<T> b(e<T> parame, d<T> paramd, g<T> paramg)
  {
    return new e(parame, paramd, paramg);
  }
  
  private static <T> g<T> c()
  {
    return a;
  }
  
  public static <T extends f> e<T> d(int paramInt, d<T> paramd)
  {
    return a(new g(paramInt), paramd);
  }
  
  public static <T> e<List<T>> e()
  {
    return f(20);
  }
  
  public static <T> e<List<T>> f(int paramInt)
  {
    return b(new g(paramInt), new b(), new c());
  }
  
  class a
    implements a.g<Object>
  {
    public void a(Object paramObject) {}
  }
  
  class b
    implements a.d<List<T>>
  {
    public List<T> b()
    {
      return new ArrayList();
    }
  }
  
  class c
    implements a.g<List<T>>
  {
    public void b(List<T> paramList)
    {
      paramList.clear();
    }
  }
  
  public static abstract interface d<T>
  {
    public abstract T a();
  }
  
  private static final class e<T>
    implements e<T>
  {
    private final a.d<T> a;
    private final a.g<T> b;
    private final e<T> c;
    
    e(e<T> parame, a.d<T> paramd, a.g<T> paramg)
    {
      this.c = parame;
      this.a = paramd;
      this.b = paramg;
    }
    
    public boolean a(T paramT)
    {
      if ((paramT instanceof a.f)) {
        ((a.f)paramT).e().b(true);
      }
      this.b.a(paramT);
      return this.c.a(paramT);
    }
    
    public T b()
    {
      Object localObject2 = this.c.b();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.a.a();
        localObject1 = localObject2;
        if (Log.isLoggable("FactoryPools", 2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Created new ");
          ((StringBuilder)localObject1).append(localObject2.getClass());
          Log.v("FactoryPools", ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      if ((localObject1 instanceof a.f)) {
        ((a.f)localObject1).e().b(false);
      }
      return localObject1;
    }
  }
  
  public static abstract interface f
  {
    public abstract c e();
  }
  
  public static abstract interface g<T>
  {
    public abstract void a(T paramT);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y2.a
 * JD-Core Version:    0.7.0.1
 */