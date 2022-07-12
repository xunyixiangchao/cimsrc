package com.farsunset.hoxin.emoticon.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Emoticon
  implements Serializable
{
  private static final transient long serialVersionUID = 1L;
  public String description;
  public Object icon;
  public Long id;
  public long index;
  public List<EmoticonItem> itemList;
  public String name;
  public byte state;
  public byte type;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Emoticon)) {
      return Objects.equals(((Emoticon)paramObject).id, this.id);
    }
    return false;
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(".");
    localStringBuilder.append(this.id);
    return localStringBuilder.toString().hashCode();
  }
  
  public boolean isDisable()
  {
    return this.state == 1;
  }
  
  public boolean isEnable()
  {
    return this.state == 0;
  }
  
  public boolean isNotOwned()
  {
    return this.state == -1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.emoticon.entity.Emoticon
 * JD-Core Version:    0.7.0.1
 */