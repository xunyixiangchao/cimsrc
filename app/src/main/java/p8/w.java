package p8;

import b9.a;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class w
  implements ListIterator, a
{
  public static final w a = new w();
  
  public Void a()
  {
    throw new NoSuchElementException();
  }
  
  public Void b()
  {
    throw new NoSuchElementException();
  }
  
  public boolean hasNext()
  {
    return false;
  }
  
  public boolean hasPrevious()
  {
    return false;
  }
  
  public int nextIndex()
  {
    return 0;
  }
  
  public int previousIndex()
  {
    return -1;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.w
 * JD-Core Version:    0.7.0.1
 */