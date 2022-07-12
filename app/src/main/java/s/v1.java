package s;

import android.util.ArrayMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class v1
  extends n2
{
  private v1(Map<String, Object> paramMap)
  {
    super(paramMap);
  }
  
  public static v1 f()
  {
    return new v1(new ArrayMap());
  }
  
  public static v1 g(n2 paramn2)
  {
    ArrayMap localArrayMap = new ArrayMap();
    Iterator localIterator = paramn2.d().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayMap.put(str, paramn2.c(str));
    }
    return new v1(localArrayMap);
  }
  
  public void e(n2 paramn2)
  {
    Map localMap = this.a;
    if (localMap != null)
    {
      paramn2 = paramn2.a;
      if (paramn2 != null) {
        localMap.putAll(paramn2);
      }
    }
  }
  
  public void h(String paramString, Object paramObject)
  {
    this.a.put(paramString, paramObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.v1
 * JD-Core Version:    0.7.0.1
 */