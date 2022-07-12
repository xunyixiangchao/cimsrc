package com.farsunset.hoxin.emoticon.api.response;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.model.Page;
import com.farsunset.hoxin.emoticon.entity.Emoticon;
import java.util.ArrayList;

public class EmoticonPageResult
  extends BaseResult
{
  public ArrayList<Emoticon> data;
  public Page page;
  
  public boolean isEmpty()
  {
    ArrayList localArrayList = this.data;
    return (localArrayList == null) || (localArrayList.isEmpty());
  }
  
  public boolean isNotEmpty()
  {
    ArrayList localArrayList = this.data;
    return (localArrayList != null) && (!localArrayList.isEmpty());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.emoticon.api.response.EmoticonPageResult
 * JD-Core Version:    0.7.0.1
 */