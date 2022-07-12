package com.baidu.platform.core.route;

import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.TransitRoutePlanOption.TransitPolicy;
import com.baidu.platform.util.a;

public class l
  extends com.baidu.platform.base.c
{
  public l(TransitRoutePlanOption paramTransitRoutePlanOption)
  {
    a(paramTransitRoutePlanOption);
  }
  
  private void a(TransitRoutePlanOption paramTransitRoutePlanOption)
  {
    this.c.a("qt", "bus");
    Object localObject = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTransitRoutePlanOption.mPolicy.getInt());
    localStringBuilder.append("");
    ((a)localObject).a("sy", localStringBuilder.toString());
    this.c.a("ie", "utf-8");
    this.c.a("lrn", "20");
    this.c.a("version", "3");
    this.c.a("rp_format", "json");
    this.c.a("rp_filter", "mobile");
    this.c.a("ic_info", "2");
    this.c.a("exptype", "depall");
    this.c.a("sn", a(paramTransitRoutePlanOption.mFrom));
    this.c.a("en", a(paramTransitRoutePlanOption.mTo));
    localObject = paramTransitRoutePlanOption.mCityName;
    if (localObject != null) {
      this.c.a("c", (String)localObject);
    }
    if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == paramTransitRoutePlanOption.mPolicy) {
      this.c.a("f", "[0,2,4,7,5,8,9,10,11]");
    }
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.v();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.l
 * JD-Core Version:    0.7.0.1
 */