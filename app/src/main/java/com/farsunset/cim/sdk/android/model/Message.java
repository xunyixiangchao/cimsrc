package com.farsunset.cim.sdk.android.model;

import java.io.Serializable;

public class Message
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String action;
  private String content;
  private String extra;
  private String format;
  private long id;
  private String receiver;
  private String sender;
  private long timestamp = System.currentTimeMillis();
  private String title;
  
  public String getAction()
  {
    return this.action;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getExtra()
  {
    return this.extra;
  }
  
  public String getFormat()
  {
    return this.format;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getReceiver()
  {
    return this.receiver;
  }
  
  public String getSender()
  {
    return this.sender;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setExtra(String paramString)
  {
    this.extra = paramString;
  }
  
  public void setFormat(String paramString)
  {
    this.format = paramString;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setReceiver(String paramString)
  {
    this.receiver = paramString;
  }
  
  public void setSender(String paramString)
  {
    this.sender = paramString;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("#Message#");
    localStringBuffer.append("\n");
    localStringBuffer.append("id:");
    localStringBuffer.append(this.id);
    localStringBuffer.append("\n");
    localStringBuffer.append("action:");
    localStringBuffer.append(this.action);
    localStringBuffer.append("\n");
    localStringBuffer.append("title:");
    localStringBuffer.append(this.title);
    localStringBuffer.append("\n");
    localStringBuffer.append("content:");
    localStringBuffer.append(this.content);
    localStringBuffer.append("\n");
    localStringBuffer.append("extra:");
    localStringBuffer.append(this.extra);
    localStringBuffer.append("\n");
    localStringBuffer.append("sender:");
    localStringBuffer.append(this.sender);
    localStringBuffer.append("\n");
    localStringBuffer.append("receiver:");
    localStringBuffer.append(this.receiver);
    localStringBuffer.append("\n");
    localStringBuffer.append("format:");
    localStringBuffer.append(this.format);
    localStringBuffer.append("\n");
    localStringBuffer.append("timestamp:");
    localStringBuffer.append(this.timestamp);
    return localStringBuffer.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.cim.sdk.android.model.Message
 * JD-Core Version:    0.7.0.1
 */