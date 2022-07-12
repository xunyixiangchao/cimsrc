package com.baidu.mapapi.search.weather;

public enum WeatherServerType
{
  static
  {
    WeatherServerType localWeatherServerType1 = new WeatherServerType("WEATHER_SERVER_TYPE_DEFAULT", 0);
    WEATHER_SERVER_TYPE_DEFAULT = localWeatherServerType1;
    WeatherServerType localWeatherServerType2 = new WeatherServerType("LANGUAGE_SERVER_TYPE_ABROAD", 1);
    LANGUAGE_SERVER_TYPE_ABROAD = localWeatherServerType2;
    $VALUES = new WeatherServerType[] { localWeatherServerType1, localWeatherServerType2 };
  }
  
  private WeatherServerType() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.weather.WeatherServerType
 * JD-Core Version:    0.7.0.1
 */