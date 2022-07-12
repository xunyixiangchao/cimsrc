package h2;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j
  implements h
{
  private final Map<String, List<i>> c;
  private volatile Map<String, String> d;
  
  j(Map<String, List<i>> paramMap)
  {
    this.c = Collections.unmodifiableMap(paramMap);
  }
  
  private String b(List<i> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      String str = ((i)paramList.get(i)).a();
      if (!TextUtils.isEmpty(str))
      {
        localStringBuilder.append(str);
        if (i != paramList.size() - 1) {
          localStringBuilder.append(',');
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private Map<String, String> c()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = b((List)localEntry.getValue());
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put(localEntry.getKey(), str);
      }
    }
    return localHashMap;
  }
  
  public Map<String, String> a()
  {
    if (this.d == null) {
      try
      {
        if (this.d == null) {
          this.d = Collections.unmodifiableMap(c());
        }
      }
      finally {}
    }
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof j))
    {
      paramObject = (j)paramObject;
      return this.c.equals(paramObject.c);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LazyHeaders{headers=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    private static final String d;
    private static final Map<String, List<i>> e;
    private boolean a = true;
    private Map<String, List<i>> b = e;
    private boolean c = true;
    
    static
    {
      String str = b();
      d = str;
      HashMap localHashMap = new HashMap(2);
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put("User-Agent", Collections.singletonList(new j.b(str)));
      }
      e = Collections.unmodifiableMap(localHashMap);
    }
    
    static String b()
    {
      String str = System.getProperty("http.agent");
      if (TextUtils.isEmpty(str)) {
        return str;
      }
      int j = str.length();
      StringBuilder localStringBuilder = new StringBuilder(str.length());
      int i = 0;
      while (i < j)
      {
        char c1 = str.charAt(i);
        if (((c1 <= '\037') && (c1 != '\t')) || (c1 >= '')) {
          c1 = '?';
        }
        localStringBuilder.append(c1);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public j a()
    {
      this.a = true;
      return new j(this.b);
    }
  }
  
  static final class b
    implements i
  {
    private final String a;
    
    b(String paramString)
    {
      this.a = paramString;
    }
    
    public String a()
    {
      return this.a;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        return this.a.equals(paramObject.a);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StringHeaderFactory{value='");
      localStringBuilder.append(this.a);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.j
 * JD-Core Version:    0.7.0.1
 */