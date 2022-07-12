package com.baidu.platform.core.geocode;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.util.a;

public class e
  extends com.baidu.platform.base.c
{
  public e(ReverseGeoCodeOption paramReverseGeoCodeOption)
  {
    a(paramReverseGeoCodeOption);
  }
  
  private void a(ReverseGeoCodeOption paramReverseGeoCodeOption)
  {
    if (paramReverseGeoCodeOption.getLocation() != null)
    {
      localObject2 = new LatLng(paramReverseGeoCodeOption.getLocation().latitude, paramReverseGeoCodeOption.getLocation().longitude);
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
    if (paramReverseGeoCodeOption.getLanguage() == LanguageType.LanguageTypeEnglish) {
      this.c.a("language", "en");
    }
    this.c.a("coordtype", "bd09ll");
    this.c.a("page_index", String.valueOf(paramReverseGeoCodeOption.getPageNum()));
    this.c.a("page_size", String.valueOf(paramReverseGeoCodeOption.getPageSize()));
    this.c.a("pois", "1");
    this.c.a("extensions_poi", "1");
    Object localObject1 = this.c;
    Object localObject2 = "true";
    ((a)localObject1).a("extensions_town", "true");
    if (paramReverseGeoCodeOption.getExtensionsRoad())
    {
      localObject1 = this.c;
    }
    else
    {
      localObject1 = this.c;
      localObject2 = "false";
    }
    ((a)localObject1).a("extensions_road", (String)localObject2);
    localObject1 = paramReverseGeoCodeOption.getPoiType();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.c.a("poi_types", (String)localObject1);
    }
    this.c.a("output", "jsonaes");
    this.c.a("from", "android_map_sdk");
    this.c.a("latest_admin", String.valueOf(paramReverseGeoCodeOption.getLatestAdmin()));
    this.c.a("radius", String.valueOf(paramReverseGeoCodeOption.getRadius()));
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.s();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.geocode.e
 * JD-Core Version:    0.7.0.1
 */