package v8;

import java.lang.reflect.Method;

public class a
{
  public void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    a9.f.f(paramThrowable1, "cause");
    a9.f.f(paramThrowable2, "exception");
    Method localMethod = a.b;
    if (localMethod != null) {
      localMethod.invoke(paramThrowable1, new Object[] { paramThrowable2 });
    }
  }
  
  private static final class a
  {
    public static final a a = new a();
    public static final Method b;
    public static final Method c;
    
    static
    {
      Method[] arrayOfMethod = Throwable.class.getMethods();
      a9.f.e(arrayOfMethod, "throwableMethods");
      int m = arrayOfMethod.length;
      int k = 0;
      int i = 0;
      Object localObject2;
      for (;;)
      {
        localObject2 = null;
        if (i >= m) {
          break;
        }
        localObject1 = arrayOfMethod[i];
        if (a9.f.a(((Method)localObject1).getName(), "addSuppressed"))
        {
          Class[] arrayOfClass = ((Method)localObject1).getParameterTypes();
          a9.f.e(arrayOfClass, "it.parameterTypes");
          if (a9.f.a(p8.f.t(arrayOfClass), Throwable.class))
          {
            j = 1;
            break label93;
          }
        }
        j = 0;
        label93:
        if (j != 0) {
          break label110;
        }
        i += 1;
      }
      Object localObject1 = null;
      label110:
      b = (Method)localObject1;
      int j = arrayOfMethod.length;
      i = k;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        localObject1 = arrayOfMethod[i];
        if (a9.f.a(((Method)localObject1).getName(), "getSuppressed")) {
          break;
        }
        i += 1;
      }
      c = (Method)localObject1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v8.a
 * JD-Core Version:    0.7.0.1
 */