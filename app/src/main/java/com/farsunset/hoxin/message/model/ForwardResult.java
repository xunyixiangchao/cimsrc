package com.farsunset.hoxin.message.model;

public class ForwardResult
{
  private String action;
  private long id;
  private Long mid;
  private long timestamp;
  
  public String getAction()
  {
    return this.action;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public Long getMid()
  {
    return this.mid;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setMid(Long paramLong)
  {
    this.mid = paramLong;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.model.ForwardResult
 * JD-Core Version:    0.7.0.1
 */