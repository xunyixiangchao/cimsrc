package com.farsunset.hoxin.group.api.request;

import java.io.Serializable;
import java.util.List;

public class GroupCreateRequest
  implements Serializable
{
  private List<Long> idList;
  private String name;
  
  public List<Long> getIdList()
  {
    return this.idList;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setIdList(List<Long> paramList)
  {
    this.idList = paramList;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.group.api.request.GroupCreateRequest
 * JD-Core Version:    0.7.0.1
 */