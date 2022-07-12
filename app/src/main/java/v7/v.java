package v7;

import b8.a;
import b8.b;
import b8.c;
import java.io.IOException;
import y7.f;

public abstract class v<T>
{
  public final v<T> a()
  {
    return new a();
  }
  
  public abstract T b(a parama);
  
  public final l c(T paramT)
  {
    try
    {
      f localf = new f();
      d(localf, paramT);
      paramT = localf.A0();
      return paramT;
    }
    catch (IOException paramT)
    {
      throw new m(paramT);
    }
  }
  
  public abstract void d(c paramc, T paramT);
  
  class a
    extends v<T>
  {
    a() {}
    
    public T b(a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      return v.this.b(parama);
    }
    
    public void d(c paramc, T paramT)
    {
      if (paramT == null)
      {
        paramc.k0();
        return;
      }
      v.this.d(paramc, paramT);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v7.v
 * JD-Core Version:    0.7.0.1
 */