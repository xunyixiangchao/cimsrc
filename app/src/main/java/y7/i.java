package y7;

import com.google.gson.reflect.a<*>;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import v7.e;
import v7.f;
import v7.t;
import v7.v;
import v7.w;
import x7.k;

public final class i
  implements w
{
  private final x7.c a;
  private final e b;
  private final x7.d c;
  private final d d;
  private final a8.b e = a8.b.a();
  
  public i(x7.c paramc, e parame, x7.d paramd, d paramd1)
  {
    this.a = paramc;
    this.b = parame;
    this.c = paramd;
    this.d = paramd1;
  }
  
  private c b(final f paramf, final Field paramField, String paramString, final com.google.gson.reflect.a<?> parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    final boolean bool2 = k.b(parama.getRawType());
    Object localObject1 = (w7.b)paramField.getAnnotation(w7.b.class);
    if (localObject1 != null) {
      localObject1 = this.d.b(this.a, paramf, parama, (w7.b)localObject1);
    } else {
      localObject1 = null;
    }
    final boolean bool1;
    if (localObject1 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramf.k(parama);
    }
    return new a(paramString, paramBoolean1, paramBoolean2, paramField, bool1, (v)localObject2, paramf, parama, bool2);
  }
  
  static boolean d(Field paramField, boolean paramBoolean, x7.d paramd)
  {
    return (!paramd.c(paramField.getType(), paramBoolean)) && (!paramd.f(paramField, paramBoolean));
  }
  
  private Map<String, c> e(f paramf, com.google.gson.reflect.a<?> parama, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface()) {
      return localLinkedHashMap;
    }
    Type localType1 = parama.getType();
    Object localObject1 = paramClass;
    paramClass = parama;
    while (localObject1 != Object.class)
    {
      Field[] arrayOfField = ((Class)localObject1).getDeclaredFields();
      int m = arrayOfField.length;
      int i = 0;
      while (i < m)
      {
        Field localField = arrayOfField[i];
        boolean bool1 = c(localField, true);
        boolean bool2 = c(localField, false);
        if ((bool1) || (bool2))
        {
          this.e.b(localField);
          Type localType2 = x7.b.p(paramClass.getType(), (Class)localObject1, localField.getGenericType());
          List localList = f(localField);
          int j = localList.size();
          parama = null;
          int k = 0;
          while (k < j)
          {
            Object localObject2 = (String)localList.get(k);
            if (k != 0) {
              bool1 = false;
            }
            localObject2 = (c)localLinkedHashMap.put(localObject2, b(paramf, localField, (String)localObject2, com.google.gson.reflect.a.get(localType2), bool1, bool2));
            if (parama == null) {
              parama = (com.google.gson.reflect.a<?>)localObject2;
            }
            k += 1;
          }
          if (parama != null) {}
        }
        else
        {
          i += 1;
          continue;
        }
        paramf = new StringBuilder();
        paramf.append(localType1);
        paramf.append(" declares multiple JSON fields named ");
        paramf.append(parama.a);
        throw new IllegalArgumentException(paramf.toString());
      }
      paramClass = com.google.gson.reflect.a.get(x7.b.p(paramClass.getType(), (Class)localObject1, ((Class)localObject1).getGenericSuperclass()));
      localObject1 = paramClass.getRawType();
    }
    return localLinkedHashMap;
  }
  
  private List<String> f(Field paramField)
  {
    Object localObject = (w7.c)paramField.getAnnotation(w7.c.class);
    if (localObject == null) {
      return Collections.singletonList(this.b.a(paramField));
    }
    paramField = ((w7.c)localObject).value();
    localObject = ((w7.c)localObject).alternate();
    if (localObject.length == 0) {
      return Collections.singletonList(paramField);
    }
    ArrayList localArrayList = new ArrayList(localObject.length + 1);
    localArrayList.add(paramField);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(localObject[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public <T> v<T> a(f paramf, com.google.gson.reflect.a<T> parama)
  {
    Class localClass = parama.getRawType();
    if (!Object.class.isAssignableFrom(localClass)) {
      return null;
    }
    return new b(this.a.a(parama), e(paramf, parama, localClass));
  }
  
  public boolean c(Field paramField, boolean paramBoolean)
  {
    return d(paramField, paramBoolean, this.c);
  }
  
  class a
    extends i.c
  {
    a(String paramString, boolean paramBoolean1, boolean paramBoolean2, Field paramField, boolean paramBoolean3, v paramv, f paramf, com.google.gson.reflect.a parama, boolean paramBoolean4)
    {
      super(paramBoolean1, paramBoolean2);
    }
    
    void a(b8.a parama, Object paramObject)
    {
      parama = this.f.b(parama);
      if ((parama != null) || (!bool2)) {
        paramField.set(paramObject, parama);
      }
    }
    
    void b(b8.c paramc, Object paramObject)
    {
      Object localObject = paramField.get(paramObject);
      if (bool1) {
        paramObject = this.f;
      } else {
        paramObject = new m(paramf, this.f, parama.getType());
      }
      paramObject.d(paramc, localObject);
    }
    
    public boolean c(Object paramObject)
    {
      boolean bool2 = this.b;
      boolean bool1 = false;
      if (!bool2) {
        return false;
      }
      if (paramField.get(paramObject) != paramObject) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public static final class b<T>
    extends v<T>
  {
    private final x7.i<T> a;
    private final Map<String, i.c> b;
    
    b(x7.i<T> parami, Map<String, i.c> paramMap)
    {
      this.a = parami;
      this.b = paramMap;
    }
    
    public T b(b8.a parama)
    {
      if (parama.u0() == b8.b.i)
      {
        parama.q0();
        return null;
      }
      Object localObject1 = this.a.a();
      try
      {
        parama.g();
        while (parama.g0())
        {
          Object localObject2 = parama.o0();
          localObject2 = (i.c)this.b.get(localObject2);
          if ((localObject2 != null) && (((i.c)localObject2).c)) {
            ((i.c)localObject2).a(parama, localObject1);
          } else {
            parama.E0();
          }
        }
        parama.e0();
        return localObject1;
      }
      catch (IllegalAccessException parama)
      {
        throw new AssertionError(parama);
      }
      catch (IllegalStateException parama)
      {
        throw new t(parama);
      }
    }
    
    public void d(b8.c paramc, T paramT)
    {
      if (paramT == null)
      {
        paramc.k0();
        return;
      }
      paramc.i();
      try
      {
        Iterator localIterator = this.b.values().iterator();
        while (localIterator.hasNext())
        {
          i.c localc = (i.c)localIterator.next();
          if (localc.c(paramT))
          {
            paramc.i0(localc.a);
            localc.b(paramc, paramT);
          }
        }
        paramc.e0();
        return;
      }
      catch (IllegalAccessException paramc)
      {
        throw new AssertionError(paramc);
      }
    }
  }
  
  static abstract class c
  {
    final String a;
    final boolean b;
    final boolean c;
    
    protected c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramString;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
    }
    
    abstract void a(b8.a parama, Object paramObject);
    
    abstract void b(b8.c paramc, Object paramObject);
    
    abstract boolean c(Object paramObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.i
 * JD-Core Version:    0.7.0.1
 */