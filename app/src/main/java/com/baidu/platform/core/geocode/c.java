package com.baidu.platform.core.geocode;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.platform.util.a;

public class c
  extends com.baidu.platform.base.c
{
  public c(GeoCodeOption paramGeoCodeOption)
  {
    a(paramGeoCodeOption);
  }
  
  private void a(GeoCodeOption paramGeoCodeOption)
  {
    this.c.a("city", paramGeoCodeOption.mCity);
    this.c.a("address", paramGeoCodeOption.mAddress);
    this.c.a("output", "json");
    this.c.a("ret_coordtype", "bd09ll");
    this.c.a("from", "android_map_sdk");
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.m();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.geocode.c
 * JD-Core Version:    0.7.0.1
 */