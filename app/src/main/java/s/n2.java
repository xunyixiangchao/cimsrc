package s;

import android.util.ArrayMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class n2
{
  private static final n2 b = new n2(new ArrayMap());
  protected final Map<String, Object> a;
  
  protected n2(Map<String, Object> paramMap)
  {
    this.a = paramMap;
  }
  
  public static n2 a()
  {
    return b;
  }
  
  public static n2 b(n2 paramn2)
  {
    ArrayMap localArrayMap = new ArrayMap();
    Iterator localIterator = paramn2.d().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayMap.put(str, paramn2.c(str));
    }
    return new n2(localArrayMap);
  }
  
  public Object c(String paramString)
  {
    return this.a.get(paramString);
  }
  
  public Set<String> d()
  {
    return this.a.keySet();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.n2
 * JD-Core Version:    0.7.0.1
 */