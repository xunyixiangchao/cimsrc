package ea;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import l9.e.a;
import l9.f0;
import l9.g0;
import s8.a;

abstract class k<ResponseT, ReturnT>
  extends v<ReturnT>
{
  private final s a;
  private final e.a b;
  private final f<g0, ResponseT> c;
  
  k(s params, e.a parama, f<g0, ResponseT> paramf)
  {
    this.a = params;
    this.b = parama;
    this.c = paramf;
  }
  
  private static <ResponseT, ReturnT> c<ResponseT, ReturnT> d(u paramu, Method paramMethod, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    try
    {
      paramu = paramu.a(paramType, paramArrayOfAnnotation);
      return paramu;
    }
    catch (RuntimeException paramu)
    {
      throw y.n(paramMethod, paramu, "Unable to create call adapter for %s", new Object[] { paramType });
    }
  }
  
  private static <ResponseT> f<g0, ResponseT> e(u paramu, Method paramMethod, Type paramType)
  {
    Annotation[] arrayOfAnnotation = paramMethod.getAnnotations();
    try
    {
      paramu = paramu.h(paramType, arrayOfAnnotation);
      return paramu;
    }
    catch (RuntimeException paramu)
    {
      throw y.n(paramMethod, paramu, "Unable to create converter for %s", new Object[] { paramType });
    }
  }
  
  static <ResponseT, ReturnT> k<ResponseT, ReturnT> f(u paramu, Method paramMethod, s params)
  {
    boolean bool = params.k;
    Annotation[] arrayOfAnnotation = paramMethod.getAnnotations();
    int i;
    if (bool)
    {
      localObject1 = paramMethod.getGenericParameterTypes();
      localObject1 = y.f(0, (ParameterizedType)localObject1[(localObject1.length - 1)]);
      if ((y.h((Type)localObject1) == t.class) && ((localObject1 instanceof ParameterizedType)))
      {
        localObject1 = y.g(0, (ParameterizedType)localObject1);
        i = 1;
      }
      else
      {
        i = 0;
      }
      localObject2 = new y.b(null, b.class, new Type[] { localObject1 });
      localObject1 = x.a(arrayOfAnnotation);
    }
    else
    {
      localObject2 = paramMethod.getGenericReturnType();
      i = 0;
      localObject1 = arrayOfAnnotation;
    }
    Object localObject1 = d(paramu, paramMethod, (Type)localObject2, (Annotation[])localObject1);
    Object localObject2 = ((c)localObject1).a();
    if (localObject2 != f0.class)
    {
      if (localObject2 != t.class)
      {
        if ((params.c.equals("HEAD")) && (!Void.class.equals(localObject2))) {
          throw y.m(paramMethod, "HEAD method must use Void as response type.", new Object[0]);
        }
        paramMethod = e(paramu, paramMethod, (Type)localObject2);
        paramu = paramu.b;
        if (!bool) {
          return new a(params, paramu, paramMethod, (c)localObject1);
        }
        if (i != 0) {
          return new c(params, paramu, paramMethod, (c)localObject1);
        }
        return new b(params, paramu, paramMethod, (c)localObject1, false);
      }
      throw y.m(paramMethod, "Response must include generic type (e.g., Response<String>)", new Object[0]);
    }
    paramu = new StringBuilder();
    paramu.append("'");
    paramu.append(y.h((Type)localObject2).getName());
    paramu.append("' is not a valid response body type. Did you mean ResponseBody?");
    throw y.m(paramMethod, paramu.toString(), new Object[0]);
  }
  
  @Nullable
  final ReturnT a(Object[] paramArrayOfObject)
  {
    return c(new n(this.a, paramArrayOfObject, this.b, this.c), paramArrayOfObject);
  }
  
  @Nullable
  protected abstract ReturnT c(b<ResponseT> paramb, Object[] paramArrayOfObject);
  
  static final class a<ResponseT, ReturnT>
    extends k<ResponseT, ReturnT>
  {
    private final c<ResponseT, ReturnT> d;
    
    a(s params, e.a parama, f<g0, ResponseT> paramf, c<ResponseT, ReturnT> paramc)
    {
      super(parama, paramf);
      this.d = paramc;
    }
    
    protected ReturnT c(b<ResponseT> paramb, Object[] paramArrayOfObject)
    {
      return this.d.b(paramb);
    }
  }
  
  static final class b<ResponseT>
    extends k<ResponseT, Object>
  {
    private final c<ResponseT, b<ResponseT>> d;
    private final boolean e;
    
    b(s params, e.a parama, f<g0, ResponseT> paramf, c<ResponseT, b<ResponseT>> paramc, boolean paramBoolean)
    {
      super(parama, paramf);
      this.d = paramc;
      this.e = paramBoolean;
    }
    
    protected Object c(b<ResponseT> paramb, Object[] paramArrayOfObject)
    {
      b localb = (b)this.d.b(paramb);
      paramb = (a)paramArrayOfObject[(paramArrayOfObject.length - 1)];
      try
      {
        if (this.e) {
          return m.b(localb, paramb);
        }
        paramArrayOfObject = m.a(localb, paramb);
        return paramArrayOfObject;
      }
      catch (Exception paramArrayOfObject) {}
      return m.d(paramArrayOfObject, paramb);
    }
  }
  
  static final class c<ResponseT>
    extends k<ResponseT, Object>
  {
    private final c<ResponseT, b<ResponseT>> d;
    
    c(s params, e.a parama, f<g0, ResponseT> paramf, c<ResponseT, b<ResponseT>> paramc)
    {
      super(parama, paramf);
      this.d = paramc;
    }
    
    protected Object c(b<ResponseT> paramb, Object[] paramArrayOfObject)
    {
      b localb = (b)this.d.b(paramb);
      paramb = (a)paramArrayOfObject[(paramArrayOfObject.length - 1)];
      try
      {
        paramArrayOfObject = m.c(localb, paramb);
        return paramArrayOfObject;
      }
      catch (Exception paramArrayOfObject) {}
      return m.d(paramArrayOfObject, paramb);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.k
 * JD-Core Version:    0.7.0.1
 */