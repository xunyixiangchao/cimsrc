package com.baidu.platform.core.route;

import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption.DrivingPolicy;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption.DrivingTrafficPolicy;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.platform.util.a;
import java.util.List;

public class d
  extends com.baidu.platform.base.c
{
  d(DrivingRoutePlanOption paramDrivingRoutePlanOption)
  {
    a(paramDrivingRoutePlanOption);
  }
  
  private void a(DrivingRoutePlanOption paramDrivingRoutePlanOption)
  {
    this.c.a("qt", "cars");
    Object localObject1 = this.c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramDrivingRoutePlanOption.mPolicy.getInt());
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("sy", ((StringBuilder)localObject2).toString());
    this.c.a("ie", "utf-8");
    this.c.a("lrn", "20");
    this.c.a("version", "6");
    this.c.a("extinfo", "32");
    this.c.a("mrs", "1");
    this.c.a("rp_format", "json");
    this.c.a("rp_filter", "mobile");
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramDrivingRoutePlanOption.mtrafficPolicy.getInt());
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("route_traffic", ((StringBuilder)localObject2).toString());
    this.c.a("sn", a(paramDrivingRoutePlanOption.mFrom));
    this.c.a("en", a(paramDrivingRoutePlanOption.mTo));
    localObject1 = paramDrivingRoutePlanOption.mCityName;
    if (localObject1 != null) {
      this.c.a("c", (String)localObject1);
    }
    localObject1 = paramDrivingRoutePlanOption.mFrom;
    if (localObject1 != null) {
      this.c.a("sc", ((PlanNode)localObject1).getCity());
    }
    localObject1 = paramDrivingRoutePlanOption.mTo;
    if (localObject1 != null) {
      this.c.a("ec", ((PlanNode)localObject1).getCity());
    }
    List localList = paramDrivingRoutePlanOption.mWayPoints;
    localObject1 = new String();
    paramDrivingRoutePlanOption = new String();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        Object localObject3 = (PlanNode)localList.get(i);
        if (localObject3 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(a((PlanNode)localObject3));
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramDrivingRoutePlanOption);
          ((StringBuilder)localObject1).append(((PlanNode)localObject3).getCity());
          localObject3 = ((StringBuilder)localObject1).toString();
          localObject1 = localObject2;
          paramDrivingRoutePlanOption = (DrivingRoutePlanOption)localObject3;
          if (i != localList.size() - 1)
          {
            paramDrivingRoutePlanOption = new StringBuilder();
            paramDrivingRoutePlanOption.append((String)localObject2);
            paramDrivingRoutePlanOption.append("|");
            localObject1 = paramDrivingRoutePlanOption.toString();
            paramDrivingRoutePlanOption = new StringBuilder();
            paramDrivingRoutePlanOption.append((String)localObject3);
            paramDrivingRoutePlanOption.append("|");
            paramDrivingRoutePlanOption = paramDrivingRoutePlanOption.toString();
          }
        }
        i += 1;
      }
      this.c.a("wp", (String)localObject1);
      this.c.a("wpc", paramDrivingRoutePlanOption);
    }
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.d
 * JD-Core Version:    0.7.0.1
 */