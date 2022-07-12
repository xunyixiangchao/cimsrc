package com.farsunset.hoxin.message.model;

import com.farsunset.hoxin.message.entity.ChatSession;
import java.io.Serializable;

public class MessageSearchHit
  implements Serializable
{
  public long count;
  public ChatSession session;
  public long sessionId;
  public long timestamp;
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.model.MessageSearchHit
 * JD-Core Version:    0.7.0.1
 */