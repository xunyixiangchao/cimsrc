package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
import org.json.JSONArray;

public class TruckNaviOption
  extends NaviParaOption
{
  int g;
  double h;
  double i;
  double j;
  double k;
  double l;
  int m;
  boolean n;
  String o;
  int p;
  int q;
  int r;
  int s;
  int t;
  
  public TruckNaviOption endName(String paramString)
  {
    return (TruckNaviOption)super.endName(paramString);
  }
  
  public TruckNaviOption endPoint(LatLng paramLatLng)
  {
    return (TruckNaviOption)super.endPoint(paramLatLng);
  }
  
  public int getAxleCount()
  {
    return this.m;
  }
  
  public double getAxleWeight()
  {
    return this.l;
  }
  
  public int getDisplacement()
  {
    return this.q;
  }
  
  public int getEmissionLimit()
  {
    return this.s;
  }
  
  public String getEndName()
  {
    return super.getEndName();
  }
  
  public LatLng getEndPoint()
  {
    return super.getEndPoint();
  }
  
  public double getHeight()
  {
    return this.h;
  }
  
  public boolean getIsTrailer()
  {
    return this.n;
  }
  
  public double getLength()
  {
    return this.k;
  }
  
  public int getLoadWeight()
  {
    return this.t;
  }
  
  public String getNaviRoutePolicy()
  {
    return super.getNaviRoutePolicy();
  }
  
  public int getPlateColor()
  {
    return this.p;
  }
  
  public String getPlateNumber()
  {
    return this.o;
  }
  
  public int getPowerType()
  {
    return this.r;
  }
  
  public int getTruckType()
  {
    return this.g;
  }
  
  public JSONArray getWayPoint()
  {
    return super.getWayPoint();
  }
  
  public double getWeight()
  {
    return this.j;
  }
  
  public double getWidth()
  {
    return this.i;
  }
  
  public TruckNaviOption setAxleCount(int paramInt)
  {
    this.m = paramInt;
    return this;
  }
  
  public TruckNaviOption setAxleWeight(double paramDouble)
  {
    this.l = paramDouble;
    return this;
  }
  
  public TruckNaviOption setDisplacement(int paramInt)
  {
    this.q = paramInt;
    return this;
  }
  
  public TruckNaviOption setEmissionLimit(int paramInt)
  {
    this.s = paramInt;
    return this;
  }
  
  public TruckNaviOption setHeight(double paramDouble)
  {
    this.h = paramDouble;
    return this;
  }
  
  public TruckNaviOption setIsTrailer(boolean paramBoolean)
  {
    this.n = paramBoolean;
    return this;
  }
  
  public TruckNaviOption setLength(double paramDouble)
  {
    this.k = paramDouble;
    return this;
  }
  
  public TruckNaviOption setLoadWeight(int paramInt)
  {
    this.t = paramInt;
    return this;
  }
  
  public TruckNaviOption setNaviRoutePolicy(NaviParaOption.NaviRoutePolicy paramNaviRoutePolicy)
  {
    return (TruckNaviOption)super.setNaviRoutePolicy(paramNaviRoutePolicy);
  }
  
  public TruckNaviOption setPlateColor(int paramInt)
  {
    this.p = paramInt;
    return this;
  }
  
  public TruckNaviOption setPlateNumber(String paramString)
  {
    this.o = paramString;
    return this;
  }
  
  public TruckNaviOption setPowerType(int paramInt)
  {
    this.r = paramInt;
    return this;
  }
  
  public TruckNaviOption setTruckType(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public TruckNaviOption setWayPoint(WayPoint paramWayPoint)
  {
    return (TruckNaviOption)super.setWayPoint(paramWayPoint);
  }
  
  public TruckNaviOption setWeight(double paramDouble)
  {
    this.j = paramDouble;
    return this;
  }
  
  public TruckNaviOption setWidth(double paramDouble)
  {
    this.i = paramDouble;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.navi.TruckNaviOption
 * JD-Core Version:    0.7.0.1
 */