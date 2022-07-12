package com.baidu.mapapi.search.route;

public class BikingRoutePlanOption
{
  public PlanNode mFrom = null;
  public int mRidingType = 0;
  public PlanNode mTo = null;
  
  public BikingRoutePlanOption from(PlanNode paramPlanNode)
  {
    this.mFrom = paramPlanNode;
    return this;
  }
  
  public BikingRoutePlanOption ridingType(int paramInt)
  {
    this.mRidingType = paramInt;
    return this;
  }
  
  public BikingRoutePlanOption to(PlanNode paramPlanNode)
  {
    this.mTo = paramPlanNode;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.BikingRoutePlanOption
 * JD-Core Version:    0.7.0.1
 */