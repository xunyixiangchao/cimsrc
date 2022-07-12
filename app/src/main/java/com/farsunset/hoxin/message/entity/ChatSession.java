package com.farsunset.hoxin.message.entity;

import com.farsunset.hoxin.common.model.MessageSource;
import java.io.Serializable;

public class ChatSession
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String action;
  public int badge;
  public long id;
  public String message;
  public String name;
  public long priority;
  public long sourceId;
  public int sourceType;
  public int state;
  public long timestamp;
  public int visible;
  
  public static ChatSession of(long paramLong, int paramInt)
  {
    ChatSession localChatSession = new ChatSession();
    localChatSession.sourceType = paramInt;
    localChatSession.sourceId = paramLong;
    return localChatSession;
  }
  
  public static ChatSession of(MessageSource paramMessageSource)
  {
    ChatSession localChatSession = new ChatSession();
    localChatSession.sourceType = paramMessageSource.getType();
    localChatSession.action = paramMessageSource.getAction();
    localChatSession.name = paramMessageSource.getName();
    localChatSession.sourceId = paramMessageSource.getId().longValue();
    return localChatSession;
  }
  
  public boolean equals(MessageSource paramMessageSource)
  {
    return (paramMessageSource.getId().longValue() == this.sourceId) && (paramMessageSource.getType() == this.sourceType);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ChatSession;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (ChatSession)paramObject;
    bool1 = bool2;
    if (paramObject.sourceId == this.sourceId)
    {
      bool1 = bool2;
      if (paramObject.sourceType == this.sourceType) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return getClass().getName().hashCode();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.entity.ChatSession
 * JD-Core Version:    0.7.0.1
 */