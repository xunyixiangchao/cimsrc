package com.baidu.mapapi.search.poi;

public abstract interface OnGetPoiSearchResultListener
{
  public abstract void onGetPoiDetailResult(PoiDetailResult paramPoiDetailResult);
  
  public abstract void onGetPoiDetailResult(PoiDetailSearchResult paramPoiDetailSearchResult);
  
  public abstract void onGetPoiIndoorResult(PoiIndoorResult paramPoiIndoorResult);
  
  public abstract void onGetPoiResult(PoiResult paramPoiResult);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
 * JD-Core Version:    0.7.0.1
 */