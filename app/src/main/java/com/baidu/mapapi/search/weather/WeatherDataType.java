package com.baidu.mapapi.search.weather;

public enum WeatherDataType
{
  static
  {
    WeatherDataType localWeatherDataType1 = new WeatherDataType("WEATHER_DATA_TYPE_REAL_TIME", 0);
    WEATHER_DATA_TYPE_REAL_TIME = localWeatherDataType1;
    WeatherDataType localWeatherDataType2 = new WeatherDataType("WEATHER_DATA_TYPE_FORECASTS_FOR_DAY", 1);
    WEATHER_DATA_TYPE_FORECASTS_FOR_DAY = localWeatherDataType2;
    WeatherDataType localWeatherDataType3 = new WeatherDataType("WEATHER_DATA_TYPE_FORECASTS_FOR_HOUR", 2);
    WEATHER_DATA_TYPE_FORECASTS_FOR_HOUR = localWeatherDataType3;
    WeatherDataType localWeatherDataType4 = new WeatherDataType("WEATHER_DATA_TYPE_LIFE_INDEX", 3);
    WEATHER_DATA_TYPE_LIFE_INDEX = localWeatherDataType4;
    WeatherDataType localWeatherDataType5 = new WeatherDataType("WEATHER_DATA_TYPE_ALERT", 4);
    WEATHER_DATA_TYPE_ALERT = localWeatherDataType5;
    WeatherDataType localWeatherDataType6 = new WeatherDataType("WEATHER_DATA_TYPE_ALL", 5);
    WEATHER_DATA_TYPE_ALL = localWeatherDataType6;
    $VALUES = new WeatherDataType[] { localWeatherDataType1, localWeatherDataType2, localWeatherDataType3, localWeatherDataType4, localWeatherDataType5, localWeatherDataType6 };
  }
  
  private WeatherDataType() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.weather.WeatherDataType
 * JD-Core Version:    0.7.0.1
 */