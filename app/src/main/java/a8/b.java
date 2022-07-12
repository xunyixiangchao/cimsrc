package a8;

import java.lang.reflect.AccessibleObject;
import x7.e;

public abstract class b
{
  private static final b a;
  
  static
  {
    Object localObject;
    if (e.c() < 9) {
      localObject = new a();
    } else {
      localObject = new c();
    }
    a = (b)localObject;
  }
  
  public static b a()
  {
    return a;
  }
  
  public abstract void b(AccessibleObject paramAccessibleObject);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a8.b
 * JD-Core Version:    0.7.0.1
 */