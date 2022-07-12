package com.baidu.platform.core.sug;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.util.a;

public class c
  extends com.baidu.platform.base.c
{
  public c(SuggestionSearchOption paramSuggestionSearchOption)
  {
    a(paramSuggestionSearchOption);
  }
  
  private void a(SuggestionSearchOption paramSuggestionSearchOption)
  {
    this.c.a("query", paramSuggestionSearchOption.mKeyword);
    this.c.a("region", paramSuggestionSearchOption.mCity);
    Object localObject1 = paramSuggestionSearchOption.mLocation;
    if (localObject1 != null)
    {
      Object localObject2 = new LatLng(((LatLng)localObject1).latitude, ((LatLng)localObject1).longitude);
      localObject1 = localObject2;
      if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
        localObject1 = CoordTrans.gcjToBaidu((LatLng)localObject2);
      }
      localObject2 = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((LatLng)localObject1).latitude);
      localStringBuilder.append(",");
      localStringBuilder.append(((LatLng)localObject1).longitude);
      ((a)localObject2).a("location", localStringBuilder.toString());
    }
    if (paramSuggestionSearchOption.mCityLimit.booleanValue())
    {
      localObject1 = this.c;
      paramSuggestionSearchOption = "true";
    }
    else
    {
      localObject1 = this.c;
      paramSuggestionSearchOption = "false";
    }
    ((a)localObject1).a("city_limit", paramSuggestionSearchOption);
    this.c.a("from", "android_map_sdk");
    this.c.a("output", "json");
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.l();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.sug.c
 * JD-Core Version:    0.7.0.1
 */