package com.farsunset.hoxin.webrtc.api.request;

import java.io.Serializable;

public class RoomAcceptRequest
  implements Serializable
{
  private int audio;
  private String tag;
  private int video;
  
  public int getAudio()
  {
    return this.audio;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public int getVideo()
  {
    return this.video;
  }
  
  public void setAudio(int paramInt)
  {
    this.audio = paramInt;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  public void setVideo(int paramInt)
  {
    this.video = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.webrtc.api.request.RoomAcceptRequest
 * JD-Core Version:    0.7.0.1
 */