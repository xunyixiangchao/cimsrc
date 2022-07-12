package com.baidu.platform.core.weather;

import com.baidu.mapapi.search.weather.OnGetWeatherResultListener;
import com.baidu.mapapi.search.weather.WeatherSearchOption;

public abstract interface IWeatherSearch
{
  public abstract void destroy();
  
  public abstract boolean searchWeather(WeatherSearchOption paramWeatherSearchOption);
  
  public abstract void setOnGetWeatherSearchResultListener(OnGetWeatherResultListener paramOnGetWeatherResultListener);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.weather.IWeatherSearch
 * JD-Core Version:    0.7.0.1
 */