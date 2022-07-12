package p8;

import b9.a;
import java.util.Iterator;

public abstract class a0
  implements Iterator<Integer>, a
{
  public abstract int a();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.a0
 * JD-Core Version:    0.7.0.1
 */