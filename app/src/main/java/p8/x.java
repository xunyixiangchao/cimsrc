package p8;

import a9.c;
import a9.f;
import b9.a;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class x
  implements List, Serializable, RandomAccess, a
{
  public static final x a = new x();
  
  public boolean a(Void paramVoid)
  {
    f.f(paramVoid, "element");
    return false;
  }
  
  public boolean addAll(int paramInt, Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public Void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Empty list doesn't contain element at index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append('.');
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public int c()
  {
    return 0;
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    f.f(paramCollection, "elements");
    return paramCollection.isEmpty();
  }
  
  public int d(Void paramVoid)
  {
    f.f(paramVoid, "element");
    return -1;
  }
  
  public int e(Void paramVoid)
  {
    f.f(paramVoid, "element");
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof List)) && (((List)paramObject).isEmpty());
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Iterator iterator()
  {
    return w.a;
  }
  
  public ListIterator listIterator()
  {
    return w.a;
  }
  
  public ListIterator listIterator(int paramInt)
  {
    if (paramInt == 0) {
      return w.a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index: ");
    localStringBuilder.append(paramInt);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public List subList(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromIndex: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", toIndex: ");
    localStringBuilder.append(paramInt2);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public Object[] toArray()
  {
    return c.a(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    f.f(paramArrayOfT, "array");
    return c.b(this, paramArrayOfT);
  }
  
  public String toString()
  {
    return "[]";
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.x
 * JD-Core Version:    0.7.0.1
 */