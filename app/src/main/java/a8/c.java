package a8;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import v7.m;

final class c
  extends b
{
  private static Class d;
  private final Object b = d();
  private final Field c = c();
  
  private static Field c()
  {
    try
    {
      Field localField = AccessibleObject.class.getDeclaredField("override");
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  private static Object d()
  {
    try
    {
      Object localObject = Class.forName("sun.misc.Unsafe");
      d = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("theUnsafe");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void b(AccessibleObject paramAccessibleObject)
  {
    if (!e(paramAccessibleObject)) {
      try
      {
        paramAccessibleObject.setAccessible(true);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Gson couldn't modify fields for ");
        localStringBuilder.append(paramAccessibleObject);
        localStringBuilder.append("\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.");
        throw new m(localStringBuilder.toString(), localSecurityException);
      }
    }
  }
  
  boolean e(AccessibleObject paramAccessibleObject)
  {
    if ((this.b != null) && (this.c != null)) {}
    try
    {
      long l = ((Long)d.getMethod("objectFieldOffset", new Class[] { Field.class }).invoke(this.b, new Object[] { this.c })).longValue();
      d.getMethod("putBoolean", new Class[] { Object.class, Long.TYPE, Boolean.TYPE }).invoke(this.b, new Object[] { paramAccessibleObject, Long.valueOf(l), Boolean.TRUE });
      return true;
    }
    catch (Exception paramAccessibleObject) {}
    return false;
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a8.c
 * JD-Core Version:    0.7.0.1
 */