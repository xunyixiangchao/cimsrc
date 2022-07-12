package s;

import java.util.HashMap;
import java.util.Map;

public final class b1
{
  private static final Object a = new Object();
  private static final Map<Object, z> b = new HashMap();
  
  public static void a(Object paramObject, z paramz)
  {
    synchronized (a)
    {
      b.put(paramObject, paramz);
      return;
    }
  }
  
  public static z b(Object paramObject)
  {
    synchronized (a)
    {
      z localz = (z)b.get(paramObject);
      paramObject = localz;
      if (localz == null) {
        paramObject = z.a;
      }
      return paramObject;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.b1
 * JD-Core Version:    0.7.0.1
 */