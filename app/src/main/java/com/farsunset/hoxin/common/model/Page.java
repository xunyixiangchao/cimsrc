package com.farsunset.hoxin.common.model;

import java.io.Serializable;

public class Page
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int count;
  public int countPage;
  public int currentPage;
  public int size;
  
  public boolean hasMore()
  {
    return this.currentPage < this.countPage;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.model.Page
 * JD-Core Version:    0.7.0.1
 */