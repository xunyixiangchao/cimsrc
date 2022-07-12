package com.baidu.platform.core.weather;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.weather.OnGetWeatherResultListener;
import com.baidu.mapapi.search.weather.WeatherLifeIndexes;
import com.baidu.mapapi.search.weather.WeatherResult;
import com.baidu.mapapi.search.weather.WeatherSearchAlerts;
import com.baidu.mapapi.search.weather.WeatherSearchForecastForHours;
import com.baidu.mapapi.search.weather.WeatherSearchForecasts;
import com.baidu.mapapi.search.weather.WeatherSearchLocation;
import com.baidu.mapapi.search.weather.WeatherSearchRealTime;
import com.baidu.platform.base.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends b
{
  private void a(WeatherSearchLocation paramWeatherSearchLocation, JSONObject paramJSONObject)
  {
    paramWeatherSearchLocation.setCountry(paramJSONObject.optString("country"));
    paramWeatherSearchLocation.setProvince(paramJSONObject.optString("province"));
    paramWeatherSearchLocation.setCity(paramJSONObject.optString("city"));
    paramWeatherSearchLocation.setDistrictName(paramJSONObject.optString("name"));
    paramWeatherSearchLocation.setDistrictID(paramJSONObject.optString("id"));
  }
  
  private void a(WeatherSearchRealTime paramWeatherSearchRealTime, JSONObject paramJSONObject)
  {
    paramWeatherSearchRealTime.setPhenomenon(paramJSONObject.optString("text"));
    paramWeatherSearchRealTime.setTemperature(paramJSONObject.optInt("temp"));
    paramWeatherSearchRealTime.setSensoryTemp(paramJSONObject.optInt("feels_like"));
    paramWeatherSearchRealTime.setRelativeHumidity(paramJSONObject.optInt("rh"));
    paramWeatherSearchRealTime.setWindPower(paramJSONObject.optString("wind_class"));
    paramWeatherSearchRealTime.setWindDirection(paramJSONObject.optString("wind_dir"));
    paramWeatherSearchRealTime.setUpdateTime(paramJSONObject.optString("uptime"));
    paramWeatherSearchRealTime.setCO((float)paramJSONObject.optDouble("co"));
    paramWeatherSearchRealTime.setNO2(paramJSONObject.optInt("no2"));
    paramWeatherSearchRealTime.setPM10(paramJSONObject.optInt("pm10"));
    paramWeatherSearchRealTime.setPM2_5(paramJSONObject.optInt("pm25"));
    paramWeatherSearchRealTime.setClouds(paramJSONObject.optInt("clouds"));
    paramWeatherSearchRealTime.setAirQualityIndex(paramJSONObject.optInt("aqi"));
    paramWeatherSearchRealTime.setSO2(paramJSONObject.optInt("so2"));
    paramWeatherSearchRealTime.setVisibility(paramJSONObject.optInt("vis"));
    paramWeatherSearchRealTime.setO3(paramJSONObject.optInt("o3"));
    paramWeatherSearchRealTime.setHourlyPrecipitation(paramJSONObject.optInt("prec_1h"));
  }
  
  private boolean a(JSONObject paramJSONObject, WeatherResult paramWeatherResult)
  {
    int i = 0;
    if (paramJSONObject != null)
    {
      if (paramWeatherResult == null) {
        return false;
      }
      JSONArray localJSONArray = paramJSONObject.optJSONArray("alerts");
      if (localJSONArray == null) {
        return false;
      }
      if (paramWeatherResult.getWeatherAlerts() == null) {
        paramWeatherResult.setWeatherAlerts(new ArrayList());
      }
      paramJSONObject = null;
      while (i < localJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          paramJSONObject = localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        if (paramJSONObject != null)
        {
          WeatherSearchAlerts localWeatherSearchAlerts = new WeatherSearchAlerts();
          localWeatherSearchAlerts.setDesc(paramJSONObject.optString("desc"));
          localWeatherSearchAlerts.setLevel(paramJSONObject.optString("level"));
          localWeatherSearchAlerts.setTitle(paramJSONObject.optString("title"));
          localWeatherSearchAlerts.setType(paramJSONObject.optString("type"));
          paramWeatherResult.getWeatherAlerts().add(localWeatherSearchAlerts);
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private boolean b(JSONObject paramJSONObject, WeatherResult paramWeatherResult)
  {
    int i = 0;
    if (paramJSONObject != null)
    {
      if (paramWeatherResult == null) {
        return false;
      }
      JSONArray localJSONArray = paramJSONObject.optJSONArray("forecast_hours");
      if (localJSONArray == null) {
        return false;
      }
      if (paramWeatherResult.getForecastHours() == null) {
        paramWeatherResult.setForecastHours(new ArrayList());
      }
      paramJSONObject = null;
      while (i < localJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          paramJSONObject = localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        if (paramJSONObject != null)
        {
          WeatherSearchForecastForHours localWeatherSearchForecastForHours = new WeatherSearchForecastForHours();
          localWeatherSearchForecastForHours.setClouds(paramJSONObject.optInt("clouds"));
          localWeatherSearchForecastForHours.setDataTime(paramJSONObject.optString("data_time"));
          localWeatherSearchForecastForHours.setHourlyPrecipitation(paramJSONObject.optInt("prec_1h"));
          localWeatherSearchForecastForHours.setRelativeHumidity(paramJSONObject.optInt("rh"));
          localWeatherSearchForecastForHours.setTemperature(paramJSONObject.optInt("temp_fc"));
          localWeatherSearchForecastForHours.setPhenomenon(paramJSONObject.optString("text"));
          localWeatherSearchForecastForHours.setWindDirection(paramJSONObject.optString("wind_dir"));
          localWeatherSearchForecastForHours.setWindPower(paramJSONObject.optString("wind_class"));
          paramWeatherResult.getForecastHours().add(localWeatherSearchForecastForHours);
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private boolean c(JSONObject paramJSONObject, WeatherResult paramWeatherResult)
  {
    int i = 0;
    if (paramJSONObject != null)
    {
      if (paramWeatherResult == null) {
        return false;
      }
      JSONArray localJSONArray = paramJSONObject.optJSONArray("forecasts");
      if (localJSONArray == null) {
        return false;
      }
      if (paramWeatherResult.getForecasts() == null) {
        paramWeatherResult.setForecasts(new ArrayList());
      }
      paramJSONObject = null;
      while (i < localJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          try
          {
            new WeatherSearchForecasts();
            paramJSONObject = localJSONObject;
          }
          catch (JSONException localJSONException2)
          {
            paramJSONObject = localJSONObject;
          }
          JSONException localJSONException3;
          localJSONException3.printStackTrace();
        }
        catch (JSONException localJSONException1)
        {
          localJSONException3 = localJSONException1;
        }
        if (paramJSONObject != null)
        {
          WeatherSearchForecasts localWeatherSearchForecasts = new WeatherSearchForecasts();
          localWeatherSearchForecasts.setDate(paramJSONObject.optString("date"));
          localWeatherSearchForecasts.setHighestTemp(paramJSONObject.optInt("high"));
          localWeatherSearchForecasts.setLowestTemp(paramJSONObject.optInt("low"));
          localWeatherSearchForecasts.setPhenomenonDay(paramJSONObject.optString("text_day"));
          localWeatherSearchForecasts.setPhenomenonNight(paramJSONObject.optString("text_night"));
          localWeatherSearchForecasts.setWeek(paramJSONObject.optString("week"));
          localWeatherSearchForecasts.setWindDirectionDay(paramJSONObject.optString("wd_day"));
          localWeatherSearchForecasts.setWindPowerDay(paramJSONObject.optString("wc_day"));
          localWeatherSearchForecasts.setWindDirectionNight(paramJSONObject.optString("wd_night"));
          localWeatherSearchForecasts.setWindPowerNight(paramJSONObject.optString("wc_night"));
          localWeatherSearchForecasts.setAirQualityIndex(paramJSONObject.optInt("aqi"));
          paramWeatherResult.getForecasts().add(localWeatherSearchForecasts);
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private boolean d(JSONObject paramJSONObject, WeatherResult paramWeatherResult)
  {
    int i = 0;
    if (paramJSONObject != null)
    {
      if (paramWeatherResult == null) {
        return false;
      }
      JSONArray localJSONArray = paramJSONObject.optJSONArray("indexes");
      if (localJSONArray == null) {
        return false;
      }
      if (paramWeatherResult.getLifeIndexes() == null) {
        paramWeatherResult.setLifeIndexes(new ArrayList());
      }
      paramJSONObject = null;
      while (i < localJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          paramJSONObject = localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        if (paramJSONObject != null)
        {
          WeatherLifeIndexes localWeatherLifeIndexes = new WeatherLifeIndexes();
          localWeatherLifeIndexes.setBrief(paramJSONObject.optString("brief"));
          localWeatherLifeIndexes.setDetail(paramJSONObject.optString("detail"));
          localWeatherLifeIndexes.setName(paramJSONObject.optString("name"));
          paramWeatherResult.getLifeIndexes().add(localWeatherLifeIndexes);
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private boolean e(JSONObject paramJSONObject, WeatherResult paramWeatherResult)
  {
    if (paramJSONObject != null)
    {
      if (paramWeatherResult == null) {
        return false;
      }
      paramJSONObject = paramJSONObject.optJSONObject("location");
      if (paramJSONObject == null) {
        return false;
      }
      if (paramWeatherResult.getLocation() == null)
      {
        WeatherSearchLocation localWeatherSearchLocation = new WeatherSearchLocation();
        a(localWeatherSearchLocation, paramJSONObject);
        paramWeatherResult.setLocation(localWeatherSearchLocation);
      }
      else
      {
        a(paramWeatherResult.getLocation(), paramJSONObject);
      }
      return true;
    }
    return false;
  }
  
  private boolean f(JSONObject paramJSONObject, WeatherResult paramWeatherResult)
  {
    if (paramJSONObject != null)
    {
      if (paramWeatherResult == null) {
        return false;
      }
      paramJSONObject = paramJSONObject.optJSONObject("now");
      if (paramJSONObject == null) {
        return false;
      }
      if (paramWeatherResult.getRealTimeWeather() == null)
      {
        WeatherSearchRealTime localWeatherSearchRealTime = new WeatherSearchRealTime();
        a(localWeatherSearchRealTime, paramJSONObject);
        paramWeatherResult.setRealTimeWeather(localWeatherSearchRealTime);
      }
      else
      {
        a(paramWeatherResult.getRealTimeWeather(), paramJSONObject);
      }
      return true;
    }
    return false;
  }
  
  private boolean g(JSONObject paramJSONObject, WeatherResult paramWeatherResult)
  {
    paramWeatherResult.status = paramJSONObject.optInt("status");
    paramJSONObject = paramJSONObject.optJSONObject("result");
    if (paramJSONObject == null) {
      return false;
    }
    e(paramJSONObject, paramWeatherResult);
    f(paramJSONObject, paramWeatherResult);
    a(paramJSONObject, paramWeatherResult);
    b(paramJSONObject, paramWeatherResult);
    c(paramJSONObject, paramWeatherResult);
    d(paramJSONObject, paramWeatherResult);
    return true;
  }
  
  public SearchResult a(String paramString)
  {
    WeatherResult localWeatherResult = new WeatherResult();
    if (paramString == null) {}
    Object localObject;
    JSONObject localJSONObject2;
    for (paramString = SearchResult.ERRORNO.RESULT_NOT_FOUND;; paramString = SearchResult.ERRORNO.PERMISSION_UNFINISHED)
    {
      localWeatherResult.error = paramString;
      return localWeatherResult;
      localObject = null;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        localObject = localJSONObject1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if ((localObject == null) || (localObject.length() == 0)) {
        break;
      }
      if (!localObject.has("SDK_InnerError")) {
        break label166;
      }
      localJSONObject2 = localObject.optJSONObject("SDK_InnerError");
      if (!localJSONObject2.has("PermissionCheckError")) {
        break label96;
      }
    }
    label96:
    if (localJSONObject2.has("httpStateError"))
    {
      paramString = localJSONObject2.optString("httpStateError");
      paramString.hashCode();
      if (!paramString.equals("NETWORK_ERROR"))
      {
        if (!paramString.equals("REQUEST_ERROR")) {
          paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
        } else {
          paramString = SearchResult.ERRORNO.REQUEST_ERROR;
        }
      }
      else {
        paramString = SearchResult.ERRORNO.NETWORK_ERROR;
      }
      localWeatherResult.error = paramString;
      return localWeatherResult;
    }
    label166:
    if (!a(paramString, localWeatherResult, true)) {
      g(localObject, localWeatherResult);
    }
    return localWeatherResult;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetWeatherResultListener)) {
        return;
      }
      ((OnGetWeatherResultListener)paramObject).onGetWeatherResultListener((WeatherResult)paramSearchResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.weather.a
 * JD-Core Version:    0.7.0.1
 */