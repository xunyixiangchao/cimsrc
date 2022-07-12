package com.baidu.platform.core.route;

import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;

public abstract interface IRoutePlanSearch
{
  public abstract boolean bikingSearch(BikingRoutePlanOption paramBikingRoutePlanOption);
  
  public abstract void destroy();
  
  public abstract boolean drivingSearch(DrivingRoutePlanOption paramDrivingRoutePlanOption);
  
  public abstract boolean masstransitSearch(MassTransitRoutePlanOption paramMassTransitRoutePlanOption);
  
  public abstract void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener paramOnGetRoutePlanResultListener);
  
  public abstract boolean transitSearch(TransitRoutePlanOption paramTransitRoutePlanOption);
  
  public abstract boolean walkingIndoorSearch(IndoorRoutePlanOption paramIndoorRoutePlanOption);
  
  public abstract boolean walkingSearch(WalkingRoutePlanOption paramWalkingRoutePlanOption);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.IRoutePlanSearch
 * JD-Core Version:    0.7.0.1
 */