package p8;

import a9.c;
import a9.f;
import b9.a;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class z
  implements Set, Serializable, a
{
  public static final z a = new z();
  
  public boolean a(Void paramVoid)
  {
    f.f(paramVoid, "element");
    return false;
  }
  
  public boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public int b()
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
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Set)) && (((Set)paramObject).isEmpty());
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Iterator iterator()
  {
    return w.a;
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
 * Qualified Name:     p8.z
 * JD-Core Version:    0.7.0.1
 */