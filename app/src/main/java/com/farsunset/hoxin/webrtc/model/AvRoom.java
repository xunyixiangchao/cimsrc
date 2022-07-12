package com.farsunset.hoxin.webrtc.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AvRoom
  implements Serializable
{
  private Map<Long, String> member = new HashMap();
  private String tag;
  private long timestamp;
  private byte type;
  private long uid;
  
  public void add(long paramLong, String paramString)
  {
    this.member.put(Long.valueOf(paramLong), paramString);
  }
  
  public void addAll(Map<Long, String> paramMap)
  {
    this.member.putAll(paramMap);
  }
  
  public long[] getIdArray()
  {
    Object localObject = getIdList();
    long[] arrayOfLong = new long[((List)localObject).size()];
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Long localLong = (Long)((Iterator)localObject).next();
      arrayOfLong[localAtomicInteger.getAndIncrement()] = localLong.longValue();
    }
    return arrayOfLong;
  }
  
  public List<Long> getIdList()
  {
    return new LinkedList(this.member.keySet());
  }
  
  public Map<Long, String> getMember()
  {
    return this.member;
  }
  
  public String getName(long paramLong)
  {
    return (String)this.member.get(Long.valueOf(paramLong));
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public byte getType()
  {
    return this.type;
  }
  
  public long getUid()
  {
    return this.uid;
  }
  
  public void setMember(Map<Long, String> paramMap)
  {
    this.member = paramMap;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public void setType(byte paramByte)
  {
    this.type = paramByte;
  }
  
  public void setUid(long paramLong)
  {
    this.uid = paramLong;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.webrtc.model.AvRoom
 * JD-Core Version:    0.7.0.1
 */