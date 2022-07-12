package l9;

import a9.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import m9.i;
import m9.o;
import o8.h;
import p8.c0;
import p8.l;

public final class d0
{
  private final x a;
  private final String b;
  private final w c;
  private final e0 d;
  private final Map<Class<?>, Object> e;
  private d f;
  
  public d0(x paramx, String paramString, w paramw, e0 parame0, Map<Class<?>, ? extends Object> paramMap)
  {
    this.a = paramx;
    this.b = paramString;
    this.c = paramw;
    this.d = parame0;
    this.e = paramMap;
  }
  
  public final e0 a()
  {
    return this.d;
  }
  
  public final d b()
  {
    d locald2 = this.f;
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = d.n.a(this.c);
      this.f = locald1;
    }
    return locald1;
  }
  
  public final Map<Class<?>, Object> c()
  {
    return this.e;
  }
  
  public final String d(String paramString)
  {
    f.f(paramString, "name");
    return i.c(this, paramString);
  }
  
  public final w e()
  {
    return this.c;
  }
  
  public final boolean f()
  {
    return this.a.j();
  }
  
  public final String g()
  {
    return this.b;
  }
  
  public final a h()
  {
    return new a(this);
  }
  
  public final <T> T i(Class<? extends T> paramClass)
  {
    f.f(paramClass, "type");
    return paramClass.cast(this.e.get(paramClass));
  }
  
  public final x j()
  {
    return this.a;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Request{method=");
    ((StringBuilder)localObject1).append(g());
    ((StringBuilder)localObject1).append(", url=");
    ((StringBuilder)localObject1).append(j());
    if (e().size() != 0)
    {
      ((StringBuilder)localObject1).append(", headers=[");
      Object localObject2 = e();
      int i = 0;
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          l.p();
        }
        Object localObject4 = (h)localObject3;
        localObject3 = (String)((h)localObject4).a();
        localObject4 = (String)((h)localObject4).b();
        if (i > 0) {
          ((StringBuilder)localObject1).append(", ");
        }
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(':');
        ((StringBuilder)localObject1).append((String)localObject4);
        i += 1;
      }
      ((StringBuilder)localObject1).append(']');
    }
    if ((c().isEmpty() ^ true))
    {
      ((StringBuilder)localObject1).append(", tags=");
      ((StringBuilder)localObject1).append(c());
    }
    ((StringBuilder)localObject1).append('}');
    localObject1 = ((StringBuilder)localObject1).toString();
    f.e(localObject1, "StringBuilder().apply(builderAction).toString()");
    return localObject1;
  }
  
  public static class a
  {
    private x a;
    private String b;
    private w.a c;
    private e0 d;
    private Map<Class<?>, Object> e = new LinkedHashMap();
    
    public a()
    {
      this.b = "GET";
      this.c = new w.a();
    }
    
    public a(d0 paramd0)
    {
      this.a = paramd0.j();
      this.b = paramd0.g();
      this.d = paramd0.a();
      Object localObject;
      if (paramd0.c().isEmpty()) {
        localObject = new LinkedHashMap();
      } else {
        localObject = c0.e(paramd0.c());
      }
      this.e = ((Map)localObject);
      this.c = paramd0.e().d();
    }
    
    public a a(String paramString1, String paramString2)
    {
      f.f(paramString1, "name");
      f.f(paramString2, "value");
      return i.b(this, paramString1, paramString2);
    }
    
    public d0 b()
    {
      x localx = this.a;
      if (localx != null) {
        return new d0(localx, this.b, this.c.f(), this.d, o.v(this.e));
      }
      throw new IllegalStateException("url == null".toString());
    }
    
    public final w.a c()
    {
      return this.c;
    }
    
    public final Map<Class<?>, Object> d()
    {
      return this.e;
    }
    
    public a e(String paramString1, String paramString2)
    {
      f.f(paramString1, "name");
      f.f(paramString2, "value");
      return i.d(this, paramString1, paramString2);
    }
    
    public a f(w paramw)
    {
      f.f(paramw, "headers");
      return i.e(this, paramw);
    }
    
    public a g(String paramString, e0 parame0)
    {
      f.f(paramString, "method");
      return i.f(this, paramString, parame0);
    }
    
    public a h(String paramString)
    {
      f.f(paramString, "name");
      return i.g(this, paramString);
    }
    
    public final void i(e0 parame0)
    {
      this.d = parame0;
    }
    
    public final void j(w.a parama)
    {
      f.f(parama, "<set-?>");
      this.c = parama;
    }
    
    public final void k(String paramString)
    {
      f.f(paramString, "<set-?>");
      this.b = paramString;
    }
    
    public final void l(Map<Class<?>, Object> paramMap)
    {
      f.f(paramMap, "<set-?>");
      this.e = paramMap;
    }
    
    public final void m(x paramx)
    {
      this.a = paramx;
    }
    
    public <T> a n(Class<? super T> paramClass, T paramT)
    {
      f.f(paramClass, "type");
      if (paramT == null)
      {
        d().remove(paramClass);
        return this;
      }
      if (d().isEmpty()) {
        l(new LinkedHashMap());
      }
      Map localMap = d();
      paramT = paramClass.cast(paramT);
      f.c(paramT);
      localMap.put(paramClass, paramT);
      return this;
    }
    
    public a o(String paramString)
    {
      f.f(paramString, "url");
      return p(x.k.d(i.a(paramString)));
    }
    
    public a p(x paramx)
    {
      f.f(paramx, "url");
      m(paramx);
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.d0
 * JD-Core Version:    0.7.0.1
 */