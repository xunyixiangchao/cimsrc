package com.farsunset.hoxin.micro.api.response;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.model.Page;
import com.farsunset.hoxin.micro.entity.MicroServer;
import java.util.List;

public class MicroServerListResult
  extends BaseResult
{
  public List<MicroServer> data;
  public Page page;
  
  public boolean isNotEmpty()
  {
    List localList = this.data;
    return (localList != null) && (!localList.isEmpty());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.micro.api.response.MicroServerListResult
 * JD-Core Version:    0.7.0.1
 */