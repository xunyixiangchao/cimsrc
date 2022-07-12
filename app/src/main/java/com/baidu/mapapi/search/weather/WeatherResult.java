package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

public class WeatherResult
  extends SearchResult
{
  public static final Parcelable.Creator<WeatherResult> CREATOR = new a();
  private WeatherSearchRealTime a;
  private WeatherSearchLocation b;
  private List<WeatherSearchForecasts> c;
  private List<WeatherSearchForecastForHours> d;
  private List<WeatherLifeIndexes> e;
  private List<WeatherSearchAlerts> f;
  
  public WeatherResult() {}
  
  protected WeatherResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((WeatherSearchRealTime)paramParcel.readParcelable(WeatherSearchRealTime.class.getClassLoader()));
    this.b = ((WeatherSearchLocation)paramParcel.readParcelable(WeatherSearchLocation.class.getClassLoader()));
    this.c = paramParcel.createTypedArrayList(WeatherSearchForecasts.CREATOR);
    this.d = paramParcel.createTypedArrayList(WeatherSearchForecastForHours.CREATOR);
    this.e = paramParcel.createTypedArrayList(WeatherLifeIndexes.CREATOR);
    this.f = paramParcel.createTypedArrayList(WeatherSearchAlerts.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<WeatherSearchForecastForHours> getForecastHours()
  {
    return this.d;
  }
  
  public List<WeatherSearchForecasts> getForecasts()
  {
    return this.c;
  }
  
  public List<WeatherLifeIndexes> getLifeIndexes()
  {
    return this.e;
  }
  
  public WeatherSearchLocation getLocation()
  {
    return this.b;
  }
  
  public WeatherSearchRealTime getRealTimeWeather()
  {
    return this.a;
  }
  
  public List<WeatherSearchAlerts> getWeatherAlerts()
  {
    return this.f;
  }
  
  public void setForecastHours(List<WeatherSearchForecastForHours> paramList)
  {
    this.d = paramList;
  }
  
  public void setForecasts(List<WeatherSearchForecasts> paramList)
  {
    this.c = paramList;
  }
  
  public void setLifeIndexes(List<WeatherLifeIndexes> paramList)
  {
    this.e = paramList;
  }
  
  public void setLocation(WeatherSearchLocation paramWeatherSearchLocation)
  {
    this.b = paramWeatherSearchLocation;
  }
  
  public void setRealTimeWeather(WeatherSearchRealTime paramWeatherSearchRealTime)
  {
    this.a = paramWeatherSearchRealTime;
  }
  
  public void setWeatherAlerts(List<WeatherSearchAlerts> paramList)
  {
    this.f = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeTypedList(this.c);
    paramParcel.writeTypedList(this.d);
    paramParcel.writeTypedList(this.e);
    paramParcel.writeTypedList(this.f);
  }
  
  class a
    implements Parcelable.Creator<WeatherResult>
  {
    public WeatherResult a(Parcel paramParcel)
    {
      return new WeatherResult(paramParcel);
    }
    
    public WeatherResult[] a(int paramInt)
    {
      return new WeatherResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.weather.WeatherResult
 * JD-Core Version:    0.7.0.1
 */