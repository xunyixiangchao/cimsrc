package com.farsunset.hoxin.message.entity;

import java.io.Serializable;
import java.util.Objects;
import w7.a;

public class Message
  implements Serializable
{
  public static final String NAME = Message.class.getSimpleName();
  public static final String TABLE_NAME = "t_hoxin_message";
  public static final long serialVersionUID = 1845362556725768545L;
  public String action;
  public String content;
  @a(serialize=false)
  public Long createTime;
  public byte direction = 0;
  public String extra;
  public byte format = -1;
  @a(serialize=false)
  public long id;
  public Long receiver;
  public Long sender;
  public Long sessionId;
  @a(deserialize=false, serialize=false)
  public Byte state;
  public String title;
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof Message;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((Message)paramObject).id == this.id) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return getClass().getName().hashCode();
  }
  
  public boolean isFileFormat()
  {
    return 4 == this.format;
  }
  
  public boolean isGroupChatMessage()
  {
    return Objects.equals(this.action, "3");
  }
  
  public boolean isImageFormat()
  {
    return 1 == this.format;
  }
  
  public boolean isLinkFormat()
  {
    return 6 == this.format;
  }
  
  public boolean isLinkListFormat()
  {
    return 7 == this.format;
  }
  
  public boolean isMapFormat()
  {
    return 5 == this.format;
  }
  
  public boolean isNeedShowReadStatus()
  {
    return this.action.equals("0");
  }
  
  public boolean isNoNeedShow()
  {
    return (this.action.startsWith("9")) || (this.action.startsWith("8"));
  }
  
  public boolean isProfileFormat()
  {
    return 14 == this.format;
  }
  
  public boolean isSendState()
  {
    return 4 == this.state.byteValue();
  }
  
  public boolean isSingleChatMessage()
  {
    return Objects.equals(this.action, "0");
  }
  
  public boolean isTextFormat()
  {
    return this.format == 0;
  }
  
  public boolean isVideoFormat()
  {
    return 3 == this.format;
  }
  
  public boolean isVoiceFormat()
  {
    return 2 == this.format;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.entity.Message
 * JD-Core Version:    0.7.0.1
 */