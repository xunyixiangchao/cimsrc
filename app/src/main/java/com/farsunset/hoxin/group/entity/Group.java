package com.farsunset.hoxin.group.entity;

import com.farsunset.hoxin.common.model.MessageSource;
import java.util.List;
import java.util.Objects;
import u3.b0;

public class Group
  extends MessageSource
{
  public static final String NAME = Group.class.getSimpleName();
  public static final transient byte STATE_BLOCKED = 1;
  public static final transient byte STATE_NORMAL = 0;
  public static final long serialVersionUID = 4733464888738356502L;
  public boolean deleted;
  public long id;
  public List<GroupMember> memberList;
  public String name;
  public String notice;
  public byte state;
  public long uid;
  
  public Group() {}
  
  public Group(long paramLong)
  {
    this.id = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Group)) {
      return Objects.equals(Long.valueOf(((Group)paramObject).id), Long.valueOf(this.id));
    }
    return false;
  }
  
  public String getAction()
  {
    return "3";
  }
  
  public int getDefaultIconRID()
  {
    return 2131165686;
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
    return 2;
  }
  
  public String getWebIcon()
  {
    return b0.g(this.id);
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
 * Qualified Name:     com.farsunset.hoxin.group.entity.Group
 * JD-Core Version:    0.7.0.1
 */