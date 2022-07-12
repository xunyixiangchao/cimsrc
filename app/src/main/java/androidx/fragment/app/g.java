package androidx.fragment.app;

public class g
{
  private static final g0.g<ClassLoader, g0.g<String, Class<?>>> a = new g0.g();
  
  static boolean b(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      boolean bool = Fragment.class.isAssignableFrom(c(paramClassLoader, paramString));
      return bool;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      label13:
      break label13;
    }
    return false;
  }
  
  private static Class<?> c(ClassLoader paramClassLoader, String paramString)
  {
    Object localObject3 = a;
    Object localObject2 = (g0.g)((g0.g)localObject3).get(paramClassLoader);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new g0.g();
      ((g0.g)localObject3).put(paramClassLoader, localObject1);
    }
    localObject3 = (Class)((g0.g)localObject1).get(paramString);
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = Class.forName(paramString, false, paramClassLoader);
      ((g0.g)localObject1).put(paramString, localObject2);
    }
    return localObject2;
  }
  
  public static Class<? extends Fragment> d(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = c(paramClassLoader, paramString);
      return paramClassLoader;
    }
    catch (ClassCastException paramClassLoader)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to instantiate fragment ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": make sure class is a valid subclass of Fragment");
      throw new Fragment.j(localStringBuilder.toString(), paramClassLoader);
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to instantiate fragment ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": make sure class name exists");
      throw new Fragment.j(localStringBuilder.toString(), paramClassLoader);
    }
  }
  
  public Fragment a(ClassLoader paramClassLoader, String paramString)
  {
    throw null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.g
 * JD-Core Version:    0.7.0.1
 */