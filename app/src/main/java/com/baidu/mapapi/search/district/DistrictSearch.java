package com.baidu.mapapi.search.district;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.a;
import com.baidu.platform.core.district.IDistrictSearch;

public class DistrictSearch
  extends a
{
  private IDistrictSearch a = null;
  private boolean b = false;
  
  public static DistrictSearch newInstance()
  {
    BMapManager.init();
    return new DistrictSearch();
  }
  
  public void destroy()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.a.destroy();
    BMapManager.destroy();
  }
  
  public boolean searchDistrict(DistrictSearchOption paramDistrictSearchOption)
  {
    if (this.a != null)
    {
      if (paramDistrictSearchOption != null)
      {
        String str = paramDistrictSearchOption.mCityName;
        if ((str != null) && (!str.equals(""))) {
          return this.a.searchDistrict(paramDistrictSearchOption);
        }
      }
      throw new IllegalArgumentException("BDMapSDKException: option or city name can not be null or empty.");
    }
    throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
  }
  
  public void setOnDistrictSearchListener(OnGetDistricSearchResultListener paramOnGetDistricSearchResultListener)
  {
    IDistrictSearch localIDistrictSearch = this.a;
    if (localIDistrictSearch != null)
    {
      if (paramOnGetDistricSearchResultListener != null)
      {
        localIDistrictSearch.setOnDistrictSearchListener(paramOnGetDistricSearchResultListener);
        return;
      }
      throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.district.DistrictSearch
 * JD-Core Version:    0.7.0.1
 */