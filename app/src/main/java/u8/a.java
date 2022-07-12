package u8;

import java.io.Serializable;
import o8.i;
import o8.i.a;
import o8.j;
import t8.b;

public abstract class a
  implements s8.a<Object>, Serializable
{
  private final s8.a<Object> a;
  
  public a(s8.a<Object> parama)
  {
    this.a = parama;
  }
  
  public final void a(Object paramObject)
  {
    Object localObject = this;
    do
    {
      f.a((s8.a)localObject);
      a locala = (a)localObject;
      localObject = locala.a;
      a9.f.c(localObject);
      try
      {
        paramObject = locala.d(paramObject);
        if (paramObject == b.b()) {
          return;
        }
        locala1 = i.a;
        paramObject = i.a(paramObject);
      }
      finally
      {
        i.a locala1 = i.a;
        paramObject = i.a(j.a(paramObject));
      }
      locala.e();
    } while ((localObject instanceof a));
    ((s8.a)localObject).a(paramObject);
  }
  
  public StackTraceElement b()
  {
    return e.d(this);
  }
  
  protected abstract Object d(Object paramObject);
  
  protected void e() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Continuation at ");
    Object localObject = b();
    if (localObject == null) {
      localObject = getClass().getName();
    }
    localStringBuilder.append(localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u8.a
 * JD-Core Version:    0.7.0.1
 */