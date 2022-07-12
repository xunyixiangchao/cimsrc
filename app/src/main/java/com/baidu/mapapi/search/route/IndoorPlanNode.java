package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;

public class IndoorPlanNode
{
  private LatLng a;
  private String b;
  
  public IndoorPlanNode(LatLng paramLatLng, String paramString)
  {
    this.a = paramLatLng;
    this.b = paramString;
  }
  
  public String getFloor()
  {
    return this.b;
  }
  
  public LatLng getLocation()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.IndoorPlanNode
 * JD-Core Version:    0.7.0.1
 */