package g0;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class g<K, V>
{
  static Object[] d;
  static int e;
  static Object[] f;
  static int g;
  int[] a;
  Object[] b;
  int c;
  
  public g()
  {
    this.a = c.a;
    this.b = c.c;
    this.c = 0;
  }
  
  public g(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a = c.a;
      this.b = c.c;
    }
    else
    {
      a(paramInt);
    }
    this.c = 0;
  }
  
  public g(g<K, V> paramg)
  {
    this();
    if (paramg != null) {
      j(paramg);
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        Object[] arrayOfObject1 = f;
        if (arrayOfObject1 != null)
        {
          this.b = arrayOfObject1;
          f = (Object[])arrayOfObject1[0];
          this.a = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          g -= 1;
          return;
        }
      }
      finally {}
    } else if (paramInt == 4) {
      try
      {
        Object[] arrayOfObject2 = d;
        if (arrayOfObject2 != null)
        {
          this.b = arrayOfObject2;
          d = (Object[])arrayOfObject2[0];
          this.a = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          e -= 1;
          return;
        }
      }
      finally {}
    }
    this.a = new int[paramInt];
    this.b = new Object[paramInt << 1];
  }
  
  private static int b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = c.a(paramArrayOfInt, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      label9:
      break label9;
    }
    throw new ConcurrentModificationException();
  }
  
  private static void d(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (g < 10)
        {
          paramArrayOfObject[0] = f;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label118;
          f = paramArrayOfObject;
          g += 1;
        }
        return;
      }
      finally {}
    } else if (paramArrayOfInt.length != 4) {}
    for (;;)
    {
      try
      {
        if (e < 10)
        {
          paramArrayOfObject[0] = d;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          d = paramArrayOfObject;
          e += 1;
        }
        return;
      }
      finally {}
      return;
      label118:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label134:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  public void c(int paramInt)
  {
    int i = this.c;
    int[] arrayOfInt = this.a;
    if (arrayOfInt.length < paramInt)
    {
      Object[] arrayOfObject = this.b;
      a(paramInt);
      if (this.c > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.a, 0, i);
        System.arraycopy(arrayOfObject, 0, this.b, 0, i << 1);
      }
      d(arrayOfInt, arrayOfObject, i);
    }
    if (this.c == i) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public void clear()
  {
    int i = this.c;
    if (i > 0)
    {
      int[] arrayOfInt = this.a;
      Object[] arrayOfObject = this.b;
      this.a = c.a;
      this.b = c.c;
      this.c = 0;
      d(arrayOfInt, arrayOfObject, i);
    }
    if (this.c <= 0) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return f(paramObject) >= 0;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return h(paramObject) >= 0;
  }
  
  int e(Object paramObject, int paramInt)
  {
    int j = this.c;
    if (j == 0) {
      return -1;
    }
    int k = b(this.a, j, paramInt);
    if (k < 0) {
      return k;
    }
    if (paramObject.equals(this.b[(k << 1)])) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.a[i] == paramInt))
    {
      if (paramObject.equals(this.b[(i << 1)])) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.a[j] == paramInt))
    {
      if (paramObject.equals(this.b[(j << 1)])) {
        return j;
      }
      j -= 1;
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    int i;
    if ((paramObject instanceof g))
    {
      paramObject = (g)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < this.c)
      {
        localObject1 = i(i);
        localObject2 = m(i);
        localObject3 = paramObject.get(localObject1);
        if (localObject2 == null)
        {
          if (localObject3 != null) {
            break label223;
          }
          if (!paramObject.containsKey(localObject1)) {
            return false;
          }
        }
        else
        {
          bool = localObject2.equals(localObject3);
          if (!bool) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (NullPointerException|ClassCastException paramObject)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      boolean bool;
      return false;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < this.c)
      {
        localObject1 = i(i);
        localObject2 = m(i);
        localObject3 = paramObject.get(localObject1);
        if (localObject2 == null)
        {
          if (localObject3 != null) {
            break label225;
          }
          if (!paramObject.containsKey(localObject1)) {
            return false;
          }
        }
        else
        {
          bool = localObject2.equals(localObject3);
          if (!bool) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (NullPointerException|ClassCastException paramObject)
    {
      return false;
    }
    return false;
    label223:
    return false;
    label225:
    return false;
  }
  
  public int f(Object paramObject)
  {
    if (paramObject == null) {
      return g();
    }
    return e(paramObject, paramObject.hashCode());
  }
  
  int g()
  {
    int j = this.c;
    if (j == 0) {
      return -1;
    }
    int k = b(this.a, j, 0);
    if (k < 0) {
      return k;
    }
    if (this.b[(k << 1)] == null) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.a[i] == 0))
    {
      if (this.b[(i << 1)] == null) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.a[j] == 0))
    {
      if (this.b[(j << 1)] == null) {
        return j;
      }
      j -= 1;
    }
    return i;
  }
  
  public V get(Object paramObject)
  {
    return getOrDefault(paramObject, null);
  }
  
  public V getOrDefault(Object paramObject, V paramV)
  {
    int i = f(paramObject);
    if (i >= 0) {
      paramV = this.b[((i << 1) + 1)];
    }
    return paramV;
  }
  
  int h(Object paramObject)
  {
    int j = this.c * 2;
    Object[] arrayOfObject = this.b;
    if (paramObject == null)
    {
      i = 1;
      while (i < j)
      {
        if (arrayOfObject[i] == null) {
          return i >> 1;
        }
        i += 2;
      }
    }
    int i = 1;
    while (i < j)
    {
      if (paramObject.equals(arrayOfObject[i])) {
        return i >> 1;
      }
      i += 2;
    }
    return -1;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.a;
    Object[] arrayOfObject = this.b;
    int n = this.c;
    int i = 1;
    int j = 0;
    int k = j;
    while (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      int m;
      if (localObject == null) {
        m = 0;
      } else {
        m = localObject.hashCode();
      }
      k += (m ^ i1);
      j += 1;
      i += 2;
    }
    return k;
  }
  
  public K i(int paramInt)
  {
    return this.b[(paramInt << 1)];
  }
  
  public boolean isEmpty()
  {
    return this.c <= 0;
  }
  
  public void j(g<? extends K, ? extends V> paramg)
  {
    int j = paramg.c;
    c(this.c + j);
    int k = this.c;
    int i = 0;
    if (k == 0)
    {
      if (j > 0)
      {
        System.arraycopy(paramg.a, 0, this.a, 0, j);
        System.arraycopy(paramg.b, 0, this.b, 0, j << 1);
        this.c = j;
      }
    }
    else {
      while (i < j)
      {
        put(paramg.i(i), paramg.m(i));
        i += 1;
      }
    }
  }
  
  public V k(int paramInt)
  {
    Object[] arrayOfObject = this.b;
    int m = paramInt << 1;
    Object localObject = arrayOfObject[(m + 1)];
    int k = this.c;
    int i = 0;
    if (k <= 1)
    {
      d(this.a, arrayOfObject, k);
      this.a = c.a;
      this.b = c.c;
      paramInt = i;
    }
    else
    {
      int j = k - 1;
      int[] arrayOfInt1 = this.a;
      int n = arrayOfInt1.length;
      i = 8;
      if ((n > 8) && (k < arrayOfInt1.length / 3))
      {
        if (k > 8) {
          i = k + (k >> 1);
        }
        a(i);
        if (k == this.c)
        {
          if (paramInt > 0)
          {
            System.arraycopy(arrayOfInt1, 0, this.a, 0, paramInt);
            System.arraycopy(arrayOfObject, 0, this.b, 0, m);
          }
          if (paramInt < j)
          {
            i = paramInt + 1;
            int[] arrayOfInt2 = this.a;
            n = j - paramInt;
            System.arraycopy(arrayOfInt1, i, arrayOfInt2, paramInt, n);
            System.arraycopy(arrayOfObject, i << 1, this.b, m, n << 1);
          }
        }
        else
        {
          throw new ConcurrentModificationException();
        }
      }
      else
      {
        if (paramInt < j)
        {
          i = paramInt + 1;
          n = j - paramInt;
          System.arraycopy(arrayOfInt1, i, arrayOfInt1, paramInt, n);
          arrayOfObject = this.b;
          System.arraycopy(arrayOfObject, i << 1, arrayOfObject, m, n << 1);
        }
        arrayOfObject = this.b;
        paramInt = j << 1;
        arrayOfObject[paramInt] = null;
        arrayOfObject[(paramInt + 1)] = null;
      }
      paramInt = j;
    }
    if (k == this.c)
    {
      this.c = paramInt;
      return localObject;
    }
    throw new ConcurrentModificationException();
  }
  
  public V l(int paramInt, V paramV)
  {
    paramInt = (paramInt << 1) + 1;
    Object[] arrayOfObject = this.b;
    Object localObject = arrayOfObject[paramInt];
    arrayOfObject[paramInt] = paramV;
    return localObject;
  }
  
  public V m(int paramInt)
  {
    return this.b[((paramInt << 1) + 1)];
  }
  
  public V put(K paramK, V paramV)
  {
    int k = this.c;
    int j;
    if (paramK == null)
    {
      i = g();
      j = 0;
    }
    else
    {
      j = paramK.hashCode();
      i = e(paramK, j);
    }
    if (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.b;
      localObject = paramK[i];
      paramK[i] = paramV;
      return localObject;
    }
    int m = i;
    Object localObject = this.a;
    if (k >= localObject.length)
    {
      i = 4;
      if (k >= 8) {
        i = (k >> 1) + k;
      } else if (k >= 4) {
        i = 8;
      }
      Object[] arrayOfObject = this.b;
      a(i);
      if (k == this.c)
      {
        int[] arrayOfInt = this.a;
        if (arrayOfInt.length > 0)
        {
          System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
          System.arraycopy(arrayOfObject, 0, this.b, 0, arrayOfObject.length);
        }
        d((int[])localObject, arrayOfObject, k);
      }
      else
      {
        throw new ConcurrentModificationException();
      }
    }
    if (m < k)
    {
      localObject = this.a;
      i = m + 1;
      System.arraycopy(localObject, m, localObject, i, k - m);
      localObject = this.b;
      System.arraycopy(localObject, m << 1, localObject, i << 1, this.c - m << 1);
    }
    int i = this.c;
    if (k == i)
    {
      localObject = this.a;
      if (m < localObject.length)
      {
        localObject[m] = j;
        localObject = this.b;
        j = m << 1;
        localObject[j] = paramK;
        localObject[(j + 1)] = paramV;
        this.c = (i + 1);
        return null;
      }
    }
    throw new ConcurrentModificationException();
  }
  
  public V putIfAbsent(K paramK, V paramV)
  {
    Object localObject2 = get(paramK);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = put(paramK, paramV);
    }
    return localObject1;
  }
  
  public V remove(Object paramObject)
  {
    int i = f(paramObject);
    if (i >= 0) {
      return k(i);
    }
    return null;
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    int i = f(paramObject1);
    if (i >= 0)
    {
      paramObject1 = m(i);
      if ((paramObject2 == paramObject1) || ((paramObject2 != null) && (paramObject2.equals(paramObject1))))
      {
        k(i);
        return true;
      }
    }
    return false;
  }
  
  public V replace(K paramK, V paramV)
  {
    int i = f(paramK);
    if (i >= 0) {
      return l(i, paramV);
    }
    return null;
  }
  
  public boolean replace(K paramK, V paramV1, V paramV2)
  {
    int i = f(paramK);
    if (i >= 0)
    {
      paramK = m(i);
      if ((paramK == paramV1) || ((paramV1 != null) && (paramV1.equals(paramK))))
      {
        l(i, paramV2);
        return true;
      }
    }
    return false;
  }
  
  public int size()
  {
    return this.c;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.c * 28);
    localStringBuilder.append('{');
    int i = 0;
    while (i < this.c)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = i(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      localStringBuilder.append('=');
      localObject = m(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g0.g
 * JD-Core Version:    0.7.0.1
 */