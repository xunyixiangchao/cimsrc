package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.a;
import com.baidu.platform.core.poi.IPoiSearch;
import com.baidu.platform.core.poi.e;

public class PoiSearch
  extends a
{
  private IPoiSearch a = new e();
  private boolean b = false;
  
  public static PoiSearch newInstance()
  {
    BMapManager.init();
    return new PoiSearch();
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
  
  public boolean searchInBound(PoiBoundSearchOption paramPoiBoundSearchOption)
  {
    IPoiSearch localIPoiSearch = this.a;
    if (localIPoiSearch != null)
    {
      if ((paramPoiBoundSearchOption != null) && (paramPoiBoundSearchOption.mBound != null) && (paramPoiBoundSearchOption.mKeyword != null)) {
        return localIPoiSearch.searchInBound(paramPoiBoundSearchOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option or bound or keyworld can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
  }
  
  public boolean searchInCity(PoiCitySearchOption paramPoiCitySearchOption)
  {
    IPoiSearch localIPoiSearch = this.a;
    if (localIPoiSearch != null)
    {
      if ((paramPoiCitySearchOption != null) && (paramPoiCitySearchOption.mCity != null) && (paramPoiCitySearchOption.mKeyword != null)) {
        return localIPoiSearch.searchInCity(paramPoiCitySearchOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option or city or keyworld can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
  }
  
  public boolean searchNearby(PoiNearbySearchOption paramPoiNearbySearchOption)
  {
    IPoiSearch localIPoiSearch = this.a;
    if (localIPoiSearch != null)
    {
      if ((paramPoiNearbySearchOption != null) && (paramPoiNearbySearchOption.mLocation != null) && (paramPoiNearbySearchOption.mKeyword != null))
      {
        if (paramPoiNearbySearchOption.mRadius <= 0) {
          return false;
        }
        return localIPoiSearch.searchNearby(paramPoiNearbySearchOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option or location or keyworld can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
  }
  
  public boolean searchPoiDetail(PoiDetailSearchOption paramPoiDetailSearchOption)
  {
    if (this.a != null)
    {
      if ((paramPoiDetailSearchOption != null) && (paramPoiDetailSearchOption.getUid() != null)) {
        return this.a.searchPoiDetail(paramPoiDetailSearchOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option or uid can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
  }
  
  public boolean searchPoiIndoor(PoiIndoorOption paramPoiIndoorOption)
  {
    IPoiSearch localIPoiSearch = this.a;
    if (localIPoiSearch != null)
    {
      if ((paramPoiIndoorOption != null) && (paramPoiIndoorOption.bid != null) && (paramPoiIndoorOption.wd != null)) {
        return localIPoiSearch.searchPoiIndoor(paramPoiIndoorOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option or indoor bid or keyword can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
  }
  
  public void setOnGetPoiSearchResultListener(OnGetPoiSearchResultListener paramOnGetPoiSearchResultListener)
  {
    IPoiSearch localIPoiSearch = this.a;
    if (localIPoiSearch != null)
    {
      if (paramOnGetPoiSearchResultListener != null)
      {
        localIPoiSearch.setOnPoiSearchListener(paramOnGetPoiSearchResultListener);
        return;
      }
      throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiSearch
 * JD-Core Version:    0.7.0.1
 */