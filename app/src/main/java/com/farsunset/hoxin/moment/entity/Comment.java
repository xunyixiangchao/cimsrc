package com.farsunset.hoxin.moment.entity;

import java.io.Serializable;
import w7.a;

public class Comment
  implements Serializable
{
  public static final String TYPE_COMMENT = "1";
  public static final String TYPE_MOMENT = "0";
  public static final String TYPE_PRAISE = "2";
  private static final long serialVersionUID = 1L;
  public String content;
  public Long createTime;
  public boolean deleted;
  @a(serialize=false)
  public long id;
  public long momentId;
  public Long parentId;
  public String type;
  public long uid;
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof Comment;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((Comment)paramObject).id == this.id) {
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
 * Qualified Name:     com.farsunset.hoxin.moment.entity.Comment
 * JD-Core Version:    0.7.0.1
 */