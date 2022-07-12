package com.baidu.platform.core.route;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption.TacticsIncity;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption.TacticsIntercity;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption.TransTypeIntercity;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.util.a;

public class h
  extends com.baidu.platform.base.c
{
  public h(MassTransitRoutePlanOption paramMassTransitRoutePlanOption)
  {
    a(paramMassTransitRoutePlanOption);
  }
  
  private void a(MassTransitRoutePlanOption paramMassTransitRoutePlanOption)
  {
    Object localObject2 = paramMassTransitRoutePlanOption.mFrom.getLocation();
    StringBuilder localStringBuilder;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
        localObject1 = CoordTrans.gcjToBaidu((LatLng)localObject2);
      }
      localObject2 = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((LatLng)localObject1).latitude);
      localStringBuilder.append(",");
      localStringBuilder.append(((LatLng)localObject1).longitude);
      ((a)localObject2).a("origin", localStringBuilder.toString());
    }
    else
    {
      this.c.a("origin", paramMassTransitRoutePlanOption.mFrom.getName());
    }
    if (paramMassTransitRoutePlanOption.mFrom.getCity() != null) {
      this.c.a("origin_region", paramMassTransitRoutePlanOption.mFrom.getCity());
    }
    localObject2 = paramMassTransitRoutePlanOption.mTo.getLocation();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
        localObject1 = CoordTrans.gcjToBaidu((LatLng)localObject2);
      }
      localObject2 = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((LatLng)localObject1).latitude);
      localStringBuilder.append(",");
      localStringBuilder.append(((LatLng)localObject1).longitude);
      ((a)localObject2).a("destination", localStringBuilder.toString());
    }
    else
    {
      this.c.a("destination", paramMassTransitRoutePlanOption.mTo.getName());
    }
    if (paramMassTransitRoutePlanOption.mTo.getCity() != null) {
      this.c.a("destination_region", paramMassTransitRoutePlanOption.mTo.getCity());
    }
    Object localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramMassTransitRoutePlanOption.mTacticsIncity.getInt());
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("tactics_incity", ((StringBuilder)localObject2).toString());
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramMassTransitRoutePlanOption.mTacticsIntercity.getInt());
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("tactics_intercity", ((StringBuilder)localObject2).toString());
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramMassTransitRoutePlanOption.mTransTypeIntercity.getInt());
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("trans_type_intercity", ((StringBuilder)localObject2).toString());
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramMassTransitRoutePlanOption.mPageIndex);
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("page_index", ((StringBuilder)localObject2).toString());
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramMassTransitRoutePlanOption.mPageSize);
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("page_size", ((StringBuilder)localObject2).toString());
    this.c.a("coord_type", paramMassTransitRoutePlanOption.mCoordType);
    this.c.a("output", "json");
    this.c.a("from", "android_map_sdk");
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.n();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.h
 * JD-Core Version:    0.7.0.1
 */