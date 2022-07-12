package com.farsunset.hoxin.group.api.response;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.group.entity.GroupMember;
import java.util.ArrayList;

public class GroupMemberListResult
  extends BaseResult
{
  public ArrayList<GroupMember> data;
  
  public boolean isNotEmpty()
  {
    ArrayList localArrayList = this.data;
    return (localArrayList != null) && (!localArrayList.isEmpty());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.group.api.response.GroupMemberListResult
 * JD-Core Version:    0.7.0.1
 */