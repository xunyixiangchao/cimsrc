package com.baidu.platform.core.building;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.building.BuildingSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.util.a;

public class c
  extends com.baidu.platform.base.c
{
  public c(BuildingSearchOption paramBuildingSearchOption)
  {
    a(paramBuildingSearchOption);
  }
  
  private void a(BuildingSearchOption paramBuildingSearchOption)
  {
    if (paramBuildingSearchOption == null) {
      return;
    }
    Object localObject = paramBuildingSearchOption.getLatLng();
    if (localObject != null)
    {
      paramBuildingSearchOption = (BuildingSearchOption)localObject;
      if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
        paramBuildingSearchOption = CoordTrans.gcjToBaidu((LatLng)localObject);
      }
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBuildingSearchOption.latitude);
      localStringBuilder.append("");
      ((a)localObject).a("latitude", localStringBuilder.toString());
      localObject = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBuildingSearchOption.longitude);
      localStringBuilder.append("");
      ((a)localObject).a("longitude", localStringBuilder.toString());
    }
    this.c.a("coord_type", "bd09ll");
    this.c.a("from", "android_map_sdk");
    this.c.a("output", "json");
    this.c.a("data_set", "building");
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.e();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.building.c
 * JD-Core Version:    0.7.0.1
 */