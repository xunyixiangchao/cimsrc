package com.farsunset.hoxin.common.model;

import com.farsunset.hoxin.friend.entity.Friend;

public class User
  extends Friend
{
  public static final transient long serialVersionUID = 4733464888738356502L;
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof User;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (User)paramObject;
      bool1 = bool2;
      if (this.id == paramObject.id) {
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
 * Qualified Name:     com.farsunset.hoxin.common.model.User
 * JD-Core Version:    0.7.0.1
 */