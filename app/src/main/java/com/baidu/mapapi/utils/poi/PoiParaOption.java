package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;

public class PoiParaOption
{
  String a;
  String b;
  LatLng c;
  int d;
  
  public PoiParaOption center(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.c;
  }
  
  public String getKey()
  {
    return this.b;
  }
  
  public int getRadius()
  {
    return this.d;
  }
  
  public String getUid()
  {
    return this.a;
  }
  
  public PoiParaOption key(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public PoiParaOption radius(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public PoiParaOption uid(String paramString)
  {
    this.a = paramString;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.utils.poi.PoiParaOption
 * JD-Core Version:    0.7.0.1
 */