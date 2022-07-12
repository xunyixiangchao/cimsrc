package m1;

import androidx.room.f0;
import java.util.Iterator;
import p1.k;

public abstract class g<T>
  extends m
{
  public g(f0 paramf0)
  {
    super(paramf0);
  }
  
  protected abstract void g(k paramk, T paramT);
  
  public final void h(Iterable<? extends T> paramIterable)
  {
    k localk = a();
    try
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        g(localk, paramIterable.next());
        localk.Z();
      }
      return;
    }
    finally
    {
      f(localk);
    }
  }
  
  public final void i(T paramT)
  {
    k localk = a();
    try
    {
      g(localk, paramT);
      localk.Z();
      return;
    }
    finally
    {
      f(localk);
    }
  }
  
  public final long j(T paramT)
  {
    k localk = a();
    try
    {
      g(localk, paramT);
      long l = localk.Z();
      return l;
    }
    finally
    {
      f(localk);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m1.g
 * JD-Core Version:    0.7.0.1
 */