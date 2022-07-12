package com.farsunset.hoxin.webrtc.api.request;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class CreateRoomRequest
  implements Serializable
{
  private Map<Long, String> member = new TreeMap();
  private String tag;
  
  public void clear()
  {
    this.member.clear();
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
  
  public void setMember(Map<Long, String> paramMap)
  {
    this.member = paramMap;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.webrtc.api.request.CreateRoomRequest
 * JD-Core Version:    0.7.0.1
 */