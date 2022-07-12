package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;

public class ReverseGeoCodeOption
{
  private int a = 10;
  private int b = 0;
  private LatLng c = null;
  private int d = 1;
  private int e = 1000;
  private String f = null;
  private boolean g = false;
  private LanguageType h = LanguageType.LanguageTypeChinese;
  
  public ReverseGeoCodeOption extensionsRoad(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public boolean getExtensionsRoad()
  {
    return this.g;
  }
  
  public LanguageType getLanguage()
  {
    return this.h;
  }
  
  public int getLatestAdmin()
  {
    return this.d;
  }
  
  public LatLng getLocation()
  {
    return this.c;
  }
  
  public int getPageNum()
  {
    return this.b;
  }
  
  public int getPageSize()
  {
    return this.a;
  }
  
  public String getPoiType()
  {
    return this.f;
  }
  
  public int getRadius()
  {
    return this.e;
  }
  
  public ReverseGeoCodeOption language(LanguageType paramLanguageType)
  {
    this.h = paramLanguageType;
    return this;
  }
  
  public ReverseGeoCodeOption location(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
  
  public ReverseGeoCodeOption newVersion(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public ReverseGeoCodeOption pageNum(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.b = i;
    return this;
  }
  
  public ReverseGeoCodeOption pageSize(int paramInt)
  {
    int i;
    if (paramInt <= 0) {
      i = 10;
    }
    do
    {
      this.a = i;
      return this;
      i = paramInt;
    } while (paramInt <= 100);
    this.a = 100;
    return this;
  }
  
  public ReverseGeoCodeOption poiType(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public ReverseGeoCodeOption radius(int paramInt)
  {
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    do
    {
      this.e = i;
      return this;
      i = paramInt;
    } while (paramInt <= 1000);
    this.e = 1000;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.geocode.ReverseGeoCodeOption
 * JD-Core Version:    0.7.0.1
 */