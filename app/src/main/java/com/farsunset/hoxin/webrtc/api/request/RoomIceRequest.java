package com.farsunset.hoxin.webrtc.api.request;

import java.io.Serializable;

public class RoomIceRequest
  implements Serializable
{
  private String content;
  private String tag;
  private Long uid;
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public Long getUid()
  {
    return this.uid;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  public void setUid(Long paramLong)
  {
    this.uid = paramLong;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.webrtc.api.request.RoomIceRequest
 * JD-Core Version:    0.7.0.1
 */