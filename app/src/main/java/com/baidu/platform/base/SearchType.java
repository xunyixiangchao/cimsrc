package com.baidu.platform.base;

public enum SearchType
{
  static
  {
    SearchType localSearchType1 = new SearchType("POI_NEAR_BY_SEARCH", 0);
    a = localSearchType1;
    SearchType localSearchType2 = new SearchType("POI_IN_CITY_SEARCH", 1);
    b = localSearchType2;
    SearchType localSearchType3 = new SearchType("POI_IN_BOUND_SEARCH", 2);
    c = localSearchType3;
    SearchType localSearchType4 = new SearchType("POI_DETAIL_SEARCH", 3);
    d = localSearchType4;
    SearchType localSearchType5 = new SearchType("INDOOR_POI_SEARCH", 4);
    e = localSearchType5;
    SearchType localSearchType6 = new SearchType("SUGGESTION_SEARCH_TYPE", 5);
    f = localSearchType6;
    SearchType localSearchType7 = new SearchType("GEO_CODER", 6);
    g = localSearchType7;
    SearchType localSearchType8 = new SearchType("REVERSE_GEO_CODER", 7);
    h = localSearchType8;
    SearchType localSearchType9 = new SearchType("MASS_TRANSIT_ROUTE", 8);
    i = localSearchType9;
    SearchType localSearchType10 = new SearchType("TRANSIT_ROUTE", 9);
    j = localSearchType10;
    SearchType localSearchType11 = new SearchType("DRIVE_ROUTE", 10);
    k = localSearchType11;
    SearchType localSearchType12 = new SearchType("BIKE_ROUTE", 11);
    l = localSearchType12;
    SearchType localSearchType13 = new SearchType("WALK_ROUTE", 12);
    m = localSearchType13;
    SearchType localSearchType14 = new SearchType("INDOOR_ROUTE", 13);
    n = localSearchType14;
    SearchType localSearchType15 = new SearchType("BUS_LINE_DETAIL", 14);
    o = localSearchType15;
    SearchType localSearchType16 = new SearchType("DISTRICT_SEARCH", 15);
    p = localSearchType16;
    SearchType localSearchType17 = new SearchType("POI_DETAIL_SHARE", 16);
    q = localSearchType17;
    SearchType localSearchType18 = new SearchType("LOCATION_SEARCH_SHARE", 17);
    r = localSearchType18;
    SearchType localSearchType19 = new SearchType("ROUTE_PLAN_SHARE", 18);
    s = localSearchType19;
    SearchType localSearchType20 = new SearchType("WEATHER_SEARCH", 19);
    t = localSearchType20;
    SearchType localSearchType21 = new SearchType("RECOMMEND_STOP", 20);
    u = localSearchType21;
    SearchType localSearchType22 = new SearchType("BUILDING_SEARCH", 21);
    v = localSearchType22;
    w = new SearchType[] { localSearchType1, localSearchType2, localSearchType3, localSearchType4, localSearchType5, localSearchType6, localSearchType7, localSearchType8, localSearchType9, localSearchType10, localSearchType11, localSearchType12, localSearchType13, localSearchType14, localSearchType15, localSearchType16, localSearchType17, localSearchType18, localSearchType19, localSearchType20, localSearchType21, localSearchType22 };
  }
  
  private SearchType() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.base.SearchType
 * JD-Core Version:    0.7.0.1
 */