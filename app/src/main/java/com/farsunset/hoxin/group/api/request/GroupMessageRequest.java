package com.farsunset.hoxin.group.api.request;

import java.io.Serializable;

public class GroupMessageRequest
  implements Serializable
{
  private String content;
  private String extra;
  private Byte format;
  private Long groupId;
  private String title;
  
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
  
  public Long getGroupId()
  {
    return this.groupId;
  }
  
  public String getTitle()
  {
    return this.title;
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
  
  public void setGroupId(Long paramLong)
  {
    this.groupId = paramLong;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.group.api.request.GroupMessageRequest
 * JD-Core Version:    0.7.0.1
 */