package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.model.LatLng;

public class SuggestionSearchOption
{
  public String mCity = null;
  public Boolean mCityLimit = Boolean.FALSE;
  public String mKeyword = null;
  public LatLng mLocation = null;
  
  public SuggestionSearchOption city(String paramString)
  {
    this.mCity = paramString;
    return this;
  }
  
  public SuggestionSearchOption citylimit(Boolean paramBoolean)
  {
    this.mCityLimit = paramBoolean;
    return this;
  }
  
  public SuggestionSearchOption keyword(String paramString)
  {
    this.mKeyword = paramString;
    return this;
  }
  
  public SuggestionSearchOption location(LatLng paramLatLng)
  {
    this.mLocation = paramLatLng;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.sug.SuggestionSearchOption
 * JD-Core Version:    0.7.0.1
 */