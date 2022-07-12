package ea;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import l9.b0;
import l9.e.a;
import l9.e0;
import l9.g0;
import l9.x;

public final class u
{
  private final Map<Method, v<?>> a = new ConcurrentHashMap();
  final e.a b;
  final x c;
  final List<f.a> d;
  final List<c.a> e;
  @Nullable
  final Executor f;
  final boolean g;
  
  u(e.a parama, x paramx, List<f.a> paramList, List<c.a> paramList1, @Nullable Executor paramExecutor, boolean paramBoolean)
  {
    this.b = parama;
    this.c = paramx;
    this.d = paramList;
    this.e = paramList1;
    this.f = paramExecutor;
    this.g = paramBoolean;
  }
  
  private void j(Class<?> paramClass)
  {
    if (paramClass.isInterface())
    {
      Object localObject2 = new ArrayDeque(1);
      ((Deque)localObject2).add(paramClass);
      Object localObject1;
      while (!((Deque)localObject2).isEmpty())
      {
        localObject1 = (Class)((Deque)localObject2).removeFirst();
        if (((Class)localObject1).getTypeParameters().length != 0)
        {
          localObject2 = new StringBuilder("Type parameters are unsupported on ");
          ((StringBuilder)localObject2).append(((Class)localObject1).getName());
          if (localObject1 != paramClass)
          {
            ((StringBuilder)localObject2).append(" which is an interface of ");
            ((StringBuilder)localObject2).append(paramClass.getName());
          }
          throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
        }
        Collections.addAll((Collection)localObject2, ((Class)localObject1).getInterfaces());
      }
      if (this.g)
      {
        localObject1 = q.f();
        paramClass = paramClass.getDeclaredMethods();
        int j = paramClass.length;
        int i = 0;
        while (i < j)
        {
          localObject2 = paramClass[i];
          if ((!((q)localObject1).h((Method)localObject2)) && (!Modifier.isStatic(((Method)localObject2).getModifiers()))) {
            c((Method)localObject2);
          }
          i += 1;
        }
      }
      return;
    }
    throw new IllegalArgumentException("API declarations must be interfaces.");
  }
  
  public c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    return d(null, paramType, paramArrayOfAnnotation);
  }
  
  public <T> T b(final Class<T> paramClass)
  {
    j(paramClass);
    ClassLoader localClassLoader = paramClass.getClassLoader();
    a locala = new a(paramClass);
    return Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, locala);
  }
  
  v<?> c(Method paramMethod)
  {
    Object localObject = (v)this.a.get(paramMethod);
    if (localObject != null) {
      return localObject;
    }
    synchronized (this.a)
    {
      v localv = (v)this.a.get(paramMethod);
      localObject = localv;
      if (localv == null)
      {
        localObject = v.b(this, paramMethod);
        this.a.put(paramMethod, localObject);
      }
      return localObject;
    }
  }
  
  public c<?, ?> d(@Nullable c.a parama, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    Objects.requireNonNull(paramType, "returnType == null");
    Objects.requireNonNull(paramArrayOfAnnotation, "annotations == null");
    int i = this.e.indexOf(parama) + 1;
    int k = this.e.size();
    int j = i;
    while (j < k)
    {
      c localc = ((c.a)this.e.get(j)).a(paramType, paramArrayOfAnnotation, this);
      if (localc != null) {
        return localc;
      }
      j += 1;
    }
    paramArrayOfAnnotation = new StringBuilder("Could not locate call adapter for ");
    paramArrayOfAnnotation.append(paramType);
    paramArrayOfAnnotation.append(".\n");
    if (parama != null)
    {
      paramArrayOfAnnotation.append("  Skipped:");
      j = 0;
      while (j < i)
      {
        paramArrayOfAnnotation.append("\n   * ");
        paramArrayOfAnnotation.append(((c.a)this.e.get(j)).getClass().getName());
        j += 1;
      }
      paramArrayOfAnnotation.append('\n');
    }
    paramArrayOfAnnotation.append("  Tried:");
    j = this.e.size();
    while (i < j)
    {
      paramArrayOfAnnotation.append("\n   * ");
      paramArrayOfAnnotation.append(((c.a)this.e.get(i)).getClass().getName());
      i += 1;
    }
    throw new IllegalArgumentException(paramArrayOfAnnotation.toString());
  }
  
  public <T> f<T, e0> e(@Nullable f.a parama, Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2)
  {
    Objects.requireNonNull(paramType, "type == null");
    Objects.requireNonNull(paramArrayOfAnnotation1, "parameterAnnotations == null");
    Objects.requireNonNull(paramArrayOfAnnotation2, "methodAnnotations == null");
    int i = this.d.indexOf(parama) + 1;
    int k = this.d.size();
    int j = i;
    while (j < k)
    {
      f localf = ((f.a)this.d.get(j)).c(paramType, paramArrayOfAnnotation1, paramArrayOfAnnotation2, this);
      if (localf != null) {
        return localf;
      }
      j += 1;
    }
    paramArrayOfAnnotation1 = new StringBuilder("Could not locate RequestBody converter for ");
    paramArrayOfAnnotation1.append(paramType);
    paramArrayOfAnnotation1.append(".\n");
    if (parama != null)
    {
      paramArrayOfAnnotation1.append("  Skipped:");
      j = 0;
      while (j < i)
      {
        paramArrayOfAnnotation1.append("\n   * ");
        paramArrayOfAnnotation1.append(((f.a)this.d.get(j)).getClass().getName());
        j += 1;
      }
      paramArrayOfAnnotation1.append('\n');
    }
    paramArrayOfAnnotation1.append("  Tried:");
    j = this.d.size();
    while (i < j)
    {
      paramArrayOfAnnotation1.append("\n   * ");
      paramArrayOfAnnotation1.append(((f.a)this.d.get(i)).getClass().getName());
      i += 1;
    }
    throw new IllegalArgumentException(paramArrayOfAnnotation1.toString());
  }
  
  public <T> f<g0, T> f(@Nullable f.a parama, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    Objects.requireNonNull(paramType, "type == null");
    Objects.requireNonNull(paramArrayOfAnnotation, "annotations == null");
    int i = this.d.indexOf(parama) + 1;
    int k = this.d.size();
    int j = i;
    while (j < k)
    {
      f localf = ((f.a)this.d.get(j)).d(paramType, paramArrayOfAnnotation, this);
      if (localf != null) {
        return localf;
      }
      j += 1;
    }
    paramArrayOfAnnotation = new StringBuilder("Could not locate ResponseBody converter for ");
    paramArrayOfAnnotation.append(paramType);
    paramArrayOfAnnotation.append(".\n");
    if (parama != null)
    {
      paramArrayOfAnnotation.append("  Skipped:");
      j = 0;
      while (j < i)
      {
        paramArrayOfAnnotation.append("\n   * ");
        paramArrayOfAnnotation.append(((f.a)this.d.get(j)).getClass().getName());
        j += 1;
      }
      paramArrayOfAnnotation.append('\n');
    }
    paramArrayOfAnnotation.append("  Tried:");
    j = this.d.size();
    while (i < j)
    {
      paramArrayOfAnnotation.append("\n   * ");
      paramArrayOfAnnotation.append(((f.a)this.d.get(i)).getClass().getName());
      i += 1;
    }
    throw new IllegalArgumentException(paramArrayOfAnnotation.toString());
  }
  
  public <T> f<T, e0> g(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2)
  {
    return e(null, paramType, paramArrayOfAnnotation1, paramArrayOfAnnotation2);
  }
  
  public <T> f<g0, T> h(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    return f(null, paramType, paramArrayOfAnnotation);
  }
  
  public <T> f<T, String> i(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    Objects.requireNonNull(paramType, "type == null");
    Objects.requireNonNull(paramArrayOfAnnotation, "annotations == null");
    int j = this.d.size();
    int i = 0;
    while (i < j)
    {
      f localf = ((f.a)this.d.get(i)).e(paramType, paramArrayOfAnnotation, this);
      if (localf != null) {
        return localf;
      }
      i += 1;
    }
    return a.d.a;
  }
  
  class a
    implements InvocationHandler
  {
    private final q a = q.f();
    private final Object[] b = new Object[0];
    
    @Nullable
    public Object invoke(Object paramObject, Method paramMethod, @Nullable Object[] paramArrayOfObject)
    {
      if (paramMethod.getDeclaringClass() == Object.class) {
        return paramMethod.invoke(this, paramArrayOfObject);
      }
      if (paramArrayOfObject == null) {
        paramArrayOfObject = this.b;
      }
      if (this.a.h(paramMethod)) {
        return this.a.g(paramMethod, paramClass, paramObject, paramArrayOfObject);
      }
      return this.d.c(paramMethod).a(paramArrayOfObject);
    }
  }
  
  public static final class b
  {
    private final q a;
    @Nullable
    private e.a b;
    @Nullable
    private x c;
    private final List<f.a> d = new ArrayList();
    private final List<c.a> e = new ArrayList();
    @Nullable
    private Executor f;
    private boolean g;
    
    public b()
    {
      this(q.f());
    }
    
    b(q paramq)
    {
      this.a = paramq;
    }
    
    public b a(f.a parama)
    {
      List localList = this.d;
      Objects.requireNonNull(parama, "factory == null");
      localList.add(parama);
      return this;
    }
    
    public b b(String paramString)
    {
      Objects.requireNonNull(paramString, "baseUrl == null");
      return c(x.h(paramString));
    }
    
    public b c(x paramx)
    {
      Objects.requireNonNull(paramx, "baseUrl == null");
      Object localObject = paramx.m();
      if ("".equals(((List)localObject).get(((List)localObject).size() - 1)))
      {
        this.c = paramx;
        return this;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("baseUrl must end in /: ");
      ((StringBuilder)localObject).append(paramx);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public u d()
    {
      if (this.c != null)
      {
        Object localObject2 = this.b;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new b0();
        }
        Object localObject3 = this.f;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = this.a.b();
        }
        localObject3 = new ArrayList(this.e);
        ((List)localObject3).addAll(this.a.a((Executor)localObject2));
        ArrayList localArrayList = new ArrayList(this.d.size() + 1 + this.a.d());
        localArrayList.add(new a());
        localArrayList.addAll(this.d);
        localArrayList.addAll(this.a.c());
        return new u((e.a)localObject1, this.c, Collections.unmodifiableList(localArrayList), Collections.unmodifiableList((List)localObject3), (Executor)localObject2, this.g);
      }
      throw new IllegalStateException("Base URL required.");
    }
    
    public b e(e.a parama)
    {
      Objects.requireNonNull(parama, "factory == null");
      this.b = ((e.a)parama);
      return this;
    }
    
    public b f(b0 paramb0)
    {
      Objects.requireNonNull(paramb0, "client == null");
      return e((e.a)paramb0);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.u
 * JD-Core Version:    0.7.0.1
 */