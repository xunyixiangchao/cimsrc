package com.farsunset.hoxin.micro.api.response;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.micro.entity.MicroServerMenu;
import java.util.ArrayList;

public class MicroServerMenuListResult
  extends BaseResult
{
  public ArrayList<MicroServerMenu> data;
  
  public boolean isNotEmpty()
  {
    ArrayList localArrayList = this.data;
    return (localArrayList != null) && (!localArrayList.isEmpty());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.micro.api.response.MicroServerMenuListResult
 * JD-Core Version:    0.7.0.1
 */