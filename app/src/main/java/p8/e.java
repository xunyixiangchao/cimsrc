package p8;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class e<E>
  extends c<E>
{
  public static final a d = new a(null);
  private static final Object[] e = new Object[0];
  private int a;
  private Object[] b = e;
  private int c;
  
  private final void e(int paramInt, Collection<? extends E> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    int i = this.b.length;
    while ((paramInt < i) && (localIterator.hasNext()))
    {
      this.b[paramInt] = localIterator.next();
      paramInt += 1;
    }
    paramInt = 0;
    i = this.a;
    while ((paramInt < i) && (localIterator.hasNext()))
    {
      this.b[paramInt] = localIterator.next();
      paramInt += 1;
    }
    this.c = (size() + paramCollection.size());
  }
  
  private final void f(int paramInt)
  {
    Object[] arrayOfObject1 = new Object[paramInt];
    Object[] arrayOfObject2 = this.b;
    f.e(arrayOfObject2, arrayOfObject1, 0, this.a, arrayOfObject2.length);
    arrayOfObject2 = this.b;
    paramInt = arrayOfObject2.length;
    int i = this.a;
    f.e(arrayOfObject2, arrayOfObject1, paramInt - i, 0, i);
    this.a = 0;
    this.b = arrayOfObject1;
  }
  
  private final int g(int paramInt)
  {
    if (paramInt == 0) {
      return f.p(this.b);
    }
    return paramInt - 1;
  }
  
  private final void h(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object[] arrayOfObject = this.b;
      if (paramInt <= arrayOfObject.length) {
        return;
      }
      if (arrayOfObject == e)
      {
        this.b = new Object[c9.g.b(paramInt, 10)];
        return;
      }
      f(d.a(arrayOfObject.length, paramInt));
      return;
    }
    throw new IllegalStateException("Deque is too big.");
  }
  
  private final int i(int paramInt)
  {
    if (paramInt == f.p(this.b)) {
      return 0;
    }
    return paramInt + 1;
  }
  
  private final int j(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = paramInt + this.b.length;
    }
    return i;
  }
  
  private final int k(int paramInt)
  {
    Object[] arrayOfObject = this.b;
    int i = paramInt;
    if (paramInt >= arrayOfObject.length) {
      i = paramInt - arrayOfObject.length;
    }
    return i;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void add(int paramInt, E paramE)
  {
    b.a.c(paramInt, size());
    if (paramInt == size())
    {
      d(paramE);
      return;
    }
    if (paramInt == 0)
    {
      c(paramE);
      return;
    }
    h(size() + 1);
    int i = k(this.a + paramInt);
    Object[] arrayOfObject;
    if (paramInt < size() + 1 >> 1)
    {
      paramInt = g(i);
      i = g(this.a);
      int j = this.a;
      if (paramInt >= j)
      {
        arrayOfObject = this.b;
        arrayOfObject[i] = arrayOfObject[j];
        f.e(arrayOfObject, arrayOfObject, j, j + 1, paramInt + 1);
      }
      else
      {
        arrayOfObject = this.b;
        f.e(arrayOfObject, arrayOfObject, j - 1, j, arrayOfObject.length);
        arrayOfObject = this.b;
        arrayOfObject[(arrayOfObject.length - 1)] = arrayOfObject[0];
        f.e(arrayOfObject, arrayOfObject, 0, 1, paramInt + 1);
      }
      this.b[paramInt] = paramE;
      this.a = i;
    }
    else
    {
      paramInt = k(this.a + size());
      arrayOfObject = this.b;
      if (i < paramInt)
      {
        f.e(arrayOfObject, arrayOfObject, i + 1, i, paramInt);
      }
      else
      {
        f.e(arrayOfObject, arrayOfObject, 1, 0, paramInt);
        arrayOfObject = this.b;
        arrayOfObject[0] = arrayOfObject[(arrayOfObject.length - 1)];
        f.e(arrayOfObject, arrayOfObject, i + 1, i, arrayOfObject.length - 1);
      }
      this.b[i] = paramE;
    }
    this.c = (size() + 1);
  }
  
  public boolean add(E paramE)
  {
    d(paramE);
    return true;
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    a9.f.f(paramCollection, "elements");
    b.a.c(paramInt, size());
    if (paramCollection.isEmpty()) {
      return false;
    }
    if (paramInt == size()) {
      return addAll(paramCollection);
    }
    h(size() + paramCollection.size());
    int k = k(this.a + size());
    int i = k(this.a + paramInt);
    int j = paramCollection.size();
    Object[] arrayOfObject;
    if (paramInt < size() + 1 >> 1)
    {
      k = this.a;
      paramInt = k - j;
      if (i >= k)
      {
        if (paramInt >= 0)
        {
          arrayOfObject = this.b;
          f.e(arrayOfObject, arrayOfObject, paramInt, k, i);
        }
        else
        {
          arrayOfObject = this.b;
          paramInt += arrayOfObject.length;
          int m = arrayOfObject.length - paramInt;
          if (m >= i - k)
          {
            f.e(arrayOfObject, arrayOfObject, paramInt, k, i);
          }
          else
          {
            f.e(arrayOfObject, arrayOfObject, paramInt, k, k + m);
            arrayOfObject = this.b;
            f.e(arrayOfObject, arrayOfObject, 0, this.a + m, i);
          }
        }
      }
      else
      {
        arrayOfObject = this.b;
        f.e(arrayOfObject, arrayOfObject, paramInt, k, arrayOfObject.length);
        arrayOfObject = this.b;
        if (j >= i)
        {
          f.e(arrayOfObject, arrayOfObject, arrayOfObject.length - j, 0, i);
        }
        else
        {
          f.e(arrayOfObject, arrayOfObject, arrayOfObject.length - j, 0, j);
          arrayOfObject = this.b;
          f.e(arrayOfObject, arrayOfObject, 0, j, i);
        }
      }
      this.a = paramInt;
      e(j(i - j), paramCollection);
      return true;
    }
    paramInt = i + j;
    if (i < k)
    {
      j += k;
      arrayOfObject = this.b;
      if (j <= arrayOfObject.length) {}
      for (;;)
      {
        f.e(arrayOfObject, arrayOfObject, paramInt, i, k);
        break label537;
        if (paramInt < arrayOfObject.length) {
          break;
        }
        paramInt -= arrayOfObject.length;
      }
      j = k - (j - arrayOfObject.length);
      f.e(arrayOfObject, arrayOfObject, 0, j, k);
      arrayOfObject = this.b;
      f.e(arrayOfObject, arrayOfObject, paramInt, i, j);
    }
    else
    {
      arrayOfObject = this.b;
      f.e(arrayOfObject, arrayOfObject, j, 0, k);
      arrayOfObject = this.b;
      if (paramInt >= arrayOfObject.length)
      {
        f.e(arrayOfObject, arrayOfObject, paramInt - arrayOfObject.length, i, arrayOfObject.length);
      }
      else
      {
        f.e(arrayOfObject, arrayOfObject, 0, arrayOfObject.length - j, arrayOfObject.length);
        arrayOfObject = this.b;
        f.e(arrayOfObject, arrayOfObject, paramInt, i, arrayOfObject.length - j);
      }
    }
    label537:
    e(i, paramCollection);
    return true;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    a9.f.f(paramCollection, "elements");
    if (paramCollection.isEmpty()) {
      return false;
    }
    h(size() + paramCollection.size());
    e(k(this.a + size()), paramCollection);
    return true;
  }
  
  public E b(int paramInt)
  {
    b.a.b(paramInt, size());
    if (paramInt == l.j(this)) {
      return m();
    }
    if (paramInt == 0) {
      return l();
    }
    int i = k(this.a + paramInt);
    Object localObject = this.b[i];
    Object[] arrayOfObject;
    if (paramInt < size() >> 1)
    {
      paramInt = this.a;
      if (i >= paramInt)
      {
        arrayOfObject = this.b;
        f.e(arrayOfObject, arrayOfObject, paramInt + 1, paramInt, i);
      }
      else
      {
        arrayOfObject = this.b;
        f.e(arrayOfObject, arrayOfObject, 1, 0, i);
        arrayOfObject = this.b;
        arrayOfObject[0] = arrayOfObject[(arrayOfObject.length - 1)];
        paramInt = this.a;
        f.e(arrayOfObject, arrayOfObject, paramInt + 1, paramInt, arrayOfObject.length - 1);
      }
      arrayOfObject = this.b;
      paramInt = this.a;
      arrayOfObject[paramInt] = null;
      this.a = i(paramInt);
    }
    else
    {
      paramInt = k(this.a + l.j(this));
      arrayOfObject = this.b;
      if (i <= paramInt)
      {
        f.e(arrayOfObject, arrayOfObject, i, i + 1, paramInt + 1);
      }
      else
      {
        f.e(arrayOfObject, arrayOfObject, i, i + 1, arrayOfObject.length);
        arrayOfObject = this.b;
        arrayOfObject[(arrayOfObject.length - 1)] = arrayOfObject[0];
        f.e(arrayOfObject, arrayOfObject, 0, 1, paramInt + 1);
      }
      this.b[paramInt] = null;
    }
    this.c = (size() - 1);
    return localObject;
  }
  
  public final void c(E paramE)
  {
    h(size() + 1);
    int i = g(this.a);
    this.a = i;
    this.b[i] = paramE;
    this.c = (size() + 1);
  }
  
  public void clear()
  {
    int i = k(this.a + size());
    int j = this.a;
    if (j < i)
    {
      f.k(this.b, null, j, i);
    }
    else if ((isEmpty() ^ true))
    {
      Object[] arrayOfObject = this.b;
      f.k(arrayOfObject, null, this.a, arrayOfObject.length);
      f.k(this.b, null, 0, i);
    }
    this.a = 0;
    this.c = 0;
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) != -1;
  }
  
  public final void d(E paramE)
  {
    h(size() + 1);
    this.b[k(this.a + size())] = paramE;
    this.c = (size() + 1);
  }
  
  public E get(int paramInt)
  {
    b.a.b(paramInt, size());
    return this.b[k(this.a + paramInt)];
  }
  
  public int indexOf(Object paramObject)
  {
    int j = k(this.a + size());
    int i = this.a;
    if (i < j) {
      while (i < j)
      {
        if (a9.f.a(paramObject, this.b[i])) {
          return i - this.a;
        }
        i += 1;
      }
    }
    if (i >= j)
    {
      int k = this.b.length;
      for (;;)
      {
        if (i >= k) {
          break label97;
        }
        if (a9.f.a(paramObject, this.b[i])) {
          break;
        }
        i += 1;
      }
      label97:
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label135;
        }
        if (a9.f.a(paramObject, this.b[i]))
        {
          i += this.b.length;
          break;
        }
        i += 1;
      }
    }
    label135:
    return -1;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public final E l()
  {
    if (!isEmpty())
    {
      Object[] arrayOfObject = this.b;
      int i = this.a;
      Object localObject = arrayOfObject[i];
      arrayOfObject[i] = null;
      this.a = i(i);
      this.c = (size() - 1);
      return localObject;
    }
    throw new NoSuchElementException("ArrayDeque is empty.");
  }
  
  public int lastIndexOf(Object paramObject)
  {
    int i = k(this.a + size());
    int j = this.a;
    if (j < i)
    {
      i -= 1;
      if (j > i) {
        break label156;
      }
      if (!a9.f.a(paramObject, this.b[i])) {}
    }
    for (;;)
    {
      return i - this.a;
      if (i == j) {
        break label156;
      }
      i -= 1;
      break;
      if (j <= i) {
        break label156;
      }
      i -= 1;
      for (;;)
      {
        if (-1 >= i) {
          break label110;
        }
        if (a9.f.a(paramObject, this.b[i]))
        {
          i += this.b.length;
          break;
        }
        i -= 1;
      }
      label110:
      i = f.p(this.b);
      j = this.a;
      if (j > i) {
        break label156;
      }
      while (!a9.f.a(paramObject, this.b[i]))
      {
        if (i == j) {
          break label156;
        }
        i -= 1;
      }
    }
    label156:
    return -1;
  }
  
  public final E m()
  {
    if (!isEmpty())
    {
      int i = k(this.a + l.j(this));
      Object[] arrayOfObject = this.b;
      Object localObject = arrayOfObject[i];
      arrayOfObject[i] = null;
      this.c = (size() - 1);
      return localObject;
    }
    throw new NoSuchElementException("ArrayDeque is empty.");
  }
  
  public boolean remove(Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i == -1) {
      return false;
    }
    remove(i);
    return true;
  }
  
  public boolean removeAll(Collection<? extends Object> paramCollection)
  {
    a9.f.f(paramCollection, "elements");
    boolean bool3 = isEmpty();
    int k = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool3)
    {
      if (this.b.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return false;
      }
      int m = k(this.a + size());
      int i = this.a;
      int j;
      Object localObject1;
      if (i < m)
      {
        j = i;
        while (i < m)
        {
          localObject1 = this.b[i];
          if ((paramCollection.contains(localObject1) ^ true))
          {
            this.b[j] = localObject1;
            j += 1;
          }
          else
          {
            bool1 = true;
          }
          i += 1;
        }
        f.k(this.b, null, j, m);
        i = j;
      }
      else
      {
        int n = this.b.length;
        bool1 = false;
        j = i;
        Object localObject2;
        while (i < n)
        {
          localObject1 = this.b;
          localObject2 = localObject1[i];
          localObject1[i] = null;
          if ((paramCollection.contains(localObject2) ^ true))
          {
            this.b[j] = localObject2;
            j += 1;
          }
          else
          {
            bool1 = true;
          }
          i += 1;
        }
        i = k(j);
        j = k;
        while (j < m)
        {
          localObject1 = this.b;
          localObject2 = localObject1[j];
          localObject1[j] = null;
          if ((paramCollection.contains(localObject2) ^ true))
          {
            this.b[i] = localObject2;
            i = i(i);
          }
          else
          {
            bool1 = true;
          }
          j += 1;
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        this.c = j(i - this.a);
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public boolean retainAll(Collection<? extends Object> paramCollection)
  {
    a9.f.f(paramCollection, "elements");
    boolean bool3 = isEmpty();
    int k = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool3)
    {
      if (this.b.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return false;
      }
      int m = k(this.a + size());
      int i = this.a;
      int j;
      Object localObject1;
      if (i < m)
      {
        j = i;
        while (i < m)
        {
          localObject1 = this.b[i];
          if (paramCollection.contains(localObject1))
          {
            this.b[j] = localObject1;
            j += 1;
          }
          else
          {
            bool1 = true;
          }
          i += 1;
        }
        f.k(this.b, null, j, m);
        i = j;
      }
      else
      {
        int n = this.b.length;
        bool1 = false;
        j = i;
        Object localObject2;
        while (i < n)
        {
          localObject1 = this.b;
          localObject2 = localObject1[i];
          localObject1[i] = null;
          if (paramCollection.contains(localObject2))
          {
            this.b[j] = localObject2;
            j += 1;
          }
          else
          {
            bool1 = true;
          }
          i += 1;
        }
        i = k(j);
        j = k;
        while (j < m)
        {
          localObject1 = this.b;
          localObject2 = localObject1[j];
          localObject1[j] = null;
          if (paramCollection.contains(localObject2))
          {
            this.b[i] = localObject2;
            i = i(i);
          }
          else
          {
            bool1 = true;
          }
          j += 1;
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        this.c = j(i - this.a);
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public E set(int paramInt, E paramE)
  {
    b.a.b(paramInt, size());
    paramInt = k(this.a + paramInt);
    Object[] arrayOfObject = this.b;
    Object localObject = arrayOfObject[paramInt];
    arrayOfObject[paramInt] = paramE;
    return localObject;
  }
  
  public Object[] toArray()
  {
    return toArray(new Object[size()]);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    a9.f.f(paramArrayOfT, "array");
    if (paramArrayOfT.length < size()) {
      paramArrayOfT = g.a(paramArrayOfT, size());
    }
    a9.f.d(paramArrayOfT, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    int i = k(this.a + size());
    int j = this.a;
    if (j < i)
    {
      i.g(this.b, paramArrayOfT, 0, j, i, 2, null);
    }
    else if ((isEmpty() ^ true))
    {
      Object[] arrayOfObject = this.b;
      f.e(arrayOfObject, paramArrayOfT, 0, this.a, arrayOfObject.length);
      arrayOfObject = this.b;
      f.e(arrayOfObject, paramArrayOfT, arrayOfObject.length - this.a, 0, i);
    }
    if (paramArrayOfT.length > size()) {
      paramArrayOfT[size()] = null;
    }
    return paramArrayOfT;
  }
  
  public static final class a
  {
    public final int a(int paramInt1, int paramInt2)
    {
      int i = paramInt1 + (paramInt1 >> 1);
      paramInt1 = i;
      if (i - paramInt2 < 0) {
        paramInt1 = paramInt2;
      }
      i = paramInt1;
      if (paramInt1 - 2147483639 > 0)
      {
        if (paramInt2 > 2147483639) {
          return 2147483647;
        }
        i = 2147483639;
      }
      return i;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.e
 * JD-Core Version:    0.7.0.1
 */