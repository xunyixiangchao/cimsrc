package com.farsunset.hoxin.group.entity;

import java.io.Serializable;

public class GroupMember
  implements Serializable
{
  public static final byte STATE_BLOCKED = 1;
  public static final byte STATE_NORMAL = 0;
  public static final byte TYPE_FOUNDER = 1;
  public static final byte TYPE_NORMAL = 0;
  public static final long serialVersionUID = 4733464888738356502L;
  public boolean deleted;
  public long groupId;
  public long id;
  public String name;
  public byte type;
  public long uid;
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof GroupMember;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (GroupMember)paramObject;
      bool1 = bool2;
      if (paramObject.groupId == this.groupId)
      {
        bool1 = bool2;
        if (paramObject.uid == this.uid) {
          bool1 = true;
        }
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
 * Qualified Name:     com.farsunset.hoxin.group.entity.GroupMember
 * JD-Core Version:    0.7.0.1
 */