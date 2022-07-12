package com.baidu.mapapi.search.route;

public class WalkingRoutePlanOption
{
  public PlanNode mFrom = null;
  public PlanNode mTo = null;
  
  public WalkingRoutePlanOption from(PlanNode paramPlanNode)
  {
    this.mFrom = paramPlanNode;
    return this;
  }
  
  public WalkingRoutePlanOption to(PlanNode paramPlanNode)
  {
    this.mTo = paramPlanNode;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.WalkingRoutePlanOption
 * JD-Core Version:    0.7.0.1
 */