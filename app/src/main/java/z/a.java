package z;

import java.util.ArrayDeque;

public class a<T>
{
  private final int a;
  private final ArrayDeque<T> b;
  private final Object c = new Object();
  final c<T> d;
  
  public a(int paramInt, c<T> paramc)
  {
    this.a = paramInt;
    this.b = new ArrayDeque(paramInt);
    this.d = paramc;
  }
  
  public T a()
  {
    synchronized (this.c)
    {
      Object localObject2 = this.b.removeLast();
      return localObject2;
    }
  }
  
  public void b(T paramT)
  {
    for (;;)
    {
      synchronized (this.c)
      {
        if (this.b.size() >= this.a)
        {
          localObject1 = a();
          this.b.addFirst(paramT);
          paramT = this.d;
          if ((paramT != null) && (localObject1 != null)) {
            paramT.a(localObject1);
          }
          return;
        }
      }
      Object localObject1 = null;
    }
  }
  
  public boolean c()
  {
    synchronized (this.c)
    {
      boolean bool = this.b.isEmpty();
      return bool;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z.a
 * JD-Core Version:    0.7.0.1
 */