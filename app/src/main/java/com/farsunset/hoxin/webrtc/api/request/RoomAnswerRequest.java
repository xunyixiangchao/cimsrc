package com.farsunset.hoxin.webrtc.api.request;

import java.io.Serializable;

public class RoomAnswerRequest
  implements Serializable
{
  private int audio;
  private String description;
  private String tag;
  private Long uid;
  private int video;
  
  public int getAudio()
  {
    return this.audio;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public Long getUid()
  {
    return this.uid;
  }
  
  public int getVideo()
  {
    return this.video;
  }
  
  public void setAudio(int paramInt)
  {
    this.audio = paramInt;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  public void setUid(Long paramLong)
  {
    this.uid = paramLong;
  }
  
  public void setVideo(int paramInt)
  {
    this.video = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.webrtc.api.request.RoomAnswerRequest
 * JD-Core Version:    0.7.0.1
 */