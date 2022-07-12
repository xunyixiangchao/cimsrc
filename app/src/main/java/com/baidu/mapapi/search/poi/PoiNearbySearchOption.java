package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;

public class PoiNearbySearchOption
{
  public String mKeyword = null;
  public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;
  public LatLng mLocation = null;
  public int mPageCapacity = 10;
  public int mPageNum = 0;
  public PoiFilter mPoiFilter = null;
  public int mRadius = -1;
  public boolean mRadiusLimit = false;
  public int mScope = 1;
  public String mTag = "";
  public PoiSortType sortType = PoiSortType.comprehensive;
  
  public PoiNearbySearchOption keyword(String paramString)
  {
    this.mKeyword = paramString;
    return this;
  }
  
  public PoiNearbySearchOption language(LanguageType paramLanguageType)
  {
    this.mLanguageType = paramLanguageType;
    return this;
  }
  
  public PoiNearbySearchOption location(LatLng paramLatLng)
  {
    this.mLocation = paramLatLng;
    return this;
  }
  
  public PoiNearbySearchOption pageCapacity(int paramInt)
  {
    this.mPageCapacity = paramInt;
    return this;
  }
  
  public PoiNearbySearchOption pageNum(int paramInt)
  {
    this.mPageNum = paramInt;
    return this;
  }
  
  public PoiNearbySearchOption poiFilter(PoiFilter paramPoiFilter)
  {
    this.mPoiFilter = paramPoiFilter;
    return this;
  }
  
  public PoiNearbySearchOption radius(int paramInt)
  {
    this.mRadius = paramInt;
    return this;
  }
  
  public PoiNearbySearchOption radiusLimit(boolean paramBoolean)
  {
    this.mRadiusLimit = paramBoolean;
    return this;
  }
  
  public PoiNearbySearchOption scope(int paramInt)
  {
    this.mScope = paramInt;
    return this;
  }
  
  public PoiNearbySearchOption sortType(PoiSortType paramPoiSortType)
  {
    if (paramPoiSortType != null) {
      this.sortType = paramPoiSortType;
    }
    return this;
  }
  
  public PoiNearbySearchOption tag(String paramString)
  {
    this.mTag = paramString;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiNearbySearchOption
 * JD-Core Version:    0.7.0.1
 */