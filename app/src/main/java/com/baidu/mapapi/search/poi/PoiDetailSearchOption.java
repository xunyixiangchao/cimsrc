package com.baidu.mapapi.search.poi;

public class PoiDetailSearchOption
{
  private String a = "";
  private String b = "";
  private boolean c = false;
  
  public String getUid()
  {
    return this.a;
  }
  
  public String getUids()
  {
    return this.b;
  }
  
  public boolean isSearchByUids()
  {
    return this.c;
  }
  
  public PoiDetailSearchOption poiUid(String paramString)
  {
    this.c = false;
    this.a = paramString;
    return this;
  }
  
  public PoiDetailSearchOption poiUids(String paramString)
  {
    this.c = true;
    this.b = paramString;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiDetailSearchOption
 * JD-Core Version:    0.7.0.1
 */