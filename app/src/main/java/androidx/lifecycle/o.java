package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class o
{
  private static Map<Class<?>, Integer> a = new HashMap();
  private static Map<Class<?>, List<Constructor<? extends g>>> b = new HashMap();
  
  private static g a(Constructor<? extends g> paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = (g)paramConstructor.newInstance(new Object[] { paramObject });
      return paramConstructor;
    }
    catch (InvocationTargetException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InstantiationException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (IllegalAccessException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
  }
  
  private static Constructor<? extends g> b(Class<?> paramClass)
  {
    try
    {
      localObject = paramClass.getPackage();
      str = paramClass.getCanonicalName();
      if (localObject == null) {
        break label138;
      }
      localObject = ((Package)localObject).getName();
    }
    catch (NoSuchMethodException paramClass)
    {
      String str;
      StringBuilder localStringBuilder;
      throw new RuntimeException(paramClass);
      return null;
    }
    catch (ClassNotFoundException paramClass)
    {
      for (;;)
      {
        continue;
        label138:
        Object localObject = "";
      }
    }
    if (!((String)localObject).isEmpty()) {
      str = str.substring(((String)localObject).length() + 1);
    }
    str = c(str);
    if (((String)localObject).isEmpty())
    {
      localObject = str;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      localObject = localStringBuilder.toString();
    }
    paramClass = Class.forName((String)localObject).getDeclaredConstructor(new Class[] { paramClass });
    if (!paramClass.isAccessible()) {
      paramClass.setAccessible(true);
    }
    return paramClass;
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.replace(".", "_"));
    localStringBuilder.append("_LifecycleAdapter");
    return localStringBuilder.toString();
  }
  
  private static int d(Class<?> paramClass)
  {
    Integer localInteger = (Integer)a.get(paramClass);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    int i = g(paramClass);
    a.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  private static boolean e(Class<?> paramClass)
  {
    return (paramClass != null) && (k.class.isAssignableFrom(paramClass));
  }
  
  static j f(Object paramObject)
  {
    boolean bool1 = paramObject instanceof j;
    boolean bool2 = paramObject instanceof f;
    if ((bool1) && (bool2)) {
      return new FullLifecycleObserverAdapter((f)paramObject, (j)paramObject);
    }
    if (bool2) {
      return new FullLifecycleObserverAdapter((f)paramObject, null);
    }
    if (bool1) {
      return (j)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (d((Class)localObject) == 2)
    {
      localObject = (List)b.get(localObject);
      int j = ((List)localObject).size();
      int i = 0;
      if (j == 1) {
        return new SingleGeneratedAdapterObserver(a((Constructor)((List)localObject).get(0), paramObject));
      }
      g[] arrayOfg = new g[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfg[i] = a((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      return new CompositeGeneratedAdaptersObserver(arrayOfg);
    }
    return new ReflectiveGenericLifecycleObserver(paramObject);
  }
  
  private static int g(Class<?> paramClass)
  {
    if (paramClass.getCanonicalName() == null) {
      return 1;
    }
    Object localObject1 = b(paramClass);
    if (localObject1 != null)
    {
      b.put(paramClass, Collections.singletonList(localObject1));
      return 2;
    }
    if (b.c.d(paramClass)) {
      return 1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = null;
    if (e((Class)localObject2))
    {
      if (d((Class)localObject2) == 1) {
        return 1;
      }
      localObject1 = new ArrayList((Collection)b.get(localObject2));
    }
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      if (e(localClass))
      {
        if (d(localClass) == 1) {
          return 1;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).addAll((Collection)b.get(localClass));
        localObject1 = localObject2;
      }
      i += 1;
    }
    if (localObject1 != null)
    {
      b.put(paramClass, localObject1);
      return 2;
    }
    return 1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.o
 * JD-Core Version:    0.7.0.1
 */