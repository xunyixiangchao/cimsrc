package g0;

public class h<E>
  implements Cloneable
{
  private static final Object e = new Object();
  private boolean a = false;
  private int[] b;
  private Object[] c;
  private int d;
  
  public h()
  {
    this(10);
  }
  
  public h(int paramInt)
  {
    if (paramInt == 0)
    {
      this.b = c.a;
      this.c = c.c;
      return;
    }
    paramInt = c.e(paramInt);
    this.b = new int[paramInt];
    this.c = new Object[paramInt];
  }
  
  private void d()
  {
    int m = this.d;
    int[] arrayOfInt = this.b;
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
          arrayOfInt[j] = arrayOfInt[i];
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
  
  public void a(int paramInt, E paramE)
  {
    int i = this.d;
    if ((i != 0) && (paramInt <= this.b[(i - 1)]))
    {
      l(paramInt, paramE);
      return;
    }
    if ((this.a) && (i >= this.b.length)) {
      d();
    }
    i = this.d;
    if (i >= this.b.length)
    {
      int j = c.e(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject = this.b;
      System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
      localObject = this.c;
      System.arraycopy(localObject, 0, arrayOfObject, 0, localObject.length);
      this.b = arrayOfInt;
      this.c = arrayOfObject;
    }
    this.b[i] = paramInt;
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
  
  public h<E> c()
  {
    try
    {
      h localh = (h)super.clone();
      localh.b = ((int[])this.b.clone());
      localh.c = ((Object[])this.c.clone());
      return localh;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public E e(int paramInt)
  {
    return f(paramInt, null);
  }
  
  public E f(int paramInt, E paramE)
  {
    paramInt = c.a(this.b, this.d, paramInt);
    if (paramInt >= 0)
    {
      Object[] arrayOfObject = this.c;
      if (arrayOfObject[paramInt] == e) {
        return paramE;
      }
      return arrayOfObject[paramInt];
    }
    return paramE;
  }
  
  public int j(E paramE)
  {
    if (this.a) {
      d();
    }
    int i = 0;
    while (i < this.d)
    {
      if (this.c[i] == paramE) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int k(int paramInt)
  {
    if (this.a) {
      d();
    }
    return this.b[paramInt];
  }
  
  public void l(int paramInt, E paramE)
  {
    int i = c.a(this.b, this.d, paramInt);
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
        this.b[j] = paramInt;
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
        i = c.a(this.b, this.d, paramInt);
      }
    }
    j = this.d;
    if (j >= this.b.length)
    {
      j = c.e(j + 1);
      localObject1 = new int[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject2 = this.b;
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      localObject2 = this.c;
      System.arraycopy(localObject2, 0, arrayOfObject, 0, localObject2.length);
      this.b = ((int[])localObject1);
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
    this.b[i] = paramInt;
    this.c[i] = paramE;
    this.d += 1;
  }
  
  public void m(int paramInt)
  {
    paramInt = c.a(this.b, this.d, paramInt);
    if (paramInt >= 0)
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
  }
  
  public int n()
  {
    if (this.a) {
      d();
    }
    return this.d;
  }
  
  public E o(int paramInt)
  {
    if (this.a) {
      d();
    }
    return this.c[paramInt];
  }
  
  public String toString()
  {
    if (n() <= 0) {
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
      Object localObject = o(i);
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
 * Qualified Name:     g0.h
 * JD-Core Version:    0.7.0.1
 */