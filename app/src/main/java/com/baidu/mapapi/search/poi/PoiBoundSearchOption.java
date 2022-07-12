package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.base.LanguageType;

public class PoiBoundSearchOption
{
  public LatLngBounds mBound = null;
  public String mKeyword = null;
  public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;
  public int mPageCapacity = 10;
  public int mPageNum = 0;
  public PoiFilter mPoiFilter = null;
  public int mScope = 1;
  public String mTag = "";
  
  public PoiBoundSearchOption bound(LatLngBounds paramLatLngBounds)
  {
    this.mBound = paramLatLngBounds;
    return this;
  }
  
  public PoiBoundSearchOption keyword(String paramString)
  {
    this.mKeyword = paramString;
    return this;
  }
  
  public PoiBoundSearchOption language(LanguageType paramLanguageType)
  {
    this.mLanguageType = paramLanguageType;
    return this;
  }
  
  public PoiBoundSearchOption pageCapacity(int paramInt)
  {
    this.mPageCapacity = paramInt;
    return this;
  }
  
  public PoiBoundSearchOption pageNum(int paramInt)
  {
    this.mPageNum = paramInt;
    return this;
  }
  
  public PoiBoundSearchOption poiFilter(PoiFilter paramPoiFilter)
  {
    this.mPoiFilter = paramPoiFilter;
    return this;
  }
  
  public PoiBoundSearchOption scope(int paramInt)
  {
    this.mScope = paramInt;
    return this;
  }
  
  public PoiBoundSearchOption tag(String paramString)
  {
    this.mTag = paramString;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiBoundSearchOption
 * JD-Core Version:    0.7.0.1
 */