package com.farsunset.hoxin.emoticon.entity;

import java.io.Serializable;

public class EmoticonItem
  implements Serializable
{
  private static final transient long serialVersionUID = 1L;
  public Long emoticonId;
  public Long id;
  public Object image;
  public String name;
  public byte type;
  
  public boolean isDynamic()
  {
    return this.type == 1;
  }
  
  public boolean isStatic()
  {
    return this.type == 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.emoticon.entity.EmoticonItem
 * JD-Core Version:    0.7.0.1
 */