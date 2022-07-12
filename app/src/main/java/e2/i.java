package e2;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import x2.k;

public final class i
  implements b
{
  private final g<a, Object> a = new g();
  private final b b = new b();
  private final Map<Class<?>, NavigableMap<Integer, Integer>> c = new HashMap();
  private final Map<Class<?>, a<?>> d = new HashMap();
  private final int e;
  private int f;
  
  public i(int paramInt)
  {
    this.e = paramInt;
  }
  
  private void f(int paramInt, Class<?> paramClass)
  {
    paramClass = m(paramClass);
    Integer localInteger1 = (Integer)paramClass.get(Integer.valueOf(paramInt));
    if (localInteger1 != null)
    {
      int i = localInteger1.intValue();
      Integer localInteger2 = Integer.valueOf(paramInt);
      if (i == 1)
      {
        paramClass.remove(localInteger2);
        return;
      }
      paramClass.put(localInteger2, Integer.valueOf(localInteger1.intValue() - 1));
      return;
    }
    paramClass = new StringBuilder();
    paramClass.append("Tried to decrement empty size, size: ");
    paramClass.append(paramInt);
    paramClass.append(", this: ");
    paramClass.append(this);
    throw new NullPointerException(paramClass.toString());
  }
  
  private void g()
  {
    h(this.e);
  }
  
  private void h(int paramInt)
  {
    while (this.f > paramInt)
    {
      Object localObject = this.a.f();
      k.d(localObject);
      a locala = i(localObject);
      this.f -= locala.b(localObject) * locala.c();
      f(locala.b(localObject), localObject.getClass());
      if (Log.isLoggable(locala.a(), 2))
      {
        String str = locala.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("evicted: ");
        localStringBuilder.append(locala.b(localObject));
        Log.v(str, localStringBuilder.toString());
      }
    }
  }
  
  private <T> a<T> i(T paramT)
  {
    return j(paramT.getClass());
  }
  
  private <T> a<T> j(Class<T> paramClass)
  {
    Object localObject = (a)this.d.get(paramClass);
    if (localObject == null)
    {
      if (paramClass.equals([I.class))
      {
        localObject = new h();
      }
      else
      {
        if (!paramClass.equals([B.class)) {
          break label69;
        }
        localObject = new f();
      }
      this.d.put(paramClass, localObject);
      return localObject;
      label69:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No array pool found for: ");
      ((StringBuilder)localObject).append(paramClass.getSimpleName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return localObject;
  }
  
  private <T> T k(a parama)
  {
    return this.a.a(parama);
  }
  
  private <T> T l(a parama, Class<T> paramClass)
  {
    a locala = j(paramClass);
    Object localObject = k(parama);
    if (localObject != null)
    {
      this.f -= locala.b(localObject) * locala.c();
      f(locala.b(localObject), paramClass);
    }
    paramClass = (Class<T>)localObject;
    if (localObject == null)
    {
      if (Log.isLoggable(locala.a(), 2))
      {
        paramClass = locala.a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Allocated ");
        ((StringBuilder)localObject).append(parama.b);
        ((StringBuilder)localObject).append(" bytes");
        Log.v(paramClass, ((StringBuilder)localObject).toString());
      }
      paramClass = locala.newArray(parama.b);
    }
    return paramClass;
  }
  
  private NavigableMap<Integer, Integer> m(Class<?> paramClass)
  {
    NavigableMap localNavigableMap = (NavigableMap)this.c.get(paramClass);
    Object localObject = localNavigableMap;
    if (localNavigableMap == null)
    {
      localObject = new TreeMap();
      this.c.put(paramClass, localObject);
    }
    return localObject;
  }
  
  private boolean n()
  {
    int i = this.f;
    return (i == 0) || (this.e / i >= 2);
  }
  
  private boolean o(int paramInt)
  {
    return paramInt <= this.e / 2;
  }
  
  private boolean p(int paramInt, Integer paramInteger)
  {
    return (paramInteger != null) && ((n()) || (paramInteger.intValue() <= paramInt * 8));
  }
  
  public void a()
  {
    try
    {
      h(0);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 40) {}
    for (;;)
    {
      try
      {
        a();
        continue;
        h(this.e / 2);
        return;
      }
      finally
      {
        Object localObject1;
        continue;
      }
      throw localObject1;
      if (paramInt < 20) {
        if (paramInt != 15) {}
      }
    }
  }
  
  public <T> T c(int paramInt, Class<T> paramClass)
  {
    try
    {
      paramClass = l(this.b.e(paramInt, paramClass), paramClass);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public <T> void d(T paramT)
  {
    try
    {
      Object localObject2 = paramT.getClass();
      Object localObject1 = j((Class)localObject2);
      int i = ((a)localObject1).b(paramT);
      int j = ((a)localObject1).c() * i;
      boolean bool = o(j);
      if (!bool) {
        return;
      }
      localObject1 = this.b.e(i, (Class)localObject2);
      this.a.d((l)localObject1, paramT);
      paramT = m((Class)localObject2);
      localObject2 = (Integer)paramT.get(Integer.valueOf(((a)localObject1).b));
      int k = ((a)localObject1).b;
      i = 1;
      if (localObject2 != null) {
        i = 1 + ((Integer)localObject2).intValue();
      }
      paramT.put(Integer.valueOf(k), Integer.valueOf(i));
      this.f += j;
      g();
      return;
    }
    finally {}
  }
  
  public <T> T e(int paramInt, Class<T> paramClass)
  {
    try
    {
      Object localObject = (Integer)m(paramClass).ceilingKey(Integer.valueOf(paramInt));
      if (p(paramInt, (Integer)localObject)) {
        localObject = this.b.e(((Integer)localObject).intValue(), paramClass);
      } else {
        localObject = this.b.e(paramInt, paramClass);
      }
      paramClass = l((a)localObject, paramClass);
      return paramClass;
    }
    finally {}
  }
  
  private static final class a
    implements l
  {
    private final i.b a;
    int b;
    private Class<?> c;
    
    a(i.b paramb)
    {
      this.a = paramb;
    }
    
    public void a()
    {
      this.a.c(this);
    }
    
    void b(int paramInt, Class<?> paramClass)
    {
      this.b = paramInt;
      this.c = paramClass;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool3 = paramObject instanceof a;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        paramObject = (a)paramObject;
        bool1 = bool2;
        if (this.b == paramObject.b)
        {
          bool1 = bool2;
          if (this.c == paramObject.c) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      int j = this.b;
      Class localClass = this.c;
      int i;
      if (localClass != null) {
        i = localClass.hashCode();
      } else {
        i = 0;
      }
      return j * 31 + i;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Key{size=");
      localStringBuilder.append(this.b);
      localStringBuilder.append("array=");
      localStringBuilder.append(this.c);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  private static final class b
    extends c<i.a>
  {
    protected i.a d()
    {
      return new i.a(this);
    }
    
    i.a e(int paramInt, Class<?> paramClass)
    {
      i.a locala = (i.a)b();
      locala.b(paramInt, paramClass);
      return locala;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e2.i
 * JD-Core Version:    0.7.0.1
 */