package com.farsunset.hoxin.message.api.request;

import com.farsunset.hoxin.message.entity.Message;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class MessageForwardRequest
  implements Serializable
{
  private final String content;
  private final String extra;
  private final Byte format;
  private final List<MessageReceiver> receiver = new LinkedList();
  private final String title;
  
  public MessageForwardRequest(Message paramMessage)
  {
    this.title = paramMessage.title;
    this.content = paramMessage.content;
    this.extra = paramMessage.extra;
    this.format = Byte.valueOf(paramMessage.format);
  }
  
  public void add(long paramLong, String paramString)
  {
    MessageReceiver localMessageReceiver = new MessageReceiver();
    MessageReceiver.access$002(localMessageReceiver, paramLong);
    MessageReceiver.access$102(localMessageReceiver, paramString);
    this.receiver.add(localMessageReceiver);
  }
  
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
  
  public List<MessageReceiver> getReceiver()
  {
    return this.receiver;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public static class MessageReceiver
  {
    private String action;
    private long id;
    
    public String getAction()
    {
      return this.action;
    }
    
    public long getId()
    {
      return this.id;
    }
    
    public void setAction(String paramString)
    {
      this.action = paramString;
    }
    
    public void setId(long paramLong)
    {
      this.id = paramLong;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.api.request.MessageForwardRequest
 * JD-Core Version:    0.7.0.1
 */