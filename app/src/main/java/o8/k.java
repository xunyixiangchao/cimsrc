package o8;

import a9.f;
import java.io.Serializable;
import z8.a;

final class k<T>
  implements d<T>, Serializable
{
  private a<? extends T> a;
  private volatile Object b;
  private final Object c;
  
  public k(a<? extends T> parama, Object paramObject)
  {
    this.a = parama;
    this.b = m.a;
    parama = paramObject;
    if (paramObject == null) {
      parama = this;
    }
    this.c = parama;
  }
  
  public boolean a()
  {
    return this.b != m.a;
  }
  
  public T getValue()
  {
    Object localObject1 = this.b;
    m localm = m.a;
    if (localObject1 != localm) {
      return localObject1;
    }
    synchronized (this.c)
    {
      localObject1 = this.b;
      if (localObject1 == localm)
      {
        localObject1 = this.a;
        f.c(localObject1);
        localObject1 = ((a)localObject1).b();
        this.b = localObject1;
        this.a = null;
      }
      return localObject1;
    }
  }
  
  public String toString()
  {
    if (a()) {
      return String.valueOf(getValue());
    }
    return "Lazy value not initialized yet.";
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o8.k
 * JD-Core Version:    0.7.0.1
 */