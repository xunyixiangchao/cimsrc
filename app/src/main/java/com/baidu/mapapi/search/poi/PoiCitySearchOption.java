package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.search.base.LanguageType;

public class PoiCitySearchOption
{
  public String mCity = null;
  public boolean mIsCityLimit = true;
  public boolean mIsReturnAddr = true;
  public String mKeyword = null;
  public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;
  public int mPageCapacity = 10;
  public int mPageNum = 0;
  public PoiFilter mPoiFilter = null;
  public int mScope = 1;
  public String mTag = "";
  
  public PoiCitySearchOption city(String paramString)
  {
    this.mCity = paramString;
    return this;
  }
  
  public PoiCitySearchOption cityLimit(boolean paramBoolean)
  {
    this.mIsCityLimit = paramBoolean;
    return this;
  }
  
  public PoiCitySearchOption isReturnAddr(boolean paramBoolean)
  {
    this.mIsReturnAddr = paramBoolean;
    return this;
  }
  
  public PoiCitySearchOption keyword(String paramString)
  {
    this.mKeyword = paramString;
    return this;
  }
  
  public PoiCitySearchOption language(LanguageType paramLanguageType)
  {
    this.mLanguageType = paramLanguageType;
    return this;
  }
  
  public PoiCitySearchOption pageCapacity(int paramInt)
  {
    this.mPageCapacity = paramInt;
    return this;
  }
  
  public PoiCitySearchOption pageNum(int paramInt)
  {
    this.mPageNum = paramInt;
    return this;
  }
  
  public PoiCitySearchOption poiFilter(PoiFilter paramPoiFilter)
  {
    this.mPoiFilter = paramPoiFilter;
    return this;
  }
  
  public PoiCitySearchOption scope(int paramInt)
  {
    this.mScope = paramInt;
    return this;
  }
  
  public PoiCitySearchOption tag(String paramString)
  {
    this.mTag = paramString;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiCitySearchOption
 * JD-Core Version:    0.7.0.1
 */