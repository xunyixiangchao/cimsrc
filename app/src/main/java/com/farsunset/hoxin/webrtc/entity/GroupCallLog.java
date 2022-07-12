package com.farsunset.hoxin.webrtc.entity;

import java.io.Serializable;

public class GroupCallLog
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String content;
  public Long duration;
  public long id;
  public int state;
  public String tag;
  public Long timestamp;
  public int type;
  public long uid;
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof GroupCallLog;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((GroupCallLog)paramObject).id == this.id) {
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
 * Qualified Name:     com.farsunset.hoxin.webrtc.entity.GroupCallLog
 * JD-Core Version:    0.7.0.1
 */