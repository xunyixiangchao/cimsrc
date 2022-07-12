package com.baidu.platform.util;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class a
  implements ParamBuilder<a>
{
  protected Map<String, String> a;
  
  public a a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      this.a = new LinkedHashMap();
    }
    this.a.put(paramString1, paramString2);
    return this;
  }
  
  public String a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localObject = new String();
      Iterator localIterator = this.a.keySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = AppMD5.encodeUrlParamsValue((String)this.a.get(str1));
        StringBuilder localStringBuilder;
        if (i == 0)
        {
          localStringBuilder = new StringBuilder();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localObject = "&";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(str1);
        localStringBuilder.append("=");
        localStringBuilder.append(str2);
        localObject = localStringBuilder.toString();
        i += 1;
      }
      return localObject;
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.util.a
 * JD-Core Version:    0.7.0.1
 */