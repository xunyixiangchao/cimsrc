package com.baidu.mapapi.search.weather;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.a;
import com.baidu.platform.core.weather.IWeatherSearch;
import com.baidu.platform.core.weather.c;

public class WeatherSearch
  extends a
{
  IWeatherSearch a = new c();
  
  public static WeatherSearch newInstance()
  {
    BMapManager.init();
    return new WeatherSearch();
  }
  
  public void destroy()
  {
    IWeatherSearch localIWeatherSearch = this.a;
    if (localIWeatherSearch != null) {
      localIWeatherSearch.destroy();
    }
    BMapManager.destroy();
  }
  
  public boolean request(WeatherSearchOption paramWeatherSearchOption)
  {
    IWeatherSearch localIWeatherSearch = this.a;
    if (localIWeatherSearch != null)
    {
      if (paramWeatherSearchOption != null) {
        return localIWeatherSearch.searchWeather(paramWeatherSearchOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
  }
  
  public void setWeatherSearchResultListener(OnGetWeatherResultListener paramOnGetWeatherResultListener)
  {
    IWeatherSearch localIWeatherSearch = this.a;
    if (localIWeatherSearch != null)
    {
      if (paramOnGetWeatherResultListener != null)
      {
        localIWeatherSearch.setOnGetWeatherSearchResultListener(paramOnGetWeatherResultListener);
        return;
      }
      throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.weather.WeatherSearch
 * JD-Core Version:    0.7.0.1
 */