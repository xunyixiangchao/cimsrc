package com.baidu.platform.core.recommendstop;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.util.a;

public class c
  extends com.baidu.platform.base.c
{
  public c(RecommendStopSearchOption paramRecommendStopSearchOption)
  {
    a(paramRecommendStopSearchOption);
  }
  
  private void a(RecommendStopSearchOption paramRecommendStopSearchOption)
  {
    if ((paramRecommendStopSearchOption != null) && (paramRecommendStopSearchOption.mLocation != null))
    {
      Object localObject = new LatLng(paramRecommendStopSearchOption.getLocation().latitude, paramRecommendStopSearchOption.getLocation().longitude);
      paramRecommendStopSearchOption = (RecommendStopSearchOption)localObject;
      if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
        paramRecommendStopSearchOption = CoordTrans.gcjToBaidu((LatLng)localObject);
      }
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRecommendStopSearchOption.longitude);
      localStringBuilder.append(",");
      localStringBuilder.append(paramRecommendStopSearchOption.latitude);
      ((a)localObject).a("location", localStringBuilder.toString());
    }
    this.c.a("coordtype", "bd09ll");
    this.c.a("from", "android_map_sdk");
    this.c.a("output", "json");
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.d();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.recommendstop.c
 * JD-Core Version:    0.7.0.1
 */