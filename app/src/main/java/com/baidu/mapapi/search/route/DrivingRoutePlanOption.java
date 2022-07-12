package com.baidu.mapapi.search.route;

import java.util.List;

public class DrivingRoutePlanOption
{
  public String mCityName;
  public PlanNode mFrom = null;
  public DrivingPolicy mPolicy = DrivingPolicy.ECAR_TIME_FIRST;
  public PlanNode mTo = null;
  public List<PlanNode> mWayPoints = null;
  public DrivingTrafficPolicy mtrafficPolicy = DrivingTrafficPolicy.ROUTE_PATH;
  
  public DrivingRoutePlanOption currentCity(String paramString)
  {
    this.mCityName = paramString;
    return this;
  }
  
  public DrivingRoutePlanOption from(PlanNode paramPlanNode)
  {
    this.mFrom = paramPlanNode;
    return this;
  }
  
  public DrivingRoutePlanOption passBy(List<PlanNode> paramList)
  {
    this.mWayPoints = paramList;
    return this;
  }
  
  public DrivingRoutePlanOption policy(DrivingPolicy paramDrivingPolicy)
  {
    this.mPolicy = paramDrivingPolicy;
    return this;
  }
  
  public DrivingRoutePlanOption to(PlanNode paramPlanNode)
  {
    this.mTo = paramPlanNode;
    return this;
  }
  
  public DrivingRoutePlanOption trafficPolicy(DrivingTrafficPolicy paramDrivingTrafficPolicy)
  {
    this.mtrafficPolicy = paramDrivingTrafficPolicy;
    return this;
  }
  
  public static enum DrivingPolicy
  {
    private int a;
    
    static
    {
      DrivingPolicy localDrivingPolicy1 = new DrivingPolicy("ECAR_AVOID_JAM", 0, 3);
      ECAR_AVOID_JAM = localDrivingPolicy1;
      DrivingPolicy localDrivingPolicy2 = new DrivingPolicy("ECAR_TIME_FIRST", 1, 0);
      ECAR_TIME_FIRST = localDrivingPolicy2;
      DrivingPolicy localDrivingPolicy3 = new DrivingPolicy("ECAR_DIS_FIRST", 2, 1);
      ECAR_DIS_FIRST = localDrivingPolicy3;
      DrivingPolicy localDrivingPolicy4 = new DrivingPolicy("ECAR_FEE_FIRST", 3, 2);
      ECAR_FEE_FIRST = localDrivingPolicy4;
      b = new DrivingPolicy[] { localDrivingPolicy1, localDrivingPolicy2, localDrivingPolicy3, localDrivingPolicy4 };
    }
    
    private DrivingPolicy(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getInt()
    {
      return this.a;
    }
  }
  
  public static enum DrivingTrafficPolicy
  {
    private int a;
    
    static
    {
      DrivingTrafficPolicy localDrivingTrafficPolicy1 = new DrivingTrafficPolicy("ROUTE_PATH", 0, 0);
      ROUTE_PATH = localDrivingTrafficPolicy1;
      DrivingTrafficPolicy localDrivingTrafficPolicy2 = new DrivingTrafficPolicy("ROUTE_PATH_AND_TRAFFIC", 1, 1);
      ROUTE_PATH_AND_TRAFFIC = localDrivingTrafficPolicy2;
      b = new DrivingTrafficPolicy[] { localDrivingTrafficPolicy1, localDrivingTrafficPolicy2 };
    }
    
    private DrivingTrafficPolicy(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getInt()
    {
      return this.a;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.DrivingRoutePlanOption
 * JD-Core Version:    0.7.0.1
 */