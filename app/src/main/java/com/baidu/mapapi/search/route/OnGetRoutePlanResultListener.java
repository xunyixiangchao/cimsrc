package com.baidu.mapapi.search.route;

public abstract interface OnGetRoutePlanResultListener
{
  public abstract void onGetBikingRouteResult(BikingRouteResult paramBikingRouteResult);
  
  public abstract void onGetDrivingRouteResult(DrivingRouteResult paramDrivingRouteResult);
  
  public abstract void onGetIndoorRouteResult(IndoorRouteResult paramIndoorRouteResult);
  
  public abstract void onGetMassTransitRouteResult(MassTransitRouteResult paramMassTransitRouteResult);
  
  public abstract void onGetTransitRouteResult(TransitRouteResult paramTransitRouteResult);
  
  public abstract void onGetWalkingRouteResult(WalkingRouteResult paramWalkingRouteResult);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
 * JD-Core Version:    0.7.0.1
 */