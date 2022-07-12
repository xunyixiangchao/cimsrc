package p8;

import a9.f;
import java.util.Iterator;
import java.util.Set;

class k0
  extends j0
{
  public static <T> Set<T> b()
  {
    return z.a;
  }
  
  public static final <T> Set<T> c(Set<? extends T> paramSet)
  {
    f.f(paramSet, "<this>");
    int i = paramSet.size();
    if (i != 0)
    {
      if (i != 1) {
        return paramSet;
      }
      return j0.a(paramSet.iterator().next());
    }
    return i0.b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.k0
 * JD-Core Version:    0.7.0.1
 */