package com.baidu.mapapi.search.weather;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;

public class WeatherSearchOption
{
  private WeatherServerType a = WeatherServerType.WEATHER_SERVER_TYPE_DEFAULT;
  private String b;
  private LatLng c;
  private WeatherDataType d = WeatherDataType.WEATHER_DATA_TYPE_REAL_TIME;
  private LanguageType e = LanguageType.LanguageTypeChinese;
  
  public WeatherSearchOption districtID(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public WeatherDataType getDataType()
  {
    return this.d;
  }
  
  public String getDistrictID()
  {
    return this.b;
  }
  
  public LanguageType getLanguageType()
  {
    return this.e;
  }
  
  public LatLng getLocation()
  {
    return this.c;
  }
  
  public WeatherServerType getServerType()
  {
    return this.a;
  }
  
  public WeatherSearchOption languageType(LanguageType paramLanguageType)
  {
    this.e = paramLanguageType;
    return this;
  }
  
  public WeatherSearchOption location(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
  
  public WeatherSearchOption serverType(WeatherServerType paramWeatherServerType)
  {
    this.a = paramWeatherServerType;
    return this;
  }
  
  public WeatherSearchOption weatherDataType(WeatherDataType paramWeatherDataType)
  {
    this.d = paramWeatherDataType;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.weather.WeatherSearchOption
 * JD-Core Version:    0.7.0.1
 */