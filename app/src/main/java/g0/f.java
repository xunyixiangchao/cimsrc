package g0;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class f<K, V>
{
  f<K, V>.b a;
  f<K, V>.c b;
  f<K, V>.e c;
  
  public static <K, V> boolean j(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!paramMap.containsKey(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public static <T> boolean k(Set<T> paramSet, Object paramObject)
  {
    if (paramSet == paramObject) {
      return true;
    }
    if ((paramObject instanceof Set)) {
      paramObject = (Set)paramObject;
    }
    try
    {
      if (paramSet.size() == paramObject.size())
      {
        boolean bool = paramSet.containsAll(paramObject);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (NullPointerException|ClassCastException paramSet) {}
    return false;
    return false;
  }
  
  public static <K, V> boolean o(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      paramMap.remove(paramCollection.next());
    }
    return i != paramMap.size();
  }
  
  public static <K, V> boolean p(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!paramCollection.contains(localIterator.next())) {
        localIterator.remove();
      }
    }
    return i != paramMap.size();
  }
  
  protected abstract void a();
  
  protected abstract Object b(int paramInt1, int paramInt2);
  
  protected abstract Map<K, V> c();
  
  protected abstract int d();
  
  protected abstract int e(Object paramObject);
  
  protected abstract int f(Object paramObject);
  
  protected abstract void g(K paramK, V paramV);
  
  protected abstract void h(int paramInt);
  
  protected abstract V i(int paramInt, V paramV);
  
  public Set<Map.Entry<K, V>> l()
  {
    if (this.a == null) {
      this.a = new b();
    }
    return this.a;
  }
  
  public Set<K> m()
  {
    if (this.b == null) {
      this.b = new c();
    }
    return this.b;
  }
  
  public Collection<V> n()
  {
    if (this.c == null) {
      this.c = new e();
    }
    return this.c;
  }
  
  public Object[] q(int paramInt)
  {
    int j = d();
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = b(i, paramInt);
      i += 1;
    }
    return arrayOfObject;
  }
  
  public <T> T[] r(T[] paramArrayOfT, int paramInt)
  {
    int j = d();
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < j) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    }
    int i = 0;
    while (i < j)
    {
      localObject[i] = b(i, paramInt);
      i += 1;
    }
    if (localObject.length > j) {
      localObject[j] = null;
    }
    return localObject;
  }
  
  final class a<T>
    implements Iterator<T>
  {
    final int a;
    int b;
    int c;
    boolean d = false;
    
    a(int paramInt)
    {
      this.a = paramInt;
      this.b = f.this.d();
    }
    
    public boolean hasNext()
    {
      return this.c < this.b;
    }
    
    public T next()
    {
      if (hasNext())
      {
        Object localObject = f.this.b(this.c, this.a);
        this.c += 1;
        this.d = true;
        return localObject;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      if (this.d)
      {
        int i = this.c - 1;
        this.c = i;
        this.b -= 1;
        this.d = false;
        f.this.h(i);
        return;
      }
      throw new IllegalStateException();
    }
  }
  
  final class b
    implements Set<Map.Entry<K, V>>
  {
    b() {}
    
    public boolean a(Map.Entry<K, V> paramEntry)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
    {
      int i = f.this.d();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCollection.next();
        f.this.g(localEntry.getKey(), localEntry.getValue());
      }
      return i != f.this.d();
    }
    
    public void clear()
    {
      f.this.a();
    }
    
    public boolean contains(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      int i = f.this.e(paramObject.getKey());
      if (i < 0) {
        return false;
      }
      return c.c(f.this.b(i, 1), paramObject.getValue());
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public boolean equals(Object paramObject)
    {
      return f.k(this, paramObject);
    }
    
    public int hashCode()
    {
      int i = f.this.d() - 1;
      int j = 0;
      while (i >= 0)
      {
        Object localObject1 = f.this.b(i, 0);
        Object localObject2 = f.this.b(i, 1);
        int k;
        if (localObject1 == null) {
          k = 0;
        } else {
          k = localObject1.hashCode();
        }
        int m;
        if (localObject2 == null) {
          m = 0;
        } else {
          m = localObject2.hashCode();
        }
        j += (k ^ m);
        i -= 1;
      }
      return j;
    }
    
    public boolean isEmpty()
    {
      return f.this.d() == 0;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new f.d(f.this);
    }
    
    public boolean remove(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public int size()
    {
      return f.this.d();
    }
    
    public Object[] toArray()
    {
      throw new UnsupportedOperationException();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  final class c
    implements Set<K>
  {
    c() {}
    
    public boolean add(K paramK)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends K> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      f.this.a();
    }
    
    public boolean contains(Object paramObject)
    {
      return f.this.e(paramObject) >= 0;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return f.j(f.this.c(), paramCollection);
    }
    
    public boolean equals(Object paramObject)
    {
      return f.k(this, paramObject);
    }
    
    public int hashCode()
    {
      int i = f.this.d() - 1;
      int j = 0;
      while (i >= 0)
      {
        Object localObject = f.this.b(i, 0);
        int k;
        if (localObject == null) {
          k = 0;
        } else {
          k = localObject.hashCode();
        }
        j += k;
        i -= 1;
      }
      return j;
    }
    
    public boolean isEmpty()
    {
      return f.this.d() == 0;
    }
    
    public Iterator<K> iterator()
    {
      return new f.a(f.this, 0);
    }
    
    public boolean remove(Object paramObject)
    {
      int i = f.this.e(paramObject);
      if (i >= 0)
      {
        f.this.h(i);
        return true;
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return f.o(f.this.c(), paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return f.p(f.this.c(), paramCollection);
    }
    
    public int size()
    {
      return f.this.d();
    }
    
    public Object[] toArray()
    {
      return f.this.q(0);
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return f.this.r(paramArrayOfT, 0);
    }
  }
  
  final class d
    implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
  {
    int a = f.this.d() - 1;
    int b = -1;
    boolean c = false;
    
    d() {}
    
    public Map.Entry<K, V> a()
    {
      if (hasNext())
      {
        this.b += 1;
        this.c = true;
        return this;
      }
      throw new NoSuchElementException();
    }
    
    public boolean equals(Object paramObject)
    {
      if (this.c)
      {
        boolean bool1 = paramObject instanceof Map.Entry;
        boolean bool2 = false;
        if (!bool1) {
          return false;
        }
        paramObject = (Map.Entry)paramObject;
        bool1 = bool2;
        if (c.c(paramObject.getKey(), f.this.b(this.b, 0)))
        {
          bool1 = bool2;
          if (c.c(paramObject.getValue(), f.this.b(this.b, 1))) {
            bool1 = true;
          }
        }
        return bool1;
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public K getKey()
    {
      if (this.c) {
        return f.this.b(this.b, 0);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public V getValue()
    {
      if (this.c) {
        return f.this.b(this.b, 1);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public boolean hasNext()
    {
      return this.b < this.a;
    }
    
    public int hashCode()
    {
      if (this.c)
      {
        Object localObject1 = f.this;
        int i = this.b;
        int j = 0;
        localObject1 = ((f)localObject1).b(i, 0);
        Object localObject2 = f.this.b(this.b, 1);
        if (localObject1 == null) {
          i = 0;
        } else {
          i = localObject1.hashCode();
        }
        if (localObject2 != null) {
          j = localObject2.hashCode();
        }
        return i ^ j;
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public void remove()
    {
      if (this.c)
      {
        f.this.h(this.b);
        this.b -= 1;
        this.a -= 1;
        this.c = false;
        return;
      }
      throw new IllegalStateException();
    }
    
    public V setValue(V paramV)
    {
      if (this.c) {
        return f.this.i(this.b, paramV);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getKey());
      localStringBuilder.append("=");
      localStringBuilder.append(getValue());
      return localStringBuilder.toString();
    }
  }
  
  final class e
    implements Collection<V>
  {
    e() {}
    
    public boolean add(V paramV)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends V> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      f.this.a();
    }
    
    public boolean contains(Object paramObject)
    {
      return f.this.f(paramObject) >= 0;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public boolean isEmpty()
    {
      return f.this.d() == 0;
    }
    
    public Iterator<V> iterator()
    {
      return new f.a(f.this, 1);
    }
    
    public boolean remove(Object paramObject)
    {
      int i = f.this.f(paramObject);
      if (i >= 0)
      {
        f.this.h(i);
        return true;
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      int j = f.this.d();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int k = j;
        int m = i;
        if (paramCollection.contains(f.this.b(i, 1)))
        {
          f.this.h(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      return bool;
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      int j = f.this.d();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int k = j;
        int m = i;
        if (!paramCollection.contains(f.this.b(i, 1)))
        {
          f.this.h(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      return bool;
    }
    
    public int size()
    {
      return f.this.d();
    }
    
    public Object[] toArray()
    {
      return f.this.q(1);
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return f.this.r(paramArrayOfT, 1);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g0.f
 * JD-Core Version:    0.7.0.1
 */