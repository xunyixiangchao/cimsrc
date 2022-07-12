package com.baidu.mapapi.search.route;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.a;
import com.baidu.platform.core.route.IRoutePlanSearch;
import com.baidu.platform.core.route.i;

public class RoutePlanSearch
  extends a
{
  private IRoutePlanSearch a = new i();
  private boolean b = false;
  
  public static RoutePlanSearch newInstance()
  {
    BMapManager.init();
    return new RoutePlanSearch();
  }
  
  public boolean bikingSearch(BikingRoutePlanOption paramBikingRoutePlanOption)
  {
    if (this.a != null)
    {
      if ((paramBikingRoutePlanOption != null) && (paramBikingRoutePlanOption.mTo != null))
      {
        PlanNode localPlanNode = paramBikingRoutePlanOption.mFrom;
        if (localPlanNode != null)
        {
          if ((localPlanNode.getLocation() == null) && ((paramBikingRoutePlanOption.mFrom.getName() == null) || (paramBikingRoutePlanOption.mFrom.getName() == ""))) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option , origin is illegal");
          }
          if ((paramBikingRoutePlanOption.mTo.getLocation() == null) && ((paramBikingRoutePlanOption.mTo.getName() == null) || (paramBikingRoutePlanOption.mTo.getName() == ""))) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option , destination is illegal");
          }
          return this.a.bikingSearch(paramBikingRoutePlanOption);
        }
      }
      throw new IllegalArgumentException("BDMapSDKException: route plan option , origin or destination can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
  }
  
  public void destroy()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.a.destroy();
    BMapManager.destroy();
  }
  
  public boolean drivingSearch(DrivingRoutePlanOption paramDrivingRoutePlanOption)
  {
    IRoutePlanSearch localIRoutePlanSearch = this.a;
    if (localIRoutePlanSearch != null)
    {
      if ((paramDrivingRoutePlanOption != null) && (paramDrivingRoutePlanOption.mTo != null) && (paramDrivingRoutePlanOption.mFrom != null)) {
        return localIRoutePlanSearch.drivingSearch(paramDrivingRoutePlanOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: route plan option , origin or destination can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
  }
  
  public boolean masstransitSearch(MassTransitRoutePlanOption paramMassTransitRoutePlanOption)
  {
    if (this.a != null)
    {
      if ((paramMassTransitRoutePlanOption != null) && (paramMassTransitRoutePlanOption.mTo != null))
      {
        PlanNode localPlanNode = paramMassTransitRoutePlanOption.mFrom;
        if (localPlanNode != null)
        {
          if ((localPlanNode.getLocation() == null) && ((paramMassTransitRoutePlanOption.mFrom.getName() == null) || (paramMassTransitRoutePlanOption.mFrom.getCity() == null))) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option,origin is illegal");
          }
          if ((paramMassTransitRoutePlanOption.mTo.getLocation() == null) && ((paramMassTransitRoutePlanOption.mTo.getName() == null) || (paramMassTransitRoutePlanOption.mTo.getCity() == null))) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option,destination is illegal");
          }
          return this.a.masstransitSearch(paramMassTransitRoutePlanOption);
        }
      }
      throw new IllegalArgumentException("BDMapSDKException: route plan option,origin or destination can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
  }
  
  public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener paramOnGetRoutePlanResultListener)
  {
    IRoutePlanSearch localIRoutePlanSearch = this.a;
    if (localIRoutePlanSearch != null)
    {
      if (paramOnGetRoutePlanResultListener != null)
      {
        localIRoutePlanSearch.setOnGetRoutePlanResultListener(paramOnGetRoutePlanResultListener);
        return;
      }
      throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
  }
  
  public boolean transitSearch(TransitRoutePlanOption paramTransitRoutePlanOption)
  {
    IRoutePlanSearch localIRoutePlanSearch = this.a;
    if (localIRoutePlanSearch != null)
    {
      if ((paramTransitRoutePlanOption != null) && (paramTransitRoutePlanOption.mCityName != null) && (paramTransitRoutePlanOption.mTo != null) && (paramTransitRoutePlanOption.mFrom != null)) {
        return localIRoutePlanSearch.transitSearch(paramTransitRoutePlanOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: route plan option,origin or destination or city can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
  }
  
  public boolean walkingIndoorSearch(IndoorRoutePlanOption paramIndoorRoutePlanOption)
  {
    IRoutePlanSearch localIRoutePlanSearch = this.a;
    if (localIRoutePlanSearch != null)
    {
      if ((paramIndoorRoutePlanOption != null) && (paramIndoorRoutePlanOption.mTo != null) && (paramIndoorRoutePlanOption.mFrom != null)) {
        return localIRoutePlanSearch.walkingIndoorSearch(paramIndoorRoutePlanOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option , origin or destination can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
  }
  
  public boolean walkingSearch(WalkingRoutePlanOption paramWalkingRoutePlanOption)
  {
    IRoutePlanSearch localIRoutePlanSearch = this.a;
    if (localIRoutePlanSearch != null)
    {
      if ((paramWalkingRoutePlanOption != null) && (paramWalkingRoutePlanOption.mTo != null) && (paramWalkingRoutePlanOption.mFrom != null)) {
        return localIRoutePlanSearch.walkingSearch(paramWalkingRoutePlanOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option , origin or destination can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.RoutePlanSearch
 * JD-Core Version:    0.7.0.1
 */