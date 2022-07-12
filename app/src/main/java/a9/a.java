package a9;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class a<T>
  implements Iterator<T>, b9.a
{
  private final T[] a;
  private int b;
  
  public a(T[] paramArrayOfT)
  {
    this.a = paramArrayOfT;
  }
  
  public boolean hasNext()
  {
    return this.b < this.a.length;
  }
  
  public T next()
  {
    try
    {
      Object localObject = this.a;
      int i = this.b;
      this.b = (i + 1);
      localObject = localObject[i];
      return localObject;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.b -= 1;
      throw new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a9.a
 * JD-Core Version:    0.7.0.1
 */