package x0;

public class f<T>
  implements e<T>
{
  private final Object[] a;
  private int b;
  
  public f(int paramInt)
  {
    if (paramInt > 0)
    {
      this.a = new Object[paramInt];
      return;
    }
    throw new IllegalArgumentException("The max pool size must be > 0");
  }
  
  private boolean c(T paramT)
  {
    int i = 0;
    while (i < this.b)
    {
      if (this.a[i] == paramT) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean a(T paramT)
  {
    if (!c(paramT))
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
    throw new IllegalStateException("Already in the pool!");
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
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x0.f
 * JD-Core Version:    0.7.0.1
 */