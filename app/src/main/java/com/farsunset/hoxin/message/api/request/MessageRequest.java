package com.farsunset.hoxin.message.api.request;

import java.io.Serializable;

public class MessageRequest
  implements Serializable
{
  private String content;
  private String extra;
  private Byte format;
  private String title;
  private Long uid;
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getExtra()
  {
    return this.extra;
  }
  
  public Byte getFormat()
  {
    return this.format;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public Long getUid()
  {
    return this.uid;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setExtra(String paramString)
  {
    this.extra = paramString;
  }
  
  public void setFormat(Byte paramByte)
  {
    this.format = paramByte;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUid(Long paramLong)
  {
    this.uid = paramLong;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.api.request.MessageRequest
 * JD-Core Version:    0.7.0.1
 */