package com.baidu.mapapi.search.poi;

public class PoiIndoorOption
{
  public String bid;
  public int currentPage = 0;
  public String floor;
  public int pageSize = 10;
  public String wd;
  
  public PoiIndoorOption poiCurrentPage(int paramInt)
  {
    this.currentPage = paramInt;
    return this;
  }
  
  public PoiIndoorOption poiFloor(String paramString)
  {
    this.floor = paramString;
    return this;
  }
  
  public PoiIndoorOption poiIndoorBid(String paramString)
  {
    this.bid = paramString;
    return this;
  }
  
  public PoiIndoorOption poiIndoorWd(String paramString)
  {
    this.wd = paramString;
    return this;
  }
  
  public PoiIndoorOption poiPageSize(int paramInt)
  {
    this.pageSize = paramInt;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiIndoorOption
 * JD-Core Version:    0.7.0.1
 */