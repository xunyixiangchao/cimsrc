package q9;

import java.io.IOException;
import o8.a;

public final class p
  implements d
{
  private final n a;
  
  public p(n paramn)
  {
    this.a = paramn;
  }
  
  public i a()
  {
    Object localObject1 = null;
    Object localObject5 = localObject1;
    while (!b().i())
    {
      Object localObject2;
      Object localObject6;
      if (localObject1 != null)
      {
        localObject2 = null;
        localObject6 = localObject1;
        localObject1 = localObject2;
      }
      try
      {
        localObject6 = b().b();
        localObject2 = localObject1;
        Object localObject3 = localObject1;
        try
        {
          if (!((n.c)localObject6).d())
          {
            localObject3 = localObject1;
            localObject2 = ((n.c)localObject6).f();
            Object localObject7 = localObject2;
            localObject3 = localObject1;
            if (((n.a)localObject2).f())
            {
              localObject3 = localObject1;
              localObject7 = ((n.c)localObject6).b();
            }
            localObject3 = localObject1;
            localObject2 = ((n.a)localObject7).a();
            localObject3 = localObject1;
            localObject1 = ((n.a)localObject7).b();
            if (localObject1 == null)
            {
              if (localObject2 != null)
              {
                localObject1 = localObject2;
                continue;
              }
            }
            else {
              try
              {
                throw ((Throwable)localObject1);
              }
              catch (IOException localIOException3)
              {
                localObject1 = localObject2;
                localObject2 = localIOException3;
              }
            }
          }
          localObject4 = localObject2;
          localObject1 = ((n.c)localObject6).c();
          return localObject1;
        }
        catch (IOException localIOException1)
        {
          Object localObject4;
          localObject1 = localObject4;
        }
        if (localObject5 != null) {
          break label161;
        }
      }
      catch (IOException localIOException2) {}
      localObject5 = localIOException2;
      break label167;
      label161:
      a.a(localObject5, localIOException2);
      label167:
      if ((localObject1 == null) && (!n.b.a(b(), null, 1, null))) {
        throw localObject5;
      }
    }
    throw new IOException("Canceled");
  }
  
  public n b()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.p
 * JD-Core Version:    0.7.0.1
 */