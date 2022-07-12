package h0;

class g<T>
  implements f<T>
{
  private final Object[] a;
  private int b;
  
  g(int paramInt)
  {
    if (paramInt > 0)
    {
      this.a = new Object[paramInt];
      return;
    }
    throw new IllegalArgumentException("The max pool size must be > 0");
  }
  
  public boolean a(T paramT)
  {
    int i = this.b;
    Object[] arrayOfObject = this.a;
    if (i < arrayOfObject.length)
    {
      arrayOfObject[i] = paramT;
      this.b = (i + 1);
      return true;
    }
    return false;
  }
  
  public T b()
  {
    int i = this.b;
    if (i > 0)
    {
      int j = i - 1;
      Object[] arrayOfObject = this.a;
      Object localObject = arrayOfObject[j];
      arrayOfObject[j] = null;
      this.b = (i - 1);
      return localObject;
    }
    return null;
  }
  
  public void c(T[] paramArrayOfT, int paramInt)
  {
    int i = paramInt;
    if (paramInt > paramArrayOfT.length) {
      i = paramArrayOfT.length;
    }
    paramInt = 0;
    while (paramInt < i)
    {
      T ? = paramArrayOfT[paramInt];
      int j = this.b;
      Object[] arrayOfObject = this.a;
      if (j < arrayOfObject.length)
      {
        arrayOfObject[j] = ?;
        this.b = (j + 1);
      }
      paramInt += 1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h0.g
 * JD-Core Version:    0.7.0.1
 */