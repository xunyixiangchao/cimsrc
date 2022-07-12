package com.farsunset.hoxin.webrtc.api.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RoomAddRequest
  implements Serializable
{
  private Map<Long, String> member;
  private final Map<Long, String> newMember = new HashMap();
  private String tag;
  private byte type;
  
  public void addNew(long paramLong, String paramString)
  {
    this.newMember.put(Long.valueOf(paramLong), paramString);
  }
  
  public Map<Long, String> getMember()
  {
    return this.member;
  }
  
  public Map<Long, String> getNewMember()
  {
    return this.newMember;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public byte getType()
  {
    return this.type;
  }
  
  public void setMember(Map<Long, String> paramMap)
  {
    this.member = paramMap;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  public void setType(byte paramByte)
  {
    this.type = paramByte;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.webrtc.api.request.RoomAddRequest
 * JD-Core Version:    0.7.0.1
 */