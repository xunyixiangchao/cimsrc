package ea;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

abstract class v<T>
{
  static <T> v<T> b(u paramu, Method paramMethod)
  {
    s locals = s.b(paramu, paramMethod);
    Type localType = paramMethod.getGenericReturnType();
    if (!y.j(localType))
    {
      if (localType != Void.TYPE) {
        return k.f(paramu, paramMethod, locals);
      }
      throw y.m(paramMethod, "Service methods cannot return void.", new Object[0]);
    }
    throw y.m(paramMethod, "Method return type must not include a type variable or wildcard: %s", new Object[] { localType });
  }
  
  @Nullable
  abstract T a(Object[] paramArrayOfObject);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.v
 * JD-Core Version:    0.7.0.1
 */