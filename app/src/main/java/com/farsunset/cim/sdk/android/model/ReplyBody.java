package com.farsunset.cim.sdk.android.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReplyBody
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String code;
  private final Map<String, String> data = new HashMap();
  private String key;
  private String message;
  private long timestamp;
  
  public String get(String paramString)
  {
    return (String)this.data.get(paramString);
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public Set<String> getKeySet()
  {
    return this.data.keySet();
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public void put(String paramString1, String paramString2)
  {
    this.data.put(paramString1, paramString2);
  }
  
  public void putAll(Map<String, String> paramMap)
  {
    this.data.putAll(paramMap);
  }
  
  public void remove(String paramString)
  {
    this.data.remove(paramString);
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("#ReplyBody#");
    localStringBuffer.append("\n");
    localStringBuffer.append("key:");
    localStringBuffer.append(getKey());
    localStringBuffer.append("\n");
    localStringBuffer.append("timestamp:");
    localStringBuffer.append(this.timestamp);
    localStringBuffer.append("\n");
    localStringBuffer.append("code:");
    localStringBuffer.append(this.code);
    localStringBuffer.append("\n");
    localStringBuffer.append("data{");
    localStringBuffer.append("\n");
    Iterator localIterator = getKeySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuffer.append(str);
      localStringBuffer.append(":");
      localStringBuffer.append(get(str));
      localStringBuffer.append("\n");
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.cim.sdk.android.model.ReplyBody
 * JD-Core Version:    0.7.0.1
 */