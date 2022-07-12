package e9;

import java.util.Iterator;

public final class a<T>
  implements c<T>, b<T>
{
  private final c<T> a;
  private final int b;
  
  public a(c<? extends T> paramc, int paramInt)
  {
    this.a = paramc;
    this.b = paramInt;
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    paramc = new StringBuilder();
    paramc.append("count must be non-negative, but was ");
    paramc.append(paramInt);
    paramc.append('.');
    throw new IllegalArgumentException(paramc.toString().toString());
  }
  
  public c<T> a(int paramInt)
  {
    int i = this.b + paramInt;
    if (i < 0) {
      return new a(this, paramInt);
    }
    return new a(this.a, i);
  }
  
  public Iterator<T> iterator()
  {
    return new a(this);
  }
  
  public static final class a
    implements Iterator<T>, b9.a
  {
    private final Iterator<T> a;
    private int b;
    
    a(a<T> parama)
    {
      this.a = a.c(parama).iterator();
      this.b = a.b(parama);
    }
    
    private final void a()
    {
      while ((this.b > 0) && (this.a.hasNext()))
      {
        this.a.next();
        this.b -= 1;
      }
    }
    
    public boolean hasNext()
    {
      a();
      return this.a.hasNext();
    }
    
    public T next()
    {
      a();
      return this.a.next();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e9.a
 * JD-Core Version:    0.7.0.1
 */