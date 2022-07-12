package com.farsunset.hoxin.common.model;

import java.io.Serializable;

public class Link
  implements Serializable
{
  public static final transient String NAME = Link.class.getSimpleName();
  private static final long serialVersionUID = 1L;
  public String content;
  public String image;
  public String link;
  public String title;
  
  public String toString()
  {
    if (this.title == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.title);
    localStringBuilder.append("\n");
    localStringBuilder.append(this.link);
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.model.Link
 * JD-Core Version:    0.7.0.1
 */