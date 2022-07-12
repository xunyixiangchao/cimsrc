package com.baidu.platform.core.weather;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.weather.WeatherDataType;
import com.baidu.mapapi.search.weather.WeatherSearchOption;
import com.baidu.mapapi.search.weather.WeatherServerType;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.util.a;

public class b
  extends com.baidu.platform.base.c
{
  WeatherSearchOption d;
  
  public b(WeatherSearchOption paramWeatherSearchOption)
  {
    this.d = paramWeatherSearchOption;
    a(paramWeatherSearchOption);
  }
  
  private String a(CoordType paramCoordType)
  {
    int i = a.b[paramCoordType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return "";
      }
      return "gcj02";
    }
    return "bd09ll";
  }
  
  private String a(LanguageType paramLanguageType)
  {
    int i = a.c[paramLanguageType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return "";
      }
      return "cn";
    }
    return "en";
  }
  
  private String a(WeatherDataType paramWeatherDataType)
  {
    switch (a.a[paramWeatherDataType.ordinal()])
    {
    default: 
      return "";
    case 6: 
      return "all";
    case 5: 
      return "alert";
    case 4: 
      return "index";
    case 3: 
      return "fc_hour";
    case 2: 
      return "fc";
    }
    return "now";
  }
  
  private void a(WeatherSearchOption paramWeatherSearchOption)
  {
    if (!TextUtils.isEmpty(paramWeatherSearchOption.getDistrictID())) {
      this.c.a("district_id", paramWeatherSearchOption.getDistrictID());
    }
    if (paramWeatherSearchOption.getLocation() != null)
    {
      Object localObject2 = new LatLng(paramWeatherSearchOption.getLocation().latitude, paramWeatherSearchOption.getLocation().longitude);
      Object localObject1 = localObject2;
      if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
        localObject1 = CoordTrans.gcjToBaidu((LatLng)localObject2);
      }
      localObject2 = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((LatLng)localObject1).longitude);
      localStringBuilder.append(",");
      localStringBuilder.append(((LatLng)localObject1).latitude);
      ((a)localObject2).a("location", localStringBuilder.toString());
      this.c.a("coordtype", a(CoordType.BD09LL));
    }
    if (paramWeatherSearchOption.getDataType() != null) {
      this.c.a("data_type", a(paramWeatherSearchOption.getDataType()));
    }
    if (paramWeatherSearchOption.getLanguageType() != null) {
      this.c.a("language", a(paramWeatherSearchOption.getLanguageType()));
    }
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    WeatherSearchOption localWeatherSearchOption = this.d;
    if (localWeatherSearchOption == null) {
      return "";
    }
    if (localWeatherSearchOption.getServerType() == WeatherServerType.LANGUAGE_SERVER_TYPE_ABROAD) {
      return paramc.g();
    }
    return paramc.k();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.weather.b
 * JD-Core Version:    0.7.0.1
 */