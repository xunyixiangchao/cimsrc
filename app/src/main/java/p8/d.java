package p8;

import a9.b;
import a9.c;
import a9.f;
import b9.a;
import java.util.Collection;
import java.util.Iterator;

final class d<T>
  implements Collection<T>, a
{
  private final T[] a;
  private final boolean b;
  
  public d(T[] paramArrayOfT, boolean paramBoolean)
  {
    this.a = paramArrayOfT;
    this.b = paramBoolean;
  }
  
  public int a()
  {
    return this.a.length;
  }
  
  public boolean add(T paramT)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(Object paramObject)
  {
    return j.m(this.a, paramObject);
  }
  
  public boolean containsAll(Collection<? extends Object> paramCollection)
  {
    f.f(paramCollection, "elements");
    boolean bool1 = paramCollection.isEmpty();
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    paramCollection = paramCollection.iterator();
    do
    {
      bool1 = bool2;
      if (!paramCollection.hasNext()) {
        break;
      }
    } while (contains(paramCollection.next()));
    bool1 = false;
    return bool1;
  }
  
  public boolean isEmpty()
  {
    return this.a.length == 0;
  }
  
  public Iterator<T> iterator()
  {
    return b.a(this.a);
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final Object[] toArray()
  {
    return m.b(this.a, this.b);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    f.f(paramArrayOfT, "array");
    return c.b(this, paramArrayOfT);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.d
 * JD-Core Version:    0.7.0.1
 */