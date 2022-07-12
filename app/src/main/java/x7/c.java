package x7;

import a8.b;
import com.google.gson.reflect.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class c
{
  private final Map<Type, v7.h<?>> a;
  private final b b = b.a();
  
  public c(Map<Type, v7.h<?>> paramMap)
  {
    this.a = paramMap;
  }
  
  private <T> i<T> b(final Class<? super T> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      if (!paramClass.isAccessible()) {
        this.b.b(paramClass);
      }
      paramClass = new h(paramClass);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      label36:
      break label36;
    }
    return null;
  }
  
  private <T> i<T> c(final Type paramType, Class<? super T> paramClass)
  {
    if (Collection.class.isAssignableFrom(paramClass))
    {
      if (SortedSet.class.isAssignableFrom(paramClass)) {
        return new i();
      }
      if (EnumSet.class.isAssignableFrom(paramClass)) {
        return new j(paramType);
      }
      if (Set.class.isAssignableFrom(paramClass)) {
        return new k();
      }
      if (Queue.class.isAssignableFrom(paramClass)) {
        return new l();
      }
      return new m();
    }
    if (Map.class.isAssignableFrom(paramClass))
    {
      if (ConcurrentNavigableMap.class.isAssignableFrom(paramClass)) {
        return new n();
      }
      if (ConcurrentMap.class.isAssignableFrom(paramClass)) {
        return new a();
      }
      if (SortedMap.class.isAssignableFrom(paramClass)) {
        return new b();
      }
      if (((paramType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(a.get(((ParameterizedType)paramType).getActualTypeArguments()[0]).getRawType()))) {
        return new c();
      }
      return new d();
    }
    return null;
  }
  
  private <T> i<T> d(final Type paramType, final Class<? super T> paramClass)
  {
    return new e(paramClass, paramType);
  }
  
  public <T> i<T> a(a<T> parama)
  {
    final Type localType = parama.getType();
    parama = parama.getRawType();
    Object localObject = (v7.h)this.a.get(localType);
    if (localObject != null) {
      return new f((v7.h)localObject, localType);
    }
    localObject = (v7.h)this.a.get(parama);
    if (localObject != null) {
      return new g((v7.h)localObject, localType);
    }
    localObject = b(parama);
    if (localObject != null) {
      return localObject;
    }
    localObject = c(localType, parama);
    if (localObject != null) {
      return localObject;
    }
    return d(localType, parama);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  class a
    implements i<T>
  {
    a() {}
    
    public T a()
    {
      return new ConcurrentHashMap();
    }
  }
  
  class b
    implements i<T>
  {
    b() {}
    
    public T a()
    {
      return new TreeMap();
    }
  }
  
  class c
    implements i<T>
  {
    c() {}
    
    public T a()
    {
      return new LinkedHashMap();
    }
  }
  
  class d
    implements i<T>
  {
    d() {}
    
    public T a()
    {
      return new h();
    }
  }
  
  class e
    implements i<T>
  {
    private final m a = m.b();
    
    e(Class paramClass, Type paramType) {}
    
    public T a()
    {
      try
      {
        Object localObject = this.a.c(paramClass);
        return localObject;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to invoke no-args constructor for ");
        localStringBuilder.append(paramType);
        localStringBuilder.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
        throw new RuntimeException(localStringBuilder.toString(), localException);
      }
    }
  }
  
  class f
    implements i<T>
  {
    f(v7.h paramh, Type paramType) {}
    
    public T a()
    {
      return this.a.a(localType);
    }
  }
  
  class g
    implements i<T>
  {
    g(v7.h paramh, Type paramType) {}
    
    public T a()
    {
      return this.a.a(localType);
    }
  }
  
  class h
    implements i<T>
  {
    h(Constructor paramConstructor) {}
    
    public T a()
    {
      try
      {
        Object localObject = paramClass.newInstance(null);
        return localObject;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to invoke ");
        localStringBuilder.append(paramClass);
        localStringBuilder.append(" with no args");
        throw new RuntimeException(localStringBuilder.toString(), localInvocationTargetException.getTargetException());
      }
      catch (InstantiationException localInstantiationException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to invoke ");
        localStringBuilder.append(paramClass);
        localStringBuilder.append(" with no args");
        throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
      }
    }
  }
  
  class i
    implements i<T>
  {
    i() {}
    
    public T a()
    {
      return new TreeSet();
    }
  }
  
  class j
    implements i<T>
  {
    j(Type paramType) {}
    
    public T a()
    {
      Object localObject = paramType;
      if ((localObject instanceof ParameterizedType))
      {
        localObject = ((ParameterizedType)localObject).getActualTypeArguments()[0];
        if ((localObject instanceof Class)) {
          return EnumSet.noneOf((Class)localObject);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid EnumSet type: ");
        ((StringBuilder)localObject).append(paramType.toString());
        throw new v7.m(((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid EnumSet type: ");
      ((StringBuilder)localObject).append(paramType.toString());
      throw new v7.m(((StringBuilder)localObject).toString());
    }
  }
  
  class k
    implements i<T>
  {
    k() {}
    
    public T a()
    {
      return new LinkedHashSet();
    }
  }
  
  class l
    implements i<T>
  {
    l() {}
    
    public T a()
    {
      return new ArrayDeque();
    }
  }
  
  class m
    implements i<T>
  {
    m() {}
    
    public T a()
    {
      return new ArrayList();
    }
  }
  
  class n
    implements i<T>
  {
    n() {}
    
    public T a()
    {
      return new ConcurrentSkipListMap();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x7.c
 * JD-Core Version:    0.7.0.1
 */