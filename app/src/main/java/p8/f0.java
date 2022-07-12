package p8;

import a9.f;
import java.util.LinkedHashMap;
import java.util.Map;

class f0
  extends e0
{
  public static <K, V> Map<K, V> c()
  {
    y localy = y.a;
    f.d(localy, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
    return localy;
  }
  
  public static <K, V> Map<K, V> d(Map<? extends K, ? extends V> paramMap)
  {
    f.f(paramMap, "<this>");
    int i = paramMap.size();
    if (i != 0)
    {
      if (i != 1) {
        return c0.e(paramMap);
      }
      return e0.b(paramMap);
    }
    return c0.c();
  }
  
  public static <K, V> Map<K, V> e(Map<? extends K, ? extends V> paramMap)
  {
    f.f(paramMap, "<this>");
    return new LinkedHashMap(paramMap);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.f0
 * JD-Core Version:    0.7.0.1
 */