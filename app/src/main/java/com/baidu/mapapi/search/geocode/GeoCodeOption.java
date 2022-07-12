package com.baidu.mapapi.search.geocode;

public class GeoCodeOption
{
  public String mAddress = null;
  public String mCity = null;
  
  public GeoCodeOption address(String paramString)
  {
    this.mAddress = paramString;
    return this;
  }
  
  public GeoCodeOption city(String paramString)
  {
    this.mCity = paramString;
    return this;
  }
  
  public String getAddress()
  {
    return this.mAddress;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.geocode.GeoCodeOption
 * JD-Core Version:    0.7.0.1
 */