package y7;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import v7.q;
import v7.t;
import v7.v;
import v7.w;
import x7.i;

public final class g
  implements w
{
  private final x7.c a;
  final boolean b;
  
  public g(x7.c paramc, boolean paramBoolean)
  {
    this.a = paramc;
    this.b = paramBoolean;
  }
  
  private v<?> b(v7.f paramf, Type paramType)
  {
    if ((paramType != Boolean.TYPE) && (paramType != Boolean.class)) {
      return paramf.k(com.google.gson.reflect.a.get(paramType));
    }
    return n.f;
  }
  
  public <T> v<T> a(v7.f paramf, com.google.gson.reflect.a<T> parama)
  {
    Object localObject = parama.getType();
    if (!Map.class.isAssignableFrom(parama.getRawType())) {
      return null;
    }
    localObject = x7.b.j((Type)localObject, x7.b.k((Type)localObject));
    v localv1 = b(paramf, localObject[0]);
    v localv2 = paramf.k(com.google.gson.reflect.a.get(localObject[1]));
    parama = this.a.a(parama);
    return new a(paramf, localObject[0], localv1, localObject[1], localv2, parama);
  }
  
  private final class a<K, V>
    extends v<Map<K, V>>
  {
    private final v<K> a;
    private final v<V> b;
    private final i<? extends Map<K, V>> c;
    
    public a(Type paramType1, v<K> paramv, Type paramType2, v<V> paramv1, i<? extends Map<K, V>> parami)
    {
      this.a = new m(paramType1, paramType2, paramv);
      this.b = new m(paramType1, parami, paramv1);
      Object localObject;
      this.c = localObject;
    }
    
    private String e(v7.l paraml)
    {
      if (paraml.g())
      {
        paraml = paraml.c();
        if (paraml.q()) {
          return String.valueOf(paraml.m());
        }
        if (paraml.o()) {
          return Boolean.toString(paraml.h());
        }
        if (paraml.s()) {
          return paraml.n();
        }
        throw new AssertionError();
      }
      if (paraml.e()) {
        return "null";
      }
      throw new AssertionError();
    }
    
    public Map<K, V> f(b8.a parama)
    {
      Object localObject = parama.u0();
      if (localObject == b8.b.i)
      {
        parama.q0();
        return null;
      }
      Map localMap = (Map)this.c.a();
      if (localObject == b8.b.a)
      {
        parama.a();
        while (parama.g0())
        {
          parama.a();
          localObject = this.a.b(parama);
          if (localMap.put(localObject, this.b.b(parama)) == null)
          {
            parama.d0();
          }
          else
          {
            parama = new StringBuilder();
            parama.append("duplicate key: ");
            parama.append(localObject);
            throw new t(parama.toString());
          }
        }
        parama.d0();
        return localMap;
      }
      parama.g();
      while (parama.g0())
      {
        x7.f.a.a(parama);
        localObject = this.a.b(parama);
        if (localMap.put(localObject, this.b.b(parama)) != null)
        {
          parama = new StringBuilder();
          parama.append("duplicate key: ");
          parama.append(localObject);
          throw new t(parama.toString());
        }
      }
      parama.e0();
      return localMap;
    }
    
    public void g(b8.c paramc, Map<K, V> paramMap)
    {
      if (paramMap == null)
      {
        paramc.k0();
        return;
      }
      if (!g.this.b)
      {
        paramc.i();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (Map.Entry)paramMap.next();
          paramc.i0(String.valueOf(((Map.Entry)localObject).getKey()));
          this.b.d(paramc, ((Map.Entry)localObject).getValue());
        }
        paramc.e0();
        return;
      }
      Object localObject = new ArrayList(paramMap.size());
      ArrayList localArrayList = new ArrayList(paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      int m = 0;
      int k = 0;
      int i = 0;
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        v7.l locall = this.a.c(localEntry.getKey());
        ((List)localObject).add(locall);
        localArrayList.add(localEntry.getValue());
        if ((!locall.d()) && (!locall.f())) {
          j = 0;
        } else {
          j = 1;
        }
        i |= j;
      }
      if (i != 0)
      {
        paramc.h();
        j = ((List)localObject).size();
        i = k;
        while (i < j)
        {
          paramc.h();
          x7.l.b((v7.l)((List)localObject).get(i), paramc);
          this.b.d(paramc, localArrayList.get(i));
          paramc.d0();
          i += 1;
        }
        paramc.d0();
        return;
      }
      paramc.i();
      int j = ((List)localObject).size();
      i = m;
      while (i < j)
      {
        paramc.i0(e((v7.l)((List)localObject).get(i)));
        this.b.d(paramc, localArrayList.get(i));
        i += 1;
      }
      paramc.e0();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.g
 * JD-Core Version:    0.7.0.1
 */