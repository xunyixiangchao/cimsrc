package com.baidu.mapapi.search.recommendstop;

import com.baidu.mapapi.model.LatLng;

public class RecommendStopSearchOption
{
  public LatLng mLocation;
  
  public LatLng getLocation()
  {
    return this.mLocation;
  }
  
  public RecommendStopSearchOption location(LatLng paramLatLng)
  {
    this.mLocation = paramLatLng;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption
 * JD-Core Version:    0.7.0.1
 */