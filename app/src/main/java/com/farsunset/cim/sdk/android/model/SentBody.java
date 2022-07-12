package com.farsunset.cim.sdk.android.model;

import com.farsunset.cim.sdk.android.model.proto.SentBodyProto.Model;
import com.farsunset.cim.sdk.android.model.proto.SentBodyProto.Model.Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SentBody
  implements Serializable, BinaryBody
{
  private static final long serialVersionUID = 1L;
  private final Map<String, String> data = new HashMap();
  private String key;
  private long timestamp = System.currentTimeMillis();
  
  public String get(String paramString)
  {
    return (String)this.data.get(paramString);
  }
  
  public byte[] getByteArray()
  {
    SentBodyProto.Model.Builder localBuilder = SentBodyProto.Model.newBuilder();
    localBuilder.setKey(this.key);
    localBuilder.setTimestamp(this.timestamp);
    if (!this.data.isEmpty()) {
      localBuilder.putAllData(this.data);
    }
    return ((SentBodyProto.Model)localBuilder.build()).toByteArray();
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public Set<String> getKeySet()
  {
    return this.data.keySet();
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public byte getType()
  {
    return 3;
  }
  
  public void put(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      this.data.put(paramString1, paramString2);
    }
  }
  
  public void remove(String paramString)
  {
    this.data.remove(paramString);
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("#SentBody#");
    localStringBuffer.append("\n");
    localStringBuffer.append("key:");
    localStringBuffer.append(this.key);
    localStringBuffer.append("\n");
    localStringBuffer.append("timestamp:");
    localStringBuffer.append(this.timestamp);
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
 * Qualified Name:     com.farsunset.cim.sdk.android.model.SentBody
 * JD-Core Version:    0.7.0.1
 */