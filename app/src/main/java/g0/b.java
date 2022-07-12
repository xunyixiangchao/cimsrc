package g0;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E>
  implements Collection<E>, Set<E>
{
  private static final int[] e = new int[0];
  private static final Object[] f = new Object[0];
  private static Object[] g;
  private static int h;
  private static Object[] i;
  private static int j;
  private int[] a;
  Object[] b;
  int c;
  private f<E, E> d;
  
  public b()
  {
    this(0);
  }
  
  public b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a = e;
      this.b = f;
    }
    else
    {
      a(paramInt);
    }
    this.c = 0;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        Object[] arrayOfObject1 = i;
        if (arrayOfObject1 != null)
        {
          this.b = arrayOfObject1;
          i = (Object[])arrayOfObject1[0];
          this.a = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          j -= 1;
          return;
        }
      }
      finally {}
    } else if (paramInt == 4) {
      try
      {
        Object[] arrayOfObject2 = g;
        if (arrayOfObject2 != null)
        {
          this.b = arrayOfObject2;
          g = (Object[])arrayOfObject2[0];
          this.a = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          h -= 1;
          return;
        }
      }
      finally {}
    }
    this.a = new int[paramInt];
    this.b = new Object[paramInt];
  }
  
  private static void c(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (j < 10)
        {
          paramArrayOfObject[0] = i;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label114;
          i = paramArrayOfObject;
          j += 1;
        }
        return;
      }
      finally {}
    } else if (paramArrayOfInt.length != 4) {}
    for (;;)
    {
      try
      {
        if (h < 10)
        {
          paramArrayOfObject[0] = g;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          g = paramArrayOfObject;
          h += 1;
        }
        return;
      }
      finally {}
      return;
      label114:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label130:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  private f<E, E> d()
  {
    if (this.d == null) {
      this.d = new a();
    }
    return this.d;
  }
  
  private int e(Object paramObject, int paramInt)
  {
    int m = this.c;
    if (m == 0) {
      return -1;
    }
    int n = c.a(this.a, m, paramInt);
    if (n < 0) {
      return n;
    }
    if (paramObject.equals(this.b[n])) {
      return n;
    }
    int k = n + 1;
    while ((k < m) && (this.a[k] == paramInt))
    {
      if (paramObject.equals(this.b[k])) {
        return k;
      }
      k += 1;
    }
    m = n - 1;
    while ((m >= 0) && (this.a[m] == paramInt))
    {
      if (paramObject.equals(this.b[m])) {
        return m;
      }
      m -= 1;
    }
    return k;
  }
  
  private int f()
  {
    int m = this.c;
    if (m == 0) {
      return -1;
    }
    int n = c.a(this.a, m, 0);
    if (n < 0) {
      return n;
    }
    if (this.b[n] == null) {
      return n;
    }
    int k = n + 1;
    while ((k < m) && (this.a[k] == 0))
    {
      if (this.b[k] == null) {
        return k;
      }
      k += 1;
    }
    m = n - 1;
    while ((m >= 0) && (this.a[m] == 0))
    {
      if (this.b[m] == null) {
        return m;
      }
      m -= 1;
    }
    return k;
  }
  
  public boolean add(E paramE)
  {
    int m;
    if (paramE == null)
    {
      k = f();
      m = 0;
    }
    else
    {
      m = paramE.hashCode();
      k = e(paramE, m);
    }
    if (k >= 0) {
      return false;
    }
    int n = k;
    int i1 = this.c;
    Object localObject = this.a;
    if (i1 >= localObject.length)
    {
      k = 4;
      if (i1 >= 8) {
        k = (i1 >> 1) + i1;
      } else if (i1 >= 4) {
        k = 8;
      }
      Object[] arrayOfObject = this.b;
      a(k);
      int[] arrayOfInt = this.a;
      if (arrayOfInt.length > 0)
      {
        System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
        System.arraycopy(arrayOfObject, 0, this.b, 0, arrayOfObject.length);
      }
      c((int[])localObject, arrayOfObject, this.c);
    }
    int k = this.c;
    if (n < k)
    {
      localObject = this.a;
      i1 = n + 1;
      System.arraycopy(localObject, n, localObject, i1, k - n);
      localObject = this.b;
      System.arraycopy(localObject, n, localObject, i1, this.c - n);
    }
    this.a[n] = m;
    this.b[n] = paramE;
    this.c += 1;
    return true;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    b(this.c + paramCollection.size());
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    return bool;
  }
  
  public void b(int paramInt)
  {
    int[] arrayOfInt = this.a;
    if (arrayOfInt.length < paramInt)
    {
      Object[] arrayOfObject = this.b;
      a(paramInt);
      paramInt = this.c;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.a, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.b, 0, this.c);
      }
      c(arrayOfInt, arrayOfObject, this.c);
    }
  }
  
  public void clear()
  {
    int k = this.c;
    if (k != 0)
    {
      c(this.a, this.b, k);
      this.a = e;
      this.b = f;
      this.c = 0;
    }
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
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
    if (this == paramObject) {
      return true;
    }
    int k;
    if ((paramObject instanceof Set))
    {
      paramObject = (Set)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
      k = 0;
    }
    try
    {
      while (k < this.c)
      {
        boolean bool = paramObject.contains(h(k));
        if (!bool) {
          return false;
        }
        k += 1;
      }
      return true;
    }
    catch (NullPointerException|ClassCastException paramObject) {}
    return false;
    return false;
  }
  
  public E g(int paramInt)
  {
    Object[] arrayOfObject = this.b;
    Object localObject = arrayOfObject[paramInt];
    int m = this.c;
    if (m <= 1)
    {
      c(this.a, arrayOfObject, m);
      this.a = e;
      this.b = f;
      this.c = 0;
      return localObject;
    }
    int[] arrayOfInt = this.a;
    int n = arrayOfInt.length;
    int k = 8;
    if ((n > 8) && (m < arrayOfInt.length / 3))
    {
      if (m > 8) {
        k = m + (m >> 1);
      }
      a(k);
      this.c -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.a, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.b, 0, paramInt);
      }
      k = this.c;
      if (paramInt < k)
      {
        m = paramInt + 1;
        System.arraycopy(arrayOfInt, m, this.a, paramInt, k - paramInt);
        System.arraycopy(arrayOfObject, m, this.b, paramInt, this.c - paramInt);
        return localObject;
      }
    }
    else
    {
      k = m - 1;
      this.c = k;
      if (paramInt < k)
      {
        m = paramInt + 1;
        System.arraycopy(arrayOfInt, m, arrayOfInt, paramInt, k - paramInt);
        arrayOfObject = this.b;
        System.arraycopy(arrayOfObject, m, arrayOfObject, paramInt, this.c - paramInt);
      }
      this.b[this.c] = null;
    }
    return localObject;
  }
  
  public E h(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.a;
    int n = this.c;
    int k = 0;
    int m = 0;
    while (k < n)
    {
      m += arrayOfInt[k];
      k += 1;
    }
    return m;
  }
  
  public int indexOf(Object paramObject)
  {
    if (paramObject == null) {
      return f();
    }
    return e(paramObject, paramObject.hashCode());
  }
  
  public boolean isEmpty()
  {
    return this.c <= 0;
  }
  
  public Iterator<E> iterator()
  {
    return d().m().iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    int k = indexOf(paramObject);
    if (k >= 0)
    {
      g(k);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    while (paramCollection.hasNext()) {
      bool |= remove(paramCollection.next());
    }
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    int k = this.c - 1;
    boolean bool = false;
    while (k >= 0)
    {
      if (!paramCollection.contains(this.b[k]))
      {
        g(k);
        bool = true;
      }
      k -= 1;
    }
    return bool;
  }
  
  public int size()
  {
    return this.c;
  }
  
  public Object[] toArray()
  {
    int k = this.c;
    Object[] arrayOfObject = new Object[k];
    System.arraycopy(this.b, 0, arrayOfObject, 0, k);
    return arrayOfObject;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < this.c) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.c);
    }
    System.arraycopy(this.b, 0, localObject, 0, this.c);
    int k = localObject.length;
    int m = this.c;
    if (k > m) {
      localObject[m] = null;
    }
    return localObject;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.c * 14);
    localStringBuilder.append('{');
    int k = 0;
    while (k < this.c)
    {
      if (k > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = h(k);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Set)");
      }
      k += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  class a
    extends f<E, E>
  {
    a() {}
    
    protected void a()
    {
      b.this.clear();
    }
    
    protected Object b(int paramInt1, int paramInt2)
    {
      return b.this.b[paramInt1];
    }
    
    protected Map<E, E> c()
    {
      throw new UnsupportedOperationException("not a map");
    }
    
    protected int d()
    {
      return b.this.c;
    }
    
    protected int e(Object paramObject)
    {
      return b.this.indexOf(paramObject);
    }
    
    protected int f(Object paramObject)
    {
      return b.this.indexOf(paramObject);
    }
    
    protected void g(E paramE1, E paramE2)
    {
      b.this.add(paramE1);
    }
    
    protected void h(int paramInt)
    {
      b.this.g(paramInt);
    }
    
    protected E i(int paramInt, E paramE)
    {
      throw new UnsupportedOperationException("not a map");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g0.b
 * JD-Core Version:    0.7.0.1
 */