package e9;

import b9.a;
import java.util.Iterator;
import z8.b;

public final class j<T, R>
  implements c<R>
{
  private final c<T> a;
  private final b<T, R> b;
  
  public j(c<? extends T> paramc, b<? super T, ? extends R> paramb)
  {
    this.a = paramc;
    this.b = paramb;
  }
  
  public Iterator<R> iterator()
  {
    return new a(this);
  }
  
  public static final class a
    implements Iterator<R>, a
  {
    private final Iterator<T> a;
    
    a(j<T, R> paramj)
    {
      this.a = j.b(paramj).iterator();
    }
    
    public boolean hasNext()
    {
      return this.a.hasNext();
    }
    
    public R next()
    {
      return j.c(this.b).c(this.a.next());
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e9.j
 * JD-Core Version:    0.7.0.1
 */