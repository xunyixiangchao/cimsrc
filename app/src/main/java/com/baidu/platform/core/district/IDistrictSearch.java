package com.baidu.platform.core.district;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;

public abstract interface IDistrictSearch
{
  public abstract void destroy();
  
  public abstract boolean searchDistrict(DistrictSearchOption paramDistrictSearchOption);
  
  public abstract void setOnDistrictSearchListener(OnGetDistricSearchResultListener paramOnGetDistricSearchResultListener);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.district.IDistrictSearch
 * JD-Core Version:    0.7.0.1
 */