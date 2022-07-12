package com.farsunset.hoxin.group.api.request;

import java.io.Serializable;
import java.util.List;

public class GroupInviteRequest
  implements Serializable
{
  private Long groupId;
  private List<Long> idList;
  
  public Long getGroupId()
  {
    return this.groupId;
  }
  
  public List<Long> getIdList()
  {
    return this.idList;
  }
  
  public void setGroupId(Long paramLong)
  {
    this.groupId = paramLong;
  }
  
  public void setIdList(List<Long> paramList)
  {
    this.idList = paramList;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.group.api.request.GroupInviteRequest
 * JD-Core Version:    0.7.0.1
 */