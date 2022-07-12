package q8;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p8.b.a;
import p8.c;
import p8.e;
import p8.e.a;

public final class a<E>
  extends c<E>
  implements RandomAccess, Serializable
{
  private E[] a;
  private int b;
  private int c;
  private boolean d;
  private final a<E> e;
  private final a<E> f;
  
  public a()
  {
    this(10);
  }
  
  public a(int paramInt)
  {
    this(b.d(paramInt), 0, 0, false, null, null);
  }
  
  private a(E[] paramArrayOfE, int paramInt1, int paramInt2, boolean paramBoolean, a<E> parama1, a<E> parama2)
  {
    this.a = paramArrayOfE;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean;
    this.e = parama1;
    this.f = parama2;
  }
  
  private final void f(int paramInt1, Collection<? extends E> paramCollection, int paramInt2)
  {
    a locala = this.e;
    if (locala != null)
    {
      locala.f(paramInt1, paramCollection, paramInt2);
      this.a = this.e.a;
      this.c += paramInt2;
      return;
    }
    m(paramInt1, paramInt2);
    int i = 0;
    paramCollection = paramCollection.iterator();
    while (i < paramInt2)
    {
      this.a[(paramInt1 + i)] = paramCollection.next();
      i += 1;
    }
  }
  
  private final void g(int paramInt, E paramE)
  {
    a locala = this.e;
    if (locala != null)
    {
      locala.g(paramInt, paramE);
      this.a = this.e.a;
      this.c += 1;
      return;
    }
    m(paramInt, 1);
    this.a[paramInt] = paramE;
  }
  
  private final void i()
  {
    if (!n()) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private final boolean j(List<?> paramList)
  {
    return b.a(this.a, this.b, this.c, paramList);
  }
  
  private final void k(int paramInt)
  {
    if (this.e == null)
    {
      if (paramInt >= 0)
      {
        Object[] arrayOfObject = this.a;
        if (paramInt > arrayOfObject.length)
        {
          paramInt = e.d.a(arrayOfObject.length, paramInt);
          this.a = b.e(this.a, paramInt);
        }
        return;
      }
      throw new OutOfMemoryError();
    }
    throw new IllegalStateException();
  }
  
  private final void l(int paramInt)
  {
    k(this.c + paramInt);
  }
  
  private final void m(int paramInt1, int paramInt2)
  {
    l(paramInt2);
    Object[] arrayOfObject = this.a;
    p8.f.e(arrayOfObject, arrayOfObject, paramInt1 + paramInt2, paramInt1, this.b + this.c);
    this.c += paramInt2;
  }
  
  private final boolean n()
  {
    if (!this.d)
    {
      a locala = this.f;
      if ((locala == null) || (!locala.d)) {
        return false;
      }
    }
    return true;
  }
  
  private final E o(int paramInt)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((a)localObject).o(paramInt);
      this.c -= 1;
      return localObject;
    }
    localObject = this.a;
    E ? = localObject[paramInt];
    p8.f.e((Object[])localObject, (Object[])localObject, paramInt, paramInt + 1, this.b + this.c);
    b.f(this.a, this.b + this.c - 1);
    this.c -= 1;
    return ?;
  }
  
  private final void p(int paramInt1, int paramInt2)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((a)localObject).p(paramInt1, paramInt2);
    }
    else
    {
      localObject = this.a;
      p8.f.e((Object[])localObject, (Object[])localObject, paramInt1, paramInt1 + paramInt2, this.c);
      localObject = this.a;
      paramInt1 = this.c;
      b.g((Object[])localObject, paramInt1 - paramInt2, paramInt1);
    }
    this.c -= paramInt2;
  }
  
  private final int q(int paramInt1, int paramInt2, Collection<? extends E> paramCollection, boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      paramInt1 = ((a)localObject).q(paramInt1, paramInt2, paramCollection, paramBoolean);
      this.c -= paramInt1;
      return paramInt1;
    }
    int i = 0;
    int j = 0;
    while (i < paramInt2)
    {
      localObject = this.a;
      int k = paramInt1 + i;
      if (paramCollection.contains(localObject[k]) == paramBoolean)
      {
        localObject = this.a;
        i += 1;
        localObject[(j + paramInt1)] = localObject[k];
        j += 1;
      }
      else
      {
        i += 1;
      }
    }
    i = paramInt2 - j;
    paramCollection = this.a;
    p8.f.e(paramCollection, paramCollection, paramInt1 + j, paramInt2 + paramInt1, this.c);
    paramCollection = this.a;
    paramInt1 = this.c;
    b.g(paramCollection, paramInt1 - i, paramInt1);
    this.c -= i;
    return i;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void add(int paramInt, E paramE)
  {
    i();
    p8.b.a.c(paramInt, this.c);
    g(this.b + paramInt, paramE);
  }
  
  public boolean add(E paramE)
  {
    i();
    g(this.b + this.c, paramE);
    return true;
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    a9.f.f(paramCollection, "elements");
    i();
    p8.b.a.c(paramInt, this.c);
    int i = paramCollection.size();
    f(this.b + paramInt, paramCollection, i);
    return i > 0;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    a9.f.f(paramCollection, "elements");
    i();
    int i = paramCollection.size();
    f(this.b + this.c, paramCollection, i);
    return i > 0;
  }
  
  public E b(int paramInt)
  {
    i();
    p8.b.a.b(paramInt, this.c);
    return o(this.b + paramInt);
  }
  
  public void clear()
  {
    i();
    p(this.b, this.c);
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof List)) && (j((List)paramObject)));
  }
  
  public E get(int paramInt)
  {
    p8.b.a.b(paramInt, this.c);
    return this.a[(this.b + paramInt)];
  }
  
  public final List<E> h()
  {
    if (this.e == null)
    {
      i();
      this.d = true;
      return this;
    }
    throw new IllegalStateException();
  }
  
  public int hashCode()
  {
    return b.b(this.a, this.b, this.c);
  }
  
  public int indexOf(Object paramObject)
  {
    int i = 0;
    while (i < this.c)
    {
      if (a9.f.a(this.a[(this.b + i)], paramObject)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.c == 0;
  }
  
  public Iterator<E> iterator()
  {
    return new a(this, 0);
  }
  
  public int lastIndexOf(Object paramObject)
  {
    int i = this.c - 1;
    while (i >= 0)
    {
      if (a9.f.a(this.a[(this.b + i)], paramObject)) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public ListIterator<E> listIterator()
  {
    return new a(this, 0);
  }
  
  public ListIterator<E> listIterator(int paramInt)
  {
    p8.b.a.c(paramInt, this.c);
    return new a(this, paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    i();
    int i = indexOf(paramObject);
    if (i >= 0) {
      remove(i);
    }
    return i >= 0;
  }
  
  public boolean removeAll(Collection<? extends Object> paramCollection)
  {
    a9.f.f(paramCollection, "elements");
    i();
    int i = this.b;
    int j = this.c;
    boolean bool = false;
    if (q(i, j, paramCollection, false) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean retainAll(Collection<? extends Object> paramCollection)
  {
    a9.f.f(paramCollection, "elements");
    i();
    return q(this.b, this.c, paramCollection, true) > 0;
  }
  
  public E set(int paramInt, E paramE)
  {
    i();
    p8.b.a.b(paramInt, this.c);
    Object[] arrayOfObject = this.a;
    int i = this.b;
    Object localObject = arrayOfObject[(i + paramInt)];
    arrayOfObject[(i + paramInt)] = paramE;
    return localObject;
  }
  
  public List<E> subList(int paramInt1, int paramInt2)
  {
    p8.b.a.d(paramInt1, paramInt2, this.c);
    Object[] arrayOfObject = this.a;
    int i = this.b;
    boolean bool = this.d;
    a locala = this.f;
    if (locala == null) {
      locala = this;
    }
    return new a(arrayOfObject, i + paramInt1, paramInt2 - paramInt1, bool, this, locala);
  }
  
  public Object[] toArray()
  {
    Object[] arrayOfObject = this.a;
    int i = this.b;
    arrayOfObject = p8.f.i(arrayOfObject, i, this.c + i);
    a9.f.d(arrayOfObject, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    return arrayOfObject;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    a9.f.f(paramArrayOfT, "destination");
    int j = paramArrayOfT.length;
    int i = this.c;
    if (j < i)
    {
      arrayOfObject = this.a;
      j = this.b;
      paramArrayOfT = Arrays.copyOfRange(arrayOfObject, j, i + j, paramArrayOfT.getClass());
      a9.f.e(paramArrayOfT, "copyOfRange(array, offse…h, destination.javaClass)");
      return paramArrayOfT;
    }
    Object[] arrayOfObject = this.a;
    a9.f.d(arrayOfObject, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilder.toArray>");
    i = this.b;
    p8.f.e(arrayOfObject, paramArrayOfT, 0, i, this.c + i);
    i = paramArrayOfT.length;
    j = this.c;
    if (i > j) {
      paramArrayOfT[j] = null;
    }
    return paramArrayOfT;
  }
  
  public String toString()
  {
    return b.c(this.a, this.b, this.c);
  }
  
  private static final class a<E>
    implements ListIterator<E>, b9.a
  {
    private final a<E> a;
    private int b;
    private int c;
    
    public a(a<E> parama, int paramInt)
    {
      this.a = parama;
      this.b = paramInt;
      this.c = -1;
    }
    
    public void add(E paramE)
    {
      a locala = this.a;
      int i = this.b;
      this.b = (i + 1);
      locala.add(i, paramE);
      this.c = -1;
    }
    
    public boolean hasNext()
    {
      return this.b < a.d(this.a);
    }
    
    public boolean hasPrevious()
    {
      return this.b > 0;
    }
    
    public E next()
    {
      if (this.b < a.d(this.a))
      {
        int i = this.b;
        this.b = (i + 1);
        this.c = i;
        return a.c(this.a)[(a.e(this.a) + this.c)];
      }
      throw new NoSuchElementException();
    }
    
    public int nextIndex()
    {
      return this.b;
    }
    
    public E previous()
    {
      int i = this.b;
      if (i > 0)
      {
        i -= 1;
        this.b = i;
        this.c = i;
        return a.c(this.a)[(a.e(this.a) + this.c)];
      }
      throw new NoSuchElementException();
    }
    
    public int previousIndex()
    {
      return this.b - 1;
    }
    
    public void remove()
    {
      int j = this.c;
      int i;
      if (j != -1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.a.remove(j);
        this.b = this.c;
        this.c = -1;
        return;
      }
      throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
    }
    
    public void set(E paramE)
    {
      int j = this.c;
      int i;
      if (j != -1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.a.set(j, paramE);
        return;
      }
      throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q8.a
 * JD-Core Version:    0.7.0.1
 */