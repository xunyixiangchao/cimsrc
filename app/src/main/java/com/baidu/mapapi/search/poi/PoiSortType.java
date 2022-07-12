package com.baidu.mapapi.search.poi;

public enum PoiSortType
{
  static
  {
    PoiSortType localPoiSortType1 = new PoiSortType("comprehensive", 0);
    comprehensive = localPoiSortType1;
    PoiSortType localPoiSortType2 = new PoiSortType("distance_from_near_to_far", 1);
    distance_from_near_to_far = localPoiSortType2;
    a = new PoiSortType[] { localPoiSortType1, localPoiSortType2 };
  }
  
  private PoiSortType() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiSortType
 * JD-Core Version:    0.7.0.1
 */