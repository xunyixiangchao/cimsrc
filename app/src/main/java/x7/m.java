package x7;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class m
{
  static void a(Class<?> paramClass)
  {
    int i = paramClass.getModifiers();
    if (!Modifier.isInterface(i))
    {
      if (!Modifier.isAbstract(i)) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Abstract class can't be instantiated! Class name: ");
      localStringBuilder.append(paramClass.getName());
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Interface can't be instantiated! Interface name: ");
    localStringBuilder.append(paramClass.getName());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public static m b()
  {
    try
    {
      localObject1 = Class.forName("sun.misc.Unsafe");
      final Object localObject2 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(null);
      localObject1 = new a(((Class)localObject1).getMethod("allocateInstance", new Class[] { Class.class }), localObject2);
      return localObject1;
    }
    catch (Exception localException1)
    {
      Object localObject1;
      label50:
      final int i;
      label133:
      label171:
      break label50;
    }
    try
    {
      localObject1 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
      ((Method)localObject1).setAccessible(true);
      i = ((Integer)((Method)localObject1).invoke(null, new Object[] { Object.class })).intValue();
      localObject1 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
      ((Method)localObject1).setAccessible(true);
      localObject1 = new b((Method)localObject1, i);
      return localObject1;
    }
    catch (Exception localException2)
    {
      break label133;
    }
    try
    {
      localObject1 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = new c((Method)localObject1);
      return localObject1;
    }
    catch (Exception localException3)
    {
      break label171;
    }
    return new d();
  }
  
  public abstract <T> T c(Class<T> paramClass);
  
  static final class a
    extends m
  {
    a(Method paramMethod, Object paramObject) {}
    
    public <T> T c(Class<T> paramClass)
    {
      m.a(paramClass);
      return this.a.invoke(localObject2, new Object[] { paramClass });
    }
  }
  
  static final class b
    extends m
  {
    b(Method paramMethod, int paramInt) {}
    
    public <T> T c(Class<T> paramClass)
    {
      m.a(paramClass);
      return this.a.invoke(null, new Object[] { paramClass, Integer.valueOf(i) });
    }
  }
  
  static final class c
    extends m
  {
    c(Method paramMethod) {}
    
    public <T> T c(Class<T> paramClass)
    {
      m.a(paramClass);
      return this.a.invoke(null, new Object[] { paramClass, Object.class });
    }
  }
  
  static final class d
    extends m
  {
    public <T> T c(Class<T> paramClass)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot allocate ");
      localStringBuilder.append(paramClass);
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x7.m
 * JD-Core Version:    0.7.0.1
 */