package com.baidu.platform.core.route;

import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.platform.util.a;

public class n
  extends com.baidu.platform.base.c
{
  public n(WalkingRoutePlanOption paramWalkingRoutePlanOption)
  {
    a(paramWalkingRoutePlanOption);
  }
  
  private void a(WalkingRoutePlanOption paramWalkingRoutePlanOption)
  {
    this.c.a("qt", "walk2");
    this.c.a("sn", a(paramWalkingRoutePlanOption.mFrom));
    this.c.a("en", a(paramWalkingRoutePlanOption.mTo));
    PlanNode localPlanNode = paramWalkingRoutePlanOption.mFrom;
    if (localPlanNode != null) {
      this.c.a("sc", localPlanNode.getCity());
    }
    paramWalkingRoutePlanOption = paramWalkingRoutePlanOption.mTo;
    if (paramWalkingRoutePlanOption != null) {
      this.c.a("ec", paramWalkingRoutePlanOption.getCity());
    }
    this.c.a("ie", "utf-8");
    this.c.a("lrn", "20");
    this.c.a("version", "3");
    this.c.a("rp_format", "json");
    this.c.a("rp_filter", "mobile");
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.i();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.n
 * JD-Core Version:    0.7.0.1
 */