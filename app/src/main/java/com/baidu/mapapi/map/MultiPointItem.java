package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;

public final class MultiPointItem
{
  private LatLng a;
  private String b;
  
  public MultiPointItem(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.a = paramLatLng;
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: MultiPointItem point can not be null");
  }
  
  public LatLng getPoint()
  {
    return this.a;
  }
  
  public String getTitle()
  {
    return this.b;
  }
  
  public void setTitle(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MultiPointItem
 * JD-Core Version:    0.7.0.1
 */