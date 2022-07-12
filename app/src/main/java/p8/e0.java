package p8;

import a9.f;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class e0
  extends d0
{
  public static final int a(int paramInt)
  {
    if (paramInt < 0) {
      return paramInt;
    }
    if (paramInt < 3) {
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return (int)(paramInt / 0.75F + 1.0F);
    }
    return 2147483647;
  }
  
  public static final <K, V> Map<K, V> b(Map<? extends K, ? extends V> paramMap)
  {
    f.f(paramMap, "<this>");
    paramMap = (Map.Entry)paramMap.entrySet().iterator().next();
    paramMap = Collections.singletonMap(paramMap.getKey(), paramMap.getValue());
    f.e(paramMap, "with(entries.iterator().…ingletonMap(key, value) }");
    return paramMap;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.e0
 * JD-Core Version:    0.7.0.1
 */