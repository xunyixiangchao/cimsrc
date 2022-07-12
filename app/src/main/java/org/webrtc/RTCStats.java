package org.webrtc;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RTCStats
{
  private final String id;
  private final Map<String, Object> members;
  private final long timestampUs;
  private final String type;
  
  public RTCStats(long paramLong, String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    this.timestampUs = paramLong;
    this.type = paramString1;
    this.id = paramString2;
    this.members = paramMap;
  }
  
  private static void appendValue(StringBuilder paramStringBuilder, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      paramStringBuilder.append('[');
      int i = 0;
      while (i < paramObject.length)
      {
        if (i != 0) {
          paramStringBuilder.append(", ");
        }
        appendValue(paramStringBuilder, paramObject[i]);
        i += 1;
      }
      paramStringBuilder.append(']');
      return;
    }
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append('"');
      paramStringBuilder.append(paramObject);
      paramStringBuilder.append('"');
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  @CalledByNative
  static RTCStats create(long paramLong, String paramString1, String paramString2, Map paramMap)
  {
    return new RTCStats(paramLong, paramString1, paramString2, paramMap);
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public Map<String, Object> getMembers()
  {
    return this.members;
  }
  
  public double getTimestampUs()
  {
    return this.timestampUs;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ timestampUs: ");
    localStringBuilder.append(this.timestampUs);
    localStringBuilder.append(", type: ");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", id: ");
    localStringBuilder.append(this.id);
    Iterator localIterator = this.members.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(", ");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(": ");
      appendValue(localStringBuilder, localEntry.getValue());
    }
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.RTCStats
 * JD-Core Version:    0.7.0.1
 */