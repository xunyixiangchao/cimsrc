package com.baidu.platform.core.poi;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiFilter;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.util.a;

public class g
  extends com.baidu.platform.base.c
{
  g(PoiBoundSearchOption paramPoiBoundSearchOption)
  {
    a(paramPoiBoundSearchOption);
  }
  
  g(PoiCitySearchOption paramPoiCitySearchOption)
  {
    a(paramPoiCitySearchOption);
  }
  
  g(PoiNearbySearchOption paramPoiNearbySearchOption)
  {
    a(paramPoiNearbySearchOption);
  }
  
  private void a(PoiBoundSearchOption paramPoiBoundSearchOption)
  {
    if (paramPoiBoundSearchOption == null) {
      return;
    }
    this.c.a("query", paramPoiBoundSearchOption.mKeyword);
    if (paramPoiBoundSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
      this.c.a("language", "en");
    }
    this.c.a("tag", paramPoiBoundSearchOption.mTag);
    Object localObject1 = paramPoiBoundSearchOption.mBound;
    if (localObject1 != null)
    {
      localObject2 = ((LatLngBounds)localObject1).southwest;
      if ((localObject2 != null) && (((LatLngBounds)localObject1).northeast != null))
      {
        Object localObject3 = new LatLng(((LatLng)localObject2).latitude, ((LatLng)localObject2).longitude);
        localObject1 = paramPoiBoundSearchOption.mBound.northeast;
        Object localObject4 = new LatLng(((LatLng)localObject1).latitude, ((LatLng)localObject1).longitude);
        localObject2 = localObject3;
        localObject1 = localObject4;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02)
        {
          localObject2 = CoordTrans.gcjToBaidu((LatLng)localObject3);
          localObject1 = CoordTrans.gcjToBaidu((LatLng)localObject4);
        }
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject3 = this.c;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(((LatLng)localObject2).latitude);
          ((StringBuilder)localObject4).append(",");
          ((StringBuilder)localObject4).append(((LatLng)localObject2).longitude);
          ((StringBuilder)localObject4).append(",");
          ((StringBuilder)localObject4).append(((LatLng)localObject1).latitude);
          ((StringBuilder)localObject4).append(",");
          ((StringBuilder)localObject4).append(((LatLng)localObject1).longitude);
          ((a)localObject3).a("bounds", ((StringBuilder)localObject4).toString());
        }
      }
    }
    this.c.a("output", "json");
    localObject1 = this.c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPoiBoundSearchOption.mScope);
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("scope", ((StringBuilder)localObject2).toString());
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPoiBoundSearchOption.mPageNum);
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("page_num", ((StringBuilder)localObject2).toString());
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPoiBoundSearchOption.mPageCapacity);
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("page_size", ((StringBuilder)localObject2).toString());
    if (paramPoiBoundSearchOption.mScope == 2)
    {
      localObject1 = paramPoiBoundSearchOption.mPoiFilter;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((PoiFilter)localObject1).toString()))) {
        this.c.a("filter", paramPoiBoundSearchOption.mPoiFilter.toString());
      }
    }
  }
  
  private void a(PoiCitySearchOption paramPoiCitySearchOption)
  {
    if (paramPoiCitySearchOption == null) {
      return;
    }
    this.c.a("query", paramPoiCitySearchOption.mKeyword);
    if (paramPoiCitySearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
      this.c.a("language", "en");
    }
    this.c.a("region", paramPoiCitySearchOption.mCity);
    this.c.a("output", "json");
    Object localObject1 = this.c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPoiCitySearchOption.mPageNum);
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("page_num", ((StringBuilder)localObject2).toString());
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPoiCitySearchOption.mPageCapacity);
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("page_size", ((StringBuilder)localObject2).toString());
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPoiCitySearchOption.mScope);
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("scope", ((StringBuilder)localObject2).toString());
    this.c.a("tag", paramPoiCitySearchOption.mTag);
    if (paramPoiCitySearchOption.mIsCityLimit)
    {
      localObject1 = this.c;
      localObject2 = "true";
    }
    else
    {
      localObject1 = this.c;
      localObject2 = "false";
    }
    ((a)localObject1).a("city_limit", (String)localObject2);
    if (paramPoiCitySearchOption.mScope == 2)
    {
      localObject1 = paramPoiCitySearchOption.mPoiFilter;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((PoiFilter)localObject1).toString()))) {
        this.c.a("filter", paramPoiCitySearchOption.mPoiFilter.toString());
      }
    }
  }
  
  private void a(PoiNearbySearchOption paramPoiNearbySearchOption)
  {
    if (paramPoiNearbySearchOption == null) {
      return;
    }
    this.c.a("query", paramPoiNearbySearchOption.mKeyword);
    if (paramPoiNearbySearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
      this.c.a("language", "en");
    }
    Object localObject1 = paramPoiNearbySearchOption.mLocation;
    if (localObject1 != null)
    {
      localObject2 = new LatLng(((LatLng)localObject1).latitude, ((LatLng)localObject1).longitude);
      localObject1 = localObject2;
      if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
        localObject1 = CoordTrans.gcjToBaidu((LatLng)localObject2);
      }
      if (localObject1 != null)
      {
        localObject2 = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((LatLng)localObject1).latitude);
        localStringBuilder.append(",");
        localStringBuilder.append(((LatLng)localObject1).longitude);
        ((a)localObject2).a("location", localStringBuilder.toString());
      }
    }
    localObject1 = this.c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPoiNearbySearchOption.mRadius);
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("radius", ((StringBuilder)localObject2).toString());
    this.c.a("output", "json");
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPoiNearbySearchOption.mPageNum);
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("page_num", ((StringBuilder)localObject2).toString());
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPoiNearbySearchOption.mPageCapacity);
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("page_size", ((StringBuilder)localObject2).toString());
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPoiNearbySearchOption.mScope);
    ((StringBuilder)localObject2).append("");
    ((a)localObject1).a("scope", ((StringBuilder)localObject2).toString());
    this.c.a("tag", paramPoiNearbySearchOption.mTag);
    if (paramPoiNearbySearchOption.mRadiusLimit)
    {
      localObject1 = this.c;
      localObject2 = "true";
    }
    else
    {
      localObject1 = this.c;
      localObject2 = "false";
    }
    ((a)localObject1).a("radius_limit", (String)localObject2);
    if (paramPoiNearbySearchOption.mScope == 2)
    {
      localObject1 = paramPoiNearbySearchOption.mPoiFilter;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((PoiFilter)localObject1).toString()))) {
        this.c.a("filter", paramPoiNearbySearchOption.mPoiFilter.toString());
      }
    }
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.t();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.poi.g
 * JD-Core Version:    0.7.0.1
 */