package ea;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import l9.a0.c;
import l9.e0;
import l9.w;

abstract class p<T>
{
  abstract void a(r paramr, @Nullable T paramT);
  
  final p<Object> b()
  {
    return new b();
  }
  
  final p<Iterable<T>> c()
  {
    return new a();
  }
  
  class a
    extends p<Iterable<T>>
  {
    a() {}
    
    void d(r paramr, @Nullable Iterable<T> paramIterable)
    {
      if (paramIterable == null) {
        return;
      }
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        p.this.a(paramr, localObject);
      }
    }
  }
  
  class b
    extends p<Object>
  {
    b() {}
    
    void a(r paramr, @Nullable Object paramObject)
    {
      if (paramObject == null) {
        return;
      }
      int i = 0;
      int j = Array.getLength(paramObject);
      while (i < j)
      {
        p.this.a(paramr, Array.get(paramObject, i));
        i += 1;
      }
    }
  }
  
  static final class c<T>
    extends p<T>
  {
    private final Method a;
    private final int b;
    private final f<T, e0> c;
    
    c(Method paramMethod, int paramInt, f<T, e0> paramf)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = paramf;
    }
    
    void a(r paramr, @Nullable T paramT)
    {
      if (paramT != null) {
        try
        {
          localObject = (e0)this.c.convert(paramT);
          paramr.l((e0)localObject);
          return;
        }
        catch (IOException paramr)
        {
          Object localObject = this.a;
          int i = this.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unable to convert ");
          localStringBuilder.append(paramT);
          localStringBuilder.append(" to RequestBody");
          throw y.p((Method)localObject, paramr, i, localStringBuilder.toString(), new Object[0]);
        }
      }
      throw y.o(this.a, this.b, "Body parameter value must not be null.", new Object[0]);
    }
  }
  
  static final class d<T>
    extends p<T>
  {
    private final String a;
    private final f<T, String> b;
    private final boolean c;
    
    d(String paramString, f<T, String> paramf, boolean paramBoolean)
    {
      Objects.requireNonNull(paramString, "name == null");
      this.a = paramString;
      this.b = paramf;
      this.c = paramBoolean;
    }
    
    void a(r paramr, @Nullable T paramT)
    {
      if (paramT == null) {
        return;
      }
      paramT = (String)this.b.convert(paramT);
      if (paramT == null) {
        return;
      }
      paramr.a(this.a, paramT, this.c);
    }
  }
  
  static final class e<T>
    extends p<Map<String, T>>
  {
    private final Method a;
    private final int b;
    private final f<T, String> c;
    private final boolean d;
    
    e(Method paramMethod, int paramInt, f<T, String> paramf, boolean paramBoolean)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = paramf;
      this.d = paramBoolean;
    }
    
    void d(r paramr, @Nullable Map<String, T> paramMap)
    {
      if (paramMap != null)
      {
        Object localObject2 = paramMap.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject1 = (Map.Entry)((Iterator)localObject2).next();
          paramMap = (String)((Map.Entry)localObject1).getKey();
          if (paramMap != null)
          {
            localObject1 = ((Map.Entry)localObject1).getValue();
            int i;
            if (localObject1 != null)
            {
              String str = (String)this.c.convert(localObject1);
              if (str != null)
              {
                paramr.a(paramMap, str, this.d);
              }
              else
              {
                paramr = this.a;
                i = this.b;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Field map value '");
                ((StringBuilder)localObject2).append(localObject1);
                ((StringBuilder)localObject2).append("' converted to null by ");
                ((StringBuilder)localObject2).append(this.c.getClass().getName());
                ((StringBuilder)localObject2).append(" for key '");
                ((StringBuilder)localObject2).append(paramMap);
                ((StringBuilder)localObject2).append("'.");
                throw y.o(paramr, i, ((StringBuilder)localObject2).toString(), new Object[0]);
              }
            }
            else
            {
              paramr = this.a;
              i = this.b;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Field map contained null value for key '");
              ((StringBuilder)localObject1).append(paramMap);
              ((StringBuilder)localObject1).append("'.");
              throw y.o(paramr, i, ((StringBuilder)localObject1).toString(), new Object[0]);
            }
          }
          else
          {
            throw y.o(this.a, this.b, "Field map contained null key.", new Object[0]);
          }
        }
        return;
      }
      throw y.o(this.a, this.b, "Field map was null.", new Object[0]);
    }
  }
  
  static final class f<T>
    extends p<T>
  {
    private final String a;
    private final f<T, String> b;
    
    f(String paramString, f<T, String> paramf)
    {
      Objects.requireNonNull(paramString, "name == null");
      this.a = paramString;
      this.b = paramf;
    }
    
    void a(r paramr, @Nullable T paramT)
    {
      if (paramT == null) {
        return;
      }
      paramT = (String)this.b.convert(paramT);
      if (paramT == null) {
        return;
      }
      paramr.b(this.a, paramT);
    }
  }
  
  static final class g<T>
    extends p<Map<String, T>>
  {
    private final Method a;
    private final int b;
    private final f<T, String> c;
    
    g(Method paramMethod, int paramInt, f<T, String> paramf)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = paramf;
    }
    
    void d(r paramr, @Nullable Map<String, T> paramMap)
    {
      if (paramMap != null)
      {
        Object localObject1 = paramMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramMap = (String)((Map.Entry)localObject2).getKey();
          if (paramMap != null)
          {
            localObject2 = ((Map.Entry)localObject2).getValue();
            if (localObject2 != null)
            {
              paramr.b(paramMap, (String)this.c.convert(localObject2));
            }
            else
            {
              paramr = this.a;
              int i = this.b;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Header map contained null value for key '");
              ((StringBuilder)localObject1).append(paramMap);
              ((StringBuilder)localObject1).append("'.");
              throw y.o(paramr, i, ((StringBuilder)localObject1).toString(), new Object[0]);
            }
          }
          else
          {
            throw y.o(this.a, this.b, "Header map contained null key.", new Object[0]);
          }
        }
        return;
      }
      throw y.o(this.a, this.b, "Header map was null.", new Object[0]);
    }
  }
  
  static final class h
    extends p<w>
  {
    private final Method a;
    private final int b;
    
    h(Method paramMethod, int paramInt)
    {
      this.a = paramMethod;
      this.b = paramInt;
    }
    
    void d(r paramr, @Nullable w paramw)
    {
      if (paramw != null)
      {
        paramr.c(paramw);
        return;
      }
      throw y.o(this.a, this.b, "Headers parameter must not be null.", new Object[0]);
    }
  }
  
  static final class i<T>
    extends p<T>
  {
    private final Method a;
    private final int b;
    private final w c;
    private final f<T, e0> d;
    
    i(Method paramMethod, int paramInt, w paramw, f<T, e0> paramf)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = paramw;
      this.d = paramf;
    }
    
    void a(r paramr, @Nullable T paramT)
    {
      if (paramT == null) {
        return;
      }
      try
      {
        localObject = (e0)this.d.convert(paramT);
        paramr.d(this.c, (e0)localObject);
        return;
      }
      catch (IOException paramr)
      {
        Object localObject = this.a;
        int i = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to convert ");
        localStringBuilder.append(paramT);
        localStringBuilder.append(" to RequestBody");
        throw y.o((Method)localObject, i, localStringBuilder.toString(), new Object[] { paramr });
      }
    }
  }
  
  static final class j<T>
    extends p<Map<String, T>>
  {
    private final Method a;
    private final int b;
    private final f<T, e0> c;
    private final String d;
    
    j(Method paramMethod, int paramInt, f<T, e0> paramf, String paramString)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = paramf;
      this.d = paramString;
    }
    
    void d(r paramr, @Nullable Map<String, T> paramMap)
    {
      if (paramMap != null)
      {
        Object localObject1 = paramMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramMap = (String)((Map.Entry)localObject2).getKey();
          if (paramMap != null)
          {
            localObject2 = ((Map.Entry)localObject2).getValue();
            if (localObject2 != null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("form-data; name=\"");
              localStringBuilder.append(paramMap);
              localStringBuilder.append("\"");
              paramr.d(w.e(new String[] { "Content-Disposition", localStringBuilder.toString(), "Content-Transfer-Encoding", this.d }), (e0)this.c.convert(localObject2));
            }
            else
            {
              paramr = this.a;
              int i = this.b;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Part map contained null value for key '");
              ((StringBuilder)localObject1).append(paramMap);
              ((StringBuilder)localObject1).append("'.");
              throw y.o(paramr, i, ((StringBuilder)localObject1).toString(), new Object[0]);
            }
          }
          else
          {
            throw y.o(this.a, this.b, "Part map contained null key.", new Object[0]);
          }
        }
        return;
      }
      throw y.o(this.a, this.b, "Part map was null.", new Object[0]);
    }
  }
  
  static final class k<T>
    extends p<T>
  {
    private final Method a;
    private final int b;
    private final String c;
    private final f<T, String> d;
    private final boolean e;
    
    k(Method paramMethod, int paramInt, String paramString, f<T, String> paramf, boolean paramBoolean)
    {
      this.a = paramMethod;
      this.b = paramInt;
      Objects.requireNonNull(paramString, "name == null");
      this.c = paramString;
      this.d = paramf;
      this.e = paramBoolean;
    }
    
    void a(r paramr, @Nullable T paramT)
    {
      if (paramT != null)
      {
        paramr.f(this.c, (String)this.d.convert(paramT), this.e);
        return;
      }
      paramr = this.a;
      int i = this.b;
      paramT = new StringBuilder();
      paramT.append("Path parameter \"");
      paramT.append(this.c);
      paramT.append("\" value must not be null.");
      throw y.o(paramr, i, paramT.toString(), new Object[0]);
    }
  }
  
  static final class l<T>
    extends p<T>
  {
    private final String a;
    private final f<T, String> b;
    private final boolean c;
    
    l(String paramString, f<T, String> paramf, boolean paramBoolean)
    {
      Objects.requireNonNull(paramString, "name == null");
      this.a = paramString;
      this.b = paramf;
      this.c = paramBoolean;
    }
    
    void a(r paramr, @Nullable T paramT)
    {
      if (paramT == null) {
        return;
      }
      paramT = (String)this.b.convert(paramT);
      if (paramT == null) {
        return;
      }
      paramr.g(this.a, paramT, this.c);
    }
  }
  
  static final class m<T>
    extends p<Map<String, T>>
  {
    private final Method a;
    private final int b;
    private final f<T, String> c;
    private final boolean d;
    
    m(Method paramMethod, int paramInt, f<T, String> paramf, boolean paramBoolean)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = paramf;
      this.d = paramBoolean;
    }
    
    void d(r paramr, @Nullable Map<String, T> paramMap)
    {
      if (paramMap != null)
      {
        Object localObject2 = paramMap.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject1 = (Map.Entry)((Iterator)localObject2).next();
          paramMap = (String)((Map.Entry)localObject1).getKey();
          if (paramMap != null)
          {
            localObject1 = ((Map.Entry)localObject1).getValue();
            int i;
            if (localObject1 != null)
            {
              String str = (String)this.c.convert(localObject1);
              if (str != null)
              {
                paramr.g(paramMap, str, this.d);
              }
              else
              {
                paramr = this.a;
                i = this.b;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Query map value '");
                ((StringBuilder)localObject2).append(localObject1);
                ((StringBuilder)localObject2).append("' converted to null by ");
                ((StringBuilder)localObject2).append(this.c.getClass().getName());
                ((StringBuilder)localObject2).append(" for key '");
                ((StringBuilder)localObject2).append(paramMap);
                ((StringBuilder)localObject2).append("'.");
                throw y.o(paramr, i, ((StringBuilder)localObject2).toString(), new Object[0]);
              }
            }
            else
            {
              paramr = this.a;
              i = this.b;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Query map contained null value for key '");
              ((StringBuilder)localObject1).append(paramMap);
              ((StringBuilder)localObject1).append("'.");
              throw y.o(paramr, i, ((StringBuilder)localObject1).toString(), new Object[0]);
            }
          }
          else
          {
            throw y.o(this.a, this.b, "Query map contained null key.", new Object[0]);
          }
        }
        return;
      }
      throw y.o(this.a, this.b, "Query map was null", new Object[0]);
    }
  }
  
  static final class n<T>
    extends p<T>
  {
    private final f<T, String> a;
    private final boolean b;
    
    n(f<T, String> paramf, boolean paramBoolean)
    {
      this.a = paramf;
      this.b = paramBoolean;
    }
    
    void a(r paramr, @Nullable T paramT)
    {
      if (paramT == null) {
        return;
      }
      paramr.g((String)this.a.convert(paramT), null, this.b);
    }
  }
  
  static final class o
    extends p<a0.c>
  {
    static final o a = new o();
    
    void d(r paramr, @Nullable a0.c paramc)
    {
      if (paramc != null) {
        paramr.e(paramc);
      }
    }
  }
  
  static final class p
    extends p<Object>
  {
    private final Method a;
    private final int b;
    
    p(Method paramMethod, int paramInt)
    {
      this.a = paramMethod;
      this.b = paramInt;
    }
    
    void a(r paramr, @Nullable Object paramObject)
    {
      if (paramObject != null)
      {
        paramr.m(paramObject);
        return;
      }
      throw y.o(this.a, this.b, "@Url parameter is null.", new Object[0]);
    }
  }
  
  static final class q<T>
    extends p<T>
  {
    final Class<T> a;
    
    q(Class<T> paramClass)
    {
      this.a = paramClass;
    }
    
    void a(r paramr, @Nullable T paramT)
    {
      paramr.h(this.a, paramT);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.p
 * JD-Core Version:    0.7.0.1
 */