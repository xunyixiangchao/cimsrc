package com.farsunset.hoxin.moment.entity;

import java.io.Serializable;

public class MomentRule
  implements Serializable
{
  public static final transient byte TYPE_BLOCK = 0;
  public static final transient byte TYPE_IGNORE = 1;
  private static final long serialVersionUID = 1L;
  public long id;
  public long targetId;
  public byte type;
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.entity.MomentRule
 * JD-Core Version:    0.7.0.1
 */