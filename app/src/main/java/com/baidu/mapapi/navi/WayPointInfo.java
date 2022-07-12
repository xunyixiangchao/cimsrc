package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;

public class WayPointInfo
{
  private String a;
  private LatLng b;
  
  public LatLng getLatLng()
  {
    return this.b;
  }
  
  public String getWayPointName()
  {
    return this.a;
  }
  
  public WayPointInfo setLatLng(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.b = paramLatLng;
      return this;
    }
    throw new IllegalStateException("BDMapSDKException: The latitude and longitude of the waypoint cannot be null");
  }
  
  public WayPointInfo setWayPointName(String paramString)
  {
    this.a = paramString;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.navi.WayPointInfo
 * JD-Core Version:    0.7.0.1
 */