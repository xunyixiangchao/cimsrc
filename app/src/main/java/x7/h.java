package x7;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public final class h<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> h = new a();
  Comparator<? super K> a;
  e<K, V> b;
  int c = 0;
  int d = 0;
  final e<K, V> e = new e();
  private h<K, V>.b f;
  private h<K, V>.c g;
  
  public h()
  {
    this(h);
  }
  
  public h(Comparator<? super K> paramComparator)
  {
    if (paramComparator == null) {
      paramComparator = h;
    }
    this.a = paramComparator;
  }
  
  private boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private void e(e<K, V> parame, boolean paramBoolean)
  {
    while (parame != null)
    {
      e locale1 = parame.b;
      e locale2 = parame.c;
      int m = 0;
      int k = 0;
      int i;
      if (locale1 != null) {
        i = locale1.h;
      } else {
        i = 0;
      }
      int j;
      if (locale2 != null) {
        j = locale2.h;
      } else {
        j = 0;
      }
      int n = i - j;
      e locale3;
      if (n == -2)
      {
        locale1 = locale2.b;
        locale3 = locale2.c;
        if (locale3 != null) {
          i = locale3.h;
        } else {
          i = 0;
        }
        j = k;
        if (locale1 != null) {
          j = locale1.h;
        }
        i = j - i;
        if ((i != -1) && ((i != 0) || (paramBoolean))) {
          j(locale2);
        }
        i(parame);
        if (!paramBoolean) {}
      }
      else if (n == 2)
      {
        locale2 = locale1.b;
        locale3 = locale1.c;
        if (locale3 != null) {
          i = locale3.h;
        } else {
          i = 0;
        }
        j = m;
        if (locale2 != null) {
          j = locale2.h;
        }
        i = j - i;
        if ((i != 1) && ((i != 0) || (paramBoolean))) {
          i(locale1);
        }
        j(parame);
        if (!paramBoolean) {}
      }
      else if (n == 0)
      {
        parame.h = (i + 1);
        if (!paramBoolean) {}
      }
      else
      {
        parame.h = (Math.max(i, j) + 1);
        if (!paramBoolean) {
          return;
        }
      }
      parame = parame.a;
    }
  }
  
  private void h(e<K, V> parame1, e<K, V> parame2)
  {
    e locale = parame1.a;
    parame1.a = null;
    if (parame2 != null) {
      parame2.a = locale;
    }
    if (locale != null)
    {
      if (locale.b == parame1)
      {
        locale.b = parame2;
        return;
      }
      locale.c = parame2;
      return;
    }
    this.b = parame2;
  }
  
  private void i(e<K, V> parame)
  {
    e locale1 = parame.b;
    e locale2 = parame.c;
    e locale3 = locale2.b;
    e locale4 = locale2.c;
    parame.c = locale3;
    if (locale3 != null) {
      locale3.a = parame;
    }
    h(parame, locale2);
    locale2.b = parame;
    parame.a = locale2;
    int k = 0;
    if (locale1 != null) {
      i = locale1.h;
    } else {
      i = 0;
    }
    if (locale3 != null) {
      j = locale3.h;
    } else {
      j = 0;
    }
    int j = Math.max(i, j) + 1;
    parame.h = j;
    int i = k;
    if (locale4 != null) {
      i = locale4.h;
    }
    locale2.h = (Math.max(j, i) + 1);
  }
  
  private void j(e<K, V> parame)
  {
    e locale1 = parame.b;
    e locale2 = parame.c;
    e locale3 = locale1.b;
    e locale4 = locale1.c;
    parame.b = locale4;
    if (locale4 != null) {
      locale4.a = parame;
    }
    h(parame, locale1);
    locale1.c = parame;
    parame.a = locale1;
    int k = 0;
    if (locale2 != null) {
      i = locale2.h;
    } else {
      i = 0;
    }
    if (locale4 != null) {
      j = locale4.h;
    } else {
      j = 0;
    }
    int j = Math.max(i, j) + 1;
    parame.h = j;
    int i = k;
    if (locale3 != null) {
      i = locale3.h;
    }
    locale1.h = (Math.max(j, i) + 1);
  }
  
  e<K, V> b(K paramK, boolean paramBoolean)
  {
    Comparator localComparator = this.a;
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      Comparable localComparable;
      if (localComparator == h) {
        localComparable = (Comparable)paramK;
      } else {
        localComparable = null;
      }
      for (;;)
      {
        localObject2 = ((e)localObject1).f;
        if (localComparable != null) {
          i = localComparable.compareTo(localObject2);
        } else {
          i = localComparator.compare(paramK, localObject2);
        }
        if (i == 0) {
          return localObject1;
        }
        if (i < 0) {
          localObject2 = ((e)localObject1).b;
        } else {
          localObject2 = ((e)localObject1).c;
        }
        if (localObject2 == null) {
          break;
        }
        localObject1 = localObject2;
      }
    }
    int i = 0;
    if (!paramBoolean) {
      return null;
    }
    Object localObject2 = this.e;
    if (localObject1 == null)
    {
      if ((localComparator == h) && (!(paramK instanceof Comparable)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramK.getClass().getName());
        ((StringBuilder)localObject1).append(" is not Comparable");
        throw new ClassCastException(((StringBuilder)localObject1).toString());
      }
      paramK = new e((e)localObject1, paramK, (e)localObject2, ((e)localObject2).e);
      this.b = paramK;
    }
    else
    {
      paramK = new e((e)localObject1, paramK, (e)localObject2, ((e)localObject2).e);
      if (i < 0) {
        ((e)localObject1).b = paramK;
      } else {
        ((e)localObject1).c = paramK;
      }
      e((e)localObject1, true);
    }
    this.c += 1;
    this.d += 1;
    return paramK;
  }
  
  e<K, V> c(Map.Entry<?, ?> paramEntry)
  {
    e locale = d(paramEntry.getKey());
    int i;
    if ((locale != null) && (a(locale.g, paramEntry.getValue()))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return locale;
    }
    return null;
  }
  
  public void clear()
  {
    this.b = null;
    this.c = 0;
    this.d += 1;
    e locale = this.e;
    locale.e = locale;
    locale.d = locale;
  }
  
  public boolean containsKey(Object paramObject)
  {
    return d(paramObject) != null;
  }
  
  e<K, V> d(Object paramObject)
  {
    e locale = null;
    if (paramObject != null) {}
    try
    {
      locale = b(paramObject, false);
      return locale;
    }
    catch (ClassCastException paramObject) {}
    return null;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    b localb = this.f;
    if (localb != null) {
      return localb;
    }
    localb = new b();
    this.f = localb;
    return localb;
  }
  
  void f(e<K, V> parame, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      locale1 = parame.e;
      locale1.d = parame.d;
      parame.d.e = locale1;
    }
    e locale1 = parame.b;
    e locale2 = parame.c;
    e locale3 = parame.a;
    int j = 0;
    if ((locale1 != null) && (locale2 != null))
    {
      if (locale1.h > locale2.h) {
        locale1 = locale1.b();
      } else {
        locale1 = locale2.a();
      }
      f(locale1, false);
      locale2 = parame.b;
      int i;
      if (locale2 != null)
      {
        i = locale2.h;
        locale1.b = locale2;
        locale2.a = locale1;
        parame.b = null;
      }
      else
      {
        i = 0;
      }
      locale2 = parame.c;
      if (locale2 != null)
      {
        j = locale2.h;
        locale1.c = locale2;
        locale2.a = locale1;
        parame.c = null;
      }
      locale1.h = (Math.max(i, j) + 1);
      h(parame, locale1);
      return;
    }
    if (locale1 != null)
    {
      h(parame, locale1);
      parame.b = null;
    }
    else if (locale2 != null)
    {
      h(parame, locale2);
      parame.c = null;
    }
    else
    {
      h(parame, null);
    }
    e(locale3, false);
    this.c -= 1;
    this.d += 1;
  }
  
  e<K, V> g(Object paramObject)
  {
    paramObject = d(paramObject);
    if (paramObject != null) {
      f(paramObject, true);
    }
    return paramObject;
  }
  
  public V get(Object paramObject)
  {
    paramObject = d(paramObject);
    if (paramObject != null) {
      return paramObject.g;
    }
    return null;
  }
  
  public Set<K> keySet()
  {
    c localc = this.g;
    if (localc != null) {
      return localc;
    }
    localc = new c();
    this.g = localc;
    return localc;
  }
  
  public V put(K paramK, V paramV)
  {
    Objects.requireNonNull(paramK, "key == null");
    paramK = b(paramK, true);
    Object localObject = paramK.g;
    paramK.g = paramV;
    return localObject;
  }
  
  public V remove(Object paramObject)
  {
    paramObject = g(paramObject);
    if (paramObject != null) {
      return paramObject.g;
    }
    return null;
  }
  
  public int size()
  {
    return this.c;
  }
  
  static final class a
    implements Comparator<Comparable>
  {
    public int a(Comparable paramComparable1, Comparable paramComparable2)
    {
      return paramComparable1.compareTo(paramComparable2);
    }
  }
  
  class b
    extends AbstractSet<Map.Entry<K, V>>
  {
    b() {}
    
    public void clear()
    {
      h.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Map.Entry)) && (h.this.c((Map.Entry)paramObject) != null);
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new a();
    }
    
    public boolean remove(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {
        return false;
      }
      paramObject = h.this.c((Map.Entry)paramObject);
      if (paramObject == null) {
        return false;
      }
      h.this.f(paramObject, true);
      return true;
    }
    
    public int size()
    {
      return h.this.c;
    }
    
    class a
      extends h<K, V>.d<Map.Entry<K, V>>
    {
      a()
      {
        super();
      }
      
      public Map.Entry<K, V> b()
      {
        return a();
      }
    }
  }
  
  final class c
    extends AbstractSet<K>
  {
    c() {}
    
    public void clear()
    {
      h.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return h.this.containsKey(paramObject);
    }
    
    public Iterator<K> iterator()
    {
      return new a();
    }
    
    public boolean remove(Object paramObject)
    {
      return h.this.g(paramObject) != null;
    }
    
    public int size()
    {
      return h.this.c;
    }
    
    class a
      extends h<K, V>.d<K>
    {
      a()
      {
        super();
      }
      
      public K next()
      {
        return a().f;
      }
    }
  }
  
  private abstract class d<T>
    implements Iterator<T>
  {
    h.e<K, V> a = h.this.e.d;
    h.e<K, V> b = null;
    int c = h.this.d;
    
    d() {}
    
    final h.e<K, V> a()
    {
      h.e locale = this.a;
      h localh = h.this;
      if (locale != localh.e)
      {
        if (localh.d == this.c)
        {
          this.a = locale.d;
          this.b = locale;
          return locale;
        }
        throw new ConcurrentModificationException();
      }
      throw new NoSuchElementException();
    }
    
    public final boolean hasNext()
    {
      return this.a != h.this.e;
    }
    
    public final void remove()
    {
      h.e locale = this.b;
      if (locale != null)
      {
        h.this.f(locale, true);
        this.b = null;
        this.c = h.this.d;
        return;
      }
      throw new IllegalStateException();
    }
  }
  
  static final class e<K, V>
    implements Map.Entry<K, V>
  {
    e<K, V> a;
    e<K, V> b;
    e<K, V> c;
    e<K, V> d;
    e<K, V> e;
    final K f;
    V g;
    int h;
    
    e()
    {
      this.f = null;
      this.e = this;
      this.d = this;
    }
    
    e(e<K, V> parame1, K paramK, e<K, V> parame2, e<K, V> parame3)
    {
      this.a = parame1;
      this.f = paramK;
      this.h = 1;
      this.d = parame2;
      this.e = parame3;
      parame3.d = this;
      parame2.e = this;
    }
    
    public e<K, V> a()
    {
      Object localObject1 = this.b;
      Object localObject2 = this;
      while (localObject1 != null)
      {
        e locale = ((e)localObject1).b;
        localObject2 = localObject1;
        localObject1 = locale;
      }
      return localObject2;
    }
    
    public e<K, V> b()
    {
      Object localObject1 = this.c;
      Object localObject2 = this;
      while (localObject1 != null)
      {
        e locale = ((e)localObject1).c;
        localObject2 = localObject1;
        localObject1 = locale;
      }
      return localObject2;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool3 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        paramObject = (Map.Entry)paramObject;
        Object localObject = this.f;
        if (localObject == null)
        {
          bool1 = bool2;
          if (paramObject.getKey() != null) {
            return bool1;
          }
        }
        else
        {
          bool1 = bool2;
          if (!localObject.equals(paramObject.getKey())) {
            return bool1;
          }
        }
        localObject = this.g;
        paramObject = paramObject.getValue();
        if (localObject == null)
        {
          bool1 = bool2;
          if (paramObject != null) {
            return bool1;
          }
        }
        else
        {
          bool1 = bool2;
          if (!localObject.equals(paramObject)) {
            return bool1;
          }
        }
        bool1 = true;
      }
      return bool1;
    }
    
    public K getKey()
    {
      return this.f;
    }
    
    public V getValue()
    {
      return this.g;
    }
    
    public int hashCode()
    {
      Object localObject = this.f;
      int j = 0;
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = localObject.hashCode();
      }
      localObject = this.g;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i ^ j;
    }
    
    public V setValue(V paramV)
    {
      Object localObject = this.g;
      this.g = paramV;
      return localObject;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.f);
      localStringBuilder.append("=");
      localStringBuilder.append(this.g);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x7.h
 * JD-Core Version:    0.7.0.1
 */