package g0;

public class d<E>
  implements Cloneable
{
  private static final Object e = new Object();
  private boolean a = false;
  private long[] b;
  private Object[] c;
  private int d;
  
  public d()
  {
    this(10);
  }
  
  public d(int paramInt)
  {
    if (paramInt == 0)
    {
      this.b = c.b;
      this.c = c.c;
      return;
    }
    paramInt = c.f(paramInt);
    this.b = new long[paramInt];
    this.c = new Object[paramInt];
  }
  
  private void d()
  {
    int m = this.d;
    long[] arrayOfLong = this.b;
    Object[] arrayOfObject = this.c;
    int i = 0;
    int k;
    for (int j = i; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != e)
      {
        if (i != j)
        {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.a = false;
    this.d = j;
  }
  
  public void a(long paramLong, E paramE)
  {
    int i = this.d;
    if ((i != 0) && (paramLong <= this.b[(i - 1)]))
    {
      l(paramLong, paramE);
      return;
    }
    if ((this.a) && (i >= this.b.length)) {
      d();
    }
    i = this.d;
    if (i >= this.b.length)
    {
      int j = c.f(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject = this.b;
      System.arraycopy(localObject, 0, arrayOfLong, 0, localObject.length);
      localObject = this.c;
      System.arraycopy(localObject, 0, arrayOfObject, 0, localObject.length);
      this.b = arrayOfLong;
      this.c = arrayOfObject;
    }
    this.b[i] = paramLong;
    this.c[i] = paramE;
    this.d = (i + 1);
  }
  
  public void b()
  {
    int j = this.d;
    Object[] arrayOfObject = this.c;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.d = 0;
    this.a = false;
  }
  
  public d<E> c()
  {
    try
    {
      d locald = (d)super.clone();
      locald.b = ((long[])this.b.clone());
      locald.c = ((Object[])this.c.clone());
      return locald;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public E e(long paramLong)
  {
    return f(paramLong, null);
  }
  
  public E f(long paramLong, E paramE)
  {
    int i = c.b(this.b, this.d, paramLong);
    if (i >= 0)
    {
      Object[] arrayOfObject = this.c;
      if (arrayOfObject[i] == e) {
        return paramE;
      }
      return arrayOfObject[i];
    }
    return paramE;
  }
  
  public int j(long paramLong)
  {
    if (this.a) {
      d();
    }
    return c.b(this.b, this.d, paramLong);
  }
  
  public long k(int paramInt)
  {
    if (this.a) {
      d();
    }
    return this.b[paramInt];
  }
  
  public void l(long paramLong, E paramE)
  {
    int i = c.b(this.b, this.d, paramLong);
    if (i >= 0)
    {
      this.c[i] = paramE;
      return;
    }
    int j = i;
    int k = this.d;
    Object localObject1;
    if (j < k)
    {
      localObject1 = this.c;
      if (localObject1[j] == e)
      {
        this.b[j] = paramLong;
        localObject1[j] = paramE;
        return;
      }
    }
    i = j;
    if (this.a)
    {
      i = j;
      if (k >= this.b.length)
      {
        d();
        i = c.b(this.b, this.d, paramLong);
      }
    }
    j = this.d;
    if (j >= this.b.length)
    {
      j = c.f(j + 1);
      localObject1 = new long[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject2 = this.b;
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      localObject2 = this.c;
      System.arraycopy(localObject2, 0, arrayOfObject, 0, localObject2.length);
      this.b = ((long[])localObject1);
      this.c = arrayOfObject;
    }
    j = this.d;
    if (j - i != 0)
    {
      localObject1 = this.b;
      k = i + 1;
      System.arraycopy(localObject1, i, localObject1, k, j - i);
      localObject1 = this.c;
      System.arraycopy(localObject1, i, localObject1, k, this.d - i);
    }
    this.b[i] = paramLong;
    this.c[i] = paramE;
    this.d += 1;
  }
  
  public void m(long paramLong)
  {
    int i = c.b(this.b, this.d, paramLong);
    if (i >= 0)
    {
      Object[] arrayOfObject = this.c;
      Object localObject1 = arrayOfObject[i];
      Object localObject2 = e;
      if (localObject1 != localObject2)
      {
        arrayOfObject[i] = localObject2;
        this.a = true;
      }
    }
  }
  
  public void n(int paramInt)
  {
    Object[] arrayOfObject = this.c;
    Object localObject1 = arrayOfObject[paramInt];
    Object localObject2 = e;
    if (localObject1 != localObject2)
    {
      arrayOfObject[paramInt] = localObject2;
      this.a = true;
    }
  }
  
  public int o()
  {
    if (this.a) {
      d();
    }
    return this.d;
  }
  
  public E p(int paramInt)
  {
    if (this.a) {
      d();
    }
    return this.c[paramInt];
  }
  
  public String toString()
  {
    if (o() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.d * 28);
    localStringBuilder.append('{');
    int i = 0;
    while (i < this.d)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(k(i));
      localStringBuilder.append('=');
      Object localObject = p(i);
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
 * Qualified Name:     g0.d
 * JD-Core Version:    0.7.0.1
 */