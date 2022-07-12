package com.baidu.mapapi.search.route;

public class IndoorRoutePlanOption
{
  public IndoorPlanNode mFrom = null;
  public IndoorPlanNode mTo = null;
  
  public IndoorRoutePlanOption from(IndoorPlanNode paramIndoorPlanNode)
  {
    this.mFrom = paramIndoorPlanNode;
    return this;
  }
  
  public IndoorRoutePlanOption to(IndoorPlanNode paramIndoorPlanNode)
  {
    this.mTo = paramIndoorPlanNode;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.IndoorRoutePlanOption
 * JD-Core Version:    0.7.0.1
 */