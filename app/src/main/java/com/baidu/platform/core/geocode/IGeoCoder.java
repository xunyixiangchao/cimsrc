package com.baidu.platform.core.geocode;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;

public abstract interface IGeoCoder
{
  public abstract void destroy();
  
  public abstract boolean geocode(GeoCodeOption paramGeoCodeOption);
  
  public abstract boolean reverseGeoCode(ReverseGeoCodeOption paramReverseGeoCodeOption);
  
  public abstract void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener paramOnGetGeoCoderResultListener);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.geocode.IGeoCoder
 * JD-Core Version:    0.7.0.1
 */