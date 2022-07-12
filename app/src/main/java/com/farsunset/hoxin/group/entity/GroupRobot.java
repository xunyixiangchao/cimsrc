package com.farsunset.hoxin.group.entity;

import java.io.Serializable;
import java.util.Objects;

public class GroupRobot
  implements Serializable
{
  public static final byte STATE_DISABLED = 1;
  public static final byte STATE_ENABLED = 0;
  public static final long serialVersionUID = 4733464888738356502L;
  public String extra;
  public long groupId;
  public long id;
  public String name;
  public byte state;
  public byte type;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof GroupRobot))
    {
      paramObject = (GroupRobot)paramObject;
      return Objects.equals(Long.valueOf(this.id), Long.valueOf(paramObject.id));
    }
    return false;
  }
  
  public int hashCode()
  {
    return getClass().getName().hashCode();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.group.entity.GroupRobot
 * JD-Core Version:    0.7.0.1
 */