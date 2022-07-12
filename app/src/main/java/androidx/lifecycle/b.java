package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
final class b
{
  static b c = new b();
  private final Map<Class<?>, a> a = new HashMap();
  private final Map<Class<?>, Boolean> b = new HashMap();
  
  private a a(Class<?> paramClass, Method[] paramArrayOfMethod)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private Method[] b(Class<?> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethods();
      return paramClass;
    }
    catch (NoClassDefFoundError paramClass)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
    }
  }
  
  private void e(Map<b, h.b> paramMap, b paramb, h.b paramb1, Class<?> paramClass)
  {
    h.b localb = (h.b)paramMap.get(paramb);
    if ((localb != null) && (paramb1 != localb))
    {
      paramMap = paramb.b;
      paramb = new StringBuilder();
      paramb.append("Method ");
      paramb.append(paramMap.getName());
      paramb.append(" in ");
      paramb.append(paramClass.getName());
      paramb.append(" already declared with different @OnLifecycleEvent value: previous value ");
      paramb.append(localb);
      paramb.append(", new value ");
      paramb.append(paramb1);
      throw new IllegalArgumentException(paramb.toString());
    }
    if (localb == null) {
      paramMap.put(paramb, paramb1);
    }
  }
  
  a c(Class<?> paramClass)
  {
    a locala = (a)this.a.get(paramClass);
    if (locala != null) {
      return locala;
    }
    return a(paramClass, null);
  }
  
  boolean d(Class<?> paramClass)
  {
    Object localObject = (Boolean)this.b.get(paramClass);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    localObject = b(paramClass);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if ((t)localObject[i].getAnnotation(t.class) != null)
      {
        a(paramClass, (Method[])localObject);
        return true;
      }
      i += 1;
    }
    this.b.put(paramClass, Boolean.FALSE);
    return false;
  }
  
  @Deprecated
  static class a
  {
    final Map<h.b, List<b.b>> a;
    final Map<b.b, h.b> b;
    
    a(Map<b.b, h.b> paramMap)
    {
      this.b = paramMap;
      this.a = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        h.b localb = (h.b)localEntry.getValue();
        List localList = (List)this.a.get(localb);
        paramMap = localList;
        if (localList == null)
        {
          paramMap = new ArrayList();
          this.a.put(localb, paramMap);
        }
        paramMap.add((b.b)localEntry.getKey());
      }
    }
    
    private static void b(List<b.b> paramList, l paraml, h.b paramb, Object paramObject)
    {
      if (paramList != null)
      {
        int i = paramList.size() - 1;
        while (i >= 0)
        {
          ((b.b)paramList.get(i)).a(paraml, paramb, paramObject);
          i -= 1;
        }
      }
    }
    
    void a(l paraml, h.b paramb, Object paramObject)
    {
      b((List)this.a.get(paramb), paraml, paramb, paramObject);
      b((List)this.a.get(h.b.ON_ANY), paraml, paramb, paramObject);
    }
  }
  
  @Deprecated
  static final class b
  {
    final int a;
    final Method b;
    
    b(int paramInt, Method paramMethod)
    {
      this.a = paramInt;
      this.b = paramMethod;
      paramMethod.setAccessible(true);
    }
    
    void a(l paraml, h.b paramb, Object paramObject)
    {
      try
      {
        int i = this.a;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2) {
              return;
            }
            this.b.invoke(paramObject, new Object[] { paraml, paramb });
            return;
          }
          this.b.invoke(paramObject, new Object[] { paraml });
          return;
        }
        this.b.invoke(paramObject, new Object[0]);
        return;
      }
      catch (IllegalAccessException paraml)
      {
        throw new RuntimeException(paraml);
      }
      catch (InvocationTargetException paraml)
      {
        throw new RuntimeException("Failed to call observer method", paraml.getCause());
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      return (this.a == paramObject.a) && (this.b.getName().equals(paramObject.b.getName()));
    }
    
    public int hashCode()
    {
      return this.a * 31 + this.b.getName().hashCode();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.b
 * JD-Core Version:    0.7.0.1
 */