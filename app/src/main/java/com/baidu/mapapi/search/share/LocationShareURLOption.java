package com.baidu.mapapi.search.share;

import com.baidu.mapapi.model.LatLng;

public class LocationShareURLOption
{
  public LatLng mLocation = null;
  public String mName = null;
  public String mSnippet = null;
  
  public LocationShareURLOption location(LatLng paramLatLng)
  {
    this.mLocation = paramLatLng;
    return this;
  }
  
  public LocationShareURLOption name(String paramString)
  {
    this.mName = paramString;
    return this;
  }
  
  public LocationShareURLOption snippet(String paramString)
  {
    this.mSnippet = paramString;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.share.LocationShareURLOption
 * JD-Core Version:    0.7.0.1
 */