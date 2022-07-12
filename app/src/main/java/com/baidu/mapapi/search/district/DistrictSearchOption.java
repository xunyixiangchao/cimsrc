package com.baidu.mapapi.search.district;

public class DistrictSearchOption
{
  public String mCityName;
  public String mDistrictName;
  
  public DistrictSearchOption cityName(String paramString)
  {
    this.mCityName = paramString;
    return this;
  }
  
  public DistrictSearchOption districtName(String paramString)
  {
    this.mDistrictName = paramString;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.district.DistrictSearchOption
 * JD-Core Version:    0.7.0.1
 */