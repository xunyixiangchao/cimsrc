package m1;

import androidx.room.f0;
import p1.k;

public abstract class f<T>
  extends m
{
  public f(f0 paramf0)
  {
    super(paramf0);
  }
  
  protected abstract void g(k paramk, T paramT);
  
  public final int h(T paramT)
  {
    k localk = a();
    try
    {
      g(localk, paramT);
      int i = localk.u();
      return i;
    }
    finally
    {
      f(localk);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m1.f
 * JD-Core Version:    0.7.0.1
 */