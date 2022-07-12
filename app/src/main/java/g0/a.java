package g0;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V>
  extends g<K, V>
  implements Map<K, V>
{
  f<K, V> h;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public a(g paramg)
  {
    super(paramg);
  }
  
  private f<K, V> n()
  {
    if (this.h == null) {
      this.h = new a();
    }
    return this.h;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return n().l();
  }
  
  public Set<K> keySet()
  {
    return n().m();
  }
  
  public boolean o(Collection<?> paramCollection)
  {
    return f.p(this, paramCollection);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    c(this.c + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public Collection<V> values()
  {
    return n().n();
  }
  
  class a
    extends f<K, V>
  {
    a() {}
    
    protected void a()
    {
      a.this.clear();
    }
    
    protected Object b(int paramInt1, int paramInt2)
    {
      return a.this.b[((paramInt1 << 1) + paramInt2)];
    }
    
    protected Map<K, V> c()
    {
      return a.this;
    }
    
    protected int d()
    {
      return a.this.c;
    }
    
    protected int e(Object paramObject)
    {
      return a.this.f(paramObject);
    }
    
    protected int f(Object paramObject)
    {
      return a.this.h(paramObject);
    }
    
    protected void g(K paramK, V paramV)
    {
      a.this.put(paramK, paramV);
    }
    
    protected void h(int paramInt)
    {
      a.this.k(paramInt);
    }
    
    protected V i(int paramInt, V paramV)
    {
      return a.this.l(paramInt, paramV);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g0.a
 * JD-Core Version:    0.7.0.1
 */