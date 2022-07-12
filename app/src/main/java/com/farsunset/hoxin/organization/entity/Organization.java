package com.farsunset.hoxin.organization.entity;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Organization
{
  public List<Department> departmentList;
  public Long id;
  public List<DepartmentMember> memberList;
  public String name;
  
  public List<Long> getUidList()
  {
    Object localObject = this.memberList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = new LinkedList();
      Iterator localIterator = this.memberList.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((DepartmentMember)localIterator.next()).uid);
      }
      return localObject;
    }
    return Collections.emptyList();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.organization.entity.Organization
 * JD-Core Version:    0.7.0.1
 */