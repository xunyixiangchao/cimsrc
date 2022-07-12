package com.baidu.platform.core.route;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.util.a;

public class b
  extends com.baidu.platform.base.c
{
  public b(BikingRoutePlanOption paramBikingRoutePlanOption)
  {
    a(paramBikingRoutePlanOption);
  }
  
  private void a(BikingRoutePlanOption paramBikingRoutePlanOption)
  {
    this.c.a("mode", "riding");
    Object localObject2 = paramBikingRoutePlanOption.mFrom.getLocation();
    Object localObject1;
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
      this.c.a("origin", paramBikingRoutePlanOption.mFrom.getName());
    }
    localObject2 = paramBikingRoutePlanOption.mTo.getLocation();
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
      this.c.a("destination", paramBikingRoutePlanOption.mTo.getName());
    }
    this.c.a("origin_region", paramBikingRoutePlanOption.mFrom.getCity());
    this.c.a("destination_region", paramBikingRoutePlanOption.mTo.getCity());
    int i = paramBikingRoutePlanOption.mRidingType;
    if (i == 1) {
      this.c.a("riding_type", String.valueOf(i));
    }
    this.c.a("output", "json");
    this.c.a("from", "android_map_sdk");
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.b
 * JD-Core Version:    0.7.0.1
 */