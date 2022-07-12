package com.baidu.mapapi.search.share;

import com.baidu.mapapi.search.route.PlanNode;

public class RouteShareURLOption
{
  public int mCityCode = -1;
  public PlanNode mFrom = null;
  public RouteShareMode mMode;
  public int mPn = 0;
  public PlanNode mTo = null;
  
  public RouteShareURLOption cityCode(int paramInt)
  {
    this.mCityCode = paramInt;
    return this;
  }
  
  public RouteShareURLOption from(PlanNode paramPlanNode)
  {
    this.mFrom = paramPlanNode;
    return this;
  }
  
  public RouteShareMode getmMode()
  {
    return this.mMode;
  }
  
  public RouteShareURLOption pn(int paramInt)
  {
    this.mPn = paramInt;
    return this;
  }
  
  public RouteShareURLOption routMode(RouteShareMode paramRouteShareMode)
  {
    this.mMode = paramRouteShareMode;
    return this;
  }
  
  public RouteShareURLOption to(PlanNode paramPlanNode)
  {
    this.mTo = paramPlanNode;
    return this;
  }
  
  public static enum RouteShareMode
  {
    private int a;
    
    static
    {
      RouteShareMode localRouteShareMode1 = new RouteShareMode("CAR_ROUTE_SHARE_MODE", 0, 0);
      CAR_ROUTE_SHARE_MODE = localRouteShareMode1;
      RouteShareMode localRouteShareMode2 = new RouteShareMode("FOOT_ROUTE_SHARE_MODE", 1, 1);
      FOOT_ROUTE_SHARE_MODE = localRouteShareMode2;
      RouteShareMode localRouteShareMode3 = new RouteShareMode("CYCLE_ROUTE_SHARE_MODE", 2, 2);
      CYCLE_ROUTE_SHARE_MODE = localRouteShareMode3;
      RouteShareMode localRouteShareMode4 = new RouteShareMode("BUS_ROUTE_SHARE_MODE", 3, 3);
      BUS_ROUTE_SHARE_MODE = localRouteShareMode4;
      b = new RouteShareMode[] { localRouteShareMode1, localRouteShareMode2, localRouteShareMode3, localRouteShareMode4 };
    }
    
    private RouteShareMode(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getRouteShareMode()
    {
      return this.a;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.share.RouteShareURLOption
 * JD-Core Version:    0.7.0.1
 */