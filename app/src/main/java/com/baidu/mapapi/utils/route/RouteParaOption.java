package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;

public class RouteParaOption
{
  LatLng a;
  LatLng b;
  String c;
  String d;
  String e;
  EBusStrategyType f = EBusStrategyType.bus_recommend_way;
  
  public RouteParaOption busStrategyType(EBusStrategyType paramEBusStrategyType)
  {
    this.f = paramEBusStrategyType;
    return this;
  }
  
  public RouteParaOption cityName(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public RouteParaOption endName(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public RouteParaOption endPoint(LatLng paramLatLng)
  {
    this.b = paramLatLng;
    return this;
  }
  
  public EBusStrategyType getBusStrategyType()
  {
    return this.f;
  }
  
  public String getCityName()
  {
    return this.e;
  }
  
  public String getEndName()
  {
    return this.d;
  }
  
  public LatLng getEndPoint()
  {
    return this.b;
  }
  
  public String getStartName()
  {
    return this.c;
  }
  
  public LatLng getStartPoint()
  {
    return this.a;
  }
  
  public RouteParaOption startName(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public RouteParaOption startPoint(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
  
  public static enum EBusStrategyType
  {
    static
    {
      EBusStrategyType localEBusStrategyType1 = new EBusStrategyType("bus_time_first", 0);
      bus_time_first = localEBusStrategyType1;
      EBusStrategyType localEBusStrategyType2 = new EBusStrategyType("bus_transfer_little", 1);
      bus_transfer_little = localEBusStrategyType2;
      EBusStrategyType localEBusStrategyType3 = new EBusStrategyType("bus_walk_little", 2);
      bus_walk_little = localEBusStrategyType3;
      EBusStrategyType localEBusStrategyType4 = new EBusStrategyType("bus_no_subway", 3);
      bus_no_subway = localEBusStrategyType4;
      EBusStrategyType localEBusStrategyType5 = new EBusStrategyType("bus_recommend_way", 4);
      bus_recommend_way = localEBusStrategyType5;
      a = new EBusStrategyType[] { localEBusStrategyType1, localEBusStrategyType2, localEBusStrategyType3, localEBusStrategyType4, localEBusStrategyType5 };
    }
    
    private EBusStrategyType() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.utils.route.RouteParaOption
 * JD-Core Version:    0.7.0.1
 */