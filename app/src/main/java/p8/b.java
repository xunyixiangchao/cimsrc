package p8;

import a9.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public abstract class b<E>
  extends a<E>
  implements List<E>
{
  public static final a a = new a(null);
  
  public void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof List)) {
      return false;
    }
    return a.e(this, (Collection)paramObject);
  }
  
  public abstract E get(int paramInt);
  
  public int hashCode()
  {
    return a.f(this);
  }
  
  public int indexOf(E paramE)
  {
    Iterator localIterator = iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      if (f.a(localIterator.next(), paramE)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public Iterator<E> iterator()
  {
    return new b();
  }
  
  public int lastIndexOf(E paramE)
  {
    ListIterator localListIterator = listIterator(size());
    while (localListIterator.hasPrevious()) {
      if (f.a(localListIterator.previous(), paramE)) {
        return localListIterator.nextIndex();
      }
    }
    return -1;
  }
  
  public ListIterator<E> listIterator()
  {
    return new c(0);
  }
  
  public ListIterator<E> listIterator(int paramInt)
  {
    return new c(paramInt);
  }
  
  public E remove(int paramInt)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public List<E> subList(int paramInt1, int paramInt2)
  {
    return new d(this, paramInt1, paramInt2);
  }
  
  public static final class a
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt1 >= 0) && (paramInt2 <= paramInt3))
      {
        if (paramInt1 <= paramInt2) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startIndex: ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" > endIndex: ");
        localStringBuilder.append(paramInt2);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startIndex: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", endIndex: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", size: ");
      localStringBuilder.append(paramInt3);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    public final void b(int paramInt1, int paramInt2)
    {
      if ((paramInt1 >= 0) && (paramInt1 < paramInt2)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("index: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", size: ");
      localStringBuilder.append(paramInt2);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    public final void c(int paramInt1, int paramInt2)
    {
      if ((paramInt1 >= 0) && (paramInt1 <= paramInt2)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("index: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", size: ");
      localStringBuilder.append(paramInt2);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    public final void d(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt1 >= 0) && (paramInt2 <= paramInt3))
      {
        if (paramInt1 <= paramInt2) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fromIndex: ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" > toIndex: ");
        localStringBuilder.append(paramInt2);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fromIndex: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", toIndex: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", size: ");
      localStringBuilder.append(paramInt3);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    public final boolean e(Collection<?> paramCollection1, Collection<?> paramCollection2)
    {
      f.f(paramCollection1, "c");
      f.f(paramCollection2, "other");
      if (paramCollection1.size() != paramCollection2.size()) {
        return false;
      }
      paramCollection2 = paramCollection2.iterator();
      paramCollection1 = paramCollection1.iterator();
      while (paramCollection1.hasNext()) {
        if (!f.a(paramCollection1.next(), paramCollection2.next())) {
          return false;
        }
      }
      return true;
    }
    
    public final int f(Collection<?> paramCollection)
    {
      f.f(paramCollection, "c");
      paramCollection = paramCollection.iterator();
      int j;
      for (int i = 1; paramCollection.hasNext(); i = i * 31 + j)
      {
        Object localObject = paramCollection.next();
        if (localObject != null) {
          j = localObject.hashCode();
        } else {
          j = 0;
        }
      }
      return i;
    }
  }
  
  private class b
    implements Iterator<E>, b9.a
  {
    private int a;
    
    protected final int a()
    {
      return this.a;
    }
    
    protected final void b(int paramInt)
    {
      this.a = paramInt;
    }
    
    public boolean hasNext()
    {
      return this.a < this.b.size();
    }
    
    public E next()
    {
      if (hasNext())
      {
        b localb = this.b;
        int i = this.a;
        this.a = (i + 1);
        return localb.get(i);
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
  }
  
  private class c
    extends b<E>.b
    implements ListIterator<E>
  {
    public c()
    {
      super();
      int i;
      b.a.c(i, b.this.size());
      b(i);
    }
    
    public void add(E paramE)
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    public boolean hasPrevious()
    {
      return a() > 0;
    }
    
    public int nextIndex()
    {
      return a();
    }
    
    public E previous()
    {
      if (hasPrevious())
      {
        b localb = b.this;
        b(a() - 1);
        return localb.get(a());
      }
      throw new NoSuchElementException();
    }
    
    public int previousIndex()
    {
      return a() - 1;
    }
    
    public void set(E paramE)
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
  }
  
  private static final class d<E>
    extends b<E>
    implements RandomAccess
  {
    private final b<E> b;
    private final int c;
    private int d;
    
    public d(b<? extends E> paramb, int paramInt1, int paramInt2)
    {
      this.b = paramb;
      this.c = paramInt1;
      b.a.d(paramInt1, paramInt2, paramb.size());
      this.d = (paramInt2 - paramInt1);
    }
    
    public int a()
    {
      return this.d;
    }
    
    public E get(int paramInt)
    {
      b.a.b(paramInt, this.d);
      return this.b.get(this.c + paramInt);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.b
 * JD-Core Version:    0.7.0.1
 */