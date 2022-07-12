package com.farsunset.hoxin.friend.entity;

import com.farsunset.hoxin.common.model.MessageSource;
import u3.b0;

public class Friend
  extends MessageSource
{
  public static final transient byte GENDER_MAN = 1;
  public static final transient byte TYPE_BOTH = 2;
  public static final transient byte TYPE_CONTACTS = 1;
  public static final transient byte TYPE_FRIEND = 0;
  public static final transient byte TYPE_NONE = 3;
  private static final long serialVersionUID = 1L;
  public String email;
  public String firstPinyin;
  public Byte gender = Byte.valueOf((byte)1);
  public long id;
  public String motto;
  public String name;
  public String telephone;
  public byte type;
  
  public Friend clone()
  {
    Friend localFriend = new Friend();
    localFriend.id = this.id;
    localFriend.email = this.email;
    localFriend.name = this.name;
    localFriend.gender = this.gender;
    localFriend.telephone = this.telephone;
    localFriend.motto = this.motto;
    localFriend.type = this.type;
    localFriend.firstPinyin = this.firstPinyin;
    return localFriend;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof Friend;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((Friend)paramObject).id == this.id) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getAction()
  {
    return "0";
  }
  
  public int getDefaultIconRID()
  {
    return 2131165495;
  }
  
  public Long getId()
  {
    return Long.valueOf(this.id);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public String getWebIcon()
  {
    return b0.l(this.id);
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(".");
    localStringBuilder.append(this.id);
    return localStringBuilder.toString().hashCode();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.friend.entity.Friend
 * JD-Core Version:    0.7.0.1
 */