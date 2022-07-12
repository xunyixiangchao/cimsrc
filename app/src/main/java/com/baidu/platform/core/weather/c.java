package com.baidu.platform.core.weather;

import com.baidu.mapapi.search.weather.OnGetWeatherResultListener;
import com.baidu.mapapi.search.weather.WeatherSearchOption;
import com.baidu.platform.base.SearchType;
import java.util.concurrent.locks.Lock;

public class c
  extends com.baidu.platform.base.a
  implements IWeatherSearch
{
  private OnGetWeatherResultListener g;
  
  public void destroy()
  {
    this.c.lock();
    this.g = null;
    this.c.unlock();
  }
  
  public boolean searchWeather(WeatherSearchOption paramWeatherSearchOption)
  {
    a locala = new a();
    locala.a(SearchType.t);
    return a(new b(paramWeatherSearchOption), this.g, locala);
  }
  
  public void setOnGetWeatherSearchResultListener(OnGetWeatherResultListener paramOnGetWeatherResultListener)
  {
    this.c.lock();
    this.g = paramOnGetWeatherResultListener;
    this.c.unlock();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.weather.c
 * JD-Core Version:    0.7.0.1
 */