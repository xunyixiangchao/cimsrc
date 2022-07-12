package l9;

import a9.f;
import f9.d;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import m9.c;

public final class h
{
  private final String a;
  private final Map<String, String> b;
  
  public h(String paramString, Map<String, String> paramMap)
  {
    this.a = paramString;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      paramString = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (paramString == null)
      {
        paramString = null;
      }
      else
      {
        Locale localLocale = Locale.US;
        f.e(localLocale, "US");
        paramString = paramString.toLowerCase(localLocale);
        f.e(paramString, "this as java.lang.String).toLowerCase(locale)");
      }
      localLinkedHashMap.put(paramString, localObject);
    }
    paramString = Collections.unmodifiableMap(localLinkedHashMap);
    f.e(paramString, "unmodifiableMap<String?, String>(newAuthParams)");
    this.b = paramString;
  }
  
  public final Map<String, String> a()
  {
    return this.b;
  }
  
  public final Charset b()
  {
    Object localObject = (String)this.b.get("charset");
    if (localObject != null) {}
    try
    {
      localObject = Charset.forName((String)localObject);
      f.e(localObject, "forName(charset)");
      return localObject;
    }
    catch (Exception localException)
    {
      label32:
      break label32;
    }
    return d.g;
  }
  
  public final String c()
  {
    return (String)this.b.get("realm");
  }
  
  public final String d()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    return c.a(this, paramObject);
  }
  
  public int hashCode()
  {
    return c.b(this);
  }
  
  public String toString()
  {
    return c.c(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.h
 * JD-Core Version:    0.7.0.1
 */