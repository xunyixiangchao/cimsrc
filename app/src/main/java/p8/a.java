package p8;

import a9.c;
import a9.f;
import a9.g;
import java.util.Collection;
import java.util.Iterator;
import z8.b;

public abstract class a<E>
  implements Collection<E>, b9.a
{
  public abstract int a();
  
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(E paramE)
  {
    boolean bool1 = isEmpty();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    Iterator localIterator = iterator();
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!f.a(localIterator.next(), paramE));
    bool1 = true;
    return bool1;
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
    return size() == 0;
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
  
  public Object[] toArray()
  {
    return c.a(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    f.f(paramArrayOfT, "array");
    paramArrayOfT = c.b(this, paramArrayOfT);
    f.d(paramArrayOfT, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt__CollectionsJVMKt.copyToArrayImpl>");
    return paramArrayOfT;
  }
  
  public String toString()
  {
    return v.B(this, ", ", "[", "]", 0, null, new a(this), 24, null);
  }
  
  static final class a
    extends g
    implements b<E, CharSequence>
  {
    a(a<? extends E> parama)
    {
      super();
    }
    
    public final CharSequence d(E paramE)
    {
      if (paramE == this.b) {
        return "(this Collection)";
      }
      return String.valueOf(paramE);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.a
 * JD-Core Version:    0.7.0.1
 */