package u8;

import a9.f;
import s8.c.a;

public abstract class c
  extends a
{
  private final s8.c b;
  private transient s8.a<Object> c;
  
  public c(s8.a<Object> parama)
  {
    this(parama, localc);
  }
  
  public c(s8.a<Object> parama, s8.c paramc)
  {
    super(parama);
    this.b = paramc;
  }
  
  public s8.c c()
  {
    s8.c localc = this.b;
    f.c(localc);
    return localc;
  }
  
  protected void e()
  {
    s8.a locala = this.c;
    if ((locala != null) && (locala != this))
    {
      c.a locala1 = c().a(s8.b.a);
      f.c(locala1);
      ((s8.b)locala1).b(locala);
    }
    this.c = b.a;
  }
  
  public final s8.a<Object> f()
  {
    s8.a locala = this.c;
    Object localObject = locala;
    if (locala == null)
    {
      localObject = (s8.b)c().a(s8.b.a);
      if (localObject != null)
      {
        locala = ((s8.b)localObject).c(this);
        localObject = locala;
        if (locala != null) {}
      }
      else
      {
        localObject = this;
      }
      this.c = ((s8.a)localObject);
    }
    return localObject;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u8.c
 * JD-Core Version:    0.7.0.1
 */