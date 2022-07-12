package com.baidu.platform.core.route;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.route.IndoorPlanNode;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.util.a;

public class f
  extends com.baidu.platform.base.c
{
  f(IndoorRoutePlanOption paramIndoorRoutePlanOption)
  {
    a(paramIndoorRoutePlanOption);
  }
  
  private void a(IndoorRoutePlanOption paramIndoorRoutePlanOption)
  {
    this.c.a("qt", "indoornavi");
    this.c.a("rp_format", "json");
    this.c.a("version", "1");
    Object localObject = CoordUtil.ll2mc(paramIndoorRoutePlanOption.mFrom.getLocation());
    StringBuilder localStringBuilder;
    if (localObject != null)
    {
      localObject = String.format("%f,%f", new Object[] { Double.valueOf(((GeoPoint)localObject).getLongitudeE6()), Double.valueOf(((GeoPoint)localObject).getLatitudeE6()) });
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("|");
      localStringBuilder.append(paramIndoorRoutePlanOption.mFrom.getFloor());
      localObject = localStringBuilder.toString().replaceAll(" ", "");
      this.c.a("sn", (String)localObject);
    }
    localObject = CoordUtil.ll2mc(paramIndoorRoutePlanOption.mTo.getLocation());
    if (localObject != null)
    {
      localObject = String.format("%f,%f", new Object[] { Double.valueOf(((GeoPoint)localObject).getLongitudeE6()), Double.valueOf(((GeoPoint)localObject).getLatitudeE6()) });
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("|");
      localStringBuilder.append(paramIndoorRoutePlanOption.mTo.getFloor());
      paramIndoorRoutePlanOption = localStringBuilder.toString().replaceAll(" ", "");
      this.c.a("en", paramIndoorRoutePlanOption);
    }
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.q();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.f
 * JD-Core Version:    0.7.0.1
 */