package q0;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class i
  extends h
{
  protected Typeface h(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(this.g, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)this.m.invoke(null, new Object[] { localObject, "sans-serif", Integer.valueOf(-1), Integer.valueOf(-1) });
      return paramObject;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  protected Method t(Class<?> paramClass)
  {
    paramClass = Array.newInstance(paramClass, 1).getClass();
    Class localClass = Integer.TYPE;
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { paramClass, String.class, localClass, localClass });
    paramClass.setAccessible(true);
    return paramClass;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q0.i
 * JD-Core Version:    0.7.0.1
 */