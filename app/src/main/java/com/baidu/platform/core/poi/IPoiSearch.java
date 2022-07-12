package com.baidu.platform.core.poi;

import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;

public abstract interface IPoiSearch
{
  public abstract void destroy();
  
  public abstract boolean searchInBound(PoiBoundSearchOption paramPoiBoundSearchOption);
  
  public abstract boolean searchInCity(PoiCitySearchOption paramPoiCitySearchOption);
  
  public abstract boolean searchNearby(PoiNearbySearchOption paramPoiNearbySearchOption);
  
  public abstract boolean searchPoiDetail(PoiDetailSearchOption paramPoiDetailSearchOption);
  
  public abstract boolean searchPoiIndoor(PoiIndoorOption paramPoiIndoorOption);
  
  public abstract void setOnPoiSearchListener(OnGetPoiSearchResultListener paramOnGetPoiSearchResultListener);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.poi.IPoiSearch
 * JD-Core Version:    0.7.0.1
 */