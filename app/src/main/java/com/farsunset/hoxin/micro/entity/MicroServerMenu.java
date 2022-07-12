package com.farsunset.hoxin.micro.entity;

import java.io.Serializable;

public class MicroServerMenu
  implements Serializable
{
  private static final byte ACTION_API = 1;
  private static final byte ACTION_ROOT = 0;
  private static final byte ACTION_TEXT = 3;
  private static final byte ACTION_WEB = 2;
  public static final long serialVersionUID = 1L;
  public String code;
  public String content;
  public long id;
  public String name;
  public Long parentId;
  public long serverId;
  public int sort;
  public Byte type;
  
  public boolean hasSubMenu()
  {
    return this.type.byteValue() == 0;
  }
  
  public boolean isApiMenu()
  {
    return 1 == this.type.byteValue();
  }
  
  public boolean isRootMenu()
  {
    return this.parentId == null;
  }
  
  public boolean isTextMenu()
  {
    return 3 == this.type.byteValue();
  }
  
  public boolean isWebMenu()
  {
    return 2 == this.type.byteValue();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.micro.entity.MicroServerMenu
 * JD-Core Version:    0.7.0.1
 */