package a9;

import d9.a;

public class j
{
  private static final k a;
  private static final a[] b = new a[0];
  
  static
  {
    Object localObject = null;
    try
    {
      k localk = (k)Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
      localObject = localk;
    }
    catch (ClassCastException|ClassNotFoundException|InstantiationException|IllegalAccessException localClassCastException)
    {
      label16:
      break label16;
    }
    if (localObject == null) {
      localObject = new k();
    }
    a = (k)localObject;
  }
  
  public static String a(g paramg)
  {
    return a.b(paramg);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a9.j
 * JD-Core Version:    0.7.0.1
 */