package j;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class b<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  c<K, V> a;
  private c<K, V> b;
  private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap();
  private int d = 0;
  
  public Iterator<Map.Entry<K, V>> a()
  {
    b localb = new b(this.b, this.a);
    this.c.put(localb, Boolean.FALSE);
    return localb;
  }
  
  public Map.Entry<K, V> b()
  {
    return this.a;
  }
  
  protected c<K, V> c(K paramK)
  {
    for (c localc = this.a; localc != null; localc = localc.c) {
      if (localc.a.equals(paramK)) {
        return localc;
      }
    }
    return localc;
  }
  
  public b<K, V>.d d()
  {
    d locald = new d();
    this.c.put(locald, Boolean.FALSE);
    return locald;
  }
  
  public Map.Entry<K, V> e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return false;
    }
    Object localObject1 = (b)paramObject;
    if (size() != ((b)localObject1).size()) {
      return false;
    }
    paramObject = iterator();
    localObject1 = ((b)localObject1).iterator();
    while ((paramObject.hasNext()) && (((Iterator)localObject1).hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)paramObject.next();
      Object localObject2 = ((Iterator)localObject1).next();
      if (((localEntry == null) && (localObject2 != null)) || ((localEntry != null) && (!localEntry.equals(localObject2)))) {
        return false;
      }
    }
    return (!paramObject.hasNext()) && (!((Iterator)localObject1).hasNext());
  }
  
  protected c<K, V> f(K paramK, V paramV)
  {
    paramK = new c(paramK, paramV);
    this.d += 1;
    paramV = this.b;
    if (paramV == null) {
      this.a = paramK;
    }
    for (;;)
    {
      this.b = paramK;
      return paramK;
      paramV.c = paramK;
      paramK.d = paramV;
    }
  }
  
  public V g(K paramK, V paramV)
  {
    c localc = c(paramK);
    if (localc != null) {
      return localc.b;
    }
    f(paramK, paramV);
    return null;
  }
  
  public V h(K paramK)
  {
    paramK = c(paramK);
    if (paramK == null) {
      return null;
    }
    this.d -= 1;
    if (!this.c.isEmpty())
    {
      localObject = this.c.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).a(paramK);
      }
    }
    Object localObject = paramK.d;
    c localc = paramK.c;
    if (localObject != null) {
      ((c)localObject).c = localc;
    } else {
      this.a = localc;
    }
    localc = paramK.c;
    if (localc != null) {
      localc.d = ((c)localObject);
    } else {
      this.b = ((c)localObject);
    }
    paramK.c = null;
    paramK.d = null;
    return paramK.b;
  }
  
  public int hashCode()
  {
    Iterator localIterator = iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((Map.Entry)localIterator.next()).hashCode();
    }
    return i;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    a locala = new a(this.a, this.b);
    this.c.put(locala, Boolean.FALSE);
    return locala;
  }
  
  public int size()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  static class a<K, V>
    extends b.e<K, V>
  {
    a(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    b.c<K, V> b(b.c<K, V> paramc)
    {
      return paramc.d;
    }
    
    b.c<K, V> c(b.c<K, V> paramc)
    {
      return paramc.c;
    }
  }
  
  private static class b<K, V>
    extends b.e<K, V>
  {
    b(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    b.c<K, V> b(b.c<K, V> paramc)
    {
      return paramc.c;
    }
    
    b.c<K, V> c(b.c<K, V> paramc)
    {
      return paramc.d;
    }
  }
  
  static class c<K, V>
    implements Map.Entry<K, V>
  {
    final K a;
    final V b;
    c<K, V> c;
    c<K, V> d;
    
    c(K paramK, V paramV)
    {
      this.a = paramK;
      this.b = paramV;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
      return (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b));
    }
    
    public K getKey()
    {
      return this.a;
    }
    
    public V getValue()
    {
      return this.b;
    }
    
    public int hashCode()
    {
      return this.a.hashCode() ^ this.b.hashCode();
    }
    
    public V setValue(V paramV)
    {
      throw new UnsupportedOperationException("An entry modification is not supported");
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("=");
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
    }
  }
  
  private class d
    implements Iterator<Map.Entry<K, V>>, b.f<K, V>
  {
    private b.c<K, V> a;
    private boolean b = true;
    
    d() {}
    
    public void a(b.c<K, V> paramc)
    {
      b.c localc = this.a;
      if (paramc == localc)
      {
        paramc = localc.d;
        this.a = paramc;
        boolean bool;
        if (paramc == null) {
          bool = true;
        } else {
          bool = false;
        }
        this.b = bool;
      }
    }
    
    public Map.Entry<K, V> b()
    {
      b.c localc;
      if (this.b)
      {
        this.b = false;
        localc = b.this.a;
      }
      for (;;)
      {
        this.a = localc;
        break;
        localc = this.a;
        if (localc != null) {
          localc = localc.c;
        } else {
          localc = null;
        }
      }
      return this.a;
    }
    
    public boolean hasNext()
    {
      if (this.b) {
        return b.this.a != null;
      }
      b.c localc = this.a;
      return (localc != null) && (localc.c != null);
    }
  }
  
  private static abstract class e<K, V>
    implements Iterator<Map.Entry<K, V>>, b.f<K, V>
  {
    b.c<K, V> a;
    b.c<K, V> b;
    
    e(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      this.a = paramc2;
      this.b = paramc1;
    }
    
    private b.c<K, V> e()
    {
      b.c localc1 = this.b;
      b.c localc2 = this.a;
      if ((localc1 != localc2) && (localc2 != null)) {
        return c(localc1);
      }
      return null;
    }
    
    public void a(b.c<K, V> paramc)
    {
      if ((this.a == paramc) && (paramc == this.b))
      {
        this.b = null;
        this.a = null;
      }
      b.c localc = this.a;
      if (localc == paramc) {
        this.a = b(localc);
      }
      if (this.b == paramc) {
        this.b = e();
      }
    }
    
    abstract b.c<K, V> b(b.c<K, V> paramc);
    
    abstract b.c<K, V> c(b.c<K, V> paramc);
    
    public Map.Entry<K, V> d()
    {
      b.c localc = this.b;
      this.b = e();
      return localc;
    }
    
    public boolean hasNext()
    {
      return this.b != null;
    }
  }
  
  static abstract interface f<K, V>
  {
    public abstract void a(b.c<K, V> paramc);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j.b
 * JD-Core Version:    0.7.0.1
 */